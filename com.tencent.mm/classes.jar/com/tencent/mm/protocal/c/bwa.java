package com.tencent.mm.protocal.c;

public final class bwa
  extends com.tencent.mm.bv.a
{
  public String dSP;
  public String dSR;
  public String dSS;
  public String dST;
  public String dSU;
  public String dSV;
  public String dSW;
  public int sWK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.dSP != null) {
        paramVarArgs.d(1, this.dSP);
      }
      paramVarArgs.gB(2, this.sWK);
      if (this.dSS != null) {
        paramVarArgs.d(3, this.dSS);
      }
      if (this.dST != null) {
        paramVarArgs.d(4, this.dST);
      }
      if (this.dSR != null) {
        paramVarArgs.d(5, this.dSR);
      }
      if (this.dSU != null) {
        paramVarArgs.d(6, this.dSU);
      }
      if (this.dSV != null) {
        paramVarArgs.d(7, this.dSV);
      }
      if (this.dSW != null) {
        paramVarArgs.d(8, this.dSW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.dSP == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = d.a.a.b.b.a.e(1, this.dSP) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sWK);
      paramInt = i;
      if (this.dSS != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.dSS);
      }
      i = paramInt;
      if (this.dST != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.dST);
      }
      paramInt = i;
      if (this.dSR != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.dSR);
      }
      i = paramInt;
      if (this.dSU != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.dSU);
      }
      paramInt = i;
      if (this.dSV != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.dSV);
      }
      i = paramInt;
      if (this.dSW != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.dSW);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bwa localbwa = (bwa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbwa.dSP = locala.xpH.readString();
          return 0;
        case 2: 
          localbwa.sWK = locala.xpH.oD();
          return 0;
        case 3: 
          localbwa.dSS = locala.xpH.readString();
          return 0;
        case 4: 
          localbwa.dST = locala.xpH.readString();
          return 0;
        case 5: 
          localbwa.dSR = locala.xpH.readString();
          return 0;
        case 6: 
          localbwa.dSU = locala.xpH.readString();
          return 0;
        case 7: 
          localbwa.dSV = locala.xpH.readString();
          return 0;
        }
        localbwa.dSW = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bwa
 * JD-Core Version:    0.7.0.1
 */