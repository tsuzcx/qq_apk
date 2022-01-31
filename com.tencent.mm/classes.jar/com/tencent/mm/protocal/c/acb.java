package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class acb
  extends bly
{
  public int iHq;
  public String iHr;
  public LinkedList<String> qqx = new LinkedList();
  public String tbb;
  
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
      paramVarArgs.d(2, 1, this.qqx);
      paramVarArgs.gB(3, this.iHq);
      if (this.iHr != null) {
        paramVarArgs.d(4, this.iHr);
      }
      if (this.tbb != null) {
        paramVarArgs.d(5, this.tbb);
      }
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
      int i = paramInt + d.a.a.a.c(2, 1, this.qqx) + d.a.a.a.gy(3, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iHr);
      }
      i = paramInt;
      if (this.tbb != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tbb);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qqx.clear();
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
        acb localacb = (acb)paramVarArgs[1];
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
            localacb.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localacb.qqx.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 3: 
          localacb.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localacb.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localacb.tbb = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.acb
 * JD-Core Version:    0.7.0.1
 */