package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cv;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import java.util.Map;

public final class c
  implements d
{
  public final void a(b paramb)
  {
    AppMethodBeat.i(80538);
    a.dhl().vuV = paramb;
    AppMethodBeat.o(80538);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(80537);
    a.dhl().vuU.put(paramString, paramb);
    AppMethodBeat.o(80537);
  }
  
  public final cv ajt(String paramString)
  {
    AppMethodBeat.i(80539);
    paramString = a.dhl().ajs(paramString);
    AppMethodBeat.o(80539);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c
 * JD-Core Version:    0.7.0.1
 */