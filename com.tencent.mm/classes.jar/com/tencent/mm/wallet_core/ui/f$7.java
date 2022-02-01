package com.tencent.mm.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.g;
import com.tencent.mm.sdk.platformtools.Log;

final class f$7
  implements View.OnClickListener
{
  f$7(String paramString1, TextView paramTextView, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(72987);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.val$url);
    paramView.putExtra("showShare", true);
    c.b(this.RvH.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    g.gH(f.bnl(this.cPU), 1);
    a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f.7
 * JD-Core Version:    0.7.0.1
 */