package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ahc
  extends bly
{
  public String bZd;
  public String color;
  public int end_time;
  public String iln;
  public String ilp;
  public String ilq;
  public String ilr;
  public String imA;
  public int nZr;
  public String nZs;
  public String nZt;
  public String nZu;
  public String nZw;
  public boolean nZx;
  public boolean teA;
  public String teB;
  public String teC;
  public int teD;
  public String teE;
  public int teF;
  public String teG;
  public boolean tez;
  public String title;
  
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
      paramVarArgs.aA(2, this.tez);
      paramVarArgs.aA(3, this.teA);
      if (this.teB != null) {
        paramVarArgs.d(4, this.teB);
      }
      if (this.teC != null) {
        paramVarArgs.d(5, this.teC);
      }
      paramVarArgs.gB(6, this.teD);
      if (this.teE != null) {
        paramVarArgs.d(7, this.teE);
      }
      paramVarArgs.gB(8, this.teF);
      if (this.iln != null) {
        paramVarArgs.d(9, this.iln);
      }
      if (this.bZd != null) {
        paramVarArgs.d(10, this.bZd);
      }
      if (this.title != null) {
        paramVarArgs.d(11, this.title);
      }
      if (this.ilq != null) {
        paramVarArgs.d(12, this.ilq);
      }
      if (this.ilr != null) {
        paramVarArgs.d(13, this.ilr);
      }
      if (this.imA != null) {
        paramVarArgs.d(14, this.imA);
      }
      if (this.ilp != null) {
        paramVarArgs.d(15, this.ilp);
      }
      if (this.color != null) {
        paramVarArgs.d(16, this.color);
      }
      paramVarArgs.gB(17, this.nZr);
      if (this.nZs != null) {
        paramVarArgs.d(18, this.nZs);
      }
      if (this.nZt != null) {
        paramVarArgs.d(19, this.nZt);
      }
      if (this.nZu != null) {
        paramVarArgs.d(20, this.nZu);
      }
      paramVarArgs.gB(21, this.end_time);
      if (this.nZw != null) {
        paramVarArgs.d(22, this.nZw);
      }
      if (this.teG != null) {
        paramVarArgs.d(23, this.teG);
      }
      paramVarArgs.aA(24, this.nZx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1477;
      }
    }
    label1477:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 1) + (d.a.a.b.b.a.dQ(3) + 1);
      paramInt = i;
      if (this.teB != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.teB);
      }
      i = paramInt;
      if (this.teC != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.teC);
      }
      i += d.a.a.a.gy(6, this.teD);
      paramInt = i;
      if (this.teE != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.teE);
      }
      i = paramInt + d.a.a.a.gy(8, this.teF);
      paramInt = i;
      if (this.iln != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.iln);
      }
      i = paramInt;
      if (this.bZd != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.bZd);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.title);
      }
      i = paramInt;
      if (this.ilq != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.ilq);
      }
      paramInt = i;
      if (this.ilr != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.ilr);
      }
      i = paramInt;
      if (this.imA != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.imA);
      }
      paramInt = i;
      if (this.ilp != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.ilp);
      }
      i = paramInt;
      if (this.color != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.color);
      }
      i += d.a.a.a.gy(17, this.nZr);
      paramInt = i;
      if (this.nZs != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.nZs);
      }
      i = paramInt;
      if (this.nZt != null) {
        i = paramInt + d.a.a.b.b.a.e(19, this.nZt);
      }
      paramInt = i;
      if (this.nZu != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.nZu);
      }
      i = paramInt + d.a.a.a.gy(21, this.end_time);
      paramInt = i;
      if (this.nZw != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.nZw);
      }
      i = paramInt;
      if (this.teG != null) {
        i = paramInt + d.a.a.b.b.a.e(23, this.teG);
      }
      return i + (d.a.a.b.b.a.dQ(24) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        ahc localahc = (ahc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localahc.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localahc.tez = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 3: 
          localahc.teA = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 4: 
          localahc.teB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localahc.teC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localahc.teD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localahc.teE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localahc.teF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localahc.iln = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localahc.bZd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localahc.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localahc.ilq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localahc.ilr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localahc.imA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localahc.ilp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localahc.color = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localahc.nZr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localahc.nZs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localahc.nZt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localahc.nZu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localahc.end_time = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 22: 
          localahc.nZw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 23: 
          localahc.teG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localahc.nZx = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ahc
 * JD-Core Version:    0.7.0.1
 */