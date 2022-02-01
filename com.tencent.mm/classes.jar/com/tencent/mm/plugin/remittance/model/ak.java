package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ak
  extends a
{
  public int OjB;
  public String Ojh;
  public String OkS;
  public int OkT;
  public int wYR;
  
  public ak(double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(67901);
    this.wYR = 0;
    this.Ojh = "";
    this.OkS = "";
    Log.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("transfer_amount", Math.round(100.0D * paramDouble));
      localHashMap.put("pay_nickname", URLEncoder.encode(paramString1, "utf-8"));
      localHashMap.put("rcvd_username", String.valueOf(paramString2));
      localHashMap.put("rcvd_nickname", URLEncoder.encode(paramString3, "utf-8"));
      localHashMap.put("reason", URLEncoder.encode(Util.nullAs(paramString4, ""), "utf-8"));
      localHashMap.put("currency", String.valueOf(paramInt));
      setRequestData(localHashMap);
      AppMethodBeat.o(67901);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneTenpayh5Pay", "error " + paramString1.getMessage());
      }
    }
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/h5requesttransfer";
  }
  
  public final int drJ()
  {
    return 1;
  }
  
  public final int getType()
  {
    return 1622;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67902);
    Log.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      Log.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
      AppMethodBeat.o(67902);
      return;
    }
    paramString = new StringBuffer();
    this.Ojh = paramJSONObject.optString("payurl");
    this.OkS = paramJSONObject.optString("tradeurl");
    this.OjB = paramJSONObject.optInt("transfering_num");
    this.OkT = paramJSONObject.optInt("transfering_type");
    paramString.append("payurl:" + this.Ojh);
    paramString.append(" tradeurl:" + this.OkS);
    paramString.append(" transfering_num:" + this.OjB);
    paramString.append(" transfering_type:" + this.OkT);
    Log.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + paramString.toString());
    AppMethodBeat.o(67902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ak
 * JD-Core Version:    0.7.0.1
 */