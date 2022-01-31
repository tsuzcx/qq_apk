package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cdi
  extends blm
{
  public bmk sBt;
  public int tDX;
  public int tDZ;
  public cdt tSf;
  public String til;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tSf == null) {
        throw new b("Not all required fields were included: Piece");
      }
      if (this.sBt == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tSf != null)
      {
        paramVarArgs.gD(2, this.tSf.btq());
        this.tSf.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tDX);
      paramVarArgs.gB(4, this.tDZ);
      if (this.til != null) {
        paramVarArgs.d(5, this.til);
      }
      if (this.sBt != null)
      {
        paramVarArgs.gD(6, this.sBt.btq());
        this.sBt.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label768;
      }
    }
    label768:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tSf != null) {
        i = paramInt + d.a.a.a.gA(2, this.tSf.btq());
      }
      i = i + d.a.a.a.gy(3, this.tDX) + d.a.a.a.gy(4, this.tDZ);
      paramInt = i;
      if (this.til != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.til);
      }
      i = paramInt;
      if (this.sBt != null) {
        i = paramInt + d.a.a.a.gA(6, this.sBt.btq());
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
        if (this.tSf == null) {
          throw new b("Not all required fields were included: Piece");
        }
        if (this.sBt != null) {
          break;
        }
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cdi localcdi = (cdi)paramVarArgs[1];
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
            localcdi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdi.tSf = ((cdt)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcdi.tDX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcdi.tDZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcdi.til = ((d.a.a.a.a)localObject1).xpH.readString();
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
          localcdi.sBt = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdi
 * JD-Core Version:    0.7.0.1
 */