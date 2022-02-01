package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends m
{
  public int DgO;
  public int DgP;
  public String[] Djh;
  public Profession[] DkC;
  public int DkD;
  
  public l()
  {
    AppMethodBeat.i(70156);
    this.DkC = null;
    this.Djh = null;
    HashMap localHashMap = new HashMap();
    if (!bu.isNullOrNil(null)) {
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
    ae.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ae.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", new Object[] { paramJSONObject.toString() });
    this.DgO = paramJSONObject.optInt("need_area");
    this.DgP = paramJSONObject.optInt("need_profession");
    paramString = paramJSONObject.optJSONArray("array");
    if (paramString != null)
    {
      this.DkC = new Profession[paramString.length()];
      paramInt = 0;
      if (paramInt < paramString.length())
      {
        Object localObject = paramString.optJSONObject(paramInt);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("profession_name");
          int j = ((JSONObject)localObject).optInt("profession_type");
          if (bu.isNullOrNil(str)) {
            break label166;
          }
          localObject = new Profession(str, j);
          this.DkC[paramInt] = localObject;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label166:
          ae.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
        }
      }
    }
    this.DkD = paramJSONObject.optInt("need_nationality");
    paramString = paramJSONObject.optJSONArray("nationality_exclude_array");
    if (paramString != null)
    {
      this.Djh = new String[paramString.length()];
      paramInt = i;
      while (paramInt < paramString.length())
      {
        this.Djh[paramInt] = paramString.optString(paramInt);
        paramInt += 1;
      }
    }
    AppMethodBeat.o(70157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.l
 * JD-Core Version:    0.7.0.1
 */