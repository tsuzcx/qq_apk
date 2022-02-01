package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d;

final class WcPayRealnameVerifyMainUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WcPayRealnameVerifyMainUI$2(WcPayRealnameVerifyMainUI paramWcPayRealnameVerifyMainUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(70119);
    paramMenuItem = this.HTw.getProcess();
    if (paramMenuItem != null)
    {
      paramMenuItem.g(this.HTw.getContext(), 0);
      AppMethodBeat.o(70119);
      return true;
    }
    this.HTw.finish();
    AppMethodBeat.o(70119);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.2
 * JD-Core Version:    0.7.0.1
 */