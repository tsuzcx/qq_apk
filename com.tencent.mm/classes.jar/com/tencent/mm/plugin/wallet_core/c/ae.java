package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public Orders Bpf;
  
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
        this.Bpf = new Orders();
        paramString = new Orders.Commodity();
        paramString.vwX = paramJSONObject.getString("buy_uin");
        paramString.vwY = paramJSONObject.getString("buy_name");
        paramString.vwZ = paramJSONObject.optString("sale_uin");
        paramString.vxa = paramJSONObject.optString("sale_name");
        paramString.dad = paramJSONObject.getString("trans_id");
        paramString.desc = paramJSONObject.optString("goods_name");
        paramString.oxA = (paramJSONObject.optDouble("pay_num") / 100.0D);
        paramString.vxe = paramJSONObject.getString("trade_state");
        paramString.vxf = paramJSONObject.getString("trade_state_name");
        paramString.vxj = paramJSONObject.getString("buy_bank_name");
        paramString.vxq = paramJSONObject.optString("discount", "");
        paramString.vxh = paramJSONObject.optInt("modify_timestamp");
        paramString.vxl = paramJSONObject.optString("fee_type");
        paramString.vxm = paramJSONObject.optString("appusername");
        paramString.vwP = paramJSONObject.optString("app_telephone");
        paramString.Bys = (paramJSONObject.optDouble("original_total_fee", -1.0D) / 100.0D);
        paramString.vxl = paramJSONObject.optString("fee_type", "");
        paramInt = 1;
        Object localObject1 = paramJSONObject.optJSONObject("subscribe_biz_info");
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = new Orders.Promotions();
          ((Orders.Promotions)localObject2).type = Orders.Byq;
          ((Orders.Promotions)localObject2).name = ((JSONObject)localObject1).optString("nickname");
          ((Orders.Promotions)localObject2).vxm = ((JSONObject)localObject1).optString("username");
          paramString.Byt = ((Orders.Promotions)localObject2).vxm;
          ((Orders.Promotions)localObject2).vFL = ((JSONObject)localObject1).optString("logo_round_url");
          ((Orders.Promotions)localObject2).url = ((JSONObject)localObject1).optString("subscribe_biz_url");
          i = ((JSONObject)localObject1).optInt("recommend_level");
          paramString.BxH = i;
          paramInt = i;
          if (!bs.isNullOrNil(((Orders.Promotions)localObject2).name))
          {
            paramString.ByB.add(localObject2);
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
          ((Orders.Promotions)localObject3).type = Orders.Byr;
          ((Orders.Promotions)localObject3).vFL = ((JSONObject)localObject2).optString("icon");
          ((Orders.Promotions)localObject3).name = ((JSONObject)localObject2).optString("wording");
          ((Orders.Promotions)localObject3).url = ((JSONObject)localObject2).optString("url");
          ((Orders.Promotions)localObject3).Bxt = ((JSONObject)localObject2).optString("btn_text");
          ((Orders.Promotions)localObject3).ByO = ((JSONObject)localObject2).optInt("type");
          ((Orders.Promotions)localObject3).title = ((JSONObject)localObject2).optString("title");
          ((Orders.Promotions)localObject3).BoC = ((JSONObject)localObject2).optLong("activity_id");
          ((Orders.Promotions)localObject3).DeE = ((JSONObject)localObject2).optInt("activity_type", 0);
          ((Orders.Promotions)localObject3).DeF = ((JSONObject)localObject2).optInt("award_id");
          ((Orders.Promotions)localObject3).Bxq = ((JSONObject)localObject2).optInt("send_record_id");
          ((Orders.Promotions)localObject3).Bxr = ((JSONObject)localObject2).optInt("user_record_id");
          ((Orders.Promotions)localObject3).DeH = ((JSONObject)localObject2).optString("activity_tinyapp_username");
          ((Orders.Promotions)localObject3).DeI = ((JSONObject)localObject2).optString("activity_tinyapp_path");
          ((Orders.Promotions)localObject3).Bxs = ((JSONObject)localObject2).optLong("activity_mch_id");
          ((Orders.Promotions)localObject3).DeJ = ((JSONObject)localObject2).optInt("activity_tinyapp_version");
          ((Orders.Promotions)localObject3).GZQ = ((JSONObject)localObject2).optString("get_award_params");
          ((Orders.Promotions)localObject3).GZR = ((JSONObject)localObject2).optString("query_award_status_params");
          Orders.a((Orders.Promotions)localObject3, ((JSONObject)localObject2).optJSONObject("exposure_info"));
          paramString.ByB.add(localObject3);
          i += 1;
        }
        localObject1 = paramJSONObject.optJSONArray("discount_array");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          j = ((JSONArray)localObject1).length();
          paramString.Byv = new ArrayList();
          i = 0;
          while (i < j)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            localObject3 = new Orders.DiscountInfo();
            ((Orders.DiscountInfo)localObject3).ByN = ((JSONObject)localObject2).optDouble("payment_amount");
            ((Orders.DiscountInfo)localObject3).wJS = ((JSONObject)localObject2).optString("favor_desc");
            paramString.Byv.add(localObject3);
            i += 1;
          }
        }
        paramString.Byw = paramJSONObject.optString("rateinfo");
        paramString.Byx = paramJSONObject.optString("discount_rateinfo");
        paramString.Byy = paramJSONObject.optString("original_feeinfo");
        this.Bpf.BxR = new ArrayList();
        this.Bpf.BxR.add(paramString);
        this.Bpf.BxJ = paramJSONObject.optString("trade_state_name");
        this.Bpf.BxH = paramInt;
        AppMethodBeat.o(69956);
        return;
      }
      catch (JSONException paramString)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(69956);
        return;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ae
 * JD-Core Version:    0.7.0.1
 */