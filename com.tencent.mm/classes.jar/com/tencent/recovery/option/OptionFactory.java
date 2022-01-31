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
  private static IOptionsCreator BiC;
  
  public static ProcessOptions fc(String paramString, int paramInt)
  {
    ProcessOptions localProcessOptions = null;
    if (BiC != null) {
      localProcessOptions = BiC.createProcessOptions(paramString, paramInt);
    }
    paramString = localProcessOptions;
    if (localProcessOptions == null)
    {
      RecoveryLog.i("Recovery.OptionFactory", "not found custom process options, use default %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1) {
        paramString = ConstantsRecovery.DefaultProcessOptions.BhZ;
      }
    }
    else
    {
      return paramString;
    }
    return ConstantsRecovery.DefaultProcessOptions.BhX;
  }
  
  public static CommonOptions iR(Context paramContext)
  {
    Object localObject1 = null;
    if (BiC != null) {
      localObject1 = BiC.createCommonOptions(paramContext);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      RecoveryLog.i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
      localObject1 = new CommonOptions.Builder();
      ((CommonOptions.Builder)localObject1).Biu = "";
      ((CommonOptions.Builder)localObject1).Biz = false;
      ((CommonOptions.Builder)localObject1).eAx = String.valueOf(Util.iT(paramContext));
    }
    try
    {
      ((CommonOptions.Builder)localObject1).clientVersion = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      label84:
      ((CommonOptions.Builder)localObject1).BiA = 600000L;
      ((CommonOptions.Builder)localObject1).BiB = 600000L;
      localObject2 = ((CommonOptions.Builder)localObject1).dUs();
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