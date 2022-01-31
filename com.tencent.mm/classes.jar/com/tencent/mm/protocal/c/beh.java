package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class beh
  extends blm
{
  public int tlp;
  public int tlq;
  public bmk tlr;
  public bmk tzn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tlr == null) {
        throw new b("Not all required fields were included: ReqText");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tlp);
      paramVarArgs.gB(3, this.tlq);
      if (this.tlr != null)
      {
        paramVarArgs.gD(4, this.tlr.btq());
        this.tlr.a(paramVarArgs);
      }
      if (this.tzn != null)
      {
        paramVarArgs.gD(5, this.tzn.btq());
        this.tzn.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label677;
      }
    }
    label677:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tlp) + d.a.a.a.gy(3, this.tlq);
      paramInt = i;
      if (this.tlr != null) {
        paramInt = i + d.a.a.a.gA(4, this.tlr.btq());
      }
      i = paramInt;
      if (this.tzn != null) {
        i = paramInt + d.a.a.a.gA(5, this.tzn.btq());
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
        if (this.tlr != null) {
          break;
        }
        throw new b("Not all required fields were included: ReqText");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        beh localbeh = (beh)paramVarArgs[1];
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
            localbeh.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbeh.tlp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbeh.tlq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
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
            localbeh.tlr = ((bmk)localObject1);
            paramInt += 1;
          }
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
          localbeh.tzn = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.beh
 * JD-Core Version:    0.7.0.1
 */