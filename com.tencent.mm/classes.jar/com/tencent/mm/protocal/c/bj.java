package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class bj
  extends com.tencent.mm.bv.a
{
  public int sva;
  public b svb;
  public long svc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sva);
      if (this.svb != null) {
        paramVarArgs.b(2, this.svb);
      }
      paramVarArgs.Y(3, this.svc);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.sva) + 0;
      paramInt = i;
      if (this.svb != null) {
        paramInt = i + d.a.a.a.a(2, this.svb);
      }
      return paramInt + d.a.a.a.X(3, this.svc);
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
      bj localbj = (bj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbj.sva = locala.xpH.oD();
        return 0;
      case 2: 
        localbj.svb = locala.cUs();
        return 0;
      }
      localbj.svc = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bj
 * JD-Core Version:    0.7.0.1
 */