package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
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
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(48448);
    switch (paramInt)
    {
    default: 
      localObject = super.getTips(paramInt);
      AppMethodBeat.o(48448);
      return localObject;
    case 0: 
      localObject = this.hwZ.getString(2131304836);
      AppMethodBeat.o(48448);
      return localObject;
    }
    Object localObject = this.hwZ.getString(2131304835);
    AppMethodBeat.o(48448);
    return localObject;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48447);
    paramVarArgs = (Orders)paramVarArgs[0];
    s.cRG();
    Bankcard localBankcard = s.cRH().tOD;
    localBankcard.ufM += paramVarArgs.cnL;
    AppMethodBeat.o(48447);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.e.2
 * JD-Core Version:    0.7.0.1
 */