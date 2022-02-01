package com.tencent.mm.plugin.mv.ui.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initBgCover$2", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$e
  implements h
{
  c$e(ImageView paramImageView) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(288212);
    s.u(paramString, "url");
    if (paramb == null) {}
    for (paramString = null;; paramString = paramb.bitmap)
    {
      if ((paramString != null) && (!paramb.bitmap.isRecycled()))
      {
        paramString = BitmapUtil.fastblur(paramb.bitmap, 10);
        if (paramString != null) {
          d.uiThread((a)new a(this.Mbh, paramString));
        }
      }
      AppMethodBeat.o(288212);
      return;
    }
  }
  
  public final void c(String paramString, View paramView) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(ImageView paramImageView, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.e
 * JD-Core Version:    0.7.0.1
 */