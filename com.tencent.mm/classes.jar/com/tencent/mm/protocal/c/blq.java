package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class blq
  extends bly
{
  public String lRA;
  public int tFf;
  public int tFg;
  public String txI;
  public String txv;
  public int txx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.lRA != null) {
        paramVarArgs.d(2, this.lRA);
      }
      if (this.txv != null) {
        paramVarArgs.d(3, this.txv);
      }
      paramVarArgs.gB(4, this.tFf);
      paramVarArgs.gB(5, this.tFg);
      paramVarArgs.gB(6, this.txx);
      if (this.txI != null) {
        paramVarArgs.d(7, this.txI);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label587;
      }
    }
    label587:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lRA != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.lRA);
      }
      i = paramInt;
      if (this.txv != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.txv);
      }
      i = i + d.a.a.a.gy(4, this.tFf) + d.a.a.a.gy(5, this.tFg) + d.a.a.a.gy(6, this.txx);
      paramInt = i;
      if (this.txI != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.txI);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        blq localblq = (blq)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localblq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localblq.lRA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localblq.txv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localblq.tFf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localblq.tFg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localblq.txx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localblq.txI = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blq
 * JD-Core Version:    0.7.0.1
 */