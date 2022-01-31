package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class c$3
  extends g
{
  c$3(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48379);
    if (((paramm instanceof d)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.uCp.mEJ.putParcelableArrayList("key_security_question_list", ((d)paramm).uDV);
      AppMethodBeat.o(48379);
      return true;
    }
    AppMethodBeat.o(48379);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    AppMethodBeat.i(48378);
    this.AXB.a(new d(), true);
    AppMethodBeat.o(48378);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.3
 * JD-Core Version:    0.7.0.1
 */