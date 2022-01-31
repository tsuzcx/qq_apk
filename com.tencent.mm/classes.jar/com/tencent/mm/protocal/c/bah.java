package com.tencent.mm.protocal.c;

public final class bah
  extends com.tencent.mm.bv.a
{
  public String ewD;
  public int ndo;
  public int sEE;
  public int sNU;
  public int twk;
  public int twl;
  public String twm;
  public int twn;
  public String two;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ewD != null) {
        paramVarArgs.d(1, this.ewD);
      }
      paramVarArgs.gB(2, this.twk);
      paramVarArgs.gB(3, this.twl);
      paramVarArgs.gB(4, this.sEE);
      if (this.twm != null) {
        paramVarArgs.d(5, this.twm);
      }
      paramVarArgs.gB(6, this.ndo);
      paramVarArgs.gB(7, this.twn);
      paramVarArgs.gB(8, this.sNU);
      if (this.two != null) {
        paramVarArgs.d(9, this.two);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ewD == null) {
        break label523;
      }
    }
    label523:
    for (paramInt = d.a.a.b.b.a.e(1, this.ewD) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.twk) + d.a.a.a.gy(3, this.twl) + d.a.a.a.gy(4, this.sEE);
      paramInt = i;
      if (this.twm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.twm);
      }
      i = paramInt + d.a.a.a.gy(6, this.ndo) + d.a.a.a.gy(7, this.twn) + d.a.a.a.gy(8, this.sNU);
      paramInt = i;
      if (this.two != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.two);
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
        bah localbah = (bah)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbah.ewD = locala.xpH.readString();
          return 0;
        case 2: 
          localbah.twk = locala.xpH.oD();
          return 0;
        case 3: 
          localbah.twl = locala.xpH.oD();
          return 0;
        case 4: 
          localbah.sEE = locala.xpH.oD();
          return 0;
        case 5: 
          localbah.twm = locala.xpH.readString();
          return 0;
        case 6: 
          localbah.ndo = locala.xpH.oD();
          return 0;
        case 7: 
          localbah.twn = locala.xpH.oD();
          return 0;
        case 8: 
          localbah.sNU = locala.xpH.oD();
          return 0;
        }
        localbah.two = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bah
 * JD-Core Version:    0.7.0.1
 */