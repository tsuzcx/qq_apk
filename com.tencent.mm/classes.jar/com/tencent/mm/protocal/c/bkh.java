package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bkh
  extends bly
{
  public int tDX;
  public int tEa;
  public int tEb;
  public cdt tEc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tEc == null) {
        throw new b("Not all required fields were included: NextPiece");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tEa);
      paramVarArgs.gB(3, this.tEb);
      if (this.tEc != null)
      {
        paramVarArgs.gD(4, this.tEc.btq());
        this.tEc.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tDX);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label599;
      }
    }
    label599:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tEa) + d.a.a.a.gy(3, this.tEb);
      paramInt = i;
      if (this.tEc != null) {
        paramInt = i + d.a.a.a.gA(4, this.tEc.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.tDX);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.tEc != null) {
          break;
        }
        throw new b("Not all required fields were included: NextPiece");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bkh localbkh = (bkh)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbkh.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbkh.tEa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbkh.tEb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbkh.tEc = ((cdt)localObject1);
            paramInt += 1;
          }
        }
        localbkh.tDX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bkh
 * JD-Core Version:    0.7.0.1
 */