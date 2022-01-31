package com.tencent.mm.plugin.radar;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.sdk.platformtools.y;

public final class PluginRadar
  extends f
  implements a
{
  private static final String TAG = "MicroMsg.PluginRadar";
  public static final PluginRadar.a nko = new PluginRadar.a((byte)0);
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    a.d.b.g.k(paramg, "profile");
    if (paramg.Ex())
    {
      y.i(access$getTAG$cp(), "PluginRadar configure");
      pin((com.tencent.mm.kernel.b.c)new p(c.class));
    }
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    a.d.b.g.k(paramg, "profile");
    com.tencent.mm.br.c.Xg("radar");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.PluginRadar
 * JD-Core Version:    0.7.0.1
 */