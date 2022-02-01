package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.aj;
import org.xwalk.core.Log;

public final class f
{
  static b Mvz;
  
  static
  {
    AppMethodBeat.i(157157);
    aj.initInterface();
    AppMethodBeat.o(157157);
  }
  
  public static void a(b paramb)
  {
    Mvz = paramb;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    AppMethodBeat.i(157151);
    if (Mvz != null)
    {
      paramBoolean1 = Mvz.a(paramContext, paramBoolean1, paramBoolean2, parama);
      AppMethodBeat.o(157151);
      return paramBoolean1;
    }
    Log.e("TbsDownloader", "needDownload: sImp is null");
    AppMethodBeat.o(157151);
    return false;
  }
  
  public static boolean isDownloadForeground()
  {
    AppMethodBeat.i(157156);
    if (Mvz != null)
    {
      boolean bool = Mvz.isDownloadForeground();
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
    //   8: getstatic 30	com/tencent/xweb/x5/sdk/f:Mvz	Lcom/tencent/xweb/x5/sdk/b;
    //   11: ifnull +22 -> 33
    //   14: getstatic 30	com/tencent/xweb/x5/sdk/f:Mvz	Lcom/tencent/xweb/x5/sdk/b;
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
  
  public static boolean lz(Context paramContext)
  {
    AppMethodBeat.i(157149);
    if (Mvz != null)
    {
      boolean bool = Mvz.lz(paramContext);
      AppMethodBeat.o(157149);
      return bool;
    }
    Log.e("TbsDownloader", "needSendRequest: sImp is null");
    AppMethodBeat.o(157149);
    return false;
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(157150);
    paramBoolean = a(paramContext, paramBoolean, false, null);
    AppMethodBeat.o(157150);
    return paramBoolean;
  }
  
  public static void startDownload(Context paramContext)
  {
    AppMethodBeat.i(157152);
    startDownload(paramContext, false);
    AppMethodBeat.o(157152);
  }
  
  /* Error */
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 77
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 30	com/tencent/xweb/x5/sdk/f:Mvz	Lcom/tencent/xweb/x5/sdk/b;
    //   11: ifnull +22 -> 33
    //   14: getstatic 30	com/tencent/xweb/x5/sdk/f:Mvz	Lcom/tencent/xweb/x5/sdk/b;
    //   17: aload_0
    //   18: iload_1
    //   19: invokeinterface 78 3 0
    //   24: ldc 77
    //   26: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: ldc 38
    //   35: ldc 80
    //   37: invokestatic 46	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 77
    //   42: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -16 -> 29
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    //   0	54	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	29	48	finally
    //   33	45	48	finally
  }
  
  public static void stopDownload()
  {
    AppMethodBeat.i(157154);
    if (Mvz != null)
    {
      Mvz.stopDownload();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.f
 * JD-Core Version:    0.7.0.1
 */