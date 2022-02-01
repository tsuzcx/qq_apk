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

public final class v
  extends m
{
  public BindCardOrder HPA;
  public String action;
  
  public v(com.tencent.mm.plugin.wallet_core.model.v paramv)
  {
    this(paramv, -1, "");
  }
  
  public v(com.tencent.mm.plugin.wallet_core.model.v paramv, int paramInt, String paramString)
  {
    AppMethodBeat.i(69935);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramv.BDB, localHashMap1, localHashMap2);
    localHashMap1.put("flag", paramv.flag);
    if ("2".equals(paramv.flag)) {
      localHashMap1.put("passwd", paramv.kdF);
    }
    localHashMap1.put("verify_code", paramv.IaW);
    localHashMap1.put("token", paramv.token);
    if ((paramv.BDB != null) && (!Util.isNullOrNil(paramv.BDB.dDL))) {
      localHashMap1.put("req_key", paramv.BDB.dDL);
    }
    if (paramInt >= 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt));
      Log.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!Util.isNullOrNil(paramv.dDj)) {
      localHashMap1.put("bank_type", paramv.dDj);
    }
    if ((paramv.flag == "2") && (paramv.HVe == 1) && (!Util.isNullOrNil(paramv.HQm)))
    {
      localHashMap1.put("verify_user_token", "1");
      localHashMap1.put("usertoken", paramv.HQm);
    }
    localHashMap1.put("session_id", paramString);
    if (z.hhq())
    {
      localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
      localHashMap2.put("bindcard_scene", z.hhr());
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
    this.HPA = new BindCardOrder();
    this.HPA.bB(paramJSONObject);
    this.action = paramJSONObject.optString("action");
    AppMethodBeat.o(69936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */