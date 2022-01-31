package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class azd
  extends bly
{
  public String hPY;
  public int hQq;
  public int jwX;
  public String jwZ;
  public apl sBD;
  public jv sBE;
  public ays sBF;
  public ld sCd;
  public ld sCe;
  public ld sCf;
  public String sst;
  public String stN;
  public int stQ;
  public String stT;
  public String stU;
  public int stV;
  public String stW;
  public String syp;
  public bsd sys;
  public int syx;
  public String tgU;
  public bmk tgX;
  public String tvf;
  public int tvg;
  public String tvh;
  public int tvi;
  public bex tvj;
  public int tvk;
  public String tvl;
  public String tvm;
  public bom tvn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.jwX);
      if (this.sst != null) {
        paramVarArgs.d(3, this.sst);
      }
      if (this.stT != null) {
        paramVarArgs.d(4, this.stT);
      }
      if (this.stU != null) {
        paramVarArgs.d(5, this.stU);
      }
      if (this.tvf != null) {
        paramVarArgs.d(6, this.tvf);
      }
      if (this.stN != null) {
        paramVarArgs.d(7, this.stN);
      }
      paramVarArgs.gB(8, this.stV);
      paramVarArgs.gB(9, this.tvg);
      if (this.tvh != null) {
        paramVarArgs.d(10, this.tvh);
      }
      if (this.sBE != null)
      {
        paramVarArgs.gD(14, this.sBE.btq());
        this.sBE.a(paramVarArgs);
      }
      if (this.stW != null) {
        paramVarArgs.d(15, this.stW);
      }
      if (this.hPY != null) {
        paramVarArgs.d(16, this.hPY);
      }
      paramVarArgs.gB(17, this.hQq);
      if (this.sBF != null)
      {
        paramVarArgs.gD(18, this.sBF.btq());
        this.sBF.a(paramVarArgs);
      }
      paramVarArgs.gB(19, this.tvi);
      paramVarArgs.gB(20, this.stQ);
      if (this.syp != null) {
        paramVarArgs.d(21, this.syp);
      }
      if (this.tvj != null)
      {
        paramVarArgs.gD(22, this.tvj.btq());
        this.tvj.a(paramVarArgs);
      }
      if (this.jwZ != null) {
        paramVarArgs.d(23, this.jwZ);
      }
      paramVarArgs.gB(24, this.tvk);
      if (this.sBD != null)
      {
        paramVarArgs.gD(25, this.sBD.btq());
        this.sBD.a(paramVarArgs);
      }
      if (this.tvl != null) {
        paramVarArgs.d(26, this.tvl);
      }
      if (this.sCd != null)
      {
        paramVarArgs.gD(27, this.sCd.btq());
        this.sCd.a(paramVarArgs);
      }
      if (this.tvm != null) {
        paramVarArgs.d(28, this.tvm);
      }
      if (this.tgU != null) {
        paramVarArgs.d(29, this.tgU);
      }
      if (this.tgX != null)
      {
        paramVarArgs.gD(30, this.tgX.btq());
        this.tgX.a(paramVarArgs);
      }
      if (this.sys != null)
      {
        paramVarArgs.gD(31, this.sys.btq());
        this.sys.a(paramVarArgs);
      }
      if (this.sCe != null)
      {
        paramVarArgs.gD(32, this.sCe.btq());
        this.sCe.a(paramVarArgs);
      }
      if (this.sCf != null)
      {
        paramVarArgs.gD(33, this.sCf.btq());
        this.sCf.a(paramVarArgs);
      }
      if (this.tvn != null)
      {
        paramVarArgs.gD(34, this.tvn.btq());
        this.tvn.a(paramVarArgs);
      }
      paramVarArgs.gB(35, this.syx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label2862;
      }
    }
    label2862:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.jwX);
      paramInt = i;
      if (this.sst != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sst);
      }
      i = paramInt;
      if (this.stT != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.stT);
      }
      paramInt = i;
      if (this.stU != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.stU);
      }
      i = paramInt;
      if (this.tvf != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tvf);
      }
      paramInt = i;
      if (this.stN != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.stN);
      }
      i = paramInt + d.a.a.a.gy(8, this.stV) + d.a.a.a.gy(9, this.tvg);
      paramInt = i;
      if (this.tvh != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tvh);
      }
      i = paramInt;
      if (this.sBE != null) {
        i = paramInt + d.a.a.a.gA(14, this.sBE.btq());
      }
      paramInt = i;
      if (this.stW != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.stW);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.hPY);
      }
      i += d.a.a.a.gy(17, this.hQq);
      paramInt = i;
      if (this.sBF != null) {
        paramInt = i + d.a.a.a.gA(18, this.sBF.btq());
      }
      i = paramInt + d.a.a.a.gy(19, this.tvi) + d.a.a.a.gy(20, this.stQ);
      paramInt = i;
      if (this.syp != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.syp);
      }
      i = paramInt;
      if (this.tvj != null) {
        i = paramInt + d.a.a.a.gA(22, this.tvj.btq());
      }
      paramInt = i;
      if (this.jwZ != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.jwZ);
      }
      i = paramInt + d.a.a.a.gy(24, this.tvk);
      paramInt = i;
      if (this.sBD != null) {
        paramInt = i + d.a.a.a.gA(25, this.sBD.btq());
      }
      i = paramInt;
      if (this.tvl != null) {
        i = paramInt + d.a.a.b.b.a.e(26, this.tvl);
      }
      paramInt = i;
      if (this.sCd != null) {
        paramInt = i + d.a.a.a.gA(27, this.sCd.btq());
      }
      i = paramInt;
      if (this.tvm != null) {
        i = paramInt + d.a.a.b.b.a.e(28, this.tvm);
      }
      paramInt = i;
      if (this.tgU != null) {
        paramInt = i + d.a.a.b.b.a.e(29, this.tgU);
      }
      i = paramInt;
      if (this.tgX != null) {
        i = paramInt + d.a.a.a.gA(30, this.tgX.btq());
      }
      paramInt = i;
      if (this.sys != null) {
        paramInt = i + d.a.a.a.gA(31, this.sys.btq());
      }
      i = paramInt;
      if (this.sCe != null) {
        i = paramInt + d.a.a.a.gA(32, this.sCe.btq());
      }
      paramInt = i;
      if (this.sCf != null) {
        paramInt = i + d.a.a.a.gA(33, this.sCf.btq());
      }
      i = paramInt;
      if (this.tvn != null) {
        i = paramInt + d.a.a.a.gA(34, this.tvn.btq());
      }
      return i + d.a.a.a.gy(35, this.syx);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        azd localazd = (azd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
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
            localazd.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localazd.jwX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localazd.sst = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localazd.stT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localazd.stU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localazd.tvf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localazd.stN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localazd.stV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localazd.tvg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localazd.tvh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.sBE = ((jv)localObject1);
            paramInt += 1;
          }
        case 15: 
          localazd.stW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localazd.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localazd.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ays();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ays)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.sBF = ((ays)localObject1);
            paramInt += 1;
          }
        case 19: 
          localazd.tvi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localazd.stQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localazd.syp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bex();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bex)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.tvj = ((bex)localObject1);
            paramInt += 1;
          }
        case 23: 
          localazd.jwZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 24: 
          localazd.tvk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.sBD = ((apl)localObject1);
            paramInt += 1;
          }
        case 26: 
          localazd.tvl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 27: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.sCd = ((ld)localObject1);
            paramInt += 1;
          }
        case 28: 
          localazd.tvm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 29: 
          localazd.tgU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 30: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.tgX = ((bmk)localObject1);
            paramInt += 1;
          }
        case 31: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.sys = ((bsd)localObject1);
            paramInt += 1;
          }
        case 32: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.sCe = ((ld)localObject1);
            paramInt += 1;
          }
        case 33: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.sCf = ((ld)localObject1);
            paramInt += 1;
          }
        case 34: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bom();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bom)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazd.tvn = ((bom)localObject1);
            paramInt += 1;
          }
        }
        localazd.syx = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azd
 * JD-Core Version:    0.7.0.1
 */