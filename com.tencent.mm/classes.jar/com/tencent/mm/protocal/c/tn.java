package com.tencent.mm.protocal.c;

public final class tn
  extends com.tencent.mm.bv.a
{
  public String sQE;
  public int sQF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQE != null) {
        paramVarArgs.d(1, this.sQE);
      }
      paramVarArgs.gB(2, this.sQF);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQE == null) {
        break label212;
      }
    }
    label212:
    for (paramInt = d.a.a.b.b.a.e(1, this.sQE) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.sQF);
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
        tn localtn = (tn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localtn.sQE = locala.xpH.readString();
          return 0;
        }
        localtn.sQF = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.tn
 * JD-Core Version:    0.7.0.1
 */