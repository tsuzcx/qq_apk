package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nr$d
{
  private boolean a = false;
  private long b = 0L;
  private long c = 0L;
  private nr.b d;
  private Set<nr.g> e;
  private nr.a f;
  
  private JSONObject a()
  {
    AppMethodBeat.i(149533);
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONObject1.put("loadSuccess", this.a);
      localJSONObject1.put("loadSuccessTime", this.b);
      localJSONObject1.put("firstLoadTime", this.c);
      if (this.d != null) {
        localJSONObject1.put("configUpdate", nr.b.a(this.d));
      }
      if ((this.e == null) || (this.e.size() <= 0)) {
        break label165;
      }
      localJSONArray = new JSONArray();
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject2 = nr.g.a((nr.g)localIterator.next());
        if (localJSONObject2 != null) {
          localJSONArray.put(localJSONObject2);
        }
      }
      if (localJSONArray.length() <= 0) {
        break label165;
      }
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149533);
      return null;
    }
    localJSONException.put("tileErrors", localJSONArray);
    label165:
    if (this.f != null) {
      localJSONException.put("configError", nr.a.c(this.f));
    }
    AppMethodBeat.o(149533);
    return localJSONException;
  }
  
  private static d b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149534);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149534);
      return null;
    }
    d locald = new d();
    locald.a = paramJSONObject.optBoolean("loadSuccess");
    locald.b = paramJSONObject.optLong("loadSuccessTime");
    locald.c = paramJSONObject.optLong("firstLoadTime");
    locald.d = nr.b.a(paramJSONObject.optJSONObject("configUpdate"));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("tileErrors");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      locald.e = new CopyOnWriteArraySet();
      int i = 0;
      while (i < localJSONArray.length())
      {
        nr.g localg = nr.g.a(localJSONArray.optJSONObject(i));
        if (localg != null) {
          locald.e.add(localg);
        }
        i += 1;
      }
    }
    locald.f = nr.a.a(paramJSONObject.optJSONObject("configError"));
    AppMethodBeat.o(149534);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr.d
 * JD-Core Version:    0.7.0.1
 */