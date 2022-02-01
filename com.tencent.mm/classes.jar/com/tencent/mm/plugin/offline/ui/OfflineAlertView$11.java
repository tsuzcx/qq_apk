package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;

final class OfflineAlertView$11
  implements View.OnClickListener
{
  OfflineAlertView$11(OfflineAlertView paramOfflineAlertView, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66348);
    paramView = new Intent();
    paramView.putExtra("wallet_lock_jsapi_scene", 2);
    d.b(this.ukS.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramView);
    AppMethodBeat.o(66348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.11
 * JD-Core Version:    0.7.0.1
 */