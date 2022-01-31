import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.mobileqq.ark.ArkAppCenterEvent;
import com.tencent.qphone.base.util.QLog;

final class afij
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
    anrm.a(paramApplication);
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
        break label280;
      }
      bool1 = true;
      boolean bool3 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramApplication);
      boolean bool4 = anob.a();
      if ((!bool3) || (bool4)) {
        break label286;
      }
      bool2 = true;
      label69:
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppContainer", 2, new Object[] { "ArkSafe.UrlCheck.CheckUrlLegalityCallback,appname=", paramApplication, ", enableCheck=", Boolean.valueOf(bool2), ", appEnableCheck=", Boolean.valueOf(bool3), ", isPublicAccount=", Boolean.valueOf(bool4) });
      }
      if (bool1) {
        break label292;
      }
      i = 1;
      if (bool2) {
        break label292;
      }
      QLog.e("ArkApp.ArkAppContainer", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.EngineCallback , isValid set=true, appName=", paramApplication, ",appEnableCheck=", Boolean.valueOf(bool3), ", isPublicAccount=", Boolean.valueOf(bool4), ",url=", ndq.b(paramString, new String[0]) });
      bool1 = true;
      i = 2;
    }
    label280:
    label286:
    label292:
    for (;;)
    {
      anrm.a(paramApplication, paramString, j, i, afii.c);
      QLog.e("ArkApp.ArkAppContainer", 1, new Object[] { "ArkSafe.EngineCallback appName=", paramApplication, ",url=", ndq.b(paramString, new String[0]), ", isValid=", Boolean.valueOf(bool1) });
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
        anoe.a(null, paramString1, "ScriptError", 0, 0, 0L, 0L, 0L, paramString2, "");
        return;
      }
    }
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    anjy.a(paramModuleRegister, paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afij
 * JD-Core Version:    0.7.0.1
 */