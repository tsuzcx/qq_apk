package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.music.e.l;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class PluginMusic
  extends f
  implements com.tencent.mm.plugin.music.a.a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(104810);
    com.tencent.mm.plugin.music.f.c.b.init(ah.getContext());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.cache.c.class, new com.tencent.mm.plugin.music.model.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.b.a.d.class, new com.tencent.mm.plugin.music.b.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.b.class, new l());
    com.tencent.mm.plugin.music.b.d.init();
    com.tencent.mm.plugin.music.f.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
    if (paramg.SD())
    {
      ab.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
      pin(new q(e.class));
    }
    AppMethodBeat.o(104810);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(104811);
    if (paramg.SD())
    {
      ab.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
      com.tencent.mm.bq.c.anb("music");
    }
    AppMethodBeat.o(104811);
  }
  
  public void installed()
  {
    AppMethodBeat.i(104809);
    alias(com.tencent.mm.plugin.music.a.a.class);
    AppMethodBeat.o(104809);
  }
  
  public String name()
  {
    return "plugin-music";
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(104812);
    super.uninstalled();
    com.tencent.mm.plugin.music.b.d.release();
    com.tencent.mm.plugin.music.f.c.b.F(com.tencent.mm.plugin.music.cache.c.class);
    com.tencent.mm.plugin.music.f.c.b.F(com.tencent.mm.plugin.music.b.a.d.class);
    com.tencent.mm.plugin.music.f.c.b.F(com.tencent.mm.plugin.music.e.b.class);
    com.tencent.mm.plugin.music.f.c.b.release();
    AppMethodBeat.o(104812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.PluginMusic
 * JD-Core Version:    0.7.0.1
 */