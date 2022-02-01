package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public class d
  implements az
{
  private String DKj = null;
  private int DKk = -1;
  
  static
  {
    AppMethodBeat.i(72055);
    a.i("PayUOpenProcess", com.tencent.mm.plugin.wallet_payu.create.a.c.class);
    a.i("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
    a.i("PayUForgotPwdProcess", f.class);
    a.i("PayUModifyPasswordProcess", com.tencent.mm.plugin.wallet_payu.pwd.a.g.class);
    a.i("PayURemittanceProcess", com.tencent.mm.plugin.wallet_payu.remittance.a.g.class);
    a.i("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.d
 * JD-Core Version:    0.7.0.1
 */