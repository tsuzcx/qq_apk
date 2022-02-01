package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class j
{
  public final Object grf;
  public final String method;
  
  public j(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.grf = paramObject;
  }
  
  public final <T> T wd(String paramString)
  {
    AppMethodBeat.i(9850);
    if (this.grf == null)
    {
      AppMethodBeat.o(9850);
      return null;
    }
    if ((this.grf instanceof Map))
    {
      paramString = ((Map)this.grf).get(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    if ((this.grf instanceof JSONObject))
    {
      paramString = ((JSONObject)this.grf).opt(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(9850);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */