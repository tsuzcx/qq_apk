package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bic
  extends bly
{
  public long ceq;
  public int lLk;
  public int lLl;
  public String lLm;
  public String lLn;
  public String lLo;
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
      paramVarArgs.Y(2, this.ceq);
      paramVarArgs.gB(3, this.txz);
      paramVarArgs.Y(4, this.txA);
      paramVarArgs.gB(5, this.srt);
      paramVarArgs.Y(6, this.txB);
      paramVarArgs.gB(9, this.lLl);
      paramVarArgs.d(10, 8, this.txC);
      if (this.lLm != null) {
        paramVarArgs.d(11, this.lLm);
      }
      if (this.txD != null) {
        paramVarArgs.d(12, this.txD);
      }
      if (this.txE != null) {
        paramVarArgs.d(13, this.txE);
      }
      if (this.txF != null) {
        paramVarArgs.d(14, this.txF);
      }
      paramVarArgs.gB(15, this.txG);
      if (this.lLo != null) {
        paramVarArgs.d(16, this.lLo);
      }
      paramVarArgs.gB(17, this.txH);
      if (this.lLn != null) {
        paramVarArgs.d(18, this.lLn);
      }
      paramVarArgs.gB(19, this.txy);
      paramVarArgs.gB(20, this.lLk);
      paramVarArgs.gB(21, this.txx);
      if (this.txI != null) {
        paramVarArgs.d(22, this.txI);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1276;
      }
    }
    label1276:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.ceq) + d.a.a.a.gy(3, this.txz) + d.a.a.a.X(4, this.txA) + d.a.a.a.gy(5, this.srt) + d.a.a.a.X(6, this.txB) + d.a.a.a.gy(9, this.lLl) + d.a.a.a.c(10, 8, this.txC);
      paramInt = i;
      if (this.lLm != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.lLm);
      }
      i = paramInt;
      if (this.txD != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.txD);
      }
      paramInt = i;
      if (this.txE != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.txE);
      }
      i = paramInt;
      if (this.txF != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.txF);
      }
      i += d.a.a.a.gy(15, this.txG);
      paramInt = i;
      if (this.lLo != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.lLo);
      }
      i = paramInt + d.a.a.a.gy(17, this.txH);
      paramInt = i;
      if (this.lLn != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.lLn);
      }
      i = paramInt + d.a.a.a.gy(19, this.txy) + d.a.a.a.gy(20, this.lLk) + d.a.a.a.gy(21, this.txx);
      paramInt = i;
      if (this.txI != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.txI);
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
        bic localbic = (bic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
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
            localbic.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbic.ceq = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localbic.txz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbic.txA = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localbic.srt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbic.txB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 9: 
          localbic.lLl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aog();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aog)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbic.txC.add(localObject1);
            paramInt += 1;
          }
        case 11: 
          localbic.lLm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localbic.txD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbic.txE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbic.txF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbic.txG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localbic.lLo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localbic.txH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localbic.lLn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localbic.txy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localbic.lLk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localbic.txx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbic.txI = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bic
 * JD-Core Version:    0.7.0.1
 */