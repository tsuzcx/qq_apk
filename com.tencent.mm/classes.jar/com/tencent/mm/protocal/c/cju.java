package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cju
  extends com.tencent.mm.bv.a
{
  public boolean tXg;
  public boolean tXy;
  public LinkedList<cjs> thk = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.tXg);
      paramVarArgs.d(2, 8, this.thk);
      paramVarArgs.aA(3, this.tXy);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.b.b.a.dQ(1) + 1 + 0 + d.a.a.a.c(2, 8, this.thk) + (d.a.a.b.b.a.dQ(3) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.thk.clear();
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
      cju localcju = (cju)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcju.tXg = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjs();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cjs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcju.thk.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localcju.tXy = ((d.a.a.a.a)localObject1).cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cju
 * JD-Core Version:    0.7.0.1
 */