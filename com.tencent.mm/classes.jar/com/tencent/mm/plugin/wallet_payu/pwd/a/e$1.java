package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$1
  extends g
{
  e$1(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48508);
    if ((paramm instanceof d))
    {
      ab.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uDC.mEJ.putInt("key_errcode_payu", 0);
        a.b(this.hwZ, this.uDC.mEJ, 0);
        AppMethodBeat.o(48508);
        return true;
      }
    }
    AppMethodBeat.o(48508);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48509);
    Object localObject = (u)paramVarArgs[0];
    paramVarArgs = this.uDC.mEJ.getString("payu_reference");
    localObject = ((u)localObject).gww;
    this.AXB.a(new d(paramVarArgs, (String)localObject), true);
    AppMethodBeat.o(48509);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.e.1
 * JD-Core Version:    0.7.0.1
 */