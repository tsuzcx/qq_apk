package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class fa
  extends com.tencent.mm.bv.a
{
  public bmk syJ;
  public bmk syK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syJ == null) {
        throw new b("Not all required fields were included: EncryptKey");
      }
      if (this.syK == null) {
        throw new b("Not all required fields were included: Key");
      }
      if (this.syJ != null)
      {
        paramVarArgs.gD(1, this.syJ.btq());
        this.syJ.a(paramVarArgs);
      }
      if (this.syK != null)
      {
        paramVarArgs.gD(2, this.syK.btq());
        this.syK.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.syJ == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = d.a.a.a.gA(1, this.syJ.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.syK != null) {
        i = paramInt + d.a.a.a.gA(2, this.syK.btq());
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
        if (this.syJ == null) {
          throw new b("Not all required fields were included: EncryptKey");
        }
        if (this.syK != null) {
          break;
        }
        throw new b("Not all required fields were included: Key");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        fa localfa = (fa)paramVarArgs[1];
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
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localfa.syJ = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfa.syK = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fa
 * JD-Core Version:    0.7.0.1
 */