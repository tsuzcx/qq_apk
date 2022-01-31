package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class yj
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String fGK;
  public boolean sUA = false;
  public boolean sUz = false;
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
  public yp sXa;
  public boolean sXb = false;
  public LinkedList<xv> sXc = new LinkedList();
  public boolean sXd = false;
  public boolean sXe = false;
  public yd sro;
  public long srp;
  public String title;
  public int version;
  
  public final yj EO(int paramInt)
  {
    this.sWq = paramInt;
    this.sWr = true;
    return this;
  }
  
  public final yj EP(int paramInt)
  {
    this.version = paramInt;
    this.sXe = true;
    return this;
  }
  
  public final yj Yn(String paramString)
  {
    this.fGK = paramString;
    this.sWn = true;
    return this;
  }
  
  public final yj Yo(String paramString)
  {
    this.title = paramString;
    this.sUz = true;
    return this;
  }
  
  public final yj Yp(String paramString)
  {
    this.desc = paramString;
    this.sUA = true;
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sXa != null)
      {
        paramVarArgs.gD(1, this.sXa.btq());
        this.sXa.a(paramVarArgs);
      }
      paramVarArgs.d(2, 8, this.sXc);
      if (this.sWf != null)
      {
        paramVarArgs.gD(3, this.sWf.btq());
        this.sWf.a(paramVarArgs);
      }
      if (this.sWh != null)
      {
        paramVarArgs.gD(4, this.sWh.btq());
        this.sWh.a(paramVarArgs);
      }
      if (this.fGK != null) {
        paramVarArgs.d(5, this.fGK);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(7, this.desc);
      }
      if (this.sWp == true) {
        paramVarArgs.Y(8, this.sWo);
      }
      if (this.sWr == true) {
        paramVarArgs.gB(91, this.sWq);
      }
      if (this.sWj != null)
      {
        paramVarArgs.gD(10, this.sWj.btq());
        this.sWj.a(paramVarArgs);
      }
      if (this.sWs == true) {
        paramVarArgs.Y(11, this.srp);
      }
      if (this.sWl != null)
      {
        paramVarArgs.gD(12, this.sWl.btq());
        this.sWl.a(paramVarArgs);
      }
      if (this.sXe == true) {
        paramVarArgs.gB(13, this.version);
      }
      if (this.sro != null)
      {
        paramVarArgs.gD(14, this.sro.btq());
        this.sro.a(paramVarArgs);
      }
      if (this.sWu != null)
      {
        paramVarArgs.gD(15, this.sWu.btq());
        this.sWu.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sXa == null) {
        break label1863;
      }
    }
    label1863:
    for (paramInt = d.a.a.a.gA(1, this.sXa.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.sXc);
      paramInt = i;
      if (this.sWf != null) {
        paramInt = i + d.a.a.a.gA(3, this.sWf.btq());
      }
      i = paramInt;
      if (this.sWh != null) {
        i = paramInt + d.a.a.a.gA(4, this.sWh.btq());
      }
      paramInt = i;
      if (this.fGK != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.fGK);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.desc);
      }
      i = paramInt;
      if (this.sWp == true) {
        i = paramInt + d.a.a.a.X(8, this.sWo);
      }
      paramInt = i;
      if (this.sWr == true) {
        paramInt = i + d.a.a.a.gy(91, this.sWq);
      }
      i = paramInt;
      if (this.sWj != null) {
        i = paramInt + d.a.a.a.gA(10, this.sWj.btq());
      }
      paramInt = i;
      if (this.sWs == true) {
        paramInt = i + d.a.a.a.X(11, this.srp);
      }
      i = paramInt;
      if (this.sWl != null) {
        i = paramInt + d.a.a.a.gA(12, this.sWl.btq());
      }
      paramInt = i;
      if (this.sXe == true) {
        paramInt = i + d.a.a.a.gy(13, this.version);
      }
      i = paramInt;
      if (this.sro != null) {
        i = paramInt + d.a.a.a.gA(14, this.sro.btq());
      }
      paramInt = i;
      if (this.sWu != null) {
        paramInt = i + d.a.a.a.gA(15, this.sWu.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sXc.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        yj localyj = (yj)paramVarArgs[1];
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
            localObject1 = new yp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyj.sXa = ((yp)localObject1);
            paramInt += 1;
          }
          localyj.sXb = true;
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyj.sXc.add(localObject1);
            paramInt += 1;
          }
          localyj.sXd = true;
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyj.sWf = ((yc)localObject1);
            paramInt += 1;
          }
          localyj.sWg = true;
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyj.sWh = ((yy)localObject1);
            paramInt += 1;
          }
          localyj.sWi = true;
          return 0;
        case 5: 
          localyj.fGK = ((d.a.a.a.a)localObject1).xpH.readString();
          localyj.sWn = true;
          return 0;
        case 6: 
          localyj.title = ((d.a.a.a.a)localObject1).xpH.readString();
          localyj.sUz = true;
          return 0;
        case 7: 
          localyj.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          localyj.sUA = true;
          return 0;
        case 8: 
          localyj.sWo = ((d.a.a.a.a)localObject1).xpH.oE();
          localyj.sWp = true;
          return 0;
        case 91: 
          localyj.sWq = ((d.a.a.a.a)localObject1).xpH.oD();
          localyj.sWr = true;
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyj.sWj = ((yi)localObject1);
            paramInt += 1;
          }
          localyj.sWk = true;
          return 0;
        case 11: 
          localyj.srp = ((d.a.a.a.a)localObject1).xpH.oE();
          localyj.sWs = true;
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ys();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ys)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyj.sWl = ((ys)localObject1);
            paramInt += 1;
          }
          localyj.sWm = true;
          return 0;
        case 13: 
          localyj.version = ((d.a.a.a.a)localObject1).xpH.oD();
          localyj.sXe = true;
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localyj.sro = ((yd)localObject1);
            paramInt += 1;
          }
          localyj.sWt = true;
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
          localyj.sWu = ((xt)localObject1);
          paramInt += 1;
        }
        localyj.sWv = true;
        return 0;
      }
      return -1;
    }
  }
  
  public final yj a(yd paramyd)
  {
    this.sro = paramyd;
    this.sWt = true;
    return this;
  }
  
  public final yj a(yp paramyp)
  {
    this.sXa = paramyp;
    this.sXb = true;
    return this;
  }
  
  public final yj az(LinkedList<xv> paramLinkedList)
  {
    this.sXc = paramLinkedList;
    this.sXd = true;
    return this;
  }
  
  public final yj b(yc paramyc)
  {
    this.sWf = paramyc;
    this.sWg = true;
    return this;
  }
  
  public final yj b(yi paramyi)
  {
    this.sWj = paramyi;
    this.sWk = true;
    return this;
  }
  
  public final yj b(ys paramys)
  {
    this.sWl = paramys;
    this.sWm = true;
    return this;
  }
  
  public final yj b(yy paramyy)
  {
    this.sWh = paramyy;
    this.sWi = true;
    return this;
  }
  
  public final yj hj(long paramLong)
  {
    this.sWo = paramLong;
    this.sWp = true;
    return this;
  }
  
  public final yj hk(long paramLong)
  {
    this.srp = paramLong;
    this.sWs = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yj
 * JD-Core Version:    0.7.0.1
 */