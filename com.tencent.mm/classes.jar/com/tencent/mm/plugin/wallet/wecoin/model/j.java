package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.plugin.wallet.wecoin.b.g;
import com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class j
  implements com.tencent.mm.plugin.wallet.wecoin.a.c
{
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(277896);
    com.tencent.mm.plugin.report.service.h.IzE.a(22129, new Object[] { Integer.valueOf(1), paramString1, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2 });
    AppMethodBeat.o(277896);
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.d a(FragmentActivity paramFragmentActivity, int paramInt, String paramString, e<Boolean> parame)
  {
    AppMethodBeat.i(277889);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(277889);
      return null;
    }
    e.a locala = new e.a();
    locala.OEF = true;
    locala.mScene = paramInt;
    locala.OEG = paramString;
    locala.OEH = parame;
    paramFragmentActivity = new com.tencent.mm.plugin.wallet.wecoin.ui.a(paramFragmentActivity, locala.gIh());
    AppMethodBeat.o(277889);
    return paramFragmentActivity;
  }
  
  public final void a(Context paramContext, final e<Boolean> parame)
  {
    AppMethodBeat.i(277883);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "initEngine context is null.");
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(267526);
          if (parame != null) {
            parame.p(3, -2, "");
          }
          AppMethodBeat.o(267526);
        }
      });
      AppMethodBeat.o(277883);
      return;
    }
    k.a locala = k.OFH;
    k.gIk().b(paramContext, parame);
    AppMethodBeat.o(277883);
  }
  
  public final void a(Context paramContext, final String paramString, byte[] paramArrayOfByte, final e<Long> parame)
  {
    AppMethodBeat.i(277888);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "consumeWeCoin contextBuff is null");
      a(paramString, 1, 3, 3, "consumeWeCoin contextBuff is null");
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 72);
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278051);
          if (parame != null) {
            parame.p(3, -2, "");
          }
          AppMethodBeat.o(278051);
        }
      });
      AppMethodBeat.o(277888);
      return;
    }
    final dod localdod = new dod();
    try
    {
      localdod.parseFrom(paramArrayOfByte);
      com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinManagerImplement", localdod);
      jh localjh = localdod.BaseResponse;
      if ((localjh != null) && (localjh.CqV != 0))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(1581, 72);
        int i = localjh.CqV;
        paramArrayOfByte = "";
        if (localdod.TVn != null)
        {
          Log.i("MicroMsg.WeCoinManagerImplement", "consumeWeCoin intercept_info is not null");
          com.tencent.mm.plugin.report.service.h.IzE.el(1581, 77);
          int j = 10000;
          String str = localdod.TVn.wording;
          paramArrayOfByte = str;
          i = j;
          if (paramContext != null)
          {
            cma localcma = localdod.TVn;
            paramArrayOfByte = str;
            i = j;
            if (localcma != null)
            {
              com.tencent.mm.plugin.wallet.wecoin.c.c.a(paramContext, localcma, new b()
              {
                public final void a(dms paramAnonymousdms)
                {
                  AppMethodBeat.i(204306);
                  if ((paramAnonymousdms != null) && (paramAnonymousdms.action == 3)) {
                    j.this.a(localdod, paramString, parame, false);
                  }
                  AppMethodBeat.o(204306);
                }
              });
              i = j;
              paramArrayOfByte = str;
            }
          }
        }
        paramContext = paramArrayOfByte;
        if (localjh.Tef != null)
        {
          paramContext = paramArrayOfByte;
          if (localjh.Tef.Ufz) {
            paramContext = localjh.Tef.Ufy;
          }
        }
        Log.i("MicroMsg.WeCoinManagerImplement", "serialize PrepareWecoinConsumeResponse, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(localjh.CqV), paramContext });
        if (parame != null) {
          parame.p(4, i, paramContext);
        }
        a(paramString, 1, 3, localjh.CqV, paramContext);
        AppMethodBeat.o(277888);
        return;
      }
    }
    catch (Exception paramContext)
    {
      a(paramString, 1, 3, 3, "parse response failed");
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 72);
      Log.e("MicroMsg.WeCoinManagerImplement", "parse PrepareWecoinConsumeResponse failed, exception: %s", new Object[] { paramContext.getMessage() });
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(266798);
          if (parame != null) {
            parame.p(3, -1, "");
          }
          AppMethodBeat.o(266798);
        }
      });
      AppMethodBeat.o(277888);
      return;
    }
    a(localdod, paramString, parame, false);
    AppMethodBeat.o(277888);
  }
  
  public final void a(e<Long> parame)
  {
    AppMethodBeat.i(277886);
    new g().bhW().b(new j.5(this, parame));
    AppMethodBeat.o(277886);
  }
  
  public final void a(final dod paramdod, final String paramString, final e<Long> parame, boolean paramBoolean)
  {
    AppMethodBeat.i(277894);
    com.tencent.mm.cd.b localb = paramdod.SpV;
    if (localb == null)
    {
      a(paramString, 1, 3, 3, "contextByteString is null");
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 72);
      Log.e("MicroMsg.WeCoinManagerImplement", "contextByteString is null");
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(266239);
          if (parame != null) {
            parame.p(3, -1, "");
          }
          AppMethodBeat.o(266239);
        }
      });
      AppMethodBeat.o(277894);
      return;
    }
    if (!paramBoolean)
    {
      a(paramString, 1, 3, 0, "");
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 71);
    }
    a(paramString, 2, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.IzE.el(1581, 73);
    byte[] arrayOfByte = com.tencent.mm.network.b.bsU().aK(localb.UH);
    if (arrayOfByte == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "signData is null");
      a(paramString, 2, 3, 4, "sign data failed.");
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 76);
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 75);
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(223614);
          if (parame != null) {
            parame.p(3, -1, "");
          }
          AppMethodBeat.o(223614);
        }
      });
      AppMethodBeat.o(277894);
      return;
    }
    new com.tencent.mm.plugin.wallet.wecoin.b.b(localb, paramString, new com.tencent.mm.cd.b(arrayOfByte)).bhW().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(277894);
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.b ao(Activity paramActivity)
  {
    AppMethodBeat.i(277892);
    if (paramActivity == null)
    {
      AppMethodBeat.o(277892);
      return null;
    }
    paramActivity = new com.tencent.mm.plugin.wallet.wecoin.ui.b(paramActivity);
    AppMethodBeat.o(277892);
    return paramActivity;
  }
  
  public final void b(e<Long> parame)
  {
    AppMethodBeat.i(277887);
    new com.tencent.mm.plugin.wallet.wecoin.b.d().bhW().b(new j.6(this, parame));
    AppMethodBeat.o(277887);
  }
  
  public final void bY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(277890);
    if (paramContext == null)
    {
      AppMethodBeat.o(277890);
      return;
    }
    Intent localIntent = new Intent(paramContext, WeCoinIncomeDetailView.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("wecoin_enter_encash_business_kv_data", new WecoinEncashKVData(1, paramString, ""));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(277890);
  }
  
  public final boolean dxX()
  {
    AppMethodBeat.i(277884);
    boolean bool = "CN".equalsIgnoreCase(Util.nullAs((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null), "CN"));
    Log.i("MicroMsg.WeCoinManagerImplement", "isWeCoinEntranceAvailable, isChinaReg: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLd, 0);
      Log.i("MicroMsg.WeCoinUtils", "isWeCoinEntranceABTestHit, %s", new Object[] { Integer.valueOf(i) });
      if (i == 0) {}
      for (i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(277884);
        return true;
      }
    }
    AppMethodBeat.o(277884);
    return false;
  }
  
  public final Long gIg()
  {
    AppMethodBeat.i(277885);
    long l = com.tencent.mm.plugin.wallet.wecoin.c.c.gIq();
    AppMethodBeat.o(277885);
    return Long.valueOf(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.j
 * JD-Core Version:    0.7.0.1
 */