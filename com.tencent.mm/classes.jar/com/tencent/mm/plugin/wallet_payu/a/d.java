package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public class d
  implements at
{
  public String uCJ = null;
  private int uCK = -1;
  
  static
  {
    AppMethodBeat.i(48414);
    a.h("PayUOpenProcess", com.tencent.mm.plugin.wallet_payu.create.a.c.class);
    a.h("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
    a.h("PayUForgotPwdProcess", f.class);
    a.h("PayUModifyPasswordProcess", com.tencent.mm.plugin.wallet_payu.pwd.a.g.class);
    a.h("PayURemittanceProcess", com.tencent.mm.plugin.wallet_payu.remittance.a.g.class);
    a.h("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
    AppMethodBeat.o(48414);
  }
  
  public static d cXq()
  {
    AppMethodBeat.i(48413);
    d locald = (d)q.S(d.class);
    AppMethodBeat.o(48413);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.d
 * JD-Core Version:    0.7.0.1
 */