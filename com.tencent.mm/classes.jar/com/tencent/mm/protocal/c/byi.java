package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class byi
  extends com.tencent.mm.bv.a
{
  public b sFm;
  public int sFn;
  public int tON;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(7, this.tON);
      if (this.sFm != null) {
        paramVarArgs.b(8, this.sFm);
      }
      paramVarArgs.gB(9, this.sFn);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(7, this.tON) + 0;
      paramInt = i;
      if (this.sFm != null) {
        paramInt = i + d.a.a.a.a(8, this.sFm);
      }
      return paramInt + d.a.a.a.gy(9, this.sFn);
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
      byi localbyi = (byi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 7: 
        localbyi.tON = locala.xpH.oD();
        return 0;
      case 8: 
        localbyi.sFm = locala.cUs();
        return 0;
      }
      localbyi.sFn = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byi
 * JD-Core Version:    0.7.0.1
 */