package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bfq
  extends com.tencent.mm.bv.a
{
  public int hPS;
  public int hQR;
  public String kRZ;
  public String mQp;
  public int pyo;
  public String sSo;
  public int tAp;
  public LinkedList<asu> tAq = new LinkedList();
  public int tAr;
  public String tAs;
  public String tAt;
  public int tAu;
  public String tAv;
  public int tAw;
  public LinkedList<tz> tAx = new LinkedList();
  public String tfK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tAp);
      paramVarArgs.d(2, 8, this.tAq);
      paramVarArgs.gB(3, this.hPS);
      paramVarArgs.gB(4, this.tAr);
      if (this.sSo != null) {
        paramVarArgs.d(5, this.sSo);
      }
      if (this.tfK != null) {
        paramVarArgs.d(6, this.tfK);
      }
      if (this.tAs != null) {
        paramVarArgs.d(7, this.tAs);
      }
      if (this.tAt != null) {
        paramVarArgs.d(8, this.tAt);
      }
      paramVarArgs.gB(9, this.hQR);
      if (this.kRZ != null) {
        paramVarArgs.d(10, this.kRZ);
      }
      if (this.mQp != null) {
        paramVarArgs.d(11, this.mQp);
      }
      paramVarArgs.gB(12, this.tAu);
      paramVarArgs.gB(13, this.pyo);
      if (this.tAv != null) {
        paramVarArgs.d(14, this.tAv);
      }
      paramVarArgs.gB(15, this.tAw);
      paramVarArgs.d(16, 8, this.tAx);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.tAp) + 0 + d.a.a.a.c(2, 8, this.tAq) + d.a.a.a.gy(3, this.hPS) + d.a.a.a.gy(4, this.tAr);
      paramInt = i;
      if (this.sSo != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sSo);
      }
      i = paramInt;
      if (this.tfK != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tfK);
      }
      paramInt = i;
      if (this.tAs != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tAs);
      }
      i = paramInt;
      if (this.tAt != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tAt);
      }
      i += d.a.a.a.gy(9, this.hQR);
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.kRZ);
      }
      i = paramInt;
      if (this.mQp != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.mQp);
      }
      i = i + d.a.a.a.gy(12, this.tAu) + d.a.a.a.gy(13, this.pyo);
      paramInt = i;
      if (this.tAv != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.tAv);
      }
      return paramInt + d.a.a.a.gy(15, this.tAw) + d.a.a.a.c(16, 8, this.tAx);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tAq.clear();
      this.tAx.clear();
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
      bfq localbfq = (bfq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbfq.tAp = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new asu();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((asu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbfq.tAq.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localbfq.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localbfq.tAr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localbfq.sSo = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        localbfq.tfK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        localbfq.tAs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        localbfq.tAt = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        localbfq.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localbfq.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 11: 
        localbfq.mQp = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 12: 
        localbfq.tAu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 13: 
        localbfq.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        localbfq.tAv = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 15: 
        localbfq.tAw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new tz();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((tz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localbfq.tAx.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfq
 * JD-Core Version:    0.7.0.1
 */