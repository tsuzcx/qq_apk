package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtil
{
  public static Object unwrap(Object paramObject)
  {
    AppMethodBeat.i(189829);
    if ((JSONObject.NULL.equals(paramObject)) || (paramObject == null))
    {
      AppMethodBeat.o(189829);
      return null;
    }
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Character)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Short)) || ((paramObject instanceof String)))
    {
      AppMethodBeat.o(189829);
      return paramObject;
    }
    Object localObject;
    try
    {
      if ((paramObject instanceof JSONArray))
      {
        localObject = new ArrayList();
        paramObject = (JSONArray)paramObject;
        int i = 0;
        while (i < paramObject.length())
        {
          ((List)localObject).add(unwrap(paramObject.get(i)));
          i += 1;
        }
        AppMethodBeat.o(189829);
        return localObject;
      }
      if ((paramObject instanceof JSONObject))
      {
        localObject = new HashMap();
        paramObject = (JSONObject)paramObject;
        Iterator localIterator = paramObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((Map)localObject).put(str, unwrap(paramObject.get(str)));
        }
      }
      AppMethodBeat.o(189829);
    }
    catch (Exception paramObject)
    {
      AppMethodBeat.o(189829);
      return null;
    }
    return localObject;
  }
  
  public static Object wrap(Object paramObject)
  {
    AppMethodBeat.i(9836);
    if (paramObject == null)
    {
      paramObject = JSONObject.NULL;
      AppMethodBeat.o(9836);
      return paramObject;
    }
    if (((paramObject instanceof JSONArray)) || ((paramObject instanceof JSONObject)))
    {
      AppMethodBeat.o(9836);
      return paramObject;
    }
    if (paramObject.equals(JSONObject.NULL))
    {
      AppMethodBeat.o(9836);
      return paramObject;
    }
    label130:
    do
    {
      Object localObject;
      try
      {
        if (!(paramObject instanceof Collection)) {
          break label130;
        }
        localObject = new JSONArray();
        paramObject = ((Collection)paramObject).iterator();
        while (paramObject.hasNext()) {
          ((JSONArray)localObject).put(wrap(paramObject.next()));
        }
        AppMethodBeat.o(9836);
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(9836);
        return null;
      }
      return localObject;
      if (paramObject.getClass().isArray())
      {
        localObject = new JSONArray();
        int j = Array.getLength(paramObject);
        int i = 0;
        while (i < j)
        {
          ((JSONArray)localObject).put(wrap(Array.get(paramObject, i)));
          i += 1;
        }
        AppMethodBeat.o(9836);
        return localObject;
      }
      if ((paramObject instanceof Map))
      {
        localObject = new JSONObject();
        paramObject = ((Map)paramObject).entrySet().iterator();
        while (paramObject.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramObject.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), wrap(localEntry.getValue()));
        }
        AppMethodBeat.o(9836);
        return localObject;
      }
      if (((paramObject instanceof Boolean)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Character)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Short)) || ((paramObject instanceof String)))
      {
        AppMethodBeat.o(9836);
        return paramObject;
      }
    } while (!paramObject.getClass().getPackage().getName().startsWith("java."));
    paramObject = paramObject.toString();
    AppMethodBeat.o(9836);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.JSONUtil
 * JD-Core Version:    0.7.0.1
 */