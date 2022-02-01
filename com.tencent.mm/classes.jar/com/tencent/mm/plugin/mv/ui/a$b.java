package com.tencent.mm.plugin.mv.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MvLogic$loadAppIcon$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  implements b.k
{
  a$b(ImageView paramImageView, String paramString) {}
  
  public final void bFg()
  {
    AppMethodBeat.i(286409);
    this.FfV.setImageResource(this.MaA);
    AppMethodBeat.o(286409);
  }
  
  public final void bFh()
  {
    AppMethodBeat.i(286423);
    Log.e("MicroMsg.Mv.MvLogic", "alvinluo loadAppIcon failed");
    this.FfV.setImageResource(this.MaA);
    AppMethodBeat.o(286423);
  }
  
  public final String key()
  {
    return this.MaB;
  }
  
  public final void onBitmapLoaded(Bitmap paramBitmap)
  {
    AppMethodBeat.i(286415);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.FfV.setImageBitmap(paramBitmap);
      AppMethodBeat.o(286415);
      return;
    }
    bFh();
    AppMethodBeat.o(286415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.b
 * JD-Core Version:    0.7.0.1
 */