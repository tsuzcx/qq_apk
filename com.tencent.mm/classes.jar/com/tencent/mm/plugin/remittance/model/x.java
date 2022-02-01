package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends m
{
  public String CpA;
  public String CpB;
  public String CpC;
  public String CpD;
  public String CpE;
  public int CpF;
  public String CpG;
  public String CpH;
  public int CpI;
  public String CpJ;
  public String CpK;
  public int CpL;
  public String CpM;
  public int CpN;
  public BusiRemittanceResp CpO;
  public String Cpg;
  public String Cpz;
  public int dDN;
  public String desc;
  public int pTI;
  public String pTL;
  public double qwJ;
  public int scene;
  public String username;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(67887);
    this.CpB = "";
    this.CpC = "";
    this.CpD = "";
    this.CpE = "";
    this.CpG = "";
    this.CpH = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", URLEncoder.encode(paramString));
    setRequestData(localHashMap);
    paramString = new HashMap();
    paramString.put("channel", String.valueOf(paramInt));
    setWXRequestData(paramString);
    AppMethodBeat.o(67887);
  }
  
  public final int getFuncId()
  {
    return 1515;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferscanqrcode";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67888);
    try
    {
      Log.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0)
      {
        AppMethodBeat.o(67888);
        return;
      }
      Log.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.Cpz = paramJSONObject.optString("true_name");
      this.qwJ = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.CpA = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.CpB = paramJSONObject.optString("f2f_pay_desc");
      this.CpC = paramJSONObject.optString("rcvr_desc");
      this.CpD = paramJSONObject.optString("payer_desc");
      this.CpE = paramJSONObject.optString("rcvr_ticket");
      this.CpF = paramJSONObject.optInt("busi_type", 0);
      this.CpG = paramJSONObject.optString("mch_name");
      this.CpH = paramJSONObject.optString("mch_photo");
      this.CpK = paramJSONObject.optString("mch_type", "");
      this.CpI = paramJSONObject.optInt("mch_time", 0);
      this.CpJ = paramJSONObject.optString("receiver_openid");
      this.CpL = paramJSONObject.optInt("get_pay_wifi");
      this.Cpg = paramJSONObject.optString("receiver_true_name");
      this.CpM = paramJSONObject.optString("mch_info_string");
      this.CpN = paramJSONObject.optInt("amount_remind_bit");
      this.pTI = paramJSONObject.optInt("action_type");
      this.dDN = paramJSONObject.optInt("retcode");
      this.pTL = paramJSONObject.optString("jump_url");
      this.CpO = new BusiRemittanceResp(paramJSONObject);
      AppMethodBeat.o(67888);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
      AppMethodBeat.o(67888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */