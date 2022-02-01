package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.cn.a;
import com.tencent.mm.g.a.cn.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h.d;

final class ProductUI$6$1
  implements h.d
{
  ProductUI$6$1(ProductUI.6 param6) {}
  
  public final void ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51856);
    switch (paramInt2)
    {
    default: 
      ac.d("MicroMsg.scanner.ProductUI", "do del cancel");
    }
    cn localcn;
    do
    {
      AppMethodBeat.o(51856);
      return;
      localcn = new cn();
      localcn.dce.dcg = this.xdP.xdM.getIntent().getLongExtra("key_favorite_local_id", -1L);
      a.GpY.l(localcn);
      ac.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[] { Long.valueOf(localcn.dce.dcg), Boolean.valueOf(localcn.dcf.dbS) });
    } while (!localcn.dcf.dbS);
    this.xdP.xdM.finish();
    AppMethodBeat.o(51856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.6.1
 * JD-Core Version:    0.7.0.1
 */