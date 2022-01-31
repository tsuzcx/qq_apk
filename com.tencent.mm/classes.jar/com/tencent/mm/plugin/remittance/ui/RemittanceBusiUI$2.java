package com.tencent.mm.plugin.remittance.ui;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RemittanceBusiUI$2
  implements Runnable
{
  RemittanceBusiUI$2(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(142175);
    RemittanceBusiUI.a(this.qoF, RemittanceBusiUI.v(this.qoF).getWidth());
    RemittanceBusiUI.w(this.qoF).setVisibility(8);
    ab.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.x(this.qoF)) });
    AppMethodBeat.o(142175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.2
 * JD-Core Version:    0.7.0.1
 */