package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class clg
  extends com.tencent.mm.bv.a
{
  public LinkedList<cle> tYy = new LinkedList();
  public boolean tYz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.tYy);
      paramVarArgs.aA(2, this.tYz);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.c(1, 8, this.tYy) + 0 + (d.a.a.b.b.a.dQ(2) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tYy.clear();
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
      clg localclg = (clg)paramVarArgs[1];
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
          localObject1 = new cle();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cle)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localclg.tYy.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localclg.tYz = ((d.a.a.a.a)localObject1).cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clg
 * JD-Core Version:    0.7.0.1
 */