package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.evt;
import com.tencent.mm.protocal.protobuf.evu;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class am
{
  public static evu Wpw;
  
  public static String cwe()
  {
    AppMethodBeat.i(117724);
    String str = "key_pb_history_list" + z.bAM();
    AppMethodBeat.o(117724);
    return str;
  }
  
  public static evu iqd()
  {
    AppMethodBeat.i(117723);
    Object localObject;
    if (Wpw == null)
    {
      localObject = cwe();
      Wpw = new evu();
      localObject = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!Util.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      Wpw.parseFrom((byte[])localObject);
      label67:
      localObject = Wpw;
      AppMethodBeat.o(117723);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String iqe()
  {
    AppMethodBeat.i(117725);
    evu localevu = iqd();
    int j = localevu.vgO.size();
    Object localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localevu.vgO.size()) && (i < j))
      {
        evt localevt = (evt)localevu.vgO.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("word", localevt.YWK);
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am
 * JD-Core Version:    0.7.0.1
 */