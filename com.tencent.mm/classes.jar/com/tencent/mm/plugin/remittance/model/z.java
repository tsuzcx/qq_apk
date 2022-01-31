package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z
  extends a
{
  public int kNE;
  public String kNG;
  public String kNH;
  public String qkM;
  public String qkN;
  
  public z(int paramInt)
  {
    AppMethodBeat.i(44790);
    this.kNE = 0;
    this.qkM = "";
    this.qkN = "";
    ab.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(44790);
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int bhH()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1574;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44791);
    ab.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ab.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(44791);
      return;
    }
    paramString = new StringBuffer();
    this.kNE = paramJSONObject.optInt("currency");
    this.qkM = paramJSONObject.optString("currencyUint");
    this.qkN = paramJSONObject.optString("currencyWording");
    this.kNG = paramJSONObject.optString("notice");
    this.kNH = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.kNE);
    paramString.append(" currencyuint:" + this.qkM);
    paramString.append(" currencywording:" + this.qkN);
    paramString.append(" notice:" + this.kNG);
    paramString.append(" notice_url:" + this.kNH);
    ab.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
    AppMethodBeat.o(44791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.z
 * JD-Core Version:    0.7.0.1
 */