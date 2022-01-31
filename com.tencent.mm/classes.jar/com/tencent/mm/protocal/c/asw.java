package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class asw
  extends com.tencent.mm.bv.a
{
  public int hPS;
  public int toC;
  public int toD;
  public int tou;
  public b tov;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tou);
      if (this.tov != null) {
        paramVarArgs.b(2, this.tov);
      }
      paramVarArgs.gB(3, this.toC);
      paramVarArgs.gB(4, this.hPS);
      paramVarArgs.gB(5, this.toD);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tou) + 0;
      paramInt = i;
      if (this.tov != null) {
        paramInt = i + d.a.a.a.a(2, this.tov);
      }
      return paramInt + d.a.a.a.gy(3, this.toC) + d.a.a.a.gy(4, this.hPS) + d.a.a.a.gy(5, this.toD);
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
      asw localasw = (asw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localasw.tou = locala.xpH.oD();
        return 0;
      case 2: 
        localasw.tov = locala.cUs();
        return 0;
      case 3: 
        localasw.toC = locala.xpH.oD();
        return 0;
      case 4: 
        localasw.hPS = locala.xpH.oD();
        return 0;
      }
      localasw.toD = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.asw
 * JD-Core Version:    0.7.0.1
 */