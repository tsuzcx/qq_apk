package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cn
  extends com.tencent.mm.bv.a
{
  public bss svY;
  public bml svZ;
  public int swa;
  public bkk swb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svY == null) {
        throw new b("Not all required fields were included: SnsADObject");
      }
      if (this.svY != null)
      {
        paramVarArgs.gD(1, this.svY.btq());
        this.svY.a(paramVarArgs);
      }
      if (this.svZ != null)
      {
        paramVarArgs.gD(2, this.svZ.btq());
        this.svZ.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.swa);
      if (this.swb != null)
      {
        paramVarArgs.gD(4, this.swb.btq());
        this.swb.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.svY == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = d.a.a.a.gA(1, this.svY.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.svZ != null) {
        i = paramInt + d.a.a.a.gA(2, this.svZ.btq());
      }
      i += d.a.a.a.gy(3, this.swa);
      paramInt = i;
      if (this.swb != null) {
        paramInt = i + d.a.a.a.gA(4, this.swb.btq());
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
        if (this.svY != null) {
          break;
        }
        throw new b("Not all required fields were included: SnsADObject");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cn localcn = (cn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bss();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bss)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcn.svY = ((bss)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcn.svZ = ((bml)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcn.swa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcn.swb = ((bkk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cn
 * JD-Core Version:    0.7.0.1
 */