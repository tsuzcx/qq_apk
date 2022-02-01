package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class g
  implements com.tencent.mm.plugin.wallet.wecoin.a.c
{
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(214157);
    com.tencent.mm.plugin.report.service.h.CyF.a(22129, new Object[] { Integer.valueOf(1), paramString1, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2 });
    AppMethodBeat.o(214157);
  }
  
  public final d a(FragmentActivity paramFragmentActivity, int paramInt, String paramString, com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> parame)
  {
    AppMethodBeat.i(214153);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(214153);
      return null;
    }
    e.a locala = new e.a();
    locala.HMJ = true;
    locala.mScene = paramInt;
    locala.HMK = paramString;
    locala.HML = parame;
    paramFragmentActivity = new com.tencent.mm.plugin.wallet.wecoin.ui.a(paramFragmentActivity, locala.fPD());
    AppMethodBeat.o(214153);
    return paramFragmentActivity;
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> parame)
  {
    AppMethodBeat.i(214149);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "initEngine context is null.");
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214140);
          if (parame != null) {
            parame.p(3, -2, "");
          }
          AppMethodBeat.o(214140);
        }
      });
      AppMethodBeat.o(214149);
      return;
    }
    h.a locala = h.HNL;
    h.fPG().b(paramContext, parame);
    AppMethodBeat.o(214149);
  }
  
  public final void a(Context paramContext, final String paramString, byte[] paramArrayOfByte, final com.tencent.mm.plugin.wallet.wecoin.a.e<Long> parame)
  {
    AppMethodBeat.i(214152);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "consumeWeCoin contextBuff is null");
      a(paramString, 1, 3, 3, "consumeWeCoin contextBuff is null");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 72);
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214146);
          if (parame != null) {
            parame.p(3, -2, "");
          }
          AppMethodBeat.o(214146);
        }
      });
      AppMethodBeat.o(214152);
      return;
    }
    final den localden = new den();
    try
    {
      localden.parseFrom(paramArrayOfByte);
      com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinManagerImplement", localden);
      BaseResponse localBaseResponse = localden.BaseResponse;
      if ((localBaseResponse != null) && (localBaseResponse.Ret != 0))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 72);
        int i = localBaseResponse.Ret;
        paramArrayOfByte = "";
        if (localden.MJy != null)
        {
          Log.i("MicroMsg.WeCoinManagerImplement", "consumeWeCoin intercept_info is not null");
          com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 77);
          int j = 10000;
          String str = localden.MJy.dQx;
          paramArrayOfByte = str;
          i = j;
          if (paramContext != null)
          {
            cdg localcdg = localden.MJy;
            paramArrayOfByte = str;
            i = j;
            if (localcdg != null)
            {
              com.tencent.mm.plugin.wallet.wecoin.c.c.a(paramContext, localcdg, new b()
              {
                public final void a(ddc paramAnonymousddc)
                {
                  AppMethodBeat.i(214144);
                  if ((paramAnonymousddc != null) && (paramAnonymousddc.action == 3)) {
                    g.this.a(localden, paramString, parame, false);
                  }
                  AppMethodBeat.o(214144);
                }
              });
              i = j;
              paramArrayOfByte = str;
            }
          }
        }
        paramContext = paramArrayOfByte;
        if (localBaseResponse.ErrMsg != null)
        {
          paramContext = paramArrayOfByte;
          if (localBaseResponse.ErrMsg.MTp) {
            paramContext = localBaseResponse.ErrMsg.MTo;
          }
        }
        Log.i("MicroMsg.WeCoinManagerImplement", "serialize PrepareWecoinConsumeResponse, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(localBaseResponse.Ret), paramContext });
        parame.p(4, i, paramContext);
        a(paramString, 1, 3, localBaseResponse.Ret, paramContext);
        AppMethodBeat.o(214152);
        return;
      }
    }
    catch (Exception paramContext)
    {
      a(paramString, 1, 3, 3, "parse response failed");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 72);
      Log.e("MicroMsg.WeCoinManagerImplement", "parse PrepareWecoinConsumeResponse failed, exception: %s", new Object[] { paramContext.getMessage() });
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214147);
          if (parame != null) {
            parame.p(3, -1, "");
          }
          AppMethodBeat.o(214147);
        }
      });
      AppMethodBeat.o(214152);
      return;
    }
    a(localden, paramString, parame, false);
    AppMethodBeat.o(214152);
  }
  
  public final void a(final com.tencent.mm.plugin.wallet.wecoin.a.e<Long> parame)
  {
    AppMethodBeat.i(214151);
    new com.tencent.mm.plugin.wallet.wecoin.b.f().aYI().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(214151);
  }
  
  public final void a(final den paramden, final String paramString, final com.tencent.mm.plugin.wallet.wecoin.a.e<Long> parame, boolean paramBoolean)
  {
    AppMethodBeat.i(214156);
    com.tencent.mm.bw.b localb = paramden.Loz;
    if (localb == null)
    {
      a(paramString, 1, 3, 3, "contextByteString is null");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 72);
      Log.e("MicroMsg.WeCoinManagerImplement", "contextByteString is null");
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214148);
          if (parame != null) {
            parame.p(3, -1, "");
          }
          AppMethodBeat.o(214148);
        }
      });
      AppMethodBeat.o(214156);
      return;
    }
    if (!paramBoolean)
    {
      a(paramString, 1, 3, 0, "");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 71);
    }
    a(paramString, 2, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 73);
    byte[] arrayOfByte = com.tencent.mm.network.b.bjq().az(localb.zy);
    if (arrayOfByte == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "signData is null");
      a(paramString, 2, 3, 4, "sign data failed.");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 76);
      com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 75);
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214141);
          if (parame != null) {
            parame.p(3, -1, "");
          }
          AppMethodBeat.o(214141);
        }
      });
      AppMethodBeat.o(214156);
      return;
    }
    new com.tencent.mm.plugin.wallet.wecoin.b.b(localb, paramString, new com.tencent.mm.bw.b(arrayOfByte)).aYI().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(214156);
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.b aP(Activity paramActivity)
  {
    AppMethodBeat.i(214155);
    if (paramActivity == null)
    {
      AppMethodBeat.o(214155);
      return null;
    }
    paramActivity = new com.tencent.mm.plugin.wallet.wecoin.ui.b(paramActivity);
    AppMethodBeat.o(214155);
    return paramActivity;
  }
  
  public final void bN(Context paramContext, String paramString)
  {
    AppMethodBeat.i(214154);
    if (paramContext == null)
    {
      AppMethodBeat.o(214154);
      return;
    }
    Intent localIntent = new Intent(paramContext, WeCoinIncomeDetailView.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("wecoin_enter_encash_business_kv_data", new WecoinEncashKVData(1, paramString, ""));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(214154);
  }
  
  public final boolean dfq()
  {
    AppMethodBeat.i(214150);
    boolean bool = "CN".equalsIgnoreCase(Util.nullAs((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null), "CN"));
    Log.i("MicroMsg.WeCoinManagerImplement", "isWeCoinEntranceAvailable, isChinaReg: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scI, 0);
      Log.i("MicroMsg.WeCoinUtils", "isWeCoinEntranceABTestHit, %s", new Object[] { Integer.valueOf(i) });
      if (i == 0) {}
      for (i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(214150);
        return true;
      }
    }
    AppMethodBeat.o(214150);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.g
 * JD-Core Version:    0.7.0.1
 */