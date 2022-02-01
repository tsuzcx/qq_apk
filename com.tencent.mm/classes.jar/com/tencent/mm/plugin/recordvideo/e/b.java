package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "TAG", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "setTextureSize", "width", "height", "updateDrawViewSize", "updateTextureSize", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.media.j.a
{
  private final String TAG = "MicroMsg.RecorderTextureRenderer";
  
  public b()
  {
    super(0, 0, 1, 1, 15);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(182857);
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new e(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
    AppMethodBeat.o(182857);
    return locala;
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182859);
    super.ek(paramInt1, paramInt2);
    AppMethodBeat.o(182859);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182858);
    Log.i(this.TAG, "updateTextureSize " + paramInt1 + ", " + paramInt2 + "; " + this.mVd + ", " + this.mVe);
    AppMethodBeat.o(182858);
  }
  
  public final void fQ(boolean paramBoolean) {}
  
  public final void kI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182856);
    super.el(paramInt1, paramInt2);
    AppMethodBeat.o(182856);
  }
  
  public final void th(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b
 * JD-Core Version:    0.7.0.1
 */