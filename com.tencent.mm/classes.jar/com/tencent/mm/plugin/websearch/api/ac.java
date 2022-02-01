package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
{
  public static ctc BZh;
  
  public static String bkj()
  {
    AppMethodBeat.i(117724);
    String str = "key_pb_history_list" + u.axw();
    AppMethodBeat.o(117724);
    return str;
  }
  
  public static ctc ext()
  {
    AppMethodBeat.i(117723);
    Object localObject;
    if (BZh == null)
    {
      localObject = bkj();
      BZh = new ctc();
      localObject = ai.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!bs.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      BZh.parseFrom((byte[])localObject);
      label67:
      localObject = BZh;
      AppMethodBeat.o(117723);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String exu()
  {
    AppMethodBeat.i(117725);
    ctc localctc = ext();
    int j = localctc.ncM.size();
    Object localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localctc.ncM.size()) && (i < j))
      {
        ctb localctb = (ctb)localctc.ncM.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("word", localctb.Eel);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac
 * JD-Core Version:    0.7.0.1
 */