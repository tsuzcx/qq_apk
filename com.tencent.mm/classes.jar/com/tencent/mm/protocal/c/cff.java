package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cff
  extends blm
{
  public int sSK;
  public int sST;
  public long sSU;
  public long tSJ;
  public int tTQ;
  
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
      paramVarArgs.gB(2, this.sST);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.gB(4, this.sSK);
      paramVarArgs.Y(5, this.tSJ);
      paramVarArgs.gB(6, this.tTQ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label460;
      }
    }
    label460:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.X(3, this.sSU) + d.a.a.a.gy(4, this.sSK) + d.a.a.a.X(5, this.tSJ) + d.a.a.a.gy(6, this.tTQ);
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
        cff localcff = (cff)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcff.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcff.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcff.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localcff.sSK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcff.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localcff.tTQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cff
 * JD-Core Version:    0.7.0.1
 */