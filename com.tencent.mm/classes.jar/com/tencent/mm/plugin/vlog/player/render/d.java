package com.tencent.mm.plugin.vlog.player.render;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCropRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "beforeCropTextureSize", "Landroid/util/Size;", "cropOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "cropOutputTextureSize", "cropRect", "Landroid/graphics/Rect;", "cropRectChanged", "", "cropRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "checkInitCropOutputTextureInfo", "", "hasCropRect", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "setBeforeCropTextureSize", "textureSize", "setCropRect", "rect", "Companion", "plugin-vlog_release"})
public final class d
  extends e
{
  public static final d.a Arf;
  com.tencent.mm.media.f.d Ara;
  com.tencent.mm.media.i.b.e Arb;
  boolean Arc;
  private Size Ard;
  Size Are;
  Rect gUl;
  
  static
  {
    AppMethodBeat.i(207744);
    Arf = new d.a((byte)0);
    AppMethodBeat.o(207744);
  }
  
  public d()
  {
    AppMethodBeat.i(207743);
    this.Ard = new Size(0, 0);
    this.Are = new Size(0, 0);
    AppMethodBeat.o(207743);
  }
  
  public final void release()
  {
    AppMethodBeat.i(207742);
    super.release();
    Object localObject = this.Arb;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.e)localObject).release();
    }
    localObject = this.Ara;
    if (localObject != null)
    {
      ((com.tencent.mm.media.f.d)localObject).close();
      AppMethodBeat.o(207742);
      return;
    }
    AppMethodBeat.o(207742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.d
 * JD-Core Version:    0.7.0.1
 */