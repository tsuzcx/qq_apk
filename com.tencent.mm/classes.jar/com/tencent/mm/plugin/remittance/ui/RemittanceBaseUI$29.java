package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;

final class RemittanceBaseUI$29
  implements Runnable
{
  RemittanceBaseUI$29(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(142160);
    Bitmap localBitmap = b.b(this.qmk.eaX, false, -1);
    if (localBitmap == null)
    {
      this.qmk.qlq.setImageResource(2130838493);
      AppMethodBeat.o(142160);
      return;
    }
    this.qmk.qlq.setImageBitmap(localBitmap);
    AppMethodBeat.o(142160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.29
 * JD-Core Version:    0.7.0.1
 */