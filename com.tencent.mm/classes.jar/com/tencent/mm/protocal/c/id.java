package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class id
  extends bly
{
  public int hQq;
  public bmo sBI;
  public String sBP;
  public bml sBS;
  public bmk sBT;
  public int sBV;
  public String sBW;
  public String sBX;
  public int stS;
  public int stV;
  public bmk svJ;
  public bmk syk;
  public bmk syq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sBP != null) {
        paramVarArgs.d(2, this.sBP);
      }
      if (this.svJ != null)
      {
        paramVarArgs.gD(3, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.stV);
      paramVarArgs.gB(5, this.sBV);
      if (this.sBW != null) {
        paramVarArgs.d(6, this.sBW);
      }
      paramVarArgs.gB(7, this.hQq);
      if (this.sBX != null) {
        paramVarArgs.d(8, this.sBX);
      }
      if (this.sBS != null)
      {
        paramVarArgs.gD(9, this.sBS.btq());
        this.sBS.a(paramVarArgs);
      }
      if (this.syq != null)
      {
        paramVarArgs.gD(10, this.syq.btq());
        this.syq.a(paramVarArgs);
      }
      if (this.sBT != null)
      {
        paramVarArgs.gD(11, this.sBT.btq());
        this.sBT.a(paramVarArgs);
      }
      if (this.sBI != null)
      {
        paramVarArgs.gD(12, this.sBI.btq());
        this.sBI.a(paramVarArgs);
      }
      paramVarArgs.gB(13, this.stS);
      if (this.syk != null)
      {
        paramVarArgs.gD(14, this.syk.btq());
        this.syk.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1560;
      }
    }
    label1560:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sBP != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sBP);
      }
      i = paramInt;
      if (this.svJ != null) {
        i = paramInt + d.a.a.a.gA(3, this.svJ.btq());
      }
      i = i + d.a.a.a.gy(4, this.stV) + d.a.a.a.gy(5, this.sBV);
      paramInt = i;
      if (this.sBW != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sBW);
      }
      i = paramInt + d.a.a.a.gy(7, this.hQq);
      paramInt = i;
      if (this.sBX != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sBX);
      }
      i = paramInt;
      if (this.sBS != null) {
        i = paramInt + d.a.a.a.gA(9, this.sBS.btq());
      }
      paramInt = i;
      if (this.syq != null) {
        paramInt = i + d.a.a.a.gA(10, this.syq.btq());
      }
      i = paramInt;
      if (this.sBT != null) {
        i = paramInt + d.a.a.a.gA(11, this.sBT.btq());
      }
      paramInt = i;
      if (this.sBI != null) {
        paramInt = i + d.a.a.a.gA(12, this.sBI.btq());
      }
      i = paramInt + d.a.a.a.gy(13, this.stS);
      paramInt = i;
      if (this.syk != null) {
        paramInt = i + d.a.a.a.gA(14, this.syk.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.svJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        id localid = (id)paramVarArgs[1];
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
            localid.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localid.sBP = ((d.a.a.a.a)localObject1).xpH.readString();
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
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localid.svJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localid.stV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localid.sBV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localid.sBW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localid.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localid.sBX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localid.sBS = ((bml)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localid.syq = ((bmk)localObject1);
            paramInt += 1;
          }
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localid.sBT = ((bmk)localObject1);
            paramInt += 1;
          }
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localid.sBI = ((bmo)localObject1);
            paramInt += 1;
          }
        case 13: 
          localid.stS = ((d.a.a.a.a)localObject1).xpH.oD();
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
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localid.syk = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.id
 * JD-Core Version:    0.7.0.1
 */