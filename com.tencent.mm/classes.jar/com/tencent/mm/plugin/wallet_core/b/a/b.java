package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends m
  implements i
{
  public BindCardOrder ubq;
  
  public b(u paramu)
  {
    this(paramu, -1);
  }
  
  public b(u paramu, int paramInt)
  {
    AppMethodBeat.i(46486);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("flag", paramu.flag);
    localHashMap1.put("passwd", paramu.gww);
    localHashMap1.put("verify_code", paramu.uld);
    localHashMap1.put("token", paramu.token);
    if (paramu.ule) {}
    for (String str = "1";; str = "0")
    {
      localHashMap1.put("bind_flag", str);
      if (paramInt > 0)
      {
        localHashMap1.put("realname_scene", String.valueOf(paramInt));
        ab.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
      }
      if (!bo.isNullOrNil(paramu.poq)) {
        localHashMap1.put("bank_type", paramu.poq);
      }
      if (x.dSp())
      {
        localHashMap2.put("uuid_for_bindcard", x.dSr());
        localHashMap2.put("bindcard_scene", x.dSq());
      }
      setPayInfo(paramu.pVo, localHashMap1, localHashMap2);
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(46486);
      return;
    }
  }
  
  public final int getFuncId()
  {
    return 475;
  }
  
  public final int getTenpayCgicmd()
  {
    return 17;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/bindverifyreg";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46487);
    this.ubq = new BindCardOrder();
    this.ubq.ax(paramJSONObject);
    AppMethodBeat.o(46487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.b
 * JD-Core Version:    0.7.0.1
 */