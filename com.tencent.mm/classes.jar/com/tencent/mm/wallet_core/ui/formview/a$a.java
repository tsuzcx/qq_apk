package com.tencent.mm.wallet_core.ui.formview;

import com.tenpay.android.wechat.TenpaySecureEditText;

public final class a$a
  extends a.b
{
  private int wCF = 1;
  private WalletFormView wCG;
  
  public a$a(WalletFormView paramWalletFormView)
  {
    this(paramWalletFormView, (byte)0);
  }
  
  public a$a(WalletFormView paramWalletFormView, byte paramByte)
  {
    super((byte)0);
    this.wCG = paramWalletFormView;
    this.wCF = 1;
    cNt();
  }
  
  private void cNt()
  {
    if (this.wCF == 1) {
      if (this.wCG != null) {
        this.wCG.setKeyListener(new a.a.1(this));
      }
    }
    while (this.wCG == null) {
      return;
    }
    this.wCG.setInputType(1);
  }
  
  public final void Jd(int paramInt)
  {
    this.wCF = paramInt;
    cNt();
  }
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    int i = this.wCF;
    if (paramWalletFormView.wCS == null) {
      return false;
    }
    return paramWalletFormView.wCS.isAreaIDCardNum(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.a
 * JD-Core Version:    0.7.0.1
 */