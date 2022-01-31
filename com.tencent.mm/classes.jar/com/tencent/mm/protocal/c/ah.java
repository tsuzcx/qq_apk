package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ah
  extends com.tencent.mm.bv.a
{
  public int ssQ;
  public int ssR;
  public int ssX;
  public LinkedList<af> ssY = new LinkedList();
  public int ssZ;
  public LinkedList<af> sta = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ssQ);
      paramVarArgs.gB(2, this.ssX);
      paramVarArgs.d(3, 8, this.ssY);
      paramVarArgs.gB(4, this.ssR);
      paramVarArgs.gB(5, this.ssZ);
      paramVarArgs.d(6, 8, this.sta);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.ssQ) + 0 + d.a.a.a.gy(2, this.ssX) + d.a.a.a.c(3, 8, this.ssY) + d.a.a.a.gy(4, this.ssR) + d.a.a.a.gy(5, this.ssZ) + d.a.a.a.c(6, 8, this.sta);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ssY.clear();
      this.sta.clear();
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
      ah localah = (ah)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localah.ssQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localah.ssX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new af();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((af)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localah.ssY.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localah.ssR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localah.ssZ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new af();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((af)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localah.sta.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ah
 * JD-Core Version:    0.7.0.1
 */