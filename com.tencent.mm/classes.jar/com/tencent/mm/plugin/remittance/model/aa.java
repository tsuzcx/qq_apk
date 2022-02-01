package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends a
{
  public String iWA;
  public String iWB;
  public int phn;
  public String ypu;
  public String ypv;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(67899);
    this.phn = 0;
    this.ypu = "";
    this.ypv = "";
    ae.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(67899);
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int cbK()
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
    ae.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ae.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(67900);
      return;
    }
    paramString = new StringBuffer();
    this.phn = paramJSONObject.optInt("currency");
    this.ypu = paramJSONObject.optString("currencyUint");
    this.ypv = paramJSONObject.optString("currencyWording");
    this.iWA = paramJSONObject.optString("notice");
    this.iWB = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.phn);
    paramString.append(" currencyuint:" + this.ypu);
    paramString.append(" currencywording:" + this.ypv);
    paramString.append(" notice:" + this.iWA);
    paramString.append(" notice_url:" + this.iWB);
    ae.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(67900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */