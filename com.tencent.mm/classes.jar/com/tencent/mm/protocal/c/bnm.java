package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bnm
  extends bly
{
  public int ffh;
  public String ffi;
  public String ffj;
  public String ffk;
  public int ffl;
  public String ffm;
  public int ffn;
  public int ffo;
  public String ffp;
  public String ffq;
  public String ffr;
  public String sLD;
  public String sLE;
  public bml sQa;
  public bml sQb;
  public bml sQs;
  public bmk svJ;
  public int tGq;
  public bmk tGs;
  public String tGt;
  public String tGu;
  public int tGv;
  public LinkedList<bob> tGw = new LinkedList();
  public String tac;
  public int tcA;
  public LinkedList<bnk> tcB = new LinkedList();
  public bml tmw;
  public int tpg;
  public String tph;
  public String tpi;
  public String tpj;
  public int tpk;
  public but tpm;
  public sg tpn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sQs == null) {
        throw new b("Not all required fields were included: UserName");
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
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sQs != null)
      {
        paramVarArgs.gD(2, this.sQs.btq());
        this.sQs.a(paramVarArgs);
      }
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
      if (this.svJ != null)
      {
        paramVarArgs.gD(7, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      if (this.ffi != null) {
        paramVarArgs.d(8, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(9, this.ffj);
      }
      if (this.ffk != null) {
        paramVarArgs.d(10, this.ffk);
      }
      paramVarArgs.gB(11, this.ffl);
      paramVarArgs.gB(12, this.tpg);
      if (this.tph != null) {
        paramVarArgs.d(13, this.tph);
      }
      if (this.tpi != null) {
        paramVarArgs.d(14, this.tpi);
      }
      if (this.ffm != null) {
        paramVarArgs.d(15, this.ffm);
      }
      if (this.tpj != null) {
        paramVarArgs.d(16, this.tpj);
      }
      paramVarArgs.gB(17, this.tpk);
      paramVarArgs.gB(18, this.ffo);
      paramVarArgs.gB(19, this.ffn);
      if (this.ffp != null) {
        paramVarArgs.d(20, this.ffp);
      }
      if (this.tpm != null)
      {
        paramVarArgs.gD(21, this.tpm.btq());
        this.tpm.a(paramVarArgs);
      }
      if (this.ffq != null) {
        paramVarArgs.d(22, this.ffq);
      }
      if (this.ffr != null) {
        paramVarArgs.d(23, this.ffr);
      }
      if (this.tpn != null)
      {
        paramVarArgs.gD(24, this.tpn.btq());
        this.tpn.a(paramVarArgs);
      }
      paramVarArgs.gB(25, this.tcA);
      paramVarArgs.d(26, 8, this.tcB);
      if (this.sLD != null) {
        paramVarArgs.d(27, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(28, this.sLE);
      }
      if (this.tGs != null)
      {
        paramVarArgs.gD(29, this.tGs.btq());
        this.tGs.a(paramVarArgs);
      }
      if (this.tac != null) {
        paramVarArgs.d(30, this.tac);
      }
      if (this.tGt != null) {
        paramVarArgs.d(31, this.tGt);
      }
      paramVarArgs.gB(32, this.tGq);
      if (this.tGu != null) {
        paramVarArgs.d(33, this.tGu);
      }
      paramVarArgs.gB(34, this.tGv);
      paramVarArgs.d(35, 8, this.tGw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label3143;
      }
    }
    label3143:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sQs != null) {
        paramInt = i + d.a.a.a.gA(2, this.sQs.btq());
      }
      i = paramInt;
      if (this.tmw != null) {
        i = paramInt + d.a.a.a.gA(3, this.tmw.btq());
      }
      paramInt = i;
      if (this.sQa != null) {
        paramInt = i + d.a.a.a.gA(4, this.sQa.btq());
      }
      i = paramInt;
      if (this.sQb != null) {
        i = paramInt + d.a.a.a.gA(5, this.sQb.btq());
      }
      i += d.a.a.a.gy(6, this.ffh);
      paramInt = i;
      if (this.svJ != null) {
        paramInt = i + d.a.a.a.gA(7, this.svJ.btq());
      }
      i = paramInt;
      if (this.ffi != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.ffi);
      }
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.ffj);
      }
      i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.ffk);
      }
      i = i + d.a.a.a.gy(11, this.ffl) + d.a.a.a.gy(12, this.tpg);
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.tph);
      }
      i = paramInt;
      if (this.tpi != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.tpi);
      }
      paramInt = i;
      if (this.ffm != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.ffm);
      }
      i = paramInt;
      if (this.tpj != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.tpj);
      }
      i = i + d.a.a.a.gy(17, this.tpk) + d.a.a.a.gy(18, this.ffo) + d.a.a.a.gy(19, this.ffn);
      paramInt = i;
      if (this.ffp != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.ffp);
      }
      i = paramInt;
      if (this.tpm != null) {
        i = paramInt + d.a.a.a.gA(21, this.tpm.btq());
      }
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.ffq);
      }
      i = paramInt;
      if (this.ffr != null) {
        i = paramInt + d.a.a.b.b.a.e(23, this.ffr);
      }
      paramInt = i;
      if (this.tpn != null) {
        paramInt = i + d.a.a.a.gA(24, this.tpn.btq());
      }
      i = paramInt + d.a.a.a.gy(25, this.tcA) + d.a.a.a.c(26, 8, this.tcB);
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(27, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(28, this.sLE);
      }
      paramInt = i;
      if (this.tGs != null) {
        paramInt = i + d.a.a.a.gA(29, this.tGs.btq());
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(30, this.tac);
      }
      paramInt = i;
      if (this.tGt != null) {
        paramInt = i + d.a.a.b.b.a.e(31, this.tGt);
      }
      i = paramInt + d.a.a.a.gy(32, this.tGq);
      paramInt = i;
      if (this.tGu != null) {
        paramInt = i + d.a.a.b.b.a.e(33, this.tGu);
      }
      return paramInt + d.a.a.a.gy(34, this.tGv) + d.a.a.a.c(35, 8, this.tGw);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tcB.clear();
        this.tGw.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.sQs == null) {
          throw new b("Not all required fields were included: UserName");
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
        if (this.svJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bnm localbnm = (bnm)paramVarArgs[1];
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
            localbnm.tFx = ((gd)localObject1);
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.sQs = ((bml)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.tmw = ((bml)localObject1);
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.sQa = ((bml)localObject1);
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.sQb = ((bml)localObject1);
            paramInt += 1;
          }
        case 6: 
          localbnm.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.svJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 8: 
          localbnm.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbnm.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbnm.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbnm.ffl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbnm.tpg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localbnm.tph = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbnm.tpi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbnm.ffm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localbnm.tpj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localbnm.tpk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localbnm.ffo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localbnm.ffn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localbnm.ffp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new but();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((but)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.tpm = ((but)localObject1);
            paramInt += 1;
          }
        case 22: 
          localbnm.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 23: 
          localbnm.ffr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 24: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.tpn = ((sg)localObject1);
            paramInt += 1;
          }
        case 25: 
          localbnm.tcA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 26: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.tcB.add(localObject1);
            paramInt += 1;
          }
        case 27: 
          localbnm.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 28: 
          localbnm.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 29: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnm.tGs = ((bmk)localObject1);
            paramInt += 1;
          }
        case 30: 
          localbnm.tac = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 31: 
          localbnm.tGt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 32: 
          localbnm.tGq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 33: 
          localbnm.tGu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 34: 
          localbnm.tGv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bob();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bob)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localbnm.tGw.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnm
 * JD-Core Version:    0.7.0.1
 */