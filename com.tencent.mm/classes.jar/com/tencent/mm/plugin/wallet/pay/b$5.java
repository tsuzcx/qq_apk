package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet.pay.a.d.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$5
  extends b.a
{
  b$5(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45870);
    if ((!super.onSceneEnd(paramInt1, paramInt2, paramString, paramm)) && ((paramm instanceof f)))
    {
      paramString = (f)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.isPaySuccess) {
          b.s(this.tVh).putParcelable("key_orders", paramString.tVr);
        }
        paramString = paramString.plg;
        if (paramString != null) {
          b.t(this.tVh).putParcelable("key_realname_guide_helper", paramString);
        }
        this.tVh.a(this.hwZ, 0, b.u(this.tVh));
        this.hwZ.finish();
        AppMethodBeat.o(45870);
        return true;
      }
    }
    AppMethodBeat.o(45870);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45869);
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = a.a((u)paramVarArgs[0], (Orders)b.r(this.tVh).getParcelable("key_orders"));
      this.AXB.a(paramVarArgs, true, 1);
    }
    AppMethodBeat.o(45869);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.5
 * JD-Core Version:    0.7.0.1
 */