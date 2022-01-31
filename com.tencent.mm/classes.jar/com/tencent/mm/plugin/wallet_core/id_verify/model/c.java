package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends m
{
  public c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, (byte)0);
  }
  
  private c(String paramString1, String paramString2, String paramString3, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(142471);
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    localHashMap.put("face_token", paramString3);
    localHashMap.put("realname_scene", String.valueOf(paramInt));
    ab.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    setRequestData(localHashMap);
    AppMethodBeat.o(142471);
  }
  
  public final int getFuncId()
  {
    return 1648;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1648;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46640);
    ab.i("MicroMsg.NetSceneRealNameReg", "errCode=" + paramString + ";errMsg=" + paramString);
    AppMethodBeat.o(46640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.c
 * JD-Core Version:    0.7.0.1
 */