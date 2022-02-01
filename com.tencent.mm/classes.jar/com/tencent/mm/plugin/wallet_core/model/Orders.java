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
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static int CYJ;
  public static int CYK;
  public int CPj;
  public String CTa;
  public String CWk;
  public long CXS;
  public double CXT;
  public int CXU;
  public int CXV;
  public String CXW;
  public String CXX;
  public String CXY;
  public String CXZ;
  public String CYA;
  public String CYB;
  public String CYC;
  public String CYD;
  public String CYE;
  public String CYF;
  public String CYG;
  public int CYH;
  public SimpleCashierInfo CYI;
  public int CYa;
  public boolean CYb;
  public String CYc;
  public long CYd;
  public String CYe;
  public String CYf;
  public Set<String> CYg;
  public int CYh;
  public boolean CYi;
  public String CYj;
  public List<Commodity> CYk;
  public com.tencent.mm.plugin.wallet.a.h CYl;
  public int CYm;
  public String CYn;
  public String CYo;
  public DeductInfo CYp;
  public long CYq;
  public long CYr;
  public int CYs;
  public int CYt;
  public int CYu;
  public String CYv;
  public int CYw;
  public int CYx;
  public ArrayList<ShowInfo> CYy;
  public String CYz;
  public String dlu;
  public double dlx;
  public String fRg;
  public ArrayList<dlu> field_infos;
  public String nickname;
  public String qeQ;
  public String thf;
  public String token;
  public String username;
  public String wCF;
  public String wqa;
  public double xYr;
  
  static
  {
    AppMethodBeat.i(70364);
    CREATOR = new Parcelable.Creator() {};
    CYJ = 0;
    CYK = 1;
    AppMethodBeat.o(70364);
  }
  
  public Orders()
  {
    AppMethodBeat.i(70352);
    this.dlu = "";
    this.token = "";
    this.fRg = "0";
    this.dlx = 0.0D;
    this.CXT = 0.0D;
    this.CYb = false;
    this.CYc = "";
    this.qeQ = "";
    this.CYd = 0L;
    this.CYe = "";
    this.CYg = new HashSet();
    this.CYh = 0;
    this.CYj = "";
    this.CYk = new ArrayList();
    this.CYl = new com.tencent.mm.plugin.wallet.a.h();
    this.CYm = 0;
    this.CYn = "";
    this.CYo = "";
    this.CYs = 0;
    this.CYt = 0;
    this.CYu = 0;
    this.CYv = "";
    this.CYw = 0;
    this.CYx = 0;
    this.CYy = new ArrayList();
    this.CYz = "";
    this.CYA = "";
    this.field_infos = new ArrayList();
    this.CYB = "";
    this.CYE = "";
    AppMethodBeat.o(70352);
  }
  
  public Orders(Parcel paramParcel)
  {
    AppMethodBeat.i(70362);
    this.dlu = "";
    this.token = "";
    this.fRg = "0";
    this.dlx = 0.0D;
    this.CXT = 0.0D;
    this.CYb = false;
    this.CYc = "";
    this.qeQ = "";
    this.CYd = 0L;
    this.CYe = "";
    this.CYg = new HashSet();
    this.CYh = 0;
    this.CYj = "";
    this.CYk = new ArrayList();
    this.CYl = new com.tencent.mm.plugin.wallet.a.h();
    this.CYm = 0;
    this.CYn = "";
    this.CYo = "";
    this.CYs = 0;
    this.CYt = 0;
    this.CYu = 0;
    this.CYv = "";
    this.CYw = 0;
    this.CYx = 0;
    this.CYy = new ArrayList();
    this.CYz = "";
    this.CYA = "";
    this.field_infos = new ArrayList();
    this.CYB = "";
    this.CYE = "";
    this.CXS = paramParcel.readLong();
    this.dlu = paramParcel.readString();
    this.token = paramParcel.readString();
    this.fRg = paramParcel.readString();
    this.dlx = paramParcel.readDouble();
    this.CPj = paramParcel.readInt();
    this.wCF = paramParcel.readString();
    this.xYr = paramParcel.readDouble();
    this.CXT = paramParcel.readDouble();
    this.CXU = paramParcel.readInt();
    this.CTa = paramParcel.readString();
    this.CWk = paramParcel.readString();
    this.CXV = paramParcel.readInt();
    this.CXW = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.wqa = paramParcel.readString();
    this.CXX = paramParcel.readString();
    this.CXY = paramParcel.readString();
    this.CXZ = paramParcel.readString();
    this.CYa = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.CYb = bool1;
      this.CYc = paramParcel.readString();
      this.qeQ = paramParcel.readString();
      this.CYd = paramParcel.readLong();
      this.CYe = paramParcel.readString();
      paramParcel.readTypedList(this.CYk, Commodity.CREATOR);
      this.CYf = paramParcel.readString();
      this.CYg = aEn(this.CYf);
      this.CYh = paramParcel.readInt();
      this.CYj = paramParcel.readString();
      this.CYp = ((DeductInfo)paramParcel.readParcelable(DeductInfo.class.getClassLoader()));
      this.CYs = paramParcel.readInt();
      this.CYt = paramParcel.readInt();
      this.CYx = paramParcel.readInt();
      this.CYA = paramParcel.readString();
      this.CYz = paramParcel.readString();
      this.CYw = paramParcel.readInt();
      paramParcel.readTypedList(this.CYy, ShowInfo.CREATOR);
      this.CYI = ((SimpleCashierInfo)paramParcel.readParcelable(SimpleCashierInfo.class.getClassLoader()));
      this.thf = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label591;
      }
    }
    label591:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.CYi = bool1;
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
          paramOrders.CXY = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.CXZ = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.CYa = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.qeQ = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.CYa;
        localObject1 = paramOrders.CYk;
        paramOrders.CYc = paramJSONObject.optString("pay_result_tips");
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
            ((Commodity)localObject2).CYU = new ArrayList();
            ((Commodity)localObject2).CYO = new ArrayList();
            ((Commodity)localObject2).dlv = localJSONObject.getString("transaction_id");
            a((Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Commodity localCommodity = (Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.dlv))) {
                continue;
              }
              a(localCommodity, localJSONObject, j);
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.Orders", paramJSONObject, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(70355);
        return paramOrders;
        localObject1 = paramJSONObject.optJSONObject("extinfo");
        if (localObject1 != null)
        {
          paramOrders.CYd = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
          paramOrders.CYe = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
        }
        paramOrders.CYu = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
        paramOrders.CYv = paramJSONObject.optString("pay_succ_btn_wording");
        paramOrders.CYx = paramJSONObject.optInt("is_jsapi_close_page");
        paramOrders.CYz = paramJSONObject.optString("jsapi_tinyapp_username");
        paramOrders.CYA = paramJSONObject.optString("jsapi_tinyapp_path");
        b(paramOrders, paramJSONObject);
        continue;
        ad.w("MicroMsg.Orders", "oldOrders is null");
      }
      i += 1;
    }
  }
  
  private static void a(Commodity paramCommodity, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(70356);
    paramCommodity.wCK = paramJSONObject.optString("discount");
    paramCommodity.wCy = paramJSONObject.getString("pay_status");
    paramCommodity.wCz = paramJSONObject.getString("pay_status_name");
    paramCommodity.wCD = paramJSONObject.optString("buy_bank_name");
    paramCommodity.wCB = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.CYN = paramJSONObject.optString("card_tail");
    paramCommodity.CYa = paramInt;
    paramCommodity.CYP = paramJSONObject.optString("rateinfo");
    paramCommodity.CYQ = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.CYR = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.paV = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.CYL = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.wCF = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Promotions();
      ((Promotions)localObject2).type = CYJ;
      ((Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Promotions)localObject2).wCG = ((JSONObject)localObject1).optString("username");
      paramCommodity.CYM = ((Promotions)localObject2).wCG;
      ((Promotions)localObject2).wMR = ((JSONObject)localObject1).optString("logo_round_url");
      ((Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!bt.isNullOrNil(((Promotions)localObject2).name)) && (!bt.isNullOrNil(((Promotions)localObject2).url)))
      {
        paramCommodity.CYU.add(localObject2);
        paramCommodity.CYV = true;
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
      ((Promotions)localObject3).type = CYK;
      ((Promotions)localObject3).wMR = ((JSONObject)localObject2).optString("icon");
      ((Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Promotions)localObject3).CXM = ((JSONObject)localObject2).optString("btn_text");
      ((Promotions)localObject3).CZh = ((JSONObject)localObject2).optInt("type");
      ((Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Promotions)localObject3).COR = ((JSONObject)localObject2).optLong("activity_id");
      ((Promotions)localObject3).OdM = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Promotions)localObject3).OdO = ((JSONObject)localObject2).optString("small_title");
      ((Promotions)localObject3).OdN = ((JSONObject)localObject2).optInt("award_id");
      ((Promotions)localObject3).CXJ = ((JSONObject)localObject2).optInt("send_record_id");
      ((Promotions)localObject3).CXK = ((JSONObject)localObject2).optInt("user_record_id");
      ((Promotions)localObject3).OdP = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Promotions)localObject3).OdQ = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Promotions)localObject3).CXL = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Promotions)localObject3).OdR = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Promotions)localObject3).OdS = ((JSONObject)localObject2).optString("get_award_params");
      ((Promotions)localObject3).OdT = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.CYU.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.CYW.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.CYW.url = ((JSONObject)localObject1).optString("url");
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
          ((DiscountInfo)localObject3).CZg = ((JSONObject)localObject2).optDouble("payment_amount");
          ((DiscountInfo)localObject3).xXz = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.CYO.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.CYS == null) {
        paramCommodity.CYS = new RecommendTinyAppInfo();
      }
      paramCommodity.CYS.CNV = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.CYS.CXO = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.CYS.CXP = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.CYS.CzQ = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.CYS.CzR = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.CYS.CXQ = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.CYS.CZr = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.CYS.CZs = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.CYS.CZt = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.CYS.CZu = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.CYS.CZv = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.CYS.CZw = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.CYS.CXR = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.CYT == null) {
        paramCommodity.CYT = new RemarksInfo();
      }
      paramCommodity.CYT.CZx = paramJSONObject.optString("remark_title");
      paramCommodity.CYT.CZy = paramJSONObject.optString("remark_desc");
    }
    AppMethodBeat.o(70356);
  }
  
  public static void a(Promotions paramPromotions, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70357);
    ad.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.CZq = null;
      AppMethodBeat.o(70357);
      return;
    }
    try
    {
      e.a.a.c localc = new e.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.GeV = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          e.a.a.i locali = new e.a.a.i();
          locali.wMR = localJSONObject.optString("logo");
          locali.NPI = localJSONObject.optString("award_name");
          locali.NPJ = localJSONObject.optString("award_description");
          locali.NPK = localJSONObject.optString("background_img");
          locali.NPM = localJSONObject.optString("award_description_color");
          locali.NPL = localJSONObject.optString("award_name_color");
          localc.GeV.add(locali);
          i += 1;
        }
      }
      localc.NPf = paramJSONObject.optInt("is_query_others", 0);
      localc.Gdt = paramJSONObject.optString("draw_lottery_params");
      localc.GeW = paramJSONObject.optInt("is_show_btn");
      localc.NPj = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.GeX = new e.a.a.a();
        localc.GeX.NOX = ((JSONObject)localObject).optString("btn_words");
        localc.GeX.NOY = ((JSONObject)localObject).optString("btn_color");
        localc.GeX.NOZ = ((JSONObject)localObject).optInt("btn_op_type");
        localc.GeX.url = ((JSONObject)localObject).optString("url");
        localc.GeX.GAg = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.GeX.NPa = new e.a.a.g();
          localc.GeX.NPa.HcE = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.GeX.NPa.HcF = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.GeX.NPa.HcG = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.GeU = paramJSONObject.optString("exposure_info_modify_params");
      localc.NPg = paramJSONObject.optInt("user_opertaion_type");
      localc.NPh = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.NPi = new e.a.a.f();
        localc.NPi.NPw = ((JSONObject)localObject).optString("layer_title");
        localc.NPi.NPx = ((JSONObject)localObject).optString("layer_logo");
        localc.NPi.NPy = ((JSONObject)localObject).optString("layer_type");
        localc.NPi.NPz = ((JSONObject)localObject).optString("layer_name");
        localc.NPi.NPA = ((JSONObject)localObject).optString("layer_description");
        localc.NPi.NPB = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!bt.isNullOrNil(((JSONObject)localObject).optString("voice_url"))) {
          localc.NPi.NPD = new com.tencent.mm.bx.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!bt.isNullOrNil(((JSONObject)localObject).optString("voice_data"))) {
          localc.NPi.FNV = new com.tencent.mm.bx.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.NPi.NPC = new e();
          localc.NPi.NPC.NOX = ((JSONObject)localObject).optString("btn_words");
          localc.NPi.NPC.NOY = ((JSONObject)localObject).optString("btn_color");
          localc.NPi.NPC.NOZ = ((JSONObject)localObject).optInt("btn_op_type");
          localc.NPi.NPC.GAg = ((JSONObject)localObject).optString("get_lottery_params");
          localc.NPi.NPC.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.NPi.NPC.NPa = new e.a.a.g();
            localc.NPi.NPC.NPa.HcE = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.NPi.NPC.NPa.HcF = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.NPi.NPC.NPa.HcG = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      localObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (localObject != null)
      {
        localc.NPk = new e.a.a.b();
        localc.NPk.url = ((JSONObject)localObject).optString("url");
        localc.NPk.NPb = ((JSONObject)localObject).optString("animation_wording");
        localc.NPk.NPc = ((JSONObject)localObject).optString("animation_wording_color");
        localc.NPk.NPd = ((JSONObject)localObject).optString("after_animation_wording");
        localc.NPk.NPe = ((JSONObject)localObject).optString("after_animation_wording_color");
        localc.NPk.HEW = ((JSONObject)localObject).optInt("op_type");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.NPk.NPa = new e.a.a.g();
          localc.NPk.NPa.HcE = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.NPk.NPa.HcF = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.NPk.NPa.HcG = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("follow_cardbd_mch_info");
      if (paramJSONObject != null)
      {
        localc.NPl = new e.a.a.d();
        localc.NPl.NPm = paramJSONObject.optInt("is_followed_cardbd_mch", 0);
        localc.NPl.NPo = paramJSONObject.optString("follow_logo", "");
        localc.NPl.NPn = paramJSONObject.optString("follow_tips", "");
        localc.NPl.NPp = paramJSONObject.optString("follow_tips_color", "");
        localc.NPl.NPq = paramJSONObject.optLong("follow_tips_size", 0L);
        localc.NPl.NPt = paramJSONObject.optString("follow_logo_after", "");
        localc.NPl.NPv = paramJSONObject.optString("follow_tips_after", "");
        localc.NPl.NPu = paramJSONObject.optString("follow_tips_color_after", "");
        localc.NPl.FWL = paramJSONObject.optString("follow_param", "");
        localc.NPl.NPr = paramJSONObject.optInt("is_show_pop_up", 0);
        paramJSONObject = paramJSONObject.optJSONObject("pop_up_window_info");
        if (paramJSONObject != null)
        {
          localc.NPl.NPs = new e.a.a.h();
          localc.NPl.NPs.NPE = paramJSONObject.optString("pop_up_title");
          localc.NPl.NPs.NPF = paramJSONObject.optString("pop_up_text");
          localc.NPl.NPs.NPH = paramJSONObject.optString("pop_up_button_text");
          localc.NPl.NPs.NPG = paramJSONObject.optString("pop_up_image_url");
        }
      }
      paramPromotions.CZq = localc;
      AppMethodBeat.o(70357);
      return;
    }
    catch (Exception paramPromotions)
    {
      ad.printErrStackTrace("MicroMsg.Orders", paramPromotions, "parseExposureInfo error: %s", new Object[] { paramPromotions.getMessage() });
      AppMethodBeat.o(70357);
    }
  }
  
  private static void a(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70358);
    if (paramJSONObject != null)
    {
      ad.i("MicroMsg.Orders", "parseDeductInfo json is not null");
      paramOrders.CYp = new DeductInfo();
      paramOrders.CYp.title = paramJSONObject.optString("contract_title");
      paramOrders.CYp.desc = paramJSONObject.optString("contract_desc");
      paramOrders.CYp.CKb = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.CYp.CYX = paramJSONObject.optString("contract_url");
      paramOrders.CYp.CYZ = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.CYp.CJp = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.CYp.ozC = paramJSONObject.optString("button_wording", "");
      paramOrders.CYp.CJq = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.CYp.CZa = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.CYp.CZb = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.CYp.CYY = new ArrayList();
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
              localDeductShowInfo.CZc = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.CZd = localJSONObject.optString("link_weapp");
              localDeductShowInfo.CZe = localJSONObject.optString("link_addr");
              localDeductShowInfo.CZf = localJSONObject.optString("link_url");
            }
            paramOrders.CYp.CYY.add(localDeductShowInfo);
          }
          for (;;)
          {
            i += 1;
            break;
            ad.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i)));
          }
        }
        AppMethodBeat.o(70358);
        return;
      }
      ad.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(j)));
      AppMethodBeat.o(70358);
      return;
    }
    ad.i("MicroMsg.Orders", "parseDeductInfo json is null");
    AppMethodBeat.o(70358);
  }
  
  private static HashSet<String> aEn(String paramString)
  {
    AppMethodBeat.i(70361);
    HashSet localHashSet = new HashSet();
    if (!bt.isNullOrNil(paramString))
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
    //   24: invokestatic 1230	com/tencent/mm/sdk/platformtools/bt:flT	()J
    //   27: putfield 241	com/tencent/mm/plugin/wallet_core/model/Orders:CXS	J
    //   30: aload 5
    //   32: aload_0
    //   33: ldc_w 496
    //   36: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: ldc_w 1232
    //   42: iconst_2
    //   43: getstatic 1238	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   46: invokestatic 1243	com/tencent/mm/wallet_core/ui/e:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   49: putfield 170	com/tencent/mm/plugin/wallet_core/model/Orders:dlx	D
    //   52: aload 5
    //   54: aload_0
    //   55: ldc_w 1245
    //   58: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 168	com/tencent/mm/plugin/wallet_core/model/Orders:fRg	Ljava/lang/String;
    //   64: aload 5
    //   66: aload_0
    //   67: ldc_w 1247
    //   70: iconst_1
    //   71: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: putfield 255	com/tencent/mm/plugin/wallet_core/model/Orders:CPj	I
    //   77: aload 5
    //   79: aload_0
    //   80: ldc_w 518
    //   83: ldc 160
    //   85: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:wCF	Ljava/lang/String;
    //   91: aload 5
    //   93: aload_0
    //   94: ldc_w 1249
    //   97: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: ldc_w 1232
    //   103: iconst_2
    //   104: getstatic 1238	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   107: invokestatic 1243	com/tencent/mm/wallet_core/ui/e:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   110: putfield 259	com/tencent/mm/plugin/wallet_core/model/Orders:xYr	D
    //   113: aload 5
    //   115: aload_0
    //   116: ldc_w 1251
    //   119: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: ldc_w 1232
    //   125: iconst_2
    //   126: getstatic 1238	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   129: invokestatic 1243	com/tencent/mm/wallet_core/ui/e:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   132: putfield 172	com/tencent/mm/plugin/wallet_core/model/Orders:CXT	D
    //   135: aload 5
    //   137: aload_0
    //   138: ldc_w 1253
    //   141: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   144: putfield 261	com/tencent/mm/plugin/wallet_core/model/Orders:CXU	I
    //   147: aload 5
    //   149: aload_0
    //   150: ldc_w 1255
    //   153: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: putfield 263	com/tencent/mm/plugin/wallet_core/model/Orders:CTa	Ljava/lang/String;
    //   159: aload 5
    //   161: aload_0
    //   162: ldc_w 1257
    //   165: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 265	com/tencent/mm/plugin/wallet_core/model/Orders:CWk	Ljava/lang/String;
    //   171: aload 5
    //   173: aload_0
    //   174: ldc_w 1259
    //   177: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   180: putfield 267	com/tencent/mm/plugin/wallet_core/model/Orders:CXV	I
    //   183: aload 5
    //   185: aload_0
    //   186: ldc_w 1261
    //   189: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: putfield 269	com/tencent/mm/plugin/wallet_core/model/Orders:CXW	Ljava/lang/String;
    //   195: aload_0
    //   196: ldc_w 1263
    //   199: invokevirtual 349	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore 6
    //   204: aload 5
    //   206: aload_0
    //   207: ldc_w 1265
    //   210: invokevirtual 420	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   213: putfield 1267	com/tencent/mm/plugin/wallet_core/model/Orders:CYq	J
    //   216: aload 5
    //   218: aload_0
    //   219: ldc_w 1269
    //   222: invokevirtual 420	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   225: putfield 1271	com/tencent/mm/plugin/wallet_core/model/Orders:CYr	J
    //   228: aload 5
    //   230: aload_0
    //   231: ldc_w 1273
    //   234: iconst_0
    //   235: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   238: putfield 209	com/tencent/mm/plugin/wallet_core/model/Orders:CYs	I
    //   241: aload 5
    //   243: aload_0
    //   244: ldc_w 1275
    //   247: iconst_0
    //   248: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   251: putfield 211	com/tencent/mm/plugin/wallet_core/model/Orders:CYt	I
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
    //   281: putfield 187	com/tencent/mm/plugin/wallet_core/model/Orders:CYg	Ljava/util/Set;
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
    //   344: invokestatic 1243	com/tencent/mm/wallet_core/ui/e:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   347: putfield 509	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:paV	D
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
    //   374: putfield 1297	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCw	Ljava/lang/String;
    //   377: aload 8
    //   379: aload 7
    //   381: ldc_w 455
    //   384: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: putfield 458	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCy	Ljava/lang/String;
    //   390: aload 8
    //   392: aload 7
    //   394: ldc_w 465
    //   397: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 468	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCD	Ljava/lang/String;
    //   403: aload 8
    //   405: aload 7
    //   407: ldc_w 460
    //   410: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: putfield 463	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCz	Ljava/lang/String;
    //   416: aload 8
    //   418: aload 7
    //   420: ldc_w 1299
    //   423: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 1302	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCt	Ljava/lang/String;
    //   429: aload 8
    //   431: aload 7
    //   433: ldc_w 1304
    //   436: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 1307	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCu	Ljava/lang/String;
    //   442: aload 8
    //   444: aload 7
    //   446: ldc_w 1309
    //   449: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   452: putfield 473	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCB	I
    //   455: aload 8
    //   457: aload 7
    //   459: ldc_w 375
    //   462: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 381	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:dlv	Ljava/lang/String;
    //   468: aload 8
    //   470: aload 7
    //   472: ldc_w 518
    //   475: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: putfield 522	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCF	Ljava/lang/String;
    //   481: aload 5
    //   483: getfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:wCF	Ljava/lang/String;
    //   486: invokestatic 554	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   489: ifeq +13 -> 502
    //   492: aload 5
    //   494: aload 8
    //   496: getfield 522	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCF	Ljava/lang/String;
    //   499: putfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:wCF	Ljava/lang/String;
    //   502: aload 8
    //   504: aload 7
    //   506: ldc_w 1311
    //   509: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   512: putfield 1312	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCG	Ljava/lang/String;
    //   515: aload 8
    //   517: aload 7
    //   519: ldc_w 333
    //   522: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: putfield 1315	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wCj	Ljava/lang/String;
    //   528: aload 5
    //   530: getfield 196	com/tencent/mm/plugin/wallet_core/model/Orders:CYk	Ljava/util/List;
    //   533: aload 8
    //   535: invokeinterface 557 2 0
    //   540: pop
    //   541: iload_1
    //   542: ifne +649 -> 1191
    //   545: aload 5
    //   547: aload 7
    //   549: ldc_w 1317
    //   552: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   555: putfield 290	com/tencent/mm/plugin/wallet_core/model/Orders:CYf	Ljava/lang/String;
    //   558: aload 5
    //   560: aload 5
    //   562: getfield 290	com/tencent/mm/plugin/wallet_core/model/Orders:CYf	Ljava/lang/String;
    //   565: invokestatic 294	com/tencent/mm/plugin/wallet_core/model/Orders:aEn	(Ljava/lang/String;)Ljava/util/HashSet;
    //   568: putfield 187	com/tencent/mm/plugin/wallet_core/model/Orders:CYg	Ljava/util/Set;
    //   571: goto +620 -> 1191
    //   574: aload_0
    //   575: ldc_w 1319
    //   578: invokevirtual 500	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +338 -> 919
    //   584: aload 5
    //   586: aload_0
    //   587: ldc_w 1319
    //   590: invokestatic 1323	com/tencent/mm/wallet_core/ui/e:m	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   593: putfield 174	com/tencent/mm/plugin/wallet_core/model/Orders:CYb	Z
    //   596: aload 5
    //   598: aload_0
    //   599: invokestatic 1327	com/tencent/mm/plugin/wallet_core/model/Orders:bl	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet/a/h;
    //   602: putfield 201	com/tencent/mm/plugin/wallet_core/model/Orders:CYl	Lcom/tencent/mm/plugin/wallet/a/h;
    //   605: aload_0
    //   606: ldc_w 1329
    //   609: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   612: astore 6
    //   614: aload 6
    //   616: ifnonnull +337 -> 953
    //   619: ldc_w 406
    //   622: ldc_w 1331
    //   625: invokestatic 1199	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 5
    //   630: aload_0
    //   631: ldc_w 1333
    //   634: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   637: putfield 203	com/tencent/mm/plugin/wallet_core/model/Orders:CYm	I
    //   640: aload 5
    //   642: aload_0
    //   643: ldc_w 1335
    //   646: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   649: putfield 205	com/tencent/mm/plugin/wallet_core/model/Orders:CYn	Ljava/lang/String;
    //   652: aload 5
    //   654: aload_0
    //   655: ldc_w 1337
    //   658: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   661: putfield 207	com/tencent/mm/plugin/wallet_core/model/Orders:CYo	Ljava/lang/String;
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
    //   687: invokestatic 554	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   690: ifne +42 -> 732
    //   693: aload 6
    //   695: iconst_0
    //   696: invokestatic 1349	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   699: astore 6
    //   701: new 1351	com/tencent/mm/protocal/protobuf/alb
    //   704: dup
    //   705: invokespecial 1352	com/tencent/mm/protocal/protobuf/alb:<init>	()V
    //   708: aload 6
    //   710: invokevirtual 1356	com/tencent/mm/protocal/protobuf/alb:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   713: checkcast 1351	com/tencent/mm/protocal/protobuf/alb
    //   716: astore 6
    //   718: aload 5
    //   720: getfield 227	com/tencent/mm/plugin/wallet_core/model/Orders:field_infos	Ljava/util/ArrayList;
    //   723: aload 6
    //   725: getfield 1359	com/tencent/mm/protocal/protobuf/alb:field_info	Ljava/util/LinkedList;
    //   728: invokevirtual 1362	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   731: pop
    //   732: aload 5
    //   734: aload_0
    //   735: ldc_w 1364
    //   738: ldc 166
    //   740: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 229	com/tencent/mm/plugin/wallet_core/model/Orders:CYB	Ljava/lang/String;
    //   746: aload 5
    //   748: aload_0
    //   749: ldc_w 1366
    //   752: ldc 160
    //   754: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   757: putfield 1368	com/tencent/mm/plugin/wallet_core/model/Orders:CYC	Ljava/lang/String;
    //   760: aload 5
    //   762: aload_0
    //   763: ldc_w 1370
    //   766: ldc 160
    //   768: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   771: putfield 1372	com/tencent/mm/plugin/wallet_core/model/Orders:CYD	Ljava/lang/String;
    //   774: aload 5
    //   776: aload_0
    //   777: ldc_w 1374
    //   780: ldc 166
    //   782: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 231	com/tencent/mm/plugin/wallet_core/model/Orders:CYE	Ljava/lang/String;
    //   788: aload 5
    //   790: aload_0
    //   791: ldc_w 1376
    //   794: ldc 160
    //   796: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   799: putfield 1378	com/tencent/mm/plugin/wallet_core/model/Orders:CYF	Ljava/lang/String;
    //   802: aload 5
    //   804: aload_0
    //   805: ldc_w 1380
    //   808: ldc 160
    //   810: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: putfield 1382	com/tencent/mm/plugin/wallet_core/model/Orders:CYG	Ljava/lang/String;
    //   816: aload 5
    //   818: aload_0
    //   819: ldc_w 1384
    //   822: iconst_0
    //   823: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   826: putfield 1386	com/tencent/mm/plugin/wallet_core/model/Orders:CYH	I
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
    //   862: putfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:CYI	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   865: aload 5
    //   867: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:CYI	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   870: aload_0
    //   871: ldc_w 1391
    //   874: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   877: putfield 1394	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:CZF	I
    //   880: aload 5
    //   882: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:CYI	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   885: aload_0
    //   886: ldc_w 1396
    //   889: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   892: putfield 1399	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:dkR	Ljava/lang/String;
    //   895: aload 5
    //   897: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:CYI	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   900: aload_0
    //   901: ldc_w 1401
    //   904: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   907: putfield 1404	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:wBI	Ljava/lang/String;
    //   910: ldc_w 1226
    //   913: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: aload 5
    //   918: areturn
    //   919: aload 5
    //   921: aload 5
    //   923: getfield 255	com/tencent/mm/plugin/wallet_core/model/Orders:CPj	I
    //   926: iconst_2
    //   927: invokestatic 1410	com/tencent/mm/plugin/wallet_core/model/Bankcard:iJ	(II)Z
    //   930: putfield 174	com/tencent/mm/plugin/wallet_core/model/Orders:CYb	Z
    //   933: goto -337 -> 596
    //   936: astore_0
    //   937: ldc_w 406
    //   940: aload_0
    //   941: ldc 160
    //   943: iconst_0
    //   944: anewarray 4	java/lang/Object
    //   947: invokestatic 412	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   950: goto -40 -> 910
    //   953: aload 6
    //   955: ldc_w 1412
    //   958: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   961: astore 6
    //   963: aload 6
    //   965: ifnonnull +15 -> 980
    //   968: ldc_w 406
    //   971: ldc_w 1414
    //   974: invokestatic 1199	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -349 -> 628
    //   980: aload 6
    //   982: ldc_w 1416
    //   985: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   988: astore 6
    //   990: aload 6
    //   992: ifnonnull +15 -> 1007
    //   995: ldc_w 406
    //   998: ldc_w 1418
    //   1001: invokestatic 1199	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1061: putfield 189	com/tencent/mm/plugin/wallet_core/model/Orders:CYh	I
    //   1064: aload 5
    //   1066: aload 6
    //   1068: ldc_w 1436
    //   1071: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: putfield 191	com/tencent/mm/plugin/wallet_core/model/Orders:CYj	Ljava/lang/String;
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
    //   1106: putfield 311	com/tencent/mm/plugin/wallet_core/model/Orders:thf	Ljava/lang/String;
    //   1109: aload 5
    //   1111: iload 4
    //   1113: putfield 313	com/tencent/mm/plugin/wallet_core/model/Orders:CYi	Z
    //   1116: getstatic 1446	com/tencent/mm/plugin/fingerprint/b/p:thl	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1119: aload 7
    //   1121: putfield 1447	com/tencent/mm/plugin/fingerprint/b/p:thf	Ljava/lang/String;
    //   1124: getstatic 1446	com/tencent/mm/plugin/fingerprint/b/p:thl	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1127: iload 4
    //   1129: putfield 1450	com/tencent/mm/plugin/fingerprint/b/p:thn	Z
    //   1132: ldc_w 406
    //   1135: ldc_w 1452
    //   1138: iconst_3
    //   1139: anewarray 4	java/lang/Object
    //   1142: dup
    //   1143: iconst_0
    //   1144: aload 5
    //   1146: getfield 189	com/tencent/mm/plugin/wallet_core/model/Orders:CYh	I
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
    //   1166: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1169: goto -541 -> 628
    //   1172: astore 6
    //   1174: ldc_w 406
    //   1177: aload 6
    //   1179: ldc 160
    //   1181: iconst_0
    //   1182: anewarray 4	java/lang/Object
    //   1185: invokestatic 412	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        paramOrders.CYw = paramJSONObject.optInt("is_use_show_info", 0);
        ad.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.CYw) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          ad.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.CYy = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              ShowInfo localShowInfo = new ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.uaQ = localJSONObject.optString("name_color");
              localShowInfo.CZz = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.CZA = localJSONObject.optInt("link_type");
                localShowInfo.CZB = localJSONObject.optString("link_weapp");
                localShowInfo.CZC = localJSONObject.optString("link_addr");
                localShowInfo.CZD = localJSONObject.optString("link_url");
                localShowInfo.CZE = localJSONObject.optInt("text_attr");
              }
              if ((!bt.isNullOrNil(localShowInfo.name)) || (!bt.isNullOrNil(localShowInfo.value))) {
                paramOrders.CYy.add(localShowInfo);
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
        ad.printErrStackTrace("MicroMsg.Orders", paramOrders, "parseShowInfo error", new Object[0]);
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
      ad.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
      AppMethodBeat.o(70354);
      return localh;
    }
    localh.CGW = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localh.CGX = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localh.CGY = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localh.CGZ = paramJSONObject.optString("favorComposeId");
    localh.CHc = paramJSONObject.optInt("useNaturalDefense");
    localh.CHd = paramJSONObject.optString("discountWording");
    localh.CHe = paramJSONObject.optString("favorRuleWording");
    localh.CHf = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localh.CHg = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localh.CHh = paramJSONObject.optInt("isVariableFavor");
    localh.CHi = paramJSONObject.optString("invariableFavorDesc");
    localh.CHj = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new t();
      ((t)localObject2).CHO = ((JSONObject)localObject3).optInt("favType");
      ((t)localObject2).CHP = ((JSONObject)localObject3).optInt("favSubType");
      ((t)localObject2).CHQ = ((JSONObject)localObject3).optLong("favProperty");
      ((t)localObject2).CHR = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((t)localObject2).CGT = ((JSONObject)localObject3).optString("favId");
      ((t)localObject2).CHS = ((JSONObject)localObject3).optString("favName");
      ((t)localObject2).CHT = ((JSONObject)localObject3).optString("favDesc");
      ((t)localObject2).CGU = ((JSONObject)localObject3).optString("favorUseManual");
      ((t)localObject2).CGV = ((JSONObject)localObject3).optString("favorRemarks");
      ((t)localObject2).CHU = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((t)localObject2).CHV = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((t)localObject2).CHW = ((JSONObject)localObject3).optInt("needBankPay");
      ((t)localObject2).CHX = ((JSONObject)localObject3).optString("bankNo");
      ((t)localObject2).wCD = ((JSONObject)localObject3).optString("bankName");
      ((t)localObject2).CHY = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((t)localObject2).CHZ.add(com.tencent.mm.bx.b.cj(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localh.CHa.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localh.CHb = new com.tencent.mm.plugin.wallet.a.i();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new j();
        ((j)localObject2).CHp = ((JSONObject)localObject3).optString("faovrComposeId");
        ((j)localObject2).CHq = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((j)localObject2).CGY = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((j)localObject2).CHf = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).CHg = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).CHh = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((j)localObject2).CHi = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((j)localObject2).CHj = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.a.f();
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).CGT = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).CGU = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).CGV = ((JSONObject)localObject4).optString("favorRemarks");
          ((j)localObject2).CHr.add(localObject5);
          j += 1;
        }
        localh.CHb.CHn.add(localObject2);
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
          ((com.tencent.mm.plugin.wallet.a.c)localObject4).wBI = ((JSONObject)localObject5).optString("bind_serial");
          localObject5 = ((JSONObject)localObject5).optJSONArray("bind_serial_favor_list");
          if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              com.tencent.mm.plugin.wallet.a.d locald = new com.tencent.mm.plugin.wallet.a.d();
              JSONObject localJSONObject = ((JSONArray)localObject5).optJSONObject(j);
              locald.xXz = localJSONObject.optString("favor_desc");
              locald.CGR = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.a.c)localObject4).CGQ.add(locald);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).CGF.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.a.a)localObject1).CGG = new n();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new o();
          ((o)localObject3).xXz = ((JSONArray)localObject2).optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).CGG.CHw.add(localObject3);
          i += 1;
        }
      }
    }
    localh.CHk = ((com.tencent.mm.plugin.wallet.a.a)localObject1);
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
          ((com.tencent.mm.plugin.wallet.a.g)localObject2).CGJ = ((JSONObject)localObject3).optString("default_fav_comb_id");
          localObject3 = ((JSONObject)localObject3).optJSONObject("payment_channel");
          if (localObject3 != null)
          {
            localObject4 = new m();
            ((m)localObject4).wBI = ((JSONObject)localObject3).optString("bind_serial");
            ((m)localObject4).selected = ((JSONObject)localObject3).optInt("selected");
            ((m)localObject4).CHv = ((JSONObject)localObject3).optString("bankCode");
            ((com.tencent.mm.plugin.wallet.a.g)localObject2).CGH = ((m)localObject4);
          }
          localh.CHl.add(localObject2);
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
        ((m)localObject2).CHv = ((JSONObject)localObject3).optString("bankCode");
        ((m)localObject2).selected = ((JSONObject)localObject3).optInt("selected");
        ((m)localObject2).wBI = ((JSONObject)localObject3).optString("bind_serial");
        ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGH = ((m)localObject2);
      }
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGI = paramJSONObject.optInt("is_show_guide");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGJ = paramJSONObject.optString("default_fav_comb_id");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGK = paramJSONObject.optString("guide_content");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGL = paramJSONObject.optString("guide_content_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGM = paramJSONObject.optString("guide_btn_text");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGN = paramJSONObject.optString("guide_btn_text_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGO = paramJSONObject.optString("guide_btn_bg_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).CGP = paramJSONObject.optString("guide_logo");
      localh.CHm = ((com.tencent.mm.plugin.wallet.a.b)localObject1);
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
    ((StringBuilder)localObject).append("reqKey:").append(this.dlu).append("\n");
    ((StringBuilder)localObject).append("token").append(this.token).append("\n");
    ((StringBuilder)localObject).append("num").append(this.fRg).append("\n");
    ((StringBuilder)localObject).append("totalFee").append(this.dlx).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(70360);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70363);
    paramParcel.writeLong(this.CXS);
    paramParcel.writeString(this.dlu);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.fRg);
    paramParcel.writeDouble(this.dlx);
    paramParcel.writeInt(this.CPj);
    paramParcel.writeString(this.wCF);
    paramParcel.writeDouble(this.xYr);
    paramParcel.writeDouble(this.CXT);
    paramParcel.writeInt(this.CXU);
    paramParcel.writeString(this.CTa);
    paramParcel.writeString(this.CWk);
    paramParcel.writeInt(this.CXV);
    paramParcel.writeString(this.CXW);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.wqa);
    paramParcel.writeString(this.CXX);
    paramParcel.writeString(this.CXY);
    paramParcel.writeString(this.CXZ);
    paramParcel.writeInt(this.CYa);
    if (this.CYb)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.CYc);
      paramParcel.writeString(this.qeQ);
      paramParcel.writeLong(this.CYd);
      paramParcel.writeString(this.CYe);
      paramParcel.writeTypedList(this.CYk);
      paramParcel.writeString(this.CYf);
      paramParcel.writeInt(this.CYh);
      paramParcel.writeString(this.CYj);
      paramParcel.writeParcelable(this.CYp, 1);
      paramParcel.writeInt(this.CYs);
      paramParcel.writeInt(this.CYt);
      paramParcel.writeInt(this.CYx);
      paramParcel.writeString(this.CYA);
      paramParcel.writeString(this.CYz);
      paramParcel.writeInt(this.CYw);
      paramParcel.writeTypedList(this.CYy);
      paramParcel.writeParcelable(this.CYI, 1);
      paramParcel.writeString(this.thf);
      if (!this.CYi) {
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
    public double CYL;
    public String CYM;
    public String CYN;
    public List<Orders.DiscountInfo> CYO;
    public String CYP;
    public String CYQ;
    public String CYR;
    public Orders.RecommendTinyAppInfo CYS;
    public Orders.RemarksInfo CYT;
    public List<Orders.Promotions> CYU;
    public boolean CYV;
    public Orders.a CYW;
    public int CYa;
    public String desc;
    public String dlv;
    public double paV;
    public int wCB;
    public String wCD;
    public String wCF;
    public String wCG;
    public String wCK;
    public String wCj;
    public String wCr;
    public String wCs;
    public String wCt;
    public String wCu;
    public String wCw;
    public String wCy;
    public String wCz;
    
    static
    {
      AppMethodBeat.i(70317);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70317);
    }
    
    public Commodity()
    {
      AppMethodBeat.i(70314);
      this.paV = 0.0D;
      this.CYL = 0.0D;
      this.CYO = new ArrayList();
      this.CYS = null;
      this.CYU = new ArrayList();
      this.CYV = false;
      this.CYW = new Orders.a();
      AppMethodBeat.o(70314);
    }
    
    public Commodity(Parcel paramParcel)
    {
      AppMethodBeat.i(70315);
      this.paV = 0.0D;
      this.CYL = 0.0D;
      this.CYO = new ArrayList();
      this.CYS = null;
      this.CYU = new ArrayList();
      this.CYV = false;
      this.CYW = new Orders.a();
      this.wCr = paramParcel.readString();
      this.wCs = paramParcel.readString();
      this.wCt = paramParcel.readString();
      this.wCu = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.wCw = paramParcel.readString();
      this.paV = paramParcel.readDouble();
      this.wCy = paramParcel.readString();
      this.wCz = paramParcel.readString();
      this.wCB = paramParcel.readInt();
      this.dlv = paramParcel.readString();
      this.wCD = paramParcel.readString();
      this.wCF = paramParcel.readString();
      this.wCG = paramParcel.readString();
      this.wCj = paramParcel.readString();
      this.CYN = paramParcel.readString();
      this.wCK = paramParcel.readString();
      paramParcel.readTypedList(this.CYO, Orders.DiscountInfo.CREATOR);
      this.CYP = paramParcel.readString();
      this.CYR = paramParcel.readString();
      this.CYS = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
      paramParcel.readTypedList(this.CYU, Orders.Promotions.CREATOR);
      this.CYT = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.CYV = bool;
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
      paramParcel.writeString(this.wCr);
      paramParcel.writeString(this.wCs);
      paramParcel.writeString(this.wCt);
      paramParcel.writeString(this.wCu);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.wCw);
      paramParcel.writeDouble(this.paV);
      paramParcel.writeString(this.wCy);
      paramParcel.writeString(this.wCz);
      paramParcel.writeInt(this.wCB);
      paramParcel.writeString(this.dlv);
      paramParcel.writeString(this.wCD);
      paramParcel.writeString(this.wCF);
      paramParcel.writeString(this.wCG);
      paramParcel.writeString(this.wCj);
      paramParcel.writeString(this.CYN);
      paramParcel.writeString(this.wCK);
      paramParcel.writeTypedList(this.CYO);
      paramParcel.writeString(this.CYP);
      paramParcel.writeString(this.CYR);
      paramParcel.writeParcelable(this.CYS, 0);
      paramParcel.writeTypedList(this.CYU);
      paramParcel.writeParcelable(this.CYT, 0);
      if (this.CYV) {
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
    public int CJp;
    public String CJq;
    public int CKb;
    public String CYX;
    public List<Orders.DeductShowInfo> CYY;
    public int CYZ;
    public String CZa;
    public String CZb;
    public String desc;
    public String ozC;
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
      this.CYY = new ArrayList();
      AppMethodBeat.o(70319);
    }
    
    public DeductInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70320);
      this.CYY = new ArrayList();
      this.title = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.CKb = paramParcel.readInt();
      this.CYX = paramParcel.readString();
      this.CYZ = paramParcel.readInt();
      paramParcel.readTypedList(this.CYY, Orders.DeductShowInfo.CREATOR);
      this.CJp = paramParcel.readInt();
      this.ozC = paramParcel.readString();
      this.CJq = paramParcel.readString();
      this.CZa = paramParcel.readString();
      this.CZb = paramParcel.readString();
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
      paramParcel.writeInt(this.CKb);
      paramParcel.writeString(this.CYX);
      paramParcel.writeInt(this.CYZ);
      paramParcel.writeTypedList(this.CYY);
      paramParcel.writeInt(this.CJp);
      paramParcel.writeString(this.ozC);
      paramParcel.writeString(this.CJq);
      paramParcel.writeString(this.CZa);
      paramParcel.writeString(this.CZb);
      AppMethodBeat.o(70321);
    }
  }
  
  public static class DeductShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DeductShowInfo> CREATOR;
    public int CZc;
    public String CZd;
    public String CZe;
    public String CZf;
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
      this.CZc = paramParcel.readInt();
      this.CZd = paramParcel.readString();
      this.CZe = paramParcel.readString();
      this.CZf = paramParcel.readString();
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
      paramParcel.writeInt(this.CZc);
      paramParcel.writeString(this.CZd);
      paramParcel.writeString(this.CZe);
      paramParcel.writeString(this.CZf);
      AppMethodBeat.o(70325);
    }
  }
  
  public static class DiscountInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DiscountInfo> CREATOR;
    public double CZg;
    public String xXz;
    
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
      this.CZg = paramParcel.readDouble();
      this.xXz = paramParcel.readString();
      AppMethodBeat.o(70328);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70329);
      paramParcel.writeDouble(this.CZg);
      paramParcel.writeString(this.xXz);
      AppMethodBeat.o(70329);
    }
  }
  
  public static class Promotions
    implements Parcelable
  {
    public static final Parcelable.Creator<Promotions> CREATOR;
    public long COR;
    public int CXJ;
    public int CXK;
    public long CXL;
    public String CXM;
    public int CZh;
    public e.a.a.c CZq;
    public int OdM;
    public int OdN;
    public String OdO;
    public String OdP;
    public String OdQ;
    public int OdR;
    public String OdS;
    public String OdT;
    public String name;
    public String title;
    public int type;
    public String url;
    public String wCG;
    public String wMR;
    
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
      this.wMR = paramParcel.readString();
      this.name = paramParcel.readString();
      this.CXM = paramParcel.readString();
      this.url = paramParcel.readString();
      this.wCG = paramParcel.readString();
      this.title = paramParcel.readString();
      this.CZh = paramParcel.readInt();
      this.COR = paramParcel.readLong();
      this.OdM = paramParcel.readInt();
      this.OdN = paramParcel.readInt();
      this.CXJ = paramParcel.readInt();
      this.CXK = paramParcel.readInt();
      this.OdO = paramParcel.readString();
      this.OdP = paramParcel.readString();
      this.OdQ = paramParcel.readString();
      this.CXL = paramParcel.readLong();
      this.OdR = paramParcel.readInt();
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
      paramParcel.writeString(this.wMR);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.CXM);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.wCG);
      paramParcel.writeString(this.title);
      paramParcel.writeInt(this.CZh);
      paramParcel.writeLong(this.COR);
      paramParcel.writeInt(this.OdM);
      paramParcel.writeInt(this.OdN);
      paramParcel.writeInt(this.CXJ);
      paramParcel.writeInt(this.CXK);
      paramParcel.writeString(this.OdO);
      paramParcel.writeString(this.OdP);
      paramParcel.writeString(this.OdQ);
      paramParcel.writeLong(this.CXL);
      paramParcel.writeInt(this.OdR);
      AppMethodBeat.o(70333);
    }
  }
  
  public static class RecommendTinyAppInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR;
    public String CNV;
    public String CXO;
    public String CXP;
    public String CXQ;
    public int CXR;
    public long CZr;
    public long CZs;
    public long CZt;
    public int CZu;
    public int CZv;
    public long CZw;
    public String CzQ;
    public String CzR;
    
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
      this.CNV = paramParcel.readString();
      this.CXO = paramParcel.readString();
      this.CXP = paramParcel.readString();
      this.CzQ = paramParcel.readString();
      this.CzR = paramParcel.readString();
      this.CXR = paramParcel.readInt();
      AppMethodBeat.o(70336);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70337);
      paramParcel.writeString(this.CNV);
      paramParcel.writeString(this.CXO);
      paramParcel.writeString(this.CXP);
      paramParcel.writeString(this.CzQ);
      paramParcel.writeString(this.CzR);
      paramParcel.writeInt(this.CXR);
      AppMethodBeat.o(70337);
    }
  }
  
  public static class RemarksInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RemarksInfo> CREATOR;
    public String CZx;
    public String CZy;
    
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
      this.CZx = paramParcel.readString();
      this.CZy = paramParcel.readString();
      AppMethodBeat.o(70340);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70341);
      paramParcel.writeString(this.CZx);
      paramParcel.writeString(this.CZy);
      AppMethodBeat.o(70341);
    }
  }
  
  public static class ShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ShowInfo> CREATOR;
    public int CZA;
    public String CZB;
    public String CZC;
    public String CZD;
    public int CZE;
    public String CZz;
    public String name;
    public String uaQ;
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
      this.uaQ = paramParcel.readString();
      this.CZz = paramParcel.readString();
      this.CZA = paramParcel.readInt();
      this.CZB = paramParcel.readString();
      this.CZC = paramParcel.readString();
      this.CZD = paramParcel.readString();
      this.CZE = paramParcel.readInt();
      AppMethodBeat.o(70344);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(70345);
      String str = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.uaQ, this.CZz, Integer.valueOf(this.CZA), this.CZB, this.CZC, this.CZD, Integer.valueOf(this.CZE) });
      AppMethodBeat.o(70345);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70346);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.uaQ);
      paramParcel.writeString(this.CZz);
      paramParcel.writeInt(this.CZA);
      paramParcel.writeString(this.CZB);
      paramParcel.writeString(this.CZC);
      paramParcel.writeString(this.CZD);
      paramParcel.writeInt(this.CZE);
      AppMethodBeat.o(70346);
    }
  }
  
  public static class SimpleCashierInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleCashierInfo> CREATOR;
    public int CZF;
    public String dkR;
    public String wBI;
    
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
      this.CZF = paramParcel.readInt();
      this.dkR = paramParcel.readString();
      this.wBI = paramParcel.readString();
      AppMethodBeat.o(70349);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70350);
      paramParcel.writeInt(this.CZF);
      paramParcel.writeString(this.dkR);
      paramParcel.writeString(this.wBI);
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