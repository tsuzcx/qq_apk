package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cks
  extends bly
{
  public int sDT;
  public String sEb;
  public bjl tXY;
  public bjj tXZ;
  public int tpP;
  
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
      paramVarArgs.gB(2, this.tpP);
      paramVarArgs.gB(3, this.sDT);
      if (this.sEb != null) {
        paramVarArgs.d(4, this.sEb);
      }
      if (this.tXY != null)
      {
        paramVarArgs.gD(5, this.tXY.btq());
        this.tXY.a(paramVarArgs);
      }
      if (this.tXZ != null)
      {
        paramVarArgs.gD(6, this.tXZ.btq());
        this.tXZ.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tpP) + d.a.a.a.gy(3, this.sDT);
      paramInt = i;
      if (this.sEb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sEb);
      }
      i = paramInt;
      if (this.tXY != null) {
        i = paramInt + d.a.a.a.gA(5, this.tXY.btq());
      }
      paramInt = i;
      if (this.tXZ != null) {
        paramInt = i + d.a.a.a.gA(6, this.tXZ.btq());
      }
      return paramInt;
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
        cks localcks = (cks)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcks.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcks.tpP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcks.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcks.sEb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcks.tXY = ((bjl)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjj();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localcks.tXZ = ((bjj)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cks
 * JD-Core Version:    0.7.0.1
 */