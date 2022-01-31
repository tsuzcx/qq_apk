package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class WcPayRealnameVerifyMainUI$4
  implements View.OnClickListener
{
  WcPayRealnameVerifyMainUI$4(WcPayRealnameVerifyMainUI paramWcPayRealnameVerifyMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142462);
    paramView = new Intent();
    paramView.putExtra("wallet_lock_jsapi_scene", 2);
    d.b(this.udW.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramView);
    AppMethodBeat.o(142462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI.4
 * JD-Core Version:    0.7.0.1
 */