package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.Map;

final class WalletPhoneInputView$5
  implements View.OnFocusChangeListener
{
  WalletPhoneInputView$5(WalletPhoneInputView paramWalletPhoneInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(47912);
    if (!paramBoolean)
    {
      if ((b.a)WalletPhoneInputView.h(this.uwX).get(WalletPhoneInputView.e(this.uwX).getText().toString()) == null)
      {
        WalletPhoneInputView.d(this.uwX).setContentTextColorRes(2131690393);
        WalletPhoneInputView.e(this.uwX).setTextColor(this.uwX.getResources().getColor(2131690393));
        AppMethodBeat.o(47912);
        return;
      }
      WalletPhoneInputView.d(this.uwX).setContentTextColorRes(2131690322);
      WalletPhoneInputView.e(this.uwX).setTextColor(this.uwX.getResources().getColor(2131690322));
    }
    AppMethodBeat.o(47912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.5
 * JD-Core Version:    0.7.0.1
 */