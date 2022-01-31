package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class lf
  extends blm
{
  public String euK;
  public String kWm;
  public String kWn;
  public int pyo;
  public String sGF;
  public int sGG;
  public int sGH;
  public bmk sGI;
  public float sGJ;
  public float sGK;
  public String sGL;
  public int sGM;
  public int sGN;
  public int sGO;
  public int sGP;
  public String sGQ;
  public int sGR;
  public int sGS;
  public int sGT;
  public String sua;
  public String sub;
  public String suc;
  public String svK;
  public int swS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sGF != null) {
        paramVarArgs.d(1, this.sGF);
      }
      if (this.kWn != null) {
        paramVarArgs.d(2, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(3, this.kWm);
      }
      paramVarArgs.gB(4, this.sGG);
      paramVarArgs.gB(5, this.sGH);
      if (this.svK != null) {
        paramVarArgs.d(6, this.svK);
      }
      if (this.sGI != null)
      {
        paramVarArgs.gD(7, this.sGI.btq());
        this.sGI.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.pyo);
      paramVarArgs.m(9, this.sGJ);
      paramVarArgs.m(10, this.sGK);
      if (this.sGL != null) {
        paramVarArgs.d(11, this.sGL);
      }
      paramVarArgs.gB(12, this.sGM);
      paramVarArgs.gB(13, this.sGN);
      paramVarArgs.gB(14, this.sGO);
      paramVarArgs.gB(15, this.sGP);
      if (this.sGQ != null) {
        paramVarArgs.d(16, this.sGQ);
      }
      paramVarArgs.gB(17, this.sGR);
      paramVarArgs.gB(18, this.sGS);
      paramVarArgs.gB(19, this.sGT);
      paramVarArgs.gB(20, this.swS);
      if (this.euK != null) {
        paramVarArgs.d(21, this.euK);
      }
      if (this.suc != null) {
        paramVarArgs.d(22, this.suc);
      }
      if (this.sub != null) {
        paramVarArgs.d(23, this.sub);
      }
      if (this.sua != null) {
        paramVarArgs.d(24, this.sua);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGF == null) {
        break label1346;
      }
    }
    label1346:
    for (int i = d.a.a.b.b.a.e(1, this.sGF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kWn);
      }
      i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWm);
      }
      i = i + d.a.a.a.gy(4, this.sGG) + d.a.a.a.gy(5, this.sGH);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.svK);
      }
      i = paramInt;
      if (this.sGI != null) {
        i = paramInt + d.a.a.a.gA(7, this.sGI.btq());
      }
      i = i + d.a.a.a.gy(8, this.pyo) + (d.a.a.b.b.a.dQ(9) + 4) + (d.a.a.b.b.a.dQ(10) + 4);
      paramInt = i;
      if (this.sGL != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sGL);
      }
      i = paramInt + d.a.a.a.gy(12, this.sGM) + d.a.a.a.gy(13, this.sGN) + d.a.a.a.gy(14, this.sGO) + d.a.a.a.gy(15, this.sGP);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.sGQ);
      }
      i = paramInt + d.a.a.a.gy(17, this.sGR) + d.a.a.a.gy(18, this.sGS) + d.a.a.a.gy(19, this.sGT) + d.a.a.a.gy(20, this.swS);
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.euK);
      }
      i = paramInt;
      if (this.suc != null) {
        i = paramInt + d.a.a.b.b.a.e(22, this.suc);
      }
      paramInt = i;
      if (this.sub != null) {
        paramInt = i + d.a.a.b.b.a.e(23, this.sub);
      }
      i = paramInt;
      if (this.sua != null) {
        i = paramInt + d.a.a.b.b.a.e(24, this.sua);
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        lf locallf = (lf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locallf.sGF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locallf.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          locallf.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          locallf.sGG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          locallf.sGH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          locallf.svK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            locallf.sGI = ((bmk)localObject1);
            paramInt += 1;
          }
        case 8: 
          locallf.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          locallf.sGJ = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 10: 
          locallf.sGK = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 11: 
          locallf.sGL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          locallf.sGM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          locallf.sGN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          locallf.sGO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          locallf.sGP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          locallf.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          locallf.sGR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          locallf.sGS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          locallf.sGT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          locallf.swS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          locallf.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          locallf.suc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 23: 
          locallf.sub = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        locallf.sua = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lf
 * JD-Core Version:    0.7.0.1
 */