package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class dz
  extends com.tencent.mm.bv.a
{
  public String euK;
  public int ssq;
  public int sxB;
  public int sxC;
  public ee sxD;
  public dy sxE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      paramVarArgs.gB(1, this.ssq);
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      paramVarArgs.gB(3, this.sxB);
      paramVarArgs.gB(4, this.sxC);
      if (this.sxD != null)
      {
        paramVarArgs.gD(5, this.sxD.btq());
        this.sxD.a(paramVarArgs);
      }
      if (this.sxE != null)
      {
        paramVarArgs.gD(6, this.sxE.btq());
        this.sxE.a(paramVarArgs);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.ssq) + 0;
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt + d.a.a.a.gy(3, this.sxB) + d.a.a.a.gy(4, this.sxC);
      paramInt = i;
      if (this.sxD != null) {
        paramInt = i + d.a.a.a.gA(5, this.sxD.btq());
      }
      i = paramInt;
    } while (this.sxE == null);
    return paramInt + d.a.a.a.gA(6, this.sxE.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      dz localdz = (dz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localdz.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localdz.euK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localdz.sxB = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localdz.sxC = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ee();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ee)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localdz.sxD = ((ee)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dy();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localdz.sxE = ((dy)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dz
 * JD-Core Version:    0.7.0.1
 */