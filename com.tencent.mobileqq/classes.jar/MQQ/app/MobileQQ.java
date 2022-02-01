package mqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.MsfExitReceiver;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class MobileQQ
  extends BaseApplication
  implements Handler.Callback
{
  public static final String ACTION_MAIN_PROCESS_ALIVE = "com.tencent.mobileqq__alive";
  public static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  public static final int BROADCAST_INFO_LIST_SIZE = 5;
  private static final ArraySet<String> BROADCAST_WHITE_LIST = new ArraySet();
  public static final String KEY_UIN = "uin";
  private static final int MSG_ACCOUNT = 1;
  protected static final int MSG_LAST_UIN = 3;
  private static final int MSG_MONITOR = 2;
  public static final String PACKAGE_NAME = "com.tencent.mobileqq";
  private static final String[] PERMS;
  public static final String PREF_BROADCAST = "broadcast_white_pref";
  private static final String PREF_KEY = "currentAccount";
  private static final String PREF_SHARE = "share";
  public static final String PREF_WHITE_LIST_KEY = "white_list";
  public static final int PROCESS_AV_GAME = 12;
  public static final int PROCESS_LOLA = 6;
  public static final int PROCESS_MINI = 11;
  public static final int PROCESS_MSF = 4;
  public static final int PROCESS_NEARBY = 5;
  public static final int PROCESS_OTHER = -1;
  public static final int PROCESS_PEAK = 9;
  public static final int PROCESS_QQ = 1;
  public static final int PROCESS_TOOL = 7;
  public static final int PROCESS_VIDEO = 10;
  @Deprecated
  public static final int PROCESS_WEB = 3;
  public static final int PROCESS_ZONE = 2;
  public static final int PROCESS_ZONE_LIVE = 8;
  private static final String PROPERTY_NAME = "Properties";
  public static final int STATE_EMPTY = 1;
  public static final int STATE_INITING = 2;
  public static final int STATE_READY = 3;
  public static final ConcurrentHashMap<String, Boolean> S_MODULE_LOADED = new ConcurrentHashMap();
  private static boolean hasInit;
  private static boolean hasTryExit = false;
  public static String processName;
  private static volatile boolean sHasPhonePermission;
  private static volatile boolean sHasSDCardPermission;
  private static boolean sHasStoragePermission;
  public static String sImmersiveUtilsEscapedMsg;
  public static String sInjectResult;
  public static boolean sIsToolProc = false;
  public static MobileQQ sMobileQQ;
  public static int sProcessId = -1;
  private boolean accountChanged;
  private final List<WeakReference<BaseActivity>> activitys = new ArrayList();
  public final ArrayList<WeakReference<AppActivity>> appActivities = new ArrayList();
  protected final ArrayList<WeakReference<AppService>> appServices = new ArrayList();
  public Queue<Pair<Long, String>> broadcastInfoQueue;
  private Runnable doExit;
  private boolean isCrashed;
  public boolean isPCActive;
  private ArrayList<AppCallback> mAppCallbacks;
  private AppRuntime mAppRuntime;
  final Handler mHandler;
  private volatile AtomicInteger mRuntimeState;
  private MainService mService;
  protected final ArrayList<WeakReference<Activity>> otherTypeActivitys = new ArrayList();
  private volatile Properties properties;
  List<SimpleAccount> sortAccountList;
  public String startComponentInfo;
  private boolean stopMSF;
  private boolean stopMsfOnCrash;
  private Handler subHandler;
  
  static
  {
    PERMS = new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
    sImmersiveUtilsEscapedMsg = "";
  }
  
  public MobileQQ()
  {
    BROADCAST_WHITE_LIST.add("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    BROADCAST_WHITE_LIST.add("com.android.launcher.action.INSTALL_SHORTCUT");
    BROADCAST_WHITE_LIST.add("android.intent.action.APPLICATION_MESSAGE_UPDATE");
    BROADCAST_WHITE_LIST.add("com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT");
    BROADCAST_WHITE_LIST.add("android.intent.action.BADGE_COUNT_UPDATE");
    BROADCAST_WHITE_LIST.add("com.sonyericsson.home.action.UPDATE_BADGE");
    BROADCAST_WHITE_LIST.add("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
    BROADCAST_WHITE_LIST.add("com.miui.util.LongScreenshotUtils.LongScreenshot");
    this.stopMsfOnCrash = false;
    this.isPCActive = false;
    this.broadcastInfoQueue = new LinkedList();
    this.startComponentInfo = null;
    this.mRuntimeState = new AtomicInteger(1);
    this.mHandler = new Handler(this);
    this.mAppCallbacks = new ArrayList();
    this.stopMSF = false;
    this.doExit = new MobileQQ.3(this);
    this.sortAccountList = null;
  }
  
  public static void addBroadcastWhitList(Collection<String> paramCollection)
  {
    if (paramCollection != null) {
      synchronized (BROADCAST_WHITE_LIST)
      {
        BROADCAST_WHITE_LIST.addAll(paramCollection);
        return;
      }
    }
  }
  
  /* Error */
  private void ensureInitProperty()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 261	mqq/app/MobileQQ:properties	Ljava/util/Properties;
    //   4: ifnonnull +128 -> 132
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 261	mqq/app/MobileQQ:properties	Ljava/util/Properties;
    //   13: ifnonnull +111 -> 124
    //   16: new 276	java/util/Properties
    //   19: dup
    //   20: invokespecial 277	java/util/Properties:<init>	()V
    //   23: astore 4
    //   25: aconst_null
    //   26: astore_2
    //   27: aconst_null
    //   28: astore_1
    //   29: aload_0
    //   30: ldc 71
    //   32: invokevirtual 281	mqq/app/MobileQQ:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_1
    //   38: aload_3
    //   39: astore_2
    //   40: aload 4
    //   42: aload_3
    //   43: invokevirtual 285	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   46: aload_3
    //   47: ifnull +50 -> 97
    //   50: aload_3
    //   51: invokevirtual 290	java/io/InputStream:close	()V
    //   54: goto +43 -> 97
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   62: goto +35 -> 97
    //   65: astore_2
    //   66: goto +40 -> 106
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: ldc_w 295
    //   75: iconst_1
    //   76: ldc 149
    //   78: aload_3
    //   79: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_2
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: invokevirtual 290	java/io/InputStream:close	()V
    //   90: goto +7 -> 97
    //   93: astore_1
    //   94: goto -36 -> 58
    //   97: aload_0
    //   98: aload 4
    //   100: putfield 261	mqq/app/MobileQQ:properties	Ljava/util/Properties;
    //   103: goto +21 -> 124
    //   106: aload_1
    //   107: ifnull +15 -> 122
    //   110: aload_1
    //   111: invokevirtual 290	java/io/InputStream:close	()V
    //   114: goto +8 -> 122
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   122: aload_2
    //   123: athrow
    //   124: aload_0
    //   125: monitorexit
    //   126: return
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	MobileQQ
    //   28	10	1	localObject1	Object
    //   57	2	1	localIOException1	java.io.IOException
    //   71	1	1	localObject2	Object
    //   93	18	1	localIOException2	java.io.IOException
    //   117	2	1	localIOException3	java.io.IOException
    //   127	4	1	localObject3	Object
    //   26	14	2	localObject4	Object
    //   65	58	2	localObject5	Object
    //   35	16	3	localFileInputStream	java.io.FileInputStream
    //   69	10	3	localException	Exception
    //   23	76	4	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   50	54	57	java/io/IOException
    //   29	36	65	finally
    //   40	46	65	finally
    //   72	82	65	finally
    //   29	36	69	java/lang/Exception
    //   40	46	69	java/lang/Exception
    //   86	90	93	java/io/IOException
    //   110	114	117	java/io/IOException
    //   9	25	127	finally
    //   50	54	127	finally
    //   58	62	127	finally
    //   86	90	127	finally
    //   97	103	127	finally
    //   110	114	127	finally
    //   118	122	127	finally
    //   122	124	127	finally
    //   124	126	127	finally
    //   128	130	127	finally
  }
  
  private void exit(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stopMSF = paramBoolean2;
    if (getQQProcessName().endsWith(":video")) {
      this.mService.msfSub.unRegisterMsfService(Boolean.valueOf(paramBoolean1 ^ true));
    }
    this.mService.reportMSFCallBackCost(-1L, true);
    closeAllActivitys();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exit isCrashed=");
    ((StringBuilder)localObject).append(this.isCrashed);
    ((StringBuilder)localObject).append(" stopMsfOnCrash=");
    ((StringBuilder)localObject).append(this.stopMsfOnCrash);
    QLog.d("mqq", 1, ((StringBuilder)localObject).toString());
    localObject = new MobileQQ.1(this, paramBoolean1);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.postAtFrontOfQueue((Runnable)localObject);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  public static String getLogExternalPath(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (!isHasStoragePermission(paramContext))) {
      return localFile.getPath();
    }
    return Environment.getExternalStorageDirectory().getPath();
  }
  
  public static MobileQQ getMobileQQ()
  {
    return sMobileQQ;
  }
  
  public static String getProcessSuffix(String paramString1, String paramString2)
  {
    return paramString1.replace(paramString2, "").replace(":", "");
  }
  
  public static String getShortUinStr(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() <= 4) {
      return paramString;
    }
    return paramString.substring(0, 4);
  }
  
  public static boolean isHasStoragePermission(Context paramContext)
  {
    boolean bool2 = sHasStoragePermission;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
          {
            sHasStoragePermission = true;
            return sHasStoragePermission;
          }
        }
      }
      else
      {
        sHasStoragePermission = true;
        bool1 = sHasStoragePermission;
      }
    }
    return bool1;
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return false;
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        Object localObject = paramContext.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (paramContext.processName.equals(paramString))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("kill process = ");
              ((StringBuilder)localObject).append(paramString);
              QLog.d("mqq", 2, ((StringBuilder)localObject).toString());
            }
            Process.killProcess(paramContext.pid);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static void restrictBroadcast(Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramIntent.getPackage())) && ((paramIntent.getFlags() & 0x1000000) == 0)) {
      synchronized (BROADCAST_WHITE_LIST)
      {
        boolean bool = hasInit;
        if (!bool) {}
        try
        {
          Object localObject = getContext().getSharedPreferences("broadcast_white_pref", 4).getString("white_list", null);
          if (localObject != null)
          {
            localObject = new JSONObject((String)localObject).getJSONArray("white_list");
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              BROADCAST_WHITE_LIST.add(((JSONArray)localObject).optString(i, ""));
              i += 1;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          label108:
          break label108;
        }
        hasInit = true;
        if (!BROADCAST_WHITE_LIST.contains(paramIntent.getAction()))
        {
          paramIntent.setPackage("com.tencent.mobileqq");
          if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, "sending broadcast without package");
          }
        }
        return;
      }
    } else {
      return;
    }
  }
  
  void addActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.add(0, new WeakReference(paramBaseActivity));
  }
  
  public void addOtherTypeActivity(Activity paramActivity) {}
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    sMobileQQ = this;
    initProcess();
  }
  
  public void closeAllActivitys()
  {
    MobileQQ.2 local2 = new MobileQQ.2(this);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.postAtFrontOfQueue(local2);
      return;
    }
    local2.run();
  }
  
  public void crashed()
  {
    this.isCrashed = true;
  }
  
  void createNewRuntime(SimpleAccount paramSimpleAccount, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createNewRuntime, ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString);
    QLog.d("MobileQQ", 1, localStringBuilder.toString());
    paramSimpleAccount = new MobileQQ.5(this, paramSimpleAccount, paramInt, paramBoolean1, paramBoolean2, paramString);
    if (this.mAppRuntime == null)
    {
      paramSimpleAccount.run();
      return;
    }
    this.mHandler.post(paramSimpleAccount);
  }
  
  public abstract AppRuntime createRuntime(String paramString, boolean paramBoolean);
  
  void dispatchAccountEvent(Constants.LogoutReason paramLogoutReason, int paramInt, boolean paramBoolean, String paramString)
  {
    int j = this.activitys.size();
    int i;
    if (paramLogoutReason != null) {
      i = 1;
    } else {
      i = 0;
    }
    j -= 1;
    Object localObject;
    while (j >= 0)
    {
      localObject = (BaseActivity)((WeakReference)this.activitys.get(j)).get();
      if (localObject == null)
      {
        this.activitys.remove(j);
      }
      else if (i == 0)
      {
        ((BaseActivity)localObject).setAppRuntime(this.mAppRuntime);
        if (this.accountChanged)
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
          ((BaseActivity)localObject).onAccountChanged();
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
          ((BaseActivity)localObject).onAccoutChangeFailed();
        }
      }
      else
      {
        QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
        ((BaseActivity)localObject).onLogout(paramLogoutReason);
      }
      j -= 1;
    }
    j = this.appActivities.size() - 1;
    while (j >= 0)
    {
      localObject = (AppActivity)((WeakReference)this.appActivities.get(j)).get();
      if (localObject == null)
      {
        this.appActivities.remove(j);
      }
      else if (i == 0)
      {
        ((AppActivity)localObject).setAppRuntime(this.mAppRuntime);
        if (this.accountChanged)
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
          ((AppActivity)localObject).onAccountChanged();
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
          ((AppActivity)localObject).onAccoutChangeFailed();
        }
      }
      else
      {
        QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
        ((AppActivity)localObject).onLogout(paramLogoutReason);
      }
      j -= 1;
    }
    j = this.appServices.size() - 1;
    while (j >= 0)
    {
      localObject = (AppService)((WeakReference)this.appServices.get(j)).get();
      if (localObject == null)
      {
        this.appServices.remove(j);
      }
      else if (i == 0)
      {
        ((AppService)localObject).setAppRuntime(this.mAppRuntime);
        if (this.accountChanged)
        {
          QLog.d("MobileQQ", 1, "dispatchAE S onAccountChanged");
          ((AppService)localObject).onAccountChanged();
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE S onAccoutChangeFailed");
          ((AppService)localObject).onAccoutChangeFailed();
        }
      }
      else
      {
        QLog.d("MobileQQ", 1, "dispatchAE S onLogou");
        ((AppService)localObject).onLogout(paramLogoutReason);
      }
      j -= 1;
    }
    Foreground.updateRuntimeState(this.mAppRuntime);
    if (getPackageName().equals(getQQProcessName())) {
      if (i == 0)
      {
        if (this.accountChanged)
        {
          if (!paramBoolean)
          {
            paramLogoutReason = new Intent("mqq.intent.action.ACCOUNT_CHANGED");
            paramLogoutReason.putExtra("account", this.mAppRuntime.getAccount());
            paramLogoutReason.putExtra("type", paramInt);
            paramLogoutReason.setPackage("com.tencent.mobileqq");
            sendBroadcast(paramLogoutReason);
            paramLogoutReason = new StringBuilder();
            paramLogoutReason.append("mqq.intent.action.EXIT_");
            paramLogoutReason.append(getMobileQQ().getPackageName());
            paramLogoutReason = new Intent(paramLogoutReason.toString());
            paramLogoutReason.putExtra("K_EXCEP", paramString);
            paramLogoutReason.setPackage("com.tencent.mobileqq");
            sendBroadcast(paramLogoutReason);
            try
            {
              QIPCServerHelper.getInstance().notifyOnAccountChanged();
              return;
            }
            catch (Exception paramLogoutReason)
            {
              QLog.d("mqq", 1, "onAccountChanged", paramLogoutReason);
              return;
            }
          }
          paramLogoutReason = new Intent("com.tencent.mobileqq__alive");
          paramLogoutReason.setPackage("com.tencent.mobileqq");
          sendBroadcast(paramLogoutReason);
        }
      }
      else {
        sendBroadcast(new Intent("mqq.intent.action.LOGOUT"));
      }
    }
  }
  
  /* Error */
  public final void doInit(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 209	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_1
    //   5: iconst_2
    //   6: invokevirtual 714	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getstatic 715	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   17: invokevirtual 718	mqq/app/MobileQQ:isNeedMSF	(Ljava/lang/String;)Z
    //   20: istore_2
    //   21: new 342	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc_w 720
    //   33: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: getstatic 715	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   41: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc_w 295
    //   48: iconst_1
    //   49: aload_3
    //   50: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: getstatic 715	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   59: ldc_w 722
    //   62: invokevirtual 313	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   65: ifne +249 -> 314
    //   68: iload_2
    //   69: ifeq +245 -> 314
    //   72: aload_0
    //   73: new 315	mqq/app/MainService
    //   76: dup
    //   77: aload_0
    //   78: aload_0
    //   79: getstatic 715	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   82: invokevirtual 725	mqq/app/MobileQQ:getAppId	(Ljava/lang/String;)I
    //   85: aload_0
    //   86: getstatic 715	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   89: invokevirtual 728	mqq/app/MobileQQ:getBootBroadcastName	(Ljava/lang/String;)Ljava/lang/String;
    //   92: iload_1
    //   93: invokespecial 731	mqq/app/MainService:<init>	(Lmqq/app/MobileQQ;ILjava/lang/String;Z)V
    //   96: putfield 239	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   99: aload_0
    //   100: invokevirtual 307	mqq/app/MobileQQ:getQQProcessName	()Ljava/lang/String;
    //   103: ldc_w 309
    //   106: invokevirtual 313	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   109: ifne +13 -> 122
    //   112: aload_0
    //   113: getfield 239	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   116: getfield 319	mqq/app/MainService:msfSub	Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   119: invokevirtual 734	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:initMsfService	()V
    //   122: aload_0
    //   123: invokevirtual 737	mqq/app/MobileQQ:getAllAccounts	()Ljava/util/List;
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +361 -> 489
    //   131: aload_3
    //   132: iconst_0
    //   133: invokeinterface 610 2 0
    //   138: checkcast 739	com/tencent/qphone/base/remote/SimpleAccount
    //   141: astore_3
    //   142: goto +3 -> 145
    //   145: aload_3
    //   146: astore 4
    //   148: aload_3
    //   149: ifnonnull +148 -> 297
    //   152: ldc_w 295
    //   155: iconst_1
    //   156: ldc_w 741
    //   159: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: ldc 42
    //   165: iconst_0
    //   166: invokevirtual 742	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   169: astore 6
    //   171: aload_3
    //   172: astore 4
    //   174: aload 6
    //   176: ifnull +121 -> 297
    //   179: aload 6
    //   181: ldc 39
    //   183: aconst_null
    //   184: invokeinterface 528 3 0
    //   189: astore 5
    //   191: invokestatic 485	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +41 -> 235
    //   197: new 342	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   204: astore 4
    //   206: aload 4
    //   208: ldc_w 744
    //   211: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 4
    //   217: aload 5
    //   219: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc_w 295
    //   226: iconst_1
    //   227: aload 4
    //   229: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_3
    //   236: astore 4
    //   238: aload 5
    //   240: ifnull +57 -> 297
    //   243: aload 6
    //   245: invokeinterface 748 1 0
    //   250: ldc 39
    //   252: invokeinterface 753 2 0
    //   257: invokeinterface 756 1 0
    //   262: pop
    //   263: new 739	com/tencent/qphone/base/remote/SimpleAccount
    //   266: dup
    //   267: invokespecial 757	com/tencent/qphone/base/remote/SimpleAccount:<init>	()V
    //   270: astore 4
    //   272: aload 4
    //   274: aload 5
    //   276: invokevirtual 760	com/tencent/qphone/base/remote/SimpleAccount:setUin	(Ljava/lang/String;)V
    //   279: aload 4
    //   281: invokevirtual 763	com/tencent/qphone/base/remote/SimpleAccount:isLogined	()Z
    //   284: pop
    //   285: aload 4
    //   287: ldc_w 765
    //   290: iconst_1
    //   291: invokestatic 768	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   294: invokevirtual 772	com/tencent/qphone/base/remote/SimpleAccount:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: aload 4
    //   300: iconst_0
    //   301: getstatic 715	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   304: ldc 31
    //   306: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: iconst_5
    //   310: aconst_null
    //   311: invokevirtual 774	mqq/app/MobileQQ:createNewRuntime	(Lcom/tencent/qphone/base/remote/SimpleAccount;ZZILjava/lang/String;)V
    //   314: new 342	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   321: astore_3
    //   322: aload_3
    //   323: ldc_w 776
    //   326: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: getstatic 715	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   334: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_0
    //   339: new 500	android/content/Intent
    //   342: dup
    //   343: aload_3
    //   344: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokespecial 669	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   350: invokevirtual 688	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   353: aload_0
    //   354: getfield 209	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   357: astore_3
    //   358: aload_3
    //   359: monitorenter
    //   360: aload_0
    //   361: getfield 209	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   364: iconst_3
    //   365: invokevirtual 779	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   368: aload_0
    //   369: getfield 209	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   372: invokevirtual 784	java/lang/Object:notifyAll	()V
    //   375: aload_3
    //   376: monitorexit
    //   377: ldc_w 295
    //   380: iconst_1
    //   381: ldc_w 786
    //   384: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aload_0
    //   388: getfield 216	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   391: iconst_2
    //   392: ldc2_w 787
    //   395: invokevirtual 792	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   398: pop
    //   399: return
    //   400: astore 4
    //   402: aload_3
    //   403: monitorexit
    //   404: aload 4
    //   406: athrow
    //   407: astore 4
    //   409: goto +24 -> 433
    //   412: astore_3
    //   413: ldc_w 295
    //   416: iconst_1
    //   417: ldc_w 794
    //   420: aload_3
    //   421: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   424: new 796	java/lang/RuntimeException
    //   427: dup
    //   428: aload_3
    //   429: invokespecial 799	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   432: athrow
    //   433: aload_0
    //   434: getfield 209	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   437: astore_3
    //   438: aload_3
    //   439: monitorenter
    //   440: aload_0
    //   441: getfield 209	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   444: iconst_3
    //   445: invokevirtual 779	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   448: aload_0
    //   449: getfield 209	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   452: invokevirtual 784	java/lang/Object:notifyAll	()V
    //   455: aload_3
    //   456: monitorexit
    //   457: ldc_w 295
    //   460: iconst_1
    //   461: ldc_w 786
    //   464: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: aload_0
    //   468: getfield 216	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   471: iconst_2
    //   472: ldc2_w 787
    //   475: invokevirtual 792	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   478: pop
    //   479: aload 4
    //   481: athrow
    //   482: astore 4
    //   484: aload_3
    //   485: monitorexit
    //   486: aload 4
    //   488: athrow
    //   489: aconst_null
    //   490: astore_3
    //   491: goto -346 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	MobileQQ
    //   0	494	1	paramBoolean	boolean
    //   20	49	2	bool	boolean
    //   412	17	3	localThrowable	Throwable
    //   146	153	4	localObject2	Object
    //   400	5	4	localObject3	Object
    //   407	73	4	localObject4	Object
    //   482	5	4	localObject5	Object
    //   189	86	5	str	String
    //   169	75	6	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   360	377	400	finally
    //   402	404	400	finally
    //   13	68	407	finally
    //   72	122	407	finally
    //   122	127	407	finally
    //   131	142	407	finally
    //   152	171	407	finally
    //   179	235	407	finally
    //   243	297	407	finally
    //   297	314	407	finally
    //   314	353	407	finally
    //   413	433	407	finally
    //   13	68	412	java/lang/Throwable
    //   72	122	412	java/lang/Throwable
    //   122	127	412	java/lang/Throwable
    //   131	142	412	java/lang/Throwable
    //   152	171	412	java/lang/Throwable
    //   179	235	412	java/lang/Throwable
    //   243	297	412	java/lang/Throwable
    //   297	314	412	java/lang/Throwable
    //   314	353	412	java/lang/Throwable
    //   440	457	482	finally
    //   484	486	482	finally
  }
  
  public boolean doesHasPhonePermission()
  {
    if (!sHasPhonePermission) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((context != null) && (context.checkSelfPermission(PERMS[1]) == 0)) {
          sHasPhonePermission = true;
        }
      }
      else {
        sHasPhonePermission = true;
      }
    }
    return sHasPhonePermission;
  }
  
  public boolean doesHasSDCardPermission()
  {
    if (!sHasSDCardPermission) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((context != null) && (context.checkSelfPermission(PERMS[0]) == 0)) {
          sHasSDCardPermission = true;
        }
      }
      else {
        sHasSDCardPermission = true;
      }
    }
    return sHasSDCardPermission;
  }
  
  public List<SimpleAccount> getAllAccounts()
  {
    List localList2 = this.sortAccountList;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = refreAccountList();
    }
    return localList1;
  }
  
  public List<SimpleAccount> getAllNotSynAccountList()
  {
    return this.sortAccountList;
  }
  
  public abstract int getAppId(String paramString);
  
  public AppRuntime getAppRuntime(String paramString)
  {
    AppRuntime localAppRuntime = waitAppRuntime(null);
    if ((paramString != null) && (paramString.equals(localAppRuntime.getAccount()))) {
      return localAppRuntime;
    }
    if (paramString == localAppRuntime.getAccount()) {
      return localAppRuntime;
    }
    throw new AccountNotMatchException(localAppRuntime.getAccount(), paramString);
  }
  
  public abstract String getBootBroadcastName(String paramString);
  
  public SimpleAccount getFirstSimpleAccount()
  {
    List localList = getAllAccounts();
    if ((localList != null) && (localList.size() != 0)) {
      return (SimpleAccount)localList.get(0);
    }
    return null;
  }
  
  public int getMsfConnectedNetType()
  {
    try
    {
      int i = this.mService.msfSub.getConnectedNetowrkType();
      return i;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    return 0;
  }
  
  public String getProperty(String paramString)
  {
    ensureInitProperty();
    return this.properties.getProperty(paramString);
  }
  
  public String getQQProcessName()
  {
    if (processName == null)
    {
      int i = 0;
      String str2;
      do
      {
        str2 = MsfSdkUtils.getProcessName(this);
        i += 1;
      } while ((i < 3) && ("unknown".equals(str2)));
      String str1 = str2;
      if ("unknown".equals(str2)) {
        str1 = "com.tencent.mobileqq";
      }
      processName = str1;
      BaseApplication.processName = str1;
    }
    return processName;
  }
  
  public WeakReference<BaseActivity> getResumeActivity()
  {
    Iterator localIterator = this.activitys.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (((BaseActivity)localWeakReference.get()).isResume()) {
        return localWeakReference;
      }
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        SharedPreferences localSharedPreferences = getSharedPreferences("Last_Login", 4);
        if (localSharedPreferences.getString("uin", "").equals(paramMessage)) {
          break label145;
        }
        localSharedPreferences.edit().putString("uin", paramMessage).commit();
        return true;
      }
      monitor.setProcessName(processName);
      try
      {
        monitor.start();
        return true;
      }
      catch (Throwable paramMessage)
      {
        QLog.d("mqq", 1, "", paramMessage);
        return true;
      }
    }
    i = paramMessage.arg1;
    boolean bool;
    if (paramMessage.arg2 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    dispatchAccountEvent(null, i, bool, (String)paramMessage.obj);
    label145:
    return true;
  }
  
  protected void initProcess()
  {
    String str = getQQProcessName();
    if ("com.tencent.mobileqq".equals(str)) {
      sProcessId = 1;
    } else if (str.endsWith("MSF")) {
      sProcessId = 4;
    } else if (str.endsWith("qzone")) {
      sProcessId = 2;
    } else if (str.endsWith("web")) {
      sProcessId = 3;
    } else if (str.endsWith("nearby")) {
      sProcessId = 5;
    } else if (str.endsWith("lola")) {
      sProcessId = 6;
    } else if (str.endsWith("tool")) {
      sProcessId = 7;
    } else if (str.endsWith("qzonelive")) {
      sProcessId = 8;
    } else if (str.endsWith("peak")) {
      sProcessId = 9;
    } else if (str.endsWith("video")) {
      sProcessId = 10;
    } else if (str.endsWith("miniapp")) {
      sProcessId = 11;
    } else if (str.endsWith("avgame")) {
      sProcessId = 12;
    } else {
      sProcessId = -1;
    }
    BaseApplication.processName = str;
  }
  
  public boolean isModuleLoaded(String paramString)
  {
    if (paramString != null)
    {
      paramString = (Boolean)S_MODULE_LOADED.get(paramString);
      if (paramString != null) {
        return paramString.booleanValue();
      }
    }
    return false;
  }
  
  public abstract boolean isNeedMSF(String paramString);
  
  public boolean isRuntimeReady()
  {
    return this.mRuntimeState.get() == 3;
  }
  
  public void loadModule(String paramString)
  {
    if (paramString == null) {
      return;
    }
    S_MODULE_LOADED.put(paramString, Boolean.valueOf(true));
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean) {}
  
  public void onCreate()
  {
    sMobileQQ = this;
    super.onCreate();
  }
  
  public void onSendBroadcast(Context paramContext, Intent paramIntent)
  {
    Object[] arrayOfObject;
    synchronized (this.mAppCallbacks)
    {
      if (this.mAppCallbacks.size() > 0)
      {
        arrayOfObject = this.mAppCallbacks.toArray();
        if (arrayOfObject != null)
        {
          int j = arrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            ((AppCallback)arrayOfObject[i]).onSendBroadcast(paramContext, paramIntent);
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  public void otherProcessExit(boolean paramBoolean)
  {
    exit(paramBoolean, false);
  }
  
  public AppRuntime peekAppRuntime()
  {
    return this.mAppRuntime;
  }
  
  public void qqProcessExit(boolean paramBoolean)
  {
    exit(false, paramBoolean);
  }
  
  public List<SimpleAccount> refreAccountList()
  {
    return setSortAccountList(MsfSdkUtils.getLoginedAccountList());
  }
  
  public void registerAppCallbacks(AppCallback paramAppCallback)
  {
    synchronized (this.mAppCallbacks)
    {
      this.mAppCallbacks.add(paramAppCallback);
      return;
    }
  }
  
  void removeActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.remove(new WeakReference(paramBaseActivity));
  }
  
  public void removeOtherTypeActivity(Activity paramActivity) {}
  
  public void reportPCActive(String paramString, int paramInt) {}
  
  public void sendBroadcast(Intent paramIntent)
  {
    restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent, paramString);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.mAppRuntime;
    if ((localAppRuntime != null) && (localAppRuntime.getAccount() != null) && (this.mAppRuntime.getAccount().length() > 0)) {
      this.mAppRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setProperty(String arg1, String paramString2)
  {
    ensureInitProperty();
    this.properties.setProperty(???, paramString2);
    if (???.endsWith(Constants.Key._logintime.toString())) {
      setSortAccountList(this.sortAccountList);
    }
    if (this.subHandler == null) {
      synchronized (this.properties)
      {
        if (this.subHandler == null)
        {
          paramString2 = new HandlerThread("property-saver");
          paramString2.start();
          this.subHandler = new Handler(paramString2.getLooper());
        }
      }
    }
    this.subHandler.post(new MobileQQ.6(this));
  }
  
  public List<SimpleAccount> setSortAccountList(List<SimpleAccount> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new MobileQQ.4(this));
      if (paramList != this.sortAccountList) {
        this.sortAccountList = paramList;
      }
    }
    return this.sortAccountList;
  }
  
  public void startActivity(Intent paramIntent)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void startService()
  {
    MainService localMainService = this.mService;
    if (localMainService != null) {
      localMainService.start();
    }
  }
  
  public void stopMsfOnCrash(boolean paramBoolean)
  {
    this.stopMsfOnCrash = paramBoolean;
    if (this.stopMsfOnCrash)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop and kill msf stopMsfOnCrash=");
      localStringBuilder.append(this.stopMsfOnCrash);
      QLog.d("mqq", 1, localStringBuilder.toString());
      try
      {
        this.mService.msfSub.unRegisterMsfService();
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      try
      {
        this.mService.msfSub.unbindMsfService();
        this.mService.msfSub.stopMsfService();
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
      try
      {
        Intent localIntent = new Intent("com.tencent.process.exit");
        localIntent.putExtra("procName", "com.tencent.mobileqq:MSF");
        localIntent.putExtra("verify", MsfExitReceiver.getLocalVerify("com.tencent.mobileqq:MSF", false));
        sendBroadcast(localIntent);
        return;
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
      }
    }
  }
  
  public long string2Long(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long number is empty");
      }
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long catch exception");
      }
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public void unregisterAppCallbacks(AppCallback paramAppCallback)
  {
    synchronized (this.mAppCallbacks)
    {
      this.mAppCallbacks.remove(paramAppCallback);
      return;
    }
  }
  
  public AppRuntime waitAppRuntime(BaseActivity arg1)
  {
    int i = this.mRuntimeState.get();
    if (i != 3)
    {
      if (i == 1)
      {
        QLog.e("mqq", 1, "waitInit when empty: ", new RuntimeException(""));
        doInit(true);
      }
      synchronized (this.mRuntimeState)
      {
        i = this.mRuntimeState.get();
        if (i == 2) {
          try
          {
            this.mRuntimeState.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            QLog.e("mqq", 1, "waitInit failed", localInterruptedException);
          }
        }
      }
    }
    return this.mAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MobileQQ
 * JD-Core Version:    0.7.0.1
 */