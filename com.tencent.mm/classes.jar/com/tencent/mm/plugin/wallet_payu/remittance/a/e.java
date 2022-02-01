package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public int BTi;
  public int BTj;
  public int dgm;
  public int drx;
  public double oxA;
  public int status;
  public String vxl;
  private String wLA;
  public int wLC;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 0);
  }
  
  public e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72174);
    this.wLA = null;
    this.wLA = paramString1;
    this.dgm = 1;
    this.drx = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("invalid_time", String.valueOf(paramInt1));
    setRequestData(localHashMap);
    AppMethodBeat.o(72174);
  }
  
  public final int eqK()
  {
    return 25;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72175);
    ac.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72175);
      return;
    }
    this.wLC = paramJSONObject.optInt("pay_time");
    this.oxA = (paramJSONObject.optDouble("total_fee") / 100.0D);
    this.vxl = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("pay_status");
    this.BTi = paramJSONObject.optInt("refund_time");
    this.BTj = paramJSONObject.optInt("receive_time");
    AppMethodBeat.o(72175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.e
 * JD-Core Version:    0.7.0.1
 */