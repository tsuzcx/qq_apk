package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.wallet_core.tenpay.model.m
{
  public JSONObject VpD;
  
  public m(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69563);
    HashMap localHashMap = new HashMap();
    Log.d("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "cpuId: %s, uid: %s", new Object[] { paramString1, paramString2 });
    localHashMap.put("is_root", "0");
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_device_open_touch", str);
      localHashMap.put("cpu_id", paramString1);
      localHashMap.put("app_uid", paramString2);
      setRequestData(localHashMap);
      AppMethodBeat.o(69563);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69564);
    this.callback = paramh;
    int i = super.doScene(paramg, paramh);
    AppMethodBeat.o(69564);
    return i;
  }
  
  public final int getFuncId()
  {
    return 1669;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/paysecurity";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69565);
    Log.i("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      Log.v("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo json: %s", new Object[] { paramJSONObject.toString() });
      this.VpD = paramJSONObject;
      ae.jOT().cQ(this.VpD);
    }
    AppMethodBeat.o(69565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */