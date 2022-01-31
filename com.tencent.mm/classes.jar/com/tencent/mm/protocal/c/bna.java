package com.tencent.mm.protocal.c;

public final class bna
  extends com.tencent.mm.bv.a
{
  public String gkl;
  public String kRN;
  public String sEi;
  public int tGf;
  public String tmA;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sEi != null) {
        paramVarArgs.d(1, this.sEi);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      paramVarArgs.gB(3, this.tGf);
      if (this.gkl != null) {
        paramVarArgs.d(4, this.gkl);
      }
      if (this.tmA != null) {
        paramVarArgs.d(5, this.tmA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sEi == null) {
        break label383;
      }
    }
    label383:
    for (paramInt = d.a.a.b.b.a.e(1, this.sEi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kRN);
      }
      i += d.a.a.a.gy(3, this.tGf);
      paramInt = i;
      if (this.gkl != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.gkl);
      }
      i = paramInt;
      if (this.tmA != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tmA);
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
        bna localbna = (bna)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbna.sEi = locala.xpH.readString();
          return 0;
        case 2: 
          localbna.kRN = locala.xpH.readString();
          return 0;
        case 3: 
          localbna.tGf = locala.xpH.oD();
          return 0;
        case 4: 
          localbna.gkl = locala.xpH.readString();
          return 0;
        }
        localbna.tmA = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bna
 * JD-Core Version:    0.7.0.1
 */