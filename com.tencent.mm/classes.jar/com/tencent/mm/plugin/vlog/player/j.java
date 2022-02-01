package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"})
public final class j
{
  public static final a Cas;
  final d[] Cao;
  final d[] Cap;
  int Caq;
  int Car;
  
  static
  {
    AppMethodBeat.i(191415);
    Cas = new a((byte)0);
    AppMethodBeat.o(191415);
  }
  
  public j()
  {
    AppMethodBeat.i(191414);
    this.Cao = new d[2];
    this.Cap = new d[2];
    AppMethodBeat.o(191414);
  }
  
  public final void ewq()
  {
    AppMethodBeat.i(191413);
    ae.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
    int i = 0;
    while (i < 2)
    {
      this.Cao[i] = c.a(false, 11L);
      this.Cap[i] = c.a(true, 11L);
      i += 1;
    }
    AppMethodBeat.o(191413);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache$Companion;", "", "()V", "TAG", "", "cacheTexsNum", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.j
 * JD-Core Version:    0.7.0.1
 */