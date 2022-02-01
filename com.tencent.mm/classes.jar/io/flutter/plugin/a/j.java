package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class j
{
  public final Object ZZe;
  public final String method;
  
  public j(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.ZZe = paramObject;
  }
  
  public final <T> T bGt(String paramString)
  {
    AppMethodBeat.i(9850);
    if (this.ZZe == null)
    {
      AppMethodBeat.o(9850);
      return null;
    }
    if ((this.ZZe instanceof Map))
    {
      paramString = ((Map)this.ZZe).get(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    if ((this.ZZe instanceof JSONObject))
    {
      paramString = ((JSONObject)this.ZZe).opt(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(9850);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */