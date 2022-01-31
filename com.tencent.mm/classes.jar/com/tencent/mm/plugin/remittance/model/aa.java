package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends a
{
  public int kNE;
  public String qjt;
  public int qjz;
  public String qkO;
  public int qkP;
  
  public aa(double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(44792);
    this.kNE = 0;
    this.qjt = "";
    this.qkO = "";
    ab.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("transfer_amount", Math.round(100.0D * paramDouble));
      localHashMap.put("pay_nickname", URLEncoder.encode(paramString1, "utf-8"));
      localHashMap.put("rcvd_username", String.valueOf(paramString2));
      localHashMap.put("rcvd_nickname", URLEncoder.encode(paramString3, "utf-8"));
      localHashMap.put("reason", URLEncoder.encode(bo.bf(paramString4, ""), "utf-8"));
      localHashMap.put("currency", String.valueOf(paramInt));
      setRequestData(localHashMap);
      AppMethodBeat.o(44792);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneTenpayh5Pay", "error " + paramString1.getMessage());
      }
    }
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/h5requesttransfer";
  }
  
  public final int bhH()
  {
    return 1;
  }
  
  public final int getType()
  {
    return 1622;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44793);
    ab.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ab.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
      AppMethodBeat.o(44793);
      return;
    }
    paramString = new StringBuffer();
    this.qjt = paramJSONObject.optString("payurl");
    this.qkO = paramJSONObject.optString("tradeurl");
    this.qjz = paramJSONObject.optInt("transfering_num");
    this.qkP = paramJSONObject.optInt("transfering_type");
    paramString.append("payurl:" + this.qjt);
    paramString.append(" tradeurl:" + this.qkO);
    paramString.append(" transfering_num:" + this.qjz);
    paramString.append(" transfering_type:" + this.qkP);
    ab.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + paramString.toString());
    AppMethodBeat.o(44793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.aa
 * JD-Core Version:    0.7.0.1
 */