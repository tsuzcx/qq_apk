package com.tencent.mm.plugin.mv.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MvLogic$loadAppIcon$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-mv_release"})
public final class a$a
  implements b.k
{
  a$a(ImageView paramImageView, String paramString) {}
  
  public final void I(Bitmap paramBitmap)
  {
    AppMethodBeat.i(256948);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.hYC.setImageBitmap(paramBitmap);
      AppMethodBeat.o(256948);
      return;
    }
    oD();
    AppMethodBeat.o(256948);
  }
  
  public final String Lb()
  {
    return this.ArC;
  }
  
  public final void aYg()
  {
    AppMethodBeat.i(256947);
    this.hYC.setImageResource(this.ArB);
    AppMethodBeat.o(256947);
  }
  
  public final void oD()
  {
    AppMethodBeat.i(256949);
    Log.e("MicroMsg.Mv.MvLogic", "alvinluo loadAppIcon failed");
    this.hYC.setImageResource(this.ArB);
    AppMethodBeat.o(256949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.a
 * JD-Core Version:    0.7.0.1
 */