package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bsk
  extends bly
{
  public String tIU;
  public String tIV;
  public String tIW;
  public int tIX;
  public int tIY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.tIU != null) {
        paramVarArgs.d(2, this.tIU);
      }
      paramVarArgs.gB(3, this.tIX);
      paramVarArgs.gB(4, this.tIY);
      if (this.tIV != null) {
        paramVarArgs.d(5, this.tIV);
      }
      if (this.tIW != null) {
        paramVarArgs.d(6, this.tIW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tIU != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tIU);
      }
      i = i + d.a.a.a.gy(3, this.tIX) + d.a.a.a.gy(4, this.tIY);
      paramInt = i;
      if (this.tIV != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tIV);
      }
      i = paramInt;
      if (this.tIW != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tIW);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bsk localbsk = (bsk)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbsk.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbsk.tIU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbsk.tIX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbsk.tIY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbsk.tIV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbsk.tIW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsk
 * JD-Core Version:    0.7.0.1
 */