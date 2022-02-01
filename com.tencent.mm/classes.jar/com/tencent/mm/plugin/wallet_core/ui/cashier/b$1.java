package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71416);
    Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
    this.BLa.cancel();
    AppMethodBeat.o(71416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b.1
 * JD-Core Version:    0.7.0.1
 */