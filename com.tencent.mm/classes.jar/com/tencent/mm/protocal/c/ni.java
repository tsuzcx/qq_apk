package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ni
  extends blm
{
  public int amount;
  public String bOT;
  public String sKU;
  public String sKV;
  public String sKX;
  public String swd;
  
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
      if (this.bOT != null) {
        paramVarArgs.d(2, this.bOT);
      }
      if (this.sKX != null) {
        paramVarArgs.d(3, this.sKX);
      }
      if (this.swd != null) {
        paramVarArgs.d(4, this.swd);
      }
      paramVarArgs.gB(5, this.amount);
      if (this.sKV != null) {
        paramVarArgs.d(6, this.sKV);
      }
      if (this.sKU != null) {
        paramVarArgs.d(7, this.sKU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label591;
      }
    }
    label591:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bOT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bOT);
      }
      i = paramInt;
      if (this.sKX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sKX);
      }
      paramInt = i;
      if (this.swd != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.swd);
      }
      i = paramInt + d.a.a.a.gy(5, this.amount);
      paramInt = i;
      if (this.sKV != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sKV);
      }
      i = paramInt;
      if (this.sKU != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sKU);
      }
      return i;
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
        ni localni = (ni)paramVarArgs[1];
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
            localni.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localni.bOT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localni.sKX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localni.swd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localni.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localni.sKV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localni.sKU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ni
 * JD-Core Version:    0.7.0.1
 */