package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SwitchRealnameVerifyModeUI$8
  implements View.OnClickListener
{
  SwitchRealnameVerifyModeUI$8(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70025);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("wallet_lock_jsapi_scene", 2);
    c.b(this.Vzj, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramView);
    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.8
 * JD-Core Version:    0.7.0.1
 */