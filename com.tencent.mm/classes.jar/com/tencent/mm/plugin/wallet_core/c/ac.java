package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
  extends m
{
  public Orders ucc;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(46549);
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(46549);
  }
  
  public ac(String paramString, int paramInt)
  {
    AppMethodBeat.i(46550);
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString);
    localHashMap.put("pay_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(46550);
  }
  
  public final int getTenpayCgicmd()
  {
    return 3;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46551);
    if (paramJSONObject != null) {
      try
      {
        this.ucc = new Orders();
        paramString = new Orders.Commodity();
        paramString.ppb = paramJSONObject.getString("buy_uin");
        paramString.ppc = paramJSONObject.getString("buy_name");
        paramString.ppd = paramJSONObject.optString("sale_uin");
        paramString.ppe = paramJSONObject.optString("sale_name");
        paramString.cnJ = paramJSONObject.getString("trans_id");
        paramString.desc = paramJSONObject.optString("goods_name");
        paramString.kNS = (paramJSONObject.optDouble("pay_num") / 100.0D);
        paramString.ppi = paramJSONObject.getString("trade_state");
        paramString.ppj = paramJSONObject.getString("trade_state_name");
        paramString.ppn = paramJSONObject.getString("buy_bank_name");
        paramString.ppu = paramJSONObject.optString("discount", "");
        paramString.ppl = paramJSONObject.optInt("modify_timestamp");
        paramString.ppp = paramJSONObject.optString("fee_type");
        paramString.ppq = paramJSONObject.optString("appusername");
        paramString.poT = paramJSONObject.optString("app_telephone");
        paramString.ujM = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
        paramString.ppp = paramJSONObject.optString("fee_type", "");
        paramInt = 1;
        Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = new Orders.Promotions();
          ((Orders.Promotions)localObject2).type = Orders.ujK;
          ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
          ((Orders.Promotions)localObject2).ppq = ((JSONObject)localObject1).optString("username");
          paramString.ujN = ((Orders.Promotions)localObject2).ppq;
          ((Orders.Promotions)localObject2).pvi = ((JSONObject)localObject1).optString("logo_round_url");
          ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
          i = ((JSONObject)localObject1).optInt("recommend_level");
          paramString.ujc = i;
          paramInt = i;
          if (!bo.isNullOrNil(((Orders.Promotions)localObject2).name))
          {
            paramString.ujV.add(localObject2);
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
          ((Orders.Promotions)localObject3).type = Orders.ujL;
          ((Orders.Promotions)localObject3).pvi = ((JSONObject)localObject2).optString("icon");
          ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
          ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
          ((Orders.Promotions)localObject3).uiO = ((JSONObject)localObject2).optString("btn_text");
          ((Orders.Promotions)localObject3).uki = ((JSONObject)localObject2).optInt("type");
          ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
          ((Orders.Promotions)localObject3).ubC = ((JSONObject)localObject2).optLong("activity_id");
          ((Orders.Promotions)localObject3).ukk = ((JSONObject)localObject2).optInt("activity_type", 0);
          ((Orders.Promotions)localObject3).ukl = ((JSONObject)localObject2).optInt("award_id");
          ((Orders.Promotions)localObject3).uiL = ((JSONObject)localObject2).optInt("send_record_id");
          ((Orders.Promotions)localObject3).uiM = ((JSONObject)localObject2).optInt("user_record_id");
          ((Orders.Promotions)localObject3).ukn = ((JSONObject)localObject2).optString("activity_tinyapp_username");
          ((Orders.Promotions)localObject3).uko = ((JSONObject)localObject2).optString("activity_tinyapp_path");
          ((Orders.Promotions)localObject3).uiN = ((JSONObject)localObject2).optLong("activity_mch_id");
          ((Orders.Promotions)localObject3).ukp = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
          ((Orders.Promotions)localObject3).ukq = ((JSONObject)localObject2).optString("get_award_params");
          ((Orders.Promotions)localObject3).uWi = ((JSONObject)localObject2).optString("query_award_status_params");
          Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
          paramString.ujV.add(localObject3);
          i += 1;
        }
        localObject1 = paramJSONObject.optJSONArray("discount_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          j = ((JSONArray)localObject1).length();
          paramString.ujP = new ArrayList();
          i = 0;
          while (i < j)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            localObject3 = new Orders.DiscountInfo();
            ((Orders.DiscountInfo)localObject3).ukh = ((JSONObject)localObject2).optDouble("payment_amount");
            ((Orders.DiscountInfo)localObject3).qiO = ((JSONObject)localObject2).optString("favor_desc");
            paramString.ujP.add(localObject3);
            i += 1;
          }
        }
        paramString.ujQ = paramJSONObject.optString("rateinfo");
        paramString.ujR = paramJSONObject.optString("discount_rateinfo");
        paramString.ujS = paramJSONObject.optString("original_feeinfo");
        this.ucc.ujl = new ArrayList();
        this.ucc.ujl.add(paramString);
        this.ucc.uje = paramJSONObject.optString("trade_state_name");
        this.ucc.ujc = paramInt;
        AppMethodBeat.o(46551);
        return;
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(46551);
        return;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(46551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */