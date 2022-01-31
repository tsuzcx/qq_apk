package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import d.a.a.e;
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
  public static final Parcelable.Creator<Orders> CREATOR;
  public static int ujK;
  public static int ujL;
  public String cnI;
  public double cnL;
  public String ehy;
  public ArrayList<cje> field_infos;
  public String lHq;
  public String nickname;
  public String pek;
  public String ppp;
  public double qjD;
  public String token;
  public int ubU;
  public String ueu;
  public String uht;
  public long uiU;
  public double uiV;
  public int uiW;
  public int uiX;
  public String uiY;
  public String uiZ;
  public String ujA;
  public String ujB;
  public String ujC;
  public String ujD;
  public String ujE;
  public String ujF;
  public String ujG;
  public String ujH;
  public int ujI;
  public Orders.SimpleCashierInfo ujJ;
  public String uja;
  public String ujb;
  public int ujc;
  public boolean ujd;
  public String uje;
  public long ujf;
  public String ujg;
  public String ujh;
  public Set<String> uji;
  public int ujj;
  public String ujk;
  public List<Orders.Commodity> ujl;
  public com.tencent.mm.plugin.wallet.a.h ujm;
  public int ujn;
  public String ujo;
  public String ujp;
  public Orders.DeductInfo ujq;
  public long ujr;
  public long ujs;
  public int ujt;
  public int uju;
  public int ujv;
  public String ujw;
  public int ujx;
  public int ujy;
  public ArrayList<Orders.ShowInfo> ujz;
  public String username;
  
  static
  {
    AppMethodBeat.i(46845);
    CREATOR = new Orders.1();
    ujK = 0;
    ujL = 1;
    AppMethodBeat.o(46845);
  }
  
  public Orders()
  {
    AppMethodBeat.i(46833);
    this.cnI = "";
    this.token = "";
    this.ehy = "0";
    this.cnL = 0.0D;
    this.uiV = 0.0D;
    this.ujd = false;
    this.uje = "";
    this.lHq = "";
    this.ujf = 0L;
    this.ujg = "";
    this.uji = new HashSet();
    this.ujj = 0;
    this.ujk = "";
    this.ujl = new ArrayList();
    this.ujm = new com.tencent.mm.plugin.wallet.a.h();
    this.ujn = 0;
    this.ujo = "";
    this.ujp = "";
    this.ujt = 0;
    this.uju = 0;
    this.ujv = 0;
    this.ujw = "";
    this.ujx = 0;
    this.ujy = 0;
    this.ujz = new ArrayList();
    this.ujA = "";
    this.ujB = "";
    this.field_infos = new ArrayList();
    this.ujC = "";
    this.ujF = "";
    AppMethodBeat.o(46833);
  }
  
  public Orders(Parcel paramParcel)
  {
    AppMethodBeat.i(46843);
    this.cnI = "";
    this.token = "";
    this.ehy = "0";
    this.cnL = 0.0D;
    this.uiV = 0.0D;
    this.ujd = false;
    this.uje = "";
    this.lHq = "";
    this.ujf = 0L;
    this.ujg = "";
    this.uji = new HashSet();
    this.ujj = 0;
    this.ujk = "";
    this.ujl = new ArrayList();
    this.ujm = new com.tencent.mm.plugin.wallet.a.h();
    this.ujn = 0;
    this.ujo = "";
    this.ujp = "";
    this.ujt = 0;
    this.uju = 0;
    this.ujv = 0;
    this.ujw = "";
    this.ujx = 0;
    this.ujy = 0;
    this.ujz = new ArrayList();
    this.ujA = "";
    this.ujB = "";
    this.field_infos = new ArrayList();
    this.ujC = "";
    this.ujF = "";
    this.uiU = paramParcel.readLong();
    this.cnI = paramParcel.readString();
    this.token = paramParcel.readString();
    this.ehy = paramParcel.readString();
    this.cnL = paramParcel.readDouble();
    this.ubU = paramParcel.readInt();
    this.ppp = paramParcel.readString();
    this.qjD = paramParcel.readDouble();
    this.uiV = paramParcel.readDouble();
    this.uiW = paramParcel.readInt();
    this.ueu = paramParcel.readString();
    this.uht = paramParcel.readString();
    this.uiX = paramParcel.readInt();
    this.uiY = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.pek = paramParcel.readString();
    this.uiZ = paramParcel.readString();
    this.uja = paramParcel.readString();
    this.ujb = paramParcel.readString();
    this.ujc = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ujd = bool;
      this.uje = paramParcel.readString();
      this.lHq = paramParcel.readString();
      this.ujf = paramParcel.readLong();
      this.ujg = paramParcel.readString();
      paramParcel.readTypedList(this.ujl, Orders.Commodity.CREATOR);
      this.ujh = paramParcel.readString();
      this.uji = afg(this.ujh);
      this.ujj = paramParcel.readInt();
      this.ujk = paramParcel.readString();
      this.ujq = ((Orders.DeductInfo)paramParcel.readParcelable(Orders.DeductInfo.class.getClassLoader()));
      this.ujt = paramParcel.readInt();
      this.uju = paramParcel.readInt();
      this.ujy = paramParcel.readInt();
      this.ujB = paramParcel.readString();
      this.ujA = paramParcel.readString();
      this.ujx = paramParcel.readInt();
      paramParcel.readTypedList(this.ujz, Orders.ShowInfo.CREATOR);
      this.ujJ = ((Orders.SimpleCashierInfo)paramParcel.readParcelable(Orders.SimpleCashierInfo.class.getClassLoader()));
      AppMethodBeat.o(46843);
      return;
      bool = false;
    }
  }
  
  public static Orders a(JSONObject paramJSONObject, Orders paramOrders)
  {
    AppMethodBeat.i(46836);
    if ((paramJSONObject != null) && (paramOrders != null)) {}
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = paramJSONObject.optJSONObject("appservice");
        if (localObject1 != null)
        {
          paramOrders.uja = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.ujb = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.ujc = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.lHq = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.ujc;
        localObject1 = paramOrders.ujl;
        paramOrders.uje = paramJSONObject.optString("pay_result_tips");
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
            ((Orders.Commodity)localObject2).ujV = new ArrayList();
            ((Orders.Commodity)localObject2).ujP = new ArrayList();
            ((Orders.Commodity)localObject2).cnJ = localJSONObject.getString("transaction_id");
            a((Orders.Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Orders.Commodity localCommodity = (Orders.Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.cnJ))) {
                continue;
              }
              a(localCommodity, localJSONObject, j);
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.Orders", paramJSONObject, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(46836);
        return paramOrders;
        localObject1 = paramJSONObject.optJSONObject("extinfo");
        if (localObject1 != null)
        {
          paramOrders.ujf = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
          paramOrders.ujg = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
        }
        paramOrders.ujv = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
        paramOrders.ujw = paramJSONObject.optString("pay_succ_btn_wording");
        paramOrders.ujy = paramJSONObject.optInt("is_jsapi_close_page");
        paramOrders.ujA = paramJSONObject.optString("jsapi_tinyapp_username");
        paramOrders.ujB = paramJSONObject.optString("jsapi_tinyapp_path");
        b(paramOrders, paramJSONObject);
        continue;
        ab.w("MicroMsg.Orders", "oldOrders is null");
      }
      i += 1;
    }
  }
  
  private static void a(Orders.Commodity paramCommodity, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(46837);
    paramCommodity.ppu = paramJSONObject.optString("discount");
    paramCommodity.ppi = paramJSONObject.getString("pay_status");
    paramCommodity.ppj = paramJSONObject.getString("pay_status_name");
    paramCommodity.ppn = paramJSONObject.optString("buy_bank_name");
    paramCommodity.ppl = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.ujO = paramJSONObject.optString("card_tail");
    paramCommodity.ujc = paramInt;
    paramCommodity.ujQ = paramJSONObject.optString("rateinfo");
    paramCommodity.ujR = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.ujS = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.kNS = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.ujM = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.ppp = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Orders.Promotions();
      ((Orders.Promotions)localObject2).type = ujK;
      ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Orders.Promotions)localObject2).ppq = ((JSONObject)localObject1).optString("username");
      paramCommodity.ujN = ((Orders.Promotions)localObject2).ppq;
      ((Orders.Promotions)localObject2).pvi = ((JSONObject)localObject1).optString("logo_round_url");
      ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!bo.isNullOrNil(((Orders.Promotions)localObject2).name)) && (!bo.isNullOrNil(((Orders.Promotions)localObject2).url)))
      {
        paramCommodity.ujV.add(localObject2);
        paramCommodity.ujW = true;
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
      ((Orders.Promotions)localObject3).type = ujL;
      ((Orders.Promotions)localObject3).pvi = ((JSONObject)localObject2).optString("icon");
      ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Orders.Promotions)localObject3).uiO = ((JSONObject)localObject2).optString("btn_text");
      ((Orders.Promotions)localObject3).uki = ((JSONObject)localObject2).optInt("type");
      ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Orders.Promotions)localObject3).ubC = ((JSONObject)localObject2).optLong("activity_id");
      ((Orders.Promotions)localObject3).ukk = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Orders.Promotions)localObject3).ukm = ((JSONObject)localObject2).optString("small_title");
      ((Orders.Promotions)localObject3).ukl = ((JSONObject)localObject2).optInt("award_id");
      ((Orders.Promotions)localObject3).uiL = ((JSONObject)localObject2).optInt("send_record_id");
      ((Orders.Promotions)localObject3).uiM = ((JSONObject)localObject2).optInt("user_record_id");
      ((Orders.Promotions)localObject3).ukn = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Orders.Promotions)localObject3).uko = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Orders.Promotions)localObject3).uiN = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Orders.Promotions)localObject3).ukp = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Orders.Promotions)localObject3).ukq = ((JSONObject)localObject2).optString("get_award_params");
      ((Orders.Promotions)localObject3).uWi = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.ujV.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.ujX.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.ujX.url = ((JSONObject)localObject1).optString("url");
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
          ((Orders.DiscountInfo)localObject3).ukh = ((JSONObject)localObject2).optDouble("payment_amount");
          ((Orders.DiscountInfo)localObject3).qiO = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.ujP.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.ujT == null) {
        paramCommodity.ujT = new Orders.RecommendTinyAppInfo();
      }
      paramCommodity.ujT.uaK = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.ujT.uiQ = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.ujT.uiR = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.ujT.ugl = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.ujT.uaL = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.ujT.uiS = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.ujT.uks = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.ujT.ukt = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.ujT.uku = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.ujT.ukv = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.ujT.ukw = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.ujT.ukx = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.ujT.uiT = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.ujU == null) {
        paramCommodity.ujU = new Orders.RemarksInfo();
      }
      paramCommodity.ujU.uky = paramJSONObject.optString("remark_title");
      paramCommodity.ujU.ukz = paramJSONObject.optString("remark_desc");
    }
    AppMethodBeat.o(46837);
  }
  
  public static void a(Orders.Promotions paramPromotions, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46838);
    ab.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.ukr = null;
      AppMethodBeat.o(46838);
      return;
    }
    try
    {
      d.a.a.c localc = new d.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.wQZ = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          d.a.a.i locali = new d.a.a.i();
          locali.pvi = localJSONObject.optString("logo");
          locali.CLT = localJSONObject.optString("award_name");
          locali.CLU = localJSONObject.optString("award_description");
          locali.CLV = localJSONObject.optString("background_img");
          locali.CLX = localJSONObject.optString("award_description_color");
          locali.CLW = localJSONObject.optString("award_name_color");
          localc.wQZ.add(locali);
          i += 1;
        }
      }
      localc.CLp = paramJSONObject.optInt("is_query_others", 0);
      localc.wPV = paramJSONObject.optString("draw_lottery_params");
      localc.wRa = paramJSONObject.optInt("is_show_btn");
      localc.CLt = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.wRb = new d.a.a.a();
        localc.wRb.CLh = ((JSONObject)localObject).optString("btn_words");
        localc.wRb.CLi = ((JSONObject)localObject).optString("btn_color");
        localc.wRb.CLj = ((JSONObject)localObject).optInt("btn_op_type");
        localc.wRb.url = ((JSONObject)localObject).optString("url");
        localc.wRb.xcU = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.wRb.CLk = new d.a.a.g();
          localc.wRb.CLk.xzC = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.wRb.CLk.xzD = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.wRb.CLk.xzE = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.wQY = paramJSONObject.optString("exposure_info_modify_params");
      localc.CLq = paramJSONObject.optInt("user_opertaion_type");
      localc.CLr = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.CLs = new d.a.a.f();
        localc.CLs.CLG = ((JSONObject)localObject).optString("layer_title");
        localc.CLs.CLH = ((JSONObject)localObject).optString("layer_logo");
        localc.CLs.CLI = ((JSONObject)localObject).optString("layer_type");
        localc.CLs.CLJ = ((JSONObject)localObject).optString("layer_name");
        localc.CLs.CLK = ((JSONObject)localObject).optString("layer_description");
        localc.CLs.CLL = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!bo.isNullOrNil(((JSONObject)localObject).optString("voice_url"))) {
          localc.CLs.CLN = new com.tencent.mm.bv.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!bo.isNullOrNil(((JSONObject)localObject).optString("voice_data"))) {
          localc.CLs.CLO = new com.tencent.mm.bv.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.CLs.CLM = new e();
          localc.CLs.CLM.CLh = ((JSONObject)localObject).optString("btn_words");
          localc.CLs.CLM.CLi = ((JSONObject)localObject).optString("btn_color");
          localc.CLs.CLM.CLj = ((JSONObject)localObject).optInt("btn_op_type");
          localc.CLs.CLM.xcU = ((JSONObject)localObject).optString("get_lottery_params");
          localc.CLs.CLM.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.CLs.CLM.CLk = new d.a.a.g();
            localc.CLs.CLM.CLk.xzC = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.CLs.CLM.CLk.xzD = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.CLs.CLM.CLk.xzE = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      localObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (localObject != null)
      {
        localc.CLu = new d.a.a.b();
        localc.CLu.url = ((JSONObject)localObject).optString("url");
        localc.CLu.CLl = ((JSONObject)localObject).optString("animation_wording");
        localc.CLu.CLm = ((JSONObject)localObject).optString("animation_wording_color");
        localc.CLu.CLn = ((JSONObject)localObject).optString("after_animation_wording");
        localc.CLu.CLo = ((JSONObject)localObject).optString("after_animation_wording_color");
        localc.CLu.xWC = ((JSONObject)localObject).optInt("op_type");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.CLu.CLk = new d.a.a.g();
          localc.CLu.CLk.xzC = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.CLu.CLk.xzD = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.CLu.CLk.xzE = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("follow_cardbd_mch_info");
      if (paramJSONObject != null)
      {
        localc.CLv = new d.a.a.d();
        localc.CLv.CLw = paramJSONObject.optInt("is_followed_cardbd_mch", 0);
        localc.CLv.CLy = paramJSONObject.optString("follow_logo", "");
        localc.CLv.CLx = paramJSONObject.optString("follow_tips", "");
        localc.CLv.CLz = paramJSONObject.optString("follow_tips_color", "");
        localc.CLv.CLA = paramJSONObject.optLong("follow_tips_size", 0L);
        localc.CLv.CLD = paramJSONObject.optString("follow_logo_after", "");
        localc.CLv.CLF = paramJSONObject.optString("follow_tips_after", "");
        localc.CLv.CLE = paramJSONObject.optString("follow_tips_color_after", "");
        localc.CLv.wKD = paramJSONObject.optString("follow_param", "");
        localc.CLv.CLB = paramJSONObject.optInt("is_show_pop_up", 0);
        paramJSONObject = paramJSONObject.optJSONObject("pop_up_window_info");
        if (paramJSONObject != null)
        {
          localc.CLv.CLC = new d.a.a.h();
          localc.CLv.CLC.CLP = paramJSONObject.optString("pop_up_title");
          localc.CLv.CLC.CLQ = paramJSONObject.optString("pop_up_text");
          localc.CLv.CLC.CLS = paramJSONObject.optString("pop_up_button_text");
          localc.CLv.CLC.CLR = paramJSONObject.optString("pop_up_image_url");
        }
      }
      paramPromotions.ukr = localc;
      AppMethodBeat.o(46838);
      return;
    }
    catch (Exception paramPromotions)
    {
      ab.printErrStackTrace("MicroMsg.Orders", paramPromotions, "parseExposureInfo error: %s", new Object[] { paramPromotions.getMessage() });
      AppMethodBeat.o(46838);
    }
  }
  
  private static void a(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46839);
    if (paramJSONObject != null)
    {
      ab.i("MicroMsg.Orders", "parseDeductInfo json is not null");
      paramOrders.ujq = new Orders.DeductInfo();
      paramOrders.ujq.title = paramJSONObject.optString("contract_title");
      paramOrders.ujq.desc = paramJSONObject.optString("contract_desc");
      paramOrders.ujq.tXg = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.ujq.ujY = paramJSONObject.optString("contract_url");
      paramOrders.ujq.uka = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.ujq.tWu = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.ujq.knU = paramJSONObject.optString("button_wording", "");
      paramOrders.ujq.tWv = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.ujq.ukb = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.ujq.ukc = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.ujq.ujZ = new ArrayList();
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
              localDeductShowInfo.ukd = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.uke = localJSONObject.optString("link_weapp");
              localDeductShowInfo.ukf = localJSONObject.optString("link_addr");
              localDeductShowInfo.ukg = localJSONObject.optString("link_url");
            }
            paramOrders.ujq.ujZ.add(localDeductShowInfo);
          }
          for (;;)
          {
            i += 1;
            break;
            ab.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i)));
          }
        }
        AppMethodBeat.o(46839);
        return;
      }
      ab.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(j)));
      AppMethodBeat.o(46839);
      return;
    }
    ab.i("MicroMsg.Orders", "parseDeductInfo json is null");
    AppMethodBeat.o(46839);
  }
  
  private static com.tencent.mm.plugin.wallet.a.h aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46835);
    com.tencent.mm.plugin.wallet.a.h localh = new com.tencent.mm.plugin.wallet.a.h();
    paramJSONObject = paramJSONObject.optJSONObject("favinfo");
    if (paramJSONObject == null)
    {
      ab.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
      AppMethodBeat.o(46835);
      return localh;
    }
    localh.tUc = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localh.tUd = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localh.tUe = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localh.tUf = paramJSONObject.optString("favorComposeId");
    localh.tUi = paramJSONObject.optInt("useNaturalDefense");
    localh.tUj = paramJSONObject.optString("discountWording");
    localh.tUk = paramJSONObject.optString("favorRuleWording");
    localh.tUl = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localh.tUm = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localh.tUn = paramJSONObject.optInt("isVariableFavor");
    localh.tUo = paramJSONObject.optString("invariableFavorDesc");
    localh.tUp = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new t();
      ((t)localObject2).tUU = ((JSONObject)localObject3).optInt("favType");
      ((t)localObject2).tUV = ((JSONObject)localObject3).optInt("favSubType");
      ((t)localObject2).tUW = ((JSONObject)localObject3).optLong("favProperty");
      ((t)localObject2).tUX = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((t)localObject2).tTZ = ((JSONObject)localObject3).optString("favId");
      ((t)localObject2).tUY = ((JSONObject)localObject3).optString("favName");
      ((t)localObject2).tUZ = ((JSONObject)localObject3).optString("favDesc");
      ((t)localObject2).tUa = ((JSONObject)localObject3).optString("favorUseManual");
      ((t)localObject2).tUb = ((JSONObject)localObject3).optString("favorRemarks");
      ((t)localObject2).tVa = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((t)localObject2).tVb = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((t)localObject2).tVc = ((JSONObject)localObject3).optInt("needBankPay");
      ((t)localObject2).tVd = ((JSONObject)localObject3).optString("bankNo");
      ((t)localObject2).ppn = ((JSONObject)localObject3).optString("bankName");
      ((t)localObject2).tVe = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((t)localObject2).tVf.add(com.tencent.mm.bv.b.bL(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localh.tUg.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localh.tUh = new com.tencent.mm.plugin.wallet.a.i();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new j();
        ((j)localObject2).tUv = ((JSONObject)localObject3).optString("faovrComposeId");
        ((j)localObject2).tUw = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((j)localObject2).tUe = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((j)localObject2).tUl = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).tUm = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).tUn = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((j)localObject2).tUo = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((j)localObject2).tUp = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.a.f();
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).tTZ = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).tUa = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).tUb = ((JSONObject)localObject4).optString("favorRemarks");
          ((j)localObject2).tUx.add(localObject5);
          j += 1;
        }
        localh.tUh.tUt.add(localObject2);
        i += 1;
      }
    }
    localObject1 = new com.tencent.mm.plugin.wallet.a.a();
    Object localObject2 = paramJSONObject.optJSONObject("bank_card_info");
    if (localObject2 != null)
    {
      localObject3 = ((JSONObject)localObject2).optJSONArray("bind_serial_favor_info_list");
      if (localObject3 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject3).length())
        {
          localObject4 = new com.tencent.mm.plugin.wallet.a.c();
          localObject5 = ((JSONArray)localObject3).getJSONObject(i);
          ((com.tencent.mm.plugin.wallet.a.c)localObject4).por = ((JSONObject)localObject5).optString("bind_serial");
          localObject5 = ((JSONObject)localObject5).optJSONArray("bind_serial_favor_list");
          if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              com.tencent.mm.plugin.wallet.a.d locald = new com.tencent.mm.plugin.wallet.a.d();
              JSONObject localJSONObject = ((JSONArray)localObject5).optJSONObject(j);
              locald.qiO = localJSONObject.optString("favor_desc");
              locald.tTX = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.a.c)localObject4).tTW.add(locald);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).tTL.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.a.a)localObject1).tTM = new n();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new o();
          ((o)localObject3).qiO = ((JSONArray)localObject2).optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).tTM.tUD.add(localObject3);
          i += 1;
        }
      }
    }
    localh.tUq = ((com.tencent.mm.plugin.wallet.a.a)localObject1);
    localObject1 = paramJSONObject.optJSONArray("favcombid_forbindcard_list");
    if (localObject1 != null)
    {
      j = ((JSONArray)localObject1).length();
      i = 0;
      while (i < j)
      {
        localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject3 != null)
        {
          localObject2 = new com.tencent.mm.plugin.wallet.a.g();
          ((com.tencent.mm.plugin.wallet.a.g)localObject2).tTP = ((JSONObject)localObject3).optString("default_fav_comb_id");
          localObject3 = ((JSONObject)localObject3).optJSONObject("payment_channel");
          if (localObject3 != null)
          {
            localObject4 = new m();
            ((m)localObject4).por = ((JSONObject)localObject3).optString("bind_serial");
            ((m)localObject4).selected = ((JSONObject)localObject3).optInt("selected");
            ((m)localObject4).tUC = ((JSONObject)localObject3).optString("bankCode");
            ((com.tencent.mm.plugin.wallet.a.g)localObject2).tTN = ((m)localObject4);
          }
          localh.tUr.add(localObject2);
        }
        i += 1;
      }
    }
    localObject1 = new com.tencent.mm.plugin.wallet.a.b();
    paramJSONObject = paramJSONObject.optJSONObject("bank_fav_guide");
    if (paramJSONObject != null)
    {
      localObject2 = new m();
      localObject3 = paramJSONObject.optJSONObject("payment_channel");
      if (localObject3 != null)
      {
        ((m)localObject2).tUC = ((JSONObject)localObject3).optString("bankCode");
        ((m)localObject2).selected = ((JSONObject)localObject3).optInt("selected");
        ((m)localObject2).por = ((JSONObject)localObject3).optString("bind_serial");
        ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTN = ((m)localObject2);
      }
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTO = paramJSONObject.optInt("is_show_guide");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTP = paramJSONObject.optString("default_fav_comb_id");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTQ = paramJSONObject.optString("guide_content");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTR = paramJSONObject.optString("guide_content_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTS = paramJSONObject.optString("guide_btn_text");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTT = paramJSONObject.optString("guide_btn_text_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTU = paramJSONObject.optString("guide_btn_bg_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).tTV = paramJSONObject.optString("guide_logo");
      localh.tUs = ((com.tencent.mm.plugin.wallet.a.b)localObject1);
    }
    AppMethodBeat.o(46835);
    return localh;
  }
  
  private static HashSet<String> afg(String paramString)
  {
    AppMethodBeat.i(46842);
    HashSet localHashSet = new HashSet();
    if (!bo.isNullOrNil(paramString))
    {
      paramString = paramString.split("\\|");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramString[i]);
        i += 1;
      }
      if (localHashSet.size() <= 0) {
        break label75;
      }
      localHashSet.retainAll(localHashSet);
    }
    for (;;)
    {
      AppMethodBeat.o(46842);
      return localHashSet;
      label75:
      localHashSet.clear();
    }
  }
  
  /* Error */
  public static Orders au(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 1537
    //   3: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: ifnull +896 -> 906
    //   13: new 2	com/tencent/mm/plugin/wallet_core/model/Orders
    //   16: dup
    //   17: invokespecial 1538	com/tencent/mm/plugin/wallet_core/model/Orders:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 1541	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   27: putfield 217	com/tencent/mm/plugin/wallet_core/model/Orders:uiU	J
    //   30: aload 5
    //   32: aload_0
    //   33: ldc_w 469
    //   36: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: ldc_w 1543
    //   42: getstatic 1549	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   45: invokestatic 1554	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   48: putfield 146	com/tencent/mm/plugin/wallet_core/model/Orders:cnL	D
    //   51: aload 5
    //   53: aload_0
    //   54: ldc_w 1556
    //   57: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: putfield 144	com/tencent/mm/plugin/wallet_core/model/Orders:ehy	Ljava/lang/String;
    //   63: aload 5
    //   65: aload_0
    //   66: ldc_w 1558
    //   69: iconst_1
    //   70: invokevirtual 312	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   73: putfield 231	com/tencent/mm/plugin/wallet_core/model/Orders:ubU	I
    //   76: aload 5
    //   78: aload_0
    //   79: ldc_w 491
    //   82: ldc 136
    //   84: invokevirtual 494	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: putfield 233	com/tencent/mm/plugin/wallet_core/model/Orders:ppp	Ljava/lang/String;
    //   90: aload 5
    //   92: aload_0
    //   93: ldc_w 1560
    //   96: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: ldc_w 1543
    //   102: getstatic 1549	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   105: invokestatic 1554	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   108: putfield 235	com/tencent/mm/plugin/wallet_core/model/Orders:qjD	D
    //   111: aload 5
    //   113: aload_0
    //   114: ldc_w 1562
    //   117: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: ldc_w 1543
    //   123: getstatic 1549	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   126: invokestatic 1554	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   129: putfield 148	com/tencent/mm/plugin/wallet_core/model/Orders:uiV	D
    //   132: aload 5
    //   134: aload_0
    //   135: ldc_w 1564
    //   138: invokevirtual 406	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   141: putfield 237	com/tencent/mm/plugin/wallet_core/model/Orders:uiW	I
    //   144: aload 5
    //   146: aload_0
    //   147: ldc_w 1566
    //   150: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: putfield 239	com/tencent/mm/plugin/wallet_core/model/Orders:ueu	Ljava/lang/String;
    //   156: aload 5
    //   158: aload_0
    //   159: ldc_w 1568
    //   162: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 241	com/tencent/mm/plugin/wallet_core/model/Orders:uht	Ljava/lang/String;
    //   168: aload 5
    //   170: aload_0
    //   171: ldc_w 1570
    //   174: invokevirtual 406	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   177: putfield 243	com/tencent/mm/plugin/wallet_core/model/Orders:uiX	I
    //   180: aload 5
    //   182: aload_0
    //   183: ldc_w 1572
    //   186: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 245	com/tencent/mm/plugin/wallet_core/model/Orders:uiY	Ljava/lang/String;
    //   192: aload_0
    //   193: ldc_w 1574
    //   196: invokevirtual 322	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   199: astore 6
    //   201: aload 5
    //   203: aload_0
    //   204: ldc_w 1576
    //   207: invokevirtual 393	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   210: putfield 1578	com/tencent/mm/plugin/wallet_core/model/Orders:ujr	J
    //   213: aload 5
    //   215: aload_0
    //   216: ldc_w 1580
    //   219: invokevirtual 393	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   222: putfield 1582	com/tencent/mm/plugin/wallet_core/model/Orders:ujs	J
    //   225: aload 5
    //   227: aload_0
    //   228: ldc_w 1584
    //   231: iconst_0
    //   232: invokevirtual 312	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   235: putfield 185	com/tencent/mm/plugin/wallet_core/model/Orders:ujt	I
    //   238: aload 5
    //   240: aload_0
    //   241: ldc_w 1586
    //   244: iconst_0
    //   245: invokevirtual 312	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   248: putfield 187	com/tencent/mm/plugin/wallet_core/model/Orders:uju	I
    //   251: aload_0
    //   252: ldc_w 1588
    //   255: iconst_0
    //   256: invokevirtual 312	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   259: iconst_1
    //   260: if_icmpne +885 -> 1145
    //   263: iconst_1
    //   264: istore_1
    //   265: iload_1
    //   266: ifeq +15 -> 281
    //   269: aload 5
    //   271: new 160	java/util/HashSet
    //   274: dup
    //   275: invokespecial 161	java/util/HashSet:<init>	()V
    //   278: putfield 163	com/tencent/mm/plugin/wallet_core/model/Orders:uji	Ljava/util/Set;
    //   281: aload 6
    //   283: invokevirtual 327	org/json/JSONArray:length	()I
    //   286: istore_3
    //   287: iconst_0
    //   288: istore_2
    //   289: iload_2
    //   290: iload_3
    //   291: if_icmpge +279 -> 570
    //   294: aload 6
    //   296: iload_2
    //   297: invokevirtual 331	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   300: astore 7
    //   302: new 8	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity
    //   305: dup
    //   306: invokespecial 1589	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:<init>	()V
    //   309: astore 8
    //   311: aload 8
    //   313: aload 7
    //   315: ldc_w 1590
    //   318: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   321: putfield 1591	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:desc	Ljava/lang/String;
    //   324: aload 8
    //   326: aload 7
    //   328: ldc_w 1593
    //   331: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: ldc_w 1543
    //   337: getstatic 1549	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   340: invokestatic 1554	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   343: putfield 482	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:kNS	D
    //   346: aload 8
    //   348: new 1595	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 1596	java/lang/StringBuilder:<init>	()V
    //   355: aload 7
    //   357: ldc_w 1598
    //   360: iconst_1
    //   361: invokevirtual 312	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   364: invokevirtual 1602	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 1605	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: putfield 1608	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppg	Ljava/lang/String;
    //   373: aload 8
    //   375: aload 7
    //   377: ldc_w 428
    //   380: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   383: putfield 431	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppi	Ljava/lang/String;
    //   386: aload 8
    //   388: aload 7
    //   390: ldc_w 438
    //   393: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: putfield 441	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppn	Ljava/lang/String;
    //   399: aload 8
    //   401: aload 7
    //   403: ldc_w 433
    //   406: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   409: putfield 436	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppj	Ljava/lang/String;
    //   412: aload 8
    //   414: aload 7
    //   416: ldc_w 1610
    //   419: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   422: putfield 1613	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppd	Ljava/lang/String;
    //   425: aload 8
    //   427: aload 7
    //   429: ldc_w 1615
    //   432: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   435: putfield 1618	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppe	Ljava/lang/String;
    //   438: aload 8
    //   440: aload 7
    //   442: ldc_w 1620
    //   445: invokevirtual 406	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   448: putfield 446	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppl	I
    //   451: aload 8
    //   453: aload 7
    //   455: ldc_w 348
    //   458: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   461: putfield 354	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:cnJ	Ljava/lang/String;
    //   464: aload 8
    //   466: aload 7
    //   468: ldc_w 491
    //   471: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   474: putfield 495	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppp	Ljava/lang/String;
    //   477: aload 5
    //   479: getfield 233	com/tencent/mm/plugin/wallet_core/model/Orders:ppp	Ljava/lang/String;
    //   482: invokestatic 527	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   485: ifeq +13 -> 498
    //   488: aload 5
    //   490: aload 8
    //   492: getfield 495	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppp	Ljava/lang/String;
    //   495: putfield 233	com/tencent/mm/plugin/wallet_core/model/Orders:ppp	Ljava/lang/String;
    //   498: aload 8
    //   500: aload 7
    //   502: ldc_w 1622
    //   505: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   508: putfield 1623	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ppq	Ljava/lang/String;
    //   511: aload 8
    //   513: aload 7
    //   515: ldc_w 306
    //   518: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   521: putfield 1626	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:poT	Ljava/lang/String;
    //   524: aload 5
    //   526: getfield 172	com/tencent/mm/plugin/wallet_core/model/Orders:ujl	Ljava/util/List;
    //   529: aload 8
    //   531: invokeinterface 530 2 0
    //   536: pop
    //   537: iload_1
    //   538: ifne +600 -> 1138
    //   541: aload 5
    //   543: aload 7
    //   545: ldc_w 1628
    //   548: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   551: putfield 266	com/tencent/mm/plugin/wallet_core/model/Orders:ujh	Ljava/lang/String;
    //   554: aload 5
    //   556: aload 5
    //   558: getfield 266	com/tencent/mm/plugin/wallet_core/model/Orders:ujh	Ljava/lang/String;
    //   561: invokestatic 270	com/tencent/mm/plugin/wallet_core/model/Orders:afg	(Ljava/lang/String;)Ljava/util/HashSet;
    //   564: putfield 163	com/tencent/mm/plugin/wallet_core/model/Orders:uji	Ljava/util/Set;
    //   567: goto +571 -> 1138
    //   570: aload_0
    //   571: ldc_w 1630
    //   574: invokevirtual 473	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   577: ifeq +338 -> 915
    //   580: aload 5
    //   582: aload_0
    //   583: ldc_w 1630
    //   586: invokestatic 1634	com/tencent/mm/wallet_core/ui/e:n	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   589: putfield 150	com/tencent/mm/plugin/wallet_core/model/Orders:ujd	Z
    //   592: aload 5
    //   594: aload_0
    //   595: invokestatic 1636	com/tencent/mm/plugin/wallet_core/model/Orders:aG	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet/a/h;
    //   598: putfield 177	com/tencent/mm/plugin/wallet_core/model/Orders:ujm	Lcom/tencent/mm/plugin/wallet/a/h;
    //   601: aload_0
    //   602: ldc_w 1638
    //   605: invokevirtual 298	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   608: astore 6
    //   610: aload 6
    //   612: ifnonnull +337 -> 949
    //   615: ldc_w 379
    //   618: ldc_w 1640
    //   621: invokestatic 1172	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload 5
    //   626: aload_0
    //   627: ldc_w 1642
    //   630: invokevirtual 406	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   633: putfield 179	com/tencent/mm/plugin/wallet_core/model/Orders:ujn	I
    //   636: aload 5
    //   638: aload_0
    //   639: ldc_w 1644
    //   642: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   645: putfield 181	com/tencent/mm/plugin/wallet_core/model/Orders:ujo	Ljava/lang/String;
    //   648: aload 5
    //   650: aload_0
    //   651: ldc_w 1646
    //   654: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   657: putfield 183	com/tencent/mm/plugin/wallet_core/model/Orders:ujp	Ljava/lang/String;
    //   660: aload 5
    //   662: aload_0
    //   663: ldc_w 1648
    //   666: invokevirtual 298	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   669: invokestatic 1650	com/tencent/mm/plugin/wallet_core/model/Orders:a	(Lcom/tencent/mm/plugin/wallet_core/model/Orders;Lorg/json/JSONObject;)V
    //   672: aload_0
    //   673: ldc_w 1652
    //   676: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   679: astore 6
    //   681: aload 6
    //   683: invokestatic 527	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   686: ifne +42 -> 728
    //   689: aload 6
    //   691: iconst_0
    //   692: invokestatic 1658	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   695: astore 6
    //   697: new 1660	com/tencent/mm/protocal/protobuf/adn
    //   700: dup
    //   701: invokespecial 1661	com/tencent/mm/protocal/protobuf/adn:<init>	()V
    //   704: aload 6
    //   706: invokevirtual 1665	com/tencent/mm/protocal/protobuf/adn:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   709: checkcast 1660	com/tencent/mm/protocal/protobuf/adn
    //   712: astore 6
    //   714: aload 5
    //   716: getfield 203	com/tencent/mm/plugin/wallet_core/model/Orders:field_infos	Ljava/util/ArrayList;
    //   719: aload 6
    //   721: getfield 1668	com/tencent/mm/protocal/protobuf/adn:field_info	Ljava/util/LinkedList;
    //   724: invokevirtual 1671	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   727: pop
    //   728: aload 5
    //   730: aload_0
    //   731: ldc_w 1673
    //   734: ldc 142
    //   736: invokevirtual 494	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   739: putfield 205	com/tencent/mm/plugin/wallet_core/model/Orders:ujC	Ljava/lang/String;
    //   742: aload 5
    //   744: aload_0
    //   745: ldc_w 1675
    //   748: ldc 136
    //   750: invokevirtual 494	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   753: putfield 1677	com/tencent/mm/plugin/wallet_core/model/Orders:ujD	Ljava/lang/String;
    //   756: aload 5
    //   758: aload_0
    //   759: ldc_w 1679
    //   762: ldc 136
    //   764: invokevirtual 494	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   767: putfield 1681	com/tencent/mm/plugin/wallet_core/model/Orders:ujE	Ljava/lang/String;
    //   770: aload 5
    //   772: aload_0
    //   773: ldc_w 1683
    //   776: ldc 142
    //   778: invokevirtual 494	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   781: putfield 207	com/tencent/mm/plugin/wallet_core/model/Orders:ujF	Ljava/lang/String;
    //   784: aload 5
    //   786: aload_0
    //   787: ldc_w 1685
    //   790: ldc 136
    //   792: invokevirtual 494	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   795: putfield 1687	com/tencent/mm/plugin/wallet_core/model/Orders:ujG	Ljava/lang/String;
    //   798: aload 5
    //   800: aload_0
    //   801: ldc_w 1689
    //   804: ldc 136
    //   806: invokevirtual 494	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   809: putfield 1691	com/tencent/mm/plugin/wallet_core/model/Orders:ujH	Ljava/lang/String;
    //   812: aload 5
    //   814: aload_0
    //   815: ldc_w 1693
    //   818: iconst_0
    //   819: invokevirtual 312	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   822: putfield 1695	com/tencent/mm/plugin/wallet_core/model/Orders:ujI	I
    //   825: aload_0
    //   826: ldc_w 1638
    //   829: invokevirtual 298	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   832: astore_0
    //   833: aload_0
    //   834: ifnull +72 -> 906
    //   837: aload_0
    //   838: ldc_w 1697
    //   841: invokevirtual 298	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   844: astore_0
    //   845: aload_0
    //   846: ifnull +60 -> 906
    //   849: aload 5
    //   851: new 30	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo
    //   854: dup
    //   855: invokespecial 1698	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:<init>	()V
    //   858: putfield 285	com/tencent/mm/plugin/wallet_core/model/Orders:ujJ	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   861: aload 5
    //   863: getfield 285	com/tencent/mm/plugin/wallet_core/model/Orders:ujJ	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   866: aload_0
    //   867: ldc_w 1700
    //   870: invokevirtual 406	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   873: putfield 1703	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:ukG	I
    //   876: aload 5
    //   878: getfield 285	com/tencent/mm/plugin/wallet_core/model/Orders:ujJ	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   881: aload_0
    //   882: ldc_w 1705
    //   885: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: putfield 1708	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:poq	Ljava/lang/String;
    //   891: aload 5
    //   893: getfield 285	com/tencent/mm/plugin/wallet_core/model/Orders:ujJ	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   896: aload_0
    //   897: ldc_w 1394
    //   900: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   903: putfield 1709	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:por	Ljava/lang/String;
    //   906: ldc_w 1537
    //   909: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   912: aload 5
    //   914: areturn
    //   915: aload 5
    //   917: aload 5
    //   919: getfield 231	com/tencent/mm/plugin/wallet_core/model/Orders:ubU	I
    //   922: iconst_2
    //   923: invokestatic 1715	com/tencent/mm/plugin/wallet_core/model/Bankcard:gx	(II)Z
    //   926: putfield 150	com/tencent/mm/plugin/wallet_core/model/Orders:ujd	Z
    //   929: goto -337 -> 592
    //   932: astore_0
    //   933: ldc_w 379
    //   936: aload_0
    //   937: ldc 136
    //   939: iconst_0
    //   940: anewarray 4	java/lang/Object
    //   943: invokestatic 385	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   946: goto -40 -> 906
    //   949: aload 6
    //   951: ldc_w 1717
    //   954: invokevirtual 298	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   957: astore 6
    //   959: aload 6
    //   961: ifnonnull +15 -> 976
    //   964: ldc_w 379
    //   967: ldc_w 1719
    //   970: invokestatic 1172	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   973: goto -349 -> 624
    //   976: aload 6
    //   978: ldc_w 1721
    //   981: invokevirtual 298	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   984: astore 6
    //   986: aload 6
    //   988: ifnonnull +15 -> 1003
    //   991: ldc_w 379
    //   994: ldc_w 1723
    //   997: invokestatic 1172	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: goto -376 -> 624
    //   1003: invokestatic 1726	com/tencent/mm/wallet_core/ui/e:dSU	()Z
    //   1006: ifeq +144 -> 1150
    //   1009: aload 6
    //   1011: ldc_w 1728
    //   1014: iconst_0
    //   1015: invokevirtual 312	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1018: istore_1
    //   1019: aload 5
    //   1021: iload_1
    //   1022: putfield 165	com/tencent/mm/plugin/wallet_core/model/Orders:ujj	I
    //   1025: aload 5
    //   1027: aload 6
    //   1029: ldc_w 1730
    //   1032: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1035: putfield 167	com/tencent/mm/plugin/wallet_core/model/Orders:ujk	Ljava/lang/String;
    //   1038: aload 6
    //   1040: ldc_w 1732
    //   1043: invokevirtual 304	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1046: astore 7
    //   1048: iconst_1
    //   1049: aload 6
    //   1051: ldc_w 1734
    //   1054: invokevirtual 406	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1057: if_icmpne +98 -> 1155
    //   1060: iconst_1
    //   1061: istore 4
    //   1063: getstatic 1740	com/tencent/mm/plugin/wallet_core/model/x:uli	Lcom/tencent/mm/plugin/wallet_core/model/x;
    //   1066: aload 7
    //   1068: putfield 1743	com/tencent/mm/plugin/wallet_core/model/x:mGC	Ljava/lang/String;
    //   1071: getstatic 1740	com/tencent/mm/plugin/wallet_core/model/x:uli	Lcom/tencent/mm/plugin/wallet_core/model/x;
    //   1074: iload 4
    //   1076: putfield 1746	com/tencent/mm/plugin/wallet_core/model/x:mGD	Z
    //   1079: ldc_w 379
    //   1082: ldc_w 1748
    //   1085: iconst_3
    //   1086: anewarray 4	java/lang/Object
    //   1089: dup
    //   1090: iconst_0
    //   1091: aload 5
    //   1093: getfield 165	com/tencent/mm/plugin/wallet_core/model/Orders:ujj	I
    //   1096: invokestatic 1753	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1099: aastore
    //   1100: dup
    //   1101: iconst_1
    //   1102: aload 7
    //   1104: aastore
    //   1105: dup
    //   1106: iconst_2
    //   1107: iload 4
    //   1109: invokestatic 1758	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1112: aastore
    //   1113: invokestatic 735	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1116: goto -492 -> 624
    //   1119: astore 6
    //   1121: ldc_w 379
    //   1124: aload 6
    //   1126: ldc 136
    //   1128: iconst_0
    //   1129: anewarray 4	java/lang/Object
    //   1132: invokestatic 385	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1135: goto -407 -> 728
    //   1138: iload_2
    //   1139: iconst_1
    //   1140: iadd
    //   1141: istore_2
    //   1142: goto -853 -> 289
    //   1145: iconst_0
    //   1146: istore_1
    //   1147: goto -882 -> 265
    //   1150: iconst_0
    //   1151: istore_1
    //   1152: goto -133 -> 1019
    //   1155: iconst_0
    //   1156: istore 4
    //   1158: goto -95 -> 1063
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1161	0	paramJSONObject	JSONObject
    //   264	888	1	i	int
    //   288	854	2	j	int
    //   286	6	3	k	int
    //   1061	96	4	bool	boolean
    //   7	1085	5	localOrders	Orders
    //   199	851	6	localObject1	Object
    //   1119	6	6	localIOException	java.io.IOException
    //   300	803	7	localObject2	Object
    //   309	221	8	localCommodity	Orders.Commodity
    // Exception table:
    //   from	to	target	type
    //   22	263	932	org/json/JSONException
    //   269	281	932	org/json/JSONException
    //   281	287	932	org/json/JSONException
    //   294	498	932	org/json/JSONException
    //   498	537	932	org/json/JSONException
    //   541	567	932	org/json/JSONException
    //   570	592	932	org/json/JSONException
    //   592	610	932	org/json/JSONException
    //   615	624	932	org/json/JSONException
    //   624	697	932	org/json/JSONException
    //   697	728	932	org/json/JSONException
    //   728	833	932	org/json/JSONException
    //   837	845	932	org/json/JSONException
    //   849	906	932	org/json/JSONException
    //   915	929	932	org/json/JSONException
    //   949	959	932	org/json/JSONException
    //   964	973	932	org/json/JSONException
    //   976	986	932	org/json/JSONException
    //   991	1000	932	org/json/JSONException
    //   1003	1019	932	org/json/JSONException
    //   1019	1060	932	org/json/JSONException
    //   1063	1116	932	org/json/JSONException
    //   1121	1135	932	org/json/JSONException
    //   697	728	1119	java/io/IOException
  }
  
  private static void b(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46840);
    if (paramJSONObject != null) {
      try
      {
        paramOrders.ujx = paramJSONObject.optInt("is_use_show_info", 0);
        ab.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.ujx) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          ab.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.ujz = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.nmk = localJSONObject.optString("name_color");
              localShowInfo.ukA = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.ukB = localJSONObject.optInt("link_type");
                localShowInfo.ukC = localJSONObject.optString("link_weapp");
                localShowInfo.ukD = localJSONObject.optString("link_addr");
                localShowInfo.ukE = localJSONObject.optString("link_url");
                localShowInfo.ukF = localJSONObject.optInt("text_attr");
              }
              if ((!bo.isNullOrNil(localShowInfo.name)) || (!bo.isNullOrNil(localShowInfo.value))) {
                paramOrders.ujz.add(localShowInfo);
              }
            }
            i += 1;
          }
        }
        AppMethodBeat.o(46840);
        return;
      }
      catch (Exception paramOrders)
      {
        ab.printErrStackTrace("MicroMsg.Orders", paramOrders, "parseShowInfo error", new Object[0]);
      }
    }
    AppMethodBeat.o(46840);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(46841);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reqKey:").append(this.cnI).append("\n");
    ((StringBuilder)localObject).append("token").append(this.token).append("\n");
    ((StringBuilder)localObject).append("num").append(this.ehy).append("\n");
    ((StringBuilder)localObject).append("totalFee").append(this.cnL).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(46841);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46844);
    paramParcel.writeLong(this.uiU);
    paramParcel.writeString(this.cnI);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.ehy);
    paramParcel.writeDouble(this.cnL);
    paramParcel.writeInt(this.ubU);
    paramParcel.writeString(this.ppp);
    paramParcel.writeDouble(this.qjD);
    paramParcel.writeDouble(this.uiV);
    paramParcel.writeInt(this.uiW);
    paramParcel.writeString(this.ueu);
    paramParcel.writeString(this.uht);
    paramParcel.writeInt(this.uiX);
    paramParcel.writeString(this.uiY);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.pek);
    paramParcel.writeString(this.uiZ);
    paramParcel.writeString(this.uja);
    paramParcel.writeString(this.ujb);
    paramParcel.writeInt(this.ujc);
    if (this.ujd) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.uje);
      paramParcel.writeString(this.lHq);
      paramParcel.writeLong(this.ujf);
      paramParcel.writeString(this.ujg);
      paramParcel.writeTypedList(this.ujl);
      paramParcel.writeString(this.ujh);
      paramParcel.writeInt(this.ujj);
      paramParcel.writeString(this.ujk);
      paramParcel.writeParcelable(this.ujq, 1);
      paramParcel.writeInt(this.ujt);
      paramParcel.writeInt(this.uju);
      paramParcel.writeInt(this.ujy);
      paramParcel.writeString(this.ujB);
      paramParcel.writeString(this.ujA);
      paramParcel.writeInt(this.ujx);
      paramParcel.writeTypedList(this.ujz);
      paramParcel.writeParcelable(this.ujJ, 1);
      AppMethodBeat.o(46844);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders
 * JD-Core Version:    0.7.0.1
 */