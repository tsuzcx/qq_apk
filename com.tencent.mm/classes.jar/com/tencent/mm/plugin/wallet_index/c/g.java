package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends j
{
  public g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("toUser", paramString1);
    localHashMap.put("receiverTitle", paramString2);
    localHashMap.put("senderTitle", paramString3);
    localHashMap.put("tempId", paramString4);
    localHashMap.put("receiverdes", paramString6);
    localHashMap.put("senderdes", paramString5);
    localHashMap.put("Url", paramString7);
    localHashMap.put("Scene", paramString8);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1962;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneSendC2CMsg", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {}
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/h5sendc2cmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */