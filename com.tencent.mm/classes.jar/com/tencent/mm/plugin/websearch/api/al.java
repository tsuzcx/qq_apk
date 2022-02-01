package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dsg;
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class al
{
  public static dsh IEV;
  
  public static String bKh()
  {
    AppMethodBeat.i(117724);
    String str = "key_pb_history_list" + z.aTY();
    AppMethodBeat.o(117724);
    return str;
  }
  
  public static dsh fYg()
  {
    AppMethodBeat.i(117723);
    Object localObject;
    if (IEV == null)
    {
      localObject = bKh();
      IEV = new dsh();
      localObject = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!Util.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      IEV.parseFrom((byte[])localObject);
      label67:
      localObject = IEV;
      AppMethodBeat.o(117723);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String fYh()
  {
    AppMethodBeat.i(117725);
    dsh localdsh = fYg();
    int j = localdsh.oTA.size();
    Object localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localdsh.oTA.size()) && (i < j))
      {
        dsg localdsg = (dsg)localdsh.oTA.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("word", localdsg.KXA);
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al
 * JD-Core Version:    0.7.0.1
 */