package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aan
  extends blm
{
  public String hPY;
  public int pyo;
  public int sLZ;
  public int sMa;
  public bml sZG;
  public bml sZH;
  public bml sZI;
  public bml sZJ;
  public String sZK;
  public int sZL;
  public String sZM;
  public bmk sZN;
  public int sZO;
  public int sZP;
  public String sZQ;
  public int sZR;
  public String sZS;
  public int sZT;
  public bmk sZU;
  public int ssq;
  public int svx;
  public bmk syq;
  
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
      paramVarArgs.gB(2, this.ssq);
      if (this.syq != null)
      {
        paramVarArgs.gD(3, this.syq.btq());
        this.syq.a(paramVarArgs);
      }
      if (this.sZG != null)
      {
        paramVarArgs.gD(4, this.sZG.btq());
        this.sZG.a(paramVarArgs);
      }
      if (this.sZH != null)
      {
        paramVarArgs.gD(5, this.sZH.btq());
        this.sZH.a(paramVarArgs);
      }
      if (this.sZI != null)
      {
        paramVarArgs.gD(6, this.sZI.btq());
        this.sZI.a(paramVarArgs);
      }
      if (this.sZJ != null)
      {
        paramVarArgs.gD(7, this.sZJ.btq());
        this.sZJ.a(paramVarArgs);
      }
      if (this.sZK != null) {
        paramVarArgs.d(8, this.sZK);
      }
      paramVarArgs.gB(9, this.sZL);
      paramVarArgs.gB(10, this.pyo);
      if (this.hPY != null) {
        paramVarArgs.d(11, this.hPY);
      }
      if (this.sZM != null) {
        paramVarArgs.d(12, this.sZM);
      }
      if (this.sZN != null)
      {
        paramVarArgs.gD(13, this.sZN.btq());
        this.sZN.a(paramVarArgs);
      }
      paramVarArgs.gB(14, this.sZO);
      paramVarArgs.gB(15, this.sZP);
      paramVarArgs.gB(16, this.svx);
      if (this.sZQ != null) {
        paramVarArgs.d(17, this.sZQ);
      }
      paramVarArgs.gB(18, this.sLZ);
      paramVarArgs.gB(19, this.sMa);
      paramVarArgs.gB(20, this.sZR);
      if (this.sZS != null) {
        paramVarArgs.d(21, this.sZS);
      }
      paramVarArgs.gB(22, this.sZT);
      if (this.sZU != null)
      {
        paramVarArgs.gD(23, this.sZU.btq());
        this.sZU.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1993;
      }
    }
    label1993:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssq);
      paramInt = i;
      if (this.syq != null) {
        paramInt = i + d.a.a.a.gA(3, this.syq.btq());
      }
      i = paramInt;
      if (this.sZG != null) {
        i = paramInt + d.a.a.a.gA(4, this.sZG.btq());
      }
      paramInt = i;
      if (this.sZH != null) {
        paramInt = i + d.a.a.a.gA(5, this.sZH.btq());
      }
      i = paramInt;
      if (this.sZI != null) {
        i = paramInt + d.a.a.a.gA(6, this.sZI.btq());
      }
      paramInt = i;
      if (this.sZJ != null) {
        paramInt = i + d.a.a.a.gA(7, this.sZJ.btq());
      }
      i = paramInt;
      if (this.sZK != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sZK);
      }
      i = i + d.a.a.a.gy(9, this.sZL) + d.a.a.a.gy(10, this.pyo);
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.hPY);
      }
      i = paramInt;
      if (this.sZM != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.sZM);
      }
      paramInt = i;
      if (this.sZN != null) {
        paramInt = i + d.a.a.a.gA(13, this.sZN.btq());
      }
      i = paramInt + d.a.a.a.gy(14, this.sZO) + d.a.a.a.gy(15, this.sZP) + d.a.a.a.gy(16, this.svx);
      paramInt = i;
      if (this.sZQ != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.sZQ);
      }
      i = paramInt + d.a.a.a.gy(18, this.sLZ) + d.a.a.a.gy(19, this.sMa) + d.a.a.a.gy(20, this.sZR);
      paramInt = i;
      if (this.sZS != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.sZS);
      }
      i = paramInt + d.a.a.a.gy(22, this.sZT);
      paramInt = i;
      if (this.sZU != null) {
        paramInt = i + d.a.a.a.gA(23, this.sZU.btq());
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
        aan localaan = (aan)paramVarArgs[1];
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
            localaan.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaan.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaan.syq = ((bmk)localObject1);
            paramInt += 1;
          }
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
            localaan.sZG = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaan.sZH = ((bml)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaan.sZI = ((bml)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaan.sZJ = ((bml)localObject1);
            paramInt += 1;
          }
        case 8: 
          localaan.sZK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localaan.sZL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localaan.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localaan.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localaan.sZM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaan.sZN = ((bmk)localObject1);
            paramInt += 1;
          }
        case 14: 
          localaan.sZO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localaan.sZP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localaan.svx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localaan.sZQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localaan.sLZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localaan.sMa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localaan.sZR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localaan.sZS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localaan.sZT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
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
          localaan.sZU = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aan
 * JD-Core Version:    0.7.0.1
 */