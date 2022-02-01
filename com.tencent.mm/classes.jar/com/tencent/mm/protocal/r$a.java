package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;

public final class r$a
  extends n
{
  private boolean MtT;
  private r.b Yyn;
  private r.c Yyo;
  
  public r$a(boolean paramBoolean)
  {
    AppMethodBeat.i(149112);
    this.MtT = true;
    this.MtT = paramBoolean;
    this.Yyn = new r.b(this.MtT);
    this.Yyo = new r.c();
    AppMethodBeat.o(149112);
  }
  
  public final int getOptions()
  {
    AppMethodBeat.i(149113);
    if (this.MtT)
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
    if (this.MtT) {
      return 3944;
    }
    return 836;
  }
  
  public final String getUri()
  {
    if (this.MtT) {
      return "/cgi-bin/micromsg-bin/fpfreshnl";
    }
    return "/cgi-bin/micromsg-bin/fpfresh";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.r.a
 * JD-Core Version:    0.7.0.1
 */