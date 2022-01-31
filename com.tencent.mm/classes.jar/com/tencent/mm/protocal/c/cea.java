package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cea
  extends bly
{
  public int sST;
  public long sSU;
  public int tSE;
  public int tSL;
  public cfj tSM;
  public int tSN;
  public int tSO;
  public int tSP;
  public int tSQ;
  public bmk tSR;
  
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
      paramVarArgs.gB(2, this.sST);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.gB(4, this.tSL);
      if (this.tSM != null)
      {
        paramVarArgs.gD(5, this.tSM.btq());
        this.tSM.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.tSE);
      paramVarArgs.gB(7, this.tSN);
      paramVarArgs.gB(8, this.tSO);
      paramVarArgs.gB(9, this.tSP);
      paramVarArgs.gB(10, this.tSQ);
      if (this.tSR != null)
      {
        paramVarArgs.gD(11, this.tSR.btq());
        this.tSR.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label911;
      }
    }
    label911:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.X(3, this.sSU) + d.a.a.a.gy(4, this.tSL);
      paramInt = i;
      if (this.tSM != null) {
        paramInt = i + d.a.a.a.gA(5, this.tSM.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.tSE) + d.a.a.a.gy(7, this.tSN) + d.a.a.a.gy(8, this.tSO) + d.a.a.a.gy(9, this.tSP) + d.a.a.a.gy(10, this.tSQ);
      paramInt = i;
      if (this.tSR != null) {
        paramInt = i + d.a.a.a.gA(11, this.tSR.btq());
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
        cea localcea = (cea)paramVarArgs[1];
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
            localcea.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcea.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcea.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localcea.tSL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcea.tSM = ((cfj)localObject1);
            paramInt += 1;
          }
        case 6: 
          localcea.tSE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcea.tSN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcea.tSO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcea.tSP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcea.tSQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localcea.tSR = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cea
 * JD-Core Version:    0.7.0.1
 */