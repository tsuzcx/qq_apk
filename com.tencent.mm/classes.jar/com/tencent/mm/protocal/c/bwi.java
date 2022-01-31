package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bwi
  extends blm
{
  public String sRr;
  public String sYA;
  public String sYB;
  public String sYz;
  public String tev;
  
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
      if (this.sYz != null) {
        paramVarArgs.d(2, this.sYz);
      }
      if (this.tev != null) {
        paramVarArgs.d(3, this.tev);
      }
      if (this.sYA != null) {
        paramVarArgs.d(4, this.sYA);
      }
      if (this.sYB != null) {
        paramVarArgs.d(5, this.sYB);
      }
      if (this.sRr != null) {
        paramVarArgs.d(6, this.sRr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label548;
      }
    }
    label548:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sYz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sYz);
      }
      i = paramInt;
      if (this.tev != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tev);
      }
      paramInt = i;
      if (this.sYA != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sYA);
      }
      i = paramInt;
      if (this.sYB != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sYB);
      }
      paramInt = i;
      if (this.sRr != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sRr);
      }
      return paramInt;
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
        bwi localbwi = (bwi)paramVarArgs[1];
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
            localbwi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbwi.sYz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbwi.tev = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbwi.sYA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbwi.sYB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbwi.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bwi
 * JD-Core Version:    0.7.0.1
 */