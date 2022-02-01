package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends a
{
  public String Cql;
  public String Cqm;
  public String jTx;
  public String jTy;
  public int qww;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(67899);
    this.qww = 0;
    this.Cql = "";
    this.Cqm = "";
    Log.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(67899);
  }
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int czE()
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
    this.qww = paramJSONObject.optInt("currency");
    this.Cql = paramJSONObject.optString("currencyUint");
    this.Cqm = paramJSONObject.optString("currencyWording");
    this.jTx = paramJSONObject.optString("notice");
    this.jTy = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.qww);
    paramString.append(" currencyuint:" + this.Cql);
    paramString.append(" currencywording:" + this.Cqm);
    paramString.append(" notice:" + this.jTx);
    paramString.append(" notice_url:" + this.jTy);
    Log.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(67900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */