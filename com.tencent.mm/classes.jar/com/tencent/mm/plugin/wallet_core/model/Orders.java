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
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public static int Byq;
  public static int Byr;
  public static final Parcelable.Creator<Orders> CREATOR;
  public int BoU;
  public String BsL;
  public String BvU;
  public double BxA;
  public int BxB;
  public int BxC;
  public String BxD;
  public String BxE;
  public String BxF;
  public String BxG;
  public int BxH;
  public boolean BxI;
  public String BxJ;
  public long BxK;
  public String BxL;
  public String BxM;
  public Set<String> BxN;
  public int BxO;
  public boolean BxP;
  public String BxQ;
  public List<Commodity> BxR;
  public com.tencent.mm.plugin.wallet.a.h BxS;
  public int BxT;
  public String BxU;
  public String BxV;
  public DeductInfo BxW;
  public long BxX;
  public long BxY;
  public int BxZ;
  public long Bxz;
  public int Bya;
  public int Byb;
  public String Byc;
  public int Byd;
  public int Bye;
  public ArrayList<ShowInfo> Byf;
  public String Byg;
  public String Byh;
  public String Byi;
  public String Byj;
  public String Byk;
  public String Byl;
  public String Bym;
  public String Byn;
  public int Byo;
  public SimpleCashierInfo Byp;
  public String dac;
  public double daf;
  public ArrayList<dgh> field_infos;
  public String fxT;
  public String nickname;
  public String pBl;
  public String skD;
  public String token;
  public String username;
  public String vkI;
  public String vxl;
  public double wKK;
  
  static
  {
    AppMethodBeat.i(70364);
    CREATOR = new Parcelable.Creator() {};
    Byq = 0;
    Byr = 1;
    AppMethodBeat.o(70364);
  }
  
  public Orders()
  {
    AppMethodBeat.i(70352);
    this.dac = "";
    this.token = "";
    this.fxT = "0";
    this.daf = 0.0D;
    this.BxA = 0.0D;
    this.BxI = false;
    this.BxJ = "";
    this.pBl = "";
    this.BxK = 0L;
    this.BxL = "";
    this.BxN = new HashSet();
    this.BxO = 0;
    this.BxQ = "";
    this.BxR = new ArrayList();
    this.BxS = new com.tencent.mm.plugin.wallet.a.h();
    this.BxT = 0;
    this.BxU = "";
    this.BxV = "";
    this.BxZ = 0;
    this.Bya = 0;
    this.Byb = 0;
    this.Byc = "";
    this.Byd = 0;
    this.Bye = 0;
    this.Byf = new ArrayList();
    this.Byg = "";
    this.Byh = "";
    this.field_infos = new ArrayList();
    this.Byi = "";
    this.Byl = "";
    AppMethodBeat.o(70352);
  }
  
  public Orders(Parcel paramParcel)
  {
    AppMethodBeat.i(70362);
    this.dac = "";
    this.token = "";
    this.fxT = "0";
    this.daf = 0.0D;
    this.BxA = 0.0D;
    this.BxI = false;
    this.BxJ = "";
    this.pBl = "";
    this.BxK = 0L;
    this.BxL = "";
    this.BxN = new HashSet();
    this.BxO = 0;
    this.BxQ = "";
    this.BxR = new ArrayList();
    this.BxS = new com.tencent.mm.plugin.wallet.a.h();
    this.BxT = 0;
    this.BxU = "";
    this.BxV = "";
    this.BxZ = 0;
    this.Bya = 0;
    this.Byb = 0;
    this.Byc = "";
    this.Byd = 0;
    this.Bye = 0;
    this.Byf = new ArrayList();
    this.Byg = "";
    this.Byh = "";
    this.field_infos = new ArrayList();
    this.Byi = "";
    this.Byl = "";
    this.Bxz = paramParcel.readLong();
    this.dac = paramParcel.readString();
    this.token = paramParcel.readString();
    this.fxT = paramParcel.readString();
    this.daf = paramParcel.readDouble();
    this.BoU = paramParcel.readInt();
    this.vxl = paramParcel.readString();
    this.wKK = paramParcel.readDouble();
    this.BxA = paramParcel.readDouble();
    this.BxB = paramParcel.readInt();
    this.BsL = paramParcel.readString();
    this.BvU = paramParcel.readString();
    this.BxC = paramParcel.readInt();
    this.BxD = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.vkI = paramParcel.readString();
    this.BxE = paramParcel.readString();
    this.BxF = paramParcel.readString();
    this.BxG = paramParcel.readString();
    this.BxH = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.BxI = bool1;
      this.BxJ = paramParcel.readString();
      this.pBl = paramParcel.readString();
      this.BxK = paramParcel.readLong();
      this.BxL = paramParcel.readString();
      paramParcel.readTypedList(this.BxR, Commodity.CREATOR);
      this.BxM = paramParcel.readString();
      this.BxN = azf(this.BxM);
      this.BxO = paramParcel.readInt();
      this.BxQ = paramParcel.readString();
      this.BxW = ((DeductInfo)paramParcel.readParcelable(DeductInfo.class.getClassLoader()));
      this.BxZ = paramParcel.readInt();
      this.Bya = paramParcel.readInt();
      this.Bye = paramParcel.readInt();
      this.Byh = paramParcel.readString();
      this.Byg = paramParcel.readString();
      this.Byd = paramParcel.readInt();
      paramParcel.readTypedList(this.Byf, ShowInfo.CREATOR);
      this.Byp = ((SimpleCashierInfo)paramParcel.readParcelable(SimpleCashierInfo.class.getClassLoader()));
      this.skD = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label591;
      }
    }
    label591:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BxP = bool1;
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
          paramOrders.BxF = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.BxG = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.BxH = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.pBl = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.BxH;
        localObject1 = paramOrders.BxR;
        paramOrders.BxJ = paramJSONObject.optString("pay_result_tips");
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
            ((Commodity)localObject2).ByB = new ArrayList();
            ((Commodity)localObject2).Byv = new ArrayList();
            ((Commodity)localObject2).dad = localJSONObject.getString("transaction_id");
            a((Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Commodity localCommodity = (Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.dad))) {
                continue;
              }
              a(localCommodity, localJSONObject, j);
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.Orders", paramJSONObject, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(70355);
        return paramOrders;
        localObject1 = paramJSONObject.optJSONObject("extinfo");
        if (localObject1 != null)
        {
          paramOrders.BxK = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
          paramOrders.BxL = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
        }
        paramOrders.Byb = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
        paramOrders.Byc = paramJSONObject.optString("pay_succ_btn_wording");
        paramOrders.Bye = paramJSONObject.optInt("is_jsapi_close_page");
        paramOrders.Byg = paramJSONObject.optString("jsapi_tinyapp_username");
        paramOrders.Byh = paramJSONObject.optString("jsapi_tinyapp_path");
        b(paramOrders, paramJSONObject);
        continue;
        ac.w("MicroMsg.Orders", "oldOrders is null");
      }
      i += 1;
    }
  }
  
  private static void a(Commodity paramCommodity, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(70356);
    paramCommodity.vxq = paramJSONObject.optString("discount");
    paramCommodity.vxe = paramJSONObject.getString("pay_status");
    paramCommodity.vxf = paramJSONObject.getString("pay_status_name");
    paramCommodity.vxj = paramJSONObject.optString("buy_bank_name");
    paramCommodity.vxh = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.Byu = paramJSONObject.optString("card_tail");
    paramCommodity.BxH = paramInt;
    paramCommodity.Byw = paramJSONObject.optString("rateinfo");
    paramCommodity.Byx = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.Byy = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.oxA = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.Bys = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.vxl = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Promotions();
      ((Promotions)localObject2).type = Byq;
      ((Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Promotions)localObject2).vxm = ((JSONObject)localObject1).optString("username");
      paramCommodity.Byt = ((Promotions)localObject2).vxm;
      ((Promotions)localObject2).vFL = ((JSONObject)localObject1).optString("logo_round_url");
      ((Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!bs.isNullOrNil(((Promotions)localObject2).name)) && (!bs.isNullOrNil(((Promotions)localObject2).url)))
      {
        paramCommodity.ByB.add(localObject2);
        paramCommodity.ByC = true;
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
      ((Promotions)localObject3).type = Byr;
      ((Promotions)localObject3).vFL = ((JSONObject)localObject2).optString("icon");
      ((Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Promotions)localObject3).Bxt = ((JSONObject)localObject2).optString("btn_text");
      ((Promotions)localObject3).ByO = ((JSONObject)localObject2).optInt("type");
      ((Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Promotions)localObject3).BoC = ((JSONObject)localObject2).optLong("activity_id");
      ((Promotions)localObject3).DeE = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Promotions)localObject3).DeG = ((JSONObject)localObject2).optString("small_title");
      ((Promotions)localObject3).DeF = ((JSONObject)localObject2).optInt("award_id");
      ((Promotions)localObject3).Bxq = ((JSONObject)localObject2).optInt("send_record_id");
      ((Promotions)localObject3).Bxr = ((JSONObject)localObject2).optInt("user_record_id");
      ((Promotions)localObject3).DeH = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Promotions)localObject3).DeI = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Promotions)localObject3).Bxs = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Promotions)localObject3).DeJ = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Promotions)localObject3).GZQ = ((JSONObject)localObject2).optString("get_award_params");
      ((Promotions)localObject3).GZR = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.ByB.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.ByD.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.ByD.url = ((JSONObject)localObject1).optString("url");
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
          ((DiscountInfo)localObject3).ByN = ((JSONObject)localObject2).optDouble("payment_amount");
          ((DiscountInfo)localObject3).wJS = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.Byv.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.Byz == null) {
        paramCommodity.Byz = new RecommendTinyAppInfo();
      }
      paramCommodity.Byz.BnG = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.Byz.Bxv = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.Byz.Bxw = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.Byz.AZE = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.Byz.AZF = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.Byz.Bxx = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.Byz.ByY = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.Byz.ByZ = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.Byz.Bza = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.Byz.Bzb = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.Byz.Bzc = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.Byz.Bzd = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.Byz.Bxy = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.ByA == null) {
        paramCommodity.ByA = new RemarksInfo();
      }
      paramCommodity.ByA.Bze = paramJSONObject.optString("remark_title");
      paramCommodity.ByA.Bzf = paramJSONObject.optString("remark_desc");
    }
    AppMethodBeat.o(70356);
  }
  
  public static void a(Promotions paramPromotions, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70357);
    ac.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.ByX = null;
      AppMethodBeat.o(70357);
      return;
    }
    try
    {
      e.a.a.c localc = new e.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.Exs = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          e.a.a.i locali = new e.a.a.i();
          locali.vFL = localJSONObject.optString("logo");
          locali.LVj = localJSONObject.optString("award_name");
          locali.LVk = localJSONObject.optString("award_description");
          locali.LVl = localJSONObject.optString("background_img");
          locali.LVn = localJSONObject.optString("award_description_color");
          locali.LVm = localJSONObject.optString("award_name_color");
          localc.Exs.add(locali);
          i += 1;
        }
      }
      localc.LUG = paramJSONObject.optInt("is_query_others", 0);
      localc.EvX = paramJSONObject.optString("draw_lottery_params");
      localc.Ext = paramJSONObject.optInt("is_show_btn");
      localc.LUK = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.Exu = new e.a.a.a();
        localc.Exu.LUy = ((JSONObject)localObject).optString("btn_words");
        localc.Exu.LUz = ((JSONObject)localObject).optString("btn_color");
        localc.Exu.LUA = ((JSONObject)localObject).optInt("btn_op_type");
        localc.Exu.url = ((JSONObject)localObject).optString("url");
        localc.Exu.EQP = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.Exu.LUB = new e.a.a.g();
          localc.Exu.LUB.Fsx = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.Exu.LUB.Fsy = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.Exu.LUB.Fsz = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.Exr = paramJSONObject.optString("exposure_info_modify_params");
      localc.LUH = paramJSONObject.optInt("user_opertaion_type");
      localc.LUI = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.LUJ = new e.a.a.f();
        localc.LUJ.LUX = ((JSONObject)localObject).optString("layer_title");
        localc.LUJ.LUY = ((JSONObject)localObject).optString("layer_logo");
        localc.LUJ.LUZ = ((JSONObject)localObject).optString("layer_type");
        localc.LUJ.LVa = ((JSONObject)localObject).optString("layer_name");
        localc.LUJ.LVb = ((JSONObject)localObject).optString("layer_description");
        localc.LUJ.LVc = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!bs.isNullOrNil(((JSONObject)localObject).optString("voice_url"))) {
          localc.LUJ.LVe = new com.tencent.mm.bw.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!bs.isNullOrNil(((JSONObject)localObject).optString("voice_data"))) {
          localc.LUJ.EgO = new com.tencent.mm.bw.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.LUJ.LVd = new e();
          localc.LUJ.LVd.LUy = ((JSONObject)localObject).optString("btn_words");
          localc.LUJ.LVd.LUz = ((JSONObject)localObject).optString("btn_color");
          localc.LUJ.LVd.LUA = ((JSONObject)localObject).optInt("btn_op_type");
          localc.LUJ.LVd.EQP = ((JSONObject)localObject).optString("get_lottery_params");
          localc.LUJ.LVd.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.LUJ.LVd.LUB = new e.a.a.g();
            localc.LUJ.LVd.LUB.Fsx = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.LUJ.LVd.LUB.Fsy = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.LUJ.LVd.LUB.Fsz = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      localObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (localObject != null)
      {
        localc.LUL = new e.a.a.b();
        localc.LUL.url = ((JSONObject)localObject).optString("url");
        localc.LUL.LUC = ((JSONObject)localObject).optString("animation_wording");
        localc.LUL.LUD = ((JSONObject)localObject).optString("animation_wording_color");
        localc.LUL.LUE = ((JSONObject)localObject).optString("after_animation_wording");
        localc.LUL.LUF = ((JSONObject)localObject).optString("after_animation_wording_color");
        localc.LUL.FUi = ((JSONObject)localObject).optInt("op_type");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.LUL.LUB = new e.a.a.g();
          localc.LUL.LUB.Fsx = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.LUL.LUB.Fsy = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.LUL.LUB.Fsz = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("follow_cardbd_mch_info");
      if (paramJSONObject != null)
      {
        localc.LUM = new e.a.a.d();
        localc.LUM.LUN = paramJSONObject.optInt("is_followed_cardbd_mch", 0);
        localc.LUM.LUP = paramJSONObject.optString("follow_logo", "");
        localc.LUM.LUO = paramJSONObject.optString("follow_tips", "");
        localc.LUM.LUQ = paramJSONObject.optString("follow_tips_color", "");
        localc.LUM.LUR = paramJSONObject.optLong("follow_tips_size", 0L);
        localc.LUM.LUU = paramJSONObject.optString("follow_logo_after", "");
        localc.LUM.LUW = paramJSONObject.optString("follow_tips_after", "");
        localc.LUM.LUV = paramJSONObject.optString("follow_tips_color_after", "");
        localc.LUM.Epz = paramJSONObject.optString("follow_param", "");
        localc.LUM.LUS = paramJSONObject.optInt("is_show_pop_up", 0);
        paramJSONObject = paramJSONObject.optJSONObject("pop_up_window_info");
        if (paramJSONObject != null)
        {
          localc.LUM.LUT = new e.a.a.h();
          localc.LUM.LUT.LVf = paramJSONObject.optString("pop_up_title");
          localc.LUM.LUT.LVg = paramJSONObject.optString("pop_up_text");
          localc.LUM.LUT.LVi = paramJSONObject.optString("pop_up_button_text");
          localc.LUM.LUT.LVh = paramJSONObject.optString("pop_up_image_url");
        }
      }
      paramPromotions.ByX = localc;
      AppMethodBeat.o(70357);
      return;
    }
    catch (Exception paramPromotions)
    {
      ac.printErrStackTrace("MicroMsg.Orders", paramPromotions, "parseExposureInfo error: %s", new Object[] { paramPromotions.getMessage() });
      AppMethodBeat.o(70357);
    }
  }
  
  private static void a(Orders paramOrders, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70358);
    if (paramJSONObject != null)
    {
      ac.i("MicroMsg.Orders", "parseDeductInfo json is not null");
      paramOrders.BxW = new DeductInfo();
      paramOrders.BxW.title = paramJSONObject.optString("contract_title");
      paramOrders.BxW.desc = paramJSONObject.optString("contract_desc");
      paramOrders.BxW.BjN = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.BxW.ByE = paramJSONObject.optString("contract_url");
      paramOrders.BxW.ByG = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.BxW.Bjb = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.BxW.nWi = paramJSONObject.optString("button_wording", "");
      paramOrders.BxW.Bjc = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.BxW.ByH = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.BxW.ByI = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.BxW.ByF = new ArrayList();
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
              localDeductShowInfo.ByJ = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.ByK = localJSONObject.optString("link_weapp");
              localDeductShowInfo.ByL = localJSONObject.optString("link_addr");
              localDeductShowInfo.ByM = localJSONObject.optString("link_url");
            }
            paramOrders.BxW.ByF.add(localDeductShowInfo);
          }
          for (;;)
          {
            i += 1;
            break;
            ac.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=".concat(String.valueOf(i)));
          }
        }
        AppMethodBeat.o(70358);
        return;
      }
      ac.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is ".concat(String.valueOf(j)));
      AppMethodBeat.o(70358);
      return;
    }
    ac.i("MicroMsg.Orders", "parseDeductInfo json is null");
    AppMethodBeat.o(70358);
  }
  
  /* Error */
  public static Orders aQ(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 1208
    //   3: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: ifnull +896 -> 906
    //   13: new 2	com/tencent/mm/plugin/wallet_core/model/Orders
    //   16: dup
    //   17: invokespecial 1209	com/tencent/mm/plugin/wallet_core/model/Orders:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 1212	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   27: putfield 241	com/tencent/mm/plugin/wallet_core/model/Orders:Bxz	J
    //   30: aload 5
    //   32: aload_0
    //   33: ldc_w 496
    //   36: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: ldc_w 1214
    //   42: getstatic 1220	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   45: invokestatic 1225	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   48: putfield 170	com/tencent/mm/plugin/wallet_core/model/Orders:daf	D
    //   51: aload 5
    //   53: aload_0
    //   54: ldc_w 1227
    //   57: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: putfield 168	com/tencent/mm/plugin/wallet_core/model/Orders:fxT	Ljava/lang/String;
    //   63: aload 5
    //   65: aload_0
    //   66: ldc_w 1229
    //   69: iconst_1
    //   70: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   73: putfield 255	com/tencent/mm/plugin/wallet_core/model/Orders:BoU	I
    //   76: aload 5
    //   78: aload_0
    //   79: ldc_w 518
    //   82: ldc 160
    //   84: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: putfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:vxl	Ljava/lang/String;
    //   90: aload 5
    //   92: aload_0
    //   93: ldc_w 1231
    //   96: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: ldc_w 1214
    //   102: getstatic 1220	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   105: invokestatic 1225	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   108: putfield 259	com/tencent/mm/plugin/wallet_core/model/Orders:wKK	D
    //   111: aload 5
    //   113: aload_0
    //   114: ldc_w 1233
    //   117: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: ldc_w 1214
    //   123: getstatic 1220	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   126: invokestatic 1225	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   129: putfield 172	com/tencent/mm/plugin/wallet_core/model/Orders:BxA	D
    //   132: aload 5
    //   134: aload_0
    //   135: ldc_w 1235
    //   138: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   141: putfield 261	com/tencent/mm/plugin/wallet_core/model/Orders:BxB	I
    //   144: aload 5
    //   146: aload_0
    //   147: ldc_w 1237
    //   150: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: putfield 263	com/tencent/mm/plugin/wallet_core/model/Orders:BsL	Ljava/lang/String;
    //   156: aload 5
    //   158: aload_0
    //   159: ldc_w 1239
    //   162: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 265	com/tencent/mm/plugin/wallet_core/model/Orders:BvU	Ljava/lang/String;
    //   168: aload 5
    //   170: aload_0
    //   171: ldc_w 1241
    //   174: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   177: putfield 267	com/tencent/mm/plugin/wallet_core/model/Orders:BxC	I
    //   180: aload 5
    //   182: aload_0
    //   183: ldc_w 1243
    //   186: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 269	com/tencent/mm/plugin/wallet_core/model/Orders:BxD	Ljava/lang/String;
    //   192: aload_0
    //   193: ldc_w 1245
    //   196: invokevirtual 349	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   199: astore 6
    //   201: aload 5
    //   203: aload_0
    //   204: ldc_w 1247
    //   207: invokevirtual 420	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   210: putfield 1249	com/tencent/mm/plugin/wallet_core/model/Orders:BxX	J
    //   213: aload 5
    //   215: aload_0
    //   216: ldc_w 1251
    //   219: invokevirtual 420	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   222: putfield 1253	com/tencent/mm/plugin/wallet_core/model/Orders:BxY	J
    //   225: aload 5
    //   227: aload_0
    //   228: ldc_w 1255
    //   231: iconst_0
    //   232: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   235: putfield 209	com/tencent/mm/plugin/wallet_core/model/Orders:BxZ	I
    //   238: aload 5
    //   240: aload_0
    //   241: ldc_w 1257
    //   244: iconst_0
    //   245: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   248: putfield 211	com/tencent/mm/plugin/wallet_core/model/Orders:Bya	I
    //   251: aload_0
    //   252: ldc_w 1259
    //   255: iconst_0
    //   256: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   259: iconst_1
    //   260: if_icmpne +934 -> 1194
    //   263: iconst_1
    //   264: istore_1
    //   265: iload_1
    //   266: ifeq +15 -> 281
    //   269: aload 5
    //   271: new 184	java/util/HashSet
    //   274: dup
    //   275: invokespecial 185	java/util/HashSet:<init>	()V
    //   278: putfield 187	com/tencent/mm/plugin/wallet_core/model/Orders:BxN	Ljava/util/Set;
    //   281: aload 6
    //   283: invokevirtual 354	org/json/JSONArray:length	()I
    //   286: istore_3
    //   287: iconst_0
    //   288: istore_2
    //   289: iload_2
    //   290: iload_3
    //   291: if_icmpge +279 -> 570
    //   294: aload 6
    //   296: iload_2
    //   297: invokevirtual 358	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   300: astore 7
    //   302: new 10	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity
    //   305: dup
    //   306: invokespecial 1260	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:<init>	()V
    //   309: astore 8
    //   311: aload 8
    //   313: aload 7
    //   315: ldc_w 1261
    //   318: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   321: putfield 1262	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:desc	Ljava/lang/String;
    //   324: aload 8
    //   326: aload 7
    //   328: ldc_w 1264
    //   331: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: ldc_w 1214
    //   337: getstatic 1220	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   340: invokestatic 1225	com/tencent/mm/wallet_core/ui/e:b	(Ljava/lang/String;Ljava/lang/String;Ljava/math/RoundingMode;)D
    //   343: putfield 509	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:oxA	D
    //   346: aload 8
    //   348: new 1266	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 1267	java/lang/StringBuilder:<init>	()V
    //   355: aload 7
    //   357: ldc_w 1269
    //   360: iconst_1
    //   361: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   364: invokevirtual 1273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 1276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: putfield 1279	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxc	Ljava/lang/String;
    //   373: aload 8
    //   375: aload 7
    //   377: ldc_w 455
    //   380: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   383: putfield 458	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxe	Ljava/lang/String;
    //   386: aload 8
    //   388: aload 7
    //   390: ldc_w 465
    //   393: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: putfield 468	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxj	Ljava/lang/String;
    //   399: aload 8
    //   401: aload 7
    //   403: ldc_w 460
    //   406: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   409: putfield 463	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxf	Ljava/lang/String;
    //   412: aload 8
    //   414: aload 7
    //   416: ldc_w 1281
    //   419: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   422: putfield 1284	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vwZ	Ljava/lang/String;
    //   425: aload 8
    //   427: aload 7
    //   429: ldc_w 1286
    //   432: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   435: putfield 1289	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxa	Ljava/lang/String;
    //   438: aload 8
    //   440: aload 7
    //   442: ldc_w 1291
    //   445: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   448: putfield 473	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxh	I
    //   451: aload 8
    //   453: aload 7
    //   455: ldc_w 375
    //   458: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   461: putfield 381	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:dad	Ljava/lang/String;
    //   464: aload 8
    //   466: aload 7
    //   468: ldc_w 518
    //   471: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   474: putfield 522	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxl	Ljava/lang/String;
    //   477: aload 5
    //   479: getfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:vxl	Ljava/lang/String;
    //   482: invokestatic 554	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   485: ifeq +13 -> 498
    //   488: aload 5
    //   490: aload 8
    //   492: getfield 522	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxl	Ljava/lang/String;
    //   495: putfield 257	com/tencent/mm/plugin/wallet_core/model/Orders:vxl	Ljava/lang/String;
    //   498: aload 8
    //   500: aload 7
    //   502: ldc_w 1293
    //   505: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   508: putfield 1294	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vxm	Ljava/lang/String;
    //   511: aload 8
    //   513: aload 7
    //   515: ldc_w 333
    //   518: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   521: putfield 1297	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:vwP	Ljava/lang/String;
    //   524: aload 5
    //   526: getfield 196	com/tencent/mm/plugin/wallet_core/model/Orders:BxR	Ljava/util/List;
    //   529: aload 8
    //   531: invokeinterface 557 2 0
    //   536: pop
    //   537: iload_1
    //   538: ifne +649 -> 1187
    //   541: aload 5
    //   543: aload 7
    //   545: ldc_w 1299
    //   548: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   551: putfield 290	com/tencent/mm/plugin/wallet_core/model/Orders:BxM	Ljava/lang/String;
    //   554: aload 5
    //   556: aload 5
    //   558: getfield 290	com/tencent/mm/plugin/wallet_core/model/Orders:BxM	Ljava/lang/String;
    //   561: invokestatic 294	com/tencent/mm/plugin/wallet_core/model/Orders:azf	(Ljava/lang/String;)Ljava/util/HashSet;
    //   564: putfield 187	com/tencent/mm/plugin/wallet_core/model/Orders:BxN	Ljava/util/Set;
    //   567: goto +620 -> 1187
    //   570: aload_0
    //   571: ldc_w 1301
    //   574: invokevirtual 500	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   577: ifeq +338 -> 915
    //   580: aload 5
    //   582: aload_0
    //   583: ldc_w 1301
    //   586: invokestatic 1305	com/tencent/mm/wallet_core/ui/e:m	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   589: putfield 174	com/tencent/mm/plugin/wallet_core/model/Orders:BxI	Z
    //   592: aload 5
    //   594: aload_0
    //   595: invokestatic 1309	com/tencent/mm/plugin/wallet_core/model/Orders:bc	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet/a/h;
    //   598: putfield 201	com/tencent/mm/plugin/wallet_core/model/Orders:BxS	Lcom/tencent/mm/plugin/wallet/a/h;
    //   601: aload_0
    //   602: ldc_w 1311
    //   605: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   608: astore 6
    //   610: aload 6
    //   612: ifnonnull +337 -> 949
    //   615: ldc_w 406
    //   618: ldc_w 1313
    //   621: invokestatic 1199	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload 5
    //   626: aload_0
    //   627: ldc_w 1315
    //   630: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   633: putfield 203	com/tencent/mm/plugin/wallet_core/model/Orders:BxT	I
    //   636: aload 5
    //   638: aload_0
    //   639: ldc_w 1317
    //   642: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   645: putfield 205	com/tencent/mm/plugin/wallet_core/model/Orders:BxU	Ljava/lang/String;
    //   648: aload 5
    //   650: aload_0
    //   651: ldc_w 1319
    //   654: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   657: putfield 207	com/tencent/mm/plugin/wallet_core/model/Orders:BxV	Ljava/lang/String;
    //   660: aload 5
    //   662: aload_0
    //   663: ldc_w 1321
    //   666: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   669: invokestatic 1323	com/tencent/mm/plugin/wallet_core/model/Orders:a	(Lcom/tencent/mm/plugin/wallet_core/model/Orders;Lorg/json/JSONObject;)V
    //   672: aload_0
    //   673: ldc_w 1325
    //   676: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   679: astore 6
    //   681: aload 6
    //   683: invokestatic 554	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   686: ifne +42 -> 728
    //   689: aload 6
    //   691: iconst_0
    //   692: invokestatic 1331	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   695: astore 6
    //   697: new 1333	com/tencent/mm/protocal/protobuf/ail
    //   700: dup
    //   701: invokespecial 1334	com/tencent/mm/protocal/protobuf/ail:<init>	()V
    //   704: aload 6
    //   706: invokevirtual 1338	com/tencent/mm/protocal/protobuf/ail:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   709: checkcast 1333	com/tencent/mm/protocal/protobuf/ail
    //   712: astore 6
    //   714: aload 5
    //   716: getfield 227	com/tencent/mm/plugin/wallet_core/model/Orders:field_infos	Ljava/util/ArrayList;
    //   719: aload 6
    //   721: getfield 1341	com/tencent/mm/protocal/protobuf/ail:field_info	Ljava/util/LinkedList;
    //   724: invokevirtual 1345	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   727: pop
    //   728: aload 5
    //   730: aload_0
    //   731: ldc_w 1347
    //   734: ldc 166
    //   736: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   739: putfield 229	com/tencent/mm/plugin/wallet_core/model/Orders:Byi	Ljava/lang/String;
    //   742: aload 5
    //   744: aload_0
    //   745: ldc_w 1349
    //   748: ldc 160
    //   750: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   753: putfield 1351	com/tencent/mm/plugin/wallet_core/model/Orders:Byj	Ljava/lang/String;
    //   756: aload 5
    //   758: aload_0
    //   759: ldc_w 1353
    //   762: ldc 160
    //   764: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   767: putfield 1355	com/tencent/mm/plugin/wallet_core/model/Orders:Byk	Ljava/lang/String;
    //   770: aload 5
    //   772: aload_0
    //   773: ldc_w 1357
    //   776: ldc 166
    //   778: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   781: putfield 231	com/tencent/mm/plugin/wallet_core/model/Orders:Byl	Ljava/lang/String;
    //   784: aload 5
    //   786: aload_0
    //   787: ldc_w 1359
    //   790: ldc 160
    //   792: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   795: putfield 1361	com/tencent/mm/plugin/wallet_core/model/Orders:Bym	Ljava/lang/String;
    //   798: aload 5
    //   800: aload_0
    //   801: ldc_w 1363
    //   804: ldc 160
    //   806: invokevirtual 521	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   809: putfield 1365	com/tencent/mm/plugin/wallet_core/model/Orders:Byn	Ljava/lang/String;
    //   812: aload 5
    //   814: aload_0
    //   815: ldc_w 1367
    //   818: iconst_0
    //   819: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   822: putfield 1369	com/tencent/mm/plugin/wallet_core/model/Orders:Byo	I
    //   825: aload_0
    //   826: ldc_w 1311
    //   829: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   832: astore_0
    //   833: aload_0
    //   834: ifnull +72 -> 906
    //   837: aload_0
    //   838: ldc_w 1371
    //   841: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   844: astore_0
    //   845: aload_0
    //   846: ifnull +60 -> 906
    //   849: aload 5
    //   851: new 50	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo
    //   854: dup
    //   855: invokespecial 1372	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:<init>	()V
    //   858: putfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Byp	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   861: aload 5
    //   863: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Byp	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   866: aload_0
    //   867: ldc_w 1374
    //   870: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   873: putfield 1377	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:Bzm	I
    //   876: aload 5
    //   878: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Byp	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   881: aload_0
    //   882: ldc_w 1379
    //   885: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: putfield 1382	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:cZz	Ljava/lang/String;
    //   891: aload 5
    //   893: getfield 309	com/tencent/mm/plugin/wallet_core/model/Orders:Byp	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   896: aload_0
    //   897: ldc_w 1384
    //   900: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   903: putfield 1387	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:vwo	Ljava/lang/String;
    //   906: ldc_w 1208
    //   909: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   912: aload 5
    //   914: areturn
    //   915: aload 5
    //   917: aload 5
    //   919: getfield 255	com/tencent/mm/plugin/wallet_core/model/Orders:BoU	I
    //   922: iconst_2
    //   923: invokestatic 1393	com/tencent/mm/plugin/wallet_core/model/Bankcard:iw	(II)Z
    //   926: putfield 174	com/tencent/mm/plugin/wallet_core/model/Orders:BxI	Z
    //   929: goto -337 -> 592
    //   932: astore_0
    //   933: ldc_w 406
    //   936: aload_0
    //   937: ldc 160
    //   939: iconst_0
    //   940: anewarray 4	java/lang/Object
    //   943: invokestatic 412	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   946: goto -40 -> 906
    //   949: aload 6
    //   951: ldc_w 1395
    //   954: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   957: astore 6
    //   959: aload 6
    //   961: ifnonnull +15 -> 976
    //   964: ldc_w 406
    //   967: ldc_w 1397
    //   970: invokestatic 1199	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   973: goto -349 -> 624
    //   976: aload 6
    //   978: ldc_w 1399
    //   981: invokevirtual 325	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   984: astore 6
    //   986: aload 6
    //   988: ifnonnull +15 -> 1003
    //   991: ldc_w 406
    //   994: ldc_w 1401
    //   997: invokestatic 1199	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: goto -376 -> 624
    //   1003: ldc_w 1403
    //   1006: invokestatic 1409	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1009: checkcast 1403	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1012: invokeinterface 1412 1 0
    //   1017: ifne +182 -> 1199
    //   1020: ldc_w 1403
    //   1023: invokestatic 1409	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1026: checkcast 1403	com/tencent/mm/plugin/fingerprint/b/a/i
    //   1029: invokeinterface 1415 1 0
    //   1034: ifeq +170 -> 1204
    //   1037: goto +162 -> 1199
    //   1040: iload_1
    //   1041: ifeq +168 -> 1209
    //   1044: aload 6
    //   1046: ldc_w 1417
    //   1049: iconst_0
    //   1050: invokevirtual 339	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1053: istore_1
    //   1054: aload 5
    //   1056: iload_1
    //   1057: putfield 189	com/tencent/mm/plugin/wallet_core/model/Orders:BxO	I
    //   1060: aload 5
    //   1062: aload 6
    //   1064: ldc_w 1419
    //   1067: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1070: putfield 191	com/tencent/mm/plugin/wallet_core/model/Orders:BxQ	Ljava/lang/String;
    //   1073: aload 6
    //   1075: ldc_w 1421
    //   1078: invokevirtual 331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1081: astore 7
    //   1083: iconst_1
    //   1084: aload 6
    //   1086: ldc_w 1423
    //   1089: invokevirtual 433	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1092: if_icmpne +122 -> 1214
    //   1095: iconst_1
    //   1096: istore 4
    //   1098: aload 5
    //   1100: aload 7
    //   1102: putfield 311	com/tencent/mm/plugin/wallet_core/model/Orders:skD	Ljava/lang/String;
    //   1105: aload 5
    //   1107: iload 4
    //   1109: putfield 313	com/tencent/mm/plugin/wallet_core/model/Orders:BxP	Z
    //   1112: getstatic 1429	com/tencent/mm/plugin/fingerprint/b/p:skJ	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1115: aload 7
    //   1117: putfield 1430	com/tencent/mm/plugin/fingerprint/b/p:skD	Ljava/lang/String;
    //   1120: getstatic 1429	com/tencent/mm/plugin/fingerprint/b/p:skJ	Lcom/tencent/mm/plugin/fingerprint/b/p;
    //   1123: iload 4
    //   1125: putfield 1433	com/tencent/mm/plugin/fingerprint/b/p:skL	Z
    //   1128: ldc_w 406
    //   1131: ldc_w 1435
    //   1134: iconst_3
    //   1135: anewarray 4	java/lang/Object
    //   1138: dup
    //   1139: iconst_0
    //   1140: aload 5
    //   1142: getfield 189	com/tencent/mm/plugin/wallet_core/model/Orders:BxO	I
    //   1145: invokestatic 1440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1148: aastore
    //   1149: dup
    //   1150: iconst_1
    //   1151: aload 7
    //   1153: aastore
    //   1154: dup
    //   1155: iconst_2
    //   1156: iload 4
    //   1158: invokestatic 1445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1161: aastore
    //   1162: invokestatic 762	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1165: goto -541 -> 624
    //   1168: astore 6
    //   1170: ldc_w 406
    //   1173: aload 6
    //   1175: ldc 160
    //   1177: iconst_0
    //   1178: anewarray 4	java/lang/Object
    //   1181: invokestatic 412	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1184: goto -456 -> 728
    //   1187: iload_2
    //   1188: iconst_1
    //   1189: iadd
    //   1190: istore_2
    //   1191: goto -902 -> 289
    //   1194: iconst_0
    //   1195: istore_1
    //   1196: goto -931 -> 265
    //   1199: iconst_1
    //   1200: istore_1
    //   1201: goto -161 -> 1040
    //   1204: iconst_0
    //   1205: istore_1
    //   1206: goto -166 -> 1040
    //   1209: iconst_0
    //   1210: istore_1
    //   1211: goto -157 -> 1054
    //   1214: iconst_0
    //   1215: istore 4
    //   1217: goto -119 -> 1098
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1220	0	paramJSONObject	JSONObject
    //   264	947	1	i	int
    //   288	903	2	j	int
    //   286	6	3	k	int
    //   1096	120	4	bool	boolean
    //   7	1134	5	localOrders	Orders
    //   199	886	6	localObject1	Object
    //   1168	6	6	localIOException	java.io.IOException
    //   300	852	7	localObject2	Object
    //   309	221	8	localCommodity	Commodity
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
    //   1003	1037	932	org/json/JSONException
    //   1044	1054	932	org/json/JSONException
    //   1054	1095	932	org/json/JSONException
    //   1098	1165	932	org/json/JSONException
    //   1170	1184	932	org/json/JSONException
    //   697	728	1168	java/io/IOException
  }
  
  private static HashSet<String> azf(String paramString)
  {
    AppMethodBeat.i(70361);
    HashSet localHashSet = new HashSet();
    if (!bs.isNullOrNil(paramString))
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
        paramOrders.Byd = paramJSONObject.optInt("is_use_show_info", 0);
        ac.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.Byd) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          ac.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.Byf = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              ShowInfo localShowInfo = new ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.tda = localJSONObject.optString("name_color");
              localShowInfo.Bzg = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.Bzh = localJSONObject.optInt("link_type");
                localShowInfo.Bzi = localJSONObject.optString("link_weapp");
                localShowInfo.Bzj = localJSONObject.optString("link_addr");
                localShowInfo.Bzk = localJSONObject.optString("link_url");
                localShowInfo.Bzl = localJSONObject.optInt("text_attr");
              }
              if ((!bs.isNullOrNil(localShowInfo.name)) || (!bs.isNullOrNil(localShowInfo.value))) {
                paramOrders.Byf.add(localShowInfo);
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
        ac.printErrStackTrace("MicroMsg.Orders", paramOrders, "parseShowInfo error", new Object[0]);
      }
    }
    AppMethodBeat.o(70359);
  }
  
  private static com.tencent.mm.plugin.wallet.a.h bc(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70354);
    com.tencent.mm.plugin.wallet.a.h localh = new com.tencent.mm.plugin.wallet.a.h();
    paramJSONObject = paramJSONObject.optJSONObject("favinfo");
    if (paramJSONObject == null)
    {
      ac.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
      AppMethodBeat.o(70354);
      return localh;
    }
    localh.BgI = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localh.BgJ = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localh.BgK = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localh.BgL = paramJSONObject.optString("favorComposeId");
    localh.BgO = paramJSONObject.optInt("useNaturalDefense");
    localh.BgP = paramJSONObject.optString("discountWording");
    localh.BgQ = paramJSONObject.optString("favorRuleWording");
    localh.BgR = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localh.BgS = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localh.BgT = paramJSONObject.optInt("isVariableFavor");
    localh.BgU = paramJSONObject.optString("invariableFavorDesc");
    localh.BgV = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new t();
      ((t)localObject2).BhA = ((JSONObject)localObject3).optInt("favType");
      ((t)localObject2).BhB = ((JSONObject)localObject3).optInt("favSubType");
      ((t)localObject2).BhC = ((JSONObject)localObject3).optLong("favProperty");
      ((t)localObject2).BhD = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((t)localObject2).BgF = ((JSONObject)localObject3).optString("favId");
      ((t)localObject2).BhE = ((JSONObject)localObject3).optString("favName");
      ((t)localObject2).BhF = ((JSONObject)localObject3).optString("favDesc");
      ((t)localObject2).BgG = ((JSONObject)localObject3).optString("favorUseManual");
      ((t)localObject2).BgH = ((JSONObject)localObject3).optString("favorRemarks");
      ((t)localObject2).BhG = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((t)localObject2).BhH = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((t)localObject2).BhI = ((JSONObject)localObject3).optInt("needBankPay");
      ((t)localObject2).BhJ = ((JSONObject)localObject3).optString("bankNo");
      ((t)localObject2).vxj = ((JSONObject)localObject3).optString("bankName");
      ((t)localObject2).BhK = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((t)localObject2).BhL.add(com.tencent.mm.bw.b.cc(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localh.BgM.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localh.BgN = new com.tencent.mm.plugin.wallet.a.i();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new j();
        ((j)localObject2).Bhb = ((JSONObject)localObject3).optString("faovrComposeId");
        ((j)localObject2).Bhc = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((j)localObject2).BgK = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((j)localObject2).BgR = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).BgS = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).BgT = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((j)localObject2).BgU = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((j)localObject2).BgV = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.a.f();
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).BgF = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).BgG = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.a.f)localObject5).BgH = ((JSONObject)localObject4).optString("favorRemarks");
          ((j)localObject2).Bhd.add(localObject5);
          j += 1;
        }
        localh.BgN.BgZ.add(localObject2);
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
          ((com.tencent.mm.plugin.wallet.a.c)localObject4).vwo = ((JSONObject)localObject5).optString("bind_serial");
          localObject5 = ((JSONObject)localObject5).optJSONArray("bind_serial_favor_list");
          if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              com.tencent.mm.plugin.wallet.a.d locald = new com.tencent.mm.plugin.wallet.a.d();
              JSONObject localJSONObject = ((JSONArray)localObject5).optJSONObject(j);
              locald.wJS = localJSONObject.optString("favor_desc");
              locald.BgD = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.a.c)localObject4).BgC.add(locald);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).Bgr.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.a.a)localObject1).Bgs = new n();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new o();
          ((o)localObject3).wJS = ((JSONArray)localObject2).optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.a.a)localObject1).Bgs.Bhi.add(localObject3);
          i += 1;
        }
      }
    }
    localh.BgW = ((com.tencent.mm.plugin.wallet.a.a)localObject1);
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
          ((com.tencent.mm.plugin.wallet.a.g)localObject2).Bgv = ((JSONObject)localObject3).optString("default_fav_comb_id");
          localObject3 = ((JSONObject)localObject3).optJSONObject("payment_channel");
          if (localObject3 != null)
          {
            localObject4 = new m();
            ((m)localObject4).vwo = ((JSONObject)localObject3).optString("bind_serial");
            ((m)localObject4).selected = ((JSONObject)localObject3).optInt("selected");
            ((m)localObject4).Bhh = ((JSONObject)localObject3).optString("bankCode");
            ((com.tencent.mm.plugin.wallet.a.g)localObject2).Bgt = ((m)localObject4);
          }
          localh.BgX.add(localObject2);
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
        ((m)localObject2).Bhh = ((JSONObject)localObject3).optString("bankCode");
        ((m)localObject2).selected = ((JSONObject)localObject3).optInt("selected");
        ((m)localObject2).vwo = ((JSONObject)localObject3).optString("bind_serial");
        ((com.tencent.mm.plugin.wallet.a.b)localObject1).Bgt = ((m)localObject2);
      }
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Bgu = paramJSONObject.optInt("is_show_guide");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Bgv = paramJSONObject.optString("default_fav_comb_id");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Bgw = paramJSONObject.optString("guide_content");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Bgx = paramJSONObject.optString("guide_content_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Bgy = paramJSONObject.optString("guide_btn_text");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).Bgz = paramJSONObject.optString("guide_btn_text_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).BgA = paramJSONObject.optString("guide_btn_bg_color");
      ((com.tencent.mm.plugin.wallet.a.b)localObject1).BgB = paramJSONObject.optString("guide_logo");
      localh.BgY = ((com.tencent.mm.plugin.wallet.a.b)localObject1);
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
    ((StringBuilder)localObject).append("reqKey:").append(this.dac).append("\n");
    ((StringBuilder)localObject).append("token").append(this.token).append("\n");
    ((StringBuilder)localObject).append("num").append(this.fxT).append("\n");
    ((StringBuilder)localObject).append("totalFee").append(this.daf).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(70360);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70363);
    paramParcel.writeLong(this.Bxz);
    paramParcel.writeString(this.dac);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.fxT);
    paramParcel.writeDouble(this.daf);
    paramParcel.writeInt(this.BoU);
    paramParcel.writeString(this.vxl);
    paramParcel.writeDouble(this.wKK);
    paramParcel.writeDouble(this.BxA);
    paramParcel.writeInt(this.BxB);
    paramParcel.writeString(this.BsL);
    paramParcel.writeString(this.BvU);
    paramParcel.writeInt(this.BxC);
    paramParcel.writeString(this.BxD);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.vkI);
    paramParcel.writeString(this.BxE);
    paramParcel.writeString(this.BxF);
    paramParcel.writeString(this.BxG);
    paramParcel.writeInt(this.BxH);
    if (this.BxI)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.BxJ);
      paramParcel.writeString(this.pBl);
      paramParcel.writeLong(this.BxK);
      paramParcel.writeString(this.BxL);
      paramParcel.writeTypedList(this.BxR);
      paramParcel.writeString(this.BxM);
      paramParcel.writeInt(this.BxO);
      paramParcel.writeString(this.BxQ);
      paramParcel.writeParcelable(this.BxW, 1);
      paramParcel.writeInt(this.BxZ);
      paramParcel.writeInt(this.Bya);
      paramParcel.writeInt(this.Bye);
      paramParcel.writeString(this.Byh);
      paramParcel.writeString(this.Byg);
      paramParcel.writeInt(this.Byd);
      paramParcel.writeTypedList(this.Byf);
      paramParcel.writeParcelable(this.Byp, 1);
      paramParcel.writeString(this.skD);
      if (!this.BxP) {
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
    public int BxH;
    public Orders.RemarksInfo ByA;
    public List<Orders.Promotions> ByB;
    public boolean ByC;
    public Orders.a ByD;
    public double Bys;
    public String Byt;
    public String Byu;
    public List<Orders.DiscountInfo> Byv;
    public String Byw;
    public String Byx;
    public String Byy;
    public Orders.RecommendTinyAppInfo Byz;
    public String dad;
    public String desc;
    public double oxA;
    public String vwP;
    public String vwX;
    public String vwY;
    public String vwZ;
    public String vxa;
    public String vxc;
    public String vxe;
    public String vxf;
    public int vxh;
    public String vxj;
    public String vxl;
    public String vxm;
    public String vxq;
    
    static
    {
      AppMethodBeat.i(70317);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70317);
    }
    
    public Commodity()
    {
      AppMethodBeat.i(70314);
      this.oxA = 0.0D;
      this.Bys = 0.0D;
      this.Byv = new ArrayList();
      this.Byz = null;
      this.ByB = new ArrayList();
      this.ByC = false;
      this.ByD = new Orders.a();
      AppMethodBeat.o(70314);
    }
    
    public Commodity(Parcel paramParcel)
    {
      AppMethodBeat.i(70315);
      this.oxA = 0.0D;
      this.Bys = 0.0D;
      this.Byv = new ArrayList();
      this.Byz = null;
      this.ByB = new ArrayList();
      this.ByC = false;
      this.ByD = new Orders.a();
      this.vwX = paramParcel.readString();
      this.vwY = paramParcel.readString();
      this.vwZ = paramParcel.readString();
      this.vxa = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.vxc = paramParcel.readString();
      this.oxA = paramParcel.readDouble();
      this.vxe = paramParcel.readString();
      this.vxf = paramParcel.readString();
      this.vxh = paramParcel.readInt();
      this.dad = paramParcel.readString();
      this.vxj = paramParcel.readString();
      this.vxl = paramParcel.readString();
      this.vxm = paramParcel.readString();
      this.vwP = paramParcel.readString();
      this.Byu = paramParcel.readString();
      this.vxq = paramParcel.readString();
      paramParcel.readTypedList(this.Byv, Orders.DiscountInfo.CREATOR);
      this.Byw = paramParcel.readString();
      this.Byy = paramParcel.readString();
      this.Byz = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
      paramParcel.readTypedList(this.ByB, Orders.Promotions.CREATOR);
      this.ByA = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.ByC = bool;
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
      paramParcel.writeString(this.vwX);
      paramParcel.writeString(this.vwY);
      paramParcel.writeString(this.vwZ);
      paramParcel.writeString(this.vxa);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.vxc);
      paramParcel.writeDouble(this.oxA);
      paramParcel.writeString(this.vxe);
      paramParcel.writeString(this.vxf);
      paramParcel.writeInt(this.vxh);
      paramParcel.writeString(this.dad);
      paramParcel.writeString(this.vxj);
      paramParcel.writeString(this.vxl);
      paramParcel.writeString(this.vxm);
      paramParcel.writeString(this.vwP);
      paramParcel.writeString(this.Byu);
      paramParcel.writeString(this.vxq);
      paramParcel.writeTypedList(this.Byv);
      paramParcel.writeString(this.Byw);
      paramParcel.writeString(this.Byy);
      paramParcel.writeParcelable(this.Byz, 0);
      paramParcel.writeTypedList(this.ByB);
      paramParcel.writeParcelable(this.ByA, 0);
      if (this.ByC) {
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
    public int BjN;
    public int Bjb;
    public String Bjc;
    public String ByE;
    public List<Orders.DeductShowInfo> ByF;
    public int ByG;
    public String ByH;
    public String ByI;
    public String desc;
    public String nWi;
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
      this.ByF = new ArrayList();
      AppMethodBeat.o(70319);
    }
    
    public DeductInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70320);
      this.ByF = new ArrayList();
      this.title = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.BjN = paramParcel.readInt();
      this.ByE = paramParcel.readString();
      this.ByG = paramParcel.readInt();
      paramParcel.readTypedList(this.ByF, Orders.DeductShowInfo.CREATOR);
      this.Bjb = paramParcel.readInt();
      this.nWi = paramParcel.readString();
      this.Bjc = paramParcel.readString();
      this.ByH = paramParcel.readString();
      this.ByI = paramParcel.readString();
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
      paramParcel.writeInt(this.BjN);
      paramParcel.writeString(this.ByE);
      paramParcel.writeInt(this.ByG);
      paramParcel.writeTypedList(this.ByF);
      paramParcel.writeInt(this.Bjb);
      paramParcel.writeString(this.nWi);
      paramParcel.writeString(this.Bjc);
      paramParcel.writeString(this.ByH);
      paramParcel.writeString(this.ByI);
      AppMethodBeat.o(70321);
    }
  }
  
  public static class DeductShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DeductShowInfo> CREATOR;
    public int ByJ;
    public String ByK;
    public String ByL;
    public String ByM;
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
      this.ByJ = paramParcel.readInt();
      this.ByK = paramParcel.readString();
      this.ByL = paramParcel.readString();
      this.ByM = paramParcel.readString();
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
      paramParcel.writeInt(this.ByJ);
      paramParcel.writeString(this.ByK);
      paramParcel.writeString(this.ByL);
      paramParcel.writeString(this.ByM);
      AppMethodBeat.o(70325);
    }
  }
  
  public static class DiscountInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DiscountInfo> CREATOR;
    public double ByN;
    public String wJS;
    
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
      this.ByN = paramParcel.readDouble();
      this.wJS = paramParcel.readString();
      AppMethodBeat.o(70328);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70329);
      paramParcel.writeDouble(this.ByN);
      paramParcel.writeString(this.wJS);
      AppMethodBeat.o(70329);
    }
  }
  
  public static class Promotions
    implements Parcelable
  {
    public static final Parcelable.Creator<Promotions> CREATOR;
    public long BoC;
    public int Bxq;
    public int Bxr;
    public long Bxs;
    public String Bxt;
    public int ByO;
    public e.a.a.c ByX;
    public int DeE;
    public int DeF;
    public String DeG;
    public String DeH;
    public String DeI;
    public int DeJ;
    public String GZQ;
    public String GZR;
    public String name;
    public String title;
    public int type;
    public String url;
    public String vFL;
    public String vxm;
    
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
      this.vFL = paramParcel.readString();
      this.name = paramParcel.readString();
      this.Bxt = paramParcel.readString();
      this.url = paramParcel.readString();
      this.vxm = paramParcel.readString();
      this.title = paramParcel.readString();
      this.ByO = paramParcel.readInt();
      this.BoC = paramParcel.readLong();
      this.DeE = paramParcel.readInt();
      this.DeF = paramParcel.readInt();
      this.Bxq = paramParcel.readInt();
      this.Bxr = paramParcel.readInt();
      this.DeG = paramParcel.readString();
      this.DeH = paramParcel.readString();
      this.DeI = paramParcel.readString();
      this.Bxs = paramParcel.readLong();
      this.DeJ = paramParcel.readInt();
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
      paramParcel.writeString(this.vFL);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.Bxt);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.vxm);
      paramParcel.writeString(this.title);
      paramParcel.writeInt(this.ByO);
      paramParcel.writeLong(this.BoC);
      paramParcel.writeInt(this.DeE);
      paramParcel.writeInt(this.DeF);
      paramParcel.writeInt(this.Bxq);
      paramParcel.writeInt(this.Bxr);
      paramParcel.writeString(this.DeG);
      paramParcel.writeString(this.DeH);
      paramParcel.writeString(this.DeI);
      paramParcel.writeLong(this.Bxs);
      paramParcel.writeInt(this.DeJ);
      AppMethodBeat.o(70333);
    }
  }
  
  public static class RecommendTinyAppInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR;
    public String AZE;
    public String AZF;
    public String BnG;
    public String Bxv;
    public String Bxw;
    public String Bxx;
    public int Bxy;
    public long ByY;
    public long ByZ;
    public long Bza;
    public int Bzb;
    public int Bzc;
    public long Bzd;
    
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
      this.BnG = paramParcel.readString();
      this.Bxv = paramParcel.readString();
      this.Bxw = paramParcel.readString();
      this.AZE = paramParcel.readString();
      this.AZF = paramParcel.readString();
      this.Bxy = paramParcel.readInt();
      AppMethodBeat.o(70336);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70337);
      paramParcel.writeString(this.BnG);
      paramParcel.writeString(this.Bxv);
      paramParcel.writeString(this.Bxw);
      paramParcel.writeString(this.AZE);
      paramParcel.writeString(this.AZF);
      paramParcel.writeInt(this.Bxy);
      AppMethodBeat.o(70337);
    }
  }
  
  public static class RemarksInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RemarksInfo> CREATOR;
    public String Bze;
    public String Bzf;
    
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
      this.Bze = paramParcel.readString();
      this.Bzf = paramParcel.readString();
      AppMethodBeat.o(70340);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70341);
      paramParcel.writeString(this.Bze);
      paramParcel.writeString(this.Bzf);
      AppMethodBeat.o(70341);
    }
  }
  
  public static class ShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ShowInfo> CREATOR;
    public String Bzg;
    public int Bzh;
    public String Bzi;
    public String Bzj;
    public String Bzk;
    public int Bzl;
    public String name;
    public String tda;
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
      this.tda = paramParcel.readString();
      this.Bzg = paramParcel.readString();
      this.Bzh = paramParcel.readInt();
      this.Bzi = paramParcel.readString();
      this.Bzj = paramParcel.readString();
      this.Bzk = paramParcel.readString();
      this.Bzl = paramParcel.readInt();
      AppMethodBeat.o(70344);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(70345);
      String str = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.tda, this.Bzg, Integer.valueOf(this.Bzh), this.Bzi, this.Bzj, this.Bzk, Integer.valueOf(this.Bzl) });
      AppMethodBeat.o(70345);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70346);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.tda);
      paramParcel.writeString(this.Bzg);
      paramParcel.writeInt(this.Bzh);
      paramParcel.writeString(this.Bzi);
      paramParcel.writeString(this.Bzj);
      paramParcel.writeString(this.Bzk);
      paramParcel.writeInt(this.Bzl);
      AppMethodBeat.o(70346);
    }
  }
  
  public static class SimpleCashierInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleCashierInfo> CREATOR;
    public int Bzm;
    public String cZz;
    public String vwo;
    
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
      this.Bzm = paramParcel.readInt();
      this.cZz = paramParcel.readString();
      this.vwo = paramParcel.readString();
      AppMethodBeat.o(70349);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70350);
      paramParcel.writeInt(this.Bzm);
      paramParcel.writeString(this.cZz);
      paramParcel.writeString(this.vwo);
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