package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class TbsPVConfig
  extends TbsBaseConfig
{
  private static TbsPVConfig b;
  public SharedPreferences mPreferences;
  
  public static TbsPVConfig getInstance(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        TbsPVConfig localTbsPVConfig = new TbsPVConfig();
        b = localTbsPVConfig;
        localTbsPVConfig.init(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static void releaseInstance()
  {
    try
    {
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getConfigFileName()
  {
    return "tbs_pv_config";
  }
  
  /* Error */
  public int getDisabledCoreVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   6: ldc 39
    //   8: invokeinterface 45 2 0
    //   13: checkcast 47	java/lang/String
    //   16: invokestatic 53	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: astore_2
    //   25: iconst_0
    //   26: istore_1
    //   27: goto -7 -> 20
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	TbsPVConfig
    //   19	8	1	i	int
    //   24	1	2	localException	java.lang.Exception
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	24	java/lang/Exception
    //   2	20	30	finally
  }
  
  /* Error */
  public int getEmergentCoreVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   6: ldc 56
    //   8: invokeinterface 45 2 0
    //   13: checkcast 47	java/lang/String
    //   16: invokestatic 53	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: astore_2
    //   25: iconst_0
    //   26: istore_1
    //   27: goto -7 -> 20
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	TbsPVConfig
    //   19	8	1	i	int
    //   24	1	2	localException	java.lang.Exception
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	24	java/lang/Exception
    //   2	20	30	finally
  }
  
  public void putData(String paramString1, String paramString2)
  {
    try
    {
      this.a.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsPVConfig
 * JD-Core Version:    0.7.0.1
 */