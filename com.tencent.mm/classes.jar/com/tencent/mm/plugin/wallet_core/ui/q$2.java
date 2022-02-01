package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;

final class q$2
  implements View.OnClickListener
{
  q$2(ECardInfo paramECardInfo, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70956);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = new Intent();
    localObject = this.VPu.VEO;
    Log.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { localObject });
    paramView.putExtra("rawUrl", (String)localObject);
    paramView.putExtra("geta8key_username", z.bAM());
    paramView.putExtra("pay_channel", 1);
    i.aS(this.val$context, paramView);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletIdCardTip$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.2
 * JD-Core Version:    0.7.0.1
 */