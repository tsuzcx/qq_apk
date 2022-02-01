import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.mobileqq.ark.ArkAppCenterEvent;
import com.tencent.qphone.base.util.QLog;

final class agyx
  implements ark.ApplicationCallback
{
  public void AppCreate(ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(0, paramApplication.GetSpecific("appName"), null);
  }
  
  public void AppDestroy(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppCenterEvent.a(1, paramApplication, null);
    aqfh.a(paramApplication);
  }
  
  public boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppUrlChecker localArkAppUrlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(paramApplication);
    boolean bool1 = true;
    int j;
    int i;
    boolean bool2;
    if (localArkAppUrlChecker != null)
    {
      j = localArkAppUrlChecker.checkUrlIsValidByAppResouceList(paramString);
      i = 0;
      if (j != 0) {
        break label289;
      }
      bool1 = true;
      boolean bool3 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramApplication);
      boolean bool4 = aqbx.a();
      if ((!bool3) || (bool4)) {
        break label295;
      }
      bool2 = true;
      label69:
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppContainer", 2, new Object[] { "ArkSafe.UrlCheck.CheckUrlLegalityCallback,appname=", paramApplication, ", enableCheck=", Boolean.valueOf(bool2), ", appEnableCheck=", Boolean.valueOf(bool3), ", isPublicAccount=", Boolean.valueOf(bool4) });
      }
      if (bool1) {
        break label301;
      }
      i = 1;
      if (bool2) {
        break label301;
      }
      QLog.e("ArkApp.ArkAppContainer", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.EngineCallback , isValid set=true, appName=", paramApplication, ",appEnableCheck=", Boolean.valueOf(bool3), ", isPublicAccount=", Boolean.valueOf(bool4), ",url=", noe.b(paramString, new String[0]) });
      bool1 = true;
      i = 2;
    }
    label289:
    label295:
    label301:
    for (;;)
    {
      aqfh.a(paramApplication, paramString, j, i, agyw.c);
      aqca.b(agyw.a(), paramApplication, paramString, 1);
      QLog.e("ArkApp.ArkAppContainer", 1, new Object[] { "ArkSafe.EngineCallback appName=", paramApplication, ",url=", noe.b(paramString, new String[0]), ", isValid=", Boolean.valueOf(bool1) });
      return bool1;
      bool1 = false;
      break;
      bool2 = false;
      break label69;
    }
  }
  
  public void OutputScriptError(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAppContainer", 1, String.format("%s.script error: %s", new Object[] { paramString1, paramString2 }));
        }
        aqca.a(null, paramString1, "ScriptError", 0, 0, 0L, 0L, 0L, paramString2, "");
        return;
      }
    }
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    apwe.a(paramModuleRegister, paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyx
 * JD-Core Version:    0.7.0.1
 */