package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class h
{
  public static PayInfo S(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(135781);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.cnI = paramString1;
    localPayInfo.appId = paramString2;
    localPayInfo.uAe = null;
    localPayInfo.cCD = paramInt;
    localPayInfo.errMsg = null;
    localPayInfo.cCy = 0;
    AppMethodBeat.o(135781);
    return localPayInfo;
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(135793);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_qrcode_url", paramString1);
    localIntent.putExtra("key_channel", paramInt1);
    localIntent.putExtra("key_web_url", paramString2);
    localIntent.putExtra("key_scene", paramInt2);
    d.b(paramContext, "collect", ".reward.ui.QrRewardSelectMoneyUI", localIntent);
    AppMethodBeat.o(135793);
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2, com.tencent.mm.plugin.wallet.a parama)
  {
    AppMethodBeat.i(135792);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene", paramInt1);
    localIntent.putExtra("receiver_name", paramString);
    if (paramInt2 > 0) {
      localIntent.putExtra("pay_channel", paramInt2);
    }
    com.tencent.mm.plugin.wallet.a.a(parama, localIntent);
    if (r.ZB()) {
      d.b(paramContext, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(135792);
      return true;
      if (r.ZC())
      {
        d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        com.tencent.mm.plugin.report.service.h.qsU.e(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
      else
      {
        d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        com.tencent.mm.plugin.report.service.h.qsU.e(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
    }
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean, String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(135776);
    Intent localIntent = new Intent();
    localIntent.putExtra("orderhandlerui_checkapp_result", paramBoolean);
    if (!bo.isNullOrNil(paramString)) {
      localIntent.putExtra("_mmessage_appPackage", paramString);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramBundle = new PayReq();
    paramBundle.fromBundle(localIntent.getExtras());
    paramBundle = paramBundle.prepayId;
    paramBoolean = paramBundle.startsWith("sns_");
    boolean bool2 = paramBundle.startsWith("tax_");
    boolean bool3 = paramBundle.startsWith("seb_ff_");
    if ((paramBoolean) || (bool2) || (bool3))
    {
      bool1 = true;
      paramBoolean = dpQ();
      if (localIntent.getIntExtra("key_scene", 0) != 1) {
        break label212;
      }
      bool2 = ((b)g.E(b.class)).kindaCacheServiceGetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY");
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
      AppMethodBeat.o(135776);
      return true;
      bool1 = false;
      break;
      label212:
      bool2 = ((b)g.E(b.class)).kindaCacheServiceGetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY");
      i = j;
      if (!bool1) {
        i = 1;
      }
    }
  }
  
  public static boolean a(Context paramContext, PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(135782);
    boolean bool = a(paramContext, false, "", paramPayInfo, paramInt);
    AppMethodBeat.o(135782);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135779);
    boolean bool = b(paramContext, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(135779);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135787);
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(135787);
      return false;
    }
    boolean bool = a(paramContext, true, paramString1, S(paramString2, paramString3, paramInt1), paramInt2);
    AppMethodBeat.o(135787);
    return bool;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean, String paramString, PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(135783);
    paramBoolean = b(paramContext, paramBoolean, paramString, paramPayInfo, paramInt);
    AppMethodBeat.o(135783);
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, PayInfo paramPayInfo, String paramString2, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(135785);
    paramBoolean = a(paramContext, paramBoolean, paramString1, "", paramPayInfo, paramString2, paramIntent, paramInt);
    AppMethodBeat.o(135785);
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(135786);
    if ((2 == paramPayInfo.cCD) || (1 == paramPayInfo.cCD) || (4 == paramPayInfo.cCD) || (36 == paramPayInfo.cCD))
    {
      paramPayInfo.nnQ = false;
      if ((paramPayInfo.cCD != 4) && (paramPayInfo.cCD != 1) && (36 != paramPayInfo.cCD) && (8 != paramPayInfo.cCD)) {
        break label263;
      }
      paramPayInfo.wgt = true;
      label92:
      paramPayInfo.qjK = paramString3;
      paramIntent.putExtra("key_pay_info", paramPayInfo);
      paramIntent.putExtra("key_force_use_bind_serail", bo.nullAsNil(paramString1));
      paramIntent.putExtra("key_is_force_use_given_card", paramBoolean);
      if ((paramContext instanceof Activity))
      {
        paramIntent.putExtra("key_context_hashcode", paramContext.hashCode());
        ab.i("MicroMsg.WalletManager", "startPay context %s %s", new Object[] { paramContext, Integer.valueOf(paramContext.hashCode()) });
      }
      if (!bo.isNullOrNil(paramString2)) {
        paramIntent.putExtra("key_is_use_default_card", paramString2);
      }
      ab.i("MicroMsg.WalletManager", "startPay context %s from %s", new Object[] { paramContext, bo.dtY() });
      paramIntent.putExtra("key_receiver_true_name", paramString3);
      if (!r.ZB()) {
        break label272;
      }
      d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramIntent, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(135786);
      return true;
      paramPayInfo.nnQ = true;
      break;
      label263:
      paramPayInfo.wgt = false;
      break label92;
      label272:
      d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramIntent, paramInt);
    }
  }
  
  public static boolean a(MMActivity paramMMActivity, WalletJsapiData paramWalletJsapiData, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(135777);
    Intent localIntent = new Intent();
    localIntent.putExtra("WalletJsapiData", paramWalletJsapiData);
    localIntent.putExtra("requestCode", paramInt);
    if (parama != null) {
      paramMMActivity.mmSetOnActivityResultCallback(parama);
    }
    ab.i("MicroMsg.WalletManager", "startJsapiPay context %s from %s", new Object[] { paramMMActivity, bo.dtY() });
    d.a(paramMMActivity, "wallet_index", ".ui.WalletBrandUI", localIntent, paramInt, false);
    AppMethodBeat.o(135777);
    return true;
  }
  
  public static void al(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(135778);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", paramInt);
    d.b(paramContext, "collect", ".ui.CollectAdapterUI", localIntent);
    AppMethodBeat.o(135778);
  }
  
  public static boolean am(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(135789);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_bind_scene", 5);
    localIntent.putExtra("key_offline_add_fee", paramInt);
    d.b(paramContext, "wallet", ".bind.ui.WalletBindUI", localIntent);
    AppMethodBeat.o(135789);
    return true;
  }
  
  public static boolean an(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(135790);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", paramInt);
    if (r.ZB()) {
      d.b(paramContext, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(135790);
      return true;
      d.b(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    }
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135780);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(135780);
      return false;
    }
    boolean bool = a(paramContext, S(paramString1, paramString2, paramInt1), paramInt2);
    AppMethodBeat.o(135780);
    return bool;
  }
  
  private static boolean b(Context paramContext, boolean paramBoolean, String paramString, PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(135784);
    paramBoolean = a(paramContext, paramBoolean, paramString, paramPayInfo, null, new Intent(), paramInt);
    AppMethodBeat.o(135784);
    return paramBoolean;
  }
  
  public static boolean b(MMActivity paramMMActivity, WalletJsapiData paramWalletJsapiData, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(135788);
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramWalletJsapiData.appId);
    localIntent.putExtra("timeStamp", paramWalletJsapiData.timeStamp);
    localIntent.putExtra("nonceStr", paramWalletJsapiData.nonceStr);
    localIntent.putExtra("packageExt", paramWalletJsapiData.packageExt);
    localIntent.putExtra("signtype", paramWalletJsapiData.signType);
    localIntent.putExtra("paySignature", paramWalletJsapiData.cCB);
    localIntent.putExtra("url", paramWalletJsapiData.url);
    localIntent.putExtra("key_bind_scene", paramWalletJsapiData.cCE);
    localIntent.putExtra("pay_channel", paramWalletJsapiData.cqj);
    paramMMActivity.mmSetOnActivityResultCallback(parama);
    d.a(paramMMActivity, "wallet", ".bind.ui.WalletBindUI", localIntent, paramInt, false);
    AppMethodBeat.o(135788);
    return true;
  }
  
  private static boolean dpQ()
  {
    AppMethodBeat.i(141116);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVb, false);
    AppMethodBeat.o(141116);
    return bool;
  }
  
  public static boolean gc(Context paramContext)
  {
    AppMethodBeat.i(135791);
    d.H(paramContext, "mall", ".ui.MallIndexUI");
    AppMethodBeat.o(135791);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.h
 * JD-Core Version:    0.7.0.1
 */