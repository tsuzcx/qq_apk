package com.tencent.mm.plugin.music.b;

import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  private static c mwM = null;
  
  private c()
  {
    e.blX();
  }
  
  /* Error */
  public static void init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/tencent/mm/plugin/music/b/c:mwM	Lcom/tencent/mm/plugin/music/b/c;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: ldc 22
    //   17: ldc 24
    //   19: invokestatic 30	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: new 2	com/tencent/mm/plugin/music/b/c
    //   25: dup
    //   26: invokespecial 31	com/tencent/mm/plugin/music/b/c:<init>	()V
    //   29: putstatic 10	com/tencent/mm/plugin/music/b/c:mwM	Lcom/tencent/mm/plugin/music/b/c;
    //   32: goto -21 -> 11
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	localc	c
    //   35	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	35	finally
    //   15	32	35	finally
  }
  
  public static void release()
  {
    try
    {
      y.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
      e locale = e.blY();
      y.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
      locale.blZ();
      locale.bmh();
      mwM = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.c
 * JD-Core Version:    0.7.0.1
 */