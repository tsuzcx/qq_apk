package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WcPayRealnameVerifyMainUI$4
  implements View.OnClickListener
{
  WcPayRealnameVerifyMainUI$4(WcPayRealnameVerifyMainUI paramWcPayRealnameVerifyMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70124);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("wallet_lock_jsapi_scene", 2);
    c.b(this.HTw.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramView);
    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.4
 * JD-Core Version:    0.7.0.1
 */