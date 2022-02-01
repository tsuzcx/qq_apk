package com.tencent.xweb.x5.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class g
{
  private static b ainE;
  
  static
  {
    AppMethodBeat.i(157157);
    XWalkEnvironment.initInterface();
    AppMethodBeat.o(157157);
  }
  
  public static void a(b paramb)
  {
    ainE = paramb;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(213139);
    if (ainE != null)
    {
      paramBoolean = ainE.a(paramContext, paramBoolean, parama);
      AppMethodBeat.o(213139);
      return paramBoolean;
    }
    Log.e("TbsDownloader", "needDownload: sImp is null");
    AppMethodBeat.o(213139);
    return false;
  }
  
  public static boolean isDownloadForeground()
  {
    AppMethodBeat.i(157156);
    if (ainE != null)
    {
      boolean bool = ainE.isDownloadForeground();
      AppMethodBeat.o(157156);
      return bool;
    }
    Log.e("TbsDownloader", "isDownloadForeground: sImp is null");
    AppMethodBeat.o(157156);
    return false;
  }
  
  /* Error */
  public static boolean isDownloading()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 55
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 30	com/tencent/xweb/x5/a/g:ainE	Lcom/tencent/xweb/x5/a/b;
    //   11: ifnull +22 -> 33
    //   14: getstatic 30	com/tencent/xweb/x5/a/g:ainE	Lcom/tencent/xweb/x5/a/b;
    //   17: invokeinterface 57 1 0
    //   22: istore_0
    //   23: ldc 55
    //   25: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload_0
    //   32: ireturn
    //   33: ldc 38
    //   35: ldc 59
    //   37: invokestatic 46	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: iconst_0
    //   41: istore_0
    //   42: ldc 55
    //   44: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -19 -> 28
    //   50: astore_1
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	20	0	bool	boolean
    //   50	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	28	50	finally
    //   33	40	50	finally
    //   42	47	50	finally
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(157150);
    paramBoolean = a(paramContext, paramBoolean, null);
    AppMethodBeat.o(157150);
    return paramBoolean;
  }
  
  public static boolean oZ(Context paramContext)
  {
    AppMethodBeat.i(157149);
    if (ainE != null)
    {
      boolean bool = ainE.oZ(paramContext);
      AppMethodBeat.o(157149);
      return bool;
    }
    Log.e("TbsDownloader", "needSendRequest: sImp is null");
    AppMethodBeat.o(157149);
    return false;
  }
  
  /* Error */
  private static void pa(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 73
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 30	com/tencent/xweb/x5/a/g:ainE	Lcom/tencent/xweb/x5/a/b;
    //   11: ifnull +21 -> 32
    //   14: getstatic 30	com/tencent/xweb/x5/a/g:ainE	Lcom/tencent/xweb/x5/a/b;
    //   17: aload_0
    //   18: invokeinterface 75 2 0
    //   23: ldc 73
    //   25: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: ldc 38
    //   34: ldc 77
    //   36: invokestatic 46	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc 73
    //   41: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -16 -> 28
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	28	47	finally
    //   32	44	47	finally
  }
  
  public static void startDownload(Context paramContext)
  {
    AppMethodBeat.i(157152);
    pa(paramContext);
    AppMethodBeat.o(157152);
  }
  
  public static void stopDownload()
  {
    AppMethodBeat.i(157154);
    if (ainE != null)
    {
      ainE.stopDownload();
      AppMethodBeat.o(157154);
      return;
    }
    Log.e("TbsDownloader", "stopDownload: sImp is null");
    AppMethodBeat.o(157154);
  }
  
  public static abstract interface a
  {
    public abstract void onNeedDownloadFinish(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.a.g
 * JD-Core Version:    0.7.0.1
 */