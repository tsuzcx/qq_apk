package com.tencent.mm.protocal.c;

public final class cds
  extends com.tencent.mm.bv.a
{
  public int sxP;
  public int sxQ;
  public int sxR;
  public int sxS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sxP);
      paramVarArgs.gB(2, this.sxQ);
      paramVarArgs.gB(3, this.sxR);
      paramVarArgs.gB(4, this.sxS);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sxP) + 0 + d.a.a.a.gy(2, this.sxQ) + d.a.a.a.gy(3, this.sxR) + d.a.a.a.gy(4, this.sxS);
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
      cds localcds = (cds)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcds.sxP = locala.xpH.oD();
        return 0;
      case 2: 
        localcds.sxQ = locala.xpH.oD();
        return 0;
      case 3: 
        localcds.sxR = locala.xpH.oD();
        return 0;
      }
      localcds.sxS = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cds
 * JD-Core Version:    0.7.0.1
 */