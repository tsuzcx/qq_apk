package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.e;

final class a$1
  implements h.a
{
  a$1(a parama, int paramInt, String paramString, MMActivity paramMMActivity) {}
  
  public final void onClick(View paramView)
  {
    e.a(3, bk.UX(), this.qsC);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.qsD);
    paramView.putExtra("showShare", false);
    d.b(this.byc, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.1
 * JD-Core Version:    0.7.0.1
 */