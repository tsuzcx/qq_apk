package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;

public final class s$a
  extends n
{
  private boolean MtT;
  private s.b Yyr;
  private s.c Yys;
  
  public s$a(boolean paramBoolean)
  {
    AppMethodBeat.i(149118);
    this.MtT = true;
    this.MtT = paramBoolean;
    this.Yyr = new s.b(this.MtT);
    this.Yys = new s.c();
    AppMethodBeat.o(149118);
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(149119);
    if (this.MtT)
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
    if (this.MtT) {
      return 3789;
    }
    return 3644;
  }
  
  public final String getUri()
  {
    if (this.MtT) {
      return "/cgi-bin/micromsg-bin/fpinitnl";
    }
    return "/cgi-bin/micromsg-bin/fpinit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.s.a
 * JD-Core Version:    0.7.0.1
 */