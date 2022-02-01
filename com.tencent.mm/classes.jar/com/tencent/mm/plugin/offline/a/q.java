package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.c;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  private q(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    AppMethodBeat.i(269120);
    HashMap localHashMap = new HashMap();
    localHashMap.put("residue_num", String.valueOf(paramInt1));
    localHashMap.put("entry_scene", String.valueOf(paramInt2));
    localHashMap.put("is_snapshot", String.valueOf(paramInt3));
    localHashMap.put("user_view_digit", String.valueOf(paramInt4));
    StringBuilder localStringBuilder = new StringBuilder();
    h.baF();
    localHashMap.put("code_ver", h.baE().ban().get(at.a.acHB, ""));
    localHashMap.put("card_id", d.wrg);
    localHashMap.put("user_card_id", d.MDo);
    localHashMap.put("card_code", d.MDp);
    localHashMap.put("ext_business_attach", paramString1);
    localHashMap.put("is_new_authcodes", paramString2);
    paramString1 = c.MDa;
    paramString1 = c.gwy();
    if (paramString1 != null)
    {
      localHashMap.put("prefer_bind_serial", paramString1.field_bindSerial);
      localHashMap.put("prefer_bank_type", paramString1.field_bankcardType);
    }
    setRequestData(localHashMap);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d, user_view_digit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", new Object[] { d.wrg, d.MDo, d.MDp });
    AppMethodBeat.o(269120);
  }
  
  public q(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this(paramInt1, paramInt2, 0, paramInt3, "", paramString);
  }
  
  public q(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this(paramInt1, paramInt2, paramInt3, 0, paramString1, paramString2);
  }
  
  public final int getFuncId()
  {
    return 1645;
  }
  
  public final int getTenpayCgicmd()
  {
    return 102;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineshowcode";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66313);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "onGynetEnd %s %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(66313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.q
 * JD-Core Version:    0.7.0.1
 */