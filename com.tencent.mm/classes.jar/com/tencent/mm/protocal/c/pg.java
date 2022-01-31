package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class pg
  extends bly
{
  public int hQR;
  public int sMV;
  public int sMW;
  public int sMX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.sMV);
      paramVarArgs.gB(4, this.sMW);
      paramVarArgs.gB(5, this.sMX);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label453;
      }
    }
    label453:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.sMV) + d.a.a.a.gy(4, this.sMW) + d.a.a.a.gy(5, this.sMX);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        pg localpg = (pg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localpg.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localpg.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localpg.sMV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localpg.sMW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localpg.sMX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pg
 * JD-Core Version:    0.7.0.1
 */