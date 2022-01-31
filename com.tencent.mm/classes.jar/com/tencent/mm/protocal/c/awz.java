package com.tencent.mm.protocal.c;

public final class awz
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String sLC;
  public String svm;
  
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
      if (this.sLC != null) {
        paramVarArgs.d(3, this.sLC);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.svm == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.svm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.sLC != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sLC);
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
        awz localawz = (awz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localawz.svm = locala.xpH.readString();
          return 0;
        case 2: 
          localawz.hPY = locala.xpH.readString();
          return 0;
        }
        localawz.sLC = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awz
 * JD-Core Version:    0.7.0.1
 */