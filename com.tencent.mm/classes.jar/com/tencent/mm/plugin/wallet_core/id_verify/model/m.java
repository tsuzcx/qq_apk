package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.wallet_core.tenpay.model.m
{
  public m(String paramString1, String paramString2, String paramString3, Profession paramProfession, String paramString4)
  {
    AppMethodBeat.i(70158);
    ad.d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s, nationality: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    HashMap localHashMap = new HashMap();
    if (!bt.isNullOrNil(paramString1)) {
      localHashMap.put("user_country", paramString1);
    }
    if (!bt.isNullOrNil(paramString2)) {
      localHashMap.put("user_province", paramString2);
    }
    if (!bt.isNullOrNil(paramString3)) {
      localHashMap.put("user_city", paramString3);
    }
    if (paramProfession != null)
    {
      ad.d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", new Object[] { paramProfession.Aap, Integer.valueOf(paramProfession.Aaq) });
      localHashMap.put("profession_name", paramProfession.Aap);
      localHashMap.put("profession_type", String.valueOf(paramProfession.Aaq));
    }
    if (!bt.isNullOrNil(paramString4)) {
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
    ad.i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(70159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.m
 * JD-Core Version:    0.7.0.1
 */