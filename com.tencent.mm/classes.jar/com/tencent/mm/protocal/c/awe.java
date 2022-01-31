package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class awe
  extends com.tencent.mm.bv.a
{
  public String bIB;
  public String bYM;
  public int cec;
  public int ebp;
  public String nde;
  public String sRr;
  public String token;
  public int trR;
  public String tsA;
  public long tsB;
  public String tsC;
  public boolean tsD;
  public bsz tsE;
  public int tsl;
  public int tsm;
  public LinkedList<auf> tsn = new LinkedList();
  public LinkedList<buw> tso = new LinkedList();
  public int tsp;
  public long tsq;
  public int tsr;
  public LinkedList<Long> tss = new LinkedList();
  public int tst;
  public int tsu;
  public String tsv;
  public int tsw;
  public LinkedList<bml> tsx = new LinkedList();
  public bty tsy;
  public LinkedList<bue> tsz = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tsl);
      paramVarArgs.gB(2, this.tsm);
      paramVarArgs.gB(3, this.trR);
      if (this.nde != null) {
        paramVarArgs.d(4, this.nde);
      }
      paramVarArgs.d(5, 8, this.tsn);
      paramVarArgs.d(6, 8, this.tso);
      paramVarArgs.gB(7, this.tsp);
      paramVarArgs.gB(8, this.ebp);
      paramVarArgs.Y(9, this.tsq);
      paramVarArgs.gB(10, this.tsr);
      paramVarArgs.d(11, 3, this.tss);
      paramVarArgs.gB(12, this.tst);
      paramVarArgs.gB(13, this.tsu);
      if (this.token != null) {
        paramVarArgs.d(14, this.token);
      }
      if (this.tsv != null) {
        paramVarArgs.d(15, this.tsv);
      }
      paramVarArgs.gB(16, this.tsw);
      paramVarArgs.d(17, 8, this.tsx);
      if (this.tsy != null)
      {
        paramVarArgs.gD(18, this.tsy.btq());
        this.tsy.a(paramVarArgs);
      }
      if (this.bYM != null) {
        paramVarArgs.d(19, this.bYM);
      }
      paramVarArgs.d(20, 8, this.tsz);
      if (this.bIB != null) {
        paramVarArgs.d(21, this.bIB);
      }
      if (this.tsA != null) {
        paramVarArgs.d(22, this.tsA);
      }
      if (this.sRr != null) {
        paramVarArgs.d(23, this.sRr);
      }
      paramVarArgs.gB(24, this.cec);
      paramVarArgs.Y(25, this.tsB);
      if (this.tsC != null) {
        paramVarArgs.d(26, this.tsC);
      }
      paramVarArgs.aA(27, this.tsD);
      if (this.tsE != null)
      {
        paramVarArgs.gD(28, this.tsE.btq());
        this.tsE.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tsl) + 0 + d.a.a.a.gy(2, this.tsm) + d.a.a.a.gy(3, this.trR);
      paramInt = i;
      if (this.nde != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.nde);
      }
      i = paramInt + d.a.a.a.c(5, 8, this.tsn) + d.a.a.a.c(6, 8, this.tso) + d.a.a.a.gy(7, this.tsp) + d.a.a.a.gy(8, this.ebp) + d.a.a.a.X(9, this.tsq) + d.a.a.a.gy(10, this.tsr) + d.a.a.a.c(11, 3, this.tss) + d.a.a.a.gy(12, this.tst) + d.a.a.a.gy(13, this.tsu);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.token);
      }
      i = paramInt;
      if (this.tsv != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tsv);
      }
      i = i + d.a.a.a.gy(16, this.tsw) + d.a.a.a.c(17, 8, this.tsx);
      paramInt = i;
      if (this.tsy != null) {
        paramInt = i + d.a.a.a.gA(18, this.tsy.btq());
      }
      i = paramInt;
      if (this.bYM != null) {
        i = paramInt + d.a.a.b.b.a.e(19, this.bYM);
      }
      i += d.a.a.a.c(20, 8, this.tsz);
      paramInt = i;
      if (this.bIB != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.bIB);
      }
      i = paramInt;
      if (this.tsA != null) {
        i = paramInt + d.a.a.b.b.a.e(22, this.tsA);
      }
      paramInt = i;
      if (this.sRr != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.sRr);
      }
      i = paramInt + d.a.a.a.gy(24, this.cec) + d.a.a.a.X(25, this.tsB);
      paramInt = i;
      if (this.tsC != null) {
        paramInt = i + d.a.a.b.b.a.e(26, this.tsC);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(27) + 1);
      paramInt = i;
    } while (this.tsE == null);
    return i + d.a.a.a.gA(28, this.tsE.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tsn.clear();
      this.tso.clear();
      this.tss.clear();
      this.tsx.clear();
      this.tsz.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      awe localawe = (awe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localawe.tsl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localawe.tsm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localawe.trR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localawe.nde = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auf();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((auf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawe.tsn.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawe.tso.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        localawe.tsp = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localawe.ebp = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localawe.tsq = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 10: 
        localawe.tsr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        localawe.tss.add(Long.valueOf(((d.a.a.a.a)localObject1).xpH.oE()));
        return 0;
      case 12: 
        localawe.tst = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 13: 
        localawe.tsu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        localawe.token = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 15: 
        localawe.tsv = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 16: 
        localawe.tsw = ((d.a.a.a.a)localObject1).xpH.oD();
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
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawe.tsx.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 18: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bty();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bty)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawe.tsy = ((bty)localObject1);
          paramInt += 1;
        }
        return 0;
      case 19: 
        localawe.bYM = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 20: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bue();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bue)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawe.tsz.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 21: 
        localawe.bIB = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 22: 
        localawe.tsA = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 23: 
        localawe.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 24: 
        localawe.cec = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 25: 
        localawe.tsB = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 26: 
        localawe.tsC = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 27: 
        localawe.tsD = ((d.a.a.a.a)localObject1).cUr();
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
        localawe.tsE = ((bsz)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awe
 * JD-Core Version:    0.7.0.1
 */