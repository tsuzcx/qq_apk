package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
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
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import e.a.a.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
  public static String oCY;
  private static String wRe;
  public static String wRf;
  public static int wRg;
  public static String wRh;
  public static String wRi;
  public static String wRj;
  public static int wRk;
  public static int wRl;
  public static long wRm;
  public static boolean wRn;
  public static String wRo;
  public static String wRp;
  private static Comparator<Bankcard> wRq;
  private static Comparator<a> wRr;
  
  static
  {
    AppMethodBeat.i(66629);
    wRe = "";
    wRf = "";
    wRg = 1;
    wRh = "";
    wRi = "";
    wRj = "";
    wRk = 1;
    wRl = 0;
    wRm = 0L;
    wRn = false;
    oCY = "";
    wRo = "";
    wRp = "";
    wRq = new a.5();
    wRr = new Comparator() {};
    AppMethodBeat.o(66629);
  }
  
  private static LinkedList<a> A(JSONArray paramJSONArray)
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
        locala.wRs = localJSONObject.optInt("card_id");
        locala.dlT = localJSONObject.optString("bank_type");
        locala.wRt = localJSONObject.optString("bind_serial");
        locala.wRu = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(66603);
    return localLinkedList;
  }
  
  private static LinkedList<b> B(JSONArray paramJSONArray)
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
        localb.dlT = localJSONObject.optString("bank_type");
        localb.pqW = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(66612);
    return localLinkedList;
  }
  
  public static void MT(int paramInt)
  {
    AppMethodBeat.i(66568);
    k.dzG();
    k.bz(196640, String.valueOf(paramInt));
    AppMethodBeat.o(66568);
  }
  
  public static void MU(int paramInt)
  {
    AppMethodBeat.i(66569);
    k.dzG();
    k.bz(196642, String.valueOf(paramInt));
    AppMethodBeat.o(66569);
  }
  
  public static void MV(int paramInt)
  {
    AppMethodBeat.i(66594);
    k.dzG();
    k.bz(196644, String.valueOf(paramInt));
    AppMethodBeat.o(66594);
  }
  
  public static void MW(int paramInt)
  {
    AppMethodBeat.i(66622);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUX, Integer.valueOf(i));
    AppMethodBeat.o(66622);
  }
  
  public static void MX(int paramInt)
  {
    AppMethodBeat.i(182496);
    if (paramInt > 0)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITZ, Integer.valueOf(paramInt));
      k.wNs = paramInt;
      ae.i("MicroMsg.WalletOfflineUtil", "set token num: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(182496);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66585);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dDI = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!t.eJf().eJH())
    {
      if (t.eJf().eJJ())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
      if (t.eJf().eJI())
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
    localPayInfo.dDI = 5;
    paramBundle.putParcelable("key_pay_info", localPayInfo);
    paramBundle.putBoolean("key_need_bind_response", true);
    paramBundle.putInt("key_bind_scene", 5);
    paramBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      paramBundle.putInt("key_entry_scene", paramInt2);
    }
    if (paramBundle != null)
    {
      ab.kI(6, paramBundle.getInt("key_bind_scene"));
      z.agV(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramActivity, paramBundle);
      AppMethodBeat.o(66586);
      return;
      ab.kI(6, 0);
      z.agV(0);
    }
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    AppMethodBeat.i(66579);
    ae.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.wOJ == null))
    {
      ae.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(66579);
      return;
    }
    if (!dAz())
    {
      AppMethodBeat.o(66579);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.wOJ);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.dOH != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.b(paramf.dOH.dOi, paramf.dOH.dOj, paramf.dOH.dOk, paramf.dOH.dOl, paramf.dOH.dOm, 8);
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
  
  public static void a(Activity paramActivity, String paramString, n paramn)
  {
    AppMethodBeat.i(66583);
    ae.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.WalletOfflineUtil", "transid == null");
      AppMethodBeat.o(66583);
      return;
    }
    if (!dAz())
    {
      AppMethodBeat.o(66583);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramn = ((com.tencent.mm.plugin.offline.a.e)paramn).wNL;
      if (paramn != null) {
        localBundle.putParcelable("key_realname_guide_helper", paramn);
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
      paramOrders.Dqb = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.Dqd = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.ulS = ((String)paramMap.get(str + "name_color"));
          localShowInfo.Dre = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.Drf = bu.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.Drg = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.Drh = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.Dri = ((String)paramMap.get(str + "link_url"));
          localShowInfo.Drj = bu.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!bu.isNullOrNil(localShowInfo.name)) || (!bu.isNullOrNil(localShowInfo.value))) {
            paramOrders.Dqd.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(66582);
  }
  
  public static void auX(String paramString)
  {
    AppMethodBeat.i(66572);
    k.dzG();
    k.bz(196631, paramString);
    AppMethodBeat.o(66572);
  }
  
  public static void auY(String paramString)
  {
    AppMethodBeat.i(66577);
    t.eJf();
    an.aFR(paramString);
    AppMethodBeat.o(66577);
  }
  
  public static void auZ(String paramString)
  {
    AppMethodBeat.i(66600);
    k.dzG();
    k.bz(196656, paramString);
    wRh = paramString;
    AppMethodBeat.o(66600);
  }
  
  public static LinkedList<a> ava(String paramString)
  {
    AppMethodBeat.i(66602);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66602);
      return null;
    }
    try
    {
      paramString = A(new JSONArray(paramString));
      AppMethodBeat.o(66602);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66602);
    }
    return null;
  }
  
  public static void avb(String paramString)
  {
    AppMethodBeat.i(66606);
    k.dzG();
    k.bz(196616, paramString);
    AppMethodBeat.o(66606);
  }
  
  public static void avc(String paramString)
  {
    AppMethodBeat.i(66610);
    k.dzG();
    k.bz(196615, paramString);
    wRj = paramString;
    AppMethodBeat.o(66610);
  }
  
  private static LinkedList<b> avd(String paramString)
  {
    AppMethodBeat.i(66611);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66611);
      return null;
    }
    try
    {
      paramString = B(new JSONArray(paramString));
      AppMethodBeat.o(66611);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66611);
    }
    return null;
  }
  
  public static String ave(String paramString)
  {
    AppMethodBeat.i(66615);
    LinkedList localLinkedList = avd(dAS());
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
      if ((localb == null) || (!paramString.equals(localb.dlT))) {}
    }
    for (paramString = localb.pqW;; paramString = "")
    {
      AppMethodBeat.o(66615);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String avf(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(66616);
    Object localObject = ava(dAO());
    LinkedList localLinkedList = avd(dAS());
    if ((localObject == null) || (localLinkedList == null) || (((LinkedList)localObject).size() == 0) || (localLinkedList.size() == 0))
    {
      ae.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
      AppMethodBeat.o(66616);
      return "";
    }
    int i = 0;
    a locala;
    if (i < ((LinkedList)localObject).size())
    {
      locala = (a)((LinkedList)localObject).get(i);
      if ((locala == null) || (!paramString.equals(locala.wRt))) {}
    }
    for (paramString = locala.dlT;; paramString = "")
    {
      if (TextUtils.isEmpty(paramString))
      {
        ae.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
        AppMethodBeat.o(66616);
        return "";
        i += 1;
        break;
      }
      i = j;
      if (i < localLinkedList.size())
      {
        localObject = (b)localLinkedList.get(i);
        if ((localObject == null) || (!paramString.equals(((b)localObject).dlT))) {}
      }
      for (paramString = ((b)localObject).pqW;; paramString = "")
      {
        AppMethodBeat.o(66616);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void avg(String paramString)
  {
    AppMethodBeat.i(66618);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ITX, paramString);
    AppMethodBeat.o(66618);
  }
  
  public static void avh(String paramString)
  {
    AppMethodBeat.i(66620);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUW, paramString);
    AppMethodBeat.o(66620);
  }
  
  public static void avi(String paramString)
  {
    AppMethodBeat.i(66624);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUY, paramString);
    AppMethodBeat.o(66624);
  }
  
  public static void avj(String paramString)
  {
    AppMethodBeat.i(66628);
    ae.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.h.m(paramString, true, false);
    if (paramString == null)
    {
      ae.w("MicroMsg.WalletOfflineUtil", "can not find app info");
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
    com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bd(localBundle);
    MMessageActV2.send(ak.getContext(), (MMessageActV2.Args)localObject);
    AppMethodBeat.o(66628);
  }
  
  public static void ax(Activity paramActivity)
  {
    AppMethodBeat.i(66589);
    a(paramActivity, "freeze", paramActivity.getString(2131765964), 0, -1);
    AppMethodBeat.o(66589);
  }
  
  public static void ay(Activity paramActivity)
  {
    AppMethodBeat.i(66590);
    k(paramActivity, -1);
    AppMethodBeat.o(66590);
  }
  
  public static Orders az(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66580);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.wSc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.wSd = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.wSe = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.wSf = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.dmx = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.phz = (bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.wSj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.wSk = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.wSo = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.wSv = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.wSm = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.wSq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.wSr = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.wRU = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.Dqq = (bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).wSr = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.Dqo;
    localCommodity.Dqr = ((Orders.Promotions)localObject1).wSr;
    ((Orders.Promotions)localObject1).xcF = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.DpF = j;
    localCommodity.Dqu = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.Dqv = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.Dqw = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!bu.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.DqA = true;
      localCommodity.Dqz.add(localObject1);
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
        if (!bu.isNullOrNil(str1)) {
          break label2130;
        }
        ae.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.DqB.text = ((String)localObject1);
      localCommodity.DqB.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(str1)) && (!bu.isNullOrNil((String)localObject2)) && (!bu.isNullOrNil(str2)))
      {
        localCommodity.Dqx = new Orders.RecommendTinyAppInfo();
        localCommodity.Dqx.DfD = ((String)localObject1);
        localCommodity.Dqx.Dpt = str1;
        localCommodity.Dqx.Dpu = ((String)localObject2);
        localCommodity.Dqx.CRv = str2;
        localCommodity.Dqx.CRw = str3;
        localCommodity.Dqx.Dpv = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.Dqx.DqW = bu.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.Dqx.DqX = bu.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.Dqx.DqZ = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.Dqx.Dra = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.Dqx.Drb = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.Dqx.DqY = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.Dqx.Dpw = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localOrders.DpP = new ArrayList();
      localOrders.DpP.add(localCommodity);
      localOrders.DpZ = bu.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.Dqa = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.DpH = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.DpF = j;
      localOrders.dmw = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.Dqq = (bu.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
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
      ((Orders.DiscountInfo)localObject2).ynr = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).DqL = bu.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.Dqt.add(localObject2);
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
      localPromotions.xcF = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.Dpr = str2;
      localPromotions.type = Orders.Dqp;
      localPromotions.DqM = bu.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.JhR = bu.getInt(str5, 0);
      localPromotions.vlr = bu.getLong(str6, 0L);
      localPromotions.Dpo = bu.getInt(str7, 0);
      localPromotions.JhS = bu.getInt(str8, 0);
      localPromotions.Dpp = bu.getInt(str9, 0);
      localPromotions.JhT = str10;
      localPromotions.JhU = str11;
      localPromotions.JhV = str12;
      localPromotions.Dpq = bu.getLong(str13, 0L);
      localPromotions.JhW = bu.getInt(str14, 0);
      localPromotions.JhX = str15;
      localPromotions.JhY = str16;
      localObject1 = d(paramMap, i);
      if (localObject1 != null) {
        localPromotions.DqV = ((e.a.a.c)localObject1);
      }
      localCommodity.Dqz.add(localPromotions);
      i += 1;
      break;
    }
    label2339:
    ae.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    for (;;)
    {
      AppMethodBeat.o(66580);
      return localOrders;
      label2387:
      ae.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    }
  }
  
  public static void az(Activity paramActivity)
  {
    AppMethodBeat.i(66607);
    com.tencent.mm.ui.base.h.cm(paramActivity, paramActivity.getResources().getString(2131765962));
    if (!TextUtils.isEmpty(dAQ())) {
      com.tencent.mm.wallet_core.ui.f.aY(paramActivity, dAQ());
    }
    AppMethodBeat.o(66607);
  }
  
  public static boolean cJ(Context paramContext)
  {
    AppMethodBeat.i(66617);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ae.d("MicroMsg.WalletOfflineUtil", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ae.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
        AppMethodBeat.o(66617);
        return false;
      }
    }
    if (((KeyguardManager)ak.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(66617);
      return false;
    }
    ae.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
    AppMethodBeat.o(66617);
    return true;
  }
  
  private static e.a.a.c d(Map<String, String> paramMap, int paramInt)
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
      localc.Oml = bu.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.Gwa = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.GxE = bu.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localc.GxC = bu.nullAsNil((String)paramMap.get(str + "exposure_info_modify_params"));
      localObject1 = new e.a.a.a();
      localObject2 = str + "btn_info.";
      ((e.a.a.a)localObject1).Omd = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((e.a.a.a)localObject1).Ome = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((e.a.a.a)localObject1).Omf = bu.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((e.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((e.a.a.a)localObject1).GTG = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((e.a.a.a)localObject1).Omg = new e.a.a.g();
      ((e.a.a.a)localObject1).Omg.Hwe = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((e.a.a.a)localObject1).Omg.Hwf = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((e.a.a.a)localObject1).Omg.Hwg = bu.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!bu.isNullOrNil(((e.a.a.a)localObject1).Omd)) || (!bu.isNullOrNil(((e.a.a.a)localObject1).url)) || (!bu.isNullOrNil(((e.a.a.a)localObject1).GTG)) || (!bu.isNullOrNil(((e.a.a.a)localObject1).Omg.Hwe)) || (!bu.isNullOrNil(((e.a.a.a)localObject1).Omg.Hwf))) {
        localc.GxF = ((e.a.a.a)localObject1);
      }
      localc.Omm = bu.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.Omn = bu.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.Omp = ((String)paramMap.get(str + "background_img_whole"));
      localc.GxD = new LinkedList();
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
      ((i)localObject2).xcF = ((String)paramMap.get((String)localObject1 + "logo"));
      ((i)localObject2).OmO = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((i)localObject2).OmP = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((i)localObject2).OmQ = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((i)localObject2).OmR = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((i)localObject2).OmS = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!bu.isNullOrNil(((i)localObject2).xcF)) || (!bu.isNullOrNil(((i)localObject2).OmO)) || (!bu.isNullOrNil(((i)localObject2).OmP)) || (!bu.isNullOrNil(((i)localObject2).OmQ)) || (!bu.isNullOrNil(((i)localObject2).OmR)) || (!bu.isNullOrNil(((i)localObject2).OmS))) {
        localc.GxD.add(localObject2);
      }
      if ((bu.isNullOrNil(((i)localObject2).OmO)) || (bu.isNullOrNil(((i)localObject2).OmP))) {
        break label1125;
      }
      paramInt += 1;
      break label713;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1125:
    localc.Omo = new e.a.a.f();
    localObject1 = str + "layer_info.";
    localc.Omo.OmC = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.Omo.OmD = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.Omo.OmE = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.Omo.OmF = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.Omo.OmG = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.Omo.OmH = bu.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.Omo.OmI = new e.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.Omo.OmI.Omd = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.Omo.OmI.Ome = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.Omo.OmI.Omf = bu.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.Omo.OmI.GTG = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.Omo.OmI.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.Omo.OmI.Omg = new e.a.a.g();
    localc.Omo.OmI.Omg.Hwe = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.Omo.OmI.Omg.Hwf = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.Omo.OmI.Omg.Hwg = bu.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!bu.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.Omo.OmJ = new com.tencent.mm.bw.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!bu.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.Omo.Ggu = new com.tencent.mm.bw.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new e.a.a.b();
    String str = str + "draw_lottery_info.";
    ((e.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((e.a.a.b)localObject1).Omh = ((String)paramMap.get(str + "animation_wording"));
    ((e.a.a.b)localObject1).Omi = ((String)paramMap.get(str + "animation_wording_color"));
    ((e.a.a.b)localObject1).HYJ = bu.getInt((String)paramMap.get(str + "op_type"), 0);
    ((e.a.a.b)localObject1).Omj = ((String)paramMap.get(str + "after_animation_wording"));
    ((e.a.a.b)localObject1).Omk = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((e.a.a.b)localObject1).Omg = new e.a.a.g();
    ((e.a.a.b)localObject1).Omg.Hwe = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((e.a.a.b)localObject1).Omg.Hwf = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((e.a.a.b)localObject1).Omg.Hwg = bu.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!bu.isNullOrNil(((e.a.a.b)localObject1).url)) || (!bu.isNullOrNil(((e.a.a.b)localObject1).Omh)) || (!bu.isNullOrNil(((e.a.a.b)localObject1).Omi)) || (!bu.isNullOrNil(((e.a.a.b)localObject1).Omg.Hwe)) || (!bu.isNullOrNil(((e.a.a.b)localObject1).Omg.Hwf))) {
      localc.Omq = ((e.a.a.b)localObject1);
    }
    AppMethodBeat.o(66581);
    return localc;
    label2417:
    AppMethodBeat.o(66581);
    return null;
  }
  
  @Deprecated
  public static Bankcard dAA()
  {
    AppMethodBeat.i(66560);
    t.eJf();
    Object localObject2 = an.eKm();
    ae.i("MicroMsg.WalletPayOrderMgr", "step 1 getSelectedBindBankCard %s", new Object[] { localObject2 });
    Object localObject3 = t.eJf();
    Object localObject1;
    if (((an)localObject3).Dsv == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label508;
      }
      localObject1 = t.eJf().uv(true);
    }
    label508:
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (i >= ((List)localObject1).size())) {
          break label254;
        }
        localObject3 = (Bankcard)((List)localObject1).get(i);
        if ((localObject3 != null) && (((String)localObject2).equals(((Bankcard)localObject3).field_bindSerial)))
        {
          ae.i("MicroMsg.WalletPayOrderMgr", "step 2 micropay: %s, forbidword: %s", new Object[] { Boolean.valueOf(((Bankcard)localObject3).field_support_micropay), ((Bankcard)localObject3).field_forbidWord });
          if (((Bankcard)localObject3).field_support_micropay)
          {
            AppMethodBeat.o(66560);
            return localObject3;
            localObject1 = new ArrayList();
            if ((((an)localObject3).CRg != null) && (!((an)localObject3).eJJ())) {
              ((ArrayList)localObject1).add(((an)localObject3).CRg);
            }
            if ((((an)localObject3).DsE != null) && (!((an)localObject3).eJJ())) {
              ((ArrayList)localObject1).add(((an)localObject3).DsE);
            }
            if (((an)localObject3).Dsv.size() > 0)
            {
              localObject3 = ((an)localObject3).Dsv.iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add((Bankcard)((Iterator)localObject3).next());
              }
            }
            break;
          }
        }
        i += 1;
      }
      label254:
      ae.i("MicroMsg.WalletPayOrderMgr", "step 3 clear default bindserial");
      t.eJf();
      an.aFR("");
      t.eJf();
      localObject2 = an.eKs();
      if ((localObject2 != null) && (bu.isNullOrNil(((Bankcard)localObject2).field_forbidWord)))
      {
        ae.i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject2;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (Bankcard)((List)localObject1).get(i);
        if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (!((Bankcard)localObject2).eIy()))
        {
          ae.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
          AppMethodBeat.o(66560);
          return localObject2;
        }
        i += 1;
      }
      localObject1 = t.eJf().CRg;
      if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay))
      {
        ae.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject1;
      }
      localObject1 = t.eJf().DsE;
      if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay) && (bu.isNullOrNil(((Bankcard)localObject1).field_forbidWord)))
      {
        ae.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject1;
      }
      AppMethodBeat.o(66560);
      return null;
    }
  }
  
  public static Bankcard dAB()
  {
    AppMethodBeat.i(66561);
    Object localObject = dAA();
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (bu.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(66561);
      return localObject;
    }
    localObject = t.eJf().uv(true);
    int i = 0;
    while (i < ((List)localObject).size())
    {
      Bankcard localBankcard = (Bankcard)((List)localObject).get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay))
      {
        AppMethodBeat.o(66561);
        return localBankcard;
      }
      i += 1;
    }
    AppMethodBeat.o(66561);
    return null;
  }
  
  public static Bankcard dAC()
  {
    AppMethodBeat.i(66562);
    t.eJf();
    Bankcard localBankcard = an.eKs();
    AppMethodBeat.o(66562);
    return localBankcard;
  }
  
  public static int dAD()
  {
    AppMethodBeat.i(66563);
    int i = t.eJf().uv(true).size();
    AppMethodBeat.o(66563);
    return i;
  }
  
  public static List<Bankcard> dAE()
  {
    AppMethodBeat.i(66565);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = t.eJf().eKe();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localArrayList1.add((Bankcard)localArrayList2.get(i));
      i += 1;
    }
    ae.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66565);
    return localArrayList1;
  }
  
  public static int dAF()
  {
    AppMethodBeat.i(66566);
    k.dzG();
    String str = k.MN(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66566);
      return 0;
    }
    int i = bu.getInt(str, 0);
    AppMethodBeat.o(66566);
    return i;
  }
  
  private static int dAG()
  {
    int j = 0;
    AppMethodBeat.i(66567);
    k.dzG();
    String str = k.MN(196640);
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
      i = bu.getInt(str, 0);
      break;
      label62:
      i = 20000;
    }
  }
  
  public static String dAH()
  {
    AppMethodBeat.i(66570);
    k.dzG();
    String str = k.MN(196632);
    AppMethodBeat.o(66570);
    return str;
  }
  
  public static String dAI()
  {
    AppMethodBeat.i(66571);
    k.dzG();
    String str = k.MN(196631);
    AppMethodBeat.o(66571);
    return str;
  }
  
  public static String dAJ()
  {
    AppMethodBeat.i(66576);
    t.eJf();
    String str = an.eKm();
    AppMethodBeat.o(66576);
    return str;
  }
  
  public static void dAK()
  {
    AppMethodBeat.i(66578);
    ae.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.dzG();
    k.bz(196630, "0");
    k.dzG();
    k.bz(196626, "");
    k.dzG();
    k.bz(196627, "");
    k.dzG();
    k.bz(196628, "");
    k.dzG();
    k.bz(196617, "");
    k.dzG();
    k.bz(196632, "");
    k.dzG();
    k.bz(196641, "");
    k.dzG();
    k.bz(196647, "");
    k.dzG();
    k.bz(196649, "");
    s("", "", "", "");
    MX(0);
    k.dzG();
    k.bz(196629, "0");
    auX("");
    k.dzG();
    k.dzH().wOu = null;
    k.dzG();
    k.dzJ();
    k.dzG();
    String str = k.MN(196617);
    com.tencent.mm.wallet_core.c.b.fVM();
    com.tencent.mm.wallet_core.c.b.clearToken(str);
    avc("");
    auZ("");
    AppMethodBeat.o(66578);
  }
  
  public static void dAL()
  {
    AppMethodBeat.i(66593);
    k.dzG();
    k.bz(196643, "1");
    AppMethodBeat.o(66593);
  }
  
  public static int dAM()
  {
    AppMethodBeat.i(66595);
    k.dzG();
    String str = k.MN(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66595);
      return 0;
    }
    int i = bu.getInt(str, 0);
    AppMethodBeat.o(66595);
    return i;
  }
  
  public static String dAN()
  {
    AppMethodBeat.i(66598);
    if (!TextUtils.isEmpty(wRf))
    {
      str = wRf;
      AppMethodBeat.o(66598);
      return str;
    }
    dAP();
    if (TextUtils.isEmpty(wRf)) {
      ae.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = wRf;
    AppMethodBeat.o(66598);
    return str;
  }
  
  public static String dAO()
  {
    AppMethodBeat.i(66599);
    if (!TextUtils.isEmpty(wRh))
    {
      str = wRh;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(wRh))
    {
      k.dzG();
      str = k.MN(196656);
      wRh = str;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(wRh)) {
      ae.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = wRh;
    AppMethodBeat.o(66599);
    return str;
  }
  
  private static void dAP()
  {
    AppMethodBeat.i(66601);
    com.tencent.mm.kernel.g.ajQ().gDv.a(new bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66555);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFs() == null))
        {
          ae.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
          AppMethodBeat.o(66555);
          return;
        }
        byte[] arrayOfByte = paramAnonymouse.aFs().DO("offline_token");
        if (arrayOfByte != null) {
          a.fh(new String(arrayOfByte));
        }
        arrayOfByte = paramAnonymouse.aFs().DO("offline_token_V2");
        if (arrayOfByte != null) {
          a.wRf = new String(arrayOfByte);
        }
        paramAnonymouse = paramAnonymouse.aFs().DO("offline_key_list");
        if (paramAnonymouse != null) {
          a.wRi = new String(paramAnonymouse);
        }
        AppMethodBeat.o(66555);
      }
    }), 0);
    AppMethodBeat.o(66601);
  }
  
  private static String dAQ()
  {
    AppMethodBeat.i(66605);
    k.dzG();
    String str = k.MN(196616);
    AppMethodBeat.o(66605);
    return str;
  }
  
  public static boolean dAR()
  {
    int j = 0;
    AppMethodBeat.i(66608);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOn, 0) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.i("MicroMsg.WalletOfflineUtil", "pass same md5 case");
      AppMethodBeat.o(66608);
      return true;
    }
    ArrayList localArrayList = t.eJf().uv(true);
    Object localObject = ava(dAO());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size()))
    {
      AppMethodBeat.o(66608);
      return false;
    }
    Collections.sort((List)localObject, wRr);
    Collections.sort(localArrayList, wRq);
    StringBuilder localStringBuilder = new StringBuilder();
    i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a)((LinkedList)localObject).get(i)).wRt);
      i += 1;
    }
    localObject = new StringBuilder();
    i = j;
    while (i < localArrayList.size())
    {
      ((StringBuilder)localObject).append(((Bankcard)localArrayList.get(i)).field_bindSerial);
      i += 1;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.aj.ej(localStringBuilder.toString()).equals(com.tencent.mm.sdk.platformtools.aj.ej(((StringBuilder)localObject).toString()));
    AppMethodBeat.o(66608);
    return bool;
  }
  
  private static String dAS()
  {
    AppMethodBeat.i(66609);
    if (TextUtils.isEmpty(wRj))
    {
      k.dzG();
      str = k.MN(196615);
      wRj = str;
      AppMethodBeat.o(66609);
      return str;
    }
    String str = wRj;
    AppMethodBeat.o(66609);
    return str;
  }
  
  public static int dAT()
  {
    AppMethodBeat.i(66613);
    k.dzG();
    String str = k.MN(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66613);
      return 0;
    }
    int i = bu.getInt(str, 0);
    AppMethodBeat.o(66613);
    return i;
  }
  
  public static boolean dAU()
  {
    AppMethodBeat.i(66614);
    String str = dAH();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(66614);
      return false;
    }
    long l1 = dAT();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(66614);
      return true;
    }
    AppMethodBeat.o(66614);
    return false;
  }
  
  public static String dAV()
  {
    AppMethodBeat.i(66619);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITX, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66619);
      return localObject;
    }
    AppMethodBeat.o(66619);
    return null;
  }
  
  public static String dAW()
  {
    AppMethodBeat.i(66621);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUW, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66621);
      return localObject;
    }
    AppMethodBeat.o(66621);
    return null;
  }
  
  public static int dAX()
  {
    AppMethodBeat.i(66623);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUX, null);
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
  
  public static String dAY()
  {
    AppMethodBeat.i(66625);
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUY, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66625);
      return localObject;
    }
    AppMethodBeat.o(66625);
    return null;
  }
  
  public static boolean dAZ()
  {
    AppMethodBeat.i(66627);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).fsy();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        ae.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.d.aDI().xi("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).fsy();
      bool1 = bool2;
      if (((Map)localObject).containsKey("open"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("open"))) {
          bool1 = true;
        }
      }
    }
    ae.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(66627);
    return bool1;
  }
  
  public static boolean dAy()
  {
    AppMethodBeat.i(66558);
    k.dzG();
    String str = k.MN(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66558);
      return true;
    }
    AppMethodBeat.o(66558);
    return false;
  }
  
  public static boolean dAz()
  {
    AppMethodBeat.i(66559);
    k.dzG();
    String str = k.MN(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66559);
      return true;
    }
    AppMethodBeat.o(66559);
    return false;
  }
  
  public static int dBa()
  {
    return k.wNs;
  }
  
  public static void f(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66592);
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(2131765981), paramActivity.getString(2131755691), new a.1(paramActivity), new a.2(paramActivity));
    AppMethodBeat.o(66592);
  }
  
  public static void gc(Context paramContext)
  {
    AppMethodBeat.i(66573);
    String str = ad.fom();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(2131764607);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.f.aY(paramContext, str);
      AppMethodBeat.o(66573);
      return;
      if ("zh_TW".equals(str)) {
        str = paramContext.getString(2131764610);
      } else if ("zh_HK".equals(str)) {
        str = paramContext.getString(2131764609);
      } else {
        str = paramContext.getResources().getString(2131764608);
      }
    }
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(66626);
    int i;
    if (az.isConnected(paramContext)) {
      if (az.isWifi(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66626);
      return i;
      if (az.is2G(paramContext))
      {
        i = 2;
      }
      else if (az.is3G(paramContext))
      {
        i = 3;
      }
      else if (az.is4G(paramContext))
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
    if (!TextUtils.isEmpty(wRe))
    {
      str = wRe;
      AppMethodBeat.o(66596);
      return str;
    }
    dAP();
    if (TextUtils.isEmpty(wRe)) {
      ae.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = wRe;
    AppMethodBeat.o(66596);
    return str;
  }
  
  public static String getTokenPin()
  {
    AppMethodBeat.i(66604);
    k.dzG();
    String str = k.MN(196647);
    AppMethodBeat.o(66604);
    return str;
  }
  
  public static void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66584);
    a(paramActivity, paramInt, -1);
    AppMethodBeat.o(66584);
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
    a(paramActivity, "create", paramActivity.getString(2131765961), 0, paramInt);
    AppMethodBeat.o(66587);
  }
  
  public static void k(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66591);
    a(paramActivity, "create", "", dAG(), paramInt);
    AppMethodBeat.o(66591);
  }
  
  public static List<Bankcard> pu(boolean paramBoolean)
  {
    AppMethodBeat.i(66564);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = t.eJf().uw(true);
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
    ae.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66564);
    return localArrayList1;
  }
  
  public static void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(66597);
    wRe = paramString1;
    wRf = paramString2;
    wRh = paramString3;
    wRi = paramString4;
    auZ(wRh);
    com.tencent.mm.kernel.g.ajQ().gDv.a(new bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66554);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFs() == null))
        {
          AppMethodBeat.o(66554);
          return;
        }
        if (a.wRe != null) {
          paramAnonymouse.aFs().i("offline_token", a.wRe.getBytes());
        }
        if (a.wRf != null) {
          paramAnonymouse.aFs().i("offline_token_V2", a.wRf.getBytes());
        }
        if (a.wRi != null) {
          paramAnonymouse.aFs().i("offline_key_list", a.wRi.getBytes());
        }
        AppMethodBeat.o(66554);
      }
    }), 0);
    AppMethodBeat.o(66597);
  }
  
  public static final class a
  {
    public String dlT;
    public int wRs;
    public String wRt;
    public String wRu;
  }
  
  public static final class b
  {
    public String dlT;
    public String pqW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */