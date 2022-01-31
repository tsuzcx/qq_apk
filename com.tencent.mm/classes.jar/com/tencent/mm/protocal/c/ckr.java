package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ckr
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public int pyo;
  public int sDT;
  public String sFF;
  public String sYZ;
  public String tDn;
  public int tEN;
  public int tNf;
  public LinkedList<String> tOe = new LinkedList();
  public int tXU;
  public LinkedList<rb> tXV = new LinkedList();
  public String tXW;
  public int tXX;
  public int tpJ = 2;
  public String tpM;
  public int tqS;
  public atp tqT;
  public String tvD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sDT);
      paramVarArgs.gB(2, this.tqS);
      paramVarArgs.gB(3, this.tEN);
      if (this.sYZ != null) {
        paramVarArgs.d(4, this.sYZ);
      }
      if (this.tqT != null)
      {
        paramVarArgs.gD(5, this.tqT.btq());
        this.tqT.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.pyo);
      if (this.sFF != null) {
        paramVarArgs.d(7, this.sFF);
      }
      paramVarArgs.gB(8, this.tXU);
      paramVarArgs.gB(9, this.tpJ);
      paramVarArgs.d(10, 8, this.tXV);
      if (this.tpM != null) {
        paramVarArgs.d(11, this.tpM);
      }
      if (this.tvD != null) {
        paramVarArgs.d(12, this.tvD);
      }
      paramVarArgs.gB(13, this.tNf);
      if (this.tXW != null) {
        paramVarArgs.d(14, this.tXW);
      }
      if (this.tDn != null) {
        paramVarArgs.d(15, this.tDn);
      }
      paramVarArgs.d(16, 1, this.tOe);
      paramVarArgs.gB(17, this.tXX);
      paramVarArgs.gB(18, this.hQR);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.sDT) + 0 + d.a.a.a.gy(2, this.tqS) + d.a.a.a.gy(3, this.tEN);
      paramInt = i;
      if (this.sYZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sYZ);
      }
      i = paramInt;
      if (this.tqT != null) {
        i = paramInt + d.a.a.a.gA(5, this.tqT.btq());
      }
      i += d.a.a.a.gy(6, this.pyo);
      paramInt = i;
      if (this.sFF != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sFF);
      }
      i = paramInt + d.a.a.a.gy(8, this.tXU) + d.a.a.a.gy(9, this.tpJ) + d.a.a.a.c(10, 8, this.tXV);
      paramInt = i;
      if (this.tpM != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tpM);
      }
      i = paramInt;
      if (this.tvD != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.tvD);
      }
      i += d.a.a.a.gy(13, this.tNf);
      paramInt = i;
      if (this.tXW != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.tXW);
      }
      i = paramInt;
      if (this.tDn != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tDn);
      }
      return i + d.a.a.a.c(16, 1, this.tOe) + d.a.a.a.gy(17, this.tXX) + d.a.a.a.gy(18, this.hQR);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tXV.clear();
      this.tOe.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      ckr localckr = (ckr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localckr.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localckr.tqS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localckr.tEN = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localckr.sYZ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((atp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckr.tqT = ((atp)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localckr.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localckr.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        localckr.tXU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localckr.tpJ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rb();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localckr.tXV.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 11: 
        localckr.tpM = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 12: 
        localckr.tvD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 13: 
        localckr.tNf = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        localckr.tXW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 15: 
        localckr.tDn = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 16: 
        localckr.tOe.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      case 17: 
        localckr.tXX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localckr.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckr
 * JD-Core Version:    0.7.0.1
 */