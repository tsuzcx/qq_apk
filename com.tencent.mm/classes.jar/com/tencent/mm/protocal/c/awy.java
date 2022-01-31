package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class awy
  extends com.tencent.mm.bv.a
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
  public int sPx;
  public bml sQa;
  public bml sQb;
  public bml sQs;
  public bmk svJ;
  public String tgV;
  public bml tmw;
  public int tpg;
  public String tph;
  public String tpi;
  public String tpj;
  public int tpk;
  public but tpm;
  public sg tpn;
  public bml tsS;
  public bml tsT;
  public bml tsU;
  public int ttk;
  
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
      if (this.sQa == null) {
        throw new b("Not all required fields were included: PYInitial");
      }
      if (this.sQb == null) {
        throw new b("Not all required fields were included: QuanPin");
      }
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
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
      if (this.sQa != null)
      {
        paramVarArgs.gD(3, this.sQa.btq());
        this.sQa.a(paramVarArgs);
      }
      if (this.sQb != null)
      {
        paramVarArgs.gD(4, this.sQb.btq());
        this.sQb.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.ffh);
      if (this.svJ != null)
      {
        paramVarArgs.gD(6, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.ttk);
      if (this.tsS != null)
      {
        paramVarArgs.gD(8, this.tsS.btq());
        this.tsS.a(paramVarArgs);
      }
      if (this.tsT != null)
      {
        paramVarArgs.gD(9, this.tsT.btq());
        this.tsT.a(paramVarArgs);
      }
      if (this.tsU != null)
      {
        paramVarArgs.gD(10, this.tsU.btq());
        this.tsU.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.sPx);
      if (this.ffi != null) {
        paramVarArgs.d(12, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(13, this.ffj);
      }
      if (this.ffk != null) {
        paramVarArgs.d(14, this.ffk);
      }
      paramVarArgs.gB(15, this.ffl);
      paramVarArgs.gB(16, this.tpg);
      if (this.tph != null) {
        paramVarArgs.d(17, this.tph);
      }
      if (this.tpi != null) {
        paramVarArgs.d(18, this.tpi);
      }
      if (this.tgV != null) {
        paramVarArgs.d(19, this.tgV);
      }
      if (this.tpj != null) {
        paramVarArgs.d(20, this.tpj);
      }
      paramVarArgs.gB(21, this.tpk);
      paramVarArgs.gB(22, this.ffo);
      paramVarArgs.gB(23, this.ffn);
      if (this.ffp != null) {
        paramVarArgs.d(24, this.ffp);
      }
      if (this.ffm != null) {
        paramVarArgs.d(25, this.ffm);
      }
      if (this.tpm != null)
      {
        paramVarArgs.gD(26, this.tpm.btq());
        this.tpm.a(paramVarArgs);
      }
      if (this.ffq != null) {
        paramVarArgs.d(27, this.ffq);
      }
      if (this.sLD != null) {
        paramVarArgs.d(28, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(29, this.sLE);
      }
      if (this.ffr != null) {
        paramVarArgs.d(30, this.ffr);
      }
      if (this.tpn != null)
      {
        paramVarArgs.gD(31, this.tpn.btq());
        this.tpn.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQs == null) {
        break label2941;
      }
    }
    label2941:
    for (int i = d.a.a.a.gA(1, this.sQs.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tmw != null) {
        paramInt = i + d.a.a.a.gA(2, this.tmw.btq());
      }
      i = paramInt;
      if (this.sQa != null) {
        i = paramInt + d.a.a.a.gA(3, this.sQa.btq());
      }
      paramInt = i;
      if (this.sQb != null) {
        paramInt = i + d.a.a.a.gA(4, this.sQb.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.ffh);
      paramInt = i;
      if (this.svJ != null) {
        paramInt = i + d.a.a.a.gA(6, this.svJ.btq());
      }
      i = paramInt + d.a.a.a.gy(7, this.ttk);
      paramInt = i;
      if (this.tsS != null) {
        paramInt = i + d.a.a.a.gA(8, this.tsS.btq());
      }
      i = paramInt;
      if (this.tsT != null) {
        i = paramInt + d.a.a.a.gA(9, this.tsT.btq());
      }
      paramInt = i;
      if (this.tsU != null) {
        paramInt = i + d.a.a.a.gA(10, this.tsU.btq());
      }
      i = paramInt + d.a.a.a.gy(11, this.sPx);
      paramInt = i;
      if (this.ffi != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.ffi);
      }
      i = paramInt;
      if (this.ffj != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.ffj);
      }
      paramInt = i;
      if (this.ffk != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.ffk);
      }
      i = paramInt + d.a.a.a.gy(15, this.ffl) + d.a.a.a.gy(16, this.tpg);
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.tph);
      }
      i = paramInt;
      if (this.tpi != null) {
        i = paramInt + d.a.a.b.b.a.e(18, this.tpi);
      }
      paramInt = i;
      if (this.tgV != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.tgV);
      }
      i = paramInt;
      if (this.tpj != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.tpj);
      }
      i = i + d.a.a.a.gy(21, this.tpk) + d.a.a.a.gy(22, this.ffo) + d.a.a.a.gy(23, this.ffn);
      paramInt = i;
      if (this.ffp != null) {
        paramInt = i + d.a.a.b.b.a.e(24, this.ffp);
      }
      i = paramInt;
      if (this.ffm != null) {
        i = paramInt + d.a.a.b.b.a.e(25, this.ffm);
      }
      paramInt = i;
      if (this.tpm != null) {
        paramInt = i + d.a.a.a.gA(26, this.tpm.btq());
      }
      i = paramInt;
      if (this.ffq != null) {
        i = paramInt + d.a.a.b.b.a.e(27, this.ffq);
      }
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(28, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(29, this.sLE);
      }
      paramInt = i;
      if (this.ffr != null) {
        paramInt = i + d.a.a.b.b.a.e(30, this.ffr);
      }
      i = paramInt;
      if (this.tpn != null) {
        i = paramInt + d.a.a.a.gA(31, this.tpn.btq());
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
        awy localawy = (awy)paramVarArgs[1];
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
            localawy.sQs = ((bml)localObject1);
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
            localawy.tmw = ((bml)localObject1);
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localawy.sQa = ((bml)localObject1);
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
            localawy.sQb = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          localawy.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localawy.svJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          localawy.ttk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localawy.tsS = ((bml)localObject1);
            paramInt += 1;
          }
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
            localawy.tsT = ((bml)localObject1);
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
            localawy.tsU = ((bml)localObject1);
            paramInt += 1;
          }
        case 11: 
          localawy.sPx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localawy.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localawy.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localawy.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localawy.ffl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localawy.tpg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localawy.tph = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localawy.tpi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localawy.tgV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localawy.tpj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localawy.tpk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 22: 
          localawy.ffo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localawy.ffn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 24: 
          localawy.ffp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 25: 
          localawy.ffm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 26: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new but();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((but)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localawy.tpm = ((but)localObject1);
            paramInt += 1;
          }
        case 27: 
          localawy.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 28: 
          localawy.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 29: 
          localawy.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 30: 
          localawy.ffr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sg();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawy.tpn = ((sg)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awy
 * JD-Core Version:    0.7.0.1
 */