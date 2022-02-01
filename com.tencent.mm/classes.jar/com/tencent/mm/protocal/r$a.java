package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.o;

public final class r$a
  extends o
{
  private boolean GxN;
  private r.b RBK;
  private r.c RBL;
  
  public r$a(boolean paramBoolean)
  {
    AppMethodBeat.i(149112);
    this.GxN = true;
    this.GxN = paramBoolean;
    this.RBK = new r.b(this.GxN);
    this.RBL = new r.c();
    AppMethodBeat.o(149112);
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(149113);
    if (this.GxN)
    {
      AppMethodBeat.o(149113);
      return 1;
    }
    int i = super.getOptions();
    AppMethodBeat.o(149113);
    return i;
  }
  
  public final int getType()
  {
    if (this.GxN) {
      return 3944;
    }
    return 836;
  }
  
  public final String getUri()
  {
    if (this.GxN) {
      return "/cgi-bin/micromsg-bin/fpfreshnl";
    }
    return "/cgi-bin/micromsg-bin/fpfresh";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.a
 * JD-Core Version:    0.7.0.1
 */