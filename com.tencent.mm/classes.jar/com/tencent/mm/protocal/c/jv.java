package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class jv
  extends com.tencent.mm.bv.a
{
  public int sEC;
  public int sED;
  public int sEE;
  public LinkedList<ju> sEF = new LinkedList();
  public LinkedList<ju> sEG = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sEC);
      paramVarArgs.gB(2, this.sED);
      paramVarArgs.gB(5, this.sEE);
      paramVarArgs.d(3, 8, this.sEF);
      paramVarArgs.d(4, 8, this.sEG);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sEC) + 0 + d.a.a.a.gy(2, this.sED) + d.a.a.a.gy(5, this.sEE) + d.a.a.a.c(3, 8, this.sEF) + d.a.a.a.c(4, 8, this.sEG);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sEF.clear();
      this.sEG.clear();
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
      jv localjv = (jv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localjv.sEC = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localjv.sED = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localjv.sEE = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ju();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ju)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localjv.sEF.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ju();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ju)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localjv.sEG.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jv
 * JD-Core Version:    0.7.0.1
 */