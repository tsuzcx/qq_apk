package com.tencent.mm.plugin.wallet.a;

import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bv.a
{
  public double qkT;
  public double qkU;
  public double qkV;
  public String qkW;
  public LinkedList<q> qkX = new LinkedList();
  public g qkY;
  public int qkZ;
  public String qla;
  public String qlb;
  public double qlc;
  public double qld;
  public int qle;
  public String qlf;
  public String qlg;
  public a qlh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, this.qkT);
      paramVarArgs.b(2, this.qkU);
      paramVarArgs.b(3, this.qkV);
      if (this.qkW != null) {
        paramVarArgs.d(4, this.qkW);
      }
      paramVarArgs.d(5, 8, this.qkX);
      if (this.qkY != null)
      {
        paramVarArgs.gD(6, this.qkY.btq());
        this.qkY.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.qkZ);
      if (this.qla != null) {
        paramVarArgs.d(8, this.qla);
      }
      if (this.qlb != null) {
        paramVarArgs.d(9, this.qlb);
      }
      paramVarArgs.b(10, this.qlc);
      paramVarArgs.b(11, this.qld);
      paramVarArgs.gB(12, this.qle);
      if (this.qlf != null) {
        paramVarArgs.d(13, this.qlf);
      }
      if (this.qlg != null) {
        paramVarArgs.d(14, this.qlg);
      }
      if (this.qlh != null)
      {
        paramVarArgs.gD(15, this.qlh.btq());
        this.qlh.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.b.b.a.dQ(1) + 8 + 0 + (d.a.a.b.b.a.dQ(2) + 8) + (d.a.a.b.b.a.dQ(3) + 8);
      paramInt = i;
      if (this.qkW != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.qkW);
      }
      i = paramInt + d.a.a.a.c(5, 8, this.qkX);
      paramInt = i;
      if (this.qkY != null) {
        paramInt = i + d.a.a.a.gA(6, this.qkY.btq());
      }
      i = paramInt + d.a.a.a.gy(7, this.qkZ);
      paramInt = i;
      if (this.qla != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.qla);
      }
      i = paramInt;
      if (this.qlb != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.qlb);
      }
      i = i + (d.a.a.b.b.a.dQ(10) + 8) + (d.a.a.b.b.a.dQ(11) + 8) + d.a.a.a.gy(12, this.qle);
      paramInt = i;
      if (this.qlf != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.qlf);
      }
      i = paramInt;
      if (this.qlg != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.qlg);
      }
      paramInt = i;
    } while (this.qlh == null);
    return i + d.a.a.a.gA(15, this.qlh.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.qkX.clear();
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
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localf.qkT = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      case 2: 
        localf.qkU = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      case 3: 
        localf.qkV = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      case 4: 
        localf.qkW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localf.qkX.add(localObject1);
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
          localObject1 = new g();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localf.qkY = ((g)localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        localf.qkZ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localf.qla = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        localf.qlb = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 10: 
        localf.qlc = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      case 11: 
        localf.qld = ((d.a.a.a.a)localObject1).xpH.readDouble();
        return 0;
      case 12: 
        localf.qle = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 13: 
        localf.qlf = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 14: 
        localf.qlg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localf.qlh = ((a)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.f
 * JD-Core Version:    0.7.0.1
 */