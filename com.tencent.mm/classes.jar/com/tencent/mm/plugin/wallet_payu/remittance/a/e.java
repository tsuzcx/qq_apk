package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public int bsY;
  public int ctW;
  public double kNS;
  public String ppp;
  private String qkt;
  public int qku;
  public int status;
  public int uDH;
  public int uDI;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 0);
  }
  
  public e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48533);
    this.qkt = null;
    this.qkt = paramString1;
    this.ctW = 1;
    this.bsY = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("invalid_time", String.valueOf(paramInt1));
    setRequestData(localHashMap);
    AppMethodBeat.o(48533);
  }
  
  public final int cTa()
  {
    return 25;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48534);
    ab.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(48534);
      return;
    }
    this.qku = paramJSONObject.optInt("pay_time");
    this.kNS = (paramJSONObject.optDouble("total_fee") / 100.0D);
    this.ppp = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("pay_status");
    this.uDH = paramJSONObject.optInt("refund_time");
    this.uDI = paramJSONObject.optInt("receive_time");
    AppMethodBeat.o(48534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.e
 * JD-Core Version:    0.7.0.1
 */