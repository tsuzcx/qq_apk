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
  private static final String TAG = "Recovery.OptionFactory";
  private static IOptionsCreator creator;
  
  public static CommonOptions getCommonOptions(Context paramContext)
  {
    Object localObject1 = null;
    if (creator != null) {
      localObject1 = creator.createCommonOptions(paramContext);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      RecoveryLog.i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
      localObject1 = new CommonOptions.Builder();
      ((CommonOptions.Builder)localObject1).setConfigUrl("");
      ((CommonOptions.Builder)localObject1).setDebugMode(false);
      ((CommonOptions.Builder)localObject1).setUUID(String.valueOf(Util.getUUID(paramContext)));
    }
    try
    {
      ((CommonOptions.Builder)localObject1).setClientVersion(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      label84:
      ((CommonOptions.Builder)localObject1).setUploadInterval(600000L);
      ((CommonOptions.Builder)localObject1).setHandleRetryInterval(600000L);
      localObject2 = ((CommonOptions.Builder)localObject1).build();
      return localObject2;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label84;
    }
  }
  
  private static IOptionsCreator getCreator(String paramString)
  {
    try
    {
      paramString = Class.forName(String.format(paramString, new Object[0]));
      if (paramString == null) {}
    }
    catch (ClassNotFoundException paramString)
    {
      IOptionsCreator localIOptionsCreator2;
      for (;;)
      {
        try
        {
          IOptionsCreator localIOptionsCreator1 = (IOptionsCreator)paramString.newInstance();
          if (localIOptionsCreator1 == null) {
            break;
          }
          RecoveryLog.i("Recovery.OptionFactory", "getCreator %s success %s", new Object[] { paramString.getName(), localIOptionsCreator1.toString() });
          return localIOptionsCreator1;
        }
        catch (Exception localException) {}
        paramString = paramString;
        paramString = null;
        continue;
        localIOptionsCreator2 = null;
      }
      RecoveryLog.i("Recovery.OptionFactory", "getCreator fail", new Object[0]);
      return localIOptionsCreator2;
    }
  }
  
  public static ProcessOptions getProcessOptions(String paramString, int paramInt)
  {
    ProcessOptions localProcessOptions = null;
    if (creator != null) {
      localProcessOptions = creator.createProcessOptions(paramString, paramInt);
    }
    paramString = localProcessOptions;
    if (localProcessOptions == null)
    {
      RecoveryLog.i("Recovery.OptionFactory", "not found custom process options, use default %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1) {
        paramString = ConstantsRecovery.DefaultProcessOptions.ForegroundCrash;
      }
    }
    else
    {
      return paramString;
    }
    return ConstantsRecovery.DefaultProcessOptions.Background;
  }
  
  public static void initOptionCreator(String paramString)
  {
    creator = getCreator(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.option.OptionFactory
 * JD-Core Version:    0.7.0.1
 */