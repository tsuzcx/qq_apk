package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends m
{
  public int ubV;
  public int ubW;
  public String[] udu;
  public Profession[] ueq;
  public int uer;
  
  public g()
  {
    AppMethodBeat.i(46650);
    this.ueq = null;
    this.udu = null;
    HashMap localHashMap = new HashMap();
    if (!bo.isNullOrNil(null)) {
      localHashMap.put("scene", null);
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(46650);
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
    AppMethodBeat.i(46651);
    ab.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ab.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", new Object[] { paramJSONObject.toString() });
    this.ubV = paramJSONObject.optInt("need_area");
    this.ubW = paramJSONObject.optInt("need_profession");
    paramString = paramJSONObject.optJSONArray("array");
    if (paramString != null)
    {
      this.ueq = new Profession[paramString.length()];
      paramInt = 0;
      if (paramInt < paramString.length())
      {
        Object localObject = paramString.optJSONObject(paramInt);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("profession_name");
          int j = ((JSONObject)localObject).optInt("profession_type");
          if (bo.isNullOrNil(str)) {
            break label166;
          }
          localObject = new Profession(str, j);
          this.ueq[paramInt] = localObject;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label166:
          ab.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
        }
      }
    }
    this.uer = paramJSONObject.optInt("need_nationality");
    paramString = paramJSONObject.optJSONArray("nationality_exclude_array");
    if (paramString != null)
    {
      this.udu = new String[paramString.length()];
      paramInt = i;
      while (paramInt < paramString.length())
      {
        this.udu[paramInt] = paramString.optString(paramInt);
        paramInt += 1;
      }
    }
    AppMethodBeat.o(46651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.g
 * JD-Core Version:    0.7.0.1
 */