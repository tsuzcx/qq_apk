package com.tencent.recovery.option;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.recovery.ConstantsRecovery.DefaultProcessOptions;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.util.Util;

public class OptionFactory
{
  private static IOptionsCreator wLd;
  
  public static ProcessOptions dS(String paramString, int paramInt)
  {
    ProcessOptions localProcessOptions = null;
    if (wLd != null) {
      localProcessOptions = wLd.createProcessOptions(paramString, paramInt);
    }
    paramString = localProcessOptions;
    if (localProcessOptions == null)
    {
      RecoveryLog.i("Recovery.OptionFactory", "not found custom process options, use default %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1) {
        paramString = ConstantsRecovery.DefaultProcessOptions.wKy;
      }
    }
    else
    {
      return paramString;
    }
    return ConstantsRecovery.DefaultProcessOptions.wKw;
  }
  
  public static CommonOptions hq(Context paramContext)
  {
    Object localObject1 = null;
    if (wLd != null) {
      localObject1 = wLd.createCommonOptions(paramContext);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      RecoveryLog.i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
      localObject1 = new CommonOptions.Builder();
      ((CommonOptions.Builder)localObject1).wKU = "";
      ((CommonOptions.Builder)localObject1).wLa = false;
      ((CommonOptions.Builder)localObject1).dCX = String.valueOf(Util.hs(paramContext));
    }
    try
    {
      ((CommonOptions.Builder)localObject1).clientVersion = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      label84:
      ((CommonOptions.Builder)localObject1).wLb = 600000L;
      ((CommonOptions.Builder)localObject1).wLc = 600000L;
      localObject2 = ((CommonOptions.Builder)localObject1).cOD();
      return localObject2;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.option.OptionFactory
 * JD-Core Version:    0.7.0.1
 */