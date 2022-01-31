package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class axu
  extends blm
{
  public String bOL;
  public int bZe;
  public String ttX;
  public int ttY;
  public int ttZ;
  public int tua;
  
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
      if (this.bOL != null) {
        paramVarArgs.d(2, this.bOL);
      }
      if (this.ttX != null) {
        paramVarArgs.d(3, this.ttX);
      }
      paramVarArgs.gB(4, this.ttY);
      paramVarArgs.gB(5, this.ttZ);
      paramVarArgs.gB(6, this.tua);
      paramVarArgs.gB(7, this.bZe);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label535;
      }
    }
    label535:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bOL);
      }
      i = paramInt;
      if (this.ttX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ttX);
      }
      return i + d.a.a.a.gy(4, this.ttY) + d.a.a.a.gy(5, this.ttZ) + d.a.a.a.gy(6, this.tua) + d.a.a.a.gy(7, this.bZe);
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
        axu localaxu = (axu)paramVarArgs[1];
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
            localaxu.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaxu.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaxu.ttX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaxu.ttY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localaxu.ttZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localaxu.tua = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaxu.bZe = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axu
 * JD-Core Version:    0.7.0.1
 */