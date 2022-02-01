package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public n wOq;
  public ad wOr;
  public e wOs;
  public e wOt;
  
  public q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174388);
    this.wOq = new n(System.currentTimeMillis(), paramInt1);
    setRequestData(this.wOq.wOp);
    this.wOr = new ad(null, 8);
    this.wOr.DgY = true;
    Map localMap = this.wOr.wOp;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString);
    addRequestData(localMap);
    setWXRequestData(this.wOr.CZR);
    ae.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(174388);
  }
  
  private static e aI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66317);
    e locale = new e();
    locale.errMsg = ak.getContext().getString(2131765224);
    String str = ak.getContext().getString(2131765224);
    try
    {
      i = paramJSONObject.getInt("retcode");
      paramJSONObject = paramJSONObject.optString("retmsg");
      if (i != 0)
      {
        ae.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
        if (i != -10089)
        {
          locale.e(1000, i, paramJSONObject, 2);
          AppMethodBeat.o(66317);
          return locale;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        ae.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + paramJSONObject.toString());
        int i = -10089;
        paramJSONObject = str;
        continue;
        locale.e(1000, 2, paramJSONObject, 2);
        continue;
        ae.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
      }
    }
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
    AppMethodBeat.i(66316);
    if (paramInt != 0)
    {
      AppMethodBeat.o(66316);
      return;
    }
    paramString = paramJSONObject.optJSONObject("queryuser_resp");
    this.wOs = aI(paramString);
    this.wOq.onGYNetEnd(this.wOs.errCode, this.wOs.errMsg, paramString);
    paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
    this.wOt = aI(paramJSONObject);
    this.wOr.onGYNetEnd(this.wOt.errCode, this.wOt.errMsg, paramJSONObject);
    if (paramString != null)
    {
      paramString = paramString.optString("card_list");
      if (paramString != null) {
        a.auZ(paramString);
      }
      ae.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "card_list: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(66316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.q
 * JD-Core Version:    0.7.0.1
 */