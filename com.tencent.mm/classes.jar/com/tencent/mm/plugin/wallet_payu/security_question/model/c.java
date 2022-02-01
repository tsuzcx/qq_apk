package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public String WdQ;
  public String hQR;
  public String id;
  
  public c()
  {
    this("");
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(72211);
    this.hQR = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("payu_reference", Util.nullAs(paramString, ""));
    setRequestData(localHashMap);
    AppMethodBeat.o(72211);
  }
  
  public final int ihO()
  {
    return 23;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72212);
    this.id = paramJSONObject.optString("id");
    this.WdQ = paramJSONObject.optString("description");
    AppMethodBeat.o(72212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.c
 * JD-Core Version:    0.7.0.1
 */