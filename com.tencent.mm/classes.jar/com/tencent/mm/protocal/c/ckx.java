package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ckx
  extends com.tencent.mm.bv.a
{
  public String jxi;
  public int pyo;
  public bww qTF;
  public int sDT;
  public long sFC;
  public String sFF;
  public String sYZ;
  public int tEN;
  public LinkedList<ccd> tGy = new LinkedList();
  public int tXU;
  public LinkedList<rb> tXV = new LinkedList();
  public String tYf;
  public String tYg;
  public int tYh;
  public LinkedList<String> tYi = new LinkedList();
  public LinkedList<azi> tYj = new LinkedList();
  public btg tYk;
  public si tYl;
  public bey tYm;
  public int tpI;
  public int tpJ = 2;
  public String tpM;
  public com.tencent.mm.bv.b tpN;
  public com.tencent.mm.bv.b tpO;
  public atp tqT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sYZ == null) {
        throw new d.a.a.b("Not all required fields were included: Keyword");
      }
      paramVarArgs.gB(1, this.tEN);
      if (this.sYZ != null) {
        paramVarArgs.d(2, this.sYZ);
      }
      paramVarArgs.gB(3, this.sDT);
      paramVarArgs.Y(4, this.sFC);
      paramVarArgs.gB(5, this.tpI);
      if (this.tqT != null)
      {
        paramVarArgs.gD(6, this.tqT.btq());
        this.tqT.a(paramVarArgs);
      }
      paramVarArgs.d(7, 8, this.tGy);
      paramVarArgs.gB(8, this.pyo);
      if (this.sFF != null) {
        paramVarArgs.d(9, this.sFF);
      }
      paramVarArgs.gB(10, this.tXU);
      if (this.tYf != null) {
        paramVarArgs.d(11, this.tYf);
      }
      if (this.tYg != null) {
        paramVarArgs.d(12, this.tYg);
      }
      paramVarArgs.gB(13, this.tYh);
      paramVarArgs.d(14, 1, this.tYi);
      paramVarArgs.gB(15, this.tpJ);
      if (this.qTF != null)
      {
        paramVarArgs.gD(16, this.qTF.btq());
        this.qTF.a(paramVarArgs);
      }
      paramVarArgs.d(17, 8, this.tXV);
      paramVarArgs.d(18, 8, this.tYj);
      if (this.jxi != null) {
        paramVarArgs.d(19, this.jxi);
      }
      if (this.tpO != null) {
        paramVarArgs.b(20, this.tpO);
      }
      if (this.tpM != null) {
        paramVarArgs.d(21, this.tpM);
      }
      if (this.tpN != null) {
        paramVarArgs.b(22, this.tpN);
      }
      if (this.tYk != null)
      {
        paramVarArgs.gD(23, this.tYk.btq());
        this.tYk.a(paramVarArgs);
      }
      if (this.tYl != null)
      {
        paramVarArgs.gD(24, this.tYl.btq());
        this.tYl.a(paramVarArgs);
      }
      if (this.tYm != null)
      {
        paramVarArgs.gD(25, this.tYm.btq());
        this.tYm.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.tEN) + 0;
      paramInt = i;
      if (this.sYZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sYZ);
      }
      i = paramInt + d.a.a.a.gy(3, this.sDT) + d.a.a.a.X(4, this.sFC) + d.a.a.a.gy(5, this.tpI);
      paramInt = i;
      if (this.tqT != null) {
        paramInt = i + d.a.a.a.gA(6, this.tqT.btq());
      }
      i = paramInt + d.a.a.a.c(7, 8, this.tGy) + d.a.a.a.gy(8, this.pyo);
      paramInt = i;
      if (this.sFF != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sFF);
      }
      i = paramInt + d.a.a.a.gy(10, this.tXU);
      paramInt = i;
      if (this.tYf != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tYf);
      }
      i = paramInt;
      if (this.tYg != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.tYg);
      }
      i = i + d.a.a.a.gy(13, this.tYh) + d.a.a.a.c(14, 1, this.tYi) + d.a.a.a.gy(15, this.tpJ);
      paramInt = i;
      if (this.qTF != null) {
        paramInt = i + d.a.a.a.gA(16, this.qTF.btq());
      }
      i = paramInt + d.a.a.a.c(17, 8, this.tXV) + d.a.a.a.c(18, 8, this.tYj);
      paramInt = i;
      if (this.jxi != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.jxi);
      }
      i = paramInt;
      if (this.tpO != null) {
        i = paramInt + d.a.a.a.a(20, this.tpO);
      }
      paramInt = i;
      if (this.tpM != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.tpM);
      }
      i = paramInt;
      if (this.tpN != null) {
        i = paramInt + d.a.a.a.a(22, this.tpN);
      }
      paramInt = i;
      if (this.tYk != null) {
        paramInt = i + d.a.a.a.gA(23, this.tYk.btq());
      }
      i = paramInt;
      if (this.tYl != null) {
        i = paramInt + d.a.a.a.gA(24, this.tYl.btq());
      }
      paramInt = i;
    } while (this.tYm == null);
    return i + d.a.a.a.gA(25, this.tYm.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tGy.clear();
      this.tYi.clear();
      this.tXV.clear();
      this.tYj.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sYZ == null) {
        throw new d.a.a.b("Not all required fields were included: Keyword");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      ckx localckx = (ckx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localckx.tEN = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localckx.sYZ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localckx.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localckx.sFC = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 5: 
        localckx.tpI = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((atp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckx.tqT = ((atp)localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckx.tGy.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        localckx.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localckx.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 10: 
        localckx.tXU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        localckx.tYf = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 12: 
        localckx.tYg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 13: 
        localckx.tYh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        localckx.tYi.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      case 15: 
        localckx.tpJ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 16: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bww();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bww)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckx.qTF = ((bww)localObject1);
          paramInt += 1;
        }
        return 0;
      case 17: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rb();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckx.tXV.add(localObject1);
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
          localObject1 = new azi();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckx.tYj.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 19: 
        localckx.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 20: 
        localckx.tpO = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      case 21: 
        localckx.tpM = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 22: 
        localckx.tpN = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      case 23: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btg();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckx.tYk = ((btg)localObject1);
          paramInt += 1;
        }
        return 0;
      case 24: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new si();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((si)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckx.tYl = ((si)localObject1);
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
        localObject1 = new bey();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bey)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localckx.tYm = ((bey)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckx
 * JD-Core Version:    0.7.0.1
 */