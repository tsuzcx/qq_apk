package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class atr
  extends bly
{
  public int oqF;
  public int tcA;
  public LinkedList<atm> tcB = new LinkedList();
  public int tpu;
  public int tpv;
  public int tpw;
  
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
      paramVarArgs.gB(2, this.tcA);
      paramVarArgs.d(3, 8, this.tcB);
      paramVarArgs.gB(4, this.oqF);
      paramVarArgs.gB(5, this.tpu);
      paramVarArgs.gB(6, this.tpv);
      paramVarArgs.gB(7, this.tpw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label625;
      }
    }
    label625:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tcA) + d.a.a.a.c(3, 8, this.tcB) + d.a.a.a.gy(4, this.oqF) + d.a.a.a.gy(5, this.tpu) + d.a.a.a.gy(6, this.tpv) + d.a.a.a.gy(7, this.tpw);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tcB.clear();
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
        atr localatr = (atr)paramVarArgs[1];
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
            localatr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localatr.tcA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atm();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localatr.tcB.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localatr.oqF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localatr.tpu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localatr.tpv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localatr.tpw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atr
 * JD-Core Version:    0.7.0.1
 */