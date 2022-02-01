package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public String DtO;
  public String dyV;
  public String id;
  
  public c()
  {
    this("");
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(72211);
    this.dyV = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("payu_reference", bt.bI(paramString, ""));
    setRequestData(localHashMap);
    AppMethodBeat.o(72211);
  }
  
  public final int eEK()
  {
    return 23;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72212);
    this.id = paramJSONObject.optString("id");
    this.DtO = paramJSONObject.optString("description");
    AppMethodBeat.o(72212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.c
 * JD-Core Version:    0.7.0.1
 */