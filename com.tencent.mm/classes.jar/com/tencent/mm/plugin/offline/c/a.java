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
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.plugin.expt.a.b.a;
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
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public static String nTb;
  private static String vvZ;
  public static String vwa;
  public static int vwb;
  public static String vwc;
  public static String vwd;
  public static String vwe;
  public static int vwf;
  public static int vwg;
  public static long vwh;
  public static boolean vwi;
  public static String vwj;
  public static String vwk;
  private static Comparator<Bankcard> vwl;
  private static Comparator<a> vwm;
  
  static
  {
    AppMethodBeat.i(66629);
    vvZ = "";
    vwa = "";
    vwb = 1;
    vwc = "";
    vwd = "";
    vwe = "";
    vwf = 1;
    vwg = 0;
    vwh = 0L;
    vwi = false;
    nTb = "";
    vwj = "";
    vwk = "";
    vwl = new a.5();
    vwm = new Comparator() {};
    AppMethodBeat.o(66629);
  }
  
  public static void KM(int paramInt)
  {
    AppMethodBeat.i(66568);
    k.dlZ();
    k.bu(196640, String.valueOf(paramInt));
    AppMethodBeat.o(66568);
  }
  
  public static void KN(int paramInt)
  {
    AppMethodBeat.i(66569);
    k.dlZ();
    k.bu(196642, String.valueOf(paramInt));
    AppMethodBeat.o(66569);
  }
  
  public static void KO(int paramInt)
  {
    AppMethodBeat.i(66594);
    k.dlZ();
    k.bu(196644, String.valueOf(paramInt));
    AppMethodBeat.o(66594);
  }
  
  public static void KP(int paramInt)
  {
    AppMethodBeat.i(66622);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOd, Integer.valueOf(i));
    AppMethodBeat.o(66622);
  }
  
  public static void KQ(int paramInt)
  {
    AppMethodBeat.i(182496);
    if (paramInt > 0)
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNj, Integer.valueOf(paramInt));
      k.vsp = paramInt;
      ac.i("MicroMsg.WalletOfflineUtil", "set token num: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(182496);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66585);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dqM = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!s.ery().esa())
    {
      if (s.ery().esc())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
      if (s.ery().esb())
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
    localPayInfo.dqM = 5;
    paramBundle.putParcelable("key_pay_info", localPayInfo);
    paramBundle.putBoolean("key_need_bind_response", true);
    paramBundle.putInt("key_bind_scene", 5);
    paramBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      paramBundle.putInt("key_entry_scene", paramInt2);
    }
    if (paramBundle != null)
    {
      com.tencent.mm.wallet_core.c.ab.km(6, paramBundle.getInt("key_bind_scene"));
      z.adM(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramActivity, paramBundle);
      AppMethodBeat.o(66586);
      return;
      com.tencent.mm.wallet_core.c.ab.km(6, 0);
      z.adM(0);
    }
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    AppMethodBeat.i(66579);
    ac.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.vtG == null))
    {
      ac.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(66579);
      return;
    }
    if (!dmR())
    {
      AppMethodBeat.o(66579);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.vtG);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.dBe != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.b(paramf.dBe.dAF, paramf.dBe.dAG, paramf.dBe.dAH, paramf.dBe.dAI, paramf.dBe.dAJ, 8);
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
    ac.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.WalletOfflineUtil", "transid == null");
      AppMethodBeat.o(66583);
      return;
    }
    if (!dmR())
    {
      AppMethodBeat.o(66583);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramn = ((com.tencent.mm.plugin.offline.a.e)paramn).vsI;
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
      paramOrders.Byd = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.Byf = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.tda = ((String)paramMap.get(str + "name_color"));
          localShowInfo.Bzg = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.Bzh = bs.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.Bzi = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.Bzj = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.Bzk = ((String)paramMap.get(str + "link_url"));
          localShowInfo.Bzl = bs.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!bs.isNullOrNil(localShowInfo.name)) || (!bs.isNullOrNil(localShowInfo.value))) {
            paramOrders.Byf.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(66582);
  }
  
  public static Orders ao(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66580);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.vwX = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.vwY = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.vwZ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.vxa = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.dad = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.oxA = (bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.vxe = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.vxf = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.vxj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.vxq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.vxh = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.vxl = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.vxm = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.vwP = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.Bys = (bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).vxm = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.Byq;
    localCommodity.Byt = ((Orders.Promotions)localObject1).vxm;
    ((Orders.Promotions)localObject1).vFL = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.BxH = j;
    localCommodity.Byw = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.Byx = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.Byy = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!bs.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.ByC = true;
      localCommodity.ByB.add(localObject1);
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
        if (!bs.isNullOrNil(str1)) {
          break label2130;
        }
        ac.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.ByD.text = ((String)localObject1);
      localCommodity.ByD.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(str1)) && (!bs.isNullOrNil((String)localObject2)) && (!bs.isNullOrNil(str2)))
      {
        localCommodity.Byz = new Orders.RecommendTinyAppInfo();
        localCommodity.Byz.BnG = ((String)localObject1);
        localCommodity.Byz.Bxv = str1;
        localCommodity.Byz.Bxw = ((String)localObject2);
        localCommodity.Byz.AZE = str2;
        localCommodity.Byz.AZF = str3;
        localCommodity.Byz.Bxx = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.Byz.ByY = bs.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.Byz.ByZ = bs.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.Byz.Bzb = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.Byz.Bzc = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.Byz.Bzd = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.Byz.Bza = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.Byz.Bxy = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localOrders.BxR = new ArrayList();
      localOrders.BxR.add(localCommodity);
      localOrders.Byb = bs.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.Byc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.BxJ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.BxH = j;
      localOrders.dac = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.Bys = (bs.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
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
      ((Orders.DiscountInfo)localObject2).wJS = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).ByN = bs.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.Byv.add(localObject2);
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
      localPromotions.vFL = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.Bxt = str2;
      localPromotions.type = Orders.Byr;
      localPromotions.ByO = bs.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.DeE = bs.getInt(str5, 0);
      localPromotions.BoC = bs.getLong(str6, 0L);
      localPromotions.Bxq = bs.getInt(str7, 0);
      localPromotions.DeF = bs.getInt(str8, 0);
      localPromotions.Bxr = bs.getInt(str9, 0);
      localPromotions.DeG = str10;
      localPromotions.DeH = str11;
      localPromotions.DeI = str12;
      localPromotions.Bxs = bs.getLong(str13, 0L);
      localPromotions.DeJ = bs.getInt(str14, 0);
      localPromotions.GZQ = str15;
      localPromotions.GZR = str16;
      localObject1 = e(paramMap, i);
      if (localObject1 != null) {
        localPromotions.ByX = ((e.a.a.c)localObject1);
      }
      localCommodity.ByB.add(localPromotions);
      i += 1;
      break;
    }
    label2339:
    ac.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    for (;;)
    {
      AppMethodBeat.o(66580);
      return localOrders;
      label2387:
      ac.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    }
  }
  
  public static void aoI(String paramString)
  {
    AppMethodBeat.i(66572);
    k.dlZ();
    k.bu(196631, paramString);
    AppMethodBeat.o(66572);
  }
  
  public static void aoJ(String paramString)
  {
    AppMethodBeat.i(66577);
    s.ery();
    am.azp(paramString);
    AppMethodBeat.o(66577);
  }
  
  public static void aoK(String paramString)
  {
    AppMethodBeat.i(66600);
    k.dlZ();
    k.bu(196656, paramString);
    vwc = paramString;
    AppMethodBeat.o(66600);
  }
  
  public static LinkedList<a> aoL(String paramString)
  {
    AppMethodBeat.i(66602);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66602);
      return null;
    }
    try
    {
      paramString = y(new JSONArray(paramString));
      AppMethodBeat.o(66602);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66602);
    }
    return null;
  }
  
  public static void aoM(String paramString)
  {
    AppMethodBeat.i(66606);
    k.dlZ();
    k.bu(196616, paramString);
    AppMethodBeat.o(66606);
  }
  
  public static void aoN(String paramString)
  {
    AppMethodBeat.i(66610);
    k.dlZ();
    k.bu(196615, paramString);
    vwe = paramString;
    AppMethodBeat.o(66610);
  }
  
  private static LinkedList<b> aoO(String paramString)
  {
    AppMethodBeat.i(66611);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66611);
      return null;
    }
    try
    {
      paramString = z(new JSONArray(paramString));
      AppMethodBeat.o(66611);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66611);
    }
    return null;
  }
  
  public static String aoP(String paramString)
  {
    AppMethodBeat.i(66615);
    LinkedList localLinkedList = aoO(dnk());
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
      if ((localb == null) || (!paramString.equals(localb.cZz))) {}
    }
    for (paramString = localb.oGN;; paramString = "")
    {
      AppMethodBeat.o(66615);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String aoQ(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(66616);
    Object localObject = aoL(dng());
    LinkedList localLinkedList = aoO(dnk());
    if ((localObject == null) || (localLinkedList == null) || (((LinkedList)localObject).size() == 0) || (localLinkedList.size() == 0))
    {
      ac.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
      AppMethodBeat.o(66616);
      return "";
    }
    int i = 0;
    a locala;
    if (i < ((LinkedList)localObject).size())
    {
      locala = (a)((LinkedList)localObject).get(i);
      if ((locala == null) || (!paramString.equals(locala.vwo))) {}
    }
    for (paramString = locala.cZz;; paramString = "")
    {
      if (TextUtils.isEmpty(paramString))
      {
        ac.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
        AppMethodBeat.o(66616);
        return "";
        i += 1;
        break;
      }
      i = j;
      if (i < localLinkedList.size())
      {
        localObject = (b)localLinkedList.get(i);
        if ((localObject == null) || (!paramString.equals(((b)localObject).cZz))) {}
      }
      for (paramString = ((b)localObject).oGN;; paramString = "")
      {
        AppMethodBeat.o(66616);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void aoR(String paramString)
  {
    AppMethodBeat.i(66618);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNh, paramString);
    AppMethodBeat.o(66618);
  }
  
  public static void aoS(String paramString)
  {
    AppMethodBeat.i(66620);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOc, paramString);
    AppMethodBeat.o(66620);
  }
  
  public static void aoT(String paramString)
  {
    AppMethodBeat.i(66624);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOe, paramString);
    AppMethodBeat.o(66624);
  }
  
  public static void aoU(String paramString)
  {
    AppMethodBeat.i(66628);
    ac.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.h.k(paramString, true, false);
    if (paramString == null)
    {
      ac.w("MicroMsg.WalletOfflineUtil", "can not find app info");
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
    com.tencent.mm.pluginsdk.model.app.q.aW(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.aX(localBundle);
    MMessageActV2.send(ai.getContext(), (MMessageActV2.Args)localObject);
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
    com.tencent.mm.ui.base.h.cg(paramActivity, paramActivity.getResources().getString(2131765962));
    if (!TextUtils.isEmpty(dni())) {
      com.tencent.mm.wallet_core.ui.e.aT(paramActivity, dni());
    }
    AppMethodBeat.o(66607);
  }
  
  public static boolean cK(Context paramContext)
  {
    AppMethodBeat.i(66617);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ac.d("MicroMsg.WalletOfflineUtil", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ac.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
        AppMethodBeat.o(66617);
        return false;
      }
    }
    if (((KeyguardManager)ai.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(66617);
      return false;
    }
    ac.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
    AppMethodBeat.o(66617);
    return true;
  }
  
  public static boolean dmQ()
  {
    AppMethodBeat.i(66558);
    k.dlZ();
    String str = k.KG(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66558);
      return true;
    }
    AppMethodBeat.o(66558);
    return false;
  }
  
  public static boolean dmR()
  {
    AppMethodBeat.i(66559);
    k.dlZ();
    String str = k.KG(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66559);
      return true;
    }
    AppMethodBeat.o(66559);
    return false;
  }
  
  @Deprecated
  public static Bankcard dmS()
  {
    AppMethodBeat.i(66560);
    s.ery();
    Object localObject2 = am.esF();
    ac.i("MicroMsg.WalletPayOrderMgr", "step 1 getSelectedBindBankCard %s", new Object[] { localObject2 });
    Object localObject3 = s.ery();
    Object localObject1;
    if (((am)localObject3).BAz == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label508;
      }
      localObject1 = s.ery().tD(true);
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
          ac.i("MicroMsg.WalletPayOrderMgr", "step 2 micropay: %s, forbidword: %s", new Object[] { Boolean.valueOf(((Bankcard)localObject3).field_support_micropay), ((Bankcard)localObject3).field_forbidWord });
          if (((Bankcard)localObject3).field_support_micropay)
          {
            AppMethodBeat.o(66560);
            return localObject3;
            localObject1 = new ArrayList();
            if ((((am)localObject3).AZp != null) && (!((am)localObject3).esc())) {
              ((ArrayList)localObject1).add(((am)localObject3).AZp);
            }
            if ((((am)localObject3).BAI != null) && (!((am)localObject3).esc())) {
              ((ArrayList)localObject1).add(((am)localObject3).BAI);
            }
            if (((am)localObject3).BAz.size() > 0)
            {
              localObject3 = ((am)localObject3).BAz.iterator();
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
      ac.i("MicroMsg.WalletPayOrderMgr", "step 3 clear default bindserial");
      s.ery();
      am.azp("");
      s.ery();
      localObject2 = am.esL();
      if ((localObject2 != null) && (bs.isNullOrNil(((Bankcard)localObject2).field_forbidWord)))
      {
        ac.i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject2;
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (Bankcard)((List)localObject1).get(i);
        if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (!((Bankcard)localObject2).eqR()))
        {
          ac.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
          AppMethodBeat.o(66560);
          return localObject2;
        }
        i += 1;
      }
      localObject1 = s.ery().AZp;
      if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay))
      {
        ac.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject1;
      }
      localObject1 = s.ery().BAI;
      if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay) && (bs.isNullOrNil(((Bankcard)localObject1).field_forbidWord)))
      {
        ac.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject1;
      }
      AppMethodBeat.o(66560);
      return null;
    }
  }
  
  public static Bankcard dmT()
  {
    AppMethodBeat.i(66561);
    Object localObject = dmS();
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (bs.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(66561);
      return localObject;
    }
    localObject = s.ery().tD(true);
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
  
  public static Bankcard dmU()
  {
    AppMethodBeat.i(66562);
    s.ery();
    Bankcard localBankcard = am.esL();
    AppMethodBeat.o(66562);
    return localBankcard;
  }
  
  public static int dmV()
  {
    AppMethodBeat.i(66563);
    int i = s.ery().tD(true).size();
    AppMethodBeat.o(66563);
    return i;
  }
  
  public static List<Bankcard> dmW()
  {
    AppMethodBeat.i(66565);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = s.ery().esx();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localArrayList1.add((Bankcard)localArrayList2.get(i));
      i += 1;
    }
    ac.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66565);
    return localArrayList1;
  }
  
  public static int dmX()
  {
    AppMethodBeat.i(66566);
    k.dlZ();
    String str = k.KG(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66566);
      return 0;
    }
    int i = bs.getInt(str, 0);
    AppMethodBeat.o(66566);
    return i;
  }
  
  private static int dmY()
  {
    int j = 0;
    AppMethodBeat.i(66567);
    k.dlZ();
    String str = k.KG(196640);
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
      i = bs.getInt(str, 0);
      break;
      label62:
      i = 20000;
    }
  }
  
  public static String dmZ()
  {
    AppMethodBeat.i(66570);
    k.dlZ();
    String str = k.KG(196632);
    AppMethodBeat.o(66570);
    return str;
  }
  
  public static String dna()
  {
    AppMethodBeat.i(66571);
    k.dlZ();
    String str = k.KG(196631);
    AppMethodBeat.o(66571);
    return str;
  }
  
  public static String dnb()
  {
    AppMethodBeat.i(66576);
    s.ery();
    String str = am.esF();
    AppMethodBeat.o(66576);
    return str;
  }
  
  public static void dnc()
  {
    AppMethodBeat.i(66578);
    ac.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.dlZ();
    k.bu(196630, "0");
    k.dlZ();
    k.bu(196626, "");
    k.dlZ();
    k.bu(196627, "");
    k.dlZ();
    k.bu(196628, "");
    k.dlZ();
    k.bu(196617, "");
    k.dlZ();
    k.bu(196632, "");
    k.dlZ();
    k.bu(196641, "");
    k.dlZ();
    k.bu(196647, "");
    k.dlZ();
    k.bu(196649, "");
    s("", "", "", "");
    KQ(0);
    k.dlZ();
    k.bu(196629, "0");
    aoI("");
    k.dlZ();
    k.dma().vtr = null;
    k.dlZ();
    k.dmc();
    k.dlZ();
    String str = k.KG(196617);
    com.tencent.mm.wallet_core.c.b.fAg();
    com.tencent.mm.wallet_core.c.b.clearToken(str);
    aoN("");
    aoK("");
    AppMethodBeat.o(66578);
  }
  
  public static void dnd()
  {
    AppMethodBeat.i(66593);
    k.dlZ();
    k.bu(196643, "1");
    AppMethodBeat.o(66593);
  }
  
  public static int dne()
  {
    AppMethodBeat.i(66595);
    k.dlZ();
    String str = k.KG(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66595);
      return 0;
    }
    int i = bs.getInt(str, 0);
    AppMethodBeat.o(66595);
    return i;
  }
  
  public static String dnf()
  {
    AppMethodBeat.i(66598);
    if (!TextUtils.isEmpty(vwa))
    {
      str = vwa;
      AppMethodBeat.o(66598);
      return str;
    }
    dnh();
    if (TextUtils.isEmpty(vwa)) {
      ac.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = vwa;
    AppMethodBeat.o(66598);
    return str;
  }
  
  public static String dng()
  {
    AppMethodBeat.i(66599);
    if (!TextUtils.isEmpty(vwc))
    {
      str = vwc;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(vwc))
    {
      k.dlZ();
      str = k.KG(196656);
      vwc = str;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(vwc)) {
      ac.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = vwc;
    AppMethodBeat.o(66599);
    return str;
  }
  
  private static void dnh()
  {
    AppMethodBeat.i(66601);
    com.tencent.mm.kernel.g.agQ().ghe.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66555);
        if ((paramAnonymouse == null) || (paramAnonymouse.aBZ() == null))
        {
          ac.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
          AppMethodBeat.o(66555);
          return;
        }
        byte[] arrayOfByte = paramAnonymouse.aBZ().An("offline_token");
        if (arrayOfByte != null) {
          a.eh(new String(arrayOfByte));
        }
        arrayOfByte = paramAnonymouse.aBZ().An("offline_token_V2");
        if (arrayOfByte != null) {
          a.vwa = new String(arrayOfByte);
        }
        paramAnonymouse = paramAnonymouse.aBZ().An("offline_key_list");
        if (paramAnonymouse != null) {
          a.vwd = new String(paramAnonymouse);
        }
        AppMethodBeat.o(66555);
      }
    }), 0);
    AppMethodBeat.o(66601);
  }
  
  private static String dni()
  {
    AppMethodBeat.i(66605);
    k.dlZ();
    String str = k.KG(196616);
    AppMethodBeat.o(66605);
    return str;
  }
  
  public static boolean dnj()
  {
    int j = 0;
    AppMethodBeat.i(66608);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbi, 0) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.i("MicroMsg.WalletOfflineUtil", "pass same md5 case");
      AppMethodBeat.o(66608);
      return true;
    }
    ArrayList localArrayList = s.ery().tD(true);
    Object localObject = aoL(dng());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size()))
    {
      AppMethodBeat.o(66608);
      return false;
    }
    Collections.sort((List)localObject, vwm);
    Collections.sort(localArrayList, vwl);
    StringBuilder localStringBuilder = new StringBuilder();
    i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a)((LinkedList)localObject).get(i)).vwo);
      i += 1;
    }
    localObject = new StringBuilder();
    i = j;
    while (i < localArrayList.size())
    {
      ((StringBuilder)localObject).append(((Bankcard)localArrayList.get(i)).field_bindSerial);
      i += 1;
    }
    boolean bool = ah.dg(localStringBuilder.toString()).equals(ah.dg(((StringBuilder)localObject).toString()));
    AppMethodBeat.o(66608);
    return bool;
  }
  
  private static String dnk()
  {
    AppMethodBeat.i(66609);
    if (TextUtils.isEmpty(vwe))
    {
      k.dlZ();
      str = k.KG(196615);
      vwe = str;
      AppMethodBeat.o(66609);
      return str;
    }
    String str = vwe;
    AppMethodBeat.o(66609);
    return str;
  }
  
  public static int dnl()
  {
    AppMethodBeat.i(66613);
    k.dlZ();
    String str = k.KG(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66613);
      return 0;
    }
    int i = bs.getInt(str, 0);
    AppMethodBeat.o(66613);
    return i;
  }
  
  public static boolean dnm()
  {
    AppMethodBeat.i(66614);
    String str = dmZ();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(66614);
      return false;
    }
    long l1 = dnl();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(66614);
      return true;
    }
    AppMethodBeat.o(66614);
    return false;
  }
  
  public static String dnn()
  {
    AppMethodBeat.i(66619);
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNh, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66619);
      return localObject;
    }
    AppMethodBeat.o(66619);
    return null;
  }
  
  public static String dno()
  {
    AppMethodBeat.i(66621);
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOc, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66621);
      return localObject;
    }
    AppMethodBeat.o(66621);
    return null;
  }
  
  public static int dnp()
  {
    AppMethodBeat.i(66623);
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOd, null);
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
  
  public static String dnq()
  {
    AppMethodBeat.i(66625);
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOe, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66625);
      return localObject;
    }
    AppMethodBeat.o(66625);
    return null;
  }
  
  public static boolean dnr()
  {
    AppMethodBeat.i(66627);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.d.aAp().tJ("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).eYV();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        ac.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.d.aAp().tJ("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).eYV();
      bool1 = bool2;
      if (((Map)localObject).containsKey("open"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("open"))) {
          bool1 = true;
        }
      }
    }
    ac.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(66627);
    return bool1;
  }
  
  public static int dns()
  {
    return k.vsp;
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
      localc.LUG = bs.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.EvX = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.Ext = bs.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localc.Exr = bs.nullAsNil((String)paramMap.get(str + "exposure_info_modify_params"));
      localObject1 = new e.a.a.a();
      localObject2 = str + "btn_info.";
      ((e.a.a.a)localObject1).LUy = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((e.a.a.a)localObject1).LUz = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((e.a.a.a)localObject1).LUA = bs.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((e.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((e.a.a.a)localObject1).EQP = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((e.a.a.a)localObject1).LUB = new e.a.a.g();
      ((e.a.a.a)localObject1).LUB.Fsx = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((e.a.a.a)localObject1).LUB.Fsy = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((e.a.a.a)localObject1).LUB.Fsz = bs.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!bs.isNullOrNil(((e.a.a.a)localObject1).LUy)) || (!bs.isNullOrNil(((e.a.a.a)localObject1).url)) || (!bs.isNullOrNil(((e.a.a.a)localObject1).EQP)) || (!bs.isNullOrNil(((e.a.a.a)localObject1).LUB.Fsx)) || (!bs.isNullOrNil(((e.a.a.a)localObject1).LUB.Fsy))) {
        localc.Exu = ((e.a.a.a)localObject1);
      }
      localc.LUH = bs.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.LUI = bs.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.LUK = ((String)paramMap.get(str + "background_img_whole"));
      localc.Exs = new LinkedList();
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
      ((i)localObject2).vFL = ((String)paramMap.get((String)localObject1 + "logo"));
      ((i)localObject2).LVj = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((i)localObject2).LVk = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((i)localObject2).LVl = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((i)localObject2).LVm = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((i)localObject2).LVn = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!bs.isNullOrNil(((i)localObject2).vFL)) || (!bs.isNullOrNil(((i)localObject2).LVj)) || (!bs.isNullOrNil(((i)localObject2).LVk)) || (!bs.isNullOrNil(((i)localObject2).LVl)) || (!bs.isNullOrNil(((i)localObject2).LVm)) || (!bs.isNullOrNil(((i)localObject2).LVn))) {
        localc.Exs.add(localObject2);
      }
      if ((bs.isNullOrNil(((i)localObject2).LVj)) || (bs.isNullOrNil(((i)localObject2).LVk))) {
        break label1125;
      }
      paramInt += 1;
      break label713;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1125:
    localc.LUJ = new f();
    localObject1 = str + "layer_info.";
    localc.LUJ.LUX = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.LUJ.LUY = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.LUJ.LUZ = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.LUJ.LVa = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.LUJ.LVb = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.LUJ.LVc = bs.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.LUJ.LVd = new e.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.LUJ.LVd.LUy = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.LUJ.LVd.LUz = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.LUJ.LVd.LUA = bs.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.LUJ.LVd.EQP = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.LUJ.LVd.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.LUJ.LVd.LUB = new e.a.a.g();
    localc.LUJ.LVd.LUB.Fsx = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.LUJ.LVd.LUB.Fsy = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.LUJ.LVd.LUB.Fsz = bs.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!bs.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.LUJ.LVe = new com.tencent.mm.bw.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!bs.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.LUJ.EgO = new com.tencent.mm.bw.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new e.a.a.b();
    String str = str + "draw_lottery_info.";
    ((e.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((e.a.a.b)localObject1).LUC = ((String)paramMap.get(str + "animation_wording"));
    ((e.a.a.b)localObject1).LUD = ((String)paramMap.get(str + "animation_wording_color"));
    ((e.a.a.b)localObject1).FUi = bs.getInt((String)paramMap.get(str + "op_type"), 0);
    ((e.a.a.b)localObject1).LUE = ((String)paramMap.get(str + "after_animation_wording"));
    ((e.a.a.b)localObject1).LUF = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((e.a.a.b)localObject1).LUB = new e.a.a.g();
    ((e.a.a.b)localObject1).LUB.Fsx = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((e.a.a.b)localObject1).LUB.Fsy = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((e.a.a.b)localObject1).LUB.Fsz = bs.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!bs.isNullOrNil(((e.a.a.b)localObject1).url)) || (!bs.isNullOrNil(((e.a.a.b)localObject1).LUC)) || (!bs.isNullOrNil(((e.a.a.b)localObject1).LUD)) || (!bs.isNullOrNil(((e.a.a.b)localObject1).LUB.Fsx)) || (!bs.isNullOrNil(((e.a.a.b)localObject1).LUB.Fsy))) {
      localc.LUL = ((e.a.a.b)localObject1);
    }
    AppMethodBeat.o(66581);
    return localc;
    label2417:
    AppMethodBeat.o(66581);
    return null;
  }
  
  public static void e(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66592);
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(2131765981), paramActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66552);
        a.dnc();
        a.ax(this.val$activity);
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
  
  public static void fR(Context paramContext)
  {
    AppMethodBeat.i(66573);
    String str = com.tencent.mm.sdk.platformtools.ab.eUO();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(2131764607);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.e.aT(paramContext, str);
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
    if (ax.isConnected(paramContext)) {
      if (ax.isWifi(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66626);
      return i;
      if (ax.is2G(paramContext))
      {
        i = 2;
      }
      else if (ax.is3G(paramContext))
      {
        i = 3;
      }
      else if (ax.is4G(paramContext))
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
    if (!TextUtils.isEmpty(vvZ))
    {
      str = vvZ;
      AppMethodBeat.o(66596);
      return str;
    }
    dnh();
    if (TextUtils.isEmpty(vvZ)) {
      ac.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = vvZ;
    AppMethodBeat.o(66596);
    return str;
  }
  
  public static String getTokenPin()
  {
    AppMethodBeat.i(66604);
    k.dlZ();
    String str = k.KG(196647);
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
    a(paramActivity, "create", "", dmY(), paramInt);
    AppMethodBeat.o(66591);
  }
  
  public static List<Bankcard> oN(boolean paramBoolean)
  {
    AppMethodBeat.i(66564);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = s.ery().tE(true);
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
    ac.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + localArrayList1.size());
    AppMethodBeat.o(66564);
    return localArrayList1;
  }
  
  public static void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(66597);
    vvZ = paramString1;
    vwa = paramString2;
    vwc = paramString3;
    vwd = paramString4;
    aoK(vwc);
    com.tencent.mm.kernel.g.agQ().ghe.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66554);
        if ((paramAnonymouse == null) || (paramAnonymouse.aBZ() == null))
        {
          AppMethodBeat.o(66554);
          return;
        }
        if (a.vvZ != null) {
          paramAnonymouse.aBZ().i("offline_token", a.vvZ.getBytes());
        }
        if (a.vwa != null) {
          paramAnonymouse.aBZ().i("offline_token_V2", a.vwa.getBytes());
        }
        if (a.vwd != null) {
          paramAnonymouse.aBZ().i("offline_key_list", a.vwd.getBytes());
        }
        AppMethodBeat.o(66554);
      }
    }), 0);
    AppMethodBeat.o(66597);
  }
  
  private static LinkedList<a> y(JSONArray paramJSONArray)
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
        locala.vwn = localJSONObject.optInt("card_id");
        locala.cZz = localJSONObject.optString("bank_type");
        locala.vwo = localJSONObject.optString("bind_serial");
        locala.vwp = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(66603);
    return localLinkedList;
  }
  
  private static LinkedList<b> z(JSONArray paramJSONArray)
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
        localb.cZz = localJSONObject.optString("bank_type");
        localb.oGN = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(66612);
    return localLinkedList;
  }
  
  public static final class a
  {
    public String cZz;
    public int vwn;
    public String vwo;
    public String vwp;
  }
  
  public static final class b
  {
    public String cZz;
    public String oGN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */