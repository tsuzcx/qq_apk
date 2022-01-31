package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.lj;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;

public final class k$9
  implements View.OnClickListener
{
  public k$9(ECardInfo paramECardInfo, Context paramContext, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[] { Integer.valueOf(this.qDH.quP) });
    if (this.qDH.quP == 1) {
      e.l(this.val$context, this.qDH.cdp, false);
    }
    for (;;)
    {
      if ((this.oof != null) && (this.oof.isShowing())) {
        this.oof.dismiss();
      }
      return;
      paramView = new lj();
      paramView.bUt.aoB = new WeakReference(this.val$context);
      a.udP.m(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k.9
 * JD-Core Version:    0.7.0.1
 */