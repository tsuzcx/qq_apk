package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bvy
  extends com.tencent.mm.bv.a
{
  public int tMK;
  public int tML;
  public LinkedList<aze> tMM = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tMK);
      paramVarArgs.gB(2, this.tML);
      paramVarArgs.d(3, 8, this.tMM);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tMK) + 0 + d.a.a.a.gy(2, this.tML) + d.a.a.a.c(3, 8, this.tMM);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tMM.clear();
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
      bvy localbvy = (bvy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbvy.tMK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbvy.tML = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aze();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aze)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localbvy.tMM.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvy
 * JD-Core Version:    0.7.0.1
 */