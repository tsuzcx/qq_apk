package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bku
  extends blm
{
  public com.tencent.mm.bv.b tEu;
  public int tEv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEu == null) {
        throw new d.a.a.b("Not all required fields were included: clientCheckData");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tEu != null) {
        paramVarArgs.b(2, this.tEu);
      }
      paramVarArgs.gB(3, this.tEv);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tEu != null) {
        i = paramInt + d.a.a.a.a(2, this.tEu);
      }
      return i + d.a.a.a.gy(3, this.tEv);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tEu != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: clientCheckData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bku localbku = (bku)paramVarArgs[1];
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
            localbku.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbku.tEu = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localbku.tEv = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bku
 * JD-Core Version:    0.7.0.1
 */