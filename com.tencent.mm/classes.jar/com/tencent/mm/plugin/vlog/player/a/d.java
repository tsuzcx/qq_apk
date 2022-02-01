package com.tencent.mm.plugin.vlog.player.a;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCropRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "beforeCropTextureSize", "Landroid/util/Size;", "cropOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "cropOutputTextureSize", "cropRect", "Landroid/graphics/Rect;", "cropRectChanged", "", "cropRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "checkInitCropOutputTextureInfo", "", "hasCropRect", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "setBeforeCropTextureSize", "textureSize", "setCropRect", "rect", "Companion", "plugin-vlog_release"})
public final class d
  extends e
{
  public static final a LsY;
  com.tencent.mm.media.f.d LsT;
  com.tencent.mm.media.i.b.d LsU;
  boolean LsV;
  private Size LsW;
  Size LsX;
  Rect gtE;
  
  static
  {
    AppMethodBeat.i(201059);
    LsY = new a((byte)0);
    AppMethodBeat.o(201059);
  }
  
  public d()
  {
    AppMethodBeat.i(201058);
    this.LsW = new Size(0, 0);
    this.LsX = new Size(0, 0);
    AppMethodBeat.o(201058);
  }
  
  public final void release()
  {
    AppMethodBeat.i(201057);
    super.release();
    Object localObject = this.LsU;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.d)localObject).release();
    }
    localObject = this.LsT;
    if (localObject != null)
    {
      ((com.tencent.mm.media.f.d)localObject).close();
      AppMethodBeat.o(201057);
      return;
    }
    AppMethodBeat.o(201057);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCropRenderProc$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.d
 * JD-Core Version:    0.7.0.1
 */