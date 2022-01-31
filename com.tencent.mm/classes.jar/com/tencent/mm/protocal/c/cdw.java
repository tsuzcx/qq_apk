package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cdw
  extends blm
{
  public int euw;
  public bmk ndi;
  public int pyo;
  public int sDT;
  public int sEE;
  public bml tEU;
  public String tQb;
  public int tQd;
  public int tSx;
  public LinkedList<bml> tSy = new LinkedList();
  public int tSz;
  
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
      if (this.ndi != null)
      {
        paramVarArgs.gD(2, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.sDT);
      if (this.tQb != null) {
        paramVarArgs.d(4, this.tQb);
      }
      paramVarArgs.gB(5, this.euw);
      paramVarArgs.gB(6, this.tQd);
      paramVarArgs.gB(7, this.sEE);
      paramVarArgs.gB(8, this.tSx);
      paramVarArgs.d(9, 8, this.tSy);
      if (this.tEU != null)
      {
        paramVarArgs.gD(10, this.tEU.btq());
        this.tEU.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.tSz);
      paramVarArgs.gB(12, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1064;
      }
    }
    label1064:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ndi != null) {
        i = paramInt + d.a.a.a.gA(2, this.ndi.btq());
      }
      i += d.a.a.a.gy(3, this.sDT);
      paramInt = i;
      if (this.tQb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tQb);
      }
      i = paramInt + d.a.a.a.gy(5, this.euw) + d.a.a.a.gy(6, this.tQd) + d.a.a.a.gy(7, this.sEE) + d.a.a.a.gy(8, this.tSx) + d.a.a.a.c(9, 8, this.tSy);
      paramInt = i;
      if (this.tEU != null) {
        paramInt = i + d.a.a.a.gA(10, this.tEU.btq());
      }
      return paramInt + d.a.a.a.gy(11, this.tSz) + d.a.a.a.gy(12, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tSy.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        cdw localcdw = (cdw)paramVarArgs[1];
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
            localcdw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdw.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcdw.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcdw.tQb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localcdw.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcdw.tQd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcdw.sEE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcdw.tSx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdw.tSy.add(localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdw.tEU = ((bml)localObject1);
            paramInt += 1;
          }
        case 11: 
          localcdw.tSz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcdw.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdw
 * JD-Core Version:    0.7.0.1
 */