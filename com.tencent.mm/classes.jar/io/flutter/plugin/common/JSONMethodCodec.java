package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONMethodCodec
  implements MethodCodec
{
  public static final JSONMethodCodec INSTANCE;
  
  static
  {
    AppMethodBeat.i(9879);
    INSTANCE = new JSONMethodCodec();
    AppMethodBeat.o(9879);
  }
  
  public final Object decodeEnvelope(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9878);
    try
    {
      paramByteBuffer = JSONMessageCodec.INSTANCE.decodeMessage(paramByteBuffer);
      if ((paramByteBuffer instanceof JSONArray))
      {
        Object localObject3 = (JSONArray)paramByteBuffer;
        if (((JSONArray)localObject3).length() == 1)
        {
          paramByteBuffer = unwrapNull(((JSONArray)localObject3).opt(0));
          AppMethodBeat.o(9878);
          return paramByteBuffer;
        }
        if (((JSONArray)localObject3).length() == 3)
        {
          Object localObject1 = ((JSONArray)localObject3).get(0);
          Object localObject2 = unwrapNull(((JSONArray)localObject3).opt(1));
          localObject3 = unwrapNull(((JSONArray)localObject3).opt(2));
          if (((localObject1 instanceof String)) && ((localObject2 == null) || ((localObject2 instanceof String))))
          {
            paramByteBuffer = new FlutterException((String)localObject1, (String)localObject2, localObject3);
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
  
  public final MethodCall decodeMethodCall(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9875);
    try
    {
      paramByteBuffer = JSONMessageCodec.INSTANCE.decodeMessage(paramByteBuffer);
      if ((paramByteBuffer instanceof JSONObject))
      {
        Object localObject2 = (JSONObject)paramByteBuffer;
        Object localObject1 = ((JSONObject)localObject2).get("method");
        localObject2 = unwrapNull(((JSONObject)localObject2).opt("args"));
        if ((localObject1 instanceof String))
        {
          paramByteBuffer = new MethodCall((String)localObject1, localObject2);
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
  
  public final ByteBuffer encodeErrorEnvelope(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(9877);
    paramString1 = JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(paramString1).put(JSONUtil.wrap(paramString2)).put(JSONUtil.wrap(paramObject)));
    AppMethodBeat.o(9877);
    return paramString1;
  }
  
  public final ByteBuffer encodeErrorEnvelopeWithStacktrace(String paramString1, String paramString2, Object paramObject, String paramString3)
  {
    AppMethodBeat.i(189851);
    paramString1 = JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(paramString1).put(JSONUtil.wrap(paramString2)).put(JSONUtil.wrap(paramObject)).put(JSONUtil.wrap(paramString3)));
    AppMethodBeat.o(189851);
    return paramString1;
  }
  
  public final ByteBuffer encodeMethodCall(MethodCall paramMethodCall)
  {
    AppMethodBeat.i(9874);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("method", paramMethodCall.method);
      localJSONObject.put("args", JSONUtil.wrap(paramMethodCall.arguments));
      paramMethodCall = JSONMessageCodec.INSTANCE.encodeMessage(localJSONObject);
      AppMethodBeat.o(9874);
      return paramMethodCall;
    }
    catch (JSONException paramMethodCall)
    {
      paramMethodCall = new IllegalArgumentException("Invalid JSON", paramMethodCall);
      AppMethodBeat.o(9874);
      throw paramMethodCall;
    }
  }
  
  public final ByteBuffer encodeSuccessEnvelope(Object paramObject)
  {
    AppMethodBeat.i(9876);
    paramObject = JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(JSONUtil.wrap(paramObject)));
    AppMethodBeat.o(9876);
    return paramObject;
  }
  
  final Object unwrapNull(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == JSONObject.NULL) {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.plugin.common.JSONMethodCodec
 * JD-Core Version:    0.7.0.1
 */