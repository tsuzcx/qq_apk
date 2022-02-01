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
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import e.a.a.e;
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
  public static int HZC;
  public static int HZD;
  public String AAU;
  public String AOl;
  public double CoZ;
  public int HQg;
  public String HTZ;
  public String HXh;
  public long HYL;
  public double HYM;
  public int HYN;
  public int HYO;
  public String HYP;
  public String HYQ;
  public String HYR;
  public String HYS;
  public int HYT;
  public boolean HYU;
  public String HYV;
  public long HYW;
  public String HYX;
  public String HYY;
  public Set<String> HYZ;
  public int HZA;
  public SimpleCashierInfo HZB;
  public int HZa;
  public boolean HZb;
  public String HZc;
  public List<Commodity> HZd;
  public com.tencent.mm.plugin.wallet.a.h HZe;
  public int HZf;
  public String HZg;
  public String HZh;
  public DeductInfo HZi;
  public long HZj;
  public long HZk;
  public int HZl;
  public int HZm;
  public int HZn;
  public String HZo;
  public int HZp;
  public int HZq;
  public ArrayList<Orders.ShowInfo> HZr;
  public String HZs;
  public String HZt;
  public String HZu;
  public String HZv;
  public String HZw;
  public String HZx;
  public String HZy;
  public String HZz;
  public String dDL;
  public double dDO;
  public ArrayList<egf> field_infos;
  public String nickname;
  public String num;
  public String rCq;
  public String token;
  public String username;
  public String wFE;
  
  static
  {
    AppMethodBeat.i(70364);
    CREATOR = new Orders.1();
    HZC = 0;
    HZD = 1;
    AppMethodBeat.o(70364);
  }
  
  public Orders()
  {
    AppMethodBeat.i(70352);
    this.dDL = "";
    this.token = "";
    this.num = "0";
    this.dDO = 0.0D;
    this.HYM = 0.0D;
    this.HYU = false;
    this.HYV = "";
    this.rCq = "";
    this.HYW = 0L;
    this.HYX = "";
    this.HYZ = new HashSet();
    this.HZa = 0;
    this.HZc = "";
    this.HZd = new ArrayList();
    this.HZe = new com.tencent.mm.plugin.wallet.a.h();
    this.HZf = 0;
    this.HZg = "";
    this.HZh = "";
    this.HZl = 0;
    this.HZm = 0;
    this.HZn = 0;
    this.HZo = "";
    this.HZp = 0;
    this.HZq = 0;
    this.HZr = new ArrayList();
    this.HZs = "";
    this.HZt = "";
    this.field_infos = new ArrayList();
    this.HZu = "";
    this.HZx = "";
    AppMethodBeat.o(70352);
  }
  
  public Orders(Parcel paramParcel)
  {
    AppMethodBeat.i(70362);
    this.dDL = "";
    this.token = "";
    this.num = "0";
    this.dDO = 0.0D;
    this.HYM = 0.0D;
    this.HYU = false;
    this.HYV = "";
    this.rCq = "";
    this.HYW = 0L;
    this.HYX = "";
    this.HYZ = new HashSet();
    this.HZa = 0;
    this.HZc = "";
    this.HZd = new ArrayList();
    this.HZe = new com.tencent.mm.plugin.wallet.a.h();
    this.HZf = 0;
    this.HZg = "";
    this.HZh = "";
    this.HZl = 0;
    this.HZm = 0;
    this.HZn = 0;
    this.HZo = "";
    this.HZp = 0;
    this.HZq = 0;
    this.HZr = new ArrayList();
    this.HZs = "";
    this.HZt = "";
    this.field_infos = new ArrayList();
    this.HZu = "";
    this.HZx = "";
    this.HYL = paramParcel.readLong();
    this.dDL = paramParcel.readString();
    this.token = paramParcel.readString();
    this.num = paramParcel.readString();
    this.dDO = paramParcel.readDouble();
    this.HQg = paramParcel.readInt();
    this.AOl = paramParcel.readString();
    this.CoZ = paramParcel.readDouble();
    this.HYM = paramParcel.readDouble();
    this.HYN = paramParcel.readInt();
    this.HTZ = paramParcel.readString();
    this.HXh = paramParcel.readString();
    this.HYO = paramParcel.readInt();
    this.HYP = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.AAU = paramParcel.readString();
    this.HYQ = paramParcel.readString();
    this.HYR = paramParcel.readString();
    this.HYS = paramParcel.readString();
    this.HYT = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.HYU = bool1;
      this.HYV = paramParcel.readString();
      this.rCq = paramParcel.readString();
      this.HYW = paramParcel.readLong();
      this.HYX = paramParcel.readString();
      paramParcel.readTypedList(this.HZd, Commodity.CREATOR);
      this.HYY = paramParcel.readString();
      this.HYZ = aVg(this.HYY);
      this.HZa = paramParcel.readInt();
      this.HZc = paramParcel.readString();
      this.HZi = ((DeductInfo)paramParcel.readParcelable(DeductInfo.class.getClassLoader()));
      this.HZl = paramParcel.readInt();
      this.HZm = paramParcel.readInt();
      this.HZq = paramParcel.readInt();
      this.HZt = paramParcel.readString();
      this.HZs = paramParcel.readString();
      this.HZp = paramParcel.readInt();
      paramParcel.readTypedList(this.HZr, Orders.ShowInfo.CREATOR);
      this.HZB = ((SimpleCashierInfo)paramParcel.readParcelable(SimpleCashierInfo.class.getClassLoader()));
      this.wFE = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label591;
      }
    }
    label591:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.HZb = bool1;
      AppMethodBeat.o(70362);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static Orders a(JSONObject paramJSONObject, Orders paramOrders)
  {
    AppMethodBeat.i(70355);
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
          paramOrders.HYR = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.HYS = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.HYT = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.rCq = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.HYT;
        localObject1 = paramOrders.HZd;
        paramOrders.HYV = paramJSONObject.optString("pay_result_tips");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("payresult");
        int k = localJSONArray.length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          Object localObject2;
          if ((localObject1 != null) && (((List)localObject1).size() == 1))
          {
            localObject2 = (Commodity)((List)localObject1).get(0);
            ((Commodity)localObject2).HZN = new ArrayList();
            ((Commodity)localObject2).HZH = new ArrayList();
            ((Commodity)localObject2).dDM = localJSONObject.getString("transaction_id");
            a((Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Commodity localCommodity = (Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.dDM))) {
                continue;
              }
              a(localCommodity, localJSONObject, j);
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.Orders", paramJSONObject, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(70355);
        return paramOrders;
        localObject1 = paramJSONObject.optJSONObject("extinfo");
        if (localObject1 != null)
        {
          paramOrders.HYW = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
          paramOrders.HYX = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
        }
        paramOrders.HZn = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
        paramOrders.HZo = paramJSONObject.optString("pay_succ_btn_wording");
        paramOrders.HZq = paramJSONObject.optInt("is_jsapi_close_page");
        paramOrders.HZs = paramJSONObject.optString("jsapi_tinyapp_username");
        paramOrders.HZt = paramJSONObject.optString("jsapi_tinyapp_path");
        b(paramOrders, paramJSONObject);
        continue;
        Log.w("MicroMsg.Orders", "oldOrders is null");
      }
      i += 1;
    }
  }
  
  private static void a(Commodity paramCommodity, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(70356);
    paramCommodity.AOp = paramJSONObject.optString("discount");
    paramCommodity.AOe = paramJSONObject.getString("pay_status");
    paramCommodity.AOf = paramJSONObject.getString("pay_status_name");
    paramCommodity.AOj = paramJSONObject.optString("buy_bank_name");
    paramCommodity.AOh = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.HZG = paramJSONObject.optString("card_tail");
    paramCommodity.HYT = paramInt;
    paramCommodity.HZI = paramJSONObject.optString("rateinfo");
    paramCommodity.HZJ = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.HZK = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.qwJ = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.HZE = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.AOl = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Promotions();
      ((Promotions)localObject2).type = HZC;
      ((Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Promotions)localObject2).dCu = ((JSONObject)localObject1).optString("username");
      paramCommodity.HZF = ((Promotions)localObject2).dCu;
      ((Promotions)localObject2).Bah = ((JSONObject)localObject1).optString("logo_round_url");
      ((Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!Util.isNullOrNil(((Promotions)localObject2).name)) && (!Util.isNullOrNil(((Promotions)localObject2).url)))
      {
        paramCommodity.HZN.add(localObject2);
        paramCommodity.HZO = true;
      }
    }
    localObject1 = paramJSONObject.getJSONArray("activity_info");
    int j = ((JSONArray)localObject1).length();
    paramInt = 0;
    Object localObject3;
    while (paramInt < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
      localObject3 = new Promotions();
      ((Promotions)localObject3).type = HZD;
      ((Promotions)localObject3).Bah = ((JSONObject)localObject2).optString("icon");
      ((Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Promotions)localObject3).HYF = ((JSONObject)localObject2).optString("btn_text");
      ((Promotions)localObject3).trD = ((JSONObject)localObject2).optInt("type");
      ((Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Promotions)localObject3).crw = ((JSONObject)localObject2).optLong("activity_id");
      ((Promotions)localObject3).Utv = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Promotions)localObject3).Utx = ((JSONObject)localObject2).optString("small_title");
      ((Promotions)localObject3).Utw = ((JSONObject)localObject2).optInt("award_id");
      ((Promotions)localObject3).HYC = ((JSONObject)localObject2).optInt("send_record_id");
      ((Promotions)localObject3).HYD = ((JSONObject)localObject2).optInt("user_record_id");
      ((Promotions)localObject3).Uty = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Promotions)localObject3).Utz = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Promotions)localObject3).HYE = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Promotions)localObject3).UtA = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Promotions)localObject3).UtB = ((JSONObject)localObject2).optString("get_award_params");
      ((Promotions)localObject3).UtC = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.HZN.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.HZP.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.HZP.url = ((JSONObject)localObject1).optString("url");
    }
    localObject1 = paramJSONObject.optJSONArray("discount_array");
    if (localObject1 != null)
    {
      j = ((JSONArray)localObject1).length();
      paramInt = i;
      while (paramInt < j)
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(paramInt);
        localObject3 = new DiscountInfo();
        if (localObject2 != null)
        {
          ((DiscountInfo)localObject3).HZY = ((JSONObject)localObject2).optDouble("payment_amount");
          ((DiscountInfo)localObject3).Coh = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.HZH.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.HZL == null) {
        paramCommodity.HZL = new RecommendTinyAppInfo();
      }
      paramCommodity.HZL.HLz = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.HZL.HYH = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.HZL.HYI = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.HZL.Hwr = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.HZL.Hws = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.HZL.HYJ = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.HZL.Iai = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.HZL.Iaj = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.HZL.Iak = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.HZL.Ial = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.HZL.Iam = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.HZL.Ian = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.HZL.HYK = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.HZM == null) {
        paramCommodity.HZM = new RemarksInfo();
      }
      paramCommodity.HZM.Iao = paramJSONObject.optString("remark_title");
      paramCommodity.HZM.Iap = paramJSONObject.optString("remark_desc");
    }
    AppMethodBeat.o(70356);
  }
  
  public static void a(Promotions paramPromotions, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70357);
    Log.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.Iah = null;
      AppMethodBeat.o(70357);
      return;
    }
    try
    {
      e.a.a.c localc = new e.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.Ltm = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          e.a.a.i locali = new e.a.a.i();
          locali.Bah = localJSONObject.optString("logo");
          locali.UbK = localJSONObject.optString("award_name");
          locali.UbL = localJSONObject.optString("award_description");
          locali.UbM = localJSONObject.optString("background_img");
          locali.UbO = localJSONObject.optString("award_description_color");
          locali.UbN = localJSONObject.optString("award_name_color");
          localc.Ltm.add(locali);
          i += 1;
        }
      }
      localc.Ubh = paramJSONObject.optInt("is_query_others", 0);
      localc.LrG = paramJSONObject.optString("draw_lottery_params");
      localc.Ltn = paramJSONObject.optInt("is_show_btn");
      localc.Ubl = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.Lto = new e.a.a.a();
        localc.Lto.UaZ = ((JSONObject)localObject).optString("btn_words");
        localc.Lto.Uba = ((JSONObject)localObject).optString("btn_color");
        localc.Lto.Ubb = ((JSONObject)localObject).optInt("btn_op_type");
        localc.Lto.url = ((JSONObject)localObject).optString("url");
        localc.Lto.LXU = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.Lto.Ubc = new e.a.a.g();
          localc.Lto.Ubc.MFd = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.Lto.Ubc.MFe = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.Lto.Ubc.MFf = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.Ltl = paramJSONObject.optString("exposure_info_modify_params");
      localc.Ubi = paramJSONObject.optInt("user_opertaion_type");
      localc.Ubj = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.Ubk = new e.a.a.f();
        localc.Ubk.Uby = ((JSONObject)localObject).optString("layer_title");
        localc.Ubk.Ubz = ((JSONObject)localObject).optString("layer_logo");
        localc.Ubk.UbA = ((JSONObject)localObject).optString("layer_type");
        localc.Ubk.UbB = ((JSONObject)localObject).optString("layer_name");
        localc.Ubk.UbC = ((JSONObject)localObject).optString("layer_description");
        localc.Ubk.UbD = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!Util.isNullOrNil(((JSONObject)localObject).optString("voice_url"))) {
          localc.Ubk.UbF = new com.tencent.mm.bw.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!Util.isNullOrNil(((JSONObject)localObject).optString("voice_data"))) {
          localc.Ubk.LaX = new com.tencent.mm.bw.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.Ubk.UbE = new e();
          localc.Ubk.UbE.UaZ = ((JSONObject)localObject).optString("btn_words");
          localc.Ubk.UbE.Uba = ((JSONObject)localObject).optString("btn_color");
          localc.Ubk.UbE.Ubb = ((JSONObject)localObject).optInt("btn_op_type");
          localc.Ubk.UbE.LXU = ((JSONObject)localObject).optString("get_lottery_params");
          localc.Ubk.UbE.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.Ubk.UbE.Ubc = new e.a.a.g();
            localc.Ubk.UbE.Ubc.MFd = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.Ubk.UbE.Ubc.MFe = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.Ubk.UbE.Ubc.MFf = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      localObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (localObject != null)
      {
        localc.Ubm = new e.a.a.b();
        localc.Ubm.url = ((JSONObject)localObject).optString("url");
        localc.Ubm.Ubd = ((JSONObject)localObject).optString("animation_wording");
        localc.Ubm.Ube = ((JSONObject)localObject).optString("animation_wording_color");
        localc.Ubm.Ubf = ((JSONObject)localObject).optString("after_animation_wording");
        localc.Ubm.Ubg = ((JSONObject)localObject).optString("after_animation_wording_color");
        localc.Ubm.NkQ = ((JSONObject)localObject).optInt("op_type");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.Ubm.Ubc = new e.a.a.g();
          localc.Ubm.Ubc.MFd = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.Ubm.Ubc.MFe = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.Ubm.Ubc.MFf = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("follow_cardbd_mch_info");
      if (paramJSONObject != null)
      {
        localc.Ubn = new e.a.a.d();
        localc.Ubn.Ubo = paramJSONObject.optInt("is_followed_cardbd_mch", 0);
        localc.Ubn.Ubq = paramJSONObject.optString("follow_logo", "");
        localc.Ubn.Ubp = paramJSONObject.optString("follow_tips", "");
        localc.Ubn.Ubr = paramJSONObject.optString("follow_tips_color", "");
        localc.Ubn.Ubs = paramJSONObject.optLong("follow_tips_size", 0L);
        localc.Ubn.Ubv = paramJSONObject.optString("follow_logo_after", "");
        localc.Ubn.Ubx = paramJSONObject.optString("follow_tips_after", "");
        localc.Ubn.Ubw = paramJSONObject.optString("follow_tips_color_after", "");
        localc.Ubn.LjW = paramJSONObject.optString("follow_param", "");
        localc.Ubn.Ubt = paramJSONObject.optInt("is_show_pop_up", 0);
        paramJSONObject = paramJSONObject.optJSONObject("pop_up_window_info");
        if (paramJSONObject != null)
        {
          localc.Ubn.Ubu = new e.a.a.h();
          localc.Ubn.Ubu.UbG = paramJSONObject.optString("pop_up_title");
          localc.Ubn.Ubu.UbH = paramJSONObject.optString("pop_up_text");
          localc.Ubn.Ubu.UbJ = paramJSONObject.optString("pop_up_button_text");
          localc.Ubn.Ubu.UbI = paramJSONObject.optString("pop_up_image_url");
        }
      }
      paramPromotions.Iah = localc;
      AppMethodBeat.o(70357);
      return;
    }
    catch (Exception paramPromotions)
    {
      Log.printErrStackTrace("MicroMsg.Orders", paramPromotions, "parseExposureInfo error: %s", new Object[] { paramPromotions.getMessage() });
      AppMethodBeat.o(70357);
    }
  }
  
  private static void a(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70358);
    if (paramJSONObject != null)
    {
      Log.i("MicroMsg.Orders", "parseDeductInfo json is not null");
      paramOrders.HZi = new DeductInfo();
      paramOrders.HZi.title = paramJSONObject.optString("contract_title");
      paramOrders.HZi.desc = paramJSONObject.optString("contract_desc");
      paramOrders.HZi.HHv = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.HZi.HZQ = paramJSONObject.optString("contract_url");
      paramOrders.HZi.HZS = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.HZi.HGJ = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.HZi.pTK = paramJSONObject.optString("button_wording", "");
      paramOrders.HZi.HGK = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.HZi.HZT = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.HZi.HZU = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.HZi.HZR = new ArrayList();
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
              localDeductShowInfo.gTx = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.HZV = localJSONObject.optString("link_weapp");
              localDeductShowInfo.HZW = localJSONObject.optString("link_addr");
              localDeductShowInfo.HZX = localJSONObject.optString("link_url");
            }
            paramOrders.HZi.HZR.add(localDeductShowInfo);
          }
          for (;;)
          {
            i += 1;
            break;
            Log.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i)));
          }
        }
        AppMethodBeat.o(70358);
        return;
      }
      Log.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(j)));
      AppMethodBeat.o(70358);
      return;
    }
    Log.i("MicroMsg.Orders", "parseDeductInfo json is null");
    AppMethodBeat.o(70358);
  }
  
  private static HashSet<String> aVg(String paramString)
  {
    AppMethodBeat.i(70361);
    HashSet localHashSet = new HashSet();
    if (!Util.isNullOrNil(paramString))
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
      AppMethodBeat.o(70361);
      return localHashSet;
      label75:
      localHashSet.clear();
    }
  }
  
  private static void b(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70359);
    if (paramJSONObject != null) {
      try
      {
        paramOrders.HZp = paramJSONObject.optInt("is_use_show_info", 0);
        Log.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.HZp) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          Log.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.HZr = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.xEk = localJSONObject.optString("name_color");
              localShowInfo.Iaq = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.Iar = localJSONObject.optInt("link_type");
                localShowInfo.Ias = localJSONObject.optString("link_weapp");
                localShowInfo.Iat = localJSONObject.optString("link_addr");
                localShowInfo.Iau = localJSONObject.optString("link_url");
                localShowInfo.Iav = localJSONObject.optInt("text_attr");
              }
              if ((!Util.isNullOrNil(localShowInfo.name)) || (!Util.isNullOrNil(localShowInfo.value))) {
                paramOrders.HZr.add(localShowInfo);
              }
            }
            i += 1;
          }
        }
        AppMethodBeat.o(70359);
        return;
      }
      catch (Exception paramOrders)
      {
        Log.printErrStackTrace("MicroMsg.Orders", paramOrders, "parseShowInfo error", new Object[0]);
      }
    }
    AppMethodBeat.o(70359);
  }
  
  private static com.tencent.mm.plugin.wallet.a.h bL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70354);
    com.tencent.mm.plugin.wallet.a.h localh = new com.tencent.mm.plugin.wallet.a.h();
    paramJSONObject = paramJSONObject.optJSONObject("favinfo");
    if (paramJSONObject == null)
    {
      Log.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
      AppMethodBeat.o(70354);
      return localh;
    }
    localh.HEq = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localh.HEr = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localh.HEs = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localh.HEt = paramJSONObject.optString("favorComposeId");
    localh.HEw = paramJSONObject.optInt("useNaturalDefense");
    localh.HEx = paramJSONObject.optString("discountWording");
    localh.HEy = paramJSONObject.optString("favorRuleWording");
    localh.HEz = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localh.HEA = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localh.HEB = paramJSONObject.optInt("isVariableFavor");
    localh.HEC = paramJSONObject.optString("invariableFavorDesc");
    localh.HED = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new t();
      ((t)localObject2).HFi = ((JSONObject)localObject3).optInt("favType");
      ((t)localObject2).HFj = ((JSONObject)localObject3).optInt("favSubType");
      ((t)localObject2).HFk = ((JSONObject)localObject3).optLong("favProperty");
      ((t)localObject2).HFl = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((t)localObject2).HEn = ((JSONObject)localObject3).optString("favId");
      ((t)localObject2).HFm = ((JSONObject)localObject3).optString("favName");
      ((t)localObject2).HFn = ((JSONObject)localObject3).optString("favDesc");
      ((t)localObject2).HEo = ((JSONObject)localObject3).optString("favorUseManual");
      ((t)localObject2).HEp = ((JSONObject)localObject3).optString("favorRemarks");
      ((t)localObject2).HFo = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((t)localObject2).HFp = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((t)localObject2).HFq = ((JSONObject)localObject3).optInt("needBankPay");
      ((t)localObject2).HFr = ((JSONObject)localObject3).optString("bankNo");
      ((t)localObject2).AOj = ((JSONObject)localObject3).optString("bankName");
      ((t)localObject2).HFs = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((t)localObject2).HFt.add(com.tencent.mm.bw.b.cD(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localh.HEu.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localh.HEv = new com.tencent.mm.plugin.wallet.a.i();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new j();
        ((j)localObject2).HEJ = ((JSONObject)localObject3).optString("faovrComposeId");
        ((j)localObject2).HEK = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((j)localObject2).HEs = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((j)localObject2).HEz = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).HEA = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).HEB = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((j)localObject2).HEC = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((j)localObject2).HED = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.a.f();
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).HEn = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).HEo = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).HEp = ((JSONObject)localObject4).optString("favorRemarks");
          ((j)localObject2).HEL.add(localObject5);
          j += 1;
        }
        localh.HEv.HEH.add(localObject2);
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
          ((com.tencent.mm.plugin.wallet.a.c)localObject4).ANo = ((JSONObject)localObject5).optString("bind_serial");
          localObject5 = ((JSONObject)localObject5).optJSONArray("bind_serial_favor_list");
          if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              com.tencent.mm.plugin.wallet.a.d locald = new com.tencent.mm.plugin.wallet.a.d();
              JSONObject localJSONObject = ((JSONArray)localObject5).optJSONObject(j);
              locald.Coh = localJSONObject.optString("favor_desc");
              locald.HEl = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.a.c)localObject4).HEk.add(locald);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).HDZ.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.a.a)localObject1).HEa = new n();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new o();
          ((o)localObject3).Coh = ((JSONArray)localObject2).optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).HEa.HEQ.add(localObject3);
          i += 1;
        }
      }
    }
    localh.HEE = ((com.tencent.mm.plugin.wallet.a.a)localObject1);
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
          ((com.tencent.mm.plugin.wallet.a.g)localObject2).HEd = ((JSONObject)localObject3).optString("default_fav_comb_id");
          localObject3 = ((JSONObject)localObject3).optJSONObject("payment_channel");
          if (localObject3 != null)
          {
            localObject4 = new m();
            ((m)localObject4).ANo = ((JSONObject)localObject3).optString("bind_serial");
            ((m)localObject4).selected = ((JSONObject)localObject3).optInt("selected");
            ((m)localObject4).HEP = ((JSONObject)localObject3).optString("bankCode");
            ((com.tencent.mm.plugin.wallet.a.g)localObject2).HEb = ((m)localObject4);
          }
          localh.HEF.add(localObject2);
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
        ((m)localObject2).HEP = ((JSONObject)localObject3).optString("bankCode");
        ((m)localObject2).selected = ((JSONObject)localObject3).optInt("selected");
        ((m)localObject2).ANo = ((JSONObject)localObject3).optString("bind_serial");
        ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEb = ((m)localObject2);
      }
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEc = paramJSONObject.optInt("is_show_guide");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEd = paramJSONObject.optString("default_fav_comb_id");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEe = paramJSONObject.optString("guide_content");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEf = paramJSONObject.optString("guide_content_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEg = paramJSONObject.optString("guide_btn_text");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEh = paramJSONObject.optString("guide_btn_text_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEi = paramJSONObject.optString("guide_btn_bg_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).HEj = paramJSONObject.optString("guide_logo");
      localh.HEG = ((com.tencent.mm.plugin.wallet.a.b)localObject1);
    }
    AppMethodBeat.o(70354);
    return localh;
  }
  
  /* Error */
  public static Orders by(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 1601
    //   3: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: ifnull +900 -> 910
    //   13: new 2	com/tencent/mm/plugin/wallet_core/model/Orders
    //   16: dup
    //   17: invokespecial 1602	com/tencent/mm/plugin/wallet_core/model/Orders:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 1605	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   27: putfield 233	com/tencent/mm/plugin/wallet_core/model/Orders:HYL	J
    //   30: aload 5
    //   32: aload_0
    //   33: ldc_w 488
    //   36: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: ldc_w 1607
    //   42: iconst_2
    //   43: getstatic 1613	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   46: invokestatic 1618	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   49: putfield 162	com/tencent/mm/plugin/wallet_core/model/Orders:dDO	D
    //   52: aload 5
    //   54: aload_0
    //   55: ldc_w 1619
    //   58: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 160	com/tencent/mm/plugin/wallet_core/model/Orders:num	Ljava/lang/String;
    //   64: aload 5
    //   66: aload_0
    //   67: ldc_w 1621
    //   70: iconst_1
    //   71: invokevirtual 331	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: putfield 247	com/tencent/mm/plugin/wallet_core/model/Orders:HQg	I
    //   77: aload 5
    //   79: aload_0
    //   80: ldc_w 510
    //   83: ldc 152
    //   85: invokevirtual 513	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 249	com/tencent/mm/plugin/wallet_core/model/Orders:AOl	Ljava/lang/String;
    //   91: aload 5
    //   93: aload_0
    //   94: ldc_w 1623
    //   97: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: ldc_w 1607
    //   103: iconst_2
    //   104: getstatic 1613	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   107: invokestatic 1618	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   110: putfield 251	com/tencent/mm/plugin/wallet_core/model/Orders:CoZ	D
    //   113: aload 5
    //   115: aload_0
    //   116: ldc_w 1625
    //   119: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: ldc_w 1607
    //   125: iconst_2
    //   126: getstatic 1613	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   129: invokestatic 1618	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   132: putfield 164	com/tencent/mm/plugin/wallet_core/model/Orders:HYM	D
    //   135: aload 5
    //   137: aload_0
    //   138: ldc_w 1627
    //   141: invokevirtual 425	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   144: putfield 253	com/tencent/mm/plugin/wallet_core/model/Orders:HYN	I
    //   147: aload 5
    //   149: aload_0
    //   150: ldc_w 1629
    //   153: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: putfield 255	com/tencent/mm/plugin/wallet_core/model/Orders:HTZ	Ljava/lang/String;
    //   159: aload 5
    //   161: aload_0
    //   162: ldc_w 1631
    //   165: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:HXh	Ljava/lang/String;
    //   171: aload 5
    //   173: aload_0
    //   174: ldc_w 1633
    //   177: invokevirtual 425	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   180: putfield 259	com/tencent/mm/plugin/wallet_core/model/Orders:HYO	I
    //   183: aload 5
    //   185: aload_0
    //   186: ldc_w 1635
    //   189: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: putfield 261	com/tencent/mm/plugin/wallet_core/model/Orders:HYP	Ljava/lang/String;
    //   195: aload_0
    //   196: ldc_w 1637
    //   199: invokevirtual 341	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore 6
    //   204: aload 5
    //   206: aload_0
    //   207: ldc_w 1639
    //   210: invokevirtual 412	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   213: putfield 1641	com/tencent/mm/plugin/wallet_core/model/Orders:HZj	J
    //   216: aload 5
    //   218: aload_0
    //   219: ldc_w 1643
    //   222: invokevirtual 412	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   225: putfield 1645	com/tencent/mm/plugin/wallet_core/model/Orders:HZk	J
    //   228: aload 5
    //   230: aload_0
    //   231: ldc_w 1647
    //   234: iconst_0
    //   235: invokevirtual 331	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   238: putfield 201	com/tencent/mm/plugin/wallet_core/model/Orders:HZl	I
    //   241: aload 5
    //   243: aload_0
    //   244: ldc_w 1649
    //   247: iconst_0
    //   248: invokevirtual 331	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   251: putfield 203	com/tencent/mm/plugin/wallet_core/model/Orders:HZm	I
    //   254: aload_0
    //   255: ldc_w 1651
    //   258: iconst_0
    //   259: invokevirtual 331	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   262: iconst_1
    //   263: if_icmpne +935 -> 1198
    //   266: iconst_1
    //   267: istore_1
    //   268: iload_1
    //   269: ifeq +15 -> 284
    //   272: aload 5
    //   274: new 176	java/util/HashSet
    //   277: dup
    //   278: invokespecial 177	java/util/HashSet:<init>	()V
    //   281: putfield 179	com/tencent/mm/plugin/wallet_core/model/Orders:HYZ	Ljava/util/Set;
    //   284: aload 6
    //   286: invokevirtual 346	org/json/JSONArray:length	()I
    //   289: istore_3
    //   290: iconst_0
    //   291: istore_2
    //   292: iload_2
    //   293: iload_3
    //   294: if_icmpge +280 -> 574
    //   297: aload 6
    //   299: iload_2
    //   300: invokevirtual 350	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   303: astore 7
    //   305: new 8	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity
    //   308: dup
    //   309: invokespecial 1652	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:<init>	()V
    //   312: astore 8
    //   314: aload 8
    //   316: aload 7
    //   318: ldc_w 1653
    //   321: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 1654	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:desc	Ljava/lang/String;
    //   327: aload 8
    //   329: aload 7
    //   331: ldc_w 1656
    //   334: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   337: ldc_w 1607
    //   340: iconst_2
    //   341: getstatic 1613	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   344: invokestatic 1618	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   347: putfield 501	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:qwJ	D
    //   350: aload 8
    //   352: new 1658	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 1659	java/lang/StringBuilder:<init>	()V
    //   359: aload 7
    //   361: ldc_w 1661
    //   364: iconst_1
    //   365: invokevirtual 331	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   368: invokevirtual 1665	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 1668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: putfield 1671	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOc	Ljava/lang/String;
    //   377: aload 8
    //   379: aload 7
    //   381: ldc_w 447
    //   384: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: putfield 450	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOe	Ljava/lang/String;
    //   390: aload 8
    //   392: aload 7
    //   394: ldc_w 457
    //   397: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 460	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOj	Ljava/lang/String;
    //   403: aload 8
    //   405: aload 7
    //   407: ldc_w 452
    //   410: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: putfield 455	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOf	Ljava/lang/String;
    //   416: aload 8
    //   418: aload 7
    //   420: ldc_w 1673
    //   423: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 1676	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ANZ	Ljava/lang/String;
    //   429: aload 8
    //   431: aload 7
    //   433: ldc_w 1678
    //   436: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 1681	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOa	Ljava/lang/String;
    //   442: aload 8
    //   444: aload 7
    //   446: ldc_w 1683
    //   449: invokevirtual 425	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   452: putfield 465	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOh	I
    //   455: aload 8
    //   457: aload 7
    //   459: ldc_w 367
    //   462: invokevirtual 370	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 373	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:dDM	Ljava/lang/String;
    //   468: aload 8
    //   470: aload 7
    //   472: ldc_w 510
    //   475: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: putfield 514	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOl	Ljava/lang/String;
    //   481: aload 5
    //   483: getfield 249	com/tencent/mm/plugin/wallet_core/model/Orders:AOl	Ljava/lang/String;
    //   486: invokestatic 546	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   489: ifeq +13 -> 502
    //   492: aload 5
    //   494: aload 8
    //   496: getfield 514	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:AOl	Ljava/lang/String;
    //   499: putfield 249	com/tencent/mm/plugin/wallet_core/model/Orders:AOl	Ljava/lang/String;
    //   502: aload 8
    //   504: aload 7
    //   506: ldc_w 1685
    //   509: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   512: putfield 1686	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:dCu	Ljava/lang/String;
    //   515: aload 8
    //   517: aload 7
    //   519: ldc_w 325
    //   522: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: putfield 1689	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:ANP	Ljava/lang/String;
    //   528: aload 5
    //   530: getfield 188	com/tencent/mm/plugin/wallet_core/model/Orders:HZd	Ljava/util/List;
    //   533: aload 8
    //   535: invokeinterface 549 2 0
    //   540: pop
    //   541: iload_1
    //   542: ifne +649 -> 1191
    //   545: aload 5
    //   547: aload 7
    //   549: ldc_w 1691
    //   552: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   555: putfield 282	com/tencent/mm/plugin/wallet_core/model/Orders:HYY	Ljava/lang/String;
    //   558: aload 5
    //   560: aload 5
    //   562: getfield 282	com/tencent/mm/plugin/wallet_core/model/Orders:HYY	Ljava/lang/String;
    //   565: invokestatic 286	com/tencent/mm/plugin/wallet_core/model/Orders:aVg	(Ljava/lang/String;)Ljava/util/HashSet;
    //   568: putfield 179	com/tencent/mm/plugin/wallet_core/model/Orders:HYZ	Ljava/util/Set;
    //   571: goto +620 -> 1191
    //   574: aload_0
    //   575: ldc_w 1693
    //   578: invokevirtual 492	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +338 -> 919
    //   584: aload 5
    //   586: aload_0
    //   587: ldc_w 1693
    //   590: invokestatic 1697	com/tencent/mm/wallet_core/ui/f:q	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   593: putfield 166	com/tencent/mm/plugin/wallet_core/model/Orders:HYU	Z
    //   596: aload 5
    //   598: aload_0
    //   599: invokestatic 1699	com/tencent/mm/plugin/wallet_core/model/Orders:bL	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet/a/h;
    //   602: putfield 193	com/tencent/mm/plugin/wallet_core/model/Orders:HZe	Lcom/tencent/mm/plugin/wallet/a/h;
    //   605: aload_0
    //   606: ldc_w 1701
    //   609: invokevirtual 317	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   612: astore 6
    //   614: aload 6
    //   616: ifnonnull +337 -> 953
    //   619: ldc_w 398
    //   622: ldc_w 1703
    //   625: invokestatic 1191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 5
    //   630: aload_0
    //   631: ldc_w 1705
    //   634: invokevirtual 425	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   637: putfield 195	com/tencent/mm/plugin/wallet_core/model/Orders:HZf	I
    //   640: aload 5
    //   642: aload_0
    //   643: ldc_w 1707
    //   646: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   649: putfield 197	com/tencent/mm/plugin/wallet_core/model/Orders:HZg	Ljava/lang/String;
    //   652: aload 5
    //   654: aload_0
    //   655: ldc_w 1709
    //   658: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   661: putfield 199	com/tencent/mm/plugin/wallet_core/model/Orders:HZh	Ljava/lang/String;
    //   664: aload 5
    //   666: aload_0
    //   667: ldc_w 1711
    //   670: invokevirtual 317	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   673: invokestatic 1713	com/tencent/mm/plugin/wallet_core/model/Orders:a	(Lcom/tencent/mm/plugin/wallet_core/model/Orders;Lorg/json/JSONObject;)V
    //   676: aload_0
    //   677: ldc_w 1715
    //   680: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   683: astore 6
    //   685: aload 6
    //   687: invokestatic 546	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   690: ifne +42 -> 732
    //   693: aload 6
    //   695: iconst_0
    //   696: invokestatic 1721	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   699: astore 6
    //   701: new 1723	com/tencent/mm/protocal/protobuf/aoa
    //   704: dup
    //   705: invokespecial 1724	com/tencent/mm/protocal/protobuf/aoa:<init>	()V
    //   708: aload 6
    //   710: invokevirtual 1728	com/tencent/mm/protocal/protobuf/aoa:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   713: checkcast 1723	com/tencent/mm/protocal/protobuf/aoa
    //   716: astore 6
    //   718: aload 5
    //   720: getfield 219	com/tencent/mm/plugin/wallet_core/model/Orders:field_infos	Ljava/util/ArrayList;
    //   723: aload 6
    //   725: getfield 1731	com/tencent/mm/protocal/protobuf/aoa:field_info	Ljava/util/LinkedList;
    //   728: invokevirtual 1734	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   731: pop
    //   732: aload 5
    //   734: aload_0
    //   735: ldc_w 1736
    //   738: ldc 158
    //   740: invokevirtual 513	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 221	com/tencent/mm/plugin/wallet_core/model/Orders:HZu	Ljava/lang/String;
    //   746: aload 5
    //   748: aload_0
    //   749: ldc_w 1738
    //   752: ldc 152
    //   754: invokevirtual 513	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   757: putfield 1740	com/tencent/mm/plugin/wallet_core/model/Orders:HZv	Ljava/lang/String;
    //   760: aload 5
    //   762: aload_0
    //   763: ldc_w 1742
    //   766: ldc 152
    //   768: invokevirtual 513	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   771: putfield 1744	com/tencent/mm/plugin/wallet_core/model/Orders:HZw	Ljava/lang/String;
    //   774: aload 5
    //   776: aload_0
    //   777: ldc_w 1746
    //   780: ldc 158
    //   782: invokevirtual 513	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 223	com/tencent/mm/plugin/wallet_core/model/Orders:HZx	Ljava/lang/String;
    //   788: aload 5
    //   790: aload_0
    //   791: ldc_w 1748
    //   794: ldc 152
    //   796: invokevirtual 513	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   799: putfield 1750	com/tencent/mm/plugin/wallet_core/model/Orders:HZy	Ljava/lang/String;
    //   802: aload 5
    //   804: aload_0
    //   805: ldc_w 1752
    //   808: ldc 152
    //   810: invokevirtual 513	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: putfield 1754	com/tencent/mm/plugin/wallet_core/model/Orders:HZz	Ljava/lang/String;
    //   816: aload 5
    //   818: aload_0
    //   819: ldc_w 1756
    //   822: iconst_0
    //   823: invokevirtual 331	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   826: putfield 1758	com/tencent/mm/plugin/wallet_core/model/Orders:HZA	I
    //   829: aload_0
    //   830: ldc_w 1701
    //   833: invokevirtual 317	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   836: astore_0
    //   837: aload_0
    //   838: ifnull +72 -> 910
    //   841: aload_0
    //   842: ldc_w 1760
    //   845: invokevirtual 317	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   848: astore_0
    //   849: aload_0
    //   850: ifnull +60 -> 910
    //   853: aload 5
    //   855: new 40	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo
    //   858: dup
    //   859: invokespecial 1761	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:<init>	()V
    //   862: putfield 301	com/tencent/mm/plugin/wallet_core/model/Orders:HZB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   865: aload 5
    //   867: getfield 301	com/tencent/mm/plugin/wallet_core/model/Orders:HZB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   870: aload_0
    //   871: ldc_w 1763
    //   874: invokevirtual 425	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   877: putfield 1766	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:Iaw	I
    //   880: aload 5
    //   882: getfield 301	com/tencent/mm/plugin/wallet_core/model/Orders:HZB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   885: aload_0
    //   886: ldc_w 1768
    //   889: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   892: putfield 1771	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:dDj	Ljava/lang/String;
    //   895: aload 5
    //   897: getfield 301	com/tencent/mm/plugin/wallet_core/model/Orders:HZB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   900: aload_0
    //   901: ldc_w 1476
    //   904: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   907: putfield 1772	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:ANo	Ljava/lang/String;
    //   910: ldc_w 1601
    //   913: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: aload 5
    //   918: areturn
    //   919: aload 5
    //   921: aload 5
    //   923: getfield 247	com/tencent/mm/plugin/wallet_core/model/Orders:HQg	I
    //   926: iconst_2
    //   927: invokestatic 1778	com/tencent/mm/plugin/wallet_core/model/Bankcard:jT	(II)Z
    //   930: putfield 166	com/tencent/mm/plugin/wallet_core/model/Orders:HYU	Z
    //   933: goto -337 -> 596
    //   936: astore_0
    //   937: ldc_w 398
    //   940: aload_0
    //   941: ldc 152
    //   943: iconst_0
    //   944: anewarray 4	java/lang/Object
    //   947: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   950: goto -40 -> 910
    //   953: aload 6
    //   955: ldc_w 1780
    //   958: invokevirtual 317	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   961: astore 6
    //   963: aload 6
    //   965: ifnonnull +15 -> 980
    //   968: ldc_w 398
    //   971: ldc_w 1782
    //   974: invokestatic 1191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -349 -> 628
    //   980: aload 6
    //   982: ldc_w 1784
    //   985: invokevirtual 317	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   988: astore 6
    //   990: aload 6
    //   992: ifnonnull +15 -> 1007
    //   995: ldc_w 398
    //   998: ldc_w 1786
    //   1001: invokestatic 1191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: goto -376 -> 628
    //   1007: ldc_w 1788
    //   1010: invokestatic 1794	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1013: checkcast 1788	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1016: invokeinterface 1797 1 0
    //   1021: ifne +182 -> 1203
    //   1024: ldc_w 1788
    //   1027: invokestatic 1794	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1030: checkcast 1788	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1033: invokeinterface 1800 1 0
    //   1038: ifeq +170 -> 1208
    //   1041: goto +162 -> 1203
    //   1044: iload_1
    //   1045: ifeq +168 -> 1213
    //   1048: aload 6
    //   1050: ldc_w 1802
    //   1053: iconst_0
    //   1054: invokevirtual 331	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1057: istore_1
    //   1058: aload 5
    //   1060: iload_1
    //   1061: putfield 181	com/tencent/mm/plugin/wallet_core/model/Orders:HZa	I
    //   1064: aload 5
    //   1066: aload 6
    //   1068: ldc_w 1804
    //   1071: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: putfield 183	com/tencent/mm/plugin/wallet_core/model/Orders:HZc	Ljava/lang/String;
    //   1077: aload 6
    //   1079: ldc_w 1806
    //   1082: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1085: astore 7
    //   1087: iconst_1
    //   1088: aload 6
    //   1090: ldc_w 1808
    //   1093: invokevirtual 425	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1096: if_icmpne +122 -> 1218
    //   1099: iconst_1
    //   1100: istore 4
    //   1102: aload 5
    //   1104: aload 7
    //   1106: putfield 303	com/tencent/mm/plugin/wallet_core/model/Orders:wFE	Ljava/lang/String;
    //   1109: aload 5
    //   1111: iload 4
    //   1113: putfield 305	com/tencent/mm/plugin/wallet_core/model/Orders:HZb	Z
    //   1116: getstatic 1814	com/tencent/mm/plugin/fingerprint/b/p:wFK	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1119: aload 7
    //   1121: putfield 1815	com/tencent/mm/plugin/fingerprint/b/p:wFE	Ljava/lang/String;
    //   1124: getstatic 1814	com/tencent/mm/plugin/fingerprint/b/p:wFK	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1127: iload 4
    //   1129: putfield 1818	com/tencent/mm/plugin/fingerprint/b/p:wFM	Z
    //   1132: ldc_w 398
    //   1135: ldc_w 1820
    //   1138: iconst_3
    //   1139: anewarray 4	java/lang/Object
    //   1142: dup
    //   1143: iconst_0
    //   1144: aload 5
    //   1146: getfield 181	com/tencent/mm/plugin/wallet_core/model/Orders:HZa	I
    //   1149: invokestatic 1223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_1
    //   1155: aload 7
    //   1157: aastore
    //   1158: dup
    //   1159: iconst_2
    //   1160: iload 4
    //   1162: invokestatic 1825	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1165: aastore
    //   1166: invokestatic 754	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1169: goto -541 -> 628
    //   1172: astore 6
    //   1174: ldc_w 398
    //   1177: aload 6
    //   1179: ldc 152
    //   1181: iconst_0
    //   1182: anewarray 4	java/lang/Object
    //   1185: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1188: goto -456 -> 732
    //   1191: iload_2
    //   1192: iconst_1
    //   1193: iadd
    //   1194: istore_2
    //   1195: goto -903 -> 292
    //   1198: iconst_0
    //   1199: istore_1
    //   1200: goto -932 -> 268
    //   1203: iconst_1
    //   1204: istore_1
    //   1205: goto -161 -> 1044
    //   1208: iconst_0
    //   1209: istore_1
    //   1210: goto -166 -> 1044
    //   1213: iconst_0
    //   1214: istore_1
    //   1215: goto -157 -> 1058
    //   1218: iconst_0
    //   1219: istore 4
    //   1221: goto -119 -> 1102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1224	0	paramJSONObject	JSONObject
    //   267	948	1	i	int
    //   291	904	2	j	int
    //   289	6	3	k	int
    //   1100	120	4	bool	boolean
    //   7	1138	5	localOrders	Orders
    //   202	887	6	localObject1	Object
    //   1172	6	6	localIOException	java.io.IOException
    //   303	853	7	localObject2	Object
    //   312	222	8	localCommodity	Commodity
    // Exception table:
    //   from	to	target	type
    //   22	266	936	org/json/JSONException
    //   272	284	936	org/json/JSONException
    //   284	290	936	org/json/JSONException
    //   297	502	936	org/json/JSONException
    //   502	541	936	org/json/JSONException
    //   545	571	936	org/json/JSONException
    //   574	596	936	org/json/JSONException
    //   596	614	936	org/json/JSONException
    //   619	628	936	org/json/JSONException
    //   628	701	936	org/json/JSONException
    //   701	732	936	org/json/JSONException
    //   732	837	936	org/json/JSONException
    //   841	849	936	org/json/JSONException
    //   853	910	936	org/json/JSONException
    //   919	933	936	org/json/JSONException
    //   953	963	936	org/json/JSONException
    //   968	977	936	org/json/JSONException
    //   980	990	936	org/json/JSONException
    //   995	1004	936	org/json/JSONException
    //   1007	1041	936	org/json/JSONException
    //   1048	1058	936	org/json/JSONException
    //   1058	1099	936	org/json/JSONException
    //   1102	1169	936	org/json/JSONException
    //   1174	1188	936	org/json/JSONException
    //   701	732	1172	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70360);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reqKey:").append(this.dDL).append("\n");
    ((StringBuilder)localObject).append("token").append(this.token).append("\n");
    ((StringBuilder)localObject).append("num").append(this.num).append("\n");
    ((StringBuilder)localObject).append("totalFee").append(this.dDO).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(70360);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70363);
    paramParcel.writeLong(this.HYL);
    paramParcel.writeString(this.dDL);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.num);
    paramParcel.writeDouble(this.dDO);
    paramParcel.writeInt(this.HQg);
    paramParcel.writeString(this.AOl);
    paramParcel.writeDouble(this.CoZ);
    paramParcel.writeDouble(this.HYM);
    paramParcel.writeInt(this.HYN);
    paramParcel.writeString(this.HTZ);
    paramParcel.writeString(this.HXh);
    paramParcel.writeInt(this.HYO);
    paramParcel.writeString(this.HYP);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.AAU);
    paramParcel.writeString(this.HYQ);
    paramParcel.writeString(this.HYR);
    paramParcel.writeString(this.HYS);
    paramParcel.writeInt(this.HYT);
    if (this.HYU)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.HYV);
      paramParcel.writeString(this.rCq);
      paramParcel.writeLong(this.HYW);
      paramParcel.writeString(this.HYX);
      paramParcel.writeTypedList(this.HZd);
      paramParcel.writeString(this.HYY);
      paramParcel.writeInt(this.HZa);
      paramParcel.writeString(this.HZc);
      paramParcel.writeParcelable(this.HZi, 1);
      paramParcel.writeInt(this.HZl);
      paramParcel.writeInt(this.HZm);
      paramParcel.writeInt(this.HZq);
      paramParcel.writeString(this.HZt);
      paramParcel.writeString(this.HZs);
      paramParcel.writeInt(this.HZp);
      paramParcel.writeTypedList(this.HZr);
      paramParcel.writeParcelable(this.HZB, 1);
      paramParcel.writeString(this.wFE);
      if (!this.HZb) {
        break label362;
      }
    }
    label362:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(70363);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static class Commodity
    implements Parcelable
  {
    public static final Parcelable.Creator<Commodity> CREATOR;
    public String ANP;
    public String ANX;
    public String ANY;
    public String ANZ;
    public String AOa;
    public String AOc;
    public String AOe;
    public String AOf;
    public int AOh;
    public String AOj;
    public String AOl;
    public String AOp;
    public int HYT;
    public double HZE;
    public String HZF;
    public String HZG;
    public List<Orders.DiscountInfo> HZH;
    public String HZI;
    public String HZJ;
    public String HZK;
    public Orders.RecommendTinyAppInfo HZL;
    public Orders.RemarksInfo HZM;
    public List<Orders.Promotions> HZN;
    public boolean HZO;
    public Orders.a HZP;
    public String dCu;
    public String dDM;
    public String desc;
    public double qwJ;
    
    static
    {
      AppMethodBeat.i(70317);
      CREATOR = new Orders.Commodity.1();
      AppMethodBeat.o(70317);
    }
    
    public Commodity()
    {
      AppMethodBeat.i(70314);
      this.qwJ = 0.0D;
      this.HZE = 0.0D;
      this.HZH = new ArrayList();
      this.HZL = null;
      this.HZN = new ArrayList();
      this.HZO = false;
      this.HZP = new Orders.a();
      AppMethodBeat.o(70314);
    }
    
    public Commodity(Parcel paramParcel)
    {
      AppMethodBeat.i(70315);
      this.qwJ = 0.0D;
      this.HZE = 0.0D;
      this.HZH = new ArrayList();
      this.HZL = null;
      this.HZN = new ArrayList();
      this.HZO = false;
      this.HZP = new Orders.a();
      this.ANX = paramParcel.readString();
      this.ANY = paramParcel.readString();
      this.ANZ = paramParcel.readString();
      this.AOa = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.AOc = paramParcel.readString();
      this.qwJ = paramParcel.readDouble();
      this.AOe = paramParcel.readString();
      this.AOf = paramParcel.readString();
      this.AOh = paramParcel.readInt();
      this.dDM = paramParcel.readString();
      this.AOj = paramParcel.readString();
      this.AOl = paramParcel.readString();
      this.dCu = paramParcel.readString();
      this.ANP = paramParcel.readString();
      this.HZG = paramParcel.readString();
      this.AOp = paramParcel.readString();
      paramParcel.readTypedList(this.HZH, Orders.DiscountInfo.CREATOR);
      this.HZI = paramParcel.readString();
      this.HZK = paramParcel.readString();
      this.HZL = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
      paramParcel.readTypedList(this.HZN, Orders.Promotions.CREATOR);
      this.HZM = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.HZO = bool;
        AppMethodBeat.o(70315);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b = 0;
      AppMethodBeat.i(70316);
      paramParcel.writeString(this.ANX);
      paramParcel.writeString(this.ANY);
      paramParcel.writeString(this.ANZ);
      paramParcel.writeString(this.AOa);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.AOc);
      paramParcel.writeDouble(this.qwJ);
      paramParcel.writeString(this.AOe);
      paramParcel.writeString(this.AOf);
      paramParcel.writeInt(this.AOh);
      paramParcel.writeString(this.dDM);
      paramParcel.writeString(this.AOj);
      paramParcel.writeString(this.AOl);
      paramParcel.writeString(this.dCu);
      paramParcel.writeString(this.ANP);
      paramParcel.writeString(this.HZG);
      paramParcel.writeString(this.AOp);
      paramParcel.writeTypedList(this.HZH);
      paramParcel.writeString(this.HZI);
      paramParcel.writeString(this.HZK);
      paramParcel.writeParcelable(this.HZL, 0);
      paramParcel.writeTypedList(this.HZN);
      paramParcel.writeParcelable(this.HZM, 0);
      if (this.HZO) {
        b = 1;
      }
      paramParcel.writeByte(b);
      AppMethodBeat.o(70316);
    }
  }
  
  public static class DeductInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DeductInfo> CREATOR;
    public int HGJ;
    public String HGK;
    public int HHv;
    public String HZQ;
    public List<Orders.DeductShowInfo> HZR;
    public int HZS;
    public String HZT;
    public String HZU;
    public String desc;
    public String pTK;
    public String title;
    
    static
    {
      AppMethodBeat.i(70322);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70322);
    }
    
    public DeductInfo()
    {
      AppMethodBeat.i(70319);
      this.HZR = new ArrayList();
      AppMethodBeat.o(70319);
    }
    
    public DeductInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70320);
      this.HZR = new ArrayList();
      this.title = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.HHv = paramParcel.readInt();
      this.HZQ = paramParcel.readString();
      this.HZS = paramParcel.readInt();
      paramParcel.readTypedList(this.HZR, Orders.DeductShowInfo.CREATOR);
      this.HGJ = paramParcel.readInt();
      this.pTK = paramParcel.readString();
      this.HGK = paramParcel.readString();
      this.HZT = paramParcel.readString();
      this.HZU = paramParcel.readString();
      AppMethodBeat.o(70320);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70321);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.desc);
      paramParcel.writeInt(this.HHv);
      paramParcel.writeString(this.HZQ);
      paramParcel.writeInt(this.HZS);
      paramParcel.writeTypedList(this.HZR);
      paramParcel.writeInt(this.HGJ);
      paramParcel.writeString(this.pTK);
      paramParcel.writeString(this.HGK);
      paramParcel.writeString(this.HZT);
      paramParcel.writeString(this.HZU);
      AppMethodBeat.o(70321);
    }
  }
  
  public static class DiscountInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DiscountInfo> CREATOR;
    public String Coh;
    public double HZY;
    
    static
    {
      AppMethodBeat.i(70330);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70330);
    }
    
    public DiscountInfo() {}
    
    public DiscountInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70328);
      this.HZY = paramParcel.readDouble();
      this.Coh = paramParcel.readString();
      AppMethodBeat.o(70328);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70329);
      paramParcel.writeDouble(this.HZY);
      paramParcel.writeString(this.Coh);
      AppMethodBeat.o(70329);
    }
  }
  
  public static class Promotions
    implements Parcelable
  {
    public static final Parcelable.Creator<Promotions> CREATOR;
    public String Bah;
    public int HYC;
    public int HYD;
    public long HYE;
    public String HYF;
    public e.a.a.c Iah;
    public int UtA;
    public String UtB;
    public String UtC;
    public int Utv;
    public int Utw;
    public String Utx;
    public String Uty;
    public String Utz;
    public long crw;
    public String dCu;
    public String name;
    public String title;
    public int trD;
    public int type;
    public String url;
    
    static
    {
      AppMethodBeat.i(70334);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70334);
    }
    
    public Promotions() {}
    
    public Promotions(Parcel paramParcel)
    {
      AppMethodBeat.i(70332);
      this.type = paramParcel.readInt();
      this.Bah = paramParcel.readString();
      this.name = paramParcel.readString();
      this.HYF = paramParcel.readString();
      this.url = paramParcel.readString();
      this.dCu = paramParcel.readString();
      this.title = paramParcel.readString();
      this.trD = paramParcel.readInt();
      this.crw = paramParcel.readLong();
      this.Utv = paramParcel.readInt();
      this.Utw = paramParcel.readInt();
      this.HYC = paramParcel.readInt();
      this.HYD = paramParcel.readInt();
      this.Utx = paramParcel.readString();
      this.Uty = paramParcel.readString();
      this.Utz = paramParcel.readString();
      this.HYE = paramParcel.readLong();
      this.UtA = paramParcel.readInt();
      AppMethodBeat.o(70332);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70333);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.Bah);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.HYF);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.dCu);
      paramParcel.writeString(this.title);
      paramParcel.writeInt(this.trD);
      paramParcel.writeLong(this.crw);
      paramParcel.writeInt(this.Utv);
      paramParcel.writeInt(this.Utw);
      paramParcel.writeInt(this.HYC);
      paramParcel.writeInt(this.HYD);
      paramParcel.writeString(this.Utx);
      paramParcel.writeString(this.Uty);
      paramParcel.writeString(this.Utz);
      paramParcel.writeLong(this.HYE);
      paramParcel.writeInt(this.UtA);
      AppMethodBeat.o(70333);
    }
  }
  
  public static class RecommendTinyAppInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR;
    public String HLz;
    public String HYH;
    public String HYI;
    public String HYJ;
    public int HYK;
    public String Hwr;
    public String Hws;
    public long Iai;
    public long Iaj;
    public long Iak;
    public int Ial;
    public int Iam;
    public long Ian;
    
    static
    {
      AppMethodBeat.i(70338);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70338);
    }
    
    public RecommendTinyAppInfo() {}
    
    public RecommendTinyAppInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70336);
      this.HLz = paramParcel.readString();
      this.HYH = paramParcel.readString();
      this.HYI = paramParcel.readString();
      this.Hwr = paramParcel.readString();
      this.Hws = paramParcel.readString();
      this.HYK = paramParcel.readInt();
      AppMethodBeat.o(70336);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70337);
      paramParcel.writeString(this.HLz);
      paramParcel.writeString(this.HYH);
      paramParcel.writeString(this.HYI);
      paramParcel.writeString(this.Hwr);
      paramParcel.writeString(this.Hws);
      paramParcel.writeInt(this.HYK);
      AppMethodBeat.o(70337);
    }
  }
  
  public static class RemarksInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RemarksInfo> CREATOR;
    public String Iao;
    public String Iap;
    
    static
    {
      AppMethodBeat.i(70342);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70342);
    }
    
    public RemarksInfo() {}
    
    protected RemarksInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70340);
      this.Iao = paramParcel.readString();
      this.Iap = paramParcel.readString();
      AppMethodBeat.o(70340);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70341);
      paramParcel.writeString(this.Iao);
      paramParcel.writeString(this.Iap);
      AppMethodBeat.o(70341);
    }
  }
  
  public static class SimpleCashierInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleCashierInfo> CREATOR;
    public String ANo;
    public int Iaw;
    public String dDj;
    
    static
    {
      AppMethodBeat.i(70351);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70351);
    }
    
    public SimpleCashierInfo() {}
    
    protected SimpleCashierInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70349);
      this.Iaw = paramParcel.readInt();
      this.dDj = paramParcel.readString();
      this.ANo = paramParcel.readString();
      AppMethodBeat.o(70349);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70350);
      paramParcel.writeInt(this.Iaw);
      paramParcel.writeString(this.dDj);
      paramParcel.writeString(this.ANo);
      AppMethodBeat.o(70350);
    }
  }
  
  public static final class a
  {
    public String text = "";
    public String url = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders
 * JD-Core Version:    0.7.0.1
 */