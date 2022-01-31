package com.tencent.mm.plugin.wxpay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.cm.h;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.wallet_core.c.y;
import java.util.HashMap;

public class PluginWxPay
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.plugin.wxpay.a.a
{
  private h<y> vIL;
  private com.tencent.mm.sdk.b.c<lr> vIM;
  
  public PluginWxPay()
  {
    AppMethodBeat.i(48758);
    this.vIL = new h(new PluginWxPay.1(this));
    this.vIM = new PluginWxPay.2(this);
    AppMethodBeat.o(48758);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(48764);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new PluginWxPay.3(this));
    AppMethodBeat.o(48764);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(48761);
    if (paramg.SD())
    {
      pin(new q(com.tencent.mm.plugin.aa.b.class));
      pin(new q(com.tencent.mm.plugin.collect.a.a.class));
      pin(new q(com.tencent.mm.plugin.luckymoney.b.a.class));
      pin(new q(j.class));
      pin(new q(k.class));
      pin(new q(com.tencent.mm.plugin.order.a.b.class));
      pin(new q(com.tencent.mm.plugin.product.a.a.class));
      pin(new q(com.tencent.mm.plugin.recharge.a.a.class));
      pin(new q(com.tencent.mm.plugin.remittance.a.c.class));
      pin(new q(s.class));
      pin(new q(t.class));
      pin(new q(com.tencent.mm.plugin.wallet_index.a.a.class));
      pin(new q(com.tencent.mm.plugin.wallet_payu.a.d.class));
      pin(new q(com.tencent.mm.plugin.wxcredit.a.class));
      pin(new q(com.tencent.mm.plugin.fingerprint.a.class));
      pin(new q(com.tencent.mm.plugin.wallet_ecard.a.class));
      pin(new q(com.tencent.mm.plugin.honey_pay.a.class));
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.a.a.class, new e(new com.tencent.mm.plugin.luckymoney.model.l()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.wxpaysdk.api.b.class, new e(new com.tencent.mm.plugin.remittance.a.b()));
    AppMethodBeat.o(48761);
  }
  
  public void dependency() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(48762);
    if (paramg.SD())
    {
      com.tencent.mm.bq.c.anb("wallet");
      com.tencent.mm.bq.c.anb("mall");
      com.tencent.mm.bq.c.anb("wxcredit");
      com.tencent.mm.bq.c.anb("offline");
      com.tencent.mm.bq.c.anb("recharge");
      com.tencent.mm.bq.c.anb("wallet_index");
      com.tencent.mm.bq.c.anb("order");
      com.tencent.mm.bq.c.anb("product");
      com.tencent.mm.bq.c.anb("remittance");
      com.tencent.mm.bq.c.anb("collect");
      com.tencent.mm.bq.c.anb("wallet_payu");
      com.tencent.mm.bq.c.anb("luckymoney");
      com.tencent.mm.bq.c.anb("fingerprint");
    }
    AppMethodBeat.o(48762);
  }
  
  public y getWalletCacheStg()
  {
    AppMethodBeat.i(48763);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48763);
      throw ((Throwable)localObject);
    }
    Object localObject = (y)this.vIL.get();
    AppMethodBeat.o(48763);
    return localObject;
  }
  
  public void installed()
  {
    AppMethodBeat.i(48759);
    alias(com.tencent.mm.plugin.wxpay.a.a.class);
    com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.l.class, new com.tencent.mm.plugin.fingerprint.b.d());
    this.vIM.alive();
    AppMethodBeat.o(48759);
  }
  
  public String name()
  {
    return "plugin-wxpay";
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(48760);
    super.uninstalled();
    this.vIM.dead();
    AppMethodBeat.o(48760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.PluginWxPay
 * JD-Core Version:    0.7.0.1
 */