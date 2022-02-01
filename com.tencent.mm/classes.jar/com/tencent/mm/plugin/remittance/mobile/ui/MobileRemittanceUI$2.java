package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class MobileRemittanceUI$2
  implements TextView.OnEditorActionListener
{
  MobileRemittanceUI$2(MobileRemittanceUI paramMobileRemittanceUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67758);
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66) && (MobileRemittanceUI.r(this.xXk).isShown()))
    {
      ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
      this.xXl.onClick(null);
      AppMethodBeat.o(67758);
      return true;
    }
    AppMethodBeat.o(67758);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.2
 * JD-Core Version:    0.7.0.1
 */