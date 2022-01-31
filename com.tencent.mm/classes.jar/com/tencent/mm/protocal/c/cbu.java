package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbu
  extends blm
{
  public int euw;
  public String kWm;
  public String kWn;
  public bmk ndi;
  public int ndm;
  public long ndp;
  public int sDT;
  public int sRM;
  public int sRd;
  public int sRf;
  public int sRg;
  public String svK;
  public String swQ;
  public int tQU;
  public int tQV;
  public int trH;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.kWn != null) {
        paramVarArgs.d(1, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(2, this.kWm);
      }
      paramVarArgs.gB(3, this.sDT);
      paramVarArgs.gB(4, this.sRd);
      if (this.swQ != null) {
        paramVarArgs.d(5, this.swQ);
      }
      paramVarArgs.gB(6, this.ndm);
      paramVarArgs.gB(7, this.sRf);
      if (this.ndi != null)
      {
        paramVarArgs.gD(8, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.euw);
      if (this.tEX != null)
      {
        paramVarArgs.gD(10, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.sRg);
      if (this.svK != null) {
        paramVarArgs.d(12, this.svK);
      }
      paramVarArgs.gB(13, this.trH);
      paramVarArgs.gB(14, this.tQU);
      paramVarArgs.gB(15, this.tQV);
      paramVarArgs.Y(16, this.ndp);
      paramVarArgs.gB(17, this.sRM);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWn == null) {
        break label1111;
      }
    }
    label1111:
    for (paramInt = d.a.a.b.b.a.e(1, this.kWn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kWm);
      }
      i = i + d.a.a.a.gy(3, this.sDT) + d.a.a.a.gy(4, this.sRd);
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.swQ);
      }
      i = paramInt + d.a.a.a.gy(6, this.ndm) + d.a.a.a.gy(7, this.sRf);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(8, this.ndi.btq());
      }
      i = paramInt + d.a.a.a.gy(9, this.euw);
      paramInt = i;
      if (this.tEX != null) {
        paramInt = i + d.a.a.a.gA(10, this.tEX.btq());
      }
      i = paramInt + d.a.a.a.gy(11, this.sRg);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.svK);
      }
      return paramInt + d.a.a.a.gy(13, this.trH) + d.a.a.a.gy(14, this.tQU) + d.a.a.a.gy(15, this.tQV) + d.a.a.a.X(16, this.ndp) + d.a.a.a.gy(17, this.sRM);
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
        cbu localcbu = (cbu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcbu.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localcbu.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcbu.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcbu.sRd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcbu.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localcbu.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcbu.sRf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbu.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 9: 
          localcbu.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbu.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 11: 
          localcbu.sRg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localcbu.svK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localcbu.trH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localcbu.tQU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localcbu.tQV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localcbu.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localcbu.sRM = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbu
 * JD-Core Version:    0.7.0.1
 */