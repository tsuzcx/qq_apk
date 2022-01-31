package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.b;

final class WalletPhoneInputView$2
  implements View.OnClickListener
{
  WalletPhoneInputView$2(WalletPhoneInputView paramWalletPhoneInputView) {}
  
  public final void onClick(View paramView)
  {
    int i = a.g.wallet_phone_illustration_dialog;
    int j = a.i.wallet_card_phone_illustraction;
    b.a((MMActivity)this.qIp.getContext(), i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.2
 * JD-Core Version:    0.7.0.1
 */