package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends j
{
  public h(String paramString1, String paramString2, String paramString3, Profession paramProfession)
  {
    y.d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s", new Object[] { paramString1, paramString2, paramString3 });
    HashMap localHashMap = new HashMap();
    if (!bk.bl(paramString1)) {
      localHashMap.put("user_country", paramString1);
    }
    if (!bk.bl(paramString2)) {
      localHashMap.put("user_province", paramString2);
    }
    if (!bk.bl(paramString3)) {
      localHashMap.put("user_city", paramString3);
    }
    if (paramProfession != null)
    {
      y.d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", new Object[] { paramProfession.qst, Integer.valueOf(paramProfession.qsu) });
      localHashMap.put("profession_name", paramProfession.qst);
      localHashMap.put("profession_type", String.valueOf(paramProfession.qsu));
    }
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1978;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final int aEC()
  {
    return 1978;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/setuserexinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.h
 * JD-Core Version:    0.7.0.1
 */