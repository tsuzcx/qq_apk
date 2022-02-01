package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
{
  public static cnv AGP;
  
  public static String bdo()
  {
    AppMethodBeat.i(117724);
    String str = "key_pb_history_list" + u.aqG();
    AppMethodBeat.o(117724);
    return str;
  }
  
  public static cnv ehZ()
  {
    AppMethodBeat.i(117723);
    Object localObject;
    if (AGP == null)
    {
      localObject = bdo();
      AGP = new cnv();
      localObject = aj.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!bt.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      AGP.parseFrom((byte[])localObject);
      label67:
      localObject = AGP;
      AppMethodBeat.o(117723);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String eia()
  {
    AppMethodBeat.i(117725);
    cnv localcnv = ehZ();
    int j = localcnv.mAL.size();
    Object localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localcnv.mAL.size()) && (i < j))
      {
        cnu localcnu = (cnu)localcnv.mAL.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("word", localcnu.CLI);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ae
 * JD-Core Version:    0.7.0.1
 */