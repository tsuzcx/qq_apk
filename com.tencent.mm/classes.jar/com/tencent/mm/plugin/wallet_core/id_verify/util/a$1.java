package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.e;

final class a$1
  implements j.a
{
  a$1(a parama, int paramInt, String paramString, MMActivity paramMMActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46666);
    e.a(3, bo.aox(), this.ueO);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.ueP);
    paramView.putExtra("showShare", false);
    d.b(this.cae, "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(46666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.1
 * JD-Core Version:    0.7.0.1
 */