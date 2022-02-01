package com.tencent.mm.plugin.wxpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qx;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fingerprint.mgr.a.j;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.s.1;
import com.tencent.mm.plugin.luckymoney.model.s.2;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI;
import com.tencent.mm.plugin.wallet.model.p;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.af;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import java.util.HashMap;

public class PluginWxPay
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, i.a, com.tencent.mm.plugin.wxpay.a.a
{
  private IListener<qx> Weg;
  private boolean XII;
  private com.tencent.mm.cp.h<ab> XIJ;
  
  public PluginWxPay()
  {
    AppMethodBeat.i(72400);
    this.XII = false;
    this.XIJ = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.Weg = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(72400);
  }
  
  private com.tencent.mm.plugin.fingerprint.mgr.a.i biometricPayManager(int paramInt)
  {
    AppMethodBeat.i(72406);
    Object localObject = new j();
    if (((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject).isSupport())
    {
      ((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.mgr.a.h();
    if (((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject).isSupport())
    {
      ((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.mgr.a.g();
    AppMethodBeat.o(72406);
    return localObject;
  }
  
  public void beforeJumpRedPacketPreviewUI()
  {
    AppMethodBeat.i(267309);
    s.fXb();
    s.fXa();
    AppMethodBeat.o(267309);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(72408);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ab.SQL_CREATE;
      }
    });
    AppMethodBeat.o(72408);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72403);
    if (paramg.bbA())
    {
      pin(new y(com.tencent.mm.plugin.aa.b.class));
      pin(new y(com.tencent.mm.plugin.collect.app.a.class));
      pin(new y(com.tencent.mm.plugin.luckymoney.app.a.class));
      pin(new y(com.tencent.mm.plugin.mall.a.k.class));
      pin(new y(com.tencent.mm.plugin.offline.k.class));
      pin(new y(com.tencent.mm.plugin.order.a.b.class));
      pin(new y(com.tencent.mm.plugin.product.a.a.class));
      pin(new y(com.tencent.mm.plugin.recharge.a.a.class));
      pin(new y(com.tencent.mm.plugin.remittance.app.c.class));
      pin(new y(p.class));
      pin(new y(u.class));
      pin(new y(com.tencent.mm.plugin.wallet_index.a.a.class));
      pin(new y(com.tencent.mm.plugin.wallet_payu.a.d.class));
      pin(new y(com.tencent.mm.plugin.wxcredit.a.class));
      pin(new y(com.tencent.mm.plugin.fingerprint.a.class));
      pin(new y(com.tencent.mm.plugin.wallet_ecard.a.class));
      pin(new y(com.tencent.mm.plugin.honey_pay.a.class));
      af.aR("wallet", "wallet", 5);
      af.a("luckymoney", "luckymoney", 7776000000L, 518);
    }
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.luckymoney.a.a.class, new com.tencent.mm.kernel.c.e(new r()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.wxpaysdk.api.b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.remittance.app.b()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.wxpaysdk.api.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.wallet_core.a()));
    AppMethodBeat.o(72403);
  }
  
  public void dependency() {}
  
  public void doRedPacketPreviewLoading(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163876);
    Log.i("MicroMsg.LuckyMoneyEnvelopePreview", "do get red packet preview: %s", new Object[] { paramString });
    paramString = new com.tencent.mm.plugin.luckymoney.model.g(paramString);
    w localw = com.tencent.mm.ui.base.k.a(paramContext, 3, a.j.LuckyMoneyNoAnimDialog, paramContext.getString(a.i.loading_tips), true, new s.1(paramString));
    paramString.bFJ().h(new s.2(localw, paramContext));
    AppMethodBeat.o(163876);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72404);
    if (paramg.bbA())
    {
      com.tencent.mm.br.b.bsa("wallet");
      com.tencent.mm.br.b.bsa("mall");
      com.tencent.mm.br.b.bsa("wxcredit");
      com.tencent.mm.br.b.bsa("offline");
      com.tencent.mm.br.b.bsa("recharge");
      com.tencent.mm.br.b.bsa("wallet_index");
      com.tencent.mm.br.b.bsa("order");
      com.tencent.mm.br.b.bsa("product");
      com.tencent.mm.br.b.bsa("remittance");
      com.tencent.mm.br.b.bsa("collect");
      com.tencent.mm.br.b.bsa("wallet_payu");
      com.tencent.mm.br.b.bsa("luckymoney");
      com.tencent.mm.br.b.bsa("fingerprint");
    }
    AppMethodBeat.o(72404);
  }
  
  public ab getWalletCacheStg()
  {
    AppMethodBeat.i(72405);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(72405);
      throw ((Throwable)localObject);
    }
    Object localObject = (ab)this.XIJ.get();
    AppMethodBeat.o(72405);
    return localObject;
  }
  
  public void gotoLuckyMoneyReceiveUI(Context paramContext, Bundle paramBundle, k.b paramb)
  {
    AppMethodBeat.i(267311);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("key_way", 0);
    localIntent.putExtra("key_native_url", paramb.nSL);
    localIntent.putExtra("scene_id", Integer.parseInt(paramb.nSK));
    localIntent.putExtra("key_invalidtime", paramb.nSl);
    paramBundle = (com.tencent.mm.message.c)paramb.aK(com.tencent.mm.message.c.class);
    paramb = (com.tencent.mm.message.g)paramb.aK(com.tencent.mm.message.g.class);
    localIntent.putExtra("key_exclusive_username", paramBundle.nQc);
    localIntent.putExtra("key_cropname", paramBundle.nPT);
    localIntent.putExtra("key_receive_envelope_url", paramBundle.nPY);
    localIntent.putExtra("key_receive_envelope_md5", paramBundle.nPZ);
    localIntent.putExtra("key_receive_envelope_widget_url", paramBundle.nQd);
    localIntent.putExtra("key_receive_envelope_widget_md5", paramBundle.nQe);
    localIntent.putExtra("key_detail_envelope_url", paramBundle.nQa);
    localIntent.putExtra("key_detail_envelope_md5", paramBundle.nQb);
    localIntent.putExtra("key_about_url", paramb.nQD);
    localIntent.putExtra("key_packet_id", paramb.nQE);
    localIntent.putExtra("key_receive_envelope_widget_status_flag", paramBundle.nQj);
    localIntent.putExtra("key_receive_envelope_fission_info", paramBundle.nQk);
    localIntent.putExtra("key_packet_source", paramb.nQF);
    localIntent.putExtra("key_has_story", paramb.nQI);
    localIntent.putExtra("key_material_flag", paramb.nQJ);
    com.tencent.mm.br.c.b(paramContext, "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", localIntent);
    AppMethodBeat.o(267311);
  }
  
  public void gotoRedPacketPreviewUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163877);
    s.fXb();
    s.fXa();
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", "1@fackuser");
    localIntent.putExtra("finish_direct", false);
    localIntent.putExtra("key_red_packet_preview_url", paramString);
    com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(163877);
  }
  
  public boolean hasInitBiometricManager()
  {
    return this.XII;
  }
  
  public void installed()
  {
    AppMethodBeat.i(72401);
    alias(com.tencent.mm.plugin.wxpay.a.a.class);
    com.tencent.mm.plugin.fingerprint.mgr.b localb = new com.tencent.mm.plugin.fingerprint.mgr.b();
    com.tencent.mm.plugin.fingerprint.mgr.a.g localg = new com.tencent.mm.plugin.fingerprint.mgr.a.g();
    localb.a(localg);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.c.a.class, localb);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.mgr.a.i.class, localg);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.wallet.wecoin.a.d.class, new com.tencent.mm.plugin.wallet.wecoin.model.k());
    this.Weg.alive();
    AppMethodBeat.o(72401);
  }
  
  public boolean isPayScene(Activity paramActivity)
  {
    AppMethodBeat.i(267313);
    if (((paramActivity instanceof WalletBaseUI)) || (((IPluginWxKindaApi)com.tencent.mm.kernel.h.az(IPluginWxKindaApi.class)).isKindaScene(paramActivity)) || ((paramActivity instanceof WalletPreferenceUI)) || ((paramActivity instanceof LuckyMoneyBaseUI)) || ((paramActivity instanceof BankMobileRemittanceChooseUI)))
    {
      AppMethodBeat.o(267313);
      return true;
    }
    AppMethodBeat.o(267313);
    return false;
  }
  
  public String name()
  {
    return "plugin-wxpay";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(267316);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this, null);
    AppMethodBeat.o(267316);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(267317);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this);
    AppMethodBeat.o(267317);
  }
  
  public void onExitRedPacketPreviewChatting()
  {
    AppMethodBeat.i(163878);
    com.tencent.mm.plugin.luckymoney.a.b.fWf();
    AppMethodBeat.o(163878);
  }
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(267320);
    if (CrashReportFactory.isBackupMerge())
    {
      AppMethodBeat.o(267320);
      return;
    }
    if ((parami == null) || (paramc == null) || (paramc.mZo == null))
    {
      AppMethodBeat.o(267320);
      return;
    }
    new com.tencent.mm.plugin.wallet_core.utils.e();
    parami = paramc.KRm;
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
      AppMethodBeat.o(267320);
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
      com.tencent.mm.plugin.wallet_core.utils.e.a(paramc.mZo, com.tencent.mm.plugin.wallet_core.utils.d.VXU);
      AppMethodBeat.o(267320);
      return;
      com.tencent.mm.plugin.wallet_core.utils.e.a(paramc.mZo, com.tencent.mm.plugin.wallet_core.utils.d.VXV);
      AppMethodBeat.o(267320);
      return;
      com.tencent.mm.plugin.wallet_core.utils.e.a(paramc.mZo, com.tencent.mm.plugin.wallet_core.utils.d.VXW);
    }
  }
  
  public void triggerSoterReInit()
  {
    AppMethodBeat.i(72407);
    Log.d("MicroMsg.PluginWxPay", "re init soter");
    com.tencent.mm.plugin.fingerprint.mgr.a.i locali = (com.tencent.mm.plugin.fingerprint.mgr.a.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class);
    if (locali.ftV() == 0) {
      locali.prepare();
    }
    AppMethodBeat.o(72407);
  }
  
  public void unMarkLuckyMoneyRedFlag(String paramString)
  {
    AppMethodBeat.i(267312);
    com.tencent.mm.plugin.luckymoney.app.a.fWk().co(paramString, false);
    AppMethodBeat.o(267312);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(72402);
    super.uninstalled();
    this.Weg.dead();
    AppMethodBeat.o(72402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.PluginWxPay
 * JD-Core Version:    0.7.0.1
 */