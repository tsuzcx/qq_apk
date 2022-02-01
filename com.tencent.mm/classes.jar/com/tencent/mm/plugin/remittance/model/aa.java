package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends a
{
  public String iau;
  public String iav;
  public int nTT;
  public String vBQ;
  public String vBR;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(67899);
    this.nTT = 0;
    this.vBQ = "";
    this.vBR = "";
    ad.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(67899);
  }
  
  public final String bOB()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int bOC()
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
    ad.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ad.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(67900);
      return;
    }
    paramString = new StringBuffer();
    this.nTT = paramJSONObject.optInt("currency");
    this.vBQ = paramJSONObject.optString("currencyUint");
    this.vBR = paramJSONObject.optString("currencyWording");
    this.iau = paramJSONObject.optString("notice");
    this.iav = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.nTT);
    paramString.append(" currencyuint:" + this.vBQ);
    paramString.append(" currencywording:" + this.vBR);
    paramString.append(" notice:" + this.iau);
    paramString.append(" notice_url:" + this.iav);
    ad.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(67900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */