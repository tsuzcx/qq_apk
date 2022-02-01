package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.me;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.music.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class PluginMusic
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.music.a.a
{
  private com.tencent.mm.sdk.b.c whK;
  
  public PluginMusic()
  {
    AppMethodBeat.i(178787);
    this.whK = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(178787);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(62936);
    com.tencent.mm.plugin.music.f.c.b.init(aj.getContext());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.cache.c.class, new com.tencent.mm.plugin.music.model.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.b.a.d.class, new com.tencent.mm.plugin.music.b.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.b.class, new l());
    com.tencent.mm.plugin.music.b.d.init();
    com.tencent.mm.plugin.music.f.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
    if (paramg.akw())
    {
      ad.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
      pin(new t(com.tencent.mm.plugin.music.model.f.class));
    }
    this.whK.alive();
    AppMethodBeat.o(62936);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(62937);
    if (paramg.akw())
    {
      ad.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
      com.tencent.mm.bs.c.aNQ("music");
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
    com.tencent.mm.plugin.music.b.d.release();
    com.tencent.mm.plugin.music.f.c.b.ac(com.tencent.mm.plugin.music.cache.c.class);
    com.tencent.mm.plugin.music.f.c.b.ac(com.tencent.mm.plugin.music.b.a.d.class);
    com.tencent.mm.plugin.music.f.c.b.ac(com.tencent.mm.plugin.music.e.b.class);
    com.tencent.mm.plugin.music.f.c.b.release();
    this.whK.dead();
    AppMethodBeat.o(62938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.PluginMusic
 * JD-Core Version:    0.7.0.1
 */