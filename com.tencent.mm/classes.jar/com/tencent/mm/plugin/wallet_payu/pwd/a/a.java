package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends g
{
  private Bundle dow;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.dow = paramBundle;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72142);
    if ((paramn instanceof c))
    {
      paramString = (c)paramn;
      if (bt.isNullOrNil(paramString.token)) {
        break label67;
      }
      ad.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
      this.dow.putString("payu_reference", paramString.token);
      com.tencent.mm.wallet_core.a.k(this.activity, this.dow);
    }
    for (;;)
    {
      AppMethodBeat.o(72142);
      return false;
      label67:
      ad.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
    }
  }
  
  public final boolean q(Object... paramVarArgs)
  {
    AppMethodBeat.i(72143);
    this.dow.putString("key_pwd1", (String)paramVarArgs[0]);
    this.Ieo.b(new c(this.dow.getString("key_pwd1")), true);
    AppMethodBeat.o(72143);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */