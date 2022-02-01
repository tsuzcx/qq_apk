package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/FlutterVoIPScreenRenderProcTexture;", "Lcom/tencent/mm/plugin/voip/video/render/VoIPScreenRenderProcTexture;", "renderSide", "", "textureWidth", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIIII)V", "isFirstDraw", "", "lastDrawHeight", "lastDrawWidth", "newDrawHeight", "newDrawWidth", "beforeRender", "", "updateDrawViewSize", "width", "height", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends k
{
  private boolean HjK;
  private int USb;
  private int USc;
  private int USd;
  private int USe;
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, 0, paramInt4, 1, 2);
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(293061);
    if (this.HjK) {
      super.ek(this.USb, this.USc);
    }
    for (;;)
    {
      this.HjK = false;
      super.bgB();
      AppMethodBeat.o(293061);
      return;
      super.ek(this.USd, this.USe);
    }
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293066);
    if ((paramInt1 != this.USd) || (paramInt2 != this.USe))
    {
      this.USb = getDrawWidth();
      this.USc = getDrawHeight();
      this.USd = paramInt1;
      this.USe = paramInt2;
      if ((this.USb == 0) || (this.USc == 0) || ((paramInt1 == this.USb) && (paramInt2 == this.USc))) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      this.HjK = bool;
      super.ek(paramInt1, paramInt2);
      AppMethodBeat.o(293066);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.d
 * JD-Core Version:    0.7.0.1
 */