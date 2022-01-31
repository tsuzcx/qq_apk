package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class alr
  extends bly
{
  public int syA;
  public String thG;
  public String thH;
  public LinkedList<String> thI = new LinkedList();
  
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
      if (this.thG != null) {
        paramVarArgs.d(2, this.thG);
      }
      paramVarArgs.gB(3, this.syA);
      if (this.thH != null) {
        paramVarArgs.d(4, this.thH);
      }
      paramVarArgs.d(5, 1, this.thI);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label505;
      }
    }
    label505:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thG != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.thG);
      }
      i += d.a.a.a.gy(3, this.syA);
      paramInt = i;
      if (this.thH != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.thH);
      }
      return paramInt + d.a.a.a.c(5, 1, this.thI);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thI.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        alr localalr = (alr)paramVarArgs[1];
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
            localalr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localalr.thG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localalr.syA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localalr.thH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localalr.thI.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.alr
 * JD-Core Version:    0.7.0.1
 */