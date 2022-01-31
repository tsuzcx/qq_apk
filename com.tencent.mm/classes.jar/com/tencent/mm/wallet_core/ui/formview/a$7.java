package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;

final class a$7
  implements View.OnClickListener
{
  a$7(MMActivity paramMMActivity) {}
  
  public final void onClick(View paramView)
  {
    int i = a.g.wallet_phone_illustration_dialog;
    int j = a.i.wallet_card_phone_illustraction;
    b.a(this.jxM, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.7
 * JD-Core Version:    0.7.0.1
 */