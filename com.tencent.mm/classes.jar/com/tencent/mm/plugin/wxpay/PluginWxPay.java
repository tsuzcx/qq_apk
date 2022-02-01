package com.tencent.mm.plugin.wxpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.s.1;
import com.tencent.mm.plugin.luckymoney.model.s.2;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.wallet_core.c.aa;
import java.util.HashMap;

public class PluginWxPay
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, i.a, com.tencent.mm.plugin.wxpay.a.a
{
  private IListener<pk> PnH;
  private boolean QPk;
  private com.tencent.mm.cw.h<aa> QPl;
  
  public PluginWxPay()
  {
    AppMethodBeat.i(72400);
    this.QPk = false;
    this.QPl = new com.tencent.mm.cw.h(new PluginWxPay.1(this));
    this.PnH = new IListener() {};
    AppMethodBeat.o(72400);
  }
  
  private com.tencent.mm.plugin.fingerprint.b.a.i biometricPayManager(int paramInt)
  {
    AppMethodBeat.i(72406);
    Object localObject = new com.tencent.mm.plugin.fingerprint.b.a.j();
    if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).isSupport())
    {
      ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.b.a.h();
    if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).isSupport())
    {
      ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.b.a.g();
    AppMethodBeat.o(72406);
    return localObject;
  }
  
  public void beforeJumpRedPacketPreviewUI()
  {
    AppMethodBeat.i(238501);
    com.tencent.mm.plugin.luckymoney.model.s.eOE();
    com.tencent.mm.plugin.luckymoney.model.s.eOD();
    AppMethodBeat.o(238501);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(72408);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new PluginWxPay.3(this));
    AppMethodBeat.o(72408);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72403);
    if (paramg.aIE())
    {
      pin(new y(com.tencent.mm.plugin.aa.b.class));
      pin(new y(com.tencent.mm.plugin.collect.a.a.class));
      pin(new y(com.tencent.mm.plugin.luckymoney.b.a.class));
      pin(new y(com.tencent.mm.plugin.mall.a.k.class));
      pin(new y(com.tencent.mm.plugin.offline.k.class));
      pin(new y(com.tencent.mm.plugin.order.a.b.class));
      pin(new y(com.tencent.mm.plugin.product.a.a.class));
      pin(new y(com.tencent.mm.plugin.recharge.a.a.class));
      pin(new y(com.tencent.mm.plugin.remittance.a.c.class));
      pin(new y(com.tencent.mm.plugin.wallet.a.s.class));
      pin(new y(u.class));
      pin(new y(com.tencent.mm.plugin.wallet_index.a.a.class));
      pin(new y(com.tencent.mm.plugin.wallet_payu.a.d.class));
      pin(new y(com.tencent.mm.plugin.wxcredit.a.class));
      pin(new y(com.tencent.mm.plugin.fingerprint.a.class));
      pin(new y(com.tencent.mm.plugin.wallet_ecard.a.class));
      pin(new y(com.tencent.mm.plugin.honey_pay.a.class));
      ab.aE("wallet", "wallet", 5);
      ab.a("luckymoney", "luckymoney", 7776000000L, 518);
    }
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.luckymoney.a.a.class, new e(new r()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.wxpaysdk.api.b.class, new e(new com.tencent.mm.plugin.remittance.a.b()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.wxpaysdk.api.c.class, new e(new com.tencent.mm.plugin.wallet_core.a()));
    AppMethodBeat.o(72403);
  }
  
  public void dependency() {}
  
  public void doRedPacketPreviewLoading(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163876);
    Log.i("MicroMsg.LuckyMoneyEnvelopePreview", "do get red packet preview: %s", new Object[] { paramString });
    paramString = new com.tencent.mm.plugin.luckymoney.model.f(paramString);
    com.tencent.mm.ui.base.s locals = com.tencent.mm.ui.base.h.a(paramContext, 3, a.j.LuckyMoneyNoAnimDialog, paramContext.getString(a.i.loading_tips), true, new s.1(paramString));
    paramString.bhW().h(new s.2(locals, paramContext));
    AppMethodBeat.o(163876);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72404);
    if (paramg.aIE())
    {
      com.tencent.mm.by.b.bsj("wallet");
      com.tencent.mm.by.b.bsj("mall");
      com.tencent.mm.by.b.bsj("wxcredit");
      com.tencent.mm.by.b.bsj("offline");
      com.tencent.mm.by.b.bsj("recharge");
      com.tencent.mm.by.b.bsj("wallet_index");
      com.tencent.mm.by.b.bsj("order");
      com.tencent.mm.by.b.bsj("product");
      com.tencent.mm.by.b.bsj("remittance");
      com.tencent.mm.by.b.bsj("collect");
      com.tencent.mm.by.b.bsj("wallet_payu");
      com.tencent.mm.by.b.bsj("luckymoney");
      com.tencent.mm.by.b.bsj("fingerprint");
    }
    AppMethodBeat.o(72404);
  }
  
  public aa getWalletCacheStg()
  {
    AppMethodBeat.i(72405);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(72405);
      throw ((Throwable)localObject);
    }
    Object localObject = (aa)this.QPl.get();
    AppMethodBeat.o(72405);
    return localObject;
  }
  
  public void gotoLuckyMoneyReceiveUI(Context paramContext, Bundle paramBundle, k.b paramb)
  {
    AppMethodBeat.i(238502);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("key_way", 0);
    localIntent.putExtra("key_native_url", paramb.lnH);
    localIntent.putExtra("scene_id", Integer.parseInt(paramb.lnG));
    localIntent.putExtra("key_invalidtime", paramb.lnh);
    paramBundle = (com.tencent.mm.aj.c)paramb.ar(com.tencent.mm.aj.c.class);
    paramb = (com.tencent.mm.aj.g)paramb.ar(com.tencent.mm.aj.g.class);
    localIntent.putExtra("key_exclusive_username", paramBundle.lln);
    localIntent.putExtra("key_cropname", paramBundle.lle);
    localIntent.putExtra("key_receive_envelope_url", paramBundle.llj);
    localIntent.putExtra("key_receive_envelope_md5", paramBundle.llk);
    localIntent.putExtra("key_detail_envelope_url", paramBundle.lll);
    localIntent.putExtra("key_detail_envelope_md5", paramBundle.llm);
    localIntent.putExtra("key_about_url", paramb.llG);
    localIntent.putExtra("key_packet_id", paramb.llH);
    localIntent.putExtra("key_has_story", paramb.llK);
    localIntent.putExtra("key_material_flag", paramb.llL);
    com.tencent.mm.by.c.b(paramContext, "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", localIntent);
    AppMethodBeat.o(238502);
  }
  
  public void gotoRedPacketPreviewUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163877);
    com.tencent.mm.plugin.luckymoney.model.s.eOE();
    com.tencent.mm.plugin.luckymoney.model.s.eOD();
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", "1@fackuser");
    localIntent.putExtra("finish_direct", false);
    localIntent.putExtra("key_red_packet_preview_url", paramString);
    com.tencent.mm.by.c.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(163877);
  }
  
  public boolean hasInitBiometricManager()
  {
    return this.QPk;
  }
  
  public void installed()
  {
    AppMethodBeat.i(72401);
    alias(com.tencent.mm.plugin.wxpay.a.a.class);
    com.tencent.mm.plugin.fingerprint.b.c localc = new com.tencent.mm.plugin.fingerprint.b.c();
    com.tencent.mm.plugin.fingerprint.b.a.g localg = new com.tencent.mm.plugin.fingerprint.b.a.g();
    localc.a(localg);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.b.a.i.class, localg);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.wallet.wecoin.a.c.class, new com.tencent.mm.plugin.wallet.wecoin.model.j());
    this.PnH.alive();
    AppMethodBeat.o(72401);
  }
  
  public String name()
  {
    return "plugin-wxpay";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(238505);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this, null);
    AppMethodBeat.o(238505);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(238506);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this);
    AppMethodBeat.o(238506);
  }
  
  public void onExitRedPacketPreviewChatting()
  {
    AppMethodBeat.i(163878);
    com.tencent.mm.plugin.luckymoney.a.b.eNM();
    AppMethodBeat.o(163878);
  }
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(238509);
    if (CrashReportFactory.isBackupMerge())
    {
      AppMethodBeat.o(238509);
      return;
    }
    if ((parami == null) || (paramc == null) || (paramc.kvM == null))
    {
      AppMethodBeat.o(238509);
      return;
    }
    new com.tencent.mm.plugin.wallet_core.utils.d();
    parami = paramc.EVM;
    int i = -1;
    switch (parami.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(238509);
      return;
      if (!parami.equals("insert")) {
        break;
      }
      i = 0;
      break;
      if (!parami.equals("delete")) {
        break;
      }
      i = 1;
      break;
      if (!parami.equals("update")) {
        break;
      }
      i = 2;
      break;
      com.tencent.mm.plugin.wallet_core.utils.d.a(paramc.kvM, com.tencent.mm.plugin.wallet_core.utils.c.Phh);
      AppMethodBeat.o(238509);
      return;
      com.tencent.mm.plugin.wallet_core.utils.d.a(paramc.kvM, com.tencent.mm.plugin.wallet_core.utils.c.Phi);
      AppMethodBeat.o(238509);
      return;
      com.tencent.mm.plugin.wallet_core.utils.d.a(paramc.kvM, com.tencent.mm.plugin.wallet_core.utils.c.Phj);
    }
  }
  
  public void triggerSoterReInit()
  {
    AppMethodBeat.i(72407);
    Log.d("MicroMsg.PluginWxPay", "re init soter");
    com.tencent.mm.plugin.fingerprint.b.a.i locali = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (locali.eoT() == 0) {
      locali.prepare();
    }
    AppMethodBeat.o(72407);
  }
  
  public void unMarkLuckyMoneyRedFlag(String paramString)
  {
    AppMethodBeat.i(238503);
    com.tencent.mm.plugin.luckymoney.b.a.eNR().bT(paramString, false);
    AppMethodBeat.o(238503);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(72402);
    super.uninstalled();
    this.PnH.dead();
    AppMethodBeat.o(72402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.PluginWxPay
 * JD-Core Version:    0.7.0.1
 */