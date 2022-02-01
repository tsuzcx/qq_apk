package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends a
{
  public String iAx;
  public String iAy;
  public int oxo;
  public String wLV;
  public String wLW;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(67899);
    this.oxo = 0;
    this.wLV = "";
    this.wLW = "";
    ac.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(67899);
  }
  
  public final String bVR()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int bVS()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1574;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67900);
    ac.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ac.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(67900);
      return;
    }
    paramString = new StringBuffer();
    this.oxo = paramJSONObject.optInt("currency");
    this.wLV = paramJSONObject.optString("currencyUint");
    this.wLW = paramJSONObject.optString("currencyWording");
    this.iAx = paramJSONObject.optString("notice");
    this.iAy = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.oxo);
    paramString.append(" currencyuint:" + this.wLV);
    paramString.append(" currencywording:" + this.wLW);
    paramString.append(" notice:" + this.iAx);
    paramString.append(" notice_url:" + this.iAy);
    ac.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(67900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */