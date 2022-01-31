package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class xw
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String fGK;
  public boolean sUA = false;
  public boolean sUz = false;
  public xx sWd;
  public boolean sWe = false;
  public yc sWf;
  public boolean sWg = false;
  public yy sWh;
  public boolean sWi = false;
  public yi sWj;
  public boolean sWk = false;
  public ys sWl;
  public boolean sWm = false;
  public boolean sWn = false;
  public long sWo;
  public boolean sWp = false;
  public int sWq = -1;
  public boolean sWr = false;
  public boolean sWs = false;
  public boolean sWt = false;
  public xt sWu;
  public boolean sWv = false;
  public yd sro;
  public long srp;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sWd != null)
      {
        paramVarArgs.gD(1, this.sWd.btq());
        this.sWd.a(paramVarArgs);
      }
      if (this.sWf != null)
      {
        paramVarArgs.gD(2, this.sWf.btq());
        this.sWf.a(paramVarArgs);
      }
      if (this.sWh != null)
      {
        paramVarArgs.gD(3, this.sWh.btq());
        this.sWh.a(paramVarArgs);
      }
      if (this.sWj != null)
      {
        paramVarArgs.gD(4, this.sWj.btq());
        this.sWj.a(paramVarArgs);
      }
      if (this.sWl != null)
      {
        paramVarArgs.gD(5, this.sWl.btq());
        this.sWl.a(paramVarArgs);
      }
      if (this.fGK != null) {
        paramVarArgs.d(6, this.fGK);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      if (this.sWp == true) {
        paramVarArgs.Y(9, this.sWo);
      }
      if (this.sWr == true) {
        paramVarArgs.gB(101, this.sWq);
      }
      if (this.sWs == true) {
        paramVarArgs.Y(11, this.srp);
      }
      if (this.sro != null)
      {
        paramVarArgs.gD(12, this.sro.btq());
        this.sro.a(paramVarArgs);
      }
      if (this.sWu != null)
      {
        paramVarArgs.gD(13, this.sWu.btq());
        this.sWu.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sWd == null) {
        break label1645;
      }
    }
    label1645:
    for (int i = d.a.a.a.gA(1, this.sWd.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sWf != null) {
        paramInt = i + d.a.a.a.gA(2, this.sWf.btq());
      }
      i = paramInt;
      if (this.sWh != null) {
        i = paramInt + d.a.a.a.gA(3, this.sWh.btq());
      }
      paramInt = i;
      if (this.sWj != null) {
        paramInt = i + d.a.a.a.gA(4, this.sWj.btq());
      }
      i = paramInt;
      if (this.sWl != null) {
        i = paramInt + d.a.a.a.gA(5, this.sWl.btq());
      }
      paramInt = i;
      if (this.fGK != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.fGK);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.desc);
      }
      i = paramInt;
      if (this.sWp == true) {
        i = paramInt + d.a.a.a.X(9, this.sWo);
      }
      paramInt = i;
      if (this.sWr == true) {
        paramInt = i + d.a.a.a.gy(101, this.sWq);
      }
      i = paramInt;
      if (this.sWs == true) {
        i = paramInt + d.a.a.a.X(11, this.srp);
      }
      paramInt = i;
      if (this.sro != null) {
        paramInt = i + d.a.a.a.gA(12, this.sro.btq());
      }
      i = paramInt;
      if (this.sWu != null) {
        i = paramInt + d.a.a.a.gA(13, this.sWu.btq());
      }
      return i;
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
        xw localxw = (xw)paramVarArgs[1];
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
            localObject1 = new xx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localxw.sWd = ((xx)localObject1);
            paramInt += 1;
          }
          localxw.sWe = true;
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localxw.sWf = ((yc)localObject1);
            paramInt += 1;
          }
          localxw.sWg = true;
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localxw.sWh = ((yy)localObject1);
            paramInt += 1;
          }
          localxw.sWi = true;
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localxw.sWj = ((yi)localObject1);
            paramInt += 1;
          }
          localxw.sWk = true;
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ys();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ys)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localxw.sWl = ((ys)localObject1);
            paramInt += 1;
          }
          localxw.sWm = true;
          return 0;
        case 6: 
          localxw.fGK = ((d.a.a.a.a)localObject1).xpH.readString();
          localxw.sWn = true;
          return 0;
        case 7: 
          localxw.title = ((d.a.a.a.a)localObject1).xpH.readString();
          localxw.sUz = true;
          return 0;
        case 8: 
          localxw.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          localxw.sUA = true;
          return 0;
        case 9: 
          localxw.sWo = ((d.a.a.a.a)localObject1).xpH.oE();
          localxw.sWp = true;
          return 0;
        case 101: 
          localxw.sWq = ((d.a.a.a.a)localObject1).xpH.oD();
          localxw.sWr = true;
          return 0;
        case 11: 
          localxw.srp = ((d.a.a.a.a)localObject1).xpH.oE();
          localxw.sWs = true;
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localxw.sro = ((yd)localObject1);
            paramInt += 1;
          }
          localxw.sWt = true;
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xt();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localxw.sWu = ((xt)localObject1);
          paramInt += 1;
        }
        localxw.sWv = true;
        return 0;
      }
      return -1;
    }
  }
  
  public final xw a(xt paramxt)
  {
    this.sWu = paramxt;
    this.sWv = true;
    return this;
  }
  
  public final xw a(yc paramyc)
  {
    this.sWf = paramyc;
    this.sWg = true;
    return this;
  }
  
  public final xw a(yi paramyi)
  {
    this.sWj = paramyi;
    this.sWk = true;
    return this;
  }
  
  public final xw a(ys paramys)
  {
    this.sWl = paramys;
    this.sWm = true;
    return this;
  }
  
  public final xw a(yy paramyy)
  {
    this.sWh = paramyy;
    this.sWi = true;
    return this;
  }
  
  public final xw c(xx paramxx)
  {
    this.sWd = paramxx;
    this.sWe = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xw
 * JD-Core Version:    0.7.0.1
 */