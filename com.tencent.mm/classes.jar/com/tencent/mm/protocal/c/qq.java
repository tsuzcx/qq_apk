package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class qq
  extends com.tencent.mm.bv.a
{
  public int sOr;
  public bmk sOs;
  public int sOt;
  public bmk sOu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sOs == null) {
        throw new b("Not all required fields were included: OperationInfo");
      }
      paramVarArgs.gB(1, this.sOr);
      if (this.sOs != null)
      {
        paramVarArgs.gD(2, this.sOs.btq());
        this.sOs.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.sOt);
      if (this.sOu != null)
      {
        paramVarArgs.gD(4, this.sOu.btq());
        this.sOu.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.sOr) + 0;
      paramInt = i;
      if (this.sOs != null) {
        paramInt = i + d.a.a.a.gA(2, this.sOs.btq());
      }
      i = paramInt + d.a.a.a.gy(3, this.sOt);
      paramInt = i;
    } while (this.sOu == null);
    return i + d.a.a.a.gA(4, this.sOu.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sOs == null) {
        throw new b("Not all required fields were included: OperationInfo");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      qq localqq = (qq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localqq.sOr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localqq.sOs = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localqq.sOt = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bmk();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localqq.sOu = ((bmk)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qq
 * JD-Core Version:    0.7.0.1
 */