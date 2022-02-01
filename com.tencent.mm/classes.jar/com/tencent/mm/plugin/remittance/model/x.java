package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends m
{
  public String desc;
  public int dmy;
  public int oGc;
  public String oGf;
  public double phz;
  public int scene;
  public String username;
  public String yoJ;
  public String yoK;
  public String yoL;
  public String yoM;
  public String yoN;
  public String yoO;
  public int yoP;
  public String yoQ;
  public String yoR;
  public int yoS;
  public String yoT;
  public String yoU;
  public int yoV;
  public String yoW;
  public int yoX;
  public BusiRemittanceResp yoY;
  public String yoq;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(67887);
    this.yoL = "";
    this.yoM = "";
    this.yoN = "";
    this.yoO = "";
    this.yoQ = "";
    this.yoR = "";
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
      ae.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0)
      {
        AppMethodBeat.o(67888);
        return;
      }
      ae.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.yoJ = paramJSONObject.optString("true_name");
      this.phz = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.yoK = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.yoL = paramJSONObject.optString("f2f_pay_desc");
      this.yoM = paramJSONObject.optString("rcvr_desc");
      this.yoN = paramJSONObject.optString("payer_desc");
      this.yoO = paramJSONObject.optString("rcvr_ticket");
      this.yoP = paramJSONObject.optInt("busi_type", 0);
      this.yoQ = paramJSONObject.optString("mch_name");
      this.yoR = paramJSONObject.optString("mch_photo");
      this.yoU = paramJSONObject.optString("mch_type", "");
      this.yoS = paramJSONObject.optInt("mch_time", 0);
      this.yoT = paramJSONObject.optString("receiver_openid");
      this.yoV = paramJSONObject.optInt("get_pay_wifi");
      this.yoq = paramJSONObject.optString("receiver_true_name");
      this.yoW = paramJSONObject.optString("mch_info_string");
      this.yoX = paramJSONObject.optInt("amount_remind_bit");
      this.oGc = paramJSONObject.optInt("action_type");
      this.dmy = paramJSONObject.optInt("retcode");
      this.oGf = paramJSONObject.optString("jump_url");
      this.yoY = new BusiRemittanceResp(paramJSONObject);
      AppMethodBeat.o(67888);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
      AppMethodBeat.o(67888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */