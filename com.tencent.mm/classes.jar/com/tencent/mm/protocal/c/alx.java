package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class alx
  extends bly
{
  public String dRj;
  public boolean jym;
  public LinkedList<zh> svE = new LinkedList();
  public LinkedList<String> thO = new LinkedList();
  public String thP;
  public String thQ;
  public boolean thS;
  public LinkedList<cnr> thV = new LinkedList();
  public LinkedList<cns> thW = new LinkedList();
  public String thX;
  public String thY;
  public String thZ;
  public String tia;
  public boolean tib;
  public int tic;
  public String tie;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.thX == null) {
        throw new b("Not all required fields were included: championcoverurl");
      }
      if (this.thY == null) {
        throw new b("Not all required fields were included: championmotto");
      }
      if (this.dRj == null) {
        throw new b("Not all required fields were included: rankid");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.d(2, 8, this.thV);
      paramVarArgs.d(3, 8, this.thW);
      paramVarArgs.d(4, 1, this.thO);
      if (this.thX != null) {
        paramVarArgs.d(5, this.thX);
      }
      if (this.thY != null) {
        paramVarArgs.d(6, this.thY);
      }
      if (this.dRj != null) {
        paramVarArgs.d(7, this.dRj);
      }
      if (this.thZ != null) {
        paramVarArgs.d(8, this.thZ);
      }
      if (this.thP != null) {
        paramVarArgs.d(9, this.thP);
      }
      paramVarArgs.aA(10, this.jym);
      if (this.thQ != null) {
        paramVarArgs.d(11, this.thQ);
      }
      paramVarArgs.d(12, 8, this.svE);
      paramVarArgs.aA(13, this.thS);
      if (this.tia != null) {
        paramVarArgs.d(14, this.tia);
      }
      paramVarArgs.aA(15, this.tib);
      paramVarArgs.gB(16, this.tic);
      if (this.tie != null) {
        paramVarArgs.d(17, this.tie);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1454;
      }
    }
    label1454:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.thV) + d.a.a.a.c(3, 8, this.thW) + d.a.a.a.c(4, 1, this.thO);
      paramInt = i;
      if (this.thX != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.thX);
      }
      i = paramInt;
      if (this.thY != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.thY);
      }
      paramInt = i;
      if (this.dRj != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.dRj);
      }
      i = paramInt;
      if (this.thZ != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.thZ);
      }
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.thP);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(10) + 1);
      paramInt = i;
      if (this.thQ != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.thQ);
      }
      i = paramInt + d.a.a.a.c(12, 8, this.svE) + (d.a.a.b.b.a.dQ(13) + 1);
      paramInt = i;
      if (this.tia != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.tia);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(15) + 1) + d.a.a.a.gy(16, this.tic);
      paramInt = i;
      if (this.tie != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.tie);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thV.clear();
        this.thW.clear();
        this.thO.clear();
        this.svE.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.thX == null) {
          throw new b("Not all required fields were included: championcoverurl");
        }
        if (this.thY == null) {
          throw new b("Not all required fields were included: championmotto");
        }
        if (this.dRj != null) {
          break;
        }
        throw new b("Not all required fields were included: rankid");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        alx localalx = (alx)paramVarArgs[1];
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
            localalx.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalx.thV.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cns();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cns)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalx.thW.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localalx.thO.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 5: 
          localalx.thX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localalx.thY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localalx.dRj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localalx.thZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localalx.thP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localalx.jym = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 11: 
          localalx.thQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localalx.svE.add(localObject1);
            paramInt += 1;
          }
        case 13: 
          localalx.thS = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 14: 
          localalx.tia = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localalx.tib = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 16: 
          localalx.tic = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localalx.tie = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.alx
 * JD-Core Version:    0.7.0.1
 */