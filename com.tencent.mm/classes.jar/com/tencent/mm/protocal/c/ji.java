package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ji
  extends bly
{
  public int euw;
  public int hQR;
  public int sDQ;
  public int sDU;
  public String sDW;
  public float sDX;
  public float sDY;
  
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
      paramVarArgs.gB(2, this.sDQ);
      paramVarArgs.gB(3, this.hQR);
      if (this.sDW != null) {
        paramVarArgs.d(4, this.sDW);
      }
      paramVarArgs.gB(5, this.euw);
      paramVarArgs.gB(6, this.sDU);
      paramVarArgs.m(7, this.sDX);
      paramVarArgs.m(8, this.sDY);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sDQ) + d.a.a.a.gy(3, this.hQR);
      paramInt = i;
      if (this.sDW != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sDW);
      }
      return paramInt + d.a.a.a.gy(5, this.euw) + d.a.a.a.gy(6, this.sDU) + (d.a.a.b.b.a.dQ(7) + 4) + (d.a.a.b.b.a.dQ(8) + 4);
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
        ji localji = (ji)paramVarArgs[1];
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
            localji.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localji.sDQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localji.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localji.sDW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localji.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localji.sDU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localji.sDX = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        }
        localji.sDY = ((d.a.a.a.a)localObject1).xpH.readFloat();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ji
 * JD-Core Version:    0.7.0.1
 */