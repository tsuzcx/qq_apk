package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab
  extends a
{
  public int nTT;
  public int vAB;
  public String vAu;
  public String vBS;
  public int vBT;
  
  public ab(double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(67901);
    this.nTT = 0;
    this.vAu = "";
    this.vBS = "";
    ad.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("transfer_amount", Math.round(100.0D * paramDouble));
      localHashMap.put("pay_nickname", URLEncoder.encode(paramString1, "utf-8"));
      localHashMap.put("rcvd_username", String.valueOf(paramString2));
      localHashMap.put("rcvd_nickname", URLEncoder.encode(paramString3, "utf-8"));
      localHashMap.put("reason", URLEncoder.encode(bt.by(paramString4, ""), "utf-8"));
      localHashMap.put("currency", String.valueOf(paramInt));
      setRequestData(localHashMap);
      AppMethodBeat.o(67901);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneTenpayh5Pay", "error " + paramString1.getMessage());
      }
    }
  }
  
  public final String bOB()
  {
    return "/cgi-bin/mmpay-bin/h5requesttransfer";
  }
  
  public final int bOC()
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
    ad.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ad.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
      AppMethodBeat.o(67902);
      return;
    }
    paramString = new StringBuffer();
    this.vAu = paramJSONObject.optString("payurl");
    this.vBS = paramJSONObject.optString("tradeurl");
    this.vAB = paramJSONObject.optInt("transfering_num");
    this.vBT = paramJSONObject.optInt("transfering_type");
    paramString.append("payurl:" + this.vAu);
    paramString.append(" tradeurl:" + this.vBS);
    paramString.append(" transfering_num:" + this.vAB);
    paramString.append(" transfering_type:" + this.vBT);
    ad.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + paramString.toString());
    AppMethodBeat.o(67902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ab
 * JD-Core Version:    0.7.0.1
 */