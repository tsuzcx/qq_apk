package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cgc
  extends bly
{
  public int sFD;
  public bmk sIi;
  public int sST;
  public long sSU;
  public cey tVm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sIi == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      if (this.tVm == null) {
        throw new b("Not all required fields were included: CmdList");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.sST);
      if (this.sIi != null)
      {
        paramVarArgs.gD(4, this.sIi.btq());
        this.sIi.a(paramVarArgs);
      }
      if (this.tVm != null)
      {
        paramVarArgs.gD(5, this.tVm.btq());
        this.tVm.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.sFD);
      paramVarArgs.Y(8, this.sSU);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label792;
      }
    }
    label792:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(3, this.sST);
      paramInt = i;
      if (this.sIi != null) {
        paramInt = i + d.a.a.a.gA(4, this.sIi.btq());
      }
      i = paramInt;
      if (this.tVm != null) {
        i = paramInt + d.a.a.a.gA(5, this.tVm.btq());
      }
      return i + d.a.a.a.gy(7, this.sFD) + d.a.a.a.X(8, this.sSU);
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
        if (this.sIi == null) {
          throw new b("Not all required fields were included: KeyBuf");
        }
        if (this.tVm != null) {
          break;
        }
        throw new b("Not all required fields were included: CmdList");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cgc localcgc = (cgc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 6: 
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
            localcgc.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcgc.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcgc.sIi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cey();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cey)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcgc.tVm = ((cey)localObject1);
            paramInt += 1;
          }
        case 7: 
          localcgc.sFD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcgc.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgc
 * JD-Core Version:    0.7.0.1
 */