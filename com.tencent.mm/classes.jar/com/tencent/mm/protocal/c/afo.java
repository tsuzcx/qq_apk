package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class afo
  extends bly
{
  public int tdu;
  public int tdv;
  public LinkedList<Integer> tdw = new LinkedList();
  public LinkedList<wj> tdx = new LinkedList();
  public int tdy;
  
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
      paramVarArgs.gB(2, this.tdu);
      paramVarArgs.gB(3, this.tdv);
      paramVarArgs.d(4, 2, this.tdw);
      paramVarArgs.d(5, 8, this.tdx);
      paramVarArgs.gB(6, this.tdy);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label605;
      }
    }
    label605:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tdu) + d.a.a.a.gy(3, this.tdv) + d.a.a.a.c(4, 2, this.tdw) + d.a.a.a.c(5, 8, this.tdx) + d.a.a.a.gy(6, this.tdy);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tdw.clear();
        this.tdx.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        afo localafo = (afo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        int i;
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafo.tdu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localafo.tdv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localafo.tdw.add(Integer.valueOf(((d.a.a.a.a)localObject1).xpH.oD()));
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafo.tdx.add(localObject1);
            paramInt += 1;
          }
        }
        localafo.tdy = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afo
 * JD-Core Version:    0.7.0.1
 */