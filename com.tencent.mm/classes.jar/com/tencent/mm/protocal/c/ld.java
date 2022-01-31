package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ld
  extends com.tencent.mm.bv.a
{
  public int jwX;
  public LinkedList<le> sGA = new LinkedList();
  public int sGB;
  public int sGC;
  public int sGp;
  public int sGq;
  public int sGr;
  public int sGs;
  public LinkedList<bml> sGt = new LinkedList();
  public String sGu;
  public bmk sGv;
  public int sGw;
  public int sGx;
  public LinkedList<bml> sGy = new LinkedList();
  public LinkedList<le> sGz = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sGv == null) {
        throw new b("Not all required fields were included: AuthKey");
      }
      paramVarArgs.gB(1, this.sGp);
      paramVarArgs.gB(2, this.jwX);
      paramVarArgs.gB(3, this.sGq);
      paramVarArgs.gB(4, this.sGr);
      paramVarArgs.gB(5, this.sGs);
      paramVarArgs.d(6, 8, this.sGt);
      if (this.sGu != null) {
        paramVarArgs.d(7, this.sGu);
      }
      if (this.sGv != null)
      {
        paramVarArgs.gD(8, this.sGv.btq());
        this.sGv.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.sGw);
      paramVarArgs.gB(10, this.sGx);
      paramVarArgs.d(11, 8, this.sGy);
      paramVarArgs.d(12, 8, this.sGz);
      paramVarArgs.d(13, 8, this.sGA);
      paramVarArgs.gB(14, this.sGB);
      paramVarArgs.gB(15, this.sGC);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.sGp) + 0 + d.a.a.a.gy(2, this.jwX) + d.a.a.a.gy(3, this.sGq) + d.a.a.a.gy(4, this.sGr) + d.a.a.a.gy(5, this.sGs) + d.a.a.a.c(6, 8, this.sGt);
      paramInt = i;
      if (this.sGu != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sGu);
      }
      i = paramInt;
      if (this.sGv != null) {
        i = paramInt + d.a.a.a.gA(8, this.sGv.btq());
      }
      return i + d.a.a.a.gy(9, this.sGw) + d.a.a.a.gy(10, this.sGx) + d.a.a.a.c(11, 8, this.sGy) + d.a.a.a.c(12, 8, this.sGz) + d.a.a.a.c(13, 8, this.sGA) + d.a.a.a.gy(14, this.sGB) + d.a.a.a.gy(15, this.sGC);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sGt.clear();
      this.sGy.clear();
      this.sGz.clear();
      this.sGA.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sGv == null) {
        throw new b("Not all required fields were included: AuthKey");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      ld localld = (ld)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localld.sGp = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localld.jwX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localld.sGq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localld.sGr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localld.sGs = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localld.sGt.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        localld.sGu = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localld.sGv = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 9: 
        localld.sGw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localld.sGx = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localld.sGy.add(localObject1);
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
          localObject1 = new le();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((le)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localld.sGz.add(localObject1);
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
          localObject1 = new le();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((le)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localld.sGA.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 14: 
        localld.sGB = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localld.sGC = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ld
 * JD-Core Version:    0.7.0.1
 */