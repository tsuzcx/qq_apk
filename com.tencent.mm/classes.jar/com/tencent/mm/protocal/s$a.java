package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;

public final class s$a
  extends l
{
  private s.b Fop;
  private s.c Foq;
  private boolean wtN;
  
  public s$a(boolean paramBoolean)
  {
    AppMethodBeat.i(149118);
    this.wtN = true;
    this.wtN = paramBoolean;
    this.Fop = new s.b(this.wtN);
    this.Foq = new s.c();
    AppMethodBeat.o(149118);
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(149119);
    if (this.wtN)
    {
      AppMethodBeat.o(149119);
      return 1;
    }
    int i = super.getOptions();
    AppMethodBeat.o(149119);
    return i;
  }
  
  public final int getType()
  {
    if (this.wtN) {
      return 3789;
    }
    return 3644;
  }
  
  public final String getUri()
  {
    if (this.wtN) {
      return "/cgi-bin/micromsg-bin/fpinitnl";
    }
    return "/cgi-bin/micromsg-bin/fpinit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.a
 * JD-Core Version:    0.7.0.1
 */