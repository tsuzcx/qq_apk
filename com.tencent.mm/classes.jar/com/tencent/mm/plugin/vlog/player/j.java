package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"})
public final class j
{
  public static final a GCf;
  final d[] GCb;
  final d[] GCc;
  int GCd;
  int GCe;
  
  static
  {
    AppMethodBeat.i(190886);
    GCf = new a((byte)0);
    AppMethodBeat.o(190886);
  }
  
  public j()
  {
    AppMethodBeat.i(190885);
    this.GCb = new d[2];
    this.GCc = new d[2];
    AppMethodBeat.o(190885);
  }
  
  public final void fCp()
  {
    AppMethodBeat.i(190884);
    Log.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
    int i = 0;
    while (i < 2)
    {
      this.GCb[i] = c.a(false, 11L);
      this.GCc[i] = c.a(true, 11L);
      i += 1;
    }
    AppMethodBeat.o(190884);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache$Companion;", "", "()V", "TAG", "", "cacheTexsNum", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.j
 * JD-Core Version:    0.7.0.1
 */