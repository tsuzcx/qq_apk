package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a UdC;
  final d[] UdD;
  final d[] UdE;
  int UdF;
  int UdG;
  
  static
  {
    AppMethodBeat.i(281192);
    UdC = new a((byte)0);
    AppMethodBeat.o(281192);
  }
  
  public i()
  {
    AppMethodBeat.i(281190);
    this.UdD = new d[2];
    this.UdE = new d[2];
    AppMethodBeat.o(281190);
  }
  
  public final void hSd()
  {
    AppMethodBeat.i(281195);
    Log.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      this.UdD[i] = c.d(false, 11L);
      this.UdE[i] = c.d(true, 11L);
      if (j >= 2)
      {
        AppMethodBeat.o(281195);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache$Companion;", "", "()V", "TAG", "", "cacheTexsNum", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.i
 * JD-Core Version:    0.7.0.1
 */