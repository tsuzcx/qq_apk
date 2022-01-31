package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.at.b.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.Map;

final class WalletPhoneInputView$5
  implements View.OnFocusChangeListener
{
  WalletPhoneInputView$5(WalletPhoneInputView paramWalletPhoneInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if ((b.a)WalletPhoneInputView.h(this.qIp).get(WalletPhoneInputView.e(this.qIp).getText().toString()) == null)
      {
        WalletPhoneInputView.d(this.qIp).setContentTextColorRes(a.c.red_text_color);
        WalletPhoneInputView.e(this.qIp).setTextColor(this.qIp.getResources().getColor(a.c.red_text_color));
      }
    }
    else {
      return;
    }
    WalletPhoneInputView.d(this.qIp).setContentTextColorRes(a.c.normal_text_color);
    WalletPhoneInputView.e(this.qIp).setTextColor(this.qIp.getResources().getColor(a.c.normal_text_color));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.5
 * JD-Core Version:    0.7.0.1
 */