package com.tencent.mm.protocal.c;

public final class cgq
  extends com.tencent.mm.bv.a
{
  public String bOn;
  public int tVE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOn != null) {
        paramVarArgs.d(1, this.bOn);
      }
      paramVarArgs.gB(2, this.tVE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOn == null) {
        break label212;
      }
    }
    label212:
    for (paramInt = d.a.a.b.b.a.e(1, this.bOn) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tVE);
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
        cgq localcgq = (cgq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcgq.bOn = locala.xpH.readString();
          return 0;
        }
        localcgq.tVE = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgq
 * JD-Core Version:    0.7.0.1
 */