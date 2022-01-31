package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cia
  extends com.tencent.mm.bv.a
{
  public String tWB;
  public li tWC;
  public boolean tWD;
  public String tWE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tWB != null) {
        paramVarArgs.d(1, this.tWB);
      }
      if (this.tWC != null)
      {
        paramVarArgs.gD(2, this.tWC.btq());
        this.tWC.a(paramVarArgs);
      }
      paramVarArgs.aA(3, this.tWD);
      if (this.tWE != null) {
        paramVarArgs.d(4, this.tWE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tWB == null) {
        break label415;
      }
    }
    label415:
    for (paramInt = d.a.a.b.b.a.e(1, this.tWB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tWC != null) {
        i = paramInt + d.a.a.a.gA(2, this.tWC.btq());
      }
      i += d.a.a.b.b.a.dQ(3) + 1;
      paramInt = i;
      if (this.tWE != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tWE);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cia localcia = (cia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcia.tWB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new li();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((li)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcia.tWC = ((li)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcia.tWD = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localcia.tWE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cia
 * JD-Core Version:    0.7.0.1
 */