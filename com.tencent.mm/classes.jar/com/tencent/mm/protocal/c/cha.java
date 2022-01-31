package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cha
  extends com.tencent.mm.bv.a
{
  public cgw tVV;
  public cgm tVW;
  public String tVX;
  public String tVY;
  public String tVZ;
  public int tWa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tVV != null)
      {
        paramVarArgs.gD(1, this.tVV.btq());
        this.tVV.a(paramVarArgs);
      }
      if (this.tVW != null)
      {
        paramVarArgs.gD(2, this.tVW.btq());
        this.tVW.a(paramVarArgs);
      }
      if (this.tVX != null) {
        paramVarArgs.d(3, this.tVX);
      }
      if (this.tVY != null) {
        paramVarArgs.d(4, this.tVY);
      }
      if (this.tVZ != null) {
        paramVarArgs.d(5, this.tVZ);
      }
      paramVarArgs.gB(6, this.tWa);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVV == null) {
        break label622;
      }
    }
    label622:
    for (int i = d.a.a.a.gA(1, this.tVV.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tVW != null) {
        paramInt = i + d.a.a.a.gA(2, this.tVW.btq());
      }
      i = paramInt;
      if (this.tVX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tVX);
      }
      paramInt = i;
      if (this.tVY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tVY);
      }
      i = paramInt;
      if (this.tVZ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tVZ);
      }
      return i + d.a.a.a.gy(6, this.tWa);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cha localcha = (cha)paramVarArgs[1];
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
            localObject1 = new cgw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcha.tVV = ((cgw)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgm();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcha.tVW = ((cgm)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcha.tVX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localcha.tVY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localcha.tVZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcha.tWa = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cha
 * JD-Core Version:    0.7.0.1
 */