package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ahr
  extends bly
{
  public int sHi;
  public String sHj;
  public String tfg;
  public String tfh;
  
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
      paramVarArgs.gB(2, this.sHi);
      if (this.sHj != null) {
        paramVarArgs.d(3, this.sHj);
      }
      if (this.tfg != null) {
        paramVarArgs.d(4, this.tfg);
      }
      if (this.tfh != null) {
        paramVarArgs.d(5, this.tfh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label509;
      }
    }
    label509:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sHi);
      paramInt = i;
      if (this.sHj != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sHj);
      }
      i = paramInt;
      if (this.tfg != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tfg);
      }
      paramInt = i;
      if (this.tfh != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tfh);
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
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ahr localahr = (ahr)paramVarArgs[1];
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
            localahr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localahr.sHi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localahr.sHj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localahr.tfg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localahr.tfh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ahr
 * JD-Core Version:    0.7.0.1
 */