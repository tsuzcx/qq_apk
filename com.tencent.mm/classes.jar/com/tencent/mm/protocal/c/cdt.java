package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cdt
  extends com.tencent.mm.bv.a
{
  public int ndg;
  public int tSt;
  public int tSu;
  public bmk tSv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tSv == null) {
        throw new b("Not all required fields were included: PieceData");
      }
      paramVarArgs.gB(1, this.ndg);
      paramVarArgs.gB(2, this.tSt);
      paramVarArgs.gB(3, this.tSu);
      if (this.tSv != null)
      {
        paramVarArgs.gD(4, this.tSv.btq());
        this.tSv.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.ndg) + 0 + d.a.a.a.gy(2, this.tSt) + d.a.a.a.gy(3, this.tSu);
      paramInt = i;
    } while (this.tSv == null);
    return i + d.a.a.a.gA(4, this.tSv.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tSv == null) {
        throw new b("Not all required fields were included: PieceData");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      cdt localcdt = (cdt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcdt.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localcdt.tSt = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localcdt.tSu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bmk();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localcdt.tSv = ((bmk)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdt
 * JD-Core Version:    0.7.0.1
 */