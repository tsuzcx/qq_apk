package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab
  extends a
{
  public int oxo;
  public int wKG;
  public String wKz;
  public String wLX;
  public int wLY;
  
  public ab(double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(67901);
    this.oxo = 0;
    this.wKz = "";
    this.wLX = "";
    ac.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("transfer_amount", Math.round(100.0D * paramDouble));
      localHashMap.put("pay_nickname", URLEncoder.encode(paramString1, "utf-8"));
      localHashMap.put("rcvd_username", String.valueOf(paramString2));
      localHashMap.put("rcvd_nickname", URLEncoder.encode(paramString3, "utf-8"));
      localHashMap.put("reason", URLEncoder.encode(bs.bG(paramString4, ""), "utf-8"));
      localHashMap.put("currency", String.valueOf(paramInt));
      setRequestData(localHashMap);
      AppMethodBeat.o(67901);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneTenpayh5Pay", "error " + paramString1.getMessage());
      }
    }
  }
  
  public final String bVR()
  {
    return "/cgi-bin/mmpay-bin/h5requesttransfer";
  }
  
  public final int bVS()
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
    ac.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ac.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
      AppMethodBeat.o(67902);
      return;
    }
    paramString = new StringBuffer();
    this.wKz = paramJSONObject.optString("payurl");
    this.wLX = paramJSONObject.optString("tradeurl");
    this.wKG = paramJSONObject.optInt("transfering_num");
    this.wLY = paramJSONObject.optInt("transfering_type");
    paramString.append("payurl:" + this.wKz);
    paramString.append(" tradeurl:" + this.wLX);
    paramString.append(" transfering_num:" + this.wKG);
    paramString.append(" transfering_type:" + this.wLY);
    ac.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + paramString.toString());
    AppMethodBeat.o(67902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ab
 * JD-Core Version:    0.7.0.1
 */