package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class axx
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
  public int hQq;
  public bml sQs;
  public long sTU;
  public String sTV;
  public int stM;
  public int stP;
  public bml tmw;
  public int tpg;
  public String tph;
  public String tpi;
  public String tpj;
  public int tpk;
  public ua ttK;
  public int ttW;
  public int ttq;
  public int tub;
  public com.tencent.mm.bv.b tuc;
  public int tue;
  public bml tuf;
  public bml tug;
  public int tuh;
  public int tui;
  public int tuj;
  public int tuk;
  public int tul;
  public ant tum;
  public int tun;
  public String tuo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQs == null) {
        throw new d.a.a.b("Not all required fields were included: UserName");
      }
      if (this.tmw == null) {
        throw new d.a.a.b("Not all required fields were included: NickName");
      }
      if (this.tuf == null) {
        throw new d.a.a.b("Not all required fields were included: BindEmail");
      }
      if (this.tug == null) {
        throw new d.a.a.b("Not all required fields were included: BindMobile");
      }
      paramVarArgs.gB(1, this.tue);
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
      paramVarArgs.gB(4, this.stM);
      if (this.tuf != null)
      {
        paramVarArgs.gD(5, this.tuf.btq());
        this.tuf.a(paramVarArgs);
      }
      if (this.tug != null)
      {
        paramVarArgs.gD(6, this.tug.btq());
        this.tug.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.hQq);
      paramVarArgs.gB(8, this.tub);
      if (this.tuc != null) {
        paramVarArgs.b(9, this.tuc);
      }
      paramVarArgs.gB(10, this.ffh);
      if (this.ffi != null) {
        paramVarArgs.d(11, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(12, this.ffj);
      }
      if (this.ffk != null) {
        paramVarArgs.d(13, this.ffk);
      }
      paramVarArgs.gB(14, this.ffl);
      if (this.ttK != null)
      {
        paramVarArgs.gD(15, this.ttK.btq());
        this.ttK.a(paramVarArgs);
      }
      paramVarArgs.gB(16, this.stP);
      paramVarArgs.gB(17, this.tpg);
      if (this.tph != null) {
        paramVarArgs.d(18, this.tph);
      }
      paramVarArgs.gB(19, this.tuh);
      paramVarArgs.gB(20, this.tui);
      paramVarArgs.gB(21, this.ttq);
      paramVarArgs.gB(22, this.tuj);
      paramVarArgs.gB(23, this.tuk);
      if (this.tpi != null) {
        paramVarArgs.d(24, this.tpi);
      }
      paramVarArgs.gB(25, this.tul);
      if (this.tum != null)
      {
        paramVarArgs.gD(26, this.tum.btq());
        this.tum.a(paramVarArgs);
      }
      if (this.ffm != null) {
        paramVarArgs.d(27, this.ffm);
      }
      if (this.tpj != null) {
        paramVarArgs.d(28, this.tpj);
      }
      paramVarArgs.gB(29, this.tpk);
      paramVarArgs.gB(30, this.tun);
      paramVarArgs.Y(31, this.sTU);
      if (this.sTV != null) {
        paramVarArgs.d(32, this.sTV);
      }
      paramVarArgs.gB(33, this.ffo);
      paramVarArgs.gB(34, this.ffn);
      if (this.ffp != null) {
        paramVarArgs.d(35, this.ffp);
      }
      paramVarArgs.gB(36, this.ttW);
      if (this.tuo != null) {
        paramVarArgs.d(37, this.tuo);
      }
      if (this.ffq != null) {
        paramVarArgs.d(38, this.ffq);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tue) + 0;
      paramInt = i;
      if (this.sQs != null) {
        paramInt = i + d.a.a.a.gA(2, this.sQs.btq());
      }
      i = paramInt;
      if (this.tmw != null) {
        i = paramInt + d.a.a.a.gA(3, this.tmw.btq());
      }
      i += d.a.a.a.gy(4, this.stM);
      paramInt = i;
      if (this.tuf != null) {
        paramInt = i + d.a.a.a.gA(5, this.tuf.btq());
      }
      i = paramInt;
      if (this.tug != null) {
        i = paramInt + d.a.a.a.gA(6, this.tug.btq());
      }
      i = i + d.a.a.a.gy(7, this.hQq) + d.a.a.a.gy(8, this.tub);
      paramInt = i;
      if (this.tuc != null) {
        paramInt = i + d.a.a.a.a(9, this.tuc);
      }
      i = paramInt + d.a.a.a.gy(10, this.ffh);
      paramInt = i;
      if (this.ffi != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.ffi);
      }
      i = paramInt;
      if (this.ffj != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.ffj);
      }
      paramInt = i;
      if (this.ffk != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.ffk);
      }
      i = paramInt + d.a.a.a.gy(14, this.ffl);
      paramInt = i;
      if (this.ttK != null) {
        paramInt = i + d.a.a.a.gA(15, this.ttK.btq());
      }
      i = paramInt + d.a.a.a.gy(16, this.stP) + d.a.a.a.gy(17, this.tpg);
      paramInt = i;
      if (this.tph != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.tph);
      }
      i = paramInt + d.a.a.a.gy(19, this.tuh) + d.a.a.a.gy(20, this.tui) + d.a.a.a.gy(21, this.ttq) + d.a.a.a.gy(22, this.tuj) + d.a.a.a.gy(23, this.tuk);
      paramInt = i;
      if (this.tpi != null) {
        paramInt = i + d.a.a.b.b.a.e(24, this.tpi);
      }
      i = paramInt + d.a.a.a.gy(25, this.tul);
      paramInt = i;
      if (this.tum != null) {
        paramInt = i + d.a.a.a.gA(26, this.tum.btq());
      }
      i = paramInt;
      if (this.ffm != null) {
        i = paramInt + d.a.a.b.b.a.e(27, this.ffm);
      }
      paramInt = i;
      if (this.tpj != null) {
        paramInt = i + d.a.a.b.b.a.e(28, this.tpj);
      }
      i = paramInt + d.a.a.a.gy(29, this.tpk) + d.a.a.a.gy(30, this.tun) + d.a.a.a.X(31, this.sTU);
      paramInt = i;
      if (this.sTV != null) {
        paramInt = i + d.a.a.b.b.a.e(32, this.sTV);
      }
      i = paramInt + d.a.a.a.gy(33, this.ffo) + d.a.a.a.gy(34, this.ffn);
      paramInt = i;
      if (this.ffp != null) {
        paramInt = i + d.a.a.b.b.a.e(35, this.ffp);
      }
      i = paramInt + d.a.a.a.gy(36, this.ttW);
      paramInt = i;
      if (this.tuo != null) {
        paramInt = i + d.a.a.b.b.a.e(37, this.tuo);
      }
      i = paramInt;
    } while (this.ffq == null);
    return paramInt + d.a.a.b.b.a.e(38, this.ffq);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sQs == null) {
        throw new d.a.a.b("Not all required fields were included: UserName");
      }
      if (this.tmw == null) {
        throw new d.a.a.b("Not all required fields were included: NickName");
      }
      if (this.tuf == null) {
        throw new d.a.a.b("Not all required fields were included: BindEmail");
      }
      if (this.tug == null) {
        throw new d.a.a.b("Not all required fields were included: BindMobile");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      axx localaxx = (axx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaxx.tue = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
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
          localaxx.sQs = ((bml)localObject1);
          paramInt += 1;
        }
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
          localaxx.tmw = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localaxx.stM = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
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
          localaxx.tuf = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaxx.tug = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        localaxx.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localaxx.tub = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localaxx.tuc = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      case 10: 
        localaxx.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        localaxx.ffi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 12: 
        localaxx.ffj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 13: 
        localaxx.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 14: 
        localaxx.ffl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 15: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ua();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ua)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaxx.ttK = ((ua)localObject1);
          paramInt += 1;
        }
        return 0;
      case 16: 
        localaxx.stP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 17: 
        localaxx.tpg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 18: 
        localaxx.tph = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 19: 
        localaxx.tuh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 20: 
        localaxx.tui = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 21: 
        localaxx.ttq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 22: 
        localaxx.tuj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 23: 
        localaxx.tuk = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 24: 
        localaxx.tpi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 25: 
        localaxx.tul = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 26: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ant();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ant)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaxx.tum = ((ant)localObject1);
          paramInt += 1;
        }
        return 0;
      case 27: 
        localaxx.ffm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 28: 
        localaxx.tpj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 29: 
        localaxx.tpk = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 30: 
        localaxx.tun = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 31: 
        localaxx.sTU = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 32: 
        localaxx.sTV = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 33: 
        localaxx.ffo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 34: 
        localaxx.ffn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 35: 
        localaxx.ffp = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 36: 
        localaxx.ttW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 37: 
        localaxx.tuo = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localaxx.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axx
 * JD-Core Version:    0.7.0.1
 */