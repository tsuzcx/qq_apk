package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

final class c$2
  extends g
{
  c$2(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(48377);
    if (paramInt == 0)
    {
      localObject = this.hwZ.getString(2131305686, new Object[] { e.awd("+" + c.b(this.uCp).getString("dial_code") + c.c(this.uCp).getString("key_mobile")) });
      AppMethodBeat.o(48377);
      return localObject;
    }
    Object localObject = super.getTips(paramInt);
    AppMethodBeat.o(48377);
    return localObject;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48375);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.a.a))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.a.a)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.qIW))
      {
        c.a(this.uCp).putString("payu_reference", paramString.uCH);
        com.tencent.mm.wallet_core.a.j(this.hwZ, this.uCp.mEJ);
        AppMethodBeat.o(48375);
        return true;
      }
    }
    else if (((paramm instanceof b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (b)paramm;
      this.uCp.mEJ.putString("payu_reference", paramString.czq);
      AppMethodBeat.o(48375);
      return true;
    }
    AppMethodBeat.o(48375);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48376);
    this.AXB.a(new com.tencent.mm.plugin.wallet_payu.a.a((String)paramVarArgs[0], this.uCp.mEJ.getString("payu_reference")), true);
    AppMethodBeat.o(48376);
    return true;
  }
  
  public final boolean y(Object... paramVarArgs)
  {
    AppMethodBeat.i(48374);
    this.AXB.a(new b(this.uCp.mEJ.getString("dial_code"), this.uCp.mEJ.getString("key_mobile")), true, 1);
    AppMethodBeat.o(48374);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.2
 * JD-Core Version:    0.7.0.1
 */