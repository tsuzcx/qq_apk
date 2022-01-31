package com.tencent.mm.protocal.c;

public final class rd
  extends com.tencent.mm.bv.a
{
  public int iFc;
  public int iFd;
  public int iFe;
  public int iFf;
  public int iFg;
  public int iFh;
  public int iFi;
  public int iFj;
  public int iFk;
  public int sOO;
  public int sOP;
  public int sOQ;
  public int sOR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.iFc);
      paramVarArgs.gB(2, this.sOO);
      paramVarArgs.gB(3, this.iFd);
      paramVarArgs.gB(4, this.iFe);
      paramVarArgs.gB(5, this.iFf);
      paramVarArgs.gB(6, this.sOP);
      paramVarArgs.gB(7, this.iFg);
      paramVarArgs.gB(8, this.iFh);
      paramVarArgs.gB(9, this.sOQ);
      paramVarArgs.gB(10, this.sOR);
      paramVarArgs.gB(11, this.iFi);
      paramVarArgs.gB(12, this.iFj);
      paramVarArgs.gB(13, this.iFk);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.iFc) + 0 + d.a.a.a.gy(2, this.sOO) + d.a.a.a.gy(3, this.iFd) + d.a.a.a.gy(4, this.iFe) + d.a.a.a.gy(5, this.iFf) + d.a.a.a.gy(6, this.sOP) + d.a.a.a.gy(7, this.iFg) + d.a.a.a.gy(8, this.iFh) + d.a.a.a.gy(9, this.sOQ) + d.a.a.a.gy(10, this.sOR) + d.a.a.a.gy(11, this.iFi) + d.a.a.a.gy(12, this.iFj) + d.a.a.a.gy(13, this.iFk);
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
      rd localrd = (rd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localrd.iFc = locala.xpH.oD();
        return 0;
      case 2: 
        localrd.sOO = locala.xpH.oD();
        return 0;
      case 3: 
        localrd.iFd = locala.xpH.oD();
        return 0;
      case 4: 
        localrd.iFe = locala.xpH.oD();
        return 0;
      case 5: 
        localrd.iFf = locala.xpH.oD();
        return 0;
      case 6: 
        localrd.sOP = locala.xpH.oD();
        return 0;
      case 7: 
        localrd.iFg = locala.xpH.oD();
        return 0;
      case 8: 
        localrd.iFh = locala.xpH.oD();
        return 0;
      case 9: 
        localrd.sOQ = locala.xpH.oD();
        return 0;
      case 10: 
        localrd.sOR = locala.xpH.oD();
        return 0;
      case 11: 
        localrd.iFi = locala.xpH.oD();
        return 0;
      case 12: 
        localrd.iFj = locala.xpH.oD();
        return 0;
      }
      localrd.iFk = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rd
 * JD-Core Version:    0.7.0.1
 */