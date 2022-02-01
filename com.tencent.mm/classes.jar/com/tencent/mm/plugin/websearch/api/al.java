package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class al
{
  public static ecd Pzn;
  
  public static String bVR()
  {
    AppMethodBeat.i(117724);
    String str = "key_pb_history_list" + z.bcZ();
    AppMethodBeat.o(117724);
    return str;
  }
  
  public static ecd gQR()
  {
    AppMethodBeat.i(117723);
    Object localObject;
    if (Pzn == null)
    {
      localObject = bVR();
      Pzn = new ecd();
      localObject = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!Util.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      Pzn.parseFrom((byte[])localObject);
      label67:
      localObject = Pzn;
      AppMethodBeat.o(117723);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String gQS()
  {
    AppMethodBeat.i(117725);
    ecd localecd = gQR();
    int j = localecd.rVy.size();
    Object localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localecd.rVy.size()) && (i < j))
      {
        ecc localecc = (ecc)localecd.rVy.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("word", localecc.RYJ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al
 * JD-Core Version:    0.7.0.1
 */