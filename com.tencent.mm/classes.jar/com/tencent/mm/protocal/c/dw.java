package com.tencent.mm.protocal.c;

public final class dw
  extends com.tencent.mm.bv.a
{
  public String kRX;
  public String kTU;
  public int sxz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRX != null) {
        paramVarArgs.d(1, this.kRX);
      }
      paramVarArgs.gB(2, this.sxz);
      if (this.kTU != null) {
        paramVarArgs.d(3, this.kTU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRX == null) {
        break label273;
      }
    }
    label273:
    for (paramInt = d.a.a.b.b.a.e(1, this.kRX) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sxz);
      paramInt = i;
      if (this.kTU != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kTU);
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
        dw localdw = (dw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdw.kRX = locala.xpH.readString();
          return 0;
        case 2: 
          localdw.sxz = locala.xpH.oD();
          return 0;
        }
        localdw.kTU = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dw
 * JD-Core Version:    0.7.0.1
 */