package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class c$1
  extends g
{
  c$1(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48609);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.vHs.a(this.hwZ, 0, c.a(this.vHs));
      this.hwZ.finish();
      AppMethodBeat.o(48609);
      return true;
    }
    AppMethodBeat.o(48609);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48610);
    c.b(this.vHs).putString("key_pwd1", (String)paramVarArgs[0]);
    this.AXB.a(new u((String)paramVarArgs[0], 5, ""), true, 1);
    AppMethodBeat.o(48610);
    return true;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.c.1
 * JD-Core Version:    0.7.0.1
 */