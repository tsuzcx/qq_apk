package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.offline.a.u.g;
import com.tencent.mm.plugin.offline.a.u.i;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.FinderInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.LeadTailViewInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.ac;
import java.util.ArrayList;
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

public final class d
{
  private static String MDd;
  public static String MDe;
  public static int MDf;
  public static String MDg;
  public static String MDh;
  public static String MDi;
  public static int MDj;
  public static int MDk;
  public static int MDl;
  public static long MDm;
  public static boolean MDn;
  public static String MDo;
  public static String MDp;
  private static Comparator<Bankcard> MDq;
  private static Comparator<a> MDr;
  public static String wrg;
  
  static
  {
    AppMethodBeat.i(66629);
    MDd = "";
    MDe = "";
    MDf = 1;
    MDg = "";
    MDh = "";
    MDi = "";
    MDj = 0;
    MDk = 1;
    MDl = 0;
    MDm = 0L;
    MDn = false;
    wrg = "";
    MDo = "";
    MDp = "";
    MDq = new Comparator() {};
    MDr = new Comparator() {};
    AppMethodBeat.o(66629);
  }
  
  public static List<Bankcard> Am(boolean paramBoolean)
  {
    AppMethodBeat.i(66564);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.u.iiC().HK(true);
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
  
  private static LinkedList<a> G(JSONArray paramJSONArray)
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
        locala.MDs = localJSONObject.optInt("card_id");
        locala.hAk = localJSONObject.optString("bank_type");
        locala.MDt = localJSONObject.optString("bind_serial");
        locala.MDu = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(66603);
    return localLinkedList;
  }
  
  private static LinkedList<b> H(JSONArray paramJSONArray)
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
        localb.hAk = localJSONObject.optString("bank_type");
        localb.icon_url = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(66612);
    return localLinkedList;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(66586);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.hUS = 5;
    paramBundle.putParcelable("key_pay_info", localPayInfo);
    paramBundle.putBoolean("key_need_bind_response", true);
    paramBundle.putInt("key_req_bind_scene", 5);
    paramBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      paramBundle.putInt("key_entry_scene", paramInt2);
    }
    if (paramBundle != null)
    {
      ac.pu(6, paramBundle.getInt("key_bind_scene"));
      aa.aGq(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramActivity, paramBundle);
      AppMethodBeat.o(66586);
      return;
      ac.pu(6, 0);
      aa.aGq(0);
    }
  }
  
  public static void a(Activity paramActivity, u.g paramg)
  {
    AppMethodBeat.i(66579);
    Log.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramg == null) || (paramg.MzL == null))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(66579);
      return;
    }
    if (!gwB())
    {
      AppMethodBeat.o(66579);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramg.MzL);
    localBundle.putInt("key_pay_type", 2);
    if (paramg.ihd != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.a(paramg.ihd.igC, paramg.ihd.igD, paramg.ihd.igE, paramg.ihd.igF, paramg.ihd.igG, 8);
      localBundle.putParcelable("key_realname_guide_helper", localRealnameGuideHelper);
    }
    if ((paramActivity instanceof WalletOfflineCoinPurseUI))
    {
      paramg = paramActivity.getIntent();
      localBundle.putString("key_appid", paramg.getStringExtra("key_appid"));
      localBundle.putInt("key_from_scene", paramg.getIntExtra("key_from_scene", 0));
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, j.class, localBundle);
    AppMethodBeat.o(66579);
  }
  
  public static void a(Activity paramActivity, String paramString, p paramp)
  {
    AppMethodBeat.i(66583);
    Log.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "transid == null");
      AppMethodBeat.o(66583);
      return;
    }
    if (!gwB())
    {
      AppMethodBeat.o(66583);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramp instanceof com.tencent.mm.plugin.offline.a.g))
    {
      paramp = ((com.tencent.mm.plugin.offline.a.g)paramp).MyJ;
      if (paramp != null) {
        localBundle.putParcelable("key_realname_guide_helper", paramp);
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
      paramOrders.VHj = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.VHl = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.ICv = ((String)paramMap.get(str + "name_color"));
          localShowInfo.VII = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.VIJ = Util.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.VIK = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.VIL = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.VIM = ((String)paramMap.get(str + "link_url"));
          localShowInfo.VIN = Util.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!Util.isNullOrNil(localShowInfo.name)) || (!Util.isNullOrNil(localShowInfo.value))) {
            paramOrders.VHl.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(66582);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(269181);
    MDd = paramString1;
    MDe = paramString2;
    MDg = paramString3;
    MDh = paramString4;
    aQM(MDg);
    setTokenType(paramInt);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVL, "");
    com.tencent.mm.kernel.h.baD().mCm.a(new bw(new bw.a()
    {
      public final void b(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(66554);
        if ((paramAnonymousg == null) || (paramAnonymousg.bGg() == null))
        {
          AppMethodBeat.o(66554);
          return;
        }
        if (d.MDd != null) {
          paramAnonymousg.bGg().k("offline_token", d.MDd.getBytes());
        }
        if (d.MDe != null) {
          paramAnonymousg.bGg().k("offline_token_V2", d.MDe.getBytes());
        }
        if (d.MDh != null) {
          paramAnonymousg.bGg().k("offline_key_list", d.MDh.getBytes());
        }
        AppMethodBeat.o(66554);
      }
    }), 0);
    AppMethodBeat.o(269181);
  }
  
  public static Orders aJ(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66580);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.MEc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.MEd = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.MEe = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.MEf = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.hAU = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.wZe = (Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.MEj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.MEk = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.MEo = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.DUX = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.MEm = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.MEq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.hzv = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.MDU = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.VHy = (Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).hzv = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.VHw;
    localCommodity.VHz = ((Orders.Promotions)localObject1).hzv;
    ((Orders.Promotions)localObject1).MRI = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.VGN = j;
    localCommodity.VHC = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.VHD = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.VHE = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!Util.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.VHK = true;
      localCommodity.VHJ.add(localObject1);
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
          break label2942;
        }
        Log.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.VHL.text = ((String)localObject1);
      localCommodity.VHL.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)) && (!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(str2)))
      {
        localCommodity.VHF = new Orders.RecommendTinyAppInfo();
        localCommodity.VHF.VsI = ((String)localObject1);
        localCommodity.VHF.VGB = str1;
        localCommodity.VHF.VGC = ((String)localObject2);
        localCommodity.VHF.VcU = str2;
        localCommodity.VHF.VcV = str3;
        localCommodity.VHF.VGD = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.VHF.VIA = Util.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.VHF.VIB = Util.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.VHF.VID = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.VHF.VIE = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.VHF.VIF = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.VHF.VIC = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.VHF.VGE = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localCommodity.VHG = new Orders.FinderInfo();
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
      localCommodity.VHG.type = i;
      localCommodity.VHG.url = ((String)localObject1);
      localCommodity.VHG.username = str1;
      localCommodity.VHG.path = ((String)localObject2);
      localCommodity.VHG.version = str2;
      localCommodity.VHG.VHV = str3;
      localCommodity.VHG.VHW = str4;
      localCommodity.VHG.VHX = str5;
      localCommodity.VHG.VHY = str6;
      localCommodity.VHG.VHZ = str7;
      localCommodity.VHG.VIa = str8;
      localCommodity.VHG.VIb = k;
      localCommodity.VHG.VIc = str9;
      localCommodity.VHG.VId = str10;
      localCommodity.VHG.VIe = str11;
      localCommodity.VHH = new Orders.LeadTailViewInfo();
      localCommodity.VHH.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.desc"));
      localCommodity.VHH.VIf = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.settled_logo.url"));
      localCommodity.VHH.VIg = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.settled_logo.dark_mode_url"));
      localCommodity.VHH.VIh = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.unsettled_logo.url"));
      localCommodity.VHH.VIi = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.unsettled_logo.dark_mode_url"));
      localCommodity.VHH.type = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.type"), 0);
      localCommodity.VHH.VIj = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.route_info.type"), 0);
      localCommodity.VHH.VIk = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.route_info.url"));
      localCommodity.VHH.VIl = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.route_info.tiny_app_uri.username"));
      localCommodity.VHH.VIm = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.route_info.tiny_app_uri.path"));
      localCommodity.VHH.VIn = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.route_info.tiny_app_uri.version"));
      localCommodity.VHH.VIo = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.cmd_data.busi_param"));
      localCommodity.VHH.VIp = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.cmd_data.trans_id"));
      localCommodity.VHH.VIq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.lead_tail_view.jump_info.cmd_data.mmpay_mkt_sign"));
      localOrders.VGX = new ArrayList();
      localOrders.VGX.add(localCommodity);
      localOrders.VHh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.VHi = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.VGP = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.VGN = j;
      localOrders.hAT = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.VHy = (Util.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
      if (TextUtils.isEmpty((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
        break label3205;
      }
      i = 0;
      label2168:
      if (i != 0) {
        break label3147;
      }
    }
    label3147:
    for (localObject1 = "";; localObject1 = String.valueOf(i))
    {
      str1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".favor_desc";
      localObject1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".payment_amount";
      if ((TextUtils.isEmpty((CharSequence)paramMap.get(str1))) || (TextUtils.isEmpty((CharSequence)paramMap.get(localObject1)))) {
        break label3156;
      }
      localObject2 = new Orders.DiscountInfo();
      ((Orders.DiscountInfo)localObject2).OhO = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).VHU = Util.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.VHB.add(localObject2);
      i += 1;
      break label2168;
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
      label2942:
      localPromotions.MRI = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.VGz = str2;
      localPromotions.type = Orders.VHx;
      localPromotions.Avy = Util.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.akjp = Util.getInt(str5, 0);
      localPromotions.ehe = Util.getLong(str6, 0L);
      localPromotions.VGw = Util.getInt(str7, 0);
      localPromotions.akjq = Util.getInt(str8, 0);
      localPromotions.VGx = Util.getInt(str9, 0);
      localPromotions.akjr = str10;
      localPromotions.akjs = str11;
      localPromotions.akjt = str12;
      localPromotions.VGy = Util.getLong(str13, 0L);
      localPromotions.akju = Util.getInt(str14, 0);
      localPromotions.akjv = str15;
      localPromotions.akjw = str16;
      localObject1 = g(paramMap, i);
      if (localObject1 != null) {
        localPromotions.VIz = ((g.a.a.c)localObject1);
      }
      localCommodity.VHJ.add(localPromotions);
      i += 1;
      break;
    }
    label3156:
    Log.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    for (;;)
    {
      AppMethodBeat.o(66580);
      return localOrders;
      label3205:
      Log.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    }
  }
  
  public static void aQK(String paramString)
  {
    AppMethodBeat.i(66572);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196631, paramString);
    AppMethodBeat.o(66572);
  }
  
  public static void aQL(String paramString)
  {
    AppMethodBeat.i(66577);
    com.tencent.mm.plugin.wallet_core.model.u.iiC();
    am.bgI(paramString);
    AppMethodBeat.o(66577);
  }
  
  public static void aQM(String paramString)
  {
    AppMethodBeat.i(66600);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196656, paramString);
    MDg = paramString;
    AppMethodBeat.o(66600);
  }
  
  public static LinkedList<a> aQN(String paramString)
  {
    AppMethodBeat.i(66602);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66602);
      return null;
    }
    try
    {
      paramString = G(new JSONArray(paramString));
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
  
  public static void aQO(String paramString)
  {
    AppMethodBeat.i(66606);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196616, paramString);
    AppMethodBeat.o(66606);
  }
  
  public static void aQP(String paramString)
  {
    AppMethodBeat.i(66610);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196615, paramString);
    MDi = paramString;
    AppMethodBeat.o(66610);
  }
  
  private static LinkedList<b> aQQ(String paramString)
  {
    AppMethodBeat.i(66611);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66611);
      return null;
    }
    try
    {
      paramString = H(new JSONArray(paramString));
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
  
  public static String aQR(String paramString)
  {
    AppMethodBeat.i(66615);
    LinkedList localLinkedList = aQQ(gwU());
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
      if ((localb == null) || (!paramString.equals(localb.hAk))) {}
    }
    for (paramString = localb.icon_url;; paramString = "")
    {
      AppMethodBeat.o(66615);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String aQS(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(66616);
    Object localObject = ae.HH(true);
    LinkedList localLinkedList = aQQ(gwU());
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      Log.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
      AppMethodBeat.o(66616);
      return "";
    }
    int i = 0;
    Bankcard localBankcard;
    if (i < ((List)localObject).size())
    {
      localBankcard = (Bankcard)((List)localObject).get(i);
      if ((localBankcard == null) || (!paramString.equals(localBankcard.field_bindSerial))) {}
    }
    for (paramString = localBankcard.field_bankcardType;; paramString = "")
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
        if ((localObject == null) || (!paramString.equals(((b)localObject).hAk))) {}
      }
      for (paramString = ((b)localObject).icon_url;; paramString = "")
      {
        AppMethodBeat.o(66616);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void aQT(String paramString)
  {
    AppMethodBeat.i(66618);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acRQ, paramString);
    AppMethodBeat.o(66618);
  }
  
  public static void aQU(String paramString)
  {
    AppMethodBeat.i(66620);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTc, paramString);
    AppMethodBeat.o(66620);
  }
  
  public static void aQV(String paramString)
  {
    AppMethodBeat.i(66624);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTe, paramString);
    AppMethodBeat.o(66624);
  }
  
  public static void aQW(String paramString)
  {
    AppMethodBeat.i(66628);
    Log.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
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
    com.tencent.mm.pluginsdk.model.app.u.bS(localBundle);
    com.tencent.mm.pluginsdk.model.app.u.bT(localBundle);
    MMessageActV2.send(MMApplicationContext.getContext(), (MMessageActV2.Args)localObject);
    AppMethodBeat.o(66628);
  }
  
  public static boolean aQX(String paramString)
  {
    AppMethodBeat.i(269276);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(269276);
      return false;
    }
    long l = Long.parseLong(paramString);
    if ((0x0 & l) == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.WalletOfflineUtil", "is online code: %s, %s", new Object[] { Boolean.valueOf(bool), Long.toBinaryString(l) });
      AppMethodBeat.o(269276);
      return bool;
    }
  }
  
  public static void afi(int paramInt)
  {
    AppMethodBeat.i(66594);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196644, String.valueOf(paramInt));
    AppMethodBeat.o(66594);
  }
  
  public static void afj(int paramInt)
  {
    AppMethodBeat.i(66622);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTd, Integer.valueOf(i));
    AppMethodBeat.o(66622);
  }
  
  public static void afk(int paramInt)
  {
    AppMethodBeat.i(182496);
    if (paramInt > 0)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRS, Integer.valueOf(paramInt));
      com.tencent.mm.plugin.offline.k.Myp = paramInt;
      Log.i("MicroMsg.WalletOfflineUtil", "set token num: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(182496);
  }
  
  public static void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66585);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.hUS = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_req_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!com.tencent.mm.plugin.wallet_core.model.u.iiC().ijf())
    {
      if (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijh())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
      if (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijg())
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
  
  public static void bg(Activity paramActivity)
  {
    AppMethodBeat.i(66589);
    b(paramActivity, "freeze", paramActivity.getString(a.i.wallet_wx_offline_freeze_content), 0, -1);
    AppMethodBeat.o(66589);
  }
  
  public static void bh(Activity paramActivity)
  {
    AppMethodBeat.i(66590);
    m(paramActivity, -1);
    AppMethodBeat.o(66590);
  }
  
  public static void bi(Activity paramActivity)
  {
    AppMethodBeat.i(66607);
    com.tencent.mm.ui.base.k.cZ(paramActivity, paramActivity.getResources().getString(a.i.wallet_wx_offline_create_success));
    if (!TextUtils.isEmpty(gwS())) {
      com.tencent.mm.wallet_core.ui.i.bC(paramActivity, gwS());
    }
    AppMethodBeat.o(66607);
  }
  
  public static int dt(Context paramContext)
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
  
  private static g.a.a.c g(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(66581);
    g.a.a.c localc;
    if (paramInt == 0)
    {
      str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
      if (paramMap == null) {
        break label2417;
      }
      localc = new g.a.a.c();
      localc.ajFz = Util.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.Zsq = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.ZvU = Util.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localc.ZvS = Util.nullAsNil((String)paramMap.get(str + "exposure_info_modify_params"));
      localObject1 = new g.a.a.a();
      localObject2 = str + "btn_info.";
      ((g.a.a.a)localObject1).ajFr = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((g.a.a.a)localObject1).ajFs = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((g.a.a.a)localObject1).ajFt = Util.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((g.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((g.a.a.a)localObject1).aauB = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((g.a.a.a)localObject1).ajFu = new g.a.a.g();
      ((g.a.a.a)localObject1).ajFu.abho = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((g.a.a.a)localObject1).ajFu.abhp = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((g.a.a.a)localObject1).ajFu.abhq = Util.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!Util.isNullOrNil(((g.a.a.a)localObject1).ajFr)) || (!Util.isNullOrNil(((g.a.a.a)localObject1).url)) || (!Util.isNullOrNil(((g.a.a.a)localObject1).aauB)) || (!Util.isNullOrNil(((g.a.a.a)localObject1).ajFu.abho)) || (!Util.isNullOrNil(((g.a.a.a)localObject1).ajFu.abhp))) {
        localc.ZvV = ((g.a.a.a)localObject1);
      }
      localc.ajFA = Util.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.ajFB = Util.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.ajFD = ((String)paramMap.get(str + "background_img_whole"));
      localc.ZvT = new LinkedList();
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
      localObject2 = new g.a.a.i();
      ((g.a.a.i)localObject2).MRI = ((String)paramMap.get((String)localObject1 + "logo"));
      ((g.a.a.i)localObject2).ajGc = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((g.a.a.i)localObject2).ajGd = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((g.a.a.i)localObject2).ajGe = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((g.a.a.i)localObject2).ajGf = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((g.a.a.i)localObject2).ajGg = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!Util.isNullOrNil(((g.a.a.i)localObject2).MRI)) || (!Util.isNullOrNil(((g.a.a.i)localObject2).ajGc)) || (!Util.isNullOrNil(((g.a.a.i)localObject2).ajGd)) || (!Util.isNullOrNil(((g.a.a.i)localObject2).ajGe)) || (!Util.isNullOrNil(((g.a.a.i)localObject2).ajGf)) || (!Util.isNullOrNil(((g.a.a.i)localObject2).ajGg))) {
        localc.ZvT.add(localObject2);
      }
      if ((Util.isNullOrNil(((g.a.a.i)localObject2).ajGc)) || (Util.isNullOrNil(((g.a.a.i)localObject2).ajGd))) {
        break label1125;
      }
      paramInt += 1;
      break label713;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1125:
    localc.ajFC = new g.a.a.f();
    localObject1 = str + "layer_info.";
    localc.ajFC.ajFQ = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.ajFC.ajFR = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.ajFC.ajFS = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.ajFC.ajFT = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.ajFC.ajFU = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.ajFC.ajFV = Util.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.ajFC.ajFW = new g.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.ajFC.ajFW.ajFr = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.ajFC.ajFW.ajFs = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.ajFC.ajFW.ajFt = Util.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.ajFC.ajFW.aauB = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.ajFC.ajFW.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.ajFC.ajFW.ajFu = new g.a.a.g();
    localc.ajFC.ajFW.ajFu.abho = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.ajFC.ajFW.ajFu.abhp = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.ajFC.ajFW.ajFu.abhq = Util.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!Util.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.ajFC.ajFX = new com.tencent.mm.bx.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!Util.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.ajFC.Zab = new com.tencent.mm.bx.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new g.a.a.b();
    String str = str + "draw_lottery_info.";
    ((g.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((g.a.a.b)localObject1).ajFv = ((String)paramMap.get(str + "animation_wording"));
    ((g.a.a.b)localObject1).ajFw = ((String)paramMap.get(str + "animation_wording_color"));
    ((g.a.a.b)localObject1).YAN = Util.getInt((String)paramMap.get(str + "op_type"), 0);
    ((g.a.a.b)localObject1).ajFx = ((String)paramMap.get(str + "after_animation_wording"));
    ((g.a.a.b)localObject1).ajFy = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((g.a.a.b)localObject1).ajFu = new g.a.a.g();
    ((g.a.a.b)localObject1).ajFu.abho = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((g.a.a.b)localObject1).ajFu.abhp = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((g.a.a.b)localObject1).ajFu.abhq = Util.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!Util.isNullOrNil(((g.a.a.b)localObject1).url)) || (!Util.isNullOrNil(((g.a.a.b)localObject1).ajFv)) || (!Util.isNullOrNil(((g.a.a.b)localObject1).ajFw)) || (!Util.isNullOrNil(((g.a.a.b)localObject1).ajFu.abho)) || (!Util.isNullOrNil(((g.a.a.b)localObject1).ajFu.abhp))) {
      localc.ajFE = ((g.a.a.b)localObject1);
    }
    AppMethodBeat.o(66581);
    return localc;
    label2417:
    AppMethodBeat.o(66581);
    return null;
  }
  
  public static String getToken()
  {
    AppMethodBeat.i(66596);
    if (!TextUtils.isEmpty(MDd))
    {
      str = MDd;
      AppMethodBeat.o(66596);
      return str;
    }
    gwR();
    if (TextUtils.isEmpty(MDd)) {
      Log.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = MDd;
    AppMethodBeat.o(66596);
    return str;
  }
  
  public static String getTokenPin()
  {
    AppMethodBeat.i(66604);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196647);
    AppMethodBeat.o(66604);
    return str;
  }
  
  public static int getTokenType()
  {
    AppMethodBeat.i(269279);
    if (MDj == 0) {
      MDj = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVK, Integer.valueOf(0))).intValue();
    }
    int i = MDj;
    AppMethodBeat.o(269279);
    return i;
  }
  
  public static boolean gwA()
  {
    AppMethodBeat.i(66558);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66558);
      return true;
    }
    AppMethodBeat.o(66558);
    return false;
  }
  
  public static boolean gwB()
  {
    AppMethodBeat.i(66559);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66559);
      return true;
    }
    AppMethodBeat.o(66559);
    return false;
  }
  
  public static Bankcard gwC()
  {
    AppMethodBeat.i(66561);
    Bankcard localBankcard = gwD();
    AppMethodBeat.o(66561);
    return localBankcard;
  }
  
  public static Bankcard gwD()
  {
    AppMethodBeat.i(269110);
    Object localObject = c.MDa;
    localObject = c.gwy();
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (Util.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(269110);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.wallet_core.model.u.iiC().HJ(true);
    int i = 0;
    while ((localObject != null) && (i < ((List)localObject).size()))
    {
      Bankcard localBankcard = (Bankcard)((List)localObject).get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay))
      {
        AppMethodBeat.o(269110);
        return localBankcard;
      }
      i += 1;
    }
    AppMethodBeat.o(269110);
    return null;
  }
  
  public static Bankcard gwE()
  {
    AppMethodBeat.i(66562);
    com.tencent.mm.plugin.wallet_core.model.u.iiC();
    Bankcard localBankcard = am.ijU();
    AppMethodBeat.o(66562);
    return localBankcard;
  }
  
  public static int gwF()
  {
    AppMethodBeat.i(66563);
    ArrayList localArrayList = com.tencent.mm.plugin.wallet_core.model.u.iiC().HJ(true);
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      AppMethodBeat.o(66563);
      return i;
    }
    Log.e("MicroMsg.WalletOfflineUtil", "mBankcardList == null");
    AppMethodBeat.o(66563);
    return 0;
  }
  
  public static List<Bankcard> gwG()
  {
    AppMethodBeat.i(66565);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.u.iiC().ijF();
    int i = 0;
    while ((localArrayList2 != null) && (i < localArrayList2.size()))
    {
      localArrayList1.add((Bankcard)localArrayList2.get(i));
      i += 1;
    }
    Log.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66565);
    return localArrayList1;
  }
  
  public static int gwH()
  {
    AppMethodBeat.i(66566);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66566);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66566);
    return i;
  }
  
  private static int gwI()
  {
    int j = 0;
    AppMethodBeat.i(66567);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196640);
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
  
  public static String gwJ()
  {
    AppMethodBeat.i(66570);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196632);
    AppMethodBeat.o(66570);
    return str;
  }
  
  public static String gwK()
  {
    AppMethodBeat.i(66571);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196631);
    AppMethodBeat.o(66571);
    return str;
  }
  
  public static String gwL()
  {
    AppMethodBeat.i(66576);
    com.tencent.mm.plugin.wallet_core.model.u.iiC();
    String str = am.ijO();
    AppMethodBeat.o(66576);
    return str;
  }
  
  public static void gwM()
  {
    int i = 1;
    AppMethodBeat.i(66578);
    Log.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196630, "0");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196626, "");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196627, "");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196628, "");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196617, "");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196632, "");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196641, "");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196647, "");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196649, "");
    if (gxe() == 1) {
      i = 2;
    }
    a("", "", "", "", i);
    afk(0);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196629, "0");
    aQK("");
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.gvk().Mzt = null;
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.gvm();
    com.tencent.mm.plugin.offline.i.dgR();
    aQP("");
    aQM("");
    AppMethodBeat.o(66578);
  }
  
  public static void gwN()
  {
    AppMethodBeat.i(66593);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.ct(196643, "1");
    AppMethodBeat.o(66593);
  }
  
  public static int gwO()
  {
    AppMethodBeat.i(66595);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66595);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66595);
    return i;
  }
  
  public static String gwP()
  {
    AppMethodBeat.i(66598);
    if (!TextUtils.isEmpty(MDe))
    {
      str = MDe;
      AppMethodBeat.o(66598);
      return str;
    }
    gwR();
    if (TextUtils.isEmpty(MDe)) {
      Log.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = MDe;
    AppMethodBeat.o(66598);
    return str;
  }
  
  public static String gwQ()
  {
    AppMethodBeat.i(66599);
    if (!TextUtils.isEmpty(MDg))
    {
      str = MDg;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(MDg))
    {
      com.tencent.mm.plugin.offline.k.gvj();
      str = com.tencent.mm.plugin.offline.k.afd(196656);
      MDg = str;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(MDg)) {
      Log.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = MDg;
    AppMethodBeat.o(66599);
    return str;
  }
  
  private static void gwR()
  {
    AppMethodBeat.i(66601);
    com.tencent.mm.kernel.h.baD().mCm.a(new bw(new bw.a()
    {
      public final void b(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(66555);
        if ((paramAnonymousg == null) || (paramAnonymousg.bGg() == null))
        {
          Log.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
          AppMethodBeat.o(66555);
          return;
        }
        byte[] arrayOfByte = paramAnonymousg.bGg().LW("offline_token");
        if (arrayOfByte != null) {
          d.jdMethod_if(new String(arrayOfByte));
        }
        arrayOfByte = paramAnonymousg.bGg().LW("offline_token_V2");
        if (arrayOfByte != null) {
          d.MDe = new String(arrayOfByte);
        }
        paramAnonymousg = paramAnonymousg.bGg().LW("offline_key_list");
        if (paramAnonymousg != null) {
          d.MDh = new String(paramAnonymousg);
        }
        AppMethodBeat.o(66555);
      }
    }), 0);
    AppMethodBeat.o(66601);
  }
  
  private static String gwS()
  {
    AppMethodBeat.i(66605);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196616);
    AppMethodBeat.o(66605);
    return str;
  }
  
  public static boolean gwT()
  {
    AppMethodBeat.i(66608);
    AppMethodBeat.o(66608);
    return true;
  }
  
  private static String gwU()
  {
    AppMethodBeat.i(66609);
    if (TextUtils.isEmpty(MDi))
    {
      com.tencent.mm.plugin.offline.k.gvj();
      str = com.tencent.mm.plugin.offline.k.afd(196615);
      MDi = str;
      AppMethodBeat.o(66609);
      return str;
    }
    String str = MDi;
    AppMethodBeat.o(66609);
    return str;
  }
  
  public static int gwV()
  {
    AppMethodBeat.i(66613);
    com.tencent.mm.plugin.offline.k.gvj();
    String str = com.tencent.mm.plugin.offline.k.afd(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66613);
      return 0;
    }
    int i = Util.getInt(str, 0);
    AppMethodBeat.o(66613);
    return i;
  }
  
  public static boolean gwW()
  {
    AppMethodBeat.i(66614);
    String str = gwJ();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(66614);
      return false;
    }
    long l1 = gwV();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(66614);
      return true;
    }
    AppMethodBeat.o(66614);
    return false;
  }
  
  public static boolean gwX()
  {
    return AppForegroundDelegate.heY.eLx;
  }
  
  public static String gwY()
  {
    AppMethodBeat.i(66619);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acRQ, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66619);
      return localObject;
    }
    AppMethodBeat.o(66619);
    return null;
  }
  
  public static String gwZ()
  {
    AppMethodBeat.i(66621);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acTc, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66621);
      return localObject;
    }
    AppMethodBeat.o(66621);
    return null;
  }
  
  public static int gxa()
  {
    AppMethodBeat.i(66623);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acTd, null);
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
  
  public static String gxb()
  {
    AppMethodBeat.i(66625);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acTe, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66625);
      return localObject;
    }
    AppMethodBeat.o(66625);
    return null;
  }
  
  public static boolean gxc()
  {
    AppMethodBeat.i(66627);
    AppMethodBeat.o(66627);
    return true;
  }
  
  public static int gxd()
  {
    return com.tencent.mm.plugin.offline.k.Myp;
  }
  
  public static int gxe()
  {
    AppMethodBeat.i(269278);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXw, 0);
    Log.d("MicroMsg.WalletOfflineUtil", "is open online code: %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(269278);
    return i;
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
  
  public static void jl(Context paramContext)
  {
    AppMethodBeat.i(66573);
    String str = LocaleUtil.getApplicationLanguage();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(a.i.url_wallet_offline_user_guide_url);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.i.bC(paramContext, str);
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
  
  public static void k(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66584);
    b(paramActivity, paramInt, -1);
    AppMethodBeat.o(66584);
  }
  
  public static void l(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66587);
    b(paramActivity, "create", paramActivity.getString(a.i.wallet_wx_offline_create_offline), 0, paramInt);
    AppMethodBeat.o(66587);
  }
  
  public static void m(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66591);
    b(paramActivity, "create", "", gwI(), paramInt);
    AppMethodBeat.o(66591);
  }
  
  public static void m(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66592);
    com.tencent.mm.ui.base.k.a(paramActivity, false, paramString, "", paramActivity.getString(a.i.wallet_wx_offline_recreate_offline_text), paramActivity.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66552);
        d.gwM();
        d.bh(d.this);
        d.this.finish();
        AppMethodBeat.o(66552);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66553);
        d.this.finish();
        AppMethodBeat.o(66553);
      }
    });
    AppMethodBeat.o(66592);
  }
  
  public static void setTokenType(int paramInt)
  {
    AppMethodBeat.i(269178);
    int i = MDj;
    MDj = paramInt;
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVK, Integer.valueOf(paramInt));
    if (i != paramInt)
    {
      Object localObject = c.MDa;
      Log.i("MicroMsg.OfflinePriorBankcardLogic", kotlin.g.b.s.X("onTokenTypeChanged: ", Integer.valueOf(getTokenType())));
      c.gwx();
      localObject = ((Iterable)c.MDc).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c.b)((Iterator)localObject).next()).gwe();
      }
    }
    AppMethodBeat.o(269178);
  }
  
  public static final class a
  {
    public int MDs;
    public String MDt;
    public String MDu;
    public String hAk;
  }
  
  public static final class b
  {
    public String hAk;
    public String icon_url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.d
 * JD-Core Version:    0.7.0.1
 */