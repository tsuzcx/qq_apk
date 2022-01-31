package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cer
  extends blm
{
  public long sSU;
  public LinkedList<ceq> tTE = new LinkedList();
  public long tTo;
  
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
      paramVarArgs.Y(2, this.tTo);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.d(4, 8, this.tTE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label476;
      }
    }
    label476:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.tTo) + d.a.a.a.X(3, this.sSU) + d.a.a.a.c(4, 8, this.tTE);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tTE.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        cer localcer = (cer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcer.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcer.tTo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localcer.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ceq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localcer.tTE.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cer
 * JD-Core Version:    0.7.0.1
 */