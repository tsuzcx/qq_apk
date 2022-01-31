package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aim
  extends blm
{
  public String kWx;
  public String tfC;
  public int tfD;
  public LinkedList<bml> tfE = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tfC != null) {
        paramVarArgs.d(2, this.tfC);
      }
      paramVarArgs.gB(3, this.tfD);
      paramVarArgs.d(4, 8, this.tfE);
      if (this.kWx != null) {
        paramVarArgs.d(5, this.kWx);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label551;
      }
    }
    label551:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tfC != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tfC);
      }
      i = i + d.a.a.a.gy(3, this.tfD) + d.a.a.a.c(4, 8, this.tfE);
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kWx);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tfE.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aim localaim = (aim)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaim.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaim.tfC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaim.tfD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaim.tfE.add(localObject1);
            paramInt += 1;
          }
        }
        localaim.kWx = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aim
 * JD-Core Version:    0.7.0.1
 */