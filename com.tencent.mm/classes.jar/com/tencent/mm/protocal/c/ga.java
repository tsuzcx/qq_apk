package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ga
  extends com.tencent.mm.bv.a
{
  public bmk sAc;
  public chv sAd;
  public clp sAe;
  public int sAf;
  public bmk syn;
  public bmk syo;
  public String syt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sAc != null)
      {
        paramVarArgs.gD(1, this.sAc.btq());
        this.sAc.a(paramVarArgs);
      }
      if (this.sAd != null)
      {
        paramVarArgs.gD(2, this.sAd.btq());
        this.sAd.a(paramVarArgs);
      }
      if (this.sAe != null)
      {
        paramVarArgs.gD(3, this.sAe.btq());
        this.sAe.a(paramVarArgs);
      }
      if (this.syn != null)
      {
        paramVarArgs.gD(4, this.syn.btq());
        this.syn.a(paramVarArgs);
      }
      if (this.syo != null)
      {
        paramVarArgs.gD(5, this.syo.btq());
        this.syo.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.sAf);
      if (this.syt != null) {
        paramVarArgs.d(7, this.syt);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sAc == null) {
        break label959;
      }
    }
    label959:
    for (int i = d.a.a.a.gA(1, this.sAc.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sAd != null) {
        paramInt = i + d.a.a.a.gA(2, this.sAd.btq());
      }
      i = paramInt;
      if (this.sAe != null) {
        i = paramInt + d.a.a.a.gA(3, this.sAe.btq());
      }
      paramInt = i;
      if (this.syn != null) {
        paramInt = i + d.a.a.a.gA(4, this.syn.btq());
      }
      i = paramInt;
      if (this.syo != null) {
        i = paramInt + d.a.a.a.gA(5, this.syo.btq());
      }
      i += d.a.a.a.gy(6, this.sAf);
      paramInt = i;
      if (this.syt != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.syt);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ga localga = (ga)paramVarArgs[1];
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
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localga.sAc = ((bmk)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localga.sAd = ((chv)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localga.sAe = ((clp)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localga.syn = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localga.syo = ((bmk)localObject1);
            paramInt += 1;
          }
        case 6: 
          localga.sAf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localga.syt = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ga
 * JD-Core Version:    0.7.0.1
 */