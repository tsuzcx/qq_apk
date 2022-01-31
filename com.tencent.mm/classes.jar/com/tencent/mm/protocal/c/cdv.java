package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cdv
  extends com.tencent.mm.bv.a
{
  public int euw;
  public String sNM;
  public bmk tQe;
  public int tSw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tQe == null) {
        throw new b("Not all required fields were included: Text");
      }
      if (this.tQe != null)
      {
        paramVarArgs.gD(1, this.tQe.btq());
        this.tQe.a(paramVarArgs);
      }
      if (this.sNM != null) {
        paramVarArgs.d(2, this.sNM);
      }
      paramVarArgs.gB(3, this.euw);
      paramVarArgs.gB(4, this.tSw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tQe == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = d.a.a.a.gA(1, this.tQe.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sNM != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sNM);
      }
      return i + d.a.a.a.gy(3, this.euw) + d.a.a.a.gy(4, this.tSw);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tQe != null) {
          break;
        }
        throw new b("Not all required fields were included: Text");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cdv localcdv = (cdv)paramVarArgs[1];
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
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcdv.tQe = ((bmk)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcdv.sNM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcdv.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcdv.tSw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdv
 * JD-Core Version:    0.7.0.1
 */