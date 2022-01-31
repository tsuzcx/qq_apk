package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  private String mReqKey;
  public Orders qrf;
  
  public c(String paramString)
  {
    this(paramString, 0);
  }
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(48443);
    this.qrf = null;
    this.mReqKey = null;
    this.mReqKey = paramString;
    paramString = new HashMap();
    paramString.put("req_key", this.mReqKey);
    paramString.put("query_scene", String.valueOf(paramInt));
    setRequestData(paramString);
    AppMethodBeat.o(48443);
  }
  
  public final int cTa()
  {
    return 8;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48444);
    this.qrf = Orders.au(paramJSONObject);
    if (this.qrf != null) {
      this.qrf.cnI = this.mReqKey;
    }
    AppMethodBeat.o(48444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.c
 * JD-Core Version:    0.7.0.1
 */