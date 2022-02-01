package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class OfflineAlertView$15
  implements View.OnClickListener
{
  OfflineAlertView$15(OfflineAlertView paramOfflineAlertView, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(189944);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Intent();
    paramView.putExtra("wallet_lock_jsapi_scene", 2);
    d.b(this.wOS.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramView);
    a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(189944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.15
 * JD-Core Version:    0.7.0.1
 */