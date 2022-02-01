package com.tencent.mm.plugin.wallet_core.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class a
  extends m
{
  private int VyE;
  public Orders VyF;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69979);
    Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "do NetSceneGetPaidOrderDetail");
    this.VyE = paramInt;
    HashMap localHashMap = new HashMap();
    if (Util.isNullOrNil(paramString1))
    {
      localHashMap.put("appId", paramString1);
      if (!Util.isNullOrNil(paramString2)) {
        break label203;
      }
      label56:
      localHashMap.put("timeStamp", paramString2);
      if (!Util.isNullOrNil(paramString3)) {
        break label211;
      }
      label74:
      localHashMap.put("nonceStr", paramString3);
      if (!Util.isNullOrNil(paramString4)) {
        break label219;
      }
      label93:
      localHashMap.put("package", paramString4);
      if (!Util.isNullOrNil(paramString5)) {
        break label229;
      }
      label113:
      localHashMap.put("reqKey", paramString5);
      localHashMap.put("payScene", r.cg(String.valueOf(paramInt)));
      if (!Util.isNullOrNil(paramString6)) {
        break label239;
      }
      label151:
      localHashMap.put("signType", paramString6);
      if (!Util.isNullOrNil(paramString7)) {
        break label249;
      }
    }
    for (;;)
    {
      localHashMap.put("paySign", paramString7);
      setRequestData(localHashMap);
      AppMethodBeat.o(69979);
      return;
      paramString1 = r.cg(paramString1);
      break;
      label203:
      paramString2 = r.cg(paramString2);
      break label56;
      label211:
      paramString3 = r.cg(paramString3);
      break label74;
      label219:
      paramString4 = r.cg(paramString4);
      break label93;
      label229:
      paramString5 = r.cg(paramString5);
      break label113;
      label239:
      paramString6 = r.cg(paramString6);
      break label151;
      label249:
      paramString7 = r.cg(paramString7);
    }
  }
  
  private Orders ce(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69981);
    if (this.VyF == null) {
      this.VyF = new Orders();
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("payresult");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        Orders.Commodity localCommodity = new Orders.Commodity();
        localCommodity.hAU = localJSONObject.getString("transaction_id");
        localCommodity.MEf = localJSONObject.optString("sp_name");
        if (Util.isNullOrNil(this.VyF.MEq)) {
          this.VyF.MEq = localJSONObject.optString("fee_type");
        }
        this.VyF.VGX.add(localCommodity);
        i += 1;
      }
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject = this.VyF;
      AppMethodBeat.o(69981);
    }
  }
  
  public final int getFuncId()
  {
    int i = 2570;
    if (this.VyE == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final int getTenpayCgicmd()
  {
    int i = 2570;
    if (this.VyE == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final String getUri()
  {
    String str = "/cgi-bin/mmpay-bin/tenpay/getpaidorderdetail";
    if (this.VyE == 2) {
      str = "/cgi-bin/mmpay-bin/tenpay/offlinegetpaidorderdetail";
    }
    return str;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69980);
    Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "errCode: " + paramInt + " errMsg: " + paramString);
    if ((paramJSONObject != null) && (isPayEnd()))
    {
      this.VyF = ce(paramJSONObject);
      this.VyF = Orders.a(paramJSONObject, this.VyF);
    }
    AppMethodBeat.o(69980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c.a
 * JD-Core Version:    0.7.0.1
 */