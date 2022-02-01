package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public String Axg;
  public dpt Axh;
  public String IeM;
  public String appId;
  public int channel;
  public String dcE;
  public String dft;
  public String jwH;
  public int scene;
  
  public o(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(72894);
    this.Axh = new dpt();
    this.scene = paramInt1;
    this.channel = paramInt3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", URLEncoder.encode(paramString1));
    localHashMap.put("scene", String.valueOf(paramInt2));
    localHashMap.put("a8key_scene", String.valueOf(paramInt1));
    localHashMap.put("channel", String.valueOf(paramInt3));
    ad.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
    if (paramInt4 < 0)
    {
      ad.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
      localHashMap.put("source_type", "0");
      localHashMap.put("source", "");
    }
    for (;;)
    {
      setRequestData(localHashMap);
      paramString2 = com.tencent.mm.model.c.d.aty().qu("100456");
      if (paramString2.isValid()) {
        break;
      }
      ad.w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
      AppMethodBeat.o(72894);
      return;
      localHashMap.put("source_type", String.valueOf(paramInt4));
      localHashMap.put("source", paramString2);
    }
    if (bt.getInt((String)paramString2.eJy().get("open"), 0) == 0)
    {
      ad.i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
      AppMethodBeat.o(72894);
      return;
    }
    try
    {
      paramString1 = new URI(paramString1).getQuery();
      if (!bt.isNullOrNil(paramString1))
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
              paramInt3 = bt.getInt(paramString2[1], 0);
              ad.d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", new Object[] { Integer.valueOf(paramInt3) });
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
      ad.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", paramString1, "", new Object[0]);
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
    ad.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ad.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", new Object[] { paramJSONObject.toString() });
    this.dcE = paramJSONObject.optString("reqkey");
    this.appId = paramJSONObject.optString("appid");
    this.Axg = paramJSONObject.optString("appsource");
    this.dft = paramJSONObject.optString("productid");
    this.IeM = paramJSONObject.optString("retcode");
    this.jwH = paramJSONObject.optString("retmsg");
    paramString = paramJSONObject.optJSONObject("wallet_mix_sp_genprepay_resp");
    if (paramString != null)
    {
      this.Axh.EFF = paramString.optString("pay_gate_url");
      this.Axh.EFH = paramString.optBoolean("need_dialog");
      this.Axh.EFI = paramString.optString("dialog_text");
      paramString = paramString.optJSONObject("callback_retry_conf");
      if (paramString != null)
      {
        this.Axh.EFG = new qb();
        this.Axh.EFG.COY = paramString.optInt("inteval_time");
        this.Axh.EFG.COZ = paramString.optInt("max_count");
        this.Axh.EFG.CPa = paramString.optString("default_wording");
      }
      ad.d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", new Object[] { this.Axh.EFF, this.Axh.EFI });
    }
    AppMethodBeat.o(72895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.o
 * JD-Core Version:    0.7.0.1
 */