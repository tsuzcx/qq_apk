package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class afl
  extends blm
{
  public String extra;
  public int ssJ;
  public b tdp;
  
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
      paramVarArgs.gB(2, this.ssJ);
      if (this.extra != null) {
        paramVarArgs.d(3, this.extra);
      }
      if (this.tdp != null) {
        paramVarArgs.b(4, this.tdp);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label419;
      }
    }
    label419:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssJ);
      paramInt = i;
      if (this.extra != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.extra);
      }
      i = paramInt;
      if (this.tdp != null) {
        i = paramInt + d.a.a.a.a(4, this.tdp);
      }
      return i;
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
        afl localafl = (afl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localafl.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafl.ssJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localafl.extra = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localafl.tdp = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afl
 * JD-Core Version:    0.7.0.1
 */