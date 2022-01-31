package com.tencent.mm.pluginsdk;

import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.sdk.platformtools.y;

public final class o$a
{
  public static o.c rSE;
  public static o.b rSF;
  
  public static o.c ckl()
  {
    if (rSE == null)
    {
      y.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      rSE = new c();
    }
    return rSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.o.a
 * JD-Core Version:    0.7.0.1
 */