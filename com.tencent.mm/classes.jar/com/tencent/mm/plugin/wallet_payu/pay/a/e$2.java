package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$2
  extends g
{
  e$2(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.e.2
 * JD-Core Version:    0.7.0.1
 */