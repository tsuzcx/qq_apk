package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends j
{
  public Orders qre;
  
  public z(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString);
    D(localHashMap);
  }
  
  public z(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString);
    localHashMap.put("pay_type", String.valueOf(paramInt));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      this.qre = new Orders();
      paramString = new Orders.Commodity();
      paramString.mOL = paramJSONObject.getString("buy_uin");
      paramString.mOM = paramJSONObject.getString("buy_name");
      paramString.mON = paramJSONObject.optString("sale_uin");
      paramString.mOO = paramJSONObject.optString("sale_name");
      paramString.bMY = paramJSONObject.getString("trans_id");
      paramString.desc = paramJSONObject.optString("goods_name");
      paramString.iHP = (paramJSONObject.optDouble("pay_num") / 100.0D);
      paramString.mOS = paramJSONObject.getString("trade_state");
      paramString.mOT = paramJSONObject.getString("trade_state_name");
      paramString.mOX = paramJSONObject.getString("buy_bank_name");
      paramString.mPe = paramJSONObject.optString("discount", "");
      paramString.mOV = paramJSONObject.optInt("modify_timestamp");
      paramString.mOZ = paramJSONObject.optString("fee_type");
      paramString.mPa = paramJSONObject.optString("appusername");
      paramString.mOD = paramJSONObject.optString("app_telephone");
      paramString.qxe = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
      paramString.mOZ = paramJSONObject.optString("fee_type", "");
      paramInt = 1;
      Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new Orders.Promotions();
        ((Orders.Promotions)localObject2).type = Orders.qxc;
        ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
        ((Orders.Promotions)localObject2).mPa = ((JSONObject)localObject1).optString("username");
        paramString.qxf = ((Orders.Promotions)localObject2).mPa;
        ((Orders.Promotions)localObject2).mTc = ((JSONObject)localObject1).optString("logo_round_url");
        ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
        i = ((JSONObject)localObject1).optInt("recommend_level");
        paramString.qwE = i;
        paramInt = i;
        if (!bk.bl(((Orders.Promotions)localObject2).name))
        {
          paramString.qxn.add(localObject2);
          paramInt = i;
        }
      }
      localObject1 = paramJSONObject.getJSONArray("activity_info");
      int j = ((JSONArray)localObject1).length();
      int i = 0;
      Object localObject3;
      while (i < j)
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        localObject3 = new Orders.Promotions();
        ((Orders.Promotions)localObject3).type = Orders.qxd;
        ((Orders.Promotions)localObject3).mTc = ((JSONObject)localObject2).optString("icon");
        ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
        ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
        ((Orders.Promotions)localObject3).qwp = ((JSONObject)localObject2).optString("btn_text");
        ((Orders.Promotions)localObject3).qxA = ((JSONObject)localObject2).optInt("type");
        ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
        ((Orders.Promotions)localObject3).qqG = ((JSONObject)localObject2).optLong("activity_id");
        ((Orders.Promotions)localObject3).qxB = ((JSONObject)localObject2).optInt("activity_type", 0);
        ((Orders.Promotions)localObject3).qxC = ((JSONObject)localObject2).optInt("award_id");
        ((Orders.Promotions)localObject3).qwm = ((JSONObject)localObject2).optInt("send_record_id");
        ((Orders.Promotions)localObject3).qwn = ((JSONObject)localObject2).optInt("user_record_id");
        ((Orders.Promotions)localObject3).qxE = ((JSONObject)localObject2).optString("activity_tinyapp_username");
        ((Orders.Promotions)localObject3).qxF = ((JSONObject)localObject2).optString("activity_tinyapp_path");
        ((Orders.Promotions)localObject3).qwo = ((JSONObject)localObject2).optLong("activity_mch_id");
        ((Orders.Promotions)localObject3).qxG = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
        ((Orders.Promotions)localObject3).qxH = ((JSONObject)localObject2).optString("get_award_params");
        ((Orders.Promotions)localObject3).qxI = ((JSONObject)localObject2).optString("query_award_status_params");
        Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
        paramString.qxn.add(localObject3);
        i += 1;
      }
      localObject1 = paramJSONObject.optJSONArray("discount_array");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        j = ((JSONArray)localObject1).length();
        paramString.qxh = new ArrayList();
        i = 0;
        while (i < j)
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).qxz = ((JSONObject)localObject2).optDouble("payment_amount");
          ((Orders.DiscountInfo)localObject3).nxN = ((JSONObject)localObject2).optString("favor_desc");
          paramString.qxh.add(localObject3);
          i += 1;
        }
      }
      paramString.qxi = paramJSONObject.optString("rateinfo");
      paramString.qxj = paramJSONObject.optString("discount_rateinfo");
      paramString.qxk = paramJSONObject.optString("original_feeinfo");
      this.qre.qwN = new ArrayList();
      this.qre.qwN.add(paramString);
      this.qre.qwG = paramJSONObject.optString("trade_state_name");
      this.qre.qwE = paramInt;
      return;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
    }
  }
  
  public final int aEC()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */