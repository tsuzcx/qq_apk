package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class buq
  extends bly
{
  public LinkedList<bto> sAA = new LinkedList();
  public String tJH;
  public int tJL;
  public int tJM;
  public buf tJN;
  public bmk tJk;
  public int tLh;
  public int tLi;
  public LinkedList<cn> tLj = new LinkedList();
  public int tLk;
  public LinkedList<bjk> tLl = new LinkedList();
  public int ttP;
  
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
      if (this.tJH != null) {
        paramVarArgs.d(2, this.tJH);
      }
      paramVarArgs.gB(3, this.ttP);
      paramVarArgs.d(4, 8, this.sAA);
      paramVarArgs.gB(5, this.tLh);
      paramVarArgs.gB(6, this.tJL);
      paramVarArgs.gB(7, this.tJM);
      if (this.tJN != null)
      {
        paramVarArgs.gD(8, this.tJN.btq());
        this.tJN.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.tLi);
      paramVarArgs.d(10, 8, this.tLj);
      if (this.tJk != null)
      {
        paramVarArgs.gD(11, this.tJk.btq());
        this.tJk.a(paramVarArgs);
      }
      paramVarArgs.gB(12, this.tLk);
      paramVarArgs.d(13, 8, this.tLl);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1287;
      }
    }
    label1287:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tJH != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tJH);
      }
      i = i + d.a.a.a.gy(3, this.ttP) + d.a.a.a.c(4, 8, this.sAA) + d.a.a.a.gy(5, this.tLh) + d.a.a.a.gy(6, this.tJL) + d.a.a.a.gy(7, this.tJM);
      paramInt = i;
      if (this.tJN != null) {
        paramInt = i + d.a.a.a.gA(8, this.tJN.btq());
      }
      i = paramInt + d.a.a.a.gy(9, this.tLi) + d.a.a.a.c(10, 8, this.tLj);
      paramInt = i;
      if (this.tJk != null) {
        paramInt = i + d.a.a.a.gA(11, this.tJk.btq());
      }
      return paramInt + d.a.a.a.gy(12, this.tLk) + d.a.a.a.c(13, 8, this.tLl);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sAA.clear();
        this.tLj.clear();
        this.tLl.clear();
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
        buq localbuq = (buq)paramVarArgs[1];
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
            localbuq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbuq.tJH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbuq.ttP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bto();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bto)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbuq.sAA.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localbuq.tLh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbuq.tJL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbuq.tJM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbuq.tJN = ((buf)localObject1);
            paramInt += 1;
          }
        case 9: 
          localbuq.tLi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbuq.tLj.add(localObject1);
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
            localbuq.tJk = ((bmk)localObject1);
            paramInt += 1;
          }
        case 12: 
          localbuq.tLk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localbuq.tLl.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.buq
 * JD-Core Version:    0.7.0.1
 */