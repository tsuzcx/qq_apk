package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bcr
  extends com.tencent.mm.bv.a
{
  public int hQL;
  public int hQQ;
  public String jnU;
  public String kRZ;
  public int kWl;
  public String sSc;
  public bmk swR;
  public bmk txZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.kWl);
      paramVarArgs.gB(2, this.hQQ);
      if (this.kRZ != null) {
        paramVarArgs.d(3, this.kRZ);
      }
      paramVarArgs.gB(4, this.hQL);
      if (this.swR != null)
      {
        paramVarArgs.gD(5, this.swR.btq());
        this.swR.a(paramVarArgs);
      }
      if (this.sSc != null) {
        paramVarArgs.d(6, this.sSc);
      }
      if (this.txZ != null)
      {
        paramVarArgs.gD(7, this.txZ.btq());
        this.txZ.a(paramVarArgs);
      }
      if (this.jnU != null) {
        paramVarArgs.d(8, this.jnU);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.kWl) + 0 + d.a.a.a.gy(2, this.hQQ);
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kRZ);
      }
      i = paramInt + d.a.a.a.gy(4, this.hQL);
      paramInt = i;
      if (this.swR != null) {
        paramInt = i + d.a.a.a.gA(5, this.swR.btq());
      }
      i = paramInt;
      if (this.sSc != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sSc);
      }
      paramInt = i;
      if (this.txZ != null) {
        paramInt = i + d.a.a.a.gA(7, this.txZ.btq());
      }
      i = paramInt;
    } while (this.jnU == null);
    return paramInt + d.a.a.b.b.a.e(8, this.jnU);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
      bcr localbcr = (bcr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbcr.kWl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbcr.hQQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localbcr.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localbcr.hQL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbcr.swR = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localbcr.sSc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbcr.txZ = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localbcr.jnU = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcr
 * JD-Core Version:    0.7.0.1
 */