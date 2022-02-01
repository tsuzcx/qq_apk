package io.flutter.plugin.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class f
  implements e
{
  private final Map<String, d> aavV;
  
  f()
  {
    AppMethodBeat.i(9893);
    this.aavV = new HashMap();
    AppMethodBeat.o(9893);
  }
  
  final d bGv(String paramString)
  {
    AppMethodBeat.i(254895);
    paramString = (d)this.aavV.get(paramString);
    AppMethodBeat.o(254895);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.platform.f
 * JD-Core Version:    0.7.0.1
 */