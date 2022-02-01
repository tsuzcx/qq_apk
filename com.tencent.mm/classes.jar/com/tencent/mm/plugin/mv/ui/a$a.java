package com.tencent.mm.plugin.mv.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MvLogic$loadAlphaAppIcon$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  implements h
{
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    paramView = null;
    AppMethodBeat.i(286407);
    s.u(paramString, "url");
    if (paramb == null)
    {
      paramString = null;
      if (paramString != null) {
        if (paramb != null) {
          break label48;
        }
      }
    }
    label48:
    for (paramString = paramView;; paramString = paramb.bitmap)
    {
      paramString.isRecycled();
      AppMethodBeat.o(286407);
      return;
      paramString = paramb.bitmap;
      break;
    }
  }
  
  public final void c(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.a
 * JD-Core Version:    0.7.0.1
 */