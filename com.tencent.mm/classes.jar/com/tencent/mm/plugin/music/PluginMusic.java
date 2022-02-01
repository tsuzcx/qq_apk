package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.b.a.d;
import com.tencent.mm.plugin.music.e.l;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.model.k;
import com.tencent.mm.plugin.music.model.n;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginMusic
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.music.a.a
{
  private IListener AgM;
  
  public PluginMusic()
  {
    AppMethodBeat.i(178787);
    this.AgM = new IListener() {};
    AppMethodBeat.o(178787);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62936);
    com.tencent.mm.plugin.music.f.c.b.init(MMApplicationContext.getContext());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.cache.c.class, new com.tencent.mm.plugin.music.model.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(d.class, new com.tencent.mm.plugin.music.b.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.b.class, new l());
    com.tencent.mm.plugin.music.b.f.init();
    com.tencent.mm.plugin.music.f.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
    if (paramg.aBb())
    {
      Log.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
      pin(new y(o.class));
      com.tencent.mm.kernel.g.b(com.tencent.mm.ay.a.b.class, new n());
      com.tencent.mm.kernel.g.b(com.tencent.mm.ay.a.a.class, new h());
      k.euA();
    }
    this.AgM.alive();
    AppMethodBeat.o(62936);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62937);
    if (paramg.aBb())
    {
      Log.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
      com.tencent.mm.br.b.bfQ("music");
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
    com.tencent.mm.plugin.music.b.f.release();
    com.tencent.mm.plugin.music.f.c.b.ag(com.tencent.mm.plugin.music.cache.c.class);
    com.tencent.mm.plugin.music.f.c.b.ag(d.class);
    com.tencent.mm.plugin.music.f.c.b.ag(com.tencent.mm.plugin.music.e.b.class);
    com.tencent.mm.plugin.music.f.c.b.release();
    this.AgM.dead();
    k.euB();
    AppMethodBeat.o(62938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.PluginMusic
 * JD-Core Version:    0.7.0.1
 */