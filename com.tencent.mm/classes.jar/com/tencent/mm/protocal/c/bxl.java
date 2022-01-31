package com.tencent.mm.protocal.c;

public final class bxl
  extends com.tencent.mm.bv.a
{
  public long tNA;
  public int tNB;
  public long tNz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.tNz);
      paramVarArgs.Y(2, this.tNA);
      paramVarArgs.gB(3, this.tNB);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.tNz) + 0 + d.a.a.a.X(2, this.tNA) + d.a.a.a.gy(3, this.tNB);
    }
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
      bxl localbxl = (bxl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbxl.tNz = locala.xpH.oE();
        return 0;
      case 2: 
        localbxl.tNA = locala.xpH.oE();
        return 0;
      }
      localbxl.tNB = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxl
 * JD-Core Version:    0.7.0.1
 */