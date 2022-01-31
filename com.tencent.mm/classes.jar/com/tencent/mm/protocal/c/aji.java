package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aji
  extends blm
{
  public int euM;
  public bmk tfU;
  public int tfV;
  public int tfW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tfU == null) {
        throw new b("Not all required fields were included: Url");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.euM);
      if (this.tfU != null)
      {
        paramVarArgs.gD(3, this.tfU.btq());
        this.tfU.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.tfV);
      paramVarArgs.gB(5, this.tfW);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label567;
      }
    }
    label567:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.euM);
      paramInt = i;
      if (this.tfU != null) {
        paramInt = i + d.a.a.a.gA(3, this.tfU.btq());
      }
      return paramInt + d.a.a.a.gy(4, this.tfV) + d.a.a.a.gy(5, this.tfW);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tfU != null) {
          break;
        }
        throw new b("Not all required fields were included: Url");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aji localaji = (aji)paramVarArgs[1];
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
            localaji.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaji.euM = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localaji.tfU = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localaji.tfV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaji.tfW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aji
 * JD-Core Version:    0.7.0.1
 */