package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.h.d;

final class WalletCardImportUI$5$1
  implements h.d
{
  WalletCardImportUI$5$1(WalletCardImportUI.5 param5) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47269);
    Intent localIntent = new Intent();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      d.b(this.upk.uph.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(47269);
      return;
      localIntent.putExtra("rawUrl", this.upk.uph.getString(2131304778, new Object[] { aa.dsG() }));
      continue;
      if (WalletCardImportUI.c(this.upk.uph) != null) {
        localIntent.putExtra("rawUrl", this.upk.uph.getString(2131304776, new Object[] { aa.dsG(), WalletCardImportUI.c(this.upk.uph).poq }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.5.1
 * JD-Core Version:    0.7.0.1
 */