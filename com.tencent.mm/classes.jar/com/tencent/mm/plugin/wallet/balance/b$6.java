package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.e.j;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$6
  extends g
{
  b$6(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45210);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof j)))
    {
      paramString = (j)paramm;
      if (paramString.isPaySuccess) {
        b.D(this.tLW).putParcelable("key_orders", paramString.tVr);
      }
      this.tLW.a(this.hwZ, 0, b.E(this.tLW));
      AppMethodBeat.o(45210);
      return true;
    }
    AppMethodBeat.o(45210);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45211);
    paramVarArgs = (u)paramVarArgs[0];
    Orders localOrders = (Orders)b.F(this.tLW).getParcelable("key_orders");
    this.AXB.a(new j(paramVarArgs, localOrders), true, 1);
    AppMethodBeat.o(45211);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.6
 * JD-Core Version:    0.7.0.1
 */