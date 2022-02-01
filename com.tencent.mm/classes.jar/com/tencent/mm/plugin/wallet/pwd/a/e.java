package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends m
{
  public e(String paramString)
  {
    AppMethodBeat.i(69526);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(69526);
  }
  
  public final int getFuncId()
  {
    return 1321;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/closewalletlock";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69527);
    ac.i("MicroMsg.NetSceneCloseWalletLock", "alvinluo close wallet lock errCode: %d, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    AppMethodBeat.o(69527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.e
 * JD-Core Version:    0.7.0.1
 */