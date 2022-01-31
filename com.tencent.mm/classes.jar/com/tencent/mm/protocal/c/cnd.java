package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cnd
  extends com.tencent.mm.bv.a
{
  public cmy tZH;
  public String tZU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tZH != null)
      {
        paramVarArgs.gD(1, this.tZH.btq());
        this.tZH.a(paramVarArgs);
      }
      if (this.tZU != null) {
        paramVarArgs.d(2, this.tZU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tZH == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = d.a.a.a.gA(1, this.tZH.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tZU != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tZU);
      }
      return i;
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
        cnd localcnd = (cnd)paramVarArgs[1];
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
            localObject1 = new cmy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcnd.tZH = ((cmy)localObject1);
            paramInt += 1;
          }
        }
        localcnd.tZU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnd
 * JD-Core Version:    0.7.0.1
 */