package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import java.util.Map;

public final class c
  implements d
{
  public final void a(b paramb)
  {
    AppMethodBeat.i(146211);
    a.gjg().JFT = paramb;
    AppMethodBeat.o(146211);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(146210);
    a.gjg().JFS.put(paramString, paramb);
    AppMethodBeat.o(146210);
  }
  
  public final ec bbA(String paramString)
  {
    AppMethodBeat.i(146212);
    paramString = a.gjg().bbz(paramString);
    AppMethodBeat.o(146212);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c
 * JD-Core Version:    0.7.0.1
 */