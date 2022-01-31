package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class oq
  extends bly
{
  public String kWm;
  public String sMf;
  public String sMg;
  public String sMh;
  
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
      if (this.sMf != null) {
        paramVarArgs.d(2, this.sMf);
      }
      if (this.kWm != null) {
        paramVarArgs.d(3, this.kWm);
      }
      if (this.sMg != null) {
        paramVarArgs.d(4, this.sMg);
      }
      if (this.sMh != null) {
        paramVarArgs.d(5, this.sMh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label525;
      }
    }
    label525:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sMf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sMf);
      }
      i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWm);
      }
      paramInt = i;
      if (this.sMg != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sMg);
      }
      i = paramInt;
      if (this.sMh != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sMh);
      }
      return i;
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
        oq localoq = (oq)paramVarArgs[1];
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
            localoq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localoq.sMf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localoq.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localoq.sMg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localoq.sMh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.oq
 * JD-Core Version:    0.7.0.1
 */