package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bud
  extends com.tencent.mm.bv.a
{
  public int tFj;
  public int tKO;
  public LinkedList<btk> tKP = new LinkedList();
  public int tKQ;
  public int tKR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tKO);
      paramVarArgs.d(2, 8, this.tKP);
      paramVarArgs.gB(3, this.tKQ);
      paramVarArgs.gB(4, this.tFj);
      paramVarArgs.gB(5, this.tKR);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tKO) + 0 + d.a.a.a.c(2, 8, this.tKP) + d.a.a.a.gy(3, this.tKQ) + d.a.a.a.gy(4, this.tFj) + d.a.a.a.gy(5, this.tKR);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tKP.clear();
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
      bud localbud = (bud)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbud.tKO = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((btk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbud.tKP.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localbud.tKQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localbud.tFj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localbud.tKR = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bud
 * JD-Core Version:    0.7.0.1
 */