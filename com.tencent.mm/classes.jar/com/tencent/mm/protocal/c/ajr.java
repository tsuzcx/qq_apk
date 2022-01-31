package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ajr
  extends bly
{
  public int iHq;
  public String iHr;
  public boolean qqA;
  public String tgh;
  public String tgi;
  public String tgj;
  public String tgk;
  public String tgl;
  public boolean tgm;
  public String tgn;
  public long tgo;
  public boolean tgp;
  public boolean tgq;
  public boolean tgr;
  public String tgs;
  public String tgt;
  public String tgu;
  public String tgv;
  public boolean tgw;
  public LinkedList<String> tgx = new LinkedList();
  public asl tgy;
  
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
      paramVarArgs.gB(2, this.iHq);
      if (this.iHr != null) {
        paramVarArgs.d(3, this.iHr);
      }
      if (this.tgh != null) {
        paramVarArgs.d(4, this.tgh);
      }
      if (this.tgi != null) {
        paramVarArgs.d(5, this.tgi);
      }
      if (this.tgj != null) {
        paramVarArgs.d(6, this.tgj);
      }
      if (this.tgk != null) {
        paramVarArgs.d(7, this.tgk);
      }
      if (this.tgl != null) {
        paramVarArgs.d(8, this.tgl);
      }
      paramVarArgs.aA(9, this.tgm);
      if (this.tgn != null) {
        paramVarArgs.d(10, this.tgn);
      }
      paramVarArgs.Y(11, this.tgo);
      paramVarArgs.aA(12, this.tgp);
      paramVarArgs.aA(13, this.tgq);
      paramVarArgs.aA(14, this.tgr);
      if (this.tgs != null) {
        paramVarArgs.d(15, this.tgs);
      }
      if (this.tgt != null) {
        paramVarArgs.d(16, this.tgt);
      }
      if (this.tgu != null) {
        paramVarArgs.d(17, this.tgu);
      }
      if (this.tgv != null) {
        paramVarArgs.d(18, this.tgv);
      }
      paramVarArgs.aA(19, this.tgw);
      paramVarArgs.d(20, 1, this.tgx);
      paramVarArgs.aA(21, this.qqA);
      if (this.tgy != null)
      {
        paramVarArgs.gD(22, this.tgy.btq());
        this.tgy.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1416;
      }
    }
    label1416:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.tgh != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tgh);
      }
      paramInt = i;
      if (this.tgi != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tgi);
      }
      i = paramInt;
      if (this.tgj != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tgj);
      }
      paramInt = i;
      if (this.tgk != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tgk);
      }
      i = paramInt;
      if (this.tgl != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tgl);
      }
      i += d.a.a.b.b.a.dQ(9) + 1;
      paramInt = i;
      if (this.tgn != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tgn);
      }
      i = paramInt + d.a.a.a.X(11, this.tgo) + (d.a.a.b.b.a.dQ(12) + 1) + (d.a.a.b.b.a.dQ(13) + 1) + (d.a.a.b.b.a.dQ(14) + 1);
      paramInt = i;
      if (this.tgs != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.tgs);
      }
      i = paramInt;
      if (this.tgt != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.tgt);
      }
      paramInt = i;
      if (this.tgu != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.tgu);
      }
      i = paramInt;
      if (this.tgv != null) {
        i = paramInt + d.a.a.b.b.a.e(18, this.tgv);
      }
      i = i + (d.a.a.b.b.a.dQ(19) + 1) + d.a.a.a.c(20, 1, this.tgx) + (d.a.a.b.b.a.dQ(21) + 1);
      paramInt = i;
      if (this.tgy != null) {
        paramInt = i + d.a.a.a.gA(22, this.tgy.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tgx.clear();
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
        ajr localajr = (ajr)paramVarArgs[1];
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
            localajr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localajr.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localajr.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localajr.tgh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localajr.tgi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localajr.tgj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localajr.tgk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localajr.tgl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localajr.tgm = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 10: 
          localajr.tgn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localajr.tgo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 12: 
          localajr.tgp = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 13: 
          localajr.tgq = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 14: 
          localajr.tgr = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 15: 
          localajr.tgs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localajr.tgt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localajr.tgu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localajr.tgv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localajr.tgw = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 20: 
          localajr.tgx.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 21: 
          localajr.qqA = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new asl();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((asl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localajr.tgy = ((asl)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ajr
 * JD-Core Version:    0.7.0.1
 */