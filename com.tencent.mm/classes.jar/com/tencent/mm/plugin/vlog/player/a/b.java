package com.tencent.mm.plugin.vlog.player.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoBitmapBlendRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "blendOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendTextureProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "checkInitBlendProc", "", "hasBlendBitmap", "", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "inputTextures", "", "setBlendBitmapProvider", "Companion", "plugin-vlog_release"})
public final class b
  extends e
{
  public static final a LsL;
  com.tencent.mm.media.i.b.b LsJ;
  d LsK;
  d.g.a.b<? super Long, Bitmap> gsq;
  
  static
  {
    AppMethodBeat.i(201049);
    LsL = new a((byte)0);
    AppMethodBeat.o(201049);
  }
  
  public final void release()
  {
    AppMethodBeat.i(201048);
    super.release();
    Object localObject = this.LsJ;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.b)localObject).release();
    }
    localObject = this.LsK;
    if (localObject != null)
    {
      ((d)localObject).close();
      AppMethodBeat.o(201048);
      return;
    }
    AppMethodBeat.o(201048);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoBitmapBlendRenderProc$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.b
 * JD-Core Version:    0.7.0.1
 */