package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$4
  extends g
{
  e$4(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        bool1 = bool2;
        if ((paramm instanceof a))
        {
          paramString = (a)paramm;
          new StringBuilder("reqKey  ").append(paramString.qmm);
          e.P(this.rQD).putString("kreq_token", paramString.token);
          this.rQD.a(this.gfb, 0, e.Q(this.rQD));
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    com.tencent.mm.plugin.wallet_core.e.c.bXt();
    Authen localAuthen = new Authen();
    localAuthen.qsM = ((String)paramVarArgs[0]);
    localAuthen.mOb = ((String)paramVarArgs[1]);
    localAuthen.qqU = ((String)paramVarArgs[2]);
    e.R(this.rQD).putString("key_bank_phone", (String)paramVarArgs[3]);
    if (o.bVs().bVN()) {}
    for (int i = 2;; i = 1)
    {
      localAuthen.bcw = i;
      localAuthen.qsL = 1;
      localAuthen.nqa = ((PayInfo)e.S(this.rQD).getParcelable("key_pay_info"));
      localAuthen.qsI = e.T(this.rQD).getString("key_pwd1");
      if (!e.U(this.rQD).getBoolean("key_has_indentity_info", false))
      {
        localAuthen.qsJ = e.V(this.rQD).getString("key_name");
        localAuthen.qsK = e.W(this.rQD).getString("key_indentity");
      }
      paramVarArgs = com.tencent.mm.wallet_core.ui.e.afk(localAuthen.qqU);
      e.X(this.rQD).putString("key_mobile", paramVarArgs);
      e.Y(this.rQD).putBoolean("key_is_oversea", false);
      this.wBd.a(new a(localAuthen), true, 1);
      return true;
    }
  }
  
  public final boolean t(Object... paramVarArgs)
  {
    this.wBd.a(new t("", (String)paramVarArgs[0], (PayInfo)e.Z(this.rQD).getParcelable("key_pay_info")), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.4
 * JD-Core Version:    0.7.0.1
 */