package com.tencent.mm.plugin.remittance.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;

final class RemittanceBaseUI$3
  implements a
{
  RemittanceBaseUI$3(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(142141);
    if (paramBoolean)
    {
      RemittanceBaseUI.a(this.qmk, this.qmk.nIO, this.qmk.gJr);
      AppMethodBeat.o(142141);
      return;
    }
    this.qmk.nIO.scrollTo(0, 0);
    AppMethodBeat.o(142141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.3
 * JD-Core Version:    0.7.0.1
 */