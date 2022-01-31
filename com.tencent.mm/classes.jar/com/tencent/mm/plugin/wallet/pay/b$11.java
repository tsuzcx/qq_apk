package com.tencent.mm.plugin.wallet.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$11
  extends b.a
{
  b$11(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45876);
    if (!super.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      AppMethodBeat.o(45876);
      return false;
    }
    AppMethodBeat.o(45876);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.11
 * JD-Core Version:    0.7.0.1
 */