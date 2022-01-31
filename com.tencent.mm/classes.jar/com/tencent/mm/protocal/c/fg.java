package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class fg
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> syU = new LinkedList();
  public int syV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 1, this.syU);
      paramVarArgs.gB(2, this.syV);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.c(1, 1, this.syU) + 0 + d.a.a.a.gy(2, this.syV);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.syU.clear();
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
      fg localfg = (fg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localfg.syU.add(locala.xpH.readString());
        return 0;
      }
      localfg.syV = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fg
 * JD-Core Version:    0.7.0.1
 */