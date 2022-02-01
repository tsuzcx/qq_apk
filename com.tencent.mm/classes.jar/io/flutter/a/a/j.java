package io.flutter.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class j
{
  public final Object fTP;
  public final String method;
  
  public j(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.fTP = paramObject;
  }
  
  public final <T> T qa(String paramString)
  {
    AppMethodBeat.i(9850);
    if (this.fTP == null)
    {
      AppMethodBeat.o(9850);
      return null;
    }
    if ((this.fTP instanceof Map))
    {
      paramString = ((Map)this.fTP).get(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    if ((this.fTP instanceof JSONObject))
    {
      paramString = ((JSONObject)this.fTP).opt(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(9850);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.a.j
 * JD-Core Version:    0.7.0.1
 */