package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ckt
  extends com.tencent.mm.bv.a
{
  public long tYa;
  public jr tYb;
  public int tYc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.tYa);
      if (this.tYb != null)
      {
        paramVarArgs.gD(2, this.tYb.btq());
        this.tYb.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tYc);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.X(1, this.tYa) + 0;
      paramInt = i;
      if (this.tYb != null) {
        paramInt = i + d.a.a.a.gA(2, this.tYb.btq());
      }
      return paramInt + d.a.a.a.gy(3, this.tYc);
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
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      ckt localckt = (ckt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localckt.tYa = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jr();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((jr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckt.tYb = ((jr)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localckt.tYc = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckt
 * JD-Core Version:    0.7.0.1
 */