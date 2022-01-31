package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bfv
  extends blm
{
  public String tAF;
  public String tAG;
  public String tAH;
  public String tAI;
  public String tAJ;
  public int tAK;
  
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
      if (this.tAF != null) {
        paramVarArgs.d(2, this.tAF);
      }
      if (this.tAG != null) {
        paramVarArgs.d(3, this.tAG);
      }
      if (this.tAH != null) {
        paramVarArgs.d(4, this.tAH);
      }
      if (this.tAI != null) {
        paramVarArgs.d(5, this.tAI);
      }
      if (this.tAJ != null) {
        paramVarArgs.d(6, this.tAJ);
      }
      paramVarArgs.gB(7, this.tAK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label587;
      }
    }
    label587:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tAF != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tAF);
      }
      i = paramInt;
      if (this.tAG != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tAG);
      }
      paramInt = i;
      if (this.tAH != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tAH);
      }
      i = paramInt;
      if (this.tAI != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tAI);
      }
      paramInt = i;
      if (this.tAJ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tAJ);
      }
      return paramInt + d.a.a.a.gy(7, this.tAK);
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
        bfv localbfv = (bfv)paramVarArgs[1];
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
            localbfv.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbfv.tAF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbfv.tAG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbfv.tAH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbfv.tAI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbfv.tAJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbfv.tAK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfv
 * JD-Core Version:    0.7.0.1
 */