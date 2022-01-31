package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t
  extends m
{
  public BindCardOrder ubq;
  
  public t(u paramu)
  {
    this(paramu, -1);
  }
  
  public t(u paramu, int paramInt)
  {
    AppMethodBeat.i(46530);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramu.pVo, localHashMap1, localHashMap2);
    localHashMap1.put("flag", paramu.flag);
    if ("2".equals(paramu.flag)) {
      localHashMap1.put("passwd", paramu.gww);
    }
    localHashMap1.put("verify_code", paramu.uld);
    localHashMap1.put("token", paramu.token);
    if ((paramu.pVo != null) && (!bo.isNullOrNil(paramu.pVo.cnI))) {
      localHashMap1.put("req_key", paramu.pVo.cnI);
    }
    if (paramInt >= 0)
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
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(46530);
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
    AppMethodBeat.i(46531);
    ab.i("test", "test");
    this.ubq = new BindCardOrder();
    this.ubq.ax(paramJSONObject);
    AppMethodBeat.o(46531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */