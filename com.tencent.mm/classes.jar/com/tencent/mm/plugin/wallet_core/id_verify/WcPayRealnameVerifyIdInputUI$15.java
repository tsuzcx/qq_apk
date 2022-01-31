package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;

final class WcPayRealnameVerifyIdInputUI$15
  implements View.OnClickListener
{
  WcPayRealnameVerifyIdInputUI$15(WcPayRealnameVerifyIdInputUI paramWcPayRealnameVerifyIdInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142434);
    paramView = new b(this.udw.getContext(), WcPayRealnameVerifyIdInputUI.d(this.udw));
    paramView.AIW = new WcPayRealnameVerifyIdInputUI.15.1(this, paramView);
    if (WcPayRealnameVerifyIdInputUI.b(this.udw).udP.getValue() != null) {
      paramView.Rw(((Integer)WcPayRealnameVerifyIdInputUI.b(this.udw).udP.getValue()).intValue());
    }
    paramView.show();
    AppMethodBeat.o(142434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.15
 * JD-Core Version:    0.7.0.1
 */