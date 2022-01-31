package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class ak
{
  private String a;
  private Map<String, al> b;
  
  public ak(String paramString)
  {
    AppMethodBeat.i(147220);
    this.a = paramString;
    this.b = new HashMap();
    AppMethodBeat.o(147220);
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(al paramal)
  {
    AppMethodBeat.i(147221);
    this.b.put(paramal.a, paramal);
    AppMethodBeat.o(147221);
  }
  
  public final Map<String, al> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ak
 * JD-Core Version:    0.7.0.1
 */