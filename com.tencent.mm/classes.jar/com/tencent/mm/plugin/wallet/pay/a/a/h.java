package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class h
  extends b
{
  public h(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    super(paramAuthen, paramOrders, paramBoolean);
  }
  
  public final int getFuncId()
  {
    return 1972;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinepayauthen";
  }
  
  public final boolean isBlock()
  {
    if (this.HFI == null) {}
    while (this.HFI.BDB.Kxz == 1) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.h
 * JD-Core Version:    0.7.0.1
 */