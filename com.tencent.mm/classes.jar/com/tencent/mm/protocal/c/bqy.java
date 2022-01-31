package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bqy
  extends com.tencent.mm.bv.a
{
  public int ffh;
  public String ffi;
  public String ffj;
  public String ffk;
  public String ffq;
  public String ffr;
  public String hPY;
  public String hRf;
  public String sLD;
  public String sLE;
  public int svI;
  public int tHI;
  public bmk tHJ;
  public int tHK;
  public String tac;
  public String tgV;
  public String tpf;
  public int tpg;
  public String tph;
  public String tpi;
  public String tpj;
  public int tpk;
  public int tpl;
  public but tpm;
  public sg tpn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tHJ == null) {
        throw new b("Not all required fields were included: ImgBuffer");
      }
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.ffi != null) {
        paramVarArgs.d(3, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(4, this.ffj);
      }
      if (this.ffk != null) {
        paramVarArgs.d(5, this.ffk);
      }
      if (this.tpf != null) {
        paramVarArgs.d(6, this.tpf);
      }
      paramVarArgs.gB(7, this.ffh);
      paramVarArgs.gB(8, this.svI);
      paramVarArgs.gB(9, this.tHI);
      if (this.tHJ != null)
      {
        paramVarArgs.gD(10, this.tHJ.btq());
        this.tHJ.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.tHK);
      if (this.tpi != null) {
        paramVarArgs.d(12, this.tpi);
      }
      if (this.tpj != null) {
        paramVarArgs.d(13, this.tpj);
      }
      paramVarArgs.gB(14, this.tpk);
      paramVarArgs.gB(15, this.tpg);
      if (this.tph != null) {
        paramVarArgs.d(16, this.tph);
      }
      if (this.tgV != null) {
        paramVarArgs.d(17, this.tgV);
      }
      paramVarArgs.gB(21, this.tpl);
      if (this.tpm != null)
      {
        paramVarArgs.gD(22, this.tpm.btq());
        this.tpm.a(paramVarArgs);
      }
      if (this.ffq != null) {
        paramVarArgs.d(23, this.ffq);
      }
      if (this.sLD != null) {
        paramVarArgs.d(24, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(25, this.sLE);
      }
      if (this.ffr != null) {
        paramVarArgs.d(26, this.ffr);
      }
      if (this.tpn != null)
      {
        paramVarArgs.gD(27, this.tpn.btq());
        this.tpn.a(paramVarArgs);
      }
      if (this.tac != null) {
        paramVarArgs.d(28, this.tac);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label1745;
      }
    }
    label1745:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.ffi != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ffi);
      }
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ffj);
      }
      i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ffk);
      }
      paramInt = i;
      if (this.tpf != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tpf);
      }
      i = paramInt + d.a.a.a.gy(7, this.ffh) + d.a.a.a.gy(8, this.svI) + d.a.a.a.gy(9, this.tHI);
      paramInt = i;
      if (this.tHJ != null) {
        paramInt = i + d.a.a.a.gA(10, this.tHJ.btq());
      }
      i = paramInt + d.a.a.a.gy(11, this.tHK);
      paramInt = i;
      if (this.tpi != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tpi);
      }
      i = paramInt;
      if (this.tpj != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.tpj);
      }
      i = i + d.a.a.a.gy(14, this.tpk) + d.a.a.a.gy(15, this.tpg);
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.tph);
      }
      i = paramInt;
      if (this.tgV != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.tgV);
      }
      i += d.a.a.a.gy(21, this.tpl);
      paramInt = i;
      if (this.tpm != null) {
        paramInt = i + d.a.a.a.gA(22, this.tpm.btq());
      }
      i = paramInt;
      if (this.ffq != null) {
        i = paramInt + d.a.a.b.b.a.e(23, this.ffq);
      }
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(24, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(25, this.sLE);
      }
      paramInt = i;
      if (this.ffr != null) {
        paramInt = i + d.a.a.b.b.a.e(26, this.ffr);
      }
      i = paramInt;
      if (this.tpn != null) {
        i = paramInt + d.a.a.a.gA(27, this.tpn.btq());
      }
      paramInt = i;
      if (this.tac != null) {
        paramInt = i + d.a.a.b.b.a.e(28, this.tac);
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
        if (this.tHJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bqy localbqy = (bqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          return -1;
        case 1: 
          localbqy.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbqy.hRf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbqy.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbqy.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbqy.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbqy.tpf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbqy.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbqy.svI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbqy.tHI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbqy.tHJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 11: 
          localbqy.tHK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbqy.tpi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbqy.tpj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbqy.tpk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localbqy.tpg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localbqy.tph = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localbqy.tgV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localbqy.tpl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 22: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new but();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((but)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbqy.tpm = ((but)localObject1);
            paramInt += 1;
          }
        case 23: 
          localbqy.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 24: 
          localbqy.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 25: 
          localbqy.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 26: 
          localbqy.ffr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 27: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbqy.tpn = ((sg)localObject1);
            paramInt += 1;
          }
        }
        localbqy.tac = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bqy
 * JD-Core Version:    0.7.0.1
 */