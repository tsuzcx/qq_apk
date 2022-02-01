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
  public Orders CPv;
  
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
        this.CPv = new Orders();
        paramString = new Orders.Commodity();
        paramString.wCr = paramJSONObject.getString("buy_uin");
        paramString.wCs = paramJSONObject.getString("buy_name");
        paramString.wCt = paramJSONObject.optString("sale_uin");
        paramString.wCu = paramJSONObject.optString("sale_name");
        paramString.dlv = paramJSONObject.getString("trans_id");
        paramString.desc = paramJSONObject.optString("goods_name");
        paramString.paV = (paramJSONObject.optDouble("pay_num") / 100.0D);
        paramString.wCy = paramJSONObject.getString("trade_state");
        paramString.wCz = paramJSONObject.getString("trade_state_name");
        paramString.wCD = paramJSONObject.getString("buy_bank_name");
        paramString.wCK = paramJSONObject.optString("discount", "");
        paramString.wCB = paramJSONObject.optInt("modify_timestamp");
        paramString.wCF = paramJSONObject.optString("fee_type");
        paramString.wCG = paramJSONObject.optString("appusername");
        paramString.wCj = paramJSONObject.optString("app_telephone");
        paramString.CYL = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
        paramString.wCF = paramJSONObject.optString("fee_type", "");
        paramInt = 1;
        Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = new Orders.Promotions();
          ((Orders.Promotions)localObject2).type = Orders.CYJ;
          ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
          ((Orders.Promotions)localObject2).wCG = ((JSONObject)localObject1).optString("username");
          paramString.CYM = ((Orders.Promotions)localObject2).wCG;
          ((Orders.Promotions)localObject2).wMR = ((JSONObject)localObject1).optString("logo_round_url");
          ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
          i = ((JSONObject)localObject1).optInt("recommend_level");
          paramString.CYa = i;
          paramInt = i;
          if (!bt.isNullOrNil(((Orders.Promotions)localObject2).name))
          {
            paramString.CYU.add(localObject2);
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
          ((Orders.Promotions)localObject3).type = Orders.CYK;
          ((Orders.Promotions)localObject3).wMR = ((JSONObject)localObject2).optString("icon");
          ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
          ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
          ((Orders.Promotions)localObject3).CXM = ((JSONObject)localObject2).optString("btn_text");
          ((Orders.Promotions)localObject3).CZh = ((JSONObject)localObject2).optInt("type");
          ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
          ((Orders.Promotions)localObject3).COR = ((JSONObject)localObject2).optLong("activity_id");
          ((Orders.Promotions)localObject3).OdM = ((JSONObject)localObject2).optInt("activity_type", 0);
          ((Orders.Promotions)localObject3).OdN = ((JSONObject)localObject2).optInt("award_id");
          ((Orders.Promotions)localObject3).CXJ = ((JSONObject)localObject2).optInt("send_record_id");
          ((Orders.Promotions)localObject3).CXK = ((JSONObject)localObject2).optInt("user_record_id");
          ((Orders.Promotions)localObject3).OdP = ((JSONObject)localObject2).optString("activity_tinyapp_username");
          ((Orders.Promotions)localObject3).OdQ = ((JSONObject)localObject2).optString("activity_tinyapp_path");
          ((Orders.Promotions)localObject3).CXL = ((JSONObject)localObject2).optLong("activity_mch_id");
          ((Orders.Promotions)localObject3).OdR = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
          ((Orders.Promotions)localObject3).OdS = ((JSONObject)localObject2).optString("get_award_params");
          ((Orders.Promotions)localObject3).OdT = ((JSONObject)localObject2).optString("query_award_status_params");
          Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
          paramString.CYU.add(localObject3);
          i += 1;
        }
        localObject1 = paramJSONObject.optJSONArray("discount_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          j = ((JSONArray)localObject1).length();
          paramString.CYO = new ArrayList();
          i = 0;
          while (i < j)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            localObject3 = new Orders.DiscountInfo();
            ((Orders.DiscountInfo)localObject3).CZg = ((JSONObject)localObject2).optDouble("payment_amount");
            ((Orders.DiscountInfo)localObject3).xXz = ((JSONObject)localObject2).optString("favor_desc");
            paramString.CYO.add(localObject3);
            i += 1;
          }
        }
        paramString.CYP = paramJSONObject.optString("rateinfo");
        paramString.CYQ = paramJSONObject.optString("discount_rateinfo");
        paramString.CYR = paramJSONObject.optString("original_feeinfo");
        this.CPv.CYk = new ArrayList();
        this.CPv.CYk.add(paramString);
        this.CPv.CYc = paramJSONObject.optString("trade_state_name");
        this.CPv.CYa = paramInt;
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