package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class vp
  extends com.tencent.mm.bv.a
{
  public vq sSQ;
  public vo sSR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sSQ == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.sSR == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      if (this.sSQ != null)
      {
        paramVarArgs.gD(1, this.sSQ.btq());
        this.sSQ.a(paramVarArgs);
      }
      if (this.sSR != null)
      {
        paramVarArgs.gD(2, this.sSR.btq());
        this.sSR.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sSQ == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = d.a.a.a.gA(1, this.sSQ.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sSR != null) {
        i = paramInt + d.a.a.a.gA(2, this.sSR.btq());
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
        if (this.sSQ == null) {
          throw new b("Not all required fields were included: RsaReqData");
        }
        if (this.sSR != null) {
          break;
        }
        throw new b("Not all required fields were included: AesReqData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        vp localvp = (vp)paramVarArgs[1];
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
            localObject1 = new vq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localvp.sSQ = ((vq)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localvp.sSR = ((vo)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vp
 * JD-Core Version:    0.7.0.1
 */