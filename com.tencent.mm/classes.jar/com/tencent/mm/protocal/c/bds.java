package com.tencent.mm.protocal.c;

public final class bds
  extends com.tencent.mm.bv.a
{
  public String title;
  public String tza;
  public String tzb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.tza != null) {
        paramVarArgs.d(2, this.tza);
      }
      if (this.tzb != null) {
        paramVarArgs.d(3, this.tzb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tza != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tza);
      }
      i = paramInt;
      if (this.tzb != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tzb);
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
        bds localbds = (bds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbds.title = locala.xpH.readString();
          return 0;
        case 2: 
          localbds.tza = locala.xpH.readString();
          return 0;
        }
        localbds.tzb = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bds
 * JD-Core Version:    0.7.0.1
 */