package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.a.h;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$5
  extends g
{
  a$5(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(46134);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.m)) || ((paramm instanceof h))))
    {
      this.tXB.a(this.hwZ, 0, a.f(this.tXB));
      AppMethodBeat.o(46134);
      return true;
    }
    AppMethodBeat.o(46134);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46135);
    paramVarArgs = (u)paramVarArgs[0];
    if (this.tXB.mEJ.getBoolean("key_is_set_pwd_after_face_action"))
    {
      ab.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, after face verify, reset pwd by face");
      String str = this.tXB.mEJ.getString("key_face_action_result_token");
      this.AXB.a(new h(str, paramVarArgs.gww), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(46135);
      return true;
      ab.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, not after face verify, reset pwd normal");
      this.AXB.a(new com.tencent.mm.plugin.wallet.pwd.a.m(paramVarArgs), true, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.5
 * JD-Core Version:    0.7.0.1
 */