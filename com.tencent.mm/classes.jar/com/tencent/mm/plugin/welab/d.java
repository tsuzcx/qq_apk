package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.eg;
import java.util.Map;

public final class d
  implements com.tencent.mm.plugin.welab.a.a.d
{
  public final void a(com.tencent.mm.plugin.welab.a.a.b paramb)
  {
    AppMethodBeat.i(146211);
    b.hcS().QFf = paramb;
    AppMethodBeat.o(146211);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.welab.a.a.b paramb)
  {
    AppMethodBeat.i(146210);
    b.hcS().QFe.put(paramString, paramb);
    AppMethodBeat.o(146210);
  }
  
  public final eg bnA(String paramString)
  {
    AppMethodBeat.i(146212);
    paramString = b.hcS().bnz(paramString);
    AppMethodBeat.o(146212);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d
 * JD-Core Version:    0.7.0.1
 */