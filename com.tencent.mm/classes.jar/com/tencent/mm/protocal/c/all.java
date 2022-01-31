package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class all
  extends bly
{
  public bmk thA;
  public int thq;
  public String thr;
  public int ths;
  public String tht;
  public int thu;
  public LinkedList<bml> thv = new LinkedList();
  public String thw;
  public int thx;
  public String thy;
  public int thz;
  
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
      paramVarArgs.gB(2, this.thq);
      if (this.thr != null) {
        paramVarArgs.d(3, this.thr);
      }
      paramVarArgs.gB(4, this.ths);
      if (this.tht != null) {
        paramVarArgs.d(5, this.tht);
      }
      paramVarArgs.gB(6, this.thu);
      paramVarArgs.d(7, 8, this.thv);
      if (this.thw != null) {
        paramVarArgs.d(8, this.thw);
      }
      paramVarArgs.gB(9, this.thx);
      if (this.thy != null) {
        paramVarArgs.d(10, this.thy);
      }
      paramVarArgs.gB(11, this.thz);
      if (this.thA != null)
      {
        paramVarArgs.gD(12, this.thA.btq());
        this.thA.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1014;
      }
    }
    label1014:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.thq);
      paramInt = i;
      if (this.thr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.thr);
      }
      i = paramInt + d.a.a.a.gy(4, this.ths);
      paramInt = i;
      if (this.tht != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tht);
      }
      i = paramInt + d.a.a.a.gy(6, this.thu) + d.a.a.a.c(7, 8, this.thv);
      paramInt = i;
      if (this.thw != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.thw);
      }
      i = paramInt + d.a.a.a.gy(9, this.thx);
      paramInt = i;
      if (this.thy != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.thy);
      }
      i = paramInt + d.a.a.a.gy(11, this.thz);
      paramInt = i;
      if (this.thA != null) {
        paramInt = i + d.a.a.a.gA(12, this.thA.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thv.clear();
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
        all localall = (all)paramVarArgs[1];
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
            localall.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localall.thq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localall.thr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localall.ths = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localall.tht = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localall.thu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localall.thv.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localall.thw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localall.thx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localall.thy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localall.thz = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localall.thA = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.all
 * JD-Core Version:    0.7.0.1
 */