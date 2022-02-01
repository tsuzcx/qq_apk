package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class v
  extends k
{
  public final LinkedList<u> tvP;
  
  public v()
  {
    AppMethodBeat.i(105154);
    this.tvP = new LinkedList();
    eNS();
    AppMethodBeat.o(105154);
  }
  
  private void eNS()
  {
    AppMethodBeat.i(105155);
    Object localObject1 = (String)g.afB().afk().get(ae.a.Ftw, "");
    try
    {
      synchronized (this.tvP)
      {
        this.tvP.clear();
        localObject1 = new JSONArray((String)localObject1);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          u localu = new u();
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localu.key = localJSONObject.optString("key", "");
          localu.FBZ = localJSONObject.optInt("use_count", 0);
          localu.glk = localJSONObject.optLong("last_time", 0L);
          this.tvP.add(localu);
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
      aSi();
      AppMethodBeat.o(105155);
    }
  }
  
  public final void aSi()
  {
    AppMethodBeat.i(105157);
    g.afB().afk().set(ae.a.Ftw, null);
    this.tvP.clear();
    AppMethodBeat.o(105157);
  }
  
  public final List<u> bUL()
  {
    AppMethodBeat.i(105156);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.tvP)
    {
      Iterator localIterator = this.tvP.iterator();
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if (com.tencent.mm.cg.e.eHT().containsKey(localu.key)) {
          localArrayList.add(localu);
        }
      }
    }
    AppMethodBeat.o(105156);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.v
 * JD-Core Version:    0.7.0.1
 */