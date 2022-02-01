package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.b.a.d;
import com.tencent.mm.plugin.music.e.l;
import com.tencent.mm.plugin.music.model.k;
import com.tencent.mm.plugin.music.model.n;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginMusic
  extends f
  implements com.tencent.mm.plugin.music.a.a
{
  private IListener FNC;
  
  public PluginMusic()
  {
    AppMethodBeat.i(178787);
    this.FNC = new IListener() {};
    AppMethodBeat.o(178787);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62936);
    com.tencent.mm.plugin.music.f.c.b.init(MMApplicationContext.getContext());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.cache.c.class, new com.tencent.mm.plugin.music.model.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(d.class, new com.tencent.mm.plugin.music.b.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.b.class, new l());
    com.tencent.mm.plugin.music.b.g.init();
    com.tencent.mm.plugin.music.f.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
    if (paramg.aIE())
    {
      Log.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
      pin(new y(o.class));
      com.tencent.mm.kernel.h.b(com.tencent.mm.bb.a.b.class, new n());
      com.tencent.mm.kernel.h.b(com.tencent.mm.bb.a.a.class, new com.tencent.mm.plugin.music.model.h());
      k.dFh();
    }
    this.FNC.alive();
    AppMethodBeat.o(62936);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62937);
    if (paramg.aIE())
    {
      Log.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
      com.tencent.mm.by.b.bsj("music");
    }
    AppMethodBeat.o(62937);
  }
  
  public void installed()
  {
    AppMethodBeat.i(62935);
    alias(com.tencent.mm.plugin.music.a.a.class);
    AppMethodBeat.o(62935);
  }
  
  public String name()
  {
    return "plugin-music";
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(62938);
    super.uninstalled();
    com.tencent.mm.plugin.music.b.g.release();
    com.tencent.mm.plugin.music.f.c.b.af(com.tencent.mm.plugin.music.cache.c.class);
    com.tencent.mm.plugin.music.f.c.b.af(d.class);
    com.tencent.mm.plugin.music.f.c.b.af(com.tencent.mm.plugin.music.e.b.class);
    com.tencent.mm.plugin.music.f.c.b.release();
    this.FNC.dead();
    k.dFi();
    AppMethodBeat.o(62938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.PluginMusic
 * JD-Core Version:    0.7.0.1
 */