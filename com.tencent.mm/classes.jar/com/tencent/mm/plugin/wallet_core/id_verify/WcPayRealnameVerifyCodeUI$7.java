package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class WcPayRealnameVerifyCodeUI$7
  implements View.OnClickListener
{
  WcPayRealnameVerifyCodeUI$7(WcPayRealnameVerifyCodeUI paramWcPayRealnameVerifyCodeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(174463);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click phone code layout");
    paramView = new Intent();
    paramView.setClassName(this.DiL.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
    this.DiL.startActivityForResult(paramView, 1);
    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(174463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.7
 * JD-Core Version:    0.7.0.1
 */