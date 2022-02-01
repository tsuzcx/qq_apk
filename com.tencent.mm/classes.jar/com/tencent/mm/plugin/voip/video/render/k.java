package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.c.b;
import com.tencent.mm.plugin.voip.video.c.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoIPScreenRenderProcTexture;", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "renderSide", "", "textureWidth", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIIII)V", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public class k
  extends n
{
  public k(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super(paramInt2, paramInt3, 0, paramInt5, paramInt6, 2);
    AppMethodBeat.i(293077);
    this.UUp = ((b)new h(paramInt1));
    paramInt2 = paramInt4;
    if (paramInt1 == 0) {
      paramInt2 = 1;
    }
    this.mWg = paramInt2;
    AppMethodBeat.o(293077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k
 * JD-Core Version:    0.7.0.1
 */