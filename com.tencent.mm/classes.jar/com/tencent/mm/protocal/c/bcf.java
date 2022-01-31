package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bcf
  extends bly
{
  public long ceq;
  public int lLk;
  public int lLl;
  public String lLm;
  public String lLn;
  public String lLo;
  public bjg sTP;
  public int srt;
  public long txA;
  public long txB;
  public LinkedList<aog> txC = new LinkedList();
  public String txD;
  public String txE;
  public String txF;
  public int txG;
  public int txH;
  public String txI;
  public int txx;
  public int txy;
  public int txz;
  
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
      paramVarArgs.gB(2, this.txx);
      paramVarArgs.gB(3, this.txy);
      paramVarArgs.gB(4, this.lLk);
      paramVarArgs.Y(5, this.ceq);
      paramVarArgs.gB(6, this.txz);
      paramVarArgs.Y(7, this.txA);
      paramVarArgs.gB(8, this.srt);
      paramVarArgs.Y(9, this.txB);
      paramVarArgs.gB(10, this.lLl);
      paramVarArgs.d(11, 8, this.txC);
      if (this.lLm != null) {
        paramVarArgs.d(12, this.lLm);
      }
      if (this.txD != null) {
        paramVarArgs.d(13, this.txD);
      }
      if (this.txE != null) {
        paramVarArgs.d(14, this.txE);
      }
      if (this.txF != null) {
        paramVarArgs.d(15, this.txF);
      }
      paramVarArgs.gB(16, this.txG);
      if (this.lLo != null) {
        paramVarArgs.d(17, this.lLo);
      }
      paramVarArgs.gB(18, this.txH);
      if (this.lLn != null) {
        paramVarArgs.d(19, this.lLn);
      }
      if (this.sTP != null)
      {
        paramVarArgs.gD(20, this.sTP.btq());
        this.sTP.a(paramVarArgs);
      }
      if (this.txI != null) {
        paramVarArgs.d(21, this.txI);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1413;
      }
    }
    label1413:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.txx) + d.a.a.a.gy(3, this.txy) + d.a.a.a.gy(4, this.lLk) + d.a.a.a.X(5, this.ceq) + d.a.a.a.gy(6, this.txz) + d.a.a.a.X(7, this.txA) + d.a.a.a.gy(8, this.srt) + d.a.a.a.X(9, this.txB) + d.a.a.a.gy(10, this.lLl) + d.a.a.a.c(11, 8, this.txC);
      paramInt = i;
      if (this.lLm != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.lLm);
      }
      i = paramInt;
      if (this.txD != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.txD);
      }
      paramInt = i;
      if (this.txE != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.txE);
      }
      i = paramInt;
      if (this.txF != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.txF);
      }
      i += d.a.a.a.gy(16, this.txG);
      paramInt = i;
      if (this.lLo != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.lLo);
      }
      i = paramInt + d.a.a.a.gy(18, this.txH);
      paramInt = i;
      if (this.lLn != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.lLn);
      }
      i = paramInt;
      if (this.sTP != null) {
        i = paramInt + d.a.a.a.gA(20, this.sTP.btq());
      }
      paramInt = i;
      if (this.txI != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.txI);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.txC.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        bcf localbcf = (bcf)paramVarArgs[1];
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
            localbcf.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbcf.txx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbcf.txy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbcf.lLk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbcf.ceq = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbcf.txz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbcf.txA = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 8: 
          localbcf.srt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbcf.txB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 10: 
          localbcf.lLl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aog();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aog)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbcf.txC.add(localObject1);
            paramInt += 1;
          }
        case 12: 
          localbcf.lLm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbcf.txD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbcf.txE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbcf.txF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localbcf.txG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localbcf.lLo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localbcf.txH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localbcf.lLn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbcf.sTP = ((bjg)localObject1);
            paramInt += 1;
          }
        }
        localbcf.txI = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcf
 * JD-Core Version:    0.7.0.1
 */