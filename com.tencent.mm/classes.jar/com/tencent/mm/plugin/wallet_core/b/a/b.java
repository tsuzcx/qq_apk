package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends m
  implements j
{
  public BindCardOrder Bon;
  public int Boo;
  public String desc;
  public String hVu;
  public String title;
  
  public b(u paramu)
  {
    this(paramu, -1, "", null);
  }
  
  public b(u paramu, int paramInt, String paramString, RealNameBundle paramRealNameBundle)
  {
    AppMethodBeat.i(174437);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("flag", paramu.flag);
    localHashMap1.put("passwd", paramu.iJA);
    localHashMap1.put("verify_code", paramu.BzM);
    localHashMap1.put("token", paramu.token);
    if (paramu.BzN) {}
    for (String str = "1";; str = "0")
    {
      localHashMap1.put("bind_flag", str);
      if (paramInt > 0)
      {
        localHashMap1.put("realname_scene", String.valueOf(paramInt));
        ac.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
      }
      if (paramRealNameBundle != null) {
        paramRealNameBundle.aQ(localHashMap1);
      }
      if (!bs.isNullOrNil(paramu.cZz)) {
        localHashMap1.put("bank_type", paramu.cZz);
      }
      localHashMap1.put("session_id", paramString);
      if (z.fAn())
      {
        localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
        localHashMap2.put("bindcard_scene", z.fAo());
      }
      setPayInfo(paramu.wfX, localHashMap1, localHashMap2);
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(174437);
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
    AppMethodBeat.i(69886);
    this.Bon = new BindCardOrder();
    this.Bon.aT(paramJSONObject);
    this.title = paramJSONObject.optString("title");
    this.desc = paramJSONObject.optString("desc");
    this.hVu = paramJSONObject.optString("page");
    this.Boo = paramJSONObject.optInt("err_jump_page");
    AppMethodBeat.o(69886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.b
 * JD-Core Version:    0.7.0.1
 */