package com.tencent.mm.protocal.c;

public final class ft
  extends com.tencent.mm.bv.a
{
  public String lnT;
  public String mOb;
  public String mOc;
  public String qqU;
  public String szN;
  public String szO;
  public String szP;
  public String szQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szN != null) {
        paramVarArgs.d(1, this.szN);
      }
      if (this.qqU != null) {
        paramVarArgs.d(2, this.qqU);
      }
      if (this.mOb != null) {
        paramVarArgs.d(3, this.mOb);
      }
      if (this.mOc != null) {
        paramVarArgs.d(4, this.mOc);
      }
      if (this.lnT != null) {
        paramVarArgs.d(5, this.lnT);
      }
      if (this.szO != null) {
        paramVarArgs.d(6, this.szO);
      }
      if (this.szP != null) {
        paramVarArgs.d(7, this.szP);
      }
      if (this.szQ != null) {
        paramVarArgs.d(8, this.szQ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.szN == null) {
        break label568;
      }
    }
    label568:
    for (int i = d.a.a.b.b.a.e(1, this.szN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qqU != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.qqU);
      }
      i = paramInt;
      if (this.mOb != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mOb);
      }
      paramInt = i;
      if (this.mOc != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.mOc);
      }
      i = paramInt;
      if (this.lnT != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.lnT);
      }
      paramInt = i;
      if (this.szO != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.szO);
      }
      i = paramInt;
      if (this.szP != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.szP);
      }
      paramInt = i;
      if (this.szQ != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.szQ);
      }
      return paramInt;
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
        ft localft = (ft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localft.szN = locala.xpH.readString();
          return 0;
        case 2: 
          localft.qqU = locala.xpH.readString();
          return 0;
        case 3: 
          localft.mOb = locala.xpH.readString();
          return 0;
        case 4: 
          localft.mOc = locala.xpH.readString();
          return 0;
        case 5: 
          localft.lnT = locala.xpH.readString();
          return 0;
        case 6: 
          localft.szO = locala.xpH.readString();
          return 0;
        case 7: 
          localft.szP = locala.xpH.readString();
          return 0;
        }
        localft.szQ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ft
 * JD-Core Version:    0.7.0.1
 */