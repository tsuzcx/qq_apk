package com.tencent.mm.plugin.music.f.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static b pbd = null;
  private Context ctx;
  private ConcurrentHashMap<Class<? extends a>, a> pbe;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(137662);
    this.pbe = new ConcurrentHashMap();
    this.ctx = paramContext;
    AppMethodBeat.o(137662);
  }
  
  public static void F(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(137667);
    bWl().pbe.remove(paramClass);
    AppMethodBeat.o(137667);
  }
  
  public static void a(Class<? extends a> paramClass, a parama)
  {
    AppMethodBeat.i(137666);
    bWl().pbe.put(paramClass, parama);
    AppMethodBeat.o(137666);
  }
  
  public static <T extends a> T am(Class<T> paramClass)
  {
    AppMethodBeat.i(137668);
    paramClass = (a)bWl().pbe.get(paramClass);
    AppMethodBeat.o(137668);
    return paramClass;
  }
  
  private static b bWl()
  {
    AppMethodBeat.i(137664);
    if (pbd == null) {
      init(null);
    }
    b localb = pbd;
    AppMethodBeat.o(137664);
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
    //   8: getstatic 15	com/tencent/mm/plugin/music/f/c/b:pbd	Lcom/tencent/mm/plugin/music/f/c/b;
    //   11: ifnull +12 -> 23
    //   14: ldc 72
    //   16: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 74
    //   25: ldc 76
    //   27: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 2	com/tencent/mm/plugin/music/f/c/b
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 83	com/tencent/mm/plugin/music/f/c/b:<init>	(Landroid/content/Context;)V
    //   38: putstatic 15	com/tencent/mm/plugin/music/f/c/b:pbd	Lcom/tencent/mm/plugin/music/f/c/b;
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
      AppMethodBeat.i(137665);
      ab.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
      b localb = pbd;
      localb.pbe.clear();
      localb.ctx = null;
      pbd = null;
      AppMethodBeat.o(137665);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c.b
 * JD-Core Version:    0.7.0.1
 */