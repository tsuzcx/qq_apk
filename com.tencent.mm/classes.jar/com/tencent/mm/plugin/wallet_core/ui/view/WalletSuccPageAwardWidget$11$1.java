package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSuccPageAwardWidget$11$1
  implements Runnable
{
  WalletSuccPageAwardWidget$11$1(WalletSuccPageAwardWidget.11 param11, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(47955);
    WalletSuccPageAwardWidget.u(this.uxR.uxM).setScaleType(ImageView.ScaleType.CENTER_CROP);
    WalletSuccPageAwardWidget.u(this.uxR.uxM).setImageBitmap(this.val$bitmap);
    AppMethodBeat.o(47955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.11.1
 * JD-Core Version:    0.7.0.1
 */