package com.tencent.mm.wallet_core.ui.formview;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class a$1
  extends a.b
{
  a$1()
  {
    super((byte)0);
  }
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49355);
    if (paramWalletFormView.AZe == null)
    {
      AppMethodBeat.o(49355);
      return false;
    }
    boolean bool = paramWalletFormView.AZe.isBankcardNum();
    AppMethodBeat.o(49355);
    return bool;
  }
  
  public final boolean c(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(49353);
    if ((!bo.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      paramWalletFormView.setSelection(0);
      paramWalletFormView.setBankcardTail(paramString);
      paramWalletFormView.setMaxInputLength(24 - paramString.length());
      paramWalletFormView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramWalletFormView.getMaxInputLength()) });
      AppMethodBeat.o(49353);
      return true;
    }
    AppMethodBeat.o(49353);
    return false;
  }
  
  public final boolean cfH()
  {
    return true;
  }
  
  public final boolean d(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(49354);
    if ((!bo.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      paramWalletFormView.setSelection(0);
      paramWalletFormView.set3DesToView(paramString);
      paramWalletFormView.setMaxInputLength(24 - paramString.length());
      paramWalletFormView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramWalletFormView.getMaxInputLength()) });
      AppMethodBeat.o(49354);
      return true;
    }
    AppMethodBeat.o(49354);
    return false;
  }
  
  public final String e(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(49356);
    paramWalletFormView = bo.bf(paramString, "").replaceAll(" ", "");
    AppMethodBeat.o(49356);
    return paramWalletFormView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.1
 * JD-Core Version:    0.7.0.1
 */