package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class byu
  extends blm
{
  public String sPn;
  public String syI;
  public apo tOS;
  public int tOT;
  
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
      if (this.sPn != null) {
        paramVarArgs.d(2, this.sPn);
      }
      if (this.syI != null) {
        paramVarArgs.d(3, this.syI);
      }
      if (this.tOS != null)
      {
        paramVarArgs.gD(4, this.tOS.btq());
        this.tOS.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tOT);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label567;
      }
    }
    label567:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sPn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sPn);
      }
      i = paramInt;
      if (this.syI != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.syI);
      }
      paramInt = i;
      if (this.tOS != null) {
        paramInt = i + d.a.a.a.gA(4, this.tOS.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.tOT);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        byu localbyu = (byu)paramVarArgs[1];
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
            localbyu.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbyu.sPn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbyu.syI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbyu.tOS = ((apo)localObject1);
            paramInt += 1;
          }
        }
        localbyu.tOT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byu
 * JD-Core Version:    0.7.0.1
 */