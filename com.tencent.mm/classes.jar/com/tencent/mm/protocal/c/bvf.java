package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bvf
  extends com.tencent.mm.bv.a
{
  public int sNU;
  public int sST;
  public int tLL;
  public int tLM;
  public int tLN;
  public int tLO;
  public int tLP;
  public LinkedList<Integer> tLQ = new LinkedList();
  public int tLR;
  public int tLS;
  public LinkedList<Integer> tLT = new LinkedList();
  public int tLU;
  public int tLV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sST);
      paramVarArgs.gB(2, this.tLL);
      paramVarArgs.gB(3, this.sNU);
      paramVarArgs.gB(4, this.tLM);
      paramVarArgs.gB(5, this.tLN);
      paramVarArgs.gB(6, this.tLO);
      paramVarArgs.gB(7, this.tLP);
      paramVarArgs.d(8, 2, this.tLQ);
      paramVarArgs.gB(9, this.tLR);
      paramVarArgs.gB(10, this.tLS);
      paramVarArgs.d(11, 2, this.tLT);
      paramVarArgs.gB(12, this.tLU);
      paramVarArgs.gB(13, this.tLV);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sST) + 0 + d.a.a.a.gy(2, this.tLL) + d.a.a.a.gy(3, this.sNU) + d.a.a.a.gy(4, this.tLM) + d.a.a.a.gy(5, this.tLN) + d.a.a.a.gy(6, this.tLO) + d.a.a.a.gy(7, this.tLP) + d.a.a.a.c(8, 2, this.tLQ) + d.a.a.a.gy(9, this.tLR) + d.a.a.a.gy(10, this.tLS) + d.a.a.a.c(11, 2, this.tLT) + d.a.a.a.gy(12, this.tLU) + d.a.a.a.gy(13, this.tLV);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tLQ.clear();
      this.tLT.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      bvf localbvf = (bvf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbvf.sST = locala.xpH.oD();
        return 0;
      case 2: 
        localbvf.tLL = locala.xpH.oD();
        return 0;
      case 3: 
        localbvf.sNU = locala.xpH.oD();
        return 0;
      case 4: 
        localbvf.tLM = locala.xpH.oD();
        return 0;
      case 5: 
        localbvf.tLN = locala.xpH.oD();
        return 0;
      case 6: 
        localbvf.tLO = locala.xpH.oD();
        return 0;
      case 7: 
        localbvf.tLP = locala.xpH.oD();
        return 0;
      case 8: 
        localbvf.tLQ.add(Integer.valueOf(locala.xpH.oD()));
        return 0;
      case 9: 
        localbvf.tLR = locala.xpH.oD();
        return 0;
      case 10: 
        localbvf.tLS = locala.xpH.oD();
        return 0;
      case 11: 
        localbvf.tLT.add(Integer.valueOf(locala.xpH.oD()));
        return 0;
      case 12: 
        localbvf.tLU = locala.xpH.oD();
        return 0;
      }
      localbvf.tLV = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvf
 * JD-Core Version:    0.7.0.1
 */