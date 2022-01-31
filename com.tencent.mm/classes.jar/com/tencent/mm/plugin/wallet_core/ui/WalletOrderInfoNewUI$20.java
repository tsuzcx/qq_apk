package com.tencent.mm.plugin.wallet_core.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletOrderInfoNewUI$20
  implements Runnable
{
  WalletOrderInfoNewUI$20(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(47442);
    ViewGroup localViewGroup = (ViewGroup)this.ury.findViewById(2131825962);
    ViewGroup.LayoutParams localLayoutParams = this.qnn.getLayoutParams();
    localLayoutParams.width = localViewGroup.getWidth();
    localLayoutParams.height = localViewGroup.getHeight();
    this.qnn.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(47442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.20
 * JD-Core Version:    0.7.0.1
 */