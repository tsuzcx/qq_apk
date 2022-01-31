package com.tencent.mm.protocal.c;

public final class atd
  extends com.tencent.mm.bv.a
{
  public int sYX;
  public int toJ;
  public String toK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.toJ);
      if (this.toK != null) {
        paramVarArgs.d(2, this.toK);
      }
      paramVarArgs.gB(3, this.sYX);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.toJ) + 0;
      paramInt = i;
      if (this.toK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.toK);
      }
      return paramInt + d.a.a.a.gy(3, this.sYX);
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
      atd localatd = (atd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localatd.toJ = locala.xpH.oD();
        return 0;
      case 2: 
        localatd.toK = locala.xpH.readString();
        return 0;
      }
      localatd.sYX = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atd
 * JD-Core Version:    0.7.0.1
 */