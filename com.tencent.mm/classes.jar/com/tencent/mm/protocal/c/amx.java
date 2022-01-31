package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class amx
  extends blm
{
  public String hPY;
  public int pyo;
  public bmk sZN;
  public bmk syq;
  public String tiS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syq == null) {
        throw new b("Not all required fields were included: A2Key");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.syq != null)
      {
        paramVarArgs.gD(2, this.syq.btq());
        this.syq.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      paramVarArgs.gB(4, this.pyo);
      if (this.tiS != null) {
        paramVarArgs.d(5, this.tiS);
      }
      if (this.sZN != null)
      {
        paramVarArgs.gD(6, this.sZN.btq());
        this.sZN.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label752;
      }
    }
    label752:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syq != null) {
        paramInt = i + d.a.a.a.gA(2, this.syq.btq());
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hPY);
      }
      i += d.a.a.a.gy(4, this.pyo);
      paramInt = i;
      if (this.tiS != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tiS);
      }
      i = paramInt;
      if (this.sZN != null) {
        i = paramInt + d.a.a.a.gA(6, this.sZN.btq());
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
        if (this.syq != null) {
          break;
        }
        throw new b("Not all required fields were included: A2Key");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        amx localamx = (amx)paramVarArgs[1];
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
            localamx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localamx.syq = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localamx.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localamx.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localamx.tiS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localamx.sZN = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.amx
 * JD-Core Version:    0.7.0.1
 */