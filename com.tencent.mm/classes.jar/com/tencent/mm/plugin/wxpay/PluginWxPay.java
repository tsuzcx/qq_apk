package com.tencent.mm.plugin.wxpay;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.fingerprint.b.a.j;
import com.tencent.mm.plugin.luckymoney.model.m;
import com.tencent.mm.plugin.luckymoney.model.n.1;
import com.tencent.mm.plugin.luckymoney.model.n.2;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.c.aa;
import java.util.HashMap;

public class PluginWxPay
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.wxpay.a.a
{
  private com.tencent.mm.sdk.b.c<nu> Due;
  private boolean EHF;
  private com.tencent.mm.cn.h<aa> EHG;
  
  public PluginWxPay()
  {
    AppMethodBeat.i(72400);
    this.EHF = false;
    this.EHG = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Due = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(72400);
  }
  
  private com.tencent.mm.plugin.fingerprint.b.a.i biometricPayManager(int paramInt)
  {
    AppMethodBeat.i(72406);
    Object localObject = new j();
    if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).cPP())
    {
      ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.b.a.h();
    if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).cPP())
    {
      ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.b.a.g();
    AppMethodBeat.o(72406);
    return localObject;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(72408);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return aa.SQL_CREATE;
      }
    });
    AppMethodBeat.o(72408);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72403);
    if (paramg.akw())
    {
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.aa.b.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.collect.a.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.luckymoney.b.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.mall.a.k.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.offline.k.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.order.a.b.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.product.a.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.recharge.a.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.remittance.a.c.class));
      pin(new com.tencent.mm.model.t(s.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.wallet_core.model.t.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.wallet_index.a.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.wallet_payu.a.d.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.wxcredit.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.fingerprint.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.wallet_ecard.a.class));
      pin(new com.tencent.mm.model.t(com.tencent.mm.plugin.honey_pay.a.class));
      o.an("wallet", "wallet", 7);
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.a.a.class, new e(new m()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.wxpaysdk.api.b.class, new e(new com.tencent.mm.plugin.remittance.a.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.wxpaysdk.api.c.class, new e(new com.tencent.mm.plugin.wallet_core.a()));
    AppMethodBeat.o(72403);
  }
  
  public void dependency() {}
  
  public void doRedPacketPreviewLoading(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163876);
    ad.i("MicroMsg.LuckyMoneyEnvelopePreview", "do get red packet preview: %s", new Object[] { paramString });
    paramString = new com.tencent.mm.plugin.luckymoney.model.d(paramString);
    p localp = com.tencent.mm.ui.base.h.a(paramContext, 3, 2131820985, paramContext.getString(2131760709), true, new n.1(paramString));
    paramString.aED().h(new n.2(localp, paramContext));
    AppMethodBeat.o(163876);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72404);
    if (paramg.akw())
    {
      com.tencent.mm.bs.c.aNQ("wallet");
      com.tencent.mm.bs.c.aNQ("mall");
      com.tencent.mm.bs.c.aNQ("wxcredit");
      com.tencent.mm.bs.c.aNQ("offline");
      com.tencent.mm.bs.c.aNQ("recharge");
      com.tencent.mm.bs.c.aNQ("wallet_index");
      com.tencent.mm.bs.c.aNQ("order");
      com.tencent.mm.bs.c.aNQ("product");
      com.tencent.mm.bs.c.aNQ("remittance");
      com.tencent.mm.bs.c.aNQ("collect");
      com.tencent.mm.bs.c.aNQ("wallet_payu");
      com.tencent.mm.bs.c.aNQ("luckymoney");
      com.tencent.mm.bs.c.aNQ("fingerprint");
    }
    AppMethodBeat.o(72404);
  }
  
  public aa getWalletCacheStg()
  {
    AppMethodBeat.i(72405);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(72405);
      throw ((Throwable)localObject);
    }
    Object localObject = (aa)this.EHG.get();
    AppMethodBeat.o(72405);
    return localObject;
  }
  
  public void gotoRedPacketPreviewUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163877);
    ad.d("MicroMsg.LuckyMoneyEnvelopePreview", "before cursor: %s", new Object[] { Integer.valueOf(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().apV("1@fackuser").getCount()) });
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqe("1@fackuser");
    ad.d("MicroMsg.LuckyMoneyEnvelopePreview", "after cursor: %s", new Object[] { Integer.valueOf(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().apV("1@fackuser").getCount()) });
    if ((int)((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj("1@fackuser").gfj > 0) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTr("1@fackuser");
    }
    Object localObject = new am();
    ((am)localObject).setUsername("1@fackuser");
    ((am)localObject).sT(aj.getContext().getString(2131760938));
    ((am)localObject).acH();
    ((am)localObject).gfj = -99L;
    ((am)localObject).ke(3);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().ad((am)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", "1@fackuser");
    ((Intent)localObject).putExtra("finish_direct", false);
    ((Intent)localObject).putExtra("key_red_packet_preview_url", paramString);
    com.tencent.mm.bs.d.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    AppMethodBeat.o(163877);
  }
  
  public boolean hasInitBiometricManager()
  {
    return this.EHF;
  }
  
  public void installed()
  {
    AppMethodBeat.i(72401);
    alias(com.tencent.mm.plugin.wxpay.a.a.class);
    com.tencent.mm.plugin.fingerprint.b.c localc = new com.tencent.mm.plugin.fingerprint.b.c();
    com.tencent.mm.plugin.fingerprint.b.a.g localg = new com.tencent.mm.plugin.fingerprint.b.a.g();
    localc.a(localg);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.b.a.i.class, localg);
    this.Due.alive();
    AppMethodBeat.o(72401);
  }
  
  public String name()
  {
    return "plugin-wxpay";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(199364);
    ad.d("MicroMsg.PluginWxPay", "open kinda switch");
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_JSAPI_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_TINYAPP_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_GROUP_CHAT_RECEIVE_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_TRANSFER2BANK_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY", true);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_EMPTY_PREPAY_ID_PAY_SWTICH_KEY", true);
    AppMethodBeat.o(199364);
  }
  
  public void onAccountRelease() {}
  
  public void onExitRedPacketPreviewChatting()
  {
    AppMethodBeat.i(163878);
    com.tencent.mm.plugin.luckymoney.a.b.dhC();
    AppMethodBeat.o(163878);
  }
  
  public void triggerSoterReInit()
  {
    AppMethodBeat.i(72407);
    ad.d("MicroMsg.PluginWxPay", "re init soter");
    com.tencent.mm.plugin.fingerprint.b.a.i locali = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (locali.cPU() == 0) {
      locali.prepare();
    }
    AppMethodBeat.o(72407);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(72402);
    super.uninstalled();
    this.Due.dead();
    AppMethodBeat.o(72402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.PluginWxPay
 * JD-Core Version:    0.7.0.1
 */