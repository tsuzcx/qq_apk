package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements be
{
  private String Wdv = null;
  private int Wdw = -1;
  
  static
  {
    AppMethodBeat.i(72055);
    com.tencent.mm.wallet_core.a.n("PayUOpenProcess", com.tencent.mm.plugin.wallet_payu.create.a.c.class);
    com.tencent.mm.wallet_core.a.n("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
    com.tencent.mm.wallet_core.a.n("PayUForgotPwdProcess", f.class);
    com.tencent.mm.wallet_core.a.n("PayUModifyPasswordProcess", g.class);
    com.tencent.mm.wallet_core.a.n("PayURemittanceProcess", com.tencent.mm.plugin.wallet_payu.remittance.a.a.class);
    com.tencent.mm.wallet_core.a.n("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
    AppMethodBeat.o(72055);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.d
 * JD-Core Version:    0.7.0.1
 */