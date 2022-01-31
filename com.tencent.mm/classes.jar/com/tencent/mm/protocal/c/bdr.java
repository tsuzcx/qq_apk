package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bdr
  extends com.tencent.mm.bv.a
{
  public String epN;
  public String mOZ;
  public String nzq;
  public String tmi;
  public int tyS;
  public String tyT;
  public int tyU;
  public String tyV;
  public int tyW;
  public String tyX;
  public long tyY;
  public LinkedList<bdi> tyZ = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tyS);
      if (this.tyT != null) {
        paramVarArgs.d(2, this.tyT);
      }
      if (this.tmi != null) {
        paramVarArgs.d(3, this.tmi);
      }
      paramVarArgs.gB(4, this.tyU);
      if (this.mOZ != null) {
        paramVarArgs.d(5, this.mOZ);
      }
      if (this.tyV != null) {
        paramVarArgs.d(6, this.tyV);
      }
      if (this.nzq != null) {
        paramVarArgs.d(7, this.nzq);
      }
      paramVarArgs.gB(8, this.tyW);
      if (this.epN != null) {
        paramVarArgs.d(9, this.epN);
      }
      if (this.tyX != null) {
        paramVarArgs.d(10, this.tyX);
      }
      paramVarArgs.Y(11, this.tyY);
      paramVarArgs.d(12, 8, this.tyZ);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.tyS) + 0;
      paramInt = i;
      if (this.tyT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tyT);
      }
      i = paramInt;
      if (this.tmi != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tmi);
      }
      i += d.a.a.a.gy(4, this.tyU);
      paramInt = i;
      if (this.mOZ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.mOZ);
      }
      i = paramInt;
      if (this.tyV != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tyV);
      }
      paramInt = i;
      if (this.nzq != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.nzq);
      }
      i = paramInt + d.a.a.a.gy(8, this.tyW);
      paramInt = i;
      if (this.epN != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.epN);
      }
      i = paramInt;
      if (this.tyX != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.tyX);
      }
      return i + d.a.a.a.X(11, this.tyY) + d.a.a.a.c(12, 8, this.tyZ);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tyZ.clear();
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
      bdr localbdr = (bdr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbdr.tyS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbdr.tyT = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbdr.tmi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localbdr.tyU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localbdr.mOZ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        localbdr.tyV = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        localbdr.nzq = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        localbdr.tyW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localbdr.epN = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 10: 
        localbdr.tyX = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 11: 
        localbdr.tyY = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bdi();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bdi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localbdr.tyZ.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdr
 * JD-Core Version:    0.7.0.1
 */