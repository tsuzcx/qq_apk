package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends m
{
  public int dcG;
  public String desc;
  public double nUf;
  public int ntg;
  public String ntj;
  public int scene;
  public String username;
  public String vAM;
  public String vBf;
  public String vBg;
  public String vBh;
  public String vBi;
  public String vBj;
  public String vBk;
  public int vBl;
  public String vBm;
  public String vBn;
  public int vBo;
  public String vBp;
  public String vBq;
  public int vBr;
  public String vBs;
  public int vBt;
  public BusiRemittanceResp vBu;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(67887);
    this.vBh = "";
    this.vBi = "";
    this.vBj = "";
    this.vBk = "";
    this.vBm = "";
    this.vBn = "";
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
      ad.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0)
      {
        AppMethodBeat.o(67888);
        return;
      }
      ad.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.vBf = paramJSONObject.optString("true_name");
      this.nUf = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.vBg = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.vBh = paramJSONObject.optString("f2f_pay_desc");
      this.vBi = paramJSONObject.optString("rcvr_desc");
      this.vBj = paramJSONObject.optString("payer_desc");
      this.vBk = paramJSONObject.optString("rcvr_ticket");
      this.vBl = paramJSONObject.optInt("busi_type", 0);
      this.vBm = paramJSONObject.optString("mch_name");
      this.vBn = paramJSONObject.optString("mch_photo");
      this.vBq = paramJSONObject.optString("mch_type", "");
      this.vBo = paramJSONObject.optInt("mch_time", 0);
      this.vBp = paramJSONObject.optString("receiver_openid");
      this.vBr = paramJSONObject.optInt("get_pay_wifi");
      this.vAM = paramJSONObject.optString("receiver_true_name");
      this.vBs = paramJSONObject.optString("mch_info_string");
      this.vBt = paramJSONObject.optInt("amount_remind_bit");
      this.ntg = paramJSONObject.optInt("action_type");
      this.dcG = paramJSONObject.optInt("retcode");
      this.ntj = paramJSONObject.optString("jump_url");
      this.vBu = new BusiRemittanceResp(paramJSONObject);
      AppMethodBeat.o(67888);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
      AppMethodBeat.o(67888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */