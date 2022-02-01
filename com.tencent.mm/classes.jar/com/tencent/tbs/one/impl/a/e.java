package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static JSONObject a(Map paramMap)
  {
    AppMethodBeat.i(173893);
    JSONObject localJSONObject = new JSONObject();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        a(localJSONObject, localObject.toString(), paramMap.get(localObject));
      }
    }
    AppMethodBeat.o(173893);
    return localJSONObject;
  }
  
  public static <T> void a(JSONObject paramJSONObject, String paramString, T paramT)
  {
    AppMethodBeat.i(173892);
    try
    {
      paramJSONObject.put(paramString, paramT);
      AppMethodBeat.o(173892);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      AppMethodBeat.o(173892);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.e
 * JD-Core Version:    0.7.0.1
 */