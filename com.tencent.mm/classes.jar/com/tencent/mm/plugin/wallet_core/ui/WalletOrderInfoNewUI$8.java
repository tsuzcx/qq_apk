package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Paint;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletOrderInfoNewUI$8
  implements Runnable
{
  WalletOrderInfoNewUI$8(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(142511);
    try
    {
      if ((WalletOrderInfoNewUI.v(this.ury).getVisibility() == 0) && (WalletOrderInfoNewUI.w(this.ury).getRight() > 0) && (WalletOrderInfoNewUI.v(this.ury).getLeft() > 0) && (WalletOrderInfoNewUI.w(this.ury).getRight() >= WalletOrderInfoNewUI.v(this.ury).getLeft()) && (!bo.aa(WalletOrderInfoNewUI.w(this.ury).getText())))
      {
        float f = WalletOrderInfoNewUI.w(this.ury).getTextSize();
        ab.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletOrderInfoNewUI.w(this.ury).getRight()), Integer.valueOf(WalletOrderInfoNewUI.v(this.ury).getLeft()) });
        Object localObject = new Paint();
        ((Paint)localObject).setTextSize(f);
        String str2 = WalletOrderInfoNewUI.w(this.ury).getText().toString();
        f = WalletOrderInfoNewUI.v(this.ury).getLeft() - WalletOrderInfoNewUI.w(this.ury).getLeft();
        int i = 1;
        while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
          i += 1;
        }
        ab.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
        String str1 = str2.substring(0, str2.length() - i - 1);
        localObject = str1;
        if (str2.length() > 9)
        {
          localObject = str1;
          if (str1.length() < 9) {
            localObject = str2.substring(0, 9);
          }
        }
        WalletOrderInfoNewUI.w(this.ury).setText((CharSequence)localObject);
        WalletOrderInfoNewUI.w(this.ury).append("...");
      }
      AppMethodBeat.o(142511);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", localException, "calc tinyapp name error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(142511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.8
 * JD-Core Version:    0.7.0.1
 */