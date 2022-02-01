package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aj
  extends a
{
  public String OkQ;
  public String OkR;
  public String pHt;
  public String pHu;
  public int wYR;
  
  public aj(int paramInt)
  {
    AppMethodBeat.i(67899);
    this.wYR = 0;
    this.OkQ = "";
    this.OkR = "";
    Log.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(67899);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int drJ()
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
    this.wYR = paramJSONObject.optInt("currency");
    this.OkQ = paramJSONObject.optString("currencyUint");
    this.OkR = paramJSONObject.optString("currencyWording");
    this.pHt = paramJSONObject.optString("notice");
    this.pHu = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.wYR);
    paramString.append(" currencyuint:" + this.OkQ);
    paramString.append(" currencywording:" + this.OkR);
    paramString.append(" notice:" + this.pHt);
    paramString.append(" notice_url:" + this.pHu);
    Log.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(67900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aj
 * JD-Core Version:    0.7.0.1
 */