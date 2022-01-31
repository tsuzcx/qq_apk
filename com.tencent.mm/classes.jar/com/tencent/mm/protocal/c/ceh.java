package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ceh
  extends blm
{
  public long sSU;
  public int sZO;
  public long tAB;
  public int tAC;
  public long tTo;
  public String tTp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tAC);
      paramVarArgs.Y(3, this.tTo);
      paramVarArgs.Y(4, this.sSU);
      if (this.tTp != null) {
        paramVarArgs.d(5, this.tTp);
      }
      paramVarArgs.Y(6, this.tAB);
      paramVarArgs.gB(7, this.sZO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label519;
      }
    }
    label519:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tAC) + d.a.a.a.X(3, this.tTo) + d.a.a.a.X(4, this.sSU);
      paramInt = i;
      if (this.tTp != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tTp);
      }
      return paramInt + d.a.a.a.X(6, this.tAB) + d.a.a.a.gy(7, this.sZO);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ceh localceh = (ceh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localceh.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localceh.tAC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localceh.tTo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localceh.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localceh.tTp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localceh.tAB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localceh.sZO = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ceh
 * JD-Core Version:    0.7.0.1
 */