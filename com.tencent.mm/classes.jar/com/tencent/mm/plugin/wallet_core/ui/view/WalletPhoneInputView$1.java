package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class WalletPhoneInputView$1
  implements View.OnClickListener
{
  WalletPhoneInputView$1(WalletPhoneInputView paramWalletPhoneInputView) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.WalletPhoneInputView", "click area");
    paramView = new Intent();
    paramView.setClassName(this.qIp.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
    ((MMActivity)this.qIp.getContext()).startActivityForResult(paramView, 65521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.1
 * JD-Core Version:    0.7.0.1
 */