package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class jh
  extends blm
{
  public int euw;
  public int pyo;
  public int sBR;
  public int sDQ;
  public bmk sDR;
  public int sDS;
  public int sDT;
  public int sDU;
  public int sDV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sDR == null) {
        throw new b("Not all required fields were included: ImageBuffer");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.sDQ);
      if (this.sDR != null)
      {
        paramVarArgs.gD(3, this.sDR.btq());
        this.sDR.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.sDS);
      paramVarArgs.gB(5, this.sDT);
      paramVarArgs.gB(6, this.euw);
      paramVarArgs.gB(7, this.sDU);
      paramVarArgs.gB(8, this.sBR);
      paramVarArgs.gB(9, this.sDV);
      paramVarArgs.gB(10, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sDQ);
      paramInt = i;
      if (this.sDR != null) {
        paramInt = i + d.a.a.a.gA(3, this.sDR.btq());
      }
      return paramInt + d.a.a.a.gy(4, this.sDS) + d.a.a.a.gy(5, this.sDT) + d.a.a.a.gy(6, this.euw) + d.a.a.a.gy(7, this.sDU) + d.a.a.a.gy(8, this.sBR) + d.a.a.a.gy(9, this.sDV) + d.a.a.a.gy(10, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sDR != null) {
          break;
        }
        throw new b("Not all required fields were included: ImageBuffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        jh localjh = (jh)paramVarArgs[1];
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
            localjh.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localjh.sDQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localjh.sDR = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localjh.sDS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localjh.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localjh.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localjh.sDU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localjh.sBR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localjh.sDV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localjh.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jh
 * JD-Core Version:    0.7.0.1
 */