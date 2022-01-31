package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayRealnameVerifyIdInputUI$12
  implements View.OnClickListener
{
  WcPayRealnameVerifyIdInputUI$12(WcPayRealnameVerifyIdInputUI paramWcPayRealnameVerifyIdInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142429);
    ab.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
    WcPayRealnameVerifyIdInputUI.b(this.udw).udH.setValue(Boolean.TRUE);
    AppMethodBeat.o(142429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.12
 * JD-Core Version:    0.7.0.1
 */