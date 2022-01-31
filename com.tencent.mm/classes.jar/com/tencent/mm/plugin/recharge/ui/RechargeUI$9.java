package com.tencent.mm.plugin.recharge.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RechargeUI$9
  implements Runnable
{
  RechargeUI$9(RechargeUI paramRechargeUI, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(44314);
    RechargeUI.o(this.pWS).setImageBitmap(this.val$bitmap);
    AppMethodBeat.o(44314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.9
 * JD-Core Version:    0.7.0.1
 */