package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class mx
  extends blm
{
  public int amount;
  public String iHQ;
  public b sKA;
  public int sKB;
  public b sKz;
  
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
      paramVarArgs.gB(2, this.amount);
      if (this.sKz != null) {
        paramVarArgs.b(3, this.sKz);
      }
      if (this.sKA != null) {
        paramVarArgs.b(4, this.sKA);
      }
      if (this.iHQ != null) {
        paramVarArgs.d(5, this.iHQ);
      }
      paramVarArgs.gB(6, this.sKB);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.amount);
      paramInt = i;
      if (this.sKz != null) {
        paramInt = i + d.a.a.a.a(3, this.sKz);
      }
      i = paramInt;
      if (this.sKA != null) {
        i = paramInt + d.a.a.a.a(4, this.sKA);
      }
      paramInt = i;
      if (this.iHQ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.iHQ);
      }
      return paramInt + d.a.a.a.gy(6, this.sKB);
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
        mx localmx = (mx)paramVarArgs[1];
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
            localmx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localmx.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localmx.sKz = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 4: 
          localmx.sKA = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 5: 
          localmx.iHQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localmx.sKB = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mx
 * JD-Core Version:    0.7.0.1
 */