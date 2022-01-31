package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends j
{
  public BindCardOrder qqu;
  
  public q(p paramp)
  {
    this(paramp, -1);
  }
  
  public q(p paramp, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    a(paramp.nqa, localHashMap1, localHashMap2);
    localHashMap1.put("flag", paramp.flag);
    if ("2".equals(paramp.flag)) {
      localHashMap1.put("passwd", paramp.feN);
    }
    localHashMap1.put("verify_code", paramp.qyu);
    localHashMap1.put("token", paramp.token);
    if ((paramp.nqa != null) && (!bk.bl(paramp.nqa.bMX))) {
      localHashMap1.put("req_key", paramp.nqa.bMX);
    }
    if (paramInt >= 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt));
      y.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!bk.bl(paramp.mOb)) {
      localHashMap1.put("bank_type", paramp.mOb);
    }
    if (v.cMA())
    {
      localHashMap2.put("uuid_for_bindcard", v.cMC());
      localHashMap2.put("bindcard_scene", v.cMB());
    }
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  public final int HH()
  {
    return 472;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("test", "test");
    this.qqu = new BindCardOrder();
    this.qqu.an(paramJSONObject);
  }
  
  public final int aEC()
  {
    return 13;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/bindverify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */