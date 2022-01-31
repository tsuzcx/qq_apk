package com.tencent.mm.plugin.wxpay;

import com.tencent.mm.br.c;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_payu.a.d;

public class PluginWxPay
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.wxpay.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.aa.b.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.collect.a.a.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.luckymoney.a.a.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.mall.a.f.class));
      pin(new com.tencent.mm.model.p(k.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.order.a.b.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.product.a.a.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.recharge.a.a.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.remittance.a.b.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.wallet.a.p.class));
      pin(new com.tencent.mm.model.p(o.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.wallet_index.a.a.class));
      pin(new com.tencent.mm.model.p(d.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.wxcredit.a.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.fingerprint.a.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.wallet_ecard.a.class));
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.honey_pay.a.class));
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
  }
  
  public void dependency() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      c.Xg("wallet");
      c.Xg("mall");
      c.Xg("wxcredit");
      c.Xg("offline");
      c.Xg("recharge");
      c.Xg("wallet_index");
      c.Xg("order");
      c.Xg("product");
      c.Xg("remittance");
      c.Xg("collect");
      c.Xg("wallet_payu");
      c.Xg("luckymoney");
      c.Xg("fingerprint");
    }
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.wxpay.a.a.class);
  }
  
  public String name()
  {
    return "plugin-wxpay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.PluginWxPay
 * JD-Core Version:    0.7.0.1
 */