package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class acq
  extends blm
{
  public String sCO;
  public int tbs;
  public int tbt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sCO == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sCO != null) {
        paramVarArgs.d(2, this.sCO);
      }
      paramVarArgs.gB(3, this.tbs);
      paramVarArgs.gB(4, this.tbt);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sCO != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sCO);
      }
      return i + d.a.a.a.gy(3, this.tbs) + d.a.a.a.gy(4, this.tbt);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sCO != null) {
          break;
        }
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        acq localacq = (acq)paramVarArgs[1];
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
            localacq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localacq.sCO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localacq.tbs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localacq.tbt = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.acq
 * JD-Core Version:    0.7.0.1
 */