package com.tencent.mm.plugin.mv.ui.uic;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgCover$imageLoaderListener$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n$a
  implements h
{
  n$a(n paramn, ImageView paramImageView, u paramu) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(288053);
    s.u(paramString, "url");
    s.u(paramView, "view");
    s.u(paramb, "imageData");
    AppMethodBeat.o(288053);
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    boolean bool = false;
    AppMethodBeat.i(288062);
    s.u(paramString, "url");
    s.u(paramView, "view");
    s.u(paramb, "imageData");
    paramView = this.Mgw.TAG;
    if (paramb.bitmap != null) {
      bool = true;
    }
    Log.i(paramView, "onImageLoadFinish %s %b", new Object[] { paramString, Boolean.valueOf(bool) });
    if ((paramb.bitmap != null) && (!paramb.bitmap.isRecycled())) {
      d.uiThread((a)new a(paramb.bitmap, this.Mbh, this.Mgx));
    }
    AppMethodBeat.o(288062);
  }
  
  public final void c(String paramString, View paramView)
  {
    AppMethodBeat.i(288047);
    s.u(paramString, "url");
    s.u(paramView, "view");
    AppMethodBeat.o(288047);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<ah>
  {
    a(Bitmap paramBitmap, ImageView paramImageView, u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.n.a
 * JD-Core Version:    0.7.0.1
 */