package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends m
{
  public List<l> QOa;
  public int QOb;
  public String token;
  
  public e(String paramString)
  {
    AppMethodBeat.i(72305);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bind_serialno", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(72305);
  }
  
  public final int getTenpayCgicmd()
  {
    return 59;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72306);
    Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72306);
      return;
    }
    for (;;)
    {
      try
      {
        this.token = paramJSONObject.getString("session_key");
        this.QOb = paramJSONObject.optInt("answer_times_left", -1);
        paramString = paramJSONObject.getJSONArray("Array");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label314;
        }
        paramJSONObject = new HashMap();
        int i = paramString.length();
        paramInt = 0;
        if (paramInt < i)
        {
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          l locall = new l();
          locall.id = localJSONObject.getString("qt_id");
          locall.QOt = localJSONObject.getString("parent_id");
          locall.type = localJSONObject.getString("qt_type");
          locall.desc = localJSONObject.getString("qt_cont");
          locall.QOu = localJSONObject.getInt("ans_len");
          locall.tsf = localJSONObject.getString("wording");
          locall.level = localJSONObject.getInt("level");
          if ((paramJSONObject.containsKey(locall.QOt)) && (!"0".equals(locall.QOt))) {
            ((l)paramJSONObject.get(locall.QOt)).QOv = locall;
          } else {
            paramJSONObject.put(locall.id, locall);
          }
        }
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
        AppMethodBeat.o(72306);
        return;
      }
      this.QOa = new ArrayList(paramJSONObject.values());
      paramJSONObject.clear();
      label314:
      AppMethodBeat.o(72306);
      return;
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.e
 * JD-Core Version:    0.7.0.1
 */