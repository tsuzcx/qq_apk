package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class kw
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public kp sFU;
  public ko sFV;
  public long sFW;
  public kv sFX;
  public ky sFY;
  public ku sFZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hQR);
      if (this.sFU != null)
      {
        paramVarArgs.gD(2, this.sFU.btq());
        this.sFU.a(paramVarArgs);
      }
      if (this.sFV != null)
      {
        paramVarArgs.gD(3, this.sFV.btq());
        this.sFV.a(paramVarArgs);
      }
      paramVarArgs.Y(4, this.sFW);
      if (this.sFX != null)
      {
        paramVarArgs.gD(5, this.sFX.btq());
        this.sFX.a(paramVarArgs);
      }
      if (this.sFY != null)
      {
        paramVarArgs.gD(6, this.sFY.btq());
        this.sFY.a(paramVarArgs);
      }
      if (this.sFZ != null)
      {
        paramVarArgs.gD(7, this.sFZ.btq());
        this.sFZ.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.hQR) + 0;
      paramInt = i;
      if (this.sFU != null) {
        paramInt = i + d.a.a.a.gA(2, this.sFU.btq());
      }
      i = paramInt;
      if (this.sFV != null) {
        i = paramInt + d.a.a.a.gA(3, this.sFV.btq());
      }
      i += d.a.a.a.X(4, this.sFW);
      paramInt = i;
      if (this.sFX != null) {
        paramInt = i + d.a.a.a.gA(5, this.sFX.btq());
      }
      i = paramInt;
      if (this.sFY != null) {
        i = paramInt + d.a.a.a.gA(6, this.sFY.btq());
      }
      paramInt = i;
    } while (this.sFZ == null);
    return i + d.a.a.a.gA(7, this.sFZ.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      kw localkw = (kw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localkw.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localkw.sFU = ((kp)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ko();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ko)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localkw.sFV = ((ko)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localkw.sFW = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kv();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localkw.sFX = ((kv)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ky();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ky)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localkw.sFY = ((ky)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ku();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ku)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localkw.sFZ = ((ku)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kw
 * JD-Core Version:    0.7.0.1
 */