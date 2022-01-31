package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class clq
  extends com.tencent.mm.bv.a
{
  public String tgU;
  public bmk tgX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tgX == null) {
        throw new b("Not all required fields were included: VerifyBuff");
      }
      if (this.tgU != null) {
        paramVarArgs.d(1, this.tgU);
      }
      if (this.tgX != null)
      {
        paramVarArgs.gD(2, this.tgX.btq());
        this.tgX.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tgU == null) {
        break label360;
      }
    }
    label360:
    for (paramInt = d.a.a.b.b.a.e(1, this.tgU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tgX != null) {
        i = paramInt + d.a.a.a.gA(2, this.tgX.btq());
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
        if (this.tgX != null) {
          break;
        }
        throw new b("Not all required fields were included: VerifyBuff");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        clq localclq = (clq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localclq.tgU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localclq.tgX = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clq
 * JD-Core Version:    0.7.0.1
 */