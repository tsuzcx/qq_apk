package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  implements l
{
  public static final g SSl;
  
  static
  {
    AppMethodBeat.i(9879);
    SSl = new g();
    AppMethodBeat.o(9879);
  }
  
  private static Object aF(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == JSONObject.NULL) {
      localObject = null;
    }
    return localObject;
  }
  
  public final j K(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9875);
    try
    {
      paramByteBuffer = f.SSk.J(paramByteBuffer);
      if ((paramByteBuffer instanceof JSONObject))
      {
        Object localObject2 = (JSONObject)paramByteBuffer;
        Object localObject1 = ((JSONObject)localObject2).get("method");
        localObject2 = aF(((JSONObject)localObject2).opt("args"));
        if ((localObject1 instanceof String))
        {
          paramByteBuffer = new j((String)localObject1, localObject2);
          AppMethodBeat.o(9875);
          return paramByteBuffer;
        }
      }
      paramByteBuffer = new IllegalArgumentException("Invalid method call: ".concat(String.valueOf(paramByteBuffer)));
      AppMethodBeat.o(9875);
      throw paramByteBuffer;
    }
    catch (JSONException paramByteBuffer)
    {
      paramByteBuffer = new IllegalArgumentException("Invalid JSON", paramByteBuffer);
      AppMethodBeat.o(9875);
      throw paramByteBuffer;
    }
  }
  
  public final Object L(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9878);
    try
    {
      paramByteBuffer = f.SSk.J(paramByteBuffer);
      if ((paramByteBuffer instanceof JSONArray))
      {
        Object localObject3 = (JSONArray)paramByteBuffer;
        if (((JSONArray)localObject3).length() == 1)
        {
          paramByteBuffer = aF(((JSONArray)localObject3).opt(0));
          AppMethodBeat.o(9878);
          return paramByteBuffer;
        }
        if (((JSONArray)localObject3).length() == 3)
        {
          Object localObject1 = ((JSONArray)localObject3).get(0);
          Object localObject2 = aF(((JSONArray)localObject3).opt(1));
          localObject3 = aF(((JSONArray)localObject3).opt(2));
          if (((localObject1 instanceof String)) && ((localObject2 == null) || ((localObject2 instanceof String))))
          {
            paramByteBuffer = new e((String)localObject1, (String)localObject2, localObject3);
            AppMethodBeat.o(9878);
            throw paramByteBuffer;
          }
        }
      }
    }
    catch (JSONException paramByteBuffer)
    {
      paramByteBuffer = new IllegalArgumentException("Invalid JSON", paramByteBuffer);
      AppMethodBeat.o(9878);
      throw paramByteBuffer;
    }
    paramByteBuffer = new IllegalArgumentException("Invalid envelope: ".concat(String.valueOf(paramByteBuffer)));
    AppMethodBeat.o(9878);
    throw paramByteBuffer;
  }
  
  public final ByteBuffer b(j paramj)
  {
    AppMethodBeat.i(9874);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("method", paramj.method);
      localJSONObject.put("args", h.wrap(paramj.SxX));
      paramj = f.SSk.eP(localJSONObject);
      AppMethodBeat.o(9874);
      return paramj;
    }
    catch (JSONException paramj)
    {
      paramj = new IllegalArgumentException("Invalid JSON", paramj);
      AppMethodBeat.o(9874);
      throw paramj;
    }
  }
  
  public final ByteBuffer eQ(Object paramObject)
  {
    AppMethodBeat.i(9876);
    paramObject = f.SSk.eP(new JSONArray().put(h.wrap(paramObject)));
    AppMethodBeat.o(9876);
    return paramObject;
  }
  
  public final ByteBuffer h(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(9877);
    paramString1 = f.SSk.eP(new JSONArray().put(paramString1).put(h.wrap(paramString2)).put(h.wrap(paramObject)));
    AppMethodBeat.o(9877);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.plugin.a.g
 * JD-Core Version:    0.7.0.1
 */