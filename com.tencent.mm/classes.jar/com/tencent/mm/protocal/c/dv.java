package com.tencent.mm.protocal.c;

public final class dv
  extends com.tencent.mm.bv.a
{
  public long sxr;
  public int sxs;
  public int sxt;
  public int sxu;
  public int sxv;
  public int sxw;
  public int sxx;
  public String sxy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.sxr);
      paramVarArgs.gB(2, this.sxs);
      paramVarArgs.gB(3, this.sxt);
      paramVarArgs.gB(4, this.sxu);
      paramVarArgs.gB(5, this.sxv);
      paramVarArgs.gB(6, this.sxw);
      paramVarArgs.gB(7, this.sxx);
      if (this.sxy != null) {
        paramVarArgs.d(8, this.sxy);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.X(1, this.sxr) + 0 + d.a.a.a.gy(2, this.sxs) + d.a.a.a.gy(3, this.sxt) + d.a.a.a.gy(4, this.sxu) + d.a.a.a.gy(5, this.sxv) + d.a.a.a.gy(6, this.sxw) + d.a.a.a.gy(7, this.sxx);
      paramInt = i;
    } while (this.sxy == null);
    return i + d.a.a.b.b.a.e(8, this.sxy);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      dv localdv = (dv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localdv.sxr = locala.xpH.oE();
        return 0;
      case 2: 
        localdv.sxs = locala.xpH.oD();
        return 0;
      case 3: 
        localdv.sxt = locala.xpH.oD();
        return 0;
      case 4: 
        localdv.sxu = locala.xpH.oD();
        return 0;
      case 5: 
        localdv.sxv = locala.xpH.oD();
        return 0;
      case 6: 
        localdv.sxw = locala.xpH.oD();
        return 0;
      case 7: 
        localdv.sxx = locala.xpH.oD();
        return 0;
      }
      localdv.sxy = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dv
 * JD-Core Version:    0.7.0.1
 */