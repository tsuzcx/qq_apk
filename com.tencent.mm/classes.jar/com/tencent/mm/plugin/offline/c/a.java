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
import com.tencent.mm.al.n;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import e.a.a.f;
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
  public static String oww;
  public static int wBA;
  public static long wBB;
  public static boolean wBC;
  public static String wBD;
  public static String wBE;
  private static Comparator<Bankcard> wBF;
  private static Comparator<a> wBG;
  private static String wBt;
  public static String wBu;
  public static int wBv;
  public static String wBw;
  public static String wBx;
  public static String wBy;
  public static int wBz;
  
  static
  {
    AppMethodBeat.i(66629);
    wBt = "";
    wBu = "";
    wBv = 1;
    wBw = "";
    wBx = "";
    wBy = "";
    wBz = 1;
    wBA = 0;
    wBB = 0L;
    wBC = false;
    oww = "";
    wBD = "";
    wBE = "";
    wBF = new a.5();
    wBG = new Comparator() {};
    AppMethodBeat.o(66629);
  }
  
  private static LinkedList<b> A(JSONArray paramJSONArray)
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
        localb.dkR = localJSONObject.optString("bank_type");
        localb.pkr = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(66612);
    return localLinkedList;
  }
  
  public static void Mo(int paramInt)
  {
    AppMethodBeat.i(66568);
    k.dwq();
    k.bz(196640, String.valueOf(paramInt));
    AppMethodBeat.o(66568);
  }
  
  public static void Mp(int paramInt)
  {
    AppMethodBeat.i(66569);
    k.dwq();
    k.bz(196642, String.valueOf(paramInt));
    AppMethodBeat.o(66569);
  }
  
  public static void Mq(int paramInt)
  {
    AppMethodBeat.i(66594);
    k.dwq();
    k.bz(196644, String.valueOf(paramInt));
    AppMethodBeat.o(66594);
  }
  
  public static void Mr(int paramInt)
  {
    AppMethodBeat.i(66622);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAy, Integer.valueOf(i));
    AppMethodBeat.o(66622);
  }
  
  public static void Ms(int paramInt)
  {
    AppMethodBeat.i(182496);
    if (paramInt > 0)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IzA, Integer.valueOf(paramInt));
      k.wxH = paramInt;
      ad.i("MicroMsg.WalletOfflineUtil", "set token num: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(182496);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66585);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dCD = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!t.eFy().eGa())
    {
      if (t.eFy().eGc())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
      if (t.eFy().eGb())
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
    localPayInfo.dCD = 5;
    paramBundle.putParcelable("key_pay_info", localPayInfo);
    paramBundle.putBoolean("key_need_bind_response", true);
    paramBundle.putInt("key_bind_scene", 5);
    paramBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      paramBundle.putInt("key_entry_scene", paramInt2);
    }
    if (paramBundle != null)
    {
      ab.kB(6, paramBundle.getInt("key_bind_scene"));
      z.agm(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramActivity, paramBundle);
      AppMethodBeat.o(66586);
      return;
      ab.kB(6, 0);
      z.agm(0);
    }
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    AppMethodBeat.i(66579);
    ad.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.wyY == null))
    {
      ad.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(66579);
      return;
    }
    if (!dxj())
    {
      AppMethodBeat.o(66579);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.wyY);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.dNr != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.b(paramf.dNr.dMS, paramf.dNr.dMT, paramf.dNr.dMU, paramf.dNr.dMV, paramf.dNr.dMW, 8);
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
    ad.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.WalletOfflineUtil", "transid == null");
      AppMethodBeat.o(66583);
      return;
    }
    if (!dxj())
    {
      AppMethodBeat.o(66583);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramn = ((com.tencent.mm.plugin.offline.a.e)paramn).wya;
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
      paramOrders.CYw = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.CYy = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.uaQ = ((String)paramMap.get(str + "name_color"));
          localShowInfo.CZz = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.CZA = bt.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.CZB = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.CZC = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.CZD = ((String)paramMap.get(str + "link_url"));
          localShowInfo.CZE = bt.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!bt.isNullOrNil(localShowInfo.name)) || (!bt.isNullOrNil(localShowInfo.value))) {
            paramOrders.CYy.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(66582);
  }
  
  public static Orders at(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66580);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.wCr = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.wCs = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.wCt = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.wCu = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.dlv = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.paV = (bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.wCy = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.wCz = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.wCD = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.wCK = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.wCB = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.wCF = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.wCG = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.wCj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.CYL = (bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).wCG = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.CYJ;
    localCommodity.CYM = ((Orders.Promotions)localObject1).wCG;
    ((Orders.Promotions)localObject1).wMR = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.CYa = j;
    localCommodity.CYP = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.CYQ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.CYR = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!bt.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.CYV = true;
      localCommodity.CYU.add(localObject1);
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
        if (!bt.isNullOrNil(str1)) {
          break label2130;
        }
        ad.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.CYW.text = ((String)localObject1);
      localCommodity.CYW.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str1)) && (!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil(str2)))
      {
        localCommodity.CYS = new Orders.RecommendTinyAppInfo();
        localCommodity.CYS.CNV = ((String)localObject1);
        localCommodity.CYS.CXO = str1;
        localCommodity.CYS.CXP = ((String)localObject2);
        localCommodity.CYS.CzQ = str2;
        localCommodity.CYS.CzR = str3;
        localCommodity.CYS.CXQ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.CYS.CZr = bt.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.CYS.CZs = bt.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.CYS.CZu = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.CYS.CZv = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.CYS.CZw = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.CYS.CZt = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.CYS.CXR = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localOrders.CYk = new ArrayList();
      localOrders.CYk.add(localCommodity);
      localOrders.CYu = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.CYv = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.CYc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.CYa = j;
      localOrders.dlu = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.CYL = (bt.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
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
      ((Orders.DiscountInfo)localObject2).xXz = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).CZg = bt.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.CYO.add(localObject2);
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
      localPromotions.wMR = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.CXM = str2;
      localPromotions.type = Orders.CYK;
      localPromotions.CZh = bt.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.OdM = bt.getInt(str5, 0);
      localPromotions.COR = bt.getLong(str6, 0L);
      localPromotions.CXJ = bt.getInt(str7, 0);
      localPromotions.OdN = bt.getInt(str8, 0);
      localPromotions.CXK = bt.getInt(str9, 0);
      localPromotions.OdO = str10;
      localPromotions.OdP = str11;
      localPromotions.OdQ = str12;
      localPromotions.CXL = bt.getLong(str13, 0L);
      localPromotions.OdR = bt.getInt(str14, 0);
      localPromotions.OdS = str15;
      localPromotions.OdT = str16;
      localObject1 = d(paramMap, i);
      if (localObject1 != null) {
        localPromotions.CZq = ((e.a.a.c)localObject1);
      }
      localCommodity.CYU.add(localPromotions);
      i += 1;
      break;
    }
    label2339:
    ad.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    for (;;)
    {
      AppMethodBeat.o(66580);
      return localOrders;
      label2387:
      ad.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    }
  }
  
  public static void atI(String paramString)
  {
    AppMethodBeat.i(66572);
    k.dwq();
    k.bz(196631, paramString);
    AppMethodBeat.o(66572);
  }
  
  public static void atJ(String paramString)
  {
    AppMethodBeat.i(66577);
    t.eFy();
    an.aEx(paramString);
    AppMethodBeat.o(66577);
  }
  
  public static void atK(String paramString)
  {
    AppMethodBeat.i(66600);
    k.dwq();
    k.bz(196656, paramString);
    wBw = paramString;
    AppMethodBeat.o(66600);
  }
  
  public static LinkedList<a> atL(String paramString)
  {
    AppMethodBeat.i(66602);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66602);
      return null;
    }
    try
    {
      paramString = z(new JSONArray(paramString));
      AppMethodBeat.o(66602);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66602);
    }
    return null;
  }
  
  public static void atM(String paramString)
  {
    AppMethodBeat.i(66606);
    k.dwq();
    k.bz(196616, paramString);
    AppMethodBeat.o(66606);
  }
  
  public static void atN(String paramString)
  {
    AppMethodBeat.i(66610);
    k.dwq();
    k.bz(196615, paramString);
    wBy = paramString;
    AppMethodBeat.o(66610);
  }
  
  private static LinkedList<b> atO(String paramString)
  {
    AppMethodBeat.i(66611);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66611);
      return null;
    }
    try
    {
      paramString = A(new JSONArray(paramString));
      AppMethodBeat.o(66611);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66611);
    }
    return null;
  }
  
  public static String atP(String paramString)
  {
    AppMethodBeat.i(66615);
    LinkedList localLinkedList = atO(dxC());
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
      if ((localb == null) || (!paramString.equals(localb.dkR))) {}
    }
    for (paramString = localb.pkr;; paramString = "")
    {
      AppMethodBeat.o(66615);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String atQ(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(66616);
    Object localObject = atL(dxy());
    LinkedList localLinkedList = atO(dxC());
    if ((localObject == null) || (localLinkedList == null) || (((LinkedList)localObject).size() == 0) || (localLinkedList.size() == 0))
    {
      ad.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
      AppMethodBeat.o(66616);
      return "";
    }
    int i = 0;
    a locala;
    if (i < ((LinkedList)localObject).size())
    {
      locala = (a)((LinkedList)localObject).get(i);
      if ((locala == null) || (!paramString.equals(locala.wBI))) {}
    }
    for (paramString = locala.dkR;; paramString = "")
    {
      if (TextUtils.isEmpty(paramString))
      {
        ad.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
        AppMethodBeat.o(66616);
        return "";
        i += 1;
        break;
      }
      i = j;
      if (i < localLinkedList.size())
      {
        localObject = (b)localLinkedList.get(i);
        if ((localObject == null) || (!paramString.equals(((b)localObject).dkR))) {}
      }
      for (paramString = ((b)localObject).pkr;; paramString = "")
      {
        AppMethodBeat.o(66616);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void atR(String paramString)
  {
    AppMethodBeat.i(66618);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Izy, paramString);
    AppMethodBeat.o(66618);
  }
  
  public static void atS(String paramString)
  {
    AppMethodBeat.i(66620);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAx, paramString);
    AppMethodBeat.o(66620);
  }
  
  public static void atT(String paramString)
  {
    AppMethodBeat.i(66624);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAz, paramString);
    AppMethodBeat.o(66624);
  }
  
  public static void atU(String paramString)
  {
    AppMethodBeat.i(66628);
    ad.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.h.m(paramString, true, false);
    if (paramString == null)
    {
      ad.w("MicroMsg.WalletOfflineUtil", "can not find app info");
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
    com.tencent.mm.pluginsdk.model.app.q.bb(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
    MMessageActV2.send(aj.getContext(), (MMessageActV2.Args)localObject);
    AppMethodBeat.o(66628);
  }
  
  public static void aw(Activity paramActivity)
  {
    AppMethodBeat.i(66589);
    a(paramActivity, "freeze", paramActivity.getString(2131765964), 0, -1);
    AppMethodBeat.o(66589);
  }
  
  public static void ax(Activity paramActivity)
  {
    AppMethodBeat.i(66590);
    k(paramActivity, -1);
    AppMethodBeat.o(66590);
  }
  
  public static void ay(Activity paramActivity)
  {
    AppMethodBeat.i(66607);
    com.tencent.mm.ui.base.h.cl(paramActivity, paramActivity.getResources().getString(2131765962));
    if (!TextUtils.isEmpty(dxA())) {
      com.tencent.mm.wallet_core.ui.e.aW(paramActivity, dxA());
    }
    AppMethodBeat.o(66607);
  }
  
  public static boolean cH(Context paramContext)
  {
    AppMethodBeat.i(66617);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ad.d("MicroMsg.WalletOfflineUtil", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ad.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
        AppMethodBeat.o(66617);
        return false;
      }
    }
    if (((KeyguardManager)aj.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(66617);
      return false;
    }
    ad.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
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
      localc.NPf = bt.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.Gdt = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.GeW = bt.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localc.GeU = bt.nullAsNil((String)paramMap.get(str + "exposure_info_modify_params"));
      localObject1 = new e.a.a.a();
      localObject2 = str + "btn_info.";
      ((e.a.a.a)localObject1).NOX = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((e.a.a.a)localObject1).NOY = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((e.a.a.a)localObject1).NOZ = bt.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((e.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((e.a.a.a)localObject1).GAg = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((e.a.a.a)localObject1).NPa = new e.a.a.g();
      ((e.a.a.a)localObject1).NPa.HcE = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((e.a.a.a)localObject1).NPa.HcF = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((e.a.a.a)localObject1).NPa.HcG = bt.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!bt.isNullOrNil(((e.a.a.a)localObject1).NOX)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).url)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).GAg)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).NPa.HcE)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).NPa.HcF))) {
        localc.GeX = ((e.a.a.a)localObject1);
      }
      localc.NPg = bt.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.NPh = bt.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.NPj = ((String)paramMap.get(str + "background_img_whole"));
      localc.GeV = new LinkedList();
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
      ((i)localObject2).wMR = ((String)paramMap.get((String)localObject1 + "logo"));
      ((i)localObject2).NPI = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((i)localObject2).NPJ = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((i)localObject2).NPK = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((i)localObject2).NPL = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((i)localObject2).NPM = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!bt.isNullOrNil(((i)localObject2).wMR)) || (!bt.isNullOrNil(((i)localObject2).NPI)) || (!bt.isNullOrNil(((i)localObject2).NPJ)) || (!bt.isNullOrNil(((i)localObject2).NPK)) || (!bt.isNullOrNil(((i)localObject2).NPL)) || (!bt.isNullOrNil(((i)localObject2).NPM))) {
        localc.GeV.add(localObject2);
      }
      if ((bt.isNullOrNil(((i)localObject2).NPI)) || (bt.isNullOrNil(((i)localObject2).NPJ))) {
        break label1125;
      }
      paramInt += 1;
      break label713;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1125:
    localc.NPi = new f();
    localObject1 = str + "layer_info.";
    localc.NPi.NPw = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.NPi.NPx = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.NPi.NPy = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.NPi.NPz = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.NPi.NPA = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.NPi.NPB = bt.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.NPi.NPC = new e.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.NPi.NPC.NOX = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.NPi.NPC.NOY = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.NPi.NPC.NOZ = bt.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.NPi.NPC.GAg = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.NPi.NPC.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.NPi.NPC.NPa = new e.a.a.g();
    localc.NPi.NPC.NPa.HcE = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.NPi.NPC.NPa.HcF = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.NPi.NPC.NPa.HcG = bt.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!bt.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.NPi.NPD = new com.tencent.mm.bx.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!bt.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.NPi.FNV = new com.tencent.mm.bx.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new e.a.a.b();
    String str = str + "draw_lottery_info.";
    ((e.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((e.a.a.b)localObject1).NPb = ((String)paramMap.get(str + "animation_wording"));
    ((e.a.a.b)localObject1).NPc = ((String)paramMap.get(str + "animation_wording_color"));
    ((e.a.a.b)localObject1).HEW = bt.getInt((String)paramMap.get(str + "op_type"), 0);
    ((e.a.a.b)localObject1).NPd = ((String)paramMap.get(str + "after_animation_wording"));
    ((e.a.a.b)localObject1).NPe = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((e.a.a.b)localObject1).NPa = new e.a.a.g();
    ((e.a.a.b)localObject1).NPa.HcE = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((e.a.a.b)localObject1).NPa.HcF = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((e.a.a.b)localObject1).NPa.HcG = bt.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!bt.isNullOrNil(((e.a.a.b)localObject1).url)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).NPb)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).NPc)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).NPa.HcE)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).NPa.HcF))) {
      localc.NPk = ((e.a.a.b)localObject1);
    }
    AppMethodBeat.o(66581);
    return localc;
    label2417:
    AppMethodBeat.o(66581);
    return null;
  }
  
  private static String dxA()
  {
    AppMethodBeat.i(66605);
    k.dwq();
    String str = k.Mi(196616);
    AppMethodBeat.o(66605);
    return str;
  }
  
  public static boolean dxB()
  {
    int j = 0;
    AppMethodBeat.i(66608);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGH, 0) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.WalletOfflineUtil", "pass same md5 case");
      AppMethodBeat.o(66608);
      return true;
    }
    ArrayList localArrayList = t.eFy().un(true);
    Object localObject = atL(dxy());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size()))
    {
      AppMethodBeat.o(66608);
      return false;
    }
    Collections.sort((List)localObject, wBG);
    Collections.sort(localArrayList, wBF);
    StringBuilder localStringBuilder = new StringBuilder();
    i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a)((LinkedList)localObject).get(i)).wBI);
      i += 1;
    }
    localObject = new StringBuilder();
    i = j;
    while (i < localArrayList.size())
    {
      ((StringBuilder)localObject).append(((Bankcard)localArrayList.get(i)).field_bindSerial);
      i += 1;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.ai.ee(localStringBuilder.toString()).equals(com.tencent.mm.sdk.platformtools.ai.ee(((StringBuilder)localObject).toString()));
    AppMethodBeat.o(66608);
    return bool;
  }
  
  private static String dxC()
  {
    AppMethodBeat.i(66609);
    if (TextUtils.isEmpty(wBy))
    {
      k.dwq();
      str = k.Mi(196615);
      wBy = str;
      AppMethodBeat.o(66609);
      return str;
    }
    String str = wBy;
    AppMethodBeat.o(66609);
    return str;
  }
  
  public static int dxD()
  {
    AppMethodBeat.i(66613);
    k.dwq();
    String str = k.Mi(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66613);
      return 0;
    }
    int i = bt.getInt(str, 0);
    AppMethodBeat.o(66613);
    return i;
  }
  
  public static boolean dxE()
  {
    AppMethodBeat.i(66614);
    String str = dxr();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(66614);
      return false;
    }
    long l1 = dxD();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(66614);
      return true;
    }
    AppMethodBeat.o(66614);
    return false;
  }
  
  public static String dxF()
  {
    AppMethodBeat.i(66619);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izy, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66619);
      return localObject;
    }
    AppMethodBeat.o(66619);
    return null;
  }
  
  public static String dxG()
  {
    AppMethodBeat.i(66621);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAx, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66621);
      return localObject;
    }
    AppMethodBeat.o(66621);
    return null;
  }
  
  public static int dxH()
  {
    AppMethodBeat.i(66623);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAy, null);
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
  
  public static String dxI()
  {
    AppMethodBeat.i(66625);
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAz, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66625);
      return localObject;
    }
    AppMethodBeat.o(66625);
    return null;
  }
  
  public static boolean dxJ()
  {
    AppMethodBeat.i(66627);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.d.aDs().wz("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).foF();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        ad.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.d.aDs().wz("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).foF();
      bool1 = bool2;
      if (((Map)localObject).containsKey("open"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("open"))) {
          bool1 = true;
        }
      }
    }
    ad.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(66627);
    return bool1;
  }
  
  public static int dxK()
  {
    return k.wxH;
  }
  
  public static boolean dxi()
  {
    AppMethodBeat.i(66558);
    k.dwq();
    String str = k.Mi(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66558);
      return true;
    }
    AppMethodBeat.o(66558);
    return false;
  }
  
  public static boolean dxj()
  {
    AppMethodBeat.i(66559);
    k.dwq();
    String str = k.Mi(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66559);
      return true;
    }
    AppMethodBeat.o(66559);
    return false;
  }
  
  @Deprecated
  public static Bankcard dxk()
  {
    AppMethodBeat.i(66560);
    t.eFy();
    Object localObject2 = an.eGF();
    ad.i("MicroMsg.WalletPayOrderMgr", "step 1 getSelectedBindBankCard %s", new Object[] { localObject2 });
    Object localObject3 = t.eFy();
    Object localObject1;
    if (((an)localObject3).DaR == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label508;
      }
      localObject1 = t.eFy().un(true);
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
          ad.i("MicroMsg.WalletPayOrderMgr", "step 2 micropay: %s, forbidword: %s", new Object[] { Boolean.valueOf(((Bankcard)localObject3).field_support_micropay), ((Bankcard)localObject3).field_forbidWord });
          if (((Bankcard)localObject3).field_support_micropay)
          {
            AppMethodBeat.o(66560);
            return localObject3;
            localObject1 = new ArrayList();
            if ((((an)localObject3).CzB != null) && (!((an)localObject3).eGc())) {
              ((ArrayList)localObject1).add(((an)localObject3).CzB);
            }
            if ((((an)localObject3).Dba != null) && (!((an)localObject3).eGc())) {
              ((ArrayList)localObject1).add(((an)localObject3).Dba);
            }
            if (((an)localObject3).DaR.size() > 0)
            {
              localObject3 = ((an)localObject3).DaR.iterator();
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
      ad.i("MicroMsg.WalletPayOrderMgr", "step 3 clear default bindserial");
      t.eFy();
      an.aEx("");
      t.eFy();
      localObject2 = an.eGL();
      if ((localObject2 != null) && (bt.isNullOrNil(((Bankcard)localObject2).field_forbidWord)))
      {
        ad.i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject2;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (Bankcard)((List)localObject1).get(i);
        if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (!((Bankcard)localObject2).eER()))
        {
          ad.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
          AppMethodBeat.o(66560);
          return localObject2;
        }
        i += 1;
      }
      localObject1 = t.eFy().CzB;
      if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay))
      {
        ad.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject1;
      }
      localObject1 = t.eFy().Dba;
      if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay) && (bt.isNullOrNil(((Bankcard)localObject1).field_forbidWord)))
      {
        ad.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject1;
      }
      AppMethodBeat.o(66560);
      return null;
    }
  }
  
  public static Bankcard dxl()
  {
    AppMethodBeat.i(66561);
    Object localObject = dxk();
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (bt.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(66561);
      return localObject;
    }
    localObject = t.eFy().un(true);
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
  
  public static Bankcard dxm()
  {
    AppMethodBeat.i(66562);
    t.eFy();
    Bankcard localBankcard = an.eGL();
    AppMethodBeat.o(66562);
    return localBankcard;
  }
  
  public static int dxn()
  {
    AppMethodBeat.i(66563);
    int i = t.eFy().un(true).size();
    AppMethodBeat.o(66563);
    return i;
  }
  
  public static List<Bankcard> dxo()
  {
    AppMethodBeat.i(66565);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = t.eFy().eGx();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localArrayList1.add((Bankcard)localArrayList2.get(i));
      i += 1;
    }
    ad.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66565);
    return localArrayList1;
  }
  
  public static int dxp()
  {
    AppMethodBeat.i(66566);
    k.dwq();
    String str = k.Mi(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66566);
      return 0;
    }
    int i = bt.getInt(str, 0);
    AppMethodBeat.o(66566);
    return i;
  }
  
  private static int dxq()
  {
    int j = 0;
    AppMethodBeat.i(66567);
    k.dwq();
    String str = k.Mi(196640);
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
      i = bt.getInt(str, 0);
      break;
      label62:
      i = 20000;
    }
  }
  
  public static String dxr()
  {
    AppMethodBeat.i(66570);
    k.dwq();
    String str = k.Mi(196632);
    AppMethodBeat.o(66570);
    return str;
  }
  
  public static String dxs()
  {
    AppMethodBeat.i(66571);
    k.dwq();
    String str = k.Mi(196631);
    AppMethodBeat.o(66571);
    return str;
  }
  
  public static String dxt()
  {
    AppMethodBeat.i(66576);
    t.eFy();
    String str = an.eGF();
    AppMethodBeat.o(66576);
    return str;
  }
  
  public static void dxu()
  {
    AppMethodBeat.i(66578);
    ad.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.dwq();
    k.bz(196630, "0");
    k.dwq();
    k.bz(196626, "");
    k.dwq();
    k.bz(196627, "");
    k.dwq();
    k.bz(196628, "");
    k.dwq();
    k.bz(196617, "");
    k.dwq();
    k.bz(196632, "");
    k.dwq();
    k.bz(196641, "");
    k.dwq();
    k.bz(196647, "");
    k.dwq();
    k.bz(196649, "");
    s("", "", "", "");
    Ms(0);
    k.dwq();
    k.bz(196629, "0");
    atI("");
    k.dwq();
    k.dwr().wyJ = null;
    k.dwq();
    k.dwt();
    k.dwq();
    String str = k.Mi(196617);
    com.tencent.mm.wallet_core.c.b.fRq();
    com.tencent.mm.wallet_core.c.b.clearToken(str);
    atN("");
    atK("");
    AppMethodBeat.o(66578);
  }
  
  public static void dxv()
  {
    AppMethodBeat.i(66593);
    k.dwq();
    k.bz(196643, "1");
    AppMethodBeat.o(66593);
  }
  
  public static int dxw()
  {
    AppMethodBeat.i(66595);
    k.dwq();
    String str = k.Mi(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66595);
      return 0;
    }
    int i = bt.getInt(str, 0);
    AppMethodBeat.o(66595);
    return i;
  }
  
  public static String dxx()
  {
    AppMethodBeat.i(66598);
    if (!TextUtils.isEmpty(wBu))
    {
      str = wBu;
      AppMethodBeat.o(66598);
      return str;
    }
    dxz();
    if (TextUtils.isEmpty(wBu)) {
      ad.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = wBu;
    AppMethodBeat.o(66598);
    return str;
  }
  
  public static String dxy()
  {
    AppMethodBeat.i(66599);
    if (!TextUtils.isEmpty(wBw))
    {
      str = wBw;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(wBw))
    {
      k.dwq();
      str = k.Mi(196656);
      wBw = str;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(wBw)) {
      ad.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = wBw;
    AppMethodBeat.o(66599);
    return str;
  }
  
  private static void dxz()
  {
    AppMethodBeat.i(66601);
    com.tencent.mm.kernel.g.ajB().gAO.a(new bo(new bo.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66555);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFc() == null))
        {
          ad.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
          AppMethodBeat.o(66555);
          return;
        }
        byte[] arrayOfByte = paramAnonymouse.aFc().Dm("offline_token");
        if (arrayOfByte != null) {
          a.fc(new String(arrayOfByte));
        }
        arrayOfByte = paramAnonymouse.aFc().Dm("offline_token_V2");
        if (arrayOfByte != null) {
          a.wBu = new String(arrayOfByte);
        }
        paramAnonymouse = paramAnonymouse.aFc().Dm("offline_key_list");
        if (paramAnonymouse != null) {
          a.wBx = new String(paramAnonymouse);
        }
        AppMethodBeat.o(66555);
      }
    }), 0);
    AppMethodBeat.o(66601);
  }
  
  public static void e(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66592);
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(2131765981), paramActivity.getString(2131755691), new DialogInterface.OnClickListener()new a.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66552);
        a.dxu();
        a.ax(this.val$activity);
        this.val$activity.finish();
        AppMethodBeat.o(66552);
      }
    }, new a.2(paramActivity));
    AppMethodBeat.o(66592);
  }
  
  public static void fW(Context paramContext)
  {
    AppMethodBeat.i(66573);
    String str = ac.fks();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(2131764607);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.e.aW(paramContext, str);
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
    if (ay.isConnected(paramContext)) {
      if (ay.isWifi(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66626);
      return i;
      if (ay.is2G(paramContext))
      {
        i = 2;
      }
      else if (ay.is3G(paramContext))
      {
        i = 3;
      }
      else if (ay.is4G(paramContext))
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
    if (!TextUtils.isEmpty(wBt))
    {
      str = wBt;
      AppMethodBeat.o(66596);
      return str;
    }
    dxz();
    if (TextUtils.isEmpty(wBt)) {
      ad.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = wBt;
    AppMethodBeat.o(66596);
    return str;
  }
  
  public static String getTokenPin()
  {
    AppMethodBeat.i(66604);
    k.dwq();
    String str = k.Mi(196647);
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
    a(paramActivity, "create", "", dxq(), paramInt);
    AppMethodBeat.o(66591);
  }
  
  public static List<Bankcard> pm(boolean paramBoolean)
  {
    AppMethodBeat.i(66564);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = t.eFy().uo(true);
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
    ad.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66564);
    return localArrayList1;
  }
  
  public static void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(66597);
    wBt = paramString1;
    wBu = paramString2;
    wBw = paramString3;
    wBx = paramString4;
    atK(wBw);
    com.tencent.mm.kernel.g.ajB().gAO.a(new bo(new bo.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66554);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFc() == null))
        {
          AppMethodBeat.o(66554);
          return;
        }
        if (a.wBt != null) {
          paramAnonymouse.aFc().i("offline_token", a.wBt.getBytes());
        }
        if (a.wBu != null) {
          paramAnonymouse.aFc().i("offline_token_V2", a.wBu.getBytes());
        }
        if (a.wBx != null) {
          paramAnonymouse.aFc().i("offline_key_list", a.wBx.getBytes());
        }
        AppMethodBeat.o(66554);
      }
    }), 0);
    AppMethodBeat.o(66597);
  }
  
  private static LinkedList<a> z(JSONArray paramJSONArray)
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
        locala.wBH = localJSONObject.optInt("card_id");
        locala.dkR = localJSONObject.optString("bank_type");
        locala.wBI = localJSONObject.optString("bind_serial");
        locala.wBJ = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(66603);
    return localLinkedList;
  }
  
  public static final class a
  {
    public String dkR;
    public int wBH;
    public String wBI;
    public String wBJ;
  }
  
  public static final class b
  {
    public String dkR;
    public String pkr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */