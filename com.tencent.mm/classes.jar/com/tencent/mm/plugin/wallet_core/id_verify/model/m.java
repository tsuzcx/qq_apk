package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.wallet_core.tenpay.model.m
{
  public m(String paramString1, String paramString2, String paramString3, Profession paramProfession, String paramString4)
  {
    AppMethodBeat.i(70158);
    ae.d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s, nationality: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    HashMap localHashMap = new HashMap();
    if (!bu.isNullOrNil(paramString1)) {
      localHashMap.put("user_country", paramString1);
    }
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("user_province", paramString2);
    }
    if (!bu.isNullOrNil(paramString3)) {
      localHashMap.put("user_city", paramString3);
    }
    if (paramProfession != null)
    {
      ae.d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", new Object[] { paramProfession.DkE, Integer.valueOf(paramProfession.DkF) });
      localHashMap.put("profession_name", paramProfession.DkE);
      localHashMap.put("profession_type", String.valueOf(paramProfession.DkF));
    }
    if (!bu.isNullOrNil(paramString4)) {
      localHashMap.put("nationality", paramString4);
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(70158);
  }
  
  public final int getFuncId()
  {
    return 1978;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1978;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/setuserexinfo";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70159);
    ae.i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(70159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.m
 * JD-Core Version:    0.7.0.1
 */