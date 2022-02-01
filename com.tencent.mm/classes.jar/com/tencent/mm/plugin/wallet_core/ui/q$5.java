package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;

final class q$5
  implements View.OnClickListener
{
  q$5(String paramString, Context paramContext, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70959);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = new Intent();
    localObject = this.VPv;
    Log.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
    paramView.putExtra("rawUrl", (String)localObject);
    paramView.putExtra("geta8key_username", z.bAM());
    paramView.putExtra("pay_channel", 1);
    i.aS(this.val$context, paramView);
    if ((this.Qqb != null) && (this.Qqb.isShowing())) {
      this.Qqb.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.5
 * JD-Core Version:    0.7.0.1
 */