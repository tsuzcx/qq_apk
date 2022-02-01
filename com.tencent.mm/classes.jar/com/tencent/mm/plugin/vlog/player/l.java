package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.c;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ad;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"})
public final class l
{
  public static final a LsA;
  final d[] Lsw;
  final d[] Lsx;
  int Lsy;
  int Lsz;
  
  static
  {
    AppMethodBeat.i(201047);
    LsA = new a((byte)0);
    AppMethodBeat.o(201047);
  }
  
  public l()
  {
    AppMethodBeat.i(201046);
    this.Lsw = new d[2];
    this.Lsx = new d[2];
    AppMethodBeat.o(201046);
  }
  
  public final void dRg()
  {
    AppMethodBeat.i(201045);
    ad.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
    int i = 0;
    while (i < 2)
    {
      this.Lsw[i] = c.a(false, 11L);
      this.Lsx[i] = c.a(true, 11L);
      i += 1;
    }
    AppMethodBeat.o(201045);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache$Companion;", "", "()V", "TAG", "", "cacheTexsNum", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.l
 * JD-Core Version:    0.7.0.1
 */