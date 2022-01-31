package com.tencent.mm.protocal.a.a;

import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bv.a
{
  public int sqM;
  public LinkedList<b> sqN = new LinkedList();
  public com.tencent.mm.bv.b sqO;
  public int sqw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sqw);
      paramVarArgs.gB(2, this.sqM);
      paramVarArgs.d(3, 8, this.sqN);
      if (this.sqO != null) {
        paramVarArgs.b(4, this.sqO);
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
      i = d.a.a.a.gy(1, this.sqw) + 0 + d.a.a.a.gy(2, this.sqM) + d.a.a.a.c(3, 8, this.sqN);
      paramInt = i;
    } while (this.sqO == null);
    return i + d.a.a.a.a(4, this.sqO);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sqN.clear();
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
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localg.sqw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localg.sqM = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localg.sqN.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localg.sqO = ((d.a.a.a.a)localObject1).cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */