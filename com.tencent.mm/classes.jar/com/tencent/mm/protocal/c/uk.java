package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class uk
  extends bly
{
  public int euw;
  public bmk ndi;
  public int ndm;
  public long ndp;
  public int sDT;
  public int sRd;
  public int sRf;
  public int sRg;
  public String swQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      paramVarArgs.gB(1, this.ndm);
      paramVarArgs.gB(2, this.sDT);
      paramVarArgs.gB(3, this.sRd);
      paramVarArgs.gB(5, this.sRf);
      if (this.swQ != null) {
        paramVarArgs.d(6, this.swQ);
      }
      if (this.ndi != null)
      {
        paramVarArgs.gD(7, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.euw);
      if (this.tFx != null)
      {
        paramVarArgs.gD(9, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(10, this.sRg);
      paramVarArgs.Y(11, this.ndp);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.ndm) + 0 + d.a.a.a.gy(2, this.sDT) + d.a.a.a.gy(3, this.sRd) + d.a.a.a.gy(5, this.sRf);
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.swQ);
      }
      i = paramInt;
      if (this.ndi != null) {
        i = paramInt + d.a.a.a.gA(7, this.ndi.btq());
      }
      i += d.a.a.a.gy(8, this.euw);
      paramInt = i;
      if (this.tFx != null) {
        paramInt = i + d.a.a.a.gA(9, this.tFx.btq());
      }
      return paramInt + d.a.a.a.gy(10, this.sRg) + d.a.a.a.X(11, this.ndp);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      uk localuk = (uk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 4: 
      default: 
        return -1;
      case 1: 
        localuk.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localuk.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localuk.sRd = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localuk.sRf = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localuk.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localuk.ndi = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        localuk.euw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localuk.tFx = ((gd)localObject1);
          paramInt += 1;
        }
        return 0;
      case 10: 
        localuk.sRg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localuk.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.uk
 * JD-Core Version:    0.7.0.1
 */