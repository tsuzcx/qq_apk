package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class boe
  extends com.tencent.mm.bv.a
{
  public int ffh;
  public String ffi;
  public String ffj;
  public String ffk;
  public int ffl;
  public String ffm;
  public String ffq;
  public String sLD;
  public String sLE;
  public bml sQs;
  public bml tmw;
  public int tpg;
  public String tph;
  public String tpi;
  public String tpj;
  public int tpk;
  public sg tpn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQs == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tmw == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.sQs != null)
      {
        paramVarArgs.gD(1, this.sQs.btq());
        this.sQs.a(paramVarArgs);
      }
      if (this.tmw != null)
      {
        paramVarArgs.gD(2, this.tmw.btq());
        this.tmw.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.ffh);
      if (this.ffi != null) {
        paramVarArgs.d(4, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(5, this.ffj);
      }
      if (this.ffk != null) {
        paramVarArgs.d(6, this.ffk);
      }
      paramVarArgs.gB(7, this.ffl);
      paramVarArgs.gB(8, this.tpg);
      if (this.tph != null) {
        paramVarArgs.d(9, this.tph);
      }
      if (this.tpi != null) {
        paramVarArgs.d(10, this.tpi);
      }
      if (this.ffm != null) {
        paramVarArgs.d(11, this.ffm);
      }
      if (this.tpj != null) {
        paramVarArgs.d(12, this.tpj);
      }
      paramVarArgs.gB(13, this.tpk);
      if (this.ffq != null) {
        paramVarArgs.d(14, this.ffq);
      }
      if (this.tpn != null)
      {
        paramVarArgs.gD(15, this.tpn.btq());
        this.tpn.a(paramVarArgs);
      }
      if (this.sLD != null) {
        paramVarArgs.d(16, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(17, this.sLE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQs == null) {
        break label1361;
      }
    }
    label1361:
    for (paramInt = d.a.a.a.gA(1, this.sQs.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tmw != null) {
        i = paramInt + d.a.a.a.gA(2, this.tmw.btq());
      }
      i += d.a.a.a.gy(3, this.ffh);
      paramInt = i;
      if (this.ffi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ffi);
      }
      i = paramInt;
      if (this.ffj != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ffj);
      }
      paramInt = i;
      if (this.ffk != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ffk);
      }
      i = paramInt + d.a.a.a.gy(7, this.ffl) + d.a.a.a.gy(8, this.tpg);
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tph);
      }
      i = paramInt;
      if (this.tpi != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.tpi);
      }
      paramInt = i;
      if (this.ffm != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.ffm);
      }
      i = paramInt;
      if (this.tpj != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.tpj);
      }
      i += d.a.a.a.gy(13, this.tpk);
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.ffq);
      }
      i = paramInt;
      if (this.tpn != null) {
        i = paramInt + d.a.a.a.gA(15, this.tpn.btq());
      }
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.sLE);
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
        if (this.sQs == null) {
          throw new b("Not all required fields were included: UserName");
        }
        if (this.tmw != null) {
          break;
        }
        throw new b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        boe localboe = (boe)paramVarArgs[1];
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
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localboe.sQs = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localboe.tmw = ((bml)localObject1);
            paramInt += 1;
          }
        case 3: 
          localboe.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localboe.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localboe.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localboe.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localboe.ffl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localboe.tpg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localboe.tph = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localboe.tpi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localboe.ffm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localboe.tpj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localboe.tpk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localboe.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localboe.tpn = ((sg)localObject1);
            paramInt += 1;
          }
        case 16: 
          localboe.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localboe.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.boe
 * JD-Core Version:    0.7.0.1
 */