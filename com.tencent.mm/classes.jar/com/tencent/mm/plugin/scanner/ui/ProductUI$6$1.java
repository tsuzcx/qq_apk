package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cy;
import com.tencent.mm.f.a.cy.a;
import com.tencent.mm.f.a.cy.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h.e;

final class ProductUI$6$1
  implements h.e
{
  ProductUI$6$1(ProductUI.6 param6) {}
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51856);
    switch (paramInt2)
    {
    default: 
      Log.d("MicroMsg.scanner.ProductUI", "do del cancel");
    }
    cy localcy;
    do
    {
      AppMethodBeat.o(51856);
      return;
      localcy = new cy();
      localcy.fyC.fyE = this.IRe.IRb.getIntent().getLongExtra("key_favorite_local_id", -1L);
      EventCenter.instance.publish(localcy);
      Log.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[] { Long.valueOf(localcy.fyC.fyE), Boolean.valueOf(localcy.fyD.fyl) });
    } while (!localcy.fyD.fyl);
    this.IRe.IRb.finish();
    AppMethodBeat.o(51856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.6.1
 * JD-Core Version:    0.7.0.1
 */