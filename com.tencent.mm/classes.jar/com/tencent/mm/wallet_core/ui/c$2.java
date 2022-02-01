package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.v;

final class c$2
  implements View.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(72949);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.d("MicroMsg.OfflinePopupWindow", "root on click");
    if ((this.agUO.qjH != null) && (this.agUO.qjH.isShowing())) {
      this.agUO.qjH.dismiss();
    }
    a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.2
 * JD-Core Version:    0.7.0.1
 */