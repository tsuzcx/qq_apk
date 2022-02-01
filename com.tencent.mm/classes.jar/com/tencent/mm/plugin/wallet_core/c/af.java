package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
  extends m
{
  public Orders OIB;
  
  public af(String paramString)
  {
    AppMethodBeat.i(69954);
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(69954);
  }
  
  public af(String paramString, int paramInt)
  {
    AppMethodBeat.i(69955);
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString);
    localHashMap.put("pay_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(69955);
  }
  
  public final int getTenpayCgicmd()
  {
    return 3;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69956);
    if (paramJSONObject != null) {
      try
      {
        this.OIB = new Orders();
        paramString = new Orders.Commodity();
        paramString.GHl = paramJSONObject.getString("buy_uin");
        paramString.GHm = paramJSONObject.getString("buy_name");
        paramString.GHn = paramJSONObject.optString("sale_uin");
        paramString.GHo = paramJSONObject.optString("sale_name");
        paramString.fww = paramJSONObject.getString("trans_id");
        paramString.desc = paramJSONObject.optString("goods_name");
        paramString.tVK = (paramJSONObject.optDouble("pay_num") / 100.0D);
        paramString.GHs = paramJSONObject.getString("trade_state");
        paramString.GHt = paramJSONObject.getString("trade_state_name");
        paramString.GHx = paramJSONObject.getString("buy_bank_name");
        paramString.GHD = paramJSONObject.optString("discount", "");
        paramString.GHv = paramJSONObject.optInt("modify_timestamp");
        paramString.GHz = paramJSONObject.optString("fee_type");
        paramString.fvb = paramJSONObject.optString("appusername");
        paramString.GHd = paramJSONObject.optString("app_telephone");
        paramString.ORE = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
        paramString.GHz = paramJSONObject.optString("fee_type", "");
        paramInt = 1;
        Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = new Orders.Promotions();
          ((Orders.Promotions)localObject2).type = Orders.ORC;
          ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
          ((Orders.Promotions)localObject2).fvb = ((JSONObject)localObject1).optString("username");
          paramString.ORF = ((Orders.Promotions)localObject2).fvb;
          ((Orders.Promotions)localObject2).GUf = ((JSONObject)localObject1).optString("logo_round_url");
          ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
          i = ((JSONObject)localObject1).optInt("recommend_level");
          paramString.OQT = i;
          paramInt = i;
          if (!Util.isNullOrNil(((Orders.Promotions)localObject2).name))
          {
            paramString.ORO.add(localObject2);
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
          ((Orders.Promotions)localObject3).type = Orders.ORD;
          ((Orders.Promotions)localObject3).GUf = ((JSONObject)localObject2).optString("icon");
          ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
          ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
          ((Orders.Promotions)localObject3).OQF = ((JSONObject)localObject2).optString("btn_text");
          ((Orders.Promotions)localObject3).wYj = ((JSONObject)localObject2).optInt("type");
          ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
          ((Orders.Promotions)localObject3).cpu = ((JSONObject)localObject2).optLong("activity_id");
          ((Orders.Promotions)localObject3).SuA = ((JSONObject)localObject2).optInt("activity_type", 0);
          ((Orders.Promotions)localObject3).SuB = ((JSONObject)localObject2).optInt("award_id");
          ((Orders.Promotions)localObject3).OQC = ((JSONObject)localObject2).optInt("send_record_id");
          ((Orders.Promotions)localObject3).OQD = ((JSONObject)localObject2).optInt("user_record_id");
          ((Orders.Promotions)localObject3).SuD = ((JSONObject)localObject2).optString("activity_tinyapp_username");
          ((Orders.Promotions)localObject3).SuE = ((JSONObject)localObject2).optString("activity_tinyapp_path");
          ((Orders.Promotions)localObject3).OQE = ((JSONObject)localObject2).optLong("activity_mch_id");
          ((Orders.Promotions)localObject3).SuF = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
          ((Orders.Promotions)localObject3).SuG = ((JSONObject)localObject2).optString("get_award_params");
          ((Orders.Promotions)localObject3).SuI = ((JSONObject)localObject2).optString("query_award_status_params");
          Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
          paramString.ORO.add(localObject3);
          i += 1;
        }
        localObject1 = paramJSONObject.optJSONArray("discount_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          j = ((JSONArray)localObject1).length();
          paramString.ORH = new ArrayList();
          i = 0;
          while (i < j)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            localObject3 = new Orders.DiscountInfo();
            ((Orders.DiscountInfo)localObject3).ORZ = ((JSONObject)localObject2).optDouble("payment_amount");
            ((Orders.DiscountInfo)localObject3).Ila = ((JSONObject)localObject2).optString("favor_desc");
            paramString.ORH.add(localObject3);
            i += 1;
          }
        }
        paramString.ORI = paramJSONObject.optString("rateinfo");
        paramString.ORJ = paramJSONObject.optString("discount_rateinfo");
        paramString.ORK = paramJSONObject.optString("original_feeinfo");
        this.OIB.ORd = new ArrayList();
        this.OIB.ORd.add(paramString);
        this.OIB.OQV = paramJSONObject.optString("trade_state_name");
        this.OIB.OQT = paramInt;
        AppMethodBeat.o(69956);
        return;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(69956);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.af
 * JD-Core Version:    0.7.0.1
 */