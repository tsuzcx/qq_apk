package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$4
  extends g
{
  a$4(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  private void cTb()
  {
    AppMethodBeat.i(142398);
    boolean bool = a.s(this.ucw).getBoolean("realname_verify_process_need_face", false);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RealNameVerifyProcess", "forward: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      ov localov = new ov();
      localov.cFu.cup = this.hwZ;
      localov.cFu.scene = ((int)a.t(this.ucw).getLong("realname_verify_process_face_scene"));
      localov.cFu.packageName = a.u(this.ucw).getString("realname_verify_process_face_package");
      localov.cFu.cFw = a.v(this.ucw).getString("realname_verify_process_face_package_sign");
      localov.cFu.requestCode = 1;
      com.tencent.mm.sdk.b.a.ymk.l(localov);
      AppMethodBeat.o(142398);
      return;
    }
    this.ucw.a(this.hwZ, 0, a.w(this.ucw));
    AppMethodBeat.o(142398);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(142400);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("token");
        this.ucw.mEJ.putString("realname_verify_process_face_token", paramIntent);
        this.ucw.a(this.hwZ, 0, this.ucw.mEJ);
        AppMethodBeat.o(142400);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(142400);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(142397);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramm;
        a.q(this.ucw).putString("kreq_token", paramString.getToken());
        if (this.ucw.c(this.hwZ, a.r(this.ucw)))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RealNameVerifyProcess", "need update bankcardlist");
          this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.ab(null, 12), false);
        }
        for (;;)
        {
          AppMethodBeat.o(142397);
          return true;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RealNameVerifyProcess", "not need update bankcardlist");
          cTb();
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RealNameVerifyProcess", "update bankcardlist success!");
        cTb();
        AppMethodBeat.o(142397);
        return true;
      }
    }
    AppMethodBeat.o(142397);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(142399);
    this.ucw.G(new Object[] { "onNext", paramVarArgs });
    paramVarArgs = (Authen)paramVarArgs[0];
    paramVarArgs.bsY = a.x(this.ucw);
    this.AXB.a(new com.tencent.mm.plugin.wallet_core.b.a.a(paramVarArgs), true, 1);
    AppMethodBeat.o(142399);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.4
 * JD-Core Version:    0.7.0.1
 */