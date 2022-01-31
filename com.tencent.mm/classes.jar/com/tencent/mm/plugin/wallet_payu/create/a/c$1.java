package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
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
    AppMethodBeat.i(48372);
    if ((paramm instanceof b))
    {
      ab.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramm;
        this.uCp.mEJ.putString("payu_reference", paramString.czq);
        ab.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[] { paramString.czq });
        this.uCp.mEJ.putBoolean("key_is_has_mobile", paramString.uCI);
        a.j(this.hwZ, this.uCp.mEJ);
        AppMethodBeat.o(48372);
        return true;
      }
    }
    AppMethodBeat.o(48372);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48373);
    this.AXB.a(new b(this.uCp.mEJ.getString("dial_code"), this.uCp.mEJ.getString("key_mobile")), true);
    AppMethodBeat.o(48373);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.1
 * JD-Core Version:    0.7.0.1
 */