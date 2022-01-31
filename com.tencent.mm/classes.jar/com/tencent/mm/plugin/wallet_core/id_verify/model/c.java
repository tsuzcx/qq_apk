package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends j
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, (byte)0);
  }
  
  private c(String paramString1, String paramString2, int paramInt, byte paramByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    localHashMap.put("realname_scene", String.valueOf(paramInt));
    y.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1648;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneRealNameReg", "errCode=" + paramString + ";errMsg=" + paramString);
  }
  
  public final int aEC()
  {
    return 1648;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.c
 * JD-Core Version:    0.7.0.1
 */