package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$4
  extends g
{
  e$4(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48632);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof a)))
    {
      paramString = (a)paramm;
      new StringBuilder("reqKey  ").append(paramString.mReqKey);
      e.P(this.vHu).putString("kreq_token", paramString.getToken());
      this.vHu.a(this.hwZ, 0, e.Q(this.vHu));
      AppMethodBeat.o(48632);
      return true;
    }
    AppMethodBeat.o(48632);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48633);
    d.cWY();
    Authen localAuthen = new Authen();
    localAuthen.ueZ = ((String)paramVarArgs[0]);
    localAuthen.poq = ((String)paramVarArgs[1]);
    localAuthen.ubQ = ((String)paramVarArgs[2]);
    e.R(this.vHu).putString("key_bank_phone", (String)paramVarArgs[3]);
    if (t.cTN().cUl()) {}
    for (int i = 2;; i = 1)
    {
      localAuthen.bsY = i;
      localAuthen.ueY = 1;
      localAuthen.pVo = ((PayInfo)e.S(this.vHu).getParcelable("key_pay_info"));
      localAuthen.ueW = e.T(this.vHu).getString("key_pwd1");
      if (!e.U(this.vHu).getBoolean("key_has_indentity_info", false))
      {
        localAuthen.ueu = e.V(this.vHu).getString("key_name");
        localAuthen.ueX = e.W(this.vHu).getString("key_indentity");
      }
      paramVarArgs = com.tencent.mm.wallet_core.ui.e.awd(localAuthen.ubQ);
      e.X(this.vHu).putString("key_mobile", paramVarArgs);
      e.Y(this.vHu).putBoolean("key_is_oversea", false);
      this.AXB.a(new a(localAuthen), true, 1);
      AppMethodBeat.o(48633);
      return true;
    }
  }
  
  public final boolean y(Object... paramVarArgs)
  {
    AppMethodBeat.i(48634);
    this.AXB.a(new w("", (String)paramVarArgs[0], (PayInfo)e.Z(this.vHu).getParcelable("key_pay_info")), true, 1);
    AppMethodBeat.o(48634);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.4
 * JD-Core Version:    0.7.0.1
 */