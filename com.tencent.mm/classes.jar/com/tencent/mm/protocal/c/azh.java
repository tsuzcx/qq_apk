package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class azh
  extends com.tencent.mm.bv.a
{
  public long lastUpdateTime;
  public LinkedList<lu> sPS = new LinkedList();
  public int sPT;
  public int sPU;
  public int version;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.sPS);
      paramVarArgs.gB(2, this.version);
      paramVarArgs.gB(3, this.sPT);
      paramVarArgs.gB(4, this.sPU);
      paramVarArgs.Y(5, this.lastUpdateTime);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.c(1, 8, this.sPS) + 0 + d.a.a.a.gy(2, this.version) + d.a.a.a.gy(3, this.sPT) + d.a.a.a.gy(4, this.sPU) + d.a.a.a.X(5, this.lastUpdateTime);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sPS.clear();
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
      azh localazh = (azh)paramVarArgs[1];
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
          localObject1 = new lu();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((lu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localazh.sPS.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localazh.version = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localazh.sPT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localazh.sPU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localazh.lastUpdateTime = ((d.a.a.a.a)localObject1).xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azh
 * JD-Core Version:    0.7.0.1
 */