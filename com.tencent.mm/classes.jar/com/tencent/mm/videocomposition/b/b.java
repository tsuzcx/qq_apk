package com.tencent.mm.videocomposition.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/render/BlendBitmapRender;", "", "()V", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "height", "", "texture", "width", "blendTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "ensureTexture", "", "release", "setBlendBitmapProvider", "uploadBitmap", "bitmap", "Companion", "video_composition_release"})
public final class b
{
  public static final a LKd;
  int BZy;
  int height;
  d.g.a.b<? super Long, Bitmap> hnM;
  int width;
  
  static
  {
    AppMethodBeat.i(195037);
    LKd = new a((byte)0);
    AppMethodBeat.o(195037);
  }
  
  public final void F(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(195036);
    p.h(paramb, "blendBitmapProvider");
    new StringBuilder("setBlendBitmapProvider:").append(paramb.hashCode());
    this.hnM = paramb;
    AppMethodBeat.o(195036);
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/render/BlendBitmapRender$Companion;", "", "()V", "TAG", "", "video_composition_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.b
 * JD-Core Version:    0.7.0.1
 */