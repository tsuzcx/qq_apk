package com.tencent.mm.protocal.c;

public final class ceb
  extends com.tencent.mm.bv.a
{
  public int tAA;
  public int tNg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tNg);
      paramVarArgs.gB(2, this.tAA);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tNg) + 0 + d.a.a.a.gy(2, this.tAA);
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
      ceb localceb = (ceb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localceb.tNg = locala.xpH.oD();
        return 0;
      }
      localceb.tAA = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ceb
 * JD-Core Version:    0.7.0.1
 */