package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bge
  extends blm
{
  public int sST;
  public long tAE;
  public bml tAU;
  public bml tAV;
  public bml tAW;
  public int tAX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tAU == null) {
        throw new b("Not all required fields were included: ClientReport");
      }
      if (this.tAV == null) {
        throw new b("Not all required fields were included: ChannelReport");
      }
      if (this.tAW == null) {
        throw new b("Not all required fields were included: EngineReport");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tAU != null)
      {
        paramVarArgs.gD(2, this.tAU.btq());
        this.tAU.a(paramVarArgs);
      }
      if (this.tAV != null)
      {
        paramVarArgs.gD(3, this.tAV.btq());
        this.tAV.a(paramVarArgs);
      }
      if (this.tAW != null)
      {
        paramVarArgs.gD(4, this.tAW.btq());
        this.tAW.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.sST);
      paramVarArgs.Y(6, this.tAE);
      paramVarArgs.gB(7, this.tAX);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label929;
      }
    }
    label929:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tAU != null) {
        paramInt = i + d.a.a.a.gA(2, this.tAU.btq());
      }
      i = paramInt;
      if (this.tAV != null) {
        i = paramInt + d.a.a.a.gA(3, this.tAV.btq());
      }
      paramInt = i;
      if (this.tAW != null) {
        paramInt = i + d.a.a.a.gA(4, this.tAW.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.sST) + d.a.a.a.X(6, this.tAE) + d.a.a.a.gy(7, this.tAX);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tAU == null) {
          throw new b("Not all required fields were included: ClientReport");
        }
        if (this.tAV == null) {
          throw new b("Not all required fields were included: ChannelReport");
        }
        if (this.tAW != null) {
          break;
        }
        throw new b("Not all required fields were included: EngineReport");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bge localbge = (bge)paramVarArgs[1];
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
            localbge.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbge.tAU = ((bml)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbge.tAV = ((bml)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbge.tAW = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbge.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbge.tAE = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localbge.tAX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bge
 * JD-Core Version:    0.7.0.1
 */