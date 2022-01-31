package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bpw
  extends blm
{
  public String kpQ;
  public long tHw;
  public long tHx;
  
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
      if (this.kpQ != null) {
        paramVarArgs.d(2, this.kpQ);
      }
      paramVarArgs.Y(3, this.tHw);
      paramVarArgs.Y(4, this.tHx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kpQ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kpQ);
      }
      return i + d.a.a.a.X(3, this.tHw) + d.a.a.a.X(4, this.tHx);
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
        bpw localbpw = (bpw)paramVarArgs[1];
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
            localbpw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbpw.kpQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbpw.tHw = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localbpw.tHx = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bpw
 * JD-Core Version:    0.7.0.1
 */