package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;

final class RemittanceNewBaseUI$3
  implements Runnable
{
  RemittanceNewBaseUI$3(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(142228);
    Bitmap localBitmap = b.b(this.qqR.eaX, false, -1);
    if (localBitmap == null)
    {
      this.qqR.qlq.setImageResource(2130838493);
      AppMethodBeat.o(142228);
      return;
    }
    this.qqR.qlq.setImageBitmap(localBitmap);
    AppMethodBeat.o(142228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.3
 * JD-Core Version:    0.7.0.1
 */