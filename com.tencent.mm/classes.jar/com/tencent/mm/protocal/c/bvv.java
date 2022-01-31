package com.tencent.mm.protocal.c;

public final class bvv
  extends com.tencent.mm.bv.a
{
  public int hQP;
  public int sSK;
  public int tMC;
  public int tMD;
  public int tME;
  public int tMF;
  public int tMG;
  public int tMH;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hQP);
      paramVarArgs.gB(2, this.sSK);
      paramVarArgs.gB(3, this.tMC);
      paramVarArgs.gB(4, this.tMD);
      paramVarArgs.gB(5, this.tME);
      paramVarArgs.gB(6, this.tMF);
      paramVarArgs.gB(7, this.tMG);
      paramVarArgs.gB(8, this.tMH);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.hQP) + 0 + d.a.a.a.gy(2, this.sSK) + d.a.a.a.gy(3, this.tMC) + d.a.a.a.gy(4, this.tMD) + d.a.a.a.gy(5, this.tME) + d.a.a.a.gy(6, this.tMF) + d.a.a.a.gy(7, this.tMG) + d.a.a.a.gy(8, this.tMH);
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
      bvv localbvv = (bvv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbvv.hQP = locala.xpH.oD();
        return 0;
      case 2: 
        localbvv.sSK = locala.xpH.oD();
        return 0;
      case 3: 
        localbvv.tMC = locala.xpH.oD();
        return 0;
      case 4: 
        localbvv.tMD = locala.xpH.oD();
        return 0;
      case 5: 
        localbvv.tME = locala.xpH.oD();
        return 0;
      case 6: 
        localbvv.tMF = locala.xpH.oD();
        return 0;
      case 7: 
        localbvv.tMG = locala.xpH.oD();
        return 0;
      }
      localbvv.tMH = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvv
 * JD-Core Version:    0.7.0.1
 */