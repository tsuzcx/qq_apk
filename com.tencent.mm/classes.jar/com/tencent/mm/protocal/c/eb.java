package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class eb
  extends com.tencent.mm.bv.a
{
  public int sxB;
  public int sxC;
  public int sxJ;
  public ec sxK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sxB);
      paramVarArgs.gB(2, this.sxC);
      paramVarArgs.gB(3, this.sxJ);
      if (this.sxK != null)
      {
        paramVarArgs.gD(4, this.sxK.btq());
        this.sxK.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.sxB) + 0 + d.a.a.a.gy(2, this.sxC) + d.a.a.a.gy(3, this.sxJ);
      paramInt = i;
    } while (this.sxK == null);
    return i + d.a.a.a.gA(4, this.sxK.btq());
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
      eb localeb = (eb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localeb.sxB = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localeb.sxC = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localeb.sxJ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ec();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ec)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localeb.sxK = ((ec)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.eb
 * JD-Core Version:    0.7.0.1
 */