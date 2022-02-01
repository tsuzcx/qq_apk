package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
{
  public BindCardOrder Bon;
  public String action;
  
  public v(u paramu)
  {
    this(paramu, -1, "");
  }
  
  public v(u paramu, int paramInt, String paramString)
  {
    AppMethodBeat.i(69935);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramu.wfX, localHashMap1, localHashMap2);
    localHashMap1.put("flag", paramu.flag);
    if ("2".equals(paramu.flag)) {
      localHashMap1.put("passwd", paramu.iJA);
    }
    localHashMap1.put("verify_code", paramu.BzM);
    localHashMap1.put("token", paramu.token);
    if ((paramu.wfX != null) && (!bs.isNullOrNil(paramu.wfX.dac))) {
      localHashMap1.put("req_key", paramu.wfX.dac);
    }
    if (paramInt >= 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt));
      ac.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!bs.isNullOrNil(paramu.cZz)) {
      localHashMap1.put("bank_type", paramu.cZz);
    }
    if ((paramu.flag == "2") && (paramu.BtQ == 1) && (!bs.isNullOrNil(paramu.Bpa)))
    {
      localHashMap1.put("verify_user_token", "1");
      localHashMap1.put("usertoken", paramu.Bpa);
    }
    localHashMap1.put("session_id", paramString);
    if (z.fAn())
    {
      localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
      localHashMap2.put("bindcard_scene", z.fAo());
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
    this.Bon = new BindCardOrder();
    this.Bon.aT(paramJSONObject);
    this.action = paramJSONObject.optString("action");
    AppMethodBeat.o(69936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */