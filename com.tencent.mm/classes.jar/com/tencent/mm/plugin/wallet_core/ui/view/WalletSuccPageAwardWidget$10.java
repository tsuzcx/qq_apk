package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Paint;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletSuccPageAwardWidget$10
  implements Runnable
{
  WalletSuccPageAwardWidget$10(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void run()
  {
    AppMethodBeat.i(47954);
    try
    {
      if ((WalletSuccPageAwardWidget.s(this.uxM).getVisibility() == 0) && (WalletSuccPageAwardWidget.t(this.uxM).getRight() > 0) && (WalletSuccPageAwardWidget.s(this.uxM).getLeft() > 0) && (WalletSuccPageAwardWidget.t(this.uxM).getRight() >= WalletSuccPageAwardWidget.s(this.uxM).getLeft()) && (!bo.aa(WalletSuccPageAwardWidget.t(this.uxM).getText())))
      {
        float f = WalletSuccPageAwardWidget.t(this.uxM).getTextSize();
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.t(this.uxM).getRight()), Integer.valueOf(WalletSuccPageAwardWidget.s(this.uxM).getLeft()) });
        Object localObject = new Paint();
        ((Paint)localObject).setTextSize(f);
        String str2 = WalletSuccPageAwardWidget.t(this.uxM).getText().toString();
        f = WalletSuccPageAwardWidget.s(this.uxM).getLeft() - WalletSuccPageAwardWidget.t(this.uxM).getLeft();
        int i = 1;
        while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
          i += 1;
        }
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
        String str1 = str2.substring(0, str2.length() - i - 1);
        localObject = str1;
        if (str2.length() > 9)
        {
          localObject = str1;
          if (str1.length() < 9) {
            localObject = str2.substring(0, 9);
          }
        }
        WalletSuccPageAwardWidget.t(this.uxM).setText((CharSequence)localObject);
        WalletSuccPageAwardWidget.t(this.uxM).append("...");
      }
      AppMethodBeat.o(47954);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException, "calc nameTv len error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(47954);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.10
 * JD-Core Version:    0.7.0.1
 */