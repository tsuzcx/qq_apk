package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class aza
  extends blm
{
  public int sDV;
  public int tuN;
  public b tuO;
  public int tuP;
  public b tuQ;
  public String tuR;
  public String tuS;
  public String tuT;
  
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
      paramVarArgs.gB(2, this.sDV);
      paramVarArgs.gB(3, this.tuN);
      if (this.tuO != null) {
        paramVarArgs.b(4, this.tuO);
      }
      paramVarArgs.gB(5, this.tuP);
      if (this.tuQ != null) {
        paramVarArgs.b(6, this.tuQ);
      }
      if (this.tuR != null) {
        paramVarArgs.d(7, this.tuR);
      }
      if (this.tuS != null) {
        paramVarArgs.d(8, this.tuS);
      }
      if (this.tuT != null) {
        paramVarArgs.d(9, this.tuT);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label663;
      }
    }
    label663:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sDV) + d.a.a.a.gy(3, this.tuN);
      paramInt = i;
      if (this.tuO != null) {
        paramInt = i + d.a.a.a.a(4, this.tuO);
      }
      i = paramInt + d.a.a.a.gy(5, this.tuP);
      paramInt = i;
      if (this.tuQ != null) {
        paramInt = i + d.a.a.a.a(6, this.tuQ);
      }
      i = paramInt;
      if (this.tuR != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tuR);
      }
      paramInt = i;
      if (this.tuS != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tuS);
      }
      i = paramInt;
      if (this.tuT != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tuT);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        aza localaza = (aza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaza.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaza.sDV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localaza.tuN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localaza.tuO = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 5: 
          localaza.tuP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localaza.tuQ = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 7: 
          localaza.tuR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localaza.tuS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaza.tuT = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aza
 * JD-Core Version:    0.7.0.1
 */