package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class j
{
  public final Object fXJ;
  public final String method;
  
  public j(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.fXJ = paramObject;
  }
  
  public final <T> T tn(String paramString)
  {
    AppMethodBeat.i(9850);
    if (this.fXJ == null)
    {
      AppMethodBeat.o(9850);
      return null;
    }
    if ((this.fXJ instanceof Map))
    {
      paramString = ((Map)this.fXJ).get(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    if ((this.fXJ instanceof JSONObject))
    {
      paramString = ((JSONObject)this.fXJ).opt(paramString);
      AppMethodBeat.o(9850);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(9850);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */