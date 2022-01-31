package com.tencent.mm.protocal.c;

public final class cfl
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public int tUC;
  public int tUD;
  public int tUE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hQR);
      paramVarArgs.gB(2, this.tUC);
      paramVarArgs.gB(3, this.tUD);
      paramVarArgs.gB(4, this.tUE);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.hQR) + 0 + d.a.a.a.gy(2, this.tUC) + d.a.a.a.gy(3, this.tUD) + d.a.a.a.gy(4, this.tUE);
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
      cfl localcfl = (cfl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcfl.hQR = locala.xpH.oD();
        return 0;
      case 2: 
        localcfl.tUC = locala.xpH.oD();
        return 0;
      case 3: 
        localcfl.tUD = locala.xpH.oD();
        return 0;
      }
      localcfl.tUE = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfl
 * JD-Core Version:    0.7.0.1
 */