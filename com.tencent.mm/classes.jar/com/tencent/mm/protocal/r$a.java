package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;

public final class r$a
  extends o
{
  private boolean AEJ;
  private r.b KzU;
  private r.c KzV;
  
  public r$a(boolean paramBoolean)
  {
    AppMethodBeat.i(149112);
    this.AEJ = true;
    this.AEJ = paramBoolean;
    this.KzU = new r.b(this.AEJ);
    this.KzV = new r.c();
    AppMethodBeat.o(149112);
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(149113);
    if (this.AEJ)
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
    if (this.AEJ) {
      return 3944;
    }
    return 836;
  }
  
  public final String getUri()
  {
    if (this.AEJ) {
      return "/cgi-bin/micromsg-bin/fpfreshnl";
    }
    return "/cgi-bin/micromsg-bin/fpfresh";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.r.a
 * JD-Core Version:    0.7.0.1
 */