package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class cfv
  extends blm
{
  public int sNU;
  public int sST;
  public int tLL;
  public int tLM;
  public int tLN;
  public int tLO;
  public int tLP;
  public LinkedList<Integer> tLQ = new LinkedList();
  public int tLR;
  public int tLS;
  public LinkedList<Integer> tLT = new LinkedList();
  public int tLU;
  public int tLV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.sST);
      paramVarArgs.gB(3, this.tLL);
      paramVarArgs.gB(4, this.sNU);
      paramVarArgs.gB(5, this.tLM);
      paramVarArgs.gB(6, this.tLN);
      paramVarArgs.gB(7, this.tLO);
      paramVarArgs.gB(8, this.tLP);
      paramVarArgs.d(9, this.tLQ);
      paramVarArgs.gB(10, this.tLR);
      paramVarArgs.gB(11, this.tLS);
      paramVarArgs.d(12, this.tLT);
      paramVarArgs.gB(13, this.tLU);
      paramVarArgs.gB(14, this.tLV);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.gy(3, this.tLL) + d.a.a.a.gy(4, this.sNU) + d.a.a.a.gy(5, this.tLM) + d.a.a.a.gy(6, this.tLN) + d.a.a.a.gy(7, this.tLO) + d.a.a.a.gy(8, this.tLP) + d.a.a.a.c(9, this.tLQ) + d.a.a.a.gy(10, this.tLR) + d.a.a.a.gy(11, this.tLS) + d.a.a.a.c(12, this.tLT) + d.a.a.a.gy(13, this.tLU) + d.a.a.a.gy(14, this.tLV);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tLQ.clear();
        this.tLT.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cfv localcfv = (cfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfv.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcfv.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcfv.tLL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcfv.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcfv.tLM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcfv.tLN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcfv.tLO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcfv.tLP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcfv.tLQ = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
          return 0;
        case 10: 
          localcfv.tLR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localcfv.tLS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localcfv.tLT = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
          return 0;
        case 13: 
          localcfv.tLU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcfv.tLV = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfv
 * JD-Core Version:    0.7.0.1
 */