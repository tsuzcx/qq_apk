package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.plugin.wxpay.a.e;

final class RemittanceBaseUI$29
  implements Runnable
{
  RemittanceBaseUI$29(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(67982);
    Bitmap localBitmap = d.a(this.Ipl.iSn, false, -1, null);
    if (localBitmap == null)
    {
      this.Ipl.Ios.setImageResource(a.e.default_avatar);
      AppMethodBeat.o(67982);
      return;
    }
    this.Ipl.Ios.setImageBitmap(localBitmap);
    AppMethodBeat.o(67982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.29
 * JD-Core Version:    0.7.0.1
 */