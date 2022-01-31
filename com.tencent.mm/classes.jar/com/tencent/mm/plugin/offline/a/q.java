package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public n plL;
  public com.tencent.mm.plugin.wallet_core.c.ab plM;
  public com.tencent.mm.wallet_core.c.d plN;
  public com.tencent.mm.wallet_core.c.d plO;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(43416);
    this.plL = new n(System.currentTimeMillis(), paramInt);
    setRequestData(this.plL.plK);
    this.plM = new com.tencent.mm.plugin.wallet_core.c.ab(null, 8);
    addRequestData(this.plM.plK);
    setWXRequestData(this.plM.tVp);
    AppMethodBeat.o(43416);
  }
  
  private static com.tencent.mm.wallet_core.c.d aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43418);
    com.tencent.mm.wallet_core.c.d locald = new com.tencent.mm.wallet_core.c.d();
    locald.errMsg = ah.getContext().getString(2131305032);
    String str = ah.getContext().getString(2131305032);
    try
    {
      i = paramJSONObject.getInt("retcode");
      paramJSONObject = paramJSONObject.optString("retmsg");
      if (i != 0)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
        if (i != -10089)
        {
          locald.e(1000, i, paramJSONObject, 2);
          AppMethodBeat.o(43418);
          return locald;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + paramJSONObject.toString());
        int i = -10089;
        paramJSONObject = str;
        continue;
        locald.e(1000, 2, paramJSONObject, 2);
        continue;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
      }
    }
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(43419);
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.c.abU().me("100337");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).dvN();
      bool1 = bool2;
      if (((Map)localObject).containsKey("enabled"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("enabled"))) {
          bool1 = true;
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "isUserBindQueryEnabled: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(43419);
    return bool1;
  }
  
  public final int getFuncId()
  {
    return 1742;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1742;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43417);
    if (paramInt != 0)
    {
      AppMethodBeat.o(43417);
      return;
    }
    paramString = paramJSONObject.optJSONObject("queryuser_resp");
    this.plN = aj(paramString);
    this.plL.onGYNetEnd(this.plN.errCode, this.plN.errMsg, paramString);
    paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
    this.plO = aj(paramJSONObject);
    this.plM.onGYNetEnd(this.plO.errCode, this.plO.errMsg, paramJSONObject);
    if (paramString != null)
    {
      paramString = paramString.optString("card_list");
      if (paramString != null) {
        a.Ws(paramString);
      }
    }
    AppMethodBeat.o(43417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.q
 * JD-Core Version:    0.7.0.1
 */