package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aqk
  extends bly
{
  public String sCO;
  public bih sCU;
  public String sPN;
  public String sPO;
  public int sPP;
  public zp sPQ;
  public iv sPR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sCU == null) {
        throw new b("Not all required fields were included: qy_base_resp");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sCU != null)
      {
        paramVarArgs.gD(2, this.sCU.btq());
        this.sCU.a(paramVarArgs);
      }
      if (this.sCO != null) {
        paramVarArgs.d(3, this.sCO);
      }
      paramVarArgs.gB(4, this.sPP);
      if (this.sPQ != null)
      {
        paramVarArgs.gD(5, this.sPQ.btq());
        this.sPQ.a(paramVarArgs);
      }
      if (this.sPR != null)
      {
        paramVarArgs.gD(6, this.sPR.btq());
        this.sPR.a(paramVarArgs);
      }
      if (this.sPN != null) {
        paramVarArgs.d(7, this.sPN);
      }
      if (this.sPO != null) {
        paramVarArgs.d(8, this.sPO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label992;
      }
    }
    label992:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sCU != null) {
        paramInt = i + d.a.a.a.gA(2, this.sCU.btq());
      }
      i = paramInt;
      if (this.sCO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sCO);
      }
      i += d.a.a.a.gy(4, this.sPP);
      paramInt = i;
      if (this.sPQ != null) {
        paramInt = i + d.a.a.a.gA(5, this.sPQ.btq());
      }
      i = paramInt;
      if (this.sPR != null) {
        i = paramInt + d.a.a.a.gA(6, this.sPR.btq());
      }
      paramInt = i;
      if (this.sPN != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sPN);
      }
      i = paramInt;
      if (this.sPO != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sPO);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.sCU != null) {
          break;
        }
        throw new b("Not all required fields were included: qy_base_resp");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aqk localaqk = (aqk)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaqk.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bih();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bih)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaqk.sCU = ((bih)localObject1);
            paramInt += 1;
          }
        case 3: 
          localaqk.sCO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaqk.sPP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaqk.sPQ = ((zp)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaqk.sPR = ((iv)localObject1);
            paramInt += 1;
          }
        case 7: 
          localaqk.sPN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaqk.sPO = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqk
 * JD-Core Version:    0.7.0.1
 */