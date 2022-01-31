package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bgg
  extends blm
{
  public int hQq;
  public String kWn;
  public int sST;
  public long sSU;
  public long tAB;
  public long tAE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kWn == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.kWn != null) {
        paramVarArgs.d(2, this.kWn);
      }
      paramVarArgs.gB(3, this.sST);
      paramVarArgs.Y(4, this.sSU);
      paramVarArgs.Y(5, this.tAB);
      paramVarArgs.Y(6, this.tAE);
      paramVarArgs.gB(7, this.hQq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label551;
      }
    }
    label551:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWn != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kWn);
      }
      return i + d.a.a.a.gy(3, this.sST) + d.a.a.a.X(4, this.sSU) + d.a.a.a.X(5, this.tAB) + d.a.a.a.X(6, this.tAE) + d.a.a.a.gy(7, this.hQq);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kWn != null) {
          break;
        }
        throw new b("Not all required fields were included: FromUserName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bgg localbgg = (bgg)paramVarArgs[1];
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
            localbgg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbgg.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbgg.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbgg.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localbgg.tAB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbgg.tAE = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localbgg.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgg
 * JD-Core Version:    0.7.0.1
 */