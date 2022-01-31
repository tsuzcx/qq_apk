package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class fo
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public int ndm;
  public long ndp;
  public bml svF;
  public bml svG;
  public bml svH;
  public String svK;
  public String swQ;
  public int szk;
  public int szl;
  public int szm;
  public LinkedList<bml> szn = new LinkedList();
  public LinkedList<bmm> szo = new LinkedList();
  public bmk szp;
  public int szq;
  public int szr;
  public int szs;
  public long szt;
  public int szu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svF == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.svH == null) {
        throw new b("Not all required fields were included: Content");
      }
      paramVarArgs.gB(1, this.hQR);
      if (this.swQ != null) {
        paramVarArgs.d(2, this.swQ);
      }
      if (this.svF != null)
      {
        paramVarArgs.gD(3, this.svF.btq());
        this.svF.a(paramVarArgs);
      }
      if (this.svG != null)
      {
        paramVarArgs.gD(4, this.svG.btq());
        this.svG.a(paramVarArgs);
      }
      if (this.svH != null)
      {
        paramVarArgs.gD(5, this.svH.btq());
        this.svH.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.szk);
      paramVarArgs.gB(7, this.szl);
      if (this.svK != null) {
        paramVarArgs.d(8, this.svK);
      }
      paramVarArgs.gB(9, this.ndm);
      paramVarArgs.gB(10, this.szm);
      paramVarArgs.d(11, 8, this.szn);
      paramVarArgs.d(12, 8, this.szo);
      if (this.szp != null)
      {
        paramVarArgs.gD(13, this.szp.btq());
        this.szp.a(paramVarArgs);
      }
      paramVarArgs.gB(14, this.szq);
      paramVarArgs.gB(15, this.szr);
      paramVarArgs.Y(16, this.ndp);
      paramVarArgs.gB(17, this.szs);
      paramVarArgs.Y(18, this.szt);
      paramVarArgs.gB(19, this.szu);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.hQR) + 0;
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.swQ);
      }
      i = paramInt;
      if (this.svF != null) {
        i = paramInt + d.a.a.a.gA(3, this.svF.btq());
      }
      paramInt = i;
      if (this.svG != null) {
        paramInt = i + d.a.a.a.gA(4, this.svG.btq());
      }
      i = paramInt;
      if (this.svH != null) {
        i = paramInt + d.a.a.a.gA(5, this.svH.btq());
      }
      i = i + d.a.a.a.gy(6, this.szk) + d.a.a.a.gy(7, this.szl);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.svK);
      }
      i = paramInt + d.a.a.a.gy(9, this.ndm) + d.a.a.a.gy(10, this.szm) + d.a.a.a.c(11, 8, this.szn) + d.a.a.a.c(12, 8, this.szo);
      paramInt = i;
      if (this.szp != null) {
        paramInt = i + d.a.a.a.gA(13, this.szp.btq());
      }
      return paramInt + d.a.a.a.gy(14, this.szq) + d.a.a.a.gy(15, this.szr) + d.a.a.a.X(16, this.ndp) + d.a.a.a.gy(17, this.szs) + d.a.a.a.X(18, this.szt) + d.a.a.a.gy(19, this.szu);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.szn.clear();
      this.szo.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.svF == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.svH == null) {
        throw new b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      fo localfo = (fo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localfo.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localfo.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfo.svF = ((bml)localObject1);
          paramInt += 1;
        }
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
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfo.svG = ((bml)localObject1);
          paramInt += 1;
        }
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
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfo.svH = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localfo.szk = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localfo.szl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localfo.svK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        localfo.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localfo.szm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfo.szn.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 12: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmm();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfo.szo.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 13: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfo.szp = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 14: 
        localfo.szq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 15: 
        localfo.szr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 16: 
        localfo.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 17: 
        localfo.szs = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 18: 
        localfo.szt = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      localfo.szu = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fo
 * JD-Core Version:    0.7.0.1
 */