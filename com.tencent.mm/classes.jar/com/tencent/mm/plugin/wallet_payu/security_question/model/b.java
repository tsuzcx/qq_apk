package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String DLs;
  public String dAa;
  public String id;
  public boolean ros;
  public String vBH;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(72209);
    this.id = paramString2;
    this.vBH = paramString3;
    this.dAa = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString2);
    localHashMap.put("answer", paramString3);
    localHashMap.put("payu_reference", paramString1);
    setRequestData(localHashMap);
    AppMethodBeat.o(72209);
  }
  
  public final int eIr()
  {
    return 18;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72210);
    this.ros = paramJSONObject.optBoolean("verified");
    this.DLs = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.b
 * JD-Core Version:    0.7.0.1
 */