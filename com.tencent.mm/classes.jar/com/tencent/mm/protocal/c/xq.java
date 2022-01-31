package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class xq
  extends bly
{
  public int dne;
  public String sRr;
  public String svm;
  public LinkedList<xr> svo = new LinkedList();
  
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
      if (this.sRr != null) {
        paramVarArgs.d(2, this.sRr);
      }
      paramVarArgs.gB(3, this.dne);
      paramVarArgs.d(4, 8, this.svo);
      if (this.svm != null) {
        paramVarArgs.d(5, this.svm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label587;
      }
    }
    label587:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sRr != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sRr);
      }
      i = i + d.a.a.a.gy(3, this.dne) + d.a.a.a.c(4, 8, this.svo);
      paramInt = i;
      if (this.svm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.svm);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.svo.clear();
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
        xq localxq = (xq)paramVarArgs[1];
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
            localxq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localxq.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localxq.dne = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localxq.svo.add(localObject1);
            paramInt += 1;
          }
        }
        localxq.svm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xq
 * JD-Core Version:    0.7.0.1
 */