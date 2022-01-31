package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ui
  extends bly
{
  public int ndf;
  public int ndg;
  public bmk ndi;
  public int ndm;
  public long ndp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ndm);
      paramVarArgs.gB(3, this.ndf);
      paramVarArgs.gB(4, this.ndg);
      if (this.ndi != null)
      {
        paramVarArgs.gD(5, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.ndp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndm) + d.a.a.a.gy(3, this.ndf) + d.a.a.a.gy(4, this.ndg);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(5, this.ndi.btq());
      }
      return paramInt + d.a.a.a.X(6, this.ndp);
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
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ui localui = (ui)paramVarArgs[1];
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
            localui.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localui.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localui.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localui.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localui.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        localui.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ui
 * JD-Core Version:    0.7.0.1
 */