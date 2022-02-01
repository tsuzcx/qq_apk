package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.c;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "", "()V", "externalTexIndex", "", "externalTexsPool", "", "Lcom/tencent/mm/media/globject/GLTextureObject;", "[Lcom/tencent/mm/media/globject/GLTextureObject;", "normalTexIndex", "normalTexsPool", "clearCache", "", "initCache", "releaseExternalTex", "tex", "releaseNormalTex", "requestExternalTex", "requestNormalTex", "Companion", "plugin-vlog_release"})
public final class k
{
  public static final k.a Aqw;
  final d[] Aqs;
  final d[] Aqt;
  int Aqu;
  int Aqv;
  
  static
  {
    AppMethodBeat.i(207733);
    Aqw = new k.a((byte)0);
    AppMethodBeat.o(207733);
  }
  
  public k()
  {
    AppMethodBeat.i(207732);
    this.Aqs = new d[2];
    this.Aqt = new d[2];
    AppMethodBeat.o(207732);
  }
  
  public final void efW()
  {
    AppMethodBeat.i(207731);
    ac.i("MicroMsg.VLogScriptTexCache", "init cache, cacheTexsNum:2");
    int i = 0;
    while (i < 2)
    {
      this.Aqs[i] = c.a(false, 11L);
      this.Aqt[i] = c.a(true, 11L);
      i += 1;
    }
    AppMethodBeat.o(207731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.k
 * JD-Core Version:    0.7.0.1
 */