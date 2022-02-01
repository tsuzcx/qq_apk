package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.bu;
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
  public Orders DgZ;
  
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
        this.DgZ = new Orders();
        paramString = new Orders.Commodity();
        paramString.wSc = paramJSONObject.getString("buy_uin");
        paramString.wSd = paramJSONObject.getString("buy_name");
        paramString.wSe = paramJSONObject.optString("sale_uin");
        paramString.wSf = paramJSONObject.optString("sale_name");
        paramString.dmx = paramJSONObject.getString("trans_id");
        paramString.desc = paramJSONObject.optString("goods_name");
        paramString.phz = (paramJSONObject.optDouble("pay_num") / 100.0D);
        paramString.wSj = paramJSONObject.getString("trade_state");
        paramString.wSk = paramJSONObject.getString("trade_state_name");
        paramString.wSo = paramJSONObject.getString("buy_bank_name");
        paramString.wSv = paramJSONObject.optString("discount", "");
        paramString.wSm = paramJSONObject.optInt("modify_timestamp");
        paramString.wSq = paramJSONObject.optString("fee_type");
        paramString.wSr = paramJSONObject.optString("appusername");
        paramString.wRU = paramJSONObject.optString("app_telephone");
        paramString.Dqq = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
        paramString.wSq = paramJSONObject.optString("fee_type", "");
        paramInt = 1;
        Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = new Orders.Promotions();
          ((Orders.Promotions)localObject2).type = Orders.Dqo;
          ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
          ((Orders.Promotions)localObject2).wSr = ((JSONObject)localObject1).optString("username");
          paramString.Dqr = ((Orders.Promotions)localObject2).wSr;
          ((Orders.Promotions)localObject2).xcF = ((JSONObject)localObject1).optString("logo_round_url");
          ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
          i = ((JSONObject)localObject1).optInt("recommend_level");
          paramString.DpF = i;
          paramInt = i;
          if (!bu.isNullOrNil(((Orders.Promotions)localObject2).name))
          {
            paramString.Dqz.add(localObject2);
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
          ((Orders.Promotions)localObject3).type = Orders.Dqp;
          ((Orders.Promotions)localObject3).xcF = ((JSONObject)localObject2).optString("icon");
          ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
          ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
          ((Orders.Promotions)localObject3).Dpr = ((JSONObject)localObject2).optString("btn_text");
          ((Orders.Promotions)localObject3).DqM = ((JSONObject)localObject2).optInt("type");
          ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
          ((Orders.Promotions)localObject3).vlr = ((JSONObject)localObject2).optLong("activity_id");
          ((Orders.Promotions)localObject3).JhR = ((JSONObject)localObject2).optInt("activity_type", 0);
          ((Orders.Promotions)localObject3).JhS = ((JSONObject)localObject2).optInt("award_id");
          ((Orders.Promotions)localObject3).Dpo = ((JSONObject)localObject2).optInt("send_record_id");
          ((Orders.Promotions)localObject3).Dpp = ((JSONObject)localObject2).optInt("user_record_id");
          ((Orders.Promotions)localObject3).JhU = ((JSONObject)localObject2).optString("activity_tinyapp_username");
          ((Orders.Promotions)localObject3).JhV = ((JSONObject)localObject2).optString("activity_tinyapp_path");
          ((Orders.Promotions)localObject3).Dpq = ((JSONObject)localObject2).optLong("activity_mch_id");
          ((Orders.Promotions)localObject3).JhW = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
          ((Orders.Promotions)localObject3).JhX = ((JSONObject)localObject2).optString("get_award_params");
          ((Orders.Promotions)localObject3).JhY = ((JSONObject)localObject2).optString("query_award_status_params");
          Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
          paramString.Dqz.add(localObject3);
          i += 1;
        }
        localObject1 = paramJSONObject.optJSONArray("discount_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          j = ((JSONArray)localObject1).length();
          paramString.Dqt = new ArrayList();
          i = 0;
          while (i < j)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            localObject3 = new Orders.DiscountInfo();
            ((Orders.DiscountInfo)localObject3).DqL = ((JSONObject)localObject2).optDouble("payment_amount");
            ((Orders.DiscountInfo)localObject3).ynr = ((JSONObject)localObject2).optString("favor_desc");
            paramString.Dqt.add(localObject3);
            i += 1;
          }
        }
        paramString.Dqu = paramJSONObject.optString("rateinfo");
        paramString.Dqv = paramJSONObject.optString("discount_rateinfo");
        paramString.Dqw = paramJSONObject.optString("original_feeinfo");
        this.DgZ.DpP = new ArrayList();
        this.DgZ.DpP.add(paramString);
        this.DgZ.DpH = paramJSONObject.optString("trade_state_name");
        this.DgZ.DpF = paramInt;
        AppMethodBeat.o(69956);
        return;
      }
      catch (JSONException paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(69956);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ae
 * JD-Core Version:    0.7.0.1
 */