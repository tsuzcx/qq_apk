package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public class d
  implements ar
{
  public String qNC = null;
  private int qND = -1;
  
  static
  {
    a.i("PayUOpenProcess", com.tencent.mm.plugin.wallet_payu.create.a.c.class);
    a.i("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
    a.i("PayUForgotPwdProcess", f.class);
    a.i("PayUModifyPasswordProcess", com.tencent.mm.plugin.wallet_payu.pwd.a.g.class);
    a.i("PayURemittanceProcess", com.tencent.mm.plugin.wallet_payu.remittance.a.g.class);
    a.i("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
  }
  
  public static d bXH()
  {
    return (d)p.B(d.class);
  }
  
  public final void bh(boolean paramBoolean) {}
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.d
 * JD-Core Version:    0.7.0.1
 */