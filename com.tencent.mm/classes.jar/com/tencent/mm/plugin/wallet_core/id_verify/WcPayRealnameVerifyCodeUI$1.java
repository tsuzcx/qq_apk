package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d;

final class WcPayRealnameVerifyCodeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WcPayRealnameVerifyCodeUI$1(WcPayRealnameVerifyCodeUI paramWcPayRealnameVerifyCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(174457);
    paramMenuItem = this.CRh.getProcess();
    if (paramMenuItem != null) {
      paramMenuItem.g(this.CRh.getContext(), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(174457);
      return false;
      this.CRh.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.1
 * JD-Core Version:    0.7.0.1
 */