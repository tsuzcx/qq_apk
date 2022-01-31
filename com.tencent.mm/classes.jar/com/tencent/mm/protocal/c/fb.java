package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class fb
  extends com.tencent.mm.bv.a
{
  public fc syL;
  public ez syM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syL == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.syM == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      if (this.syL != null)
      {
        paramVarArgs.gD(1, this.syL.btq());
        this.syL.a(paramVarArgs);
      }
      if (this.syM != null)
      {
        paramVarArgs.gD(2, this.syM.btq());
        this.syM.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.syL == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = d.a.a.a.gA(1, this.syL.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.syM != null) {
        i = paramInt + d.a.a.a.gA(2, this.syM.btq());
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
        if (this.syL == null) {
          throw new b("Not all required fields were included: RsaReqData");
        }
        if (this.syM != null) {
          break;
        }
        throw new b("Not all required fields were included: AesReqData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        fb localfb = (fb)paramVarArgs[1];
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
            localObject1 = new fc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localfb.syL = ((fc)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ez();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ez)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfb.syM = ((ez)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fb
 * JD-Core Version:    0.7.0.1
 */