package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cex
  extends com.tencent.mm.bv.a
{
  public String kWn;
  public int sOA;
  public bmk sOB;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sOB == null) {
        throw new b("Not all required fields were included: CmdBuf");
      }
      paramVarArgs.gB(1, this.sOA);
      if (this.sOB != null)
      {
        paramVarArgs.gD(2, this.sOB.btq());
        this.sOB.a(paramVarArgs);
      }
      if (this.kWn != null) {
        paramVarArgs.d(3, this.kWn);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sOA) + 0;
      paramInt = i;
      if (this.sOB != null) {
        paramInt = i + d.a.a.a.gA(2, this.sOB.btq());
      }
      i = paramInt;
    } while (this.kWn == null);
    return paramInt + d.a.a.b.b.a.e(3, this.kWn);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sOB == null) {
        throw new b("Not all required fields were included: CmdBuf");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      cex localcex = (cex)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcex.sOA = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localcex.sOB = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localcex.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cex
 * JD-Core Version:    0.7.0.1
 */