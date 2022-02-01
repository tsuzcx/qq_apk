package com.tencent.mm.plugin.wxpay;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.fingerprint.b.a.j;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.s.1;
import com.tencent.mm.plugin.luckymoney.model.s.2;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_payu.a.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.wallet_core.c.aa;
import java.util.HashMap;

public class PluginWxPay
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.wxpay.a.a
{
  private IListener<on> IuY;
  private boolean JQT;
  private com.tencent.mm.co.h<aa> JQU;
  
  public PluginWxPay()
  {
    AppMethodBeat.i(72400);
    this.JQT = false;
    this.JQU = new com.tencent.mm.co.h(new PluginWxPay.1(this));
    this.IuY = new IListener() {};
    AppMethodBeat.o(72400);
  }
  
  private com.tencent.mm.plugin.fingerprint.b.a.i biometricPayManager(int paramInt)
  {
    AppMethodBeat.i(72406);
    Object localObject = new j();
    if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).dKp())
    {
      ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).prepare();
      AppMethodBeat.o(72406);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.fingerprint.b.a.h();
    if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject).dKp())
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
    localHashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new PluginWxPay.3(this));
    AppMethodBeat.o(72408);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72403);
    if (paramg.aBb())
    {
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.aa.b.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.collect.a.a.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.luckymoney.b.a.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.mall.a.k.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.offline.k.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.order.a.b.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.product.a.a.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.recharge.a.a.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.remittance.a.c.class));
      pin(new com.tencent.mm.model.y(s.class));
      pin(new com.tencent.mm.model.y(t.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.wallet_index.a.a.class));
      pin(new com.tencent.mm.model.y(d.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.wxcredit.a.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.fingerprint.a.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.wallet_ecard.a.class));
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.honey_pay.a.class));
      com.tencent.mm.vfs.y.at("wallet", "wallet", 7);
    }
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.a.a.class, new e(new r()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.wxpaysdk.api.b.class, new e(new com.tencent.mm.plugin.remittance.a.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.wxpaysdk.api.c.class, new e(new com.tencent.mm.plugin.wallet_core.a()));
    AppMethodBeat.o(72403);
  }
  
  public void dependency() {}
  
  public void doRedPacketPreviewLoading(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163876);
    Log.i("MicroMsg.LuckyMoneyEnvelopePreview", "do get red packet preview: %s", new Object[] { paramString });
    paramString = new com.tencent.mm.plugin.luckymoney.model.f(paramString);
    q localq = com.tencent.mm.ui.base.h.a(paramContext, 3, 2131821007, paramContext.getString(2131762446), true, new s.1(paramString));
    paramString.aYI().h(new s.2(localq, paramContext));
    AppMethodBeat.o(163876);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(72404);
    if (paramg.aBb())
    {
      com.tencent.mm.br.b.bfQ("wallet");
      com.tencent.mm.br.b.bfQ("mall");
      com.tencent.mm.br.b.bfQ("wxcredit");
      com.tencent.mm.br.b.bfQ("offline");
      com.tencent.mm.br.b.bfQ("recharge");
      com.tencent.mm.br.b.bfQ("wallet_index");
      com.tencent.mm.br.b.bfQ("order");
      com.tencent.mm.br.b.bfQ("product");
      com.tencent.mm.br.b.bfQ("remittance");
      com.tencent.mm.br.b.bfQ("collect");
      com.tencent.mm.br.b.bfQ("wallet_payu");
      com.tencent.mm.br.b.bfQ("luckymoney");
      com.tencent.mm.br.b.bfQ("fingerprint");
    }
    AppMethodBeat.o(72404);
  }
  
  public aa getWalletCacheStg()
  {
    AppMethodBeat.i(72405);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(72405);
      throw ((Throwable)localObject);
    }
    Object localObject = (aa)this.JQU.get();
    AppMethodBeat.o(72405);
    return localObject;
  }
  
  public void gotoRedPacketPreviewUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(163877);
    Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "before cursor: %s", new Object[] { Integer.valueOf(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEv("1@fackuser").getCount()) });
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEE("1@fackuser");
    Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "after cursor: %s", new Object[] { Integer.valueOf(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEv("1@fackuser").getCount()) });
    if ((int)((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjJ("1@fackuser").gMZ > 0) {
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().aNa("1@fackuser");
    }
    Object localObject = new as();
    ((as)localObject).setUsername("1@fackuser");
    ((as)localObject).setNickname(MMApplicationContext.getContext().getString(2131762712));
    ((as)localObject).aqQ();
    ((as)localObject).gMZ = -99L;
    ((as)localObject).ni(3);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().am((as)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", "1@fackuser");
    ((Intent)localObject).putExtra("finish_direct", false);
    ((Intent)localObject).putExtra("key_red_packet_preview_url", paramString);
    com.tencent.mm.br.c.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    AppMethodBeat.o(163877);
  }
  
  public boolean hasInitBiometricManager()
  {
    return this.JQT;
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
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.wallet.wecoin.a.c.class, new com.tencent.mm.plugin.wallet.wecoin.model.g());
    this.IuY.alive();
    AppMethodBeat.o(72401);
  }
  
  public String name()
  {
    return "plugin-wxpay";
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
  
  public void onExitRedPacketPreviewChatting()
  {
    AppMethodBeat.i(163878);
    com.tencent.mm.plugin.luckymoney.a.b.ees();
    AppMethodBeat.o(163878);
  }
  
  public void triggerSoterReInit()
  {
    AppMethodBeat.i(72407);
    Log.d("MicroMsg.PluginWxPay", "re init soter");
    com.tencent.mm.plugin.fingerprint.b.a.i locali = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (locali.dKu() == 0) {
      locali.prepare();
    }
    AppMethodBeat.o(72407);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(72402);
    super.uninstalled();
    this.IuY.dead();
    AppMethodBeat.o(72402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.PluginWxPay
 * JD-Core Version:    0.7.0.1
 */