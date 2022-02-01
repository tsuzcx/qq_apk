package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e;

final class WcPayRealnameVerifyMainUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WcPayRealnameVerifyMainUI$2(WcPayRealnameVerifyMainUI paramWcPayRealnameVerifyMainUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(70119);
    paramMenuItem = this.VBp.getProcess();
    if (paramMenuItem != null)
    {
      paramMenuItem.i(this.VBp.getContext(), 0);
      AppMethodBeat.o(70119);
      return true;
    }
    this.VBp.finish();
    AppMethodBeat.o(70119);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.2
 * JD-Core Version:    0.7.0.1
 */