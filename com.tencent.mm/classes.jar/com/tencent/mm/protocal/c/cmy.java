package com.tencent.mm.protocal.c;

public final class cmy
  extends com.tencent.mm.bv.a
{
  public int tZD;
  public int tZE;
  public int tZF;
  public int tZG;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tZD);
      paramVarArgs.gB(2, this.tZE);
      paramVarArgs.gB(3, this.tZF);
      paramVarArgs.gB(4, this.tZG);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tZD) + 0 + d.a.a.a.gy(2, this.tZE) + d.a.a.a.gy(3, this.tZF) + d.a.a.a.gy(4, this.tZG);
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
      cmy localcmy = (cmy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcmy.tZD = locala.xpH.oD();
        return 0;
      case 2: 
        localcmy.tZE = locala.xpH.oD();
        return 0;
      case 3: 
        localcmy.tZF = locala.xpH.oD();
        return 0;
      }
      localcmy.tZG = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmy
 * JD-Core Version:    0.7.0.1
 */