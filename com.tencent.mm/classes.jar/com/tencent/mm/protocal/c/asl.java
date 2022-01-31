package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class asl
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String lRE;
  public String lRF;
  public int qho;
  public String title;
  public boolean tol;
  public bjy tom;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.qho);
      paramVarArgs.aA(2, this.tol);
      if (this.bQZ != null) {
        paramVarArgs.d(3, this.bQZ);
      }
      if (this.lRE != null) {
        paramVarArgs.d(4, this.lRE);
      }
      if (this.lRF != null) {
        paramVarArgs.d(5, this.lRF);
      }
      if (this.tom != null)
      {
        paramVarArgs.gD(6, this.tom.btq());
        this.tom.a(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
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
      i = d.a.a.a.gy(1, this.qho) + 0 + (d.a.a.b.b.a.dQ(2) + 1);
      paramInt = i;
      if (this.bQZ != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bQZ);
      }
      i = paramInt;
      if (this.lRE != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lRE);
      }
      paramInt = i;
      if (this.lRF != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.lRF);
      }
      i = paramInt;
      if (this.tom != null) {
        i = paramInt + d.a.a.a.gA(6, this.tom.btq());
      }
      paramInt = i;
    } while (this.title == null);
    return i + d.a.a.b.b.a.e(7, this.title);
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
      asl localasl = (asl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localasl.qho = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localasl.tol = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      case 3: 
        localasl.bQZ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localasl.lRE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localasl.lRF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bjy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localasl.tom = ((bjy)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localasl.title = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.asl
 * JD-Core Version:    0.7.0.1
 */