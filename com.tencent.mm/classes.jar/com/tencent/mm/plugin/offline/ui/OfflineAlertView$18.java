package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class OfflineAlertView$18
  implements View.OnClickListener
{
  OfflineAlertView$18(OfflineAlertView paramOfflineAlertView, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203332);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent();
    paramView.putExtra("wallet_lock_jsapi_scene", 2);
    c.b(this.GDJ.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramView);
    a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.18
 * JD-Core Version:    0.7.0.1
 */