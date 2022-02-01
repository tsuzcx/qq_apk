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
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
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
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import e.a.a.i;
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
  private static String AMZ;
  public static String ANa;
  public static int ANb;
  public static String ANc;
  public static String ANd;
  public static String ANe;
  public static int ANf;
  public static int ANg;
  public static long ANh;
  public static boolean ANi;
  public static String ANj;
  public static String ANk;
  private static Comparator<Bankcard> ANl;
  private static Comparator<a> ANm;
  public static String pQH;
  
  static
  {
    AppMethodBeat.i(66629);
    AMZ = "";
    ANa = "";
    ANb = 1;
    ANc = "";
    ANd = "";
    ANe = "";
    ANf = 1;
    ANg = 0;
    ANh = 0L;
    ANi = false;
    pQH = "";
    ANj = "";
    ANk = "";
    ANl = new Comparator() {};
    ANm = new Comparator() {};
    AppMethodBeat.o(66629);
  }
  
  private static LinkedList<a> B(JSONArray paramJSONArray)
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
        locala.ANn = localJSONObject.optInt("card_id");
        locala.dDj = localJSONObject.optString("bank_type");
        locala.ANo = localJSONObject.optString("bind_serial");
        locala.ANp = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(66603);
    return localLinkedList;
  }
  
  private static LinkedList<b> C(JSONArray paramJSONArray)
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
        localb.dDj = localJSONObject.optString("bank_type");
        localb.qGB = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(66612);
    return localLinkedList;
  }
  
  public static void Ud(int paramInt)
  {
    AppMethodBeat.i(66568);
    k.ezn();
    k.bN(196640, String.valueOf(paramInt));
    AppMethodBeat.o(66568);
  }
  
  public static void Ue(int paramInt)
  {
    AppMethodBeat.i(66569);
    k.ezn();
    k.bN(196642, String.valueOf(paramInt));
    AppMethodBeat.o(66569);
  }
  
  public static void Uf(int paramInt)
  {
    AppMethodBeat.i(66594);
    k.ezn();
    k.bN(196644, String.valueOf(paramInt));
    AppMethodBeat.o(66594);
  }
  
  public static void Ug(int paramInt)
  {
    AppMethodBeat.i(66622);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Odp, Integer.valueOf(i));
    AppMethodBeat.o(66622);
  }
  
  public static void Uh(int paramInt)
  {
    AppMethodBeat.i(182496);
    if (paramInt > 0)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ocn, Integer.valueOf(paramInt));
      k.AIY = paramInt;
      Log.i("MicroMsg.WalletOfflineUtil", "set token num: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(182496);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66585);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dVw = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk())
    {
      if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRm())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
      if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRl())
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
    localPayInfo.dVw = 5;
    paramBundle.putParcelable("key_pay_info", localPayInfo);
    paramBundle.putBoolean("key_need_bind_response", true);
    paramBundle.putInt("key_bind_scene", 5);
    paramBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      paramBundle.putInt("key_entry_scene", paramInt2);
    }
    if (paramBundle != null)
    {
      ab.mg(6, paramBundle.getInt("key_bind_scene"));
      z.aqh(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramActivity, paramBundle);
      AppMethodBeat.o(66586);
      return;
      ab.mg(6, 0);
      z.aqh(0);
    }
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    AppMethodBeat.i(66579);
    Log.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.AKp == null))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(66579);
      return;
    }
    if (!eAk())
    {
      AppMethodBeat.o(66579);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.AKp);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.egD != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.b(paramf.egD.egd, paramf.egD.ege, paramf.egD.egf, paramf.egD.egg, paramf.egD.egh, 8);
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
  
  public static void a(Activity paramActivity, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(66583);
    Log.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "transid == null");
      AppMethodBeat.o(66583);
      return;
    }
    if (!eAk())
    {
      AppMethodBeat.o(66583);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramq instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramq = ((com.tencent.mm.plugin.offline.a.e)paramq).AJr;
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
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
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
  
  private static void a(Orders paramOrders, Map<String, String> paramMap)
  {
    AppMethodBeat.i(66582);
    if (paramMap != null)
    {
      paramOrders.HZp = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.HZr = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.xEk = ((String)paramMap.get(str + "name_color"));
          localShowInfo.Iaq = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.Iar = Util.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.Ias = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.Iat = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.Iau = ((String)paramMap.get(str + "link_url"));
          localShowInfo.Iav = Util.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!Util.isNullOrNil(localShowInfo.name)) || (!Util.isNullOrNil(localShowInfo.value))) {
            paramOrders.HZr.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(66582);
  }
  
  public static void aA(Activity paramActivity)
  {
    AppMethodBeat.i(66607);
    com.tencent.mm.ui.base.h.cD(paramActivity, paramActivity.getResources().getString(2131768415));
    if (!TextUtils.isEmpty(eAC())) {
      com.tencent.mm.wallet_core.ui.f.bn(paramActivity, eAC());
    }
    AppMethodBeat.o(66607);
  }
  
  public static void aJj(String paramString)
  {
    AppMethodBeat.i(66572);
    k.ezn();
    k.bN(196631, paramString);
    AppMethodBeat.o(66572);
  }
  
  public static void aJk(String paramString)
  {
    AppMethodBeat.i(66577);
    com.tencent.mm.plugin.wallet_core.model.t.fQI();
    an.aVq(paramString);
    AppMethodBeat.o(66577);
  }
  
  public static void aJl(String paramString)
  {
    AppMethodBeat.i(66600);
    k.ezn();
    k.bN(196656, paramString);
    ANc = paramString;
    AppMethodBeat.o(66600);
  }
  
  public static LinkedList<a> aJm(String paramString)
  {
    AppMethodBeat.i(66602);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66602);
      return null;
    }
    try
    {
      paramString = B(new JSONArray(paramString));
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
  
  public static void aJn(String paramString)
  {
    AppMethodBeat.i(66606);
    k.ezn();
    k.bN(196616, paramString);
    AppMethodBeat.o(66606);
  }
  
  public static void aJo(String paramString)
  {
    AppMethodBeat.i(66610);
    k.ezn();
    k.bN(196615, paramString);
    ANe = paramString;
    AppMethodBeat.o(66610);
  }
  
  private static LinkedList<b> aJp(String paramString)
  {
    AppMethodBeat.i(66611);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66611);
      return null;
    }
    try
    {
      paramString = C(new JSONArray(paramString));
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
  
  public static String aJq(String paramString)
  {
    AppMethodBeat.i(66615);
    LinkedList localLinkedList = aJp(eAE());
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
      if ((localb == null) || (!paramString.equals(localb.dDj))) {}
    }
    for (paramString = localb.qGB;; paramString = "")
    {
      AppMethodBeat.o(66615);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String aJr(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(66616);
    Object localObject = aJm(eAA());
    LinkedList localLinkedList = aJp(eAE());
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
      if ((locala == null) || (!paramString.equals(locala.ANo))) {}
    }
    for (paramString = locala.dDj;; paramString = "")
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
        if ((localObject == null) || (!paramString.equals(((b)localObject).dDj))) {}
      }
      for (paramString = ((b)localObject).qGB;; paramString = "")
      {
        AppMethodBeat.o(66616);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void aJs(String paramString)
  {
    AppMethodBeat.i(66618);
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ocl, paramString);
    AppMethodBeat.o(66618);
  }
  
  public static void aJt(String paramString)
  {
    AppMethodBeat.i(66620);
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Odo, paramString);
    AppMethodBeat.o(66620);
  }
  
  public static void aJu(String paramString)
  {
    AppMethodBeat.i(66624);
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Odq, paramString);
    AppMethodBeat.o(66624);
  }
  
  public static void aJv(String paramString)
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
    com.tencent.mm.pluginsdk.model.app.q.bo(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bp(localBundle);
    MMessageActV2.send(MMApplicationContext.getContext(), (MMessageActV2.Args)localObject);
    AppMethodBeat.o(66628);
  }
  
  public static void ay(Activity paramActivity)
  {
    AppMethodBeat.i(66589);
    a(paramActivity, "freeze", paramActivity.getString(2131768417), 0, -1);
    AppMethodBeat.o(66589);
  }
  
  public static Orders az(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66580);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.ANX = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.ANY = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.ANZ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.AOa = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.dDM = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.qwJ = (Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.AOe = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.AOf = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.AOj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.AOp = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.AOh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.AOl = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.dCu = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.ANP = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.HZE = (Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).dCu = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.HZC;
    localCommodity.HZF = ((Orders.Promotions)localObject1).dCu;
    ((Orders.Promotions)localObject1).Bah = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.HYT = j;
    localCommodity.HZI = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.HZJ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.HZK = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!Util.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.HZO = true;
      localCommodity.HZN.add(localObject1);
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
        label781:
        if (!Util.isNullOrNil(str1)) {
          break label2130;
        }
        Log.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.HZP.text = ((String)localObject1);
      localCommodity.HZP.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)) && (!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(str2)))
      {
        localCommodity.HZL = new Orders.RecommendTinyAppInfo();
        localCommodity.HZL.HLz = ((String)localObject1);
        localCommodity.HZL.HYH = str1;
        localCommodity.HZL.HYI = ((String)localObject2);
        localCommodity.HZL.Hwr = str2;
        localCommodity.HZL.Hws = str3;
        localCommodity.HZL.HYJ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.HZL.Iai = Util.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.HZL.Iaj = Util.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.HZL.Ial = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.HZL.Iam = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.HZL.Ian = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.HZL.Iak = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.HZL.HYK = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localOrders.HZd = new ArrayList();
      localOrders.HZd.add(localCommodity);
      localOrders.HZn = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.HZo = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.HYV = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.HYT = j;
      localOrders.dDL = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.HZE = (Util.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
      if (TextUtils.isEmpty((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
        break label2387;
      }
      i = 0;
      label1363:
      if (i != 0) {
        break label2331;
      }
    }
    label2331:
    for (localObject1 = "";; localObject1 = String.valueOf(i))
    {
      str1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".favor_desc";
      localObject1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".payment_amount";
      if ((TextUtils.isEmpty((CharSequence)paramMap.get(str1))) || (TextUtils.isEmpty((CharSequence)paramMap.get(localObject1)))) {
        break label2339;
      }
      localObject2 = new Orders.DiscountInfo();
      ((Orders.DiscountInfo)localObject2).Coh = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).HZY = Util.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.HZH.add(localObject2);
      i += 1;
      break label1363;
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
      break label781;
      label2130:
      localPromotions.Bah = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.HYF = str2;
      localPromotions.type = Orders.HZD;
      localPromotions.trD = Util.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.Utv = Util.getInt(str5, 0);
      localPromotions.crw = Util.getLong(str6, 0L);
      localPromotions.HYC = Util.getInt(str7, 0);
      localPromotions.Utw = Util.getInt(str8, 0);
      localPromotions.HYD = Util.getInt(str9, 0);
      localPromotions.Utx = str10;
      localPromotions.Uty = str11;
      localPromotions.Utz = str12;
      localPromotions.HYE = Util.getLong(str13, 0L);
      localPromotions.UtA = Util.getInt(str14, 0);
      localPromotions.UtB = str15;
      localPromotions.UtC = str16;
      localObject1 = f(paramMap, i);
      if (localObject1 != null) {
        localPromotions.Iah = ((e.a.a.c)localObject1);
      }
      localCommodity.HZN.add(localPromotions);
      i += 1;
      break;
    }
    label2339:
    Log.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    for (;;)
    {
      AppMethodBeat.o(66580);
      return localOrders;
      label2387:
      Log.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    }
  }
  
  public static void az(Activity paramActivity)
  {
    AppMethodBeat.i(66590);
    k(paramActivity, -1);
    AppMethodBeat.o(66590);
  }
  
  public static String eAA()
  {
    AppMethodBeat.i(66599);
    if (!TextUtils.isEmpty(ANc))
    {
      str = ANc;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(ANc))
    {
      k.ezn();
      str = k.TX(196656);
      ANc = str;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(ANc)) {
      Log.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = ANc;
    AppMethodBeat.o(66599);
    return str;
  }
  
  private static void eAB()
  {
    AppMethodBeat.i(66601);
    com.tencent.mm.kernel.g.aAg().hqi.a(new bu(new bu.a()
    {
      public final void a(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(66555);
        if ((paramAnonymousg == null) || (paramAnonymousg.aZh() == null))
        {
          Log.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
          AppMethodBeat.o(66555);
          return;
        }
        byte[] arrayOfByte = paramAnonymousg.aZh().MC("offline_token");
        if (arrayOfByte != null) {
          a.fU(new String(arrayOfByte));
        }
        arrayOfByte = paramAnonymousg.aZh().MC("offline_token_V2");
        if (arrayOfByte != null) {
          a.ANa = new String(arrayOfByte);
        }
        paramAnonymousg = paramAnonymousg.aZh().MC("offline_key_list");
        if (paramAnonymousg != null) {
          a.ANd = new String(paramAnonymousg);
        }
        AppMethodBeat.o(66555);
      }
    }), 0);
    AppMethodBeat.o(66601);
  }
  
  private static String eAC()
  {
    AppMethodBeat.i(66605);
    k.ezn();
    String str = k.TX(196616);
    AppMethodBeat.o(66605);
    return str;
  }
  
  public static boolean eAD()
  {
    int j = 0;
    AppMethodBeat.i(66608);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slq, 0) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.WalletOfflineUtil", "pass same md5 case");
      AppMethodBeat.o(66608);
      return true;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
    Object localObject = aJm(eAA());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size()))
    {
      AppMethodBeat.o(66608);
      return false;
    }
    Collections.sort((List)localObject, ANm);
    Collections.sort(localArrayList, ANl);
    StringBuilder localStringBuilder = new StringBuilder();
    i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a)((LinkedList)localObject).get(i)).ANo);
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
  
  private static String eAE()
  {
    AppMethodBeat.i(66609);
    if (TextUtils.isEmpty(ANe))
    {
      k.ezn();
      str = k.TX(196615);
      ANe = str;
      AppMethodBeat.o(66609);
      return str;
    }
    String str = ANe;
    AppMethodBeat.o(66609);
    return str;
  }
  
  public static int eAF()
  {
    AppMethodBeat.i(66613);
    k.ezn();
    String str = k.TX(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66613);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66613);
    return i;
  }
  
  public static boolean eAG()
  {
    AppMethodBeat.i(66614);
    String str = eAt();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(66614);
      return false;
    }
    long l1 = eAF();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(66614);
      return true;
    }
    AppMethodBeat.o(66614);
    return false;
  }
  
  public static String eAH()
  {
    AppMethodBeat.i(66619);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ocl, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66619);
      return localObject;
    }
    AppMethodBeat.o(66619);
    return null;
  }
  
  public static String eAI()
  {
    AppMethodBeat.i(66621);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Odo, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66621);
      return localObject;
    }
    AppMethodBeat.o(66621);
    return null;
  }
  
  public static int eAJ()
  {
    AppMethodBeat.i(66623);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Odp, null);
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
  
  public static String eAK()
  {
    AppMethodBeat.i(66625);
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Odq, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66625);
      return localObject;
    }
    AppMethodBeat.o(66625);
    return null;
  }
  
  public static boolean eAL()
  {
    AppMethodBeat.i(66627);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.d.aXu().Fu("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).gzz();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        Log.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.d.aXu().Fu("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).gzz();
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
  
  public static int eAM()
  {
    return k.AIY;
  }
  
  public static boolean eAj()
  {
    AppMethodBeat.i(66558);
    k.ezn();
    String str = k.TX(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66558);
      return true;
    }
    AppMethodBeat.o(66558);
    return false;
  }
  
  public static boolean eAk()
  {
    AppMethodBeat.i(66559);
    k.ezn();
    String str = k.TX(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66559);
      return true;
    }
    AppMethodBeat.o(66559);
    return false;
  }
  
  @Deprecated
  public static Bankcard eAl()
  {
    AppMethodBeat.i(66560);
    Bankcard localBankcard = af.yi(true);
    AppMethodBeat.o(66560);
    return localBankcard;
  }
  
  @Deprecated
  public static Bankcard eAm()
  {
    AppMethodBeat.i(213693);
    Bankcard localBankcard = af.yi(false);
    AppMethodBeat.o(213693);
    return localBankcard;
  }
  
  public static Bankcard eAn()
  {
    AppMethodBeat.i(66561);
    Bankcard localBankcard = sA(true);
    AppMethodBeat.o(66561);
    return localBankcard;
  }
  
  public static Bankcard eAo()
  {
    AppMethodBeat.i(66562);
    com.tencent.mm.plugin.wallet_core.model.t.fQI();
    Bankcard localBankcard = an.fRX();
    AppMethodBeat.o(66562);
    return localBankcard;
  }
  
  public static int eAp()
  {
    AppMethodBeat.i(66563);
    int i = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true).size();
    AppMethodBeat.o(66563);
    return i;
  }
  
  public static List<Bankcard> eAq()
  {
    AppMethodBeat.i(66565);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRI();
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
  
  public static int eAr()
  {
    AppMethodBeat.i(66566);
    k.ezn();
    String str = k.TX(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66566);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66566);
    return i;
  }
  
  private static int eAs()
  {
    int j = 0;
    AppMethodBeat.i(66567);
    k.ezn();
    String str = k.TX(196640);
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
        break label62;
      }
      i *= 100;
    }
    for (;;)
    {
      AppMethodBeat.o(66567);
      return i;
      i = Util.getInt(str, 0);
      break;
      label62:
      i = 20000;
    }
  }
  
  public static String eAt()
  {
    AppMethodBeat.i(66570);
    k.ezn();
    String str = k.TX(196632);
    AppMethodBeat.o(66570);
    return str;
  }
  
  public static String eAu()
  {
    AppMethodBeat.i(66571);
    k.ezn();
    String str = k.TX(196631);
    AppMethodBeat.o(66571);
    return str;
  }
  
  public static String eAv()
  {
    AppMethodBeat.i(66576);
    com.tencent.mm.plugin.wallet_core.model.t.fQI();
    String str = an.fRR();
    AppMethodBeat.o(66576);
    return str;
  }
  
  public static void eAw()
  {
    AppMethodBeat.i(66578);
    Log.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.ezn();
    k.bN(196630, "0");
    k.ezn();
    k.bN(196626, "");
    k.ezn();
    k.bN(196627, "");
    k.ezn();
    k.bN(196628, "");
    k.ezn();
    k.bN(196617, "");
    k.ezn();
    k.bN(196632, "");
    k.ezn();
    k.bN(196641, "");
    k.ezn();
    k.bN(196647, "");
    k.ezn();
    k.bN(196649, "");
    w("", "", "", "");
    Uh(0);
    k.ezn();
    k.bN(196629, "0");
    aJj("");
    k.ezn();
    k.ezo().AKa = null;
    k.ezn();
    k.ezq();
    k.ezn();
    String str = k.TX(196617);
    com.tencent.mm.wallet_core.c.b.hhj();
    com.tencent.mm.wallet_core.c.b.clearToken(str);
    aJo("");
    aJl("");
    AppMethodBeat.o(66578);
  }
  
  public static void eAx()
  {
    AppMethodBeat.i(66593);
    k.ezn();
    k.bN(196643, "1");
    AppMethodBeat.o(66593);
  }
  
  public static int eAy()
  {
    AppMethodBeat.i(66595);
    k.ezn();
    String str = k.TX(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66595);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66595);
    return i;
  }
  
  public static String eAz()
  {
    AppMethodBeat.i(66598);
    if (!TextUtils.isEmpty(ANa))
    {
      str = ANa;
      AppMethodBeat.o(66598);
      return str;
    }
    eAB();
    if (TextUtils.isEmpty(ANa)) {
      Log.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = ANa;
    AppMethodBeat.o(66598);
    return str;
  }
  
  private static e.a.a.c f(Map<String, String> paramMap, int paramInt)
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
      localc.Ubh = Util.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.LrG = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.Ltn = Util.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localc.Ltl = Util.nullAsNil((String)paramMap.get(str + "exposure_info_modify_params"));
      localObject1 = new e.a.a.a();
      localObject2 = str + "btn_info.";
      ((e.a.a.a)localObject1).UaZ = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((e.a.a.a)localObject1).Uba = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((e.a.a.a)localObject1).Ubb = Util.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((e.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((e.a.a.a)localObject1).LXU = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((e.a.a.a)localObject1).Ubc = new e.a.a.g();
      ((e.a.a.a)localObject1).Ubc.MFd = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((e.a.a.a)localObject1).Ubc.MFe = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((e.a.a.a)localObject1).Ubc.MFf = Util.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!Util.isNullOrNil(((e.a.a.a)localObject1).UaZ)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).url)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).LXU)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).Ubc.MFd)) || (!Util.isNullOrNil(((e.a.a.a)localObject1).Ubc.MFe))) {
        localc.Lto = ((e.a.a.a)localObject1);
      }
      localc.Ubi = Util.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.Ubj = Util.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.Ubl = ((String)paramMap.get(str + "background_img_whole"));
      localc.Ltm = new LinkedList();
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
      localObject2 = new i();
      ((i)localObject2).Bah = ((String)paramMap.get((String)localObject1 + "logo"));
      ((i)localObject2).UbK = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((i)localObject2).UbL = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((i)localObject2).UbM = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((i)localObject2).UbN = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((i)localObject2).UbO = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!Util.isNullOrNil(((i)localObject2).Bah)) || (!Util.isNullOrNil(((i)localObject2).UbK)) || (!Util.isNullOrNil(((i)localObject2).UbL)) || (!Util.isNullOrNil(((i)localObject2).UbM)) || (!Util.isNullOrNil(((i)localObject2).UbN)) || (!Util.isNullOrNil(((i)localObject2).UbO))) {
        localc.Ltm.add(localObject2);
      }
      if ((Util.isNullOrNil(((i)localObject2).UbK)) || (Util.isNullOrNil(((i)localObject2).UbL))) {
        break label1125;
      }
      paramInt += 1;
      break label713;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1125:
    localc.Ubk = new e.a.a.f();
    localObject1 = str + "layer_info.";
    localc.Ubk.Uby = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.Ubk.Ubz = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.Ubk.UbA = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.Ubk.UbB = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.Ubk.UbC = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.Ubk.UbD = Util.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.Ubk.UbE = new e.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.Ubk.UbE.UaZ = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.Ubk.UbE.Uba = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.Ubk.UbE.Ubb = Util.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.Ubk.UbE.LXU = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.Ubk.UbE.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.Ubk.UbE.Ubc = new e.a.a.g();
    localc.Ubk.UbE.Ubc.MFd = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.Ubk.UbE.Ubc.MFe = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.Ubk.UbE.Ubc.MFf = Util.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!Util.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.Ubk.UbF = new com.tencent.mm.bw.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!Util.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.Ubk.LaX = new com.tencent.mm.bw.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new e.a.a.b();
    String str = str + "draw_lottery_info.";
    ((e.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((e.a.a.b)localObject1).Ubd = ((String)paramMap.get(str + "animation_wording"));
    ((e.a.a.b)localObject1).Ube = ((String)paramMap.get(str + "animation_wording_color"));
    ((e.a.a.b)localObject1).NkQ = Util.getInt((String)paramMap.get(str + "op_type"), 0);
    ((e.a.a.b)localObject1).Ubf = ((String)paramMap.get(str + "after_animation_wording"));
    ((e.a.a.b)localObject1).Ubg = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((e.a.a.b)localObject1).Ubc = new e.a.a.g();
    ((e.a.a.b)localObject1).Ubc.MFd = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((e.a.a.b)localObject1).Ubc.MFe = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((e.a.a.b)localObject1).Ubc.MFf = Util.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!Util.isNullOrNil(((e.a.a.b)localObject1).url)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).Ubd)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).Ube)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).Ubc.MFd)) || (!Util.isNullOrNil(((e.a.a.b)localObject1).Ubc.MFe))) {
      localc.Ubm = ((e.a.a.b)localObject1);
    }
    AppMethodBeat.o(66581);
    return localc;
    label2417:
    AppMethodBeat.o(66581);
    return null;
  }
  
  public static void gK(Context paramContext)
  {
    AppMethodBeat.i(66573);
    String str = LocaleUtil.getApplicationLanguage();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(2131766969);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.f.bn(paramContext, str);
      AppMethodBeat.o(66573);
      return;
      if ("zh_TW".equals(str)) {
        str = paramContext.getString(2131766972);
      } else if ("zh_HK".equals(str)) {
        str = paramContext.getString(2131766971);
      } else {
        str = paramContext.getResources().getString(2131766970);
      }
    }
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
    if (!TextUtils.isEmpty(AMZ))
    {
      str = AMZ;
      AppMethodBeat.o(66596);
      return str;
    }
    eAB();
    if (TextUtils.isEmpty(AMZ)) {
      Log.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = AMZ;
    AppMethodBeat.o(66596);
    return str;
  }
  
  public static String getTokenPin()
  {
    AppMethodBeat.i(66604);
    k.ezn();
    String str = k.TX(196647);
    AppMethodBeat.o(66604);
    return str;
  }
  
  public static void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66584);
    a(paramActivity, paramInt, -1);
    AppMethodBeat.o(66584);
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
    AppMethodBeat.i(66587);
    a(paramActivity, "create", paramActivity.getString(2131768414), 0, paramInt);
    AppMethodBeat.o(66587);
  }
  
  public static void j(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66592);
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(2131768434), paramActivity.getString(2131755761), new DialogInterface.OnClickListener()new a.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66552);
        a.eAw();
        a.az(this.val$activity);
        this.val$activity.finish();
        AppMethodBeat.o(66552);
      }
    }, new a.2(paramActivity));
    AppMethodBeat.o(66592);
  }
  
  public static void k(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66591);
    a(paramActivity, "create", "", eAs(), paramInt);
    AppMethodBeat.o(66591);
  }
  
  public static Bankcard sA(boolean paramBoolean)
  {
    AppMethodBeat.i(213694);
    Object localObject = af.yi(paramBoolean);
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (Util.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(213694);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
    int i = 0;
    while (i < ((List)localObject).size())
    {
      Bankcard localBankcard = (Bankcard)((List)localObject).get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay))
      {
        AppMethodBeat.o(213694);
        return localBankcard;
      }
      i += 1;
    }
    AppMethodBeat.o(213694);
    return null;
  }
  
  public static List<Bankcard> sB(boolean paramBoolean)
  {
    AppMethodBeat.i(66564);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.t.fQI().yk(true);
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
  
  public static void w(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(66597);
    AMZ = paramString1;
    ANa = paramString2;
    ANc = paramString3;
    ANd = paramString4;
    aJl(ANc);
    com.tencent.mm.kernel.g.aAg().hqi.a(new bu(new bu.a()
    {
      public final void a(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(66554);
        if ((paramAnonymousg == null) || (paramAnonymousg.aZh() == null))
        {
          AppMethodBeat.o(66554);
          return;
        }
        if (a.AMZ != null) {
          paramAnonymousg.aZh().i("offline_token", a.AMZ.getBytes());
        }
        if (a.ANa != null) {
          paramAnonymousg.aZh().i("offline_token_V2", a.ANa.getBytes());
        }
        if (a.ANd != null) {
          paramAnonymousg.aZh().i("offline_key_list", a.ANd.getBytes());
        }
        AppMethodBeat.o(66554);
      }
    }), 0);
    AppMethodBeat.o(66597);
  }
  
  public static final class a
  {
    public int ANn;
    public String ANo;
    public String ANp;
    public String dDj;
  }
  
  public static final class b
  {
    public String dDj;
    public String qGB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */