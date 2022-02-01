package mqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.SecureFileFrameworkManager;

public class SecurityFileFrameworkManagerImpl
  implements SecureFileFrameworkManager
{
  private static final long ERROR_CODE_ENCRYPT_FILE_EXIST_WHEN_FIRST_INTO = 6L;
  private static final long ERROR_CODE_FETCH_THIRD_PROCESS_ERROR = 7L;
  private static final long ERROR_CODE_FRAMEWORK_ENABLE_FAIL = 0L;
  private static final long ERROR_CODE_GET_ROOT_FILTER_NULL = 9L;
  private static final long ERROR_CODE_GET_UIN_FILTER_NULL = 10L;
  private static final long ERROR_CODE_RENAME_BUT_UIN_FILE_REMOVED = 4L;
  private static final long ERROR_CODE_RENAME_FAIL = 2L;
  private static final long ERROR_CODE_RENAME_FAIL_TOOL_PROCESS_EXIST = 3L;
  private static final long ERROR_CODE_RENAME_SUCCESS = 1L;
  private static final long ERROR_CODE_RENAME_SUCCESS_BUT_FILE_SUM_NO_MATCH = 11L;
  private static final long ERROR_CODE_RETURN_NULL = 8L;
  private static final long ERROR_CODE_TOKEN_DO_NOT_MATCH = 5L;
  public static final String FILE_KEY_PREFIX = "NoRename#";
  private static final long REQUEST_CODE_SECURITY_FILE_FRAMEWORK = 0L;
  private static String SDCARD_PATH;
  private static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static final String SP_KEY_FILE_KEY = "FILE_KEY";
  private static final String SP_KEY_UIN_IS_FIRST = "UIN_IS_FIRST_";
  public static final String TAG = "SecurityFileFrameworkManagerImpl";
  private static boolean enable = false;
  private static File sRootFile;
  private ConcurrentHashMap<String, File> businessRootFiles = new ConcurrentHashMap();
  private AppRuntime mApp;
  private File mUINRootFile;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_ROOT);
    localStringBuilder.append("/Tencent/MobileQQ/");
    SDCARD_PATH = localStringBuilder.toString();
  }
  
  SecurityFileFrameworkManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    getRootFile();
  }
  
  private static String generalFileKey()
  {
    Object localObject1 = new SecureRandom();
    Object localObject2 = new byte[6];
    ((SecureRandom)localObject1).nextBytes((byte[])localObject2);
    localObject1 = Base64.encodeToString((byte[])localObject2, 11);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(generateVerifyChar((String)localObject1));
    ((StringBuilder)localObject2).append((String)localObject1);
    return ((StringBuilder)localObject2).toString();
  }
  
  private String generateEncryptUIN(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "generateEncryptUIN( deviceToken=", paramString2, "fileKey= ", paramString3, " )" });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    return MD5.toMD5(localStringBuilder.toString());
  }
  
  private File generateOrGetUINFile()
  {
    Object localObject1 = MsfServiceSdk.get().getDeviceToken(this.mApp.getAccount());
    SharedPreferences localSharedPreferences = this.mApp.getApplication().getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    Object localObject3 = localSharedPreferences.getString(this.mApp.getAccount(), null);
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "Current UIN=", this.mApp.getAccount(), "msfDeviceToken=", localObject1, " spDeviceToken=", localObject3 });
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("UIN_IS_FIRST_");
    ((StringBuilder)localObject2).append(this.mApp.getAccount());
    boolean bool1 = localSharedPreferences.getBoolean(((StringBuilder)localObject2).toString(), true);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = this.mApp.getAccount();
      } else {
        localObject2 = localObject3;
      }
    }
    else
    {
      do
      {
        localObject1 = localObject2;
        break;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localSharedPreferences.edit().putString(this.mApp.getAccount(), (String)localObject1).commit();
          bool1 = true;
          break label304;
        }
        localObject2 = localObject1;
      } while (((String)localObject1).equals(localObject3));
      QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "Token Don't Match: msfDeviceToken=", localObject1, " spDeviceToken=", localObject3 });
      localSharedPreferences.edit().putString(this.mApp.getAccount(), (String)localObject1).commit();
      reportToRDM(0L, 5L, null);
      bool1 = false;
    }
    label304:
    localObject2 = this.mApp.getAccount();
    localObject2 = sRootFile.listFiles(new SecurityFileFrameworkManagerImpl.2(this, (String)localObject2));
    localObject3 = generateEncryptUIN(this.mApp.getAccount(), (String)localObject1, sRootFile.getName().replace("NoRename#", ""));
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "sRootFile.listFiles = null");
      reportToRDM(0L, 10L, null);
      localObject1 = new File[0];
    }
    int j = localObject1.length;
    int i = 0;
    boolean bool2 = false;
    boolean bool3 = false;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (((File)localObject2).getName().equals(this.mApp.getAccount())) {
        bool3 = true;
      }
      if (((File)localObject2).getName().equals(localObject3)) {
        bool2 = true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "hasEncryptUinDir=", Boolean.valueOf(bool2), " encryptUIN=", localObject3 });
    }
    if (bool2)
    {
      if (bool1)
      {
        localObject1 = localSharedPreferences.edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("UIN_IS_FIRST_");
        ((StringBuilder)localObject2).append(this.mApp.getAccount());
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), false).commit();
        reportToRDM(0L, 6L, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(sRootFile);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append((String)localObject3);
      return new File(((StringBuilder)localObject1).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "isFirst=", Boolean.valueOf(bool1), " hasUINDir=", Boolean.valueOf(bool3) });
    }
    if (bool1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(sRootFile.getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(this.mApp.getAccount());
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject2 = localSharedPreferences.edit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("UIN_IS_FIRST_");
      ((StringBuilder)localObject3).append(this.mApp.getAccount());
      ((SharedPreferences.Editor)localObject2).putBoolean(((StringBuilder)localObject3).toString(), false).commit();
      return localObject1;
    }
    if (bool3)
    {
      localObject1 = renameAndGetDir((String)localObject3, isContainThirdProcess());
      if (localObject1 != null) {
        return localObject1;
      }
      reportToRDM(0L, 8L, null);
      return null;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(sRootFile.getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append((String)localObject3);
    localObject1 = new File(((StringBuilder)localObject1).toString());
    ((File)localObject1).mkdirs();
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("toFile", ((File)localObject1).getAbsolutePath());
    reportToRDM(0L, 4L, (HashMap)localObject2);
    return localObject1;
  }
  
  public static char generateVerifyChar(String paramString)
  {
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramString[i];
      j += m * m;
      i += 1;
    }
    return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(j % 60);
  }
  
  private File getBusinessRootFile(ISecurityFileHelper paramISecurityFileHelper)
  {
    Object localObject1 = this.businessRootFiles;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mApp.getAccount());
    ((StringBuilder)localObject2).append(paramISecurityFileHelper.declareBusinessFileName());
    if (((ConcurrentHashMap)localObject1).containsKey(((StringBuilder)localObject2).toString()))
    {
      localObject1 = this.businessRootFiles;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mApp.getAccount());
      ((StringBuilder)localObject2).append(paramISecurityFileHelper.declareBusinessFileName());
      return (File)((ConcurrentHashMap)localObject1).get(((StringBuilder)localObject2).toString());
    }
    if (paramISecurityFileHelper.oldBusinessDirExist(this.mApp.getAccount()))
    {
      localObject1 = this.businessRootFiles;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mApp.getAccount());
      ((StringBuilder)localObject2).append(paramISecurityFileHelper.declareBusinessFileName());
      ((ConcurrentHashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramISecurityFileHelper.oldBusinessDir(this.mApp.getAccount()));
      return paramISecurityFileHelper.oldBusinessDir(this.mApp.getAccount());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mUINRootFile.getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(paramISecurityFileHelper.declareBusinessFileName());
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject2 = this.businessRootFiles;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append(paramISecurityFileHelper.declareBusinessFileName());
    ((ConcurrentHashMap)localObject2).put(localStringBuilder.toString(), localObject1);
    return localObject1;
  }
  
  public static File getRootFile()
  {
    try
    {
      if (sRootFile == null)
      {
        enable = initSecureFileFramework(MobileQQ.context);
        if ((!enable) || (sRootFile == null)) {
          sRootFile = new File(SDCARD_PATH);
        }
      }
      File localFile = sRootFile;
      return localFile;
    }
    finally {}
  }
  
  private static boolean initSecureFileFramework(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "context is null");
      return false;
    }
    Object localObject1 = paramContext.getExternalCacheDir();
    if ((localObject1 != null) && (((File)localObject1).getParentFile() != null))
    {
      SDCARD_ROOT = ((File)localObject1).getParentFile().getAbsolutePath();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(SDCARD_ROOT);
      ((StringBuilder)localObject1).append("/Tencent/MobileQQ/");
      SDCARD_PATH = ((StringBuilder)localObject1).toString();
      File localFile = new File(SDCARD_PATH);
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "rootFile create fail, target root path=", localFile.getAbsoluteFile() });
        return false;
      }
      Object localObject2 = paramContext.getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
      paramContext = ((SharedPreferences)localObject2).getString("FILE_KEY", "");
      if (TextUtils.isEmpty(paramContext))
      {
        localObject1 = localFile.listFiles(new SecurityFileFrameworkManagerImpl.1());
        paramContext = (Context)localObject1;
        if (localObject1 == null)
        {
          paramContext = new File[0];
          QLog.d("SecurityFileFrameworkManagerImpl", 1, "rootFile.listFiles = null");
        }
        if (paramContext.length > 1)
        {
          int j = paramContext.length;
          long l1 = 9223372036854775807L;
          localObject1 = null;
          int i = 0;
          while (i < j)
          {
            localFile = paramContext[i];
            long l2 = l1;
            if (localFile.lastModified() < l1)
            {
              l2 = localFile.lastModified();
              localObject1 = localFile;
            }
            i += 1;
            l1 = l2;
          }
          i = paramContext.length;
          boolean bool;
          if (localObject1 == null) {
            bool = true;
          } else {
            bool = false;
          }
          QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "initSecureFileFramework: fileKeyFiles.length=", Integer.valueOf(i), "firstCreateFile=", Boolean.valueOf(bool) });
          if (localObject1 == null) {
            return false;
          }
          paramContext = ((File)localObject1).getName().replaceAll("NoRename#", "");
          ((SharedPreferences)localObject2).edit().putString("FILE_KEY", paramContext).commit();
          sRootFile = (File)localObject1;
          return true;
        }
        if (paramContext.length == 0)
        {
          paramContext = generalFileKey();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append("NoRename#");
          ((StringBuilder)localObject1).append(paramContext);
          localObject1 = new File(((StringBuilder)localObject1).toString());
          if (((File)localObject1).mkdirs())
          {
            ((SharedPreferences)localObject2).edit().putString("FILE_KEY", paramContext).commit();
            sRootFile = (File)localObject1;
            return true;
          }
          QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir create fail, path=", ((File)localObject1).getAbsoluteFile() });
          return false;
        }
        localObject1 = paramContext[0].getName().replaceAll("NoRename#", "");
        ((SharedPreferences)localObject2).edit().putString("FILE_KEY", (String)localObject1).commit();
        sRootFile = paramContext[0];
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("NoRename#");
      ((StringBuilder)localObject1).append(paramContext);
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (((File)localObject1).exists())
      {
        if (!((File)localObject1).isDirectory())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("NoRename#");
          ((StringBuilder)localObject2).append(paramContext);
          ((StringBuilder)localObject2).append("_bak");
          if (((File)localObject1).renameTo(new File(((StringBuilder)localObject2).toString())))
          {
            QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir been occupied，rename file：", ((File)localObject1).getAbsoluteFile() });
            if (((File)localObject1).mkdirs())
            {
              sRootFile = (File)localObject1;
              return true;
            }
            QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir been occupied，create dir fail, path=", ((File)localObject1).getAbsoluteFile() });
            return false;
          }
          QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir been occupied，rename file fail, can't create new file, path=", ((File)localObject1).getAbsoluteFile() });
          return false;
        }
        sRootFile = (File)localObject1;
        return true;
      }
      if (((File)localObject1).mkdirs())
      {
        sRootFile = (File)localObject1;
        return true;
      }
      QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "FileKey exist, File no exist, dir create fail, path=", ((File)localObject1).getAbsoluteFile() });
      return false;
    }
    QLog.d("SecurityFileFrameworkManagerImpl", 1, "externalCacheDir is null");
    return false;
  }
  
  private boolean isContainThirdProcess()
  {
    try
    {
      Object localObject = (ActivityManager)this.mApp.getApplication().getSystemService("activity");
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          boolean bool = "com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, localException.toString());
      reportToRDM(0L, 7L, null);
    }
  }
  
  private File renameAndGetDir(String paramString, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(sRootFile.getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(this.mApp.getAccount());
    localObject1 = new File(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(sRootFile.getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(paramString);
    paramString = new File(((StringBuilder)localObject2).toString());
    if (((File)localObject1).exists())
    {
      if (!paramBoolean)
      {
        localObject2 = ((File)localObject1).list();
        long l2 = -1L;
        long l1;
        if (localObject2 != null) {
          l1 = localObject2.length;
        } else {
          l1 = -1L;
        }
        if (((File)localObject1).renameTo(paramString))
        {
          localObject1 = paramString.list();
          if (localObject1 != null) {
            l2 = localObject1.length;
          }
          localObject1 = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(l1);
          ((HashMap)localObject1).put("fileSumBeforeRename", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(l2);
          ((HashMap)localObject1).put("fileSumAfterRename", ((StringBuilder)localObject2).toString());
          if (l1 == l2)
          {
            reportToRDM(0L, 1L, (HashMap)localObject1);
            return paramString;
          }
          reportToRDM(0L, 11L, (HashMap)localObject1);
          return paramString;
        }
        paramString = new HashMap();
        paramString.put("tempFilePath", ((File)localObject1).getAbsolutePath());
        reportToRDM(0L, 2L, paramString);
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "hasUINDir & rename fail return=", ((File)localObject1).getAbsolutePath() });
        return localObject1;
      }
      paramString = new HashMap();
      paramString.put("tempFilePath", ((File)localObject1).getAbsolutePath());
      reportToRDM(0L, 3L, paramString);
      QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "containThirdProcess return=", ((File)localObject1).getAbsolutePath() });
      return localObject1;
    }
    return null;
  }
  
  private void reportToRDM(long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    for (;;)
    {
      HashMap localHashMap;
      try
      {
        if (this.mApp.getAccount() == null) {
          localObject = "NoLogin";
        } else {
          localObject = this.mApp.getAccount();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramHashMap == null)
        {
          paramHashMap = new HashMap();
        }
        else
        {
          localHashMap = new HashMap(paramHashMap);
          Iterator localIterator = paramHashMap.keySet().iterator();
          if (!localIterator.hasNext()) {
            break label406;
          }
          String str = (String)localIterator.next();
          localStringBuilder.append(str);
          localStringBuilder.append("#");
          localStringBuilder.append((String)paramHashMap.get(str));
          localStringBuilder.append("|");
          continue;
        }
        paramHashMap.put("uin", localObject);
        paramHashMap.put("isLogin", String.valueOf(this.mApp.isLogin()));
        paramHashMap.put("isRunning", String.valueOf(this.mApp.isRunning()));
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append("");
        paramHashMap.put("fromCode", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramLong2);
        ((StringBuilder)localObject).append("");
        paramHashMap.put("errorCode", ((StringBuilder)localObject).toString());
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "reportToRDM{ fromCode=", Long.valueOf(paramLong1), " errorCode=", Long.valueOf(paramLong2), " additionParams=", localStringBuilder.toString(), "}" });
        localObject = new RdmReq();
        ((RdmReq)localObject).eventName = "SecureFile";
        ((RdmReq)localObject).elapse = 0L;
        ((RdmReq)localObject).size = 0L;
        ((RdmReq)localObject).isSucceed = true;
        ((RdmReq)localObject).isRealTime = false;
        ((RdmReq)localObject).params = paramHashMap;
        paramHashMap = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), (RdmReq)localObject);
        paramHashMap.setNeedCallback(false);
        MsfServiceSdk.get().sendMsg(paramHashMap);
        return;
      }
      catch (Throwable paramHashMap)
      {
        return;
      }
      label406:
      paramHashMap = localHashMap;
    }
  }
  
  public String getEncryptUIN()
  {
    return this.mUINRootFile.getName();
  }
  
  @Nullable
  public File getUINRootFile(@Nullable ISecurityFileHelper paramISecurityFileHelper)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecurityFileFrameworkManagerImpl", 2, "call getUINRootFile");
      }
      if (this.mApp.getAccount() == null)
      {
        QLog.d("SecurityFileFrameworkManagerImpl", 1, "getAccount==null");
        if (!MainService.isDebugVersion) {
          return null;
        }
        throw new RuntimeException("mApp.getAccount() == null, you need call it later");
      }
      if (!this.mApp.getApplication().getQQProcessName().equals("com.tencent.mobileqq"))
      {
        QLog.d("SecurityFileFrameworkManagerImpl", 1, "only call in main process");
        if (!MainService.isDebugVersion) {
          return null;
        }
        throw new RuntimeException("method 'getUINRootFile' can only call in main process");
      }
      if (this.mUINRootFile != null)
      {
        if (paramISecurityFileHelper == null)
        {
          paramISecurityFileHelper = this.mUINRootFile;
          return paramISecurityFileHelper;
        }
        paramISecurityFileHelper = getBusinessRootFile(paramISecurityFileHelper);
        return paramISecurityFileHelper;
      }
      if (!enable)
      {
        QLog.d("SecurityFileFrameworkManagerImpl", 1, "getUINRootFile Enable = false");
        reportToRDM(0L, 0L, null);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(sRootFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.mApp.getAccount());
        this.mUINRootFile = new File(localStringBuilder.toString());
        if (!this.mUINRootFile.mkdirs())
        {
          QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "getUINRootFile Enable = false, mkdirs = false, mUINRootFile=", this.mUINRootFile.getAbsolutePath() });
          this.mUINRootFile = sRootFile;
        }
      }
      else
      {
        this.mUINRootFile = generateOrGetUINFile();
      }
      if (paramISecurityFileHelper == null)
      {
        paramISecurityFileHelper = this.mUINRootFile;
        return paramISecurityFileHelper;
      }
      paramISecurityFileHelper = getBusinessRootFile(paramISecurityFileHelper);
      return paramISecurityFileHelper;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (this.mApp != null) {
      this.mApp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.SecurityFileFrameworkManagerImpl
 * JD-Core Version:    0.7.0.1
 */