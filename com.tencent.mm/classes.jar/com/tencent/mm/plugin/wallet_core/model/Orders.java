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
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public static int Dqo;
  public static int Dqp;
  public int DgN;
  public String DkG;
  public String DnP;
  public int DpA;
  public String DpB;
  public String DpC;
  public String DpD;
  public String DpE;
  public int DpF;
  public boolean DpG;
  public String DpH;
  public long DpI;
  public String DpJ;
  public String DpK;
  public Set<String> DpL;
  public int DpM;
  public boolean DpN;
  public String DpO;
  public List<Commodity> DpP;
  public com.tencent.mm.plugin.wallet.a.h DpQ;
  public int DpR;
  public String DpS;
  public String DpT;
  public DeductInfo DpU;
  public long DpV;
  public long DpW;
  public int DpX;
  public int DpY;
  public int DpZ;
  public long Dpx;
  public double Dpy;
  public int Dpz;
  public String Dqa;
  public int Dqb;
  public int Dqc;
  public ArrayList<ShowInfo> Dqd;
  public String Dqe;
  public String Dqf;
  public String Dqg;
  public String Dqh;
  public String Dqi;
  public String Dqj;
  public String Dqk;
  public String Dql;
  public int Dqm;
  public SimpleCashierInfo Dqn;
  public String dmw;
  public double dmz;
  public String fTm;
  public ArrayList<dmr> field_infos;
  public String nickname;
  public String qlv;
  public String token;
  public String trY;
  public String username;
  public String wFJ;
  public String wSq;
  public double yoj;
  
  static
  {
    AppMethodBeat.i(70364);
    CREATOR = new Parcelable.Creator() {};
    Dqo = 0;
    Dqp = 1;
    AppMethodBeat.o(70364);
  }
  
  public Orders()
  {
    AppMethodBeat.i(70352);
    this.dmw = "";
    this.token = "";
    this.fTm = "0";
    this.dmz = 0.0D;
    this.Dpy = 0.0D;
    this.DpG = false;
    this.DpH = "";
    this.qlv = "";
    this.DpI = 0L;
    this.DpJ = "";
    this.DpL = new HashSet();
    this.DpM = 0;
    this.DpO = "";
    this.DpP = new ArrayList();
    this.DpQ = new com.tencent.mm.plugin.wallet.a.h();
    this.DpR = 0;
    this.DpS = "";
    this.DpT = "";
    this.DpX = 0;
    this.DpY = 0;
    this.DpZ = 0;
    this.Dqa = "";
    this.Dqb = 0;
    this.Dqc = 0;
    this.Dqd = new ArrayList();
    this.Dqe = "";
    this.Dqf = "";
    this.field_infos = new ArrayList();
    this.Dqg = "";
    this.Dqj = "";
    AppMethodBeat.o(70352);
  }
  
  public Orders(Parcel paramParcel)
  {
    AppMethodBeat.i(70362);
    this.dmw = "";
    this.token = "";
    this.fTm = "0";
    this.dmz = 0.0D;
    this.Dpy = 0.0D;
    this.DpG = false;
    this.DpH = "";
    this.qlv = "";
    this.DpI = 0L;
    this.DpJ = "";
    this.DpL = new HashSet();
    this.DpM = 0;
    this.DpO = "";
    this.DpP = new ArrayList();
    this.DpQ = new com.tencent.mm.plugin.wallet.a.h();
    this.DpR = 0;
    this.DpS = "";
    this.DpT = "";
    this.DpX = 0;
    this.DpY = 0;
    this.DpZ = 0;
    this.Dqa = "";
    this.Dqb = 0;
    this.Dqc = 0;
    this.Dqd = new ArrayList();
    this.Dqe = "";
    this.Dqf = "";
    this.field_infos = new ArrayList();
    this.Dqg = "";
    this.Dqj = "";
    this.Dpx = paramParcel.readLong();
    this.dmw = paramParcel.readString();
    this.token = paramParcel.readString();
    this.fTm = paramParcel.readString();
    this.dmz = paramParcel.readDouble();
    this.DgN = paramParcel.readInt();
    this.wSq = paramParcel.readString();
    this.yoj = paramParcel.readDouble();
    this.Dpy = paramParcel.readDouble();
    this.Dpz = paramParcel.readInt();
    this.DkG = paramParcel.readString();
    this.DnP = paramParcel.readString();
    this.DpA = paramParcel.readInt();
    this.DpB = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.wFJ = paramParcel.readString();
    this.DpC = paramParcel.readString();
    this.DpD = paramParcel.readString();
    this.DpE = paramParcel.readString();
    this.DpF = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.DpG = bool1;
      this.DpH = paramParcel.readString();
      this.qlv = paramParcel.readString();
      this.DpI = paramParcel.readLong();
      this.DpJ = paramParcel.readString();
      paramParcel.readTypedList(this.DpP, Commodity.CREATOR);
      this.DpK = paramParcel.readString();
      this.DpL = aFH(this.DpK);
      this.DpM = paramParcel.readInt();
      this.DpO = paramParcel.readString();
      this.DpU = ((DeductInfo)paramParcel.readParcelable(DeductInfo.class.getClassLoader()));
      this.DpX = paramParcel.readInt();
      this.DpY = paramParcel.readInt();
      this.Dqc = paramParcel.readInt();
      this.Dqf = paramParcel.readString();
      this.Dqe = paramParcel.readString();
      this.Dqb = paramParcel.readInt();
      paramParcel.readTypedList(this.Dqd, ShowInfo.CREATOR);
      this.Dqn = ((SimpleCashierInfo)paramParcel.readParcelable(SimpleCashierInfo.class.getClassLoader()));
      this.trY = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label591;
      }
    }
    label591:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.DpN = bool1;
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
          paramOrders.DpD = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.DpE = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.DpF = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.qlv = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.DpF;
        localObject1 = paramOrders.DpP;
        paramOrders.DpH = paramJSONObject.optString("pay_result_tips");
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
            ((Commodity)localObject2).Dqz = new ArrayList();
            ((Commodity)localObject2).Dqt = new ArrayList();
            ((Commodity)localObject2).dmx = localJSONObject.getString("transaction_id");
            a((Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Commodity localCommodity = (Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.dmx))) {
                continue;
              }
              a(localCommodity, localJSONObject, j);
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ae.printErrStackTrace("MicroMsg.Orders", paramJSONObject, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(70355);
        return paramOrders;
        localObject1 = paramJSONObject.optJSONObject("extinfo");
        if (localObject1 != null)
        {
          paramOrders.DpI = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
          paramOrders.DpJ = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
        }
        paramOrders.DpZ = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
        paramOrders.Dqa = paramJSONObject.optString("pay_succ_btn_wording");
        paramOrders.Dqc = paramJSONObject.optInt("is_jsapi_close_page");
        paramOrders.Dqe = paramJSONObject.optString("jsapi_tinyapp_username");
        paramOrders.Dqf = paramJSONObject.optString("jsapi_tinyapp_path");
        b(paramOrders, paramJSONObject);
        continue;
        ae.w("MicroMsg.Orders", "oldOrders is null");
      }
      i += 1;
    }
  }
  
  private static void a(Commodity paramCommodity, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(70356);
    paramCommodity.wSv = paramJSONObject.optString("discount");
    paramCommodity.wSj = paramJSONObject.getString("pay_status");
    paramCommodity.wSk = paramJSONObject.getString("pay_status_name");
    paramCommodity.wSo = paramJSONObject.optString("buy_bank_name");
    paramCommodity.wSm = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.Dqs = paramJSONObject.optString("card_tail");
    paramCommodity.DpF = paramInt;
    paramCommodity.Dqu = paramJSONObject.optString("rateinfo");
    paramCommodity.Dqv = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.Dqw = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.phz = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.Dqq = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.wSq = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Promotions();
      ((Promotions)localObject2).type = Dqo;
      ((Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Promotions)localObject2).wSr = ((JSONObject)localObject1).optString("username");
      paramCommodity.Dqr = ((Promotions)localObject2).wSr;
      ((Promotions)localObject2).xcF = ((JSONObject)localObject1).optString("logo_round_url");
      ((Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!bu.isNullOrNil(((Promotions)localObject2).name)) && (!bu.isNullOrNil(((Promotions)localObject2).url)))
      {
        paramCommodity.Dqz.add(localObject2);
        paramCommodity.DqA = true;
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
      ((Promotions)localObject3).type = Dqp;
      ((Promotions)localObject3).xcF = ((JSONObject)localObject2).optString("icon");
      ((Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Promotions)localObject3).Dpr = ((JSONObject)localObject2).optString("btn_text");
      ((Promotions)localObject3).DqM = ((JSONObject)localObject2).optInt("type");
      ((Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Promotions)localObject3).vlr = ((JSONObject)localObject2).optLong("activity_id");
      ((Promotions)localObject3).JhR = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Promotions)localObject3).JhT = ((JSONObject)localObject2).optString("small_title");
      ((Promotions)localObject3).JhS = ((JSONObject)localObject2).optInt("award_id");
      ((Promotions)localObject3).Dpo = ((JSONObject)localObject2).optInt("send_record_id");
      ((Promotions)localObject3).Dpp = ((JSONObject)localObject2).optInt("user_record_id");
      ((Promotions)localObject3).JhU = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Promotions)localObject3).JhV = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Promotions)localObject3).Dpq = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Promotions)localObject3).JhW = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Promotions)localObject3).JhX = ((JSONObject)localObject2).optString("get_award_params");
      ((Promotions)localObject3).JhY = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.Dqz.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.DqB.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.DqB.url = ((JSONObject)localObject1).optString("url");
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
          ((DiscountInfo)localObject3).DqL = ((JSONObject)localObject2).optDouble("payment_amount");
          ((DiscountInfo)localObject3).ynr = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.Dqt.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.Dqx == null) {
        paramCommodity.Dqx = new RecommendTinyAppInfo();
      }
      paramCommodity.Dqx.DfD = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.Dqx.Dpt = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.Dqx.Dpu = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.Dqx.CRv = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.Dqx.CRw = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.Dqx.Dpv = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.Dqx.DqW = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.Dqx.DqX = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.Dqx.DqY = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.Dqx.DqZ = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.Dqx.Dra = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.Dqx.Drb = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.Dqx.Dpw = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.Dqy == null) {
        paramCommodity.Dqy = new RemarksInfo();
      }
      paramCommodity.Dqy.Drc = paramJSONObject.optString("remark_title");
      paramCommodity.Dqy.Drd = paramJSONObject.optString("remark_desc");
    }
    AppMethodBeat.o(70356);
  }
  
  public static void a(Promotions paramPromotions, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70357);
    ae.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.DqV = null;
      AppMethodBeat.o(70357);
      return;
    }
    try
    {
      e.a.a.c localc = new e.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.GxD = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          e.a.a.i locali = new e.a.a.i();
          locali.xcF = localJSONObject.optString("logo");
          locali.OmO = localJSONObject.optString("award_name");
          locali.OmP = localJSONObject.optString("award_description");
          locali.OmQ = localJSONObject.optString("background_img");
          locali.OmS = localJSONObject.optString("award_description_color");
          locali.OmR = localJSONObject.optString("award_name_color");
          localc.GxD.add(locali);
          i += 1;
        }
      }
      localc.Oml = paramJSONObject.optInt("is_query_others", 0);
      localc.Gwa = paramJSONObject.optString("draw_lottery_params");
      localc.GxE = paramJSONObject.optInt("is_show_btn");
      localc.Omp = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.GxF = new e.a.a.a();
        localc.GxF.Omd = ((JSONObject)localObject).optString("btn_words");
        localc.GxF.Ome = ((JSONObject)localObject).optString("btn_color");
        localc.GxF.Omf = ((JSONObject)localObject).optInt("btn_op_type");
        localc.GxF.url = ((JSONObject)localObject).optString("url");
        localc.GxF.GTG = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.GxF.Omg = new e.a.a.g();
          localc.GxF.Omg.Hwe = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.GxF.Omg.Hwf = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.GxF.Omg.Hwg = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.GxC = paramJSONObject.optString("exposure_info_modify_params");
      localc.Omm = paramJSONObject.optInt("user_opertaion_type");
      localc.Omn = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.Omo = new e.a.a.f();
        localc.Omo.OmC = ((JSONObject)localObject).optString("layer_title");
        localc.Omo.OmD = ((JSONObject)localObject).optString("layer_logo");
        localc.Omo.OmE = ((JSONObject)localObject).optString("layer_type");
        localc.Omo.OmF = ((JSONObject)localObject).optString("layer_name");
        localc.Omo.OmG = ((JSONObject)localObject).optString("layer_description");
        localc.Omo.OmH = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!bu.isNullOrNil(((JSONObject)localObject).optString("voice_url"))) {
          localc.Omo.OmJ = new com.tencent.mm.bw.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!bu.isNullOrNil(((JSONObject)localObject).optString("voice_data"))) {
          localc.Omo.Ggu = new com.tencent.mm.bw.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.Omo.OmI = new e();
          localc.Omo.OmI.Omd = ((JSONObject)localObject).optString("btn_words");
          localc.Omo.OmI.Ome = ((JSONObject)localObject).optString("btn_color");
          localc.Omo.OmI.Omf = ((JSONObject)localObject).optInt("btn_op_type");
          localc.Omo.OmI.GTG = ((JSONObject)localObject).optString("get_lottery_params");
          localc.Omo.OmI.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.Omo.OmI.Omg = new e.a.a.g();
            localc.Omo.OmI.Omg.Hwe = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.Omo.OmI.Omg.Hwf = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.Omo.OmI.Omg.Hwg = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      localObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (localObject != null)
      {
        localc.Omq = new e.a.a.b();
        localc.Omq.url = ((JSONObject)localObject).optString("url");
        localc.Omq.Omh = ((JSONObject)localObject).optString("animation_wording");
        localc.Omq.Omi = ((JSONObject)localObject).optString("animation_wording_color");
        localc.Omq.Omj = ((JSONObject)localObject).optString("after_animation_wording");
        localc.Omq.Omk = ((JSONObject)localObject).optString("after_animation_wording_color");
        localc.Omq.HYJ = ((JSONObject)localObject).optInt("op_type");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.Omq.Omg = new e.a.a.g();
          localc.Omq.Omg.Hwe = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.Omq.Omg.Hwf = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.Omq.Omg.Hwg = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("follow_cardbd_mch_info");
      if (paramJSONObject != null)
      {
        localc.Omr = new e.a.a.d();
        localc.Omr.Oms = paramJSONObject.optInt("is_followed_cardbd_mch", 0);
        localc.Omr.Omu = paramJSONObject.optString("follow_logo", "");
        localc.Omr.Omt = paramJSONObject.optString("follow_tips", "");
        localc.Omr.Omv = paramJSONObject.optString("follow_tips_color", "");
        localc.Omr.Omw = paramJSONObject.optLong("follow_tips_size", 0L);
        localc.Omr.Omz = paramJSONObject.optString("follow_logo_after", "");
        localc.Omr.OmB = paramJSONObject.optString("follow_tips_after", "");
        localc.Omr.OmA = paramJSONObject.optString("follow_tips_color_after", "");
        localc.Omr.Gpk = paramJSONObject.optString("follow_param", "");
        localc.Omr.Omx = paramJSONObject.optInt("is_show_pop_up", 0);
        paramJSONObject = paramJSONObject.optJSONObject("pop_up_window_info");
        if (paramJSONObject != null)
        {
          localc.Omr.Omy = new e.a.a.h();
          localc.Omr.Omy.OmK = paramJSONObject.optString("pop_up_title");
          localc.Omr.Omy.OmL = paramJSONObject.optString("pop_up_text");
          localc.Omr.Omy.OmN = paramJSONObject.optString("pop_up_button_text");
          localc.Omr.Omy.OmM = paramJSONObject.optString("pop_up_image_url");
        }
      }
      paramPromotions.DqV = localc;
      AppMethodBeat.o(70357);
      return;
    }
    catch (Exception paramPromotions)
    {
      ae.printErrStackTrace("MicroMsg.Orders", paramPromotions, "parseExposureInfo error: %s", new Object[] { paramPromotions.getMessage() });
      AppMethodBeat.o(70357);
    }
  }
  
  private static void a(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70358);
    if (paramJSONObject != null)
    {
      ae.i("MicroMsg.Orders", "parseDeductInfo json is not null");
      paramOrders.DpU = new DeductInfo();
      paramOrders.DpU.title = paramJSONObject.optString("contract_title");
      paramOrders.DpU.desc = paramJSONObject.optString("contract_desc");
      paramOrders.DpU.DbH = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.DpU.DqC = paramJSONObject.optString("contract_url");
      paramOrders.DpU.DqE = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.DpU.DaV = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.DpU.oGe = paramJSONObject.optString("button_wording", "");
      paramOrders.DpU.DaW = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.DpU.DqF = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.DpU.DqG = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.DpU.DqD = new ArrayList();
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
              localDeductShowInfo.DqH = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.DqI = localJSONObject.optString("link_weapp");
              localDeductShowInfo.DqJ = localJSONObject.optString("link_addr");
              localDeductShowInfo.DqK = localJSONObject.optString("link_url");
            }
            paramOrders.DpU.DqD.add(localDeductShowInfo);
          }
          for (;;)
          {
            i += 1;
            break;
            ae.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i)));
          }
        }
        AppMethodBeat.o(70358);
        return;
      }
      ae.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(j)));
      AppMethodBeat.o(70358);
      return;
    }
    ae.i("MicroMsg.Orders", "parseDeductInfo json is null");
    AppMethodBeat.o(70358);
  }
  
  private static HashSet<String> aFH(String paramString)
  {
    AppMethodBeat.i(70361);
    HashSet localHashSet = new HashSet();
    if (!bu.isNullOrNil(paramString))
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
  
  /* Error */
  public static Orders aY(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 1226
    //   3: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: ifnull +900 -> 910
    //   13: new 2	com/tencent/mm/plugin/wallet_core/model/Orders
    //   16: dup
    //   17: invokespecial 1227	com/tencent/mm/plugin/wallet_core/model/Orders:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 1230	com/tencent/mm/sdk/platformtools/bu:fpO	()J
    //   27: putfield 241	com/tencent/mm/plugin/wallet_core/model/Orders:Dpx	J
    //   30: aload 5
    //   32: aload_0
    //   33: ldc_w 496
    //   36: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: ldc_w 1232
    //   42: iconst_2
    //   43: getstatic 1238	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   46: invokestatic 1243	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   49: putfield 170	com/tencent/mm/plugin/wallet_core/model/Orders:dmz	D
    //   52: aload 5
    //   54: aload_0
    //   55: ldc_w 1245
    //   58: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 168	com/tencent/mm/plugin/wallet_core/model/Orders:fTm	Ljava/lang/String;
    //   64: aload 5
    //   66: aload_0
    //   67: ldc_w 1247
    //   70: iconst_1
    //   71: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: putfield 255	com/tencent/mm/plugin/wallet_core/model/Orders:DgN	I
    //   77: aload 5
    //   79: aload_0
    //   80: ldc_w 518
    //   83: ldc 160
    //   85: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:wSq	Ljava/lang/String;
    //   91: aload 5
    //   93: aload_0
    //   94: ldc_w 1249
    //   97: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: ldc_w 1232
    //   103: iconst_2
    //   104: getstatic 1238	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   107: invokestatic 1243	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   110: putfield 259	com/tencent/mm/plugin/wallet_core/model/Orders:yoj	D
    //   113: aload 5
    //   115: aload_0
    //   116: ldc_w 1251
    //   119: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: ldc_w 1232
    //   125: iconst_2
    //   126: getstatic 1238	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   129: invokestatic 1243	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   132: putfield 172	com/tencent/mm/plugin/wallet_core/model/Orders:Dpy	D
    //   135: aload 5
    //   137: aload_0
    //   138: ldc_w 1253
    //   141: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   144: putfield 261	com/tencent/mm/plugin/wallet_core/model/Orders:Dpz	I
    //   147: aload 5
    //   149: aload_0
    //   150: ldc_w 1255
    //   153: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: putfield 263	com/tencent/mm/plugin/wallet_core/model/Orders:DkG	Ljava/lang/String;
    //   159: aload 5
    //   161: aload_0
    //   162: ldc_w 1257
    //   165: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 265	com/tencent/mm/plugin/wallet_core/model/Orders:DnP	Ljava/lang/String;
    //   171: aload 5
    //   173: aload_0
    //   174: ldc_w 1259
    //   177: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   180: putfield 267	com/tencent/mm/plugin/wallet_core/model/Orders:DpA	I
    //   183: aload 5
    //   185: aload_0
    //   186: ldc_w 1261
    //   189: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: putfield 269	com/tencent/mm/plugin/wallet_core/model/Orders:DpB	Ljava/lang/String;
    //   195: aload_0
    //   196: ldc_w 1263
    //   199: invokevirtual 349	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore 6
    //   204: aload 5
    //   206: aload_0
    //   207: ldc_w 1265
    //   210: invokevirtual 420	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   213: putfield 1267	com/tencent/mm/plugin/wallet_core/model/Orders:DpV	J
    //   216: aload 5
    //   218: aload_0
    //   219: ldc_w 1269
    //   222: invokevirtual 420	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   225: putfield 1271	com/tencent/mm/plugin/wallet_core/model/Orders:DpW	J
    //   228: aload 5
    //   230: aload_0
    //   231: ldc_w 1273
    //   234: iconst_0
    //   235: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   238: putfield 209	com/tencent/mm/plugin/wallet_core/model/Orders:DpX	I
    //   241: aload 5
    //   243: aload_0
    //   244: ldc_w 1275
    //   247: iconst_0
    //   248: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   251: putfield 211	com/tencent/mm/plugin/wallet_core/model/Orders:DpY	I
    //   254: aload_0
    //   255: ldc_w 1277
    //   258: iconst_0
    //   259: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   262: iconst_1
    //   263: if_icmpne +935 -> 1198
    //   266: iconst_1
    //   267: istore_1
    //   268: iload_1
    //   269: ifeq +15 -> 284
    //   272: aload 5
    //   274: new 184	java/util/HashSet
    //   277: dup
    //   278: invokespecial 185	java/util/HashSet:<init>	()V
    //   281: putfield 187	com/tencent/mm/plugin/wallet_core/model/Orders:DpL	Ljava/util/Set;
    //   284: aload 6
    //   286: invokevirtual 354	org/json/JSONArray:length	()I
    //   289: istore_3
    //   290: iconst_0
    //   291: istore_2
    //   292: iload_2
    //   293: iload_3
    //   294: if_icmpge +280 -> 574
    //   297: aload 6
    //   299: iload_2
    //   300: invokevirtual 358	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   303: astore 7
    //   305: new 10	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity
    //   308: dup
    //   309: invokespecial 1278	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:<init>	()V
    //   312: astore 8
    //   314: aload 8
    //   316: aload 7
    //   318: ldc_w 1279
    //   321: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 1280	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:desc	Ljava/lang/String;
    //   327: aload 8
    //   329: aload 7
    //   331: ldc_w 1282
    //   334: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   337: ldc_w 1232
    //   340: iconst_2
    //   341: getstatic 1238	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   344: invokestatic 1243	com/tencent/mm/wallet_core/ui/f:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   347: putfield 509	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:phz	D
    //   350: aload 8
    //   352: new 1284	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 1285	java/lang/StringBuilder:<init>	()V
    //   359: aload 7
    //   361: ldc_w 1287
    //   364: iconst_1
    //   365: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   368: invokevirtual 1291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 1294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: putfield 1297	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSh	Ljava/lang/String;
    //   377: aload 8
    //   379: aload 7
    //   381: ldc_w 455
    //   384: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: putfield 458	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSj	Ljava/lang/String;
    //   390: aload 8
    //   392: aload 7
    //   394: ldc_w 465
    //   397: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 468	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSo	Ljava/lang/String;
    //   403: aload 8
    //   405: aload 7
    //   407: ldc_w 460
    //   410: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: putfield 463	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSk	Ljava/lang/String;
    //   416: aload 8
    //   418: aload 7
    //   420: ldc_w 1299
    //   423: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 1302	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSe	Ljava/lang/String;
    //   429: aload 8
    //   431: aload 7
    //   433: ldc_w 1304
    //   436: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 1307	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSf	Ljava/lang/String;
    //   442: aload 8
    //   444: aload 7
    //   446: ldc_w 1309
    //   449: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   452: putfield 473	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSm	I
    //   455: aload 8
    //   457: aload 7
    //   459: ldc_w 375
    //   462: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 381	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:dmx	Ljava/lang/String;
    //   468: aload 8
    //   470: aload 7
    //   472: ldc_w 518
    //   475: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: putfield 522	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSq	Ljava/lang/String;
    //   481: aload 5
    //   483: getfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:wSq	Ljava/lang/String;
    //   486: invokestatic 554	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   489: ifeq +13 -> 502
    //   492: aload 5
    //   494: aload 8
    //   496: getfield 522	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSq	Ljava/lang/String;
    //   499: putfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:wSq	Ljava/lang/String;
    //   502: aload 8
    //   504: aload 7
    //   506: ldc_w 1311
    //   509: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   512: putfield 1312	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wSr	Ljava/lang/String;
    //   515: aload 8
    //   517: aload 7
    //   519: ldc_w 333
    //   522: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: putfield 1315	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wRU	Ljava/lang/String;
    //   528: aload 5
    //   530: getfield 196	com/tencent/mm/plugin/wallet_core/model/Orders:DpP	Ljava/util/List;
    //   533: aload 8
    //   535: invokeinterface 557 2 0
    //   540: pop
    //   541: iload_1
    //   542: ifne +649 -> 1191
    //   545: aload 5
    //   547: aload 7
    //   549: ldc_w 1317
    //   552: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   555: putfield 290	com/tencent/mm/plugin/wallet_core/model/Orders:DpK	Ljava/lang/String;
    //   558: aload 5
    //   560: aload 5
    //   562: getfield 290	com/tencent/mm/plugin/wallet_core/model/Orders:DpK	Ljava/lang/String;
    //   565: invokestatic 294	com/tencent/mm/plugin/wallet_core/model/Orders:aFH	(Ljava/lang/String;)Ljava/util/HashSet;
    //   568: putfield 187	com/tencent/mm/plugin/wallet_core/model/Orders:DpL	Ljava/util/Set;
    //   571: goto +620 -> 1191
    //   574: aload_0
    //   575: ldc_w 1319
    //   578: invokevirtual 500	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +338 -> 919
    //   584: aload 5
    //   586: aload_0
    //   587: ldc_w 1319
    //   590: invokestatic 1323	com/tencent/mm/wallet_core/ui/f:m	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   593: putfield 174	com/tencent/mm/plugin/wallet_core/model/Orders:DpG	Z
    //   596: aload 5
    //   598: aload_0
    //   599: invokestatic 1327	com/tencent/mm/plugin/wallet_core/model/Orders:bl	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet/a/h;
    //   602: putfield 201	com/tencent/mm/plugin/wallet_core/model/Orders:DpQ	Lcom/tencent/mm/plugin/wallet/a/h;
    //   605: aload_0
    //   606: ldc_w 1329
    //   609: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   612: astore 6
    //   614: aload 6
    //   616: ifnonnull +337 -> 953
    //   619: ldc_w 406
    //   622: ldc_w 1331
    //   625: invokestatic 1199	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 5
    //   630: aload_0
    //   631: ldc_w 1333
    //   634: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   637: putfield 203	com/tencent/mm/plugin/wallet_core/model/Orders:DpR	I
    //   640: aload 5
    //   642: aload_0
    //   643: ldc_w 1335
    //   646: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   649: putfield 205	com/tencent/mm/plugin/wallet_core/model/Orders:DpS	Ljava/lang/String;
    //   652: aload 5
    //   654: aload_0
    //   655: ldc_w 1337
    //   658: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   661: putfield 207	com/tencent/mm/plugin/wallet_core/model/Orders:DpT	Ljava/lang/String;
    //   664: aload 5
    //   666: aload_0
    //   667: ldc_w 1339
    //   670: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   673: invokestatic 1341	com/tencent/mm/plugin/wallet_core/model/Orders:a	(Lcom/tencent/mm/plugin/wallet_core/model/Orders;Lorg/json/JSONObject;)V
    //   676: aload_0
    //   677: ldc_w 1343
    //   680: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   683: astore 6
    //   685: aload 6
    //   687: invokestatic 554	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   690: ifne +42 -> 732
    //   693: aload 6
    //   695: iconst_0
    //   696: invokestatic 1349	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   699: astore 6
    //   701: new 1351	com/tencent/mm/protocal/protobuf/all
    //   704: dup
    //   705: invokespecial 1352	com/tencent/mm/protocal/protobuf/all:<init>	()V
    //   708: aload 6
    //   710: invokevirtual 1356	com/tencent/mm/protocal/protobuf/all:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   713: checkcast 1351	com/tencent/mm/protocal/protobuf/all
    //   716: astore 6
    //   718: aload 5
    //   720: getfield 227	com/tencent/mm/plugin/wallet_core/model/Orders:field_infos	Ljava/util/ArrayList;
    //   723: aload 6
    //   725: getfield 1359	com/tencent/mm/protocal/protobuf/all:field_info	Ljava/util/LinkedList;
    //   728: invokevirtual 1362	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   731: pop
    //   732: aload 5
    //   734: aload_0
    //   735: ldc_w 1364
    //   738: ldc 166
    //   740: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 229	com/tencent/mm/plugin/wallet_core/model/Orders:Dqg	Ljava/lang/String;
    //   746: aload 5
    //   748: aload_0
    //   749: ldc_w 1366
    //   752: ldc 160
    //   754: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   757: putfield 1368	com/tencent/mm/plugin/wallet_core/model/Orders:Dqh	Ljava/lang/String;
    //   760: aload 5
    //   762: aload_0
    //   763: ldc_w 1370
    //   766: ldc 160
    //   768: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   771: putfield 1372	com/tencent/mm/plugin/wallet_core/model/Orders:Dqi	Ljava/lang/String;
    //   774: aload 5
    //   776: aload_0
    //   777: ldc_w 1374
    //   780: ldc 166
    //   782: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 231	com/tencent/mm/plugin/wallet_core/model/Orders:Dqj	Ljava/lang/String;
    //   788: aload 5
    //   790: aload_0
    //   791: ldc_w 1376
    //   794: ldc 160
    //   796: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   799: putfield 1378	com/tencent/mm/plugin/wallet_core/model/Orders:Dqk	Ljava/lang/String;
    //   802: aload 5
    //   804: aload_0
    //   805: ldc_w 1380
    //   808: ldc 160
    //   810: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: putfield 1382	com/tencent/mm/plugin/wallet_core/model/Orders:Dql	Ljava/lang/String;
    //   816: aload 5
    //   818: aload_0
    //   819: ldc_w 1384
    //   822: iconst_0
    //   823: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   826: putfield 1386	com/tencent/mm/plugin/wallet_core/model/Orders:Dqm	I
    //   829: aload_0
    //   830: ldc_w 1329
    //   833: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   836: astore_0
    //   837: aload_0
    //   838: ifnull +72 -> 910
    //   841: aload_0
    //   842: ldc_w 1388
    //   845: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   848: astore_0
    //   849: aload_0
    //   850: ifnull +60 -> 910
    //   853: aload 5
    //   855: new 50	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo
    //   858: dup
    //   859: invokespecial 1389	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:<init>	()V
    //   862: putfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Dqn	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   865: aload 5
    //   867: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Dqn	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   870: aload_0
    //   871: ldc_w 1391
    //   874: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   877: putfield 1394	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:Drk	I
    //   880: aload 5
    //   882: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Dqn	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   885: aload_0
    //   886: ldc_w 1396
    //   889: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   892: putfield 1399	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:dlT	Ljava/lang/String;
    //   895: aload 5
    //   897: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Dqn	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   900: aload_0
    //   901: ldc_w 1401
    //   904: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   907: putfield 1404	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:wRt	Ljava/lang/String;
    //   910: ldc_w 1226
    //   913: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: aload 5
    //   918: areturn
    //   919: aload 5
    //   921: aload 5
    //   923: getfield 255	com/tencent/mm/plugin/wallet_core/model/Orders:DgN	I
    //   926: iconst_2
    //   927: invokestatic 1410	com/tencent/mm/plugin/wallet_core/model/Bankcard:iN	(II)Z
    //   930: putfield 174	com/tencent/mm/plugin/wallet_core/model/Orders:DpG	Z
    //   933: goto -337 -> 596
    //   936: astore_0
    //   937: ldc_w 406
    //   940: aload_0
    //   941: ldc 160
    //   943: iconst_0
    //   944: anewarray 4	java/lang/Object
    //   947: invokestatic 412	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   950: goto -40 -> 910
    //   953: aload 6
    //   955: ldc_w 1412
    //   958: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   961: astore 6
    //   963: aload 6
    //   965: ifnonnull +15 -> 980
    //   968: ldc_w 406
    //   971: ldc_w 1414
    //   974: invokestatic 1199	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -349 -> 628
    //   980: aload 6
    //   982: ldc_w 1416
    //   985: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   988: astore 6
    //   990: aload 6
    //   992: ifnonnull +15 -> 1007
    //   995: ldc_w 406
    //   998: ldc_w 1418
    //   1001: invokestatic 1199	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: goto -376 -> 628
    //   1007: ldc_w 1420
    //   1010: invokestatic 1426	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1013: checkcast 1420	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1016: invokeinterface 1429 1 0
    //   1021: ifne +182 -> 1203
    //   1024: ldc_w 1420
    //   1027: invokestatic 1426	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1030: checkcast 1420	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1033: invokeinterface 1432 1 0
    //   1038: ifeq +170 -> 1208
    //   1041: goto +162 -> 1203
    //   1044: iload_1
    //   1045: ifeq +168 -> 1213
    //   1048: aload 6
    //   1050: ldc_w 1434
    //   1053: iconst_0
    //   1054: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1057: istore_1
    //   1058: aload 5
    //   1060: iload_1
    //   1061: putfield 189	com/tencent/mm/plugin/wallet_core/model/Orders:DpM	I
    //   1064: aload 5
    //   1066: aload 6
    //   1068: ldc_w 1436
    //   1071: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: putfield 191	com/tencent/mm/plugin/wallet_core/model/Orders:DpO	Ljava/lang/String;
    //   1077: aload 6
    //   1079: ldc_w 1438
    //   1082: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1085: astore 7
    //   1087: iconst_1
    //   1088: aload 6
    //   1090: ldc_w 1440
    //   1093: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1096: if_icmpne +122 -> 1218
    //   1099: iconst_1
    //   1100: istore 4
    //   1102: aload 5
    //   1104: aload 7
    //   1106: putfield 311	com/tencent/mm/plugin/wallet_core/model/Orders:trY	Ljava/lang/String;
    //   1109: aload 5
    //   1111: iload 4
    //   1113: putfield 313	com/tencent/mm/plugin/wallet_core/model/Orders:DpN	Z
    //   1116: getstatic 1446	com/tencent/mm/plugin/fingerprint/b/p:tse	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1119: aload 7
    //   1121: putfield 1447	com/tencent/mm/plugin/fingerprint/b/p:trY	Ljava/lang/String;
    //   1124: getstatic 1446	com/tencent/mm/plugin/fingerprint/b/p:tse	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1127: iload 4
    //   1129: putfield 1450	com/tencent/mm/plugin/fingerprint/b/p:tsg	Z
    //   1132: ldc_w 406
    //   1135: ldc_w 1452
    //   1138: iconst_3
    //   1139: anewarray 4	java/lang/Object
    //   1142: dup
    //   1143: iconst_0
    //   1144: aload 5
    //   1146: getfield 189	com/tencent/mm/plugin/wallet_core/model/Orders:DpM	I
    //   1149: invokestatic 1457	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_1
    //   1155: aload 7
    //   1157: aastore
    //   1158: dup
    //   1159: iconst_2
    //   1160: iload 4
    //   1162: invokestatic 1462	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1165: aastore
    //   1166: invokestatic 762	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1169: goto -541 -> 628
    //   1172: astore 6
    //   1174: ldc_w 406
    //   1177: aload 6
    //   1179: ldc 160
    //   1181: iconst_0
    //   1182: anewarray 4	java/lang/Object
    //   1185: invokestatic 412	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private static void b(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70359);
    if (paramJSONObject != null) {
      try
      {
        paramOrders.Dqb = paramJSONObject.optInt("is_use_show_info", 0);
        ae.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.Dqb) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          ae.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.Dqd = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              ShowInfo localShowInfo = new ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.ulS = localJSONObject.optString("name_color");
              localShowInfo.Dre = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.Drf = localJSONObject.optInt("link_type");
                localShowInfo.Drg = localJSONObject.optString("link_weapp");
                localShowInfo.Drh = localJSONObject.optString("link_addr");
                localShowInfo.Dri = localJSONObject.optString("link_url");
                localShowInfo.Drj = localJSONObject.optInt("text_attr");
              }
              if ((!bu.isNullOrNil(localShowInfo.name)) || (!bu.isNullOrNil(localShowInfo.value))) {
                paramOrders.Dqd.add(localShowInfo);
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
        ae.printErrStackTrace("MicroMsg.Orders", paramOrders, "parseShowInfo error", new Object[0]);
      }
    }
    AppMethodBeat.o(70359);
  }
  
  private static com.tencent.mm.plugin.wallet.a.h bl(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70354);
    com.tencent.mm.plugin.wallet.a.h localh = new com.tencent.mm.plugin.wallet.a.h();
    paramJSONObject = paramJSONObject.optJSONObject("favinfo");
    if (paramJSONObject == null)
    {
      ae.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
      AppMethodBeat.o(70354);
      return localh;
    }
    localh.CYC = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localh.CYD = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localh.CYE = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localh.CYF = paramJSONObject.optString("favorComposeId");
    localh.CYI = paramJSONObject.optInt("useNaturalDefense");
    localh.CYJ = paramJSONObject.optString("discountWording");
    localh.CYK = paramJSONObject.optString("favorRuleWording");
    localh.CYL = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localh.CYM = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localh.CYN = paramJSONObject.optInt("isVariableFavor");
    localh.CYO = paramJSONObject.optString("invariableFavorDesc");
    localh.CYP = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new t();
      ((t)localObject2).CZu = ((JSONObject)localObject3).optInt("favType");
      ((t)localObject2).CZv = ((JSONObject)localObject3).optInt("favSubType");
      ((t)localObject2).CZw = ((JSONObject)localObject3).optLong("favProperty");
      ((t)localObject2).CZx = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((t)localObject2).CYz = ((JSONObject)localObject3).optString("favId");
      ((t)localObject2).CZy = ((JSONObject)localObject3).optString("favName");
      ((t)localObject2).CZz = ((JSONObject)localObject3).optString("favDesc");
      ((t)localObject2).CYA = ((JSONObject)localObject3).optString("favorUseManual");
      ((t)localObject2).CYB = ((JSONObject)localObject3).optString("favorRemarks");
      ((t)localObject2).CZA = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((t)localObject2).CZB = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((t)localObject2).CZC = ((JSONObject)localObject3).optInt("needBankPay");
      ((t)localObject2).CZD = ((JSONObject)localObject3).optString("bankNo");
      ((t)localObject2).wSo = ((JSONObject)localObject3).optString("bankName");
      ((t)localObject2).CZE = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((t)localObject2).CZF.add(com.tencent.mm.bw.b.cm(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localh.CYG.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localh.CYH = new com.tencent.mm.plugin.wallet.a.i();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new j();
        ((j)localObject2).CYV = ((JSONObject)localObject3).optString("faovrComposeId");
        ((j)localObject2).CYW = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((j)localObject2).CYE = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((j)localObject2).CYL = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).CYM = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).CYN = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((j)localObject2).CYO = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((j)localObject2).CYP = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.a.f();
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).CYz = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).CYA = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).CYB = ((JSONObject)localObject4).optString("favorRemarks");
          ((j)localObject2).CYX.add(localObject5);
          j += 1;
        }
        localh.CYH.CYT.add(localObject2);
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
          ((com.tencent.mm.plugin.wallet.a.c)localObject4).wRt = ((JSONObject)localObject5).optString("bind_serial");
          localObject5 = ((JSONObject)localObject5).optJSONArray("bind_serial_favor_list");
          if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              com.tencent.mm.plugin.wallet.a.d locald = new com.tencent.mm.plugin.wallet.a.d();
              JSONObject localJSONObject = ((JSONArray)localObject5).optJSONObject(j);
              locald.ynr = localJSONObject.optString("favor_desc");
              locald.CYx = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.a.c)localObject4).CYw.add(locald);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).CYl.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.a.a)localObject1).CYm = new n();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new o();
          ((o)localObject3).ynr = ((JSONArray)localObject2).optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).CYm.CZc.add(localObject3);
          i += 1;
        }
      }
    }
    localh.CYQ = ((com.tencent.mm.plugin.wallet.a.a)localObject1);
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
          ((com.tencent.mm.plugin.wallet.a.g)localObject2).CYp = ((JSONObject)localObject3).optString("default_fav_comb_id");
          localObject3 = ((JSONObject)localObject3).optJSONObject("payment_channel");
          if (localObject3 != null)
          {
            localObject4 = new m();
            ((m)localObject4).wRt = ((JSONObject)localObject3).optString("bind_serial");
            ((m)localObject4).selected = ((JSONObject)localObject3).optInt("selected");
            ((m)localObject4).CZb = ((JSONObject)localObject3).optString("bankCode");
            ((com.tencent.mm.plugin.wallet.a.g)localObject2).CYn = ((m)localObject4);
          }
          localh.CYR.add(localObject2);
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
        ((m)localObject2).CZb = ((JSONObject)localObject3).optString("bankCode");
        ((m)localObject2).selected = ((JSONObject)localObject3).optInt("selected");
        ((m)localObject2).wRt = ((JSONObject)localObject3).optString("bind_serial");
        ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYn = ((m)localObject2);
      }
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYo = paramJSONObject.optInt("is_show_guide");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYp = paramJSONObject.optString("default_fav_comb_id");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYq = paramJSONObject.optString("guide_content");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYr = paramJSONObject.optString("guide_content_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYs = paramJSONObject.optString("guide_btn_text");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYt = paramJSONObject.optString("guide_btn_text_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYu = paramJSONObject.optString("guide_btn_bg_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CYv = paramJSONObject.optString("guide_logo");
      localh.CYS = ((com.tencent.mm.plugin.wallet.a.b)localObject1);
    }
    AppMethodBeat.o(70354);
    return localh;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70360);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reqKey:").append(this.dmw).append("\n");
    ((StringBuilder)localObject).append("token").append(this.token).append("\n");
    ((StringBuilder)localObject).append("num").append(this.fTm).append("\n");
    ((StringBuilder)localObject).append("totalFee").append(this.dmz).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(70360);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70363);
    paramParcel.writeLong(this.Dpx);
    paramParcel.writeString(this.dmw);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.fTm);
    paramParcel.writeDouble(this.dmz);
    paramParcel.writeInt(this.DgN);
    paramParcel.writeString(this.wSq);
    paramParcel.writeDouble(this.yoj);
    paramParcel.writeDouble(this.Dpy);
    paramParcel.writeInt(this.Dpz);
    paramParcel.writeString(this.DkG);
    paramParcel.writeString(this.DnP);
    paramParcel.writeInt(this.DpA);
    paramParcel.writeString(this.DpB);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.wFJ);
    paramParcel.writeString(this.DpC);
    paramParcel.writeString(this.DpD);
    paramParcel.writeString(this.DpE);
    paramParcel.writeInt(this.DpF);
    if (this.DpG)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.DpH);
      paramParcel.writeString(this.qlv);
      paramParcel.writeLong(this.DpI);
      paramParcel.writeString(this.DpJ);
      paramParcel.writeTypedList(this.DpP);
      paramParcel.writeString(this.DpK);
      paramParcel.writeInt(this.DpM);
      paramParcel.writeString(this.DpO);
      paramParcel.writeParcelable(this.DpU, 1);
      paramParcel.writeInt(this.DpX);
      paramParcel.writeInt(this.DpY);
      paramParcel.writeInt(this.Dqc);
      paramParcel.writeString(this.Dqf);
      paramParcel.writeString(this.Dqe);
      paramParcel.writeInt(this.Dqb);
      paramParcel.writeTypedList(this.Dqd);
      paramParcel.writeParcelable(this.Dqn, 1);
      paramParcel.writeString(this.trY);
      if (!this.DpN) {
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
    public int DpF;
    public boolean DqA;
    public Orders.a DqB;
    public double Dqq;
    public String Dqr;
    public String Dqs;
    public List<Orders.DiscountInfo> Dqt;
    public String Dqu;
    public String Dqv;
    public String Dqw;
    public Orders.RecommendTinyAppInfo Dqx;
    public Orders.RemarksInfo Dqy;
    public List<Orders.Promotions> Dqz;
    public String desc;
    public String dmx;
    public double phz;
    public String wRU;
    public String wSc;
    public String wSd;
    public String wSe;
    public String wSf;
    public String wSh;
    public String wSj;
    public String wSk;
    public int wSm;
    public String wSo;
    public String wSq;
    public String wSr;
    public String wSv;
    
    static
    {
      AppMethodBeat.i(70317);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70317);
    }
    
    public Commodity()
    {
      AppMethodBeat.i(70314);
      this.phz = 0.0D;
      this.Dqq = 0.0D;
      this.Dqt = new ArrayList();
      this.Dqx = null;
      this.Dqz = new ArrayList();
      this.DqA = false;
      this.DqB = new Orders.a();
      AppMethodBeat.o(70314);
    }
    
    public Commodity(Parcel paramParcel)
    {
      AppMethodBeat.i(70315);
      this.phz = 0.0D;
      this.Dqq = 0.0D;
      this.Dqt = new ArrayList();
      this.Dqx = null;
      this.Dqz = new ArrayList();
      this.DqA = false;
      this.DqB = new Orders.a();
      this.wSc = paramParcel.readString();
      this.wSd = paramParcel.readString();
      this.wSe = paramParcel.readString();
      this.wSf = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.wSh = paramParcel.readString();
      this.phz = paramParcel.readDouble();
      this.wSj = paramParcel.readString();
      this.wSk = paramParcel.readString();
      this.wSm = paramParcel.readInt();
      this.dmx = paramParcel.readString();
      this.wSo = paramParcel.readString();
      this.wSq = paramParcel.readString();
      this.wSr = paramParcel.readString();
      this.wRU = paramParcel.readString();
      this.Dqs = paramParcel.readString();
      this.wSv = paramParcel.readString();
      paramParcel.readTypedList(this.Dqt, Orders.DiscountInfo.CREATOR);
      this.Dqu = paramParcel.readString();
      this.Dqw = paramParcel.readString();
      this.Dqx = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
      paramParcel.readTypedList(this.Dqz, Orders.Promotions.CREATOR);
      this.Dqy = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.DqA = bool;
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
      paramParcel.writeString(this.wSc);
      paramParcel.writeString(this.wSd);
      paramParcel.writeString(this.wSe);
      paramParcel.writeString(this.wSf);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.wSh);
      paramParcel.writeDouble(this.phz);
      paramParcel.writeString(this.wSj);
      paramParcel.writeString(this.wSk);
      paramParcel.writeInt(this.wSm);
      paramParcel.writeString(this.dmx);
      paramParcel.writeString(this.wSo);
      paramParcel.writeString(this.wSq);
      paramParcel.writeString(this.wSr);
      paramParcel.writeString(this.wRU);
      paramParcel.writeString(this.Dqs);
      paramParcel.writeString(this.wSv);
      paramParcel.writeTypedList(this.Dqt);
      paramParcel.writeString(this.Dqu);
      paramParcel.writeString(this.Dqw);
      paramParcel.writeParcelable(this.Dqx, 0);
      paramParcel.writeTypedList(this.Dqz);
      paramParcel.writeParcelable(this.Dqy, 0);
      if (this.DqA) {
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
    public int DaV;
    public String DaW;
    public int DbH;
    public String DqC;
    public List<Orders.DeductShowInfo> DqD;
    public int DqE;
    public String DqF;
    public String DqG;
    public String desc;
    public String oGe;
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
      this.DqD = new ArrayList();
      AppMethodBeat.o(70319);
    }
    
    public DeductInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70320);
      this.DqD = new ArrayList();
      this.title = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.DbH = paramParcel.readInt();
      this.DqC = paramParcel.readString();
      this.DqE = paramParcel.readInt();
      paramParcel.readTypedList(this.DqD, Orders.DeductShowInfo.CREATOR);
      this.DaV = paramParcel.readInt();
      this.oGe = paramParcel.readString();
      this.DaW = paramParcel.readString();
      this.DqF = paramParcel.readString();
      this.DqG = paramParcel.readString();
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
      paramParcel.writeInt(this.DbH);
      paramParcel.writeString(this.DqC);
      paramParcel.writeInt(this.DqE);
      paramParcel.writeTypedList(this.DqD);
      paramParcel.writeInt(this.DaV);
      paramParcel.writeString(this.oGe);
      paramParcel.writeString(this.DaW);
      paramParcel.writeString(this.DqF);
      paramParcel.writeString(this.DqG);
      AppMethodBeat.o(70321);
    }
  }
  
  public static class DeductShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DeductShowInfo> CREATOR;
    public int DqH;
    public String DqI;
    public String DqJ;
    public String DqK;
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
      this.DqH = paramParcel.readInt();
      this.DqI = paramParcel.readString();
      this.DqJ = paramParcel.readString();
      this.DqK = paramParcel.readString();
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
      paramParcel.writeInt(this.DqH);
      paramParcel.writeString(this.DqI);
      paramParcel.writeString(this.DqJ);
      paramParcel.writeString(this.DqK);
      AppMethodBeat.o(70325);
    }
  }
  
  public static class DiscountInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DiscountInfo> CREATOR;
    public double DqL;
    public String ynr;
    
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
      this.DqL = paramParcel.readDouble();
      this.ynr = paramParcel.readString();
      AppMethodBeat.o(70328);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70329);
      paramParcel.writeDouble(this.DqL);
      paramParcel.writeString(this.ynr);
      AppMethodBeat.o(70329);
    }
  }
  
  public static class Promotions
    implements Parcelable
  {
    public static final Parcelable.Creator<Promotions> CREATOR;
    public int Dpo;
    public int Dpp;
    public long Dpq;
    public String Dpr;
    public int DqM;
    public e.a.a.c DqV;
    public int JhR;
    public int JhS;
    public String JhT;
    public String JhU;
    public String JhV;
    public int JhW;
    public String JhX;
    public String JhY;
    public String name;
    public String title;
    public int type;
    public String url;
    public long vlr;
    public String wSr;
    public String xcF;
    
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
      this.xcF = paramParcel.readString();
      this.name = paramParcel.readString();
      this.Dpr = paramParcel.readString();
      this.url = paramParcel.readString();
      this.wSr = paramParcel.readString();
      this.title = paramParcel.readString();
      this.DqM = paramParcel.readInt();
      this.vlr = paramParcel.readLong();
      this.JhR = paramParcel.readInt();
      this.JhS = paramParcel.readInt();
      this.Dpo = paramParcel.readInt();
      this.Dpp = paramParcel.readInt();
      this.JhT = paramParcel.readString();
      this.JhU = paramParcel.readString();
      this.JhV = paramParcel.readString();
      this.Dpq = paramParcel.readLong();
      this.JhW = paramParcel.readInt();
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
      paramParcel.writeString(this.xcF);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.Dpr);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.wSr);
      paramParcel.writeString(this.title);
      paramParcel.writeInt(this.DqM);
      paramParcel.writeLong(this.vlr);
      paramParcel.writeInt(this.JhR);
      paramParcel.writeInt(this.JhS);
      paramParcel.writeInt(this.Dpo);
      paramParcel.writeInt(this.Dpp);
      paramParcel.writeString(this.JhT);
      paramParcel.writeString(this.JhU);
      paramParcel.writeString(this.JhV);
      paramParcel.writeLong(this.Dpq);
      paramParcel.writeInt(this.JhW);
      AppMethodBeat.o(70333);
    }
  }
  
  public static class RecommendTinyAppInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR;
    public String CRv;
    public String CRw;
    public String DfD;
    public String Dpt;
    public String Dpu;
    public String Dpv;
    public int Dpw;
    public long DqW;
    public long DqX;
    public long DqY;
    public int DqZ;
    public int Dra;
    public long Drb;
    
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
      this.DfD = paramParcel.readString();
      this.Dpt = paramParcel.readString();
      this.Dpu = paramParcel.readString();
      this.CRv = paramParcel.readString();
      this.CRw = paramParcel.readString();
      this.Dpw = paramParcel.readInt();
      AppMethodBeat.o(70336);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70337);
      paramParcel.writeString(this.DfD);
      paramParcel.writeString(this.Dpt);
      paramParcel.writeString(this.Dpu);
      paramParcel.writeString(this.CRv);
      paramParcel.writeString(this.CRw);
      paramParcel.writeInt(this.Dpw);
      AppMethodBeat.o(70337);
    }
  }
  
  public static class RemarksInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RemarksInfo> CREATOR;
    public String Drc;
    public String Drd;
    
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
      this.Drc = paramParcel.readString();
      this.Drd = paramParcel.readString();
      AppMethodBeat.o(70340);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70341);
      paramParcel.writeString(this.Drc);
      paramParcel.writeString(this.Drd);
      AppMethodBeat.o(70341);
    }
  }
  
  public static class ShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ShowInfo> CREATOR;
    public String Dre;
    public int Drf;
    public String Drg;
    public String Drh;
    public String Dri;
    public int Drj;
    public String name;
    public String ulS;
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
      this.ulS = paramParcel.readString();
      this.Dre = paramParcel.readString();
      this.Drf = paramParcel.readInt();
      this.Drg = paramParcel.readString();
      this.Drh = paramParcel.readString();
      this.Dri = paramParcel.readString();
      this.Drj = paramParcel.readInt();
      AppMethodBeat.o(70344);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(70345);
      String str = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.ulS, this.Dre, Integer.valueOf(this.Drf), this.Drg, this.Drh, this.Dri, Integer.valueOf(this.Drj) });
      AppMethodBeat.o(70345);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70346);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.ulS);
      paramParcel.writeString(this.Dre);
      paramParcel.writeInt(this.Drf);
      paramParcel.writeString(this.Drg);
      paramParcel.writeString(this.Drh);
      paramParcel.writeString(this.Dri);
      paramParcel.writeInt(this.Drj);
      AppMethodBeat.o(70346);
    }
  }
  
  public static class SimpleCashierInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleCashierInfo> CREATOR;
    public int Drk;
    public String dlT;
    public String wRt;
    
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
      this.Drk = paramParcel.readInt();
      this.dlT = paramParcel.readString();
      this.wRt = paramParcel.readString();
      AppMethodBeat.o(70349);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70350);
      paramParcel.writeInt(this.Drk);
      paramParcel.writeString(this.dlT);
      paramParcel.writeString(this.wRt);
      AppMethodBeat.o(70350);
    }
  }
  
  public static final class a
  {
    public String text = "";
    public String url = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders
 * JD-Core Version:    0.7.0.1
 */