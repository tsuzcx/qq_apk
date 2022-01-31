package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ua
  extends com.tencent.mm.bv.a
{
  public int sQN;
  public ub sQO;
  public int sQP;
  public ub sQQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQO == null) {
        throw new b("Not all required fields were included: NightTime");
      }
      if (this.sQQ == null) {
        throw new b("Not all required fields were included: AllDayTime");
      }
      paramVarArgs.gB(1, this.sQN);
      if (this.sQO != null)
      {
        paramVarArgs.gD(2, this.sQO.btq());
        this.sQO.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.sQP);
      if (this.sQQ != null)
      {
        paramVarArgs.gD(4, this.sQQ.btq());
        this.sQQ.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sQN) + 0;
      paramInt = i;
      if (this.sQO != null) {
        paramInt = i + d.a.a.a.gA(2, this.sQO.btq());
      }
      i = paramInt + d.a.a.a.gy(3, this.sQP);
      paramInt = i;
    } while (this.sQQ == null);
    return i + d.a.a.a.gA(4, this.sQQ.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sQO == null) {
        throw new b("Not all required fields were included: NightTime");
      }
      if (this.sQQ == null) {
        throw new b("Not all required fields were included: AllDayTime");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      ua localua = (ua)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localua.sQN = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ub();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ub)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localua.sQO = ((ub)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localua.sQP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ub();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ub)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localua.sQQ = ((ub)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ua
 * JD-Core Version:    0.7.0.1
 */