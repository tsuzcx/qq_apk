package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ud
  extends blm
{
  public int hQR;
  public int sDT;
  public bcr sQU;
  public int sQV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQU == null) {
        throw new b("Not all required fields were included: Package");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sQU != null)
      {
        paramVarArgs.gD(2, this.sQU.btq());
        this.sQU.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.sDT);
      paramVarArgs.gB(4, this.sQV);
      paramVarArgs.gB(5, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label563;
      }
    }
    label563:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sQU != null) {
        i = paramInt + d.a.a.a.gA(2, this.sQU.btq());
      }
      return i + d.a.a.a.gy(3, this.sDT) + d.a.a.a.gy(4, this.sQV) + d.a.a.a.gy(5, this.hQR);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sQU != null) {
          break;
        }
        throw new b("Not all required fields were included: Package");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ud localud = (ud)paramVarArgs[1];
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
            localud.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localud.sQU = ((bcr)localObject1);
            paramInt += 1;
          }
        case 3: 
          localud.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localud.sQV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localud.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ud
 * JD-Core Version:    0.7.0.1
 */