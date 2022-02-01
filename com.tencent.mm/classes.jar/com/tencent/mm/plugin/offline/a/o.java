package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends m
{
  public o(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, 0, paramInt3, "");
  }
  
  private o(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(66312);
    HashMap localHashMap = new HashMap();
    localHashMap.put("residue_num", String.valueOf(paramInt1));
    localHashMap.put("entry_scene", String.valueOf(paramInt2));
    localHashMap.put("is_snapshot", String.valueOf(paramInt3));
    localHashMap.put("user_view_digit", String.valueOf(paramInt4));
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAi();
    localHashMap.put("code_ver", g.aAh().azQ().get(ar.a.NSo, ""));
    localHashMap.put("card_id", a.pQH);
    localHashMap.put("user_card_id", a.ANj);
    localHashMap.put("card_code", a.ANk);
    localHashMap.put("ext_business_attach", paramString);
    setRequestData(localHashMap);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d, user_view_digit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", new Object[] { a.pQH, a.ANj, a.ANk });
    AppMethodBeat.o(66312);
  }
  
  public o(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this(paramInt1, paramInt2, paramInt3, 0, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.o
 * JD-Core Version:    0.7.0.1
 */