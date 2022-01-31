package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends j
{
  public List<l> rQK;
  public int rQL;
  public String token;
  
  public e(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bind_serialno", paramString);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    for (;;)
    {
      try
      {
        this.token = paramJSONObject.getString("session_key");
        this.rQL = paramJSONObject.optInt("answer_times_left", -1);
        paramString = paramJSONObject.getJSONArray("Array");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break;
        }
        paramJSONObject = new HashMap();
        int i = paramString.length();
        paramInt = 0;
        if (paramInt < i)
        {
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          l locall = new l();
          locall.id = localJSONObject.getString("qt_id");
          locall.rRe = localJSONObject.getString("parent_id");
          locall.type = localJSONObject.getString("qt_type");
          locall.desc = localJSONObject.getString("qt_cont");
          locall.rRf = localJSONObject.getInt("ans_len");
          locall.ioU = localJSONObject.getString("wording");
          locall.level = localJSONObject.getInt("level");
          if ((paramJSONObject.containsKey(locall.rRe)) && (!"0".equals(locall.rRe))) {
            ((l)paramJSONObject.get(locall.rRe)).rRg = locall;
          } else {
            paramJSONObject.put(locall.id, locall);
          }
        }
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
        return;
      }
      this.rQK = new ArrayList(paramJSONObject.values());
      paramJSONObject.clear();
      return;
      paramInt += 1;
    }
  }
  
  public final int aEC()
  {
    return 59;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.e
 * JD-Core Version:    0.7.0.1
 */