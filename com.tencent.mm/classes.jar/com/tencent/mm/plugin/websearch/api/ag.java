package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag
{
  public static czg DUa;
  
  public static String boE()
  {
    AppMethodBeat.i(117724);
    String str = "key_pb_history_list" + v.aAC();
    AppMethodBeat.o(117724);
    return str;
  }
  
  public static czg ePT()
  {
    AppMethodBeat.i(117723);
    Object localObject;
    if (DUa == null)
    {
      localObject = boE();
      DUa = new czg();
      localObject = ak.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!bu.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      DUa.parseFrom((byte[])localObject);
      label67:
      localObject = DUa;
      AppMethodBeat.o(117723);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String ePU()
  {
    AppMethodBeat.i(117725);
    czg localczg = ePT();
    int j = localczg.nIE.size();
    Object localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localczg.nIE.size()) && (i < j))
      {
        czf localczf = (czf)localczg.nIE.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("word", localczf.Gdj);
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
    AppMethodBeat.o(117725);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ag
 * JD-Core Version:    0.7.0.1
 */