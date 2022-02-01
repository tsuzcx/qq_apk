package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class w
  extends MStorage
{
  public final LinkedList<v> ESJ;
  
  public w()
  {
    AppMethodBeat.i(105154);
    this.ESJ = new LinkedList();
    hBL();
    AppMethodBeat.o(105154);
  }
  
  private void hBL()
  {
    AppMethodBeat.i(105155);
    Object localObject1 = (String)h.aHG().aHp().get(ar.a.Vvh, "");
    try
    {
      synchronized (this.ESJ)
      {
        this.ESJ.clear();
        localObject1 = new JSONArray((String)localObject1);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          v localv = new v();
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localv.key = localJSONObject.optString("key", "");
          localv.VIP = localJSONObject.optInt("use_count", 0);
          localv.kje = localJSONObject.optLong("last_time", 0L);
          this.ESJ.add(localv);
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
      bJQ();
      AppMethodBeat.o(105155);
    }
  }
  
  public final void bJQ()
  {
    AppMethodBeat.i(105157);
    h.aHG().aHp().set(ar.a.Vvh, null);
    this.ESJ.clear();
    AppMethodBeat.o(105157);
  }
  
  public final List<v> cUx()
  {
    AppMethodBeat.i(105156);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.ESJ)
    {
      Iterator localIterator = this.ESJ.iterator();
      while (localIterator.hasNext())
      {
        v localv = (v)localIterator.next();
        if (com.tencent.mm.cl.f.htQ().containsKey(localv.key)) {
          localArrayList.add(localv);
        }
      }
    }
    AppMethodBeat.o(105156);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.w
 * JD-Core Version:    0.7.0.1
 */