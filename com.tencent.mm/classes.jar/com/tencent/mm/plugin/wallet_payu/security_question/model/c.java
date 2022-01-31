package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public String czq;
  public String id;
  public String uDU;
  
  public c()
  {
    this("");
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(48570);
    this.czq = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("payu_reference", bo.bf(paramString, ""));
    setRequestData(localHashMap);
    AppMethodBeat.o(48570);
  }
  
  public final int cTa()
  {
    return 23;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48571);
    this.id = paramJSONObject.optString("id");
    this.uDU = paramJSONObject.optString("description");
    AppMethodBeat.o(48571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.c
 * JD-Core Version:    0.7.0.1
 */