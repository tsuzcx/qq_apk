package com.tencent.mm.plugin.vlog.player.render;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoBitmapBlendRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "blendOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendTextureProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "checkInitBlendProc", "", "hasBlendBitmap", "", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "inputTextures", "", "setBlendBitmapProvider", "Companion", "plugin-vlog_release"})
public final class b
  extends e
{
  public static final b.a AqS;
  com.tencent.mm.media.i.b.b AqQ;
  d AqR;
  d.g.a.b<? super Long, Bitmap> gSX;
  
  static
  {
    AppMethodBeat.i(207735);
    AqS = new b.a((byte)0);
    AppMethodBeat.o(207735);
  }
  
  public final void release()
  {
    AppMethodBeat.i(207734);
    super.release();
    Object localObject = this.AqQ;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.b)localObject).release();
    }
    localObject = this.AqR;
    if (localObject != null)
    {
      ((d)localObject).close();
      AppMethodBeat.o(207734);
      return;
    }
    AppMethodBeat.o(207734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.b
 * JD-Core Version:    0.7.0.1
 */