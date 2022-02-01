package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab
  extends a
{
  public int phn;
  public String ynY;
  public int yof;
  public String ypw;
  public int ypx;
  
  public ab(double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(67901);
    this.phn = 0;
    this.ynY = "";
    this.ypw = "";
    ae.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("transfer_amount", Math.round(100.0D * paramDouble));
      localHashMap.put("pay_nickname", URLEncoder.encode(paramString1, "utf-8"));
      localHashMap.put("rcvd_username", String.valueOf(paramString2));
      localHashMap.put("rcvd_nickname", URLEncoder.encode(paramString3, "utf-8"));
      localHashMap.put("reason", URLEncoder.encode(bu.bI(paramString4, ""), "utf-8"));
      localHashMap.put("currency", String.valueOf(paramInt));
      setRequestData(localHashMap);
      AppMethodBeat.o(67901);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneTenpayh5Pay", "error " + paramString1.getMessage());
      }
    }
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/h5requesttransfer";
  }
  
  public final int cbK()
  {
    return 1;
  }
  
  public final int getType()
  {
    return 1622;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67902);
    ae.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ae.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
      AppMethodBeat.o(67902);
      return;
    }
    paramString = new StringBuffer();
    this.ynY = paramJSONObject.optString("payurl");
    this.ypw = paramJSONObject.optString("tradeurl");
    this.yof = paramJSONObject.optInt("transfering_num");
    this.ypx = paramJSONObject.optInt("transfering_type");
    paramString.append("payurl:" + this.ynY);
    paramString.append(" tradeurl:" + this.ypw);
    paramString.append(" transfering_num:" + this.yof);
    paramString.append(" transfering_type:" + this.ypx);
    ae.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + paramString.toString());
    AppMethodBeat.o(67902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ab
 * JD-Core Version:    0.7.0.1
 */