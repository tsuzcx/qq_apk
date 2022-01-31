package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
{
  public f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(48663);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bank_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("passwd", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(48663);
  }
  
  public final int getTenpayCgicmd()
  {
    return 62;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.f
 * JD-Core Version:    0.7.0.1
 */