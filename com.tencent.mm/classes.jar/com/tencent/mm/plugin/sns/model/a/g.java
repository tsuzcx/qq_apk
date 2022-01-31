package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.vfs.e;

public final class g
  extends c
{
  public g(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final String aaW(String paramString)
  {
    return paramString;
  }
  
  public final boolean cpR()
  {
    AppMethodBeat.i(36751);
    String str = i.j(this.cIc);
    e.h(this.rjH.getPath(), this.rjH.cpP(), str);
    AppMethodBeat.o(36751);
    return true;
  }
  
  protected final int cpS()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.g
 * JD-Core Version:    0.7.0.1
 */