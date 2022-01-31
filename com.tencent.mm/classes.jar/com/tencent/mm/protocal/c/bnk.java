package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bnk
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
  public bml sQa;
  public bml sQb;
  public bml sQs;
  public bmk svJ;
  public int tGq;
  public String tac;
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
      if (this.ffi != null) {
        paramVarArgs.d(7, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(8, this.ffj);
      }
      if (this.ffk != null) {
        paramVarArgs.d(9, this.ffk);
      }
      paramVarArgs.gB(10, this.ffl);
      paramVarArgs.gB(11, this.tpg);
      if (this.tph != null) {
        paramVarArgs.d(12, this.tph);
      }
      if (this.tpi != null) {
        paramVarArgs.d(13, this.tpi);
      }
      if (this.ffm != null) {
        paramVarArgs.d(14, this.ffm);
      }
      if (this.tpj != null) {
        paramVarArgs.d(15, this.tpj);
      }
      paramVarArgs.gB(16, this.tpk);
      paramVarArgs.gB(17, this.ffo);
      paramVarArgs.gB(18, this.ffn);
      if (this.ffp != null) {
        paramVarArgs.d(19, this.ffp);
      }
      if (this.tpm != null)
      {
        paramVarArgs.gD(20, this.tpm.btq());
        this.tpm.a(paramVarArgs);
      }
      if (this.ffq != null) {
        paramVarArgs.d(21, this.ffq);
      }
      if (this.ffr != null) {
        paramVarArgs.d(22, this.ffr);
      }
      if (this.tpn != null)
      {
        paramVarArgs.gD(23, this.tpn.btq());
        this.tpn.a(paramVarArgs);
      }
      if (this.sLD != null) {
        paramVarArgs.d(24, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(25, this.sLE);
      }
      if (this.tac != null) {
        paramVarArgs.d(26, this.tac);
      }
      paramVarArgs.gB(27, this.tGq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQs == null) {
        break label2347;
      }
    }
    label2347:
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
      i = paramInt;
      if (this.ffi != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.ffi);
      }
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.ffj);
      }
      i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.ffk);
      }
      i = i + d.a.a.a.gy(10, this.ffl) + d.a.a.a.gy(11, this.tpg);
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tph);
      }
      i = paramInt;
      if (this.tpi != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.tpi);
      }
      paramInt = i;
      if (this.ffm != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.ffm);
      }
      i = paramInt;
      if (this.tpj != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tpj);
      }
      i = i + d.a.a.a.gy(16, this.tpk) + d.a.a.a.gy(17, this.ffo) + d.a.a.a.gy(18, this.ffn);
      paramInt = i;
      if (this.ffp != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.ffp);
      }
      i = paramInt;
      if (this.tpm != null) {
        i = paramInt + d.a.a.a.gA(20, this.tpm.btq());
      }
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.ffq);
      }
      i = paramInt;
      if (this.ffr != null) {
        i = paramInt + d.a.a.b.b.a.e(22, this.ffr);
      }
      paramInt = i;
      if (this.tpn != null) {
        paramInt = i + d.a.a.a.gA(23, this.tpn.btq());
      }
      i = paramInt;
      if (this.sLD != null) {
        i = paramInt + d.a.a.b.b.a.e(24, this.sLD);
      }
      paramInt = i;
      if (this.sLE != null) {
        paramInt = i + d.a.a.b.b.a.e(25, this.sLE);
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(26, this.tac);
      }
      return i + d.a.a.a.gy(27, this.tGq);
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
        if (this.svJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bnk localbnk = (bnk)paramVarArgs[1];
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
            localbnk.sQs = ((bml)localObject1);
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
            localbnk.tmw = ((bml)localObject1);
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
            localbnk.sQa = ((bml)localObject1);
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
            localbnk.sQb = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbnk.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localbnk.svJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          localbnk.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbnk.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbnk.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbnk.ffl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localbnk.tpg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbnk.tph = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbnk.tpi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbnk.ffm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbnk.tpj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localbnk.tpk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localbnk.ffo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localbnk.ffn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localbnk.ffp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new but();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((but)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbnk.tpm = ((but)localObject1);
            paramInt += 1;
          }
        case 21: 
          localbnk.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localbnk.ffr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 23: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbnk.tpn = ((sg)localObject1);
            paramInt += 1;
          }
        case 24: 
          localbnk.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 25: 
          localbnk.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 26: 
          localbnk.tac = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbnk.tGq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnk
 * JD-Core Version:    0.7.0.1
 */