package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends m
{
  public Profession[] Aan;
  public int Aao;
  public int zWB;
  public int zWC;
  public String[] zYU;
  
  public l()
  {
    AppMethodBeat.i(70156);
    this.Aan = null;
    this.zYU = null;
    HashMap localHashMap = new HashMap();
    if (!bt.isNullOrNil(null)) {
      localHashMap.put("scene", null);
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(70156);
  }
  
  public final int getFuncId()
  {
    return 1976;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1976;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getuserexinfo";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(70157);
    ad.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ad.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", new Object[] { paramJSONObject.toString() });
    this.zWB = paramJSONObject.optInt("need_area");
    this.zWC = paramJSONObject.optInt("need_profession");
    paramString = paramJSONObject.optJSONArray("array");
    if (paramString != null)
    {
      this.Aan = new Profession[paramString.length()];
      paramInt = 0;
      if (paramInt < paramString.length())
      {
        Object localObject = paramString.optJSONObject(paramInt);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("profession_name");
          int j = ((JSONObject)localObject).optInt("profession_type");
          if (bt.isNullOrNil(str)) {
            break label166;
          }
          localObject = new Profession(str, j);
          this.Aan[paramInt] = localObject;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label166:
          ad.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
        }
      }
    }
    this.Aao = paramJSONObject.optInt("need_nationality");
    paramString = paramJSONObject.optJSONArray("nationality_exclude_array");
    if (paramString != null)
    {
      this.zYU = new String[paramString.length()];
      paramInt = i;
      while (paramInt < paramString.length())
      {
        this.zYU[paramInt] = paramString.optString(paramInt);
        paramInt += 1;
      }
    }
    AppMethodBeat.o(70157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.l
 * JD-Core Version:    0.7.0.1
 */