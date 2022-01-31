package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;

final class m$9
  implements View.OnClickListener
{
  m$9(ECardInfo paramECardInfo, Context paramContext, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47400);
    ab.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[] { Integer.valueOf(this.uqC.uhh) });
    if (this.uqC.uhh == 1) {
      e.m(this.val$context, this.uqC.cLZ, false);
    }
    for (;;)
    {
      if ((this.rcw != null) && (this.rcw.isShowing())) {
        this.rcw.dismiss();
      }
      AppMethodBeat.o(47400);
      return;
      paramView = new ly();
      paramView.cBY.aqU = new WeakReference(this.val$context);
      a.ymk.l(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m.9
 * JD-Core Version:    0.7.0.1
 */