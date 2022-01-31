package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ia
  extends blm
{
  public String hPY;
  public String jxi;
  public String sBm;
  public String sBn;
  public int sBo;
  public String sBp;
  public int sBq;
  public String sBr;
  public String sBs;
  public bmk sBt;
  public int sBu;
  public int sBv;
  public int sBw;
  public String sBx;
  public bmk sBy;
  public bmk sBz;
  public String syH;
  public int syV;
  public String syt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      if (this.sBm != null) {
        paramVarArgs.d(3, this.sBm);
      }
      paramVarArgs.gB(4, this.syV);
      if (this.sBn != null) {
        paramVarArgs.d(5, this.sBn);
      }
      paramVarArgs.gB(6, this.sBo);
      if (this.sBp != null) {
        paramVarArgs.d(7, this.sBp);
      }
      if (this.syt != null) {
        paramVarArgs.d(8, this.syt);
      }
      paramVarArgs.gB(9, this.sBq);
      if (this.sBr != null) {
        paramVarArgs.d(10, this.sBr);
      }
      if (this.sBs != null) {
        paramVarArgs.d(11, this.sBs);
      }
      if (this.sBt != null)
      {
        paramVarArgs.gD(12, this.sBt.btq());
        this.sBt.a(paramVarArgs);
      }
      if (this.jxi != null) {
        paramVarArgs.d(13, this.jxi);
      }
      paramVarArgs.gB(14, this.sBu);
      paramVarArgs.gB(15, this.sBv);
      if (this.syH != null) {
        paramVarArgs.d(16, this.syH);
      }
      paramVarArgs.gB(17, this.sBw);
      if (this.sBx != null) {
        paramVarArgs.d(18, this.sBx);
      }
      if (this.sBy != null)
      {
        paramVarArgs.gD(19, this.sBy.btq());
        this.sBy.a(paramVarArgs);
      }
      if (this.sBz != null)
      {
        paramVarArgs.gD(20, this.sBz.btq());
        this.sBz.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1524;
      }
    }
    label1524:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.sBm != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sBm);
      }
      i += d.a.a.a.gy(4, this.syV);
      paramInt = i;
      if (this.sBn != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sBn);
      }
      i = paramInt + d.a.a.a.gy(6, this.sBo);
      paramInt = i;
      if (this.sBp != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sBp);
      }
      i = paramInt;
      if (this.syt != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.syt);
      }
      i += d.a.a.a.gy(9, this.sBq);
      paramInt = i;
      if (this.sBr != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sBr);
      }
      i = paramInt;
      if (this.sBs != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sBs);
      }
      paramInt = i;
      if (this.sBt != null) {
        paramInt = i + d.a.a.a.gA(12, this.sBt.btq());
      }
      i = paramInt;
      if (this.jxi != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.jxi);
      }
      i = i + d.a.a.a.gy(14, this.sBu) + d.a.a.a.gy(15, this.sBv);
      paramInt = i;
      if (this.syH != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.syH);
      }
      i = paramInt + d.a.a.a.gy(17, this.sBw);
      paramInt = i;
      if (this.sBx != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.sBx);
      }
      i = paramInt;
      if (this.sBy != null) {
        i = paramInt + d.a.a.a.gA(19, this.sBy.btq());
      }
      paramInt = i;
      if (this.sBz != null) {
        paramInt = i + d.a.a.a.gA(20, this.sBz.btq());
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ia localia = (ia)paramVarArgs[1];
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
            localia.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localia.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localia.sBm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localia.syV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localia.sBn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localia.sBo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localia.sBp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localia.syt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localia.sBq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localia.sBr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localia.sBs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localia.sBt = ((bmk)localObject1);
            paramInt += 1;
          }
        case 13: 
          localia.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localia.sBu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localia.sBv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localia.syH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localia.sBw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localia.sBx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localia.sBy = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localia.sBz = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ia
 * JD-Core Version:    0.7.0.1
 */