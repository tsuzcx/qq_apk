package com.tencent.mm.wallet_core.ui.formview;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import com.tencent.mm.sdk.platformtools.bk;
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
    if (paramWalletFormView.wCS == null) {
      return false;
    }
    return paramWalletFormView.wCS.isBankcardNum();
  }
  
  public final boolean bvo()
  {
    return true;
  }
  
  public final boolean c(WalletFormView paramWalletFormView, String paramString)
  {
    if ((!bk.bl(paramString)) && (paramString.length() <= 5))
    {
      paramWalletFormView.setSelection(0);
      paramWalletFormView.setBankcardTail(paramString);
      paramWalletFormView.setMaxInputLength(24 - paramString.length());
      paramWalletFormView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramWalletFormView.getMaxInputLength()) });
      return true;
    }
    return false;
  }
  
  public final boolean d(WalletFormView paramWalletFormView, String paramString)
  {
    if ((!bk.bl(paramString)) && (paramString.length() <= 5))
    {
      paramWalletFormView.setSelection(0);
      paramWalletFormView.set3DesToView(paramString);
      paramWalletFormView.setMaxInputLength(24 - paramString.length());
      paramWalletFormView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramWalletFormView.getMaxInputLength()) });
      return true;
    }
    return false;
  }
  
  public final String e(WalletFormView paramWalletFormView, String paramString)
  {
    return bk.aM(paramString, "").replaceAll(" ", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.1
 * JD-Core Version:    0.7.0.1
 */