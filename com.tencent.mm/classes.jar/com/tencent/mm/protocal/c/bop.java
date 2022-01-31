package com.tencent.mm.protocal.c;

public final class bop
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b sRj;
  public int tGQ;
  public int tGR;
  public int tGS;
  public int tGT;
  public int tGU;
  public int tGV;
  public int tGW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sRj == null) {
        throw new d.a.a.b("Not all required fields were included: data");
      }
      paramVarArgs.gB(1, this.tGQ);
      paramVarArgs.gB(2, this.tGR);
      paramVarArgs.gB(3, this.tGS);
      paramVarArgs.gB(4, this.tGT);
      paramVarArgs.gB(5, this.tGU);
      paramVarArgs.gB(6, this.tGV);
      paramVarArgs.gB(7, this.tGW);
      if (this.sRj != null) {
        paramVarArgs.b(8, this.sRj);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tGQ) + 0 + d.a.a.a.gy(2, this.tGR) + d.a.a.a.gy(3, this.tGS) + d.a.a.a.gy(4, this.tGT) + d.a.a.a.gy(5, this.tGU) + d.a.a.a.gy(6, this.tGV) + d.a.a.a.gy(7, this.tGW);
      paramInt = i;
    } while (this.sRj == null);
    return i + d.a.a.a.a(8, this.sRj);
    d.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(locala); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(locala)) {
        if (!super.a(locala, this, paramInt)) {
          locala.cUt();
        }
      }
      if (paramVarArgs == null) {
        throw new d.a.a.b("Not all required fields were included: data");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (d.a.a.a.a)paramVarArgs[0];
      bop localbop = (bop)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbop.tGQ = locala.xpH.oD();
        return 0;
      case 2: 
        localbop.tGR = locala.xpH.oD();
        return 0;
      case 3: 
        localbop.tGS = locala.xpH.oD();
        return 0;
      case 4: 
        localbop.tGT = locala.xpH.oD();
        return 0;
      case 5: 
        localbop.tGU = locala.xpH.oD();
        return 0;
      case 6: 
        localbop.tGV = locala.xpH.oD();
        return 0;
      case 7: 
        localbop.tGW = locala.xpH.oD();
        return 0;
      }
      localbop.sRj = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bop
 * JD-Core Version:    0.7.0.1
 */