package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
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

public final class t
  extends k
{
  public HashMap<String, s> yQg;
  
  public final void axH()
  {
    AppMethodBeat.i(62894);
    g.RL().Ru().set(ac.a.yKl, null);
    this.yQg = new HashMap();
    AppMethodBeat.o(62894);
  }
  
  public final List<s> blf()
  {
    AppMethodBeat.i(62893);
    if (this.yQg == null) {
      dzG();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.yQg.values().iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      if ((locals.position >= 0) && (locals.position < com.tencent.mm.cd.e.dve().aRA())) {
        localArrayList.add(locals);
      }
    }
    Collections.sort(localArrayList, new t.1(this));
    AppMethodBeat.o(62893);
    return localArrayList;
  }
  
  public final void dzG()
  {
    AppMethodBeat.i(62892);
    Object localObject = (String)g.RL().Ru().get(ac.a.yKl, "");
    this.yQg = new HashMap();
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        s locals = new s();
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        locals.key = localJSONObject.optString("key", "");
        locals.position = localJSONObject.optInt("position", 0);
        locals.yQf = localJSONObject.optInt("use_count", 0);
        locals.ePF = localJSONObject.optLong("last_time", 0L);
        this.yQg.put(locals.key, locals);
        i += 1;
      }
      AppMethodBeat.o(62892);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.w("SmileyUsageInfoStorage", "data error clear all");
      axH();
      AppMethodBeat.o(62892);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.t
 * JD-Core Version:    0.7.0.1
 */