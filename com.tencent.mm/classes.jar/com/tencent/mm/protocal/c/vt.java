package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class vt
  extends blm
{
  public String sCE;
  public b sQA;
  public b sSY;
  public int swS;
  
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
      if (this.sCE != null) {
        paramVarArgs.d(2, this.sCE);
      }
      paramVarArgs.gB(3, this.swS);
      if (this.sSY != null) {
        paramVarArgs.b(4, this.sSY);
      }
      if (this.sQA != null) {
        paramVarArgs.b(5, this.sQA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label471;
      }
    }
    label471:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sCE != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sCE);
      }
      i += d.a.a.a.gy(3, this.swS);
      paramInt = i;
      if (this.sSY != null) {
        paramInt = i + d.a.a.a.a(4, this.sSY);
      }
      i = paramInt;
      if (this.sQA != null) {
        i = paramInt + d.a.a.a.a(5, this.sQA);
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
        vt localvt = (vt)paramVarArgs[1];
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
            localvt.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localvt.sCE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localvt.swS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localvt.sSY = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localvt.sQA = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vt
 * JD-Core Version:    0.7.0.1
 */