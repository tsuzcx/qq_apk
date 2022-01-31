package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class fc
  extends com.tencent.mm.bv.a
{
  public bmk syN;
  public uq syO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syN == null) {
        throw new b("Not all required fields were included: AesEncryptKey");
      }
      if (this.syN != null)
      {
        paramVarArgs.gD(2, this.syN.btq());
        this.syN.a(paramVarArgs);
      }
      if (this.syO != null)
      {
        paramVarArgs.gD(3, this.syO.btq());
        this.syO.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.syN == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = d.a.a.a.gA(2, this.syN.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.syO != null) {
        i = paramInt + d.a.a.a.gA(3, this.syO.btq());
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
        if (this.syN != null) {
          break;
        }
        throw new b("Not all required fields were included: AesEncryptKey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        fc localfc = (fc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localfc.syN = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfc.syO = ((uq)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fc
 * JD-Core Version:    0.7.0.1
 */