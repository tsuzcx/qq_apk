package com.tencent.mm.protocal.c;

public final class bgs
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String sLC;
  public int sPE;
  public int tBs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.sLC != null) {
        paramVarArgs.d(2, this.sLC);
      }
      paramVarArgs.gB(3, this.tBs);
      paramVarArgs.gB(4, this.sPE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sLC != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sLC);
      }
      return i + d.a.a.a.gy(3, this.tBs) + d.a.a.a.gy(4, this.sPE);
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
        bgs localbgs = (bgs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbgs.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localbgs.sLC = locala.xpH.readString();
          return 0;
        case 3: 
          localbgs.tBs = locala.xpH.oD();
          return 0;
        }
        localbgs.sPE = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgs
 * JD-Core Version:    0.7.0.1
 */