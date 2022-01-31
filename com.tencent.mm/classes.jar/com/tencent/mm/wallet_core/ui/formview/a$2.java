package com.tencent.mm.wallet_core.ui.formview;

import com.tenpay.android.wechat.TenpaySecureEditText;

final class a$2
  extends a.b
{
  a$2()
  {
    super((byte)0);
  }
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    if (paramWalletFormView.wCS == null) {
      return false;
    }
    return paramWalletFormView.wCS.isMoneyAmount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.2
 * JD-Core Version:    0.7.0.1
 */