package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(47911);
    if (bo.isNullOrNil(paramEditable.toString()))
    {
      WalletPhoneInputView.d(this.uwX).setText("");
      WalletPhoneInputView.d(this.uwX).setContentTextColorRes(2131690322);
      WalletPhoneInputView.e(this.uwX).setTextColor(this.uwX.getResources().getColor(2131690322));
      AppMethodBeat.o(47911);
      return;
    }
    if (!WalletPhoneInputView.f(this.uwX))
    {
      ab.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
      WalletPhoneInputView.d(this.uwX).setContentTextColorRes(2131690322);
      WalletPhoneInputView.e(this.uwX).setTextColor(this.uwX.getResources().getColor(2131690322));
      WalletPhoneInputView.g(this.uwX);
      AppMethodBeat.o(47911);
      return;
    }
    b.a locala = (b.a)WalletPhoneInputView.h(this.uwX).get(paramEditable.toString());
    ab.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", new Object[] { locala, paramEditable.toString() });
    if (locala != null)
    {
      WalletPhoneInputView.a(this.uwX, locala.fHS);
      WalletPhoneInputView.b(this.uwX, locala.fHT);
      WalletPhoneInputView.d(this.uwX).setText(locala.fHT);
      WalletPhoneInputView.d(this.uwX).setContentTextColorRes(2131690322);
      WalletPhoneInputView.e(this.uwX).setTextColor(this.uwX.getResources().getColor(2131690322));
    }
    for (;;)
    {
      WalletPhoneInputView.c(this.uwX).getInputValidChangeListener().onInputValidChange(WalletPhoneInputView.c(this.uwX).asv());
      AppMethodBeat.o(47911);
      return;
      WalletPhoneInputView.a(this.uwX, "");
      WalletPhoneInputView.b(this.uwX, "");
      WalletPhoneInputView.d(this.uwX).setText(this.uwX.getContext().getString(2131305521));
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.4
 * JD-Core Version:    0.7.0.1
 */