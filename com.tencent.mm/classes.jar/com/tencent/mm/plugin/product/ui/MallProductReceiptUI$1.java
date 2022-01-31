package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class MallProductReceiptUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MallProductReceiptUI$1(MallProductReceiptUI paramMallProductReceiptUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = 0;
    AppMethodBeat.i(44090);
    paramMenuItem = MallProductReceiptUI.a(this.pwk).getText().toString();
    if (!bo.isNullOrNil(paramMenuItem))
    {
      c localc = MallProductReceiptUI.b(this.pwk);
      localc.pud = new bse();
      bse localbse = localc.pud;
      if (bo.isNullOrNil(paramMenuItem))
      {
        localbse.xFH = i;
        localc.pud.nqY = paramMenuItem;
        this.pwk.finish();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(44090);
      return true;
      i = 1;
      break;
      t.makeText(this.pwk, 2131301476, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI.1
 * JD-Core Version:    0.7.0.1
 */