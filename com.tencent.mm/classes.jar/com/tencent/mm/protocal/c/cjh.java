package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cjh
  extends com.tencent.mm.bv.a
{
  public int sDT;
  public boolean tXg;
  public LinkedList<cja> tcB = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.tcB);
      paramVarArgs.gB(2, this.sDT);
      paramVarArgs.aA(3, this.tXg);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.c(1, 8, this.tcB) + 0 + d.a.a.a.gy(2, this.sDT) + (d.a.a.b.b.a.dQ(3) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tcB.clear();
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
      cjh localcjh = (cjh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cja();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cja)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcjh.tcB.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localcjh.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localcjh.tXg = ((d.a.a.a.a)localObject1).cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjh
 * JD-Core Version:    0.7.0.1
 */