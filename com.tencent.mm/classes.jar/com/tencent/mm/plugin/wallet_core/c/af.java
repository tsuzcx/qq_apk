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
  public Orders Vyn;
  
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
        this.Vyn = new Orders();
        paramString = new Orders.Commodity();
        paramString.MEc = paramJSONObject.getString("buy_uin");
        paramString.MEd = paramJSONObject.getString("buy_name");
        paramString.MEe = paramJSONObject.optString("sale_uin");
        paramString.MEf = paramJSONObject.optString("sale_name");
        paramString.hAU = paramJSONObject.getString("trans_id");
        paramString.desc = paramJSONObject.optString("goods_name");
        paramString.wZe = (paramJSONObject.optDouble("pay_num") / 100.0D);
        paramString.MEj = paramJSONObject.getString("trade_state");
        paramString.MEk = paramJSONObject.getString("trade_state_name");
        paramString.MEo = paramJSONObject.getString("buy_bank_name");
        paramString.DUX = paramJSONObject.optString("discount", "");
        paramString.MEm = paramJSONObject.optInt("modify_timestamp");
        paramString.MEq = paramJSONObject.optString("fee_type");
        paramString.hzv = paramJSONObject.optString("appusername");
        paramString.MDU = paramJSONObject.optString("app_telephone");
        paramString.VHy = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
        paramString.MEq = paramJSONObject.optString("fee_type", "");
        paramInt = 1;
        Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = new Orders.Promotions();
          ((Orders.Promotions)localObject2).type = Orders.VHw;
          ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
          ((Orders.Promotions)localObject2).hzv = ((JSONObject)localObject1).optString("username");
          paramString.VHz = ((Orders.Promotions)localObject2).hzv;
          ((Orders.Promotions)localObject2).MRI = ((JSONObject)localObject1).optString("logo_round_url");
          ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
          i = ((JSONObject)localObject1).optInt("recommend_level");
          paramString.VGN = i;
          paramInt = i;
          if (!Util.isNullOrNil(((Orders.Promotions)localObject2).name))
          {
            paramString.VHJ.add(localObject2);
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
          ((Orders.Promotions)localObject3).type = Orders.VHx;
          ((Orders.Promotions)localObject3).MRI = ((JSONObject)localObject2).optString("icon");
          ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
          ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
          ((Orders.Promotions)localObject3).VGz = ((JSONObject)localObject2).optString("btn_text");
          ((Orders.Promotions)localObject3).Avy = ((JSONObject)localObject2).optInt("type");
          ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
          ((Orders.Promotions)localObject3).ehe = ((JSONObject)localObject2).optLong("activity_id");
          ((Orders.Promotions)localObject3).akjp = ((JSONObject)localObject2).optInt("activity_type", 0);
          ((Orders.Promotions)localObject3).akjq = ((JSONObject)localObject2).optInt("award_id");
          ((Orders.Promotions)localObject3).VGw = ((JSONObject)localObject2).optInt("send_record_id");
          ((Orders.Promotions)localObject3).VGx = ((JSONObject)localObject2).optInt("user_record_id");
          ((Orders.Promotions)localObject3).akjs = ((JSONObject)localObject2).optString("activity_tinyapp_username");
          ((Orders.Promotions)localObject3).akjt = ((JSONObject)localObject2).optString("activity_tinyapp_path");
          ((Orders.Promotions)localObject3).VGy = ((JSONObject)localObject2).optLong("activity_mch_id");
          ((Orders.Promotions)localObject3).akju = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
          ((Orders.Promotions)localObject3).akjv = ((JSONObject)localObject2).optString("get_award_params");
          ((Orders.Promotions)localObject3).akjw = ((JSONObject)localObject2).optString("query_award_status_params");
          Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
          paramString.VHJ.add(localObject3);
          i += 1;
        }
        localObject1 = paramJSONObject.optJSONArray("discount_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          j = ((JSONArray)localObject1).length();
          paramString.VHB = new ArrayList();
          i = 0;
          while (i < j)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            localObject3 = new Orders.DiscountInfo();
            ((Orders.DiscountInfo)localObject3).VHU = ((JSONObject)localObject2).optDouble("payment_amount");
            ((Orders.DiscountInfo)localObject3).OhO = ((JSONObject)localObject2).optString("favor_desc");
            paramString.VHB.add(localObject3);
            i += 1;
          }
        }
        paramString.VHC = paramJSONObject.optString("rateinfo");
        paramString.VHD = paramJSONObject.optString("discount_rateinfo");
        paramString.VHE = paramJSONObject.optString("original_feeinfo");
        this.Vyn.VGX = new ArrayList();
        this.Vyn.VGX.add(paramString);
        this.Vyn.VGP = paramJSONObject.optString("trade_state_name");
        this.Vyn.VGN = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.af
 * JD-Core Version:    0.7.0.1
 */