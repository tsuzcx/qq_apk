package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aiw
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public bmk swr;
  public int tcH;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.swr == null) {
        throw new b("Not all required fields were included: ReqBuf");
      }
      paramVarArgs.gB(1, this.tcH);
      if (this.swr != null)
      {
        paramVarArgs.gD(2, this.swr.btq());
        this.swr.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.pyo);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.tcH) + 0;
      paramInt = i;
      if (this.swr != null) {
        paramInt = i + d.a.a.a.gA(2, this.swr.btq());
      }
      return paramInt + d.a.a.a.gy(3, this.pyo);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.swr == null) {
        throw new b("Not all required fields were included: ReqBuf");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      aiw localaiw = (aiw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaiw.tcH = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaiw.swr = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localaiw.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aiw
 * JD-Core Version:    0.7.0.1
 */