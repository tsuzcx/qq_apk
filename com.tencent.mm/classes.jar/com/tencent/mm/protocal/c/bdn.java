package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bdn
  extends blm
{
  public String auI;
  public int tyC;
  public String tyE;
  public String tyF;
  public String tyG;
  
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
      paramVarArgs.gB(2, this.tyC);
      if (this.auI != null) {
        paramVarArgs.d(3, this.auI);
      }
      if (this.tyE != null) {
        paramVarArgs.d(4, this.tyE);
      }
      if (this.tyF != null) {
        paramVarArgs.d(5, this.tyF);
      }
      if (this.tyG != null) {
        paramVarArgs.d(6, this.tyG);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tyC);
      paramInt = i;
      if (this.auI != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.auI);
      }
      i = paramInt;
      if (this.tyE != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tyE);
      }
      paramInt = i;
      if (this.tyF != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tyF);
      }
      i = paramInt;
      if (this.tyG != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tyG);
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
        bdn localbdn = (bdn)paramVarArgs[1];
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
            localbdn.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbdn.tyC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbdn.auI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbdn.tyE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbdn.tyF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbdn.tyG = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdn
 * JD-Core Version:    0.7.0.1
 */