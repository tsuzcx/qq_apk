package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.model.n;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.af;

public class PluginMusic
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.music.a.a
{
  private IListener LIy;
  
  public PluginMusic()
  {
    AppMethodBeat.i(178787);
    this.LIy = new PluginMusic.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(178787);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62936);
    com.tencent.mm.plugin.music.e.c.b.init(MMApplicationContext.getContext());
    com.tencent.mm.plugin.music.e.c.b.a(com.tencent.mm.plugin.music.cache.c.class, new com.tencent.mm.plugin.music.model.a.d());
    com.tencent.mm.plugin.music.e.c.b.a(com.tencent.mm.plugin.music.b.a.d.class, new com.tencent.mm.plugin.music.b.a.c());
    com.tencent.mm.plugin.music.e.c.b.a(com.tencent.mm.plugin.music.logic.b.class, new com.tencent.mm.plugin.music.logic.k());
    com.tencent.mm.plugin.music.b.g.init();
    com.tencent.mm.plugin.music.e.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
    if (paramg.bbA())
    {
      Log.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
      pin(new y(o.class));
      com.tencent.mm.kernel.h.b(com.tencent.mm.aw.a.b.class, new n());
      com.tencent.mm.kernel.h.b(com.tencent.mm.aw.a.a.class, new com.tencent.mm.plugin.music.model.h());
      com.tencent.mm.plugin.music.model.k.evw();
      af.b("music", "music", 524288000L, 7776000000L, 1);
    }
    this.LIy.alive();
    AppMethodBeat.o(62936);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62937);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
      com.tencent.mm.br.b.bsa("music");
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
    com.tencent.mm.plugin.music.e.c.b.ay(com.tencent.mm.plugin.music.cache.c.class);
    com.tencent.mm.plugin.music.e.c.b.ay(com.tencent.mm.plugin.music.b.a.d.class);
    com.tencent.mm.plugin.music.e.c.b.ay(com.tencent.mm.plugin.music.logic.b.class);
    com.tencent.mm.plugin.music.e.c.b.release();
    this.LIy.dead();
    com.tencent.mm.plugin.music.model.k.evx();
    AppMethodBeat.o(62938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.PluginMusic
 * JD-Core Version:    0.7.0.1
 */