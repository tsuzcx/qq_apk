package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;

final class WcPayRealnameVerifyIdInputUI$16$1
  implements a.a
{
  WcPayRealnameVerifyIdInputUI$16$1(WcPayRealnameVerifyIdInputUI.16 param16, a parama) {}
  
  public final void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142435);
    if (paramBoolean)
    {
      String str = String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      WcPayRealnameVerifyIdInputUI.b(this.udD.udw).udQ.setValue(str);
    }
    this.udA.hide();
    AppMethodBeat.o(142435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.16.1
 * JD-Core Version:    0.7.0.1
 */