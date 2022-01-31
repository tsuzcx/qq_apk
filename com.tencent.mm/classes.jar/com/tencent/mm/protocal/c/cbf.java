package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cbf
  extends blm
{
  public String euK;
  public int hQP;
  public int kTR;
  public boolean tQo;
  
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
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      paramVarArgs.gB(3, this.hQP);
      paramVarArgs.aA(4, this.tQo);
      paramVarArgs.gB(5, this.kTR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.euK);
      }
      return i + d.a.a.a.gy(3, this.hQP) + (d.a.a.b.b.a.dQ(4) + 1) + d.a.a.a.gy(5, this.kTR);
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
        cbf localcbf = (cbf)paramVarArgs[1];
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
            localcbf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcbf.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcbf.hQP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcbf.tQo = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localcbf.kTR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbf
 * JD-Core Version:    0.7.0.1
 */