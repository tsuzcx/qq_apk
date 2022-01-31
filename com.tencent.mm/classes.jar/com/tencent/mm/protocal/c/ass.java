package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class ass
  extends com.tencent.mm.bv.a
{
  public int hPS;
  public int sQS;
  public int tou;
  public b tov;
  public int tow;
  public int tox;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tou);
      if (this.tov != null) {
        paramVarArgs.b(2, this.tov);
      }
      paramVarArgs.gB(3, this.tow);
      paramVarArgs.gB(4, this.sQS);
      paramVarArgs.gB(5, this.hPS);
      paramVarArgs.gB(6, this.tox);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tou) + 0;
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + d.a.a.a.a(2, this.tov);
      }
      return paramInt + d.a.a.a.gy(3, this.tow) + d.a.a.a.gy(4, this.sQS) + d.a.a.a.gy(5, this.hPS) + d.a.a.a.gy(6, this.tox);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ass localass = (ass)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localass.tou = locala.xpH.oD();
        return 0;
      case 2: 
        localass.tov = locala.cUs();
        return 0;
      case 3: 
        localass.tow = locala.xpH.oD();
        return 0;
      case 4: 
        localass.sQS = locala.xpH.oD();
        return 0;
      case 5: 
        localass.hPS = locala.xpH.oD();
        return 0;
      }
      localass.tox = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ass
 * JD-Core Version:    0.7.0.1
 */