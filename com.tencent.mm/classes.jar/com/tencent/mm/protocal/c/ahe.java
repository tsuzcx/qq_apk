package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ahe
  extends bly
{
  public String ffj;
  public int sFD;
  public String sFF;
  public bmk teH;
  public int teM;
  public LinkedList<bml> teN = new LinkedList();
  public int teO;
  public LinkedList<atn> teP = new LinkedList();
  public String teQ;
  public int teR;
  public int teS;
  public ato teT;
  public String teU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.teH == null) {
        throw new b("Not all required fields were included: Buff");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.teH != null)
      {
        paramVarArgs.gD(2, this.teH.btq());
        this.teH.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.teM);
      paramVarArgs.d(4, 8, this.teN);
      paramVarArgs.gB(5, this.teO);
      paramVarArgs.d(6, 8, this.teP);
      paramVarArgs.gB(7, this.sFD);
      if (this.teQ != null) {
        paramVarArgs.d(8, this.teQ);
      }
      if (this.sFF != null) {
        paramVarArgs.d(9, this.sFF);
      }
      paramVarArgs.gB(10, this.teR);
      if (this.ffj != null) {
        paramVarArgs.d(11, this.ffj);
      }
      paramVarArgs.gB(12, this.teS);
      if (this.teT != null)
      {
        paramVarArgs.gD(13, this.teT.btq());
        this.teT.a(paramVarArgs);
      }
      if (this.teU != null) {
        paramVarArgs.d(14, this.teU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1324;
      }
    }
    label1324:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.teH != null) {
        i = paramInt + d.a.a.a.gA(2, this.teH.btq());
      }
      i = i + d.a.a.a.gy(3, this.teM) + d.a.a.a.c(4, 8, this.teN) + d.a.a.a.gy(5, this.teO) + d.a.a.a.c(6, 8, this.teP) + d.a.a.a.gy(7, this.sFD);
      paramInt = i;
      if (this.teQ != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.teQ);
      }
      i = paramInt;
      if (this.sFF != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sFF);
      }
      i += d.a.a.a.gy(10, this.teR);
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.ffj);
      }
      i = paramInt + d.a.a.a.gy(12, this.teS);
      paramInt = i;
      if (this.teT != null) {
        paramInt = i + d.a.a.a.gA(13, this.teT.btq());
      }
      i = paramInt;
      if (this.teU != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.teU);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.teN.clear();
        this.teP.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.teH != null) {
          break;
        }
        throw new b("Not all required fields were included: Buff");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ahe localahe = (ahe)paramVarArgs[1];
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
            localahe.tFx = ((gd)localObject1);
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
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localahe.teH = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localahe.teM = ((d.a.a.a.a)localObject1).xpH.oD();
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localahe.teN.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localahe.teO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localahe.teP.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          localahe.sFD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localahe.teQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localahe.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localahe.teR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localahe.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localahe.teS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ato();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ato)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localahe.teT = ((ato)localObject1);
            paramInt += 1;
          }
        }
        localahe.teU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ahe
 * JD-Core Version:    0.7.0.1
 */