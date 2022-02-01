package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "TAG", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "setTextureSize", "width", "height", "updateDrawViewSize", "updateTextureSize", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.media.j.a
{
  private final String TAG = "MicroMsg.RecorderTextureRenderer";
  
  public a()
  {
    super(0, 0, 1, 1, 15);
  }
  
  public final com.tencent.mm.media.j.b.a amr()
  {
    AppMethodBeat.i(182857);
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new e(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
    AppMethodBeat.o(182857);
    return locala;
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182859);
    super.cT(paramInt1, paramInt2);
    AppMethodBeat.o(182859);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182858);
    ad.i(this.TAG, "updateTextureSize " + paramInt1 + ", " + paramInt2 + "; " + this.gKJ + ", " + this.gKK);
    AppMethodBeat.o(182858);
  }
  
  public final void eg(boolean paramBoolean) {}
  
  public final void hl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182856);
    super.cU(paramInt1, paramInt2);
    AppMethodBeat.o(182856);
  }
  
  public final void nd(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.a
 * JD-Core Version:    0.7.0.1
 */