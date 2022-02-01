package com.tencent.mm.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.g;
import com.tencent.mm.sdk.platformtools.ad;

final class e$7
  implements View.OnClickListener
{
  e$7(String paramString1, TextView paramTextView, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(72987);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.val$url);
    paramView.putExtra("showShare", true);
    d.b(this.LAb.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    g.gi(e.aWG(this.cBp), 1);
    a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.7
 * JD-Core Version:    0.7.0.1
 */