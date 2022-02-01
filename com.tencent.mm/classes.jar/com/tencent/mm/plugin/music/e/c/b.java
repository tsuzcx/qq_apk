package com.tencent.mm.plugin.music.e.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static b LOp = null;
  private ConcurrentHashMap<Class<? extends a>, a> LOq;
  private Context ctx;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(137414);
    this.LOq = new ConcurrentHashMap();
    this.ctx = paramContext;
    AppMethodBeat.o(137414);
  }
  
  public static void a(Class<? extends a> paramClass, a parama)
  {
    AppMethodBeat.i(137418);
    goD().LOq.put(paramClass, parama);
    AppMethodBeat.o(137418);
  }
  
  public static void ay(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(137419);
    goD().LOq.remove(paramClass);
    AppMethodBeat.o(137419);
  }
  
  public static <T extends a> T bU(Class<T> paramClass)
  {
    AppMethodBeat.i(137420);
    paramClass = (a)goD().LOq.get(paramClass);
    AppMethodBeat.o(137420);
    return paramClass;
  }
  
  private static b goD()
  {
    AppMethodBeat.i(137416);
    if (LOp == null) {
      init(null);
    }
    b localb = LOp;
    AppMethodBeat.o(137416);
    return localb;
  }
  
  /* Error */
  public static void init(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 72
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 15	com/tencent/mm/plugin/music/e/c/b:LOp	Lcom/tencent/mm/plugin/music/e/c/b;
    //   11: ifnull +12 -> 23
    //   14: ldc 72
    //   16: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 74
    //   25: ldc 76
    //   27: invokestatic 81	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 2	com/tencent/mm/plugin/music/e/c/b
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 83	com/tencent/mm/plugin/music/e/c/b:<init>	(Landroid/content/Context;)V
    //   38: putstatic 15	com/tencent/mm/plugin/music/e/c/b:LOp	Lcom/tencent/mm/plugin/music/e/c/b;
    //   41: ldc 72
    //   43: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -27 -> 19
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	19	49	finally
    //   23	46	49	finally
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(137417);
      Log.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
      b localb = LOp;
      localb.LOq.clear();
      localb.ctx = null;
      LOp = null;
      AppMethodBeat.o(137417);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.c.b
 * JD-Core Version:    0.7.0.1
 */