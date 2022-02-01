package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public class d
  implements bd
{
  private int ItA = -1;
  private String Itz = null;
  
  static
  {
    AppMethodBeat.i(72055);
    a.j("PayUOpenProcess", com.tencent.mm.plugin.wallet_payu.create.a.c.class);
    a.j("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
    a.j("PayUForgotPwdProcess", f.class);
    a.j("PayUModifyPasswordProcess", com.tencent.mm.plugin.wallet_payu.pwd.a.g.class);
    a.j("PayURemittanceProcess", com.tencent.mm.plugin.wallet_payu.remittance.a.g.class);
    a.j("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.d
 * JD-Core Version:    0.7.0.1
 */