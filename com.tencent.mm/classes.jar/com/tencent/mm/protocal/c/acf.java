package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class acf
  extends bly
{
  public int result;
  public aqb tbg;
  public String tbh;
  public apw tbi;
  
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
      if (this.tbg != null)
      {
        paramVarArgs.gD(2, this.tbg.btq());
        this.tbg.a(paramVarArgs);
      }
      if (this.tbh != null) {
        paramVarArgs.d(3, this.tbh);
      }
      if (this.tbi != null)
      {
        paramVarArgs.gD(4, this.tbi.btq());
        this.tbi.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.result);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label693;
      }
    }
    label693:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tbg != null) {
        paramInt = i + d.a.a.a.gA(2, this.tbg.btq());
      }
      i = paramInt;
      if (this.tbh != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tbh);
      }
      paramInt = i;
      if (this.tbi != null) {
        paramInt = i + d.a.a.a.gA(4, this.tbi.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.result);
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
        acf localacf = (acf)paramVarArgs[1];
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
            localacf.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localacf.tbg = ((aqb)localObject1);
            paramInt += 1;
          }
        case 3: 
          localacf.tbh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localacf.tbi = ((apw)localObject1);
            paramInt += 1;
          }
        }
        localacf.result = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.acf
 * JD-Core Version:    0.7.0.1
 */