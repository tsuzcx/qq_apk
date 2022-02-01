package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public int VjA;
  public String VjB;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69061);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bankcard_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    setRequestData(localHashMap);
    AppMethodBeat.o(69061);
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
    AppMethodBeat.i(69062);
    if (paramInt == 0)
    {
      if (paramJSONObject != null)
      {
        this.VjA = paramJSONObject.optInt("unbindbannerlevel", 0);
        this.VjB = paramJSONObject.optString("unbindbannerwording");
        AppMethodBeat.o(69062);
        return;
      }
      Log.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
    }
    AppMethodBeat.o(69062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.a
 * JD-Core Version:    0.7.0.1
 */