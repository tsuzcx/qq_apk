package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
{
  public d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(69067);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bank_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("passwd", paramString3);
    if (paramBoolean) {
      localHashMap.put("unbind_scene", "1");
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(69067);
  }
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(69068);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bank_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("expired_flag", "1");
    if (paramBoolean) {
      localHashMap.put("unbind_scene", "1");
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(69068);
  }
  
  public final int getFuncId()
  {
    return 473;
  }
  
  public final int getTenpayCgicmd()
  {
    return 14;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/unbind";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.d
 * JD-Core Version:    0.7.0.1
 */