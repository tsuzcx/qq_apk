package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class JSONMessageCodec
  implements MessageCodec<Object>
{
  public static final JSONMessageCodec INSTANCE;
  
  static
  {
    AppMethodBeat.i(9882);
    INSTANCE = new JSONMessageCodec();
    AppMethodBeat.o(9882);
  }
  
  public final Object decodeMessage(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9881);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(9881);
      return null;
    }
    Object localObject;
    try
    {
      paramByteBuffer = new JSONTokener(StringCodec.INSTANCE.decodeMessage(paramByteBuffer));
      localObject = paramByteBuffer.nextValue();
      if (paramByteBuffer.more())
      {
        paramByteBuffer = new IllegalArgumentException("Invalid JSON");
        AppMethodBeat.o(9881);
        throw paramByteBuffer;
      }
    }
    catch (JSONException paramByteBuffer)
    {
      paramByteBuffer = new IllegalArgumentException("Invalid JSON", paramByteBuffer);
      AppMethodBeat.o(9881);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(9881);
    return localObject;
  }
  
  public final ByteBuffer encodeMessage(Object paramObject)
  {
    AppMethodBeat.i(9880);
    if (paramObject == null)
    {
      AppMethodBeat.o(9880);
      return null;
    }
    paramObject = JSONUtil.wrap(paramObject);
    if ((paramObject instanceof String))
    {
      paramObject = StringCodec.INSTANCE.encodeMessage(JSONObject.quote((String)paramObject));
      AppMethodBeat.o(9880);
      return paramObject;
    }
    paramObject = StringCodec.INSTANCE.encodeMessage(paramObject.toString());
    AppMethodBeat.o(9880);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.plugin.common.JSONMessageCodec
 * JD-Core Version:    0.7.0.1
 */