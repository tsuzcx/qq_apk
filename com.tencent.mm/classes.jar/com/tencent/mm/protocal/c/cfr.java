package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cfr
  extends blm
{
  public int sST;
  public long sSU;
  public String tAY;
  public long tSJ;
  public cfx tTF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tTF == null) {
        throw new b("Not all required fields were included: ReportData");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tAY != null) {
        paramVarArgs.d(2, this.tAY);
      }
      paramVarArgs.gB(3, this.sST);
      paramVarArgs.Y(4, this.sSU);
      if (this.tTF != null)
      {
        paramVarArgs.gD(5, this.tTF.btq());
        this.tTF.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.tSJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tAY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tAY);
      }
      i = i + d.a.a.a.gy(3, this.sST) + d.a.a.a.X(4, this.sSU);
      paramInt = i;
      if (this.tTF != null) {
        paramInt = i + d.a.a.a.gA(5, this.tTF.btq());
      }
      return paramInt + d.a.a.a.X(6, this.tSJ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tTF != null) {
          break;
        }
        throw new b("Not all required fields were included: ReportData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cfr localcfr = (cfr)paramVarArgs[1];
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
            localcfr.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcfr.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcfr.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcfr.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfr.tTF = ((cfx)localObject1);
            paramInt += 1;
          }
        }
        localcfr.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfr
 * JD-Core Version:    0.7.0.1
 */