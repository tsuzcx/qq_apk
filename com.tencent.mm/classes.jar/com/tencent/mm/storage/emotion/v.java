package com.tencent.mm.storage.emotion;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class v
  extends j
{
  public HashMap<String, u> uDz;
  
  public final List<u> aHv()
  {
    if (this.uDz == null) {
      cwV();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.uDz.values().iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      if ((localu.position >= 0) && (localu.position < com.tencent.mm.cd.e.csH().asw())) {
        localArrayList.add(localu);
      }
    }
    Collections.sort(localArrayList, new v.1(this));
    return localArrayList;
  }
  
  public final void aUK()
  {
    g.DP().Dz().c(ac.a.uzx, null);
    this.uDz = new HashMap();
  }
  
  public final void cwV()
  {
    Object localObject = (String)g.DP().Dz().get(ac.a.uzx, "");
    this.uDz = new HashMap();
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        u localu = new u();
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        localu.key = localJSONObject.optString("key", "");
        localu.position = localJSONObject.optInt("position", 0);
        localu.uDy = localJSONObject.optInt("use_count", 0);
        localu.dXA = localJSONObject.optLong("last_time", 0L);
        this.uDz.put(localu.key, localu);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.w("SmileyUsageInfoStorage", "data error clear all");
      aUK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.v
 * JD-Core Version:    0.7.0.1
 */