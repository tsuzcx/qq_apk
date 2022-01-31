package com.tencent.mm.plugin.wallet.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$16
  extends b.a
{
  b$16(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(45887);
    switch (paramInt)
    {
    default: 
      localObject = super.getTips(paramInt);
      AppMethodBeat.o(45887);
      return localObject;
    case 0: 
      localObject = this.hwZ.getString(2131304836);
      AppMethodBeat.o(45887);
      return localObject;
    }
    Object localObject = this.hwZ.getString(2131304835);
    AppMethodBeat.o(45887);
    return localObject;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45885);
    if (!super.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      AppMethodBeat.o(45885);
      return false;
    }
    AppMethodBeat.o(45885);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45886);
    paramVarArgs = (Orders)paramVarArgs[0];
    s.cRG();
    Bankcard localBankcard = s.cRH().tOD;
    localBankcard.ufM += paramVarArgs.cnL;
    AppMethodBeat.o(45886);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.16
 * JD-Core Version:    0.7.0.1
 */