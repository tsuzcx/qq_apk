package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;

final class a$5
  implements View.OnClickListener
{
  a$5(WalletFormView paramWalletFormView, MMActivity paramMMActivity) {}
  
  public final void onClick(View paramView)
  {
    this.wCD.getContext();
    int i = ab.cMO();
    int j = a.i.cvv_tip_title;
    b.a(this.jxM, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.5
 * JD-Core Version:    0.7.0.1
 */