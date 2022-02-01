package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.smiley.o;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class y
  extends MStorage
{
  public final LinkedList<x> KNn;
  
  public y()
  {
    AppMethodBeat.i(105154);
    this.KNn = new LinkedList();
    jdM();
    AppMethodBeat.o(105154);
  }
  
  private void jdM()
  {
    AppMethodBeat.i(105155);
    Object localObject1 = (String)h.baE().ban().get(at.a.acWQ, "");
    try
    {
      synchronized (this.KNn)
      {
        this.KNn.clear();
        localObject1 = new JSONArray((String)localObject1);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          x localx = new x();
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localx.key = localJSONObject.optString("key", "");
          localx.admN = localJSONObject.optInt("use_count", 0);
          localx.mJI = localJSONObject.optLong("last_time", 0L);
          this.KNn.add(localx);
          i += 1;
        }
        AppMethodBeat.o(105155);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.w("SmileyUsageInfoStorage", "data error clear all");
      cju();
      AppMethodBeat.o(105155);
    }
  }
  
  public final void cju()
  {
    AppMethodBeat.i(105157);
    h.baE().ban().set(at.a.acWQ, null);
    this.KNn.clear();
    AppMethodBeat.o(105157);
  }
  
  public final List<x> dzE()
  {
    AppMethodBeat.i(105156);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.KNn)
    {
      Iterator localIterator = this.KNn.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if (o.iVl().containsKey(localx.key)) {
          localArrayList.add(localx);
        }
      }
    }
    AppMethodBeat.o(105156);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.y
 * JD-Core Version:    0.7.0.1
 */