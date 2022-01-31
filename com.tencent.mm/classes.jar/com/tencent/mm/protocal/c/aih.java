package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aih
  extends bly
{
  public String kSC;
  public String sFF;
  public String sRA;
  public String ssG;
  public int ssq;
  public bmk teH;
  public String teQ;
  public int teR;
  public int tfA;
  public int tfy;
  public LinkedList<bco> tfz = new LinkedList();
  
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
      paramVarArgs.gB(2, this.tfy);
      paramVarArgs.d(3, 8, this.tfz);
      paramVarArgs.gB(4, this.ssq);
      paramVarArgs.gB(5, this.tfA);
      if (this.teH != null)
      {
        paramVarArgs.gD(6, this.teH.btq());
        this.teH.a(paramVarArgs);
      }
      if (this.kSC != null) {
        paramVarArgs.d(7, this.kSC);
      }
      if (this.teQ != null) {
        paramVarArgs.d(8, this.teQ);
      }
      if (this.sRA != null) {
        paramVarArgs.d(9, this.sRA);
      }
      if (this.ssG != null) {
        paramVarArgs.d(10, this.ssG);
      }
      paramVarArgs.gB(11, this.teR);
      if (this.sFF != null) {
        paramVarArgs.d(12, this.sFF);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1058;
      }
    }
    label1058:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tfy) + d.a.a.a.c(3, 8, this.tfz) + d.a.a.a.gy(4, this.ssq) + d.a.a.a.gy(5, this.tfA);
      paramInt = i;
      if (this.teH != null) {
        paramInt = i + d.a.a.a.gA(6, this.teH.btq());
      }
      i = paramInt;
      if (this.kSC != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.kSC);
      }
      paramInt = i;
      if (this.teQ != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.teQ);
      }
      i = paramInt;
      if (this.sRA != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sRA);
      }
      paramInt = i;
      if (this.ssG != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.ssG);
      }
      i = paramInt + d.a.a.a.gy(11, this.teR);
      paramInt = i;
      if (this.sFF != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.sFF);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tfz.clear();
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
        aih localaih = (aih)paramVarArgs[1];
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
            localaih.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaih.tfy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bco();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bco)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaih.tfz.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localaih.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localaih.tfA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaih.teH = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          localaih.kSC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localaih.teQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localaih.sRA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localaih.ssG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localaih.teR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaih.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aih
 * JD-Core Version:    0.7.0.1
 */