package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet.pwd.a.j;
import com.tencent.mm.plugin.wallet.pwd.a.o;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$5
  extends g
{
  a$5(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69490);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramn instanceof o)) || ((paramn instanceof j))))
    {
      this.Bki.a(this.activity, 0, a.g(this.Bki));
      AppMethodBeat.o(69490);
      return true;
    }
    AppMethodBeat.o(69490);
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    AppMethodBeat.i(69491);
    paramVarArgs = (u)paramVarArgs[0];
    if (this.Bki.dmf.getBoolean("key_is_set_pwd_after_face_action"))
    {
      ac.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, after face verify, reset pwd by face");
      String str = this.Bki.dmf.getString("key_face_action_result_token");
      this.JFQ.a(new j(str, paramVarArgs.iJA), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(69491);
      return true;
      ac.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, not after face verify, reset pwd normal");
      this.JFQ.a(new o(paramVarArgs), true, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.5
 * JD-Core Version:    0.7.0.1
 */