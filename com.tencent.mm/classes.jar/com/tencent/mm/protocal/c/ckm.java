package com.tencent.mm.protocal.c;

public final class ckm
  extends com.tencent.mm.bv.a
{
  public int tXP;
  public long tXQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tXP);
      paramVarArgs.Y(2, this.tXQ);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tXP) + 0 + d.a.a.a.X(2, this.tXQ);
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
      ckm localckm = (ckm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localckm.tXP = locala.xpH.oD();
        return 0;
      }
      localckm.tXQ = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckm
 * JD-Core Version:    0.7.0.1
 */