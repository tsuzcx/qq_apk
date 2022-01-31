package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class SwitchRealnameVerifyModeUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SwitchRealnameVerifyModeUI$7(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(46596);
    e.a(18, bo.aox(), SwitchRealnameVerifyModeUI.a(this.ucS));
    e.m(this.ucS.getContext(), SwitchRealnameVerifyModeUI.d(this.ucS), false);
    AppMethodBeat.o(46596);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.7
 * JD-Core Version:    0.7.0.1
 */