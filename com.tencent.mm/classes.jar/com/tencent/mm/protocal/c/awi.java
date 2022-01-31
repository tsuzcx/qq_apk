package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class awi
  extends com.tencent.mm.bv.a
{
  public int ffh;
  public String ffi;
  public String ffj;
  public String ffk;
  public int ffl;
  public String ffq;
  public int sPx;
  public bml sQa;
  public bml sQb;
  public bml sQx;
  public bml tmw;
  public int tpg;
  public String tph;
  public int tsR;
  public bml tsS;
  public bml tsT;
  public bml tsU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQx == null) {
        throw new b("Not all required fields were included: MemberName");
      }
      if (this.tmw == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.sQa == null) {
        throw new b("Not all required fields were included: PYInitial");
      }
      if (this.sQb == null) {
        throw new b("Not all required fields were included: QuanPin");
      }
      if (this.tsS == null) {
        throw new b("Not all required fields were included: Remark");
      }
      if (this.tsT == null) {
        throw new b("Not all required fields were included: RemarkPYInitial");
      }
      if (this.tsU == null) {
        throw new b("Not all required fields were included: RemarkQuanPin");
      }
      if (this.sQx != null)
      {
        paramVarArgs.gD(1, this.sQx.btq());
        this.sQx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tsR);
      if (this.tmw != null)
      {
        paramVarArgs.gD(3, this.tmw.btq());
        this.tmw.a(paramVarArgs);
      }
      if (this.sQa != null)
      {
        paramVarArgs.gD(4, this.sQa.btq());
        this.sQa.a(paramVarArgs);
      }
      if (this.sQb != null)
      {
        paramVarArgs.gD(5, this.sQb.btq());
        this.sQb.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.ffh);
      if (this.tsS != null)
      {
        paramVarArgs.gD(9, this.tsS.btq());
        this.tsS.a(paramVarArgs);
      }
      if (this.tsT != null)
      {
        paramVarArgs.gD(10, this.tsT.btq());
        this.tsT.a(paramVarArgs);
      }
      if (this.tsU != null)
      {
        paramVarArgs.gD(11, this.tsU.btq());
        this.tsU.a(paramVarArgs);
      }
      paramVarArgs.gB(12, this.sPx);
      if (this.ffi != null) {
        paramVarArgs.d(13, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(14, this.ffj);
      }
      if (this.ffk != null) {
        paramVarArgs.d(15, this.ffk);
      }
      paramVarArgs.gB(16, this.ffl);
      paramVarArgs.gB(17, this.tpg);
      if (this.tph != null) {
        paramVarArgs.d(18, this.tph);
      }
      if (this.ffq != null) {
        paramVarArgs.d(19, this.ffq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQx == null) {
        break label1893;
      }
    }
    label1893:
    for (paramInt = d.a.a.a.gA(1, this.sQx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tsR);
      paramInt = i;
      if (this.tmw != null) {
        paramInt = i + d.a.a.a.gA(3, this.tmw.btq());
      }
      i = paramInt;
      if (this.sQa != null) {
        i = paramInt + d.a.a.a.gA(4, this.sQa.btq());
      }
      paramInt = i;
      if (this.sQb != null) {
        paramInt = i + d.a.a.a.gA(5, this.sQb.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.ffh);
      paramInt = i;
      if (this.tsS != null) {
        paramInt = i + d.a.a.a.gA(9, this.tsS.btq());
      }
      i = paramInt;
      if (this.tsT != null) {
        i = paramInt + d.a.a.a.gA(10, this.tsT.btq());
      }
      paramInt = i;
      if (this.tsU != null) {
        paramInt = i + d.a.a.a.gA(11, this.tsU.btq());
      }
      i = paramInt + d.a.a.a.gy(12, this.sPx);
      paramInt = i;
      if (this.ffi != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.ffi);
      }
      i = paramInt;
      if (this.ffj != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.ffj);
      }
      paramInt = i;
      if (this.ffk != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.ffk);
      }
      i = paramInt + d.a.a.a.gy(16, this.ffl) + d.a.a.a.gy(17, this.tpg);
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.tph);
      }
      i = paramInt;
      if (this.ffq != null) {
        i = paramInt + d.a.a.b.b.a.e(19, this.ffq);
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
        if (this.sQx == null) {
          throw new b("Not all required fields were included: MemberName");
        }
        if (this.tmw == null) {
          throw new b("Not all required fields were included: NickName");
        }
        if (this.sQa == null) {
          throw new b("Not all required fields were included: PYInitial");
        }
        if (this.sQb == null) {
          throw new b("Not all required fields were included: QuanPin");
        }
        if (this.tsS == null) {
          throw new b("Not all required fields were included: Remark");
        }
        if (this.tsT == null) {
          throw new b("Not all required fields were included: RemarkPYInitial");
        }
        if (this.tsU != null) {
          break;
        }
        throw new b("Not all required fields were included: RemarkQuanPin");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        awi localawi = (awi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
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
            localawi.sQx = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          localawi.tsR = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localawi.tmw = ((bml)localObject1);
            paramInt += 1;
          }
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
            localawi.sQa = ((bml)localObject1);
            paramInt += 1;
          }
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
            localawi.sQb = ((bml)localObject1);
            paramInt += 1;
          }
        case 6: 
          localawi.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localawi.tsS = ((bml)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localawi.tsT = ((bml)localObject1);
            paramInt += 1;
          }
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
            localawi.tsU = ((bml)localObject1);
            paramInt += 1;
          }
        case 12: 
          localawi.sPx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localawi.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localawi.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localawi.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localawi.ffl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localawi.tpg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localawi.tph = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localawi.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awi
 * JD-Core Version:    0.7.0.1
 */