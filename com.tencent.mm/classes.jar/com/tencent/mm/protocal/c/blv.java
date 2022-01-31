package com.tencent.mm.protocal.c;

public final class blv
  extends com.tencent.mm.bv.a
{
  public int rWB;
  public int tAu;
  public int tFp;
  public int tFr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tAu);
      paramVarArgs.gB(2, this.tFr);
      paramVarArgs.gB(3, this.tFp);
      paramVarArgs.gB(4, this.rWB);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tAu) + 0 + d.a.a.a.gy(2, this.tFr) + d.a.a.a.gy(3, this.tFp) + d.a.a.a.gy(4, this.rWB);
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
      blv localblv = (blv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localblv.tAu = locala.xpH.oD();
        return 0;
      case 2: 
        localblv.tFr = locala.xpH.oD();
        return 0;
      case 3: 
        localblv.tFp = locala.xpH.oD();
        return 0;
      }
      localblv.rWB = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blv
 * JD-Core Version:    0.7.0.1
 */