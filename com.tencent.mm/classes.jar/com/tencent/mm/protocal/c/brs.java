package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class brs
  extends blm
{
  public int hPS;
  public int pyo;
  public LinkedList<Integer> sAq = new LinkedList();
  public String tIm;
  
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
      if (this.tIm != null) {
        paramVarArgs.d(2, this.tIm);
      }
      paramVarArgs.gB(3, this.pyo);
      paramVarArgs.gB(4, this.hPS);
      paramVarArgs.d(5, this.sAq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tIm != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tIm);
      }
      return i + d.a.a.a.gy(3, this.pyo) + d.a.a.a.gy(4, this.hPS) + d.a.a.a.c(5, this.sAq);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sAq.clear();
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
        brs localbrs = (brs)paramVarArgs[1];
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
            localbrs.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbrs.tIm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbrs.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbrs.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbrs.sAq = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brs
 * JD-Core Version:    0.7.0.1
 */