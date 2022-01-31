package com.tencent.mm.plugin.music;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.music.e.l;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public class PluginMusic
  extends f
  implements com.tencent.mm.plugin.music.a.a
{
  public void configure(g paramg)
  {
    com.tencent.mm.plugin.music.f.c.b.init(ae.getContext());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.cache.c.class, new com.tencent.mm.plugin.music.model.a.c());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.b.a.b.class, new com.tencent.mm.plugin.music.b.a.a());
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.b.class, new l());
    com.tencent.mm.plugin.music.b.c.init();
    com.tencent.mm.plugin.music.f.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
    if (paramg.Ex())
    {
      y.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
      pin(new p(e.class));
    }
  }
  
  public void execute(g paramg)
  {
    if (paramg.Ex())
    {
      y.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
      com.tencent.mm.br.c.Xg("music");
    }
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.music.a.a.class);
  }
  
  public String name()
  {
    return "plugin-music";
  }
  
  public void uninstalled()
  {
    super.uninstalled();
    com.tencent.mm.plugin.music.b.c.release();
    com.tencent.mm.plugin.music.f.c.b.s(com.tencent.mm.plugin.music.cache.c.class);
    com.tencent.mm.plugin.music.f.c.b.s(com.tencent.mm.plugin.music.b.a.b.class);
    com.tencent.mm.plugin.music.f.c.b.s(com.tencent.mm.plugin.music.e.b.class);
    com.tencent.mm.plugin.music.f.c.b.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.PluginMusic
 * JD-Core Version:    0.7.0.1
 */