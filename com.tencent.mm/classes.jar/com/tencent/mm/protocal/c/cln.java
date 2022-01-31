package com.tencent.mm.protocal.c;

public final class cln
  extends com.tencent.mm.bv.a
{
  public String kSF;
  public String tYK;
  public String tqh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tYK != null) {
        paramVarArgs.d(1, this.tYK);
      }
      if (this.kSF != null) {
        paramVarArgs.d(2, this.kSF);
      }
      if (this.tqh != null) {
        paramVarArgs.d(3, this.tqh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tYK == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.tYK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSF != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSF);
      }
      i = paramInt;
      if (this.tqh != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tqh);
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
        cln localcln = (cln)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcln.tYK = locala.xpH.readString();
          return 0;
        case 2: 
          localcln.kSF = locala.xpH.readString();
          return 0;
        }
        localcln.tqh = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cln
 * JD-Core Version:    0.7.0.1
 */