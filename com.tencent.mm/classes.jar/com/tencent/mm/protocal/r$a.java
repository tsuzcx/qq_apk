package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;

public final class r$a
  extends l
{
  private r.b Fol;
  private r.c Fom;
  private boolean wtN;
  
  public r$a(boolean paramBoolean)
  {
    AppMethodBeat.i(149112);
    this.wtN = true;
    this.wtN = paramBoolean;
    this.Fol = new r.b(this.wtN);
    this.Fom = new r.c();
    AppMethodBeat.o(149112);
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(149113);
    if (this.wtN)
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
    if (this.wtN) {
      return 3944;
    }
    return 836;
  }
  
  public final String getUri()
  {
    if (this.wtN) {
      return "/cgi-bin/micromsg-bin/fpfreshnl";
    }
    return "/cgi-bin/micromsg-bin/fpfresh";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.a
 * JD-Core Version:    0.7.0.1
 */