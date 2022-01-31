package com.tencent.mm.protocal.c;

public final class ats
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String hRf;
  public String sLD;
  public String sLE;
  public String tac;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.sLD != null) {
        paramVarArgs.d(3, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(4, this.sLE);
      }
      if (this.tac != null) {
        paramVarArgs.d(5, this.tac);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.sLD != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sLD);
      }
      paramInt = i;
      if (this.sLE != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sLE);
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tac);
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
        ats localats = (ats)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localats.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localats.hRf = locala.xpH.readString();
          return 0;
        case 3: 
          localats.sLD = locala.xpH.readString();
          return 0;
        case 4: 
          localats.sLE = locala.xpH.readString();
          return 0;
        }
        localats.tac = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ats
 * JD-Core Version:    0.7.0.1
 */