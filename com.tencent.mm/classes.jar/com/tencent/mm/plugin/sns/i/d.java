package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public final class d
{
  private static d roH = null;
  private c<sa> dZC;
  public HashMap<Integer, String> roI;
  
  private d()
  {
    AppMethodBeat.i(36876);
    this.roI = null;
    this.dZC = new d.1(this);
    this.roI = new HashMap();
    a.ymk.b(this.dZC);
    AppMethodBeat.o(36876);
  }
  
  public static d cqe()
  {
    AppMethodBeat.i(36877);
    if (roH == null) {
      roH = new d();
    }
    d locald = roH;
    AppMethodBeat.o(36877);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.d
 * JD-Core Version:    0.7.0.1
 */