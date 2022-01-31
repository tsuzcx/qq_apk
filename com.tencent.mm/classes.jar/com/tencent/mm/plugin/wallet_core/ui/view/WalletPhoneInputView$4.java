package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.at.b.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.Map;

final class WalletPhoneInputView$4
  implements TextWatcher
{
  WalletPhoneInputView$4(WalletPhoneInputView paramWalletPhoneInputView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (bk.bl(paramEditable.toString()))
    {
      WalletPhoneInputView.d(this.qIp).setText("");
      WalletPhoneInputView.d(this.qIp).setContentTextColorRes(a.c.normal_text_color);
      WalletPhoneInputView.e(this.qIp).setTextColor(this.qIp.getResources().getColor(a.c.normal_text_color));
      return;
    }
    if (!WalletPhoneInputView.f(this.qIp))
    {
      y.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
      WalletPhoneInputView.d(this.qIp).setContentTextColorRes(a.c.normal_text_color);
      WalletPhoneInputView.e(this.qIp).setTextColor(this.qIp.getResources().getColor(a.c.normal_text_color));
      WalletPhoneInputView.g(this.qIp);
      return;
    }
    b.a locala = (b.a)WalletPhoneInputView.h(this.qIp).get(paramEditable.toString());
    y.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", new Object[] { locala, paramEditable.toString() });
    if (locala != null)
    {
      WalletPhoneInputView.a(this.qIp, locala.esf);
      WalletPhoneInputView.b(this.qIp, locala.esg);
      WalletPhoneInputView.d(this.qIp).setText(locala.esg);
      WalletPhoneInputView.d(this.qIp).setContentTextColorRes(a.c.normal_text_color);
      WalletPhoneInputView.e(this.qIp).setTextColor(this.qIp.getResources().getColor(a.c.normal_text_color));
    }
    for (;;)
    {
      WalletPhoneInputView.c(this.qIp).getInputValidChangeListener().gG(WalletPhoneInputView.c(this.qIp).YL());
      return;
      WalletPhoneInputView.a(this.qIp, "");
      WalletPhoneInputView.b(this.qIp, "");
      WalletPhoneInputView.d(this.qIp).setText(this.qIp.getContext().getString(a.i.wallet_phone_invalid_country_code));
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.4
 * JD-Core Version:    0.7.0.1
 */