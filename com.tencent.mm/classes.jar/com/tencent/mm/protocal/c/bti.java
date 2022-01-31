package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bti
  extends bly
{
  public int hQR;
  public int ndf;
  public int ndg;
  public bmk szp;
  public String tJQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.szp == null) {
        throw new b("Not all required fields were included: Buffer");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ndg);
      paramVarArgs.gB(3, this.ndf);
      if (this.szp != null)
      {
        paramVarArgs.gD(4, this.szp.btq());
        this.szp.a(paramVarArgs);
      }
      if (this.tJQ != null) {
        paramVarArgs.d(5, this.tJQ);
      }
      paramVarArgs.gB(6, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf);
      paramInt = i;
      if (this.szp != null) {
        paramInt = i + d.a.a.a.gA(4, this.szp.btq());
      }
      i = paramInt;
      if (this.tJQ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tJQ);
      }
      return i + d.a.a.a.gy(6, this.hQR);
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
        if (this.szp != null) {
          break;
        }
        throw new b("Not all required fields were included: Buffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bti localbti = (bti)paramVarArgs[1];
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
            localbti.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbti.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbti.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localbti.szp = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbti.tJQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbti.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bti
 * JD-Core Version:    0.7.0.1
 */