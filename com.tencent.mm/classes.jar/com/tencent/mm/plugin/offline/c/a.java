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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
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
  public static String nqb;
  private static String und;
  public static String une;
  public static int unf;
  public static String ung;
  public static String unh;
  public static String uni;
  public static int unj;
  public static int unk;
  public static long unl;
  public static boolean unm;
  public static String unn;
  public static String uno;
  private static Comparator<Bankcard> unp;
  private static Comparator<a> unq;
  
  static
  {
    AppMethodBeat.i(66629);
    und = "";
    une = "";
    unf = 1;
    ung = "";
    unh = "";
    uni = "";
    unj = 1;
    unk = 0;
    unl = 0L;
    unm = false;
    nqb = "";
    unn = "";
    uno = "";
    unp = new a.5();
    unq = new a.6();
    AppMethodBeat.o(66629);
  }
  
  public static void IN(int paramInt)
  {
    AppMethodBeat.i(66568);
    k.cYr();
    k.bp(196640, String.valueOf(paramInt));
    AppMethodBeat.o(66568);
  }
  
  public static void IO(int paramInt)
  {
    AppMethodBeat.i(66569);
    k.cYr();
    k.bp(196642, String.valueOf(paramInt));
    AppMethodBeat.o(66569);
  }
  
  public static void IP(int paramInt)
  {
    AppMethodBeat.i(66594);
    k.cYr();
    k.bp(196644, String.valueOf(paramInt));
    AppMethodBeat.o(66594);
  }
  
  public static void IQ(int paramInt)
  {
    AppMethodBeat.i(66622);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqn, Integer.valueOf(i));
    AppMethodBeat.o(66622);
  }
  
  public static void IR(int paramInt)
  {
    AppMethodBeat.i(182496);
    if (paramInt > 0)
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpt, Integer.valueOf(paramInt));
      k.ujt = paramInt;
      ad.i("MicroMsg.WalletOfflineUtil", "set token num: %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(182496);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66585);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dtc = 5;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_pay_info", localPayInfo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 5);
    localBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      localBundle.putInt("key_entry_scene", paramInt2);
    }
    if (!s.ecc().ecF())
    {
      if (s.ecc().ecH())
      {
        localBundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.offline.d.class, localBundle);
        AppMethodBeat.o(66585);
        return;
      }
      if (s.ecc().ecG())
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
    localPayInfo.dtc = 5;
    paramBundle.putParcelable("key_pay_info", localPayInfo);
    paramBundle.putBoolean("key_need_bind_response", true);
    paramBundle.putInt("key_bind_scene", 5);
    paramBundle.putInt("key_offline_add_fee", paramInt1);
    if (paramInt2 >= 0) {
      paramBundle.putInt("key_entry_scene", paramInt2);
    }
    if (paramBundle != null)
    {
      com.tencent.mm.wallet_core.c.ab.jZ(6, paramBundle.getInt("key_bind_scene"));
      z.abt(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramActivity, paramBundle);
      AppMethodBeat.o(66586);
      return;
      com.tencent.mm.wallet_core.c.ab.jZ(6, 0);
      z.abt(0);
    }
  }
  
  public static void a(Activity paramActivity, s.f paramf)
  {
    AppMethodBeat.i(66579);
    ad.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
    if ((paramf == null) || (paramf.ukK == null))
    {
      ad.e("MicroMsg.WalletOfflineUtil", "order == null");
      AppMethodBeat.o(66579);
      return;
    }
    if (!cZj())
    {
      AppMethodBeat.o(66579);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_orders", paramf.ukK);
    localBundle.putInt("key_pay_type", 2);
    if (paramf.dDs != null)
    {
      RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
      localRealnameGuideHelper.b(paramf.dDs.dCT, paramf.dDs.dCU, paramf.dDs.dCV, paramf.dDs.dCW, paramf.dDs.dCX, 8);
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
    if (!cZj())
    {
      AppMethodBeat.o(66583);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
    {
      paramn = ((com.tencent.mm.plugin.offline.a.e)paramn).ujM;
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
      paramOrders.AfJ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
      paramOrders.AfL = new ArrayList();
      int i = 0;
      if (i < 255)
      {
        if (i == 0) {}
        for (String str = ".sysmsg.paymsg.user_roll.show_info.record" + ".";; str = ".sysmsg.paymsg.user_roll.show_info.record" + i + ".")
        {
          Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
          localShowInfo.name = ((String)paramMap.get(str + "name"));
          localShowInfo.value = ((String)paramMap.get(str + "value"));
          localShowInfo.rVi = ((String)paramMap.get(str + "name_color"));
          localShowInfo.AgM = ((String)paramMap.get(str + "value_color"));
          str = str + "value_attr.";
          localShowInfo.AgN = bt.getInt((String)paramMap.get(str + "link_type"), 0);
          localShowInfo.AgO = ((String)paramMap.get(str + "link_weapp"));
          localShowInfo.AgP = ((String)paramMap.get(str + "link_addr"));
          localShowInfo.AgQ = ((String)paramMap.get(str + "link_url"));
          localShowInfo.AgR = bt.getInt((String)paramMap.get(str + "text_attr"), 0);
          if ((!bt.isNullOrNil(localShowInfo.name)) || (!bt.isNullOrNil(localShowInfo.value))) {
            paramOrders.AfL.add(localShowInfo);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(66582);
  }
  
  public static void ajK(String paramString)
  {
    AppMethodBeat.i(66572);
    k.cYr();
    k.bp(196631, paramString);
    AppMethodBeat.o(66572);
  }
  
  public static void ajL(String paramString)
  {
    AppMethodBeat.i(66577);
    s.ecc();
    am.atX(paramString);
    AppMethodBeat.o(66577);
  }
  
  public static void ajM(String paramString)
  {
    AppMethodBeat.i(66600);
    k.cYr();
    k.bp(196656, paramString);
    ung = paramString;
    AppMethodBeat.o(66600);
  }
  
  public static LinkedList<a> ajN(String paramString)
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
      ad.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66602);
    }
    return null;
  }
  
  public static void ajO(String paramString)
  {
    AppMethodBeat.i(66606);
    k.cYr();
    k.bp(196616, paramString);
    AppMethodBeat.o(66606);
  }
  
  public static void ajP(String paramString)
  {
    AppMethodBeat.i(66610);
    k.cYr();
    k.bp(196615, paramString);
    uni = paramString;
    AppMethodBeat.o(66610);
  }
  
  private static LinkedList<b> ajQ(String paramString)
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
      ad.printErrStackTrace("MicroMsg.WalletOfflineUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(66611);
    }
    return null;
  }
  
  public static String ajR(String paramString)
  {
    AppMethodBeat.i(66615);
    LinkedList localLinkedList = ajQ(cZC());
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
      if ((localb == null) || (!paramString.equals(localb.dca))) {}
    }
    for (paramString = localb.odo;; paramString = "")
    {
      AppMethodBeat.o(66615);
      return paramString;
      i += 1;
      break;
    }
  }
  
  public static String ajS(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(66616);
    Object localObject = ajN(cZy());
    LinkedList localLinkedList = ajQ(cZC());
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
      if ((locala == null) || (!paramString.equals(locala.uns))) {}
    }
    for (paramString = locala.dca;; paramString = "")
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
        if ((localObject == null) || (!paramString.equals(((b)localObject).dca))) {}
      }
      for (paramString = ((b)localObject).odo;; paramString = "")
      {
        AppMethodBeat.o(66616);
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  public static void ajT(String paramString)
  {
    AppMethodBeat.i(66618);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpr, paramString);
    AppMethodBeat.o(66618);
  }
  
  public static void ajU(String paramString)
  {
    AppMethodBeat.i(66620);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqm, paramString);
    AppMethodBeat.o(66620);
  }
  
  public static void ajV(String paramString)
  {
    AppMethodBeat.i(66624);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqo, paramString);
    AppMethodBeat.o(66624);
  }
  
  public static void ajW(String paramString)
  {
    AppMethodBeat.i(66628);
    ad.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[] { paramString });
    paramString = com.tencent.mm.pluginsdk.model.app.h.j(paramString, true, false);
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
    com.tencent.mm.pluginsdk.model.app.q.aS(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.aT(localBundle);
    MMessageActV2.send(aj.getContext(), (MMessageActV2.Args)localObject);
    AppMethodBeat.o(66628);
  }
  
  public static Orders am(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66580);
    Orders localOrders = new Orders();
    Orders.Commodity localCommodity = new Orders.Commodity();
    localCommodity.uob = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_uin"));
    localCommodity.uoc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_name"));
    localCommodity.uod = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_uin"));
    localCommodity.uoe = ((String)paramMap.get(".sysmsg.paymsg.user_roll.sale_name"));
    localCommodity.dcF = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trans_id"));
    localCommodity.desc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.goods_name"));
    localCommodity.nUf = (bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_num"), -1) / 100.0D);
    localCommodity.uoi = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state"));
    localCommodity.uoj = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
    localCommodity.uon = ((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"));
    localCommodity.uou = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount"));
    localCommodity.uol = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
    localCommodity.uop = ((String)paramMap.get(".sysmsg.paymsg.user_roll.fee_type"));
    localCommodity.uoq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.appusername"));
    localCommodity.unT = ((String)paramMap.get(".sysmsg.paymsg.user_roll.app_telephone"));
    localCommodity.AfY = (bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1) / 100.0D);
    Object localObject1 = new Orders.Promotions();
    ((Orders.Promotions)localObject1).name = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname"));
    ((Orders.Promotions)localObject1).uoq = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username"));
    ((Orders.Promotions)localObject1).type = Orders.AfW;
    localCommodity.AfZ = ((Orders.Promotions)localObject1).uoq;
    ((Orders.Promotions)localObject1).uwS = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url"));
    ((Orders.Promotions)localObject1).url = ((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url"));
    int j = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
    localCommodity.Afn = j;
    localCommodity.Agc = ((String)paramMap.get(".sysmsg.paymsg.user_roll.rateinfo"));
    localCommodity.Agd = ((String)paramMap.get(".sysmsg.paymsg.user_roll.discount_rateinfo"));
    localCommodity.Age = ((String)paramMap.get(".sysmsg.paymsg.user_roll.original_feeinfo"));
    if (!bt.isNullOrNil(((Orders.Promotions)localObject1).name))
    {
      localCommodity.Agi = true;
      localCommodity.Agh.add(localObject1);
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
      localCommodity.Agj.text = ((String)localObject1);
      localCommodity.Agj.url = str1;
      localObject1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
      str1 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
      localObject2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
      str2 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
      str3 = (String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str1)) && (!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil(str2)))
      {
        localCommodity.Agf = new Orders.RecommendTinyAppInfo();
        localCommodity.Agf.zVm = ((String)localObject1);
        localCommodity.Agf.Afb = str1;
        localCommodity.Agf.Afc = ((String)localObject2);
        localCommodity.Agf.zHs = str2;
        localCommodity.Agf.zHt = str3;
        localCommodity.Agf.Afd = ((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text"));
        localCommodity.Agf.AgE = bt.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0L);
        localCommodity.Agf.AgF = bt.getLong((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0L);
        localCommodity.Agf.AgH = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
        localCommodity.Agf.AgI = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
        localCommodity.Agf.AgJ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
        localCommodity.Agf.AgG = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
        localCommodity.Agf.Afe = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
      }
      localOrders.Afx = new ArrayList();
      localOrders.Afx.add(localCommodity);
      localOrders.AfH = bt.getInt((String)paramMap.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
      localOrders.AfI = ((String)paramMap.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording"));
      localOrders.Afp = ((String)paramMap.get(".sysmsg.paymsg.user_roll.trade_state_name"));
      localOrders.Afn = j;
      localOrders.dcE = ((String)paramMap.get(".sysmsg.req_key"));
      a(localOrders, paramMap);
      localCommodity.AfY = (bt.getDouble((String)paramMap.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0D) / 100.0D);
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
      ((Orders.DiscountInfo)localObject2).vzN = ((String)paramMap.get(str1));
      ((Orders.DiscountInfo)localObject2).Agt = bt.getDouble((String)paramMap.get(localObject1), 0.0D);
      localCommodity.Agb.add(localObject2);
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
      localPromotions.uwS = ((String)localObject1);
      localPromotions.name = str1;
      localPromotions.url = ((String)localObject2);
      localPromotions.AeZ = str2;
      localPromotions.type = Orders.AfX;
      localPromotions.Agu = bt.getInt(str3, 0);
      localPromotions.title = str4;
      localPromotions.LvT = bt.getInt(str5, 0);
      localPromotions.zWi = bt.getLong(str6, 0L);
      localPromotions.AeW = bt.getInt(str7, 0);
      localPromotions.LvU = bt.getInt(str8, 0);
      localPromotions.AeX = bt.getInt(str9, 0);
      localPromotions.LvV = str10;
      localPromotions.LvW = str11;
      localPromotions.LvX = str12;
      localPromotions.AeY = bt.getLong(str13, 0L);
      localPromotions.LvY = bt.getInt(str14, 0);
      localPromotions.LvZ = str15;
      localPromotions.Lwa = str16;
      localObject1 = e(paramMap, i);
      if (localObject1 != null) {
        localPromotions.AgD = ((e.a.a.c)localObject1);
      }
      localCommodity.Agh.add(localPromotions);
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
  
  public static void as(Activity paramActivity)
  {
    AppMethodBeat.i(66589);
    a(paramActivity, "freeze", paramActivity.getString(2131765964), 0, -1);
    AppMethodBeat.o(66589);
  }
  
  public static void at(Activity paramActivity)
  {
    AppMethodBeat.i(66590);
    k(paramActivity, -1);
    AppMethodBeat.o(66590);
  }
  
  public static void au(Activity paramActivity)
  {
    AppMethodBeat.i(66607);
    com.tencent.mm.ui.base.h.cf(paramActivity, paramActivity.getResources().getString(2131765962));
    if (!TextUtils.isEmpty(cZA())) {
      com.tencent.mm.wallet_core.ui.e.aS(paramActivity, cZA());
    }
    AppMethodBeat.o(66607);
  }
  
  public static boolean cB(Context paramContext)
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
  
  private static String cZA()
  {
    AppMethodBeat.i(66605);
    k.cYr();
    String str = k.IH(196616);
    AppMethodBeat.o(66605);
    return str;
  }
  
  public static boolean cZB()
  {
    int j = 0;
    AppMethodBeat.i(66608);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwT, 0) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.WalletOfflineUtil", "pass same md5 case");
      AppMethodBeat.o(66608);
      return true;
    }
    ArrayList localArrayList = s.ecc().sC(true);
    Object localObject = ajN(cZy());
    if ((localObject == null) || (localArrayList.size() != ((LinkedList)localObject).size()))
    {
      AppMethodBeat.o(66608);
      return false;
    }
    Collections.sort((List)localObject, unq);
    Collections.sort(localArrayList, unp);
    StringBuilder localStringBuilder = new StringBuilder();
    i = 0;
    while (i < ((LinkedList)localObject).size())
    {
      localStringBuilder.append(((a)((LinkedList)localObject).get(i)).uns);
      i += 1;
    }
    localObject = new StringBuilder();
    i = j;
    while (i < localArrayList.size())
    {
      ((StringBuilder)localObject).append(((Bankcard)localArrayList.get(i)).field_bindSerial);
      i += 1;
    }
    boolean bool = ai.du(localStringBuilder.toString()).equals(ai.du(((StringBuilder)localObject).toString()));
    AppMethodBeat.o(66608);
    return bool;
  }
  
  private static String cZC()
  {
    AppMethodBeat.i(66609);
    if (TextUtils.isEmpty(uni))
    {
      k.cYr();
      str = k.IH(196615);
      uni = str;
      AppMethodBeat.o(66609);
      return str;
    }
    String str = uni;
    AppMethodBeat.o(66609);
    return str;
  }
  
  public static int cZD()
  {
    AppMethodBeat.i(66613);
    k.cYr();
    String str = k.IH(196649);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66613);
      return 0;
    }
    int i = bt.getInt(str, 0);
    AppMethodBeat.o(66613);
    return i;
  }
  
  public static boolean cZE()
  {
    AppMethodBeat.i(66614);
    String str = cZr();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(66614);
      return false;
    }
    long l1 = cZD();
    long l2 = Long.valueOf(str).longValue();
    if (System.currentTimeMillis() / 1000L - l2 >= l1)
    {
      AppMethodBeat.o(66614);
      return true;
    }
    AppMethodBeat.o(66614);
    return false;
  }
  
  public static String cZF()
  {
    AppMethodBeat.i(66619);
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fpr, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66619);
      return localObject;
    }
    AppMethodBeat.o(66619);
    return null;
  }
  
  public static String cZG()
  {
    AppMethodBeat.i(66621);
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqm, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66621);
      return localObject;
    }
    AppMethodBeat.o(66621);
    return null;
  }
  
  public static int cZH()
  {
    AppMethodBeat.i(66623);
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqn, null);
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
  
  public static String cZI()
  {
    AppMethodBeat.i(66625);
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqo, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(66625);
      return localObject;
    }
    AppMethodBeat.o(66625);
    return null;
  }
  
  public static boolean cZJ()
  {
    AppMethodBeat.i(66627);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.d.aty().qu("100232");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).eJy();
      if ((((Map)localObject).containsKey("open")) && ("1".equals(((Map)localObject).get("open")))) {
        ad.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
      }
    }
    localObject = com.tencent.mm.model.c.d.aty().qu("100261");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).eJy();
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
  
  public static int cZK()
  {
    return k.ujt;
  }
  
  public static boolean cZi()
  {
    AppMethodBeat.i(66558);
    k.cYr();
    String str = k.IH(196630);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66558);
      return true;
    }
    AppMethodBeat.o(66558);
    return false;
  }
  
  public static boolean cZj()
  {
    AppMethodBeat.i(66559);
    k.cYr();
    String str = k.IH(196641);
    if ((str != null) && (str.equals("1")))
    {
      AppMethodBeat.o(66559);
      return true;
    }
    AppMethodBeat.o(66559);
    return false;
  }
  
  @Deprecated
  public static Bankcard cZk()
  {
    AppMethodBeat.i(66560);
    s.ecc();
    Object localObject2 = am.edk();
    ad.i("MicroMsg.WalletPayOrderMgr", "step 1 getSelectedBindBankCard %s", new Object[] { localObject2 });
    Object localObject3 = s.ecc();
    Object localObject1;
    if (((am)localObject3).Aif == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label508;
      }
      localObject1 = s.ecc().sC(true);
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
            if ((((am)localObject3).zHd != null) && (!((am)localObject3).ecH())) {
              ((ArrayList)localObject1).add(((am)localObject3).zHd);
            }
            if ((((am)localObject3).Ain != null) && (!((am)localObject3).ecH())) {
              ((ArrayList)localObject1).add(((am)localObject3).Ain);
            }
            if (((am)localObject3).Aif.size() > 0)
            {
              localObject3 = ((am)localObject3).Aif.iterator();
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
      s.ecc();
      am.atX("");
      s.ecc();
      localObject2 = am.edq();
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
        if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (!((Bankcard)localObject2).ebv()))
        {
          ad.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", new Object[] { ((Bankcard)localObject2).field_bankcardType });
          AppMethodBeat.o(66560);
          return localObject2;
        }
        i += 1;
      }
      localObject1 = s.ecc().zHd;
      if ((localObject1 != null) && (((Bankcard)localObject1).field_support_micropay))
      {
        ad.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", new Object[] { ((Bankcard)localObject1).field_bankcardType });
        AppMethodBeat.o(66560);
        return localObject1;
      }
      localObject1 = s.ecc().Ain;
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
  
  public static Bankcard cZl()
  {
    AppMethodBeat.i(66561);
    Object localObject = cZk();
    if ((localObject != null) && (((Bankcard)localObject).field_support_micropay) && (bt.isNullOrNil(((Bankcard)localObject).field_forbidWord)))
    {
      AppMethodBeat.o(66561);
      return localObject;
    }
    localObject = s.ecc().sC(true);
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
  
  public static Bankcard cZm()
  {
    AppMethodBeat.i(66562);
    s.ecc();
    Bankcard localBankcard = am.edq();
    AppMethodBeat.o(66562);
    return localBankcard;
  }
  
  public static int cZn()
  {
    AppMethodBeat.i(66563);
    int i = s.ecc().sC(true).size();
    AppMethodBeat.o(66563);
    return i;
  }
  
  public static List<Bankcard> cZo()
  {
    AppMethodBeat.i(66565);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = s.ecc().edc();
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
  
  public static int cZp()
  {
    AppMethodBeat.i(66566);
    k.cYr();
    String str = k.IH(196629);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66566);
      return 0;
    }
    int i = bt.getInt(str, 0);
    AppMethodBeat.o(66566);
    return i;
  }
  
  private static int cZq()
  {
    int j = 0;
    AppMethodBeat.i(66567);
    k.cYr();
    String str = k.IH(196640);
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
  
  public static String cZr()
  {
    AppMethodBeat.i(66570);
    k.cYr();
    String str = k.IH(196632);
    AppMethodBeat.o(66570);
    return str;
  }
  
  public static String cZs()
  {
    AppMethodBeat.i(66571);
    k.cYr();
    String str = k.IH(196631);
    AppMethodBeat.o(66571);
    return str;
  }
  
  public static String cZt()
  {
    AppMethodBeat.i(66576);
    s.ecc();
    String str = am.edk();
    AppMethodBeat.o(66576);
    return str;
  }
  
  public static void cZu()
  {
    AppMethodBeat.i(66578);
    ad.i("MicroMsg.WalletOfflineUtil", "clear offline data");
    k.cYr();
    k.bp(196630, "0");
    k.cYr();
    k.bp(196626, "");
    k.cYr();
    k.bp(196627, "");
    k.cYr();
    k.bp(196628, "");
    k.cYr();
    k.bp(196617, "");
    k.cYr();
    k.bp(196632, "");
    k.cYr();
    k.bp(196641, "");
    k.cYr();
    k.bp(196647, "");
    k.cYr();
    k.bp(196649, "");
    q("", "", "", "");
    IR(0);
    k.cYr();
    k.bp(196629, "0");
    ajK("");
    k.cYr();
    k.cYs().ukv = null;
    k.cYr();
    k.cYu();
    k.cYr();
    String str = k.IH(196617);
    com.tencent.mm.wallet_core.c.b.fjR();
    com.tencent.mm.wallet_core.c.b.clearToken(str);
    ajP("");
    ajM("");
    AppMethodBeat.o(66578);
  }
  
  public static void cZv()
  {
    AppMethodBeat.i(66593);
    k.cYr();
    k.bp(196643, "1");
    AppMethodBeat.o(66593);
  }
  
  public static int cZw()
  {
    AppMethodBeat.i(66595);
    k.cYr();
    String str = k.IH(196644);
    if ((TextUtils.isEmpty(str)) || (!isNumeric(str)))
    {
      AppMethodBeat.o(66595);
      return 0;
    }
    int i = bt.getInt(str, 0);
    AppMethodBeat.o(66595);
    return i;
  }
  
  public static String cZx()
  {
    AppMethodBeat.i(66598);
    if (!TextUtils.isEmpty(une))
    {
      str = une;
      AppMethodBeat.o(66598);
      return str;
    }
    cZz();
    if (TextUtils.isEmpty(une)) {
      ad.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
    }
    String str = une;
    AppMethodBeat.o(66598);
    return str;
  }
  
  public static String cZy()
  {
    AppMethodBeat.i(66599);
    if (!TextUtils.isEmpty(ung))
    {
      str = ung;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(ung))
    {
      k.cYr();
      str = k.IH(196656);
      ung = str;
      AppMethodBeat.o(66599);
      return str;
    }
    if (TextUtils.isEmpty(ung)) {
      ad.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
    }
    String str = ung;
    AppMethodBeat.o(66599);
    return str;
  }
  
  private static void cZz()
  {
    AppMethodBeat.i(66601);
    com.tencent.mm.kernel.g.afA().gcy.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66555);
        if ((paramAnonymouse == null) || (paramAnonymouse.avg() == null))
        {
          ad.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
          AppMethodBeat.o(66555);
          return;
        }
        byte[] arrayOfByte = paramAnonymouse.avg().wh("offline_token");
        if (arrayOfByte != null) {
          a.es(new String(arrayOfByte));
        }
        arrayOfByte = paramAnonymouse.avg().wh("offline_token_V2");
        if (arrayOfByte != null) {
          a.une = new String(arrayOfByte);
        }
        paramAnonymouse = paramAnonymouse.avg().wh("offline_key_list");
        if (paramAnonymouse != null) {
          a.unh = new String(paramAnonymouse);
        }
        AppMethodBeat.o(66555);
      }
    }), 0);
    AppMethodBeat.o(66601);
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
      localc.KgW = bt.getInt((String)paramMap.get(str + "is_query_others"), 0);
      localc.DcQ = ((String)paramMap.get(str + "draw_lottery_params"));
      localc.Den = bt.getInt((String)paramMap.get(str + "is_show_btn"), 0);
      localc.Del = bt.nullAsNil((String)paramMap.get(str + "exposure_info_modify_params"));
      localObject1 = new e.a.a.a();
      localObject2 = str + "btn_info.";
      ((e.a.a.a)localObject1).KgO = ((String)paramMap.get((String)localObject2 + "btn_words"));
      ((e.a.a.a)localObject1).KgP = ((String)paramMap.get((String)localObject2 + "btn_color"));
      ((e.a.a.a)localObject1).KgQ = bt.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
      ((e.a.a.a)localObject1).url = ((String)paramMap.get((String)localObject2 + "url"));
      ((e.a.a.a)localObject1).Dvu = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
      localObject2 = (String)localObject2 + "mini_app_info.";
      ((e.a.a.a)localObject1).KgR = new e.a.a.g();
      ((e.a.a.a)localObject1).KgR.DVJ = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
      ((e.a.a.a)localObject1).KgR.DVK = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
      ((e.a.a.a)localObject1).KgR.DVL = bt.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
      if ((!bt.isNullOrNil(((e.a.a.a)localObject1).KgO)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).url)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).Dvu)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).KgR.DVJ)) || (!bt.isNullOrNil(((e.a.a.a)localObject1).KgR.DVK))) {
        localc.Deo = ((e.a.a.a)localObject1);
      }
      localc.KgX = bt.getInt((String)paramMap.get(str + "user_opertaion_type"), 0);
      localc.KgY = bt.getInt((String)paramMap.get(str + "is_show_layer"), 0);
      localc.Kha = ((String)paramMap.get(str + "background_img_whole"));
      localc.Dem = new LinkedList();
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
      ((i)localObject2).uwS = ((String)paramMap.get((String)localObject1 + "logo"));
      ((i)localObject2).KhA = ((String)paramMap.get((String)localObject1 + "award_name"));
      ((i)localObject2).KhB = ((String)paramMap.get((String)localObject1 + "award_description"));
      ((i)localObject2).KhC = ((String)paramMap.get((String)localObject1 + "background_img"));
      ((i)localObject2).KhD = ((String)paramMap.get((String)localObject1 + "award_name_color"));
      ((i)localObject2).KhE = ((String)paramMap.get((String)localObject1 + "award_description_color"));
      if ((!bt.isNullOrNil(((i)localObject2).uwS)) || (!bt.isNullOrNil(((i)localObject2).KhA)) || (!bt.isNullOrNil(((i)localObject2).KhB)) || (!bt.isNullOrNil(((i)localObject2).KhC)) || (!bt.isNullOrNil(((i)localObject2).KhD)) || (!bt.isNullOrNil(((i)localObject2).KhE))) {
        localc.Dem.add(localObject2);
      }
      if ((bt.isNullOrNil(((i)localObject2).KhA)) || (bt.isNullOrNil(((i)localObject2).KhB))) {
        break label1125;
      }
      paramInt += 1;
      break label713;
      str = ".sysmsg.paymsg.user_roll.activity_info.record" + paramInt + ".exposure_info.";
      break;
    }
    label1125:
    localc.KgZ = new f();
    localObject1 = str + "layer_info.";
    localc.KgZ.Khn = ((String)paramMap.get((String)localObject1 + "layer_title"));
    localc.KgZ.Kho = ((String)paramMap.get((String)localObject1 + "layer_logo"));
    localc.KgZ.Khp = ((String)paramMap.get((String)localObject1 + "layer_type"));
    localc.KgZ.Khq = ((String)paramMap.get((String)localObject1 + "layer_name"));
    localc.KgZ.Khr = ((String)paramMap.get((String)localObject1 + "layer_description"));
    localc.KgZ.Khs = bt.getInt((String)paramMap.get((String)localObject1 + "is_show_layer_btn"), 0);
    localc.KgZ.Kht = new e.a.a.e();
    Object localObject2 = (String)localObject1 + "layer_btn_info.";
    localc.KgZ.Kht.KgO = ((String)paramMap.get((String)localObject2 + "btn_words"));
    localc.KgZ.Kht.KgP = ((String)paramMap.get((String)localObject2 + "btn_color"));
    localc.KgZ.Kht.KgQ = bt.getInt((String)paramMap.get((String)localObject2 + "btn_op_type"), 0);
    localc.KgZ.Kht.Dvu = ((String)paramMap.get((String)localObject2 + "get_lottery_params"));
    localc.KgZ.Kht.url = ((String)paramMap.get((String)localObject2 + "url"));
    localObject2 = (String)localObject2 + "mini_app_info.";
    localc.KgZ.Kht.KgR = new e.a.a.g();
    localc.KgZ.Kht.KgR.DVJ = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_username"));
    localc.KgZ.Kht.KgR.DVK = ((String)paramMap.get((String)localObject2 + "activity_tinyapp_path"));
    localc.KgZ.Kht.KgR.DVL = bt.getInt((String)paramMap.get((String)localObject2 + "activity_tinyapp_version"), 0);
    if (!bt.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_url"))) {
      localc.KgZ.Khu = new com.tencent.mm.bx.b(((String)paramMap.get((String)localObject1 + "voice_url")).getBytes());
    }
    if (!bt.isNullOrNil((String)paramMap.get((String)localObject1 + "voice_data"))) {
      localc.KgZ.Khv = new com.tencent.mm.bx.b(((String)paramMap.get((String)localObject1 + "voice_data")).getBytes());
    }
    localObject1 = new e.a.a.b();
    String str = str + "draw_lottery_info.";
    ((e.a.a.b)localObject1).url = ((String)paramMap.get(str + "url"));
    ((e.a.a.b)localObject1).KgS = ((String)paramMap.get(str + "animation_wording"));
    ((e.a.a.b)localObject1).KgT = ((String)paramMap.get(str + "animation_wording_color"));
    ((e.a.a.b)localObject1).Exg = bt.getInt((String)paramMap.get(str + "op_type"), 0);
    ((e.a.a.b)localObject1).KgU = ((String)paramMap.get(str + "after_animation_wording"));
    ((e.a.a.b)localObject1).KgV = ((String)paramMap.get(str + "after_animation_wording_color"));
    str = str + "mini_app_info.";
    ((e.a.a.b)localObject1).KgR = new e.a.a.g();
    ((e.a.a.b)localObject1).KgR.DVJ = ((String)paramMap.get(str + "activity_tinyapp_username"));
    ((e.a.a.b)localObject1).KgR.DVK = ((String)paramMap.get(str + "activity_tinyapp_path"));
    ((e.a.a.b)localObject1).KgR.DVL = bt.getInt((String)paramMap.get(str + "activity_tinyapp_version"), 0);
    if ((!bt.isNullOrNil(((e.a.a.b)localObject1).url)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).KgS)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).KgT)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).KgR.DVJ)) || (!bt.isNullOrNil(((e.a.a.b)localObject1).KgR.DVK))) {
      localc.Khb = ((e.a.a.b)localObject1);
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
    com.tencent.mm.ui.base.h.a(paramActivity, false, paramString, "", paramActivity.getString(2131765981), paramActivity.getString(2131755691), new DialogInterface.OnClickListener()new a.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66552);
        a.cZu();
        a.at(this.val$activity);
        this.val$activity.finish();
        AppMethodBeat.o(66552);
      }
    }, new a.2(paramActivity));
    AppMethodBeat.o(66592);
  }
  
  public static void fF(Context paramContext)
  {
    AppMethodBeat.i(66573);
    String str = ac.eFu();
    if ("zh_CN".equals(str)) {
      str = paramContext.getString(2131764607);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.e.aS(paramContext, str);
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
    if (!TextUtils.isEmpty(und))
    {
      str = und;
      AppMethodBeat.o(66596);
      return str;
    }
    cZz();
    if (TextUtils.isEmpty(und)) {
      ad.e("MicroMsg.WalletOfflineUtil", "token is null");
    }
    String str = und;
    AppMethodBeat.o(66596);
    return str;
  }
  
  public static String getTokenPin()
  {
    AppMethodBeat.i(66604);
    k.cYr();
    String str = k.IH(196647);
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
    a(paramActivity, "create", "", cZq(), paramInt);
    AppMethodBeat.o(66591);
  }
  
  public static List<Bankcard> nT(boolean paramBoolean)
  {
    AppMethodBeat.i(66564);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = s.ecc().sD(true);
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
  
  public static void q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(66597);
    und = paramString1;
    une = paramString2;
    ung = paramString3;
    unh = paramString4;
    ajM(ung);
    com.tencent.mm.kernel.g.afA().gcy.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(66554);
        if ((paramAnonymouse == null) || (paramAnonymouse.avg() == null))
        {
          AppMethodBeat.o(66554);
          return;
        }
        if (a.und != null) {
          paramAnonymouse.avg().i("offline_token", a.und.getBytes());
        }
        if (a.une != null) {
          paramAnonymouse.avg().i("offline_token_V2", a.une.getBytes());
        }
        if (a.unh != null) {
          paramAnonymouse.avg().i("offline_key_list", a.unh.getBytes());
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
        locala.unr = localJSONObject.optInt("card_id");
        locala.dca = localJSONObject.optString("bank_type");
        locala.uns = localJSONObject.optString("bind_serial");
        locala.unt = localJSONObject.optString("forbid_word");
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
        localb.dca = localJSONObject.optString("bank_type");
        localb.odo = localJSONObject.optString("icon_url");
        localLinkedList.add(localb);
      }
      i += 1;
    }
    AppMethodBeat.o(66612);
    return localLinkedList;
  }
  
  public static final class a
  {
    public String dca;
    public int unr;
    public String uns;
    public String unt;
  }
  
  public static final class b
  {
    public String dca;
    public String odo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a
 * JD-Core Version:    0.7.0.1
 */