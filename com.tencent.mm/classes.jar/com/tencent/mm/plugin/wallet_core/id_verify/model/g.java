package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends j
{
  public int qqZ;
  public int qra;
  public Profession[] qss = null;
  
  public g()
  {
    HashMap localHashMap = new HashMap();
    if (!bk.bl(null)) {
      localHashMap.put("scene", null);
    }
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1976;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    int i = 0;
    y.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    y.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", new Object[] { paramJSONObject.toString() });
    this.qqZ = paramJSONObject.optInt("need_area");
    this.qra = paramJSONObject.optInt("need_profession");
    paramString = paramJSONObject.optJSONArray("array");
    if (paramString != null)
    {
      this.qss = new Profession[paramString.length()];
      paramInt = i;
      if (paramInt < paramString.length())
      {
        paramJSONObject = paramString.optJSONObject(paramInt);
        if (paramJSONObject != null)
        {
          String str = paramJSONObject.optString("profession_name");
          i = paramJSONObject.optInt("profession_type");
          if (bk.bl(str)) {
            break label156;
          }
          paramJSONObject = new Profession(str, i);
          this.qss[paramInt] = paramJSONObject;
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label156:
          y.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
        }
      }
    }
  }
  
  public final int aEC()
  {
    return 1976;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getuserexinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.g
 * JD-Core Version:    0.7.0.1
 */