package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.mm.wallet_core.c.g;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends a
  implements g
{
  public String nyt;
  
  public q(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("recv_username", paramString1);
    localHashMap.put("recv_nickname", paramString2);
    localHashMap.put("qrcodeid", paramString5);
    try
    {
      if (!bk.bl(paramString3)) {
        localHashMap.put("desc", URLEncoder.encode(paramString3, "UTF-8"));
      }
      if (!bk.bl(paramString4)) {
        localHashMap.put("message", URLEncoder.encode(paramString4, "UTF-8"));
      }
    }
    catch (UnsupportedEncodingException paramString5)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferPay", paramString5, "", new Object[0]);
      }
    }
    localHashMap.put("currency", String.valueOf(paramInt1));
    localHashMap.put("set_amount", String.valueOf(paramInt2));
    D(localHashMap);
    y.i("MicroMsg.NetSceneH5F2fTransferPay", "username: %s, nickname: %s, amount: %s, desc: %s, msg: %s, currency: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3, paramString4, Integer.valueOf(paramInt1) });
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.nyt = paramJSONObject.optString("payurl", "");
    y.i("MicroMsg.NetSceneH5F2fTransferPay", "payurl: %s", new Object[] { this.nyt });
  }
  
  public final int aEA()
  {
    return 1529;
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferpay";
  }
  
  public final int getType()
  {
    return 1529;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.q
 * JD-Core Version:    0.7.0.1
 */