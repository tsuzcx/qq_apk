package com.tencent.mm.plugin.remittance.ui;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceNewBaseUI$30
  implements Runnable
{
  RemittanceNewBaseUI$30(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(142262);
    RemittanceNewBaseUI.a(this.qqR, RemittanceNewBaseUI.e(this.qqR).getWidth());
    RemittanceNewBaseUI.f(this.qqR).setVisibility(8);
    ab.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceNewBaseUI.g(this.qqR)) });
    AppMethodBeat.o(142262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.30
 * JD-Core Version:    0.7.0.1
 */