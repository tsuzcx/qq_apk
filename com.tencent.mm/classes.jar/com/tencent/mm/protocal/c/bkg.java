package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bkg
  extends blm
{
  public int hQP;
  public int tDX;
  public cdt tDY;
  public int tDZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tDY == null) {
        throw new b("Not all required fields were included: PieceData");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.hQP);
      paramVarArgs.gB(3, this.tDX);
      if (this.tDY != null)
      {
        paramVarArgs.gD(4, this.tDY.btq());
        this.tDY.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tDZ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label567;
      }
    }
    label567:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQP) + d.a.a.a.gy(3, this.tDX);
      paramInt = i;
      if (this.tDY != null) {
        paramInt = i + d.a.a.a.gA(4, this.tDY.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.tDZ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tDY != null) {
          break;
        }
        throw new b("Not all required fields were included: PieceData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bkg localbkg = (bkg)paramVarArgs[1];
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
            localbkg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbkg.hQP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbkg.tDX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbkg.tDY = ((cdt)localObject1);
            paramInt += 1;
          }
        }
        localbkg.tDZ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bkg
 * JD-Core Version:    0.7.0.1
 */