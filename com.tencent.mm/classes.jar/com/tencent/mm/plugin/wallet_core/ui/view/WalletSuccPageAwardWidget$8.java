package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Paint;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletSuccPageAwardWidget$8
  implements Runnable
{
  WalletSuccPageAwardWidget$8(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void run()
  {
    try
    {
      if ((WalletSuccPageAwardWidget.s(this.qJe).getVisibility() == 0) && (WalletSuccPageAwardWidget.t(this.qJe).getRight() > 0) && (WalletSuccPageAwardWidget.s(this.qJe).getLeft() > 0) && (WalletSuccPageAwardWidget.t(this.qJe).getRight() >= WalletSuccPageAwardWidget.s(this.qJe).getLeft()) && (!bk.L(WalletSuccPageAwardWidget.t(this.qJe).getText())))
      {
        float f = WalletSuccPageAwardWidget.t(this.qJe).getTextSize();
        y.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.t(this.qJe).getRight()), Integer.valueOf(WalletSuccPageAwardWidget.s(this.qJe).getLeft()) });
        Object localObject = new Paint();
        ((Paint)localObject).setTextSize(f);
        String str2 = WalletSuccPageAwardWidget.t(this.qJe).getText().toString();
        f = WalletSuccPageAwardWidget.s(this.qJe).getLeft() - WalletSuccPageAwardWidget.t(this.qJe).getLeft();
        int i = 1;
        while ((((Paint)localObject).measureText(str2.substring(0, str2.length() - i - 1)) > f) && (i <= str2.length() - 1)) {
          i += 1;
        }
        y.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str2.length()) });
        String str1 = str2.substring(0, str2.length() - i - 1);
        localObject = str1;
        if (str2.length() > 9)
        {
          localObject = str1;
          if (str1.length() < 9) {
            localObject = str2.substring(0, 9);
          }
        }
        WalletSuccPageAwardWidget.t(this.qJe).setText((CharSequence)localObject);
        WalletSuccPageAwardWidget.t(this.qJe).append("...");
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", localException, "calc nameTv len error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.8
 * JD-Core Version:    0.7.0.1
 */