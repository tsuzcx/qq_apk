package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bhm
  extends bly
{
  public int balance;
  public int cdr;
  public int ino;
  public String inp;
  public int sOy;
  public String tBT;
  public String tBU;
  public String tBV;
  public String tBW;
  public int tBX;
  public LinkedList<uc> tBY = new LinkedList();
  public int tBZ;
  public String tBg;
  public String tBi;
  public LinkedList<uc> tCa = new LinkedList();
  public uc tCb;
  public LinkedList<uc> tCc = new LinkedList();
  public uc tCd;
  public awq tCe;
  public String tCf;
  public int tCg;
  public String tCh;
  public int tCi;
  public boolean tCj;
  public String tCk;
  public String tCl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      paramVarArgs.gB(4, this.balance);
      if (this.tBU != null) {
        paramVarArgs.d(5, this.tBU);
      }
      if (this.tBV != null) {
        paramVarArgs.d(6, this.tBV);
      }
      if (this.tBW != null) {
        paramVarArgs.d(7, this.tBW);
      }
      paramVarArgs.gB(8, this.tBX);
      paramVarArgs.d(9, 8, this.tBY);
      paramVarArgs.gB(10, this.cdr);
      paramVarArgs.gB(11, this.tBZ);
      paramVarArgs.d(12, 8, this.tCa);
      if (this.tBg != null) {
        paramVarArgs.d(13, this.tBg);
      }
      if (this.tCb != null)
      {
        paramVarArgs.gD(14, this.tCb.btq());
        this.tCb.a(paramVarArgs);
      }
      paramVarArgs.d(15, 8, this.tCc);
      if (this.tCd != null)
      {
        paramVarArgs.gD(16, this.tCd.btq());
        this.tCd.a(paramVarArgs);
      }
      if (this.tCe != null)
      {
        paramVarArgs.gD(17, this.tCe.btq());
        this.tCe.a(paramVarArgs);
      }
      if (this.tCf != null) {
        paramVarArgs.d(18, this.tCf);
      }
      paramVarArgs.gB(19, this.tCg);
      if (this.tCh != null) {
        paramVarArgs.d(20, this.tCh);
      }
      if (this.tBT != null) {
        paramVarArgs.d(21, this.tBT);
      }
      paramVarArgs.gB(22, this.tCi);
      paramVarArgs.aA(23, this.tCj);
      paramVarArgs.gB(24, this.sOy);
      if (this.tBi != null) {
        paramVarArgs.d(25, this.tBi);
      }
      if (this.tCk != null) {
        paramVarArgs.d(26, this.tCk);
      }
      if (this.tCl != null) {
        paramVarArgs.d(27, this.tCl);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label2128;
      }
    }
    label2128:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt + d.a.a.a.gy(4, this.balance);
      paramInt = i;
      if (this.tBU != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tBU);
      }
      i = paramInt;
      if (this.tBV != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tBV);
      }
      paramInt = i;
      if (this.tBW != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tBW);
      }
      i = paramInt + d.a.a.a.gy(8, this.tBX) + d.a.a.a.c(9, 8, this.tBY) + d.a.a.a.gy(10, this.cdr) + d.a.a.a.gy(11, this.tBZ) + d.a.a.a.c(12, 8, this.tCa);
      paramInt = i;
      if (this.tBg != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.tBg);
      }
      i = paramInt;
      if (this.tCb != null) {
        i = paramInt + d.a.a.a.gA(14, this.tCb.btq());
      }
      i += d.a.a.a.c(15, 8, this.tCc);
      paramInt = i;
      if (this.tCd != null) {
        paramInt = i + d.a.a.a.gA(16, this.tCd.btq());
      }
      i = paramInt;
      if (this.tCe != null) {
        i = paramInt + d.a.a.a.gA(17, this.tCe.btq());
      }
      paramInt = i;
      if (this.tCf != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.tCf);
      }
      i = paramInt + d.a.a.a.gy(19, this.tCg);
      paramInt = i;
      if (this.tCh != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.tCh);
      }
      i = paramInt;
      if (this.tBT != null) {
        i = paramInt + d.a.a.b.b.a.e(21, this.tBT);
      }
      i = i + d.a.a.a.gy(22, this.tCi) + (d.a.a.b.b.a.dQ(23) + 1) + d.a.a.a.gy(24, this.sOy);
      paramInt = i;
      if (this.tBi != null) {
        paramInt = i + d.a.a.b.b.a.e(25, this.tBi);
      }
      i = paramInt;
      if (this.tCk != null) {
        i = paramInt + d.a.a.b.b.a.e(26, this.tCk);
      }
      paramInt = i;
      if (this.tCl != null) {
        paramInt = i + d.a.a.b.b.a.e(27, this.tCl);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tBY.clear();
        this.tCa.clear();
        this.tCc.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bhm localbhm = (bhm)paramVarArgs[1];
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
            localbhm.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbhm.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbhm.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbhm.balance = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbhm.tBU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbhm.tBV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbhm.tBW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbhm.tBX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhm.tBY.add(localObject1);
            paramInt += 1;
          }
        case 10: 
          localbhm.cdr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localbhm.tBZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhm.tCa.add(localObject1);
            paramInt += 1;
          }
        case 13: 
          localbhm.tBg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhm.tCb = ((uc)localObject1);
            paramInt += 1;
          }
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhm.tCc.add(localObject1);
            paramInt += 1;
          }
        case 16: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhm.tCd = ((uc)localObject1);
            paramInt += 1;
          }
        case 17: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhm.tCe = ((awq)localObject1);
            paramInt += 1;
          }
        case 18: 
          localbhm.tCf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localbhm.tCg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localbhm.tCh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localbhm.tBT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localbhm.tCi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localbhm.tCj = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 24: 
          localbhm.sOy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          localbhm.tBi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 26: 
          localbhm.tCk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbhm.tCl = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bhm
 * JD-Core Version:    0.7.0.1
 */