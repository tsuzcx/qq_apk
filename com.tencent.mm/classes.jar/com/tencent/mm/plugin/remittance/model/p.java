package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends a
{
  public p(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("recv_username", paramString1);
    localHashMap.put("qrcodeid", paramString2);
    localHashMap.put("currency", String.valueOf(paramInt1));
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("set_amount", String.valueOf(paramInt2));
    D(localHashMap);
    y.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "qrcodeId: %s, currency: %s", new Object[] { paramString2, Integer.valueOf(paramInt1) });
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetSceneH5F2fTransferCancelPay", "json: %s", new Object[] { paramJSONObject.toString() });
    y.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final int aEA()
  {
    return 1257;
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfercancelpay";
  }
  
  public final int getType()
  {
    return 1257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.p
 * JD-Core Version:    0.7.0.1
 */