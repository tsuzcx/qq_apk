package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public int tSp;
  public String tSq;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(45724);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bankcard_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    setRequestData(localHashMap);
    AppMethodBeat.o(45724);
  }
  
  public final int getFuncId()
  {
    return 1540;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1540;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45725);
    if (paramInt == 0)
    {
      if (paramJSONObject != null)
      {
        this.tSp = paramJSONObject.optInt("unbindbannerlevel", 0);
        this.tSq = paramJSONObject.optString("unbindbannerwording");
        AppMethodBeat.o(45725);
        return;
      }
      ab.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
    }
    AppMethodBeat.o(45725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.a
 * JD-Core Version:    0.7.0.1
 */