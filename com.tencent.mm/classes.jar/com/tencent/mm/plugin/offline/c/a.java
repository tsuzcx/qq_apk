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
import com.tencent.mm.ai.m;
import com.tencent.mm.model.bk;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
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
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import d.a.a.i;
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
  public static String kkW;
  private static String pob;
  public static String poc;
  public static int pod;
  public static String poe;
  public static String pof;
  public static String pog;
  public static int poh;
  public static int poi;
  public static long poj;
  public static boolean pok;
  public static String pol;
  public static String pom;
  private static Comparator<Bankcard> pon;
  private static Comparator<a.a> poo;
  
  static
  {
    AppMethodBeat.i(43721);
    pob = "";
    poc = "";
    pod = 1;
    poe = "";
    pof = "";
    pog = "";
    poh = 1;
    poi = 0;
    poj = 0L;
    pok = false;
    kkW = "";
    pol = "";
    pom = "";
    pon = new a.5();
    poo = new a.6();
    AppMethodBeat.o(43721);
  }
  
  public static void Bc(int paramInt)
  {
    AppMethodBeat.i(43662);
    k.bYF();
    k.aT(196640, String.valueOf(paramInt));
    AppMethodBeat.o(43662);
  }
  
  public static void Bd(int paramInt)
  {
    AppMethodBeat.i(43663);
    k.bYF();
    k.aT(196642, String.valueOf(paramInt));
    AppMethodBeat.o(43663);
  }
  
  public static void Be(int paramInt)
  {
    AppMethodBeat.i(43686);
    k.bYF();
    k.aT(196644, String.valueOf(paramInt));
    AppMethodBeat.o(43686);
  }
  
  public static void Bf(int paramInt)
  {
    AppMethodBeat.i(43714);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHu, Integer.valueOf(i));
    AppMethodBeat.o(43714);
  }
  
  public static Orders T(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43673);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.ppb = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.ppc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.ppd = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.ppe = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.cnJ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.kNS = (bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.ppi = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.ppj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.ppn = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.ppu = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.ppl = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.ppp = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.ppq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.poT = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.ujM = (bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).ppq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.ujK;
    localCommodity.ujN = ((Orders.Promotions)localObject1).ppq;
    ((Orders.Promotions)localObject1).pvi = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.ujc = j;
    localCommodity.ujQ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.ujR = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.ujS = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!bo.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.ujW = true;
      localCommodity.ujV.add(localObject1);
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
        label762:
        if (!bo.isNullOrNil(str1)) {
          break label2111;
        }
        ab.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.ujX.text = ((String)localObject1);
      localCommodity.ujX.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil(str1)) && (!bo.isNullOrNil((String)localObject2)) && (!bo.isNullOrNil(str2)))
      {
        localCommodity.ujT = new Orders.RecommendTinyAppInfo();
        localCommodity.ujT.uaK = ((String)localObject1);
        localCommodity.ujT.uiQ = str1;
        localCommodity.ujT.uiR = ((String)localObject2);
        localCommodity.ujT.ugl = str2;
        localCommodity.ujT.uaL = str3;
        localCommodity.ujT.uiS = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.ujT.uks = bo.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.ujT.ukt = bo.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.ujT.ukv = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.ujT.ukw = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.ujT.ukx = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.ujT.uku = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.ujT.uiT = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localOrders.ujl = new ArrayList();
      localOrders.ujl.add(localCommodity);
      localOrders.ujv = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.ujw = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.uje = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.ujc = j;
      localOrders.cnI = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.ujM = (bo.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
      if (TextUtils.isEmpty((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
        break label2368;
      }
      i = 0;
      label1344:
      if (i != 0) {
        break label2312;
      }
    }
    label2312:
    for (localObject1 = "";; localObject1 = String.valueOf(i))
    {
      str1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".favor_desc";
      localObject1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".payment_amount";
      if ((TextUtils.isEmpty((CharSequence)paramMap.get(str1))) || (TextUtils.isEmpty((CharSequence)paramMap.get(localObject1)))) {
        break label2320;
      }
      localObject2 = new Orders.DiscountInfo();
      ((Orders.DiscountInfo)localObject2).qiO = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).ukh = bo.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.ujP.add(localObject2);
      i += 1;
      break label1344;
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
      break label762;
      label2111:
      localPromotions.pvi = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.uiO = str2;
      localPromotions.type = Orders.ujL;
      localPromotions.uki = bo.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.ukk = bo.getInt(str5, 0);
      localPromotions.ubC = bo.getLong(str6, 0L);
      localPromotions.uiL = bo.getInt(str7, 0);
      localPromotions.ukl = bo.getInt(str8, 0);
      localPromotions.uiM = bo.getInt(str9, 0);
      localPromotions.ukm = str10;
      localPromotions.ukn = str11;
      localPromotions.uko = str12;
      localPromotions.uiN = bo.getLong(str13, 0L);
      localPromotions.ukp = bo.getInt(str14, 0);
      localPromotions.ukq = str15;
      localPromotions.uWi = str16;
      localObject1 = c(paramMap, i);
      if (localObject1 != null) {
        localPromotions.ukr = ((d.a.a.c)localObject1);
      }
      localCommodity.ujV.add(localPromotions);
      i += 1;
      break;
    }
    label2320:
    ab.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    for (;;)
    {
      AppMethodBeat.o(43673);
      return localOrders;
      label2368:
      ab.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    }
  }
  
  public static void WA(String paramString)
  {
    AppMethodBeat.i(43712);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHt, paramString);
    AppMethodBeat.o(43712);
  }
  
  public static void WB(String paramString)
  {
    AppMethodBeat.i(43716);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHv, paramString);
    AppMethodBeat.o(43716);
  }
  
  public static void WC(String paramString)
  {
    AppMethodBeat.i(43720);
    ab.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, true);
    if (paramString == null)
    {
      ab.w("MicroMsg.WalletOfflineUtil", "can not find app info");
      AppMethodBeat.o(43720);
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = new JumpToOfflinePay.Resp();
    ((JumpToOfflinePay.Resp)localObject).errCode = 0;
    ((JumpToOfflinePay.Resp)localObject).toBundle(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramString.field_packageName;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    com.tencent.mm.pluginsdk.model.app.p.aC(localBundle);
    com.tencent.mm.pluginsdk.model.app.p.aD(localBundle);
    MMessageActV2.send(ah.getContext(), (MMessageActV2.Args)localObject);
    AppMethodBeat.o(43720);
  }
  
  public static void Wq(String paramString)
  {
    AppMethodBeat.i(43666);
    k.bYF();
    k.aT(196631, paramString);
    AppMethodBeat.o(43666);
  }
  
  public static void Wr(String paramString)
  {
    AppMethodBeat.i(43670);
    t.cTN();
    am.afo(paramString);
    AppMethodBeat.o(43670);
  }
  
  public static void Ws(String paramString)
  {
    AppMethodBeat.i(43692);
    k.bYF();
    k.aT(196656, paramString);
    poe = paramString;
    AppMethodBeat.o(43692);
  }
  
  public static LinkedList<a.a> Wt(String paramString)
  {
    AppMethodBeat.i(43694);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(43694);
      return null;
    }
    try
    {
      paramString = w(new JSONArray(paramString));
      AppMethodBeat.o(43694);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(43694);
    }
    return null;
  }
  
  public static void Wu(String paramString)
  {
    AppMethodBeat.i(43698);
    k.bYF();
    k.aT(196616, paramString);
    AppMethodBeat.o(43698);
  }
  
  public static void Wv(String paramString)
  {
    AppMethodBeat.i(43702);
    k.bYF();
    k.aT(196615, paramString);
    pog = paramString;
    AppMethodBeat.o(43702);
  }
  
  private static LinkedList<a.b> Ww(String paramString)
  {
    AppMethodBeat.i(43703);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(43703);
      return null;
    }
    try
    {
      paramString = x(new JSONArray(paramString));
      AppMethodBeat.o(43703);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(43703);
    }
    return null;
  }
  
  public static String Wx(String paramString)
  {
    AppMethodBeat.i(43707);
    LinkedList localLinkedList = Ww(bZQ());
    if (localLinkedList == null)
    {
      AppMethodBeat.o(43707);
      return "";
    }
    int i = 0;
    a.b localb;
    if (i < localLinkedList.size())
    {
      localb = (a.b)localLinkedList.get(i);
      if ((localb == null) || (!paramString.equals(localb.poq))) {}
    }
    for (paramString = localb.kWy;; paramString = "")
    {
      AppMethodBeat.o(43707);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String Wy(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(43708);
    Object localObject = Wt(bZL());
    LinkedList localLinkedList = Ww(bZQ());
    if ((localObject == null) || (localLinkedList == null) || (((LinkedList)localObject).size() == 0) || (localLinkedList.size() == 0))
    {
      ab.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
      AppMethodBeat.o(43708);
      return "";
    }
    int i = 0;
    a.a locala;
    if (i < ((LinkedList)localObject).size())
    {
      locala = (a.a)((LinkedList)localObject).get(i);
      if ((locala == null) || (!paramString.equals(locala.por))) {}
    }
    for (paramString = locala.poq;; paramString = "")
    {
      if (TextUtils.isEmpty(paramString))
      {
        ab.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
        AppMethodBeat.o(43708);
        return "";
        i += 1;
        break;
      }
      i = j;
      if (i < localLinkedList.size())
      {
        localObject = (a.b)localLinkedList.get(i);
        if ((localObject == null) || (!paramString.equals(((a.b)localObject).poq))) {}
      }
      for (paramString = ((a.b)localObject).kWy;; paramString = "")
      {
        AppMethodBeat.o(43708);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void Wz(String paramString)
  {
    AppMethodBeat.i(43710);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGH, paramString);
    AppMethodBeat.o(43710);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43678);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.cCE = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!t.cTN().cUl())
    {
      if (t.cTN().cUn())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(43678);
        return;
      }
      if (t.cTN().cUm())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(43678);
        return;
      }
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.c.class, localBundle);
    AppMethodBeat.o(43678);
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    AppMethodBeat.i(43672);
    ab.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.pme == null))
    {
      ab.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(43672);
      return;
    }
    if (!bZx())
    {
      AppMethodBeat.o(43672);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.pme);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.cMu != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.a(paramf.cMu.cLV, paramf.cMu.cLW, paramf.cMu.cLX, paramf.cMu.cLY, paramf.cMu.cLZ, 8);
      localBundle.putParcelable("key_realname_guide_helper", localRealnameGuideHelper);
    }
    if ((paramActivity instanceof WalletOfflineCoinPurseUI))
    {
      paramf = paramActivity.getIntent();
      localBundle.putString("key_appid", paramf.getStringExtra("key_appid"));
      localBundle.putInt("key_from_scene", paramf.getIntExtra("key_from_scene", 0));
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, j.class, localBundle);
    AppMethodBeat.o(43672);
  }
  
  public static void a(Activity paramActivity, String paramString, m paramm)
  {
    AppMethodBeat.i(43676);
    ab.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.WalletOfflineUtil", "transid == null");
      AppMethodBeat.o(43676);
      return;
    }
    if (!bZx())
    {
      AppMethodBeat.o(43676);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramm instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramm = ((com.tencent.mm.plugin.offline.a.e)paramm).plg;
      if (paramm != null) {
        localBundle.putParcelable("key_realname_guide_helper", paramm);
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
    AppMethodBeat.o(43676);
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43680);
    Bundle localBundle = new Bundle();
    localBundle.putString("oper", paramString1);
    localBundle.putInt("offline_chg_fee", paramInt1);
    localBundle.putString("pwd_tips", paramString2);
    if (paramInt2 >= 0) {
      localBundle.putInt("offline_from_scene", paramInt2);
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.h.class, localBundle);
    AppMethodBeat.o(43680);
  }
  
  private static void a(Orders paramOrders, Map<String, String> paramMap)
  {
    AppMethodBeat.i(43675);
    if (paramMap != null)
    {
      paramOrders.ujx = bo.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.ujz = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.nmk = ((String)paramMap.get(str + "name_color"));
          localShowInfo.ukA = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.ukB = bo.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.ukC = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.ukD = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.ukE = ((String)paramMap.get(str + "link_url"));
          localShowInfo.ukF = bo.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!bo.isNullOrNil(localShowInfo.name)) || (!bo.isNullOrNil(localShowInfo.value))) {
            paramOrders.ujz.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(43675);
  }
  
  private static void aL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(43668);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(43668);
  }
  
  public static void aa(Activity paramActivity)
  {
    AppMethodBeat.i(43681);
    a(paramActivity, "freeze", paramActivity.getString(2131305744), 0, -1);
    AppMethodBeat.o(43681);
  }
  
  public static void ab(Activity paramActivity)
  {
    AppMethodBeat.i(43682);
    i(paramActivity, -1);
    AppMethodBeat.o(43682);
  }
  
  public static void ac(Activity paramActivity)
  {
    AppMethodBeat.i(43699);
    com.tencent.mm.ui.base.h.bO(paramActivity, paramActivity.getResources().getString(2131305742));
    if (!TextUtils.isEmpty(bZO())) {
      aL(paramActivity, bZO());
    }
    AppMethodBeat.o(43699);
  }
  
  public static Bankcard bZA()
  {
    AppMethodBeat.i(43656);
    t.cTN();
    Bankcard localBankcard = am.cUV();
    AppMethodBeat.o(43656);
    return localBankcard;
  }
  
  public static int bZB()
  {
    AppMethodBeat.i(43657);
    int i = t.cTN().nH(true).size();
    AppMethodBeat.o(43657);
    return i;
  }
  
  public static List<Bankcard> bZC()
  {
    AppMethodBeat.i(43659);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = t.cTN().cUI();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localArrayList1.add((Bankcard)localArrayList2.get(i));
      i += 1;
    }
    ab.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(43659);
    return localArrayList1;
  }
  
  public static int bZD()
  {
    AppMethodBeat.i(43660);
    k.bYF();
    String str = k.AY(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(43660);
      return 0;
    }
    int i = Integer.valueOf(str).intValue();
    AppMethodBeat.o(43660);
    return i;
  }
  
  private static int bZE()
  {
    AppMethodBeat.i(43661);
    k.bYF();
    String str = k.AY(196640);
    int i;
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      i = 0;
      if (i <= 0) {
        break label60;
      }
      i *= 100;
    }
    for (;;)
    {
      AppMethodBeat.o(43661);
      return i;
      i = Integer.valueOf(str).intValue();
      break;
      label60:
      i = 20000;
    }
  }
  
  public static String bZF()
  {
    AppMethodBeat.i(43664);
    k.bYF();
    String str = k.AY(196632);
    AppMethodBeat.o(43664);
    return str;
  }
  
  public static String bZG()
  {
    AppMethodBeat.i(43665);
    k.bYF();
    String str = k.AY(196631);
    AppMethodBeat.o(43665);
    return str;
  }
  
  public static void bZH()
  {
    AppMethodBeat.i(43671);
    ab.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.bYF();
    k.aT(196630, "0");
    k.bYF();
    k.aT(196626, "");
    k.bYF();
    k.aT(196627, "");
    k.bYF();
    k.aT(196628, "");
    k.bYF();
    k.aT(196617, "");
    k.bYF();
    k.aT(196632, "");
    k.bYF();
    k.aT(196641, "");
    k.bYF();
    k.aT(196647, "");
    k.bYF();
    k.aT(196649, "");
    r("", "", "", "");
    k.bYF();
    k.aT(196629, "0");
    Wq("");
    k.bYF();
    k.bYG().plP = null;
    k.bYF();
    k.bYI();
    k.bYF();
    String str = k.AY(196617);
    com.tencent.mm.wallet_core.c.b.dSi();
    com.tencent.mm.wallet_core.c.b.clearToken(str);
    Wv("");
    Ws("");
    AppMethodBeat.o(43671);
  }
  
  public static void bZI()
  {
    AppMethodBeat.i(43685);
    k.bYF();
    k.aT(196643, "1");
    AppMethodBeat.o(43685);
  }
  
  public static int bZJ()
  {
    AppMethodBeat.i(43687);
    k.bYF();
    String str = k.AY(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(43687);
      return 0;
    }
    int i = Integer.valueOf(str).intValue();
    AppMethodBeat.o(43687);
    return i;
  }
  
  public static String bZK()
  {
    AppMethodBeat.i(43690);
    if (!TextUtils.isEmpty(poc))
    {
      str = poc;
      AppMethodBeat.o(43690);
      return str;
    }
    bZM();
    if (TextUtils.isEmpty(poc)) {
      ab.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = poc;
    AppMethodBeat.o(43690);
    return str;
  }
  
  public static String bZL()
  {
    AppMethodBeat.i(43691);
    if (!TextUtils.isEmpty(poe))
    {
      str = poe;
      AppMethodBeat.o(43691);
      return str;
    }
    if (TextUtils.isEmpty(poe))
    {
      k.bYF();
      str = k.AY(196656);
      poe = str;
      AppMethodBeat.o(43691);
      return str;
    }
    if (TextUtils.isEmpty(poe)) {
      ab.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = poe;
    AppMethodBeat.o(43691);
    return str;
  }
  
  private static void bZM()
  {
    AppMethodBeat.i(43693);
    com.tencent.mm.kernel.g.RK().eHt.a(new bk(new a.4()), 0);
    AppMethodBeat.o(43693);
  }
  
  public static String bZN()
  {
    AppMethodBeat.i(43696);
    k.bYF();
    String str = k.AY(196647);
    AppMethodBeat.o(43696);
    return str;
  }
  
  private static String bZO()
  {
    AppMethodBeat.i(43697);
    k.bYF();
    String str = k.AY(196616);
    AppMethodBeat.o(43697);
    return str;
  }
  
  public static boolean bZP()
  {
    int j = 0;
    AppMethodBeat.i(43700);
    ArrayList localArrayList = t.cTN().nH(true);
    Object localObject = Wt(bZL());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size()))
    {
      AppMethodBeat.o(43700);
      return false;
    }
    Collections.sort((List)localObject, poo);
    Collections.sort(localArrayList, pon);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a.a)((LinkedList)localObject).get(i)).por);
      i += 1;
    }
    localObject = new StringBuilder();
    i = j;
    while (i < localArrayList.size())
    {
      ((StringBuilder)localObject).append(((Bankcard)localArrayList.get(i)).field_bindSerial);
      i += 1;
    }
    boolean bool = ag.cE(localStringBuilder.toString()).equals(ag.cE(((StringBuilder)localObject).toString()));
    AppMethodBeat.o(43700);
    return bool;
  }
  
  private static String bZQ()
  {
    AppMethodBeat.i(43701);
    if (TextUtils.isEmpty(pog))
    {
      k.bYF();
      str = k.AY(196615);
      pog = str;
      AppMethodBeat.o(43701);
      return str;
    }
    String str = pog;
    AppMethodBeat.o(43701);
    return str;
  }
  
  public static int bZR()
  {
    AppMethodBeat.i(43705);
    k.bYF();
    String str = k.AY(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(43705);
      return 0;
    }
    int i = Integer.valueOf(str).intValue();
    AppMethodBeat.o(43705);
    return i;
  }
  
  public static boolean bZS()
  {
    AppMethodBeat.i(43706);
    String str = bZF();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(43706);
      return false;
    }
    long l1 = bZR();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(43706);
      return true;
    }
    AppMethodBeat.o(43706);
    return false;
  }
  
  public static String bZT()
  {
    AppMethodBeat.i(43711);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGH, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(43711);
      return localObject;
    }
    AppMethodBeat.o(43711);
    return null;
  }
  
  public static String bZU()
  {
    AppMethodBeat.i(43713);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHt, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(43713);
      return localObject;
    }
    AppMethodBeat.o(43713);
    return null;
  }
  
  public static int bZV()
  {
    AppMethodBeat.i(43715);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHu, null);
    if (localObject != null) {}
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      AppMethodBeat.o(43715);
      return j;
    }
  }
  
  public static String bZW()
  {
    AppMethodBeat.i(43717);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHv, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(43717);
      return localObject;
    }
    AppMethodBeat.o(43717);
    return null;
  }
  
  public static boolean bZX()
  {
    AppMethodBeat.i(43719);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.c.abU().me("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).dvN();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        ab.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.c.abU().me("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).dvN();
      bool1 = bool2;
      if (((Map)localObject).containsKey("open"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("open"))) {
          bool1 = true;
        }
      }
    }
    ab.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(43719);
    return bool1;
  }
  
  public static boolean bZw()
  {
    AppMethodBeat.i(43652);
    k.bYF();
    String str = k.AY(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(43652);
      return true;
    }
    AppMethodBeat.o(43652);
    return false;
  }
  
  public static boolean bZx()
  {
    AppMethodBeat.i(43653);
    k.bYF();
    String str = k.AY(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(43653);
      return true;
    }
    AppMethodBeat.o(43653);
    return false;
  }
  
  @Deprecated
  public static Bankcard bZy()
  {
    AppMethodBeat.i(43654);
    t.cTN();
    com.tencent.mm.kernel.g.RM();
    Object localObject2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(196633, null);
    ab.i("MicroMsg.WalletPayOrderMgr", "step 1 getSelectedBindBankCard %s", new Object[] { localObject2 });
    Object localObject1 = t.cTN().nH(true);
    int i = 0;
    while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i < ((List)localObject1).size()))
    {
      Bankcard localBankcard = (Bankcard)((List)localObject1).get(i);
      if ((localBankcard != null) && (((String)localObject2).equals(localBankcard.field_bindSerial)))
      {
        ab.i("MicroMsg.WalletPayOrderMgr", "step 2 micropay: %s, forbidword: %s", new Object[] { Boolean.valueOf(localBankcard.field_support_micropay), localBankcard.field_forbidWord });
        if (localBankcard.field_support_micropay)
        {
          AppMethodBeat.o(43654);
          return localBankcard;
        }
      }
      i += 1;
    }
    ab.i("MicroMsg.WalletPayOrderMgr", "step 3 clear default bindserial");
    t.cTN();
    am.afo("");
    t.cTN();
    localObject2 = am.cUV();
    if ((localObject2 != null) && (bo.isNullOrNil(((Bankcard)localObject2).field_forbidWord)))
    {
      ab.i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
      AppMethodBeat.o(43654);
      return localObject2;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (Bankcard)((List)localObject1).get(i);
      if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (!((Bankcard)localObject2).cTf()))
      {
        ab.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
        AppMethodBeat.o(43654);
        return localObject2;
      }
      i += 1;
    }
    localObject1 = t.cTN().tOD;
    if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay))
    {
      ab.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
      AppMethodBeat.o(43654);
      return localObject1;
    }
    localObject1 = t.cTN().ulT;
    if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay) && (bo.isNullOrNil(((Bankcard)localObject1).field_forbidWord)))
    {
      ab.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
      AppMethodBeat.o(43654);
      return localObject1;
    }
    AppMethodBeat.o(43654);
    return null;
  }
  
  public static Bankcard bZz()
  {
    AppMethodBeat.i(43655);
    Object localObject = bZy();
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (bo.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(43655);
      return localObject;
    }
    localObject = t.cTN().nH(true);
    int i = 0;
    while (i < ((List)localObject).size())
    {
      Bankcard localBankcard = (Bankcard)((List)localObject).get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay))
      {
        AppMethodBeat.o(43655);
        return localBankcard;
      }
      i += 1;
    }
    AppMethodBeat.o(43655);
    return null;
  }
  
  private static d.a.a.c c(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(43674);
    d.a.a.c localc;
    if (paramInt == 0)
    {
      str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
      if (paramMap == null) {
        break label2380;
      }
      localc = new d.a.a.c();
      localc.CLp = bo.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.wPV = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.wRa = bo.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localObject1 = new d.a.a.a();
      localObject2 = str + "btn_info.";
      ((d.a.a.a)localObject1).CLh = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((d.a.a.a)localObject1).CLi = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((d.a.a.a)localObject1).CLj = bo.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((d.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((d.a.a.a)localObject1).xcU = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((d.a.a.a)localObject1).CLk = new d.a.a.g();
      ((d.a.a.a)localObject1).CLk.xzC = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((d.a.a.a)localObject1).CLk.xzD = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((d.a.a.a)localObject1).CLk.xzE = bo.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!bo.isNullOrNil(((d.a.a.a)localObject1).CLh)) || (!bo.isNullOrNil(((d.a.a.a)localObject1).url)) || (!bo.isNullOrNil(((d.a.a.a)localObject1).xcU)) || (!bo.isNullOrNil(((d.a.a.a)localObject1).CLk.xzC)) || (!bo.isNullOrNil(((d.a.a.a)localObject1).CLk.xzD))) {
        localc.wRb = ((d.a.a.a)localObject1);
      }
      localc.CLq = bo.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.CLr = bo.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.CLt = ((String)paramMap.get(str + "background_img_whole"));
      localc.wQZ = new LinkedList();
      paramInt = 0;
      label676:
      if (paramInt >= 255) {
        break label1088;
      }
      if (paramInt != 0) {
        break label1054;
      }
    }
    label1054:
    for (Object localObject1 = str + "single_exposure_info_list.record.";; localObject1 = str + "single_exposure_info_list.record" + paramInt + ".")
    {
      localObject2 = new i();
      ((i)localObject2).pvi = ((String)paramMap.get((String)localObject1 + "logo"));
      ((i)localObject2).CLT = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((i)localObject2).CLU = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((i)localObject2).CLV = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((i)localObject2).CLW = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((i)localObject2).CLX = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!bo.isNullOrNil(((i)localObject2).pvi)) || (!bo.isNullOrNil(((i)localObject2).CLT)) || (!bo.isNullOrNil(((i)localObject2).CLU)) || (!bo.isNullOrNil(((i)localObject2).CLV)) || (!bo.isNullOrNil(((i)localObject2).CLW)) || (!bo.isNullOrNil(((i)localObject2).CLX))) {
        localc.wQZ.add(localObject2);
      }
      if ((bo.isNullOrNil(((i)localObject2).CLT)) || (bo.isNullOrNil(((i)localObject2).CLU))) {
        break label1088;
      }
      paramInt += 1;
      break label676;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1088:
    localc.CLs = new d.a.a.f();
    localObject1 = str + "layer_info.";
    localc.CLs.CLG = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.CLs.CLH = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.CLs.CLI = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.CLs.CLJ = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.CLs.CLK = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.CLs.CLL = bo.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.CLs.CLM = new d.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.CLs.CLM.CLh = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.CLs.CLM.CLi = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.CLs.CLM.CLj = bo.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.CLs.CLM.xcU = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.CLs.CLM.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.CLs.CLM.CLk = new d.a.a.g();
    localc.CLs.CLM.CLk.xzC = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.CLs.CLM.CLk.xzD = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.CLs.CLM.CLk.xzE = bo.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!bo.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.CLs.CLN = new com.tencent.mm.bv.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!bo.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.CLs.CLO = new com.tencent.mm.bv.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new d.a.a.b();
    String str = str + "draw_lottery_info.";
    ((d.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((d.a.a.b)localObject1).CLl = ((String)paramMap.get(str + "animation_wording"));
    ((d.a.a.b)localObject1).CLm = ((String)paramMap.get(str + "animation_wording_color"));
    ((d.a.a.b)localObject1).xWC = bo.getInt((String)paramMap.get(str + "op_type"), 0);
    ((d.a.a.b)localObject1).CLn = ((String)paramMap.get(str + "after_animation_wording"));
    ((d.a.a.b)localObject1).CLo = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((d.a.a.b)localObject1).CLk = new d.a.a.g();
    ((d.a.a.b)localObject1).CLk.xzC = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((d.a.a.b)localObject1).CLk.xzD = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((d.a.a.b)localObject1).CLk.xzE = bo.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!bo.isNullOrNil(((d.a.a.b)localObject1).url)) || (!bo.isNullOrNil(((d.a.a.b)localObject1).CLl)) || (!bo.isNullOrNil(((d.a.a.b)localObject1).CLm)) || (!bo.isNullOrNil(((d.a.a.b)localObject1).CLk.xzC)) || (!bo.isNullOrNil(((d.a.a.b)localObject1).CLk.xzD))) {
      localc.CLu = ((d.a.a.b)localObject1);
    }
    AppMethodBeat.o(43674);
    return localc;
    label2380:
    AppMethodBeat.o(43674);
    return null;
  }
  
  public static void e(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(43684);
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(2131305761), paramActivity.getString(2131296888), new DialogInterface.OnClickListener()new a.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(43646);
        a.bZH();
        a.ab(this.val$activity);
        this.val$activity.finish();
        AppMethodBeat.o(43646);
      }
    }, new a.2(paramActivity));
    AppMethodBeat.o(43684);
  }
  
  public static boolean eD(Context paramContext)
  {
    AppMethodBeat.i(43709);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ab.d("MicroMsg.WalletOfflineUtil", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ab.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
        AppMethodBeat.o(43709);
        return false;
      }
    }
    if (((KeyguardManager)ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(43709);
      return false;
    }
    ab.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
    AppMethodBeat.o(43709);
    return true;
  }
  
  public static void eK(Context paramContext)
  {
    AppMethodBeat.i(43667);
    String str = aa.dsG();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(2131304461);
    }
    for (;;)
    {
      aL(paramContext, str);
      AppMethodBeat.o(43667);
      return;
      if ("zh_TW".equals(str)) {
        str = paramContext.getString(2131306246);
      } else if ("zh_HK".equals(str)) {
        str = paramContext.getString(2131306245);
      } else {
        str = paramContext.getResources().getString(2131306244);
      }
    }
  }
  
  public static void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(43677);
    a(paramActivity, paramInt, -1);
    AppMethodBeat.o(43677);
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(43718);
    int i;
    if (at.isConnected(paramContext)) {
      if (at.isWifi(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(43718);
      return i;
      if (at.is2G(paramContext))
      {
        i = 2;
      }
      else if (at.is3G(paramContext))
      {
        i = 3;
      }
      else if (at.is4G(paramContext))
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
    AppMethodBeat.i(43688);
    if (!TextUtils.isEmpty(pob))
    {
      str = pob;
      AppMethodBeat.o(43688);
      return str;
    }
    bZM();
    if (TextUtils.isEmpty(pob)) {
      ab.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = pob;
    AppMethodBeat.o(43688);
    return str;
  }
  
  public static void h(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(43679);
    a(paramActivity, "create", paramActivity.getString(2131305741), 0, paramInt);
    AppMethodBeat.o(43679);
  }
  
  public static void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(43683);
    a(paramActivity, "create", "", bZE(), paramInt);
    AppMethodBeat.o(43683);
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(43669);
    if (paramString == null)
    {
      AppMethodBeat.o(43669);
      return false;
    }
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(43669);
    return bool;
  }
  
  public static List<Bankcard> jX(boolean paramBoolean)
  {
    AppMethodBeat.i(43658);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = t.cTN().nI(true);
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
    ab.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(43658);
    return localArrayList1;
  }
  
  public static void r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(43689);
    pob = paramString1;
    poc = paramString2;
    poe = paramString3;
    pof = paramString4;
    Ws(poe);
    com.tencent.mm.kernel.g.RK().eHt.a(new bk(new a.3()), 0);
    AppMethodBeat.o(43689);
  }
  
  private static LinkedList<a.a> w(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(43695);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(43695);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (localJSONObject != null)
      {
        a.a locala = new a.a();
        locala.pop = localJSONObject.optInt("card_id");
        locala.poq = localJSONObject.optString("bank_type");
        locala.por = localJSONObject.optString("bind_serial");
        locala.pot = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(43695);
    return localLinkedList;
  }
  
  private static LinkedList<a.b> x(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(43704);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(43704);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (localJSONObject != null)
      {
        a.b localb = new a.b();
        localb.poq = localJSONObject.optString("bank_type");
        localb.kWy = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(43704);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */