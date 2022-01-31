package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class alv
  extends bly
{
  public String aWf;
  public int jEz;
  public String jxO;
  public String jxQ;
  public boolean jxZ;
  public LinkedList<zh> svE = new LinkedList();
  public LinkedList<bvw> swj = new LinkedList();
  public String thK;
  public cnt thL;
  public LinkedList<cnv> thM = new LinkedList();
  public LinkedList<cnu> thN = new LinkedList();
  public LinkedList<String> thO = new LinkedList();
  public String thP;
  public String thQ;
  public LinkedList<kz> thR = new LinkedList();
  public boolean thS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.thK == null) {
        throw new b("Not all required fields were included: coverurl");
      }
      if (this.jxQ == null) {
        throw new b("Not all required fields were included: motto");
      }
      if (this.thL == null) {
        throw new b("Not all required fields were included: rankdesc");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.thK != null) {
        paramVarArgs.d(2, this.thK);
      }
      if (this.jxQ != null) {
        paramVarArgs.d(3, this.jxQ);
      }
      if (this.thL != null)
      {
        paramVarArgs.gD(4, this.thL.btq());
        this.thL.a(paramVarArgs);
      }
      paramVarArgs.d(5, 8, this.thM);
      paramVarArgs.d(6, 8, this.thN);
      if (this.aWf != null) {
        paramVarArgs.d(7, this.aWf);
      }
      paramVarArgs.d(8, 1, this.thO);
      if (this.thP != null) {
        paramVarArgs.d(9, this.thP);
      }
      if (this.thQ != null) {
        paramVarArgs.d(10, this.thQ);
      }
      paramVarArgs.d(14, 8, this.swj);
      paramVarArgs.d(15, 8, this.svE);
      paramVarArgs.aA(16, this.jxZ);
      paramVarArgs.d(17, 8, this.thR);
      paramVarArgs.aA(18, this.thS);
      paramVarArgs.gB(19, this.jEz);
      if (this.jxO != null) {
        paramVarArgs.d(20, this.jxO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1731;
      }
    }
    label1731:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.thK);
      }
      i = paramInt;
      if (this.jxQ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.jxQ);
      }
      paramInt = i;
      if (this.thL != null) {
        paramInt = i + d.a.a.a.gA(4, this.thL.btq());
      }
      i = paramInt + d.a.a.a.c(5, 8, this.thM) + d.a.a.a.c(6, 8, this.thN);
      paramInt = i;
      if (this.aWf != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.aWf);
      }
      i = paramInt + d.a.a.a.c(8, 1, this.thO);
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.thP);
      }
      i = paramInt;
      if (this.thQ != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.thQ);
      }
      i = i + d.a.a.a.c(14, 8, this.swj) + d.a.a.a.c(15, 8, this.svE) + (d.a.a.b.b.a.dQ(16) + 1) + d.a.a.a.c(17, 8, this.thR) + (d.a.a.b.b.a.dQ(18) + 1) + d.a.a.a.gy(19, this.jEz);
      paramInt = i;
      if (this.jxO != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.jxO);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thM.clear();
        this.thN.clear();
        this.thO.clear();
        this.swj.clear();
        this.svE.clear();
        this.thR.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.thK == null) {
          throw new b("Not all required fields were included: coverurl");
        }
        if (this.jxQ == null) {
          throw new b("Not all required fields were included: motto");
        }
        if (this.thL != null) {
          break;
        }
        throw new b("Not all required fields were included: rankdesc");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        alv localalv = (alv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
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
            localalv.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localalv.thK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localalv.jxQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalv.thL = ((cnt)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalv.thM.add(localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalv.thN.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          localalv.aWf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localalv.thO.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 9: 
          localalv.thP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localalv.thQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalv.swj.add(localObject1);
            paramInt += 1;
          }
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalv.svE.add(localObject1);
            paramInt += 1;
          }
        case 16: 
          localalv.jxZ = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 17: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((kz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalv.thR.add(localObject1);
            paramInt += 1;
          }
        case 18: 
          localalv.thS = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 19: 
          localalv.jEz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localalv.jxO = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.alv
 * JD-Core Version:    0.7.0.1
 */