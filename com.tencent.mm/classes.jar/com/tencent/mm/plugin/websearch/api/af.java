package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
{
  public static bxr uJF;
  
  public static bxr cZw()
  {
    AppMethodBeat.i(124166);
    Object localObject;
    if (uJF == null)
    {
      localObject = cZx();
      uJF = new bxr();
      localObject = ah.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!bo.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      uJF.parseFrom((byte[])localObject);
      label67:
      localObject = uJF;
      AppMethodBeat.o(124166);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String cZx()
  {
    AppMethodBeat.i(124167);
    String str = "key_pb_history_list" + r.Zn();
    AppMethodBeat.o(124167);
    return str;
  }
  
  public static String cZy()
  {
    AppMethodBeat.i(124168);
    bxr localbxr = cZw();
    int j = localbxr.jJv.size();
    Object localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localbxr.jJv.size()) && (i < j))
      {
        bxq localbxq = (bxq)localbxr.jJv.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("word", localbxq.xHR);
        localJSONArray2.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("items", localJSONArray2);
      localJSONObject1.put("count", localJSONArray2.length());
      localJSONObject1.put("type", 4);
      localJSONArray1.put(localJSONObject1);
      ((JSONObject)localObject).put("data", localJSONArray1);
      ((JSONObject)localObject).put("ret", 0);
    }
    catch (JSONException localJSONException)
    {
      label177:
      break label177;
    }
    localObject = ((JSONObject)localObject).toString();
    AppMethodBeat.o(124168);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.af
 * JD-Core Version:    0.7.0.1
 */