package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.c.j;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class o
  extends m
  implements j
{
  public String BPA;
  public dvk BPB;
  public String JGo;
  public String appId;
  public int channel;
  public String dac;
  public String dcO;
  public String jXd;
  public int scene;
  
  public o(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(72894);
    this.BPB = new dvk();
    this.scene = paramInt1;
    this.channel = paramInt3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", URLEncoder.encode(paramString1));
    localHashMap.put("scene", String.valueOf(paramInt2));
    localHashMap.put("a8key_scene", String.valueOf(paramInt1));
    localHashMap.put("channel", String.valueOf(paramInt3));
    ac.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
    if (paramInt4 < 0)
    {
      ac.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
      localHashMap.put("source_type", "0");
      localHashMap.put("source", "");
    }
    for (;;)
    {
      setRequestData(localHashMap);
      paramString2 = com.tencent.mm.model.c.d.aAp().tJ("100456");
      if (paramString2.isValid()) {
        break;
      }
      ac.w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
      AppMethodBeat.o(72894);
      return;
      localHashMap.put("source_type", String.valueOf(paramInt4));
      localHashMap.put("source", paramString2);
    }
    if (bs.getInt((String)paramString2.eYV().get("open"), 0) == 0)
    {
      ac.i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
      AppMethodBeat.o(72894);
      return;
    }
    try
    {
      paramString1 = new URI(paramString1).getQuery();
      if (!bs.isNullOrNil(paramString1))
      {
        paramString1 = paramString1.split("&");
        paramInt2 = paramString1.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (paramString1[paramInt1].contains("groupid"))
          {
            paramString2 = paramString1[paramInt1].split("=");
            if (paramString2.length == 2)
            {
              paramInt3 = bs.getInt(paramString2[1], 0);
              ac.d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", new Object[] { Integer.valueOf(paramInt3) });
              getCommReqResp().getReqObj().setRouteInfo(paramInt3);
            }
          }
          paramInt1 += 1;
        }
      }
      AppMethodBeat.o(72894);
      return;
    }
    catch (URISyntaxException paramString1)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", paramString1, "", new Object[0]);
      AppMethodBeat.o(72894);
    }
  }
  
  public int getFuncId()
  {
    return 1694;
  }
  
  public int getTenpayCgicmd()
  {
    return 127;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72895);
    ac.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ac.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", new Object[] { paramJSONObject.toString() });
    this.dac = paramJSONObject.optString("reqkey");
    this.appId = paramJSONObject.optString("appid");
    this.BPA = paramJSONObject.optString("appsource");
    this.dcO = paramJSONObject.optString("productid");
    this.JGo = paramJSONObject.optString("retcode");
    this.jXd = paramJSONObject.optString("retmsg");
    paramString = paramJSONObject.optJSONObject("wallet_mix_sp_genprepay_resp");
    if (paramString != null)
    {
      this.BPB.GcR = paramString.optString("pay_gate_url");
      this.BPB.GcT = paramString.optBoolean("need_dialog");
      this.BPB.GcU = paramString.optString("dialog_text");
      paramString = paramString.optJSONObject("callback_retry_conf");
      if (paramString != null)
      {
        this.BPB.GcS = new ql();
        this.BPB.GcS.EhJ = paramString.optInt("inteval_time");
        this.BPB.GcS.EhK = paramString.optInt("max_count");
        this.BPB.GcS.EhL = paramString.optString("default_wording");
      }
      ac.d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", new Object[] { this.BPB.GcR, this.BPB.GcU });
    }
    AppMethodBeat.o(72895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.o
 * JD-Core Version:    0.7.0.1
 */