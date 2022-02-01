package com.tencent.mm.plugin.mv.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.a.d.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MvLogic$loadAlphaAppIcon$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
public final class a$a
  implements h
{
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, b paramb)
  {
    paramView = null;
    AppMethodBeat.i(230909);
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
        paramString.isRecycled();
      }
      AppMethodBeat.o(230909);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.a
 * JD-Core Version:    0.7.0.1
 */