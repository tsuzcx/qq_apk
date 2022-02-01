package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Map;

public final class f
{
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(117593);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_qrcode_url", paramString1);
    localIntent.putExtra("key_channel", paramInt1);
    localIntent.putExtra("key_web_url", paramString2);
    localIntent.putExtra("key_scene", paramInt2);
    d.b(paramContext, "collect", ".reward.ui.QrRewardSelectMoneyUI", localIntent);
    AppMethodBeat.o(117593);
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2, com.tencent.mm.plugin.wallet.a parama)
  {
    AppMethodBeat.i(117592);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene", paramInt1);
    localIntent.putExtra("receiver_name", paramString);
    if (paramInt2 > 0) {
      localIntent.putExtra("pay_channel", paramInt2);
    }
    com.tencent.mm.plugin.wallet.a.a(parama, localIntent);
    if (u.axL()) {
      d.b(paramContext, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(117592);
      return true;
      if (u.axM())
      {
        d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        h.wUl.f(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        h.wUl.f(11850, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
      else
      {
        d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        h.wUl.f(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        h.wUl.f(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
    }
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean, String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(117575);
    Intent localIntent = new Intent();
    localIntent.putExtra("orderhandlerui_checkapp_result", paramBoolean);
    if (!bs.isNullOrNil(paramString)) {
      localIntent.putExtra("_mmessage_appPackage", paramString);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramString = new PayReq();
    paramString.fromBundle(localIntent.getExtras());
    paramBundle = paramString.prepayId;
    if (bs.isNullOrNil(paramString.prepayId)) {
      paramBundle = "";
    }
    paramBoolean = paramBundle.startsWith("sns_");
    boolean bool2 = paramBundle.startsWith("tax_");
    boolean bool3 = paramBundle.startsWith("seb_ff_");
    if ((paramBoolean) || (bool2) || (bool3))
    {
      bool1 = true;
      paramBoolean = eQz();
      if (localIntent.getIntExtra("key_scene", 0) != 1) {
        break label225;
      }
      bool2 = ((a)g.ab(a.class)).kindaCacheServiceGetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY");
      if (!bool1) {
        i = 1;
      }
    }
    for (boolean bool1 = bool2 & paramBoolean & i;; bool1 = bool2 & paramBoolean & i)
    {
      if (bool1)
      {
        localIntent.addFlags(268435456);
        localIntent.addFlags(32768);
      }
      d.b(paramContext, "wallet_index", ".ui.OrderHandlerUI", localIntent);
      AppMethodBeat.o(117575);
      return true;
      bool1 = false;
      break;
      label225:
      bool2 = ((a)g.ab(a.class)).kindaCacheServiceGetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY");
      i = j;
      if (!bool1) {
        i = 1;
      }
    }
  }
  
  public static boolean a(Context paramContext, PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(117582);
    boolean bool = a(paramContext, false, "", paramPayInfo, paramInt);
    AppMethodBeat.o(117582);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117579);
    boolean bool = b(paramContext, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(117579);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117587);
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(117587);
      return false;
    }
    boolean bool = a(paramContext, true, paramString1, af(paramString2, paramString3, paramInt1), paramInt2);
    AppMethodBeat.o(117587);
    return bool;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean, String paramString, PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(117583);
    paramBoolean = b(paramContext, paramBoolean, paramString, paramPayInfo, paramInt);
    AppMethodBeat.o(117583);
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, PayInfo paramPayInfo, String paramString2, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117585);
    paramBoolean = a(paramContext, paramBoolean, paramString1, "", paramPayInfo, paramString2, paramIntent, paramInt);
    AppMethodBeat.o(117585);
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(117586);
    if ((2 == paramPayInfo.dqL) || (1 == paramPayInfo.dqL) || (4 == paramPayInfo.dqL) || (36 == paramPayInfo.dqL))
    {
      paramPayInfo.teP = false;
      if ((paramPayInfo.dqL != 4) && (paramPayInfo.dqL != 1) && (36 != paramPayInfo.dqL) && (8 != paramPayInfo.dqL)) {
        break label259;
      }
      paramPayInfo.DGJ = true;
      label92:
      paramPayInfo.wKR = paramString3;
      paramIntent.putExtra("key_pay_info", paramPayInfo);
      paramIntent.putExtra("key_force_use_bind_serail", bs.nullAsNil(paramString1));
      paramIntent.putExtra("key_is_force_use_given_card", paramBoolean);
      if ((paramContext instanceof Activity))
      {
        paramIntent.putExtra("key_context_hashcode", paramContext.hashCode());
        ac.i("MicroMsg.WalletManager", "startPay context %s %s", new Object[] { paramContext, Integer.valueOf(paramContext.hashCode()) });
      }
      if (!bs.isNullOrNil(paramString2)) {
        paramIntent.putExtra("key_is_use_default_card", paramString2);
      }
      ac.i("MicroMsg.WalletManager", "startPay context %s from %s", new Object[] { paramContext, bs.eWi() });
      paramIntent.putExtra("key_receiver_true_name", paramString3);
      if (!u.axL()) {
        break label268;
      }
      d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramIntent, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(117586);
      return true;
      paramPayInfo.teP = true;
      break;
      label259:
      paramPayInfo.DGJ = false;
      break label92;
      label268:
      d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramIntent, paramInt);
    }
  }
  
  public static boolean a(MMActivity paramMMActivity, WalletJsapiData paramWalletJsapiData, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(117576);
    if (paramWalletJsapiData == null)
    {
      AppMethodBeat.o(117576);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("WalletJsapiData", paramWalletJsapiData);
    localIntent.putExtra("requestCode", paramInt);
    if (parama != null) {
      paramMMActivity.mmSetOnActivityResultCallback(parama);
    }
    ac.i("MicroMsg.WalletManager", "startJsapiPay context %s from %s", new Object[] { paramMMActivity, bs.eWi() });
    d.a(paramMMActivity, "wallet_index", ".ui.WalletBrandUI", localIntent, paramInt, false);
    AppMethodBeat.o(117576);
    return true;
  }
  
  public static boolean a(MMActivity paramMMActivity, String paramString, Map<String, String> paramMap, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(117577);
    WalletJsapiData localWalletJsapiData = new WalletJsapiData();
    localWalletJsapiData.DGX = 4;
    localWalletJsapiData.yht = paramString;
    localWalletJsapiData.DHf = paramMap;
    paramString = new Intent();
    paramString.putExtra("WalletJsapiData", localWalletJsapiData);
    paramString.putExtra("requestCode", paramInt);
    paramMMActivity.mmSetOnActivityResultCallback(parama);
    ac.i("MicroMsg.WalletManager", "startPayComponent context %s from %s", new Object[] { paramMMActivity, bs.eWi() });
    d.a(paramMMActivity, "wallet_index", ".ui.WalletBrandUI", paramString, paramInt, false);
    AppMethodBeat.o(117577);
    return true;
  }
  
  public static PayInfo af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117581);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dac = paramString1;
    localPayInfo.appId = paramString2;
    localPayInfo.BPA = null;
    localPayInfo.dqL = paramInt;
    localPayInfo.errMsg = null;
    localPayInfo.channel = 0;
    AppMethodBeat.o(117581);
    return localPayInfo;
  }
  
  public static void ar(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117578);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", paramInt);
    d.b(paramContext, "collect", ".ui.CollectAdapterUI", localIntent);
    AppMethodBeat.o(117578);
  }
  
  public static boolean as(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117589);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_bind_scene", 5);
    localIntent.putExtra("key_offline_add_fee", paramInt);
    d.b(paramContext, "wallet", ".bind.ui.WalletBindUI", localIntent);
    AppMethodBeat.o(117589);
    return true;
  }
  
  public static boolean at(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117590);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", paramInt);
    if (u.axL()) {
      d.b(paramContext, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(117590);
      return true;
      d.b(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    }
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117580);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(117580);
      return false;
    }
    boolean bool = a(paramContext, af(paramString1, paramString2, paramInt1), paramInt2);
    AppMethodBeat.o(117580);
    return bool;
  }
  
  private static boolean b(Context paramContext, boolean paramBoolean, String paramString, PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(117584);
    paramBoolean = a(paramContext, paramBoolean, paramString, paramPayInfo, null, new Intent(), paramInt);
    AppMethodBeat.o(117584);
    return paramBoolean;
  }
  
  public static boolean b(MMActivity paramMMActivity, WalletJsapiData paramWalletJsapiData, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(117588);
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramWalletJsapiData.appId);
    localIntent.putExtra("timeStamp", paramWalletJsapiData.timeStamp);
    localIntent.putExtra("nonceStr", paramWalletJsapiData.nonceStr);
    localIntent.putExtra("packageExt", paramWalletJsapiData.packageExt);
    localIntent.putExtra("signtype", paramWalletJsapiData.signType);
    localIntent.putExtra("paySignature", paramWalletJsapiData.dqJ);
    localIntent.putExtra("url", paramWalletJsapiData.url);
    localIntent.putExtra("key_bind_scene", paramWalletJsapiData.dqM);
    localIntent.putExtra("pay_channel", paramWalletJsapiData.dcB);
    paramMMActivity.mmSetOnActivityResultCallback(parama);
    d.a(paramMMActivity, "wallet", ".bind.ui.WalletBindUI", localIntent, paramInt, false);
    AppMethodBeat.o(117588);
    return true;
  }
  
  private static boolean eQz()
  {
    AppMethodBeat.i(117594);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pRO, false);
    AppMethodBeat.o(117594);
    return bool;
  }
  
  public static boolean hA(Context paramContext)
  {
    AppMethodBeat.i(117591);
    d.N(paramContext, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(117591);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.f
 * JD-Core Version:    0.7.0.1
 */