package com.tencent.mm.protocal.c;

public final class rv
  extends com.tencent.mm.bv.a
{
  public String qsJ;
  public String qyx;
  public String sPW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.qsJ != null) {
        paramVarArgs.d(1, this.qsJ);
      }
      if (this.qyx != null) {
        paramVarArgs.d(2, this.qyx);
      }
      if (this.sPW != null) {
        paramVarArgs.d(3, this.sPW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.qsJ == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.qsJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qyx != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.qyx);
      }
      i = paramInt;
      if (this.sPW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sPW);
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
        rv localrv = (rv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localrv.qsJ = locala.xpH.readString();
          return 0;
        case 2: 
          localrv.qyx = locala.xpH.readString();
          return 0;
        }
        localrv.sPW = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rv
 * JD-Core Version:    0.7.0.1
 */