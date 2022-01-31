package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.d;

final class ProductFurtherInfoUI$2$1
  implements h.d
{
  ProductFurtherInfoUI$2$1(ProductFurtherInfoUI.2 param2) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(81044);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81044);
      return;
      if (!bo.isNullOrNil(ProductFurtherInfoUI.a(this.qxt.qxs)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", ProductFurtherInfoUI.a(this.qxt.qxs));
        d.b(this.qxt.qxs.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.2.1
 * JD-Core Version:    0.7.0.1
 */