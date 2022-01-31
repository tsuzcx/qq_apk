package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class btz
  extends blm
{
  public String nde;
  public bmk tJU;
  public int tKC;
  public int tKD;
  public int tKE;
  public btx tKF;
  public bmk tKG;
  public String tKH;
  public ls tKI;
  public int tKJ;
  public LinkedList<awb> tKK = new LinkedList();
  public bsz tKL;
  public int tKd;
  public LinkedList<bml> tKe = new LinkedList();
  public long tKh;
  public int tKi;
  public LinkedList<bml> tKj = new LinkedList();
  public int tKk;
  public bud tKm;
  public bmk tpt;
  public int tsm;
  public LinkedList<btj> tss = new LinkedList();
  public LinkedList<bml> tsx = new LinkedList();
  public bty tsy;
  public int tuG;
  public bzd tzP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tJU == null) {
        throw new b("Not all required fields were included: ObjectDesc");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tJU != null)
      {
        paramVarArgs.gD(2, this.tJU.btq());
        this.tJU.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tKd);
      paramVarArgs.d(4, 8, this.tKe);
      paramVarArgs.gB(5, this.tKC);
      paramVarArgs.gB(6, this.tsm);
      if (this.nde != null) {
        paramVarArgs.d(7, this.nde);
      }
      paramVarArgs.gB(8, this.tKD);
      paramVarArgs.gB(9, this.tuG);
      paramVarArgs.d(10, 8, this.tss);
      paramVarArgs.gB(11, this.tKE);
      paramVarArgs.Y(12, this.tKh);
      paramVarArgs.gB(13, this.tKi);
      paramVarArgs.d(14, 8, this.tKj);
      if (this.tzP != null)
      {
        paramVarArgs.gD(15, this.tzP.btq());
        this.tzP.a(paramVarArgs);
      }
      paramVarArgs.gB(16, this.tKk);
      paramVarArgs.d(17, 8, this.tsx);
      if (this.tKF != null)
      {
        paramVarArgs.gD(18, this.tKF.btq());
        this.tKF.a(paramVarArgs);
      }
      if (this.tsy != null)
      {
        paramVarArgs.gD(19, this.tsy.btq());
        this.tsy.a(paramVarArgs);
      }
      if (this.tKm != null)
      {
        paramVarArgs.gD(20, this.tKm.btq());
        this.tKm.a(paramVarArgs);
      }
      if (this.tKG != null)
      {
        paramVarArgs.gD(21, this.tKG.btq());
        this.tKG.a(paramVarArgs);
      }
      if (this.tKH != null) {
        paramVarArgs.d(22, this.tKH);
      }
      if (this.tKI != null)
      {
        paramVarArgs.gD(23, this.tKI.btq());
        this.tKI.a(paramVarArgs);
      }
      paramVarArgs.gB(24, this.tKJ);
      paramVarArgs.d(25, 8, this.tKK);
      if (this.tKL != null)
      {
        paramVarArgs.gD(26, this.tKL.btq());
        this.tKL.a(paramVarArgs);
      }
      if (this.tpt != null)
      {
        paramVarArgs.gD(27, this.tpt.btq());
        this.tpt.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label2811;
      }
    }
    label2811:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tJU != null) {
        i = paramInt + d.a.a.a.gA(2, this.tJU.btq());
      }
      i = i + d.a.a.a.gy(3, this.tKd) + d.a.a.a.c(4, 8, this.tKe) + d.a.a.a.gy(5, this.tKC) + d.a.a.a.gy(6, this.tsm);
      paramInt = i;
      if (this.nde != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.nde);
      }
      i = paramInt + d.a.a.a.gy(8, this.tKD) + d.a.a.a.gy(9, this.tuG) + d.a.a.a.c(10, 8, this.tss) + d.a.a.a.gy(11, this.tKE) + d.a.a.a.X(12, this.tKh) + d.a.a.a.gy(13, this.tKi) + d.a.a.a.c(14, 8, this.tKj);
      paramInt = i;
      if (this.tzP != null) {
        paramInt = i + d.a.a.a.gA(15, this.tzP.btq());
      }
      i = paramInt + d.a.a.a.gy(16, this.tKk) + d.a.a.a.c(17, 8, this.tsx);
      paramInt = i;
      if (this.tKF != null) {
        paramInt = i + d.a.a.a.gA(18, this.tKF.btq());
      }
      i = paramInt;
      if (this.tsy != null) {
        i = paramInt + d.a.a.a.gA(19, this.tsy.btq());
      }
      paramInt = i;
      if (this.tKm != null) {
        paramInt = i + d.a.a.a.gA(20, this.tKm.btq());
      }
      i = paramInt;
      if (this.tKG != null) {
        i = paramInt + d.a.a.a.gA(21, this.tKG.btq());
      }
      paramInt = i;
      if (this.tKH != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.tKH);
      }
      i = paramInt;
      if (this.tKI != null) {
        i = paramInt + d.a.a.a.gA(23, this.tKI.btq());
      }
      i = i + d.a.a.a.gy(24, this.tKJ) + d.a.a.a.c(25, 8, this.tKK);
      paramInt = i;
      if (this.tKL != null) {
        paramInt = i + d.a.a.a.gA(26, this.tKL.btq());
      }
      i = paramInt;
      if (this.tpt != null) {
        i = paramInt + d.a.a.a.gA(27, this.tpt.btq());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tKe.clear();
        this.tss.clear();
        this.tKj.clear();
        this.tsx.clear();
        this.tKK.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tJU != null) {
          break;
        }
        throw new b("Not all required fields were included: ObjectDesc");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        btz localbtz = (btz)paramVarArgs[1];
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
            localbtz.tEX = ((gc)localObject1);
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
            localbtz.tJU = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbtz.tKd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKe.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localbtz.tKC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbtz.tsm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbtz.nde = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbtz.tKD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbtz.tuG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tss.add(localObject1);
            paramInt += 1;
          }
        case 11: 
          localbtz.tKE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbtz.tKh = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 13: 
          localbtz.tKi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKj.add(localObject1);
            paramInt += 1;
          }
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tzP = ((bzd)localObject1);
            paramInt += 1;
          }
        case 16: 
          localbtz.tKk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tsx.add(localObject1);
            paramInt += 1;
          }
        case 18: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKF = ((btx)localObject1);
            paramInt += 1;
          }
        case 19: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bty();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bty)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tsy = ((bty)localObject1);
            paramInt += 1;
          }
        case 20: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bud();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bud)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKm = ((bud)localObject1);
            paramInt += 1;
          }
        case 21: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKG = ((bmk)localObject1);
            paramInt += 1;
          }
        case 22: 
          localbtz.tKH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 23: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ls();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ls)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKI = ((ls)localObject1);
            paramInt += 1;
          }
        case 24: 
          localbtz.tKJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKK.add(localObject1);
            paramInt += 1;
          }
        case 26: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbtz.tKL = ((bsz)localObject1);
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
          localbtz.tpt = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.btz
 * JD-Core Version:    0.7.0.1
 */