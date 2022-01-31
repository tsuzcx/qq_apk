package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(48504);
    this.token = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("pin", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(48504);
  }
  
  public final int cTa()
  {
    return 3;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48505);
    ab.d("MicroMsg.NetScenePayUCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    this.token = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(48505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */