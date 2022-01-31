package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WcPayRealnameVerifyIdInputUI$VM$1
  implements Observer<Object>
{
  WcPayRealnameVerifyIdInputUI$VM$1(WcPayRealnameVerifyIdInputUI.VM paramVM) {}
  
  public final void onChanged(Object paramObject)
  {
    AppMethodBeat.i(142440);
    if (WcPayRealnameVerifyIdInputUI.VM.a(this.udT))
    {
      this.udT.udN.setValue(Boolean.TRUE);
      AppMethodBeat.o(142440);
      return;
    }
    this.udT.udN.setValue(Boolean.FALSE);
    AppMethodBeat.o(142440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.VM.1
 * JD-Core Version:    0.7.0.1
 */