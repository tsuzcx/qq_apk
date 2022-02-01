package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.di;
import com.tencent.mm.autogen.a.di.a;
import com.tencent.mm.autogen.a.di.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k.e;

final class ProductUI$5$1
  implements k.e
{
  ProductUI$5$1(ProductUI.5 param5) {}
  
  public final void onClick(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51856);
    switch (paramInt2)
    {
    default: 
      Log.d("MicroMsg.scanner.ProductUI", "do del cancel");
    }
    di localdi;
    do
    {
      AppMethodBeat.o(51856);
      return;
      localdi = new di();
      localdi.hDl.hDn = this.OZZ.OZW.getIntent().getLongExtra("key_favorite_local_id", -1L);
      localdi.publish();
      Log.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[] { Long.valueOf(localdi.hDl.hDn), Boolean.valueOf(localdi.hDm.hCQ) });
    } while (!localdi.hDm.hCQ);
    this.OZZ.OZW.finish();
    AppMethodBeat.o(51856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.5.1
 * JD-Core Version:    0.7.0.1
 */