package com.tencent.mm.plugin.recordvideo.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.media.j.d;
import com.tencent.mm.plugin.recordvideo.camera.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/render/CameraSurfaceTextureRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "scaleType", "", "(I)V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-recordvideo_release"})
public final class a
  extends d
{
  public a(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(226476);
    Object localObject = b.HJh;
    if (b.aZo())
    {
      localObject = (com.tencent.mm.media.j.b.a)new f(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
      AppMethodBeat.o(226476);
      return localObject;
    }
    localObject = (com.tencent.mm.media.j.b.a)new c(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
    AppMethodBeat.o(226476);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.camera.a.a
 * JD-Core Version:    0.7.0.1
 */