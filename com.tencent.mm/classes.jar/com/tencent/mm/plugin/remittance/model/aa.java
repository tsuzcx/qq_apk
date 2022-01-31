package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends a
{
  public int iHA = 0;
  public String nyt = "";
  public int nyz;
  public String nzC = "";
  public int nzD;
  
  public aa(double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    y.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("transfer_amount", Math.round(100.0D * paramDouble));
      localHashMap.put("pay_nickname", URLEncoder.encode(paramString1, "utf-8"));
      localHashMap.put("rcvd_username", paramString2);
      localHashMap.put("rcvd_nickname", URLEncoder.encode(paramString3, "utf-8"));
      localHashMap.put("reason", URLEncoder.encode(bk.aM(paramString4, ""), "utf-8"));
      localHashMap.put("currency", String.valueOf(paramInt));
      D(localHashMap);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneTenpayh5Pay", "error " + paramString1.getMessage());
      }
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      y.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
      return;
    }
    paramString = new StringBuffer();
    this.nyt = paramJSONObject.optString("payurl");
    this.nzC = paramJSONObject.optString("tradeurl");
    this.nyz = paramJSONObject.optInt("transfering_num");
    this.nzD = paramJSONObject.optInt("transfering_type");
    paramString.append("payurl:" + this.nyt);
    paramString.append(" tradeurl:" + this.nzC);
    paramString.append(" transfering_num:" + this.nyz);
    paramString.append(" transfering_type:" + this.nzD);
    y.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + paramString.toString());
  }
  
  public final int aEA()
  {
    return 1;
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/h5requesttransfer";
  }
  
  public final int getType()
  {
    return 1622;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */