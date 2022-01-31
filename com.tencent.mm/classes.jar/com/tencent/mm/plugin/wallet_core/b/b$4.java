package com.tencent.mm.plugin.wallet_core.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$4
  extends g
{
  b$4(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46474);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.b.a.b))
    {
      this.ubp.a(this.AXB);
      if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramm).ubq != null) {
        b.g(this.ubp).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramm).ubq);
      }
    }
    while (!(paramm instanceof h))
    {
      AppMethodBeat.o(46474);
      return false;
    }
    AppMethodBeat.o(46474);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46475);
    paramVarArgs = (u)paramVarArgs[0];
    b.h(this.ubp).getString("verify_card_flag", "0");
    if ("realname_verify_process".equals(this.ubp.bzC())) {
      this.AXB.a(new com.tencent.mm.plugin.wallet_core.b.a.b(paramVarArgs, this.ubp.mEJ.getInt("entry_scene", -1)), true);
    }
    for (;;)
    {
      AppMethodBeat.o(46475);
      return false;
      this.AXB.a(new com.tencent.mm.plugin.wallet_core.b.a.b(paramVarArgs), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.4
 * JD-Core Version:    0.7.0.1
 */