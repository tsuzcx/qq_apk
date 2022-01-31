package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class adb
  extends bly
{
  public ld sCd;
  public ld sCe;
  public ld sCf;
  public bmk sCg;
  public bmk sCh;
  public ld sCi;
  public int sCj;
  public lc sCk;
  public lc sCl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sCd == null) {
        throw new b("Not all required fields were included: DnsInfo");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sCd != null)
      {
        paramVarArgs.gD(2, this.sCd.btq());
        this.sCd.a(paramVarArgs);
      }
      if (this.sCe != null)
      {
        paramVarArgs.gD(3, this.sCe.btq());
        this.sCe.a(paramVarArgs);
      }
      if (this.sCf != null)
      {
        paramVarArgs.gD(4, this.sCf.btq());
        this.sCf.a(paramVarArgs);
      }
      if (this.sCg != null)
      {
        paramVarArgs.gD(5, this.sCg.btq());
        this.sCg.a(paramVarArgs);
      }
      if (this.sCh != null)
      {
        paramVarArgs.gD(6, this.sCh.btq());
        this.sCh.a(paramVarArgs);
      }
      if (this.sCi != null)
      {
        paramVarArgs.gD(7, this.sCi.btq());
        this.sCi.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.sCj);
      if (this.sCk != null)
      {
        paramVarArgs.gD(9, this.sCk.btq());
        this.sCk.a(paramVarArgs);
      }
      if (this.sCl != null)
      {
        paramVarArgs.gD(10, this.sCl.btq());
        this.sCl.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1564;
      }
    }
    label1564:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sCd != null) {
        paramInt = i + d.a.a.a.gA(2, this.sCd.btq());
      }
      i = paramInt;
      if (this.sCe != null) {
        i = paramInt + d.a.a.a.gA(3, this.sCe.btq());
      }
      paramInt = i;
      if (this.sCf != null) {
        paramInt = i + d.a.a.a.gA(4, this.sCf.btq());
      }
      i = paramInt;
      if (this.sCg != null) {
        i = paramInt + d.a.a.a.gA(5, this.sCg.btq());
      }
      paramInt = i;
      if (this.sCh != null) {
        paramInt = i + d.a.a.a.gA(6, this.sCh.btq());
      }
      i = paramInt;
      if (this.sCi != null) {
        i = paramInt + d.a.a.a.gA(7, this.sCi.btq());
      }
      i += d.a.a.a.gy(8, this.sCj);
      paramInt = i;
      if (this.sCk != null) {
        paramInt = i + d.a.a.a.gA(9, this.sCk.btq());
      }
      i = paramInt;
      if (this.sCl != null) {
        i = paramInt + d.a.a.a.gA(10, this.sCl.btq());
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
        if (this.sCd != null) {
          break;
        }
        throw new b("Not all required fields were included: DnsInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        adb localadb = (adb)paramVarArgs[1];
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
            localadb.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localadb.sCd = ((ld)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localadb.sCe = ((ld)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localadb.sCf = ((ld)localObject1);
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
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localadb.sCg = ((bmk)localObject1);
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
            localadb.sCh = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localadb.sCi = ((ld)localObject1);
            paramInt += 1;
          }
        case 8: 
          localadb.sCj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localadb.sCk = ((lc)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lc();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localadb.sCl = ((lc)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.adb
 * JD-Core Version:    0.7.0.1
 */