package com.tencent.mm.protocal.c;

public final class yx
  extends com.tencent.mm.bv.a
{
  public int sXA;
  public int sXB;
  public int sXC;
  public int sXD;
  public int sXE;
  public int sXF;
  public int sXr;
  public int sXs;
  public int sXt;
  public int sXu;
  public int sXv;
  public int sXw;
  public int sXx;
  public int sXy;
  public int sXz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sXr);
      paramVarArgs.gB(2, this.sXs);
      paramVarArgs.gB(3, this.sXt);
      paramVarArgs.gB(4, this.sXu);
      paramVarArgs.gB(5, this.sXv);
      paramVarArgs.gB(6, this.sXw);
      paramVarArgs.gB(7, this.sXx);
      paramVarArgs.gB(8, this.sXy);
      paramVarArgs.gB(9, this.sXz);
      paramVarArgs.gB(10, this.sXA);
      paramVarArgs.gB(11, this.sXB);
      paramVarArgs.gB(12, this.sXC);
      paramVarArgs.gB(13, this.sXD);
      paramVarArgs.gB(14, this.sXE);
      paramVarArgs.gB(15, this.sXF);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sXr) + 0 + d.a.a.a.gy(2, this.sXs) + d.a.a.a.gy(3, this.sXt) + d.a.a.a.gy(4, this.sXu) + d.a.a.a.gy(5, this.sXv) + d.a.a.a.gy(6, this.sXw) + d.a.a.a.gy(7, this.sXx) + d.a.a.a.gy(8, this.sXy) + d.a.a.a.gy(9, this.sXz) + d.a.a.a.gy(10, this.sXA) + d.a.a.a.gy(11, this.sXB) + d.a.a.a.gy(12, this.sXC) + d.a.a.a.gy(13, this.sXD) + d.a.a.a.gy(14, this.sXE) + d.a.a.a.gy(15, this.sXF);
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
      yx localyx = (yx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localyx.sXr = locala.xpH.oD();
        return 0;
      case 2: 
        localyx.sXs = locala.xpH.oD();
        return 0;
      case 3: 
        localyx.sXt = locala.xpH.oD();
        return 0;
      case 4: 
        localyx.sXu = locala.xpH.oD();
        return 0;
      case 5: 
        localyx.sXv = locala.xpH.oD();
        return 0;
      case 6: 
        localyx.sXw = locala.xpH.oD();
        return 0;
      case 7: 
        localyx.sXx = locala.xpH.oD();
        return 0;
      case 8: 
        localyx.sXy = locala.xpH.oD();
        return 0;
      case 9: 
        localyx.sXz = locala.xpH.oD();
        return 0;
      case 10: 
        localyx.sXA = locala.xpH.oD();
        return 0;
      case 11: 
        localyx.sXB = locala.xpH.oD();
        return 0;
      case 12: 
        localyx.sXC = locala.xpH.oD();
        return 0;
      case 13: 
        localyx.sXD = locala.xpH.oD();
        return 0;
      case 14: 
        localyx.sXE = locala.xpH.oD();
        return 0;
      }
      localyx.sXF = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yx
 * JD-Core Version:    0.7.0.1
 */