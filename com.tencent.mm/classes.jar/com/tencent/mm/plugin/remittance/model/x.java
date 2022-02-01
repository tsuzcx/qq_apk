package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends m
{
  public int dae;
  public String desc;
  public int nWg;
  public String nWj;
  public double oxA;
  public int scene;
  public String username;
  public String wKR;
  public String wLk;
  public String wLl;
  public String wLm;
  public String wLn;
  public String wLo;
  public String wLp;
  public int wLq;
  public String wLr;
  public String wLs;
  public int wLt;
  public String wLu;
  public String wLv;
  public int wLw;
  public String wLx;
  public int wLy;
  public BusiRemittanceResp wLz;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(67887);
    this.wLm = "";
    this.wLn = "";
    this.wLo = "";
    this.wLp = "";
    this.wLr = "";
    this.wLs = "";
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
      ac.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0)
      {
        AppMethodBeat.o(67888);
        return;
      }
      ac.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.wLk = paramJSONObject.optString("true_name");
      this.oxA = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.wLl = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.wLm = paramJSONObject.optString("f2f_pay_desc");
      this.wLn = paramJSONObject.optString("rcvr_desc");
      this.wLo = paramJSONObject.optString("payer_desc");
      this.wLp = paramJSONObject.optString("rcvr_ticket");
      this.wLq = paramJSONObject.optInt("busi_type", 0);
      this.wLr = paramJSONObject.optString("mch_name");
      this.wLs = paramJSONObject.optString("mch_photo");
      this.wLv = paramJSONObject.optString("mch_type", "");
      this.wLt = paramJSONObject.optInt("mch_time", 0);
      this.wLu = paramJSONObject.optString("receiver_openid");
      this.wLw = paramJSONObject.optInt("get_pay_wifi");
      this.wKR = paramJSONObject.optString("receiver_true_name");
      this.wLx = paramJSONObject.optString("mch_info_string");
      this.wLy = paramJSONObject.optInt("amount_remind_bit");
      this.nWg = paramJSONObject.optInt("action_type");
      this.dae = paramJSONObject.optInt("retcode");
      this.nWj = paramJSONObject.optString("jump_url");
      this.wLz = new BusiRemittanceResp(paramJSONObject);
      AppMethodBeat.o(67888);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
      AppMethodBeat.o(67888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */