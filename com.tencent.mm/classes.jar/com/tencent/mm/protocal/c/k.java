package com.tencent.mm.protocal.c;

public final class k
  extends com.tencent.mm.bv.a
{
  public long ceq;
  public String srA;
  public int srB;
  public String srC;
  public String srD;
  public String srq;
  public String srr;
  public int state;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.srq != null) {
        paramVarArgs.d(1, this.srq);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.Y(3, this.ceq);
      if (this.srA != null) {
        paramVarArgs.d(5, this.srA);
      }
      paramVarArgs.gB(10, this.state);
      paramVarArgs.gB(11, this.srB);
      if (this.srC != null) {
        paramVarArgs.d(12, this.srC);
      }
      if (this.srr != null) {
        paramVarArgs.d(13, this.srr);
      }
      if (this.srD != null) {
        paramVarArgs.d(14, this.srD);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.srq == null) {
        break label599;
      }
    }
    label599:
    for (paramInt = d.a.a.b.b.a.e(1, this.srq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.title);
      }
      i += d.a.a.a.X(3, this.ceq);
      paramInt = i;
      if (this.srA != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.srA);
      }
      i = paramInt + d.a.a.a.gy(10, this.state) + d.a.a.a.gy(11, this.srB);
      paramInt = i;
      if (this.srC != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.srC);
      }
      i = paramInt;
      if (this.srr != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.srr);
      }
      paramInt = i;
      if (this.srD != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.srD);
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
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          return -1;
        case 1: 
          localk.srq = locala.xpH.readString();
          return 0;
        case 2: 
          localk.title = locala.xpH.readString();
          return 0;
        case 3: 
          localk.ceq = locala.xpH.oE();
          return 0;
        case 5: 
          localk.srA = locala.xpH.readString();
          return 0;
        case 10: 
          localk.state = locala.xpH.oD();
          return 0;
        case 11: 
          localk.srB = locala.xpH.oD();
          return 0;
        case 12: 
          localk.srC = locala.xpH.readString();
          return 0;
        case 13: 
          localk.srr = locala.xpH.readString();
          return 0;
        }
        localk.srD = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.k
 * JD-Core Version:    0.7.0.1
 */