package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class w
  extends k
{
  public final LinkedList<v> uEi;
  
  public w()
  {
    AppMethodBeat.i(105154);
    this.uEi = new LinkedList();
    fdw();
    AppMethodBeat.o(105154);
  }
  
  private void fdw()
  {
    AppMethodBeat.i(105155);
    Object localObject1 = (String)g.agR().agA().get(ah.a.GRq, "");
    try
    {
      synchronized (this.uEi)
      {
        this.uEi.clear();
        localObject1 = new JSONArray((String)localObject1);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          v localv = new v();
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localv.key = localJSONObject.optString("key", "");
          localv.Hbc = localJSONObject.optInt("use_count", 0);
          localv.gLX = localJSONObject.optLong("last_time", 0L);
          this.uEi.add(localv);
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
      aZf();
      AppMethodBeat.o(105155);
    }
  }
  
  public final void aZf()
  {
    AppMethodBeat.i(105157);
    g.agR().agA().set(ah.a.GRq, null);
    this.uEi.clear();
    AppMethodBeat.o(105157);
  }
  
  public final List<v> cbY()
  {
    AppMethodBeat.i(105156);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.uEi)
    {
      Iterator localIterator = this.uEi.iterator();
      while (localIterator.hasNext())
      {
        v localv = (v)localIterator.next();
        if (com.tencent.mm.cf.e.eXp().containsKey(localv.key)) {
          localArrayList.add(localv);
        }
      }
    }
    AppMethodBeat.o(105156);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.w
 * JD-Core Version:    0.7.0.1
 */