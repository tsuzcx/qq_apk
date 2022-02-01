package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.k;
import java.util.ArrayList;

public final class a
  extends k
{
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    super(paramContext, paramArrayList, paramInt, paramOrders);
  }
  
  public final Bankcard VS(int paramInt)
  {
    AppMethodBeat.i(72100);
    Bankcard localBankcard;
    if ((this.CQh != null) && (this.CQh.size() != 0))
    {
      localBankcard = (Bankcard)this.CQh.get(paramInt);
      AppMethodBeat.o(72100);
      return localBankcard;
    }
    if (paramInt != getCount() - 1)
    {
      localBankcard = (Bankcard)this.CQh.get(paramInt);
      AppMethodBeat.o(72100);
      return localBankcard;
    }
    AppMethodBeat.o(72100);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(72099);
    if ((this.CQh != null) && (this.CQh.size() != 0))
    {
      int i = this.CQh.size();
      AppMethodBeat.o(72099);
      return i;
    }
    AppMethodBeat.o(72099);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */