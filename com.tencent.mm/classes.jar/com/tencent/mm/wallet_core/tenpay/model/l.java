package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.protocal.c.cia;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.o;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class l
  extends j
  implements g
{
  public String appId;
  public String bJd;
  public String bMX;
  public int bUR;
  public String gfH;
  public String qLi;
  public cia qLj = new cia();
  public int scene;
  public String wBD;
  
  public l(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.scene = paramInt1;
    this.bUR = paramInt3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", URLEncoder.encode(paramString1));
    localHashMap.put("scene", String.valueOf(paramInt2));
    localHashMap.put("a8key_scene", String.valueOf(paramInt1));
    localHashMap.put("channel", String.valueOf(paramInt3));
    y.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
    if (paramInt4 < 0)
    {
      y.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
      localHashMap.put("source_type", "0");
      localHashMap.put("source", "");
      D(localHashMap);
      paramString2 = com.tencent.mm.model.c.c.IX().fJ("100456");
      if (paramString2.isValid()) {
        break label231;
      }
      y.w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
    }
    for (;;)
    {
      return;
      localHashMap.put("source_type", String.valueOf(paramInt4));
      localHashMap.put("source", paramString2);
      break;
      label231:
      if (bk.getInt((String)paramString2.ctr().get("open"), 0) == 0)
      {
        y.i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
        return;
      }
      try
      {
        paramString1 = new URI(paramString1).getQuery();
        if (bk.bl(paramString1)) {
          continue;
        }
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
              paramInt3 = bk.getInt(paramString2[1], 0);
              y.d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", new Object[] { Integer.valueOf(paramInt3) });
              this.dmK.Kv().ecM = paramInt3;
            }
          }
          paramInt1 += 1;
        }
        return;
      }
      catch (URISyntaxException paramString1)
      {
        y.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", paramString1, "", new Object[0]);
      }
    }
  }
  
  public int HH()
  {
    return 1694;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    y.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", new Object[] { paramJSONObject.toString() });
    this.bMX = paramJSONObject.optString("reqkey");
    this.appId = paramJSONObject.optString("appid");
    this.qLi = paramJSONObject.optString("appsource");
    this.bJd = paramJSONObject.optString("productid");
    this.wBD = paramJSONObject.optString("retcode");
    this.gfH = paramJSONObject.optString("retmsg");
    paramString = paramJSONObject.optJSONObject("wallet_mix_sp_genprepay_resp");
    if (paramString != null)
    {
      this.qLj.tWB = paramString.optString("pay_gate_url");
      this.qLj.tWD = paramString.optBoolean("need_dialog");
      this.qLj.tWE = paramString.optString("dialog_text");
      paramString = paramString.optJSONObject("callback_retry_conf");
      if (paramString != null)
      {
        this.qLj.tWC = new li();
        this.qLj.tWC.sGZ = paramString.optInt("inteval_time");
        this.qLj.tWC.sHa = paramString.optInt("max_count");
        this.qLj.tWC.sHb = paramString.optString("default_wording");
      }
      y.d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", new Object[] { this.qLj.tWB, this.qLj.tWE });
    }
  }
  
  public final int aEC()
  {
    return 127;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.l
 * JD-Core Version:    0.7.0.1
 */