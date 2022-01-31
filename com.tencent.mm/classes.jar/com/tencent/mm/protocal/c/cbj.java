package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cbj
  extends com.tencent.mm.bv.a
{
  public int ssq;
  public LinkedList<String> tQy = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ssq);
      paramVarArgs.d(2, 1, this.tQy);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.ssq) + 0 + d.a.a.a.c(2, 1, this.tQy);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tQy.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      cbj localcbj = (cbj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcbj.ssq = locala.xpH.oD();
        return 0;
      }
      localcbj.tQy.add(locala.xpH.readString());
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbj
 * JD-Core Version:    0.7.0.1
 */