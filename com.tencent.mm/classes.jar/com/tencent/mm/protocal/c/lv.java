package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class lv
  extends com.tencent.mm.bv.a
{
  public String code;
  public int sHA;
  public String sHB;
  public ra sHC;
  public LinkedList<ax> sHD = new LinkedList();
  public ra sHE;
  public ra sHF;
  public ra sHG;
  public tx sHH;
  public String sHI;
  public ra sHJ;
  public String sHK;
  public ra sHL;
  public boolean sHM;
  public boolean sHN;
  public int sHq;
  public int sHr;
  public LinkedList<mn> sHs = new LinkedList();
  public LinkedList<mn> sHt = new LinkedList();
  public LinkedList<mn> sHu = new LinkedList();
  public LinkedList<String> sHv = new LinkedList();
  public int sHw;
  public int sHx;
  public LinkedList<ra> sHy = new LinkedList();
  public long sHz;
  public int status;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.status);
      paramVarArgs.gB(2, this.sHq);
      paramVarArgs.gB(3, this.sHr);
      paramVarArgs.d(4, 8, this.sHs);
      paramVarArgs.d(5, 8, this.sHt);
      paramVarArgs.d(6, 8, this.sHu);
      paramVarArgs.d(7, 1, this.sHv);
      paramVarArgs.gB(8, this.sHw);
      if (this.code != null) {
        paramVarArgs.d(9, this.code);
      }
      paramVarArgs.gB(10, this.sHx);
      paramVarArgs.d(11, 8, this.sHy);
      paramVarArgs.Y(12, this.sHz);
      paramVarArgs.gB(13, this.sHA);
      if (this.sHB != null) {
        paramVarArgs.d(14, this.sHB);
      }
      if (this.sHC != null)
      {
        paramVarArgs.gD(15, this.sHC.btq());
        this.sHC.a(paramVarArgs);
      }
      paramVarArgs.d(16, 8, this.sHD);
      if (this.sHE != null)
      {
        paramVarArgs.gD(17, this.sHE.btq());
        this.sHE.a(paramVarArgs);
      }
      if (this.sHF != null)
      {
        paramVarArgs.gD(18, this.sHF.btq());
        this.sHF.a(paramVarArgs);
      }
      if (this.sHG != null)
      {
        paramVarArgs.gD(19, this.sHG.btq());
        this.sHG.a(paramVarArgs);
      }
      if (this.sHH != null)
      {
        paramVarArgs.gD(20, this.sHH.btq());
        this.sHH.a(paramVarArgs);
      }
      if (this.sHI != null) {
        paramVarArgs.d(21, this.sHI);
      }
      if (this.sHJ != null)
      {
        paramVarArgs.gD(22, this.sHJ.btq());
        this.sHJ.a(paramVarArgs);
      }
      if (this.sHK != null) {
        paramVarArgs.d(23, this.sHK);
      }
      if (this.sHL != null)
      {
        paramVarArgs.gD(24, this.sHL.btq());
        this.sHL.a(paramVarArgs);
      }
      paramVarArgs.aA(25, this.sHM);
      paramVarArgs.aA(26, this.sHN);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.status) + 0 + d.a.a.a.gy(2, this.sHq) + d.a.a.a.gy(3, this.sHr) + d.a.a.a.c(4, 8, this.sHs) + d.a.a.a.c(5, 8, this.sHt) + d.a.a.a.c(6, 8, this.sHu) + d.a.a.a.c(7, 1, this.sHv) + d.a.a.a.gy(8, this.sHw);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.code);
      }
      i = paramInt + d.a.a.a.gy(10, this.sHx) + d.a.a.a.c(11, 8, this.sHy) + d.a.a.a.X(12, this.sHz) + d.a.a.a.gy(13, this.sHA);
      paramInt = i;
      if (this.sHB != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.sHB);
      }
      i = paramInt;
      if (this.sHC != null) {
        i = paramInt + d.a.a.a.gA(15, this.sHC.btq());
      }
      i += d.a.a.a.c(16, 8, this.sHD);
      paramInt = i;
      if (this.sHE != null) {
        paramInt = i + d.a.a.a.gA(17, this.sHE.btq());
      }
      i = paramInt;
      if (this.sHF != null) {
        i = paramInt + d.a.a.a.gA(18, this.sHF.btq());
      }
      paramInt = i;
      if (this.sHG != null) {
        paramInt = i + d.a.a.a.gA(19, this.sHG.btq());
      }
      i = paramInt;
      if (this.sHH != null) {
        i = paramInt + d.a.a.a.gA(20, this.sHH.btq());
      }
      paramInt = i;
      if (this.sHI != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.sHI);
      }
      i = paramInt;
      if (this.sHJ != null) {
        i = paramInt + d.a.a.a.gA(22, this.sHJ.btq());
      }
      paramInt = i;
      if (this.sHK != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.sHK);
      }
      i = paramInt;
      if (this.sHL != null) {
        i = paramInt + d.a.a.a.gA(24, this.sHL.btq());
      }
      return i + (d.a.a.b.b.a.dQ(25) + 1) + (d.a.a.b.b.a.dQ(26) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sHs.clear();
      this.sHt.clear();
      this.sHu.clear();
      this.sHv.clear();
      this.sHy.clear();
      this.sHD.clear();
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
      lv locallv = (lv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        locallv.status = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        locallv.sHq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        locallv.sHr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mn();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHs.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mn();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHt.add(localObject1);
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
          localObject1 = new mn();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHu.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        locallv.sHv.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      case 8: 
        locallv.sHw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        locallv.code = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 10: 
        locallv.sHx = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHy.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 12: 
        locallv.sHz = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 13: 
        locallv.sHA = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        locallv.sHB = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 15: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHC = ((ra)localObject1);
          paramInt += 1;
        }
        return 0;
      case 16: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ax();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ax)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHD.add(localObject1);
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
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHE = ((ra)localObject1);
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
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHF = ((ra)localObject1);
          paramInt += 1;
        }
        return 0;
      case 19: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHG = ((ra)localObject1);
          paramInt += 1;
        }
        return 0;
      case 20: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHH = ((tx)localObject1);
          paramInt += 1;
        }
        return 0;
      case 21: 
        locallv.sHI = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 22: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHJ = ((ra)localObject1);
          paramInt += 1;
        }
        return 0;
      case 23: 
        locallv.sHK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 24: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallv.sHL = ((ra)localObject1);
          paramInt += 1;
        }
        return 0;
      case 25: 
        locallv.sHM = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      locallv.sHN = ((d.a.a.a.a)localObject1).cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lv
 * JD-Core Version:    0.7.0.1
 */