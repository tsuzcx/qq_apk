package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c;

final class WcPayRealnameVerifyMainUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WcPayRealnameVerifyMainUI$2(WcPayRealnameVerifyMainUI paramWcPayRealnameVerifyMainUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142457);
    paramMenuItem = this.udW.getProcess();
    if (paramMenuItem != null)
    {
      paramMenuItem.e(this.udW.getContext(), 0);
      AppMethodBeat.o(142457);
      return true;
    }
    this.udW.finish();
    AppMethodBeat.o(142457);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.2
 * JD-Core Version:    0.7.0.1
 */