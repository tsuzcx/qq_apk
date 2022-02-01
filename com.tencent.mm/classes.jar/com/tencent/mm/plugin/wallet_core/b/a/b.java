package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public BindCardOrder COC;
  public int COD;
  public String desc;
  public String ioP;
  public String title;
  
  public b(v paramv)
  {
    this(paramv, -1, "", null);
  }
  
  public b(v paramv, int paramInt, String paramString, RealNameBundle paramRealNameBundle)
  {
    AppMethodBeat.i(174437);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("flag", paramv.flag);
    localHashMap1.put("passwd", paramv.jcJ);
    localHashMap1.put("verify_code", paramv.Daf);
    localHashMap1.put("token", paramv.token);
    if (paramv.Dag) {}
    for (String str = "1";; str = "0")
    {
      localHashMap1.put("bind_flag", str);
      if (paramInt > 0)
      {
        localHashMap1.put("realname_scene", String.valueOf(paramInt));
        ad.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
      }
      if (paramRealNameBundle != null) {
        paramRealNameBundle.aT(localHashMap1);
      }
      if (!bt.isNullOrNil(paramv.dkR)) {
        localHashMap1.put("bank_type", paramv.dkR);
      }
      localHashMap1.put("session_id", paramString);
      if (z.fRx())
      {
        localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
        localHashMap2.put("bindcard_scene", z.fRy());
      }
      setPayInfo(paramv.xnF, localHashMap1, localHashMap2);
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
    this.COC = new BindCardOrder();
    this.COC.bb(paramJSONObject);
    this.title = paramJSONObject.optString("title");
    this.desc = paramJSONObject.optString("desc");
    this.ioP = paramJSONObject.optString("page");
    this.COD = paramJSONObject.optInt("err_jump_page");
    AppMethodBeat.o(69886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.b
 * JD-Core Version:    0.7.0.1
 */