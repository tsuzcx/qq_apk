package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$1
  extends g
{
  b$1(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45200);
    this.tLW.a(this.hwZ, 0, this.tLW.mEJ);
    AppMethodBeat.o(45200);
    return true;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    AppMethodBeat.i(45199);
    paramVarArgs = b.a(this.tLW);
    s.cRG();
    paramVarArgs.putParcelable("key_history_bankcard", s.cRH().ulO);
    paramVarArgs = (PayInfo)this.tLW.mEJ.get("key_pay_info");
    i locali = this.AXB;
    if (paramVarArgs == null) {}
    for (paramVarArgs = null;; paramVarArgs = paramVarArgs.cnI)
    {
      locali.a(new y(paramVarArgs), true);
      AppMethodBeat.o(45199);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.1
 * JD-Core Version:    0.7.0.1
 */