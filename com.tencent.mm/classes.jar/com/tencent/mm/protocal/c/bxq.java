package com.tencent.mm.protocal.c;

public class bxq
  extends com.tencent.mm.bv.a
{
  public String ilp;
  public String sxi;
  public int weight;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxi != null) {
        paramVarArgs.d(1, this.sxi);
      }
      if (this.ilp != null) {
        paramVarArgs.d(2, this.ilp);
      }
      paramVarArgs.gB(3, this.weight);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxi == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ilp != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ilp);
      }
      return i + d.a.a.a.gy(3, this.weight);
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
        bxq localbxq = (bxq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbxq.sxi = locala.xpH.readString();
          return 0;
        case 2: 
          localbxq.ilp = locala.xpH.readString();
          return 0;
        }
        localbxq.weight = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxq
 * JD-Core Version:    0.7.0.1
 */