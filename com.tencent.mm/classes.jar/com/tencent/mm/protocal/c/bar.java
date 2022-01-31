package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bar
  extends blm
{
  public int kSW;
  public String twD;
  public ro twE;
  public ro twF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.twE == null) {
        throw new b("Not all required fields were included: BigContentInfo");
      }
      if (this.twF == null) {
        throw new b("Not all required fields were included: SmallContentInfo");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.twD != null) {
        paramVarArgs.d(2, this.twD);
      }
      if (this.twE != null)
      {
        paramVarArgs.gD(3, this.twE.btq());
        this.twE.a(paramVarArgs);
      }
      if (this.twF != null)
      {
        paramVarArgs.gD(4, this.twF.btq());
        this.twF.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.kSW);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label725;
      }
    }
    label725:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.twD != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.twD);
      }
      i = paramInt;
      if (this.twE != null) {
        i = paramInt + d.a.a.a.gA(3, this.twE.btq());
      }
      paramInt = i;
      if (this.twF != null) {
        paramInt = i + d.a.a.a.gA(4, this.twF.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.kSW);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.twE == null) {
          throw new b("Not all required fields were included: BigContentInfo");
        }
        if (this.twF != null) {
          break;
        }
        throw new b("Not all required fields were included: SmallContentInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bar localbar = (bar)paramVarArgs[1];
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
            localbar.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbar.twD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ro();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ro)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbar.twE = ((ro)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ro();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ro)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbar.twF = ((ro)localObject1);
            paramInt += 1;
          }
        }
        localbar.kSW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bar
 * JD-Core Version:    0.7.0.1
 */