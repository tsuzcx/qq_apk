package com.tencent.mm.protocal.c;

public final class ayn
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String hPY;
  public String kRN;
  public long ndp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      paramVarArgs.Y(4, this.ndp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label324;
      }
    }
    label324:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRN);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hPY);
      }
      return i + d.a.a.a.X(4, this.ndp);
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
        ayn localayn = (ayn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localayn.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localayn.kRN = locala.xpH.readString();
          return 0;
        case 3: 
          localayn.hPY = locala.xpH.readString();
          return 0;
        }
        localayn.ndp = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayn
 * JD-Core Version:    0.7.0.1
 */