package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ccb
  extends com.tencent.mm.bv.a
{
  public String cCO;
  public String ffr;
  public String sAZ;
  public bmo sBI;
  public String sLD;
  public String sLE;
  public int sZT;
  public int stS;
  public atz svV;
  public String tRf;
  public String tRg;
  public int tRh;
  public int tRi;
  public int tRj;
  public String tRk;
  public int tRl;
  public bml tRm;
  public int tRn;
  public String tRo;
  public String tRp;
  public String tRq;
  public String tRr;
  public String tRs;
  public bcv tRt;
  public String tRu;
  public int tRv;
  public long tRw;
  public String tRx;
  public but tpm;
  public String ttv;
  public String ttw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tpm == null) {
        throw new b("Not all required fields were included: SnsUserInfo");
      }
      if (this.tpm != null)
      {
        paramVarArgs.gD(1, this.tpm.btq());
        this.tpm.a(paramVarArgs);
      }
      if (this.ffr != null) {
        paramVarArgs.d(2, this.ffr);
      }
      if (this.tRf != null) {
        paramVarArgs.d(3, this.tRf);
      }
      if (this.tRg != null) {
        paramVarArgs.d(4, this.tRg);
      }
      paramVarArgs.gB(5, this.tRh);
      paramVarArgs.gB(6, this.tRi);
      paramVarArgs.gB(7, this.tRj);
      if (this.tRk != null) {
        paramVarArgs.d(8, this.tRk);
      }
      if (this.sLD != null) {
        paramVarArgs.d(9, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(10, this.sLE);
      }
      paramVarArgs.gB(11, this.tRl);
      if (this.tRm != null)
      {
        paramVarArgs.gD(12, this.tRm.btq());
        this.tRm.a(paramVarArgs);
      }
      if (this.sBI != null)
      {
        paramVarArgs.gD(13, this.sBI.btq());
        this.sBI.a(paramVarArgs);
      }
      paramVarArgs.gB(14, this.stS);
      paramVarArgs.gB(15, this.tRn);
      if (this.sAZ != null) {
        paramVarArgs.d(16, this.sAZ);
      }
      if (this.ttv != null) {
        paramVarArgs.d(17, this.ttv);
      }
      if (this.ttw != null) {
        paramVarArgs.d(18, this.ttw);
      }
      if (this.tRo != null) {
        paramVarArgs.d(19, this.tRo);
      }
      if (this.tRp != null) {
        paramVarArgs.d(20, this.tRp);
      }
      if (this.tRq != null) {
        paramVarArgs.d(21, this.tRq);
      }
      if (this.tRr != null) {
        paramVarArgs.d(22, this.tRr);
      }
      if (this.svV != null)
      {
        paramVarArgs.gD(23, this.svV.btq());
        this.svV.a(paramVarArgs);
      }
      if (this.tRs != null) {
        paramVarArgs.d(24, this.tRs);
      }
      if (this.tRt != null)
      {
        paramVarArgs.gD(25, this.tRt.btq());
        this.tRt.a(paramVarArgs);
      }
      if (this.tRu != null) {
        paramVarArgs.d(26, this.tRu);
      }
      paramVarArgs.gB(27, this.tRv);
      if (this.cCO != null) {
        paramVarArgs.d(28, this.cCO);
      }
      paramVarArgs.gB(29, this.sZT);
      paramVarArgs.Y(30, this.tRw);
      if (this.tRx != null) {
        paramVarArgs.d(31, this.tRx);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tpm == null) {
        break label2223;
      }
    }
    label2223:
    for (int i = d.a.a.a.gA(1, this.tpm.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ffr != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ffr);
      }
      i = paramInt;
      if (this.tRf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tRf);
      }
      paramInt = i;
      if (this.tRg != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tRg);
      }
      i = paramInt + d.a.a.a.gy(5, this.tRh) + d.a.a.a.gy(6, this.tRi) + d.a.a.a.gy(7, this.tRj);
      paramInt = i;
      if (this.tRk != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tRk);
      }
      i = paramInt;
      if (this.sLD != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sLD);
      }
      paramInt = i;
      if (this.sLE != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sLE);
      }
      i = paramInt + d.a.a.a.gy(11, this.tRl);
      paramInt = i;
      if (this.tRm != null) {
        paramInt = i + d.a.a.a.gA(12, this.tRm.btq());
      }
      i = paramInt;
      if (this.sBI != null) {
        i = paramInt + d.a.a.a.gA(13, this.sBI.btq());
      }
      i = i + d.a.a.a.gy(14, this.stS) + d.a.a.a.gy(15, this.tRn);
      paramInt = i;
      if (this.sAZ != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.sAZ);
      }
      i = paramInt;
      if (this.ttv != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.ttv);
      }
      paramInt = i;
      if (this.ttw != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.ttw);
      }
      i = paramInt;
      if (this.tRo != null) {
        i = paramInt + d.a.a.b.b.a.e(19, this.tRo);
      }
      paramInt = i;
      if (this.tRp != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.tRp);
      }
      i = paramInt;
      if (this.tRq != null) {
        i = paramInt + d.a.a.b.b.a.e(21, this.tRq);
      }
      paramInt = i;
      if (this.tRr != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.tRr);
      }
      i = paramInt;
      if (this.svV != null) {
        i = paramInt + d.a.a.a.gA(23, this.svV.btq());
      }
      paramInt = i;
      if (this.tRs != null) {
        paramInt = i + d.a.a.b.b.a.e(24, this.tRs);
      }
      i = paramInt;
      if (this.tRt != null) {
        i = paramInt + d.a.a.a.gA(25, this.tRt.btq());
      }
      paramInt = i;
      if (this.tRu != null) {
        paramInt = i + d.a.a.b.b.a.e(26, this.tRu);
      }
      i = paramInt + d.a.a.a.gy(27, this.tRv);
      paramInt = i;
      if (this.cCO != null) {
        paramInt = i + d.a.a.b.b.a.e(28, this.cCO);
      }
      i = paramInt + d.a.a.a.gy(29, this.sZT) + d.a.a.a.X(30, this.tRw);
      paramInt = i;
      if (this.tRx != null) {
        paramInt = i + d.a.a.b.b.a.e(31, this.tRx);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tpm != null) {
          break;
        }
        throw new b("Not all required fields were included: SnsUserInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ccb localccb = (ccb)paramVarArgs[1];
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
            localObject1 = new but();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((but)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localccb.tpm = ((but)localObject1);
            paramInt += 1;
          }
        case 2: 
          localccb.ffr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localccb.tRf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localccb.tRg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localccb.tRh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localccb.tRi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localccb.tRj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localccb.tRk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localccb.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localccb.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localccb.tRl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localccb.tRm = ((bml)localObject1);
            paramInt += 1;
          }
        case 13: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localccb.sBI = ((bmo)localObject1);
            paramInt += 1;
          }
        case 14: 
          localccb.stS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localccb.tRn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localccb.sAZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localccb.ttv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localccb.ttw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localccb.tRo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localccb.tRp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localccb.tRq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localccb.tRr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 23: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localccb.svV = ((atz)localObject1);
            paramInt += 1;
          }
        case 24: 
          localccb.tRs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 25: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localccb.tRt = ((bcv)localObject1);
            paramInt += 1;
          }
        case 26: 
          localccb.tRu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 27: 
          localccb.tRv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 28: 
          localccb.cCO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 29: 
          localccb.sZT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 30: 
          localccb.tRw = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localccb.tRx = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccb
 * JD-Core Version:    0.7.0.1
 */