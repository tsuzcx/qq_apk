package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ayx
  extends blm
{
  public String hPY;
  public String jxi;
  public bmk tuH;
  public bmk tuI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tuH == null) {
        throw new b("Not all required fields were included: CurrentSynckey");
      }
      if (this.tuI == null) {
        throw new b("Not all required fields were included: MaxSynckey");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      if (this.tuH != null)
      {
        paramVarArgs.gD(3, this.tuH.btq());
        this.tuH.a(paramVarArgs);
      }
      if (this.tuI != null)
      {
        paramVarArgs.gD(4, this.tuI.btq());
        this.tuI.a(paramVarArgs);
      }
      if (this.jxi != null) {
        paramVarArgs.d(5, this.jxi);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label745;
      }
    }
    label745:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.tuH != null) {
        i = paramInt + d.a.a.a.gA(3, this.tuH.btq());
      }
      paramInt = i;
      if (this.tuI != null) {
        paramInt = i + d.a.a.a.gA(4, this.tuI.btq());
      }
      i = paramInt;
      if (this.jxi != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.jxi);
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
        if (this.tuH == null) {
          throw new b("Not all required fields were included: CurrentSynckey");
        }
        if (this.tuI != null) {
          break;
        }
        throw new b("Not all required fields were included: MaxSynckey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ayx localayx = (ayx)paramVarArgs[1];
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
            localayx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localayx.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localayx.tuH = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localayx.tuI = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        localayx.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayx
 * JD-Core Version:    0.7.0.1
 */