package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ib
  extends bly
{
  public String bJY;
  public String sBA;
  public int sBB;
  public String sBC;
  public apl sBD;
  public jv sBE;
  public ays sBF;
  public String sBG;
  public int sBH;
  public bmo sBI;
  public String sBJ;
  public String sBK;
  public String sBL;
  public String sBM;
  public int sBw;
  public String sBx;
  public int stS;
  public String sxM;
  public bsd sys;
  public String syt;
  public int syx;
  
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
      if (this.bJY != null) {
        paramVarArgs.d(2, this.bJY);
      }
      if (this.sBA != null) {
        paramVarArgs.d(3, this.sBA);
      }
      paramVarArgs.gB(4, this.sBB);
      if (this.sBC != null) {
        paramVarArgs.d(5, this.sBC);
      }
      if (this.sxM != null) {
        paramVarArgs.d(6, this.sxM);
      }
      if (this.sBD != null)
      {
        paramVarArgs.gD(7, this.sBD.btq());
        this.sBD.a(paramVarArgs);
      }
      if (this.sBE != null)
      {
        paramVarArgs.gD(8, this.sBE.btq());
        this.sBE.a(paramVarArgs);
      }
      if (this.sBF != null)
      {
        paramVarArgs.gD(9, this.sBF.btq());
        this.sBF.a(paramVarArgs);
      }
      if (this.syt != null) {
        paramVarArgs.d(10, this.syt);
      }
      paramVarArgs.gB(11, this.stS);
      if (this.sBG != null) {
        paramVarArgs.d(12, this.sBG);
      }
      paramVarArgs.gB(13, this.sBH);
      if (this.sBI != null)
      {
        paramVarArgs.gD(14, this.sBI.btq());
        this.sBI.a(paramVarArgs);
      }
      if (this.sBJ != null) {
        paramVarArgs.d(15, this.sBJ);
      }
      if (this.sBK != null) {
        paramVarArgs.d(16, this.sBK);
      }
      if (this.sys != null)
      {
        paramVarArgs.gD(17, this.sys.btq());
        this.sys.a(paramVarArgs);
      }
      paramVarArgs.gB(18, this.syx);
      if (this.sBL != null) {
        paramVarArgs.d(19, this.sBL);
      }
      if (this.sBM != null) {
        paramVarArgs.d(20, this.sBM);
      }
      paramVarArgs.gB(21, this.sBw);
      if (this.sBx != null) {
        paramVarArgs.d(22, this.sBx);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1874;
      }
    }
    label1874:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bJY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bJY);
      }
      i = paramInt;
      if (this.sBA != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sBA);
      }
      i += d.a.a.a.gy(4, this.sBB);
      paramInt = i;
      if (this.sBC != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sBC);
      }
      i = paramInt;
      if (this.sxM != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sxM);
      }
      paramInt = i;
      if (this.sBD != null) {
        paramInt = i + d.a.a.a.gA(7, this.sBD.btq());
      }
      i = paramInt;
      if (this.sBE != null) {
        i = paramInt + d.a.a.a.gA(8, this.sBE.btq());
      }
      paramInt = i;
      if (this.sBF != null) {
        paramInt = i + d.a.a.a.gA(9, this.sBF.btq());
      }
      i = paramInt;
      if (this.syt != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.syt);
      }
      i += d.a.a.a.gy(11, this.stS);
      paramInt = i;
      if (this.sBG != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.sBG);
      }
      i = paramInt + d.a.a.a.gy(13, this.sBH);
      paramInt = i;
      if (this.sBI != null) {
        paramInt = i + d.a.a.a.gA(14, this.sBI.btq());
      }
      i = paramInt;
      if (this.sBJ != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.sBJ);
      }
      paramInt = i;
      if (this.sBK != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.sBK);
      }
      i = paramInt;
      if (this.sys != null) {
        i = paramInt + d.a.a.a.gA(17, this.sys.btq());
      }
      i += d.a.a.a.gy(18, this.syx);
      paramInt = i;
      if (this.sBL != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.sBL);
      }
      i = paramInt;
      if (this.sBM != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.sBM);
      }
      i += d.a.a.a.gy(21, this.sBw);
      paramInt = i;
      if (this.sBx != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.sBx);
      }
      return paramInt;
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
        ib localib = (ib)paramVarArgs[1];
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
            localib.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localib.bJY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localib.sBA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localib.sBB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localib.sBC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localib.sxM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localib.sBD = ((apl)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localib.sBE = ((jv)localObject1);
            paramInt += 1;
          }
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ays();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ays)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localib.sBF = ((ays)localObject1);
            paramInt += 1;
          }
        case 10: 
          localib.syt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localib.stS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localib.sBG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localib.sBH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localib.sBI = ((bmo)localObject1);
            paramInt += 1;
          }
        case 15: 
          localib.sBJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localib.sBK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localib.sys = ((bsd)localObject1);
            paramInt += 1;
          }
        case 18: 
          localib.syx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localib.sBL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localib.sBM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localib.sBw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localib.sBx = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ib
 * JD-Core Version:    0.7.0.1
 */