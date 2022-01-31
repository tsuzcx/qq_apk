package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aqj
  extends blm
{
  public String sPM;
  public String tmq;
  public LinkedList<String> tmr = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sPM == null) {
        throw new b("Not all required fields were included: corp_id");
      }
      if (this.tmq == null) {
        throw new b("Not all required fields were included: bizchat_name");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sPM != null) {
        paramVarArgs.d(2, this.sPM);
      }
      if (this.tmq != null) {
        paramVarArgs.d(3, this.tmq);
      }
      paramVarArgs.d(4, 1, this.tmr);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label502;
      }
    }
    label502:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sPM != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sPM);
      }
      i = paramInt;
      if (this.tmq != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tmq);
      }
      return i + d.a.a.a.c(4, 1, this.tmr);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tmr.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sPM == null) {
          throw new b("Not all required fields were included: corp_id");
        }
        if (this.tmq != null) {
          break;
        }
        throw new b("Not all required fields were included: bizchat_name");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aqj localaqj = (aqj)paramVarArgs[1];
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
            localaqj.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaqj.sPM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaqj.tmq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaqj.tmr.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqj
 * JD-Core Version:    0.7.0.1
 */