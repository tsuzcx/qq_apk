package com.tencent.mm.protocal.c;

public final class atz
  extends com.tencent.mm.bv.a
{
  public String sBf;
  public String sBg;
  public String sBh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sBg != null) {
        paramVarArgs.d(1, this.sBg);
      }
      if (this.sBf != null) {
        paramVarArgs.d(2, this.sBf);
      }
      if (this.sBh != null) {
        paramVarArgs.d(3, this.sBh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sBg == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.sBg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sBf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sBf);
      }
      i = paramInt;
      if (this.sBh != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sBh);
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
        atz localatz = (atz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localatz.sBg = locala.xpH.readString();
          return 0;
        case 2: 
          localatz.sBf = locala.xpH.readString();
          return 0;
        }
        localatz.sBh = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atz
 * JD-Core Version:    0.7.0.1
 */