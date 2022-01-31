package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends m
{
  public h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(48190);
    HashMap localHashMap = new HashMap();
    localHashMap.put("toUser", paramString1);
    localHashMap.put("receiverTitle", paramString2);
    localHashMap.put("senderTitle", paramString3);
    localHashMap.put("tempId", paramString4);
    localHashMap.put("receiverdes", paramString6);
    localHashMap.put("senderdes", paramString5);
    localHashMap.put("Url", paramString7);
    localHashMap.put("Scene", paramString8);
    setRequestData(localHashMap);
    AppMethodBeat.o(48190);
  }
  
  public final int getFuncId()
  {
    return 1962;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/h5sendc2cmsg";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48191);
    ab.d("Micromsg.NetSceneSendC2CMsg", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(48191);
      return;
    }
    AppMethodBeat.o(48191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.h
 * JD-Core Version:    0.7.0.1
 */