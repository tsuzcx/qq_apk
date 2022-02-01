package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.re;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;
import java.lang.ref.WeakReference;

final class q$9
  implements View.OnClickListener
{
  q$9(ECardInfo paramECardInfo, Context paramContext, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70963);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[] { Integer.valueOf(this.VPu.VEP) });
    if (this.VPu.VEP == 1) {
      i.p(this.val$context, this.VPu.igG, false);
    }
    for (;;)
    {
      if ((this.Qqb != null) && (this.Qqb.isShowing())) {
        this.Qqb.dismiss();
      }
      a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70963);
      return;
      paramView = new re();
      paramView.hUj.contextRef = new WeakReference(this.val$context);
      paramView.publish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.9
 * JD-Core Version:    0.7.0.1
 */