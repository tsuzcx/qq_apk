package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ag
  extends m
{
  public String OiN;
  public String Oiv;
  public String Oiw;
  public String Oke;
  public String Okf;
  public String Okg;
  public String Okh;
  public String Oki;
  public String Okj;
  public int Okk;
  public String Okl;
  public int Okm;
  public String Okn;
  public int Oko;
  public String Okp;
  public int Okq;
  public BusiRemittanceResp Okr;
  public String desc;
  public int hAV;
  public String jump_url;
  public int scene;
  public String username;
  public double wZe;
  public int wuj;
  
  public ag(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(288803);
    this.Okg = "";
    this.Okh = "";
    this.Oki = "";
    this.Okj = "";
    this.Oiv = "";
    this.Okl = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", URLEncoder.encode(paramString1));
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localHashMap.put("qq_extend_info", URLEncoder.encode(paramString2));
    }
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("channel", String.valueOf(paramInt));
    setWXRequestData(paramString1);
    AppMethodBeat.o(288803);
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
      this.Oke = paramJSONObject.optString("true_name");
      this.wZe = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.Okf = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.Okg = paramJSONObject.optString("f2f_pay_desc");
      this.Okh = paramJSONObject.optString("rcvr_desc");
      this.Oki = paramJSONObject.optString("payer_desc");
      this.Okj = paramJSONObject.optString("rcvr_ticket");
      this.Okk = paramJSONObject.optInt("busi_type", 0);
      this.Oiv = paramJSONObject.optString("mch_name");
      this.Okl = paramJSONObject.optString("mch_photo");
      this.Okn = paramJSONObject.optString("mch_type", "");
      this.Okm = paramJSONObject.optInt("mch_time", 0);
      this.Oiw = paramJSONObject.optString("receiver_openid");
      this.Oko = paramJSONObject.optInt("get_pay_wifi");
      this.OiN = paramJSONObject.optString("receiver_true_name");
      this.Okp = paramJSONObject.optString("mch_info_string");
      this.Okq = paramJSONObject.optInt("amount_remind_bit");
      this.wuj = paramJSONObject.optInt("action_type");
      this.hAV = paramJSONObject.optInt("retcode");
      this.jump_url = paramJSONObject.optString("jump_url");
      this.Okr = new BusiRemittanceResp(paramJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ag
 * JD-Core Version:    0.7.0.1
 */