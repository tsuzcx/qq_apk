package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class h
{
  public static PayInfo J(String paramString1, String paramString2, int paramInt)
  {
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.bMX = paramString1;
    localPayInfo.appId = paramString2;
    localPayInfo.qLi = null;
    localPayInfo.bUV = paramInt;
    localPayInfo.aox = null;
    localPayInfo.bUR = 0;
    return localPayInfo;
  }
  
  public static void X(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", paramInt);
    d.b(paramContext, "collect", ".ui.CollectAdapterUI", localIntent);
  }
  
  public static boolean Y(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_bind_scene", 5);
    localIntent.putExtra("key_offline_add_fee", paramInt);
    d.b(paramContext, "wallet", ".bind.ui.WalletBindUI", localIntent);
    return true;
  }
  
  public static boolean Z(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", paramInt);
    if (q.Gw()) {
      d.b(paramContext, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", localIntent);
    }
    for (;;)
    {
      return true;
      d.b(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_qrcode_url", paramString1);
    localIntent.putExtra("key_channel", paramInt1);
    localIntent.putExtra("key_web_url", paramString2);
    localIntent.putExtra("key_scene", paramInt2);
    d.b(paramContext, "collect", ".reward.ui.QrRewardSelectMoneyUI", localIntent);
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2, a parama)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("scene", paramInt1);
    localIntent.putExtra("receiver_name", paramString);
    if (paramInt2 > 0) {
      localIntent.putExtra("pay_channel", paramInt2);
    }
    a.a(parama, localIntent);
    if (q.Gw())
    {
      d.b(paramContext, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", localIntent);
      return true;
    }
    if (q.Gx())
    {
      d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      return true;
    }
    d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
    com.tencent.mm.plugin.report.service.h.nFQ.f(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
    return true;
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("orderhandlerui_checkapp_result", paramBoolean);
    if (!bk.bl(paramString)) {
      localIntent.putExtra("_mmessage_appPackage", paramString);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    d.b(paramContext, "wallet_index", ".ui.OrderHandlerUI", localIntent);
    return true;
  }
  
  public static boolean a(Context paramContext, PayInfo paramPayInfo, int paramInt)
  {
    return a(paramContext, false, "", paramPayInfo, paramInt);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString1)) {
      return false;
    }
    return a(paramContext, J(paramString1, paramString2, paramInt1), paramInt2);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString2)) {
      return false;
    }
    return a(paramContext, true, paramString1, J(paramString2, paramString3, paramInt1), paramInt2);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString, PayInfo paramPayInfo, int paramInt)
  {
    return a(paramContext, paramBoolean, paramString, paramPayInfo, null, new Intent(), paramInt);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, PayInfo paramPayInfo, String paramString2, Intent paramIntent, int paramInt)
  {
    return a(paramContext, paramBoolean, paramString1, "", paramPayInfo, paramString2, paramIntent, paramInt);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, Intent paramIntent, int paramInt)
  {
    if ((2 == paramPayInfo.bUV) || (1 == paramPayInfo.bUV) || (4 == paramPayInfo.bUV) || (36 == paramPayInfo.bUV))
    {
      paramPayInfo.kPR = false;
      if ((paramPayInfo.bUV != 4) && (paramPayInfo.bUV != 1) && (36 != paramPayInfo.bUV) && (8 != paramPayInfo.bUV)) {
        break label173;
      }
    }
    label173:
    for (paramPayInfo.snV = true;; paramPayInfo.snV = false)
    {
      paramIntent.putExtra("key_pay_info", paramPayInfo);
      paramIntent.putExtra("key_force_use_bind_serail", bk.pm(paramString1));
      paramIntent.putExtra("key_is_force_use_given_card", paramBoolean);
      if (!bk.bl(paramString2)) {
        paramIntent.putExtra("key_is_use_default_card", paramString2);
      }
      paramIntent.putExtra("key_receiver_true_name", paramString3);
      if (!q.Gw()) {
        break label182;
      }
      d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramIntent, paramInt);
      return true;
      paramPayInfo.kPR = true;
      break;
    }
    label182:
    d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramIntent, paramInt);
    return true;
  }
  
  public static boolean a(MMActivity paramMMActivity, g paramg, int paramInt, MMActivity.a parama)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramg.appId);
    localIntent.putExtra("timeStamp", paramg.timeStamp);
    localIntent.putExtra("nonceStr", paramg.nonceStr);
    localIntent.putExtra("packageExt", paramg.packageExt);
    localIntent.putExtra("signtype", paramg.signType);
    localIntent.putExtra("paySignature", paramg.bUT);
    localIntent.putExtra("cookie", paramg.dVt);
    localIntent.putExtra("url", paramg.url);
    localIntent.putExtra("bizUsername", paramg.bUU);
    localIntent.putExtra("pay_channel", paramg.bIO);
    localIntent.putExtra("pay_for_wallet_type", paramg.soj);
    localIntent.putExtra("pay_scene", paramg.bUV);
    localIntent.putExtra("result_jump_mode", paramg.sol);
    localIntent.putExtra("ext_info", paramg.extInfo);
    localIntent.putExtra("key_wx_app_scene", paramg.soi);
    if (parama != null) {
      paramMMActivity.gJb = parama;
    }
    d.a(paramMMActivity, "wallet_index", ".ui.WalletBrandUI", localIntent, paramInt, false);
    return true;
  }
  
  public static boolean b(MMActivity paramMMActivity, g paramg, int paramInt, MMActivity.a parama)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramg.appId);
    localIntent.putExtra("timeStamp", paramg.timeStamp);
    localIntent.putExtra("nonceStr", paramg.nonceStr);
    localIntent.putExtra("packageExt", paramg.packageExt);
    localIntent.putExtra("signtype", paramg.signType);
    localIntent.putExtra("paySignature", paramg.bUT);
    localIntent.putExtra("url", paramg.url);
    localIntent.putExtra("key_bind_scene", paramg.bUW);
    localIntent.putExtra("pay_channel", paramg.bIO);
    paramMMActivity.gJb = parama;
    d.a(paramMMActivity, "wallet", ".bind.ui.WalletBindUI", localIntent, paramInt, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.h
 * JD-Core Version:    0.7.0.1
 */