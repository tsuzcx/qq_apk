package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "TAG", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "setTextureSize", "width", "height", "updateDrawViewSize", "updateTextureSize", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.media.i.a
{
  private final String TAG = "MicroMsg.RecorderTextureRenderer";
  
  public a()
  {
    super(0, 0, 1, 1, 15);
  }
  
  public final com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(182857);
    com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new d(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
    AppMethodBeat.o(182857);
    return locala;
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182858);
    ad.i(this.TAG, "updateTextureSize " + paramInt1 + ", " + paramInt2 + "; " + this.guI + ", " + this.guJ);
    AppMethodBeat.o(182858);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182859);
    super.cT(paramInt1, paramInt2);
    AppMethodBeat.o(182859);
  }
  
  public final void dJ(boolean paramBoolean) {}
  
  public final void gM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182856);
    super.cS(paramInt1, paramInt2);
    AppMethodBeat.o(182856);
  }
  
  public final void mz(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.a
 * JD-Core Version:    0.7.0.1
 */