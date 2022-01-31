package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bgt
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
  public String hPY;
  public String hRf;
  public String sLD;
  public String sLE;
  public int tBt;
  public String tBu;
  public int tBv;
  public String tBw;
  public String tac;
  public but tpm;
  public sg tpn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tBt);
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(3, this.hRf);
      }
      if (this.tBu != null) {
        paramVarArgs.d(4, this.tBu);
      }
      paramVarArgs.gB(5, this.tBv);
      if (this.tBw != null) {
        paramVarArgs.d(6, this.tBw);
      }
      paramVarArgs.gB(7, this.ffh);
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
      if (this.ffm != null) {
        paramVarArgs.d(12, this.ffm);
      }
      paramVarArgs.gB(13, this.ffn);
      paramVarArgs.gB(14, this.ffo);
      if (this.ffp != null) {
        paramVarArgs.d(15, this.ffp);
      }
      if (this.tpm != null)
      {
        paramVarArgs.gD(16, this.tpm.btq());
        this.tpm.a(paramVarArgs);
      }
      if (this.ffq != null) {
        paramVarArgs.d(17, this.ffq);
      }
      if (this.ffr != null) {
        paramVarArgs.d(18, this.ffr);
      }
      if (this.tpn != null)
      {
        paramVarArgs.gD(19, this.tpn.btq());
        this.tpn.a(paramVarArgs);
      }
      if (this.sLD != null) {
        paramVarArgs.d(20, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(21, this.sLE);
      }
      if (this.tac != null) {
        paramVarArgs.d(22, this.tac);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tBt) + 0;
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hRf);
      }
      paramInt = i;
      if (this.tBu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tBu);
      }
      i = paramInt + d.a.a.a.gy(5, this.tBv);
      paramInt = i;
      if (this.tBw != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tBw);
      }
      i = paramInt + d.a.a.a.gy(7, this.ffh);
      paramInt = i;
      if (this.ffi != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.ffi);
      }
      i = paramInt;
      if (this.ffj != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.ffj);
      }
      paramInt = i;
      if (this.ffk != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.ffk);
      }
      i = paramInt + d.a.a.a.gy(11, this.ffl);
      paramInt = i;
      if (this.ffm != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.ffm);
      }
      i = paramInt + d.a.a.a.gy(13, this.ffn) + d.a.a.a.gy(14, this.ffo);
      paramInt = i;
      if (this.ffp != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.ffp);
      }
      i = paramInt;
      if (this.tpm != null) {
        i = paramInt + d.a.a.a.gA(16, this.tpm.btq());
      }
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.ffq);
      }
      i = paramInt;
      if (this.ffr != null) {
        i = paramInt + d.a.a.b.b.a.e(18, this.ffr);
      }
      paramInt = i;
      if (this.tpn != null) {
        paramInt = i + d.a.a.a.gA(19, this.tpn.btq());
      }
      i = paramInt;
      if (this.sLD != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.sLD);
      }
      paramInt = i;
      if (this.sLE != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.sLE);
      }
      i = paramInt;
    } while (this.tac == null);
    return paramInt + d.a.a.b.b.a.e(22, this.tac);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bgt localbgt = (bgt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbgt.tBt = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbgt.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbgt.hRf = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localbgt.tBu = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localbgt.tBv = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localbgt.tBw = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        localbgt.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localbgt.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        localbgt.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 10: 
        localbgt.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 11: 
        localbgt.ffl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 12: 
        localbgt.ffm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 13: 
        localbgt.ffn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        localbgt.ffo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 15: 
        localbgt.ffp = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 16: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new but();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((but)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbgt.tpm = ((but)localObject1);
          paramInt += 1;
        }
        return 0;
      case 17: 
        localbgt.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 18: 
        localbgt.ffr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 19: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sg();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbgt.tpn = ((sg)localObject1);
          paramInt += 1;
        }
        return 0;
      case 20: 
        localbgt.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 21: 
        localbgt.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localbgt.tac = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgt
 * JD-Core Version:    0.7.0.1
 */