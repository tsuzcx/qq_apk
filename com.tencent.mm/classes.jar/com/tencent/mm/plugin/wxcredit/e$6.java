package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$6
  extends g
{
  e$6(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48637);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.vHu.a(this.hwZ, 0, e.al(this.vHu));
      AppMethodBeat.o(48637);
      return true;
    }
    AppMethodBeat.o(48637);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48638);
    e.am(this.vHu).putBoolean("key_is_follow_bank_username", ((Boolean)paramVarArgs[0]).booleanValue());
    e.an(this.vHu);
    this.AXB.a(new ab(), true, 1);
    AppMethodBeat.o(48638);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.6
 * JD-Core Version:    0.7.0.1
 */