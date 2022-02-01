package com.tencent.mm.plugin.wxpay;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.luckymoney.model.m;
import com.tencent.mm.plugin.luckymoney.model.n.1;
import com.tencent.mm.plugin.luckymoney.model.n.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.c.aa;
import java.util.HashMap;

public class PluginWxPay
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.wxpay.a.a
{
  private com.tencent.mm.sdk.b.c<nd> ABp;
  private boolean BLx;
  private com.tencent.mm.co.h<aa> BLy;
  
  public PluginWxPay()
  {
    AppMethodBeat.i(72400);
    this.BLx = false;
    this.BLy = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.ABp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(72400);
  }
  
  private i biometricPayManager(int paramInt)
  {
    AppMethodBeat.i(72406);
    Object localObject = new com.tencent.mm.plugin.fingerprint.b.a.j();
    if (((i)localObject).cuo())
    {
      ((i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.b.a.h();
    if (((i)localObject).cuo())
    {
      ((i)localObject).prepare();
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
    if (paramg.agu())
    {
      pin(new t(com.tencent.mm.plugin.aa.b.class));
      pin(new t(com.tencent.mm.plugin.collect.a.a.class));
      pin(new t(com.tencent.mm.plugin.luckymoney.b.a.class));
      pin(new t(com.tencent.mm.plugin.mall.a.j.class));
      pin(new t(com.tencent.mm.plugin.offline.k.class));
      pin(new t(com.tencent.mm.plugin.order.a.b.class));
      pin(new t(com.tencent.mm.plugin.product.a.a.class));
      pin(new t(com.tencent.mm.plugin.recharge.a.a.class));
      pin(new t(com.tencent.mm.plugin.remittance.a.c.class));
      pin(new t(com.tencent.mm.plugin.wallet.a.s.class));
      pin(new t(com.tencent.mm.plugin.wallet_core.model.s.class));
      pin(new t(com.tencent.mm.plugin.wallet_index.a.a.class));
      pin(new t(com.tencent.mm.plugin.wallet_payu.a.d.class));
      pin(new t(com.tencent.mm.plugin.wxcredit.a.class));
      pin(new t(com.tencent.mm.plugin.fingerprint.a.class));
      pin(new t(com.tencent.mm.plugin.wallet_ecard.a.class));
      pin(new t(com.tencent.mm.plugin.honey_pay.a.class));
      o.i("wallet", "wallet", 7, true);
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
    paramString.auK().h(new n.2(localp, paramContext));
    AppMethodBeat.o(163876);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72404);
    if (paramg.agu())
    {
      com.tencent.mm.bs.c.aCW("wallet");
      com.tencent.mm.bs.c.aCW("mall");
      com.tencent.mm.bs.c.aCW("wxcredit");
      com.tencent.mm.bs.c.aCW("offline");
      com.tencent.mm.bs.c.aCW("recharge");
      com.tencent.mm.bs.c.aCW("wallet_index");
      com.tencent.mm.bs.c.aCW("order");
      com.tencent.mm.bs.c.aCW("product");
      com.tencent.mm.bs.c.aCW("remittance");
      com.tencent.mm.bs.c.aCW("collect");
      com.tencent.mm.bs.c.aCW("wallet_payu");
      com.tencent.mm.bs.c.aCW("luckymoney");
      com.tencent.mm.bs.c.aCW("fingerprint");
    }
    AppMethodBeat.o(72404);
  }
  
  public aa getWalletCacheStg()
  {
    AppMethodBeat.i(72405);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(72405);
      throw ((Throwable)localObject);
    }
    Object localObject = (aa)this.BLy.get();
    AppMethodBeat.o(72405);
    return localObject;
  }
  
  public void gotoRedPacketPreviewUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163877);
    ad.d("MicroMsg.LuckyMoneyEnvelopePreview", "before cursor: %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().ago("1@fackuser").getCount()) });
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agw("1@fackuser");
    ad.d("MicroMsg.LuckyMoneyEnvelopePreview", "after cursor: %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().ago("1@fackuser").getCount()) });
    if ((int)((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW("1@fackuser").fId > 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIf("1@fackuser");
    }
    Object localObject = new af();
    ((af)localObject).setUsername("1@fackuser");
    ((af)localObject).nd(aj.getContext().getString(2131760938));
    ((af)localObject).Zk();
    ((af)localObject).fId = -99L;
    ((af)localObject).jI(3);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ac((af)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", "1@fackuser");
    ((Intent)localObject).putExtra("finish_direct", false);
    ((Intent)localObject).putExtra("key_red_packet_preview_url", paramString);
    com.tencent.mm.bs.d.e(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    AppMethodBeat.o(163877);
  }
  
  public boolean hasInitBiometricManager()
  {
    return this.BLx;
  }
  
  public void installed()
  {
    AppMethodBeat.i(72401);
    alias(com.tencent.mm.plugin.wxpay.a.a.class);
    com.tencent.mm.plugin.fingerprint.b.c localc = new com.tencent.mm.plugin.fingerprint.b.c();
    com.tencent.mm.plugin.fingerprint.b.a.g localg = new com.tencent.mm.plugin.fingerprint.b.a.g();
    localc.a(localg);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    com.tencent.mm.kernel.g.b(i.class, localg);
    this.ABp.alive();
    AppMethodBeat.o(72401);
  }
  
  public String name()
  {
    return "plugin-wxpay";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(187194);
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
    AppMethodBeat.o(187194);
  }
  
  public void onAccountRelease() {}
  
  public void onExitRedPacketPreviewChatting()
  {
    AppMethodBeat.i(163878);
    com.tencent.mm.plugin.luckymoney.a.b.cKL();
    AppMethodBeat.o(163878);
  }
  
  public void triggerSoterReInit()
  {
    AppMethodBeat.i(72407);
    ad.d("MicroMsg.PluginWxPay", "re init soter");
    i locali = (i)com.tencent.mm.kernel.g.ab(i.class);
    if (locali.cut() == 0) {
      locali.prepare();
    }
    AppMethodBeat.o(72407);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(72402);
    super.uninstalled();
    this.ABp.dead();
    AppMethodBeat.o(72402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.PluginWxPay
 * JD-Core Version:    0.7.0.1
 */