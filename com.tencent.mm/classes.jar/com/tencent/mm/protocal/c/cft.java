package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cft
  extends blm
{
  public double sDm;
  public double sDn;
  public int sNU;
  public int sST;
  public long sSU;
  public long tUY;
  public bml tUZ;
  public bml tVa;
  public int tVb;
  public LinkedList<bve> tee = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tUZ == null) {
        throw new b("Not all required fields were included: NetName");
      }
      if (this.tVa == null) {
        throw new b("Not all required fields were included: WifiName");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.Y(2, this.tUY);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.gB(4, this.sNU);
      if (this.tUZ != null)
      {
        paramVarArgs.gD(5, this.tUZ.btq());
        this.tUZ.a(paramVarArgs);
      }
      if (this.tVa != null)
      {
        paramVarArgs.gD(6, this.tVa.btq());
        this.tVa.a(paramVarArgs);
      }
      paramVarArgs.b(7, this.sDm);
      paramVarArgs.b(8, this.sDn);
      paramVarArgs.gB(9, this.sST);
      paramVarArgs.gB(10, this.tVb);
      paramVarArgs.d(11, 8, this.tee);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1037;
      }
    }
    label1037:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.tUY) + d.a.a.a.X(3, this.sSU) + d.a.a.a.gy(4, this.sNU);
      paramInt = i;
      if (this.tUZ != null) {
        paramInt = i + d.a.a.a.gA(5, this.tUZ.btq());
      }
      i = paramInt;
      if (this.tVa != null) {
        i = paramInt + d.a.a.a.gA(6, this.tVa.btq());
      }
      return i + (d.a.a.b.b.a.dQ(7) + 8) + (d.a.a.b.b.a.dQ(8) + 8) + d.a.a.a.gy(9, this.sST) + d.a.a.a.gy(10, this.tVb) + d.a.a.a.c(11, 8, this.tee);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tee.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tUZ == null) {
          throw new b("Not all required fields were included: NetName");
        }
        if (this.tVa != null) {
          break;
        }
        throw new b("Not all required fields were included: WifiName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cft localcft = (cft)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcft.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcft.tUY = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localcft.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localcft.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcft.tUZ = ((bml)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcft.tVa = ((bml)localObject1);
            paramInt += 1;
          }
        case 7: 
          localcft.sDm = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 8: 
          localcft.sDn = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 9: 
          localcft.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcft.tVb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bve();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bve)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localcft.tee.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cft
 * JD-Core Version:    0.7.0.1
 */