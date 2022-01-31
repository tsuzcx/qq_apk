package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class WcPayRealnameVerifyIdInputUI$3$1
  implements b.a
{
  WcPayRealnameVerifyIdInputUI$3$1(WcPayRealnameVerifyIdInputUI.3 param3, int[] paramArrayOfInt) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(142419);
    WcPayRealnameVerifyIdInputUI.i(this.udz.udw).hide();
    if ((paramBoolean) && (WcPayRealnameVerifyIdInputUI.i(this.udz.udw).dPp() < this.udy.length))
    {
      paramObject1 = WcPayRealnameVerifyIdInputUI.b(this.udz.udw);
      int i = this.udy[WcPayRealnameVerifyIdInputUI.i(this.udz.udw).dPp()];
      paramObject1.udF.setValue(Integer.valueOf(i));
      this.udz.udx = WcPayRealnameVerifyIdInputUI.i(this.udz.udw).dPp();
    }
    AppMethodBeat.o(142419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.3.1
 * JD-Core Version:    0.7.0.1
 */