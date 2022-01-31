package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cfo
  extends bly
{
  public int sST;
  public long sSU;
  public int tAN;
  public LinkedList<ceb> tTx = new LinkedList();
  public int tUM;
  public LinkedList<ceb> tUN = new LinkedList();
  public int tUO;
  public LinkedList<ceb> tUP = new LinkedList();
  public int tUQ;
  public int tUR;
  public int tUS;
  
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
      paramVarArgs.gB(3, this.tUM);
      paramVarArgs.d(4, 8, this.tUN);
      paramVarArgs.gB(5, this.tUO);
      paramVarArgs.d(6, 8, this.tUP);
      paramVarArgs.Y(7, this.sSU);
      paramVarArgs.gB(8, this.tAN);
      paramVarArgs.gB(9, this.tUQ);
      paramVarArgs.d(10, 8, this.tTx);
      paramVarArgs.gB(11, this.tUR);
      paramVarArgs.gB(12, this.tUS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1008;
      }
    }
    label1008:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.gy(3, this.tUM) + d.a.a.a.c(4, 8, this.tUN) + d.a.a.a.gy(5, this.tUO) + d.a.a.a.c(6, 8, this.tUP) + d.a.a.a.X(7, this.sSU) + d.a.a.a.gy(8, this.tAN) + d.a.a.a.gy(9, this.tUQ) + d.a.a.a.c(10, 8, this.tTx) + d.a.a.a.gy(11, this.tUR) + d.a.a.a.gy(12, this.tUS);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tUN.clear();
        this.tUP.clear();
        this.tTx.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        cfo localcfo = (cfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        int i;
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
            localcfo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcfo.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcfo.tUM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcfo.tUN.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localcfo.tUO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcfo.tUP.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          localcfo.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 8: 
          localcfo.tAN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcfo.tUQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcfo.tTx.add(localObject1);
            paramInt += 1;
          }
        case 11: 
          localcfo.tUR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcfo.tUS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfo
 * JD-Core Version:    0.7.0.1
 */