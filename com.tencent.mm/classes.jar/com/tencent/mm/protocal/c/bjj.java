package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bjj
  extends com.tencent.mm.bv.a
{
  public int tDg;
  public int tDh;
  public LinkedList<String> tDi = new LinkedList();
  public int tDj;
  public int tcY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tDg);
      paramVarArgs.gB(2, this.tDh);
      paramVarArgs.gB(3, this.tcY);
      paramVarArgs.d(4, 1, this.tDi);
      paramVarArgs.gB(5, this.tDj);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tDg) + 0 + d.a.a.a.gy(2, this.tDh) + d.a.a.a.gy(3, this.tcY) + d.a.a.a.c(4, 1, this.tDi) + d.a.a.a.gy(5, this.tDj);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tDi.clear();
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
      bjj localbjj = (bjj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbjj.tDg = locala.xpH.oD();
        return 0;
      case 2: 
        localbjj.tDh = locala.xpH.oD();
        return 0;
      case 3: 
        localbjj.tcY = locala.xpH.oD();
        return 0;
      case 4: 
        localbjj.tDi.add(locala.xpH.readString());
        return 0;
      }
      localbjj.tDj = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjj
 * JD-Core Version:    0.7.0.1
 */