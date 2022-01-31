package com.tencent.mm.protocal.c;

public final class ex
  extends com.tencent.mm.bv.a
{
  public String mOb;
  public String syB;
  public String syC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syB != null) {
        paramVarArgs.d(1, this.syB);
      }
      if (this.syC != null) {
        paramVarArgs.d(2, this.syC);
      }
      if (this.mOb != null) {
        paramVarArgs.d(3, this.mOb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.syB == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.syB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syC != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.syC);
      }
      i = paramInt;
      if (this.mOb != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mOb);
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
        ex localex = (ex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localex.syB = locala.xpH.readString();
          return 0;
        case 2: 
          localex.syC = locala.xpH.readString();
          return 0;
        }
        localex.mOb = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ex
 * JD-Core Version:    0.7.0.1
 */