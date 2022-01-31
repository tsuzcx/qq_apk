package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nr$a
{
  private Set<nr.c> a;
  private Set<nr.e> b;
  
  private JSONObject a()
  {
    AppMethodBeat.i(149519);
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    Iterator localIterator;
    JSONObject localJSONObject2;
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      localJSONArray = new JSONArray();
      localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localJSONObject2 = nr.c.a((nr.c)localIterator.next());
        if (localJSONObject2 != null) {
          localJSONArray.put(localJSONObject2);
        }
      }
      if (localJSONArray.length() <= 0) {}
    }
    try
    {
      localJSONObject1.put("faileUpdates", localJSONArray);
      label103:
      if ((this.b != null) && (this.b.size() > 0))
      {
        localJSONArray = new JSONArray();
        localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          localJSONObject2 = nr.e.a((nr.e)localIterator.next());
          if (localJSONObject2 != null) {
            localJSONArray.put(localJSONObject2);
          }
        }
        if (localJSONArray.length() <= 0) {}
      }
      try
      {
        localJSONObject1.put("missFiles", localJSONArray);
        label193:
        AppMethodBeat.o(149519);
        return localJSONObject1;
      }
      catch (JSONException localJSONException1)
      {
        break label193;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label103;
    }
  }
  
  private static a b(JSONObject paramJSONObject)
  {
    int j = 0;
    AppMethodBeat.i(149520);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149520);
      return null;
    }
    a locala = new a();
    Object localObject = paramJSONObject.optJSONArray("faileUpdates");
    int i;
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      locala.a = new CopyOnWriteArraySet();
      i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        nr.c localc = nr.c.a(((JSONArray)localObject).optJSONObject(i));
        if (localc != null) {
          locala.a.add(localc);
        }
        i += 1;
      }
    }
    paramJSONObject = paramJSONObject.optJSONArray("missFiles");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      locala.b = new CopyOnWriteArraySet();
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject = nr.e.a(paramJSONObject.optJSONObject(i));
        if (localObject != null) {
          locala.b.add(localObject);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(149520);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr.a
 * JD-Core Version:    0.7.0.1
 */