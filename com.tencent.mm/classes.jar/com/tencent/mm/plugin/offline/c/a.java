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
import com.tencent.mm.ah.m;
import com.tencent.mm.model.bi;
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
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
  public static String ijW = "";
  private static String mNM = "";
  public static String mNN = "";
  public static int mNO = 1;
  public static String mNP = "";
  public static String mNQ = "";
  public static String mNR = "";
  public static int mNS = 1;
  public static int mNT = 0;
  public static long mNU = 0L;
  public static boolean mNV = false;
  public static String mNW = "";
  public static String mNX = "";
  private static Comparator<Bankcard> mNY = new a.5();
  private static Comparator<a.a> mNZ = new a.6();
  
  public static Orders F(Map<String, String> paramMap)
  {
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.mOL = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.mOM = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.mON = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.mOO = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.bMY = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.iHP = (bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.mOS = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.mOT = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.mOX = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.mPe = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.mOV = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.mOZ = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.mPa = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.mOD = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.qxe = (bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).mPa = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.qxc;
    localCommodity.qxf = ((Orders.Promotions)localObject1).mPa;
    ((Orders.Promotions)localObject1).mTc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.qwE = j;
    localCommodity.qxi = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.qxj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.qxk = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!bk.bl(((Orders.Promotions)localObject1).name))
    {
      localCommodity.qxo = true;
      localCommodity.qxn.add(localObject1);
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
        label746:
        if (!bk.bl(str1)) {
          break label2095;
        }
        y.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[] { Integer.valueOf(i + 1) });
      }
    }
    else
    {
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
      localCommodity.qxp.text = ((String)localObject1);
      localCommodity.qxp.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!bk.bl((String)localObject1)) && (!bk.bl(str1)) && (!bk.bl((String)localObject2)) && (!bk.bl(str2)))
      {
        localCommodity.qxl = new Orders.RecommendTinyAppInfo();
        localCommodity.qxl.qwr = ((String)localObject1);
        localCommodity.qxl.qws = str1;
        localCommodity.qxl.qwt = ((String)localObject2);
        localCommodity.qxl.qhq = str2;
        localCommodity.qxl.qhr = str3;
        localCommodity.qxl.qwu = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.qxl.qxK = bk.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.qxl.qxL = bk.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.qxl.qxN = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.qxl.qxO = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.qxl.qxP = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.qxl.qxM = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.qxl.qwv = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localOrders.qwN = new ArrayList();
      localOrders.qwN.add(localCommodity);
      localOrders.qwX = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.qwY = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.qwG = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.qwE = j;
      localOrders.bMX = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.qxe = (bk.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
      if (TextUtils.isEmpty((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
        break label2347;
      }
      i = 0;
      label1328:
      if (i != 0) {
        break label2296;
      }
    }
    label2095:
    label2296:
    for (localObject1 = "";; localObject1 = String.valueOf(i))
    {
      str1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".favor_desc";
      localObject1 = ".sysmsg.paymsg.user_roll.discount_array.record" + (String)localObject1 + ".payment_amount";
      if ((TextUtils.isEmpty((CharSequence)paramMap.get(str1))) || (TextUtils.isEmpty((CharSequence)paramMap.get(localObject1)))) {
        break label2304;
      }
      localObject2 = new Orders.DiscountInfo();
      ((Orders.DiscountInfo)localObject2).nxN = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).qxz = bk.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.qxh.add(localObject2);
      i += 1;
      break label1328;
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
      break label746;
      localPromotions.mTc = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.qwp = str2;
      localPromotions.type = Orders.qxd;
      localPromotions.qxA = bk.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.qxB = bk.getInt(str5, 0);
      localPromotions.qqG = bk.getLong(str6, 0L);
      localPromotions.qwm = bk.getInt(str7, 0);
      localPromotions.qxC = bk.getInt(str8, 0);
      localPromotions.qwn = bk.getInt(str9, 0);
      localPromotions.qxD = str10;
      localPromotions.qxE = str11;
      localPromotions.qxF = str12;
      localPromotions.qwo = bk.getLong(str13, 0L);
      localPromotions.qxG = bk.getInt(str14, 0);
      localPromotions.qxH = str15;
      localPromotions.qxI = str16;
      localObject1 = b(paramMap, i);
      if (localObject1 != null) {
        localPromotions.qxJ = ((b.a.a.c)localObject1);
      }
      localCommodity.qxn.add(localPromotions);
      i += 1;
      break;
    }
    label2304:
    y.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str1 + ", payment_amount_key is " + (String)localObject1 + ", break");
    return localOrders;
    label2347:
    y.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
    return localOrders;
  }
  
  public static void F(Activity paramActivity)
  {
    a(paramActivity, "freeze", paramActivity.getString(a.i.wallet_wx_offline_freeze_content), 0, -1);
  }
  
  public static void G(Activity paramActivity)
  {
    f(paramActivity, -1);
  }
  
  public static void H(Activity paramActivity)
  {
    com.tencent.mm.ui.base.h.bC(paramActivity, paramActivity.getResources().getString(a.i.wallet_wx_offline_create_success));
    if (!TextUtils.isEmpty(bqZ())) {
      aC(paramActivity, bqZ());
    }
  }
  
  public static void KA(String paramString)
  {
    y.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.g.by(paramString, true);
    if (paramString == null)
    {
      y.w("MicroMsg.WalletOfflineUtil", "can not find app info");
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = new JumpToOfflinePay.Resp();
    ((JumpToOfflinePay.Resp)localObject).errCode = 0;
    ((JumpToOfflinePay.Resp)localObject).toBundle(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramString.field_packageName;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    com.tencent.mm.pluginsdk.model.app.p.ak(localBundle);
    com.tencent.mm.pluginsdk.model.app.p.al(localBundle);
    MMessageActV2.send(ae.getContext(), (MMessageActV2.Args)localObject);
  }
  
  public static void Ko(String paramString)
  {
    k.bpX();
    k.ax(196631, paramString);
  }
  
  public static void Kp(String paramString)
  {
    y.i("MicroMsg.WalletOfflineUtil", "setSelectBindSerial %s %s", new Object[] { paramString, bk.csb().toString() });
    k.bpX();
    k.ax(196633, paramString);
  }
  
  public static void Kq(String paramString)
  {
    k.bpX();
    k.ax(196656, paramString);
    mNP = paramString;
  }
  
  public static LinkedList<a.a> Kr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = r(new JSONArray(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static void Ks(String paramString)
  {
    k.bpX();
    k.ax(196616, paramString);
  }
  
  public static void Kt(String paramString)
  {
    k.bpX();
    k.ax(196615, paramString);
    mNR = paramString;
  }
  
  private static LinkedList<a.b> Ku(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = s(new JSONArray(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static String Kv(String paramString)
  {
    LinkedList localLinkedList = Ku(brb());
    if (localLinkedList == null) {
      return "";
    }
    int i = 0;
    while (i < localLinkedList.size())
    {
      a.b localb = (a.b)localLinkedList.get(i);
      if ((localb != null) && (paramString.equals(localb.mOb))) {
        return localb.iQn;
      }
      i += 1;
    }
    return "";
  }
  
  public static String Kw(String paramString)
  {
    int j = 0;
    Object localObject = Kr(bqW());
    LinkedList localLinkedList = Ku(brb());
    if ((localObject == null) || (localLinkedList == null) || (((LinkedList)localObject).size() == 0) || (localLinkedList.size() == 0))
    {
      y.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
      return "";
    }
    int i = 0;
    a.a locala;
    if (i < ((LinkedList)localObject).size())
    {
      locala = (a.a)((LinkedList)localObject).get(i);
      if ((locala == null) || (!paramString.equals(locala.mOc))) {}
    }
    for (paramString = locala.mOb;; paramString = "")
    {
      if (TextUtils.isEmpty(paramString))
      {
        y.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
        return "";
        i += 1;
        break;
      }
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (a.b)localLinkedList.get(i);
        if ((localObject != null) && (paramString.equals(((a.b)localObject).mOb))) {
          return ((a.b)localObject).iQn;
        }
        i += 1;
      }
      return "";
    }
  }
  
  public static void Kx(String paramString)
  {
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uwz, paramString);
  }
  
  public static void Ky(String paramString)
  {
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxk, paramString);
  }
  
  public static void Kz(String paramString)
  {
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxm, paramString);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.bUW = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!o.bVs().bVN())
    {
      if (o.bVs().bVK())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        return;
      }
      if (o.bVs().bVO())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        return;
      }
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.c.class, localBundle);
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    y.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.mLN == null)) {
      y.e("MicroMsg.WalletOfflineUtil", "order == null");
    }
    while (!bqI()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.mLN);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.cdK != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.a(paramf.cdK.cdl, paramf.cdK.cdm, paramf.cdK.cdn, paramf.cdK.cdo, paramf.cdK.cdp, 8);
      localBundle.putParcelable("key_realname_guide_helper", localRealnameGuideHelper);
    }
    if ((paramActivity instanceof WalletOfflineCoinPurseUI))
    {
      paramf = paramActivity.getIntent();
      localBundle.putString("key_appid", paramf.getStringExtra("key_appid"));
      localBundle.putInt("key_from_scene", paramf.getIntExtra("key_from_scene", 0));
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, j.class, localBundle);
  }
  
  public static void a(Activity paramActivity, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
    if (TextUtils.isEmpty(paramString)) {
      y.e("MicroMsg.WalletOfflineUtil", "transid == null");
    }
    while (!bqI()) {
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramm instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramm = ((com.tencent.mm.plugin.offline.a.e)paramm).mKP;
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
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("oper", paramString1);
    localBundle.putInt("offline_chg_fee", paramInt1);
    localBundle.putString("pwd_tips", paramString2);
    if (paramInt2 >= 0) {
      localBundle.putInt("offline_from_scene", paramInt2);
    }
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.h.class, localBundle);
  }
  
  private static void a(Orders paramOrders, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramOrders.qwZ = bk.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.qxb = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record.";; str = ".sysmsg.paymsg.user_roll.show_info.record." + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.kOn = ((String)paramMap.get(str + "name_color"));
          localShowInfo.qxS = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.qxT = bk.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.qxU = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.qxV = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.qxW = ((String)paramMap.get(str + "link_url"));
          localShowInfo.qxX = bk.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!bk.bl(localShowInfo.name)) || (!bk.bl(localShowInfo.value))) {
            paramOrders.qxb.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
  }
  
  private static void aC(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  private static b.a.a.c b(Map<String, String> paramMap, int paramInt)
  {
    b.a.a.c localc;
    if (paramInt == 0)
    {
      str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
      if (paramMap == null) {
        break label2368;
      }
      localc = new b.a.a.c();
      localc.xpn = bk.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.sRh = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.sTg = bk.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localObject1 = new b.a.a.a();
      localObject2 = str + "btn_info.";
      ((b.a.a.a)localObject1).xpf = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((b.a.a.a)localObject1).xpg = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((b.a.a.a)localObject1).xph = bk.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((b.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((b.a.a.a)localObject1).teX = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((b.a.a.a)localObject1).xpi = new b.a.a.f();
      ((b.a.a.a)localObject1).xpi.tyu = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((b.a.a.a)localObject1).xpi.tyv = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((b.a.a.a)localObject1).xpi.tyw = bk.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!bk.bl(((b.a.a.a)localObject1).xpf)) || (!bk.bl(((b.a.a.a)localObject1).url)) || (!bk.bl(((b.a.a.a)localObject1).teX)) || (!bk.bl(((b.a.a.a)localObject1).xpi.tyu)) || (!bk.bl(((b.a.a.a)localObject1).xpi.tyv))) {
        localc.sTh = ((b.a.a.a)localObject1);
      }
      localc.xpo = bk.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.xpp = bk.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.xpr = ((String)paramMap.get(str + "background_img_whole"));
      localc.sTf = new LinkedList();
      paramInt = 0;
      label670:
      if (paramInt >= 255) {
        break label1082;
      }
      if (paramInt != 0) {
        break label1048;
      }
    }
    label1048:
    for (Object localObject1 = str + "single_exposure_info_list.record.";; localObject1 = str + "single_exposure_info_list.record" + paramInt + ".")
    {
      localObject2 = new b.a.a.g();
      ((b.a.a.g)localObject2).mTc = ((String)paramMap.get((String)localObject1 + "logo"));
      ((b.a.a.g)localObject2).xpC = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((b.a.a.g)localObject2).xpD = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((b.a.a.g)localObject2).xpE = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((b.a.a.g)localObject2).xpF = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((b.a.a.g)localObject2).xpG = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!bk.bl(((b.a.a.g)localObject2).mTc)) || (!bk.bl(((b.a.a.g)localObject2).xpC)) || (!bk.bl(((b.a.a.g)localObject2).xpD)) || (!bk.bl(((b.a.a.g)localObject2).xpE)) || (!bk.bl(((b.a.a.g)localObject2).xpF)) || (!bk.bl(((b.a.a.g)localObject2).xpG))) {
        localc.sTf.add(localObject2);
      }
      if ((bk.bl(((b.a.a.g)localObject2).xpC)) || (bk.bl(((b.a.a.g)localObject2).xpD))) {
        break label1082;
      }
      paramInt += 1;
      break label670;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1082:
    localc.xpq = new b.a.a.e();
    localObject1 = str + "layer_info.";
    localc.xpq.xpt = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.xpq.xpu = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.xpq.xpv = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.xpq.xpw = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.xpq.xpx = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.xpq.xpy = bk.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.xpq.xpz = new b.a.a.d();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.xpq.xpz.xpf = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.xpq.xpz.xpg = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.xpq.xpz.xph = bk.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.xpq.xpz.teX = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.xpq.xpz.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.xpq.xpz.xpi = new b.a.a.f();
    localc.xpq.xpz.xpi.tyu = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.xpq.xpz.xpi.tyv = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.xpq.xpz.xpi.tyw = bk.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!bk.bl((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.xpq.xpA = new com.tencent.mm.bv.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!bk.bl((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.xpq.xpB = new com.tencent.mm.bv.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new b.a.a.b();
    String str = str + "draw_lottery_info.";
    ((b.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((b.a.a.b)localObject1).xpj = ((String)paramMap.get(str + "animation_wording"));
    ((b.a.a.b)localObject1).xpk = ((String)paramMap.get(str + "animation_wording_color"));
    ((b.a.a.b)localObject1).tPH = bk.getInt((String)paramMap.get(str + "op_type"), 0);
    ((b.a.a.b)localObject1).xpl = ((String)paramMap.get(str + "after_animation_wording"));
    ((b.a.a.b)localObject1).xpm = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((b.a.a.b)localObject1).xpi = new b.a.a.f();
    ((b.a.a.b)localObject1).xpi.tyu = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((b.a.a.b)localObject1).xpi.tyv = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((b.a.a.b)localObject1).xpi.tyw = bk.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!bk.bl(((b.a.a.b)localObject1).url)) || (!bk.bl(((b.a.a.b)localObject1).xpj)) || (!bk.bl(((b.a.a.b)localObject1).xpk)) || (!bk.bl(((b.a.a.b)localObject1).xpi.tyu)) || (!bk.bl(((b.a.a.b)localObject1).xpi.tyv))) {
      localc.xps = ((b.a.a.b)localObject1);
    }
    return localc;
    label2368:
    return null;
  }
  
  public static boolean bqH()
  {
    k.bpX();
    String str = k.vA(196630);
    return (str != null) && (str.equals("1"));
  }
  
  public static boolean bqI()
  {
    k.bpX();
    String str = k.vA(196641);
    return (str != null) && (str.equals("1"));
  }
  
  public static Bankcard bqJ()
  {
    Object localObject2 = bqR();
    y.i("MicroMsg.WalletOfflineUtil", "step 1 getSelectedBindBankCard %s", new Object[] { localObject2 });
    Object localObject1 = o.bVs().kB(true);
    int i = 0;
    while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i < ((List)localObject1).size()))
    {
      Bankcard localBankcard = (Bankcard)((List)localObject1).get(i);
      if ((localBankcard != null) && (((String)localObject2).equals(localBankcard.field_bindSerial)))
      {
        y.i("MicroMsg.WalletOfflineUtil", "step 2 micropay: %s, forbidword: %s", new Object[] { Boolean.valueOf(localBankcard.field_support_micropay), localBankcard.field_forbidWord });
        if (localBankcard.field_support_micropay) {
          return localBankcard;
        }
      }
      i += 1;
    }
    y.i("MicroMsg.WalletOfflineUtil", "step 3 clear default bindserial");
    Kp("");
    localObject2 = bqL();
    if ((localObject2 != null) && (bk.bl(((Bankcard)localObject2).field_forbidWord)))
    {
      y.i("MicroMsg.WalletOfflineUtil", "do change main card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
      return localObject2;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (Bankcard)((List)localObject1).get(i);
      if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (!((Bankcard)localObject2).bUQ()))
      {
        y.i("MicroMsg.WalletOfflineUtil", "do change first card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
        return localObject2;
      }
      i += 1;
    }
    localObject1 = o.bVs().qhj;
    if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay))
    {
      y.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
      return localObject1;
    }
    localObject1 = o.bVs().qzj;
    if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay) && (bk.bl(((Bankcard)localObject1).field_forbidWord)))
    {
      y.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
      return localObject1;
    }
    return null;
  }
  
  public static Bankcard bqK()
  {
    Object localObject = bqJ();
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (bk.bl(((Bankcard)localObject).field_forbidWord))) {
      return localObject;
    }
    ArrayList localArrayList = o.bVs().kt(true);
    int i = 0;
    for (;;)
    {
      if (i >= localArrayList.size()) {
        break label78;
      }
      Bankcard localBankcard = (Bankcard)localArrayList.get(i);
      if (localBankcard != null)
      {
        localObject = localBankcard;
        if (localBankcard.field_support_micropay) {
          break;
        }
      }
      i += 1;
    }
    label78:
    return null;
  }
  
  public static Bankcard bqL()
  {
    Bankcard localBankcard = o.bVs().a(null, null, true, true);
    if (localBankcard == null) {
      y.e("MicroMsg.WalletOfflineUtil", "defaultBankcards == null");
    }
    return localBankcard;
  }
  
  public static int bqM()
  {
    return o.bVs().kt(true).size();
  }
  
  public static List<Bankcard> bqN()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = o.bVs().kB(true);
    int i = 0;
    while (i < localArrayList2.size())
    {
      localArrayList1.add((Bankcard)localArrayList2.get(i));
      i += 1;
    }
    y.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + localArrayList1.size());
    return localArrayList1;
  }
  
  public static int bqO()
  {
    k.bpX();
    String str = k.vA(196629);
    if ((TextUtils.isEmpty(str)) || (!yS(str))) {
      return 0;
    }
    return Integer.valueOf(str).intValue();
  }
  
  public static String bqP()
  {
    k.bpX();
    return k.vA(196632);
  }
  
  public static String bqQ()
  {
    k.bpX();
    return k.vA(196631);
  }
  
  public static String bqR()
  {
    k.bpX();
    return k.vA(196633);
  }
  
  public static void bqS()
  {
    y.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.bpX();
    k.ax(196630, "0");
    k.bpX();
    k.ax(196626, "");
    k.bpX();
    k.ax(196627, "");
    k.bpX();
    k.ax(196628, "");
    k.bpX();
    k.ax(196617, "");
    k.bpX();
    k.ax(196632, "");
    k.bpX();
    k.ax(196641, "");
    k.bpX();
    k.ax(196647, "");
    k.bpX();
    k.ax(196649, "");
    p("", "", "", "");
    k.bpX();
    k.ax(196629, "0");
    Ko("");
    k.bpX();
    k.bpY().mLy = null;
    k.bpX();
    k.bqa();
    k.bpX();
    String str = k.vA(196617);
    com.tencent.mm.wallet_core.c.a.cMr();
    com.tencent.mm.wallet_core.c.a.clearToken(str);
    Kt("");
    Kq("");
  }
  
  public static void bqT()
  {
    k.bpX();
    k.ax(196643, "1");
  }
  
  public static int bqU()
  {
    k.bpX();
    String str = k.vA(196644);
    if ((TextUtils.isEmpty(str)) || (!yS(str))) {
      return 0;
    }
    return Integer.valueOf(str).intValue();
  }
  
  public static String bqV()
  {
    if (!TextUtils.isEmpty(mNN)) {
      return mNN;
    }
    bqX();
    if (TextUtils.isEmpty(mNN)) {
      y.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    return mNN;
  }
  
  public static String bqW()
  {
    if (!TextUtils.isEmpty(mNP)) {
      return mNP;
    }
    if (TextUtils.isEmpty(mNP))
    {
      k.bpX();
      String str = k.vA(196656);
      mNP = str;
      return str;
    }
    if (TextUtils.isEmpty(mNP)) {
      y.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    return mNP;
  }
  
  private static void bqX()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(new bi(new a.4()), 0);
  }
  
  public static String bqY()
  {
    k.bpX();
    return k.vA(196647);
  }
  
  private static String bqZ()
  {
    k.bpX();
    return k.vA(196616);
  }
  
  public static boolean bra()
  {
    int j = 0;
    ArrayList localArrayList = o.bVs().kt(true);
    Object localObject = Kr(bqW());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size())) {
      return false;
    }
    Collections.sort((List)localObject, mNZ);
    Collections.sort(localArrayList, mNY);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a.a)((LinkedList)localObject).get(i)).mOc);
      i += 1;
    }
    localObject = new StringBuilder();
    i = j;
    while (i < localArrayList.size())
    {
      ((StringBuilder)localObject).append(((Bankcard)localArrayList.get(i)).field_bindSerial);
      i += 1;
    }
    return ad.bB(localStringBuilder.toString()).equals(ad.bB(((StringBuilder)localObject).toString()));
  }
  
  private static String brb()
  {
    if (TextUtils.isEmpty(mNR))
    {
      k.bpX();
      String str = k.vA(196615);
      mNR = str;
      return str;
    }
    return mNR;
  }
  
  public static int brc()
  {
    k.bpX();
    String str = k.vA(196649);
    if ((TextUtils.isEmpty(str)) || (!yS(str))) {
      return 0;
    }
    return Integer.valueOf(str).intValue();
  }
  
  public static boolean brd()
  {
    String str = bqP();
    if (TextUtils.isEmpty(str)) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = brc();
      l2 = Long.valueOf(str).longValue();
    } while (System.currentTimeMillis() / 1000L - l2 < l1);
    return true;
  }
  
  public static String bre()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uwz, "");
    if (localObject != null) {
      return (String)localObject;
    }
    return null;
  }
  
  public static String brf()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxk, "");
    if (localObject != null) {
      return (String)localObject;
    }
    return null;
  }
  
  public static int brg()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxl, null);
    if (localObject != null) {}
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      return j;
    }
  }
  
  public static String brh()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxm, "");
    if (localObject != null) {
      return (String)localObject;
    }
    return null;
  }
  
  public static boolean bri()
  {
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).ctr();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        y.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.c.IX().fJ("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).ctr();
      bool1 = bool2;
      if (((Map)localObject).containsKey("open"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("open"))) {
          bool1 = true;
        }
      }
    }
    y.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: " + bool1);
    return bool1;
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(a.i.wallet_wx_offline_recreate_offline_text), paramActivity.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new a.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        a.bqS();
        a.G(this.val$activity);
        this.val$activity.finish();
      }
    }, new a.2(paramActivity));
  }
  
  public static void d(Activity paramActivity, int paramInt)
  {
    a(paramActivity, paramInt, -1);
  }
  
  public static boolean dR(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      y.d("MicroMsg.WalletOfflineUtil", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        y.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
        return false;
      }
    }
    if (((KeyguardManager)ae.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      return false;
    }
    y.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
    return true;
  }
  
  public static void dW(Context paramContext)
  {
    String str = x.cqJ();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(a.i.url_wallet_offline_user_guide_url);
    }
    for (;;)
    {
      aC(paramContext, str);
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
  
  public static void e(Activity paramActivity, int paramInt)
  {
    a(paramActivity, "create", paramActivity.getString(a.i.wallet_wx_offline_create_offline), 0, paramInt);
  }
  
  public static void f(Activity paramActivity, int paramInt)
  {
    k.bpX();
    String str = k.vA(196640);
    int i;
    if ((TextUtils.isEmpty(str)) || (!yS(str)))
    {
      i = 0;
      if (i <= 0) {
        break label59;
      }
      i *= 100;
    }
    for (;;)
    {
      a(paramActivity, "create", "", i, paramInt);
      return;
      i = Integer.valueOf(str).intValue();
      break;
      label59:
      i = 20000;
    }
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (aq.isConnected(paramContext))
    {
      if (aq.isWifi(paramContext)) {
        return 1;
      }
      if (aq.is2G(paramContext)) {
        return 2;
      }
      if (aq.is3G(paramContext)) {
        return 3;
      }
      if (aq.is4G(paramContext)) {
        return 4;
      }
      return 0;
    }
    return -1;
  }
  
  public static String getToken()
  {
    if (!TextUtils.isEmpty(mNM)) {
      return mNM;
    }
    bqX();
    if (TextUtils.isEmpty(mNM)) {
      y.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    return mNM;
  }
  
  public static List<Bankcard> ib(boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = o.bVs().kt(true);
    int i = 0;
    if (i < localArrayList2.size())
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
    y.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + localArrayList1.size());
    return localArrayList1;
  }
  
  public static void p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mNM = paramString1;
    mNN = paramString2;
    mNP = paramString3;
    mNQ = paramString4;
    Kq(mNP);
    com.tencent.mm.kernel.g.DO().dJT.a(new bi(new a.3()), 0);
  }
  
  private static LinkedList<a.a> r(JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 0) {
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
        locala.mOa = localJSONObject.optInt("card_id");
        locala.mOb = localJSONObject.optString("bank_type");
        locala.mOc = localJSONObject.optString("bind_serial");
        locala.mOd = localJSONObject.optString("forbid_word");
        localLinkedList.add(locala);
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  private static LinkedList<a.b> s(JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 0) {
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
        localb.mOb = localJSONObject.optString("bank_type");
        localb.iQn = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public static void vE(int paramInt)
  {
    k.bpX();
    k.ax(196640, String.valueOf(paramInt));
  }
  
  public static void vF(int paramInt)
  {
    k.bpX();
    k.ax(196642, String.valueOf(paramInt));
  }
  
  public static void vG(int paramInt)
  {
    k.bpX();
    k.ax(196644, String.valueOf(paramInt));
  }
  
  public static void vH(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxl, Integer.valueOf(i));
  }
  
  public static boolean yS(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */