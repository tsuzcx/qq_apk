package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public String token;
  
  public c(String paramString)
  {
    AppMethodBeat.i(72145);
    this.token = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("pin", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(72145);
  }
  
  public final int eIr()
  {
    return 3;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72146);
    ae.d("MicroMsg.NetScenePayUCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    this.token = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(72146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */