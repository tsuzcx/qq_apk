package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class a$a
  extends a.b
{
  private int AYR;
  private WalletFormView AYS;
  
  public a$a(WalletFormView paramWalletFormView)
  {
    this(paramWalletFormView, (byte)0);
  }
  
  public a$a(WalletFormView paramWalletFormView, byte paramByte)
  {
    super((byte)0);
    AppMethodBeat.i(49368);
    this.AYR = 1;
    this.AYS = paramWalletFormView;
    this.AYR = 1;
    dSX();
    AppMethodBeat.o(49368);
  }
  
  private void dSX()
  {
    AppMethodBeat.i(49370);
    if (this.AYR == 1)
    {
      if (this.AYS != null)
      {
        this.AYS.setKeyListener(new a.a.1(this));
        AppMethodBeat.o(49370);
      }
    }
    else if (this.AYS != null) {
      this.AYS.setInputType(1);
    }
    AppMethodBeat.o(49370);
  }
  
  public final void RY(int paramInt)
  {
    AppMethodBeat.i(49369);
    this.AYR = paramInt;
    dSX();
    AppMethodBeat.o(49369);
  }
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49371);
    int i = this.AYR;
    if (paramWalletFormView.AZe == null)
    {
      AppMethodBeat.o(49371);
      return false;
    }
    boolean bool = paramWalletFormView.AZe.isAreaIDCardNum(i);
    AppMethodBeat.o(49371);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.a
 * JD-Core Version:    0.7.0.1
 */