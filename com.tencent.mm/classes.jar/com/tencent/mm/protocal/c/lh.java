package com.tencent.mm.protocal.c;

public final class lh
  extends com.tencent.mm.bv.a
{
  public String sAh;
  public String sGV;
  public int sGW;
  public String sGX;
  public String sGY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sGV != null) {
        paramVarArgs.d(1, this.sGV);
      }
      paramVarArgs.gB(2, this.sGW);
      if (this.sGX != null) {
        paramVarArgs.d(3, this.sGX);
      }
      if (this.sAh != null) {
        paramVarArgs.d(4, this.sAh);
      }
      if (this.sGY != null) {
        paramVarArgs.d(5, this.sGY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGV == null) {
        break label383;
      }
    }
    label383:
    for (paramInt = d.a.a.b.b.a.e(1, this.sGV) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sGW);
      paramInt = i;
      if (this.sGX != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sGX);
      }
      i = paramInt;
      if (this.sAh != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sAh);
      }
      paramInt = i;
      if (this.sGY != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sGY);
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
        lh locallh = (lh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locallh.sGV = locala.xpH.readString();
          return 0;
        case 2: 
          locallh.sGW = locala.xpH.oD();
          return 0;
        case 3: 
          locallh.sGX = locala.xpH.readString();
          return 0;
        case 4: 
          locallh.sAh = locala.xpH.readString();
          return 0;
        }
        locallh.sGY = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lh
 * JD-Core Version:    0.7.0.1
 */