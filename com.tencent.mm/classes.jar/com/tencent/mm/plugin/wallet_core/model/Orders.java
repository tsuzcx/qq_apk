package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import b.a.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Orders
  implements Parcelable
{
  public static final Parcelable.Creator<Orders> CREATOR = new Orders.1();
  public static int qxc = 0;
  public static int qxd = 1;
  public String bMX = "";
  public String dqb = "0";
  public String jxR = "";
  public String mEi;
  public String mOZ;
  public double nCq = 0.0D;
  public String nickname;
  public double nyC;
  public int qqY;
  public String qsJ;
  public String qvb;
  public String qwA;
  public String qwB;
  public String qwC;
  public String qwD;
  public int qwE;
  public boolean qwF = false;
  public String qwG = "";
  public long qwH = 0L;
  public String qwI = "";
  public String qwJ;
  public Set<String> qwK = new HashSet();
  public int qwL = 0;
  public String qwM = "";
  public List<Orders.Commodity> qwN = new ArrayList();
  public com.tencent.mm.plugin.wallet.a.f qwO = new com.tencent.mm.plugin.wallet.a.f();
  public int qwP = 0;
  public String qwQ = "";
  public String qwR = "";
  public Orders.DeductInfo qwS;
  public long qwT;
  public long qwU;
  public int qwV = 0;
  public int qwW = 0;
  public int qwX = 0;
  public String qwY = "";
  public int qwZ = 0;
  public long qww;
  public double qwx = 0.0D;
  public int qwy;
  public int qwz;
  public int qxa = 0;
  public ArrayList<Orders.ShowInfo> qxb = new ArrayList();
  public String token = "";
  public String username;
  
  public Orders() {}
  
  public Orders(Parcel paramParcel)
  {
    this.qww = paramParcel.readLong();
    this.bMX = paramParcel.readString();
    this.token = paramParcel.readString();
    this.dqb = paramParcel.readString();
    this.nCq = paramParcel.readDouble();
    this.qqY = paramParcel.readInt();
    this.mOZ = paramParcel.readString();
    this.nyC = paramParcel.readDouble();
    this.qwx = paramParcel.readDouble();
    this.qwy = paramParcel.readInt();
    this.qsJ = paramParcel.readString();
    this.qvb = paramParcel.readString();
    this.qwz = paramParcel.readInt();
    this.qwA = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.mEi = paramParcel.readString();
    this.qwB = paramParcel.readString();
    this.qwC = paramParcel.readString();
    this.qwD = paramParcel.readString();
    this.qwE = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.qwF = bool;
      this.qwG = paramParcel.readString();
      this.jxR = paramParcel.readString();
      this.qwH = paramParcel.readLong();
      this.qwI = paramParcel.readString();
      paramParcel.readTypedList(this.qwN, Orders.Commodity.CREATOR);
      this.qwJ = paramParcel.readString();
      this.qwK = Qo(this.qwJ);
      this.qwL = paramParcel.readInt();
      this.qwM = paramParcel.readString();
      this.qwS = ((Orders.DeductInfo)paramParcel.readParcelable(Orders.DeductInfo.class.getClassLoader()));
      this.qwV = paramParcel.readInt();
      this.qwW = paramParcel.readInt();
      this.qxa = paramParcel.readInt();
      this.qwZ = paramParcel.readInt();
      paramParcel.readTypedList(this.qxb, Orders.ShowInfo.CREATOR);
      return;
      bool = false;
    }
  }
  
  private static HashSet<String> Qo(String paramString)
  {
    HashSet localHashSet = new HashSet();
    if (!bk.bl(paramString))
    {
      paramString = paramString.split("\\|");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramString[i]);
        i += 1;
      }
      if (localHashSet.size() > 0) {
        localHashSet.retainAll(localHashSet);
      }
    }
    else
    {
      return localHashSet;
    }
    localHashSet.clear();
    return localHashSet;
  }
  
  public static Orders a(JSONObject paramJSONObject, Orders paramOrders)
  {
    if ((paramJSONObject != null) && (paramOrders != null)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = paramJSONObject.optJSONObject("appservice");
        if (localObject1 != null)
        {
          paramOrders.qwC = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.qwD = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.qwE = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.jxR = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.qwE;
        localObject1 = paramOrders.qwN;
        paramOrders.qwG = paramJSONObject.optString("pay_result_tips");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("payresult");
        int k = localJSONArray.length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          Object localObject2;
          if ((localObject1 != null) && (((List)localObject1).size() == 1))
          {
            localObject2 = (Orders.Commodity)((List)localObject1).get(0);
            ((Orders.Commodity)localObject2).qxn = new ArrayList();
            ((Orders.Commodity)localObject2).qxh = new ArrayList();
            ((Orders.Commodity)localObject2).bMY = localJSONObject.getString("transaction_id");
            a((Orders.Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Orders.Commodity localCommodity = (Orders.Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.bMY))) {
                continue;
              }
              a(localCommodity, localJSONObject, j);
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        y.printErrStackTrace("MicroMsg.Orders", paramJSONObject, "", new Object[0]);
        return paramOrders;
      }
      Object localObject1 = paramJSONObject.optJSONObject("extinfo");
      if (localObject1 != null)
      {
        paramOrders.qwH = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
        paramOrders.qwI = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
      }
      paramOrders.qwX = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
      paramOrders.qwY = paramJSONObject.optString("pay_succ_btn_wording");
      paramOrders.qxa = paramJSONObject.optInt("is_jsapi_close_page");
      b(paramOrders, paramJSONObject);
      return paramOrders;
      y.w("MicroMsg.Orders", "oldOrders is null");
      return paramOrders;
      i += 1;
    }
  }
  
  private static void a(Orders.Commodity paramCommodity, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    paramCommodity.mPe = paramJSONObject.optString("discount");
    paramCommodity.mOS = paramJSONObject.getString("pay_status");
    paramCommodity.mOT = paramJSONObject.getString("pay_status_name");
    paramCommodity.mOX = paramJSONObject.optString("buy_bank_name");
    paramCommodity.mOV = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.qxg = paramJSONObject.optString("card_tail");
    paramCommodity.qwE = paramInt;
    paramCommodity.qxi = paramJSONObject.optString("rateinfo");
    paramCommodity.qxj = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.qxk = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.iHP = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.qxe = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.mOZ = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Orders.Promotions();
      ((Orders.Promotions)localObject2).type = qxc;
      ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Orders.Promotions)localObject2).mPa = ((JSONObject)localObject1).optString("username");
      paramCommodity.qxf = ((Orders.Promotions)localObject2).mPa;
      ((Orders.Promotions)localObject2).mTc = ((JSONObject)localObject1).optString("logo_round_url");
      ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!bk.bl(((Orders.Promotions)localObject2).name)) && (!bk.bl(((Orders.Promotions)localObject2).url)))
      {
        paramCommodity.qxn.add(localObject2);
        paramCommodity.qxo = true;
      }
    }
    localObject1 = paramJSONObject.getJSONArray("activity_info");
    int j = ((JSONArray)localObject1).length();
    paramInt = 0;
    Object localObject3;
    while (paramInt < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
      localObject3 = new Orders.Promotions();
      ((Orders.Promotions)localObject3).type = qxd;
      ((Orders.Promotions)localObject3).mTc = ((JSONObject)localObject2).optString("icon");
      ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Orders.Promotions)localObject3).qwp = ((JSONObject)localObject2).optString("btn_text");
      ((Orders.Promotions)localObject3).qxA = ((JSONObject)localObject2).optInt("type");
      ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Orders.Promotions)localObject3).qqG = ((JSONObject)localObject2).optLong("activity_id");
      ((Orders.Promotions)localObject3).qxB = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Orders.Promotions)localObject3).qxD = ((JSONObject)localObject2).optString("small_title");
      ((Orders.Promotions)localObject3).qxC = ((JSONObject)localObject2).optInt("award_id");
      ((Orders.Promotions)localObject3).qwm = ((JSONObject)localObject2).optInt("send_record_id");
      ((Orders.Promotions)localObject3).qwn = ((JSONObject)localObject2).optInt("user_record_id");
      ((Orders.Promotions)localObject3).qxE = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Orders.Promotions)localObject3).qxF = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Orders.Promotions)localObject3).qwo = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Orders.Promotions)localObject3).qxG = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Orders.Promotions)localObject3).qxH = ((JSONObject)localObject2).optString("get_award_params");
      ((Orders.Promotions)localObject3).qxI = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.qxn.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.qxp.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.qxp.url = ((JSONObject)localObject1).optString("url");
    }
    localObject1 = paramJSONObject.optJSONArray("discount_array");
    if (localObject1 != null)
    {
      j = ((JSONArray)localObject1).length();
      paramInt = i;
      while (paramInt < j)
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(paramInt);
        localObject3 = new Orders.DiscountInfo();
        if (localObject2 != null)
        {
          ((Orders.DiscountInfo)localObject3).qxz = ((JSONObject)localObject2).optDouble("payment_amount");
          ((Orders.DiscountInfo)localObject3).nxN = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.qxh.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.qxl == null) {
        paramCommodity.qxl = new Orders.RecommendTinyAppInfo();
      }
      paramCommodity.qxl.qwr = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.qxl.qws = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.qxl.qwt = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.qxl.qhq = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.qxl.qhr = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.qxl.qwu = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.qxl.qxK = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.qxl.qxL = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.qxl.qxM = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.qxl.qxN = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.qxl.qxO = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.qxl.qxP = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.qxl.qwv = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.qxm == null) {
        paramCommodity.qxm = new Orders.RemarksInfo();
      }
      paramCommodity.qxm.qxQ = paramJSONObject.optString("remark_title");
      paramCommodity.qxm.qxR = paramJSONObject.optString("remark_desc");
    }
  }
  
  public static void a(Orders.Promotions paramPromotions, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.qxJ = null;
      return;
    }
    try
    {
      b.a.a.c localc = new b.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.sTf = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          b.a.a.g localg = new b.a.a.g();
          localg.mTc = localJSONObject.optString("logo");
          localg.xpC = localJSONObject.optString("award_name");
          localg.xpD = localJSONObject.optString("award_description");
          localg.xpE = localJSONObject.optString("background_img");
          localg.xpG = localJSONObject.optString("award_description_color");
          localg.xpF = localJSONObject.optString("award_name_color");
          localc.sTf.add(localg);
          i += 1;
        }
      }
      localc.xpn = paramJSONObject.optInt("is_query_others", 0);
      localc.sRh = paramJSONObject.optString("draw_lottery_params");
      localc.sTg = paramJSONObject.optInt("is_show_btn");
      localc.xpr = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.sTh = new b.a.a.a();
        localc.sTh.xpf = ((JSONObject)localObject).optString("btn_words");
        localc.sTh.xpg = ((JSONObject)localObject).optString("btn_color");
        localc.sTh.xph = ((JSONObject)localObject).optInt("btn_op_type");
        localc.sTh.url = ((JSONObject)localObject).optString("url");
        localc.sTh.teX = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.sTh.xpi = new b.a.a.f();
          localc.sTh.xpi.tyu = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.sTh.xpi.tyv = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.sTh.xpi.tyw = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.sTe = paramJSONObject.optString("exposure_info_modify_params");
      localc.xpo = paramJSONObject.optInt("user_opertaion_type");
      localc.xpp = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.xpq = new b.a.a.e();
        localc.xpq.xpt = ((JSONObject)localObject).optString("layer_title");
        localc.xpq.xpu = ((JSONObject)localObject).optString("layer_logo");
        localc.xpq.xpv = ((JSONObject)localObject).optString("layer_type");
        localc.xpq.xpw = ((JSONObject)localObject).optString("layer_name");
        localc.xpq.xpx = ((JSONObject)localObject).optString("layer_description");
        localc.xpq.xpy = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!bk.bl(((JSONObject)localObject).optString("voice_url"))) {
          localc.xpq.xpA = new com.tencent.mm.bv.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!bk.bl(((JSONObject)localObject).optString("voice_data"))) {
          localc.xpq.xpB = new com.tencent.mm.bv.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.xpq.xpz = new d();
          localc.xpq.xpz.xpf = ((JSONObject)localObject).optString("btn_words");
          localc.xpq.xpz.xpg = ((JSONObject)localObject).optString("btn_color");
          localc.xpq.xpz.xph = ((JSONObject)localObject).optInt("btn_op_type");
          localc.xpq.xpz.teX = ((JSONObject)localObject).optString("get_lottery_params");
          localc.xpq.xpz.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.xpq.xpz.xpi = new b.a.a.f();
            localc.xpq.xpz.xpi.tyu = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.xpq.xpz.xpi.tyv = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.xpq.xpz.xpi.tyw = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (paramJSONObject != null)
      {
        localc.xps = new b.a.a.b();
        localc.xps.url = paramJSONObject.optString("url");
        localc.xps.xpj = paramJSONObject.optString("animation_wording");
        localc.xps.xpk = paramJSONObject.optString("animation_wording_color");
        localc.xps.xpl = paramJSONObject.optString("after_animation_wording");
        localc.xps.xpm = paramJSONObject.optString("after_animation_wording_color");
        localc.xps.tPH = paramJSONObject.optInt("op_type");
        paramJSONObject = paramJSONObject.optJSONObject("mini_app_info");
        if (paramJSONObject != null)
        {
          localc.xps.xpi = new b.a.a.f();
          localc.xps.xpi.tyu = paramJSONObject.optString("activity_tinyapp_username");
          localc.xps.xpi.tyv = paramJSONObject.optString("activity_tinyapp_path");
          localc.xps.xpi.tyw = paramJSONObject.optInt("activity_tinyapp_version");
        }
      }
      paramPromotions.qxJ = localc;
      return;
    }
    catch (Exception paramPromotions)
    {
      y.printErrStackTrace("MicroMsg.Orders", paramPromotions, "parseExposureInfo error: %s", new Object[] { paramPromotions.getMessage() });
    }
  }
  
  private static void a(Orders paramOrders, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      y.i("MicroMsg.Orders", "parseDeductInfo json is not null");
      paramOrders.qwS = new Orders.DeductInfo();
      paramOrders.qwS.title = paramJSONObject.optString("contract_title");
      paramOrders.qwS.desc = paramJSONObject.optString("contract_desc");
      paramOrders.qwS.qnO = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.qwS.qxq = paramJSONObject.optString("contract_url");
      paramOrders.qwS.qxs = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.qwS.qne = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.qwS.imZ = paramJSONObject.optString("button_wording", "");
      paramOrders.qwS.qnf = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.qwS.qxt = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.qwS.qxu = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.qwS.qxr = new ArrayList();
        int i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            Orders.DeductShowInfo localDeductShowInfo = new Orders.DeductShowInfo();
            localDeductShowInfo.name = localJSONObject.optString("name");
            localDeductShowInfo.value = localJSONObject.optString("value");
            localJSONObject = localJSONObject.optJSONObject("value_attr");
            if (localJSONObject != null)
            {
              localDeductShowInfo.qxv = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.qxw = localJSONObject.optString("link_weapp");
              localDeductShowInfo.qxx = localJSONObject.optString("link_addr");
              localDeductShowInfo.qxy = localJSONObject.optString("link_url");
            }
            paramOrders.qwS.qxr.add(localDeductShowInfo);
          }
          for (;;)
          {
            i += 1;
            break;
            y.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=" + i);
          }
        }
      }
      else
      {
        y.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is " + j);
      }
      return;
    }
    y.i("MicroMsg.Orders", "parseDeductInfo json is null");
  }
  
  public static Orders ak(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject != null)
    {
      Orders localOrders = new Orders();
      for (;;)
      {
        Object localObject1;
        int i;
        int j;
        Object localObject2;
        try
        {
          localOrders.qww = bk.UY();
          localOrders.nCq = (paramJSONObject.getDouble("total_fee") / 100.0D);
          localOrders.dqb = paramJSONObject.getString("num");
          localOrders.qqY = paramJSONObject.optInt("bank_card_tag", 1);
          localOrders.mOZ = paramJSONObject.optString("fee_type", "");
          localOrders.nyC = (paramJSONObject.optDouble("charge_fee", 0.0D) / 100.0D);
          localOrders.qwx = (paramJSONObject.optDouble("fetch_fee", 0.0D) / 100.0D);
          localOrders.qwy = paramJSONObject.optInt("is_assign_userinfo_pay");
          localOrders.qsJ = paramJSONObject.optString("true_name");
          localOrders.qvb = paramJSONObject.optString("cre_id");
          localOrders.qwz = paramJSONObject.optInt("ce_type");
          localOrders.qwA = paramJSONObject.optString("assign_pay_info");
          localObject1 = paramJSONObject.getJSONArray("Array");
          localOrders.qwT = paramJSONObject.optLong("free_fee");
          localOrders.qwU = paramJSONObject.optLong("remain_fee");
          localOrders.qwV = paramJSONObject.optInt("not_support_bind_card", 0);
          localOrders.qwW = paramJSONObject.optInt("not_support_retry", 0);
          if (paramJSONObject.optInt("support_all_bank", 0) != 1) {
            break label871;
          }
          i = 1;
          if (i != 0) {
            localOrders.qwK = new HashSet();
          }
          int k = ((JSONArray)localObject1).length();
          j = 0;
          if (j < k)
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(j);
            Orders.Commodity localCommodity = new Orders.Commodity();
            localCommodity.desc = ((JSONObject)localObject2).getString("desc");
            localCommodity.iHP = (((JSONObject)localObject2).getInt("fee") / 100.0D);
            localCommodity.mOQ = ((JSONObject)localObject2).optInt("count", 1);
            localCommodity.mOS = ((JSONObject)localObject2).getString("pay_status");
            localCommodity.mOX = ((JSONObject)localObject2).optString("buy_bank_name");
            localCommodity.mOT = ((JSONObject)localObject2).getString("pay_status_name");
            localCommodity.mON = ((JSONObject)localObject2).optString("spid");
            localCommodity.mOO = ((JSONObject)localObject2).optString("sp_name");
            localCommodity.mOV = ((JSONObject)localObject2).optInt("modify_timestamp");
            localCommodity.bMY = ((JSONObject)localObject2).getString("transaction_id");
            localCommodity.mOZ = ((JSONObject)localObject2).optString("fee_type");
            if (bk.bl(localOrders.mOZ)) {
              localOrders.mOZ = localCommodity.mOZ;
            }
            localCommodity.mPa = ((JSONObject)localObject2).optString("appusername");
            localCommodity.mOD = ((JSONObject)localObject2).optString("app_telephone");
            localOrders.qwN.add(localCommodity);
            if (i != 0) {
              break label864;
            }
            localOrders.qwJ = ((JSONObject)localObject2).optString("support_bank");
            localOrders.qwK = Qo(localOrders.qwJ);
            break label864;
          }
          if (paramJSONObject.has("is_open_fee_protocal"))
          {
            localOrders.qwF = com.tencent.mm.wallet_core.ui.e.o(paramJSONObject, "is_open_fee_protocal");
            localOrders.qwO = as(paramJSONObject);
            localObject1 = paramJSONObject.optJSONObject("bindqueryresp");
            if (localObject1 == null)
            {
              y.e("MicroMsg.Orders", "bindqueryresp is null ");
              localOrders.qwP = paramJSONObject.optInt("needbindcardtoshowfavinfo");
              localOrders.qwQ = paramJSONObject.optString("discount_wording");
              localOrders.qwR = paramJSONObject.optString("favor_rule_wording");
              a(localOrders, paramJSONObject.optJSONObject("entrustpayinfo"));
              return localOrders;
            }
          }
          else
          {
            localOrders.qwF = Bankcard.eu(localOrders.qqY, 2);
            continue;
          }
          localObject1 = ((JSONObject)localObject1).optJSONObject("user_info");
        }
        catch (JSONException paramJSONObject)
        {
          y.printErrStackTrace("MicroMsg.Orders", paramJSONObject, "", new Object[0]);
          return localOrders;
        }
        if (localObject1 == null)
        {
          y.e("MicroMsg.Orders", "user_info is null ");
        }
        else
        {
          localObject1 = ((JSONObject)localObject1).optJSONObject("touch_info");
          if (localObject1 == null)
          {
            y.e("MicroMsg.Orders", "touch_info is null ");
          }
          else
          {
            if (com.tencent.mm.wallet_core.ui.e.cNq())
            {
              i = ((JSONObject)localObject1).optInt("use_touch_pay", 0);
              label756:
              localOrders.qwL = i;
              localOrders.qwM = ((JSONObject)localObject1).optString("touch_forbidword");
              localObject2 = ((JSONObject)localObject1).optString("touch_challenge");
              if (1 != ((JSONObject)localObject1).optInt("need_change_auth_key")) {
                break label858;
              }
            }
            for (;;)
            {
              s.qyz.klM = ((String)localObject2);
              s.qyz.klN = bool;
              y.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", new Object[] { Integer.valueOf(localOrders.qwL), localObject2, Boolean.valueOf(bool) });
              break;
              i = 0;
              break label756;
              label858:
              bool = false;
            }
            label864:
            j += 1;
            continue;
            label871:
            i = 0;
          }
        }
      }
    }
    return null;
  }
  
  private static com.tencent.mm.plugin.wallet.a.f as(JSONObject paramJSONObject)
  {
    com.tencent.mm.plugin.wallet.a.f localf = new com.tencent.mm.plugin.wallet.a.f();
    paramJSONObject = paramJSONObject.optJSONObject("favinfo");
    if (paramJSONObject == null)
    {
      y.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
      return localf;
    }
    localf.qkT = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localf.qkU = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localf.qkV = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localf.qkW = paramJSONObject.optString("favorComposeId");
    localf.qkZ = paramJSONObject.optInt("useNaturalDefense");
    localf.qla = paramJSONObject.optString("discountWording");
    localf.qlb = paramJSONObject.optString("favorRuleWording");
    localf.qlc = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localf.qld = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localf.qle = paramJSONObject.optInt("isVariableFavor");
    localf.qlf = paramJSONObject.optString("invariableFavorDesc");
    localf.qlg = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    Object localObject2;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new q();
      ((q)localObject2).qlJ = ((JSONObject)localObject3).optInt("favType");
      ((q)localObject2).qlK = ((JSONObject)localObject3).optInt("favSubType");
      ((q)localObject2).qlL = ((JSONObject)localObject3).optLong("favProperty");
      ((q)localObject2).qlM = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((q)localObject2).qkQ = ((JSONObject)localObject3).optString("favId");
      ((q)localObject2).qlN = ((JSONObject)localObject3).optString("favName");
      ((q)localObject2).qlO = ((JSONObject)localObject3).optString("favDesc");
      ((q)localObject2).qkR = ((JSONObject)localObject3).optString("favorUseManual");
      ((q)localObject2).qkS = ((JSONObject)localObject3).optString("favorRemarks");
      ((q)localObject2).qlP = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((q)localObject2).qlQ = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((q)localObject2).qlR = ((JSONObject)localObject3).optInt("needBankPay");
      ((q)localObject2).qlS = ((JSONObject)localObject3).optString("bankNo");
      ((q)localObject2).mOX = ((JSONObject)localObject3).optString("bankName");
      ((q)localObject2).qlT = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((q)localObject2).qlU.add(com.tencent.mm.bv.b.bk(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localf.qkX.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localf.qkY = new com.tencent.mm.plugin.wallet.a.g();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new h();
        ((h)localObject2).qlk = ((JSONObject)localObject3).optString("faovrComposeId");
        ((h)localObject2).qll = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((h)localObject2).qkV = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((h)localObject2).qlc = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((h)localObject2).qld = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((h)localObject2).qle = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((h)localObject2).qlf = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((h)localObject2).qlg = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.a.e();
          ((com.tencent.mm.plugin.wallet.a.e)localObject5).qkQ = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.a.e)localObject5).qkR = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.a.e)localObject5).qkS = ((JSONObject)localObject4).optString("favorRemarks");
          ((h)localObject2).qlm.add(localObject5);
          j += 1;
        }
        localf.qkY.qli.add(localObject2);
        i += 1;
      }
    }
    localObject1 = new com.tencent.mm.plugin.wallet.a.a();
    paramJSONObject = paramJSONObject.optJSONObject("bank_card_info");
    if (paramJSONObject != null)
    {
      localObject2 = paramJSONObject.optJSONArray("bind_serial_favor_info_list");
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new com.tencent.mm.plugin.wallet.a.b();
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          ((com.tencent.mm.plugin.wallet.a.b)localObject3).mOc = ((JSONObject)localObject4).optString("bind_serial");
          localObject4 = ((JSONObject)localObject4).optJSONArray("bind_serial_favor_list");
          if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject4).length())
            {
              localObject5 = new com.tencent.mm.plugin.wallet.a.c();
              JSONObject localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
              ((com.tencent.mm.plugin.wallet.a.c)localObject5).nxN = localJSONObject.optString("favor_desc");
              ((com.tencent.mm.plugin.wallet.a.c)localObject5).qkO = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.a.b)localObject3).qkN.add(localObject5);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).qkL.add(localObject3);
          i += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.a.a)localObject1).qkM = new k();
        i = 0;
        while (i < paramJSONObject.length())
        {
          localObject2 = new l();
          ((l)localObject2).nxN = paramJSONObject.optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).qkM.qlr.add(localObject2);
          i += 1;
        }
      }
    }
    localf.qlh = ((com.tencent.mm.plugin.wallet.a.a)localObject1);
    return localf;
  }
  
  private static void b(Orders paramOrders, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        paramOrders.qwZ = paramJSONObject.optInt("is_use_show_info", 0);
        y.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.qwZ) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          y.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.qxb = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.kOn = localJSONObject.optString("name_color");
              localShowInfo.qxS = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.qxT = localJSONObject.optInt("link_type");
                localShowInfo.qxU = localJSONObject.optString("link_weapp");
                localShowInfo.qxV = localJSONObject.optString("link_addr");
                localShowInfo.qxW = localJSONObject.optString("link_url");
                localShowInfo.qxX = localJSONObject.optInt("text_attr");
              }
              if ((!bk.bl(localShowInfo.name)) || (!bk.bl(localShowInfo.value))) {
                paramOrders.qxb.add(localShowInfo);
              }
            }
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramOrders)
      {
        y.printErrStackTrace("MicroMsg.Orders", paramOrders, "parseShowInfo error", new Object[0]);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reqKey:").append(this.bMX).append("\n");
    localStringBuilder.append("token").append(this.token).append("\n");
    localStringBuilder.append("num").append(this.dqb).append("\n");
    localStringBuilder.append("totalFee").append(this.nCq).append("\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.qww);
    paramParcel.writeString(this.bMX);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.dqb);
    paramParcel.writeDouble(this.nCq);
    paramParcel.writeInt(this.qqY);
    paramParcel.writeString(this.mOZ);
    paramParcel.writeDouble(this.nyC);
    paramParcel.writeDouble(this.qwx);
    paramParcel.writeInt(this.qwy);
    paramParcel.writeString(this.qsJ);
    paramParcel.writeString(this.qvb);
    paramParcel.writeInt(this.qwz);
    paramParcel.writeString(this.qwA);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.mEi);
    paramParcel.writeString(this.qwB);
    paramParcel.writeString(this.qwC);
    paramParcel.writeString(this.qwD);
    paramParcel.writeInt(this.qwE);
    if (this.qwF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.qwG);
      paramParcel.writeString(this.jxR);
      paramParcel.writeLong(this.qwH);
      paramParcel.writeString(this.qwI);
      paramParcel.writeTypedList(this.qwN);
      paramParcel.writeString(this.qwJ);
      paramParcel.writeInt(this.qwL);
      paramParcel.writeString(this.qwM);
      paramParcel.writeParcelable(this.qwS, 1);
      paramParcel.writeInt(this.qwV);
      paramParcel.writeInt(this.qwW);
      paramParcel.writeInt(this.qxa);
      paramParcel.writeInt(this.qwZ);
      paramParcel.writeTypedList(this.qxb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders
 * JD-Core Version:    0.7.0.1
 */