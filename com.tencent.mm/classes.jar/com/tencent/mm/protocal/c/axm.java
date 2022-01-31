package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class axm
  extends com.tencent.mm.bv.a
{
  public aop sBc;
  public aoq sBd;
  public int ttS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sBc == null) {
        throw new b("Not all required fields were included: HardDevice");
      }
      if (this.sBd == null) {
        throw new b("Not all required fields were included: HardDeviceAttr");
      }
      if (this.sBc != null)
      {
        paramVarArgs.gD(1, this.sBc.btq());
        this.sBc.a(paramVarArgs);
      }
      if (this.sBd != null)
      {
        paramVarArgs.gD(2, this.sBd.btq());
        this.sBd.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.ttS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sBc == null) {
        break label525;
      }
    }
    label525:
    for (paramInt = d.a.a.a.gA(1, this.sBc.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sBd != null) {
        i = paramInt + d.a.a.a.gA(2, this.sBd.btq());
      }
      return i + d.a.a.a.gy(3, this.ttS);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sBc == null) {
          throw new b("Not all required fields were included: HardDevice");
        }
        if (this.sBd != null) {
          break;
        }
        throw new b("Not all required fields were included: HardDeviceAttr");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        axm localaxm = (axm)paramVarArgs[1];
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
            localObject1 = new aop();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aop)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaxm.sBc = ((aop)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaxm.sBd = ((aoq)localObject1);
            paramInt += 1;
          }
        }
        localaxm.ttS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axm
 * JD-Core Version:    0.7.0.1
 */