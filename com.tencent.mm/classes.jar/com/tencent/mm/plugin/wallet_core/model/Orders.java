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
import com.tencent.mm.protocal.protobuf.eqh;
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
  public static int ORC;
  public static int ORD;
  public String ByB;
  public String GHz;
  public String GtW;
  public double Imo;
  public int OIp;
  public String OMa;
  public String OPh;
  public long OQL;
  public double OQM;
  public int OQN;
  public int OQO;
  public String OQP;
  public String OQQ;
  public String OQR;
  public String OQS;
  public int OQT;
  public boolean OQU;
  public String OQV;
  public long OQW;
  public String OQX;
  public String OQY;
  public Set<String> OQZ;
  public int ORA;
  public SimpleCashierInfo ORB;
  public int ORa;
  public boolean ORb;
  public String ORc;
  public List<Commodity> ORd;
  public com.tencent.mm.plugin.wallet.a.h ORe;
  public int ORf;
  public String ORg;
  public String ORh;
  public DeductInfo ORi;
  public long ORj;
  public long ORk;
  public int ORl;
  public int ORm;
  public int ORn;
  public String ORo;
  public int ORp;
  public int ORq;
  public ArrayList<ShowInfo> ORr;
  public String ORs;
  public String ORt;
  public String ORu;
  public String ORv;
  public String ORw;
  public String ORx;
  public String ORy;
  public String ORz;
  public ArrayList<eqh> field_infos;
  public String fwv;
  public double fwy;
  public String nickname;
  public String num;
  public String token;
  public String username;
  public String vhY;
  
  static
  {
    AppMethodBeat.i(70364);
    CREATOR = new Parcelable.Creator() {};
    ORC = 0;
    ORD = 1;
    AppMethodBeat.o(70364);
  }
  
  public Orders()
  {
    AppMethodBeat.i(70352);
    this.fwv = "";
    this.token = "";
    this.num = "0";
    this.fwy = 0.0D;
    this.OQM = 0.0D;
    this.OQU = false;
    this.OQV = "";
    this.vhY = "";
    this.OQW = 0L;
    this.OQX = "";
    this.OQZ = new HashSet();
    this.ORa = 0;
    this.ORc = "";
    this.ORd = new ArrayList();
    this.ORe = new com.tencent.mm.plugin.wallet.a.h();
    this.ORf = 0;
    this.ORg = "";
    this.ORh = "";
    this.ORl = 0;
    this.ORm = 0;
    this.ORn = 0;
    this.ORo = "";
    this.ORp = 0;
    this.ORq = 0;
    this.ORr = new ArrayList();
    this.ORs = "";
    this.ORt = "";
    this.field_infos = new ArrayList();
    this.ORu = "";
    this.ORx = "";
    AppMethodBeat.o(70352);
  }
  
  public Orders(Parcel paramParcel)
  {
    AppMethodBeat.i(70362);
    this.fwv = "";
    this.token = "";
    this.num = "0";
    this.fwy = 0.0D;
    this.OQM = 0.0D;
    this.OQU = false;
    this.OQV = "";
    this.vhY = "";
    this.OQW = 0L;
    this.OQX = "";
    this.OQZ = new HashSet();
    this.ORa = 0;
    this.ORc = "";
    this.ORd = new ArrayList();
    this.ORe = new com.tencent.mm.plugin.wallet.a.h();
    this.ORf = 0;
    this.ORg = "";
    this.ORh = "";
    this.ORl = 0;
    this.ORm = 0;
    this.ORn = 0;
    this.ORo = "";
    this.ORp = 0;
    this.ORq = 0;
    this.ORr = new ArrayList();
    this.ORs = "";
    this.ORt = "";
    this.field_infos = new ArrayList();
    this.ORu = "";
    this.ORx = "";
    this.OQL = paramParcel.readLong();
    this.fwv = paramParcel.readString();
    this.token = paramParcel.readString();
    this.num = paramParcel.readString();
    this.fwy = paramParcel.readDouble();
    this.OIp = paramParcel.readInt();
    this.GHz = paramParcel.readString();
    this.Imo = paramParcel.readDouble();
    this.OQM = paramParcel.readDouble();
    this.OQN = paramParcel.readInt();
    this.OMa = paramParcel.readString();
    this.OPh = paramParcel.readString();
    this.OQO = paramParcel.readInt();
    this.OQP = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.GtW = paramParcel.readString();
    this.OQQ = paramParcel.readString();
    this.OQR = paramParcel.readString();
    this.OQS = paramParcel.readString();
    this.OQT = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.OQU = bool1;
      this.OQV = paramParcel.readString();
      this.vhY = paramParcel.readString();
      this.OQW = paramParcel.readLong();
      this.OQX = paramParcel.readString();
      paramParcel.readTypedList(this.ORd, Commodity.CREATOR);
      this.OQY = paramParcel.readString();
      this.OQZ = bgP(this.OQY);
      this.ORa = paramParcel.readInt();
      this.ORc = paramParcel.readString();
      this.ORi = ((DeductInfo)paramParcel.readParcelable(DeductInfo.class.getClassLoader()));
      this.ORl = paramParcel.readInt();
      this.ORm = paramParcel.readInt();
      this.ORq = paramParcel.readInt();
      this.ORt = paramParcel.readString();
      this.ORs = paramParcel.readString();
      this.ORp = paramParcel.readInt();
      paramParcel.readTypedList(this.ORr, ShowInfo.CREATOR);
      this.ORB = ((SimpleCashierInfo)paramParcel.readParcelable(SimpleCashierInfo.class.getClassLoader()));
      this.ByB = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label591;
      }
    }
    label591:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ORb = bool1;
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
          paramOrders.OQR = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.OQS = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.OQT = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.vhY = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.OQT;
        localObject1 = paramOrders.ORd;
        paramOrders.OQV = paramJSONObject.optString("pay_result_tips");
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
            ((Commodity)localObject2).ORO = new ArrayList();
            ((Commodity)localObject2).ORH = new ArrayList();
            ((Commodity)localObject2).fww = localJSONObject.getString("transaction_id");
            a((Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Commodity localCommodity = (Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.fww))) {
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
          paramOrders.OQW = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
          paramOrders.OQX = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
        }
        paramOrders.ORn = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
        paramOrders.ORo = paramJSONObject.optString("pay_succ_btn_wording");
        paramOrders.ORq = paramJSONObject.optInt("is_jsapi_close_page");
        paramOrders.ORs = paramJSONObject.optString("jsapi_tinyapp_username");
        paramOrders.ORt = paramJSONObject.optString("jsapi_tinyapp_path");
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
    paramCommodity.GHD = paramJSONObject.optString("discount");
    paramCommodity.GHs = paramJSONObject.getString("pay_status");
    paramCommodity.GHt = paramJSONObject.getString("pay_status_name");
    paramCommodity.GHx = paramJSONObject.optString("buy_bank_name");
    paramCommodity.GHv = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.ORG = paramJSONObject.optString("card_tail");
    paramCommodity.OQT = paramInt;
    paramCommodity.ORI = paramJSONObject.optString("rateinfo");
    paramCommodity.ORJ = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.ORK = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.tVK = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.ORE = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.GHz = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Promotions();
      ((Promotions)localObject2).type = ORC;
      ((Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Promotions)localObject2).fvb = ((JSONObject)localObject1).optString("username");
      paramCommodity.ORF = ((Promotions)localObject2).fvb;
      ((Promotions)localObject2).GUf = ((JSONObject)localObject1).optString("logo_round_url");
      ((Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!Util.isNullOrNil(((Promotions)localObject2).name)) && (!Util.isNullOrNil(((Promotions)localObject2).url)))
      {
        paramCommodity.ORO.add(localObject2);
        paramCommodity.ORP = true;
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
      ((Promotions)localObject3).type = ORD;
      ((Promotions)localObject3).GUf = ((JSONObject)localObject2).optString("icon");
      ((Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Promotions)localObject3).OQF = ((JSONObject)localObject2).optString("btn_text");
      ((Promotions)localObject3).wYj = ((JSONObject)localObject2).optInt("type");
      ((Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Promotions)localObject3).cpu = ((JSONObject)localObject2).optLong("activity_id");
      ((Promotions)localObject3).SuA = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Promotions)localObject3).SuC = ((JSONObject)localObject2).optString("small_title");
      ((Promotions)localObject3).SuB = ((JSONObject)localObject2).optInt("award_id");
      ((Promotions)localObject3).OQC = ((JSONObject)localObject2).optInt("send_record_id");
      ((Promotions)localObject3).OQD = ((JSONObject)localObject2).optInt("user_record_id");
      ((Promotions)localObject3).SuD = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Promotions)localObject3).SuE = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Promotions)localObject3).OQE = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Promotions)localObject3).SuF = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Promotions)localObject3).SuG = ((JSONObject)localObject2).optString("get_award_params");
      ((Promotions)localObject3).SuI = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.ORO.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.ORQ.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.ORQ.url = ((JSONObject)localObject1).optString("url");
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
          ((DiscountInfo)localObject3).ORZ = ((JSONObject)localObject2).optDouble("payment_amount");
          ((DiscountInfo)localObject3).Ila = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.ORH.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.ORL == null) {
        paramCommodity.ORL = new RecommendTinyAppInfo();
      }
      paramCommodity.ORL.ODu = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.ORL.OQH = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.ORL.OQI = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.ORL.Ooe = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.ORL.Oof = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.ORL.OQJ = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.ORL.OSt = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.ORL.OSu = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.ORL.OSv = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.ORL.OSw = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.ORL.OSx = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.ORL.OSy = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.ORL.OQK = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.ORN == null) {
        paramCommodity.ORN = new RemarksInfo();
      }
      paramCommodity.ORN.OSz = paramJSONObject.optString("remark_title");
      paramCommodity.ORN.OSA = paramJSONObject.optString("remark_desc");
    }
    AppMethodBeat.o(70356);
  }
  
  public static void a(Promotions paramPromotions, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70357);
    Log.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.OSs = null;
      AppMethodBeat.o(70357);
      return;
    }
    try
    {
      e.a.a.c localc = new e.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.SvK = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          e.a.a.i locali = new e.a.a.i();
          locali.GUf = localJSONObject.optString("logo");
          locali.abEZ = localJSONObject.optString("award_name");
          locali.abFa = localJSONObject.optString("award_description");
          locali.abFb = localJSONObject.optString("background_img");
          locali.abFd = localJSONObject.optString("award_description_color");
          locali.abFc = localJSONObject.optString("award_name_color");
          localc.SvK.add(locali);
          i += 1;
        }
      }
      localc.abEw = paramJSONObject.optInt("is_query_others", 0);
      localc.Std = paramJSONObject.optString("draw_lottery_params");
      localc.SvL = paramJSONObject.optInt("is_show_btn");
      localc.abEA = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.SvM = new e.a.a.a();
        localc.SvM.abEo = ((JSONObject)localObject).optString("btn_words");
        localc.SvM.abEp = ((JSONObject)localObject).optString("btn_color");
        localc.SvM.abEq = ((JSONObject)localObject).optInt("btn_op_type");
        localc.SvM.url = ((JSONObject)localObject).optString("url");
        localc.SvM.Thl = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.SvM.abEr = new e.a.a.g();
          localc.SvM.abEr.TQP = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.SvM.abEr.TQQ = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.SvM.abEr.TQR = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.SvJ = paramJSONObject.optString("exposure_info_modify_params");
      localc.abEx = paramJSONObject.optInt("user_opertaion_type");
      localc.abEy = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.abEz = new e.a.a.f();
        localc.abEz.abEN = ((JSONObject)localObject).optString("layer_title");
        localc.abEz.abEO = ((JSONObject)localObject).optString("layer_logo");
        localc.abEz.abEP = ((JSONObject)localObject).optString("layer_type");
        localc.abEz.abEQ = ((JSONObject)localObject).optString("layer_name");
        localc.abEz.abER = ((JSONObject)localObject).optString("layer_description");
        localc.abEz.abES = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!Util.isNullOrNil(((JSONObject)localObject).optString("voice_url"))) {
          localc.abEz.abEU = new com.tencent.mm.cd.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!Util.isNullOrNil(((JSONObject)localObject).optString("voice_data"))) {
          localc.abEz.Scj = new com.tencent.mm.cd.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.abEz.abET = new e();
          localc.abEz.abET.abEo = ((JSONObject)localObject).optString("btn_words");
          localc.abEz.abET.abEp = ((JSONObject)localObject).optString("btn_color");
          localc.abEz.abET.abEq = ((JSONObject)localObject).optInt("btn_op_type");
          localc.abEz.abET.Thl = ((JSONObject)localObject).optString("get_lottery_params");
          localc.abEz.abET.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.abEz.abET.abEr = new e.a.a.g();
            localc.abEz.abET.abEr.TQP = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.abEz.abET.abEr.TQQ = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.abEz.abET.abEr.TQR = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      localObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (localObject != null)
      {
        localc.abEB = new e.a.a.b();
        localc.abEB.url = ((JSONObject)localObject).optString("url");
        localc.abEB.abEs = ((JSONObject)localObject).optString("animation_wording");
        localc.abEB.abEt = ((JSONObject)localObject).optString("animation_wording_color");
        localc.abEB.abEu = ((JSONObject)localObject).optString("after_animation_wording");
        localc.abEB.abEv = ((JSONObject)localObject).optString("after_animation_wording_color");
        localc.abEB.SLl = ((JSONObject)localObject).optInt("op_type");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.abEB.abEr = new e.a.a.g();
          localc.abEB.abEr.TQP = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.abEB.abEr.TQQ = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.abEB.abEr.TQR = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("follow_cardbd_mch_info");
      if (paramJSONObject != null)
      {
        localc.abEC = new e.a.a.d();
        localc.abEC.abED = paramJSONObject.optInt("is_followed_cardbd_mch", 0);
        localc.abEC.abEF = paramJSONObject.optString("follow_logo", "");
        localc.abEC.abEE = paramJSONObject.optString("follow_tips", "");
        localc.abEC.abEG = paramJSONObject.optString("follow_tips_color", "");
        localc.abEC.abEH = paramJSONObject.optLong("follow_tips_size", 0L);
        localc.abEC.abEK = paramJSONObject.optString("follow_logo_after", "");
        localc.abEC.abEM = paramJSONObject.optString("follow_tips_after", "");
        localc.abEC.abEL = paramJSONObject.optString("follow_tips_color_after", "");
        localc.abEC.Sld = paramJSONObject.optString("follow_param", "");
        localc.abEC.abEI = paramJSONObject.optInt("is_show_pop_up", 0);
        paramJSONObject = paramJSONObject.optJSONObject("pop_up_window_info");
        if (paramJSONObject != null)
        {
          localc.abEC.abEJ = new e.a.a.h();
          localc.abEC.abEJ.abEV = paramJSONObject.optString("pop_up_title");
          localc.abEC.abEJ.abEW = paramJSONObject.optString("pop_up_text");
          localc.abEC.abEJ.abEY = paramJSONObject.optString("pop_up_button_text");
          localc.abEC.abEJ.abEX = paramJSONObject.optString("pop_up_image_url");
        }
      }
      paramPromotions.OSs = localc;
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
      paramOrders.ORi = new DeductInfo();
      paramOrders.ORi.title = paramJSONObject.optString("contract_title");
      paramOrders.ORi.desc = paramJSONObject.optString("contract_desc");
      paramOrders.ORi.Ozp = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.ORi.ORR = paramJSONObject.optString("contract_url");
      paramOrders.ORi.ORT = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.ORi.OyD = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.ORi.tpM = paramJSONObject.optString("button_wording", "");
      paramOrders.ORi.OyE = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.ORi.ORU = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.ORi.ORV = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.ORi.ORS = new ArrayList();
        int i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            DeductShowInfo localDeductShowInfo = new DeductShowInfo();
            localDeductShowInfo.name = localJSONObject.optString("name");
            localDeductShowInfo.value = localJSONObject.optString("value");
            localJSONObject = localJSONObject.optJSONObject("value_attr");
            if (localJSONObject != null)
            {
              localDeductShowInfo.jDZ = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.ORW = localJSONObject.optString("link_weapp");
              localDeductShowInfo.ORX = localJSONObject.optString("link_addr");
              localDeductShowInfo.ORY = localJSONObject.optString("link_url");
            }
            paramOrders.ORi.ORS.add(localDeductShowInfo);
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
  
  private static void b(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70359);
    if (paramJSONObject != null) {
      try
      {
        paramOrders.ORp = paramJSONObject.optInt("is_use_show_info", 0);
        Log.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.ORp) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          Log.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.ORr = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              ShowInfo localShowInfo = new ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.CIl = localJSONObject.optString("name_color");
              localShowInfo.OSB = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.OSC = localJSONObject.optInt("link_type");
                localShowInfo.OSD = localJSONObject.optString("link_weapp");
                localShowInfo.OSE = localJSONObject.optString("link_addr");
                localShowInfo.OSF = localJSONObject.optString("link_url");
                localShowInfo.OSG = localJSONObject.optInt("text_attr");
              }
              if ((!Util.isNullOrNil(localShowInfo.name)) || (!Util.isNullOrNil(localShowInfo.value))) {
                paramOrders.ORr.add(localShowInfo);
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
  
  /* Error */
  public static Orders bJ(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 1258
    //   3: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: ifnull +900 -> 910
    //   13: new 2	com/tencent/mm/plugin/wallet_core/model/Orders
    //   16: dup
    //   17: invokespecial 1259	com/tencent/mm/plugin/wallet_core/model/Orders:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 1262	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   27: putfield 246	com/tencent/mm/plugin/wallet_core/model/Orders:OQL	J
    //   30: aload 5
    //   32: aload_0
    //   33: ldc_w 501
    //   36: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: ldc_w 1264
    //   42: iconst_2
    //   43: getstatic 1270	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   46: invokestatic 1275	com/tencent/mm/wallet_core/ui/g:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   49: putfield 175	com/tencent/mm/plugin/wallet_core/model/Orders:fwy	D
    //   52: aload 5
    //   54: aload_0
    //   55: ldc_w 1276
    //   58: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 173	com/tencent/mm/plugin/wallet_core/model/Orders:num	Ljava/lang/String;
    //   64: aload 5
    //   66: aload_0
    //   67: ldc_w 1278
    //   70: iconst_1
    //   71: invokevirtual 344	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: putfield 260	com/tencent/mm/plugin/wallet_core/model/Orders:OIp	I
    //   77: aload 5
    //   79: aload_0
    //   80: ldc_w 523
    //   83: ldc 165
    //   85: invokevirtual 526	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 262	com/tencent/mm/plugin/wallet_core/model/Orders:GHz	Ljava/lang/String;
    //   91: aload 5
    //   93: aload_0
    //   94: ldc_w 1280
    //   97: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: ldc_w 1264
    //   103: iconst_2
    //   104: getstatic 1270	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   107: invokestatic 1275	com/tencent/mm/wallet_core/ui/g:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   110: putfield 264	com/tencent/mm/plugin/wallet_core/model/Orders:Imo	D
    //   113: aload 5
    //   115: aload_0
    //   116: ldc_w 1282
    //   119: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: ldc_w 1264
    //   125: iconst_2
    //   126: getstatic 1270	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   129: invokestatic 1275	com/tencent/mm/wallet_core/ui/g:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   132: putfield 177	com/tencent/mm/plugin/wallet_core/model/Orders:OQM	D
    //   135: aload 5
    //   137: aload_0
    //   138: ldc_w 1284
    //   141: invokevirtual 438	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   144: putfield 266	com/tencent/mm/plugin/wallet_core/model/Orders:OQN	I
    //   147: aload 5
    //   149: aload_0
    //   150: ldc_w 1286
    //   153: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: putfield 268	com/tencent/mm/plugin/wallet_core/model/Orders:OMa	Ljava/lang/String;
    //   159: aload 5
    //   161: aload_0
    //   162: ldc_w 1288
    //   165: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 270	com/tencent/mm/plugin/wallet_core/model/Orders:OPh	Ljava/lang/String;
    //   171: aload 5
    //   173: aload_0
    //   174: ldc_w 1290
    //   177: invokevirtual 438	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   180: putfield 272	com/tencent/mm/plugin/wallet_core/model/Orders:OQO	I
    //   183: aload 5
    //   185: aload_0
    //   186: ldc_w 1292
    //   189: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: putfield 274	com/tencent/mm/plugin/wallet_core/model/Orders:OQP	Ljava/lang/String;
    //   195: aload_0
    //   196: ldc_w 1294
    //   199: invokevirtual 354	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore 6
    //   204: aload 5
    //   206: aload_0
    //   207: ldc_w 1296
    //   210: invokevirtual 425	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   213: putfield 1298	com/tencent/mm/plugin/wallet_core/model/Orders:ORj	J
    //   216: aload 5
    //   218: aload_0
    //   219: ldc_w 1300
    //   222: invokevirtual 425	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   225: putfield 1302	com/tencent/mm/plugin/wallet_core/model/Orders:ORk	J
    //   228: aload 5
    //   230: aload_0
    //   231: ldc_w 1304
    //   234: iconst_0
    //   235: invokevirtual 344	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   238: putfield 214	com/tencent/mm/plugin/wallet_core/model/Orders:ORl	I
    //   241: aload 5
    //   243: aload_0
    //   244: ldc_w 1306
    //   247: iconst_0
    //   248: invokevirtual 344	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   251: putfield 216	com/tencent/mm/plugin/wallet_core/model/Orders:ORm	I
    //   254: aload_0
    //   255: ldc_w 1308
    //   258: iconst_0
    //   259: invokevirtual 344	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   262: iconst_1
    //   263: if_icmpne +935 -> 1198
    //   266: iconst_1
    //   267: istore_1
    //   268: iload_1
    //   269: ifeq +15 -> 284
    //   272: aload 5
    //   274: new 189	java/util/HashSet
    //   277: dup
    //   278: invokespecial 190	java/util/HashSet:<init>	()V
    //   281: putfield 192	com/tencent/mm/plugin/wallet_core/model/Orders:OQZ	Ljava/util/Set;
    //   284: aload 6
    //   286: invokevirtual 359	org/json/JSONArray:length	()I
    //   289: istore_3
    //   290: iconst_0
    //   291: istore_2
    //   292: iload_2
    //   293: iload_3
    //   294: if_icmpge +280 -> 574
    //   297: aload 6
    //   299: iload_2
    //   300: invokevirtual 363	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   303: astore 7
    //   305: new 10	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity
    //   308: dup
    //   309: invokespecial 1309	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:<init>	()V
    //   312: astore 8
    //   314: aload 8
    //   316: aload 7
    //   318: ldc_w 1310
    //   321: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 1311	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:desc	Ljava/lang/String;
    //   327: aload 8
    //   329: aload 7
    //   331: ldc_w 1313
    //   334: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   337: ldc_w 1264
    //   340: iconst_2
    //   341: getstatic 1270	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   344: invokestatic 1275	com/tencent/mm/wallet_core/ui/g:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   347: putfield 514	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:tVK	D
    //   350: aload 8
    //   352: new 1315	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 1316	java/lang/StringBuilder:<init>	()V
    //   359: aload 7
    //   361: ldc_w 1318
    //   364: iconst_1
    //   365: invokevirtual 344	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   368: invokevirtual 1322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 1325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: putfield 1328	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHq	Ljava/lang/String;
    //   377: aload 8
    //   379: aload 7
    //   381: ldc_w 460
    //   384: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: putfield 463	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHs	Ljava/lang/String;
    //   390: aload 8
    //   392: aload 7
    //   394: ldc_w 470
    //   397: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 473	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHx	Ljava/lang/String;
    //   403: aload 8
    //   405: aload 7
    //   407: ldc_w 465
    //   410: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: putfield 468	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHt	Ljava/lang/String;
    //   416: aload 8
    //   418: aload 7
    //   420: ldc_w 1330
    //   423: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 1333	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHn	Ljava/lang/String;
    //   429: aload 8
    //   431: aload 7
    //   433: ldc_w 1335
    //   436: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 1338	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHo	Ljava/lang/String;
    //   442: aload 8
    //   444: aload 7
    //   446: ldc_w 1340
    //   449: invokevirtual 438	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   452: putfield 478	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHv	I
    //   455: aload 8
    //   457: aload 7
    //   459: ldc_w 380
    //   462: invokevirtual 383	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 386	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:fww	Ljava/lang/String;
    //   468: aload 8
    //   470: aload 7
    //   472: ldc_w 523
    //   475: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: putfield 527	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHz	Ljava/lang/String;
    //   481: aload 5
    //   483: getfield 262	com/tencent/mm/plugin/wallet_core/model/Orders:GHz	Ljava/lang/String;
    //   486: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   489: ifeq +13 -> 502
    //   492: aload 5
    //   494: aload 8
    //   496: getfield 527	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHz	Ljava/lang/String;
    //   499: putfield 262	com/tencent/mm/plugin/wallet_core/model/Orders:GHz	Ljava/lang/String;
    //   502: aload 8
    //   504: aload 7
    //   506: ldc_w 1342
    //   509: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   512: putfield 1343	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:fvb	Ljava/lang/String;
    //   515: aload 8
    //   517: aload 7
    //   519: ldc_w 338
    //   522: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: putfield 1346	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:GHd	Ljava/lang/String;
    //   528: aload 5
    //   530: getfield 201	com/tencent/mm/plugin/wallet_core/model/Orders:ORd	Ljava/util/List;
    //   533: aload 8
    //   535: invokeinterface 562 2 0
    //   540: pop
    //   541: iload_1
    //   542: ifne +649 -> 1191
    //   545: aload 5
    //   547: aload 7
    //   549: ldc_w 1348
    //   552: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   555: putfield 295	com/tencent/mm/plugin/wallet_core/model/Orders:OQY	Ljava/lang/String;
    //   558: aload 5
    //   560: aload 5
    //   562: getfield 295	com/tencent/mm/plugin/wallet_core/model/Orders:OQY	Ljava/lang/String;
    //   565: invokestatic 299	com/tencent/mm/plugin/wallet_core/model/Orders:bgP	(Ljava/lang/String;)Ljava/util/HashSet;
    //   568: putfield 192	com/tencent/mm/plugin/wallet_core/model/Orders:OQZ	Ljava/util/Set;
    //   571: goto +620 -> 1191
    //   574: aload_0
    //   575: ldc_w 1350
    //   578: invokevirtual 505	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +338 -> 919
    //   584: aload 5
    //   586: aload_0
    //   587: ldc_w 1350
    //   590: invokestatic 1354	com/tencent/mm/wallet_core/ui/g:s	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   593: putfield 179	com/tencent/mm/plugin/wallet_core/model/Orders:OQU	Z
    //   596: aload 5
    //   598: aload_0
    //   599: invokestatic 1358	com/tencent/mm/plugin/wallet_core/model/Orders:bW	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet/a/h;
    //   602: putfield 206	com/tencent/mm/plugin/wallet_core/model/Orders:ORe	Lcom/tencent/mm/plugin/wallet/a/h;
    //   605: aload_0
    //   606: ldc_w 1360
    //   609: invokevirtual 330	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   612: astore 6
    //   614: aload 6
    //   616: ifnonnull +337 -> 953
    //   619: ldc_w 411
    //   622: ldc_w 1362
    //   625: invokestatic 1204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 5
    //   630: aload_0
    //   631: ldc_w 1364
    //   634: invokevirtual 438	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   637: putfield 208	com/tencent/mm/plugin/wallet_core/model/Orders:ORf	I
    //   640: aload 5
    //   642: aload_0
    //   643: ldc_w 1366
    //   646: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   649: putfield 210	com/tencent/mm/plugin/wallet_core/model/Orders:ORg	Ljava/lang/String;
    //   652: aload 5
    //   654: aload_0
    //   655: ldc_w 1368
    //   658: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   661: putfield 212	com/tencent/mm/plugin/wallet_core/model/Orders:ORh	Ljava/lang/String;
    //   664: aload 5
    //   666: aload_0
    //   667: ldc_w 1370
    //   670: invokevirtual 330	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   673: invokestatic 1372	com/tencent/mm/plugin/wallet_core/model/Orders:a	(Lcom/tencent/mm/plugin/wallet_core/model/Orders;Lorg/json/JSONObject;)V
    //   676: aload_0
    //   677: ldc_w 1374
    //   680: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   683: astore 6
    //   685: aload 6
    //   687: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   690: ifne +42 -> 732
    //   693: aload 6
    //   695: iconst_0
    //   696: invokestatic 1380	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   699: astore 6
    //   701: new 1382	com/tencent/mm/protocal/protobuf/apb
    //   704: dup
    //   705: invokespecial 1383	com/tencent/mm/protocal/protobuf/apb:<init>	()V
    //   708: aload 6
    //   710: invokevirtual 1387	com/tencent/mm/protocal/protobuf/apb:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   713: checkcast 1382	com/tencent/mm/protocal/protobuf/apb
    //   716: astore 6
    //   718: aload 5
    //   720: getfield 232	com/tencent/mm/plugin/wallet_core/model/Orders:field_infos	Ljava/util/ArrayList;
    //   723: aload 6
    //   725: getfield 1390	com/tencent/mm/protocal/protobuf/apb:field_info	Ljava/util/LinkedList;
    //   728: invokevirtual 1394	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   731: pop
    //   732: aload 5
    //   734: aload_0
    //   735: ldc_w 1396
    //   738: ldc 171
    //   740: invokevirtual 526	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 234	com/tencent/mm/plugin/wallet_core/model/Orders:ORu	Ljava/lang/String;
    //   746: aload 5
    //   748: aload_0
    //   749: ldc_w 1398
    //   752: ldc 165
    //   754: invokevirtual 526	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   757: putfield 1400	com/tencent/mm/plugin/wallet_core/model/Orders:ORv	Ljava/lang/String;
    //   760: aload 5
    //   762: aload_0
    //   763: ldc_w 1402
    //   766: ldc 165
    //   768: invokevirtual 526	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   771: putfield 1404	com/tencent/mm/plugin/wallet_core/model/Orders:ORw	Ljava/lang/String;
    //   774: aload 5
    //   776: aload_0
    //   777: ldc_w 1406
    //   780: ldc 171
    //   782: invokevirtual 526	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 236	com/tencent/mm/plugin/wallet_core/model/Orders:ORx	Ljava/lang/String;
    //   788: aload 5
    //   790: aload_0
    //   791: ldc_w 1408
    //   794: ldc 165
    //   796: invokevirtual 526	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   799: putfield 1410	com/tencent/mm/plugin/wallet_core/model/Orders:ORy	Ljava/lang/String;
    //   802: aload 5
    //   804: aload_0
    //   805: ldc_w 1412
    //   808: ldc 165
    //   810: invokevirtual 526	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: putfield 1414	com/tencent/mm/plugin/wallet_core/model/Orders:ORz	Ljava/lang/String;
    //   816: aload 5
    //   818: aload_0
    //   819: ldc_w 1416
    //   822: iconst_0
    //   823: invokevirtual 344	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   826: putfield 1418	com/tencent/mm/plugin/wallet_core/model/Orders:ORA	I
    //   829: aload_0
    //   830: ldc_w 1360
    //   833: invokevirtual 330	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   836: astore_0
    //   837: aload_0
    //   838: ifnull +72 -> 910
    //   841: aload_0
    //   842: ldc_w 1420
    //   845: invokevirtual 330	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   848: astore_0
    //   849: aload_0
    //   850: ifnull +60 -> 910
    //   853: aload 5
    //   855: new 55	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo
    //   858: dup
    //   859: invokespecial 1421	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:<init>	()V
    //   862: putfield 314	com/tencent/mm/plugin/wallet_core/model/Orders:ORB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   865: aload 5
    //   867: getfield 314	com/tencent/mm/plugin/wallet_core/model/Orders:ORB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   870: aload_0
    //   871: ldc_w 1423
    //   874: invokevirtual 438	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   877: putfield 1426	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:OSH	I
    //   880: aload 5
    //   882: getfield 314	com/tencent/mm/plugin/wallet_core/model/Orders:ORB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   885: aload_0
    //   886: ldc_w 1428
    //   889: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   892: putfield 1431	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:fvP	Ljava/lang/String;
    //   895: aload 5
    //   897: getfield 314	com/tencent/mm/plugin/wallet_core/model/Orders:ORB	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   900: aload_0
    //   901: ldc_w 1433
    //   904: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   907: putfield 1436	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:GGC	Ljava/lang/String;
    //   910: ldc_w 1258
    //   913: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: aload 5
    //   918: areturn
    //   919: aload 5
    //   921: aload 5
    //   923: getfield 260	com/tencent/mm/plugin/wallet_core/model/Orders:OIp	I
    //   926: iconst_2
    //   927: invokestatic 1442	com/tencent/mm/plugin/wallet_core/model/Bankcard:lj	(II)Z
    //   930: putfield 179	com/tencent/mm/plugin/wallet_core/model/Orders:OQU	Z
    //   933: goto -337 -> 596
    //   936: astore_0
    //   937: ldc_w 411
    //   940: aload_0
    //   941: ldc 165
    //   943: iconst_0
    //   944: anewarray 4	java/lang/Object
    //   947: invokestatic 417	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   950: goto -40 -> 910
    //   953: aload 6
    //   955: ldc_w 1444
    //   958: invokevirtual 330	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   961: astore 6
    //   963: aload 6
    //   965: ifnonnull +15 -> 980
    //   968: ldc_w 411
    //   971: ldc_w 1446
    //   974: invokestatic 1204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -349 -> 628
    //   980: aload 6
    //   982: ldc_w 1448
    //   985: invokevirtual 330	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   988: astore 6
    //   990: aload 6
    //   992: ifnonnull +15 -> 1007
    //   995: ldc_w 411
    //   998: ldc_w 1450
    //   1001: invokestatic 1204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: goto -376 -> 628
    //   1007: ldc_w 1452
    //   1010: invokestatic 1458	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1013: checkcast 1452	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1016: invokeinterface 1461 1 0
    //   1021: ifne +182 -> 1203
    //   1024: ldc_w 1452
    //   1027: invokestatic 1458	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1030: checkcast 1452	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1033: invokeinterface 1464 1 0
    //   1038: ifeq +170 -> 1208
    //   1041: goto +162 -> 1203
    //   1044: iload_1
    //   1045: ifeq +168 -> 1213
    //   1048: aload 6
    //   1050: ldc_w 1466
    //   1053: iconst_0
    //   1054: invokevirtual 344	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1057: istore_1
    //   1058: aload 5
    //   1060: iload_1
    //   1061: putfield 194	com/tencent/mm/plugin/wallet_core/model/Orders:ORa	I
    //   1064: aload 5
    //   1066: aload 6
    //   1068: ldc_w 1468
    //   1071: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: putfield 196	com/tencent/mm/plugin/wallet_core/model/Orders:ORc	Ljava/lang/String;
    //   1077: aload 6
    //   1079: ldc_w 1470
    //   1082: invokevirtual 336	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1085: astore 7
    //   1087: iconst_1
    //   1088: aload 6
    //   1090: ldc_w 1472
    //   1093: invokevirtual 438	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1096: if_icmpne +122 -> 1218
    //   1099: iconst_1
    //   1100: istore 4
    //   1102: aload 5
    //   1104: aload 7
    //   1106: putfield 316	com/tencent/mm/plugin/wallet_core/model/Orders:ByB	Ljava/lang/String;
    //   1109: aload 5
    //   1111: iload 4
    //   1113: putfield 318	com/tencent/mm/plugin/wallet_core/model/Orders:ORb	Z
    //   1116: getstatic 1478	com/tencent/mm/plugin/fingerprint/b/p:ByH	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1119: aload 7
    //   1121: putfield 1479	com/tencent/mm/plugin/fingerprint/b/p:ByB	Ljava/lang/String;
    //   1124: getstatic 1478	com/tencent/mm/plugin/fingerprint/b/p:ByH	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1127: iload 4
    //   1129: putfield 1482	com/tencent/mm/plugin/fingerprint/b/p:ByJ	Z
    //   1132: ldc_w 411
    //   1135: ldc_w 1484
    //   1138: iconst_3
    //   1139: anewarray 4	java/lang/Object
    //   1142: dup
    //   1143: iconst_0
    //   1144: aload 5
    //   1146: getfield 194	com/tencent/mm/plugin/wallet_core/model/Orders:ORa	I
    //   1149: invokestatic 1218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_1
    //   1155: aload 7
    //   1157: aastore
    //   1158: dup
    //   1159: iconst_2
    //   1160: iload 4
    //   1162: invokestatic 1489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1165: aastore
    //   1166: invokestatic 767	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1169: goto -541 -> 628
    //   1172: astore 6
    //   1174: ldc_w 411
    //   1177: aload 6
    //   1179: ldc 165
    //   1181: iconst_0
    //   1182: anewarray 4	java/lang/Object
    //   1185: invokestatic 417	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private static com.tencent.mm.plugin.wallet.a.h bW(JSONObject paramJSONObject)
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
    localh.Owj = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localh.Owk = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localh.Owl = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localh.Owm = paramJSONObject.optString("favorComposeId");
    localh.Owp = paramJSONObject.optInt("useNaturalDefense");
    localh.Owq = paramJSONObject.optString("discountWording");
    localh.Owr = paramJSONObject.optString("favorRuleWording");
    localh.Ows = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localh.Owt = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localh.Owu = paramJSONObject.optInt("isVariableFavor");
    localh.Owv = paramJSONObject.optString("invariableFavorDesc");
    localh.Oww = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new t();
      ((t)localObject2).Oxb = ((JSONObject)localObject3).optInt("favType");
      ((t)localObject2).Oxc = ((JSONObject)localObject3).optInt("favSubType");
      ((t)localObject2).Oxd = ((JSONObject)localObject3).optLong("favProperty");
      ((t)localObject2).Oxe = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((t)localObject2).Owg = ((JSONObject)localObject3).optString("favId");
      ((t)localObject2).Oxf = ((JSONObject)localObject3).optString("favName");
      ((t)localObject2).Oxg = ((JSONObject)localObject3).optString("favDesc");
      ((t)localObject2).Owh = ((JSONObject)localObject3).optString("favorUseManual");
      ((t)localObject2).Owi = ((JSONObject)localObject3).optString("favorRemarks");
      ((t)localObject2).Oxh = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((t)localObject2).Oxi = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((t)localObject2).Oxj = ((JSONObject)localObject3).optInt("needBankPay");
      ((t)localObject2).Oxk = ((JSONObject)localObject3).optString("bankNo");
      ((t)localObject2).GHx = ((JSONObject)localObject3).optString("bankName");
      ((t)localObject2).Oxl = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((t)localObject2).Oxm.add(com.tencent.mm.cd.b.cU(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localh.Own.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localh.Owo = new com.tencent.mm.plugin.wallet.a.i();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new j();
        ((j)localObject2).OwC = ((JSONObject)localObject3).optString("faovrComposeId");
        ((j)localObject2).OwD = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((j)localObject2).Owl = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((j)localObject2).Ows = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).Owt = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).Owu = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((j)localObject2).Owv = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((j)localObject2).Oww = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.a.f();
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).Owg = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).Owh = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).Owi = ((JSONObject)localObject4).optString("favorRemarks");
          ((j)localObject2).OwE.add(localObject5);
          j += 1;
        }
        localh.Owo.OwA.add(localObject2);
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
          ((com.tencent.mm.plugin.wallet.a.c)localObject4).GGC = ((JSONObject)localObject5).optString("bind_serial");
          localObject5 = ((JSONObject)localObject5).optJSONArray("bind_serial_favor_list");
          if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              com.tencent.mm.plugin.wallet.a.d locald = new com.tencent.mm.plugin.wallet.a.d();
              JSONObject localJSONObject = ((JSONArray)localObject5).optJSONObject(j);
              locald.Ila = localJSONObject.optString("favor_desc");
              locald.Owe = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.a.c)localObject4).Owd.add(locald);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).OvS.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.a.a)localObject1).OvT = new n();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new o();
          ((o)localObject3).Ila = ((JSONArray)localObject2).optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).OvT.OwJ.add(localObject3);
          i += 1;
        }
      }
    }
    localh.Owx = ((com.tencent.mm.plugin.wallet.a.a)localObject1);
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
          ((com.tencent.mm.plugin.wallet.a.g)localObject2).OvW = ((JSONObject)localObject3).optString("default_fav_comb_id");
          localObject3 = ((JSONObject)localObject3).optJSONObject("payment_channel");
          if (localObject3 != null)
          {
            localObject4 = new m();
            ((m)localObject4).GGC = ((JSONObject)localObject3).optString("bind_serial");
            ((m)localObject4).selected = ((JSONObject)localObject3).optInt("selected");
            ((m)localObject4).OwI = ((JSONObject)localObject3).optString("bankCode");
            ((com.tencent.mm.plugin.wallet.a.g)localObject2).OvU = ((m)localObject4);
          }
          localh.Owy.add(localObject2);
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
        ((m)localObject2).OwI = ((JSONObject)localObject3).optString("bankCode");
        ((m)localObject2).selected = ((JSONObject)localObject3).optInt("selected");
        ((m)localObject2).GGC = ((JSONObject)localObject3).optString("bind_serial");
        ((com.tencent.mm.plugin.wallet.a.b)localObject1).OvU = ((m)localObject2);
      }
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).OvV = paramJSONObject.optInt("is_show_guide");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).OvW = paramJSONObject.optString("default_fav_comb_id");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).OvX = paramJSONObject.optString("guide_content");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).OvY = paramJSONObject.optString("guide_content_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).OvZ = paramJSONObject.optString("guide_btn_text");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Owa = paramJSONObject.optString("guide_btn_text_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Owb = paramJSONObject.optString("guide_btn_bg_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Owc = paramJSONObject.optString("guide_logo");
      localh.Owz = ((com.tencent.mm.plugin.wallet.a.b)localObject1);
    }
    AppMethodBeat.o(70354);
    return localh;
  }
  
  private static HashSet<String> bgP(String paramString)
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70360);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reqKey:").append(this.fwv).append("\n");
    ((StringBuilder)localObject).append("token").append(this.token).append("\n");
    ((StringBuilder)localObject).append("num").append(this.num).append("\n");
    ((StringBuilder)localObject).append("totalFee").append(this.fwy).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(70360);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70363);
    paramParcel.writeLong(this.OQL);
    paramParcel.writeString(this.fwv);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.num);
    paramParcel.writeDouble(this.fwy);
    paramParcel.writeInt(this.OIp);
    paramParcel.writeString(this.GHz);
    paramParcel.writeDouble(this.Imo);
    paramParcel.writeDouble(this.OQM);
    paramParcel.writeInt(this.OQN);
    paramParcel.writeString(this.OMa);
    paramParcel.writeString(this.OPh);
    paramParcel.writeInt(this.OQO);
    paramParcel.writeString(this.OQP);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.GtW);
    paramParcel.writeString(this.OQQ);
    paramParcel.writeString(this.OQR);
    paramParcel.writeString(this.OQS);
    paramParcel.writeInt(this.OQT);
    if (this.OQU)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.OQV);
      paramParcel.writeString(this.vhY);
      paramParcel.writeLong(this.OQW);
      paramParcel.writeString(this.OQX);
      paramParcel.writeTypedList(this.ORd);
      paramParcel.writeString(this.OQY);
      paramParcel.writeInt(this.ORa);
      paramParcel.writeString(this.ORc);
      paramParcel.writeParcelable(this.ORi, 1);
      paramParcel.writeInt(this.ORl);
      paramParcel.writeInt(this.ORm);
      paramParcel.writeInt(this.ORq);
      paramParcel.writeString(this.ORt);
      paramParcel.writeString(this.ORs);
      paramParcel.writeInt(this.ORp);
      paramParcel.writeTypedList(this.ORr);
      paramParcel.writeParcelable(this.ORB, 1);
      paramParcel.writeString(this.ByB);
      if (!this.ORb) {
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
    public String GHD;
    public String GHd;
    public String GHl;
    public String GHm;
    public String GHn;
    public String GHo;
    public String GHq;
    public String GHs;
    public String GHt;
    public int GHv;
    public String GHx;
    public String GHz;
    public int OQT;
    public double ORE;
    public String ORF;
    public String ORG;
    public List<Orders.DiscountInfo> ORH;
    public String ORI;
    public String ORJ;
    public String ORK;
    public Orders.RecommendTinyAppInfo ORL;
    public Orders.FinderInfo ORM;
    public Orders.RemarksInfo ORN;
    public List<Orders.Promotions> ORO;
    public boolean ORP;
    public Orders.a ORQ;
    public String desc;
    public String fvb;
    public String fww;
    public double tVK;
    
    static
    {
      AppMethodBeat.i(70317);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70317);
    }
    
    public Commodity()
    {
      AppMethodBeat.i(70314);
      this.tVK = 0.0D;
      this.ORE = 0.0D;
      this.ORH = new ArrayList();
      this.ORL = null;
      this.ORM = null;
      this.ORO = new ArrayList();
      this.ORP = false;
      this.ORQ = new Orders.a();
      AppMethodBeat.o(70314);
    }
    
    public Commodity(Parcel paramParcel)
    {
      AppMethodBeat.i(70315);
      this.tVK = 0.0D;
      this.ORE = 0.0D;
      this.ORH = new ArrayList();
      this.ORL = null;
      this.ORM = null;
      this.ORO = new ArrayList();
      this.ORP = false;
      this.ORQ = new Orders.a();
      this.GHl = paramParcel.readString();
      this.GHm = paramParcel.readString();
      this.GHn = paramParcel.readString();
      this.GHo = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.GHq = paramParcel.readString();
      this.tVK = paramParcel.readDouble();
      this.GHs = paramParcel.readString();
      this.GHt = paramParcel.readString();
      this.GHv = paramParcel.readInt();
      this.fww = paramParcel.readString();
      this.GHx = paramParcel.readString();
      this.GHz = paramParcel.readString();
      this.fvb = paramParcel.readString();
      this.GHd = paramParcel.readString();
      this.ORG = paramParcel.readString();
      this.GHD = paramParcel.readString();
      paramParcel.readTypedList(this.ORH, Orders.DiscountInfo.CREATOR);
      this.ORI = paramParcel.readString();
      this.ORK = paramParcel.readString();
      this.ORL = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
      this.ORM = ((Orders.FinderInfo)paramParcel.readParcelable(Orders.FinderInfo.class.getClassLoader()));
      paramParcel.readTypedList(this.ORO, Orders.Promotions.CREATOR);
      this.ORN = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.ORP = bool;
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
      paramParcel.writeString(this.GHl);
      paramParcel.writeString(this.GHm);
      paramParcel.writeString(this.GHn);
      paramParcel.writeString(this.GHo);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.GHq);
      paramParcel.writeDouble(this.tVK);
      paramParcel.writeString(this.GHs);
      paramParcel.writeString(this.GHt);
      paramParcel.writeInt(this.GHv);
      paramParcel.writeString(this.fww);
      paramParcel.writeString(this.GHx);
      paramParcel.writeString(this.GHz);
      paramParcel.writeString(this.fvb);
      paramParcel.writeString(this.GHd);
      paramParcel.writeString(this.ORG);
      paramParcel.writeString(this.GHD);
      paramParcel.writeTypedList(this.ORH);
      paramParcel.writeString(this.ORI);
      paramParcel.writeString(this.ORK);
      paramParcel.writeParcelable(this.ORL, 0);
      paramParcel.writeParcelable(this.ORM, 0);
      paramParcel.writeTypedList(this.ORO);
      paramParcel.writeParcelable(this.ORN, 0);
      if (this.ORP) {
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
    public String ORR;
    public List<Orders.DeductShowInfo> ORS;
    public int ORT;
    public String ORU;
    public String ORV;
    public int OyD;
    public String OyE;
    public int Ozp;
    public String desc;
    public String title;
    public String tpM;
    
    static
    {
      AppMethodBeat.i(70322);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70322);
    }
    
    public DeductInfo()
    {
      AppMethodBeat.i(70319);
      this.ORS = new ArrayList();
      AppMethodBeat.o(70319);
    }
    
    public DeductInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70320);
      this.ORS = new ArrayList();
      this.title = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.Ozp = paramParcel.readInt();
      this.ORR = paramParcel.readString();
      this.ORT = paramParcel.readInt();
      paramParcel.readTypedList(this.ORS, Orders.DeductShowInfo.CREATOR);
      this.OyD = paramParcel.readInt();
      this.tpM = paramParcel.readString();
      this.OyE = paramParcel.readString();
      this.ORU = paramParcel.readString();
      this.ORV = paramParcel.readString();
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
      paramParcel.writeInt(this.Ozp);
      paramParcel.writeString(this.ORR);
      paramParcel.writeInt(this.ORT);
      paramParcel.writeTypedList(this.ORS);
      paramParcel.writeInt(this.OyD);
      paramParcel.writeString(this.tpM);
      paramParcel.writeString(this.OyE);
      paramParcel.writeString(this.ORU);
      paramParcel.writeString(this.ORV);
      AppMethodBeat.o(70321);
    }
  }
  
  public static class DeductShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DeductShowInfo> CREATOR;
    public String ORW;
    public String ORX;
    public String ORY;
    public int jDZ;
    public String name;
    public String value;
    
    static
    {
      AppMethodBeat.i(70326);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70326);
    }
    
    public DeductShowInfo() {}
    
    protected DeductShowInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70324);
      this.name = paramParcel.readString();
      this.value = paramParcel.readString();
      this.jDZ = paramParcel.readInt();
      this.ORW = paramParcel.readString();
      this.ORX = paramParcel.readString();
      this.ORY = paramParcel.readString();
      AppMethodBeat.o(70324);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70325);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.value);
      paramParcel.writeInt(this.jDZ);
      paramParcel.writeString(this.ORW);
      paramParcel.writeString(this.ORX);
      paramParcel.writeString(this.ORY);
      AppMethodBeat.o(70325);
    }
  }
  
  public static class DiscountInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DiscountInfo> CREATOR;
    public String Ila;
    public double ORZ;
    
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
      this.ORZ = paramParcel.readDouble();
      this.Ila = paramParcel.readString();
      AppMethodBeat.o(70328);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70329);
      paramParcel.writeDouble(this.ORZ);
      paramParcel.writeString(this.Ila);
      AppMethodBeat.o(70329);
    }
  }
  
  public static class FinderInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<FinderInfo> CREATOR;
    public String OSa;
    public String OSb;
    public String OSc;
    public String OSd;
    public String OSe;
    public String OSf;
    public int OSg;
    public String OSh;
    public String OSi;
    public String OSj;
    public String path;
    public int type;
    public String url;
    public String username;
    public String version;
    
    static
    {
      AppMethodBeat.i(260940);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(260940);
    }
    
    public FinderInfo() {}
    
    public FinderInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(260934);
      this.type = paramParcel.readInt();
      this.url = paramParcel.readString();
      this.username = paramParcel.readString();
      this.path = paramParcel.readString();
      this.version = paramParcel.readString();
      this.OSa = paramParcel.readString();
      this.OSb = paramParcel.readString();
      this.OSc = paramParcel.readString();
      this.OSd = paramParcel.readString();
      this.OSe = paramParcel.readString();
      this.OSf = paramParcel.readString();
      this.OSh = paramParcel.readString();
      this.OSi = paramParcel.readString();
      this.OSj = paramParcel.readString();
      this.OSg = paramParcel.readInt();
      AppMethodBeat.o(260934);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(260938);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.path);
      paramParcel.writeString(this.version);
      paramParcel.writeString(this.OSa);
      paramParcel.writeString(this.OSb);
      paramParcel.writeString(this.OSc);
      paramParcel.writeString(this.OSd);
      paramParcel.writeString(this.OSe);
      paramParcel.writeString(this.OSf);
      paramParcel.writeString(this.OSh);
      paramParcel.writeString(this.OSi);
      paramParcel.writeString(this.OSj);
      paramParcel.writeInt(this.OSg);
      AppMethodBeat.o(260938);
    }
  }
  
  public static class Promotions
    implements Parcelable
  {
    public static final Parcelable.Creator<Promotions> CREATOR;
    public String GUf;
    public int OQC;
    public int OQD;
    public long OQE;
    public String OQF;
    public e.a.a.c OSs;
    public int SuA;
    public int SuB;
    public String SuC;
    public String SuD;
    public String SuE;
    public int SuF;
    public String SuG;
    public String SuI;
    public long cpu;
    public String fvb;
    public String name;
    public String title;
    public int type;
    public String url;
    public int wYj;
    
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
      this.GUf = paramParcel.readString();
      this.name = paramParcel.readString();
      this.OQF = paramParcel.readString();
      this.url = paramParcel.readString();
      this.fvb = paramParcel.readString();
      this.title = paramParcel.readString();
      this.wYj = paramParcel.readInt();
      this.cpu = paramParcel.readLong();
      this.SuA = paramParcel.readInt();
      this.SuB = paramParcel.readInt();
      this.OQC = paramParcel.readInt();
      this.OQD = paramParcel.readInt();
      this.SuC = paramParcel.readString();
      this.SuD = paramParcel.readString();
      this.SuE = paramParcel.readString();
      this.OQE = paramParcel.readLong();
      this.SuF = paramParcel.readInt();
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
      paramParcel.writeString(this.GUf);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.OQF);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.fvb);
      paramParcel.writeString(this.title);
      paramParcel.writeInt(this.wYj);
      paramParcel.writeLong(this.cpu);
      paramParcel.writeInt(this.SuA);
      paramParcel.writeInt(this.SuB);
      paramParcel.writeInt(this.OQC);
      paramParcel.writeInt(this.OQD);
      paramParcel.writeString(this.SuC);
      paramParcel.writeString(this.SuD);
      paramParcel.writeString(this.SuE);
      paramParcel.writeLong(this.OQE);
      paramParcel.writeInt(this.SuF);
      AppMethodBeat.o(70333);
    }
  }
  
  public static class RecommendTinyAppInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR;
    public String ODu;
    public String OQH;
    public String OQI;
    public String OQJ;
    public int OQK;
    public long OSt;
    public long OSu;
    public long OSv;
    public int OSw;
    public int OSx;
    public long OSy;
    public String Ooe;
    public String Oof;
    
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
      this.ODu = paramParcel.readString();
      this.OQH = paramParcel.readString();
      this.OQI = paramParcel.readString();
      this.Ooe = paramParcel.readString();
      this.Oof = paramParcel.readString();
      this.OQK = paramParcel.readInt();
      AppMethodBeat.o(70336);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70337);
      paramParcel.writeString(this.ODu);
      paramParcel.writeString(this.OQH);
      paramParcel.writeString(this.OQI);
      paramParcel.writeString(this.Ooe);
      paramParcel.writeString(this.Oof);
      paramParcel.writeInt(this.OQK);
      AppMethodBeat.o(70337);
    }
  }
  
  public static class RemarksInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RemarksInfo> CREATOR;
    public String OSA;
    public String OSz;
    
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
      this.OSz = paramParcel.readString();
      this.OSA = paramParcel.readString();
      AppMethodBeat.o(70340);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70341);
      paramParcel.writeString(this.OSz);
      paramParcel.writeString(this.OSA);
      AppMethodBeat.o(70341);
    }
  }
  
  public static class ShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ShowInfo> CREATOR;
    public String CIl;
    public String OSB;
    public int OSC;
    public String OSD;
    public String OSE;
    public String OSF;
    public int OSG;
    public String name;
    public String value;
    
    static
    {
      AppMethodBeat.i(70347);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70347);
    }
    
    public ShowInfo() {}
    
    protected ShowInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70344);
      this.name = paramParcel.readString();
      this.value = paramParcel.readString();
      this.CIl = paramParcel.readString();
      this.OSB = paramParcel.readString();
      this.OSC = paramParcel.readInt();
      this.OSD = paramParcel.readString();
      this.OSE = paramParcel.readString();
      this.OSF = paramParcel.readString();
      this.OSG = paramParcel.readInt();
      AppMethodBeat.o(70344);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(70345);
      String str = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.CIl, this.OSB, Integer.valueOf(this.OSC), this.OSD, this.OSE, this.OSF, Integer.valueOf(this.OSG) });
      AppMethodBeat.o(70345);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70346);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.CIl);
      paramParcel.writeString(this.OSB);
      paramParcel.writeInt(this.OSC);
      paramParcel.writeString(this.OSD);
      paramParcel.writeString(this.OSE);
      paramParcel.writeString(this.OSF);
      paramParcel.writeInt(this.OSG);
      AppMethodBeat.o(70346);
    }
  }
  
  public static class SimpleCashierInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleCashierInfo> CREATOR;
    public String GGC;
    public int OSH;
    public String fvP;
    
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
      this.OSH = paramParcel.readInt();
      this.fvP = paramParcel.readString();
      this.GGC = paramParcel.readString();
      AppMethodBeat.o(70349);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70350);
      paramParcel.writeInt(this.OSH);
      paramParcel.writeString(this.fvP);
      paramParcel.writeString(this.GGC);
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