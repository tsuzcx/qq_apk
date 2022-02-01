package mqq.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManagerFactoryImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory.Builder;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qroute.remote.RemoteProxyUtil;
import com.tencent.mobileqq.qroute.utils.ProcessChecker;
import com.tencent.mobileqq.qroute.utils.QRouteUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DBBuildUtil;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.api.IRuntimeService;
import mqq.app.remote.ServiceRemoteProxy;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.observer.BusinessObserver;
import mqq.observer.SSOAccountObserver;
import mqq.observer.SubAccountObserver;
import mqq.util.WeakReference;

public abstract class AppRuntime
{
  public static final int ACCOUNT_MANAGER = 0;
  public static final int END_UN_LOGIN_MANAGER = 8;
  public static final int LOGIN_AUTO = 2;
  public static final int LOGIN_MANUAL = 1;
  public static final int LOGIN_UNINIT = 0;
  public static final String PROCESS = "process";
  public static final int PROXY_IP_MANAGER = 3;
  public static final int PUSH_MANAGER = 5;
  protected static final int SECURE_FILE_FRAMEWORK_MANAGER = 8;
  public static final int SERVER_CONFIG_MANAGER = 4;
  protected static final String TAG = "mqq";
  public static final int TICKET_MANAGER = 2;
  public static final int TYPE_CREATENEWRUNTIME_CHANGUIN_LOGIN = 4;
  public static final int TYPE_CREATENEWRUNTIME_DIRECT_LOGIN = 1;
  public static final int TYPE_CREATENEWRUNTIME_DIRECT_NET_LOGIN = 3;
  public static final int TYPE_CREATENEWRUNTIME_DOINIT = 5;
  public static final int TYPE_CREATENEWRUNTIME_SWITCHACCOUNT = 2;
  public static final int VERIFYCODE_MANAGER = 6;
  public static final int VERIFYDEVLOCK_MANAGER = 7;
  public static final int WTLOGIN_MANAGER = 1;
  @ConfigInject(configPath="Mqq/resources/Inject_MqqCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends ManagerFactory>> sProxyManagerFactory = new ArrayList();
  private ConcurrentHashMap<String, String> businessRootFilePaths = new ConcurrentHashMap();
  private BaseCacheManager cacheManager;
  private CountDownLatch countDownLatch;
  public boolean isBackgroundPause = false;
  public boolean isBackgroundStop = false;
  public boolean isClearTaskBySystem = false;
  protected boolean isLogin;
  private boolean isRunning;
  private long lUin = -1L;
  private SimpleAccount mAccount;
  private MobileQQ mContext;
  private Intent mDevLockIntent = null;
  private EntityManagerFactory mEntityManagerFactory;
  private Intent mKickIntent = null;
  protected String mProcessName;
  private final ThreadLocal<ArrayList<String>> mRuntimeServiceCycleCheck = new ThreadLocal();
  private MainService mService;
  private final ServletContainer mServletContainer = new ServletContainer(this);
  private IAppStateChangeListener mStateChangeListener;
  private String mTempPath;
  ToolProcReceiver mToolReceiver;
  private SparseArray<Manager> managers = new SparseArray();
  Bundle modularSaveInstance;
  private final List<Reference<BusinessObserver>> observers = new Vector();
  public AppRuntime parentRuntime = null;
  private BaseProxyManager proxyManager;
  private ConcurrentHashMap<Class<?>, IRuntimeService> runtimeServices = new ConcurrentHashMap(512);
  private ConcurrentHashMap<Class<?>, Object> serviceLocks = new ConcurrentHashMap();
  ConcurrentHashMap<String, AppRuntime> subRuntimeMap = new ConcurrentHashMap();
  byte[] uinSign = null;
  
  static
  {
    sProxyManagerFactory.add(ProxyManagerFactoryImpl.class);
  }
  
  @Nullable
  private String callMainProcessForSecurityFileResult(@Nullable ISecurityFileHelper paramISecurityFileHelper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "callMainProcessForSecurityFileResult from= ", MobileQQ.processName });
    }
    this.mTempPath = null;
    Bundle localBundle = new Bundle();
    if (paramISecurityFileHelper != null) {
      localBundle.putString("BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME", paramISecurityFileHelper.getClass().getName());
    }
    paramISecurityFileHelper = QIPCClientHelper.getInstance().getClient().callServer("SecurityFileModule", "ACTION_GET_BUSINESS_ROOT_PATH", localBundle);
    if (paramISecurityFileHelper != null)
    {
      if (paramISecurityFileHelper.isSuccess())
      {
        this.mTempPath = paramISecurityFileHelper.data.getString("BUNDLE_KEY_RETURN_FILE_PATH");
        if (TextUtils.isEmpty(this.mTempPath)) {
          QLog.d("SecurityFileFrameworkManagerImpl", 1, "result success but path is empty");
        } else if (QLog.isColorLevel()) {
          QLog.d("SecurityFileFrameworkManagerImpl", 2, this.mTempPath);
        }
      }
      else
      {
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "result fail: code=", Integer.valueOf(paramISecurityFileHelper.code) });
        if ((paramISecurityFileHelper.e != null) && (QLog.isColorLevel())) {
          QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "result fail: e=", paramISecurityFileHelper.e.getMessage() });
        }
      }
    }
    else {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "result null ");
    }
    return this.mTempPath;
  }
  
  private boolean checkNeedAccount(Class<?> paramClass)
  {
    if (paramClass.isAnnotationPresent(Service.class))
    {
      paramClass = (Service)paramClass.getAnnotation(Service.class);
      if (paramClass != null) {
        return paramClass.needUin();
      }
    }
    return true;
  }
  
  private void cycleCheckBegin(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mRuntimeServiceCycleCheck.get() == null)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramString);
        this.mRuntimeServiceCycleCheck.set(localObject);
        return;
      }
      if (!((ArrayList)this.mRuntimeServiceCycleCheck.get()).contains(paramString))
      {
        ((ArrayList)this.mRuntimeServiceCycleCheck.get()).add(paramString);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("find cycle init from:");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      QLog.e("mqq", 2, paramString, new Throwable());
      this.mRuntimeServiceCycleCheck.remove();
      throw new IllegalStateException(paramString);
    }
  }
  
  private void cycleCheckEnd(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mRuntimeServiceCycleCheck.get() != null) && (!((ArrayList)this.mRuntimeServiceCycleCheck.get()).isEmpty()) && (paramString.compareTo((String)((ArrayList)this.mRuntimeServiceCycleCheck.get()).get(0)) == 0)) {
      this.mRuntimeServiceCycleCheck.remove();
    }
  }
  
  private EntityManagerFactory getEntityManagerFactoryInner(String paramString)
  {
    if (this.mEntityManagerFactory == null) {
      try
      {
        if (this.mEntityManagerFactory == null) {
          this.mEntityManagerFactory = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(paramString).build();
        }
      }
      finally {}
    }
    return this.mEntityManagerFactory;
  }
  
  @Nullable
  private <T extends IRuntimeService> T getInstance(Class<T> paramClass, String paramString)
  {
    runtimeServiceCheck(paramClass, false, true);
    ??? = (IRuntimeService)this.runtimeServices.get(paramClass);
    if (??? == null)
    {
      ??? = getAccount();
      if ((TextUtils.isEmpty((CharSequence)???)) && (checkNeedAccount(paramClass)))
      {
        paramString = new StringBuilder();
        paramString.append(paramClass.getName());
        paramString.append(" need uin ");
        paramString.append((String)???);
        paramString.append(" or should add @Service{needUin=false}");
        paramClass = paramString.toString();
        QLog.e("mqq", 2, paramClass);
        throw new IllegalStateException(paramClass);
      }
      if (this.serviceLocks.get(paramClass) == null) {
        synchronized (this.serviceLocks)
        {
          if (this.serviceLocks.get(paramClass) == null) {
            this.serviceLocks.put(paramClass, new Object());
          }
        }
      }
      synchronized (this.serviceLocks.get(paramClass))
      {
        Object localObject2 = (IRuntimeService)this.runtimeServices.get(paramClass);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = Class.forName(paramString);
        cycleCheckBegin(paramString, false);
        localObject2 = (IRuntimeService)((Class)localObject2).newInstance();
        if (localObject2 != null)
        {
          ((IRuntimeService)localObject2).onCreate(this);
          this.runtimeServices.put(paramClass, localObject2);
        }
        cycleCheckEnd(paramString, false);
        return localObject2;
      }
    }
    return ???;
  }
  
  private <T extends IRuntimeService> T getRuntimeServiceIPCSyncInner(Class<T> paramClass)
  {
    Object localObject1 = QRouteUtil.convertApiToImplClass(paramClass);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      runtimeServiceCheck(paramClass, false, false);
      try
      {
        Object localObject2 = ServiceRemoteProxy.getProxy(paramClass, Class.forName((String)localObject1));
        if ((localObject2 instanceof IRuntimeService)) {
          return (IRuntimeService)localObject2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getServiceRemoteProxy null, class=");
        ((StringBuilder)localObject2).append(paramClass);
        localObject2 = ((StringBuilder)localObject2).toString();
        QLog.e("mqq", 1, (String)localObject2);
        throw new IllegalStateException((String)localObject2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ClassNotFoundException error, class= ");
        localStringBuilder.append(paramClass.getName());
        localStringBuilder.append("target Class= ");
        localStringBuilder.append((String)localObject1);
        paramClass = localStringBuilder.toString();
        QLog.e("mqq", 1, paramClass);
        throw new IllegalStateException(paramClass, localClassNotFoundException);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("api or impl service name fatal! class=");
    ((StringBuilder)localObject1).append(paramClass.getName());
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  @androidx.annotation.NonNull
  private <T extends IRuntimeService> T getRuntimeServiceInner(@androidx.annotation.NonNull Class<T> paramClass)
  {
    Object localObject = QRouteUtil.convertApiToImplClass(paramClass);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = getInstance(paramClass, (String)localObject);
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("runtimeService is null, api:");
        ((StringBuilder)localObject).append(paramClass.getSimpleName());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("build AppRuntime service fatal api:");
        localStringBuilder2.append(paramClass.getSimpleName());
        paramClass = localStringBuilder2.toString();
        this.mRuntimeServiceCycleCheck.remove();
        QLog.e("mqq", 2, paramClass, localException);
        throw new IllegalStateException(paramClass, localException);
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("api or impl service name fatal! class=");
    localStringBuilder1.append(paramClass.getName());
    throw new IllegalStateException(localStringBuilder1.toString());
  }
  
  private <T extends IRuntimeService> void runtimeServiceCheck(Class<T> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramClass.isAnnotationPresent(Service.class))
      {
        if ((paramBoolean2) && (!ProcessChecker.check(paramClass, this.mProcessName, paramBoolean1)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("service: ");
          localStringBuilder.append(paramClass.getName());
          localStringBuilder.append(" can not run on this process: ");
          localStringBuilder.append(this.mProcessName);
          localStringBuilder.append("，请联系Service开发者沟通处理。\n");
          paramClass = localStringBuilder.toString();
          QLog.e("mqq", 2, paramClass);
          throw new IllegalStateException(paramClass);
        }
        RemoteProxyUtil.verifyClass(paramClass);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IRuntimeService should have Service Annotation, class=");
      localStringBuilder.append(paramClass.getName());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    synchronized (this.managers)
    {
      if (this.managers.indexOfKey(paramInt) < 0)
      {
        this.managers.put(paramInt, paramManager);
        return;
      }
      paramManager = new StringBuilder();
      paramManager.append("addManager duplicated name = ");
      paramManager.append(paramInt);
      throw new IllegalArgumentException(paramManager.toString());
    }
  }
  
  protected boolean canAutoLogin(String paramString)
  {
    Object localObject1 = this.parentRuntime;
    if (localObject1 != null) {
      ((AppRuntime)localObject1).canAutoLogin(paramString);
    }
    boolean bool = false;
    if ((paramString != null) && (paramString.length() != 0))
    {
      localObject1 = this.mContext.getSharedPreferences("sp_login_auto", 4);
      int j = ((SharedPreferences)localObject1).getInt(paramString, 0);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CNR getAutoLoginSharePre auto flag =");
        ((StringBuilder)localObject2).append(j);
        QLog.d("SharedPreUtils", 2, ((StringBuilder)localObject2).toString());
      }
      int i = j;
      if (j == 0)
      {
        localObject2 = this.mContext;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mContext.getPackageName());
        localStringBuilder.append("_preferences");
        ((MobileQQ)localObject2).getSharedPreferences(localStringBuilder.toString(), 4);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("login_auto");
        ((StringBuilder)localObject2).append(paramString);
        if (((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), true)) {
          i = 2;
        } else {
          i = 1;
        }
        ((SharedPreferences)localObject1).edit().putInt(paramString, i).commit();
      }
      if (i == 2) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("CNR getAutoLoginSharePre auto =");
        paramString.append(bool);
        QLog.d("SharedPreUtils", 2, paramString.toString());
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre uin is null");
    }
    return false;
  }
  
  public void cancelSyncOnlineFriend(long paramLong) {}
  
  public void exit(boolean paramBoolean) {}
  
  protected void exitToolProc()
  {
    onDestroy();
    Process.killProcess(Process.myPid());
  }
  
  public String getAccount()
  {
    Object localObject = this.parentRuntime;
    if (localObject != null) {
      return ((AppRuntime)localObject).getAccount();
    }
    localObject = this.mAccount;
    if (localObject == null) {
      return null;
    }
    return ((SimpleAccount)localObject).getUin();
  }
  
  public abstract BaseApplication getApp();
  
  public AppRuntime getAppRuntime(String paramString)
  {
    Object localObject = this.parentRuntime;
    if (localObject != null) {
      return ((AppRuntime)localObject).getAppRuntime(paramString);
    }
    localObject = null;
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (paramString.intern())
      {
        AppRuntime localAppRuntime = (AppRuntime)this.subRuntimeMap.get(paramString);
        localObject = localAppRuntime;
        if (localAppRuntime == null)
        {
          localAppRuntime = onGetSubRuntime(paramString);
          localObject = localAppRuntime;
          if (localAppRuntime != null)
          {
            localAppRuntime.setProxy(this);
            localAppRuntime.onCreate(this.modularSaveInstance);
            this.subRuntimeMap.put(paramString, localAppRuntime);
            localObject = localAppRuntime;
          }
        }
      }
    }
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = this;
    }
    return paramString;
  }
  
  public MobileQQ getApplication()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public Context getApplicationContext()
  {
    return MobileQQ.sMobileQQ.getApplicationContext();
  }
  
  public BaseCacheManager getCacheManagerInner()
  {
    if (this.cacheManager == null) {
      try
      {
        this.cacheManager = ((ManagerFactory)((Class)sProxyManagerFactory.get(0)).newInstance()).getCacheManager(this);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("mqq", 1, localThrowable, new Object[0]);
      }
    }
    return this.cacheManager;
  }
  
  public abstract String getCurrentAccountUin();
  
  public String getCurrentUin()
  {
    if (!"0".equals(getCurrentAccountUin())) {
      return getCurrentAccountUin();
    }
    return "";
  }
  
  public Intent getDevLockIntent()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      return localAppRuntime.getDevLockIntent();
    }
    return this.mDevLockIntent;
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return getEntityManagerFactoryInner(getAccount());
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return getEntityManagerFactoryInner(paramString);
  }
  
  public Intent getKickIntent()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      return localAppRuntime.getKickIntent();
    }
    return this.mKickIntent;
  }
  
  public long getLongAccountUin()
  {
    Object localObject = this.parentRuntime;
    if (localObject != null) {
      return ((AppRuntime)localObject).getLongAccountUin();
    }
    if (this.lUin < 0L) {}
    try
    {
      localObject = getAccount();
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.lUin = Long.parseLong(getAccount());
      }
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    return this.lUin;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = this.parentRuntime;
    if (localObject1 != null)
    {
      localObject1 = ((AppRuntime)localObject1).getManager(paramInt);
      if (localObject1 != null) {
        return localObject1;
      }
    }
    synchronized (this.managers)
    {
      localObject1 = (Manager)this.managers.get(paramInt);
      if (localObject1 != null) {
        return localObject1;
      }
      Object localObject3 = localObject1;
      if (this.parentRuntime == null)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt == 3) {
                localObject1 = new ProxyIpManagerImpl(this);
              }
            }
            else {
              localObject1 = new TicketManagerImpl(this);
            }
          }
          else {
            localObject1 = new WtloginManagerImpl(this);
          }
        }
        else {
          localObject1 = new AccountManagerImpl(this);
        }
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          addManager(paramInt, (Manager)localObject1);
          localObject3 = localObject1;
        }
      }
      return localObject3;
    }
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return null;
  }
  
  protected Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return null;
  }
  
  public String getModuleId()
  {
    return null;
  }
  
  public <T> T getMsgCache()
  {
    return null;
  }
  
  public final SharedPreferences getPreferences()
  {
    String str2 = getAccount();
    String str1 = str2;
    if (str2 == null) {
      str1 = "noLogin";
    }
    return getApplication().getSharedPreferences(str1, 4);
  }
  
  public BaseProxyManager getProxyManagerInner()
  {
    if (this.proxyManager == null) {
      try
      {
        this.proxyManager = ((ManagerFactory)((Class)sProxyManagerFactory.get(0)).newInstance()).getProxyManager(this);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("mqq", 1, localThrowable, new Object[0]);
      }
    }
    return this.proxyManager;
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = getSQLiteOpenHelper();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getReadableDatabase();
    }
    return null;
  }
  
  public SQLiteDatabase getReadableDatabase(String paramString)
  {
    paramString = getSQLiteOpenHelper(paramString);
    if (paramString != null) {
      return paramString.getReadableDatabase();
    }
    return null;
  }
  
  public ToServiceMsg getRegisterCmdCallMsg(Intent paramIntent)
  {
    CommandCallbackerInfo localCommandCallbackerInfo = new CommandCallbackerInfo();
    localCommandCallbackerInfo.uin = getAccount();
    paramIntent = paramIntent.getStringArrayExtra("pushCommands");
    ArrayList localArrayList = new ArrayList();
    int j = paramIntent.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramIntent[i]);
      i += 1;
    }
    localCommandCallbackerInfo.cmds = localArrayList;
    return getService().msfSub.getRegisterCmdCallMsg(localCommandCallbackerInfo);
  }
  
  public ToServiceMsg getRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    return getService().msfSub.getRegisterPushMsg(paramPushRegisterInfo);
  }
  
  public int getRunningModuleSize()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      return localAppRuntime.getRunningModuleSize();
    }
    return this.subRuntimeMap.size();
  }
  
  @androidx.annotation.NonNull
  public <T extends IRuntimeService> T getRuntimeService(@androidx.annotation.NonNull Class<T> paramClass, String paramString)
  {
    return getRuntimeServiceInner(paramClass);
  }
  
  @androidx.annotation.NonNull
  public <T extends IRuntimeService> T getRuntimeServiceIPCSync(@androidx.annotation.NonNull Class<T> paramClass, String paramString)
  {
    if ((paramString.compareTo("") == 0) || (TextUtils.isEmpty(this.mProcessName))) {
      getRuntimeService(paramClass, paramString);
    }
    return getRuntimeServiceIPCSyncInner(paramClass);
  }
  
  protected SQLiteOpenHelper getSQLiteOpenHelper()
  {
    if (!getCurrentAccountUin().equals("0")) {
      return getEntityManagerFactory().build(getCurrentAccountUin());
    }
    return null;
  }
  
  protected SQLiteOpenHelper getSQLiteOpenHelper(String paramString)
  {
    return getEntityManagerFactory(paramString).build(paramString);
  }
  
  @Nullable
  public File getSecurityBusinessRootFile(@android.support.annotation.NonNull ISecurityFileHelper paramISecurityFileHelper)
  {
    if (this.businessRootFilePaths.containsKey(paramISecurityFileHelper.declareBusinessFileName())) {
      return new File((String)this.businessRootFilePaths.get(paramISecurityFileHelper.declareBusinessFileName()));
    }
    if ("com.tencent.mobileqq".equals(MobileQQ.processName))
    {
      localObject = ((SecurityFileFrameworkManagerImpl)getManager(8)).getUINRootFile(paramISecurityFileHelper);
      if (localObject != null) {
        this.businessRootFilePaths.put(paramISecurityFileHelper.declareBusinessFileName(), ((File)localObject).getAbsolutePath());
      }
      return localObject;
    }
    Object localObject = callMainProcessForSecurityFileResult(paramISecurityFileHelper);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    this.businessRootFilePaths.put(paramISecurityFileHelper.declareBusinessFileName(), localObject);
    return new File((String)localObject);
  }
  
  @Nullable
  public File getSecurityUINRootFile()
  {
    if (this.businessRootFilePaths.containsKey("SecurityUINRootFile")) {
      return new File((String)this.businessRootFilePaths.get("SecurityUINRootFile"));
    }
    if ("com.tencent.mobileqq".equals(MobileQQ.processName))
    {
      localObject = ((SecurityFileFrameworkManagerImpl)getManager(8)).getUINRootFile(null);
      if (localObject != null) {
        this.businessRootFilePaths.put("SecurityUINRootFile", ((File)localObject).getAbsolutePath());
      }
      return localObject;
    }
    Object localObject = callMainProcessForSecurityFileResult(null);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    this.businessRootFilePaths.put("SecurityUINRootFile", localObject);
    return new File((String)localObject);
  }
  
  protected MainService getService()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      return localAppRuntime.getService();
    }
    return this.mService;
  }
  
  protected ServletContainer getServletContainer()
  {
    return this.mServletContainer;
  }
  
  public void getSubAccountKey(String paramString1, String paramString2, SubAccountObserver paramSubAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSubAccountObserver);
    localNewIntent.putExtra("subaccountuin", paramString2);
    localNewIntent.putExtra("mainaccount", paramString1);
    localNewIntent.putExtra("action", 1037);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public byte[] getUinSign()
  {
    Object localObject = this.parentRuntime;
    if (localObject != null) {
      return ((AppRuntime)localObject).getUinSign();
    }
    if (this.uinSign == null)
    {
      this.uinSign = new byte[32];
      localObject = this.mAccount;
      if (localObject != null) {
        try
        {
          localObject = ((SimpleAccount)localObject).getUin().toLowerCase().getBytes("utf-8");
          byte[] arrayOfByte1 = MD5.toMD5((byte[])localObject).toLowerCase().getBytes("utf-8");
          byte[] arrayOfByte2 = new byte[arrayOfByte1.length + localObject.length];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
          System.arraycopy(localObject, 0, arrayOfByte2, arrayOfByte1.length, localObject.length);
          this.uinSign = MD5.toMD5(arrayOfByte2).toLowerCase().getBytes("utf-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    return this.uinSign;
  }
  
  public ToServiceMsg getUnRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    return getService().msfSub.getUnRegisterPushMsg(paramPushRegisterInfo);
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = getSQLiteOpenHelper();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getWritableDatabase();
    }
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase(String paramString)
  {
    paramString = getSQLiteOpenHelper(paramString);
    if (paramString != null) {
      return paramString.getWritableDatabase();
    }
    return null;
  }
  
  void init(MobileQQ paramMobileQQ, MainService paramMainService, SimpleAccount paramSimpleAccount)
  {
    this.mService = paramMainService;
    this.mContext = paramMobileQQ;
    this.mAccount = paramSimpleAccount;
    this.lUin = -1L;
  }
  
  public boolean isLogin()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      return localAppRuntime.isLogin();
    }
    return this.isLogin;
  }
  
  public boolean isModuleRunning(String paramString)
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      return localAppRuntime.isModuleRunning(paramString);
    }
    return this.subRuntimeMap.containsKey(paramString);
  }
  
  public boolean isRunning()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      return localAppRuntime.isRunning();
    }
    return this.isRunning;
  }
  
  public void kick(AppRuntime.KickParams paramKickParams)
  {
    MainService localMainService = getService();
    if (localMainService != null) {
      localMainService.kick(paramKickParams);
    }
  }
  
  public void login(SimpleAccount paramSimpleAccount)
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null)
    {
      localAppRuntime.login(paramSimpleAccount);
      return;
    }
    runOnUiThread(new AppRuntime.1(this, paramSimpleAccount));
  }
  
  public void login(String paramString, byte[] paramArrayOfByte, AccountObserver paramAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramAccountObserver);
    localNewIntent.putExtra("account", paramString);
    localNewIntent.putExtra("password", paramArrayOfByte);
    localNewIntent.putExtra("action", 1001);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void login(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, AccountObserver paramAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramAccountObserver);
    localNewIntent.putExtra("account", paramString);
    localNewIntent.putExtra("password", paramArrayOfByte1);
    localNewIntent.putExtra("resp_register_supersig", paramArrayOfByte2);
    localNewIntent.putExtra("action", 1001);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void login(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, AccountObserver paramAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("to_login_uin_encrypt", paramArrayOfByte1);
    localNewIntent.putExtra("account", paramString);
    localNewIntent.putExtra("password", paramArrayOfByte2);
    localNewIntent.putExtra("action", 1001);
    localNewIntent.setObserver(paramAccountObserver);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void login(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString, byte[] paramArrayOfByte3, AccountObserver paramAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("to_login_uin_encrypt", paramArrayOfByte1);
    localNewIntent.putExtra("sigSession", paramArrayOfByte2);
    localNewIntent.putExtra("businessType", paramInt);
    localNewIntent.putExtra("account", paramString);
    localNewIntent.putExtra("password", paramArrayOfByte3);
    localNewIntent.putExtra("action", 1001);
    localNewIntent.setObserver(paramAccountObserver);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void loginSubAccount(String paramString1, String paramString2, String paramString3, SubAccountObserver paramSubAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSubAccountObserver);
    localNewIntent.putExtra("mainaccount", paramString1);
    localNewIntent.putExtra("subaccount", paramString2);
    localNewIntent.putExtra("subpassword", paramString3);
    localNewIntent.putExtra("action", 1035);
    getServletContainer().forward(this, localNewIntent);
  }
  
  protected void logout(Constants.LogoutReason paramLogoutReason, boolean paramBoolean)
  {
    if (isLogin())
    {
      if (paramBoolean) {
        sendOnlineStatus(AppRuntime.Status.offline, AppRuntime.Status.online, false, 0L, false);
      }
      userLogoutReleaseData();
      this.isLogin = false;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getAccount());
        localStringBuilder.append(" logout by ");
        localStringBuilder.append(paramLogoutReason);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramBoolean);
        QLog.w("mqq", 2, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(MsfSdkUtils.getShortUin(getAccount()));
        localStringBuilder.append(" logout by ");
        localStringBuilder.append(paramLogoutReason);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramBoolean);
        QLog.w("mqq", 1, localStringBuilder.toString());
      }
      if (paramLogoutReason != Constants.LogoutReason.switchAccount) {
        runOnUiThread(new AppRuntime.2(this, paramLogoutReason));
      }
    }
  }
  
  public void logout(boolean paramBoolean)
  {
    logout(Constants.LogoutReason.user, paramBoolean);
  }
  
  public void notifyObserver(BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    runOnUiThread(new AppRuntime.3(this, paramBusinessObserver, paramInt, paramBoolean, paramBundle));
  }
  
  public void notifyObservers(Class<? extends BusinessObserver> paramClass, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    synchronized (this.observers)
    {
      Iterator localIterator = this.observers.iterator();
      while (localIterator.hasNext())
      {
        BusinessObserver localBusinessObserver = (BusinessObserver)((Reference)localIterator.next()).get();
        if ((localBusinessObserver != null) && (paramClass != null) && ((paramClass == BusinessObserver.class) || (paramClass.isAssignableFrom(localBusinessObserver.getClass())))) {
          notifyObserver(localBusinessObserver, paramInt, paramBoolean, paramBundle);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramClass;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.modularSaveInstance = paramBundle;
    if (getAccount() != null) {
      getAccount();
    }
    this.isRunning = true;
    if (isLogin()) {
      start(true);
    }
    if (this.parentRuntime != null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[AppRuntime]");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" (");
      localStringBuilder.append(getAccount());
      localStringBuilder.append(") onCreate,savedInstanceState=");
      localStringBuilder.append(paramBundle);
      QLog.i("mqq", 2, localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[AppRuntime]");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" (");
      localStringBuilder.append(MsfSdkUtils.getShortUin(getAccount()));
      localStringBuilder.append(") onCreate,savedInstanceState=");
      localStringBuilder.append(paramBundle);
      QLog.i("mqq", 1, localStringBuilder.toString());
    }
    addManager(0, new AccountManagerImpl(this));
    addManager(5, new PushManagerImpl(this));
    addManager(4, new ServerConfigManagerImpl(this));
    addManager(6, new VerifyCodeManagerImpl(this));
    addManager(7, new VerifyDevLockManagerImpl(this));
    if (MobileQQ.processName.equals("com.tencent.mobileqq")) {
      addManager(8, new SecurityFileFrameworkManagerImpl(this));
    }
  }
  
  protected void onDestroy()
  {
    if (this.isRunning)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[AppRuntime]");
        ((StringBuilder)localObject).append(getClass().getSimpleName());
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(getAccount());
        ((StringBuilder)localObject).append(") onDestroy");
        QLog.i("mqq", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[AppRuntime]");
        ((StringBuilder)localObject).append(getClass().getSimpleName());
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(getAccount()));
        ((StringBuilder)localObject).append(") onDestroy");
        QLog.i("mqq", 1, ((StringBuilder)localObject).toString());
      }
      this.isRunning = false;
      getServletContainer().destroy();
      localObject = this.mService;
      if (localObject != null) {
        ((MainService)localObject).clearServlets();
      }
    }
    Object localObject = this.mToolReceiver;
    if (localObject != null) {
      ((ToolProcReceiver)localObject).unRegister();
    }
    localObject = this.subRuntimeMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AppRuntime)((Iterator)localObject).next()).onDestroy();
    }
  }
  
  protected AppRuntime onGetSubRuntime(String paramString)
  {
    return null;
  }
  
  public void onGuardEvent(int paramInt, long paramLong1, long paramLong2)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 2200);
    localNewIntent.putExtra("k_event", paramInt);
    localNewIntent.putExtra("k_arg0", paramLong1);
    localNewIntent.putExtra("k_arg1", paramLong2);
    localNewIntent.withouLogin = true;
    localNewIntent.runNow = true;
    startServlet(localNewIntent);
  }
  
  protected void onProcPause() {}
  
  protected void onProcResume() {}
  
  public void onProxyIpChanged()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      localAppRuntime.onProxyIpChanged();
    }
  }
  
  public boolean onReceiveUnhandledKickedMsg(String paramString, Intent paramIntent)
  {
    return false;
  }
  
  public void onRelease()
  {
    Iterator localIterator = this.runtimeServices.values().iterator();
    while (localIterator.hasNext()) {
      ((IRuntimeService)localIterator.next()).onDestroy();
    }
  }
  
  protected void onRunningBackground()
  {
    this.isBackgroundStop = true;
    IAppStateChangeListener localIAppStateChangeListener = this.mStateChangeListener;
    if (localIAppStateChangeListener != null) {
      localIAppStateChangeListener.onRunningBackground();
    }
  }
  
  protected void onRunningForeground()
  {
    this.isBackgroundStop = false;
  }
  
  public void openMsfPCActive(String paramString1, String paramString2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("uin", paramString1);
    localNewIntent.putExtra("src", paramString2);
    localNewIntent.putExtra("opened", paramBoolean);
    localNewIntent.putExtra("action", 2128);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void registObserver(BusinessObserver paramBusinessObserver)
  {
    this.observers.add(new WeakReference(paramBusinessObserver));
  }
  
  public void reportNetworkException(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportNetworkException ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("mqq", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(getApplication(), BuiltInServlet.class);
    ((NewIntent)localObject).putExtra("action", 1042);
    ((NewIntent)localObject).putExtra("value", paramInt);
    startServlet((NewIntent)localObject);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null)
    {
      localAppRuntime.runOnUiThread(paramRunnable);
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  public void sendAppDataIncermentMsg(String paramString, String[] paramArrayOfString, long paramLong)
  {
    Object localObject = this.parentRuntime;
    if (localObject != null)
    {
      ((AppRuntime)localObject).sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
      return;
    }
    paramString = MsfMsgUtil.getAppDataIncermentMsg(this.mService.msfSub.getMsfServiceName(), paramString, paramArrayOfString, paramLong);
    paramString.setAppSeq(MSFServlet.APP_SEQ_FACTORY.incrementAndGet());
    try
    {
      this.mService.msfSub.sendMsg(paramString);
      return;
    }
    catch (Throwable paramArrayOfString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[MSF Send]");
        ((StringBuilder)localObject).append(paramString.getServiceCmd());
        ((StringBuilder)localObject).append(" error ");
        ((StringBuilder)localObject).append(paramArrayOfString);
        QLog.d("mqq", 2, ((StringBuilder)localObject).toString(), paramArrayOfString);
      }
    }
  }
  
  public void sendMsgSignal()
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("action", 2202);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void sendOnlineStatus(AppRuntime.Status paramStatus1, AppRuntime.Status paramStatus2, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    String[] arrayOfString = getMessagePushSSOCommands();
    if (arrayOfString != null)
    {
      NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 1002);
      localNewIntent.putExtra("pushCommands", arrayOfString);
      localNewIntent.putExtra("onlineStatus", paramStatus1);
      localNewIntent.putExtra("old", paramStatus2);
      localNewIntent.putExtra("kick", paramBoolean1);
      localNewIntent.putExtra("K_SEQ", paramLong);
      localNewIntent.putExtra("isUserSet", paramBoolean2);
      localNewIntent.runNow = true;
      localNewIntent.putExtra("vendor_push_type", ThirdPushSupportHelper.getThirdPushType(getApplication(), null));
      startServlet(localNewIntent);
    }
  }
  
  public void sendOnlineStatusWithExt(AppRuntime.Status paramStatus1, AppRuntime.Status paramStatus2, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, long paramLong4)
  {
    String[] arrayOfString = getMessagePushSSOCommands();
    if (arrayOfString != null)
    {
      NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 1002);
      localNewIntent.putExtra("pushCommands", arrayOfString);
      localNewIntent.putExtra("onlineStatus", paramStatus1);
      localNewIntent.putExtra("extOnlineStatus", paramLong2);
      localNewIntent.putExtra("old", paramStatus2);
      localNewIntent.putExtra("kick", paramBoolean1);
      localNewIntent.putExtra("K_SEQ", paramLong1);
      localNewIntent.putExtra("isUserSet", paramBoolean2);
      if ((paramStatus1 == AppRuntime.Status.online) && (paramLong2 == 1000L))
      {
        localNewIntent.putExtra("batteryCapacity", paramLong3);
        localNewIntent.putExtra("powerConnect", paramLong4);
      }
      localNewIntent.putExtra("vendor_push_type", ThirdPushSupportHelper.getThirdPushType(getApplication(), null));
      localNewIntent.runNow = true;
      startServlet(localNewIntent);
      return;
    }
  }
  
  public void sendWirelessMeibaoReq(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendWirelessMeibaoReq cmd: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("mqq", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(getApplication(), BuiltInServlet.class);
    ((NewIntent)localObject).putExtra("action", 1044);
    ((NewIntent)localObject).putExtra("cmd", paramInt);
    startServlet((NewIntent)localObject);
  }
  
  public void sendWirelessPswReq(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendWirelessPswReq cmd: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("mqq", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(getApplication(), BuiltInServlet.class);
    ((NewIntent)localObject).putExtra("action", 1043);
    ((NewIntent)localObject).putExtra("cmd", paramInt);
    startServlet((NewIntent)localObject);
  }
  
  public void setAppStateChangeListener(IAppStateChangeListener paramIAppStateChangeListener)
  {
    this.mStateChangeListener = paramIAppStateChangeListener;
  }
  
  public void setAsToolRuntime()
  {
    ToolProcReceiver localToolProcReceiver = this.mToolReceiver;
    if (localToolProcReceiver != null) {
      localToolProcReceiver.unRegister();
    }
    this.mToolReceiver = new ToolProcReceiver();
    localToolProcReceiver = this.mToolReceiver;
    localToolProcReceiver.mRt = this;
    localToolProcReceiver.register();
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      localAppRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setCmdCallbacker()
  {
    String[] arrayOfString = getMessagePushSSOCommands();
    if (arrayOfString != null)
    {
      NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 1040);
      localNewIntent.putExtra("pushCommands", arrayOfString);
      localNewIntent.runNow = true;
      startServlet(localNewIntent);
    }
  }
  
  public void setDevLockIntent(Intent paramIntent)
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null)
    {
      localAppRuntime.setDevLockIntent(paramIntent);
      return;
    }
    this.mDevLockIntent = paramIntent;
  }
  
  public void setInterceptKickListener(AppRuntime.InterceptKickListener paramInterceptKickListener)
  {
    MainService localMainService = getService();
    if (localMainService != null) {
      localMainService.setInterceptKickListener(paramInterceptKickListener);
    }
  }
  
  public void setKickIntent(Intent paramIntent)
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null)
    {
      localAppRuntime.setKickIntent(paramIntent);
      return;
    }
    this.mKickIntent = paramIntent;
  }
  
  public void setLogined()
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null) {
      localAppRuntime.setLogined();
    }
    this.isLogin = true;
  }
  
  public void setProcessName(String paramString)
  {
    this.mProcessName = paramString;
  }
  
  public void setProxy(AppRuntime paramAppRuntime)
  {
    this.parentRuntime = paramAppRuntime;
    if (paramAppRuntime != null)
    {
      this.isBackgroundPause = paramAppRuntime.isBackgroundPause;
      this.isBackgroundStop = paramAppRuntime.isBackgroundStop;
    }
  }
  
  public void ssoGetA1WithA1(String paramString, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, SSOAccountObserver paramSSOAccountObserver)
  {
    ssoGetA1WithA1(paramString, paramArrayOfByte1, paramLong1, paramLong2, paramLong3, paramArrayOfByte2, paramArrayOfByte3, paramSSOAccountObserver, null);
  }
  
  public void ssoGetA1WithA1(String paramString, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, SSOAccountObserver paramSSOAccountObserver, Bundle paramBundle)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSSOAccountObserver);
    localNewIntent.putExtra("ssoAccount", paramString);
    localNewIntent.putExtra("dstAppName", paramArrayOfByte1);
    localNewIntent.putExtra("dwDstSsoVer", paramLong1);
    localNewIntent.putExtra("dwDstAppid", paramLong2);
    localNewIntent.putExtra("dwSubDstAppid", paramLong3);
    localNewIntent.putExtra("dstAppVer", paramArrayOfByte2);
    localNewIntent.putExtra("dstAppSign", paramArrayOfByte3);
    localNewIntent.putExtra("action", 1102);
    if (paramBundle != null)
    {
      localNewIntent.putExtra("process", getApplication().getQQProcessName());
      localNewIntent.putExtra("extra", paramBundle);
    }
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void ssoGetTicketNoPasswd(String paramString, int paramInt, SSOAccountObserver paramSSOAccountObserver)
  {
    ssoGetTicketNoPasswd(paramString, paramInt, paramSSOAccountObserver, null);
  }
  
  public void ssoGetTicketNoPasswd(String paramString, int paramInt, SSOAccountObserver paramSSOAccountObserver, Bundle paramBundle)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSSOAccountObserver);
    localNewIntent.putExtra("process", getApplication().getQQProcessName());
    localNewIntent.putExtra("ssoAccount", paramString);
    localNewIntent.putExtra("action", 1101);
    localNewIntent.putExtra("targetTicket", paramInt);
    localNewIntent.putExtra("from_where", "ssoAccountAction");
    if (paramBundle != null) {
      localNewIntent.putExtra("extra", paramBundle);
    }
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void ssoLogin(String paramString1, String paramString2, int paramInt, SSOAccountObserver paramSSOAccountObserver)
  {
    ssoLogin(paramString1, paramString2, paramInt, paramSSOAccountObserver, null);
  }
  
  public void ssoLogin(String paramString1, String paramString2, int paramInt, SSOAccountObserver paramSSOAccountObserver, Bundle paramBundle)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSSOAccountObserver);
    localNewIntent.putExtra("process", getApplication().getQQProcessName());
    localNewIntent.putExtra("ssoAccount", paramString1);
    localNewIntent.putExtra("ssoPassword", paramString2);
    localNewIntent.putExtra("action", 1100);
    localNewIntent.putExtra("targetTicket", paramInt);
    if (paramBundle != null) {
      localNewIntent.putExtra("extra", paramBundle);
    }
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void start(boolean paramBoolean)
  {
    NewIntent localNewIntent;
    if (this.parentRuntime == null)
    {
      localObject = getAccount();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        localNewIntent.putExtra("action", 2124);
        localNewIntent.putExtra("uin", (String)localObject);
        startServlet(localNewIntent);
      }
    }
    Object localObject = getMessagePushServlets();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localNewIntent = localObject[i];
        startServlet(new NewIntent(getApplication(), localNewIntent));
        i += 1;
      }
    }
  }
  
  public void startPCActivePolling(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("uin", paramString1);
    localNewIntent.putExtra("src", paramString2);
    localNewIntent.putExtra("action", 2126);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void startServlet(NewIntent paramNewIntent)
  {
    String str2 = "";
    if (((paramNewIntent.withouLogin) || (isLogin())) && (isRunning()))
    {
      getServletContainer().forward(this, paramNewIntent);
      return;
    }
    for (;;)
    {
      try
      {
        str1 = paramNewIntent.getStringExtra("action");
      }
      catch (Exception localException2)
      {
        try
        {
          String str1;
          boolean bool2;
          boolean bool1;
          if (getAccount() == null) {
            localObject1 = "NoLogin";
          } else {
            localObject1 = getAccount();
          }
          Object localObject2 = new HashMap();
          ((HashMap)localObject2).put("uinpm", localObject1);
          ((HashMap)localObject2).put("intentWithLogin", String.valueOf(paramNewIntent.withouLogin));
          ((HashMap)localObject2).put("isLogin", String.valueOf(isLogin()));
          ((HashMap)localObject2).put("isRunning", String.valueOf(isRunning()));
          Object localObject1 = str2;
          if (paramNewIntent.getComponent() != null) {
            localObject1 = paramNewIntent.getComponent().getShortClassName();
          }
          ((HashMap)localObject2).put("compClass", localObject1);
          ((HashMap)localObject2).put("timepm", String.valueOf(System.currentTimeMillis()));
          paramNewIntent = new RdmReq();
          paramNewIntent.eventName = "sendPBToMsfError";
          paramNewIntent.isRealTime = false;
          paramNewIntent.params = ((Map)localObject2);
          paramNewIntent = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramNewIntent);
          paramNewIntent.setNeedCallback(false);
          MsfServiceSdk.get().sendMsg(paramNewIntent);
          return;
        }
        catch (Throwable paramNewIntent) {}
        localException2 = localException2;
        continue;
      }
      try
      {
        str1 = String.valueOf(paramNewIntent.getIntExtra("action", 0));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        localObject1 = "";
      }
    }
    bool2 = QLog.isColorLevel();
    bool1 = true;
    if (bool2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("can not send intent ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",isLogin:");
      ((StringBuilder)localObject2).append(isLogin());
      ((StringBuilder)localObject2).append(",isRunning:");
      ((StringBuilder)localObject2).append(isRunning());
      ((StringBuilder)localObject2).append(",parentRT:");
      if (this.parentRuntime == null) {
        bool1 = false;
      }
      ((StringBuilder)localObject2).append(bool1);
      QLog.e("mqq", 2, ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("can not send intent ,");
      ((StringBuilder)localObject1).append(isLogin());
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(isRunning());
      ((StringBuilder)localObject1).append("|");
      if (this.parentRuntime != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject1).append(bool1);
      QLog.e("mqq", 1, ((StringBuilder)localObject1).toString());
    }
    if (((MainService.isDebugVersion) || (MainService.isGrayVersion)) && (MsfServiceSdk.get() != null)) {}
  }
  
  public void stopPCActivePolling(String paramString)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("action", 2127);
    localNewIntent.putExtra("src", paramString);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void switchAccount(SimpleAccount paramSimpleAccount, String paramString)
  {
    AppRuntime localAppRuntime = this.parentRuntime;
    if (localAppRuntime != null)
    {
      localAppRuntime.switchAccount(paramSimpleAccount, paramString);
      return;
    }
    if (paramSimpleAccount != null)
    {
      getApplication().createNewRuntime(paramSimpleAccount, false, true, 2, paramString);
      return;
    }
    throw new IllegalArgumentException("the newAccount can not be null.");
  }
  
  public void unRegistObserver(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    this.observers.remove(new WeakReference(paramBusinessObserver));
  }
  
  public void updateSubAccountLogin(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSubAccountLogin isLogined = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(";subAccount =");
      localStringBuilder.append(paramString);
      QLog.d("mqq", 2, localStringBuilder.toString());
    }
    MsfSdkUtils.updateSimpleAccount(paramString, paramBoolean);
  }
  
  protected void userLogoutReleaseData() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.AppRuntime
 * JD-Core Version:    0.7.0.1
 */