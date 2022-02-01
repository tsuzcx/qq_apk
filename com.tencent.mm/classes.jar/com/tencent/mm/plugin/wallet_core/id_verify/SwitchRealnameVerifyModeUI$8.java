package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;

final class SwitchRealnameVerifyModeUI$8
  implements View.OnClickListener
{
  SwitchRealnameVerifyModeUI$8(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70025);
    paramView = new Intent();
    paramView.putExtra("wallet_lock_jsapi_scene", 2);
    d.b(this.zXJ, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramView);
    AppMethodBeat.o(70025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.8
 * JD-Core Version:    0.7.0.1
 */