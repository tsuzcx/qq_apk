package com.tencent.mm.protocal.c;

public final class bda
  extends com.tencent.mm.bv.a
{
  public String nRs;
  public long tyr;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.nRs != null) {
        paramVarArgs.d(1, this.nRs);
      }
      paramVarArgs.Y(2, this.tyr);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.nRs == null) {
        break label273;
      }
    }
    label273:
    for (paramInt = d.a.a.b.b.a.e(1, this.nRs) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.tyr);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.url);
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
        bda localbda = (bda)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbda.nRs = locala.xpH.readString();
          return 0;
        case 2: 
          localbda.tyr = locala.xpH.oE();
          return 0;
        }
        localbda.url = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bda
 * JD-Core Version:    0.7.0.1
 */