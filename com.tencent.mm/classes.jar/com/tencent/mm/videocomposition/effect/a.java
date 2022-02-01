package com.tencent.mm.videocomposition.effect;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/BitmapEffector;", "", "()V", "TAG", "", "height", "", "inputBitmap", "Landroid/graphics/Bitmap;", "renderController", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController;", "width", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "requestEffect", "", "callback", "Lkotlin/Function1;", "setInputBitmap", "bitmap", "setOutputSize", "video_composition_release"})
public final class a
{
  private final String TAG;
  public final b YIy;
  private int height;
  private Bitmap jUC;
  private int width;
  
  public a()
  {
    AppMethodBeat.i(248091);
    this.TAG = ("BitmapEffector@" + hashCode());
    this.YIy = new b();
    AppMethodBeat.o(248091);
  }
  
  public final void af(kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(248090);
    p.k(paramb, "callback");
    if ((this.width <= 0) || (this.height <= 0))
    {
      com.tencent.mm.videocomposition.c.b.r("size error [" + this.width + ", " + this.height + ']', new Object[0]);
      paramb.invoke(this.jUC);
      AppMethodBeat.o(248090);
      return;
    }
    this.YIy.no(this.width, this.height);
    this.YIy.YIS = ((kotlin.g.a.b)new a(this));
    this.YIy.ag((kotlin.g.a.b)new b(paramb));
    AppMethodBeat.o(248090);
  }
  
  public final void setInputBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(248087);
    p.k(paramBitmap, "bitmap");
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "setInputBitmap: " + paramBitmap + ", size:[" + paramBitmap.getWidth() + ',' + paramBitmap.getHeight() + ']', new Object[0]);
    this.jUC = paramBitmap;
    this.YIy.setInputBitmap(paramBitmap);
    AppMethodBeat.o(248087);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Long, x>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    b(kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.a
 * JD-Core Version:    0.7.0.1
 */