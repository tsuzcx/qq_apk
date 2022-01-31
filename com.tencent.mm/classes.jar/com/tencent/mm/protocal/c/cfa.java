package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cfa
  extends com.tencent.mm.bv.a
{
  public int hPS;
  public int sEE;
  public LinkedList<cez> tTH = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hPS);
      paramVarArgs.d(2, 8, this.tTH);
      paramVarArgs.gB(3, this.sEE);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.hPS) + 0 + d.a.a.a.c(2, 8, this.tTH) + d.a.a.a.gy(3, this.sEE);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tTH.clear();
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
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      cfa localcfa = (cfa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcfa.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cez();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cez)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcfa.tTH.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localcfa.sEE = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfa
 * JD-Core Version:    0.7.0.1
 */