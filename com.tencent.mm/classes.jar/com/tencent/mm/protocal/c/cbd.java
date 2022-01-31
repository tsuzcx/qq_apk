package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbd
  extends blm
{
  public int kVG;
  public int ndf;
  public int ndg;
  public int ndh;
  public bmk ndi;
  public bml tQi;
  public bml tQj;
  public int tQk;
  public int tQl;
  public int tQm;
  public int tQn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tQi == null) {
        throw new b("Not all required fields were included: ClientMediaId");
      }
      if (this.tQj == null) {
        throw new b("Not all required fields were included: DataMD5");
      }
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tQi != null)
      {
        paramVarArgs.gD(2, this.tQi.btq());
        this.tQi.a(paramVarArgs);
      }
      if (this.tQj != null)
      {
        paramVarArgs.gD(3, this.tQj.btq());
        this.tQj.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.ndf);
      paramVarArgs.gB(5, this.ndg);
      paramVarArgs.gB(6, this.ndh);
      if (this.ndi != null)
      {
        paramVarArgs.gD(7, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.kVG);
      paramVarArgs.gB(9, this.tQk);
      paramVarArgs.gB(10, this.tQl);
      paramVarArgs.gB(11, this.tQm);
      paramVarArgs.gB(12, this.tQn);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1128;
      }
    }
    label1128:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tQi != null) {
        paramInt = i + d.a.a.a.gA(2, this.tQi.btq());
      }
      i = paramInt;
      if (this.tQj != null) {
        i = paramInt + d.a.a.a.gA(3, this.tQj.btq());
      }
      i = i + d.a.a.a.gy(4, this.ndf) + d.a.a.a.gy(5, this.ndg) + d.a.a.a.gy(6, this.ndh);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(7, this.ndi.btq());
      }
      return paramInt + d.a.a.a.gy(8, this.kVG) + d.a.a.a.gy(9, this.tQk) + d.a.a.a.gy(10, this.tQl) + d.a.a.a.gy(11, this.tQm) + d.a.a.a.gy(12, this.tQn);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tQi == null) {
          throw new b("Not all required fields were included: ClientMediaId");
        }
        if (this.tQj == null) {
          throw new b("Not all required fields were included: DataMD5");
        }
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cbd localcbd = (cbd)paramVarArgs[1];
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
            localcbd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbd.tQi = ((bml)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbd.tQj = ((bml)localObject1);
            paramInt += 1;
          }
        case 4: 
          localcbd.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcbd.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcbd.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
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
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbd.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 8: 
          localcbd.kVG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcbd.tQk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcbd.tQl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localcbd.tQm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcbd.tQn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbd
 * JD-Core Version:    0.7.0.1
 */