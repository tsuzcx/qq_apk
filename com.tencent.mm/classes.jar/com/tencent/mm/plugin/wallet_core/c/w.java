package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends m
{
  public BindCardOrder OHI;
  public String action;
  
  public w(com.tencent.mm.plugin.wallet_core.model.w paramw)
  {
    this(paramw, -1, "");
  }
  
  public w(com.tencent.mm.plugin.wallet_core.model.w paramw, int paramInt, String paramString)
  {
    AppMethodBeat.i(69935);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramw.HzF, localHashMap1, localHashMap2);
    localHashMap1.put("flag", paramw.flag);
    if ("2".equals(paramw.flag)) {
      localHashMap1.put("passwd", paramw.mVf);
    }
    localHashMap1.put("verify_code", paramw.OTh);
    localHashMap1.put("token", paramw.token);
    if ((paramw.HzF != null) && (!Util.isNullOrNil(paramw.HzF.fwv))) {
      localHashMap1.put("req_key", paramw.HzF.fwv);
    }
    if (paramInt >= 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt));
      Log.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!Util.isNullOrNil(paramw.fvP)) {
      localHashMap1.put("bank_type", paramw.fvP);
    }
    if ((paramw.flag == "2") && (paramw.ONf == 1) && (!Util.isNullOrNil(paramw.OIv)))
    {
      localHashMap1.put("verify_user_token", "1");
      localHashMap1.put("usertoken", paramw.OIv);
    }
    localHashMap1.put("session_id", paramString);
    if (z.iiS())
    {
      localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
      localHashMap2.put("bindcard_scene", z.iiT());
    }
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69935);
  }
  
  public final int getFuncId()
  {
    return 472;
  }
  
  public final int getTenpayCgicmd()
  {
    return 13;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/bindverify";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69936);
    this.OHI = new BindCardOrder();
    this.OHI.bM(paramJSONObject);
    this.action = paramJSONObject.optString("action");
    AppMethodBeat.o(69936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.w
 * JD-Core Version:    0.7.0.1
 */