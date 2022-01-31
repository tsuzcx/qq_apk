import android.util.DisplayMetrics;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class alhf
{
  protected static final ark.ApplicationCallback a = new alhq();
  
  public static void a()
  {
    Object localObject2 = aler.a().a();
    String str1 = aler.a().b();
    String str2 = "";
    Object localObject1;
    if (1 != BaseApplicationImpl.sProcessId)
    {
      String str3 = MobileQQ.getMobileQQ().getQQProcessName();
      localObject1 = str2;
      if (str3 != null)
      {
        int i = str3.lastIndexOf(':');
        localObject1 = str2;
        if (i > -1) {
          localObject1 = "_" + str3.substring(i + 1);
        }
      }
      str2 = (String)localObject2 + (String)localObject1;
      str1 = str1 + (String)localObject1;
      localObject2 = localObject1;
      localObject1 = str2;
    }
    for (;;)
    {
      ArkDelegateManager.getInstance().init((String)localObject1, str1, (String)localObject2, "8.2.6", BaseApplicationImpl.getContext());
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      ArkEnvironmentManager.getInstance().setCurrentUin(((AppRuntime)localObject1).getAccount());
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (aler.a() != null)
      {
        bool1 = bool2;
        if (aler.a().a() == 1) {
          bool1 = true;
        }
      }
      ArkEnvironmentManager.getInstance().setEnv(bool1);
      ArkDelegateManager.getInstance().setSetupDelegate(new alhk());
      ArkDelegateManager.getInstance().setNetDelegate(new alhl());
      ArkDelegateManager.getInstance().setInputCallback(new alhr(null));
      ArkDelegateManager.getInstance().setApplicationCallback(a);
      return;
      str2 = "";
      localObject1 = localObject2;
      localObject2 = str2;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject1 = ArkEnvironmentManager.getInstance();
    if (!ArkAppCenter.a) {}
    try
    {
      if (!ArkAppCenter.a)
      {
        ((ArkEnvironmentManager)localObject1).setThreadCreator(new alhg());
        ((ArkEnvironmentManager)localObject1).setLogCallback(new alhh());
        ((ArkEnvironmentManager)localObject1).setLibraryLoader(new alhi());
        ((ArkEnvironmentManager)localObject1).setDebugFlag(false);
        ((ArkEnvironmentManager)localObject1).setProfilingLogFlag(true);
        ((ArkEnvironmentManager)localObject1).setDataReport(new alhj());
        ArkAppCenter.a = true;
      }
      if ((paramBoolean) && (!ArkAppCenter.b))
      {
        ((ArkEnvironmentManager)localObject1).loadLibrary();
        if (ArkAppCenter.b)
        {
          if (BaseApplicationImpl.getContext() != null)
          {
            localObject1 = alem.a;
            ark.arkSetScreenSize(((DisplayMetrics)localObject1).widthPixels / ((DisplayMetrics)localObject1).density, ((DisplayMetrics)localObject1).heightPixels / ((DisplayMetrics)localObject1).density);
          }
          ArkEnvironmentManager.getInstance().setSingleThreadMode(true);
          ArkEnvironmentManager.getInstance().setThreadMode();
          QLog.i("ArkApp.ArkMultiProcUtil", 1, "setupArkEnvironment, https=true, multithreads=true");
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alhf
 * JD-Core Version:    0.7.0.1
 */