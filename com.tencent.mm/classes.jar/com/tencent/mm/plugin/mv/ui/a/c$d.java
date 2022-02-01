package com.tencent.mm.plugin.mv.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initBgCover$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$d
  implements h
{
  c$d(c paramc, ImageView paramImageView) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
  {
    paramView = null;
    AppMethodBeat.i(288204);
    s.u(paramString, "url");
    if (paramb == null)
    {
      paramString = null;
      if (paramString != null) {
        if (paramb != null) {
          break label133;
        }
      }
    }
    label133:
    for (paramString = paramView;; paramString = paramb.bitmap)
    {
      if (!paramString.isRecycled())
      {
        paramString = new com.tencent.mm.videocomposition.effect.a();
        paramView = paramb.bitmap;
        s.s(paramView, "imageData.bitmap");
        paramString.setInputBitmap(paramView);
        paramString.setOutputSize(com.tencent.mm.cd.a.ms((Context)this.Mbf.activity), com.tencent.mm.cd.a.mt((Context)this.Mbf.activity));
        paramString.HkF.GpO.jQk();
        paramString.aW((kotlin.g.a.b)new c.d.a(this.Mbh));
      }
      AppMethodBeat.o(288204);
      return;
      paramString = paramb.bitmap;
      break;
    }
  }
  
  public final void c(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.d
 * JD-Core Version:    0.7.0.1
 */