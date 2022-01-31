package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bmp
  extends com.tencent.mm.bv.a
{
  public LinkedList<auo> tFS = new LinkedList();
  public boolean tFT;
  public boolean tFU;
  public boolean tFV;
  public boolean tFW;
  public boolean tFX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.tFS);
      paramVarArgs.aA(2, this.tFT);
      paramVarArgs.aA(3, this.tFU);
      paramVarArgs.aA(4, this.tFV);
      paramVarArgs.aA(5, this.tFW);
      paramVarArgs.aA(6, this.tFX);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.c(1, 8, this.tFS) + 0 + (d.a.a.b.b.a.dQ(2) + 1) + (d.a.a.b.b.a.dQ(3) + 1) + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1) + (d.a.a.b.b.a.dQ(6) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tFS.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      bmp localbmp = (bmp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((auo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbmp.tFS.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localbmp.tFT = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      case 3: 
        localbmp.tFU = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      case 4: 
        localbmp.tFV = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      case 5: 
        localbmp.tFW = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      localbmp.tFX = ((d.a.a.a.a)localObject1).cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bmp
 * JD-Core Version:    0.7.0.1
 */