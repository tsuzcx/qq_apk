package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ai
  extends a
{
  public String InC;
  public String InD;
  public String mKL;
  public String mKM;
  public int tVx;
  
  public ai(int paramInt)
  {
    AppMethodBeat.i(67899);
    this.tVx = 0;
    this.InC = "";
    this.InD = "";
    Log.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(67899);
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int cOe()
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
    Log.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      Log.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(67900);
      return;
    }
    paramString = new StringBuffer();
    this.tVx = paramJSONObject.optInt("currency");
    this.InC = paramJSONObject.optString("currencyUint");
    this.InD = paramJSONObject.optString("currencyWording");
    this.mKL = paramJSONObject.optString("notice");
    this.mKM = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.tVx);
    paramString.append(" currencyuint:" + this.InC);
    paramString.append(" currencywording:" + this.InD);
    paramString.append(" notice:" + this.mKL);
    paramString.append(" notice_url:" + this.mKM);
    Log.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(67900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ai
 * JD-Core Version:    0.7.0.1
 */