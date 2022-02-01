package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
{
  public BindCardOrder COC;
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
    setPayInfo(paramv.xnF, localHashMap1, localHashMap2);
    localHashMap1.put("flag", paramv.flag);
    if ("2".equals(paramv.flag)) {
      localHashMap1.put("passwd", paramv.jcJ);
    }
    localHashMap1.put("verify_code", paramv.Daf);
    localHashMap1.put("token", paramv.token);
    if ((paramv.xnF != null) && (!bt.isNullOrNil(paramv.xnF.dlu))) {
      localHashMap1.put("req_key", paramv.xnF.dlu);
    }
    if (paramInt >= 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt));
      ad.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!bt.isNullOrNil(paramv.dkR)) {
      localHashMap1.put("bank_type", paramv.dkR);
    }
    if ((paramv.flag == "2") && (paramv.CUf == 1) && (!bt.isNullOrNil(paramv.CPp)))
    {
      localHashMap1.put("verify_user_token", "1");
      localHashMap1.put("usertoken", paramv.CPp);
    }
    localHashMap1.put("session_id", paramString);
    if (z.fRx())
    {
      localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
      localHashMap2.put("bindcard_scene", z.fRy());
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
    this.COC = new BindCardOrder();
    this.COC.bb(paramJSONObject);
    this.action = paramJSONObject.optString("action");
    AppMethodBeat.o(69936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */