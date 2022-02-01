package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public int DLg;
  public int DLh;
  public int dEu;
  public int dsO;
  public double phz;
  public int status;
  public String wSq;
  private String yoZ;
  public int ypb;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 0);
  }
  
  public e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72174);
    this.yoZ = null;
    this.yoZ = paramString1;
    this.dsO = 1;
    this.dEu = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("invalid_time", String.valueOf(paramInt1));
    setRequestData(localHashMap);
    AppMethodBeat.o(72174);
  }
  
  public final int eIr()
  {
    return 25;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72175);
    ae.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72175);
      return;
    }
    this.ypb = paramJSONObject.optInt("pay_time");
    this.phz = (paramJSONObject.optDouble("total_fee") / 100.0D);
    this.wSq = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("pay_status");
    this.DLg = paramJSONObject.optInt("refund_time");
    this.DLh = paramJSONObject.optInt("receive_time");
    AppMethodBeat.o(72175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.e
 * JD-Core Version:    0.7.0.1
 */