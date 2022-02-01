package com.tencent.mm.videocomposition.effect;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/BitmapEffector;", "", "()V", "TAG", "", "height", "", "inputBitmap", "Landroid/graphics/Bitmap;", "renderController", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController;", "reportData", "Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "getReportData", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "width", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "requestEffect", "", "callback", "Lkotlin/Function1;", "setInputBitmap", "bitmap", "setOutputSize", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class a
{
  public final b HkF;
  private final String TAG;
  private int height;
  private Bitmap muT;
  private int width;
  
  public a()
  {
    AppMethodBeat.i(233659);
    this.TAG = ("BitmapEffector@" + hashCode());
    this.HkF = new b();
    AppMethodBeat.o(233659);
  }
  
  public final void aW(kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(233697);
    s.t(paramb, "callback");
    if ((this.width <= 0) || (this.height <= 0))
    {
      com.tencent.mm.videocomposition.d.b.s("size error [" + this.width + ", " + this.height + ']', new Object[0]);
      paramb.invoke(this.muT);
      AppMethodBeat.o(233697);
      return;
    }
    this.HkF.pl(this.width, this.height);
    this.HkF.aX((kotlin.g.a.b)new a.a(paramb));
    this.HkF.K((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(233697);
  }
  
  public final void setInputBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(233685);
    s.t(paramBitmap, "bitmap");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "setInputBitmap: " + paramBitmap + ", size:[" + paramBitmap.getWidth() + ',' + paramBitmap.getHeight() + ']', new Object[0]);
    this.muT = paramBitmap;
    this.HkF.setInputBitmap(paramBitmap);
    AppMethodBeat.o(233685);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.a
 * JD-Core Version:    0.7.0.1
 */