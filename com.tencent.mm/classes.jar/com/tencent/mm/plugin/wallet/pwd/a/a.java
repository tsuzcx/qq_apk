package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends j
{
  public a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1321;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneCloseWalletLock", "alvinluo close wallet lock errCode: %d, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/closewalletlock";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */