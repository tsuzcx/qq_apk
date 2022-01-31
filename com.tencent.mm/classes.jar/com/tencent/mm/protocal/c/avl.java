package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class avl
  extends bly
{
  public String sEb;
  public int tqW;
  public String tqX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sEb == null) {
        throw new b("Not all required fields were included: Json");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sEb != null) {
        paramVarArgs.d(2, this.sEb);
      }
      paramVarArgs.gB(3, this.tqW);
      if (this.tqX != null) {
        paramVarArgs.d(4, this.tqX);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sEb != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sEb);
      }
      i += d.a.a.a.gy(3, this.tqW);
      paramInt = i;
      if (this.tqX != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tqX);
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
        if (this.sEb != null) {
          break;
        }
        throw new b("Not all required fields were included: Json");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        avl localavl = (avl)paramVarArgs[1];
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
            localavl.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localavl.sEb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localavl.tqW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localavl.tqX = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avl
 * JD-Core Version:    0.7.0.1
 */