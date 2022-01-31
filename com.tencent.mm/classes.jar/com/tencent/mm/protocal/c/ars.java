package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ars
  extends bly
{
  public String ffk;
  public String kVn;
  public String ssG;
  public String sst;
  public String suv;
  public LinkedList<bna> tab = new LinkedList();
  public aqz tnb;
  public String tnd;
  public String tne;
  public String tnf;
  public int tng;
  
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
      if (this.tnb != null)
      {
        paramVarArgs.gD(2, this.tnb.btq());
        this.tnb.a(paramVarArgs);
      }
      if (this.tne != null) {
        paramVarArgs.d(3, this.tne);
      }
      paramVarArgs.d(4, 8, this.tab);
      if (this.kVn != null) {
        paramVarArgs.d(5, this.kVn);
      }
      if (this.suv != null) {
        paramVarArgs.d(6, this.suv);
      }
      if (this.ssG != null) {
        paramVarArgs.d(7, this.ssG);
      }
      if (this.sst != null) {
        paramVarArgs.d(8, this.sst);
      }
      if (this.tnf != null) {
        paramVarArgs.d(9, this.tnf);
      }
      paramVarArgs.gB(10, this.tng);
      if (this.tnd != null) {
        paramVarArgs.d(11, this.tnd);
      }
      if (this.ffk != null) {
        paramVarArgs.d(12, this.ffk);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1078;
      }
    }
    label1078:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnb != null) {
        paramInt = i + d.a.a.a.gA(2, this.tnb.btq());
      }
      i = paramInt;
      if (this.tne != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tne);
      }
      i += d.a.a.a.c(4, 8, this.tab);
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kVn);
      }
      i = paramInt;
      if (this.suv != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.suv);
      }
      paramInt = i;
      if (this.ssG != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ssG);
      }
      i = paramInt;
      if (this.sst != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sst);
      }
      paramInt = i;
      if (this.tnf != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tnf);
      }
      i = paramInt + d.a.a.a.gy(10, this.tng);
      paramInt = i;
      if (this.tnd != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tnd);
      }
      i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.ffk);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tab.clear();
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
        ars localars = (ars)paramVarArgs[1];
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
            localars.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localars.tnb = ((aqz)localObject1);
            paramInt += 1;
          }
        case 3: 
          localars.tne = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bna();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bna)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localars.tab.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localars.kVn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localars.suv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localars.ssG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localars.sst = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localars.tnf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localars.tng = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localars.tnd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localars.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ars
 * JD-Core Version:    0.7.0.1
 */