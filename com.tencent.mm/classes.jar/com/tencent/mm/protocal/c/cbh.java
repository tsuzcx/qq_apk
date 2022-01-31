package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbh
  extends blm
{
  public String euK;
  public String euN;
  public String jnU;
  public int kSW;
  public int ndf;
  public int ndg;
  public int ndh;
  public bmk ndi;
  public String sGQ;
  public int sGR;
  public int sGS;
  public int sGT;
  public int sNU;
  public int sRM;
  public String sua;
  public String sub;
  public String suc;
  public bml svF;
  public bml svG;
  public String svK;
  public int tHc;
  public int tLm;
  public bml tQp;
  public String tQq;
  public String tQr;
  public int tQs;
  public int tQt;
  public String tQu;
  public int tQv;
  public int tQw;
  public int tQx;
  public int tfc;
  public String tlO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tQp == null) {
        throw new b("Not all required fields were included: ClientImgId");
      }
      if (this.svF == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tQp != null)
      {
        paramVarArgs.gD(2, this.tQp.btq());
        this.tQp.a(paramVarArgs);
      }
      if (this.svF != null)
      {
        paramVarArgs.gD(3, this.svF.btq());
        this.svF.a(paramVarArgs);
      }
      if (this.svG != null)
      {
        paramVarArgs.gD(4, this.svG.btq());
        this.svG.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.ndf);
      paramVarArgs.gB(6, this.ndg);
      paramVarArgs.gB(7, this.ndh);
      if (this.ndi != null)
      {
        paramVarArgs.gD(8, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.kSW);
      if (this.svK != null) {
        paramVarArgs.d(10, this.svK);
      }
      paramVarArgs.gB(11, this.tfc);
      paramVarArgs.gB(12, this.sNU);
      paramVarArgs.gB(13, this.tLm);
      if (this.euN != null) {
        paramVarArgs.d(14, this.euN);
      }
      if (this.tQq != null) {
        paramVarArgs.d(15, this.tQq);
      }
      if (this.tQr != null) {
        paramVarArgs.d(16, this.tQr);
      }
      if (this.sGQ != null) {
        paramVarArgs.d(17, this.sGQ);
      }
      paramVarArgs.gB(18, this.sGR);
      paramVarArgs.gB(19, this.tQs);
      paramVarArgs.gB(20, this.tQt);
      if (this.tQu != null) {
        paramVarArgs.d(21, this.tQu);
      }
      paramVarArgs.gB(22, this.tQv);
      paramVarArgs.gB(23, this.tQw);
      paramVarArgs.gB(24, this.tQx);
      if (this.tlO != null) {
        paramVarArgs.d(25, this.tlO);
      }
      paramVarArgs.gB(26, this.sRM);
      if (this.jnU != null) {
        paramVarArgs.d(27, this.jnU);
      }
      paramVarArgs.gB(28, this.sGS);
      paramVarArgs.gB(29, this.sGT);
      paramVarArgs.gB(30, this.tHc);
      if (this.euK != null) {
        paramVarArgs.d(31, this.euK);
      }
      if (this.suc != null) {
        paramVarArgs.d(32, this.suc);
      }
      if (this.sub != null) {
        paramVarArgs.d(33, this.sub);
      }
      if (this.sua != null) {
        paramVarArgs.d(34, this.sua);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label2356;
      }
    }
    label2356:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tQp != null) {
        paramInt = i + d.a.a.a.gA(2, this.tQp.btq());
      }
      i = paramInt;
      if (this.svF != null) {
        i = paramInt + d.a.a.a.gA(3, this.svF.btq());
      }
      paramInt = i;
      if (this.svG != null) {
        paramInt = i + d.a.a.a.gA(4, this.svG.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.ndf) + d.a.a.a.gy(6, this.ndg) + d.a.a.a.gy(7, this.ndh);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(8, this.ndi.btq());
      }
      i = paramInt + d.a.a.a.gy(9, this.kSW);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.svK);
      }
      i = paramInt + d.a.a.a.gy(11, this.tfc) + d.a.a.a.gy(12, this.sNU) + d.a.a.a.gy(13, this.tLm);
      paramInt = i;
      if (this.euN != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.euN);
      }
      i = paramInt;
      if (this.tQq != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tQq);
      }
      paramInt = i;
      if (this.tQr != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.tQr);
      }
      i = paramInt;
      if (this.sGQ != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.sGQ);
      }
      i = i + d.a.a.a.gy(18, this.sGR) + d.a.a.a.gy(19, this.tQs) + d.a.a.a.gy(20, this.tQt);
      paramInt = i;
      if (this.tQu != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.tQu);
      }
      i = paramInt + d.a.a.a.gy(22, this.tQv) + d.a.a.a.gy(23, this.tQw) + d.a.a.a.gy(24, this.tQx);
      paramInt = i;
      if (this.tlO != null) {
        paramInt = i + d.a.a.b.b.a.e(25, this.tlO);
      }
      i = paramInt + d.a.a.a.gy(26, this.sRM);
      paramInt = i;
      if (this.jnU != null) {
        paramInt = i + d.a.a.b.b.a.e(27, this.jnU);
      }
      i = paramInt + d.a.a.a.gy(28, this.sGS) + d.a.a.a.gy(29, this.sGT) + d.a.a.a.gy(30, this.tHc);
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(31, this.euK);
      }
      i = paramInt;
      if (this.suc != null) {
        i = paramInt + d.a.a.b.b.a.e(32, this.suc);
      }
      paramInt = i;
      if (this.sub != null) {
        paramInt = i + d.a.a.b.b.a.e(33, this.sub);
      }
      i = paramInt;
      if (this.sua != null) {
        i = paramInt + d.a.a.b.b.a.e(34, this.sua);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tQp == null) {
          throw new b("Not all required fields were included: ClientImgId");
        }
        if (this.svF == null) {
          throw new b("Not all required fields were included: FromUserName");
        }
        if (this.svG == null) {
          throw new b("Not all required fields were included: ToUserName");
        }
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cbh localcbh = (cbh)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbh.tEX = ((gc)localObject1);
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbh.tQp = ((bml)localObject1);
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbh.svF = ((bml)localObject1);
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbh.svG = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          localcbh.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcbh.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcbh.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbh.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 9: 
          localcbh.kSW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcbh.svK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localcbh.tfc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localcbh.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localcbh.tLm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localcbh.euN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localcbh.tQq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localcbh.tQr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localcbh.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localcbh.sGR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localcbh.tQs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localcbh.tQt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localcbh.tQu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localcbh.tQv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localcbh.tQw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 24: 
          localcbh.tQx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          localcbh.tlO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 26: 
          localcbh.sRM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 27: 
          localcbh.jnU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 28: 
          localcbh.sGS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 29: 
          localcbh.sGT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 30: 
          localcbh.tHc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 31: 
          localcbh.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 32: 
          localcbh.suc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 33: 
          localcbh.sub = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcbh.sua = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbh
 * JD-Core Version:    0.7.0.1
 */