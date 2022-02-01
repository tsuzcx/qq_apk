package com.tencent.mm.videocomposition.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/render/BlendBitmapRender;", "", "()V", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "height", "", "texture", "width", "blendTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "ensureTexture", "", "release", "setBlendBitmapProvider", "uploadBitmap", "bitmap", "Companion", "video_composition_release"})
public final class b
{
  public static final a Lns;
  int BHZ;
  int height;
  d.g.a.b<? super Long, Bitmap> hkY;
  int width;
  
  static
  {
    AppMethodBeat.i(220902);
    Lns = new a((byte)0);
    AppMethodBeat.o(220902);
  }
  
  public final void E(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(220901);
    p.h(paramb, "blendBitmapProvider");
    new StringBuilder("setBlendBitmapProvider:").append(paramb.hashCode());
    this.hkY = paramb;
    AppMethodBeat.o(220901);
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/render/BlendBitmapRender$Companion;", "", "()V", "TAG", "", "video_composition_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.b
 * JD-Core Version:    0.7.0.1
 */