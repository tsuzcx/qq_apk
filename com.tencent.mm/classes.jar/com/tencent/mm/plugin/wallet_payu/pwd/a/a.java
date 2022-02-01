package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends g
{
  private Bundle dQL;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.dQL = paramBundle;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72142);
    if ((paramq instanceof c))
    {
      paramString = (c)paramq;
      if (Util.isNullOrNil(paramString.token)) {
        break label67;
      }
      Log.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
      this.dQL.putString("payu_reference", paramString.token);
      com.tencent.mm.wallet_core.a.l(this.activity, this.dQL);
    }
    for (;;)
    {
      AppMethodBeat.o(72142);
      return false;
      label67:
      Log.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
    }
  }
  
  public final boolean r(Object... paramVarArgs)
  {
    AppMethodBeat.i(72143);
    this.dQL.putString("key_pwd1", (String)paramVarArgs[0]);
    this.Ruz.b(new c(this.dQL.getString("key_pwd1")), true);
    AppMethodBeat.o(72143);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */