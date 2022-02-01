package com.tencent.mm.plugin.mv.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MvLogic$loadAppIcon$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-mv_release"})
public final class a$b
  implements b.k
{
  a$b(ImageView paramImageView, String paramString) {}
  
  public final void G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(230989);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.kNg.setImageBitmap(paramBitmap);
      AppMethodBeat.o(230989);
      return;
    }
    bhr();
    AppMethodBeat.o(230989);
  }
  
  public final void bhq()
  {
    AppMethodBeat.i(230988);
    this.kNg.setImageResource(this.Gfj);
    AppMethodBeat.o(230988);
  }
  
  public final void bhr()
  {
    AppMethodBeat.i(230991);
    Log.e("MicroMsg.Mv.MvLogic", "alvinluo loadAppIcon failed");
    this.kNg.setImageResource(this.Gfj);
    AppMethodBeat.o(230991);
  }
  
  public final String key()
  {
    return this.Gfk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.b
 * JD-Core Version:    0.7.0.1
 */