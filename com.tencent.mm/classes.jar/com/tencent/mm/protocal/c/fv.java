package com.tencent.mm.protocal.c;

public final class fv
  extends com.tencent.mm.bv.a
{
  public String ivG;
  public String lnT;
  public String mOb;
  public String qqU;
  public String szS;
  public String szT;
  public String szU;
  public boolean szV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lnT != null) {
        paramVarArgs.d(1, this.lnT);
      }
      if (this.mOb != null) {
        paramVarArgs.d(2, this.mOb);
      }
      if (this.ivG != null) {
        paramVarArgs.d(3, this.ivG);
      }
      if (this.qqU != null) {
        paramVarArgs.d(4, this.qqU);
      }
      if (this.szS != null) {
        paramVarArgs.d(5, this.szS);
      }
      if (this.szT != null) {
        paramVarArgs.d(6, this.szT);
      }
      if (this.szU != null) {
        paramVarArgs.d(8, this.szU);
      }
      paramVarArgs.aA(9, this.szV);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lnT == null) {
        break label549;
      }
    }
    label549:
    for (int i = d.a.a.b.b.a.e(1, this.lnT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mOb != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.mOb);
      }
      i = paramInt;
      if (this.ivG != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ivG);
      }
      paramInt = i;
      if (this.qqU != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.qqU);
      }
      i = paramInt;
      if (this.szS != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.szS);
      }
      paramInt = i;
      if (this.szT != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.szT);
      }
      i = paramInt;
      if (this.szU != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.szU);
      }
      return i + (d.a.a.b.b.a.dQ(9) + 1);
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
        fv localfv = (fv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          return -1;
        case 1: 
          localfv.lnT = locala.xpH.readString();
          return 0;
        case 2: 
          localfv.mOb = locala.xpH.readString();
          return 0;
        case 3: 
          localfv.ivG = locala.xpH.readString();
          return 0;
        case 4: 
          localfv.qqU = locala.xpH.readString();
          return 0;
        case 5: 
          localfv.szS = locala.xpH.readString();
          return 0;
        case 6: 
          localfv.szT = locala.xpH.readString();
          return 0;
        case 8: 
          localfv.szU = locala.xpH.readString();
          return 0;
        }
        localfv.szV = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fv
 * JD-Core Version:    0.7.0.1
 */