package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$14
  extends b.a
{
  b$14(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return super.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (Orders)paramVarArgs[0];
    p.bTK();
    Bankcard localBankcard = p.bTL().qhj;
    localBankcard.qty += paramVarArgs.nCq;
    return false;
  }
  
  public final CharSequence vy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.vy(paramInt);
    case 0: 
      return this.gfb.getString(a.i.wallet_balance_result_save_title);
    }
    return this.gfb.getString(a.i.wallet_balance_result_save_success);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.14
 * JD-Core Version:    0.7.0.1
 */