package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Paint;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletBindCardResultUI$6
  implements Runnable
{
  WalletBindCardResultUI$6(WalletBindCardResultUI paramWalletBindCardResultUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(47191);
    if ((WalletBindCardResultUI.g(this.unQ).getVisibility() == 0) && (WalletBindCardResultUI.h(this.unQ).getRight() >= WalletBindCardResultUI.g(this.unQ).getLeft()) && (!bo.aa(WalletBindCardResultUI.h(this.unQ).getText())))
    {
      float f1 = WalletBindCardResultUI.h(this.unQ).getTextSize();
      ab.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletBindCardResultUI.h(this.unQ).getRight()), Integer.valueOf(WalletBindCardResultUI.g(this.unQ).getLeft()) });
      Paint localPaint = new Paint();
      localPaint.setTextSize(f1);
      String str = WalletBindCardResultUI.h(this.unQ).getText().toString();
      f1 = localPaint.measureText(str);
      float f2 = WalletBindCardResultUI.h(this.unQ).getRight() - WalletBindCardResultUI.g(this.unQ).getLeft();
      int i = 1;
      while ((localPaint.measureText(str.substring(0, str.length() - i - 1)) > f1 - f2) && (i <= str.length() - 1)) {
        i += 1;
      }
      ab.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()) });
      WalletBindCardResultUI.h(this.unQ).setText(str.substring(0, str.length() - i - 1));
      WalletBindCardResultUI.h(this.unQ).append("...");
    }
    AppMethodBeat.o(47191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.6
 * JD-Core Version:    0.7.0.1
 */