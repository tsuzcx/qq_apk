package com.tencent.mm.protocal.c;

public final class fu
  extends com.tencent.mm.bv.a
{
  public String lnT;
  public String mOY;
  public String mOb;
  public String szR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szR != null) {
        paramVarArgs.d(1, this.szR);
      }
      if (this.mOb != null) {
        paramVarArgs.d(2, this.mOb);
      }
      if (this.lnT != null) {
        paramVarArgs.d(3, this.lnT);
      }
      if (this.mOY != null) {
        paramVarArgs.d(4, this.mOY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.szR == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.szR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mOb != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.mOb);
      }
      i = paramInt;
      if (this.lnT != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.lnT);
      }
      paramInt = i;
      if (this.mOY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.mOY);
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
        fu localfu = (fu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localfu.szR = locala.xpH.readString();
          return 0;
        case 2: 
          localfu.mOb = locala.xpH.readString();
          return 0;
        case 3: 
          localfu.lnT = locala.xpH.readString();
          return 0;
        }
        localfu.mOY = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fu
 * JD-Core Version:    0.7.0.1
 */