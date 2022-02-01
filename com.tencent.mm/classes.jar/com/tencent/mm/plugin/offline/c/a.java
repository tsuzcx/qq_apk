package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.offline.a.s.h;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.FinderInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static Comparator<a> GGA;
  private static String GGn;
  public static String GGo;
  public static int GGp;
  public static String GGq;
  public static String GGr;
  public static String GGs;
  public static int GGt;
  public static int GGu;
  public static long GGv;
  public static boolean GGw;
  public static String GGx;
  public static String GGy;
  private static Comparator<Bankcard> GGz;
  public static String tmG;
  
  static
  {
    AppMethodBeat.i(66629);
    GGn = "";
    GGo = "";
    GGp = 1;
    GGq = "";
    GGr = "";
    GGs = "";
    GGt = 1;
    GGu = 0;
    GGv = 0L;
    GGw = false;
    tmG = "";
    GGx = "";
    GGy = "";
    GGz = new Comparator() {};
    GGA = new Comparator() {};
    AppMethodBeat.o(66629);
  }
  
  public static void B(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(66597);
    GGn = paramString1;
    GGo = paramString2;
    GGq = paramString3;
    GGr = paramString4;
    aTH(GGq);
    com.tencent.mm.kernel.h.aHF().kcd.a(new bv(new bv.a()
    {
      public final void a(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(66554);
        if ((paramAnonymousg == null) || (paramAnonymousg.biw() == null))
        {
          AppMethodBeat.o(66554);
          return;
        }
        if (a.GGn != null) {
          paramAnonymousg.biw().i("offline_token", a.GGn.getBytes());
        }
        if (a.GGo != null) {
          paramAnonymousg.biw().i("offline_token_V2", a.GGo.getBytes());
        }
        if (a.GGr != null) {
          paramAnonymousg.biw().i("offline_key_list", a.GGr.getBytes());
        }
        AppMethodBeat.o(66554);
      }
    }), 0);
    AppMethodBeat.o(66597);
  }
  
  private static LinkedList<a> C(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(66603);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(66603);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (localJSONObject != null)
      {
        a locala = new a();
        locala.GGB = localJSONObject.optInt("card_id");
        locala.fvP = localJSONObject.optString("bank_type");
        locala.GGC = localJSONObject.optString("bind_serial");
        locala.GGD = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(66603);
    return localLinkedList;
  }
  
  private static LinkedList<b> D(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(66612);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(66612);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (localJSONObject != null)
      {
        b localb = new b();
        localb.fvP = localJSONObject.optString("bank_type");
        localb.ufC = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(66612);
    return localLinkedList;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66585);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.fOZ = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!u.gJo().gJQ())
    {
      if (u.gJo().gJS())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
      if (u.gJo().gJR())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.c.class, localBundle);
    AppMethodBeat.o(66585);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(66586);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.fOZ = 5;
    paramBundle.putParcelable("key_pay_info", localPayInfo);
    paramBundle.putBoolean("key_need_bind_response", true);
    paramBundle.putInt("key_bind_scene", 5);
    paramBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      paramBundle.putInt("key_entry_scene", paramInt2);
    }
    if (paramBundle != null)
    {
      ab.ny(6, paramBundle.getInt("key_bind_scene"));
      z.azF(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramActivity, paramBundle);
      AppMethodBeat.o(66586);
      return;
      ab.ny(6, 0);
      z.azF(0);
    }
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    AppMethodBeat.i(66579);
    Log.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.GDw == null))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(66579);
      return;
    }
    if (!flO())
    {
      AppMethodBeat.o(66579);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.GDw);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.gaT != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.a(paramf.gaT.gat, paramf.gaT.gau, paramf.gaT.gav, paramf.gaT.gaw, paramf.gaT.gax, 8);
      localBundle.putParcelable("key_realname_guide_helper", localRealnameGuideHelper);
    }
    if ((paramActivity instanceof WalletOfflineCoinPurseUI))
    {
      paramf = paramActivity.getIntent();
      localBundle.putString("key_appid", paramf.getStringExtra("key_appid"));
      localBundle.putInt("key_from_scene", paramf.getIntExtra("key_from_scene", 0));
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, j.class, localBundle);
    AppMethodBeat.o(66579);
  }
  
  public static void a(Activity paramActivity, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(66583);
    Log.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "transid == null");
      AppMethodBeat.o(66583);
      return;
    }
    if (!flO())
    {
      AppMethodBeat.o(66583);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramq instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramq = ((com.tencent.mm.plugin.offline.a.e)paramq).GCy;
      if (paramq != null) {
        localBundle.putParcelable("key_realname_guide_helper", paramq);
      }
    }
    localBundle.putString("key_trans_id", paramString);
    localBundle.putInt("key_pay_type", 2);
    if ((paramActivity instanceof WalletOfflineCoinPurseUI))
    {
      paramString = paramActivity.getIntent();
      localBundle.putString("key_appid", paramString.getStringExtra("key_appid"));
      localBundle.putInt("key_from_scene", paramString.getIntExtra("key_from_scene", 0));
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, j.class, localBundle);
    AppMethodBeat.o(66583);
  }
  
  private static void a(Orders paramOrders, Map<String, String> paramMap)
  {
    AppMethodBeat.i(66582);
    if (paramMap != null)
    {
      paramOrders.ORp = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.ORr = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.CIl = ((String)paramMap.get(str + "name_color"));
          localShowInfo.OSB = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.OSC = Util.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.OSD = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.OSE = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.OSF = ((String)paramMap.get(str + "link_url"));
          localShowInfo.OSG = Util.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!Util.isNullOrNil(localShowInfo.name)) || (!Util.isNullOrNil(localShowInfo.value))) {
            paramOrders.ORr.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(66582);
  }
  
  public static void aE(Activity paramActivity)
  {
    AppMethodBeat.i(66589);
    b(paramActivity, "freeze", paramActivity.getString(a.i.wallet_wx_offline_freeze_content), 0, -1);
    AppMethodBeat.o(66589);
  }
  
  public static void aF(Activity paramActivity)
  {
    AppMethodBeat.i(66590);
    l(paramActivity, -1);
    AppMethodBeat.o(66590);
  }
  
  public static void aG(Activity paramActivity)
  {
    AppMethodBeat.i(66607);
    com.tencent.mm.ui.base.h.cO(paramActivity, paramActivity.getResources().getString(a.i.wallet_wx_offline_create_success));
    if (!TextUtils.isEmpty(fmg())) {
      com.tencent.mm.wallet_core.ui.g.bA(paramActivity, fmg());
    }
    AppMethodBeat.o(66607);
  }
  
  public static void aTF(String paramString)
  {
    AppMethodBeat.i(66572);
    k.fkT();
    k.bL(196631, paramString);
    AppMethodBeat.o(66572);
  }
  
  public static void aTG(String paramString)
  {
    AppMethodBeat.i(66577);
    u.gJo();
    com.tencent.mm.plugin.wallet_core.model.ao.bgZ(paramString);
    AppMethodBeat.o(66577);
  }
  
  public static void aTH(String paramString)
  {
    AppMethodBeat.i(66600);
    k.fkT();
    k.bL(196656, paramString);
    GGq = paramString;
    AppMethodBeat.o(66600);
  }
  
  public static LinkedList<a> aTI(String paramString)
  {
    AppMethodBeat.i(66602);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66602);
      return null;
    }
    try
    {
      paramString = C(new JSONArray(paramString));
      AppMethodBeat.o(66602);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66602);
    }
    return null;
  }
  
  public static void aTJ(String paramString)
  {
    AppMethodBeat.i(66606);
    k.fkT();
    k.bL(196616, paramString);
    AppMethodBeat.o(66606);
  }
  
  public static void aTK(String paramString)
  {
    AppMethodBeat.i(66610);
    k.fkT();
    k.bL(196615, paramString);
    GGs = paramString;
    AppMethodBeat.o(66610);
  }
  
  private static LinkedList<b> aTL(String paramString)
  {
    AppMethodBeat.i(66611);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66611);
      return null;
    }
    try
    {
      paramString = D(new JSONArray(paramString));
      AppMethodBeat.o(66611);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66611);
    }
    return null;
  }
  
  public static String aTM(String paramString)
  {
    AppMethodBeat.i(66615);
    LinkedList localLinkedList = aTL(fmi());
    if (localLinkedList == null)
    {
      AppMethodBeat.o(66615);
      return "";
    }
    int i = 0;
    b localb;
    if (i < localLinkedList.size())
    {
      localb = (b)localLinkedList.get(i);
      if ((localb == null) || (!paramString.equals(localb.fvP))) {}
    }
    for (paramString = localb.ufC;; paramString = "")
    {
      AppMethodBeat.o(66615);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String aTN(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(66616);
    Object localObject = aTI(fme());
    LinkedList localLinkedList = aTL(fmi());
    if ((localObject == null) || (localLinkedList == null) || (((LinkedList)localObject).size() == 0) || (localLinkedList.size() == 0))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
      AppMethodBeat.o(66616);
      return "";
    }
    int i = 0;
    a locala;
    if (i < ((LinkedList)localObject).size())
    {
      locala = (a)((LinkedList)localObject).get(i);
      if ((locala == null) || (!paramString.equals(locala.GGC))) {}
    }
    for (paramString = locala.fvP;; paramString = "")
    {
      if (TextUtils.isEmpty(paramString))
      {
        Log.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
        AppMethodBeat.o(66616);
        return "";
        i += 1;
        break;
      }
      i = j;
      if (i < localLinkedList.size())
      {
        localObject = (b)localLinkedList.get(i);
        if ((localObject == null) || (!paramString.equals(((b)localObject).fvP))) {}
      }
      for (paramString = ((b)localObject).ufC;; paramString = "")
      {
        AppMethodBeat.o(66616);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void aTO(String paramString)
  {
    AppMethodBeat.i(66618);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqo, paramString);
    AppMethodBeat.o(66618);
  }
  
  public static void aTP(String paramString)
  {
    AppMethodBeat.i(66620);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vry, paramString);
    AppMethodBeat.o(66620);
  }
  
  public static void aTQ(String paramString)
  {
    AppMethodBeat.i(66624);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrA, paramString);
    AppMethodBeat.o(66624);
  }
  
  public static void aTR(String paramString)
  {
    AppMethodBeat.i(66628);
    Log.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.h.o(paramString, true, false);
    if (paramString == null)
    {
      Log.w("MicroMsg.WalletOfflineUtil", "can not find app info");
      AppMethodBeat.o(66628);
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = new JumpToOfflinePay.Resp();
    ((JumpToOfflinePay.Resp)localObject).errCode = 0;
    ((JumpToOfflinePay.Resp)localObject).toBundle(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramString.field_packageName;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    com.tencent.mm.pluginsdk.model.app.q.bm(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bn(localBundle);
    MMessageActV2.send(MMApplicationContext.getContext(), (MMessageActV2.Args)localObject);
    AppMethodBeat.o(66628);
  }
  
  public static void aaQ(int paramInt)
  {
    AppMethodBeat.i(66594);
    k.fkT();
    k.bL(196644, String.valueOf(paramInt));
    AppMethodBeat.o(66594);
  }
  
  public static void aaR(int paramInt)
  {
    AppMethodBeat.i(66622);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrz, Integer.valueOf(i));
    AppMethodBeat.o(66622);
  }
  
  public static void aaS(int paramInt)
  {
    AppMethodBeat.i(182496);
    if (paramInt > 0)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqq, Integer.valueOf(paramInt));
      k.GCh = paramInt;
      Log.i("MicroMsg.WalletOfflineUtil", "set token num: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(182496);
  }
  
  public static Orders at(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66580);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.GHl = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.GHm = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.GHn = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.GHo = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.fww = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.tVK = (Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.GHs = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.GHt = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.GHx = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.GHD = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.GHv = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.GHz = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.fvb = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.GHd = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.ORE = (Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).fvb = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.ORC;
    localCommodity.ORF = ((Orders.Promotions)localObject1).fvb;
    ((Orders.Promotions)localObject1).GUf = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.OQT = j;
    localCommodity.ORI = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.ORJ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.ORK = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!Util.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.ORP = true;
      localCommodity.ORO.add(localObject1);
    }
    int i = 0;
    Orders.Promotions localPromotions;
    String str1;
    Object localObject2;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    String str11;
    String str12;
    String str13;
    String str14;
    String str15;
    String str16;
    if (i < 255)
    {
      localPromotions = new Orders.Promotions();
      if (i == 0)
      {
        localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.icon");
        str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.wording");
        localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.url");
        str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.btn_text");
        str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.type");
        str4 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.title");
        str5 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_type");
        str6 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_id");
        str7 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.send_record_id");
        str8 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.award_id");
        str9 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.user_record_id");
        str10 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.small_title");
        str11 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_username");
        str12 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_path");
        str13 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_mch_id");
        str14 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_version");
        str15 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.get_award_params");
        str16 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record.query_award_status_params");
        label791:
        if (!Util.isNullOrNil(str1)) {
          break label2647;
        }
        Log.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.ORQ.text = ((String)localObject1);
      localCommodity.ORQ.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)) && (!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(str2)))
      {
        localCommodity.ORL = new Orders.RecommendTinyAppInfo();
        localCommodity.ORL.ODu = ((String)localObject1);
        localCommodity.ORL.OQH = str1;
        localCommodity.ORL.OQI = ((String)localObject2);
        localCommodity.ORL.Ooe = str2;
        localCommodity.ORL.Oof = str3;
        localCommodity.ORL.OQJ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.ORL.OSt = Util.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.ORL.OSu = Util.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.ORL.OSw = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.ORL.OSx = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.ORL.OSy = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.ORL.OSv = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.ORL.OQK = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localCommodity.ORM = new Orders.FinderInfo();
      i = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.type"), 0);
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.url");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.tiny_app_uri.username");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.tiny_app_uri.path");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.tiny_app_uri.version");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.logo.url");
      str4 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.logo.dark_mode_url");
      str5 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.sub_logo.url");
      str6 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.sub_logo.dark_mode_url");
      str7 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.title");
      str8 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.desc");
      int k = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.type"), -1);
      str9 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.username");
      str10 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.feedid");
      str11 = (String)paramMap.get(".sysmsg.paymsg.user_roll.finder_info_view.route_info.finder_uri.nonceid");
      Log.i("MicroMsg.WalletOfflineUtil", "finder jump type：%s", new Object[] { Integer.valueOf(i) });
      Log.i("MicroMsg.WalletOfflineUtil", "finder h5 url：%s", new Object[] { localObject1 });
      Log.i("MicroMsg.WalletOfflineUtil", "finder tinyapp username：%s ，path：%s，version：%s", new Object[] { str1, localObject2, str2 });
      Log.i("MicroMsg.WalletOfflineUtil", "finder finder_logo_normal：%s，finder_title：%s，finder_desc:%s，finder_uri_type：%s，finder_uri_username：%s，finder_uri_feedid：%s,finder_uri_nonceid：%s", new Object[] { str3, str7, str8, Integer.valueOf(k), str9, str10, str11 });
      localCommodity.ORM.type = i;
      localCommodity.ORM.url = ((String)localObject1);
      localCommodity.ORM.username = str1;
      localCommodity.ORM.path = ((String)localObject2);
      localCommodity.ORM.version = str2;
      localCommodity.ORM.OSa = str3;
      localCommodity.ORM.OSb = str4;
      localCommodity.ORM.OSc = str5;
      localCommodity.ORM.OSd = str6;
      localCommodity.ORM.OSe = str7;
      localCommodity.ORM.OSf = str8;
      localCommodity.ORM.OSg = k;
      localCommodity.ORM.OSh = str9;
      localCommodity.ORM.OSi = str10;
      localCommodity.ORM.OSj = str11;
      localOrders.ORd = new ArrayList();
      localOrders.ORd.add(localCommodity);
      localOrders.ORn = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.ORo = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.OQV = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.OQT = j;
      localOrders.fwv = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.ORE = (Util.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
      if (TextUtils.isEmpty((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
        break label2911;
      }
      i = 0;
      label1873:
      if (i != 0) {
        break label2852;
      }
    }
    label2852:
    for (localObject1 = "";; localObject1 = String.valueOf(i))
    {
      str1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".favor_desc";
      localObject1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".payment_amount";
      if ((TextUtils.isEmpty((CharSequence)paramMap.get(str1))) || (TextUtils.isEmpty((CharSequence)paramMap.get(localObject1)))) {
        break label2861;
      }
      localObject2 = new Orders.DiscountInfo();
      ((Orders.DiscountInfo)localObject2).Ila = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).ORZ = Util.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.ORH.add(localObject2);
      i += 1;
      break label1873;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".icon");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".wording");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".url");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".btn_text");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".type");
      str4 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".title");
      str5 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".activity_type");
      str6 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".activity_id");
      str7 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".send_record_id");
      str8 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".award_id");
      str9 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".user_record_id");
      str10 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".small_title");
      str11 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".activity_tinyapp_username");
      str12 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".activity_tinyapp_path");
      str13 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".activity_mch_id");
      str14 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".activity_tinyapp_version");
      str15 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".get_award_params");
      str16 = (String)paramMap.get(".sysmsg.paymsg.user_roll.activity_info.record" + i + ".query_award_status_params");
      break label791;
      label2647:
      localPromotions.GUf = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.OQF = str2;
      localPromotions.type = Orders.ORD;
      localPromotions.wYj = Util.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.SuA = Util.getInt(str5, 0);
      localPromotions.cpu = Util.getLong(str6, 0L);
      localPromotions.OQC = Util.getInt(str7, 0);
      localPromotions.SuB = Util.getInt(str8, 0);
      localPromotions.OQD = Util.getInt(str9, 0);
      localPromotions.SuC = str10;
      localPromotions.SuD = str11;
      localPromotions.SuE = str12;
      localPromotions.OQE = Util.getLong(str13, 0L);
      localPromotions.SuF = Util.getInt(str14, 0);
      localPromotions.SuG = str15;
      localPromotions.SuI = str16;
      localObject1 = e(paramMap, i);
      if (localObject1 != null) {
        localPromotions.OSs = ((e.a.a.c)localObject1);
      }
      localCommodity.ORO.add(localPromotions);
      i += 1;
      break;
    }
    label2861:
    Log.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    for (;;)
    {
      AppMethodBeat.o(66580);
      return localOrders;
      label2911:
      Log.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    }
  }
  
  private static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66588);
    Bundle localBundle = new Bundle();
    localBundle.putString("oper", paramString1);
    localBundle.putInt("offline_chg_fee", paramInt1);
    localBundle.putString("pwd_tips", paramString2);
    if (paramInt2 >= 0) {
      localBundle.putInt("offline_from_scene", paramInt2);
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.h.class, localBundle);
    AppMethodBeat.o(66588);
  }
  
  private static e.a.a.c e(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(66581);
    e.a.a.c localc;
    if (paramInt == 0)
    {
      str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
      if (paramMap == null) {
        break label2417;
      }
      localc = new e.a.a.c();
      localc.abEw = Util.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.Std = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.SvL = Util.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localc.SvJ = Util.nullAsNil((String)paramMap.get(str + "exposure_info_modify_params"));
      localObject1 = new e.a.a.a();
      localObject2 = str + "btn_info.";
      ((e.a.a.a)localObject1).abEo = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((e.a.a.a)localObject1).abEp = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((e.a.a.a)localObject1).abEq = Util.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((e.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((e.a.a.a)localObject1).Thl = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((e.a.a.a)localObject1).abEr = new e.a.a.g();
      ((e.a.a.a)localObject1).abEr.TQP = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((e.a.a.a)localObject1).abEr.TQQ = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((e.a.a.a)localObject1).abEr.TQR = Util.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!Util.isNullOrNil(((e.a.a.a)localObject1).abEo)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).url)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).Thl)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).abEr.TQP)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).abEr.TQQ))) {
        localc.SvM = ((e.a.a.a)localObject1);
      }
      localc.abEx = Util.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.abEy = Util.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.abEA = ((String)paramMap.get(str + "background_img_whole"));
      localc.SvK = new LinkedList();
      paramInt = 0;
      label713:
      if (paramInt >= 255) {
        break label1125;
      }
      if (paramInt != 0) {
        break label1091;
      }
    }
    label1091:
    for (Object localObject1 = str + "single_exposure_info_list.record.";; localObject1 = str + "single_exposure_info_list.record" + paramInt + ".")
    {
      localObject2 = new e.a.a.i();
      ((e.a.a.i)localObject2).GUf = ((String)paramMap.get((String)localObject1 + "logo"));
      ((e.a.a.i)localObject2).abEZ = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((e.a.a.i)localObject2).abFa = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((e.a.a.i)localObject2).abFb = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((e.a.a.i)localObject2).abFc = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((e.a.a.i)localObject2).abFd = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!Util.isNullOrNil(((e.a.a.i)localObject2).GUf)) || (!Util.isNullOrNil(((e.a.a.i)localObject2).abEZ)) || (!Util.isNullOrNil(((e.a.a.i)localObject2).abFa)) || (!Util.isNullOrNil(((e.a.a.i)localObject2).abFb)) || (!Util.isNullOrNil(((e.a.a.i)localObject2).abFc)) || (!Util.isNullOrNil(((e.a.a.i)localObject2).abFd))) {
        localc.SvK.add(localObject2);
      }
      if ((Util.isNullOrNil(((e.a.a.i)localObject2).abEZ)) || (Util.isNullOrNil(((e.a.a.i)localObject2).abFa))) {
        break label1125;
      }
      paramInt += 1;
      break label713;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1125:
    localc.abEz = new e.a.a.f();
    localObject1 = str + "layer_info.";
    localc.abEz.abEN = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.abEz.abEO = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.abEz.abEP = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.abEz.abEQ = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.abEz.abER = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.abEz.abES = Util.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.abEz.abET = new e.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.abEz.abET.abEo = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.abEz.abET.abEp = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.abEz.abET.abEq = Util.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.abEz.abET.Thl = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.abEz.abET.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.abEz.abET.abEr = new e.a.a.g();
    localc.abEz.abET.abEr.TQP = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.abEz.abET.abEr.TQQ = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.abEz.abET.abEr.TQR = Util.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!Util.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.abEz.abEU = new com.tencent.mm.cd.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!Util.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.abEz.Scj = new com.tencent.mm.cd.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new e.a.a.b();
    String str = str + "draw_lottery_info.";
    ((e.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((e.a.a.b)localObject1).abEs = ((String)paramMap.get(str + "animation_wording"));
    ((e.a.a.b)localObject1).abEt = ((String)paramMap.get(str + "animation_wording_color"));
    ((e.a.a.b)localObject1).SLl = Util.getInt((String)paramMap.get(str + "op_type"), 0);
    ((e.a.a.b)localObject1).abEu = ((String)paramMap.get(str + "after_animation_wording"));
    ((e.a.a.b)localObject1).abEv = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((e.a.a.b)localObject1).abEr = new e.a.a.g();
    ((e.a.a.b)localObject1).abEr.TQP = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((e.a.a.b)localObject1).abEr.TQQ = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((e.a.a.b)localObject1).abEr.TQR = Util.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!Util.isNullOrNil(((e.a.a.b)localObject1).url)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).abEs)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).abEt)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).abEr.TQP)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).abEr.TQQ))) {
      localc.abEB = ((e.a.a.b)localObject1);
    }
    AppMethodBeat.o(66581);
    return localc;
    label2417:
    AppMethodBeat.o(66581);
    return null;
  }
  
  public static boolean flN()
  {
    AppMethodBeat.i(66558);
    k.fkT();
    String str = k.aaK(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66558);
      return true;
    }
    AppMethodBeat.o(66558);
    return false;
  }
  
  public static boolean flO()
  {
    AppMethodBeat.i(66559);
    k.fkT();
    String str = k.aaK(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66559);
      return true;
    }
    AppMethodBeat.o(66559);
    return false;
  }
  
  @Deprecated
  public static Bankcard flP()
  {
    AppMethodBeat.i(66560);
    Bankcard localBankcard = ag.Cd(true);
    AppMethodBeat.o(66560);
    return localBankcard;
  }
  
  @Deprecated
  public static Bankcard flQ()
  {
    AppMethodBeat.i(262740);
    Bankcard localBankcard = ag.Cd(false);
    AppMethodBeat.o(262740);
    return localBankcard;
  }
  
  public static Bankcard flR()
  {
    AppMethodBeat.i(66561);
    Bankcard localBankcard = vP(true);
    AppMethodBeat.o(66561);
    return localBankcard;
  }
  
  public static Bankcard flS()
  {
    AppMethodBeat.i(66562);
    u.gJo();
    Bankcard localBankcard = com.tencent.mm.plugin.wallet_core.model.ao.gKC();
    AppMethodBeat.o(66562);
    return localBankcard;
  }
  
  public static int flT()
  {
    AppMethodBeat.i(66563);
    int i = u.gJo().Ce(true).size();
    AppMethodBeat.o(66563);
    return i;
  }
  
  public static List<Bankcard> flU()
  {
    AppMethodBeat.i(66565);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = u.gJo().gKo();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localArrayList1.add((Bankcard)localArrayList2.get(i));
      i += 1;
    }
    Log.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66565);
    return localArrayList1;
  }
  
  public static int flV()
  {
    AppMethodBeat.i(66566);
    k.fkT();
    String str = k.aaK(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66566);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66566);
    return i;
  }
  
  private static int flW()
  {
    int j = 0;
    AppMethodBeat.i(66567);
    k.fkT();
    String str = k.aaK(196640);
    int i = j;
    if (!TextUtils.isEmpty(str))
    {
      if (!isNumeric(str)) {
        i = j;
      }
    }
    else
    {
      if (i <= 0) {
        break label63;
      }
      i *= 100;
    }
    for (;;)
    {
      AppMethodBeat.o(66567);
      return i;
      i = Util.getInt(str, 0);
      break;
      label63:
      i = 20000;
    }
  }
  
  public static String flX()
  {
    AppMethodBeat.i(66570);
    k.fkT();
    String str = k.aaK(196632);
    AppMethodBeat.o(66570);
    return str;
  }
  
  public static String flY()
  {
    AppMethodBeat.i(66571);
    k.fkT();
    String str = k.aaK(196631);
    AppMethodBeat.o(66571);
    return str;
  }
  
  public static String flZ()
  {
    AppMethodBeat.i(66576);
    u.gJo();
    String str = com.tencent.mm.plugin.wallet_core.model.ao.gKw();
    AppMethodBeat.o(66576);
    return str;
  }
  
  public static void fma()
  {
    AppMethodBeat.i(66578);
    Log.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.fkT();
    k.bL(196630, "0");
    k.fkT();
    k.bL(196626, "");
    k.fkT();
    k.bL(196627, "");
    k.fkT();
    k.bL(196628, "");
    k.fkT();
    k.bL(196617, "");
    k.fkT();
    k.bL(196632, "");
    k.fkT();
    k.bL(196641, "");
    k.fkT();
    k.bL(196647, "");
    k.fkT();
    k.bL(196649, "");
    B("", "", "", "");
    aaS(0);
    k.fkT();
    k.bL(196629, "0");
    aTF("");
    k.fkT();
    k.fkU().GDh = null;
    k.fkT();
    k.fkW();
    com.tencent.mm.plugin.offline.i.fkR();
    aTK("");
    aTH("");
    AppMethodBeat.o(66578);
  }
  
  public static void fmb()
  {
    AppMethodBeat.i(66593);
    k.fkT();
    k.bL(196643, "1");
    AppMethodBeat.o(66593);
  }
  
  public static int fmc()
  {
    AppMethodBeat.i(66595);
    k.fkT();
    String str = k.aaK(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66595);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66595);
    return i;
  }
  
  public static String fmd()
  {
    AppMethodBeat.i(66598);
    if (!TextUtils.isEmpty(GGo))
    {
      str = GGo;
      AppMethodBeat.o(66598);
      return str;
    }
    fmf();
    if (TextUtils.isEmpty(GGo)) {
      Log.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = GGo;
    AppMethodBeat.o(66598);
    return str;
  }
  
  public static String fme()
  {
    AppMethodBeat.i(66599);
    if (!TextUtils.isEmpty(GGq))
    {
      str = GGq;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(GGq))
    {
      k.fkT();
      str = k.aaK(196656);
      GGq = str;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(GGq)) {
      Log.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = GGq;
    AppMethodBeat.o(66599);
    return str;
  }
  
  private static void fmf()
  {
    AppMethodBeat.i(66601);
    com.tencent.mm.kernel.h.aHF().kcd.a(new bv(new bv.a()
    {
      public final void a(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(66555);
        if ((paramAnonymousg == null) || (paramAnonymousg.biw() == null))
        {
          Log.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
          AppMethodBeat.o(66555);
          return;
        }
        byte[] arrayOfByte = paramAnonymousg.biw().TX("offline_token");
        if (arrayOfByte != null) {
          a.gE(new String(arrayOfByte));
        }
        arrayOfByte = paramAnonymousg.biw().TX("offline_token_V2");
        if (arrayOfByte != null) {
          a.GGo = new String(arrayOfByte);
        }
        paramAnonymousg = paramAnonymousg.biw().TX("offline_key_list");
        if (paramAnonymousg != null) {
          a.GGr = new String(paramAnonymousg);
        }
        AppMethodBeat.o(66555);
      }
    }), 0);
    AppMethodBeat.o(66601);
  }
  
  private static String fmg()
  {
    AppMethodBeat.i(66605);
    k.fkT();
    String str = k.aaK(196616);
    AppMethodBeat.o(66605);
    return str;
  }
  
  public static boolean fmh()
  {
    int j = 0;
    AppMethodBeat.i(66608);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVT, 0) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.WalletOfflineUtil", "pass same md5 case");
      AppMethodBeat.o(66608);
      return true;
    }
    ArrayList localArrayList = u.gJo().Ce(true);
    Object localObject = aTI(fme());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size()))
    {
      AppMethodBeat.o(66608);
      return false;
    }
    Collections.sort((List)localObject, GGA);
    Collections.sort(localArrayList, GGz);
    StringBuilder localStringBuilder = new StringBuilder();
    i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a)((LinkedList)localObject).get(i)).GGC);
      i += 1;
    }
    localObject = new StringBuilder();
    i = j;
    while (i < localArrayList.size())
    {
      ((StringBuilder)localObject).append(((Bankcard)localArrayList.get(i)).field_bindSerial);
      i += 1;
    }
    boolean bool = MD5Util.getMD5String(localStringBuilder.toString()).equals(MD5Util.getMD5String(((StringBuilder)localObject).toString()));
    AppMethodBeat.o(66608);
    return bool;
  }
  
  private static String fmi()
  {
    AppMethodBeat.i(66609);
    if (TextUtils.isEmpty(GGs))
    {
      k.fkT();
      str = k.aaK(196615);
      GGs = str;
      AppMethodBeat.o(66609);
      return str;
    }
    String str = GGs;
    AppMethodBeat.o(66609);
    return str;
  }
  
  public static int fmj()
  {
    AppMethodBeat.i(66613);
    k.fkT();
    String str = k.aaK(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66613);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66613);
    return i;
  }
  
  public static boolean fmk()
  {
    AppMethodBeat.i(66614);
    String str = flX();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(66614);
      return false;
    }
    long l1 = fmj();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(66614);
      return true;
    }
    AppMethodBeat.o(66614);
    return false;
  }
  
  public static String fml()
  {
    AppMethodBeat.i(66619);
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqo, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66619);
      return localObject;
    }
    AppMethodBeat.o(66619);
    return null;
  }
  
  public static String fmm()
  {
    AppMethodBeat.i(66621);
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vry, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66621);
      return localObject;
    }
    AppMethodBeat.o(66621);
    return null;
  }
  
  public static int fmn()
  {
    AppMethodBeat.i(66623);
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrz, null);
    if (localObject != null) {}
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      AppMethodBeat.o(66623);
      return j;
    }
  }
  
  public static String fmo()
  {
    AppMethodBeat.i(66625);
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrA, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66625);
      return localObject;
    }
    AppMethodBeat.o(66625);
    return null;
  }
  
  public static boolean fmp()
  {
    AppMethodBeat.i(66627);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.d.bgB().Mu("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).hvz();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        Log.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.d.bgB().Mu("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).hvz();
      bool1 = bool2;
      if (((Map)localObject).containsKey("open"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("open"))) {
          bool1 = true;
        }
      }
    }
    Log.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(66627);
    return bool1;
  }
  
  public static int fmq()
  {
    return k.GCh;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(66626);
    int i;
    if (NetStatusUtil.isConnected(paramContext)) {
      if (NetStatusUtil.isWifi(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66626);
      return i;
      if (NetStatusUtil.is2G(paramContext))
      {
        i = 2;
      }
      else if (NetStatusUtil.is3G(paramContext))
      {
        i = 3;
      }
      else if (NetStatusUtil.is4G(paramContext))
      {
        i = 4;
      }
      else
      {
        i = 0;
        continue;
        i = -1;
      }
    }
  }
  
  public static String getToken()
  {
    AppMethodBeat.i(66596);
    if (!TextUtils.isEmpty(GGn))
    {
      str = GGn;
      AppMethodBeat.o(66596);
      return str;
    }
    fmf();
    if (TextUtils.isEmpty(GGn)) {
      Log.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = GGn;
    AppMethodBeat.o(66596);
    return str;
  }
  
  public static String getTokenPin()
  {
    AppMethodBeat.i(66604);
    k.fkT();
    String str = k.aaK(196647);
    AppMethodBeat.o(66604);
    return str;
  }
  
  public static void hK(Context paramContext)
  {
    AppMethodBeat.i(66573);
    String str = LocaleUtil.getApplicationLanguage();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(a.i.url_wallet_offline_user_guide_url);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.g.bA(paramContext, str);
      AppMethodBeat.o(66573);
      return;
      if ("zh_TW".equals(str)) {
        str = paramContext.getString(a.i.url_wallet_offline_user_guide_url_tw);
      } else if ("zh_HK".equals(str)) {
        str = paramContext.getString(a.i.url_wallet_offline_user_guide_url_hk);
      } else {
        str = paramContext.getResources().getString(a.i.url_wallet_offline_user_guide_url_en);
      }
    }
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    AppMethodBeat.i(66617);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      Log.d("MicroMsg.WalletOfflineUtil", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        Log.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
        AppMethodBeat.o(66617);
        return false;
      }
    }
    if (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(66617);
      return false;
    }
    Log.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
    AppMethodBeat.o(66617);
    return true;
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(66575);
    if (paramString == null)
    {
      AppMethodBeat.o(66575);
      return false;
    }
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(66575);
    return bool;
  }
  
  public static void j(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66584);
    a(paramActivity, paramInt, -1);
    AppMethodBeat.o(66584);
  }
  
  public static void j(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66592);
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(a.i.wallet_wx_offline_recreate_offline_text), paramActivity.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66552);
        a.fma();
        a.aF(this.val$activity);
        this.val$activity.finish();
        AppMethodBeat.o(66552);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66553);
        this.val$activity.finish();
        AppMethodBeat.o(66553);
      }
    });
    AppMethodBeat.o(66592);
  }
  
  public static void k(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66587);
    b(paramActivity, "create", paramActivity.getString(a.i.wallet_wx_offline_create_offline), 0, paramInt);
    AppMethodBeat.o(66587);
  }
  
  public static void l(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66591);
    b(paramActivity, "create", "", flW(), paramInt);
    AppMethodBeat.o(66591);
  }
  
  public static Bankcard vP(boolean paramBoolean)
  {
    AppMethodBeat.i(262745);
    Object localObject = ag.Cd(paramBoolean);
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (Util.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(262745);
      return localObject;
    }
    localObject = u.gJo().Ce(true);
    int i = 0;
    while (i < ((List)localObject).size())
    {
      Bankcard localBankcard = (Bankcard)((List)localObject).get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay))
      {
        AppMethodBeat.o(262745);
        return localBankcard;
      }
      i += 1;
    }
    AppMethodBeat.o(262745);
    return null;
  }
  
  public static List<Bankcard> vQ(boolean paramBoolean)
  {
    AppMethodBeat.i(66564);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = u.gJo().Cf(true);
    int i = 0;
    if ((localArrayList2 != null) && (i < localArrayList2.size()))
    {
      Bankcard localBankcard = (Bankcard)localArrayList2.get(i);
      if (paramBoolean) {
        localArrayList1.add(localBankcard);
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList1.add(localBankcard);
      }
    }
    Log.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66564);
    return localArrayList1;
  }
  
  public static final class a
  {
    public int GGB;
    public String GGC;
    public String GGD;
    public String fvP;
  }
  
  public static final class b
  {
    public String fvP;
    public String ufC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */