package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.d;

final class e$1
  implements h.d
{
  e$1(Context paramContext, String paramString) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      d.b(this.val$context, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
      localIntent.putExtra("rawUrl", this.val$context.getString(a.i.wallet_agreemnet_user, new Object[] { x.cqJ() }));
      continue;
      if (this.wCr != null)
      {
        localIntent.putExtra("rawUrl", this.val$context.getString(a.i.wallet_agreemnet_bank, new Object[] { x.cqJ(), this.wCr }));
        continue;
        if (this.wCr != null)
        {
          localIntent.putExtra("rawUrl", this.val$context.getString(a.i.wallet_agreemnet_wxcredit_bank, new Object[] { x.cqJ(), this.wCr }));
          continue;
          if (this.wCr != null) {
            localIntent.putExtra("rawUrl", this.val$context.getString(a.i.wallet_agreemnet_wxcredit_get, new Object[] { x.cqJ(), this.wCr }));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.1
 * JD-Core Version:    0.7.0.1
 */