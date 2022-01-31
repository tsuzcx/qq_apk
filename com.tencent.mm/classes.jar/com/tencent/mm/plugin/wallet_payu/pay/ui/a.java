package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.g;
import java.util.ArrayList;

public final class a
  extends g
{
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    super(paramContext, paramArrayList, paramInt, paramOrders);
  }
  
  public final Bankcard AH(int paramInt)
  {
    if ((this.qgr != null) && (this.qgr.size() != 0)) {
      return (Bankcard)this.qgr.get(paramInt);
    }
    if (paramInt != getCount() - 1) {
      return (Bankcard)this.qgr.get(paramInt);
    }
    return null;
  }
  
  public final int getCount()
  {
    if ((this.qgr != null) && (this.qgr.size() != 0)) {
      return this.qgr.size();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */