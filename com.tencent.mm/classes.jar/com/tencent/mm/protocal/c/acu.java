package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class acu
  extends blm
{
  public String data;
  public String sPM;
  public int uC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sPM == null) {
        throw new b("Not all required fields were included: corp_id");
      }
      if (this.data == null) {
        throw new b("Not all required fields were included: data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sPM != null) {
        paramVarArgs.d(2, this.sPM);
      }
      paramVarArgs.gB(3, this.uC);
      if (this.data != null) {
        paramVarArgs.d(4, this.data);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sPM != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sPM);
      }
      i += d.a.a.a.gy(3, this.uC);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.data);
      }
      return paramInt;
      Object localObject1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        localObject1 = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a((d.a.a.a.a)localObject1); paramInt > 0; paramInt = blm.a((d.a.a.a.a)localObject1)) {
          if (!super.a((d.a.a.a.a)localObject1, this, paramInt)) {
            ((d.a.a.a.a)localObject1).cUt();
          }
        }
        if (this.sPM == null) {
          throw new b("Not all required fields were included: corp_id");
        }
        if (paramVarArgs != null) {
          break;
        }
        throw new b("Not all required fields were included: data");
      }
      if (paramInt == 3)
      {
        Object localObject2 = (d.a.a.a.a)paramVarArgs[0];
        localObject1 = (acu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject2).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gc();
            localObject3 = new d.a.a.a.a((byte[])localObject3, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject2).a((d.a.a.a.a)localObject3, (com.tencent.mm.bv.a)localObject2, blm.a((d.a.a.a.a)localObject3))) {}
            ((acu)localObject1).tEX = ((gc)localObject2);
            paramInt += 1;
          }
        case 2: 
          ((acu)localObject1).sPM = ((d.a.a.a.a)localObject2).xpH.readString();
          return 0;
        case 3: 
          ((acu)localObject1).uC = ((d.a.a.a.a)localObject2).xpH.oD();
          return 0;
        }
        ((acu)localObject1).data = ((d.a.a.a.a)localObject2).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.acu
 * JD-Core Version:    0.7.0.1
 */