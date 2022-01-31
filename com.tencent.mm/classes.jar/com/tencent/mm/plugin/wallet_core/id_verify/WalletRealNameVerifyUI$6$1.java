package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.h.d;

final class WalletRealNameVerifyUI$6$1
  implements h.d
{
  WalletRealNameVerifyUI$6$1(WalletRealNameVerifyUI.6 param6) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46625);
    Intent localIntent = new Intent();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      d.b(this.udg.udf.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(46625);
      return;
      localIntent.putExtra("rawUrl", this.udg.udf.getString(2131304778, new Object[] { aa.dsG() }));
      continue;
      if (WalletRealNameVerifyUI.e(this.udg.udf) != null) {
        localIntent.putExtra("rawUrl", this.udg.udf.getString(2131304776, new Object[] { aa.dsG(), WalletRealNameVerifyUI.e(this.udg.udf).poq }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.6.1
 * JD-Core Version:    0.7.0.1
 */