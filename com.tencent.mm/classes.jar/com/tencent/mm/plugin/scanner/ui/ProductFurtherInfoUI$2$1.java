package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;

final class ProductFurtherInfoUI$2$1
  implements h.d
{
  ProductFurtherInfoUI$2$1(ProductFurtherInfoUI.2 param2) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    do
    {
      return;
    } while (bk.bl(ProductFurtherInfoUI.a(this.nJR.nJQ)));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", ProductFurtherInfoUI.a(this.nJR.nJQ));
    d.b(this.nJR.nJQ.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.2.1
 * JD-Core Version:    0.7.0.1
 */