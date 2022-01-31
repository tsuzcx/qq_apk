package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$13
  extends b.a
{
  b$13(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45880);
    if (!super.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      AppMethodBeat.o(45880);
      return false;
    }
    AppMethodBeat.o(45880);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    AppMethodBeat.i(45879);
    if (b.b(this.tVh).getInt("key_pay_scene", 0) == 11)
    {
      Bundle localBundle = b.c(this.tVh);
      s.cRG();
      localBundle.putParcelable("key_history_bankcard", s.cRH().ulO);
    }
    boolean bool = super.x(paramVarArgs);
    AppMethodBeat.o(45879);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.13
 * JD-Core Version:    0.7.0.1
 */