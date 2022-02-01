package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends a
{
  public q(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(67871);
    HashMap localHashMap = new HashMap();
    localHashMap.put("recv_username", paramString1);
    localHashMap.put("qrcodeid", paramString2);
    localHashMap.put("currency", String.valueOf(paramInt1));
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("set_amount", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    ae.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "qrcodeId: %s, currency: %s", new Object[] { paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(67871);
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfercancelpay";
  }
  
  public final int cbK()
  {
    return 1257;
  }
  
  public final int getType()
  {
    return 1257;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67872);
    ae.d("MicroMsg.NetSceneH5F2fTransferCancelPay", "json: %s", new Object[] { paramJSONObject.toString() });
    ae.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(67872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.q
 * JD-Core Version:    0.7.0.1
 */