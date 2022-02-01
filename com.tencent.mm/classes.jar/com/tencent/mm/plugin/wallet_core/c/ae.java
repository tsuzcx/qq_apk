package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
  extends m
{
  public Orders zWL;
  
  public ae(String paramString)
  {
    AppMethodBeat.i(69954);
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(69954);
  }
  
  public ae(String paramString, int paramInt)
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
        this.zWL = new Orders();
        paramString = new Orders.Commodity();
        paramString.uob = paramJSONObject.getString("buy_uin");
        paramString.uoc = paramJSONObject.getString("buy_name");
        paramString.uod = paramJSONObject.optString("sale_uin");
        paramString.uoe = paramJSONObject.optString("sale_name");
        paramString.dcF = paramJSONObject.getString("trans_id");
        paramString.desc = paramJSONObject.optString("goods_name");
        paramString.nUf = (paramJSONObject.optDouble("pay_num") / 100.0D);
        paramString.uoi = paramJSONObject.getString("trade_state");
        paramString.uoj = paramJSONObject.getString("trade_state_name");
        paramString.uon = paramJSONObject.getString("buy_bank_name");
        paramString.uou = paramJSONObject.optString("discount", "");
        paramString.uol = paramJSONObject.optInt("modify_timestamp");
        paramString.uop = paramJSONObject.optString("fee_type");
        paramString.uoq = paramJSONObject.optString("appusername");
        paramString.unT = paramJSONObject.optString("app_telephone");
        paramString.AfY = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
        paramString.uop = paramJSONObject.optString("fee_type", "");
        paramInt = 1;
        Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = new Orders.Promotions();
          ((Orders.Promotions)localObject2).type = Orders.AfW;
          ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
          ((Orders.Promotions)localObject2).uoq = ((JSONObject)localObject1).optString("username");
          paramString.AfZ = ((Orders.Promotions)localObject2).uoq;
          ((Orders.Promotions)localObject2).uwS = ((JSONObject)localObject1).optString("logo_round_url");
          ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
          i = ((JSONObject)localObject1).optInt("recommend_level");
          paramString.Afn = i;
          paramInt = i;
          if (!bt.isNullOrNil(((Orders.Promotions)localObject2).name))
          {
            paramString.Agh.add(localObject2);
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
          ((Orders.Promotions)localObject3).type = Orders.AfX;
          ((Orders.Promotions)localObject3).uwS = ((JSONObject)localObject2).optString("icon");
          ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
          ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
          ((Orders.Promotions)localObject3).AeZ = ((JSONObject)localObject2).optString("btn_text");
          ((Orders.Promotions)localObject3).Agu = ((JSONObject)localObject2).optInt("type");
          ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
          ((Orders.Promotions)localObject3).zWi = ((JSONObject)localObject2).optLong("activity_id");
          ((Orders.Promotions)localObject3).LvT = ((JSONObject)localObject2).optInt("activity_type", 0);
          ((Orders.Promotions)localObject3).LvU = ((JSONObject)localObject2).optInt("award_id");
          ((Orders.Promotions)localObject3).AeW = ((JSONObject)localObject2).optInt("send_record_id");
          ((Orders.Promotions)localObject3).AeX = ((JSONObject)localObject2).optInt("user_record_id");
          ((Orders.Promotions)localObject3).LvW = ((JSONObject)localObject2).optString("activity_tinyapp_username");
          ((Orders.Promotions)localObject3).LvX = ((JSONObject)localObject2).optString("activity_tinyapp_path");
          ((Orders.Promotions)localObject3).AeY = ((JSONObject)localObject2).optLong("activity_mch_id");
          ((Orders.Promotions)localObject3).LvY = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
          ((Orders.Promotions)localObject3).LvZ = ((JSONObject)localObject2).optString("get_award_params");
          ((Orders.Promotions)localObject3).Lwa = ((JSONObject)localObject2).optString("query_award_status_params");
          Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
          paramString.Agh.add(localObject3);
          i += 1;
        }
        localObject1 = paramJSONObject.optJSONArray("discount_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          j = ((JSONArray)localObject1).length();
          paramString.Agb = new ArrayList();
          i = 0;
          while (i < j)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            localObject3 = new Orders.DiscountInfo();
            ((Orders.DiscountInfo)localObject3).Agt = ((JSONObject)localObject2).optDouble("payment_amount");
            ((Orders.DiscountInfo)localObject3).vzN = ((JSONObject)localObject2).optString("favor_desc");
            paramString.Agb.add(localObject3);
            i += 1;
          }
        }
        paramString.Agc = paramJSONObject.optString("rateinfo");
        paramString.Agd = paramJSONObject.optString("discount_rateinfo");
        paramString.Age = paramJSONObject.optString("original_feeinfo");
        this.zWL.Afx = new ArrayList();
        this.zWL.Afx.add(paramString);
        this.zWL.Afp = paramJSONObject.optString("trade_state_name");
        this.zWL.Afn = paramInt;
        AppMethodBeat.o(69956);
        return;
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(69956);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ae
 * JD-Core Version:    0.7.0.1
 */