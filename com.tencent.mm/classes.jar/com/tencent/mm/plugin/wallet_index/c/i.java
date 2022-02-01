package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends m
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(71825);
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
    AppMethodBeat.o(71825);
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
    AppMethodBeat.i(71826);
    Log.d("Micromsg.NetSceneSendC2CMsg", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(71826);
      return;
    }
    AppMethodBeat.o(71826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.i
 * JD-Core Version:    0.7.0.1
 */