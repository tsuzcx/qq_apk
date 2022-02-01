package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.mm.wallet_core.model.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u
  extends a
  implements j
{
  public String Ojh;
  
  public u(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67873);
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("recv_username", paramString1);
    localHashMap.put("recv_nickname", paramString2);
    localHashMap.put("qrcodeid", paramString5);
    try
    {
      if (!Util.isNullOrNil(paramString3)) {
        localHashMap.put("desc", URLEncoder.encode(paramString3, "UTF-8"));
      }
      if (!Util.isNullOrNil(paramString4)) {
        localHashMap.put("message", URLEncoder.encode(paramString4, "UTF-8"));
      }
    }
    catch (UnsupportedEncodingException paramString5)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferPay", paramString5, "", new Object[0]);
      }
    }
    localHashMap.put("currency", String.valueOf(paramInt1));
    localHashMap.put("set_amount", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    Log.i("MicroMsg.NetSceneH5F2fTransferPay", "username: %s, nickname: %s, amount: %s, desc: %s, msg: %s, currency: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3, paramString4, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(67873);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferpay";
  }
  
  public final int drJ()
  {
    return 1529;
  }
  
  public final int getType()
  {
    return 1529;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67874);
    this.Ojh = paramJSONObject.optString("payurl", "");
    Log.i("MicroMsg.NetSceneH5F2fTransferPay", "payurl: %s", new Object[] { this.Ojh });
    AppMethodBeat.o(67874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.u
 * JD-Core Version:    0.7.0.1
 */