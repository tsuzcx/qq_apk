package com.tencent.mm.protocal.c;

public final class bik
  extends com.tencent.mm.bv.a
{
  public String tCA;
  public String tCz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tCz != null) {
        paramVarArgs.d(1, this.tCz);
      }
      if (this.tCA != null) {
        paramVarArgs.d(2, this.tCA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tCz == null) {
        break label234;
      }
    }
    label234:
    for (paramInt = d.a.a.b.b.a.e(1, this.tCz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tCA != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tCA);
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
        bik localbik = (bik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbik.tCz = locala.xpH.readString();
          return 0;
        }
        localbik.tCA = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bik
 * JD-Core Version:    0.7.0.1
 */