import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController.1;
import com.tencent.mobileqq.app.upgrade.UpgradeController.2;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public final class akgo
  implements akgl, Handler.Callback, bcgn, bcgv, bchv
{
  private static akgo jdField_a_of_type_Akgo;
  private int jdField_a_of_type_Int;
  private akgk jdField_a_of_type_Akgk;
  private akgp jdField_a_of_type_Akgp;
  private befq jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private DownloadInfo jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
  public volatile String a;
  private WeakReference<akgq> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<akgr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private volatile boolean b;
  private volatile boolean c;
  private boolean d;
  private boolean e;
  
  private akgo()
  {
    this.jdField_a_of_type_Boolean = true;
    a(false);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt1 == 12) || (paramInt1 == 2)) && (a() == 4)) {
      return 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null)) {
      return 1;
    }
    String str;
    Bundle localBundle;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_JavaLangString != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_JavaLangString;
      localBundle = new Bundle();
      localBundle.putString(bcgl.b, "100686848");
      localBundle.putString(bcgl.j, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString(bcgl.f, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
      localBundle.putInt(bcgl.k, paramInt1);
      if (paramInt1 == 12) {
        localBundle.putBoolean(bcgl.o, true);
      }
      localBundle.putString(bcgl.i, "ANDROIDQQ.QQUPDATE");
      localBundle.putString(bcgl.l, str);
      if (paramInt2 == 0) {
        break label354;
      }
      localBundle.putString(bcgl.m, "_100686848");
      localBundle.putBoolean(bcgl.x, false);
      i = paramInt2;
      if (paramInt1 != 5)
      {
        i = paramInt2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade != 0) {}
      }
    }
    for (int i = 0;; i = paramInt2)
    {
      localBundle.putString(bcgl.jdField_c_of_type_JavaLangString, "6633");
      localBundle.putInt(bcgl.e, this.jdField_a_of_type_Int);
      localBundle.putBoolean(bcgl.g, true);
      localBundle.putBoolean(bcgl.h, true);
      localBundle.putInt(bcgl.n, 1);
      localBundle.putInt(bcgl.A, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bGray);
      paramInt1 = paramInt3;
      if (paramInt3 != 1)
      {
        paramInt1 = paramInt3;
        if (paramInt3 != 2)
        {
          paramInt1 = paramInt3;
          if (paramInt3 != 3) {
            paramInt1 = 0;
          }
        }
      }
      localBundle.putInt("qqupdate_support_go_market", paramInt1);
      bcgh.a(BaseActivity.sTopActivity, localBundle, "biz_src_jc_update", this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, i);
      return 0;
      str = "新版手Q";
      break;
      label354:
      localBundle.putBoolean(bcgl.x, true);
    }
  }
  
  public static akgo a()
  {
    if (jdField_a_of_type_Akgo == null) {
      jdField_a_of_type_Akgo = new akgo();
    }
    return jdField_a_of_type_Akgo;
  }
  
  private static PackageInfo a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
  }
  
  public static String a()
  {
    String str2 = "";
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      localObject = ((akgo)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          str1 = "" + ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId;
        }
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    return befm.a(paramString, "nt", akgn.a());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    Object localObject = a();
    boolean bool1;
    if (localObject != null)
    {
      localObject = ((akgo)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)) {
        if ((((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType > 0) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch == 1))
        {
          bool1 = true;
          if (!bool1) {
            break label101;
          }
          if (ajgd.a(paramQQAppInterface, ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp)) {
            break label96;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        bool2 = ((ariy)paramQQAppInterface.getManager(244)).a();
      }
      return bool2;
      bool1 = false;
      break;
      label96:
      bool1 = false;
      continue;
      label101:
      continue;
      bool1 = false;
    }
  }
  
  private boolean a(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    if (paramArrayOfSignature1 == null) {}
    HashSet localHashSet;
    do
    {
      do
      {
        return false;
      } while (paramArrayOfSignature2 == null);
      localHashSet = new HashSet();
      int j = paramArrayOfSignature1.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramArrayOfSignature1[i]);
        i += 1;
      }
      paramArrayOfSignature1 = new HashSet();
      j = paramArrayOfSignature2.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfSignature1.add(paramArrayOfSignature2[i]);
        i += 1;
      }
    } while (!localHashSet.equals(paramArrayOfSignature1));
    return true;
  }
  
  public static String b()
  {
    int j = 0;
    Object localObject = a();
    int i = j;
    if (localObject != null)
    {
      localObject = ((akgo)localObject).jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          i = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType;
        }
      }
    }
    return String.valueOf(i);
  }
  
  private void b(int paramInt)
  {
    try
    {
      ajgd localajgd = (ajgd)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime()).a(4);
      String str = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
      this.jdField_a_of_type_JavaLangString = (str + "_" + paramInt);
      this.jdField_a_of_type_Int = paramInt;
      localajgd.a(str, paramInt, this.jdField_a_of_type_JavaLangString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(int paramInt)
  {
    if (this.c) {}
    akgq localakgq;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localakgq = (akgq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localakgq == null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
      localakgq.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper, this);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "invokeStateChangedToListeners:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((akgr)localIterator.next()).a(paramInt, this);
      }
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = "100686848";
    localDownloadInfo.e = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
    localDownloadInfo.j = "6633";
    localDownloadInfo.b = this.jdField_a_of_type_Int;
    localArrayList.add(localDownloadInfo);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "queryDownloadInfo:" + localDownloadInfo);
    }
    bcgh.a(localArrayList, this);
  }
  
  private void g()
  {
    try
    {
      if (!a())
      {
        this.jdField_a_of_type_Akgp = new akgp(this);
        this.jdField_a_of_type_Akgp.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h()
  {
    try
    {
      if (a())
      {
        this.jdField_a_of_type_Akgp.b();
        this.jdField_a_of_type_Akgp = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void i()
  {
    b(true);
    Object localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    awqx.b((QQAppInterface)localObject, "CliOper", "", "", "0X800716C", "0X800716C", 0, 0, "", "", "", "");
    int i = 0;
    this.jdField_a_of_type_Boolean = false;
    if (badq.h(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
      i = 1;
    }
    ((QQAppInterface)localObject).getPreferences().edit().putInt("APPID_SHOULD_DOWNLOAD", a().jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(i));
    ((HashMap)localObject).put("param_ErrMsg", "success");
    awrn.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeErr", true, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  private void j()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "initDownloadEnv: " + this.d);
      }
      if (!this.d)
      {
        bchu.a().a(this);
        bcgh.a(this);
        this.d = true;
      }
      return;
    }
    finally {}
  }
  
  private void k()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "releaseDownloadEnv: " + this.d);
      }
      if (this.d)
      {
        bchu.a().b(this);
        bchu.a().a();
        if (this.jdField_a_of_type_Akgk != null)
        {
          bcgh.b(this.jdField_a_of_type_Akgk);
          this.jdField_a_of_type_Akgk = null;
        }
        this.jdField_a_of_type_Int = 0;
        bcgh.b(this);
        this.d = false;
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
    {
      i = j;
      switch (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a())
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "getDownloadState: " + i);
      }
      return i;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public UpgradeDetailWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "MYAPP has work, do not allow download by wifi");
        }
        ajgd.b(localQQAppInterface, false);
        b(false);
        return;
      }
    } while (this.b);
    a(ajgd.a(localQQAppInterface, false), 0);
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      awrn.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeWritten", bool, 0L, 0L, localHashMap, "", true);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onException:" + paramInt + ", " + paramString);
    }
    c(0);
  }
  
  public void a(akgr paramakgr)
  {
    if (paramakgr == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramakgr)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramakgr);
      }
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a() != 4)) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_Int == 1)) {
          break label70;
        }
        a(5, i, 0);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UpgradeController", 2, "installApk:", paramContext);
      return;
      label70:
      i = 1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (a() == 4) {}
    for (int i = 1134018;; i = 11340003)
    {
      paramQQAppInterface.obtainMessage(i).sendToTarget();
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str = ajgd.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (str != null) && (!str.startsWith("com.tencent.av.")) && (!str.equals("com.tencent.mobileqq.activity.UserguideActivity")) && (!str.equals("com.tencent.mobileqq.activity.UpgradeDetailActivity"))) {
      localBaseActivity.runOnUiThread(new UpgradeController.2(this, paramBoolean, paramQQAppInterface));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "onCheckUpdateFailed");
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_Int);
  }
  
  public void a(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (ApkUpdateDetail)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_Int == paramArrayList.versioncode) {
          this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramArrayList;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "onCheckUpdateSucceed:" + paramArrayList.url + " -- " + paramArrayList.updatemethod);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versioncode);
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_Int);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = ((DownloadInfo)paramList.get(0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onResult Status:" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
    c(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 2)) {}
    do
    {
      return;
      c();
      this.c = paramBoolean;
      this.jdField_a_of_type_Befq.removeMessages(0);
      k();
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = null;
      this.jdField_a_of_type_Boolean = true;
    } while ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null));
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = new UpgradeDetailWrapper(null, null);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "startDownload:" + paramBoolean + ", " + this.b);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if (a() == 4) {}
    while (this.b) {
      return;
    }
    ajgd.b(localQQAppInterface, paramBoolean);
    if (paramBoolean)
    {
      g();
      return;
    }
    b(false, paramInt);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        if (this.jdField_a_of_type_Akgk == null)
        {
          i = 1;
          if (!paramBoolean) {
            break label90;
          }
          if (i != 0) {
            f();
          }
          this.jdField_a_of_type_Akgk = new akgk(paramString2, this);
          bcgh.a(this.jdField_a_of_type_Akgk);
          this.jdField_a_of_type_JavaLangString = null;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label90:
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt = null;
        c(-1);
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Akgp != null;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_JavaLangString == null)) {
        b(paramInt);
      }
      return bool;
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: new 638	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 640	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 643	java/io/File:exists	()Z
    //   13: ifeq +73 -> 86
    //   16: new 645	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 648	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: iconst_2
    //   28: newarray byte
    //   30: astore 4
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: aload 4
    //   37: invokevirtual 652	java/io/FileInputStream:read	([B)I
    //   40: pop
    //   41: aload 4
    //   43: iconst_0
    //   44: baload
    //   45: bipush 80
    //   47: if_icmpne +14 -> 61
    //   50: aload 4
    //   52: iconst_1
    //   53: baload
    //   54: istore_2
    //   55: iload_2
    //   56: bipush 75
    //   58: if_icmpeq +20 -> 78
    //   61: aload_3
    //   62: ifnull +7 -> 69
    //   65: aload_3
    //   66: invokevirtual 655	java/io/FileInputStream:close	()V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 658	java/io/IOException:printStackTrace	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 655	java/io/FileInputStream:close	()V
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 658	java/io/IOException:printStackTrace	()V
    //   93: goto -7 -> 86
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_3
    //   101: astore_1
    //   102: ldc_w 330
    //   105: iconst_1
    //   106: ldc 212
    //   108: aload 4
    //   110: invokestatic 660	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_3
    //   114: ifnull -28 -> 86
    //   117: aload_3
    //   118: invokevirtual 655	java/io/FileInputStream:close	()V
    //   121: goto -35 -> 86
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 658	java/io/IOException:printStackTrace	()V
    //   129: goto -43 -> 86
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 655	java/io/FileInputStream:close	()V
    //   143: aload_3
    //   144: athrow
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 658	java/io/IOException:printStackTrace	()V
    //   150: goto -7 -> 143
    //   153: astore_3
    //   154: goto -19 -> 135
    //   157: astore 4
    //   159: goto -59 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	akgo
    //   0	162	1	paramString	String
    //   54	5	2	i	int
    //   24	94	3	localFileInputStream	java.io.FileInputStream
    //   132	12	3	localObject1	Object
    //   153	1	3	localObject2	Object
    //   30	21	4	arrayOfByte	byte[]
    //   96	13	4	localThrowable1	Throwable
    //   157	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   82	86	88	java/io/IOException
    //   16	25	96	java/lang/Throwable
    //   117	121	124	java/io/IOException
    //   16	25	132	finally
    //   139	143	145	java/io/IOException
    //   27	32	153	finally
    //   34	41	153	finally
    //   102	113	153	finally
    //   27	32	157	java/lang/Throwable
    //   34	41	157	java/lang/Throwable
  }
  
  public boolean a(String paramString, PackageInfo paramPackageInfo)
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageManager();
    boolean bool1;
    if ((paramPackageInfo.signatures != null) && (paramPackageInfo.signatures.length > 0))
    {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName(), 64);
        if (((PackageInfo)localObject).packageName.equals(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName()))
        {
          if ((((PackageInfo)localObject).signatures == null) || (((PackageInfo)localObject).signatures.length <= 0)) {
            break label177;
          }
          if (a(((PackageInfo)localObject).signatures, paramPackageInfo.signatures))
          {
            if (!QLog.isColorLevel()) {
              break label236;
            }
            QLog.d("UpgradeConfigManager", 2, "target apk's signature is same with mobileqq");
            break label236;
          }
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          QLog.d("UpgradeConfigManager", 2, "target apk's signature is wrong! path=" + paramString);
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
      }
      QLog.d("UpgradeConfigManager", 2, "WTF? cannot find mobileqq in local app");
      return false;
      label177:
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeConfigManager", 2, "WTF? cannot get signature from local mobileqq");
        return false;
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeConfigManager", 2, "cannot get signature from apk:" + paramString);
        return false;
        label236:
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(UpgradeInfo paramUpgradeInfo, akgq paramakgq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt = ajgd.a(paramUpgradeInfo);
    if ((paramakgq == null) || (paramUpgradeInfo == null)) {
      return false;
    }
    if (paramUpgradeInfo.iUpgradeType == 0) {
      return false;
    }
    if (this.c) {
      return false;
    }
    if ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime() == null) {
      return false;
    }
    j();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakgq);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "handleUpgradeInfo packageName = " + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ", bGray = " + paramUpgradeInfo.bGray + ", versioncode = " + this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_Int);
    }
    paramUpgradeInfo = new ApkUpdateParam(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName(), paramUpgradeInfo.bGray, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_Int);
    paramakgq = new ArrayList();
    paramakgq.add(paramUpgradeInfo);
    bchu.a().b(paramakgq);
    return true;
  }
  
  public void b()
  {
    if ((this.b) && (a())) {
      c();
    }
  }
  
  public void b(akgr paramakgr)
  {
    if (paramakgr == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramakgr)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramakgr);
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.post(new UpgradeController.1(this, paramBoolean), 5, null, false);
  }
  
  void b(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    if (!this.b)
    {
      this.b = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod != 4)) {
        break label59;
      }
    }
    label59:
    for (int i = 12;; i = 2)
    {
      if (paramBoolean) {
        j = 0;
      }
      a(i, j, paramInt);
      return;
    }
  }
  
  public boolean b()
  {
    String str1 = null;
    if ((a() == 4) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null))
    {
      String str2 = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l;
      if (TextUtils.isEmpty(str2))
      {
        QLog.e("UpgradeConfigManager", 1, "checkJacking：  cannot get path to apk");
        return true;
      }
      Object localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageArchiveInfo(str2, 64);
        if (localObject == null) {
          break label252;
        }
        if (((PackageInfo)localObject).packageName.equals(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName()))
        {
          String str3 = PluginStatic.encodeFile(str2);
          QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
          if (localQQAppInterface != null) {
            str1 = localQQAppInterface.getPreferences().getString("upgrade_check_md5", "");
          }
          if (!str3.equals(str1))
          {
            QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... md5 is different. apkMd5File=" + str3 + " apkMd5Record=" + str1);
            return true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        PackageInfo localPackageInfo;
        for (;;)
        {
          QLog.d("UpgradeController", 1, localThrowable, new Object[0]);
          localPackageInfo = null;
        }
        if (a(str2, localPackageInfo))
        {
          if (a(str2))
          {
            QLog.d("UpgradeConfigManager", 1, "checkJacking：  success!!! i think it is safe");
            return false;
          }
          QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... dex injected");
          return true;
        }
        QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... signature is wrong.");
        return true;
      }
      QLog.d("UpgradeConfigManager", 1, "checkJacking：  package name is wrong!");
      return true;
    }
    label252:
    QLog.e("UpgradeConfigManager", 1, "checkJacking：  apk has not been downloaded or cannot get download info");
    return true;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 330
    //   11: iconst_2
    //   12: ldc_w 772
    //   15: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 245	akgo:b	Z
    //   22: ifeq +21 -> 43
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 245	akgo:b	Z
    //   30: aload_0
    //   31: invokevirtual 774	akgo:e	()V
    //   34: aload_0
    //   35: invokespecial 776	akgo:h	()V
    //   38: ldc 138
    //   40: invokestatic 778	bcgh:a	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: goto -13 -> 34
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	akgo
    //   46	1	1	localException	Exception
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	34	46	java/lang/Exception
    //   2	18	50	finally
    //   18	30	50	finally
    //   30	34	50	finally
    //   34	43	50	finally
  }
  
  public void d()
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "resumeDownload:");
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4) {
        i = 12;
      }
    }
    if (!a()) {}
    for (j = 1;; j = 0)
    {
      a(i, j, 0);
      return;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "pauseDownload:");
    }
    if (!a()) {}
    for (int i = 1;; i = 0)
    {
      a(3, i, 0);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        paramMessage = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
        if (!this.e) {
          continue;
        }
        i = 2131629198;
        Toast.makeText(paramMessage, i, 0).show();
        paramMessage = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime()).getHandler(Conversation.class);
        if ((paramMessage != null) && (a().a() == 4)) {
          paramMessage.obtainMessage(1134019).sendToTarget();
        }
      }
      catch (Throwable paramMessage)
      {
        int i;
        continue;
      }
      return true;
      i = 2131629197;
    }
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadCancel");
    }
    this.b = false;
    h();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.b = false;
    h();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadError: " + paramInt1 + ", " + paramString);
    }
    d(a());
    paramInt2 = paramInt1;
    if (badq.h(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
      paramInt2 = paramInt1 | 0x1;
    }
    paramDownloadInfo = new HashMap();
    paramDownloadInfo.put("param_FailCode", Integer.toString(paramInt2));
    paramDownloadInfo.put("param_ErrMsg", paramString);
    awrn.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeErr", false, 0L, 0L, paramDownloadInfo, "", true);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadFinish");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.b = false;
    Object localObject2 = paramDownloadInfo.l;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (paramDownloadInfo.jdField_c_of_type_Int == 1)
      {
        paramDownloadInfo = bcgo.a().a(paramDownloadInfo);
        localObject1 = localObject2;
        if (paramDownloadInfo != null) {
          localObject1 = paramDownloadInfo.mSavePath;
        }
      }
    }
    localObject2 = a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, (String)localObject1);
    paramDownloadInfo = "";
    int i;
    if (localObject2 != null)
    {
      i = ((PackageInfo)localObject2).versionCode;
      paramDownloadInfo = ((PackageInfo)localObject2).packageName;
    }
    for (;;)
    {
      int k = amom.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      localObject2 = PluginStatic.encodeFile((String)localObject1);
      QLog.i("UpgradeController", 1, "upgradeDownloadFinish md5=" + (String)localObject2);
      if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName().equals(paramDownloadInfo)) && (k > 0) && (i >= k))
      {
        if (localQQAppInterface == null) {
          break;
        }
        d(a());
        localQQAppInterface.getPreferences().edit().putLong("YELLOW_BAR_LAST_SHOW", 0L).putString("upgrade_check_md5", (String)localObject2).commit();
        i();
        h();
        return;
      }
      boolean bool = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean;
      if (bool)
      {
        bcgh.a("_100686848");
        h();
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new HashMap();
        if (i >= k) {
          break label451;
        }
      }
      label451:
      for (i = 101;; i = 9527)
      {
        ((HashMap)localObject1).put("param_FailCode", Integer.toString(i));
        ((HashMap)localObject1).put("param_ErrMsg", "MD5:" + (String)localObject2 + "_PN:" + paramDownloadInfo);
        awrn.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a("", "UpgradeErr", false, 0L, 0L, (HashMap)localObject1, "", true);
        if (bool) {
          break;
        }
        this.jdField_a_of_type_Befq.sendEmptyMessage(0);
        return;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean = false;
        if (!a()) {}
        for (int j = 1;; j = 0)
        {
          a(10, j, 0);
          break;
        }
      }
      i = 0;
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadPause");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ("100686848".equals(localDownloadInfo.jdField_c_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = localDownloadInfo;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "onDownloadUpdate Status:" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a());
      }
      d(a());
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadWait");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgo
 * JD-Core Version:    0.7.0.1
 */