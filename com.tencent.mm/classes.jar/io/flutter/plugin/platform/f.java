package io.flutter.plugin.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements e
{
  private final Map<String, d> STi;
  
  f()
  {
    AppMethodBeat.i(9893);
    this.STi = new HashMap();
    AppMethodBeat.o(9893);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(214883);
    if (this.STi.containsKey(paramString))
    {
      AppMethodBeat.o(214883);
      return false;
    }
    this.STi.put(paramString, paramd);
    AppMethodBeat.o(214883);
    return true;
  }
  
  public final d bts(String paramString)
  {
    AppMethodBeat.i(214884);
    paramString = (d)this.STi.get(paramString);
    AppMethodBeat.o(214884);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.f
 * JD-Core Version:    0.7.0.1
 */