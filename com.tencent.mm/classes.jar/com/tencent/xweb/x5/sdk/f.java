package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ac;
import org.xwalk.core.Log;

public final class f
{
  static b BIB;
  
  static
  {
    AppMethodBeat.i(4158);
    ac.initInterface();
    AppMethodBeat.o(4158);
  }
  
  public static void a(b paramb)
  {
    BIB = paramb;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    AppMethodBeat.i(4152);
    if (BIB != null)
    {
      paramBoolean1 = BIB.a(paramContext, paramBoolean1, paramBoolean2, parama);
      AppMethodBeat.o(4152);
      return paramBoolean1;
    }
    Log.e("TbsDownloader", "needDownload: sImp is null");
    AppMethodBeat.o(4152);
    return false;
  }
  
  public static boolean isDownloadForeground()
  {
    AppMethodBeat.i(4157);
    if (BIB != null)
    {
      boolean bool = BIB.isDownloadForeground();
      AppMethodBeat.o(4157);
      return bool;
    }
    Log.e("TbsDownloader", "isDownloadForeground: sImp is null");
    AppMethodBeat.o(4157);
    return false;
  }
  
  /* Error */
  public static boolean isDownloading()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 4156
    //   6: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 29	com/tencent/xweb/x5/sdk/f:BIB	Lcom/tencent/xweb/x5/sdk/b;
    //   12: ifnull +23 -> 35
    //   15: getstatic 29	com/tencent/xweb/x5/sdk/f:BIB	Lcom/tencent/xweb/x5/sdk/b;
    //   18: invokeinterface 53 1 0
    //   23: istore_0
    //   24: sipush 4156
    //   27: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload_0
    //   34: ireturn
    //   35: ldc 36
    //   37: ldc 55
    //   39: invokestatic 44	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: iconst_0
    //   43: istore_0
    //   44: sipush 4156
    //   47: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: goto -20 -> 30
    //   53: astore_1
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	21	0	bool	boolean
    //   53	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	30	53	finally
    //   35	42	53	finally
    //   44	50	53	finally
  }
  
  public static boolean jU(Context paramContext)
  {
    AppMethodBeat.i(4150);
    if (BIB != null)
    {
      boolean bool = BIB.jU(paramContext);
      AppMethodBeat.o(4150);
      return bool;
    }
    Log.e("TbsDownloader", "needSendRequest: sImp is null");
    AppMethodBeat.o(4150);
    return false;
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(4151);
    paramBoolean = a(paramContext, paramBoolean, false, null);
    AppMethodBeat.o(4151);
    return paramBoolean;
  }
  
  public static void startDownload(Context paramContext)
  {
    AppMethodBeat.i(4153);
    startDownload(paramContext, false);
    AppMethodBeat.o(4153);
  }
  
  /* Error */
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 4154
    //   6: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 29	com/tencent/xweb/x5/sdk/f:BIB	Lcom/tencent/xweb/x5/sdk/b;
    //   12: ifnull +23 -> 35
    //   15: getstatic 29	com/tencent/xweb/x5/sdk/f:BIB	Lcom/tencent/xweb/x5/sdk/b;
    //   18: aload_0
    //   19: iload_1
    //   20: invokeinterface 70 3 0
    //   25: sipush 4154
    //   28: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: return
    //   35: ldc 36
    //   37: ldc 72
    //   39: invokestatic 44	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: sipush 4154
    //   45: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -17 -> 31
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   0	57	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	31	51	finally
    //   35	48	51	finally
  }
  
  public static void stopDownload()
  {
    AppMethodBeat.i(4155);
    if (BIB != null)
    {
      BIB.stopDownload();
      AppMethodBeat.o(4155);
      return;
    }
    Log.e("TbsDownloader", "stopDownload: sImp is null");
    AppMethodBeat.o(4155);
  }
  
  public static abstract interface a
  {
    public abstract void onNeedDownloadFinish(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.f
 * JD-Core Version:    0.7.0.1
 */