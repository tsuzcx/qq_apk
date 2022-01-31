package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bgi
  extends blm
{
  public int sST;
  public long sSU;
  public long tAB;
  public long tAE;
  public String tAY;
  public int tAZ;
  public int tBa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tAY == null) {
        throw new b("Not all required fields were included: FromUsername");
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
      paramVarArgs.Y(5, this.tAB);
      paramVarArgs.gB(6, this.tAZ);
      paramVarArgs.Y(7, this.tAE);
      paramVarArgs.gB(8, this.tBa);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tAY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tAY);
      }
      return i + d.a.a.a.gy(3, this.sST) + d.a.a.a.X(4, this.sSU) + d.a.a.a.X(5, this.tAB) + d.a.a.a.gy(6, this.tAZ) + d.a.a.a.X(7, this.tAE) + d.a.a.a.gy(8, this.tBa);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tAY != null) {
          break;
        }
        throw new b("Not all required fields were included: FromUsername");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bgi localbgi = (bgi)paramVarArgs[1];
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
            localbgi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbgi.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbgi.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbgi.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localbgi.tAB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbgi.tAZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbgi.tAE = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localbgi.tBa = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgi
 * JD-Core Version:    0.7.0.1
 */