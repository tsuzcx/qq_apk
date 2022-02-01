package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.model.j;
import com.tencent.mm.plugin.wallet.model.k;
import com.tencent.mm.plugin.wallet.model.l;
import com.tencent.mm.plugin.wallet.model.m;
import com.tencent.mm.plugin.wallet.model.q;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import g.a.a.e;
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
  public static int VHw;
  public static int VHx;
  public String Hgd;
  public String MEq;
  public String MpW;
  public double OjF;
  public String VBL;
  public String VFb;
  public long VGF;
  public double VGG;
  public int VGH;
  public int VGI;
  public String VGJ;
  public String VGK;
  public String VGL;
  public String VGM;
  public int VGN;
  public boolean VGO;
  public String VGP;
  public long VGQ;
  public String VGR;
  public String VGS;
  public Set<String> VGT;
  public int VGU;
  public boolean VGV;
  public String VGW;
  public List<Commodity> VGX;
  public com.tencent.mm.plugin.wallet.model.h VGY;
  public int VGZ;
  public String VHa;
  public String VHb;
  public DeductInfo VHc;
  public long VHd;
  public long VHe;
  public int VHf;
  public int VHg;
  public int VHh;
  public String VHi;
  public int VHj;
  public int VHk;
  public ArrayList<ShowInfo> VHl;
  public String VHm;
  public String VHn;
  public String VHo;
  public String VHp;
  public String VHq;
  public String VHr;
  public String VHs;
  public String VHt;
  public int VHu;
  public SimpleCashierInfo VHv;
  public int Vyb;
  public ArrayList<fll> field_infos;
  public String hAT;
  public double hAW;
  public String nickname;
  public String num;
  public String token;
  public String username;
  public String ytZ;
  
  static
  {
    AppMethodBeat.i(70364);
    CREATOR = new Parcelable.Creator() {};
    VHw = 0;
    VHx = 1;
    AppMethodBeat.o(70364);
  }
  
  public Orders()
  {
    AppMethodBeat.i(70352);
    this.hAT = "";
    this.token = "";
    this.num = "0";
    this.hAW = 0.0D;
    this.VGG = 0.0D;
    this.VGO = false;
    this.VGP = "";
    this.ytZ = "";
    this.VGQ = 0L;
    this.VGR = "";
    this.VGT = new HashSet();
    this.VGU = 0;
    this.VGW = "";
    this.VGX = new ArrayList();
    this.VGY = new com.tencent.mm.plugin.wallet.model.h();
    this.VGZ = 0;
    this.VHa = "";
    this.VHb = "";
    this.VHf = 0;
    this.VHg = 0;
    this.VHh = 0;
    this.VHi = "";
    this.VHj = 0;
    this.VHk = 0;
    this.VHl = new ArrayList();
    this.VHm = "";
    this.VHn = "";
    this.field_infos = new ArrayList();
    this.VHo = "";
    this.VHr = "";
    AppMethodBeat.o(70352);
  }
  
  public Orders(Parcel paramParcel)
  {
    AppMethodBeat.i(70362);
    this.hAT = "";
    this.token = "";
    this.num = "0";
    this.hAW = 0.0D;
    this.VGG = 0.0D;
    this.VGO = false;
    this.VGP = "";
    this.ytZ = "";
    this.VGQ = 0L;
    this.VGR = "";
    this.VGT = new HashSet();
    this.VGU = 0;
    this.VGW = "";
    this.VGX = new ArrayList();
    this.VGY = new com.tencent.mm.plugin.wallet.model.h();
    this.VGZ = 0;
    this.VHa = "";
    this.VHb = "";
    this.VHf = 0;
    this.VHg = 0;
    this.VHh = 0;
    this.VHi = "";
    this.VHj = 0;
    this.VHk = 0;
    this.VHl = new ArrayList();
    this.VHm = "";
    this.VHn = "";
    this.field_infos = new ArrayList();
    this.VHo = "";
    this.VHr = "";
    this.VGF = paramParcel.readLong();
    this.hAT = paramParcel.readString();
    this.token = paramParcel.readString();
    this.num = paramParcel.readString();
    this.hAW = paramParcel.readDouble();
    this.Vyb = paramParcel.readInt();
    this.MEq = paramParcel.readString();
    this.OjF = paramParcel.readDouble();
    this.VGG = paramParcel.readDouble();
    this.VGH = paramParcel.readInt();
    this.VBL = paramParcel.readString();
    this.VFb = paramParcel.readString();
    this.VGI = paramParcel.readInt();
    this.VGJ = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.MpW = paramParcel.readString();
    this.VGK = paramParcel.readString();
    this.VGL = paramParcel.readString();
    this.VGM = paramParcel.readString();
    this.VGN = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.VGO = bool1;
      this.VGP = paramParcel.readString();
      this.ytZ = paramParcel.readString();
      this.VGQ = paramParcel.readLong();
      this.VGR = paramParcel.readString();
      paramParcel.readTypedList(this.VGX, Commodity.CREATOR);
      this.VGS = paramParcel.readString();
      this.VGT = bgw(this.VGS);
      this.VGU = paramParcel.readInt();
      this.VGW = paramParcel.readString();
      this.VHc = ((DeductInfo)paramParcel.readParcelable(DeductInfo.class.getClassLoader()));
      this.VHf = paramParcel.readInt();
      this.VHg = paramParcel.readInt();
      this.VHk = paramParcel.readInt();
      this.VHn = paramParcel.readString();
      this.VHm = paramParcel.readString();
      this.VHj = paramParcel.readInt();
      paramParcel.readTypedList(this.VHl, ShowInfo.CREATOR);
      this.VHv = ((SimpleCashierInfo)paramParcel.readParcelable(SimpleCashierInfo.class.getClassLoader()));
      this.Hgd = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label591;
      }
    }
    label591:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.VGV = bool1;
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
          paramOrders.VGL = ((JSONObject)localObject1).optString("app_recommend_desc");
          paramOrders.VGM = ((JSONObject)localObject1).optString("app_telephone");
          paramOrders.VGN = ((JSONObject)localObject1).optInt("recommend_level", 2);
          paramOrders.ytZ = ((JSONObject)localObject1).optString("share_to_friends_url");
        }
        int j = paramOrders.VGN;
        localObject1 = paramOrders.VGX;
        paramOrders.VGP = paramJSONObject.optString("pay_result_tips");
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
            ((Commodity)localObject2).VHJ = new ArrayList();
            ((Commodity)localObject2).VHB = new ArrayList();
            ((Commodity)localObject2).hAU = localJSONObject.getString("transaction_id");
            a((Commodity)localObject2, localJSONObject, j);
          }
          else if (localObject1 != null)
          {
            localObject2 = localJSONObject.getString("transaction_id");
            Iterator localIterator = ((List)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Commodity localCommodity = (Commodity)localIterator.next();
              if ((localObject2 == null) || (!((String)localObject2).equals(localCommodity.hAU))) {
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
          paramOrders.VGQ = (((JSONObject)localObject1).optLong("fetch_pre_arrive_time") * 1000L);
          paramOrders.VGR = ((JSONObject)localObject1).optString("fetch_pre_arrive_time_wording");
        }
        paramOrders.VHh = paramJSONObject.optInt("is_use_new_paid_succ_page", 0);
        paramOrders.VHi = paramJSONObject.optString("pay_succ_btn_wording");
        paramOrders.VHk = paramJSONObject.optInt("is_jsapi_close_page");
        paramOrders.VHm = paramJSONObject.optString("jsapi_tinyapp_username");
        paramOrders.VHn = paramJSONObject.optString("jsapi_tinyapp_path");
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
    paramCommodity.DUX = paramJSONObject.optString("discount");
    paramCommodity.MEj = paramJSONObject.getString("pay_status");
    paramCommodity.MEk = paramJSONObject.getString("pay_status_name");
    paramCommodity.MEo = paramJSONObject.optString("buy_bank_name");
    paramCommodity.MEm = paramJSONObject.optInt("pay_timestamp");
    paramCommodity.VHA = paramJSONObject.optString("card_tail");
    paramCommodity.VGN = paramInt;
    paramCommodity.VHC = paramJSONObject.optString("rateinfo");
    paramCommodity.VHD = paramJSONObject.optString("discount_rateinfo");
    paramCommodity.VHE = paramJSONObject.optString("original_feeinfo");
    if (paramJSONObject.has("total_fee")) {
      paramCommodity.wZe = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    }
    paramCommodity.VHy = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
    paramCommodity.MEq = paramJSONObject.optString("fee_type", "");
    Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new Promotions();
      ((Promotions)localObject2).type = VHw;
      ((Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
      ((Promotions)localObject2).hzv = ((JSONObject)localObject1).optString("username");
      paramCommodity.VHz = ((Promotions)localObject2).hzv;
      ((Promotions)localObject2).MRI = ((JSONObject)localObject1).optString("logo_round_url");
      ((Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
      if ((!Util.isNullOrNil(((Promotions)localObject2).name)) && (!Util.isNullOrNil(((Promotions)localObject2).url)))
      {
        paramCommodity.VHJ.add(localObject2);
        paramCommodity.VHK = true;
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
      ((Promotions)localObject3).type = VHx;
      ((Promotions)localObject3).MRI = ((JSONObject)localObject2).optString("icon");
      ((Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
      ((Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
      ((Promotions)localObject3).VGz = ((JSONObject)localObject2).optString("btn_text");
      ((Promotions)localObject3).Avy = ((JSONObject)localObject2).optInt("type");
      ((Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
      ((Promotions)localObject3).ehe = ((JSONObject)localObject2).optLong("activity_id");
      ((Promotions)localObject3).akjp = ((JSONObject)localObject2).optInt("activity_type", 0);
      ((Promotions)localObject3).akjr = ((JSONObject)localObject2).optString("small_title");
      ((Promotions)localObject3).akjq = ((JSONObject)localObject2).optInt("award_id");
      ((Promotions)localObject3).VGw = ((JSONObject)localObject2).optInt("send_record_id");
      ((Promotions)localObject3).VGx = ((JSONObject)localObject2).optInt("user_record_id");
      ((Promotions)localObject3).akjs = ((JSONObject)localObject2).optString("activity_tinyapp_username");
      ((Promotions)localObject3).akjt = ((JSONObject)localObject2).optString("activity_tinyapp_path");
      ((Promotions)localObject3).VGy = ((JSONObject)localObject2).optLong("activity_mch_id");
      ((Promotions)localObject3).akju = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
      ((Promotions)localObject3).akjv = ((JSONObject)localObject2).optString("get_award_params");
      ((Promotions)localObject3).akjw = ((JSONObject)localObject2).optString("query_award_status_params");
      a((Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
      paramCommodity.VHJ.add(localObject3);
      paramInt += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("link_ativity_info");
    if (localObject1 != null)
    {
      paramCommodity.VHL.text = ((JSONObject)localObject1).optString("text");
      paramCommodity.VHL.url = ((JSONObject)localObject1).optString("url");
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
          ((DiscountInfo)localObject3).VHU = ((JSONObject)localObject2).optDouble("payment_amount");
          ((DiscountInfo)localObject3).OhO = ((JSONObject)localObject2).optString("favor_desc");
          paramCommodity.VHB.add(localObject3);
        }
        paramInt += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONObject("tinyapp_info");
    if (localObject1 != null)
    {
      if (paramCommodity.VHF == null) {
        paramCommodity.VHF = new RecommendTinyAppInfo();
      }
      paramCommodity.VHF.VsI = ((JSONObject)localObject1).optString("tinyapp_name");
      paramCommodity.VHF.VGB = ((JSONObject)localObject1).optString("tinyapp_logo");
      paramCommodity.VHF.VGC = ((JSONObject)localObject1).optString("tinyapp_desc");
      paramCommodity.VHF.VcU = ((JSONObject)localObject1).optString("tinyapp_username");
      paramCommodity.VHF.VcV = ((JSONObject)localObject1).optString("tinyapp_path");
      paramCommodity.VHF.VGD = ((JSONObject)localObject1).optString("activity_tinyapp_btn_text");
      paramCommodity.VHF.VIA = ((JSONObject)localObject1).optLong("activity_id");
      paramCommodity.VHF.VIB = ((JSONObject)localObject1).optLong("activity_type");
      paramCommodity.VHF.VIC = ((JSONObject)localObject1).optLong("award_id");
      paramCommodity.VHF.VID = ((JSONObject)localObject1).optInt("send_record_id");
      paramCommodity.VHF.VIE = ((JSONObject)localObject1).optInt("user_record_id");
      paramCommodity.VHF.VIF = ((JSONObject)localObject1).optLong("activity_mch_id");
      paramCommodity.VHF.VGE = ((JSONObject)localObject1).optInt("tinyapp_version");
    }
    paramJSONObject = paramJSONObject.optJSONObject("remarks_info");
    if (paramJSONObject != null)
    {
      if (paramCommodity.VHI == null) {
        paramCommodity.VHI = new RemarksInfo();
      }
      paramCommodity.VHI.VIG = paramJSONObject.optString("remark_title");
      paramCommodity.VHI.VIH = paramJSONObject.optString("remark_desc");
    }
    AppMethodBeat.o(70356);
  }
  
  public static void a(Promotions paramPromotions, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70357);
    Log.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[] { paramJSONObject });
    if (paramJSONObject == null)
    {
      paramPromotions.VIz = null;
      AppMethodBeat.o(70357);
      return;
    }
    try
    {
      g.a.a.c localc = new g.a.a.c();
      Object localObject = paramJSONObject.optJSONArray("single_exposure_info_list");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localc.ZvT = new LinkedList();
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          g.a.a.i locali = new g.a.a.i();
          locali.MRI = localJSONObject.optString("logo");
          locali.ajGc = localJSONObject.optString("award_name");
          locali.ajGd = localJSONObject.optString("award_description");
          locali.ajGe = localJSONObject.optString("background_img");
          locali.ajGg = localJSONObject.optString("award_description_color");
          locali.ajGf = localJSONObject.optString("award_name_color");
          localc.ZvT.add(locali);
          i += 1;
        }
      }
      localc.ajFz = paramJSONObject.optInt("is_query_others", 0);
      localc.Zsq = paramJSONObject.optString("draw_lottery_params");
      localc.ZvU = paramJSONObject.optInt("is_show_btn");
      localc.ajFD = paramJSONObject.optString("background_img_whole");
      localObject = paramJSONObject.optJSONObject("btn_info");
      if (localObject != null)
      {
        localc.ZvV = new g.a.a.a();
        localc.ZvV.ajFr = ((JSONObject)localObject).optString("btn_words");
        localc.ZvV.ajFs = ((JSONObject)localObject).optString("btn_color");
        localc.ZvV.ajFt = ((JSONObject)localObject).optInt("btn_op_type");
        localc.ZvV.url = ((JSONObject)localObject).optString("url");
        localc.ZvV.aauB = ((JSONObject)localObject).optString("get_lottery_params");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.ZvV.ajFu = new g.a.a.g();
          localc.ZvV.ajFu.abho = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.ZvV.ajFu.abhp = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.ZvV.ajFu.abhq = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      localc.ZvS = paramJSONObject.optString("exposure_info_modify_params");
      localc.ajFA = paramJSONObject.optInt("user_opertaion_type");
      localc.ajFB = paramJSONObject.optInt("is_show_layer");
      localObject = paramJSONObject.optJSONObject("layer_info");
      if (localObject != null)
      {
        localc.ajFC = new g.a.a.f();
        localc.ajFC.ajFQ = ((JSONObject)localObject).optString("layer_title");
        localc.ajFC.ajFR = ((JSONObject)localObject).optString("layer_logo");
        localc.ajFC.ajFS = ((JSONObject)localObject).optString("layer_type");
        localc.ajFC.ajFT = ((JSONObject)localObject).optString("layer_name");
        localc.ajFC.ajFU = ((JSONObject)localObject).optString("layer_description");
        localc.ajFC.ajFV = ((JSONObject)localObject).optInt("is_show_layer_btn");
        if (!Util.isNullOrNil(((JSONObject)localObject).optString("voice_url"))) {
          localc.ajFC.ajFX = new com.tencent.mm.bx.b(((JSONObject)localObject).optString("voice_url").getBytes());
        }
        if (!Util.isNullOrNil(((JSONObject)localObject).optString("voice_data"))) {
          localc.ajFC.Zab = new com.tencent.mm.bx.b(((JSONObject)localObject).optString("voice_data").getBytes());
        }
        localObject = ((JSONObject)localObject).optJSONObject("layer_btn_info");
        if (localObject != null)
        {
          localc.ajFC.ajFW = new e();
          localc.ajFC.ajFW.ajFr = ((JSONObject)localObject).optString("btn_words");
          localc.ajFC.ajFW.ajFs = ((JSONObject)localObject).optString("btn_color");
          localc.ajFC.ajFW.ajFt = ((JSONObject)localObject).optInt("btn_op_type");
          localc.ajFC.ajFW.aauB = ((JSONObject)localObject).optString("get_lottery_params");
          localc.ajFC.ajFW.url = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
          if (localObject != null)
          {
            localc.ajFC.ajFW.ajFu = new g.a.a.g();
            localc.ajFC.ajFW.ajFu.abho = ((JSONObject)localObject).optString("activity_tinyapp_username");
            localc.ajFC.ajFW.ajFu.abhp = ((JSONObject)localObject).optString("activity_tinyapp_path");
            localc.ajFC.ajFW.ajFu.abhq = ((JSONObject)localObject).optInt("activity_tinyapp_version");
          }
        }
      }
      localObject = paramJSONObject.optJSONObject("draw_lottery_info");
      if (localObject != null)
      {
        localc.ajFE = new g.a.a.b();
        localc.ajFE.url = ((JSONObject)localObject).optString("url");
        localc.ajFE.ajFv = ((JSONObject)localObject).optString("animation_wording");
        localc.ajFE.ajFw = ((JSONObject)localObject).optString("animation_wording_color");
        localc.ajFE.ajFx = ((JSONObject)localObject).optString("after_animation_wording");
        localc.ajFE.ajFy = ((JSONObject)localObject).optString("after_animation_wording_color");
        localc.ajFE.YAN = ((JSONObject)localObject).optInt("op_type");
        localObject = ((JSONObject)localObject).optJSONObject("mini_app_info");
        if (localObject != null)
        {
          localc.ajFE.ajFu = new g.a.a.g();
          localc.ajFE.ajFu.abho = ((JSONObject)localObject).optString("activity_tinyapp_username");
          localc.ajFE.ajFu.abhp = ((JSONObject)localObject).optString("activity_tinyapp_path");
          localc.ajFE.ajFu.abhq = ((JSONObject)localObject).optInt("activity_tinyapp_version");
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("follow_cardbd_mch_info");
      if (paramJSONObject != null)
      {
        localc.ajFF = new g.a.a.d();
        localc.ajFF.ajFG = paramJSONObject.optInt("is_followed_cardbd_mch", 0);
        localc.ajFF.ajFI = paramJSONObject.optString("follow_logo", "");
        localc.ajFF.ajFH = paramJSONObject.optString("follow_tips", "");
        localc.ajFF.ajFJ = paramJSONObject.optString("follow_tips_color", "");
        localc.ajFF.ajFK = paramJSONObject.optLong("follow_tips_size", 0L);
        localc.ajFF.ajFN = paramJSONObject.optString("follow_logo_after", "");
        localc.ajFF.ajFP = paramJSONObject.optString("follow_tips_after", "");
        localc.ajFF.ajFO = paramJSONObject.optString("follow_tips_color_after", "");
        localc.ajFF.Zjn = paramJSONObject.optString("follow_param", "");
        localc.ajFF.ajFL = paramJSONObject.optInt("is_show_pop_up", 0);
        paramJSONObject = paramJSONObject.optJSONObject("pop_up_window_info");
        if (paramJSONObject != null)
        {
          localc.ajFF.ajFM = new g.a.a.h();
          localc.ajFF.ajFM.ajFY = paramJSONObject.optString("pop_up_title");
          localc.ajFF.ajFM.ajFZ = paramJSONObject.optString("pop_up_text");
          localc.ajFF.ajFM.ajGb = paramJSONObject.optString("pop_up_button_text");
          localc.ajFF.ajFM.ajGa = paramJSONObject.optString("pop_up_image_url");
        }
      }
      paramPromotions.VIz = localc;
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
      paramOrders.VHc = new DeductInfo();
      paramOrders.VHc.title = paramJSONObject.optString("contract_title");
      paramOrders.VHc.desc = paramJSONObject.optString("contract_desc");
      paramOrders.VHc.VoA = paramJSONObject.optInt("auto_deduct_flag", 0);
      paramOrders.VHc.VHM = paramJSONObject.optString("contract_url");
      paramOrders.VHc.VHO = paramJSONObject.optInt("is_select_pay_way", 0);
      paramOrders.VHc.VnO = paramJSONObject.optInt("deduct_show_type", 0);
      paramOrders.VHc.wul = paramJSONObject.optString("button_wording", "");
      paramOrders.VHc.VnP = paramJSONObject.optString("deduct_rule_wording", "");
      paramOrders.VHc.VHP = paramJSONObject.optString("open_deduct_wording", "");
      paramOrders.VHc.VHQ = paramJSONObject.optString("open_deduct_wording_color", "");
      paramJSONObject = paramJSONObject.optJSONArray("show_info");
      int j = paramJSONObject.length();
      if (j > 0)
      {
        paramOrders.VHc.VHN = new ArrayList();
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
              localDeductShowInfo.mdV = localJSONObject.optInt("link_type", 0);
              localDeductShowInfo.VHR = localJSONObject.optString("link_weapp");
              localDeductShowInfo.VHS = localJSONObject.optString("link_addr");
              localDeductShowInfo.VHT = localJSONObject.optString("link_url");
            }
            paramOrders.VHc.VHN.add(localDeductShowInfo);
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
        paramOrders.VHj = paramJSONObject.optInt("is_use_show_info", 0);
        Log.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[] { Integer.valueOf(paramOrders.VHj) });
        paramJSONObject = paramJSONObject.optJSONArray("show_info");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          Log.i("MicroMsg.Orders", "showInfo size: %s", new Object[] { Integer.valueOf(paramJSONObject.length()) });
          paramOrders.VHl = new ArrayList();
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            if (localJSONObject != null)
            {
              ShowInfo localShowInfo = new ShowInfo();
              localShowInfo.name = localJSONObject.optString("name");
              localShowInfo.value = localJSONObject.optString("value");
              localShowInfo.ICv = localJSONObject.optString("name_color");
              localShowInfo.VII = localJSONObject.optString("value_color");
              localJSONObject = localJSONObject.optJSONObject("value_attr");
              if (localJSONObject != null)
              {
                localShowInfo.VIJ = localJSONObject.optInt("link_type");
                localShowInfo.VIK = localJSONObject.optString("link_weapp");
                localShowInfo.VIL = localJSONObject.optString("link_addr");
                localShowInfo.VIM = localJSONObject.optString("link_url");
                localShowInfo.VIN = localJSONObject.optInt("text_attr");
              }
              if ((!Util.isNullOrNil(localShowInfo.name)) || (!Util.isNullOrNil(localShowInfo.value))) {
                paramOrders.VHl.add(localShowInfo);
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
  
  private static HashSet<String> bgw(String paramString)
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
  
  /* Error */
  public static Orders ce(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 1281
    //   3: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: ifnull +900 -> 910
    //   13: new 2	com/tencent/mm/plugin/wallet_core/model/Orders
    //   16: dup
    //   17: invokespecial 1282	com/tencent/mm/plugin/wallet_core/model/Orders:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 1285	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   27: putfield 251	com/tencent/mm/plugin/wallet_core/model/Orders:VGF	J
    //   30: aload 5
    //   32: aload_0
    //   33: ldc_w 506
    //   36: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: ldc_w 1287
    //   42: iconst_2
    //   43: getstatic 1293	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   46: invokestatic 1298	com/tencent/mm/wallet_core/ui/i:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   49: putfield 180	com/tencent/mm/plugin/wallet_core/model/Orders:hAW	D
    //   52: aload 5
    //   54: aload_0
    //   55: ldc_w 1299
    //   58: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 178	com/tencent/mm/plugin/wallet_core/model/Orders:num	Ljava/lang/String;
    //   64: aload 5
    //   66: aload_0
    //   67: ldc_w 1301
    //   70: iconst_1
    //   71: invokevirtual 349	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: putfield 265	com/tencent/mm/plugin/wallet_core/model/Orders:Vyb	I
    //   77: aload 5
    //   79: aload_0
    //   80: ldc_w 528
    //   83: ldc 170
    //   85: invokevirtual 531	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 267	com/tencent/mm/plugin/wallet_core/model/Orders:MEq	Ljava/lang/String;
    //   91: aload 5
    //   93: aload_0
    //   94: ldc_w 1303
    //   97: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: ldc_w 1287
    //   103: iconst_2
    //   104: getstatic 1293	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   107: invokestatic 1298	com/tencent/mm/wallet_core/ui/i:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   110: putfield 269	com/tencent/mm/plugin/wallet_core/model/Orders:OjF	D
    //   113: aload 5
    //   115: aload_0
    //   116: ldc_w 1305
    //   119: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: ldc_w 1287
    //   125: iconst_2
    //   126: getstatic 1293	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   129: invokestatic 1298	com/tencent/mm/wallet_core/ui/i:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   132: putfield 182	com/tencent/mm/plugin/wallet_core/model/Orders:VGG	D
    //   135: aload 5
    //   137: aload_0
    //   138: ldc_w 1307
    //   141: invokevirtual 443	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   144: putfield 271	com/tencent/mm/plugin/wallet_core/model/Orders:VGH	I
    //   147: aload 5
    //   149: aload_0
    //   150: ldc_w 1309
    //   153: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: putfield 273	com/tencent/mm/plugin/wallet_core/model/Orders:VBL	Ljava/lang/String;
    //   159: aload 5
    //   161: aload_0
    //   162: ldc_w 1311
    //   165: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 275	com/tencent/mm/plugin/wallet_core/model/Orders:VFb	Ljava/lang/String;
    //   171: aload 5
    //   173: aload_0
    //   174: ldc_w 1313
    //   177: invokevirtual 443	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   180: putfield 277	com/tencent/mm/plugin/wallet_core/model/Orders:VGI	I
    //   183: aload 5
    //   185: aload_0
    //   186: ldc_w 1315
    //   189: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: putfield 279	com/tencent/mm/plugin/wallet_core/model/Orders:VGJ	Ljava/lang/String;
    //   195: aload_0
    //   196: ldc_w 1317
    //   199: invokevirtual 359	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore 6
    //   204: aload 5
    //   206: aload_0
    //   207: ldc_w 1319
    //   210: invokevirtual 430	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   213: putfield 1321	com/tencent/mm/plugin/wallet_core/model/Orders:VHd	J
    //   216: aload 5
    //   218: aload_0
    //   219: ldc_w 1323
    //   222: invokevirtual 430	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   225: putfield 1325	com/tencent/mm/plugin/wallet_core/model/Orders:VHe	J
    //   228: aload 5
    //   230: aload_0
    //   231: ldc_w 1327
    //   234: iconst_0
    //   235: invokevirtual 349	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   238: putfield 219	com/tencent/mm/plugin/wallet_core/model/Orders:VHf	I
    //   241: aload 5
    //   243: aload_0
    //   244: ldc_w 1329
    //   247: iconst_0
    //   248: invokevirtual 349	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   251: putfield 221	com/tencent/mm/plugin/wallet_core/model/Orders:VHg	I
    //   254: aload_0
    //   255: ldc_w 1331
    //   258: iconst_0
    //   259: invokevirtual 349	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   262: iconst_1
    //   263: if_icmpne +935 -> 1198
    //   266: iconst_1
    //   267: istore_1
    //   268: iload_1
    //   269: ifeq +15 -> 284
    //   272: aload 5
    //   274: new 194	java/util/HashSet
    //   277: dup
    //   278: invokespecial 195	java/util/HashSet:<init>	()V
    //   281: putfield 197	com/tencent/mm/plugin/wallet_core/model/Orders:VGT	Ljava/util/Set;
    //   284: aload 6
    //   286: invokevirtual 364	org/json/JSONArray:length	()I
    //   289: istore_3
    //   290: iconst_0
    //   291: istore_2
    //   292: iload_2
    //   293: iload_3
    //   294: if_icmpge +280 -> 574
    //   297: aload 6
    //   299: iload_2
    //   300: invokevirtual 368	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   303: astore 7
    //   305: new 10	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity
    //   308: dup
    //   309: invokespecial 1332	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:<init>	()V
    //   312: astore 8
    //   314: aload 8
    //   316: aload 7
    //   318: ldc_w 1333
    //   321: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 1334	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:desc	Ljava/lang/String;
    //   327: aload 8
    //   329: aload 7
    //   331: ldc_w 1336
    //   334: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   337: ldc_w 1287
    //   340: iconst_2
    //   341: getstatic 1293	java/math/RoundingMode:HALF_UP	Ljava/math/RoundingMode;
    //   344: invokestatic 1298	com/tencent/mm/wallet_core/ui/i:a	(Ljava/lang/String;Ljava/lang/String;ILjava/math/RoundingMode;)D
    //   347: putfield 519	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:wZe	D
    //   350: aload 8
    //   352: new 1338	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 1339	java/lang/StringBuilder:<init>	()V
    //   359: aload 7
    //   361: ldc_w 1341
    //   364: iconst_1
    //   365: invokevirtual 349	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   368: invokevirtual 1345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 1348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: putfield 1351	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEh	Ljava/lang/String;
    //   377: aload 8
    //   379: aload 7
    //   381: ldc_w 465
    //   384: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: putfield 468	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEj	Ljava/lang/String;
    //   390: aload 8
    //   392: aload 7
    //   394: ldc_w 475
    //   397: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 478	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEo	Ljava/lang/String;
    //   403: aload 8
    //   405: aload 7
    //   407: ldc_w 470
    //   410: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: putfield 473	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEk	Ljava/lang/String;
    //   416: aload 8
    //   418: aload 7
    //   420: ldc_w 1353
    //   423: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 1356	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEe	Ljava/lang/String;
    //   429: aload 8
    //   431: aload 7
    //   433: ldc_w 1358
    //   436: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 1361	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEf	Ljava/lang/String;
    //   442: aload 8
    //   444: aload 7
    //   446: ldc_w 1363
    //   449: invokevirtual 443	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   452: putfield 483	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEm	I
    //   455: aload 8
    //   457: aload 7
    //   459: ldc_w 385
    //   462: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 391	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:hAU	Ljava/lang/String;
    //   468: aload 8
    //   470: aload 7
    //   472: ldc_w 528
    //   475: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: putfield 532	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEq	Ljava/lang/String;
    //   481: aload 5
    //   483: getfield 267	com/tencent/mm/plugin/wallet_core/model/Orders:MEq	Ljava/lang/String;
    //   486: invokestatic 564	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   489: ifeq +13 -> 502
    //   492: aload 5
    //   494: aload 8
    //   496: getfield 532	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MEq	Ljava/lang/String;
    //   499: putfield 267	com/tencent/mm/plugin/wallet_core/model/Orders:MEq	Ljava/lang/String;
    //   502: aload 8
    //   504: aload 7
    //   506: ldc_w 1365
    //   509: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   512: putfield 1366	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:hzv	Ljava/lang/String;
    //   515: aload 8
    //   517: aload 7
    //   519: ldc_w 343
    //   522: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: putfield 1369	com/tencent/mm/plugin/wallet_core/model/Orders$Commodity:MDU	Ljava/lang/String;
    //   528: aload 5
    //   530: getfield 206	com/tencent/mm/plugin/wallet_core/model/Orders:VGX	Ljava/util/List;
    //   533: aload 8
    //   535: invokeinterface 567 2 0
    //   540: pop
    //   541: iload_1
    //   542: ifne +649 -> 1191
    //   545: aload 5
    //   547: aload 7
    //   549: ldc_w 1371
    //   552: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   555: putfield 300	com/tencent/mm/plugin/wallet_core/model/Orders:VGS	Ljava/lang/String;
    //   558: aload 5
    //   560: aload 5
    //   562: getfield 300	com/tencent/mm/plugin/wallet_core/model/Orders:VGS	Ljava/lang/String;
    //   565: invokestatic 304	com/tencent/mm/plugin/wallet_core/model/Orders:bgw	(Ljava/lang/String;)Ljava/util/HashSet;
    //   568: putfield 197	com/tencent/mm/plugin/wallet_core/model/Orders:VGT	Ljava/util/Set;
    //   571: goto +620 -> 1191
    //   574: aload_0
    //   575: ldc_w 1373
    //   578: invokevirtual 510	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +338 -> 919
    //   584: aload 5
    //   586: aload_0
    //   587: ldc_w 1373
    //   590: invokestatic 1377	com/tencent/mm/wallet_core/ui/i:u	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   593: putfield 184	com/tencent/mm/plugin/wallet_core/model/Orders:VGO	Z
    //   596: aload 5
    //   598: aload_0
    //   599: invokestatic 1381	com/tencent/mm/plugin/wallet_core/model/Orders:cr	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/wallet/model/h;
    //   602: putfield 211	com/tencent/mm/plugin/wallet_core/model/Orders:VGY	Lcom/tencent/mm/plugin/wallet/model/h;
    //   605: aload_0
    //   606: ldc_w 1383
    //   609: invokevirtual 335	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   612: astore 6
    //   614: aload 6
    //   616: ifnonnull +337 -> 953
    //   619: ldc_w 416
    //   622: ldc_w 1385
    //   625: invokestatic 1209	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 5
    //   630: aload_0
    //   631: ldc_w 1387
    //   634: invokevirtual 443	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   637: putfield 213	com/tencent/mm/plugin/wallet_core/model/Orders:VGZ	I
    //   640: aload 5
    //   642: aload_0
    //   643: ldc_w 1389
    //   646: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   649: putfield 215	com/tencent/mm/plugin/wallet_core/model/Orders:VHa	Ljava/lang/String;
    //   652: aload 5
    //   654: aload_0
    //   655: ldc_w 1391
    //   658: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   661: putfield 217	com/tencent/mm/plugin/wallet_core/model/Orders:VHb	Ljava/lang/String;
    //   664: aload 5
    //   666: aload_0
    //   667: ldc_w 1393
    //   670: invokevirtual 335	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   673: invokestatic 1395	com/tencent/mm/plugin/wallet_core/model/Orders:a	(Lcom/tencent/mm/plugin/wallet_core/model/Orders;Lorg/json/JSONObject;)V
    //   676: aload_0
    //   677: ldc_w 1397
    //   680: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   683: astore 6
    //   685: aload 6
    //   687: invokestatic 564	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   690: ifne +42 -> 732
    //   693: aload 6
    //   695: iconst_0
    //   696: invokestatic 1403	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   699: astore 6
    //   701: new 1405	com/tencent/mm/protocal/protobuf/asu
    //   704: dup
    //   705: invokespecial 1406	com/tencent/mm/protocal/protobuf/asu:<init>	()V
    //   708: aload 6
    //   710: invokevirtual 1410	com/tencent/mm/protocal/protobuf/asu:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   713: checkcast 1405	com/tencent/mm/protocal/protobuf/asu
    //   716: astore 6
    //   718: aload 5
    //   720: getfield 237	com/tencent/mm/plugin/wallet_core/model/Orders:field_infos	Ljava/util/ArrayList;
    //   723: aload 6
    //   725: getfield 1413	com/tencent/mm/protocal/protobuf/asu:field_info	Ljava/util/LinkedList;
    //   728: invokevirtual 1416	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   731: pop
    //   732: aload 5
    //   734: aload_0
    //   735: ldc_w 1418
    //   738: ldc 176
    //   740: invokevirtual 531	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 239	com/tencent/mm/plugin/wallet_core/model/Orders:VHo	Ljava/lang/String;
    //   746: aload 5
    //   748: aload_0
    //   749: ldc_w 1420
    //   752: ldc 170
    //   754: invokevirtual 531	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   757: putfield 1422	com/tencent/mm/plugin/wallet_core/model/Orders:VHp	Ljava/lang/String;
    //   760: aload 5
    //   762: aload_0
    //   763: ldc_w 1424
    //   766: ldc 170
    //   768: invokevirtual 531	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   771: putfield 1426	com/tencent/mm/plugin/wallet_core/model/Orders:VHq	Ljava/lang/String;
    //   774: aload 5
    //   776: aload_0
    //   777: ldc_w 1428
    //   780: ldc 176
    //   782: invokevirtual 531	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 241	com/tencent/mm/plugin/wallet_core/model/Orders:VHr	Ljava/lang/String;
    //   788: aload 5
    //   790: aload_0
    //   791: ldc_w 1430
    //   794: ldc 170
    //   796: invokevirtual 531	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   799: putfield 1432	com/tencent/mm/plugin/wallet_core/model/Orders:VHs	Ljava/lang/String;
    //   802: aload 5
    //   804: aload_0
    //   805: ldc_w 1434
    //   808: ldc 170
    //   810: invokevirtual 531	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: putfield 1436	com/tencent/mm/plugin/wallet_core/model/Orders:VHt	Ljava/lang/String;
    //   816: aload 5
    //   818: aload_0
    //   819: ldc_w 1438
    //   822: iconst_0
    //   823: invokevirtual 349	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   826: putfield 1440	com/tencent/mm/plugin/wallet_core/model/Orders:VHu	I
    //   829: aload_0
    //   830: ldc_w 1383
    //   833: invokevirtual 335	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   836: astore_0
    //   837: aload_0
    //   838: ifnull +72 -> 910
    //   841: aload_0
    //   842: ldc_w 1442
    //   845: invokevirtual 335	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   848: astore_0
    //   849: aload_0
    //   850: ifnull +60 -> 910
    //   853: aload 5
    //   855: new 60	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo
    //   858: dup
    //   859: invokespecial 1443	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:<init>	()V
    //   862: putfield 319	com/tencent/mm/plugin/wallet_core/model/Orders:VHv	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   865: aload 5
    //   867: getfield 319	com/tencent/mm/plugin/wallet_core/model/Orders:VHv	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   870: aload_0
    //   871: ldc_w 1445
    //   874: invokevirtual 443	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   877: putfield 1448	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:VIO	I
    //   880: aload 5
    //   882: getfield 319	com/tencent/mm/plugin/wallet_core/model/Orders:VHv	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   885: aload_0
    //   886: ldc_w 1450
    //   889: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   892: putfield 1453	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:hAk	Ljava/lang/String;
    //   895: aload 5
    //   897: getfield 319	com/tencent/mm/plugin/wallet_core/model/Orders:VHv	Lcom/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo;
    //   900: aload_0
    //   901: ldc_w 1455
    //   904: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   907: putfield 1458	com/tencent/mm/plugin/wallet_core/model/Orders$SimpleCashierInfo:MDt	Ljava/lang/String;
    //   910: ldc_w 1281
    //   913: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: aload 5
    //   918: areturn
    //   919: aload 5
    //   921: aload 5
    //   923: getfield 265	com/tencent/mm/plugin/wallet_core/model/Orders:Vyb	I
    //   926: iconst_2
    //   927: invokestatic 1464	com/tencent/mm/plugin/wallet_core/model/Bankcard:mU	(II)Z
    //   930: putfield 184	com/tencent/mm/plugin/wallet_core/model/Orders:VGO	Z
    //   933: goto -337 -> 596
    //   936: astore_0
    //   937: ldc_w 416
    //   940: aload_0
    //   941: ldc 170
    //   943: iconst_0
    //   944: anewarray 4	java/lang/Object
    //   947: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   950: goto -40 -> 910
    //   953: aload 6
    //   955: ldc_w 1466
    //   958: invokevirtual 335	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   961: astore 6
    //   963: aload 6
    //   965: ifnonnull +15 -> 980
    //   968: ldc_w 416
    //   971: ldc_w 1468
    //   974: invokestatic 1209	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -349 -> 628
    //   980: aload 6
    //   982: ldc_w 1470
    //   985: invokevirtual 335	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   988: astore 6
    //   990: aload 6
    //   992: ifnonnull +15 -> 1007
    //   995: ldc_w 416
    //   998: ldc_w 1472
    //   1001: invokestatic 1209	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: goto -376 -> 628
    //   1007: ldc_w 1474
    //   1010: invokestatic 1480	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1013: checkcast 1474	com/tencent/mm/plugin/fingerprint/mgr/a/i
    //   1016: invokeinterface 1483 1 0
    //   1021: ifne +182 -> 1203
    //   1024: ldc_w 1474
    //   1027: invokestatic 1480	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1030: checkcast 1474	com/tencent/mm/plugin/fingerprint/mgr/a/i
    //   1033: invokeinterface 1486 1 0
    //   1038: ifeq +170 -> 1208
    //   1041: goto +162 -> 1203
    //   1044: iload_1
    //   1045: ifeq +168 -> 1213
    //   1048: aload 6
    //   1050: ldc_w 1488
    //   1053: iconst_0
    //   1054: invokevirtual 349	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1057: istore_1
    //   1058: aload 5
    //   1060: iload_1
    //   1061: putfield 199	com/tencent/mm/plugin/wallet_core/model/Orders:VGU	I
    //   1064: aload 5
    //   1066: aload 6
    //   1068: ldc_w 1490
    //   1071: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: putfield 201	com/tencent/mm/plugin/wallet_core/model/Orders:VGW	Ljava/lang/String;
    //   1077: aload 6
    //   1079: ldc_w 1492
    //   1082: invokevirtual 341	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1085: astore 7
    //   1087: iconst_1
    //   1088: aload 6
    //   1090: ldc_w 1494
    //   1093: invokevirtual 443	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1096: if_icmpne +122 -> 1218
    //   1099: iconst_1
    //   1100: istore 4
    //   1102: aload 5
    //   1104: aload 7
    //   1106: putfield 321	com/tencent/mm/plugin/wallet_core/model/Orders:Hgd	Ljava/lang/String;
    //   1109: aload 5
    //   1111: iload 4
    //   1113: putfield 323	com/tencent/mm/plugin/wallet_core/model/Orders:VGV	Z
    //   1116: getstatic 1500	com/tencent/mm/plugin/fingerprint/mgr/j:Hgj	Lcom/tencent/mm/plugin/fingerprint/mgr/j;
    //   1119: aload 7
    //   1121: putfield 1501	com/tencent/mm/plugin/fingerprint/mgr/j:Hgd	Ljava/lang/String;
    //   1124: getstatic 1500	com/tencent/mm/plugin/fingerprint/mgr/j:Hgj	Lcom/tencent/mm/plugin/fingerprint/mgr/j;
    //   1127: iload 4
    //   1129: putfield 1504	com/tencent/mm/plugin/fingerprint/mgr/j:Hgl	Z
    //   1132: ldc_w 416
    //   1135: ldc_w 1506
    //   1138: iconst_3
    //   1139: anewarray 4	java/lang/Object
    //   1142: dup
    //   1143: iconst_0
    //   1144: aload 5
    //   1146: getfield 199	com/tencent/mm/plugin/wallet_core/model/Orders:VGU	I
    //   1149: invokestatic 1223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_1
    //   1155: aload 7
    //   1157: aastore
    //   1158: dup
    //   1159: iconst_2
    //   1160: iload 4
    //   1162: invokestatic 1511	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1165: aastore
    //   1166: invokestatic 772	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1169: goto -541 -> 628
    //   1172: astore 6
    //   1174: ldc_w 416
    //   1177: aload 6
    //   1179: ldc 170
    //   1181: iconst_0
    //   1182: anewarray 4	java/lang/Object
    //   1185: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private static com.tencent.mm.plugin.wallet.model.h cr(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70354);
    com.tencent.mm.plugin.wallet.model.h localh = new com.tencent.mm.plugin.wallet.model.h();
    paramJSONObject = paramJSONObject.optJSONObject("favinfo");
    if (paramJSONObject == null)
    {
      Log.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
      AppMethodBeat.o(70354);
      return localh;
    }
    localh.Vlu = (paramJSONObject.optLong("tradeAmount") / 100.0D);
    localh.Vlv = (paramJSONObject.optLong("totalFavAmount") / 100.0D);
    localh.Vlw = (paramJSONObject.optLong("afterFavorTradeAmount") / 100.0D);
    localh.Vlx = paramJSONObject.optString("favorComposeId");
    localh.VlA = paramJSONObject.optInt("useNaturalDefense");
    localh.VlB = paramJSONObject.optString("discountWording");
    localh.VlC = paramJSONObject.optString("favorRuleWording");
    localh.VlD = (paramJSONObject.optDouble("showFavorAmount", 0.0D) / 100.0D);
    localh.VlE = (paramJSONObject.optDouble("invariableFavorAmount", 0.0D) / 100.0D);
    localh.VlF = paramJSONObject.optInt("isVariableFavor");
    localh.VlG = paramJSONObject.optString("invariableFavorDesc");
    localh.VlH = paramJSONObject.optString("variableFavorDesc");
    Object localObject1 = paramJSONObject.optJSONArray("tradeFavList");
    int i = 0;
    Object localObject3;
    int j;
    Object localObject4;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).getJSONObject(i);
      localObject2 = new q();
      ((q)localObject2).Vmm = ((JSONObject)localObject3).optInt("favType");
      ((q)localObject2).Vmn = ((JSONObject)localObject3).optInt("favSubType");
      ((q)localObject2).Vmo = ((JSONObject)localObject3).optLong("favProperty");
      ((q)localObject2).Vmp = ((JSONObject)localObject3).optString("favorTypeDesc");
      ((q)localObject2).Vlr = ((JSONObject)localObject3).optString("favId");
      ((q)localObject2).Vmq = ((JSONObject)localObject3).optString("favName");
      ((q)localObject2).Vmr = ((JSONObject)localObject3).optString("favDesc");
      ((q)localObject2).Vls = ((JSONObject)localObject3).optString("favorUseManual");
      ((q)localObject2).Vlt = ((JSONObject)localObject3).optString("favorRemarks");
      ((q)localObject2).Vms = (((JSONObject)localObject3).optLong("favPrice") / 100.0D);
      ((q)localObject2).Vmt = (((JSONObject)localObject3).optLong("realFavFee") / 100.0D);
      ((q)localObject2).Vmu = ((JSONObject)localObject3).optInt("needBankPay");
      ((q)localObject2).Vmv = ((JSONObject)localObject3).optString("bankNo");
      ((q)localObject2).MEo = ((JSONObject)localObject3).optString("bankName");
      ((q)localObject2).Vmw = ((JSONObject)localObject3).optString("bankLogoUrl");
      localObject3 = ((JSONObject)localObject3).optJSONArray("bind_serial_list");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).optString(j);
          ((q)localObject2).Vmx.add(com.tencent.mm.bx.b.cX(((String)localObject4).getBytes()));
          j += 1;
        }
      }
      localh.Vly.add(localObject2);
      i += 1;
    }
    localObject1 = paramJSONObject.optJSONObject("favorComposeList");
    Object localObject5;
    if (localObject1 != null)
    {
      localh.Vlz = new com.tencent.mm.plugin.wallet.model.i();
      localObject1 = ((JSONObject)localObject1).optJSONArray("favorComposeInfo");
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        localObject2 = new j();
        ((j)localObject2).VlN = ((JSONObject)localObject3).optString("faovrComposeId");
        ((j)localObject2).VlO = (((JSONObject)localObject3).optLong("totalFavorAmount") / 100.0D);
        ((j)localObject2).Vlw = (((JSONObject)localObject3).optLong("afterFavorTradeAmount") / 100.0D);
        ((j)localObject2).VlD = (((JSONObject)localObject3).optDouble("showFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).VlE = (((JSONObject)localObject3).optDouble("invariableFavorAmount", 0.0D) / 100.0D);
        ((j)localObject2).VlF = ((JSONObject)localObject3).optInt("isVariableFavor");
        ((j)localObject2).VlG = ((JSONObject)localObject3).optString("invariableFavorDesc");
        ((j)localObject2).VlH = ((JSONObject)localObject3).optString("variableFavorDesc");
        localObject3 = ((JSONObject)localObject3).optJSONArray("composeArray");
        j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(j);
          localObject5 = new com.tencent.mm.plugin.wallet.model.f();
          ((com.tencent.mm.plugin.wallet.model.f)localObject5).Vlr = ((JSONObject)localObject4).optString("favId");
          ((com.tencent.mm.plugin.wallet.model.f)localObject5).Vls = ((JSONObject)localObject4).optString("favorUseManual");
          ((com.tencent.mm.plugin.wallet.model.f)localObject5).Vlt = ((JSONObject)localObject4).optString("favorRemarks");
          ((j)localObject2).VlP.add(localObject5);
          j += 1;
        }
        localh.Vlz.VlL.add(localObject2);
        i += 1;
      }
    }
    localObject1 = new com.tencent.mm.plugin.wallet.model.a();
    Object localObject2 = paramJSONObject.optJSONObject("bank_card_info");
    if (localObject2 != null)
    {
      localObject3 = ((JSONObject)localObject2).optJSONArray("bind_serial_favor_info_list");
      if (localObject3 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject3).length())
        {
          localObject4 = new com.tencent.mm.plugin.wallet.model.c();
          localObject5 = ((JSONArray)localObject3).getJSONObject(i);
          ((com.tencent.mm.plugin.wallet.model.c)localObject4).MDt = ((JSONObject)localObject5).optString("bind_serial");
          localObject5 = ((JSONObject)localObject5).optJSONArray("bind_serial_favor_list");
          if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
          {
            j = 0;
            while (j < ((JSONArray)localObject5).length())
            {
              com.tencent.mm.plugin.wallet.model.d locald = new com.tencent.mm.plugin.wallet.model.d();
              JSONObject localJSONObject = ((JSONArray)localObject5).optJSONObject(j);
              locald.OhO = localJSONObject.optString("favor_desc");
              locald.Vlp = localJSONObject.optInt("is_default_show", 0);
              ((com.tencent.mm.plugin.wallet.model.c)localObject4).Vlo.add(locald);
              j += 1;
            }
          }
          ((com.tencent.mm.plugin.wallet.model.a)localObject1).Vld.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        ((com.tencent.mm.plugin.wallet.model.a)localObject1).Vle = new l();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new m();
          ((m)localObject3).OhO = ((JSONArray)localObject2).optJSONObject(i).optString("favor_desc");
          ((com.tencent.mm.plugin.wallet.model.a)localObject1).Vle.VlU.add(localObject3);
          i += 1;
        }
      }
    }
    localh.VlI = ((com.tencent.mm.plugin.wallet.model.a)localObject1);
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
          localObject2 = new com.tencent.mm.plugin.wallet.model.g();
          ((com.tencent.mm.plugin.wallet.model.g)localObject2).Vlh = ((JSONObject)localObject3).optString("default_fav_comb_id");
          localObject3 = ((JSONObject)localObject3).optJSONObject("payment_channel");
          if (localObject3 != null)
          {
            localObject4 = new k();
            ((k)localObject4).MDt = ((JSONObject)localObject3).optString("bind_serial");
            ((k)localObject4).selected = ((JSONObject)localObject3).optInt("selected");
            ((k)localObject4).VlT = ((JSONObject)localObject3).optString("bankCode");
            ((com.tencent.mm.plugin.wallet.model.g)localObject2).Vlf = ((k)localObject4);
          }
          localh.VlJ.add(localObject2);
        }
        i += 1;
      }
    }
    localObject1 = new com.tencent.mm.plugin.wallet.model.b();
    paramJSONObject = paramJSONObject.optJSONObject("bank_fav_guide");
    if (paramJSONObject != null)
    {
      localObject2 = new k();
      localObject3 = paramJSONObject.optJSONObject("payment_channel");
      if (localObject3 != null)
      {
        ((k)localObject2).VlT = ((JSONObject)localObject3).optString("bankCode");
        ((k)localObject2).selected = ((JSONObject)localObject3).optInt("selected");
        ((k)localObject2).MDt = ((JSONObject)localObject3).optString("bind_serial");
        ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vlf = ((k)localObject2);
      }
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vlg = paramJSONObject.optInt("is_show_guide");
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vlh = paramJSONObject.optString("default_fav_comb_id");
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vli = paramJSONObject.optString("guide_content");
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vlj = paramJSONObject.optString("guide_content_color");
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vlk = paramJSONObject.optString("guide_btn_text");
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vll = paramJSONObject.optString("guide_btn_text_color");
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vlm = paramJSONObject.optString("guide_btn_bg_color");
      ((com.tencent.mm.plugin.wallet.model.b)localObject1).Vln = paramJSONObject.optString("guide_logo");
      localh.VlK = ((com.tencent.mm.plugin.wallet.model.b)localObject1);
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
    ((StringBuilder)localObject).append("reqKey:").append(this.hAT).append("\n");
    ((StringBuilder)localObject).append("token").append(this.token).append("\n");
    ((StringBuilder)localObject).append("num").append(this.num).append("\n");
    ((StringBuilder)localObject).append("totalFee").append(this.hAW).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(70360);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70363);
    paramParcel.writeLong(this.VGF);
    paramParcel.writeString(this.hAT);
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.num);
    paramParcel.writeDouble(this.hAW);
    paramParcel.writeInt(this.Vyb);
    paramParcel.writeString(this.MEq);
    paramParcel.writeDouble(this.OjF);
    paramParcel.writeDouble(this.VGG);
    paramParcel.writeInt(this.VGH);
    paramParcel.writeString(this.VBL);
    paramParcel.writeString(this.VFb);
    paramParcel.writeInt(this.VGI);
    paramParcel.writeString(this.VGJ);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.MpW);
    paramParcel.writeString(this.VGK);
    paramParcel.writeString(this.VGL);
    paramParcel.writeString(this.VGM);
    paramParcel.writeInt(this.VGN);
    if (this.VGO)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.VGP);
      paramParcel.writeString(this.ytZ);
      paramParcel.writeLong(this.VGQ);
      paramParcel.writeString(this.VGR);
      paramParcel.writeTypedList(this.VGX);
      paramParcel.writeString(this.VGS);
      paramParcel.writeInt(this.VGU);
      paramParcel.writeString(this.VGW);
      paramParcel.writeParcelable(this.VHc, 1);
      paramParcel.writeInt(this.VHf);
      paramParcel.writeInt(this.VHg);
      paramParcel.writeInt(this.VHk);
      paramParcel.writeString(this.VHn);
      paramParcel.writeString(this.VHm);
      paramParcel.writeInt(this.VHj);
      paramParcel.writeTypedList(this.VHl);
      paramParcel.writeParcelable(this.VHv, 1);
      paramParcel.writeString(this.Hgd);
      if (!this.VGV) {
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
    public String DUX;
    public String MDU;
    public String MEc;
    public String MEd;
    public String MEe;
    public String MEf;
    public String MEh;
    public String MEj;
    public String MEk;
    public int MEm;
    public String MEo;
    public String MEq;
    public int VGN;
    public String VHA;
    public List<Orders.DiscountInfo> VHB;
    public String VHC;
    public String VHD;
    public String VHE;
    public Orders.RecommendTinyAppInfo VHF;
    public Orders.FinderInfo VHG;
    public Orders.LeadTailViewInfo VHH;
    public Orders.RemarksInfo VHI;
    public List<Orders.Promotions> VHJ;
    public boolean VHK;
    public Orders.a VHL;
    public double VHy;
    public String VHz;
    public String desc;
    public String hAU;
    public String hzv;
    public double wZe;
    
    static
    {
      AppMethodBeat.i(70317);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70317);
    }
    
    public Commodity()
    {
      AppMethodBeat.i(70314);
      this.wZe = 0.0D;
      this.VHy = 0.0D;
      this.VHB = new ArrayList();
      this.VHF = null;
      this.VHG = null;
      this.VHH = null;
      this.VHJ = new ArrayList();
      this.VHK = false;
      this.VHL = new Orders.a();
      AppMethodBeat.o(70314);
    }
    
    public Commodity(Parcel paramParcel)
    {
      AppMethodBeat.i(70315);
      this.wZe = 0.0D;
      this.VHy = 0.0D;
      this.VHB = new ArrayList();
      this.VHF = null;
      this.VHG = null;
      this.VHH = null;
      this.VHJ = new ArrayList();
      this.VHK = false;
      this.VHL = new Orders.a();
      this.MEc = paramParcel.readString();
      this.MEd = paramParcel.readString();
      this.MEe = paramParcel.readString();
      this.MEf = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.MEh = paramParcel.readString();
      this.wZe = paramParcel.readDouble();
      this.MEj = paramParcel.readString();
      this.MEk = paramParcel.readString();
      this.MEm = paramParcel.readInt();
      this.hAU = paramParcel.readString();
      this.MEo = paramParcel.readString();
      this.MEq = paramParcel.readString();
      this.hzv = paramParcel.readString();
      this.MDU = paramParcel.readString();
      this.VHA = paramParcel.readString();
      this.DUX = paramParcel.readString();
      paramParcel.readTypedList(this.VHB, Orders.DiscountInfo.CREATOR);
      this.VHC = paramParcel.readString();
      this.VHE = paramParcel.readString();
      this.VHF = ((Orders.RecommendTinyAppInfo)paramParcel.readParcelable(Orders.RecommendTinyAppInfo.class.getClassLoader()));
      this.VHG = ((Orders.FinderInfo)paramParcel.readParcelable(Orders.FinderInfo.class.getClassLoader()));
      this.VHH = ((Orders.LeadTailViewInfo)paramParcel.readParcelable(Orders.LeadTailViewInfo.class.getClassLoader()));
      paramParcel.readTypedList(this.VHJ, Orders.Promotions.CREATOR);
      this.VHI = ((Orders.RemarksInfo)paramParcel.readParcelable(Orders.RemarksInfo.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.VHK = bool;
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
      paramParcel.writeString(this.MEc);
      paramParcel.writeString(this.MEd);
      paramParcel.writeString(this.MEe);
      paramParcel.writeString(this.MEf);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.MEh);
      paramParcel.writeDouble(this.wZe);
      paramParcel.writeString(this.MEj);
      paramParcel.writeString(this.MEk);
      paramParcel.writeInt(this.MEm);
      paramParcel.writeString(this.hAU);
      paramParcel.writeString(this.MEo);
      paramParcel.writeString(this.MEq);
      paramParcel.writeString(this.hzv);
      paramParcel.writeString(this.MDU);
      paramParcel.writeString(this.VHA);
      paramParcel.writeString(this.DUX);
      paramParcel.writeTypedList(this.VHB);
      paramParcel.writeString(this.VHC);
      paramParcel.writeString(this.VHE);
      paramParcel.writeParcelable(this.VHF, 0);
      paramParcel.writeParcelable(this.VHG, 0);
      paramParcel.writeParcelable(this.VHH, 0);
      paramParcel.writeTypedList(this.VHJ);
      paramParcel.writeParcelable(this.VHI, 0);
      if (this.VHK) {
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
    public String VHM;
    public List<Orders.DeductShowInfo> VHN;
    public int VHO;
    public String VHP;
    public String VHQ;
    public int VnO;
    public String VnP;
    public int VoA;
    public String desc;
    public String title;
    public String wul;
    
    static
    {
      AppMethodBeat.i(70322);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(70322);
    }
    
    public DeductInfo()
    {
      AppMethodBeat.i(70319);
      this.VHN = new ArrayList();
      AppMethodBeat.o(70319);
    }
    
    public DeductInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(70320);
      this.VHN = new ArrayList();
      this.title = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.VoA = paramParcel.readInt();
      this.VHM = paramParcel.readString();
      this.VHO = paramParcel.readInt();
      paramParcel.readTypedList(this.VHN, Orders.DeductShowInfo.CREATOR);
      this.VnO = paramParcel.readInt();
      this.wul = paramParcel.readString();
      this.VnP = paramParcel.readString();
      this.VHP = paramParcel.readString();
      this.VHQ = paramParcel.readString();
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
      paramParcel.writeInt(this.VoA);
      paramParcel.writeString(this.VHM);
      paramParcel.writeInt(this.VHO);
      paramParcel.writeTypedList(this.VHN);
      paramParcel.writeInt(this.VnO);
      paramParcel.writeString(this.wul);
      paramParcel.writeString(this.VnP);
      paramParcel.writeString(this.VHP);
      paramParcel.writeString(this.VHQ);
      AppMethodBeat.o(70321);
    }
  }
  
  public static class DeductShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DeductShowInfo> CREATOR;
    public String VHR;
    public String VHS;
    public String VHT;
    public int mdV;
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
      this.mdV = paramParcel.readInt();
      this.VHR = paramParcel.readString();
      this.VHS = paramParcel.readString();
      this.VHT = paramParcel.readString();
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
      paramParcel.writeInt(this.mdV);
      paramParcel.writeString(this.VHR);
      paramParcel.writeString(this.VHS);
      paramParcel.writeString(this.VHT);
      AppMethodBeat.o(70325);
    }
  }
  
  public static class DiscountInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DiscountInfo> CREATOR;
    public String OhO;
    public double VHU;
    
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
      this.VHU = paramParcel.readDouble();
      this.OhO = paramParcel.readString();
      AppMethodBeat.o(70328);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70329);
      paramParcel.writeDouble(this.VHU);
      paramParcel.writeString(this.OhO);
      AppMethodBeat.o(70329);
    }
  }
  
  public static class FinderInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<FinderInfo> CREATOR;
    public String VHV;
    public String VHW;
    public String VHX;
    public String VHY;
    public String VHZ;
    public String VIa;
    public int VIb;
    public String VIc;
    public String VId;
    public String VIe;
    public String path;
    public int type;
    public String url;
    public String username;
    public String version;
    
    static
    {
      AppMethodBeat.i(301185);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(301185);
    }
    
    public FinderInfo() {}
    
    public FinderInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(301183);
      this.type = paramParcel.readInt();
      this.url = paramParcel.readString();
      this.username = paramParcel.readString();
      this.path = paramParcel.readString();
      this.version = paramParcel.readString();
      this.VHV = paramParcel.readString();
      this.VHW = paramParcel.readString();
      this.VHX = paramParcel.readString();
      this.VHY = paramParcel.readString();
      this.VHZ = paramParcel.readString();
      this.VIa = paramParcel.readString();
      this.VIc = paramParcel.readString();
      this.VId = paramParcel.readString();
      this.VIe = paramParcel.readString();
      this.VIb = paramParcel.readInt();
      AppMethodBeat.o(301183);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(301186);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.path);
      paramParcel.writeString(this.version);
      paramParcel.writeString(this.VHV);
      paramParcel.writeString(this.VHW);
      paramParcel.writeString(this.VHX);
      paramParcel.writeString(this.VHY);
      paramParcel.writeString(this.VHZ);
      paramParcel.writeString(this.VIa);
      paramParcel.writeString(this.VIc);
      paramParcel.writeString(this.VId);
      paramParcel.writeString(this.VIe);
      paramParcel.writeInt(this.VIb);
      AppMethodBeat.o(301186);
    }
  }
  
  public static class LeadTailViewInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LeadTailViewInfo> CREATOR;
    public String VIf;
    public String VIg;
    public String VIh;
    public String VIi;
    public int VIj;
    public String VIk;
    public String VIl;
    public String VIm;
    public String VIn;
    public String VIo;
    public String VIp;
    public String VIq;
    public String desc;
    public int type;
    
    static
    {
      AppMethodBeat.i(301193);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(301193);
    }
    
    public LeadTailViewInfo() {}
    
    public LeadTailViewInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(301192);
      this.desc = paramParcel.readString();
      this.VIf = paramParcel.readString();
      this.VIg = paramParcel.readString();
      this.VIh = paramParcel.readString();
      this.VIi = paramParcel.readString();
      this.type = paramParcel.readInt();
      this.VIj = paramParcel.readInt();
      this.VIk = paramParcel.readString();
      this.VIl = paramParcel.readString();
      this.VIm = paramParcel.readString();
      this.VIn = paramParcel.readString();
      this.VIo = paramParcel.readString();
      this.VIp = paramParcel.readString();
      this.VIq = paramParcel.readString();
      AppMethodBeat.o(301192);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(301199);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.VIf);
      paramParcel.writeString(this.VIg);
      paramParcel.writeString(this.VIh);
      paramParcel.writeString(this.VIi);
      paramParcel.writeInt(this.type);
      paramParcel.writeInt(this.VIj);
      paramParcel.writeString(this.VIk);
      paramParcel.writeString(this.VIl);
      paramParcel.writeString(this.VIm);
      paramParcel.writeString(this.VIn);
      paramParcel.writeString(this.VIo);
      paramParcel.writeString(this.VIp);
      paramParcel.writeString(this.VIq);
      AppMethodBeat.o(301199);
    }
  }
  
  public static class Promotions
    implements Parcelable
  {
    public static final Parcelable.Creator<Promotions> CREATOR;
    public int Avy;
    public String MRI;
    public int VGw;
    public int VGx;
    public long VGy;
    public String VGz;
    public g.a.a.c VIz;
    public int akjp;
    public int akjq;
    public String akjr;
    public String akjs;
    public String akjt;
    public int akju;
    public String akjv;
    public String akjw;
    public long ehe;
    public String hzv;
    public String name;
    public String title;
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
      this.MRI = paramParcel.readString();
      this.name = paramParcel.readString();
      this.VGz = paramParcel.readString();
      this.url = paramParcel.readString();
      this.hzv = paramParcel.readString();
      this.title = paramParcel.readString();
      this.Avy = paramParcel.readInt();
      this.ehe = paramParcel.readLong();
      this.akjp = paramParcel.readInt();
      this.akjq = paramParcel.readInt();
      this.VGw = paramParcel.readInt();
      this.VGx = paramParcel.readInt();
      this.akjr = paramParcel.readString();
      this.akjs = paramParcel.readString();
      this.akjt = paramParcel.readString();
      this.VGy = paramParcel.readLong();
      this.akju = paramParcel.readInt();
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
      paramParcel.writeString(this.MRI);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.VGz);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.hzv);
      paramParcel.writeString(this.title);
      paramParcel.writeInt(this.Avy);
      paramParcel.writeLong(this.ehe);
      paramParcel.writeInt(this.akjp);
      paramParcel.writeInt(this.akjq);
      paramParcel.writeInt(this.VGw);
      paramParcel.writeInt(this.VGx);
      paramParcel.writeString(this.akjr);
      paramParcel.writeString(this.akjs);
      paramParcel.writeString(this.akjt);
      paramParcel.writeLong(this.VGy);
      paramParcel.writeInt(this.akju);
      AppMethodBeat.o(70333);
    }
  }
  
  public static class RecommendTinyAppInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RecommendTinyAppInfo> CREATOR;
    public String VGB;
    public String VGC;
    public String VGD;
    public int VGE;
    public long VIA;
    public long VIB;
    public long VIC;
    public int VID;
    public int VIE;
    public long VIF;
    public String VcU;
    public String VcV;
    public String VsI;
    
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
      this.VsI = paramParcel.readString();
      this.VGB = paramParcel.readString();
      this.VGC = paramParcel.readString();
      this.VcU = paramParcel.readString();
      this.VcV = paramParcel.readString();
      this.VGE = paramParcel.readInt();
      AppMethodBeat.o(70336);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70337);
      paramParcel.writeString(this.VsI);
      paramParcel.writeString(this.VGB);
      paramParcel.writeString(this.VGC);
      paramParcel.writeString(this.VcU);
      paramParcel.writeString(this.VcV);
      paramParcel.writeInt(this.VGE);
      AppMethodBeat.o(70337);
    }
  }
  
  public static class RemarksInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RemarksInfo> CREATOR;
    public String VIG;
    public String VIH;
    
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
      this.VIG = paramParcel.readString();
      this.VIH = paramParcel.readString();
      AppMethodBeat.o(70340);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70341);
      paramParcel.writeString(this.VIG);
      paramParcel.writeString(this.VIH);
      AppMethodBeat.o(70341);
    }
  }
  
  public static class ShowInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ShowInfo> CREATOR;
    public String ICv;
    public String VII;
    public int VIJ;
    public String VIK;
    public String VIL;
    public String VIM;
    public int VIN;
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
      this.ICv = paramParcel.readString();
      this.VII = paramParcel.readString();
      this.VIJ = paramParcel.readInt();
      this.VIK = paramParcel.readString();
      this.VIL = paramParcel.readString();
      this.VIM = paramParcel.readString();
      this.VIN = paramParcel.readInt();
      AppMethodBeat.o(70344);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(70345);
      String str = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.ICv, this.VII, Integer.valueOf(this.VIJ), this.VIK, this.VIL, this.VIM, Integer.valueOf(this.VIN) });
      AppMethodBeat.o(70345);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70346);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.ICv);
      paramParcel.writeString(this.VII);
      paramParcel.writeInt(this.VIJ);
      paramParcel.writeString(this.VIK);
      paramParcel.writeString(this.VIL);
      paramParcel.writeString(this.VIM);
      paramParcel.writeInt(this.VIN);
      AppMethodBeat.o(70346);
    }
  }
  
  public static class SimpleCashierInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleCashierInfo> CREATOR;
    public String MDt;
    public int VIO;
    public String hAk;
    
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
      this.VIO = paramParcel.readInt();
      this.hAk = paramParcel.readString();
      this.MDt = paramParcel.readString();
      AppMethodBeat.o(70349);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(70350);
      paramParcel.writeInt(this.VIO);
      paramParcel.writeString(this.hAk);
      paramParcel.writeString(this.MDt);
      AppMethodBeat.o(70350);
    }
  }
  
  public static final class a
  {
    public String text = "";
    public String url = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders
 * JD-Core Version:    0.7.0.1
 */