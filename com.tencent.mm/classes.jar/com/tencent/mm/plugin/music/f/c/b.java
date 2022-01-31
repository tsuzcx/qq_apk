package com.tencent.mm.plugin.music.f.c;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static b mAY = null;
  private Context ctx;
  private ConcurrentHashMap<Class<? extends a>, a> mAZ = new ConcurrentHashMap();
  
  private b(Context paramContext)
  {
    this.ctx = paramContext;
  }
  
  public static <T extends a> T Q(Class<T> paramClass)
  {
    return (a)bnO().mAZ.get(paramClass);
  }
  
  public static void a(Class<? extends a> paramClass, a parama)
  {
    bnO().mAZ.put(paramClass, parama);
  }
  
  private static b bnO()
  {
    if (mAY == null) {
      init(null);
    }
    return mAY;
  }
  
  /* Error */
  public static void init(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 15	com/tencent/mm/plugin/music/f/c/b:mAY	Lcom/tencent/mm/plugin/music/f/c/b;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: ldc 53
    //   17: ldc 55
    //   19: invokestatic 61	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: new 2	com/tencent/mm/plugin/music/f/c/b
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 63	com/tencent/mm/plugin/music/f/c/b:<init>	(Landroid/content/Context;)V
    //   30: putstatic 15	com/tencent/mm/plugin/music/f/c/b:mAY	Lcom/tencent/mm/plugin/music/f/c/b;
    //   33: goto -22 -> 11
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	paramContext	Context
    //   6	2	1	localb	b
    // Exception table:
    //   from	to	target	type
    //   3	7	36	finally
    //   15	33	36	finally
  }
  
  public static void release()
  {
    try
    {
      y.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
      b localb = mAY;
      localb.mAZ.clear();
      localb.ctx = null;
      mAY = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void s(Class<? extends a> paramClass)
  {
    bnO().mAZ.remove(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c.b
 * JD-Core Version:    0.7.0.1
 */