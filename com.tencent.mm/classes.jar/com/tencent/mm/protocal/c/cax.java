package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cax
  extends blm
{
  public String hPY;
  public int ndf;
  public int ndg;
  public bmk ndi;
  public String tPZ;
  public int tdY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ndf);
      paramVarArgs.gB(3, this.ndg);
      paramVarArgs.gB(4, this.tdY);
      if (this.ndi != null)
      {
        paramVarArgs.gD(5, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      if (this.tPZ != null) {
        paramVarArgs.d(6, this.tPZ);
      }
      if (this.hPY != null) {
        paramVarArgs.d(7, this.hPY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label681;
      }
    }
    label681:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndf) + d.a.a.a.gy(3, this.ndg) + d.a.a.a.gy(4, this.tdY);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(5, this.ndi.btq());
      }
      i = paramInt;
      if (this.tPZ != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tPZ);
      }
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.hPY);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cax localcax = (cax)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcax.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcax.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcax.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcax.tdY = ((d.a.a.a.a)localObject1).xpH.oD();
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
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcax.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 6: 
          localcax.tPZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcax.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cax
 * JD-Core Version:    0.7.0.1
 */