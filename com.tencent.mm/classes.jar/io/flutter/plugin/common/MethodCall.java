package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class MethodCall
{
  public final Object arguments;
  public final String method;
  
  public MethodCall(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.arguments = paramObject;
  }
  
  public final <T> T argument(String paramString)
  {
    AppMethodBeat.i(9850);
    if (this.arguments == null)
    {
      AppMethodBeat.o(9850);
      return null;
    }
    if ((this.arguments instanceof Map))
    {
      paramString = ((Map)this.arguments).get(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    if ((this.arguments instanceof JSONObject))
    {
      paramString = ((JSONObject)this.arguments).opt(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(9850);
    throw paramString;
  }
  
  public final <T> T arguments()
  {
    return this.arguments;
  }
  
  public final boolean hasArgument(String paramString)
  {
    AppMethodBeat.i(189793);
    if (this.arguments == null)
    {
      AppMethodBeat.o(189793);
      return false;
    }
    boolean bool;
    if ((this.arguments instanceof Map))
    {
      bool = ((Map)this.arguments).containsKey(paramString);
      AppMethodBeat.o(189793);
      return bool;
    }
    if ((this.arguments instanceof JSONObject))
    {
      bool = ((JSONObject)this.arguments).has(paramString);
      AppMethodBeat.o(189793);
      return bool;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(189793);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.common.MethodCall
 * JD-Core Version:    0.7.0.1
 */