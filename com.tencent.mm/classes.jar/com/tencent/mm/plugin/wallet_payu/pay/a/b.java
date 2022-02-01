package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  private String mReqKey;
  public Orders yvS;
  
  public b(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private b(String paramString, byte paramByte)
  {
    AppMethodBeat.i(163874);
    this.yvS = null;
    this.mReqKey = null;
    this.mReqKey = paramString;
    paramString = new HashMap();
    paramString.put("req_key", this.mReqKey);
    paramString.put("query_scene", "0");
    setRequestData(paramString);
    AppMethodBeat.o(163874);
  }
  
  public final int eIr()
  {
    return 8;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72085);
    this.yvS = Orders.aY(paramJSONObject);
    if (this.yvS != null) {
      this.yvS.dmw = this.mReqKey;
    }
    AppMethodBeat.o(72085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.b
 * JD-Core Version:    0.7.0.1
 */