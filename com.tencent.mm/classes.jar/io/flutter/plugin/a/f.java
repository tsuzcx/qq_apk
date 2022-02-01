package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class f
  implements i<Object>
{
  public static final f MFT;
  
  static
  {
    AppMethodBeat.i(9882);
    MFT = new f();
    AppMethodBeat.o(9882);
  }
  
  public final Object J(ByteBuffer paramByteBuffer)
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
      localObject = p.MGc;
      paramByteBuffer = new JSONTokener(p.P(paramByteBuffer));
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
  
  public final ByteBuffer eG(Object paramObject)
  {
    AppMethodBeat.i(9880);
    if (paramObject == null)
    {
      AppMethodBeat.o(9880);
      return null;
    }
    paramObject = h.wrap(paramObject);
    if ((paramObject instanceof String))
    {
      localp = p.MGc;
      paramObject = p.bbY(JSONObject.quote((String)paramObject));
      AppMethodBeat.o(9880);
      return paramObject;
    }
    p localp = p.MGc;
    paramObject = p.bbY(paramObject.toString());
    AppMethodBeat.o(9880);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.a.f
 * JD-Core Version:    0.7.0.1
 */