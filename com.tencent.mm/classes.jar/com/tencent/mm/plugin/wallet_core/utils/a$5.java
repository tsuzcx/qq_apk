package com.tencent.mm.plugin.wallet_core.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.bo;

final class a$5
  implements Runnable
{
  a$5(a parama, g paramg, ImageView paramImageView, a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(47988);
    if (!bo.isNullOrNil(this.uxY.ugo))
    {
      Bitmap localBitmap = x.a(new c(this.uxY.ugo));
      this.lHj.setImageBitmap(localBitmap);
      x.a(this.uxW);
      AppMethodBeat.o(47988);
      return;
    }
    if (this.uxY.ugs > 0) {
      this.lHj.setImageResource(this.uxY.ugs);
    }
    AppMethodBeat.o(47988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.5
 * JD-Core Version:    0.7.0.1
 */