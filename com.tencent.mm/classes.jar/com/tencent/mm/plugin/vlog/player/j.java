package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"})
public final class j
{
  public static final a NpQ;
  final d[] NpM;
  final d[] NpN;
  int NpO;
  int NpP;
  
  static
  {
    AppMethodBeat.i(224506);
    NpQ = new a((byte)0);
    AppMethodBeat.o(224506);
  }
  
  public j()
  {
    AppMethodBeat.i(224503);
    this.NpM = new d[2];
    this.NpN = new d[2];
    AppMethodBeat.o(224503);
  }
  
  public final void guo()
  {
    AppMethodBeat.i(224501);
    Log.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
    int i = 0;
    while (i < 2)
    {
      this.NpM[i] = c.a(false, 11L);
      this.NpN[i] = c.a(true, 11L);
      i += 1;
    }
    AppMethodBeat.o(224501);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache$Companion;", "", "()V", "TAG", "", "cacheTexsNum", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.j
 * JD-Core Version:    0.7.0.1
 */