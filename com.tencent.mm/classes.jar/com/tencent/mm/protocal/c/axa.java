package com.tencent.mm.protocal.c;

public final class axa
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public int nFj;
  public String svm;
  public int ttm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svm != null) {
        paramVarArgs.d(1, this.svm);
      }
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      paramVarArgs.gB(3, this.ttm);
      paramVarArgs.gB(4, this.nFj);
      return 0;
    }
    if (paramInt == 1) {
      if (this.svm == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.b.b.a.e(1, this.svm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.hPY);
      }
      return i + d.a.a.a.gy(3, this.ttm) + d.a.a.a.gy(4, this.nFj);
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
        axa localaxa = (axa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaxa.svm = locala.xpH.readString();
          return 0;
        case 2: 
          localaxa.hPY = locala.xpH.readString();
          return 0;
        case 3: 
          localaxa.ttm = locala.xpH.oD();
          return 0;
        }
        localaxa.nFj = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axa
 * JD-Core Version:    0.7.0.1
 */