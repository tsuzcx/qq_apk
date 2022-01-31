package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class cmi
  extends blm
{
  public b sCF;
  public String tMY;
  public String tZo;
  
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
      if (this.tMY != null) {
        paramVarArgs.d(2, this.tMY);
      }
      if (this.sCF != null) {
        paramVarArgs.b(3, this.sCF);
      }
      if (this.tZo != null) {
        paramVarArgs.d(4, this.tZo);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label435;
      }
    }
    label435:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tMY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tMY);
      }
      i = paramInt;
      if (this.sCF != null) {
        i = paramInt + d.a.a.a.a(3, this.sCF);
      }
      paramInt = i;
      if (this.tZo != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tZo);
      }
      return paramInt;
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
        cmi localcmi = (cmi)paramVarArgs[1];
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
            localcmi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcmi.tMY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcmi.sCF = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localcmi.tZo = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmi
 * JD-Core Version:    0.7.0.1
 */