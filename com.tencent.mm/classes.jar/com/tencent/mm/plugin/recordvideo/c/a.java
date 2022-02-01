package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "TAG", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "setTextureSize", "width", "height", "updateDrawViewSize", "updateTextureSize", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.media.i.a
{
  private final String TAG = "MicroMsg.RecorderTextureRenderer";
  
  public a()
  {
    super(0, 0, 1, 1, 15);
  }
  
  public final com.tencent.mm.media.i.b.a ajF()
  {
    AppMethodBeat.i(182857);
    com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new e(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
    AppMethodBeat.o(182857);
    return locala;
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182859);
    super.cR(paramInt1, paramInt2);
    AppMethodBeat.o(182859);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182858);
    ac.i(this.TAG, "updateTextureSize " + paramInt1 + ", " + paramInt2 + "; " + this.gqZ + ", " + this.gra);
    AppMethodBeat.o(182858);
  }
  
  public final void ee(boolean paramBoolean) {}
  
  public final void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182856);
    super.cS(paramInt1, paramInt2);
    AppMethodBeat.o(182856);
  }
  
  public final void mE(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.a
 * JD-Core Version:    0.7.0.1
 */