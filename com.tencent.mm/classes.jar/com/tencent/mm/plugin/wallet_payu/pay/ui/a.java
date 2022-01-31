package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.i;
import java.util.ArrayList;

public final class a
  extends i
{
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    super(paramContext, paramArrayList, paramInt, paramOrders);
  }
  
  public final Bankcard Il(int paramInt)
  {
    AppMethodBeat.i(48459);
    Bankcard localBankcard;
    if ((this.tNG != null) && (this.tNG.size() != 0))
    {
      localBankcard = (Bankcard)this.tNG.get(paramInt);
      AppMethodBeat.o(48459);
      return localBankcard;
    }
    if (paramInt != getCount() - 1)
    {
      localBankcard = (Bankcard)this.tNG.get(paramInt);
      AppMethodBeat.o(48459);
      return localBankcard;
    }
    AppMethodBeat.o(48459);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(48458);
    if ((this.tNG != null) && (this.tNG.size() != 0))
    {
      int i = this.tNG.size();
      AppMethodBeat.o(48458);
      return i;
    }
    AppMethodBeat.o(48458);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */