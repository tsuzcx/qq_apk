package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends m
{
  public int BoV;
  public int BoW;
  public String[] Bro;
  public Profession[] BsH;
  public int BsI;
  
  public l()
  {
    AppMethodBeat.i(70156);
    this.BsH = null;
    this.Bro = null;
    HashMap localHashMap = new HashMap();
    if (!bs.isNullOrNil(null)) {
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
    ac.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ac.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", new Object[] { paramJSONObject.toString() });
    this.BoV = paramJSONObject.optInt("need_area");
    this.BoW = paramJSONObject.optInt("need_profession");
    paramString = paramJSONObject.optJSONArray("array");
    if (paramString != null)
    {
      this.BsH = new Profession[paramString.length()];
      paramInt = 0;
      if (paramInt < paramString.length())
      {
        Object localObject = paramString.optJSONObject(paramInt);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("profession_name");
          int j = ((JSONObject)localObject).optInt("profession_type");
          if (bs.isNullOrNil(str)) {
            break label166;
          }
          localObject = new Profession(str, j);
          this.BsH[paramInt] = localObject;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label166:
          ac.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
        }
      }
    }
    this.BsI = paramJSONObject.optInt("need_nationality");
    paramString = paramJSONObject.optJSONArray("nationality_exclude_array");
    if (paramString != null)
    {
      this.Bro = new String[paramString.length()];
      paramInt = i;
      while (paramInt < paramString.length())
      {
        this.Bro[paramInt] = paramString.optString(paramInt);
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