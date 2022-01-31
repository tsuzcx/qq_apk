package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class byz
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public bmk sZU;
  public int tPa;
  public String tPb;
  public String tPc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tPa);
      if (this.tPb != null) {
        paramVarArgs.d(2, this.tPb);
      }
      if (this.tPc != null) {
        paramVarArgs.d(3, this.tPc);
      }
      paramVarArgs.gB(4, this.pyo);
      if (this.sZU != null)
      {
        paramVarArgs.gD(5, this.sZU.btq());
        this.sZU.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.tPa) + 0;
      paramInt = i;
      if (this.tPb != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tPb);
      }
      i = paramInt;
      if (this.tPc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tPc);
      }
      i += d.a.a.a.gy(4, this.pyo);
      paramInt = i;
    } while (this.sZU == null);
    return i + d.a.a.a.gA(5, this.sZU.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      byz localbyz = (byz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbyz.tPa = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbyz.tPb = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbyz.tPc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localbyz.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
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
        localbyz.sZU = ((bmk)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byz
 * JD-Core Version:    0.7.0.1
 */