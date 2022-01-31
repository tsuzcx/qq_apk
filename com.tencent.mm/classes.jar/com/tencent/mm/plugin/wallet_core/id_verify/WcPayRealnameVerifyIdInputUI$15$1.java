package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class WcPayRealnameVerifyIdInputUI$15$1
  implements b.a
{
  WcPayRealnameVerifyIdInputUI$15$1(WcPayRealnameVerifyIdInputUI.15 param15, b paramb) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(142433);
    if (paramBoolean)
    {
      paramObject1 = WcPayRealnameVerifyIdInputUI.b(this.udC.udw);
      int i = this.val$optionPicker.dPp();
      paramObject1.udP.setValue(Integer.valueOf(i));
    }
    this.val$optionPicker.hide();
    AppMethodBeat.o(142433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.15.1
 * JD-Core Version:    0.7.0.1
 */