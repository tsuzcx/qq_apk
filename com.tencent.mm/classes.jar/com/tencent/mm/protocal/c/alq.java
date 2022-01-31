package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class alq
  extends blm
{
  public String bOL;
  public int source;
  public boolean thE;
  public LinkedList<String> thF = new LinkedList();
  
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
      if (this.bOL != null) {
        paramVarArgs.d(2, this.bOL);
      }
      paramVarArgs.aA(3, this.thE);
      paramVarArgs.d(4, 1, this.thF);
      paramVarArgs.gB(5, this.source);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bOL);
      }
      return i + (d.a.a.b.b.a.dQ(3) + 1) + d.a.a.a.c(4, 1, this.thF) + d.a.a.a.gy(5, this.source);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thF.clear();
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
        alq localalq = (alq)paramVarArgs[1];
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
            localalq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localalq.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localalq.thE = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 4: 
          localalq.thF.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        }
        localalq.source = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.alq
 * JD-Core Version:    0.7.0.1
 */