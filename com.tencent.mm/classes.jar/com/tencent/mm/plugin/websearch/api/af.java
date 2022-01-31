package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.protocal.c.bnw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.IOException;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
{
  public static bnw qUu;
  
  public static bnw bZA()
  {
    Object localObject;
    if (qUu == null)
    {
      localObject = bZB();
      qUu = new bnw();
      localObject = ae.getContext().getSharedPreferences("fts_history_search_sp", 0).getString((String)localObject, "");
      if (!bk.bl((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      qUu.aH((byte[])localObject);
      label62:
      return qUu;
    }
    catch (IOException localIOException)
    {
      break label62;
    }
  }
  
  public static String bZB()
  {
    return "key_pb_history_list" + q.Gj();
  }
  
  public static String bZC()
  {
    bnw localbnw = bZA();
    int j = localbnw.hPT.size();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONArray localJSONArray2 = new JSONArray();
      int i = 0;
      while ((i < localbnw.hPT.size()) && (i < j))
      {
        bnv localbnv = (bnv)localbnw.hPT.get(i);
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("word", localbnv.tGE);
        localJSONArray2.put(localJSONObject3);
        i += 1;
      }
      localJSONObject2.put("items", localJSONArray2);
      localJSONObject2.put("count", localJSONArray2.length());
      localJSONObject2.put("type", 4);
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      localJSONObject1.put("ret", 0);
    }
    catch (JSONException localJSONException)
    {
      label172:
      break label172;
    }
    return localJSONObject1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.af
 * JD-Core Version:    0.7.0.1
 */