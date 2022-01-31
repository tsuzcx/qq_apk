package com.tencent.mm.protocal.c;

public final class are
  extends com.tencent.mm.bv.a
{
  public int sZE;
  public int tmO;
  public int tmP;
  public int tmQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sZE);
      paramVarArgs.gB(2, this.tmO);
      paramVarArgs.gB(3, this.tmP);
      paramVarArgs.gB(4, this.tmQ);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sZE) + 0 + d.a.a.a.gy(2, this.tmO) + d.a.a.a.gy(3, this.tmP) + d.a.a.a.gy(4, this.tmQ);
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
      are localare = (are)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localare.sZE = locala.xpH.oD();
        return 0;
      case 2: 
        localare.tmO = locala.xpH.oD();
        return 0;
      case 3: 
        localare.tmP = locala.xpH.oD();
        return 0;
      }
      localare.tmQ = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.are
 * JD-Core Version:    0.7.0.1
 */