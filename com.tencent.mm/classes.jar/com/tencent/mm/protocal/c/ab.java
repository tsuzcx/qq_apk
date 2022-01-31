package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ab
  extends bly
{
  public bsf ssA;
  public bkb ssB;
  public bsf ssC;
  public bhn ssD;
  public zo ssE;
  public fd ssF;
  public String ssG;
  public String ssH;
  public int ssI;
  public int ssq;
  public String ssw;
  public int ssx;
  public int ssy;
  public String ssz;
  
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
      if (this.ssw != null) {
        paramVarArgs.d(2, this.ssw);
      }
      paramVarArgs.gB(3, this.ssx);
      paramVarArgs.gB(4, this.ssy);
      if (this.ssz != null) {
        paramVarArgs.d(5, this.ssz);
      }
      if (this.ssA != null)
      {
        paramVarArgs.gD(6, this.ssA.btq());
        this.ssA.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.ssq);
      if (this.ssB != null)
      {
        paramVarArgs.gD(8, this.ssB.btq());
        this.ssB.a(paramVarArgs);
      }
      if (this.ssC != null)
      {
        paramVarArgs.gD(9, this.ssC.btq());
        this.ssC.a(paramVarArgs);
      }
      if (this.ssD != null)
      {
        paramVarArgs.gD(10, this.ssD.btq());
        this.ssD.a(paramVarArgs);
      }
      if (this.ssE != null)
      {
        paramVarArgs.gD(11, this.ssE.btq());
        this.ssE.a(paramVarArgs);
      }
      if (this.ssF != null)
      {
        paramVarArgs.gD(12, this.ssF.btq());
        this.ssF.a(paramVarArgs);
      }
      if (this.ssG != null) {
        paramVarArgs.d(13, this.ssG);
      }
      if (this.ssH != null) {
        paramVarArgs.d(14, this.ssH);
      }
      paramVarArgs.gB(15, this.ssI);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1579;
      }
    }
    label1579:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ssw != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ssw);
      }
      i = i + d.a.a.a.gy(3, this.ssx) + d.a.a.a.gy(4, this.ssy);
      paramInt = i;
      if (this.ssz != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.ssz);
      }
      i = paramInt;
      if (this.ssA != null) {
        i = paramInt + d.a.a.a.gA(6, this.ssA.btq());
      }
      i += d.a.a.a.gy(7, this.ssq);
      paramInt = i;
      if (this.ssB != null) {
        paramInt = i + d.a.a.a.gA(8, this.ssB.btq());
      }
      i = paramInt;
      if (this.ssC != null) {
        i = paramInt + d.a.a.a.gA(9, this.ssC.btq());
      }
      paramInt = i;
      if (this.ssD != null) {
        paramInt = i + d.a.a.a.gA(10, this.ssD.btq());
      }
      i = paramInt;
      if (this.ssE != null) {
        i = paramInt + d.a.a.a.gA(11, this.ssE.btq());
      }
      paramInt = i;
      if (this.ssF != null) {
        paramInt = i + d.a.a.a.gA(12, this.ssF.btq());
      }
      i = paramInt;
      if (this.ssG != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.ssG);
      }
      paramInt = i;
      if (this.ssH != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.ssH);
      }
      return paramInt + d.a.a.a.gy(15, this.ssI);
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
        ab localab = (ab)paramVarArgs[1];
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
            localab.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localab.ssw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localab.ssx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localab.ssy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localab.ssz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localab.ssA = ((bsf)localObject1);
            paramInt += 1;
          }
        case 7: 
          localab.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localab.ssB = ((bkb)localObject1);
            paramInt += 1;
          }
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localab.ssC = ((bsf)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localab.ssD = ((bhn)localObject1);
            paramInt += 1;
          }
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localab.ssE = ((zo)localObject1);
            paramInt += 1;
          }
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localab.ssF = ((fd)localObject1);
            paramInt += 1;
          }
        case 13: 
          localab.ssG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localab.ssH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localab.ssI = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ab
 * JD-Core Version:    0.7.0.1
 */