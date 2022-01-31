package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class nh
  extends bly
{
  public String iHr;
  public String sKW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sKW == null) {
        throw new b("Not all required fields were included: retcode");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sKW != null) {
        paramVarArgs.d(2, this.sKW);
      }
      if (this.iHr != null) {
        paramVarArgs.d(3, this.iHr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label451;
      }
    }
    label451:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sKW != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sKW);
      }
      i = paramInt;
      if (this.iHr != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iHr);
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
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.sKW != null) {
          break;
        }
        throw new b("Not all required fields were included: retcode");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        nh localnh = (nh)paramVarArgs[1];
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
            localnh.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localnh.sKW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localnh.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nh
 * JD-Core Version:    0.7.0.1
 */