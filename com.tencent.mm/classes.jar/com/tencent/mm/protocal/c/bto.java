package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bto
  extends com.tencent.mm.bv.a
{
  public int mPL;
  public long sGd;
  public LinkedList<btj> swl = new LinkedList();
  public String sxM;
  public bmk tJU;
  public int tJV;
  public int tJW;
  public int tJX;
  public LinkedList<btd> tJY = new LinkedList();
  public int tJZ;
  public int tJv;
  public int tKa;
  public LinkedList<btd> tKb = new LinkedList();
  public int tKc;
  public int tKd;
  public LinkedList<btd> tKe = new LinkedList();
  public int tKf;
  public String tKg;
  public long tKh;
  public int tKi;
  public LinkedList<bml> tKj = new LinkedList();
  public int tKk;
  public bmk tKl;
  public bud tKm;
  public bfg tKn;
  public bsz tKo;
  public String tqh;
  public LinkedList<bml> tsx = new LinkedList();
  public int ttD;
  public int ttI;
  public int tuG;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tJU == null) {
        throw new b("Not all required fields were included: ObjectDesc");
      }
      paramVarArgs.Y(1, this.sGd);
      if (this.sxM != null) {
        paramVarArgs.d(2, this.sxM);
      }
      if (this.tqh != null) {
        paramVarArgs.d(3, this.tqh);
      }
      paramVarArgs.gB(4, this.mPL);
      if (this.tJU != null)
      {
        paramVarArgs.gD(5, this.tJU.btq());
        this.tJU.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.tJV);
      paramVarArgs.gB(7, this.tJW);
      paramVarArgs.gB(8, this.tJX);
      paramVarArgs.d(9, 8, this.tJY);
      paramVarArgs.gB(10, this.tJZ);
      paramVarArgs.gB(11, this.tKa);
      paramVarArgs.d(12, 8, this.tKb);
      paramVarArgs.gB(13, this.tKc);
      paramVarArgs.gB(14, this.tKd);
      paramVarArgs.d(15, 8, this.tKe);
      paramVarArgs.gB(16, this.ttI);
      paramVarArgs.gB(17, this.tKf);
      paramVarArgs.gB(18, this.tuG);
      paramVarArgs.d(19, 8, this.swl);
      paramVarArgs.gB(20, this.tJv);
      if (this.tKg != null) {
        paramVarArgs.d(21, this.tKg);
      }
      paramVarArgs.Y(22, this.tKh);
      paramVarArgs.gB(23, this.tKi);
      paramVarArgs.d(24, 8, this.tKj);
      paramVarArgs.gB(25, this.ttD);
      paramVarArgs.gB(26, this.tKk);
      paramVarArgs.d(27, 8, this.tsx);
      if (this.tKl != null)
      {
        paramVarArgs.gD(28, this.tKl.btq());
        this.tKl.a(paramVarArgs);
      }
      if (this.tKm != null)
      {
        paramVarArgs.gD(29, this.tKm.btq());
        this.tKm.a(paramVarArgs);
      }
      if (this.tKn != null)
      {
        paramVarArgs.gD(30, this.tKn.btq());
        this.tKn.a(paramVarArgs);
      }
      if (this.tKo != null)
      {
        paramVarArgs.gD(31, this.tKo.btq());
        this.tKo.a(paramVarArgs);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.X(1, this.sGd) + 0;
      paramInt = i;
      if (this.sxM != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sxM);
      }
      i = paramInt;
      if (this.tqh != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tqh);
      }
      i += d.a.a.a.gy(4, this.mPL);
      paramInt = i;
      if (this.tJU != null) {
        paramInt = i + d.a.a.a.gA(5, this.tJU.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.tJV) + d.a.a.a.gy(7, this.tJW) + d.a.a.a.gy(8, this.tJX) + d.a.a.a.c(9, 8, this.tJY) + d.a.a.a.gy(10, this.tJZ) + d.a.a.a.gy(11, this.tKa) + d.a.a.a.c(12, 8, this.tKb) + d.a.a.a.gy(13, this.tKc) + d.a.a.a.gy(14, this.tKd) + d.a.a.a.c(15, 8, this.tKe) + d.a.a.a.gy(16, this.ttI) + d.a.a.a.gy(17, this.tKf) + d.a.a.a.gy(18, this.tuG) + d.a.a.a.c(19, 8, this.swl) + d.a.a.a.gy(20, this.tJv);
      paramInt = i;
      if (this.tKg != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.tKg);
      }
      i = paramInt + d.a.a.a.X(22, this.tKh) + d.a.a.a.gy(23, this.tKi) + d.a.a.a.c(24, 8, this.tKj) + d.a.a.a.gy(25, this.ttD) + d.a.a.a.gy(26, this.tKk) + d.a.a.a.c(27, 8, this.tsx);
      paramInt = i;
      if (this.tKl != null) {
        paramInt = i + d.a.a.a.gA(28, this.tKl.btq());
      }
      i = paramInt;
      if (this.tKm != null) {
        i = paramInt + d.a.a.a.gA(29, this.tKm.btq());
      }
      paramInt = i;
      if (this.tKn != null) {
        paramInt = i + d.a.a.a.gA(30, this.tKn.btq());
      }
      i = paramInt;
    } while (this.tKo == null);
    return paramInt + d.a.a.a.gA(31, this.tKo.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tJY.clear();
      this.tKb.clear();
      this.tKe.clear();
      this.swl.clear();
      this.tKj.clear();
      this.tsx.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tJU == null) {
        throw new b("Not all required fields were included: ObjectDesc");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bto localbto = (bto)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbto.sGd = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localbto.sxM = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbto.tqh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localbto.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
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
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tJU = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localbto.tJV = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localbto.tJW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localbto.tJX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tJY.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 10: 
        localbto.tJZ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        localbto.tKa = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 12: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tKb.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 13: 
        localbto.tKc = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        localbto.tKd = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 15: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tKe.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 16: 
        localbto.ttI = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 17: 
        localbto.tKf = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 18: 
        localbto.tuG = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 19: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btj();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.swl.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 20: 
        localbto.tJv = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 21: 
        localbto.tKg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 22: 
        localbto.tKh = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 23: 
        localbto.tKi = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 24: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tKj.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 25: 
        localbto.ttD = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 26: 
        localbto.tKk = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 27: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tsx.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 28: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tKl = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 29: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bud();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bud)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tKm = ((bud)localObject1);
          paramInt += 1;
        }
        return 0;
      case 30: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfg();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbto.tKn = ((bfg)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bsz();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bsz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localbto.tKo = ((bsz)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bto
 * JD-Core Version:    0.7.0.1
 */