package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z
  extends a
{
  public int iHA = 0;
  public String iHC;
  public String iHD;
  public String nzA = "";
  public String nzB = "";
  
  public z(int paramInt)
  {
    y.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
    HashMap localHashMap = new HashMap();
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      y.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
      return;
    }
    paramString = new StringBuffer();
    this.iHA = paramJSONObject.optInt("currency");
    this.nzA = paramJSONObject.optString("currencyUint");
    this.nzB = paramJSONObject.optString("currencyWording");
    this.iHC = paramJSONObject.optString("notice");
    this.iHD = paramJSONObject.optString("notice_url");
    paramString.append("currency:" + this.iHA);
    paramString.append(" currencyuint:" + this.nzA);
    paramString.append(" currencywording:" + this.nzB);
    paramString.append(" notice:" + this.iHC);
    paramString.append(" notice_url:" + this.iHD);
    y.i("MicroMsg.NetSceneTenpayh5Index", "resp " + paramString.toString());
  }
  
  public final int aEA()
  {
    return 0;
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/h5transferoperate";
  }
  
  public final int getType()
  {
    return 1574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.z
 * JD-Core Version:    0.7.0.1
 */