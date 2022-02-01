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
  public String iTH;
  public String iTI;
  public int paJ;
  public String xZC;
  public String xZD;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(67899);
    this.paJ = 0;
    this.xZC = "";
    this.xZD = "";
    ad.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(67899);
  }
  
  public final String cau()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int cav()
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
    this.paJ = paramJSONObject.optInt("currency");
    this.xZC = paramJSONObject.optString("currencyUint");
    this.xZD = paramJSONObject.optString("currencyWording");
    this.iTH = paramJSONObject.optString("notice");
    this.iTI = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.paJ);
    paramString.append(" currencyuint:" + this.xZC);
    paramString.append(" currencywording:" + this.xZD);
    paramString.append(" notice:" + this.iTH);
    paramString.append(" notice_url:" + this.iTI);
    ad.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(67900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */