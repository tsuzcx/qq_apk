package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
{
  public BindCardOrder Dgh;
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
    setPayInfo(paramv.xDC, localHashMap1, localHashMap2);
    localHashMap1.put("flag", paramv.flag);
    if ("2".equals(paramv.flag)) {
      localHashMap1.put("passwd", paramv.jfC);
    }
    localHashMap1.put("verify_code", paramv.DrK);
    localHashMap1.put("token", paramv.token);
    if ((paramv.xDC != null) && (!bu.isNullOrNil(paramv.xDC.dmw))) {
      localHashMap1.put("req_key", paramv.xDC.dmw);
    }
    if (paramInt >= 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt));
      ae.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!bu.isNullOrNil(paramv.dlT)) {
      localHashMap1.put("bank_type", paramv.dlT);
    }
    if ((paramv.flag == "2") && (paramv.DlL == 1) && (!bu.isNullOrNil(paramv.DgT)))
    {
      localHashMap1.put("verify_user_token", "1");
      localHashMap1.put("usertoken", paramv.DgT);
    }
    localHashMap1.put("session_id", paramString);
    if (z.fVT())
    {
      localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
      localHashMap2.put("bindcard_scene", z.fVU());
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
    this.Dgh = new BindCardOrder();
    this.Dgh.bb(paramJSONObject);
    this.action = paramJSONObject.optString("action");
    AppMethodBeat.o(69936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */