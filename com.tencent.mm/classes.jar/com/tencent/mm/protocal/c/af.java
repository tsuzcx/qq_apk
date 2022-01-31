package com.tencent.mm.protocal.c;

public final class af
  extends com.tencent.mm.bv.a
{
  public String ssS;
  public int ssT;
  public int ssU;
  public int ssV;
  public int ssW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ssS != null) {
        paramVarArgs.d(1, this.ssS);
      }
      paramVarArgs.gB(2, this.ssT);
      paramVarArgs.gB(3, this.ssU);
      paramVarArgs.gB(4, this.ssV);
      paramVarArgs.gB(5, this.ssW);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssS == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = d.a.a.b.b.a.e(1, this.ssS) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.ssT) + d.a.a.a.gy(3, this.ssU) + d.a.a.a.gy(4, this.ssV) + d.a.a.a.gy(5, this.ssW);
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
        af localaf = (af)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaf.ssS = locala.xpH.readString();
          return 0;
        case 2: 
          localaf.ssT = locala.xpH.oD();
          return 0;
        case 3: 
          localaf.ssU = locala.xpH.oD();
          return 0;
        case 4: 
          localaf.ssV = locala.xpH.oD();
          return 0;
        }
        localaf.ssW = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.af
 * JD-Core Version:    0.7.0.1
 */