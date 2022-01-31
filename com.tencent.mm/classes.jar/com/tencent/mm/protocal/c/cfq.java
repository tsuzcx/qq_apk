package com.tencent.mm.protocal.c;

public final class cfq
  extends com.tencent.mm.bv.a
{
  public int tUT;
  public int tUU;
  public int tUV;
  public int tUW;
  public int tUX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tUT);
      paramVarArgs.gB(2, this.tUU);
      paramVarArgs.gB(3, this.tUV);
      paramVarArgs.gB(4, this.tUW);
      paramVarArgs.gB(5, this.tUX);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tUT) + 0 + d.a.a.a.gy(2, this.tUU) + d.a.a.a.gy(3, this.tUV) + d.a.a.a.gy(4, this.tUW) + d.a.a.a.gy(5, this.tUX);
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
      cfq localcfq = (cfq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcfq.tUT = locala.xpH.oD();
        return 0;
      case 2: 
        localcfq.tUU = locala.xpH.oD();
        return 0;
      case 3: 
        localcfq.tUV = locala.xpH.oD();
        return 0;
      case 4: 
        localcfq.tUW = locala.xpH.oD();
        return 0;
      }
      localcfq.tUX = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfq
 * JD-Core Version:    0.7.0.1
 */