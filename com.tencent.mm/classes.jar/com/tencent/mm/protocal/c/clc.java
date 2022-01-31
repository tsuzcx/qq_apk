package com.tencent.mm.protocal.c;

public final class clc
  extends com.tencent.mm.bv.a
{
  public String tYr;
  public boolean tYs;
  public int tYt;
  public int tYu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tYr != null) {
        paramVarArgs.d(1, this.tYr);
      }
      paramVarArgs.aA(2, this.tYs);
      paramVarArgs.gB(3, this.tYt);
      paramVarArgs.gB(4, this.tYu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tYr == null) {
        break label277;
      }
    }
    label277:
    for (paramInt = d.a.a.b.b.a.e(1, this.tYr) + 0;; paramInt = 0)
    {
      return paramInt + (d.a.a.b.b.a.dQ(2) + 1) + d.a.a.a.gy(3, this.tYt) + d.a.a.a.gy(4, this.tYu);
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
        clc localclc = (clc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localclc.tYr = locala.xpH.readString();
          return 0;
        case 2: 
          localclc.tYs = locala.cUr();
          return 0;
        case 3: 
          localclc.tYt = locala.xpH.oD();
          return 0;
        }
        localclc.tYu = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clc
 * JD-Core Version:    0.7.0.1
 */