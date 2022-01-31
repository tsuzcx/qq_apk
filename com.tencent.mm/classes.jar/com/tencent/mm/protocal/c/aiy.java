package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aiy
  extends blm
{
  public String bHI;
  public String bJY;
  public String koB;
  public String koC;
  public String koD;
  public String sst;
  
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
      if (this.bHI != null) {
        paramVarArgs.d(2, this.bHI);
      }
      if (this.koB != null) {
        paramVarArgs.d(3, this.koB);
      }
      if (this.koC != null) {
        paramVarArgs.d(4, this.koC);
      }
      if (this.koD != null) {
        paramVarArgs.d(5, this.koD);
      }
      if (this.bJY != null) {
        paramVarArgs.d(6, this.bJY);
      }
      if (this.sst != null) {
        paramVarArgs.d(7, this.sst);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label607;
      }
    }
    label607:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bHI != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bHI);
      }
      i = paramInt;
      if (this.koB != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.koB);
      }
      paramInt = i;
      if (this.koC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.koC);
      }
      i = paramInt;
      if (this.koD != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.koD);
      }
      paramInt = i;
      if (this.bJY != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.bJY);
      }
      i = paramInt;
      if (this.sst != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sst);
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
        aiy localaiy = (aiy)paramVarArgs[1];
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
            localaiy.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaiy.bHI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaiy.koB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaiy.koC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaiy.koD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaiy.bJY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaiy.sst = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aiy
 * JD-Core Version:    0.7.0.1
 */