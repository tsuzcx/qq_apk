package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
      AppMethodBeat.i(54664);
      if (b == null)
      {
        TbsPVConfig localTbsPVConfig = new TbsPVConfig();
        b = localTbsPVConfig;
        localTbsPVConfig.init(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(54664);
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
    //   2: ldc 44
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 48	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   11: ldc 50
    //   13: invokeinterface 56 2 0
    //   18: checkcast 58	java/lang/String
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +18 -> 44
    //   29: aload_2
    //   30: invokestatic 70	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   33: istore_1
    //   34: ldc 44
    //   36: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: astore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: goto -12 -> 34
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	TbsPVConfig
    //   33	13	1	i	int
    //   21	9	2	str	String
    //   43	1	2	localException	Exception
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	34	43	java/lang/Exception
    //   2	7	49	finally
    //   7	34	49	finally
    //   34	39	49	finally
  }
  
  /* Error */
  public int getEmergentCoreVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 72
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 48	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   11: ldc 74
    //   13: invokeinterface 56 2 0
    //   18: checkcast 58	java/lang/String
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +18 -> 44
    //   29: aload_2
    //   30: invokestatic 70	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   33: istore_1
    //   34: ldc 72
    //   36: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: astore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: goto -12 -> 34
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	TbsPVConfig
    //   33	13	1	i	int
    //   21	9	2	str	String
    //   43	1	2	localException	Exception
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	34	43	java/lang/Exception
    //   2	7	49	finally
    //   7	34	49	finally
    //   34	39	49	finally
  }
  
  /* Error */
  public int getLocalCoreVersionMoreTimes()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 76
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 48	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   11: ldc 78
    //   13: invokeinterface 56 2 0
    //   18: checkcast 58	java/lang/String
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +18 -> 44
    //   29: aload_2
    //   30: invokestatic 70	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   33: istore_1
    //   34: ldc 76
    //   36: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: astore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: goto -12 -> 34
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	TbsPVConfig
    //   33	13	1	i	int
    //   21	9	2	str	String
    //   43	1	2	localException	Exception
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	34	43	java/lang/Exception
    //   2	7	49	finally
    //   7	34	49	finally
    //   34	39	49	finally
  }
  
  /* Error */
  public int getReadApk()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 80
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 48	com/tencent/smtt/sdk/TbsPVConfig:a	Ljava/util/Map;
    //   11: ldc 82
    //   13: invokeinterface 56 2 0
    //   18: checkcast 58	java/lang/String
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +18 -> 44
    //   29: aload_2
    //   30: invokestatic 70	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   33: istore_1
    //   34: ldc 80
    //   36: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: astore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: goto -12 -> 34
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	TbsPVConfig
    //   33	13	1	i	int
    //   21	9	2	str	String
    //   43	1	2	localException	Exception
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	34	43	java/lang/Exception
    //   2	7	49	finally
    //   7	34	49	finally
    //   34	39	49	finally
  }
  
  public boolean getTbsCoreSandboxModeEnable()
  {
    label43:
    try
    {
      AppMethodBeat.i(54670);
      try
      {
        bool = "true".equals((String)this.a.get("tbs_core_sandbox_mode_enable"));
        if (!bool) {
          break label43;
        }
        bool = true;
        AppMethodBeat.o(54670);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
          AppMethodBeat.o(54670);
        }
      }
      return bool;
    }
    finally {}
  }
  
  public boolean isDisableHostBackupCore()
  {
    label52:
    try
    {
      AppMethodBeat.i(54671);
      try
      {
        String str = (String)this.a.get("disable_host_backup");
        if (TextUtils.isEmpty(str)) {
          break label52;
        }
        bool = str.equals("true");
        if (!bool) {
          break label52;
        }
        bool = true;
        AppMethodBeat.o(54671);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
          AppMethodBeat.o(54671);
        }
      }
      return bool;
    }
    finally {}
  }
  
  public boolean isDisableTbsOneGrey()
  {
    label52:
    try
    {
      AppMethodBeat.i(54672);
      try
      {
        String str = (String)this.a.get("disable_tbs_one_grey");
        if (TextUtils.isEmpty(str)) {
          break label52;
        }
        bool = str.equals("true");
        if (!bool) {
          break label52;
        }
        bool = true;
        AppMethodBeat.o(54672);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
          AppMethodBeat.o(54672);
        }
      }
      return bool;
    }
    finally {}
  }
  
  public boolean isEnableNoCoreGray()
  {
    label52:
    try
    {
      AppMethodBeat.i(54669);
      try
      {
        String str = (String)this.a.get("enable_no_share_gray");
        if (TextUtils.isEmpty(str)) {
          break label52;
        }
        bool = str.equals("true");
        if (!bool) {
          break label52;
        }
        bool = true;
        AppMethodBeat.o(54669);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
          AppMethodBeat.o(54669);
        }
      }
      return bool;
    }
    finally {}
  }
  
  public void putData(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(54673);
      this.a.put(paramString1, paramString2);
      AppMethodBeat.o(54673);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsPVConfig
 * JD-Core Version:    0.7.0.1
 */