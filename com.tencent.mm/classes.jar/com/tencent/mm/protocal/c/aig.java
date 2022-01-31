package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aig
  extends blm
{
  public int pyo;
  public double sDm;
  public double sDn;
  public String sYZ;
  public int ssq;
  public bmk teH;
  public int teJ;
  public double tfw;
  public double tfx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.teH == null) {
        throw new b("Not all required fields were included: Buff");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.pyo);
      paramVarArgs.gB(3, this.ssq);
      if (this.sYZ != null) {
        paramVarArgs.d(4, this.sYZ);
      }
      if (this.teH != null)
      {
        paramVarArgs.gD(5, this.teH.btq());
        this.teH.a(paramVarArgs);
      }
      paramVarArgs.b(6, this.sDm);
      paramVarArgs.b(7, this.sDn);
      paramVarArgs.b(8, this.tfw);
      paramVarArgs.b(9, this.tfx);
      paramVarArgs.gB(10, this.teJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.pyo) + d.a.a.a.gy(3, this.ssq);
      paramInt = i;
      if (this.sYZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sYZ);
      }
      i = paramInt;
      if (this.teH != null) {
        i = paramInt + d.a.a.a.gA(5, this.teH.btq());
      }
      return i + (d.a.a.b.b.a.dQ(6) + 8) + (d.a.a.b.b.a.dQ(7) + 8) + (d.a.a.b.b.a.dQ(8) + 8) + (d.a.a.b.b.a.dQ(9) + 8) + d.a.a.a.gy(10, this.teJ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.teH != null) {
          break;
        }
        throw new b("Not all required fields were included: Buff");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aig localaig = (aig)paramVarArgs[1];
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
            localaig.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaig.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localaig.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localaig.sYZ = ((d.a.a.a.a)localObject1).xpH.readString();
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
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaig.teH = ((bmk)localObject1);
            paramInt += 1;
          }
        case 6: 
          localaig.sDm = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 7: 
          localaig.sDn = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 8: 
          localaig.tfw = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 9: 
          localaig.tfx = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        }
        localaig.teJ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aig
 * JD-Core Version:    0.7.0.1
 */