package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;

public final class s$a
  extends l
{
  private s.b DJi;
  private s.c DJj;
  private boolean vou;
  
  public s$a(boolean paramBoolean)
  {
    AppMethodBeat.i(149118);
    this.vou = true;
    this.vou = paramBoolean;
    this.DJi = new s.b(this.vou);
    this.DJj = new s.c();
    AppMethodBeat.o(149118);
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(149119);
    if (this.vou)
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
    if (this.vou) {
      return 3789;
    }
    return 3644;
  }
  
  public final String getUri()
  {
    if (this.vou) {
      return "/cgi-bin/micromsg-bin/fpinitnl";
    }
    return "/cgi-bin/micromsg-bin/fpinit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.s.a
 * JD-Core Version:    0.7.0.1
 */