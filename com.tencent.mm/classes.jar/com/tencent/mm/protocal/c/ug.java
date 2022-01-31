package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ug
  extends bly
{
  public String euK;
  public String euN;
  public String hPY;
  public int ndf;
  public int ndg;
  public int ndh;
  public bmk ndi;
  
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
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.euN != null) {
        paramVarArgs.d(3, this.euN);
      }
      if (this.hPY != null) {
        paramVarArgs.d(4, this.hPY);
      }
      paramVarArgs.gB(5, this.ndf);
      paramVarArgs.gB(6, this.ndg);
      paramVarArgs.gB(7, this.ndh);
      if (this.ndi != null)
      {
        paramVarArgs.gD(8, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label772;
      }
    }
    label772:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.euN != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.euN);
      }
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.hPY);
      }
      i = paramInt + d.a.a.a.gy(5, this.ndf) + d.a.a.a.gy(6, this.ndg) + d.a.a.a.gy(7, this.ndh);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(8, this.ndi.btq());
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
        ug localug = (ug)paramVarArgs[1];
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
            localug.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localug.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localug.euN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localug.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localug.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localug.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localug.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localug.ndi = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ug
 * JD-Core Version:    0.7.0.1
 */