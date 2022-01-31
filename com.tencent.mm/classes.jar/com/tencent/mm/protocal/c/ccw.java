package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ccw
  extends bly
{
  public bml sBS;
  public bmk sBT;
  public String sRr;
  public bmk svJ;
  public bmk syk;
  public String syp;
  public bmk syq;
  public bml tii;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tii == null) {
        throw new b("Not all required fields were included: ImgSid");
      }
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.tii != null)
      {
        paramVarArgs.gD(2, this.tii.btq());
        this.tii.a(paramVarArgs);
      }
      if (this.svJ != null)
      {
        paramVarArgs.gD(3, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      if (this.sRr != null) {
        paramVarArgs.d(4, this.sRr);
      }
      if (this.sBS != null)
      {
        paramVarArgs.gD(5, this.sBS.btq());
        this.sBS.a(paramVarArgs);
      }
      if (this.syq != null)
      {
        paramVarArgs.gD(6, this.syq.btq());
        this.syq.a(paramVarArgs);
      }
      if (this.sBT != null)
      {
        paramVarArgs.gD(7, this.sBT.btq());
        this.sBT.a(paramVarArgs);
      }
      if (this.syp != null) {
        paramVarArgs.d(8, this.syp);
      }
      if (this.syk != null)
      {
        paramVarArgs.gD(9, this.syk.btq());
        this.syk.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1373;
      }
    }
    label1373:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tii != null) {
        paramInt = i + d.a.a.a.gA(2, this.tii.btq());
      }
      i = paramInt;
      if (this.svJ != null) {
        i = paramInt + d.a.a.a.gA(3, this.svJ.btq());
      }
      paramInt = i;
      if (this.sRr != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sRr);
      }
      i = paramInt;
      if (this.sBS != null) {
        i = paramInt + d.a.a.a.gA(5, this.sBS.btq());
      }
      paramInt = i;
      if (this.syq != null) {
        paramInt = i + d.a.a.a.gA(6, this.syq.btq());
      }
      i = paramInt;
      if (this.sBT != null) {
        i = paramInt + d.a.a.a.gA(7, this.sBT.btq());
      }
      paramInt = i;
      if (this.syp != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.syp);
      }
      i = paramInt;
      if (this.syk != null) {
        i = paramInt + d.a.a.a.gA(9, this.syk.btq());
      }
      return i;
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
        if (this.tii == null) {
          throw new b("Not all required fields were included: ImgSid");
        }
        if (this.svJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ccw localccw = (ccw)paramVarArgs[1];
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
            localccw.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localccw.tii = ((bml)localObject1);
            paramInt += 1;
          }
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
            localccw.svJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localccw.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localccw.sBS = ((bml)localObject1);
            paramInt += 1;
          }
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
            localccw.syq = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localccw.sBT = ((bmk)localObject1);
            paramInt += 1;
          }
        case 8: 
          localccw.syp = ((d.a.a.a.a)localObject1).xpH.readString();
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
          localccw.syk = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccw
 * JD-Core Version:    0.7.0.1
 */