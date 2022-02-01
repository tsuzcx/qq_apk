package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"})
public final class j
{
  public static final a BIT;
  final d[] BIP;
  final d[] BIQ;
  int BIR;
  int BIS;
  
  static
  {
    AppMethodBeat.i(195955);
    BIT = new a((byte)0);
    AppMethodBeat.o(195955);
  }
  
  public j()
  {
    AppMethodBeat.i(195954);
    this.BIP = new d[2];
    this.BIQ = new d[2];
    AppMethodBeat.o(195954);
  }
  
  public final void esJ()
  {
    AppMethodBeat.i(195953);
    ad.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
    int i = 0;
    while (i < 2)
    {
      this.BIP[i] = c.a(false, 11L);
      this.BIQ[i] = c.a(true, 11L);
      i += 1;
    }
    AppMethodBeat.o(195953);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache$Companion;", "", "()V", "TAG", "", "cacheTexsNum", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.j
 * JD-Core Version:    0.7.0.1
 */