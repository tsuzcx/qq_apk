package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class acx
  extends com.tencent.mm.bv.a
  implements bsi
{
  public int sze;
  public int tbA;
  public LinkedList<bml> tbB = new LinkedList();
  public int tby;
  public int tbz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sze);
      paramVarArgs.gB(2, this.tby);
      paramVarArgs.gB(3, this.tbz);
      paramVarArgs.gB(4, this.tbA);
      paramVarArgs.d(5, 8, this.tbB);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sze) + 0 + d.a.a.a.gy(2, this.tby) + d.a.a.a.gy(3, this.tbz) + d.a.a.a.gy(4, this.tbA) + d.a.a.a.c(5, 8, this.tbB);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tbB.clear();
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
      acx localacx = (acx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localacx.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localacx.tby = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localacx.tbz = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localacx.tbA = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bml();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localacx.tbB.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
  
  public final int getRet()
  {
    return this.sze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.acx
 * JD-Core Version:    0.7.0.1
 */