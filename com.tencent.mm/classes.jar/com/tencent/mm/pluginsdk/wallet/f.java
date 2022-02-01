package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
    c.b(paramContext, "collect", ".reward.ui.QrRewardSelectMoneyUI", localIntent);
    AppMethodBeat.o(117593);
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2, a parama)
  {
    AppMethodBeat.i(117592);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene", paramInt1);
    localIntent.putExtra("receiver_name", paramString);
    if (paramInt2 > 0) {
      localIntent.putExtra("pay_channel", paramInt2);
    }
    a.a(parama, localIntent);
    if (z.aUo()) {
      c.b(paramContext, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(117592);
      return true;
      if (z.aUp())
      {
        c.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        h.CyF.a(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        h.CyF.a(11850, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
      else
      {
        c.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        h.CyF.a(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        h.CyF.a(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
    }
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(117575);
    Intent localIntent = new Intent();
    localIntent.putExtra("orderhandlerui_checkapp_result", paramBoolean);
    if (!Util.isNullOrNil(paramString)) {
      localIntent.putExtra("_mmessage_appPackage", paramString);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramBundle = new PayReq();
    paramBundle.fromBundle(localIntent.getExtras());
    Util.isNullOrNil(paramBundle.prepayId);
    if (gsT())
    {
      localIntent.addFlags(268435456);
      localIntent.addFlags(32768);
    }
    c.b(paramContext, "wallet_index", ".ui.OrderHandlerUI", localIntent);
    AppMethodBeat.o(117575);
    return true;
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
    if ((2 == paramPayInfo.dVv) || (1 == paramPayInfo.dVv) || (4 == paramPayInfo.dVv) || (36 == paramPayInfo.dVv))
    {
      paramPayInfo.crp = false;
      if ((paramPayInfo.dVv != 4) && (paramPayInfo.dVv != 1) && (36 != paramPayInfo.dVv) && (8 != paramPayInfo.dVv)) {
        break label255;
      }
      paramPayInfo.Kxs = true;
      label92:
      paramPayInfo.Cpg = paramString3;
      paramIntent.putExtra("key_pay_info", paramPayInfo);
      paramIntent.putExtra("key_force_use_bind_serail", Util.nullAsNil(paramString1));
      paramIntent.putExtra("key_is_force_use_given_card", paramBoolean);
      if ((paramContext instanceof Activity))
      {
        paramIntent.putExtra("key_context_hashcode", paramContext.hashCode());
        Log.i("MicroMsg.WalletManager", "startPay context %s %s", new Object[] { paramContext, Integer.valueOf(paramContext.hashCode()) });
      }
      if (!Util.isNullOrNil(paramString2)) {
        paramIntent.putExtra("key_is_use_default_card", paramString2);
      }
      Log.i("MicroMsg.WalletManager", "startPay context %s from %s", new Object[] { paramContext, Util.getStack() });
      paramIntent.putExtra("key_receiver_true_name", paramString3);
      if (!z.aUo()) {
        break label264;
      }
      c.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramIntent, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(117586);
      return true;
      paramPayInfo.crp = true;
      break;
      label255:
      paramPayInfo.Kxs = false;
      break label92;
      label264:
      c.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramIntent, paramInt);
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
    Log.i("MicroMsg.WalletManager", "startJsapiPay context %s from %s", new Object[] { paramMMActivity, Util.getStack() });
    c.a(paramMMActivity, "wallet_index", ".ui.WalletBrandUI", localIntent, paramInt, false);
    AppMethodBeat.o(117576);
    return true;
  }
  
  public static boolean a(MMActivity paramMMActivity, String paramString, Map<String, String> paramMap, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(117577);
    WalletJsapiData localWalletJsapiData = new WalletJsapiData();
    localWalletJsapiData.KxH = 4;
    localWalletJsapiData.DWX = paramString;
    localWalletJsapiData.KxP = paramMap;
    paramString = new Intent();
    paramString.putExtra("WalletJsapiData", localWalletJsapiData);
    paramString.putExtra("requestCode", paramInt);
    paramMMActivity.mmSetOnActivityResultCallback(parama);
    Log.i("MicroMsg.WalletManager", "startPayComponent context %s from %s", new Object[] { paramMMActivity, Util.getStack() });
    c.a(paramMMActivity, "wallet_index", ".ui.WalletBrandUI", paramString, paramInt, false);
    AppMethodBeat.o(117577);
    return true;
  }
  
  public static void aD(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117578);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", paramInt);
    c.b(paramContext, "collect", ".ui.CollectAdapterUI", localIntent);
    AppMethodBeat.o(117578);
  }
  
  public static boolean aE(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117589);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_bind_scene", 5);
    localIntent.putExtra("key_offline_add_fee", paramInt);
    c.b(paramContext, "wallet", ".bind.ui.WalletBindUI", localIntent);
    AppMethodBeat.o(117589);
    return true;
  }
  
  public static boolean aF(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117590);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", paramInt);
    if (z.aUo()) {
      c.b(paramContext, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(117590);
      return true;
      c.b(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    }
  }
  
  public static PayInfo ap(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117581);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dDL = paramString1;
    localPayInfo.appId = paramString2;
    localPayInfo.IqM = null;
    localPayInfo.dVv = paramInt;
    localPayInfo.errMsg = null;
    localPayInfo.channel = 0;
    AppMethodBeat.o(117581);
    return localPayInfo;
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117580);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(117580);
      return false;
    }
    boolean bool = a(paramContext, ap(paramString1, paramString2, paramInt1), paramInt2);
    AppMethodBeat.o(117580);
    return bool;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117587);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(117587);
      return false;
    }
    boolean bool = a(paramContext, true, paramString1, ap(paramString2, paramString3, paramInt1), paramInt2);
    AppMethodBeat.o(117587);
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
    localIntent.putExtra("paySignature", paramWalletJsapiData.dVt);
    localIntent.putExtra("url", paramWalletJsapiData.url);
    localIntent.putExtra("key_bind_scene", paramWalletJsapiData.dVw);
    localIntent.putExtra("pay_channel", paramWalletJsapiData.payChannel);
    paramMMActivity.mmSetOnActivityResultCallback(parama);
    c.a(paramMMActivity, "wallet", ".bind.ui.WalletBindUI", localIntent, paramInt, false);
    AppMethodBeat.o(117588);
    return true;
  }
  
  private static boolean gsT()
  {
    AppMethodBeat.i(117594);
    boolean bool = ((b)g.af(b.class)).a(b.a.rWd, false);
    AppMethodBeat.o(117594);
    return bool;
  }
  
  public static boolean iF(Context paramContext)
  {
    AppMethodBeat.i(117591);
    boolean bool = ((b)g.af(b.class)).a(b.a.sad, true);
    Log.i("MicroMsg.WalletManager", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      c.V(paramContext, "mall", ".ui.MallIndexUIv2");
    }
    for (;;)
    {
      AppMethodBeat.o(117591);
      return true;
      c.V(paramContext, "mall", ".ui.MallIndexUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.f
 * JD-Core Version:    0.7.0.1
 */