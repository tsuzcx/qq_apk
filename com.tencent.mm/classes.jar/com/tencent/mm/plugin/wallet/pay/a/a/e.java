package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class e
  extends b
{
  public e(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders, paramBoolean);
  }
  
  public final int getFuncId()
  {
    return 1536;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/sns_ff_authen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.e
 * JD-Core Version:    0.7.0.1
 */