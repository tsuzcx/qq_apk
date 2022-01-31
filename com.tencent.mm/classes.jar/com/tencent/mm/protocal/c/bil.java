package com.tencent.mm.protocal.c;

public final class bil
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String sUr;
  public String tac;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.tac != null) {
        paramVarArgs.d(2, this.tac);
      }
      if (this.sUr != null) {
        paramVarArgs.d(3, this.sUr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tac != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tac);
      }
      i = paramInt;
      if (this.sUr != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sUr);
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
        bil localbil = (bil)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbil.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localbil.tac = locala.xpH.readString();
          return 0;
        }
        localbil.sUr = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bil
 * JD-Core Version:    0.7.0.1
 */