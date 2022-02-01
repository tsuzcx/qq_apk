package com.tencent.mm.plugin.mv.ui.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initBgCover$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
public final class c$e
  implements h
{
  c$e(ImageView paramImageView) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
  {
    paramView = null;
    AppMethodBeat.i(227744);
    p.k(paramString, "url");
    if (paramb != null) {}
    for (paramString = paramb.bitmap;; paramString = null)
    {
      if (paramString != null)
      {
        paramString = paramView;
        if (paramb != null) {
          paramString = paramb.bitmap;
        }
        p.j(paramString, "imageData?.bitmap");
        if (!paramString.isRecycled())
        {
          paramString = new com.tencent.mm.videocomposition.effect.a();
          paramView = paramb.bitmap;
          p.j(paramView, "imageData.bitmap");
          paramString.setInputBitmap(paramView);
          paramView = this.GfQ;
          p.j(paramView, "coverIv");
          int i = paramView.getWidth();
          paramView = this.GfQ;
          p.j(paramView, "coverIv");
          paramString.setOutputSize(i, paramView.getHeight());
          paramString.YIy.ANo.ikd();
          paramString.af((kotlin.g.a.b)new a(this));
        }
      }
      AppMethodBeat.o(227744);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    a(c.e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.e
 * JD-Core Version:    0.7.0.1
 */