package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ams
  extends bly
{
  public String bGw;
  public String kRN;
  public String lsL;
  public String tiD;
  public String tiE;
  public String tiF;
  public String tiG;
  public String tiH;
  public String tiI;
  public chu tiJ;
  public String tiK;
  public String tiL;
  public String tiM;
  public String tiN;
  public String tiO;
  public int tiq;
  public LinkedList<cho> tir = new LinkedList();
  
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
      if (this.tiD != null) {
        paramVarArgs.d(2, this.tiD);
      }
      if (this.lsL != null) {
        paramVarArgs.d(3, this.lsL);
      }
      if (this.bGw != null) {
        paramVarArgs.d(4, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(5, this.kRN);
      }
      if (this.tiE != null) {
        paramVarArgs.d(6, this.tiE);
      }
      if (this.tiF != null) {
        paramVarArgs.d(7, this.tiF);
      }
      if (this.tiG != null) {
        paramVarArgs.d(8, this.tiG);
      }
      if (this.tiH != null) {
        paramVarArgs.d(9, this.tiH);
      }
      if (this.tiI != null) {
        paramVarArgs.d(10, this.tiI);
      }
      if (this.tiJ != null)
      {
        paramVarArgs.gD(11, this.tiJ.btq());
        this.tiJ.a(paramVarArgs);
      }
      if (this.tiK != null) {
        paramVarArgs.d(12, this.tiK);
      }
      if (this.tiL != null) {
        paramVarArgs.d(13, this.tiL);
      }
      if (this.tiM != null) {
        paramVarArgs.d(14, this.tiM);
      }
      if (this.tiN != null) {
        paramVarArgs.d(15, this.tiN);
      }
      if (this.tiO != null) {
        paramVarArgs.d(16, this.tiO);
      }
      paramVarArgs.gB(17, this.tiq);
      paramVarArgs.d(18, 8, this.tir);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1416;
      }
    }
    label1416:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tiD != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tiD);
      }
      i = paramInt;
      if (this.lsL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.lsL);
      }
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bGw);
      }
      i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kRN);
      }
      paramInt = i;
      if (this.tiE != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tiE);
      }
      i = paramInt;
      if (this.tiF != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tiF);
      }
      paramInt = i;
      if (this.tiG != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tiG);
      }
      i = paramInt;
      if (this.tiH != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tiH);
      }
      paramInt = i;
      if (this.tiI != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tiI);
      }
      i = paramInt;
      if (this.tiJ != null) {
        i = paramInt + d.a.a.a.gA(11, this.tiJ.btq());
      }
      paramInt = i;
      if (this.tiK != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tiK);
      }
      i = paramInt;
      if (this.tiL != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.tiL);
      }
      paramInt = i;
      if (this.tiM != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.tiM);
      }
      i = paramInt;
      if (this.tiN != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tiN);
      }
      paramInt = i;
      if (this.tiO != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.tiO);
      }
      return paramInt + d.a.a.a.gy(17, this.tiq) + d.a.a.a.c(18, 8, this.tir);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tir.clear();
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
        ams localams = (ams)paramVarArgs[1];
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
            localams.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localams.tiD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localams.lsL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localams.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localams.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localams.tiE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localams.tiF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localams.tiG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localams.tiH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localams.tiI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localams.tiJ = ((chu)localObject1);
            paramInt += 1;
          }
        case 12: 
          localams.tiK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localams.tiL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localams.tiM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localams.tiN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localams.tiO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localams.tiq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cho();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cho)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localams.tir.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ams
 * JD-Core Version:    0.7.0.1
 */